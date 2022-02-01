package com.tencent.mm.plugin.fav.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ab;
import java.util.LinkedList;

public final class ak
  extends n
  implements k
{
  com.tencent.mm.al.g callback;
  private int hkT;
  private a qaW;
  long qaX;
  public boolean qaY;
  final com.tencent.mm.al.b rr;
  
  public ak()
  {
    AppMethodBeat.i(103476);
    this.callback = null;
    this.hkT = 1;
    this.qaW = new a();
    this.qaX = -1L;
    this.qaY = false;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
    b.a locala = new b.a();
    locala.gUU = new agv();
    locala.gUV = new agw();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.reqCmdId = 195;
    locala.respCmdId = 1000000195;
    locala.gUW = false;
    this.rr = locala.atI();
    AppMethodBeat.o(103476);
  }
  
  public ak(int paramInt)
  {
    AppMethodBeat.i(103477);
    this.callback = null;
    this.hkT = 1;
    this.qaW = new a();
    this.qaX = -1L;
    this.qaY = false;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", new Object[] { Integer.valueOf(paramInt) });
    b.a locala = new b.a();
    locala.gUU = new agv();
    locala.gUV = new agw();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.reqCmdId = 195;
    locala.respCmdId = 1000000195;
    locala.gUW = false;
    this.rr = locala.atI();
    this.hkT = paramInt;
    AppMethodBeat.o(103477);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(103478);
    this.callback = paramg;
    agv localagv = (agv)this.rr.gUS.gUX;
    localagv.CRw = this.hkT;
    paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().chW();
    if (this.hkT == 2) {
      paramg = new byte[0];
    }
    localagv.CRx = z.am(paramg);
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103478);
    return i;
  }
  
  public final int getType()
  {
    return 400;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103479);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().aDC())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Fav.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
    }
    agw localagw = (agw)((com.tencent.mm.al.b)paramq).gUT.gUX;
    paramArrayOfByte = localagw.CRA.mAL;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + paramArrayOfByte.size());
      if (this.hkT != 2)
      {
        paramString = this.qaW;
        paramString.pJl = paramArrayOfByte;
        if ((paramString.pJl != null) && (paramString.pJl.size() > 0))
        {
          paramq = new al();
          com.tencent.mm.kernel.g.aeS().a(paramq, 0);
        }
        paramString.qaZ.sendEmptyMessage(0);
        AppMethodBeat.o(103479);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
    }
    if (localagw.CRx.getBuffer() != null)
    {
      paramArrayOfByte = localagw.CRx.getBuffer().toByteArray();
      paramq = com.tencent.mm.protocal.ad.k(((agv)((com.tencent.mm.al.b)paramq).gUS.gUX).CRx.getBuffer().toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0)) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().bm(paramq);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afB().afk().set(8217, Integer.valueOf(1));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Fav.NetSceneFavSync", "merge key should not be null");
    }
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    LinkedList<xd> pJl;
    ap qaZ;
    
    a()
    {
      AppMethodBeat.i(103475);
      this.qaZ = new ap("MicroMsg.Fav.NetSceneFavSync")
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(103474);
          if ((ak.a.this.pJl == null) || (ak.a.this.pJl.isEmpty()))
          {
            paramAnonymousMessage = ak.this;
            localObject1 = (agv)paramAnonymousMessage.rr.gUS.gUX;
            localObject2 = (agw)paramAnonymousMessage.rr.gUT.gUX;
            byte[] arrayOfByte = ((agw)localObject2).CRx.getBuffer().toByteArray();
            arrayOfByte = com.tencent.mm.protocal.ad.k(((agv)localObject1).CRx.getBuffer().toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
              ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().bm(arrayOfByte);
            }
            ((agv)localObject1).CRx = z.am(arrayOfByte);
            i = ((agw)localObject2).CNq;
            if ((((agv)localObject1).CRw & i) == 0)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", new Object[] { Long.valueOf(paramAnonymousMessage.qaX) });
              com.tencent.mm.kernel.g.afB().afk().set(8217, Integer.valueOf(1));
              if (paramAnonymousMessage.qaX > 0L)
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().B(paramAnonymousMessage.qaX, -1);
                if (((LinkedList)localObject1).size() > 0)
                {
                  paramAnonymousMessage.qaY = true;
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
                  localObject1 = new ai((LinkedList)localObject1);
                  if (!com.tencent.mm.kernel.g.aeS().a((n)localObject1, 0))
                  {
                    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
                    ai.cil();
                  }
                }
              }
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(103474);
              return;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", new Object[] { Integer.valueOf(((agw)localObject2).CNq) });
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(103474);
            return;
          }
          paramAnonymousMessage = (xd)ak.a.this.pJl.getFirst();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + paramAnonymousMessage.CYY);
          ak.a.this.pJl.removeFirst();
          switch (paramAnonymousMessage.CYY)
          {
          default: 
            AppMethodBeat.o(103474);
            return;
          }
          localObject1 = z.a(paramAnonymousMessage.CYZ);
          if (localObject1 == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
            sendEmptyMessage(0);
            AppMethodBeat.o(103474);
            return;
          }
          paramAnonymousMessage = ak.this;
          if (localObject1 != null) {}
          for (;;)
          {
            try
            {
              i = localObject1.length;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "processAddItem bufSize=%d", new Object[] { Integer.valueOf(i) });
              localObject2 = (cm)new cm().parseFrom((byte[])localObject1);
              if (localObject2 != null) {
                continue;
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
            }
            catch (Exception paramAnonymousMessage)
            {
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", paramAnonymousMessage, "", new Object[0]);
              continue;
              if ((paramAnonymousMessage.qaX >= 0L) && (((cm)localObject2).Cxn >= paramAnonymousMessage.qaX)) {
                continue;
              }
              paramAnonymousMessage.qaX = ((cm)localObject2).Cxn;
              localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pT(((cm)localObject2).Cxl);
              i = 0;
              paramAnonymousMessage = (Message)localObject1;
              if (localObject1 != null) {
                continue;
              }
              paramAnonymousMessage = new g();
              paramAnonymousMessage.field_updateTime = (((cm)localObject2).Cxn * 1000L);
              i = 1;
              paramAnonymousMessage.field_id = ((cm)localObject2).Cxl;
              paramAnonymousMessage.field_updateSeq = ((cm)localObject2).Cxo;
              if (paramAnonymousMessage.field_localSeq != ((cm)localObject2).Cxo) {
                continue;
              }
              paramAnonymousMessage.field_updateTime = (((cm)localObject2).Cxn * 1000L);
              paramAnonymousMessage.field_flag = ((cm)localObject2).Cxm;
              paramAnonymousMessage.field_type = ((cm)localObject2).mBH;
              if (i == 0) {
                continue;
              }
              paramAnonymousMessage.field_localId = System.currentTimeMillis();
              ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().z(paramAnonymousMessage);
              continue;
              ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramAnonymousMessage, new String[] { "localId" });
              continue;
            }
            sendEmptyMessage(0);
            break;
            i = 0;
            continue;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", new Object[] { Integer.valueOf(((cm)localObject2).Cxl), Integer.valueOf(((cm)localObject2).Cxm), Integer.valueOf(((cm)localObject2).Cxo), Integer.valueOf(((cm)localObject2).Cxn) });
            if ((((cm)localObject2).Cxm & 0x1) == 0) {
              continue;
            }
            b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pT(((cm)localObject2).Cxl), false, null);
          }
        }
      };
      AppMethodBeat.o(103475);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ak
 * JD-Core Version:    0.7.0.1
 */
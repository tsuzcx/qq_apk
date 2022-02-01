package com.tencent.mm.plugin.fav.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ae;
import java.util.LinkedList;

public final class ak
  extends n
  implements k
{
  com.tencent.mm.ak.g callback;
  private int hLw;
  private a qJC;
  long qJD;
  public boolean qJE;
  final com.tencent.mm.ak.b rr;
  
  public ak()
  {
    AppMethodBeat.i(103476);
    this.callback = null;
    this.hLw = 1;
    this.qJC = new a();
    this.qJD = -1L;
    this.qJE = false;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
    b.a locala = new b.a();
    locala.hvt = new ahu();
    locala.hvu = new ahv();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.reqCmdId = 195;
    locala.respCmdId = 1000000195;
    locala.hvv = false;
    this.rr = locala.aAz();
    AppMethodBeat.o(103476);
  }
  
  public ak(int paramInt)
  {
    AppMethodBeat.i(103477);
    this.callback = null;
    this.hLw = 1;
    this.qJC = new a();
    this.qJD = -1L;
    this.qJE = false;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", new Object[] { Integer.valueOf(paramInt) });
    b.a locala = new b.a();
    locala.hvt = new ahu();
    locala.hvu = new ahv();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.reqCmdId = 195;
    locala.respCmdId = 1000000195;
    locala.hvv = false;
    this.rr = locala.aAz();
    this.hLw = paramInt;
    AppMethodBeat.o(103477);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(103478);
    this.callback = paramg;
    ahu localahu = (ahu)this.rr.hvr.hvw;
    localahu.Ekh = this.hLw;
    paramg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().cpD();
    if (this.hLw == 2) {
      paramg = new byte[0];
    }
    localahu.Eki = z.al(paramg);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.NetSceneFavSync", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().aKt())
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
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
    ahv localahv = (ahv)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    paramArrayOfByte = localahv.Ekl.ncM;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + paramArrayOfByte.size());
      if (this.hLw != 2)
      {
        paramString = this.qJC;
        paramString.qrS = paramArrayOfByte;
        if ((paramString.qrS != null) && (paramString.qrS.size() > 0))
        {
          paramq = new al();
          com.tencent.mm.kernel.g.agi().a(paramq, 0);
        }
        paramString.qJF.sendEmptyMessage(0);
        AppMethodBeat.o(103479);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
    }
    if (localahv.Eki.getBuffer() != null)
    {
      paramArrayOfByte = localahv.Eki.getBuffer().toByteArray();
      paramq = ad.k(((ahu)((com.tencent.mm.ak.b)paramq).hvr.hvw).Eki.getBuffer().toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0)) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().bl(paramq);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agR().agA().set(8217, Integer.valueOf(1));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.NetSceneFavSync", "merge key should not be null");
    }
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    ao qJF;
    LinkedList<xv> qrS;
    
    a()
    {
      AppMethodBeat.i(103475);
      this.qJF = new ao("MicroMsg.Fav.NetSceneFavSync")
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(103474);
          if ((ak.a.this.qrS == null) || (ak.a.this.qrS.isEmpty()))
          {
            paramAnonymousMessage = ak.this;
            localObject1 = (ahu)paramAnonymousMessage.rr.hvr.hvw;
            localObject2 = (ahv)paramAnonymousMessage.rr.hvs.hvw;
            byte[] arrayOfByte = ((ahv)localObject2).Eki.getBuffer().toByteArray();
            arrayOfByte = ad.k(((ahu)localObject1).Eki.getBuffer().toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
              ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().bl(arrayOfByte);
            }
            ((ahu)localObject1).Eki = z.al(arrayOfByte);
            i = ((ahv)localObject2).EfS;
            if ((((ahu)localObject1).Ekh & i) == 0)
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", new Object[] { Long.valueOf(paramAnonymousMessage.qJD) });
              com.tencent.mm.kernel.g.agR().agA().set(8217, Integer.valueOf(1));
              if (paramAnonymousMessage.qJD > 0L)
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().C(paramAnonymousMessage.qJD, -1);
                if (((LinkedList)localObject1).size() > 0)
                {
                  paramAnonymousMessage.qJE = true;
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
                  localObject1 = new ai((LinkedList)localObject1);
                  if (!com.tencent.mm.kernel.g.agi().a((n)localObject1, 0))
                  {
                    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
                    ai.cpS();
                  }
                }
              }
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(103474);
              return;
            }
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", new Object[] { Integer.valueOf(((ahv)localObject2).EfS) });
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(103474);
            return;
          }
          paramAnonymousMessage = (xv)ak.a.this.qrS.getFirst();
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + paramAnonymousMessage.ErL);
          ak.a.this.qrS.removeFirst();
          switch (paramAnonymousMessage.ErL)
          {
          default: 
            AppMethodBeat.o(103474);
            return;
          }
          localObject1 = z.a(paramAnonymousMessage.ErM);
          if (localObject1 == null)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
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
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.NetSceneFavSync", "processAddItem bufSize=%d", new Object[] { Integer.valueOf(i) });
              localObject2 = (co)new co().parseFrom((byte[])localObject1);
              if (localObject2 != null) {
                continue;
              }
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
            }
            catch (Exception paramAnonymousMessage)
            {
              com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", paramAnonymousMessage, "", new Object[0]);
              continue;
              if ((paramAnonymousMessage.qJD >= 0L) && (((co)localObject2).DPJ >= paramAnonymousMessage.qJD)) {
                continue;
              }
              paramAnonymousMessage.qJD = ((co)localObject2).DPJ;
              localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(((co)localObject2).DPH);
              i = 0;
              paramAnonymousMessage = (Message)localObject1;
              if (localObject1 != null) {
                continue;
              }
              paramAnonymousMessage = new g();
              paramAnonymousMessage.field_updateTime = (((co)localObject2).DPJ * 1000L);
              i = 1;
              paramAnonymousMessage.field_id = ((co)localObject2).DPH;
              paramAnonymousMessage.field_updateSeq = ((co)localObject2).DPK;
              if (paramAnonymousMessage.field_localSeq != ((co)localObject2).DPK) {
                continue;
              }
              paramAnonymousMessage.field_updateTime = (((co)localObject2).DPJ * 1000L);
              paramAnonymousMessage.field_flag = ((co)localObject2).DPI;
              paramAnonymousMessage.field_type = ((co)localObject2).ndI;
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
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", new Object[] { Integer.valueOf(((co)localObject2).DPH), Integer.valueOf(((co)localObject2).DPI), Integer.valueOf(((co)localObject2).DPK), Integer.valueOf(((co)localObject2).DPJ) });
            if ((((co)localObject2).DPI & 0x1) == 0) {
              continue;
            }
            b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(((co)localObject2).DPH), false, null);
          }
        }
      };
      AppMethodBeat.o(103475);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ak
 * JD-Core Version:    0.7.0.1
 */
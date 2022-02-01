package com.tencent.mm.plugin.fav.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;

public final class ak
  extends n
  implements k
{
  f callback;
  private int duf;
  final com.tencent.mm.al.b rr;
  private a rtE;
  long rtF;
  public boolean rtG;
  
  public ak()
  {
    AppMethodBeat.i(103476);
    this.callback = null;
    this.duf = 1;
    this.rtE = new a();
    this.rtF = -1L;
    this.rtG = false;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
    b.a locala = new b.a();
    locala.hNM = new akk();
    locala.hNN = new akl();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.hNO = 195;
    locala.respCmdId = 1000000195;
    locala.hNP = false;
    this.rr = locala.aDC();
    AppMethodBeat.o(103476);
  }
  
  public ak(int paramInt)
  {
    AppMethodBeat.i(103477);
    this.callback = null;
    this.duf = 1;
    this.rtE = new a();
    this.rtF = -1L;
    this.rtG = false;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", new Object[] { Integer.valueOf(paramInt) });
    b.a locala = new b.a();
    locala.hNM = new akk();
    locala.hNN = new akl();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.hNO = 195;
    locala.respCmdId = 1000000195;
    locala.hNP = false;
    this.rr = locala.aDC();
    this.duf = paramInt;
    AppMethodBeat.o(103477);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(103478);
    this.callback = paramf;
    akk localakk = (akk)this.rr.hNK.hNQ;
    localakk.FRq = this.duf;
    paramf = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().cvi();
    if (this.duf == 2) {
      paramf = new byte[0];
    }
    localakk.FRr = z.al(paramf);
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
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().aNC())
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
    akl localakl = (akl)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    paramArrayOfByte = localakl.FRu.nDj;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + paramArrayOfByte.size());
      if (this.duf != 2)
      {
        paramString = this.rtE;
        paramString.rbl = paramArrayOfByte;
        if ((paramString.rbl != null) && (paramString.rbl.size() > 0))
        {
          paramq = new al();
          com.tencent.mm.kernel.g.aiU().a(paramq, 0);
        }
        paramString.rtH.sendEmptyMessage(0);
        AppMethodBeat.o(103479);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
    }
    if (localakl.FRr.getBuffer() != null)
    {
      paramArrayOfByte = localakl.FRr.getBuffer().toByteArray();
      paramq = com.tencent.mm.protocal.ad.k(((akk)((com.tencent.mm.al.b)paramq).hNK.hNQ).FRr.getBuffer().toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0)) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().bo(paramq);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(8217, Integer.valueOf(1));
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
    return n.b.hOp;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    LinkedList<zu> rbl;
    ap rtH;
    
    a()
    {
      AppMethodBeat.i(103475);
      this.rtH = new ap("MicroMsg.Fav.NetSceneFavSync")
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(103474);
          if ((ak.a.this.rbl == null) || (ak.a.this.rbl.isEmpty()))
          {
            paramAnonymousMessage = ak.this;
            localObject1 = (akk)paramAnonymousMessage.rr.hNK.hNQ;
            localObject2 = (akl)paramAnonymousMessage.rr.hNL.hNQ;
            byte[] arrayOfByte = ((akl)localObject2).FRr.getBuffer().toByteArray();
            arrayOfByte = com.tencent.mm.protocal.ad.k(((akk)localObject1).FRr.getBuffer().toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
              ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().bo(arrayOfByte);
            }
            ((akk)localObject1).FRr = z.al(arrayOfByte);
            i = ((akl)localObject2).FMr;
            if ((((akk)localObject1).FRq & i) == 0)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", new Object[] { Long.valueOf(paramAnonymousMessage.rtF) });
              com.tencent.mm.kernel.g.ajC().ajl().set(8217, Integer.valueOf(1));
              if (paramAnonymousMessage.rtF > 0L)
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().D(paramAnonymousMessage.rtF, -1);
                if (((LinkedList)localObject1).size() > 0)
                {
                  paramAnonymousMessage.rtG = true;
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
                  localObject1 = new ai((LinkedList)localObject1);
                  if (!com.tencent.mm.kernel.g.aiU().a((n)localObject1, 0))
                  {
                    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
                    ai.cvx();
                  }
                }
              }
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(103474);
              return;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", new Object[] { Integer.valueOf(((akl)localObject2).FMr) });
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(103474);
            return;
          }
          paramAnonymousMessage = (zu)ak.a.this.rbl.getFirst();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + paramAnonymousMessage.FYU);
          ak.a.this.rbl.removeFirst();
          switch (paramAnonymousMessage.FYU)
          {
          default: 
            AppMethodBeat.o(103474);
            return;
          }
          localObject1 = z.a(paramAnonymousMessage.FYV);
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
              localObject2 = (cp)new cp().parseFrom((byte[])localObject1);
              if (localObject2 != null) {
                continue;
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
            }
            catch (Exception paramAnonymousMessage)
            {
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", paramAnonymousMessage, "", new Object[0]);
              continue;
              if ((paramAnonymousMessage.rtF >= 0L) && (((cp)localObject2).FuY >= paramAnonymousMessage.rtF)) {
                continue;
              }
              paramAnonymousMessage.rtF = ((cp)localObject2).FuY;
              localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vF(((cp)localObject2).FuW);
              i = 0;
              paramAnonymousMessage = (Message)localObject1;
              if (localObject1 != null) {
                continue;
              }
              paramAnonymousMessage = new g();
              paramAnonymousMessage.field_updateTime = (((cp)localObject2).FuY * 1000L);
              i = 1;
              paramAnonymousMessage.field_id = ((cp)localObject2).FuW;
              paramAnonymousMessage.field_updateSeq = ((cp)localObject2).FuZ;
              if (paramAnonymousMessage.field_localSeq != ((cp)localObject2).FuZ) {
                continue;
              }
              paramAnonymousMessage.field_updateTime = (((cp)localObject2).FuY * 1000L);
              paramAnonymousMessage.field_flag = ((cp)localObject2).FuX;
              paramAnonymousMessage.field_type = ((cp)localObject2).nEf;
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
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", new Object[] { Integer.valueOf(((cp)localObject2).FuW), Integer.valueOf(((cp)localObject2).FuX), Integer.valueOf(((cp)localObject2).FuZ), Integer.valueOf(((cp)localObject2).FuY) });
            if ((((cp)localObject2).FuX & 0x1) == 0) {
              continue;
            }
            b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vF(((cp)localObject2).FuW), false, null);
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
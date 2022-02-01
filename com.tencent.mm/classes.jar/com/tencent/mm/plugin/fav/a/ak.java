package com.tencent.mm.plugin.fav.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.aj;
import java.util.LinkedList;

public final class ak
  extends n
  implements k
{
  f callback;
  private int dvk;
  private a rBQ;
  long rBR;
  public boolean rBS;
  final com.tencent.mm.ak.b rr;
  
  public ak()
  {
    AppMethodBeat.i(103476);
    this.callback = null;
    this.dvk = 1;
    this.rBQ = new a();
    this.rBR = -1L;
    this.rBS = false;
    ae.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
    b.a locala = new b.a();
    locala.hQF = new aku();
    locala.hQG = new akv();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.hQH = 195;
    locala.respCmdId = 1000000195;
    locala.hQI = false;
    this.rr = locala.aDS();
    AppMethodBeat.o(103476);
  }
  
  public ak(int paramInt)
  {
    AppMethodBeat.i(103477);
    this.callback = null;
    this.dvk = 1;
    this.rBQ = new a();
    this.rBR = -1L;
    this.rBS = false;
    ae.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", new Object[] { Integer.valueOf(paramInt) });
    b.a locala = new b.a();
    locala.hQF = new aku();
    locala.hQG = new akv();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.hQH = 195;
    locala.respCmdId = 1000000195;
    locala.hQI = false;
    this.rr = locala.aDS();
    this.dvk = paramInt;
    AppMethodBeat.o(103477);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(103478);
    this.callback = paramf;
    aku localaku = (aku)this.rr.hQD.hQJ;
    localaku.GjP = this.dvk;
    paramf = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().cwJ();
    if (this.dvk == 2) {
      paramf = new byte[0];
    }
    localaku.GjQ = z.al(paramf);
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
    ae.i("MicroMsg.Fav.NetSceneFavSync", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().aOa())
    {
      ae.w("MicroMsg.Fav.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
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
    akv localakv = (akv)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    paramArrayOfByte = localakv.GjT.nIE;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      ae.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + paramArrayOfByte.size());
      if (this.dvk != 2)
      {
        paramString = this.rBQ;
        paramString.rjr = paramArrayOfByte;
        if ((paramString.rjr != null) && (paramString.rjr.size() > 0))
        {
          paramq = new al();
          com.tencent.mm.kernel.g.ajj().a(paramq, 0);
        }
        paramString.rBT.sendEmptyMessage(0);
        AppMethodBeat.o(103479);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
    }
    if (localakv.GjQ.getBuffer() != null)
    {
      paramArrayOfByte = localakv.GjQ.getBuffer().toByteArray();
      paramq = ad.l(((aku)((com.tencent.mm.ak.b)paramq).hQD.hQJ).GjQ.getBuffer().toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0)) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().bn(paramq);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(8217, Integer.valueOf(1));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
      ae.e("MicroMsg.Fav.NetSceneFavSync", "merge key should not be null");
    }
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    aq rBT;
    LinkedList<zx> rjr;
    
    a()
    {
      AppMethodBeat.i(103475);
      this.rBT = new aq("MicroMsg.Fav.NetSceneFavSync")
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(103474);
          if ((ak.a.this.rjr == null) || (ak.a.this.rjr.isEmpty()))
          {
            paramAnonymousMessage = ak.this;
            localObject1 = (aku)paramAnonymousMessage.rr.hQD.hQJ;
            localObject2 = (akv)paramAnonymousMessage.rr.hQE.hQJ;
            byte[] arrayOfByte = ((akv)localObject2).GjQ.getBuffer().toByteArray();
            arrayOfByte = ad.l(((aku)localObject1).GjQ.getBuffer().toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
              ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavConfigStorage().bn(arrayOfByte);
            }
            ((aku)localObject1).GjQ = z.al(arrayOfByte);
            i = ((akv)localObject2).GeQ;
            if ((((aku)localObject1).GjP & i) == 0)
            {
              ae.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", new Object[] { Long.valueOf(paramAnonymousMessage.rBR) });
              com.tencent.mm.kernel.g.ajR().ajA().set(8217, Integer.valueOf(1));
              if (paramAnonymousMessage.rBR > 0L)
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().D(paramAnonymousMessage.rBR, -1);
                if (((LinkedList)localObject1).size() > 0)
                {
                  paramAnonymousMessage.rBS = true;
                  ae.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
                  localObject1 = new ai((LinkedList)localObject1);
                  if (!com.tencent.mm.kernel.g.ajj().a((n)localObject1, 0))
                  {
                    ae.w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
                    ai.cwY();
                  }
                }
              }
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(103474);
              return;
            }
            ae.i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", new Object[] { Integer.valueOf(((akv)localObject2).GeQ) });
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(103474);
            return;
          }
          paramAnonymousMessage = (zx)ak.a.this.rjr.getFirst();
          ae.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + paramAnonymousMessage.Gru);
          ak.a.this.rjr.removeFirst();
          switch (paramAnonymousMessage.Gru)
          {
          default: 
            AppMethodBeat.o(103474);
            return;
          }
          localObject1 = z.a(paramAnonymousMessage.Grv);
          if (localObject1 == null)
          {
            ae.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
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
              ae.i("MicroMsg.Fav.NetSceneFavSync", "processAddItem bufSize=%d", new Object[] { Integer.valueOf(i) });
              localObject2 = (cp)new cp().parseFrom((byte[])localObject1);
              if (localObject2 != null) {
                continue;
              }
              ae.e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
            }
            catch (Exception paramAnonymousMessage)
            {
              ae.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", paramAnonymousMessage, "", new Object[0]);
              continue;
              if ((paramAnonymousMessage.rBR >= 0L) && (((cp)localObject2).FNw >= paramAnonymousMessage.rBR)) {
                continue;
              }
              paramAnonymousMessage.rBR = ((cp)localObject2).FNw;
              localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vV(((cp)localObject2).FNu);
              i = 0;
              paramAnonymousMessage = (Message)localObject1;
              if (localObject1 != null) {
                continue;
              }
              paramAnonymousMessage = new g();
              paramAnonymousMessage.field_updateTime = (((cp)localObject2).FNw * 1000L);
              i = 1;
              paramAnonymousMessage.field_id = ((cp)localObject2).FNu;
              paramAnonymousMessage.field_updateSeq = ((cp)localObject2).FNx;
              if (paramAnonymousMessage.field_localSeq != ((cp)localObject2).FNx) {
                continue;
              }
              paramAnonymousMessage.field_updateTime = (((cp)localObject2).FNw * 1000L);
              paramAnonymousMessage.field_flag = ((cp)localObject2).FNv;
              paramAnonymousMessage.field_type = ((cp)localObject2).nJA;
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
            ae.i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", new Object[] { Integer.valueOf(((cp)localObject2).FNu), Integer.valueOf(((cp)localObject2).FNv), Integer.valueOf(((cp)localObject2).FNx), Integer.valueOf(((cp)localObject2).FNw) });
            if ((((cp)localObject2).FNv & 0x1) == 0) {
              continue;
            }
            b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vV(((cp)localObject2).FNu), false, null);
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
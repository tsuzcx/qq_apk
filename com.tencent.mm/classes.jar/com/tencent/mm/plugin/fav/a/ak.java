package com.tencent.mm.plugin.fav.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import java.util.LinkedList;

public final class ak
  extends q
  implements m
{
  i callback;
  private int dML;
  final d rr;
  private a tbv;
  long tbw;
  public boolean tbx;
  
  public ak()
  {
    AppMethodBeat.i(103476);
    this.callback = null;
    this.dML = 1;
    this.tbv = new a();
    this.tbw = -1L;
    this.tbx = false;
    Log.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
    d.a locala = new d.a();
    locala.iLN = new ani();
    locala.iLO = new anj();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.iLP = 195;
    locala.respCmdId = 1000000195;
    locala.iLQ = false;
    this.rr = locala.aXF();
    AppMethodBeat.o(103476);
  }
  
  public ak(int paramInt)
  {
    AppMethodBeat.i(103477);
    this.callback = null;
    this.dML = 1;
    this.tbv = new a();
    this.tbw = -1L;
    this.tbx = false;
    Log.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", new Object[] { Integer.valueOf(paramInt) });
    d.a locala = new d.a();
    locala.iLN = new ani();
    locala.iLO = new anj();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.iLP = 195;
    locala.respCmdId = 1000000195;
    locala.iLQ = false;
    this.rr = locala.aXF();
    this.dML = paramInt;
    AppMethodBeat.o(103477);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(103478);
    this.callback = parami;
    ani localani = (ani)this.rr.iLK.iLR;
    localani.Leu = this.dML;
    parami = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavConfigStorage().cUN();
    if (this.dML == 2) {
      parami = new byte[0];
    }
    localani.Lev = z.aC(parami);
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103478);
    return i;
  }
  
  public final int getType()
  {
    return 400;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103479);
    Log.i("MicroMsg.Fav.NetSceneFavSync", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((af)com.tencent.mm.kernel.g.ah(af.class)).getSendService().big())
    {
      Log.w("MicroMsg.Fav.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
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
    anj localanj = (anj)((d)params).iLL.iLR;
    paramArrayOfByte = localanj.Ley.oTA;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      Log.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + paramArrayOfByte.size());
      if (this.dML != 2)
      {
        paramString = this.tbv;
        paramString.sKS = paramArrayOfByte;
        if ((paramString.sKS != null) && (paramString.sKS.size() > 0))
        {
          params = new al();
          com.tencent.mm.kernel.g.azz().a(params, 0);
        }
        paramString.tby.sendEmptyMessage(0);
        AppMethodBeat.o(103479);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
    }
    if (localanj.Lev.getBuffer() != null)
    {
      paramArrayOfByte = localanj.Lev.getBuffer().toByteArray();
      params = ad.l(((ani)((d)params).iLK.iLR).Lev.getBuffer().toByteArray(), paramArrayOfByte);
      if ((params != null) && (params.length > 0)) {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavConfigStorage().bE(params);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(8217, Integer.valueOf(1));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
      Log.e("MicroMsg.Fav.NetSceneFavSync", "merge key should not be null");
    }
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    LinkedList<abn> sKS;
    MMHandler tby;
    
    a()
    {
      AppMethodBeat.i(103475);
      this.tby = new MMHandler("MicroMsg.Fav.NetSceneFavSync")
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(103474);
          if ((ak.a.this.sKS == null) || (ak.a.this.sKS.isEmpty()))
          {
            paramAnonymousMessage = ak.this;
            localObject1 = (ani)paramAnonymousMessage.rr.iLK.iLR;
            localObject2 = (anj)paramAnonymousMessage.rr.iLL.iLR;
            byte[] arrayOfByte = ((anj)localObject2).Lev.getBuffer().toByteArray();
            arrayOfByte = ad.l(((ani)localObject1).Lev.getBuffer().toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
              ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavConfigStorage().bE(arrayOfByte);
            }
            ((ani)localObject1).Lev = z.aC(arrayOfByte);
            i = ((anj)localObject2).KZh;
            if ((((ani)localObject1).Leu & i) == 0)
            {
              Log.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", new Object[] { Long.valueOf(paramAnonymousMessage.tbw) });
              com.tencent.mm.kernel.g.aAh().azQ().set(8217, Integer.valueOf(1));
              if (paramAnonymousMessage.tbw > 0L)
              {
                localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().B(paramAnonymousMessage.tbw, -1);
                if (((LinkedList)localObject1).size() > 0)
                {
                  paramAnonymousMessage.tbx = true;
                  Log.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
                  localObject1 = new ai((LinkedList)localObject1);
                  if (!com.tencent.mm.kernel.g.azz().a((q)localObject1, 0))
                  {
                    Log.w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
                    ai.cVc();
                  }
                }
              }
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(103474);
              return;
            }
            Log.i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", new Object[] { Integer.valueOf(((anj)localObject2).KZh) });
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(103474);
            return;
          }
          paramAnonymousMessage = (abn)ak.a.this.sKS.getFirst();
          Log.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + paramAnonymousMessage.Lms);
          ak.a.this.sKS.removeFirst();
          switch (paramAnonymousMessage.Lms)
          {
          default: 
            AppMethodBeat.o(103474);
            return;
          }
          localObject1 = z.a(paramAnonymousMessage.Lmt);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
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
              Log.i("MicroMsg.Fav.NetSceneFavSync", "processAddItem bufSize=%d", new Object[] { Integer.valueOf(i) });
              localObject2 = (cy)new cy().parseFrom((byte[])localObject1);
              if (localObject2 != null) {
                continue;
              }
              Log.e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
            }
            catch (Exception paramAnonymousMessage)
            {
              Log.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", paramAnonymousMessage, "", new Object[0]);
              continue;
              if ((paramAnonymousMessage.tbw >= 0L) && (((cy)localObject2).KHb >= paramAnonymousMessage.tbw)) {
                continue;
              }
              paramAnonymousMessage.tbw = ((cy)localObject2).KHb;
              localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ(((cy)localObject2).KGZ);
              i = 0;
              paramAnonymousMessage = (Message)localObject1;
              if (localObject1 != null) {
                continue;
              }
              paramAnonymousMessage = new g();
              paramAnonymousMessage.field_updateTime = (((cy)localObject2).KHb * 1000L);
              i = 1;
              paramAnonymousMessage.field_id = ((cy)localObject2).KGZ;
              paramAnonymousMessage.field_updateSeq = ((cy)localObject2).KHc;
              if (paramAnonymousMessage.field_localSeq != ((cy)localObject2).KHc) {
                continue;
              }
              paramAnonymousMessage.field_updateTime = (((cy)localObject2).KHb * 1000L);
              paramAnonymousMessage.field_flag = ((cy)localObject2).KHa;
              paramAnonymousMessage.field_type = ((cy)localObject2).oUv;
              if (i == 0) {
                continue;
              }
              paramAnonymousMessage.field_localId = System.currentTimeMillis();
              ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().z(paramAnonymousMessage);
              continue;
              ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(paramAnonymousMessage, new String[] { "localId" });
              continue;
            }
            sendEmptyMessage(0);
            break;
            i = 0;
            continue;
            Log.i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", new Object[] { Integer.valueOf(((cy)localObject2).KGZ), Integer.valueOf(((cy)localObject2).KHa), Integer.valueOf(((cy)localObject2).KHc), Integer.valueOf(((cy)localObject2).KHb) });
            if ((((cy)localObject2).KHa & 0x1) == 0) {
              continue;
            }
            b.a(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ(((cy)localObject2).KGZ), false, null);
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
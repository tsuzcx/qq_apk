package com.tencent.mm.plugin.fav.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import java.util.LinkedList;

public final class al
  extends q
  implements m
{
  private i callback;
  private int fFT;
  private final d rr;
  private a wHA;
  private long wHB;
  public boolean wHC;
  
  public al()
  {
    AppMethodBeat.i(103476);
    this.callback = null;
    this.fFT = 1;
    this.wHA = new a();
    this.wHB = -1L;
    this.wHC = false;
    Log.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
    d.a locala = new d.a();
    locala.lBU = new aoj();
    locala.lBV = new aok();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.lBW = 195;
    locala.respCmdId = 1000000195;
    locala.lBX = false;
    this.rr = locala.bgN();
    AppMethodBeat.o(103476);
  }
  
  public al(int paramInt)
  {
    AppMethodBeat.i(103477);
    this.callback = null;
    this.fFT = 1;
    this.wHA = new a();
    this.wHB = -1L;
    this.wHC = false;
    Log.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", new Object[] { Integer.valueOf(paramInt) });
    d.a locala = new d.a();
    locala.lBU = new aoj();
    locala.lBV = new aok();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.lBW = 195;
    locala.respCmdId = 1000000195;
    locala.lBX = false;
    this.rr = locala.bgN();
    this.fFT = paramInt;
    AppMethodBeat.o(103477);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103478);
    this.callback = parami;
    aoj localaoj = (aoj)d.b.b(this.rr.lBR);
    localaoj.SfH = this.fFT;
    parami = ((ag)h.ag(ag.class)).getFavConfigStorage().djT();
    if (this.fFT == 2) {
      parami = new byte[0];
    }
    localaoj.SfI = z.aN(parami);
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103478);
    return i;
  }
  
  public final int getType()
  {
    return 400;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103479);
    Log.i("MicroMsg.Fav.NetSceneFavSync", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((ag)h.ag(ag.class)).getSendService().brE())
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
    aok localaok = (aok)d.c.b(((d)params).lBS);
    paramArrayOfByte = localaok.SfL.rVy;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      Log.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + paramArrayOfByte.size());
      if (this.fFT != 2)
      {
        paramString = this.wHA;
        paramString.wqP = paramArrayOfByte;
        if ((paramString.wqP != null) && (paramString.wqP.size() > 0))
        {
          params = new am();
          h.aGY().a(params, 0);
        }
        paramString.wHD.sendEmptyMessage(0);
        AppMethodBeat.o(103479);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
    }
    if (localaok.SfI.Tkb != null)
    {
      paramArrayOfByte = localaok.SfI.Tkb.toByteArray();
      params = com.tencent.mm.protocal.ad.n(((aoj)d.b.b(((d)params).lBR)).SfI.Tkb.toByteArray(), paramArrayOfByte);
      if ((params != null) && (params.length > 0)) {
        ((ag)h.ag(ag.class)).getFavConfigStorage().bS(params);
      }
    }
    for (;;)
    {
      h.aHG().aHp().i(8217, Integer.valueOf(1));
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
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    MMHandler wHD;
    LinkedList<abu> wqP;
    
    a()
    {
      AppMethodBeat.i(103475);
      this.wHD = new MMHandler("MicroMsg.Fav.NetSceneFavSync")
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(103474);
          if ((al.a.this.wqP == null) || (al.a.this.wqP.isEmpty()))
          {
            al.a(al.this);
            AppMethodBeat.o(103474);
            return;
          }
          paramAnonymousMessage = (abu)al.a.this.wqP.getFirst();
          Log.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + paramAnonymousMessage.SnG);
          al.a.this.wqP.removeFirst();
          switch (paramAnonymousMessage.SnG)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(103474);
            return;
            paramAnonymousMessage = z.a(paramAnonymousMessage.SnH);
            if (paramAnonymousMessage == null)
            {
              Log.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
              sendEmptyMessage(0);
              AppMethodBeat.o(103474);
              return;
            }
            al.a(al.this, paramAnonymousMessage);
            sendEmptyMessage(0);
          }
        }
      };
      AppMethodBeat.o(103475);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.al
 * JD-Core Version:    0.7.0.1
 */
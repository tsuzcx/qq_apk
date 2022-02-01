package com.tencent.mm.plugin.fav.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import java.util.LinkedList;

public final class am
  extends p
  implements m
{
  private a AdO;
  private long AdP;
  public boolean AdQ;
  private com.tencent.mm.am.h callback;
  private final c rr;
  private int selector;
  
  public am()
  {
    AppMethodBeat.i(103476);
    this.callback = null;
    this.selector = 1;
    this.AdO = new a();
    this.AdP = -1L;
    this.AdQ = false;
    Log.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
    c.a locala = new c.a();
    locala.otE = new asc();
    locala.otF = new asd();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.otG = 195;
    locala.respCmdId = 1000000195;
    locala.otH = false;
    this.rr = locala.bEF();
    AppMethodBeat.o(103476);
  }
  
  public am(int paramInt)
  {
    AppMethodBeat.i(103477);
    this.callback = null;
    this.selector = 1;
    this.AdO = new a();
    this.AdP = -1L;
    this.AdQ = false;
    Log.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", new Object[] { Integer.valueOf(paramInt) });
    c.a locala = new c.a();
    locala.otE = new asc();
    locala.otF = new asd();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.otG = 195;
    locala.respCmdId = 1000000195;
    locala.otH = false;
    this.rr = locala.bEF();
    this.selector = paramInt;
    AppMethodBeat.o(103477);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(103478);
    this.callback = paramh;
    asc localasc = (asc)c.b.b(this.rr.otB);
    localasc.ZdC = this.selector;
    paramh = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavConfigStorage().dQD();
    if (this.selector == 2) {
      paramh = new byte[0];
    }
    localasc.ZdD = w.aN(paramh);
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
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getSendService().bPk())
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
    asd localasd = (asd)c.c.b(((c)params).otC);
    paramArrayOfByte = localasd.ZdG.vgO;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      Log.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + paramArrayOfByte.size());
      if (this.selector != 2)
      {
        paramString = this.AdO;
        paramString.zMR = paramArrayOfByte;
        if ((paramString.zMR != null) && (paramString.zMR.size() > 0))
        {
          params = new an();
          com.tencent.mm.kernel.h.aZW().a(params, 0);
        }
        paramString.AdR.sendEmptyMessage(0);
        AppMethodBeat.o(103479);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103479);
      return;
    }
    if (localasd.ZdD.aaxD != null)
    {
      paramArrayOfByte = localasd.ZdD.aaxD.toByteArray();
      params = ad.o(((asc)c.b.b(((c)params).otB)).ZdD.aaxD.toByteArray(), paramArrayOfByte);
      if ((params != null) && (params.length > 0)) {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavConfigStorage().bS(params);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baE().ban().B(8217, Integer.valueOf(1));
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
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    MMHandler AdR;
    LinkedList<adw> zMR;
    
    a()
    {
      AppMethodBeat.i(103475);
      this.AdR = new MMHandler("MicroMsg.Fav.NetSceneFavSync")
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(103474);
          if ((am.a.this.zMR == null) || (am.a.this.zMR.isEmpty()))
          {
            am.a(am.this);
            AppMethodBeat.o(103474);
            return;
          }
          paramAnonymousMessage = (adw)am.a.this.zMR.getFirst();
          Log.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + paramAnonymousMessage.Zmc);
          am.a.this.zMR.removeFirst();
          switch (paramAnonymousMessage.Zmc)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(103474);
            return;
            paramAnonymousMessage = w.a(paramAnonymousMessage.Zmd);
            if (paramAnonymousMessage == null)
            {
              Log.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
              sendEmptyMessage(0);
              AppMethodBeat.o(103474);
              return;
            }
            am.a(am.this, paramAnonymousMessage);
            sendEmptyMessage(0);
          }
        }
      };
      AppMethodBeat.o(103475);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.am
 * JD-Core Version:    0.7.0.1
 */
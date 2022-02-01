package com.tencent.mm.plugin.fingerprint.mgr;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rg;
import com.tencent.mm.autogen.a.rg.a;
import com.tencent.mm.autogen.a.rg.b;
import com.tencent.mm.plugin.fingerprint.mgr.a.b;
import com.tencent.mm.plugin.fingerprint.mgr.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends a
{
  private com.tencent.soter.a.d.a HfW = null;
  
  public final int a(final com.tencent.mm.plugin.fingerprint.c.c paramc)
  {
    AppMethodBeat.i(64353);
    Log.i("MicroMsg.SoterAuthMgrImp", "start face auth: %s", new Object[] { Integer.valueOf(3000) });
    final MTimerHandler localMTimerHandler = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(64345);
        Log.i("MicroMsg.SoterAuthMgrImp", "timeout: %s", new Object[] { Integer.valueOf(this.tnI) });
        f.a(f.this).cancel();
        paramc.iP(2000, -1);
        AppMethodBeat.o(64345);
        return false;
      }
    }, false);
    localMTimerHandler.startTimer(3000L);
    com.tencent.mm.plugin.fingerprint.mgr.a.f localf = new com.tencent.mm.plugin.fingerprint.mgr.a.f(j.Hgj.Hgd);
    this.Hfx.b(MMApplicationContext.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.mgr.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64346);
        localMTimerHandler.stopTimer();
        paramc.iP(paramAnonymousc.errCode, -1);
        AppMethodBeat.o(64346);
      }
    });
    AppMethodBeat.o(64353);
    return 0;
  }
  
  public final int a(final com.tencent.mm.plugin.fingerprint.c.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(64352);
    if (paramBoolean)
    {
      Log.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
      AppMethodBeat.o(64352);
      return 0;
    }
    com.tencent.mm.plugin.fingerprint.mgr.a.f localf = new com.tencent.mm.plugin.fingerprint.mgr.a.f(j.Hgj.Hgd);
    this.Hfx.a(MMApplicationContext.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.mgr.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64344);
        paramc.iP(paramAnonymousc.errCode, -1);
        AppMethodBeat.o(64344);
      }
    });
    AppMethodBeat.o(64352);
    return 0;
  }
  
  public final void a(rg paramrg, int paramInt)
  {
    AppMethodBeat.i(64354);
    Log.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
    paramrg.hUm.hUq = ftu();
    rg.b localb = paramrg.hUm;
    if (!Util.isNullOrNil(paramrg.hUm.hUq)) {}
    for (paramInt = 0;; paramInt = 1)
    {
      localb.errCode = paramInt;
      paramrg.hUm.hUr = 2;
      paramrg.hUm.hMz = "";
      paramrg.hUm.hMA = "";
      if (paramrg.hUl.hUp != null) {
        paramrg.hUl.hUp.run();
      }
      AppMethodBeat.o(64354);
      return;
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(64359);
    Log.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b, extInfo: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBundle });
    this.Hfx.a(paramBoolean1, paramBoolean2, j.Hgj.Hgl, paramBundle);
    AppMethodBeat.o(64359);
    return false;
  }
  
  public final Map<String, String> ftA()
  {
    AppMethodBeat.i(64356);
    Map localMap = this.Hfx.ftA();
    AppMethodBeat.o(64356);
    return localMap;
  }
  
  public final Map<String, String> ftB()
  {
    AppMethodBeat.i(64357);
    Map localMap = ftA();
    AppMethodBeat.o(64357);
    return localMap;
  }
  
  public final boolean ftC()
  {
    AppMethodBeat.i(64358);
    boolean bool = this.Hfx.ftX();
    Log.i("MicroMsg.SoterAuthMgrImp", "py: hasAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
    if ((!bool) && (this.Hfx.isSupport()) && (((this.Hfx.ftP()) && (this.Hfx.ftS())) || ((this.Hfx.ftQ()) && (this.Hfx.ftT()))))
    {
      com.tencent.mm.plugin.wxpayreport.c localc = com.tencent.mm.plugin.wxpayreport.c.XIN;
      com.tencent.mm.plugin.wxpayreport.c.oS("1", "key invalid when pay");
    }
    AppMethodBeat.o(64358);
    return bool;
  }
  
  public final boolean ftD()
  {
    AppMethodBeat.i(64362);
    boolean bool = this.Hfx.hD(MMApplicationContext.getContext());
    AppMethodBeat.o(64362);
    return bool;
  }
  
  public final boolean ftE()
  {
    AppMethodBeat.i(64363);
    boolean bool = this.Hfx.ftT();
    AppMethodBeat.o(64363);
    return bool;
  }
  
  public final boolean ftr()
  {
    AppMethodBeat.i(64360);
    boolean bool = this.Hfx.ftU();
    AppMethodBeat.o(64360);
    return bool;
  }
  
  public final boolean fts()
  {
    AppMethodBeat.i(64364);
    boolean bool = this.Hfx.fts();
    AppMethodBeat.o(64364);
    return bool;
  }
  
  public final String ftu()
  {
    AppMethodBeat.i(64355);
    Object localObject = j.Hgj.Hgn;
    if (localObject != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("json", ((com.tencent.soter.core.c.j)localObject).ahxs);
        localJSONObject.put("signature", ((com.tencent.soter.core.c.j)localObject).signature);
        localObject = localJSONObject.toString();
        AppMethodBeat.o(64355);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", new Object[] { localJSONException.toString() });
        Log.printErrStackTrace("MicroMsg.SoterAuthMgrImp", localJSONException, "", new Object[0]);
        AppMethodBeat.o(64355);
        return "";
      }
    }
    Log.e("MicroMsg.SoterAuthMgrImp", "hy: signature result is null");
    AppMethodBeat.o(64355);
    return "";
  }
  
  public final boolean ftv()
  {
    AppMethodBeat.i(64347);
    boolean bool = this.Hfx.hC(MMApplicationContext.getContext());
    AppMethodBeat.o(64347);
    return bool;
  }
  
  public final boolean ftw()
  {
    AppMethodBeat.i(64348);
    boolean bool = this.Hfx.ftS();
    AppMethodBeat.o(64348);
    return bool;
  }
  
  public final void ftx()
  {
    AppMethodBeat.i(64349);
    Log.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
    this.Hfx.prepare();
    AppMethodBeat.o(64349);
  }
  
  public final boolean fty()
  {
    return false;
  }
  
  public final boolean ftz()
  {
    AppMethodBeat.i(64351);
    boolean bool = this.Hfx.ftR();
    AppMethodBeat.o(64351);
    return bool;
  }
  
  public final void hz(Context paramContext)
  {
    AppMethodBeat.i(64350);
    Log.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
    AppMethodBeat.o(64350);
  }
  
  public final boolean isRoot()
  {
    return false;
  }
  
  public final int type()
  {
    return 2;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(64361);
    this.Hfx.cancel();
    AppMethodBeat.o(64361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.f
 * JD-Core Version:    0.7.0.1
 */
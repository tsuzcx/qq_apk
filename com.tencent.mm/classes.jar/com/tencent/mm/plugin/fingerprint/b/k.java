package com.tencent.mm.plugin.fingerprint.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pt;
import com.tencent.mm.f.a.pt.a;
import com.tencent.mm.f.a.pt.b;
import com.tencent.mm.plugin.fingerprint.b.a.b;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.soter.core.c.j;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
  extends a
{
  private com.tencent.soter.a.d.a Byu = null;
  
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc)
  {
    AppMethodBeat.i(64353);
    Log.i("MicroMsg.SoterAuthMgrImp", "start face auth: %s", new Object[] { Integer.valueOf(3000) });
    final MTimerHandler localMTimerHandler = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(64345);
        Log.i("MicroMsg.SoterAuthMgrImp", "timeout: %s", new Object[] { Integer.valueOf(this.qiV) });
        k.a(k.this).cancel();
        paramc.hu(2000, -1);
        AppMethodBeat.o(64345);
        return false;
      }
    }, false);
    localMTimerHandler.startTimer(3000L);
    f localf = new f(p.ByH.ByB);
    this.BxU.b(MMApplicationContext.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64346);
        localMTimerHandler.stopTimer();
        paramc.hu(paramAnonymousc.errCode, -1);
        AppMethodBeat.o(64346);
      }
    });
    AppMethodBeat.o(64353);
    return 0;
  }
  
  @TargetApi(16)
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(64352);
    if (paramBoolean)
    {
      Log.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
      AppMethodBeat.o(64352);
      return 0;
    }
    f localf = new f(p.ByH.ByB);
    this.BxU.a(MMApplicationContext.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64344);
        paramc.hu(paramAnonymousc.errCode, -1);
        AppMethodBeat.o(64344);
      }
    });
    AppMethodBeat.o(64352);
    return 0;
  }
  
  public final void a(pt parampt, int paramInt)
  {
    AppMethodBeat.i(64354);
    Log.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
    parampt.fOt.fOx = eor();
    pt.b localb = parampt.fOt;
    if (!Util.isNullOrNil(parampt.fOt.fOx)) {}
    for (paramInt = 0;; paramInt = 1)
    {
      localb.errCode = paramInt;
      parampt.fOt.fOy = 2;
      parampt.fOt.fHc = "";
      parampt.fOt.fHd = "";
      if (parampt.fOs.fOw != null) {
        parampt.fOs.fOw.run();
      }
      AppMethodBeat.o(64354);
      return;
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(64359);
    Log.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b, extInfo: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBundle });
    this.BxU.a(paramBoolean1, paramBoolean2, p.ByH.ByJ, paramBundle);
    AppMethodBeat.o(64359);
    return false;
  }
  
  public final boolean eoA()
  {
    AppMethodBeat.i(64362);
    boolean bool = this.BxU.gi(MMApplicationContext.getContext());
    AppMethodBeat.o(64362);
    return bool;
  }
  
  public final boolean eoB()
  {
    AppMethodBeat.i(64363);
    boolean bool = this.BxU.eoR();
    AppMethodBeat.o(64363);
    return bool;
  }
  
  public final boolean eoo()
  {
    AppMethodBeat.i(64360);
    boolean bool = this.BxU.eoS();
    AppMethodBeat.o(64360);
    return bool;
  }
  
  public final boolean eop()
  {
    AppMethodBeat.i(64364);
    boolean bool = this.BxU.eop();
    AppMethodBeat.o(64364);
    return bool;
  }
  
  public final String eor()
  {
    AppMethodBeat.i(64355);
    Object localObject = p.ByH.ByL;
    if (localObject != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("json", ((j)localObject).ZsE);
        localJSONObject.put("signature", ((j)localObject).signature);
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
  
  public final boolean eos()
  {
    AppMethodBeat.i(64347);
    boolean bool = this.BxU.gh(MMApplicationContext.getContext());
    AppMethodBeat.o(64347);
    return bool;
  }
  
  public final boolean eot()
  {
    AppMethodBeat.i(64348);
    boolean bool = this.BxU.eoQ();
    AppMethodBeat.o(64348);
    return bool;
  }
  
  public final void eou()
  {
    AppMethodBeat.i(64349);
    Log.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
    this.BxU.prepare();
    AppMethodBeat.o(64349);
  }
  
  public final boolean eov()
  {
    return false;
  }
  
  public final boolean eow()
  {
    AppMethodBeat.i(64351);
    boolean bool = this.BxU.eoP();
    AppMethodBeat.o(64351);
    return bool;
  }
  
  public final Map<String, String> eox()
  {
    AppMethodBeat.i(64356);
    Map localMap = this.BxU.eox();
    AppMethodBeat.o(64356);
    return localMap;
  }
  
  public final Map<String, String> eoy()
  {
    AppMethodBeat.i(64357);
    Map localMap = eox();
    AppMethodBeat.o(64357);
    return localMap;
  }
  
  public final boolean eoz()
  {
    AppMethodBeat.i(64358);
    boolean bool = this.BxU.eoV();
    Log.i("MicroMsg.SoterAuthMgrImp", "py: hasAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(64358);
    return bool;
  }
  
  public final void ge(Context paramContext)
  {
    AppMethodBeat.i(64350);
    Log.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
    AppMethodBeat.o(64350);
  }
  
  public final int type()
  {
    return 2;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(64361);
    this.BxU.cancel();
    AppMethodBeat.o(64361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.k
 * JD-Core Version:    0.7.0.1
 */
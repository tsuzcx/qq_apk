package com.tencent.mm.plugin.fingerprint.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.ow.a;
import com.tencent.mm.g.a.ow.b;
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
  private com.tencent.soter.a.d.a wFx = null;
  
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc)
  {
    AppMethodBeat.i(64353);
    Log.i("MicroMsg.SoterAuthMgrImp", "start face auth: %s", new Object[] { Integer.valueOf(3000) });
    final MTimerHandler localMTimerHandler = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(64345);
        Log.i("MicroMsg.SoterAuthMgrImp", "timeout: %s", new Object[] { Integer.valueOf(this.nim) });
        k.a(k.this).cancel();
        paramc.gz(2000, -1);
        AppMethodBeat.o(64345);
        return false;
      }
    }, false);
    localMTimerHandler.startTimer(3000L);
    f localf = new f(p.wFK.wFE);
    this.wEX.b(MMApplicationContext.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64346);
        localMTimerHandler.stopTimer();
        paramc.gz(paramAnonymousc.errCode, -1);
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
    f localf = new f(p.wFK.wFE);
    this.wEX.a(MMApplicationContext.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64344);
        paramc.gz(paramAnonymousc.errCode, -1);
        AppMethodBeat.o(64344);
      }
    });
    AppMethodBeat.o(64352);
    return 0;
  }
  
  public final void a(ow paramow, int paramInt)
  {
    AppMethodBeat.i(64354);
    Log.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
    paramow.dUR.dUV = dJS();
    ow.b localb = paramow.dUR;
    if (!Util.isNullOrNil(paramow.dUR.dUV)) {}
    for (paramInt = 0;; paramInt = 1)
    {
      localb.errCode = paramInt;
      paramow.dUR.dUW = 2;
      paramow.dUR.dNR = "";
      paramow.dUR.dNS = "";
      if (paramow.dUQ.dUU != null) {
        paramow.dUQ.dUU.run();
      }
      AppMethodBeat.o(64354);
      return;
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(64359);
    Log.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b, extInfo: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBundle });
    this.wEX.a(paramBoolean1, paramBoolean2, p.wFK.wFM, paramBundle);
    AppMethodBeat.o(64359);
    return false;
  }
  
  public final boolean dJP()
  {
    AppMethodBeat.i(64360);
    boolean bool = this.wEX.dKt();
    AppMethodBeat.o(64360);
    return bool;
  }
  
  public final boolean dJQ()
  {
    AppMethodBeat.i(64364);
    boolean bool = this.wEX.dJQ();
    AppMethodBeat.o(64364);
    return bool;
  }
  
  public final String dJS()
  {
    AppMethodBeat.i(64355);
    Object localObject = p.wFK.wFO;
    if (localObject != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("json", ((j)localObject).RPZ);
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
  
  public final boolean dJT()
  {
    AppMethodBeat.i(64347);
    boolean bool = this.wEX.fN(MMApplicationContext.getContext());
    AppMethodBeat.o(64347);
    return bool;
  }
  
  public final boolean dJU()
  {
    AppMethodBeat.i(64348);
    boolean bool = this.wEX.dKr();
    AppMethodBeat.o(64348);
    return bool;
  }
  
  public final void dJV()
  {
    AppMethodBeat.i(64349);
    Log.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
    this.wEX.prepare();
    AppMethodBeat.o(64349);
  }
  
  public final boolean dJW()
  {
    return false;
  }
  
  public final boolean dJX()
  {
    AppMethodBeat.i(64351);
    boolean bool = this.wEX.dKq();
    AppMethodBeat.o(64351);
    return bool;
  }
  
  public final Map<String, String> dJY()
  {
    AppMethodBeat.i(64356);
    Map localMap = this.wEX.dJY();
    AppMethodBeat.o(64356);
    return localMap;
  }
  
  public final Map<String, String> dJZ()
  {
    AppMethodBeat.i(64357);
    Map localMap = dJY();
    AppMethodBeat.o(64357);
    return localMap;
  }
  
  public final boolean dKa()
  {
    AppMethodBeat.i(64358);
    boolean bool = this.wEX.dKw();
    Log.i("MicroMsg.SoterAuthMgrImp", "py: hasAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(64358);
    return bool;
  }
  
  public final boolean dKb()
  {
    AppMethodBeat.i(64362);
    boolean bool = this.wEX.fO(MMApplicationContext.getContext());
    AppMethodBeat.o(64362);
    return bool;
  }
  
  public final boolean dKc()
  {
    AppMethodBeat.i(64363);
    boolean bool = this.wEX.dKs();
    AppMethodBeat.o(64363);
    return bool;
  }
  
  public final void fK(Context paramContext)
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
    this.wEX.cancel();
    AppMethodBeat.o(64361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.k
 * JD-Core Version:    0.7.0.1
 */
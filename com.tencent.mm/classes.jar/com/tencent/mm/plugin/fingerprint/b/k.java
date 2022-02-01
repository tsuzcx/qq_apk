package com.tencent.mm.plugin.fingerprint.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.nv.a;
import com.tencent.mm.g.a.nv.b;
import com.tencent.mm.plugin.fingerprint.b.a.b;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.soter.core.c.j;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
  extends a
{
  private com.tencent.soter.a.d.a skw = null;
  
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc)
  {
    AppMethodBeat.i(64353);
    ac.i("MicroMsg.SoterAuthMgrImp", "start face auth: %s", new Object[] { Integer.valueOf(3000) });
    final au localau = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(64345);
        ac.i("MicroMsg.SoterAuthMgrImp", "timeout: %s", new Object[] { Integer.valueOf(this.lwI) });
        k.a(k.this).cancel();
        paramc.fL(2000, -1);
        AppMethodBeat.o(64345);
        return false;
      }
    }, false);
    localau.au(3000L, 3000L);
    f localf = new f(p.skJ.skD);
    this.sjV.b(ai.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64346);
        localau.stopTimer();
        paramc.fL(paramAnonymousc.errCode, -1);
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
      ac.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
      AppMethodBeat.o(64352);
      return 0;
    }
    f localf = new f(p.skJ.skD);
    this.sjV.a(ai.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64344);
        paramc.fL(paramAnonymousc.errCode, -1);
        AppMethodBeat.o(64344);
      }
    });
    AppMethodBeat.o(64352);
    return 0;
  }
  
  public final void a(nv paramnv, int paramInt)
  {
    AppMethodBeat.i(64354);
    ac.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
    paramnv.dqk.dqo = cHd();
    nv.b localb = paramnv.dqk;
    if (!bs.isNullOrNil(paramnv.dqk.dqo)) {}
    for (paramInt = 0;; paramInt = 1)
    {
      localb.errCode = paramInt;
      paramnv.dqk.dqp = 2;
      paramnv.dqk.djs = "";
      paramnv.dqk.djt = "";
      if (paramnv.dqj.dqn != null) {
        paramnv.dqj.dqn.run();
      }
      AppMethodBeat.o(64354);
      return;
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(64359);
    ac.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b, extInfo: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBundle });
    this.sjV.a(paramBoolean1, paramBoolean2, p.skJ.skL, paramBundle);
    AppMethodBeat.o(64359);
    return false;
  }
  
  public final boolean cHa()
  {
    AppMethodBeat.i(64360);
    boolean bool = this.sjV.cHE();
    AppMethodBeat.o(64360);
    return bool;
  }
  
  public final boolean cHb()
  {
    AppMethodBeat.i(64364);
    boolean bool = this.sjV.cHb();
    AppMethodBeat.o(64364);
    return bool;
  }
  
  public final String cHd()
  {
    AppMethodBeat.i(64355);
    Object localObject = p.skJ.skN;
    if (localObject != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("json", ((j)localObject).JWJ);
        localJSONObject.put("signature", ((j)localObject).signature);
        localObject = localJSONObject.toString();
        AppMethodBeat.o(64355);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        ac.e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", new Object[] { localJSONException.toString() });
        ac.printErrStackTrace("MicroMsg.SoterAuthMgrImp", localJSONException, "", new Object[0]);
        AppMethodBeat.o(64355);
        return "";
      }
    }
    ac.e("MicroMsg.SoterAuthMgrImp", "hy: signature result is null");
    AppMethodBeat.o(64355);
    return "";
  }
  
  public final boolean cHe()
  {
    AppMethodBeat.i(64347);
    boolean bool = this.sjV.fb(ai.getContext());
    AppMethodBeat.o(64347);
    return bool;
  }
  
  public final boolean cHf()
  {
    AppMethodBeat.i(64348);
    boolean bool = this.sjV.cHC();
    AppMethodBeat.o(64348);
    return bool;
  }
  
  public final void cHg()
  {
    AppMethodBeat.i(64349);
    ac.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
    this.sjV.prepare();
    AppMethodBeat.o(64349);
  }
  
  public final boolean cHh()
  {
    return false;
  }
  
  public final boolean cHi()
  {
    AppMethodBeat.i(64351);
    boolean bool = this.sjV.cHB();
    AppMethodBeat.o(64351);
    return bool;
  }
  
  public final Map<String, String> cHj()
  {
    AppMethodBeat.i(64356);
    Map localMap = this.sjV.cHj();
    AppMethodBeat.o(64356);
    return localMap;
  }
  
  public final Map<String, String> cHk()
  {
    AppMethodBeat.i(64357);
    Map localMap = cHj();
    AppMethodBeat.o(64357);
    return localMap;
  }
  
  public final boolean cHl()
  {
    AppMethodBeat.i(64358);
    boolean bool = this.sjV.cHH();
    ac.i("MicroMsg.SoterAuthMgrImp", "py: hasAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(64358);
    return bool;
  }
  
  public final boolean cHm()
  {
    AppMethodBeat.i(64362);
    boolean bool = this.sjV.fc(ai.getContext());
    AppMethodBeat.o(64362);
    return bool;
  }
  
  public final boolean cHn()
  {
    AppMethodBeat.i(64363);
    boolean bool = this.sjV.cHD();
    AppMethodBeat.o(64363);
    return bool;
  }
  
  public final void eY(Context paramContext)
  {
    AppMethodBeat.i(64350);
    ac.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
    AppMethodBeat.o(64350);
  }
  
  public final int type()
  {
    return 2;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(64361);
    this.sjV.cancel();
    AppMethodBeat.o(64361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.k
 * JD-Core Version:    0.7.0.1
 */
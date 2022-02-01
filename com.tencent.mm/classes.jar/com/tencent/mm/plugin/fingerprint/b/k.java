package com.tencent.mm.plugin.fingerprint.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.od.a;
import com.tencent.mm.g.a.od.b;
import com.tencent.mm.plugin.fingerprint.b.a.b;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.soter.core.c.j;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
  extends a
{
  private com.tencent.soter.a.d.a tgY = null;
  
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc)
  {
    AppMethodBeat.i(64353);
    ad.i("MicroMsg.SoterAuthMgrImp", "start face auth: %s", new Object[] { Integer.valueOf(3000) });
    final av localav = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(64345);
        ad.i("MicroMsg.SoterAuthMgrImp", "timeout: %s", new Object[] { Integer.valueOf(this.lVV) });
        k.a(k.this).cancel();
        paramc.gb(2000, -1);
        AppMethodBeat.o(64345);
        return false;
      }
    }, false);
    localav.az(3000L, 3000L);
    f localf = new f(p.thl.thf);
    this.tgx.b(aj.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64346);
        localav.stopTimer();
        paramc.gb(paramAnonymousc.errCode, -1);
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
      ad.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
      AppMethodBeat.o(64352);
      return 0;
    }
    f localf = new f(p.thl.thf);
    this.tgx.a(aj.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64344);
        paramc.gb(paramAnonymousc.errCode, -1);
        AppMethodBeat.o(64344);
      }
    });
    AppMethodBeat.o(64352);
    return 0;
  }
  
  public final void a(od paramod, int paramInt)
  {
    AppMethodBeat.i(64354);
    ad.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
    paramod.dBX.dCb = cPs();
    od.b localb = paramod.dBX;
    if (!bt.isNullOrNil(paramod.dBX.dCb)) {}
    for (paramInt = 0;; paramInt = 1)
    {
      localb.errCode = paramInt;
      paramod.dBX.dCc = 2;
      paramod.dBX.dvf = "";
      paramod.dBX.dvg = "";
      if (paramod.dBW.dCa != null) {
        paramod.dBW.dCa.run();
      }
      AppMethodBeat.o(64354);
      return;
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(64359);
    ad.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b, extInfo: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBundle });
    this.tgx.a(paramBoolean1, paramBoolean2, p.thl.thn, paramBundle);
    AppMethodBeat.o(64359);
    return false;
  }
  
  public final boolean cPA()
  {
    AppMethodBeat.i(64358);
    boolean bool = this.tgx.cPW();
    ad.i("MicroMsg.SoterAuthMgrImp", "py: hasAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(64358);
    return bool;
  }
  
  public final boolean cPB()
  {
    AppMethodBeat.i(64362);
    boolean bool = this.tgx.ff(aj.getContext());
    AppMethodBeat.o(64362);
    return bool;
  }
  
  public final boolean cPC()
  {
    AppMethodBeat.i(64363);
    boolean bool = this.tgx.cPS();
    AppMethodBeat.o(64363);
    return bool;
  }
  
  public final boolean cPp()
  {
    AppMethodBeat.i(64360);
    boolean bool = this.tgx.cPT();
    AppMethodBeat.o(64360);
    return bool;
  }
  
  public final boolean cPq()
  {
    AppMethodBeat.i(64364);
    boolean bool = this.tgx.cPq();
    AppMethodBeat.o(64364);
    return bool;
  }
  
  public final String cPs()
  {
    AppMethodBeat.i(64355);
    Object localObject = p.thl.thp;
    if (localObject != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("json", ((j)localObject).LQE);
        localJSONObject.put("signature", ((j)localObject).signature);
        localObject = localJSONObject.toString();
        AppMethodBeat.o(64355);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        ad.e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", new Object[] { localJSONException.toString() });
        ad.printErrStackTrace("MicroMsg.SoterAuthMgrImp", localJSONException, "", new Object[0]);
        AppMethodBeat.o(64355);
        return "";
      }
    }
    ad.e("MicroMsg.SoterAuthMgrImp", "hy: signature result is null");
    AppMethodBeat.o(64355);
    return "";
  }
  
  public final boolean cPt()
  {
    AppMethodBeat.i(64347);
    boolean bool = this.tgx.fe(aj.getContext());
    AppMethodBeat.o(64347);
    return bool;
  }
  
  public final boolean cPu()
  {
    AppMethodBeat.i(64348);
    boolean bool = this.tgx.cPR();
    AppMethodBeat.o(64348);
    return bool;
  }
  
  public final void cPv()
  {
    AppMethodBeat.i(64349);
    ad.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
    this.tgx.prepare();
    AppMethodBeat.o(64349);
  }
  
  public final boolean cPw()
  {
    return false;
  }
  
  public final boolean cPx()
  {
    AppMethodBeat.i(64351);
    boolean bool = this.tgx.cPQ();
    AppMethodBeat.o(64351);
    return bool;
  }
  
  public final Map<String, String> cPy()
  {
    AppMethodBeat.i(64356);
    Map localMap = this.tgx.cPy();
    AppMethodBeat.o(64356);
    return localMap;
  }
  
  public final Map<String, String> cPz()
  {
    AppMethodBeat.i(64357);
    Map localMap = cPy();
    AppMethodBeat.o(64357);
    return localMap;
  }
  
  public final void fb(Context paramContext)
  {
    AppMethodBeat.i(64350);
    ad.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
    AppMethodBeat.o(64350);
  }
  
  public final int type()
  {
    return 2;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(64361);
    this.tgx.cancel();
    AppMethodBeat.o(64361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.k
 * JD-Core Version:    0.7.0.1
 */
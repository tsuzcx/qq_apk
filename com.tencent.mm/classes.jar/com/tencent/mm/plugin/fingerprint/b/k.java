package com.tencent.mm.plugin.fingerprint.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.nm.a;
import com.tencent.mm.g.a.nm.b;
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
  private com.tencent.soter.a.d.a rcc = null;
  
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc)
  {
    AppMethodBeat.i(64353);
    ad.i("MicroMsg.SoterAuthMgrImp", "start face auth: %s", new Object[] { Integer.valueOf(3000) });
    final av localav = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(64345);
        ad.i("MicroMsg.SoterAuthMgrImp", "timeout: %s", new Object[] { Integer.valueOf(this.kUY) });
        k.a(k.this).cancel();
        paramc.fE(2000, -1);
        AppMethodBeat.o(64345);
        return false;
      }
    }, false);
    localav.av(3000L, 3000L);
    f localf = new f(p.rcp.rcj);
    this.rbB.b(aj.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64346);
        localav.stopTimer();
        paramc.fE(paramAnonymousc.errCode, -1);
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
    f localf = new f(p.rcp.rcj);
    this.rbB.a(aj.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64344);
        paramc.fE(paramAnonymousc.errCode, -1);
        AppMethodBeat.o(64344);
      }
    });
    AppMethodBeat.o(64352);
    return 0;
  }
  
  public final void a(nm paramnm, int paramInt)
  {
    AppMethodBeat.i(64354);
    ad.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
    paramnm.dsA.dsE = ctR();
    nm.b localb = paramnm.dsA;
    if (!bt.isNullOrNil(paramnm.dsA.dsE)) {}
    for (paramInt = 0;; paramInt = 1)
    {
      localb.errCode = paramInt;
      paramnm.dsA.dsF = 2;
      paramnm.dsA.dlK = "";
      paramnm.dsA.dlL = "";
      if (paramnm.dsz.dsD != null) {
        paramnm.dsz.dsD.run();
      }
      AppMethodBeat.o(64354);
      return;
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(64359);
    ad.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b, extInfo: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBundle });
    this.rbB.a(paramBoolean1, paramBoolean2, p.rcp.rcr, paramBundle);
    AppMethodBeat.o(64359);
    return false;
  }
  
  public final boolean ctO()
  {
    AppMethodBeat.i(64360);
    boolean bool = this.rbB.cus();
    AppMethodBeat.o(64360);
    return bool;
  }
  
  public final boolean ctP()
  {
    AppMethodBeat.i(64364);
    boolean bool = this.rbB.ctP();
    AppMethodBeat.o(64364);
    return bool;
  }
  
  public final String ctR()
  {
    AppMethodBeat.i(64355);
    Object localObject = p.rcp.rct;
    if (localObject != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("json", ((j)localObject).Iva);
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
  
  public final boolean ctS()
  {
    AppMethodBeat.i(64347);
    boolean bool = this.rbB.eO(aj.getContext());
    AppMethodBeat.o(64347);
    return bool;
  }
  
  public final boolean ctT()
  {
    AppMethodBeat.i(64348);
    boolean bool = this.rbB.cuq();
    AppMethodBeat.o(64348);
    return bool;
  }
  
  public final void ctU()
  {
    AppMethodBeat.i(64349);
    ad.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
    this.rbB.prepare();
    AppMethodBeat.o(64349);
  }
  
  public final boolean ctV()
  {
    return false;
  }
  
  public final boolean ctW()
  {
    AppMethodBeat.i(64351);
    boolean bool = this.rbB.cup();
    AppMethodBeat.o(64351);
    return bool;
  }
  
  public final Map<String, String> ctX()
  {
    AppMethodBeat.i(64356);
    Map localMap = this.rbB.ctX();
    AppMethodBeat.o(64356);
    return localMap;
  }
  
  public final Map<String, String> ctY()
  {
    AppMethodBeat.i(64357);
    Map localMap = ctX();
    AppMethodBeat.o(64357);
    return localMap;
  }
  
  public final boolean ctZ()
  {
    AppMethodBeat.i(64358);
    boolean bool = this.rbB.cuv();
    ad.i("MicroMsg.SoterAuthMgrImp", "py: hasAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(64358);
    return bool;
  }
  
  public final boolean cua()
  {
    AppMethodBeat.i(64362);
    boolean bool = this.rbB.eP(aj.getContext());
    AppMethodBeat.o(64362);
    return bool;
  }
  
  public final boolean cub()
  {
    AppMethodBeat.i(64363);
    boolean bool = this.rbB.cur();
    AppMethodBeat.o(64363);
    return bool;
  }
  
  public final void eL(Context paramContext)
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
    this.rbB.cancel();
    AppMethodBeat.o(64361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.k
 * JD-Core Version:    0.7.0.1
 */
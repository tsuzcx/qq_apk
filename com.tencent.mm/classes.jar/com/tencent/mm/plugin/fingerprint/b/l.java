package com.tencent.mm.plugin.fingerprint.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.a;
import com.tencent.mm.g.a.ma.b;
import com.tencent.mm.plugin.fingerprint.c.c;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.soter.a.g.b.a;
import com.tencent.soter.core.c.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
  extends a
{
  private boolean mGj = false;
  private n mGk = null;
  private com.tencent.soter.a.d.a mGl = null;
  private com.tencent.soter.a.a.a mGm = null;
  
  public final int a(com.tencent.mm.pluginsdk.wallet.d paramd)
  {
    AppMethodBeat.i(41522);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "start face auth: %s", new Object[] { Integer.valueOf(3000) });
    Object localObject = new l.2(this);
    this.mGm = new com.tencent.soter.a.a.a();
    localObject = new b.a().So(1).jn(ah.getContext()).Sp(2).a(this.mGm).a((com.tencent.soter.a.a.b)localObject).awQ(x.uli.mGC).Bnv;
    ap localap = new ap(new l.3(this, paramd), false);
    localap.ag(3000L, 3000L);
    com.tencent.soter.a.a.a(new l.4(this, localap, paramd), (com.tencent.soter.a.g.b)localObject);
    AppMethodBeat.o(41522);
    return 0;
  }
  
  @TargetApi(16)
  public final int a(com.tencent.mm.pluginsdk.wallet.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(41521);
    if (paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
      AppMethodBeat.o(41521);
      return 0;
    }
    Object localObject = new l.1(this, paramd);
    this.mGl = new com.tencent.soter.a.d.a();
    localObject = new b.a().So(1).jn(ah.getContext()).a(this.mGl).awQ(x.uli.mGC).a((com.tencent.soter.a.d.b)localObject).Bnv;
    com.tencent.soter.a.a.a(new l.5(this, paramd), (com.tencent.soter.a.g.b)localObject);
    AppMethodBeat.o(41521);
    return 0;
  }
  
  public final void a(ma paramma, int paramInt)
  {
    AppMethodBeat.i(41525);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
    paramma.cCb.cCf = byW();
    ma.b localb = paramma.cCb;
    if (!bo.isNullOrNil(paramma.cCb.cCf)) {}
    for (paramInt = 0;; paramInt = 1)
    {
      localb.errCode = paramInt;
      paramma.cCb.cCg = 2;
      paramma.cCb.cwl = "";
      paramma.cCb.cwm = "";
      if (paramma.cCa.cCe != null) {
        paramma.cCa.cCe.run();
      }
      AppMethodBeat.o(41525);
      return;
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    AppMethodBeat.i(41533);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b, extInfo: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramBundle });
    if (!paramBoolean1)
    {
      String str = paramBundle.getString("pwd");
      int i = paramBundle.getInt("key_open_biometric_type");
      if (bo.isNullOrNil(str))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SoterAuthMgrImp", "hy: no pwd. can not change auth key");
        AppMethodBeat.o(41533);
        return false;
      }
      if (x.uli.mGD)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "hy: need change auth key. start gen auth key");
        com.tencent.soter.a.a.a(new l.6(this), true, 1, new c(str, i), new f());
      }
    }
    AppMethodBeat.o(41533);
    return false;
  }
  
  public final boolean byT()
  {
    AppMethodBeat.i(41534);
    boolean bool = com.tencent.soter.core.a.jk(ah.getContext());
    AppMethodBeat.o(41534);
    return bool;
  }
  
  public final boolean byU()
  {
    AppMethodBeat.i(41538);
    boolean bool = com.tencent.soter.core.a.aF(ah.getContext(), 2);
    AppMethodBeat.o(41538);
    return bool;
  }
  
  public final String byW()
  {
    AppMethodBeat.i(41526);
    Object localObject = x.uli.ulk;
    if (localObject != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("json", ((j)localObject).BmG);
        localJSONObject.put("signature", ((j)localObject).signature);
        localObject = localJSONObject.toString();
        AppMethodBeat.o(41526);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", new Object[] { localJSONException.toString() });
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.SoterAuthMgrImp", localJSONException, "", new Object[0]);
        AppMethodBeat.o(41526);
        return "";
      }
    }
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SoterAuthMgrImp", "hy: signature result is null");
    AppMethodBeat.o(41526);
    return "";
  }
  
  public final k byZ()
  {
    AppMethodBeat.i(41528);
    this.mGk = new n();
    n localn = this.mGk;
    AppMethodBeat.o(41528);
    return localn;
  }
  
  public final boolean bza()
  {
    AppMethodBeat.i(41515);
    if (ac.ery.eqB == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.soter.a.a.dVs();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "hy: config support: %b, device support: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2) || (!com.tencent.soter.core.a.jg(ah.getContext()))) {
        break;
      }
      AppMethodBeat.o(41515);
      return true;
    }
    AppMethodBeat.o(41515);
    return false;
  }
  
  public final boolean bzb()
  {
    AppMethodBeat.i(41516);
    boolean bool = com.tencent.soter.core.a.ji(ah.getContext());
    AppMethodBeat.o(41516);
    return bool;
  }
  
  public final void bzc()
  {
    AppMethodBeat.i(41517);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
    e.hL(true);
    e.hK(true);
    if (!this.mGj)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.SoterAuthMgrImp", "SoterAuthMgrImp is set but still need to initSoter??? TaskInit had finished[%b]", new Object[] { Boolean.valueOf(com.tencent.soter.a.a.dVs()) });
      com.tencent.mm.plugin.soter.e.b.a(false, false, null);
      this.mGj = true;
    }
    AppMethodBeat.o(41517);
  }
  
  public final boolean bze()
  {
    return false;
  }
  
  public final boolean bzf()
  {
    AppMethodBeat.i(41520);
    boolean bool = bza();
    AppMethodBeat.o(41520);
    return bool;
  }
  
  @SuppressLint({"NewApi"})
  public final void bzg()
  {
    AppMethodBeat.i(41523);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
    AppMethodBeat.o(41523);
  }
  
  @SuppressLint({"NewApi"})
  public final void bzh()
  {
    AppMethodBeat.i(41524);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
    AppMethodBeat.o(41524);
  }
  
  public final void bzi()
  {
    AppMethodBeat.i(41527);
    if (com.tencent.soter.core.a.awK(e.bzp())) {
      com.tencent.soter.core.a.cu(e.bzp(), false);
    }
    AppMethodBeat.o(41527);
  }
  
  public final Map<String, String> bzj()
  {
    AppMethodBeat.i(41529);
    HashMap localHashMap = new HashMap();
    Object localObject = com.tencent.mm.plugin.soter.d.d.cyc();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject).son;
    localObject = ((com.tencent.mm.plugin.soter.d.e)localObject).kbP;
    localHashMap.put("cpu_id", str);
    localHashMap.put("uid", localObject);
    AppMethodBeat.o(41529);
    return localHashMap;
  }
  
  public final com.tencent.mm.pluginsdk.wallet.l bzk()
  {
    AppMethodBeat.i(41530);
    o localo = new o();
    AppMethodBeat.o(41530);
    return localo;
  }
  
  public final Map<String, String> bzl()
  {
    AppMethodBeat.i(41531);
    Map localMap = bzj();
    AppMethodBeat.o(41531);
    return localMap;
  }
  
  public final boolean bzm()
  {
    AppMethodBeat.i(41532);
    boolean bool = com.tencent.soter.core.a.awK(e.bzp());
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "py: hasAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(41532);
    return bool;
  }
  
  public final boolean bzn()
  {
    AppMethodBeat.i(41536);
    int i = ac.erA.err;
    if ((!ac.erA.cJE) || ((i & 0x2) != 2))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SoterAuthMgrImp", "peteryan check isDeviceSupportFaceID from SrvDeviceInfo.mSoterInfo return false typeis[%d]", new Object[] { Integer.valueOf(ac.erA.err) });
      AppMethodBeat.o(41536);
      return false;
    }
    if ((com.tencent.soter.a.a.dVs()) && (com.tencent.soter.core.a.jh(ah.getContext())))
    {
      AppMethodBeat.o(41536);
      return true;
    }
    AppMethodBeat.o(41536);
    return false;
  }
  
  public final boolean bzo()
  {
    AppMethodBeat.i(41537);
    boolean bool = com.tencent.soter.core.a.jj(ah.getContext());
    AppMethodBeat.o(41537);
    return bool;
  }
  
  public final void dS(Context paramContext)
  {
    AppMethodBeat.i(41519);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
    AppMethodBeat.o(41519);
  }
  
  public final void dT(Context paramContext)
  {
    AppMethodBeat.i(41518);
    e.hL(true);
    e.hK(true);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "hy: is soter. no need to init");
    AppMethodBeat.o(41518);
  }
  
  public final int type()
  {
    return 2;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(41535);
    if ((this.mGl != null) && (Build.VERSION.SDK_INT >= 16))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "alvinluo cancel fingeprint canceller");
      this.mGl.rX(true);
    }
    if (this.mGm != null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SoterAuthMgrImp", "cancel biometric canceller");
      this.mGm.rV(true);
    }
    AppMethodBeat.o(41535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.l
 * JD-Core Version:    0.7.0.1
 */
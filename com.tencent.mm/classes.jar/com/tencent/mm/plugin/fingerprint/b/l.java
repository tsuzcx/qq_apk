package com.tencent.mm.plugin.fingerprint.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.x;
import com.tencent.mm.h.a.ll;
import com.tencent.mm.h.a.ll.a;
import com.tencent.mm.h.a.ll.b;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.g.b.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
  extends a
{
  private boolean klv = false;
  private n klw = null;
  private com.tencent.soter.a.d.a klx = null;
  private com.tencent.soter.a.a.a kly = null;
  
  public final int a(com.tencent.mm.pluginsdk.wallet.c paramc)
  {
    y.i("MicroMsg.SoterAuthMgrImp", "start face auth: %s", new Object[] { Integer.valueOf(3000) });
    Object localObject = new l.2(this);
    this.kly = new com.tencent.soter.a.a.a();
    localObject = new b.a().Js(1).hM(ae.getContext()).Jt(2).a(this.kly).a((com.tencent.soter.a.a.b)localObject).afV(com.tencent.mm.plugin.wallet_core.model.s.qyz.klM).wPV;
    am localam = new am(new l.3(this, paramc), false);
    localam.S(3000L, 3000L);
    com.tencent.soter.a.a.a(new l.4(this, localam, paramc), (com.tencent.soter.a.g.b)localObject);
    return 0;
  }
  
  @TargetApi(16)
  public final int a(com.tencent.mm.pluginsdk.wallet.c paramc, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
      return 0;
    }
    Object localObject = new l.1(this, paramc);
    this.klx = new com.tencent.soter.a.d.a();
    localObject = new b.a().Js(1).hM(ae.getContext()).a(this.klx).afV(com.tencent.mm.plugin.wallet_core.model.s.qyz.klM).a((com.tencent.soter.a.d.b)localObject).wPV;
    com.tencent.soter.a.a.a(new l.5(this, paramc), (com.tencent.soter.a.g.b)localObject);
    return 0;
  }
  
  public final void a(ll paramll, int paramInt)
  {
    y.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
    paramll.bUw.bUA = aSA();
    ll.b localb = paramll.bUw;
    if (!bk.bl(paramll.bUw.bUA)) {}
    for (paramInt = 0;; paramInt = 1)
    {
      localb.errCode = paramInt;
      paramll.bUw.bUB = 2;
      paramll.bUw.bOU = "";
      paramll.bUw.bOV = "";
      if (paramll.bUv.bUz != null) {
        paramll.bUv.bUz.run();
      }
      return;
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    y.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (!paramBoolean1)
    {
      paramBundle = paramBundle.getString("pwd");
      if (!bk.bl(paramBundle)) {
        break label52;
      }
      y.e("MicroMsg.SoterAuthMgrImp", "hy: no pwd. can not change auth key");
    }
    label52:
    while (!com.tencent.mm.plugin.wallet_core.model.s.qyz.klN) {
      return false;
    }
    y.i("MicroMsg.SoterAuthMgrImp", "hy: need change auth key. start gen auth key");
    com.tencent.soter.a.a.a(new l.6(this), true, 1, new com.tencent.mm.plugin.fingerprint.c.c(paramBundle), new f());
    return false;
  }
  
  public final String aSA()
  {
    Object localObject = com.tencent.mm.plugin.wallet_core.model.s.qyz.qyB;
    if (localObject != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("json", ((com.tencent.soter.core.c.j)localObject).wPi);
        localJSONObject.put("signature", ((com.tencent.soter.core.c.j)localObject).signature);
        localObject = localJSONObject.toString();
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        y.e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", new Object[] { localJSONException.toString() });
        y.printErrStackTrace("MicroMsg.SoterAuthMgrImp", localJSONException, "", new Object[0]);
        return "";
      }
    }
    y.e("MicroMsg.SoterAuthMgrImp", "hy: signature result is null");
    return "";
  }
  
  public final void aSC()
  {
    if ((this.klx != null) && (Build.VERSION.SDK_INT >= 16))
    {
      y.i("MicroMsg.SoterAuthMgrImp", "alvinluo cancel fingeprint canceller");
      this.klx.ol(true);
      if (com.tencent.mm.plugin.soter.d.a.bKQ()) {
        com.tencent.mm.plugin.soter.d.a.c(1, -1000223, -1, "user cancelled");
      }
    }
    if (this.kly != null)
    {
      y.i("MicroMsg.SoterAuthMgrImp", "cancel biometric canceller");
      this.kly.oj(true);
    }
  }
  
  public final com.tencent.mm.pluginsdk.wallet.j aSE()
  {
    this.klw = new n();
    return this.klw;
  }
  
  public final boolean aSF()
  {
    if (q.dyh.dyq == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.soter.a.a.cPw();
      y.i("MicroMsg.SoterAuthMgrImp", "hy: config support: %b, device support: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2) || (!com.tencent.soter.core.a.hF(ae.getContext()))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public final boolean aSG()
  {
    return com.tencent.soter.core.a.hH(ae.getContext());
  }
  
  public final void aSH()
  {
    y.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
    e.gj(true);
    e.gi(true);
    if (!this.klv)
    {
      y.w("MicroMsg.SoterAuthMgrImp", "SoterAuthMgrImp is set but still need to initSoter??? TaskInit had finished[%b]", new Object[] { Boolean.valueOf(com.tencent.soter.a.a.cPw()) });
      com.tencent.mm.plugin.soter.e.b.a(false, false, null);
      this.klv = true;
    }
  }
  
  public final boolean aSJ()
  {
    return false;
  }
  
  public final boolean aSK()
  {
    return aSF();
  }
  
  @SuppressLint({"NewApi"})
  public final void aSL()
  {
    y.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
  }
  
  @SuppressLint({"NewApi"})
  public final void aSM()
  {
    y.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
  }
  
  public final void aSN()
  {
    if (com.tencent.soter.core.a.afP(e.aSU())) {
      com.tencent.soter.core.a.bR(e.aSU(), false);
    }
  }
  
  public final Map<String, String> aSO()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = d.bKR();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject).psl;
    localObject = ((com.tencent.mm.plugin.soter.d.e)localObject).psm;
    localHashMap.put("cpu_id", str);
    localHashMap.put("uid", localObject);
    return localHashMap;
  }
  
  public final k aSP()
  {
    return new o();
  }
  
  public final Map<String, String> aSQ()
  {
    return aSO();
  }
  
  public final boolean aSR()
  {
    boolean bool = com.tencent.soter.core.a.afP(e.aSU());
    y.i("MicroMsg.SoterAuthMgrImp", "py: hasAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      y.i("MicroMsg.SoterAuthMgrImp", "hy: no ask or auth key");
      com.tencent.mm.plugin.wallet_core.model.s.qyz.klN = true;
    }
    return !com.tencent.mm.plugin.wallet_core.model.s.qyz.klN;
  }
  
  public final boolean aSS()
  {
    boolean bool = true;
    int i = q.dyj.dyQ;
    if ((!q.dyj.cbb) || ((i & 0x2) != 2))
    {
      y.e("MicroMsg.SoterAuthMgrImp", "peteryan check isDeviceSupportFaceID from DeviceInfo.mSoterInfo return false typeis[%d]", new Object[] { Integer.valueOf(q.dyj.dyQ) });
      bool = false;
    }
    while ((com.tencent.soter.a.a.cPw()) && (com.tencent.soter.core.a.hG(ae.getContext()))) {
      return bool;
    }
    return false;
  }
  
  public final boolean aST()
  {
    return com.tencent.soter.core.a.hI(ae.getContext());
  }
  
  public final boolean aSx()
  {
    return com.tencent.soter.core.a.hJ(ae.getContext());
  }
  
  public final boolean aSy()
  {
    return com.tencent.soter.core.a.ap(ae.getContext(), 2);
  }
  
  public final void dh(Context paramContext)
  {
    y.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
  }
  
  public final int type()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.l
 * JD-Core Version:    0.7.0.1
 */
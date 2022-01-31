package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.fingerprint.c.b;
import com.tencent.mm.plugin.fingerprint.c.c;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class n
  implements com.tencent.mm.pluginsdk.wallet.j
{
  private String foR = "";
  WeakReference<WalletBaseUI> klC = null;
  private com.tencent.mm.pluginsdk.wallet.a klj = null;
  private com.tencent.mm.pluginsdk.wallet.a klk = null;
  
  private void am(int paramInt, String paramString)
  {
    y.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
    clear();
    this.klk.ai(paramInt, paramString);
    this.klk = null;
  }
  
  public final void a(Context paramContext, com.tencent.mm.pluginsdk.wallet.a parama, String paramString)
  {
    y.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
    this.klC = new WeakReference((WalletBaseUI)paramContext);
    this.klj = parama;
    this.foR = paramString;
    ((WalletBaseUI)this.klC.get()).kh(1586);
    ((WalletBaseUI)this.klC.get()).kh(1638);
    com.tencent.mm.plugin.soter.d.a.bKN();
    y.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
    com.tencent.soter.a.a.a(new n.1(this), true, 1, new c(this.foR), new f());
  }
  
  public final void a(com.tencent.mm.pluginsdk.wallet.a parama, String paramString, int paramInt)
  {
    y.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
    this.klk = parama;
    parama = s.qyz.qyB;
    if (parama != null)
    {
      if ((this.klC != null) && (this.klC.get() != null)) {
        ((WalletBaseUI)this.klC.get()).a(new b(parama.wPi, parama.signature, this.foR, 0), true, true);
      }
      return;
    }
    y.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
    com.tencent.mm.plugin.soter.d.a.c(9, -1000223, -1, "signature is null");
    al(-1, ae.getContext().getString(a.i.fingerprint_open_fail));
  }
  
  final void al(int paramInt, String paramString)
  {
    if (this.klj != null) {
      this.klj.ai(paramInt, paramString);
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    String str = paramString;
    if (bk.bl(paramString)) {
      str = ae.getContext().getString(a.i.fingerprint_open_fail);
    }
    if ((paramm instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        y.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
        if (bk.bl(((com.tencent.mm.plugin.fingerprint.c.a)paramm).klM))
        {
          al(-1, str);
          return true;
        }
        ai.d(new n.2(this));
      }
    }
    else
    {
      if (!(paramm instanceof b)) {
        break label201;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label175;
      }
      y.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.bKO();
      com.tencent.mm.plugin.soter.d.a.c(0, 0, 0, "OK");
      am(0, str);
    }
    for (;;)
    {
      return true;
      y.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
      al(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.c(7, paramInt1, paramInt2, "get challenge failed");
      return true;
      label175:
      y.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.c(8, paramInt1, paramInt2, "open fp pay failed");
      am(-1, str);
    }
    label201:
    return false;
  }
  
  public final void clear()
  {
    y.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
    if ((this.klC != null) && (this.klC.get() != null))
    {
      ((WalletBaseUI)this.klC.get()).ki(1586);
      ((WalletBaseUI)this.klC.get()).ki(1638);
    }
    this.klj = null;
    s.qyz.reset();
    if ((this.klC != null) && (this.klC.get() != null)) {
      this.klC.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.n
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
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

public final class m
  implements com.tencent.mm.pluginsdk.wallet.j
{
  private String foR;
  WeakReference<WalletBaseUI> klC;
  private com.tencent.mm.pluginsdk.wallet.a klD;
  private com.tencent.mm.pluginsdk.wallet.a klE;
  
  private void ak(int paramInt, String paramString)
  {
    if (this.klE != null) {
      this.klE.ai(paramInt, paramString);
    }
  }
  
  public final void a(Context paramContext, com.tencent.mm.pluginsdk.wallet.a parama, String paramString)
  {
    y.i("MicroMsg.SoterFaceIdOpenDelegate", "do prepare");
    this.klD = parama;
    this.foR = paramString;
    this.klC = new WeakReference((WalletBaseUI)paramContext);
    ((WalletBaseUI)this.klC.get()).kh(1586);
    ((WalletBaseUI)this.klC.get()).kh(1638);
    com.tencent.soter.a.a.a(new m.2(this), true, 1, new c(this.foR), new f());
  }
  
  public final void a(com.tencent.mm.pluginsdk.wallet.a parama, String paramString, int paramInt)
  {
    y.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: doOpenFP");
    this.klE = parama;
    parama = s.qyz.qyB;
    if (parama != null)
    {
      if ((this.klC != null) && (this.klC.get() != null)) {
        ((WalletBaseUI)this.klC.get()).a(new b(parama.wPi, parama.signature, this.foR, 1), true, true);
      }
      return;
    }
    y.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: signature is null");
    ak(-1, ae.getContext().getString(a.i.faceid_open_fail));
  }
  
  final void aj(int paramInt, String paramString)
  {
    if (this.klD != null) {
      this.klD.ai(paramInt, paramString);
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    String str = paramString;
    if (bk.bl(paramString)) {
      str = ae.getContext().getString(a.i.faceid_open_fail);
    }
    if ((paramm instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        y.i("MicroMsg.SoterFaceIdOpenDelegate", "get challenge success");
        if (bk.bl(((com.tencent.mm.plugin.fingerprint.c.a)paramm).klM))
        {
          aj(-1, str);
          return true;
        }
        ai.d(new m.1(this));
      }
    }
    else
    {
      if (!(paramm instanceof b)) {
        break label177;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label160;
      }
      y.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open success");
      ak(0, str);
    }
    for (;;)
    {
      return true;
      y.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed get challenge");
      aj(paramInt2, str);
      return true;
      label160:
      y.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open");
      ak(-1, str);
    }
    label177:
    return false;
  }
  
  public final void clear()
  {
    y.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: clear");
    if ((this.klC != null) && (this.klC.get() != null))
    {
      ((WalletBaseUI)this.klC.get()).ki(1586);
      ((WalletBaseUI)this.klC.get()).ki(1638);
    }
    s.qyz.reset();
    if ((this.klC != null) && (this.klC.get() != null)) {
      this.klC.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.m
 * JD-Core Version:    0.7.0.1
 */
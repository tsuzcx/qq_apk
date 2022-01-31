package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.c.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class h
  implements j
{
  private String bOV = null;
  private String foR = null;
  ah klf = new ah(new h.1(this));
  com.tencent.mm.pluginsdk.wallet.a klj = null;
  private com.tencent.mm.pluginsdk.wallet.a klk = null;
  WalletBaseUI kll = null;
  private String klm = null;
  
  public final void a(Context paramContext, com.tencent.mm.pluginsdk.wallet.a parama, String paramString)
  {
    this.kll = ((WalletBaseUI)paramContext);
    this.klj = parama;
    this.foR = paramString;
    paramContext = FingerPrintAuth.getRsaKey(e.dj(ae.getContext()), e.getUserId(), com.tencent.mm.compatible.e.q.zg());
    com.tencent.mm.plugin.soter.d.a.bKN();
    if (TextUtils.isEmpty(paramContext))
    {
      y.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
      new q(new h.a(this, (byte)0)).aTf();
      return;
    }
    y.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
    paramContext = new com.tencent.mm.plugin.fingerprint.c.e(paramContext);
    this.kll.a(paramContext, false, false);
  }
  
  public final void a(com.tencent.mm.pluginsdk.wallet.a parama, String paramString, int paramInt)
  {
    this.klk = parama;
    if (TextUtils.isEmpty(this.foR))
    {
      y.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
      parama.ai(-1, this.kll.getString(a.i.fingerprint_open_fail));
      return;
    }
    String str1 = e.getUserId();
    String str2 = com.tencent.mm.compatible.e.q.zg();
    String str3 = u.cMz();
    parama = "";
    if (e.aSK())
    {
      paramString = FingerPrintAuth.genOpenFPEncrypt(e.dj(ae.getContext()), str1, str2, paramString, str3, "", this.klm, this.bOV, Build.MODEL);
      parama = FingerPrintAuth.genOpenFPSign(e.dj(ae.getContext()), e.getUserId(), com.tencent.mm.compatible.e.q.zg(), paramString);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.klm)) {
        y.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
      }
      for (;;)
      {
        parama = new f(paramString, parama, this.foR, paramInt);
        this.kll.a(parama, false, false);
        return;
        if (TextUtils.isEmpty(parama)) {
          y.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
      }
      paramString = "";
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    int i = 0;
    if ((paramm instanceof com.tencent.mm.plugin.fingerprint.c.e)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        y.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
        paramString = (com.tencent.mm.plugin.fingerprint.c.e)paramm;
        this.klm = paramString.klm;
        this.bOV = paramString.bOV;
        localObject = this.klj;
        paramm = "";
        paramInt1 = i;
        ((com.tencent.mm.pluginsdk.wallet.a)localObject).ai(paramInt1, paramm);
        bool = true;
      }
    }
    while (!(paramm instanceof f)) {
      for (;;)
      {
        return bool;
        y.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
        com.tencent.mm.pluginsdk.wallet.a locala = this.klj;
        paramInt2 = -1;
        paramInt1 = paramInt2;
        Object localObject = locala;
        paramm = paramString;
        if (bk.bl(paramString))
        {
          paramm = this.kll.getString(a.i.fingerprint_open_fail);
          paramInt1 = paramInt2;
          localObject = locala;
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.soter.d.a.bKO();
      com.tencent.mm.plugin.soter.d.a.c(0, 0, 0, "OK");
      this.klk.ai(0, "");
    }
    for (;;)
    {
      return true;
      this.klk.ai(-2, "");
    }
  }
  
  public final void clear() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.h
 * JD-Core Version:    0.7.0.1
 */
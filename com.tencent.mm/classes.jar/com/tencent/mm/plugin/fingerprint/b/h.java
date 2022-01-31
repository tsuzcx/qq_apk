package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.c.f;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class h
  implements k
{
  private String cwm;
  private String gGl;
  ak mFT;
  com.tencent.mm.pluginsdk.wallet.a mFX;
  private com.tencent.mm.pluginsdk.wallet.a mFY;
  WalletBaseUI mFZ;
  private String mGa;
  
  public h()
  {
    AppMethodBeat.i(41485);
    this.mFX = null;
    this.mFY = null;
    this.mFZ = null;
    this.mGa = null;
    this.cwm = null;
    this.gGl = null;
    this.mFT = new ak(new h.1(this));
    AppMethodBeat.o(41485);
  }
  
  public final void a(Context paramContext, com.tencent.mm.pluginsdk.wallet.a parama, String paramString)
  {
    AppMethodBeat.i(41486);
    this.mFZ = ((WalletBaseUI)paramContext);
    this.mFX = parama;
    this.gGl = paramString;
    paramContext = FingerPrintAuth.getRsaKey(e.dU(ah.getContext()), e.getUserId(), com.tencent.mm.compatible.e.q.LK());
    com.tencent.mm.plugin.soter.d.a.cxZ();
    if (TextUtils.isEmpty(paramContext))
    {
      ab.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
      new q(new h.a(this, (byte)0)).aBi();
      AppMethodBeat.o(41486);
      return;
    }
    ab.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
    paramContext = new com.tencent.mm.plugin.fingerprint.c.e(paramContext);
    this.mFZ.doSceneProgress(paramContext, false);
    AppMethodBeat.o(41486);
  }
  
  public final void a(com.tencent.mm.pluginsdk.wallet.a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(41488);
    this.mFY = parama;
    if (TextUtils.isEmpty(this.gGl))
    {
      ab.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
      parama.aC(-1, this.mFZ.getString(2131299968));
      AppMethodBeat.o(41488);
      return;
    }
    String str1 = e.getUserId();
    String str2 = com.tencent.mm.compatible.e.q.LK();
    String str3 = w.dSo();
    parama = "";
    if (e.bzf())
    {
      paramString = FingerPrintAuth.genOpenFPEncrypt(e.dU(ah.getContext()), str1, str2, paramString, str3, "", this.mGa, this.cwm, Build.MODEL);
      parama = FingerPrintAuth.genOpenFPSign(e.dU(ah.getContext()), e.getUserId(), com.tencent.mm.compatible.e.q.LK(), paramString);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.mGa)) {
        ab.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
      }
      for (;;)
      {
        parama = new f(paramString, parama, this.gGl, paramInt);
        this.mFZ.doSceneProgress(parama, false);
        AppMethodBeat.o(41488);
        return;
        if (TextUtils.isEmpty(parama)) {
          ab.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
      }
      paramString = "";
    }
  }
  
  public final void clear() {}
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    AppMethodBeat.i(41487);
    if ((paramm instanceof com.tencent.mm.plugin.fingerprint.c.e))
    {
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ab.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
        paramString = (com.tencent.mm.plugin.fingerprint.c.e)paramm;
        this.mGa = paramString.mGa;
        this.cwm = paramString.cwm;
        localObject = this.mFX;
        paramm = "";
        paramInt1 = i;
      }
      for (;;)
      {
        ((com.tencent.mm.pluginsdk.wallet.a)localObject).aC(paramInt1, paramm);
        AppMethodBeat.o(41487);
        return true;
        ab.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
        com.tencent.mm.pluginsdk.wallet.a locala = this.mFX;
        paramInt2 = -1;
        paramInt1 = paramInt2;
        localObject = locala;
        paramm = paramString;
        if (bo.isNullOrNil(paramString))
        {
          paramm = this.mFZ.getString(2131299968);
          paramInt1 = paramInt2;
          localObject = locala;
        }
      }
    }
    if ((paramm instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.soter.d.a.cya();
        com.tencent.mm.plugin.soter.d.a.d(0, 0, 0, "OK");
        this.mFY.aC(0, "");
      }
      for (;;)
      {
        AppMethodBeat.o(41487);
        return true;
        this.mFY.aC(-2, "");
      }
    }
    AppMethodBeat.o(41487);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.h
 * JD-Core Version:    0.7.0.1
 */
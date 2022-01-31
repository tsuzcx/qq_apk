package com.tencent.mm.plugin.fingerprint.ui;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class FingerPrintEntranceUI
  extends WalletBaseUI
{
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 1;
    super.onCreate(paramBundle);
    y.i("MicroMsg.FingerPrintEntranceUI", "onCreate");
    int i;
    if (e.aTb())
    {
      y.i("MicroMsg.FingerPrintEntranceUI", "will call showSetFingerPrintGuide()");
      y.i("MicroMsg.FingerPrintEntranceUI", "hy: has standard action starting to fingerprint setting");
      paramBundle = getResources().getString(a.i.strong_guide_set_fingerprint_text);
      Resources localResources = getResources();
      if (((k)g.r(k.class)).aSJ())
      {
        i = a.i.btn_guide_reg_system_fingerprint;
        h.a(this, paramBundle, "", localResources.getString(i), getString(a.i.app_cancel), true, new FingerPrintEntranceUI.1(this), new FingerPrintEntranceUI.2(this));
        e.aSX();
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        y.e("MicroMsg.FingerPrintEntranceUI", "finish FingerPrintEntranceUI");
        finish();
      }
      return;
      i = a.i.app_ok;
      break;
      if (!e.aSW())
      {
        y.i("MicroMsg.FingerPrintEntranceUI", "will showOpenFingerPrintPayGuide()");
        h.a(this, getResources().getString(a.i.strong_guide_open_fingerprint_pay_text), "", getResources().getString(a.i.btn_guide_open_fingerprint), getString(a.i.app_cancel), true, new FingerPrintEntranceUI.3(this), new FingerPrintEntranceUI.4(this));
        e.aSV();
        i = j;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI
 * JD-Core Version:    0.7.0.1
 */
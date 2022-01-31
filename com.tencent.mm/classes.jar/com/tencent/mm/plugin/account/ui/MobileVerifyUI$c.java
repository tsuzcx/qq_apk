package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.database.ContentObserver;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class MobileVerifyUI$c
  extends ContentObserver
{
  private Activity activity;
  
  public MobileVerifyUI$c(MobileVerifyUI paramMobileVerifyUI, Activity paramActivity)
  {
    super(ah.fetchFreeHandler());
    this.activity = paramActivity;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (MobileVerifyUI.f(this.fpS) != 3)
    {
      paramBoolean = a.a(this.activity, "android.permission.READ_SMS", 128, "", "");
      y.i("MicroMsg.MobileVerifyUI", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(paramBoolean), bk.csb(), this.activity });
      if (paramBoolean) {}
    }
    else
    {
      return;
    }
    MobileVerifyUI.j(this.fpS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.tencent.mm.at.b;
import com.tencent.mm.at.b.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;

@a(7)
public class AppBrandRedirectUI
  extends MMActivity
{
  private int fromScene = -1;
  private boolean hdL = false;
  private int result = 0;
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    l.a(getWindow());
    y.i("AppBrandRedirectUI", "onCreate");
    setResult(0);
    this.fromScene = getIntent().getIntExtra("key_from_scene", -1);
    if (this.fromScene == 0)
    {
      getIntent().putExtra("WizardRootClass", getClass().getName());
      y.i("AppBrandRedirectUI", "start to bind phone number");
      paramBundle = new Intent();
      paramBundle.setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMContactUI");
      paramBundle.putExtra("is_bind_for_safe_device", false);
      paramBundle.putExtra("bind_scene", 5);
      Object localObject = ((TelephonyManager)this.mController.uMN.getSystemService("phone")).getSimCountryIso();
      if (!bk.bl((String)localObject))
      {
        localObject = b.i(this, (String)localObject, this.mController.uMN.getString(y.j.country_code));
        if (localObject != null)
        {
          paramBundle.putExtra("country_name", ((b.a)localObject).esg);
          paramBundle.putExtra("couttry_code", ((b.a)localObject).esf);
        }
      }
      MMWizardActivity.C(this, paramBundle);
      return;
    }
    y.e("AppBrandRedirectUI", "from scene is illegal, finish activity");
    finish();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      y.e("AppBrandRedirectUI", "onKeyDown KEYCODE_BACK, result cancel, finishUI");
      setResult(0);
      finish();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.i("AppBrandRedirectUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.result = paramIntent.getIntExtra("wizard_activity_result_code", 0);
      setResult(this.result);
      y.i("AppBrandRedirectUI", "result:%d, finish activity", new Object[] { Integer.valueOf(this.result) });
    }
    for (;;)
    {
      finish();
      return;
      y.i("AppBrandRedirectUI", "intent is null");
      setResult(0);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    y.i("AppBrandRedirectUI", "onResume");
    if (!this.hdL)
    {
      this.hdL = true;
      return;
    }
    y.i("AppBrandRedirectUI", "onResume, RESULT_CANCELED  finish activity");
    setResult(0);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI
 * JD-Core Version:    0.7.0.1
 */
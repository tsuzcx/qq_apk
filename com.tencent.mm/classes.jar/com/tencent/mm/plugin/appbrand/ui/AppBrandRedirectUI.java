package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.au.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class AppBrandRedirectUI
  extends MMActivity
{
  private int fromScene = -1;
  private boolean iOv = false;
  private int result = 0;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(133083);
    super.onCreate(paramBundle);
    o.a(getWindow());
    ab.i("AppBrandRedirectUI", "onCreate");
    setResult(0);
    this.fromScene = getIntent().getIntExtra("key_from_scene", -1);
    if (this.fromScene == 0)
    {
      getIntent().putExtra("WizardRootClass", getClass().getName());
      ab.i("AppBrandRedirectUI", "start to bind phone number");
      paramBundle = new Intent();
      paramBundle.setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMContactUI");
      paramBundle.putExtra("bind_scene", 5);
      Object localObject = ((TelephonyManager)getContext().getSystemService("phone")).getSimCountryIso();
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = b.k(this, (String)localObject, getContext().getString(2131298871));
        if (localObject != null)
        {
          paramBundle.putExtra("country_name", ((b.a)localObject).fHT);
          paramBundle.putExtra("couttry_code", ((b.a)localObject).fHS);
        }
      }
      MMWizardActivity.J(this, paramBundle);
      AppMethodBeat.o(133083);
      return;
    }
    ab.e("AppBrandRedirectUI", "from scene is illegal, finish activity");
    finish();
    AppMethodBeat.o(133083);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(133085);
    if (paramInt == 4)
    {
      ab.e("AppBrandRedirectUI", "onKeyDown KEYCODE_BACK, result cancel, finishUI");
      setResult(0);
      finish();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(133085);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(133086);
    ab.i("AppBrandRedirectUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.result = paramIntent.getIntExtra("wizard_activity_result_code", 0);
      setResult(this.result);
      ab.i("AppBrandRedirectUI", "result:%d, finish activity", new Object[] { Integer.valueOf(this.result) });
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(133086);
      return;
      ab.i("AppBrandRedirectUI", "intent is null");
      setResult(0);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(133084);
    super.onResume();
    ab.i("AppBrandRedirectUI", "onResume");
    if (!this.iOv)
    {
      this.iOv = true;
      AppMethodBeat.o(133084);
      return;
    }
    ab.i("AppBrandRedirectUI", "onResume, RESULT_CANCELED  finish activity");
    setResult(0);
    finish();
    AppMethodBeat.o(133084);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI
 * JD-Core Version:    0.7.0.1
 */
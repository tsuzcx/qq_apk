package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class AppBrandRedirectUI
  extends MMActivity
{
  private int fromScene = -1;
  private boolean mdU = false;
  private int result = 0;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48770);
    super.onCreate(paramBundle);
    r.b(getWindow());
    ac.i("AppBrandRedirectUI", "onCreate");
    setResult(0);
    this.fromScene = getIntent().getIntExtra("key_from_scene", -1);
    if (this.fromScene == 0)
    {
      ac.i("AppBrandRedirectUI", "start to bind phone number");
      paramBundle = new Intent();
      paramBundle.setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMContactUI");
      paramBundle.putExtra("WizardRootClass", getClass().getName());
      paramBundle.putExtra("bind_scene", 5);
      Object localObject = ((TelephonyManager)getContext().getSystemService("phone")).getSimCountryIso();
      if (!bs.isNullOrNil((String)localObject))
      {
        localObject = b.bp((String)localObject, getContext().getString(2131757950));
        if (localObject != null)
        {
          paramBundle.putExtra("country_name", ((b.a)localObject).hLr);
          paramBundle.putExtra("couttry_code", ((b.a)localObject).hLq);
        }
      }
      MMWizardActivity.aj(this, paramBundle);
      AppMethodBeat.o(48770);
      return;
    }
    ac.e("AppBrandRedirectUI", "from scene is illegal, finish activity");
    finish();
    AppMethodBeat.o(48770);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(48772);
    if (paramInt == 4)
    {
      ac.e("AppBrandRedirectUI", "onKeyDown KEYCODE_BACK, result cancel, finishUI");
      setResult(0);
      finish();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(48772);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48773);
    ac.i("AppBrandRedirectUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.result = paramIntent.getIntExtra("wizard_activity_result_code", 0);
      setResult(this.result);
      ac.i("AppBrandRedirectUI", "result:%d, finish activity", new Object[] { Integer.valueOf(this.result) });
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(48773);
      return;
      ac.i("AppBrandRedirectUI", "intent is null");
      setResult(0);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(48771);
    super.onResume();
    ac.i("AppBrandRedirectUI", "onResume");
    if (!this.mdU)
    {
      this.mdU = true;
      AppMethodBeat.o(48771);
      return;
    }
    ac.i("AppBrandRedirectUI", "onResume, RESULT_CANCELED  finish activity");
    setResult(0);
    finish();
    AppMethodBeat.o(48771);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI
 * JD-Core Version:    0.7.0.1
 */
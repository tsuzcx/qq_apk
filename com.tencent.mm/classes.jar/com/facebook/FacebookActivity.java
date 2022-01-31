package com.facebook;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.app.k;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginFragment;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookActivity
  extends FragmentActivity
{
  private static String FRAGMENT_TAG;
  public static String PASS_THROUGH_CANCEL_ACTION;
  private static final String TAG;
  private Fragment singleFragment;
  
  static
  {
    AppMethodBeat.i(96592);
    PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    FRAGMENT_TAG = "SingleFragment";
    TAG = FacebookActivity.class.getName();
    AppMethodBeat.o(96592);
  }
  
  private void handlePassThroughError()
  {
    AppMethodBeat.i(96591);
    FacebookException localFacebookException = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(getIntent()));
    setResult(0, NativeProtocol.createProtocolResultIntent(getIntent(), null, localFacebookException));
    finish();
    AppMethodBeat.o(96591);
  }
  
  public Fragment getCurrentFragment()
  {
    return this.singleFragment;
  }
  
  protected Fragment getFragment()
  {
    AppMethodBeat.i(96589);
    Intent localIntent = getIntent();
    g localg = getSupportFragmentManager();
    Fragment localFragment = localg.findFragmentByTag(FRAGMENT_TAG);
    Object localObject = localFragment;
    if (localFragment == null)
    {
      if (!"FacebookDialogFragment".equals(localIntent.getAction())) {
        break label71;
      }
      localObject = new FacebookDialogFragment();
      ((FacebookDialogFragment)localObject).setRetainInstance(true);
      ((FacebookDialogFragment)localObject).show(localg, FRAGMENT_TAG);
    }
    for (;;)
    {
      AppMethodBeat.o(96589);
      return localObject;
      label71:
      if ("DeviceShareDialogFragment".equals(localIntent.getAction()))
      {
        localObject = new DeviceShareDialogFragment();
        ((DeviceShareDialogFragment)localObject).setRetainInstance(true);
        ((DeviceShareDialogFragment)localObject).setShareContent((ShareContent)localIntent.getParcelableExtra("content"));
        ((DeviceShareDialogFragment)localObject).show(localg, FRAGMENT_TAG);
      }
      else
      {
        localObject = new LoginFragment();
        ((Fragment)localObject).setRetainInstance(true);
        localg.beginTransaction().a(2131822961, (Fragment)localObject, FRAGMENT_TAG).commit();
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(96590);
    super.onConfigurationChanged(paramConfiguration);
    if (this.singleFragment != null) {
      this.singleFragment.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(96590);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(96588);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (!FacebookSdk.isInitialized())
    {
      Utility.logd(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
      FacebookSdk.sdkInitialize(getApplicationContext());
    }
    setContentView(2130969185);
    if (PASS_THROUGH_CANCEL_ACTION.equals(paramBundle.getAction()))
    {
      handlePassThroughError();
      AppMethodBeat.o(96588);
      return;
    }
    this.singleFragment = getFragment();
    AppMethodBeat.o(96588);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.FacebookActivity
 * JD-Core Version:    0.7.0.1
 */
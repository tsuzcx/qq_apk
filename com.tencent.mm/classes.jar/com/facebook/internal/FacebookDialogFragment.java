package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookDialogFragment
  extends DialogFragment
{
  public static final String TAG = "FacebookDialogFragment";
  private Dialog dialog;
  
  private void onCompleteWebDialog(Bundle paramBundle, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(96636);
    FragmentActivity localFragmentActivity = getActivity();
    paramBundle = NativeProtocol.createProtocolResultIntent(localFragmentActivity.getIntent(), paramBundle, paramFacebookException);
    if (paramFacebookException == null) {}
    for (int i = -1;; i = 0)
    {
      localFragmentActivity.setResult(i, paramBundle);
      localFragmentActivity.finish();
      AppMethodBeat.o(96636);
      return;
    }
  }
  
  private void onCompleteWebFallbackDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(96637);
    FragmentActivity localFragmentActivity = getActivity();
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localIntent.putExtras(localBundle);
    localFragmentActivity.setResult(-1, localIntent);
    localFragmentActivity.finish();
    AppMethodBeat.o(96637);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(96634);
    super.onConfigurationChanged(paramConfiguration);
    if (((this.dialog instanceof WebDialog)) && (isResumed())) {
      ((WebDialog)this.dialog).resize();
    }
    AppMethodBeat.o(96634);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(96631);
    super.onCreate(paramBundle);
    Bundle localBundle;
    String str;
    if (this.dialog == null)
    {
      paramBundle = getActivity();
      localBundle = NativeProtocol.getMethodArgumentsFromIntent(paramBundle.getIntent());
      if (localBundle.getBoolean("is_fallback", false)) {
        break label114;
      }
      str = localBundle.getString("action");
      localBundle = localBundle.getBundle("params");
      if (Utility.isNullOrEmpty(str))
      {
        Utility.logd("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
        paramBundle.finish();
        AppMethodBeat.o(96631);
        return;
      }
      paramBundle = new WebDialog.Builder(paramBundle, str, localBundle).setOnCompleteListener(new FacebookDialogFragment.1(this)).build();
    }
    for (;;)
    {
      this.dialog = paramBundle;
      AppMethodBeat.o(96631);
      return;
      label114:
      str = localBundle.getString("url");
      if (Utility.isNullOrEmpty(str))
      {
        Utility.logd("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
        paramBundle.finish();
        AppMethodBeat.o(96631);
        return;
      }
      paramBundle = FacebookWebFallbackDialog.newInstance(paramBundle, str, String.format("fb%s://bridge/", new Object[] { FacebookSdk.getApplicationId() }));
      paramBundle.setOnCompleteListener(new FacebookDialogFragment.2(this));
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(96632);
    if (this.dialog == null)
    {
      onCompleteWebDialog(null, null);
      setShowsDialog(false);
    }
    paramBundle = this.dialog;
    AppMethodBeat.o(96632);
    return paramBundle;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(96635);
    if ((getDialog() != null) && (getRetainInstance())) {
      getDialog().setDismissMessage(null);
    }
    super.onDestroyView();
    AppMethodBeat.o(96635);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(96633);
    super.onResume();
    if ((this.dialog instanceof WebDialog)) {
      ((WebDialog)this.dialog).resize();
    }
    AppMethodBeat.o(96633);
  }
  
  public void setDialog(Dialog paramDialog)
  {
    this.dialog = paramDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.internal.FacebookDialogFragment
 * JD-Core Version:    0.7.0.1
 */
package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
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
    AppMethodBeat.i(7660);
    FragmentActivity localFragmentActivity = getActivity();
    paramBundle = NativeProtocol.createProtocolResultIntent(localFragmentActivity.getIntent(), paramBundle, paramFacebookException);
    if (paramFacebookException == null) {}
    for (int i = -1;; i = 0)
    {
      localFragmentActivity.setResult(i, paramBundle);
      localFragmentActivity.finish();
      AppMethodBeat.o(7660);
      return;
    }
  }
  
  private void onCompleteWebFallbackDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(7661);
    FragmentActivity localFragmentActivity = getActivity();
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localIntent.putExtras(localBundle);
    localFragmentActivity.setResult(-1, localIntent);
    localFragmentActivity.finish();
    AppMethodBeat.o(7661);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(7658);
    super.onConfigurationChanged(paramConfiguration);
    if (((this.dialog instanceof WebDialog)) && (isResumed())) {
      ((WebDialog)this.dialog).resize();
    }
    AppMethodBeat.o(7658);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7655);
    super.onCreate(paramBundle);
    Bundle localBundle;
    String str;
    if (this.dialog == null)
    {
      paramBundle = getActivity();
      localBundle = NativeProtocol.getMethodArgumentsFromIntent(paramBundle.getIntent());
      if (localBundle.getBoolean("is_fallback", false)) {
        break label117;
      }
      str = localBundle.getString("action");
      localBundle = localBundle.getBundle("params");
      if (Utility.isNullOrEmpty(str))
      {
        Utility.logd("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
        paramBundle.finish();
        AppMethodBeat.o(7655);
        return;
      }
      paramBundle = new WebDialog.Builder(paramBundle, str, localBundle).setOnCompleteListener(new WebDialog.OnCompleteListener()
      {
        public void onComplete(Bundle paramAnonymousBundle, FacebookException paramAnonymousFacebookException)
        {
          AppMethodBeat.i(7653);
          FacebookDialogFragment.access$000(FacebookDialogFragment.this, paramAnonymousBundle, paramAnonymousFacebookException);
          AppMethodBeat.o(7653);
        }
      }).build();
    }
    for (;;)
    {
      this.dialog = paramBundle;
      AppMethodBeat.o(7655);
      return;
      label117:
      str = localBundle.getString("url");
      if (Utility.isNullOrEmpty(str))
      {
        Utility.logd("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
        paramBundle.finish();
        AppMethodBeat.o(7655);
        return;
      }
      paramBundle = FacebookWebFallbackDialog.newInstance(paramBundle, str, String.format("fb%s://bridge/", new Object[] { FacebookSdk.getApplicationId() }));
      paramBundle.setOnCompleteListener(new WebDialog.OnCompleteListener()
      {
        public void onComplete(Bundle paramAnonymousBundle, FacebookException paramAnonymousFacebookException)
        {
          AppMethodBeat.i(7654);
          FacebookDialogFragment.access$100(FacebookDialogFragment.this, paramAnonymousBundle);
          AppMethodBeat.o(7654);
        }
      });
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(7656);
    if (this.dialog == null)
    {
      onCompleteWebDialog(null, null);
      setShowsDialog(false);
    }
    paramBundle = this.dialog;
    AppMethodBeat.o(7656);
    return paramBundle;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(7659);
    if ((getDialog() != null) && (getRetainInstance())) {
      getDialog().setDismissMessage(null);
    }
    super.onDestroyView();
    AppMethodBeat.o(7659);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7657);
    super.onResume();
    if ((this.dialog instanceof WebDialog)) {
      ((WebDialog)this.dialog).resize();
    }
    AppMethodBeat.o(7657);
  }
  
  public void setDialog(Dialog paramDialog)
  {
    this.dialog = paramDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.internal.FacebookDialogFragment
 * JD-Core Version:    0.7.0.1
 */
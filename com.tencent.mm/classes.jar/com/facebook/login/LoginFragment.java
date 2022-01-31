package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LoginFragment
  extends Fragment
{
  static final String EXTRA_REQUEST = "request";
  private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
  static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
  static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
  private static final String SAVED_LOGIN_CLIENT = "loginClient";
  private static final String TAG = "LoginFragment";
  private String callingPackage;
  private LoginClient loginClient;
  private LoginClient.Request request;
  
  private void initializeCallingPackage(Activity paramActivity)
  {
    AppMethodBeat.i(96855);
    paramActivity = paramActivity.getCallingActivity();
    if (paramActivity == null)
    {
      AppMethodBeat.o(96855);
      return;
    }
    this.callingPackage = paramActivity.getPackageName();
    AppMethodBeat.o(96855);
  }
  
  private void onLoginClientCompleted(LoginClient.Result paramResult)
  {
    AppMethodBeat.i(96850);
    this.request = null;
    if (paramResult.code == LoginClient.Result.Code.CANCEL) {}
    for (int i = 0;; i = -1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("com.facebook.LoginFragment:Result", paramResult);
      paramResult = new Intent();
      paramResult.putExtras(localBundle);
      if (isAdded())
      {
        getActivity().setResult(i, paramResult);
        getActivity().finish();
      }
      AppMethodBeat.o(96850);
      return;
    }
  }
  
  protected LoginClient createLoginClient()
  {
    AppMethodBeat.i(96847);
    LoginClient localLoginClient = new LoginClient(this);
    AppMethodBeat.o(96847);
    return localLoginClient;
  }
  
  protected int getLayoutResId()
  {
    return 2130969187;
  }
  
  LoginClient getLoginClient()
  {
    return this.loginClient;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(96853);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.loginClient.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(96853);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(96846);
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.loginClient = ((LoginClient)paramBundle.getParcelable("loginClient"));
      this.loginClient.setFragment(this);
    }
    for (;;)
    {
      this.loginClient.setOnCompletedListener(new LoginFragment.1(this));
      paramBundle = getActivity();
      if (paramBundle != null) {
        break;
      }
      AppMethodBeat.o(96846);
      return;
      this.loginClient = createLoginClient();
    }
    initializeCallingPackage(paramBundle);
    paramBundle = paramBundle.getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBundleExtra("com.facebook.LoginFragment:Request");
      if (paramBundle != null) {
        this.request = ((LoginClient.Request)paramBundle.getParcelable("request"));
      }
    }
    AppMethodBeat.o(96846);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(96849);
    paramLayoutInflater = paramLayoutInflater.inflate(getLayoutResId(), paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(2131822965);
    this.loginClient.setBackgroundProcessingListener(new LoginFragment.2(this, paramViewGroup));
    AppMethodBeat.o(96849);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(96848);
    this.loginClient.cancelCurrentHandler();
    super.onDestroy();
    AppMethodBeat.o(96848);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(96852);
    super.onPause();
    if (getView() == null) {}
    for (View localView = null;; localView = getView().findViewById(2131822965))
    {
      if (localView != null) {
        localView.setVisibility(8);
      }
      AppMethodBeat.o(96852);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(96851);
    super.onResume();
    if (this.callingPackage == null)
    {
      getActivity().finish();
      AppMethodBeat.o(96851);
      return;
    }
    this.loginClient.startOrContinueAuth(this.request);
    AppMethodBeat.o(96851);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(96854);
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("loginClient", this.loginClient);
    AppMethodBeat.o(96854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.login.LoginFragment
 * JD-Core Version:    0.7.0.1
 */
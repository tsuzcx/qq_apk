package com.facebook.login;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LoginFragment$2
  implements LoginClient.BackgroundProcessingListener
{
  LoginFragment$2(LoginFragment paramLoginFragment, View paramView) {}
  
  public void onBackgroundProcessingStarted()
  {
    AppMethodBeat.i(96844);
    this.val$progressBar.setVisibility(0);
    AppMethodBeat.o(96844);
  }
  
  public void onBackgroundProcessingStopped()
  {
    AppMethodBeat.i(96845);
    this.val$progressBar.setVisibility(8);
    AppMethodBeat.o(96845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.login.LoginFragment.2
 * JD-Core Version:    0.7.0.1
 */
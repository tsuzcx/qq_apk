package com.facebook.login;

import com.tencent.matrix.trace.core.AppMethodBeat;

class LoginFragment$1
  implements LoginClient.OnCompletedListener
{
  LoginFragment$1(LoginFragment paramLoginFragment) {}
  
  public void onCompleted(LoginClient.Result paramResult)
  {
    AppMethodBeat.i(96843);
    LoginFragment.access$000(this.this$0, paramResult);
    AppMethodBeat.o(96843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.login.LoginFragment.1
 * JD-Core Version:    0.7.0.1
 */
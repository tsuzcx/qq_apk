package com.facebook.login;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LoginManager$1
  implements CallbackManagerImpl.Callback
{
  LoginManager$1(LoginManager paramLoginManager, FacebookCallback paramFacebookCallback) {}
  
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(96870);
    boolean bool = this.this$0.onActivityResult(paramInt, paramIntent, this.val$callback);
    AppMethodBeat.o(96870);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.login.LoginManager.1
 * JD-Core Version:    0.7.0.1
 */
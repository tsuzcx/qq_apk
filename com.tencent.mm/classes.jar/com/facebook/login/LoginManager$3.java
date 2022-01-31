package com.facebook.login;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LoginManager$3
  implements CallbackManagerImpl.Callback
{
  LoginManager$3(LoginManager paramLoginManager) {}
  
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(96872);
    boolean bool = this.this$0.onActivityResult(paramInt, paramIntent);
    AppMethodBeat.o(96872);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.LoginManager.3
 * JD-Core Version:    0.7.0.1
 */
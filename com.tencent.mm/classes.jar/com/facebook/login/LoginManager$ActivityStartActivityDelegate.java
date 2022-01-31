package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LoginManager$ActivityStartActivityDelegate
  implements StartActivityDelegate
{
  private final Activity activity;
  
  LoginManager$ActivityStartActivityDelegate(Activity paramActivity)
  {
    AppMethodBeat.i(96874);
    Validate.notNull(paramActivity, "activity");
    this.activity = paramActivity;
    AppMethodBeat.o(96874);
  }
  
  public Activity getActivityContext()
  {
    return this.activity;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(96875);
    this.activity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(96875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.login.LoginManager.ActivityStartActivityDelegate
 * JD-Core Version:    0.7.0.1
 */
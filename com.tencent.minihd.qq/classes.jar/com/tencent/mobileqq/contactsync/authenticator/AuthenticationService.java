package com.tencent.mobileqq.contactsync.authenticator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AuthenticationService
  extends Service
{
  public static final String a = "from_add_account";
  private static final String b = "ContactSync.AuthenticationService";
  private Authenticator a;
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a.getIBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = new Authenticator(this);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.authenticator.AuthenticationService
 * JD-Core Version:    0.7.0.1
 */
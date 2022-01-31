package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult
  implements Result
{
  private Status zzair;
  private GoogleSignInAccount zzaks;
  
  public GoogleSignInResult(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
  {
    this.zzaks = paramGoogleSignInAccount;
    this.zzair = paramStatus;
  }
  
  public GoogleSignInAccount getSignInAccount()
  {
    return this.zzaks;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
  
  public boolean isSuccess()
  {
    return this.zzair.isSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInResult
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleSignInResult
  implements Result
{
  private Status mStatus;
  private GoogleSignInAccount zzen;
  
  public GoogleSignInResult(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
  {
    this.zzen = paramGoogleSignInAccount;
    this.mStatus = paramStatus;
  }
  
  public GoogleSignInAccount getSignInAccount()
  {
    return this.zzen;
  }
  
  public Status getStatus()
  {
    return this.mStatus;
  }
  
  public boolean isSuccess()
  {
    AppMethodBeat.i(88291);
    boolean bool = this.mStatus.isSuccess();
    AppMethodBeat.o(88291);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInResult
 * JD-Core Version:    0.7.0.1
 */
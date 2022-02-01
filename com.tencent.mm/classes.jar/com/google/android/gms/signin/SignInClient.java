package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.signin.internal.ISignInCallbacks;

public abstract interface SignInClient
  extends Api.Client
{
  public abstract void clearAccountFromSessionStore();
  
  public abstract void connect();
  
  public abstract void saveDefaultAccount(IAccountAccessor paramIAccountAccessor, boolean paramBoolean);
  
  public abstract void signIn(ISignInCallbacks paramISignInCallbacks);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.signin.SignInClient
 * JD-Core Version:    0.7.0.1
 */
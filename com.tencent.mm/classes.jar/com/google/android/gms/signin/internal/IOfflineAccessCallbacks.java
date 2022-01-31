package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public abstract interface IOfflineAccessCallbacks
  extends IInterface
{
  public abstract void checkServerAuthorization(String paramString, List<Scope> paramList, ISignInService paramISignInService);
  
  public abstract void uploadServerAuthCode(String paramString1, String paramString2, ISignInService paramISignInService);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.signin.internal.IOfflineAccessCallbacks
 * JD-Core Version:    0.7.0.1
 */
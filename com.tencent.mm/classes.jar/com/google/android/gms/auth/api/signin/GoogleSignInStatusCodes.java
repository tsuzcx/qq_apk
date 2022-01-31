package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.CommonStatusCodes;

public final class GoogleSignInStatusCodes
  extends CommonStatusCodes
{
  public static final int SIGN_IN_CANCELLED = 12501;
  public static final int SIGN_IN_FAILED = 12500;
  
  public static String getStatusCodeString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return CommonStatusCodes.getStatusCodeString(paramInt);
    }
    return "A non-recoverable sign in failure occurred";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes
 * JD-Core Version:    0.7.0.1
 */
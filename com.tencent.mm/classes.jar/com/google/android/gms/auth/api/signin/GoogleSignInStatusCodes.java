package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GoogleSignInStatusCodes
  extends CommonStatusCodes
{
  public static final int SIGN_IN_CANCELLED = 12501;
  public static final int SIGN_IN_CURRENTLY_IN_PROGRESS = 12502;
  public static final int SIGN_IN_FAILED = 12500;
  
  public static String getStatusCodeString(int paramInt)
  {
    AppMethodBeat.i(88292);
    switch (paramInt)
    {
    default: 
      String str = CommonStatusCodes.getStatusCodeString(paramInt);
      AppMethodBeat.o(88292);
      return str;
    case 12500: 
      AppMethodBeat.o(88292);
      return "A non-recoverable sign in failure occurred";
    case 12501: 
      AppMethodBeat.o(88292);
      return "Sign in action cancelled";
    }
    AppMethodBeat.o(88292);
    return "Sign-in in progress";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes
 * JD-Core Version:    0.7.0.1
 */
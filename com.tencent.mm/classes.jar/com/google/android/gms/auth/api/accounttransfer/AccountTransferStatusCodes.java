package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AccountTransferStatusCodes
  extends CommonStatusCodes
{
  public static final int CHALLENGE_NOT_ALLOWED = 20503;
  public static final int INVALID_REQUEST = 20502;
  public static final int NOT_ALLOWED_SECURITY = 20500;
  public static final int NO_DATA_AVAILABLE = 20501;
  public static final int SESSION_INACTIVE = 20504;
  
  public static String getStatusCodeString(int paramInt)
  {
    AppMethodBeat.i(10648);
    switch (paramInt)
    {
    default: 
      String str = CommonStatusCodes.getStatusCodeString(paramInt);
      AppMethodBeat.o(10648);
      return str;
    case 20500: 
      AppMethodBeat.o(10648);
      return "NOT_ALLOWED_SECURITY";
    case 20501: 
      AppMethodBeat.o(10648);
      return "NO_DATA_AVAILABLE";
    case 20502: 
      AppMethodBeat.o(10648);
      return "INVALID_REQUEST";
    case 20503: 
      AppMethodBeat.o(10648);
      return "CHALLENGE_NOT_ALLOWED";
    }
    AppMethodBeat.o(10648);
    return "SESSION_INACTIVE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.AccountTransferStatusCodes
 * JD-Core Version:    0.7.0.1
 */
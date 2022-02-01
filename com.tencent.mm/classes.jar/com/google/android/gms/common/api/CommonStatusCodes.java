package com.google.android.gms.common.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CommonStatusCodes
{
  public static final int API_NOT_CONNECTED = 17;
  public static final int CANCELED = 16;
  public static final int DEVELOPER_ERROR = 10;
  public static final int ERROR = 13;
  public static final int INTERNAL_ERROR = 8;
  public static final int INTERRUPTED = 14;
  public static final int INVALID_ACCOUNT = 5;
  public static final int NETWORK_ERROR = 7;
  public static final int RESOLUTION_REQUIRED = 6;
  @Deprecated
  public static final int SERVICE_DISABLED = 3;
  @Deprecated
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int SUCCESS_CACHE = -1;
  public static final int TIMEOUT = 15;
  
  public static String getStatusCodeString(int paramInt)
  {
    AppMethodBeat.i(4466);
    switch (paramInt)
    {
    case 1: 
    case 9: 
    case 11: 
    case 12: 
    default: 
      String str = 32 + "unknown status code: " + paramInt;
      AppMethodBeat.o(4466);
      return str;
    case -1: 
      AppMethodBeat.o(4466);
      return "SUCCESS_CACHE";
    case 0: 
      AppMethodBeat.o(4466);
      return "SUCCESS";
    case 2: 
      AppMethodBeat.o(4466);
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3: 
      AppMethodBeat.o(4466);
      return "SERVICE_DISABLED";
    case 4: 
      AppMethodBeat.o(4466);
      return "SIGN_IN_REQUIRED";
    case 5: 
      AppMethodBeat.o(4466);
      return "INVALID_ACCOUNT";
    case 6: 
      AppMethodBeat.o(4466);
      return "RESOLUTION_REQUIRED";
    case 7: 
      AppMethodBeat.o(4466);
      return "NETWORK_ERROR";
    case 8: 
      AppMethodBeat.o(4466);
      return "INTERNAL_ERROR";
    case 10: 
      AppMethodBeat.o(4466);
      return "DEVELOPER_ERROR";
    case 13: 
      AppMethodBeat.o(4466);
      return "ERROR";
    case 14: 
      AppMethodBeat.o(4466);
      return "INTERRUPTED";
    case 15: 
      AppMethodBeat.o(4466);
      return "TIMEOUT";
    case 16: 
      AppMethodBeat.o(4466);
      return "CANCELED";
    case 17: 
      AppMethodBeat.o(4466);
      return "API_NOT_CONNECTED";
    }
    AppMethodBeat.o(4466);
    return "DEAD_CLIENT";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.CommonStatusCodes
 * JD-Core Version:    0.7.0.1
 */
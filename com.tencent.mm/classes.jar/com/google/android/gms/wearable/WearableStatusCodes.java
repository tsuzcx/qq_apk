package com.google.android.gms.wearable;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WearableStatusCodes
  extends CommonStatusCodes
{
  public static final int ASSET_UNAVAILABLE = 4005;
  public static final int DATA_ITEM_TOO_LARGE = 4003;
  public static final int DUPLICATE_CAPABILITY = 4006;
  public static final int DUPLICATE_LISTENER = 4001;
  public static final int INVALID_TARGET_NODE = 4004;
  public static final int TARGET_NODE_NOT_CONNECTED = 4000;
  public static final int UNKNOWN_CAPABILITY = 4007;
  public static final int UNKNOWN_LISTENER = 4002;
  public static final int WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED = 4008;
  
  public static String getStatusCodeString(int paramInt)
  {
    AppMethodBeat.i(100921);
    switch (paramInt)
    {
    default: 
      String str = CommonStatusCodes.getStatusCodeString(paramInt);
      AppMethodBeat.o(100921);
      return str;
    case 4000: 
      AppMethodBeat.o(100921);
      return "TARGET_NODE_NOT_CONNECTED";
    case 4001: 
      AppMethodBeat.o(100921);
      return "DUPLICATE_LISTENER";
    case 4002: 
      AppMethodBeat.o(100921);
      return "UNKNOWN_LISTENER";
    case 4003: 
      AppMethodBeat.o(100921);
      return "DATA_ITEM_TOO_LARGE";
    case 4004: 
      AppMethodBeat.o(100921);
      return "INVALID_TARGET_NODE";
    }
    AppMethodBeat.o(100921);
    return "ASSET_UNAVAILABLE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableStatusCodes
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static String sS(int paramInt)
  {
    AppMethodBeat.i(144593);
    switch (paramInt)
    {
    default: 
      String str = sT(paramInt);
      AppMethodBeat.o(144593);
      return str;
    case 1: 
      AppMethodBeat.o(144593);
      return "GATT CONN L2C FAILURE";
    case 8: 
      AppMethodBeat.o(144593);
      return "GATT CONN TIMEOUT";
    case 19: 
      AppMethodBeat.o(144593);
      return "GATT CONN TERMINATE PEER USER";
    case 22: 
      AppMethodBeat.o(144593);
      return "GATT CONN TERMINATE LOCAL HOST";
    case 62: 
      AppMethodBeat.o(144593);
      return "GATT CONN FAIL ESTABLISH";
    case 34: 
      AppMethodBeat.o(144593);
      return "GATT CONN LMP TIMEOUT";
    case 256: 
      AppMethodBeat.o(144593);
      return "GATT CONN CANCEL ";
    }
    AppMethodBeat.o(144593);
    return "GATT ERROR";
  }
  
  private static String sT(int paramInt)
  {
    AppMethodBeat.i(144594);
    switch (paramInt)
    {
    default: 
      String str = "UNKNOWN (" + paramInt + ")";
      AppMethodBeat.o(144594);
      return str;
    case 0: 
      AppMethodBeat.o(144594);
      return "GATT SUCCESS";
    case 1: 
      AppMethodBeat.o(144594);
      return "GATT INVALID HANDLE";
    case 2: 
      AppMethodBeat.o(144594);
      return "GATT READ NOT PERMIT";
    case 3: 
      AppMethodBeat.o(144594);
      return "GATT WRITE NOT PERMIT";
    case 4: 
      AppMethodBeat.o(144594);
      return "GATT INVALID PDU";
    case 5: 
      AppMethodBeat.o(144594);
      return "GATT INSUF AUTHENTICATION";
    case 6: 
      AppMethodBeat.o(144594);
      return "GATT REQ NOT SUPPORTED";
    case 7: 
      AppMethodBeat.o(144594);
      return "GATT INVALID OFFSET";
    case 8: 
      AppMethodBeat.o(144594);
      return "GATT INSUF AUTHORIZATION";
    case 9: 
      AppMethodBeat.o(144594);
      return "GATT PREPARE Q FULL";
    case 10: 
      AppMethodBeat.o(144594);
      return "GATT NOT FOUND";
    case 11: 
      AppMethodBeat.o(144594);
      return "GATT NOT LONG";
    case 12: 
      AppMethodBeat.o(144594);
      return "GATT INSUF KEY SIZE";
    case 13: 
      AppMethodBeat.o(144594);
      return "GATT INVALID ATTR LEN";
    case 14: 
      AppMethodBeat.o(144594);
      return "GATT ERR UNLIKELY";
    case 15: 
      AppMethodBeat.o(144594);
      return "GATT INSUF ENCRYPTION";
    case 16: 
      AppMethodBeat.o(144594);
      return "GATT UNSUPPORT GRP TYPE";
    case 17: 
      AppMethodBeat.o(144594);
      return "GATT INSUF RESOURCE";
    case 135: 
      AppMethodBeat.o(144594);
      return "GATT ILLEGAL PARAMETER";
    case 128: 
      AppMethodBeat.o(144594);
      return "GATT NO RESOURCES";
    case 129: 
      AppMethodBeat.o(144594);
      return "GATT INTERNAL ERROR";
    case 130: 
      AppMethodBeat.o(144594);
      return "GATT WRONG STATE";
    case 131: 
      AppMethodBeat.o(144594);
      return "GATT DB FULL";
    case 132: 
      AppMethodBeat.o(144594);
      return "GATT BUSY";
    case 133: 
      AppMethodBeat.o(144594);
      return "GATT ERROR";
    case 134: 
      AppMethodBeat.o(144594);
      return "GATT CMD STARTED";
    case 136: 
      AppMethodBeat.o(144594);
      return "GATT PENDING";
    case 137: 
      AppMethodBeat.o(144594);
      return "GATT AUTH FAIL";
    case 138: 
      AppMethodBeat.o(144594);
      return "GATT MORE";
    case 139: 
      AppMethodBeat.o(144594);
      return "GATT INVALID CFG";
    case 140: 
      AppMethodBeat.o(144594);
      return "GATT SERVICE STARTED";
    case 141: 
      AppMethodBeat.o(144594);
      return "GATT ENCRYPTED NO MITM";
    case 142: 
      AppMethodBeat.o(144594);
      return "GATT NOT ENCRYPTED";
    case 143: 
      AppMethodBeat.o(144594);
      return "GATT CONGESTED";
    case 253: 
      AppMethodBeat.o(144594);
      return "GATT CCCD CFG ERROR";
    case 254: 
      AppMethodBeat.o(144594);
      return "GATT PROCEDURE IN PROGRESS";
    case 255: 
      AppMethodBeat.o(144594);
      return "GATT VALUE OUT OF RANGE";
    }
    AppMethodBeat.o(144594);
    return "GATT FAILURE, TOO MANY OPEN CONNECTIONS";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising$Companion;", "", "()V", "BLE_PERIPHERAL_THREAD_TAG", "", "CTRL_INDEX", "", "NAME", "TAG", "hexCharToInt", "c", "", "hexStringToBytes", "", "s", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$c
{
  public static byte[] hexStringToBytes(String paramString)
  {
    AppMethodBeat.i(329635);
    s.u(paramString, "s");
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)(x(paramString.charAt(i)) << 4 | x(paramString.charAt(i + 1))));
      i += 2;
    }
    AppMethodBeat.o(329635);
    return arrayOfByte;
  }
  
  private static int x(char paramChar)
  {
    int j = 1;
    AppMethodBeat.i(329638);
    int i;
    if ('0' <= paramChar) {
      if (paramChar <= '9') {
        i = 1;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(329638);
      return paramChar - '0';
      i = 0;
      continue;
      i = 0;
    }
    if ('A' <= paramChar) {
      if (paramChar <= 'F') {
        i = 1;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(329638);
      return paramChar - 'A' + 10;
      i = 0;
      continue;
      i = 0;
    }
    if ('a' <= paramChar) {
      if (paramChar <= 'f') {
        i = j;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(329638);
      return paramChar - 'a' + 10;
      i = 0;
      continue;
      i = 0;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid hex char '" + paramChar + '\'');
    AppMethodBeat.o(329638);
    throw localIllegalArgumentException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.g.c
 * JD-Core Version:    0.7.0.1
 */
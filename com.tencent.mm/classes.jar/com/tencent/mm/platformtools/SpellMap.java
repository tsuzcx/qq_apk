package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class SpellMap
{
  public static HashMap<String, String> iuR;
  
  static
  {
    AppMethodBeat.i(132985);
    iuR = new HashMap();
    AppMethodBeat.o(132985);
  }
  
  public static native String spellGetJni(int paramInt1, int paramInt2);
  
  public static String v(char paramChar)
  {
    AppMethodBeat.i(132983);
    int j = w(paramChar);
    if (j < 65536)
    {
      AppMethodBeat.o(132983);
      return String.valueOf(paramChar);
    }
    int i = j >> 16;
    j &= 0xFF;
    if ((i < 129) || (i > 253)) {
      str = null;
    }
    while (str == null)
    {
      AppMethodBeat.o(132983);
      return null;
      if ((j < 63) || (j > 254)) {
        str = null;
      } else {
        str = spellGetJni(i - 129, j - 63);
      }
    }
    String[] arrayOfString = str.split(",");
    if ((arrayOfString == null) || (arrayOfString.length < 2))
    {
      AppMethodBeat.o(132983);
      return str;
    }
    String str = arrayOfString[0];
    AppMethodBeat.o(132983);
    return str;
  }
  
  private static int w(char paramChar)
  {
    AppMethodBeat.i(132984);
    if (paramChar <= '')
    {
      AppMethodBeat.o(132984);
      return paramChar;
    }
    try
    {
      byte[] arrayOfByte = String.valueOf(paramChar).getBytes("GBK");
      if ((arrayOfByte == null) || (arrayOfByte.length > 2) || (arrayOfByte.length <= 0))
      {
        AppMethodBeat.o(132984);
        return 0;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(132984);
      return 0;
    }
    int i;
    if (localUnsupportedEncodingException.length == 1)
    {
      i = localUnsupportedEncodingException[0];
      AppMethodBeat.o(132984);
      return i;
    }
    if (localUnsupportedEncodingException.length == 2)
    {
      i = localUnsupportedEncodingException[0];
      int j = localUnsupportedEncodingException[1];
      AppMethodBeat.o(132984);
      return (i + 256 << 16) + (j + 256);
    }
    AppMethodBeat.o(132984);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.SpellMap
 * JD-Core Version:    0.7.0.1
 */
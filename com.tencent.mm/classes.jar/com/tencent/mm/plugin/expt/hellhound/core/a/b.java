package com.tencent.mm.plugin.expt.hellhound.core.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw;

public final class b
{
  public static void aad(String paramString)
  {
    AppMethodBeat.i(121859);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121859);
      return;
    }
    aw.aKT("_hellhound_mmkv").putLong(paramString, -1L);
    AppMethodBeat.o(121859);
  }
  
  public static byte[] getBytes(String paramString)
  {
    AppMethodBeat.i(121858);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121858);
      return null;
    }
    paramString = aw.aKT("_hellhound_mmkv").decodeBytes(paramString);
    AppMethodBeat.o(121858);
    return paramString;
  }
  
  public static String getString(String paramString)
  {
    AppMethodBeat.i(121861);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121861);
      return null;
    }
    paramString = aw.aKT("_hellhound_mmkv").getString(paramString, null);
    AppMethodBeat.o(121861);
    return paramString;
  }
  
  public static void o(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121857);
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(121857);
      return;
    }
    aw.aKT("_hellhound_mmkv").encode(paramString, paramArrayOfByte);
    AppMethodBeat.o(121857);
  }
  
  public static void putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121860);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(121860);
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    aw.aKT("_hellhound_mmkv").putString(paramString1, str);
    AppMethodBeat.o(121860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.hellhound.core.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;

public final class b
{
  public static void Mg(String paramString)
  {
    AppMethodBeat.i(152259);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(152259);
      return;
    }
    as.apq("_hellhound_mmkv").putLong(paramString, -1L);
    AppMethodBeat.o(152259);
  }
  
  public static byte[] getBytes(String paramString)
  {
    AppMethodBeat.i(73353);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(73353);
      return null;
    }
    paramString = as.apq("_hellhound_mmkv").decodeBytes(paramString);
    AppMethodBeat.o(73353);
    return paramString;
  }
  
  public static String getString(String paramString)
  {
    AppMethodBeat.i(152261);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(152261);
      return null;
    }
    paramString = as.apq("_hellhound_mmkv").getString(paramString, null);
    AppMethodBeat.o(152261);
    return paramString;
  }
  
  public static void putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152260);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(152260);
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    as.apq("_hellhound_mmkv").putString(paramString1, str);
    AppMethodBeat.o(152260);
  }
  
  public static void v(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73352);
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(73352);
      return;
    }
    as.apq("_hellhound_mmkv").encode(paramString, paramArrayOfByte);
    AppMethodBeat.o(73352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.b
 * JD-Core Version:    0.7.0.1
 */
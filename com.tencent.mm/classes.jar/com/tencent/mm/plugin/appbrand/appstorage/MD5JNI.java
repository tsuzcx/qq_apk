package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MD5JNI
{
  public static native int getMD5String(String paramString, String[] paramArrayOfString);
  
  public static String getMD5Wrap(String paramString)
  {
    AppMethodBeat.i(102766);
    String[] arrayOfString = new String[1];
    getMD5String(paramString, arrayOfString);
    paramString = arrayOfString[0];
    AppMethodBeat.o(102766);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.MD5JNI
 * JD-Core Version:    0.7.0.1
 */
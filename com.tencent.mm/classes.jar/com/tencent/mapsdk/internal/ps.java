package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ps
{
  public final String a;
  public final String b;
  public final int c;
  public final String[] d;
  
  public ps(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(225711);
    this.a = paramString1;
    this.b = paramString2;
    if (paramArrayOfString == null) {
      paramString1 = null;
    }
    for (;;)
    {
      this.d = paramString1;
      this.c = paramInt;
      AppMethodBeat.o(225711);
      return;
      paramString1 = new String[paramArrayOfString.length];
      System.arraycopy(paramArrayOfString, 0, paramString1, 0, paramString1.length);
    }
  }
  
  private static String[] a(String[] paramArrayOfString)
  {
    AppMethodBeat.i(225719);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(225719);
      return null;
    }
    String[] arrayOfString = new String[paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, arrayOfString.length);
    AppMethodBeat.o(225719);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ps
 * JD-Core Version:    0.7.0.1
 */
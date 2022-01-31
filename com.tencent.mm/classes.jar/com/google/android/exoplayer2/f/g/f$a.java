package com.google.android.exoplayer2.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class f$a
{
  private static final String[] aXn = new String[0];
  public final String aXo;
  public final String[] aXp;
  public final String name;
  public final int position;
  
  private f$a(String paramString1, int paramInt, String paramString2, String[] paramArrayOfString)
  {
    this.position = paramInt;
    this.name = paramString1;
    this.aXo = paramString2;
    this.aXp = paramArrayOfString;
  }
  
  public static a j(String paramString, int paramInt)
  {
    AppMethodBeat.i(95729);
    Object localObject = paramString.trim();
    if (((String)localObject).isEmpty())
    {
      AppMethodBeat.o(95729);
      return null;
    }
    int i = ((String)localObject).indexOf(" ");
    String str;
    if (i == -1)
    {
      paramString = "";
      localObject = ((String)localObject).split("\\.");
      str = localObject[0];
      if (localObject.length <= 1) {
        break label107;
      }
    }
    label107:
    for (localObject = (String[])Arrays.copyOfRange((Object[])localObject, 1, localObject.length);; localObject = aXn)
    {
      paramString = new a(str, paramInt, paramString, (String[])localObject);
      AppMethodBeat.o(95729);
      return paramString;
      paramString = ((String)localObject).substring(i).trim();
      localObject = ((String)localObject).substring(0, i);
      break;
    }
  }
  
  public static a qf()
  {
    AppMethodBeat.i(95730);
    a locala = new a("", 0, "", new String[0]);
    AppMethodBeat.o(95730);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.f.a
 * JD-Core Version:    0.7.0.1
 */
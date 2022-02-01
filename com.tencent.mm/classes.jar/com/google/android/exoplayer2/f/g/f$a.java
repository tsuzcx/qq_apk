package com.google.android.exoplayer2.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class f$a
{
  private static final String[] bni = new String[0];
  public final String[] bnj;
  public final String name;
  public final int position;
  public final String voice;
  
  private f$a(String paramString1, int paramInt, String paramString2, String[] paramArrayOfString)
  {
    this.position = paramInt;
    this.name = paramString1;
    this.voice = paramString2;
    this.bnj = paramArrayOfString;
  }
  
  public static a p(String paramString, int paramInt)
  {
    AppMethodBeat.i(92897);
    Object localObject = paramString.trim();
    if (((String)localObject).isEmpty())
    {
      AppMethodBeat.o(92897);
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
    for (localObject = (String[])Arrays.copyOfRange((Object[])localObject, 1, localObject.length);; localObject = bni)
    {
      paramString = new a(str, paramInt, paramString, (String[])localObject);
      AppMethodBeat.o(92897);
      return paramString;
      paramString = ((String)localObject).substring(i).trim();
      localObject = ((String)localObject).substring(0, i);
      break;
    }
  }
  
  public static a uy()
  {
    AppMethodBeat.i(92898);
    a locala = new a("", 0, "", new String[0]);
    AppMethodBeat.o(92898);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.f.a
 * JD-Core Version:    0.7.0.1
 */
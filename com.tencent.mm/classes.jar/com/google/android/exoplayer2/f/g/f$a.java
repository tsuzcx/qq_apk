package com.google.android.exoplayer2.f.g;

import java.util.Arrays;

final class f$a
{
  private static final String[] aPT = new String[0];
  public final String aPU;
  public final String[] aPV;
  public final String name;
  public final int position;
  
  private f$a(String paramString1, int paramInt, String paramString2, String[] paramArrayOfString)
  {
    this.position = paramInt;
    this.name = paramString1;
    this.aPU = paramString2;
    this.aPV = paramArrayOfString;
  }
  
  public static a k(String paramString, int paramInt)
  {
    Object localObject = paramString.trim();
    if (((String)localObject).isEmpty()) {
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
        break label90;
      }
    }
    label90:
    for (localObject = (String[])Arrays.copyOfRange((Object[])localObject, 1, localObject.length);; localObject = aPT)
    {
      return new a(str, paramInt, paramString, (String[])localObject);
      paramString = ((String)localObject).substring(i).trim();
      localObject = ((String)localObject).substring(0, i);
      break;
    }
  }
  
  public static a nG()
  {
    return new a("", 0, "", new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.f.a
 * JD-Core Version:    0.7.0.1
 */
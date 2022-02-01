package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.c;
import java.io.IOException;
import java.util.UnknownFormatConversionException;

public class f
{
  static int a = 5;
  static int b = 16;
  static char[] c = new char[b];
  static String d = "dex2oat-cmdline";
  static long e = 4096L;
  
  public static String a(Context paramContext, String paramString)
    throws Exception
  {
    boolean bool = true;
    paramContext = new c(paramString);
    paramContext.a(c);
    if (c[a] == '\001') {}
    for (;;)
    {
      paramContext.a(bool);
      paramContext.a(e);
      return a(new String(a(paramContext)));
      bool = false;
    }
  }
  
  private static String a(String paramString)
  {
    paramString = paramString.split(new String(""));
    int i = 0;
    while (i < paramString.length)
    {
      int j = i + 1;
      Object localObject = paramString[i];
      i = j + 1;
      String str = paramString[j];
      if (localObject.equals(d)) {
        return str;
      }
    }
    return "";
  }
  
  public static char[] a(c paramc)
    throws IOException
  {
    char[] arrayOfChar1 = new char[4];
    char[] arrayOfChar2 = new char[4];
    paramc.a(arrayOfChar1);
    if ((arrayOfChar1[0] != 'o') || (arrayOfChar1[1] != 'a') || (arrayOfChar1[2] != 't')) {
      throw new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", new Object[] { Character.valueOf(arrayOfChar1[0]), Character.valueOf(arrayOfChar1[1]), Character.valueOf(arrayOfChar1[2]) }));
    }
    paramc.a(arrayOfChar2);
    paramc.b();
    paramc.b();
    paramc.b();
    paramc.b();
    paramc.b();
    paramc.b();
    paramc.b();
    paramc.b();
    if (arrayOfChar2[1] <= '4')
    {
      paramc.b();
      paramc.b();
      paramc.b();
    }
    paramc.b();
    paramc.b();
    paramc.b();
    paramc.b();
    paramc.b();
    paramc.b();
    paramc.b();
    arrayOfChar1 = new char[paramc.b()];
    paramc.a(arrayOfChar1);
    return arrayOfChar1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.f
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.metadata.id3.a.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h
{
  public static final a.a aze = new h.1();
  private static final Pattern azf = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
  public int auE = -1;
  public int auF = -1;
  
  public final boolean k(String paramString1, String paramString2)
  {
    if (!"iTunSMPB".equals(paramString1)) {}
    for (;;)
    {
      return false;
      paramString1 = azf.matcher(paramString2);
      if (paramString1.find()) {
        try
        {
          int i = Integer.parseInt(paramString1.group(1), 16);
          int j = Integer.parseInt(paramString1.group(2), 16);
          if ((i > 0) || (j > 0))
          {
            this.auE = i;
            this.auF = j;
            return true;
          }
        }
        catch (NumberFormatException paramString1) {}
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.h
 * JD-Core Version:    0.7.0.1
 */
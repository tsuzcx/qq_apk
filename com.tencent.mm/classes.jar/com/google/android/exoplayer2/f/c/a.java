package com.google.android.exoplayer2.f.c;

import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends b
{
  private static final Pattern aOG = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
  private final boolean aOH;
  private int aOI;
  private int aOJ;
  private int aOK;
  private int aOL;
  
  public a()
  {
    this(null);
  }
  
  public a(List<byte[]> paramList)
  {
    super("SsaDecoder");
    if (paramList != null)
    {
      this.aOH = true;
      String str = new String((byte[])paramList.get(0));
      com.google.android.exoplayer2.i.a.aB(str.startsWith("Format: "));
      ao(str);
      f(new j((byte[])paramList.get(1)));
      return;
    }
    this.aOH = false;
  }
  
  private void a(j paramj, List<com.google.android.exoplayer2.f.a> paramList, e parame)
  {
    Object localObject;
    long l2;
    long l1;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            localObject = paramj.readLine();
            if (localObject == null) {
              break label203;
            }
            if ((this.aOH) || (!((String)localObject).startsWith("Format: "))) {
              break;
            }
            ao((String)localObject);
          }
        } while ((!((String)localObject).startsWith("Dialogue: ")) || (this.aOI == 0));
        localObject = ((String)localObject).substring(10).split(",", this.aOI);
        l2 = ap(localObject[this.aOJ]);
      } while (l2 == -9223372036854775807L);
      String str = localObject[this.aOK];
      if (str.trim().isEmpty()) {
        break label204;
      }
      l1 = ap(str);
    } while (l1 == -9223372036854775807L);
    for (;;)
    {
      paramList.add(new com.google.android.exoplayer2.f.a(localObject[this.aOL].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
      parame.add(l2);
      if (l1 == -9223372036854775807L) {
        break;
      }
      paramList.add(null);
      parame.add(l1);
      break;
      label203:
      return;
      label204:
      l1 = -9223372036854775807L;
    }
  }
  
  private void ao(String paramString)
  {
    paramString = TextUtils.split(paramString.substring(8), ",");
    this.aOI = paramString.length;
    this.aOJ = -1;
    this.aOK = -1;
    this.aOL = -1;
    int j = 0;
    if (j < this.aOI)
    {
      String str = t.aE(paramString[j].trim());
      label92:
      int i;
      switch (str.hashCode())
      {
      default: 
        i = -1;
        label94:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        j += 1;
        break;
        if (!str.equals("start")) {
          break label92;
        }
        i = 0;
        break label94;
        if (!str.equals("end")) {
          break label92;
        }
        i = 1;
        break label94;
        if (!str.equals("text")) {
          break label92;
        }
        i = 2;
        break label94;
        this.aOJ = j;
        continue;
        this.aOK = j;
        continue;
        this.aOL = j;
      }
    }
  }
  
  private static long ap(String paramString)
  {
    paramString = aOG.matcher(paramString);
    if (!paramString.matches()) {
      return -9223372036854775807L;
    }
    long l1 = Long.parseLong(paramString.group(1));
    long l2 = Long.parseLong(paramString.group(2));
    long l3 = Long.parseLong(paramString.group(3));
    return Long.parseLong(paramString.group(4)) * 10000L + (l1 * 60L * 60L * 1000000L + l2 * 60L * 1000000L + l3 * 1000000L);
  }
  
  private static void f(j paramj)
  {
    String str;
    do
    {
      str = paramj.readLine();
    } while ((str != null) && (!str.startsWith("[Events]")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.f.c.a
 * JD-Core Version:    0.7.0.1
 */
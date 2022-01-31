package com.google.android.exoplayer2.f.c;

import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends b
{
  private static final Pattern aWa;
  private final boolean aWb;
  private int aWc;
  private int aWd;
  private int aWe;
  private int aWf;
  
  static
  {
    AppMethodBeat.i(95642);
    aWa = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    AppMethodBeat.o(95642);
  }
  
  public a()
  {
    this(null);
  }
  
  public a(List<byte[]> paramList)
  {
    super("SsaDecoder");
    AppMethodBeat.i(95636);
    if (paramList != null)
    {
      this.aWb = true;
      String str = new String((byte[])paramList.get(0));
      com.google.android.exoplayer2.i.a.checkArgument(str.startsWith("Format: "));
      at(str);
      B(new m((byte[])paramList.get(1)));
      AppMethodBeat.o(95636);
      return;
    }
    this.aWb = false;
    AppMethodBeat.o(95636);
  }
  
  private static void B(m paramm)
  {
    AppMethodBeat.i(95637);
    String str;
    do
    {
      str = paramm.readLine();
      if (str == null) {
        break;
      }
    } while (!str.startsWith("[Events]"));
    AppMethodBeat.o(95637);
    return;
    AppMethodBeat.o(95637);
  }
  
  private void a(m paramm, List<com.google.android.exoplayer2.f.a> paramList, h paramh)
  {
    AppMethodBeat.i(95638);
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
            localObject = paramm.readLine();
            if (localObject == null) {
              break label208;
            }
            if ((this.aWb) || (!((String)localObject).startsWith("Format: "))) {
              break;
            }
            at((String)localObject);
          }
        } while ((!((String)localObject).startsWith("Dialogue: ")) || (this.aWc == 0));
        localObject = ((String)localObject).substring(10).split(",", this.aWc);
        l2 = au(localObject[this.aWd]);
      } while (l2 == -9223372036854775807L);
      String str = localObject[this.aWe];
      if (str.trim().isEmpty()) {
        break label214;
      }
      l1 = au(str);
    } while (l1 == -9223372036854775807L);
    for (;;)
    {
      paramList.add(new com.google.android.exoplayer2.f.a(localObject[this.aWf].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
      paramh.add(l2);
      if (l1 == -9223372036854775807L) {
        break;
      }
      paramList.add(null);
      paramh.add(l1);
      break;
      label208:
      AppMethodBeat.o(95638);
      return;
      label214:
      l1 = -9223372036854775807L;
    }
  }
  
  private void at(String paramString)
  {
    AppMethodBeat.i(95639);
    paramString = TextUtils.split(paramString.substring(8), ",");
    this.aWc = paramString.length;
    this.aWd = -1;
    this.aWe = -1;
    this.aWf = -1;
    int j = 0;
    if (j < this.aWc)
    {
      String str = x.aQ(paramString[j].trim());
      label100:
      int i;
      switch (str.hashCode())
      {
      default: 
        i = -1;
        label102:
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
          break label100;
        }
        i = 0;
        break label102;
        if (!str.equals("end")) {
          break label100;
        }
        i = 1;
        break label102;
        if (!str.equals("text")) {
          break label100;
        }
        i = 2;
        break label102;
        this.aWd = j;
        continue;
        this.aWe = j;
        continue;
        this.aWf = j;
      }
    }
    AppMethodBeat.o(95639);
  }
  
  private static long au(String paramString)
  {
    AppMethodBeat.i(95640);
    paramString = aWa.matcher(paramString);
    if (!paramString.matches())
    {
      AppMethodBeat.o(95640);
      return -9223372036854775807L;
    }
    long l1 = Long.parseLong(paramString.group(1));
    long l2 = Long.parseLong(paramString.group(2));
    long l3 = Long.parseLong(paramString.group(3));
    long l4 = Long.parseLong(paramString.group(4));
    AppMethodBeat.o(95640);
    return l4 * 10000L + (l1 * 60L * 60L * 1000000L + l2 * 60L * 1000000L + l3 * 1000000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.f.c.a
 * JD-Core Version:    0.7.0.1
 */
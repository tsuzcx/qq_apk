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
  private static final Pattern bsc;
  private final boolean bsd;
  private int bse;
  private int bsf;
  private int bsg;
  private int bsh;
  
  static
  {
    AppMethodBeat.i(92810);
    bsc = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    AppMethodBeat.o(92810);
  }
  
  public a()
  {
    this(null);
  }
  
  public a(List<byte[]> paramList)
  {
    super("SsaDecoder");
    AppMethodBeat.i(92804);
    if (paramList != null)
    {
      this.bsd = true;
      String str = new String((byte[])paramList.get(0));
      com.google.android.exoplayer2.i.a.checkArgument(str.startsWith("Format: "));
      ar(str);
      B(new m((byte[])paramList.get(1)));
      AppMethodBeat.o(92804);
      return;
    }
    this.bsd = false;
    AppMethodBeat.o(92804);
  }
  
  private static void B(m paramm)
  {
    AppMethodBeat.i(92805);
    String str;
    do
    {
      str = paramm.readLine();
      if (str == null) {
        break;
      }
    } while (!str.startsWith("[Events]"));
    AppMethodBeat.o(92805);
    return;
    AppMethodBeat.o(92805);
  }
  
  private void a(m paramm, List<com.google.android.exoplayer2.f.a> paramList, h paramh)
  {
    AppMethodBeat.i(92806);
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
            if ((this.bsd) || (!((String)localObject).startsWith("Format: "))) {
              break;
            }
            ar((String)localObject);
          }
        } while ((!((String)localObject).startsWith("Dialogue: ")) || (this.bse == 0));
        localObject = ((String)localObject).substring(10).split(",", this.bse);
        l2 = as(localObject[this.bsf]);
      } while (l2 == -9223372036854775807L);
      String str = localObject[this.bsg];
      if (str.trim().isEmpty()) {
        break label214;
      }
      l1 = as(str);
    } while (l1 == -9223372036854775807L);
    for (;;)
    {
      paramList.add(new com.google.android.exoplayer2.f.a(localObject[this.bsh].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
      paramh.add(l2);
      if (l1 == -9223372036854775807L) {
        break;
      }
      paramList.add(null);
      paramh.add(l1);
      break;
      label208:
      AppMethodBeat.o(92806);
      return;
      label214:
      l1 = -9223372036854775807L;
    }
  }
  
  private void ar(String paramString)
  {
    AppMethodBeat.i(92807);
    paramString = TextUtils.split(paramString.substring(8), ",");
    this.bse = paramString.length;
    this.bsf = -1;
    this.bsg = -1;
    this.bsh = -1;
    int j = 0;
    if (j < this.bse)
    {
      String str = x.aO(paramString[j].trim());
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
        this.bsf = j;
        continue;
        this.bsg = j;
        continue;
        this.bsh = j;
      }
    }
    AppMethodBeat.o(92807);
  }
  
  private static long as(String paramString)
  {
    AppMethodBeat.i(92808);
    paramString = bsc.matcher(paramString);
    if (!paramString.matches())
    {
      AppMethodBeat.o(92808);
      return -9223372036854775807L;
    }
    long l1 = Long.parseLong(paramString.group(1));
    long l2 = Long.parseLong(paramString.group(2));
    long l3 = Long.parseLong(paramString.group(3));
    long l4 = Long.parseLong(paramString.group(4));
    AppMethodBeat.o(92808);
    return l4 * 10000L + (l1 * 60L * 60L * 1000000L + l2 * 60L * 1000000L + l3 * 1000000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.c.a
 * JD-Core Version:    0.7.0.1
 */
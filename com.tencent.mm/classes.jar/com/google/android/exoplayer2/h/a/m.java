package com.google.android.exoplayer2.h.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class m
  extends g
{
  private static final Pattern bwh;
  private static final Pattern bwi;
  private static final Pattern bwj;
  
  static
  {
    AppMethodBeat.i(93032);
    bwh = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    bwi = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    bwj = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);
    AppMethodBeat.o(93032);
  }
  
  m(String paramString, long paramLong1, long paramLong2, long paramLong3, File paramFile)
  {
    super(paramString, paramLong1, paramLong2, paramLong3, paramFile);
  }
  
  public static m a(File paramFile, j paramj)
  {
    AppMethodBeat.i(93031);
    Object localObject2 = paramFile.getName();
    Object localObject1;
    if (!((String)localObject2).endsWith(".v3.exo"))
    {
      localObject1 = paramFile.getName();
      localObject2 = bwi.matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).matches())
      {
        localObject1 = x.aS(((Matcher)localObject2).group(1));
        if (localObject1 == null) {
          localObject1 = null;
        }
      }
      else
      {
        while (localObject1 == null)
        {
          AppMethodBeat.o(93031);
          return null;
          localObject2 = bwh.matcher((CharSequence)localObject1);
          if (!((Matcher)localObject2).matches())
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = ((Matcher)localObject2).group(1);
            localObject2 = a(paramFile.getParentFile(), paramj.az((String)localObject1), Long.parseLong(((Matcher)localObject2).group(2)), Long.parseLong(((Matcher)localObject2).group(3)));
            localObject1 = localObject2;
            if (!paramFile.renameTo((File)localObject2)) {
              localObject1 = null;
            }
          }
        }
      }
    }
    for (paramFile = ((File)localObject1).getName();; paramFile = (File)localObject2)
    {
      paramFile = bwj.matcher(paramFile);
      if (!paramFile.matches())
      {
        AppMethodBeat.o(93031);
        return null;
      }
      long l = ((File)localObject1).length();
      int i = Integer.parseInt(paramFile.group(1));
      paramj = (String)paramj.bvR.get(i);
      if (paramj == null)
      {
        AppMethodBeat.o(93031);
        return null;
      }
      paramFile = new m(paramj, Long.parseLong(paramFile.group(2)), l, Long.parseLong(paramFile.group(3)), (File)localObject1);
      AppMethodBeat.o(93031);
      return paramFile;
      break;
      localObject1 = paramFile;
    }
  }
  
  public static File a(File paramFile, int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93027);
    paramFile = new File(paramFile, paramInt + "." + paramLong1 + "." + paramLong2 + ".v3.exo");
    AppMethodBeat.o(93027);
    return paramFile;
  }
  
  public static m g(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93030);
    paramString = new m(paramString, paramLong1, paramLong2, -9223372036854775807L, null);
    AppMethodBeat.o(93030);
    return paramString;
  }
  
  public static m j(String paramString, long paramLong)
  {
    AppMethodBeat.i(93028);
    paramString = new m(paramString, paramLong, -1L, -9223372036854775807L, null);
    AppMethodBeat.o(93028);
    return paramString;
  }
  
  public static m k(String paramString, long paramLong)
  {
    AppMethodBeat.i(93029);
    paramString = new m(paramString, paramLong, -1L, -9223372036854775807L, null);
    AppMethodBeat.o(93029);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.m
 * JD-Core Version:    0.7.0.1
 */
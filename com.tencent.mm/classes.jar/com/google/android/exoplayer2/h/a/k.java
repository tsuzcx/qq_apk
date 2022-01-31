package com.google.android.exoplayer2.h.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class k
  extends e
{
  private static final Pattern baA;
  private static final Pattern bay;
  private static final Pattern baz;
  
  static
  {
    AppMethodBeat.i(152013);
    bay = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    baz = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    baA = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);
    AppMethodBeat.o(152013);
  }
  
  k(String paramString, long paramLong1, long paramLong2, long paramLong3, File paramFile)
  {
    super(paramString, paramLong1, paramLong2, paramLong3, paramFile);
  }
  
  public static k a(File paramFile, h paramh)
  {
    AppMethodBeat.i(152012);
    Object localObject2 = paramFile.getName();
    Object localObject1;
    if (!((String)localObject2).endsWith(".v3.exo"))
    {
      localObject1 = paramFile.getName();
      localObject2 = baz.matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).matches())
      {
        localObject1 = x.aU(((Matcher)localObject2).group(1));
        if (localObject1 == null) {
          localObject1 = null;
        }
      }
      else
      {
        while (localObject1 == null)
        {
          AppMethodBeat.o(152012);
          return null;
          localObject2 = bay.matcher((CharSequence)localObject1);
          if (!((Matcher)localObject2).matches())
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = ((Matcher)localObject2).group(1);
            localObject2 = a(paramFile.getParentFile(), paramh.aB((String)localObject1), Long.parseLong(((Matcher)localObject2).group(2)), Long.parseLong(((Matcher)localObject2).group(3)));
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
      paramFile = baA.matcher(paramFile);
      if (!paramFile.matches())
      {
        AppMethodBeat.o(152012);
        return null;
      }
      long l = ((File)localObject1).length();
      int i = Integer.parseInt(paramFile.group(1));
      paramh = (String)paramh.bag.get(i);
      if (paramh == null)
      {
        AppMethodBeat.o(152012);
        return null;
      }
      paramFile = new k(paramh, Long.parseLong(paramFile.group(2)), l, Long.parseLong(paramFile.group(3)), (File)localObject1);
      AppMethodBeat.o(152012);
      return paramFile;
      break;
      localObject1 = paramFile;
    }
  }
  
  public static File a(File paramFile, int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(152008);
    paramFile = new File(paramFile, paramInt + "." + paramLong1 + "." + paramLong2 + ".v3.exo");
    AppMethodBeat.o(152008);
    return paramFile;
  }
  
  public static k h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(152011);
    paramString = new k(paramString, paramLong1, paramLong2, -9223372036854775807L, null);
    AppMethodBeat.o(152011);
    return paramString;
  }
  
  public static k j(String paramString, long paramLong)
  {
    AppMethodBeat.i(152009);
    paramString = new k(paramString, paramLong, -1L, -9223372036854775807L, null);
    AppMethodBeat.o(152009);
    return paramString;
  }
  
  public static k k(String paramString, long paramLong)
  {
    AppMethodBeat.i(152010);
    paramString = new k(paramString, paramLong, -1L, -9223372036854775807L, null);
    AppMethodBeat.o(152010);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.k
 * JD-Core Version:    0.7.0.1
 */
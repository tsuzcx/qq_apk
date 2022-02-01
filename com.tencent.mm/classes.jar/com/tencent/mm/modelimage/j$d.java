package com.tencent.mm.modelimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

public final class j$d
{
  public static final ArrayList<j.c> oHy;
  
  static
  {
    AppMethodBeat.i(239001);
    oHy = new ArrayList(3);
    a("", "ImgInfo2", j.SQL_CREATE, 1L, 1000000000L);
    a("@findermsg", "finder_img_info_table", j.NW("finder_img_info_table"), 1000000001L, 1001000001L);
    a("@gamelifesess", "gamelife_img_info_table", j.NW("gamelife_img_info_table"), 1001000002L, 1002000002L);
    AppMethodBeat.o(239001);
  }
  
  public static AtomicLong Of(String paramString)
  {
    AppMethodBeat.i(238991);
    if (paramString == null)
    {
      Log.e("MicroMsg.ImgInfoStorage", "[getIdCreator] talker is null %s", new Object[] { Util.getStack() });
      paramString = ((j.c)oHy.get(0)).oHx;
      AppMethodBeat.o(238991);
      return paramString;
    }
    Iterator localIterator = oHy.iterator();
    while (localIterator.hasNext())
    {
      j.c localc = (j.c)localIterator.next();
      if ((!localc.oHu.isEmpty()) && (paramString.toLowerCase().endsWith(localc.oHu)))
      {
        Log.i("MicroMsg.ImgInfoStorage", "[getIdCreator] table=%s talker=%s", new Object[] { localc.table, paramString });
        paramString = localc.oHx;
        AppMethodBeat.o(238991);
        return paramString;
      }
    }
    Log.i("MicroMsg.ImgInfoStorage", "[getIdCreator] table=%s talker=%s", new Object[] { ((j.c)oHy.get(0)).table, paramString });
    paramString = ((j.c)oHy.get(0)).oHx;
    AppMethodBeat.o(238991);
    return paramString;
  }
  
  public static String Og(String paramString)
  {
    AppMethodBeat.i(238994);
    if (paramString == null)
    {
      Log.e("MicroMsg.ImgInfoStorage", "[getTableByTalker] talker is null %s", new Object[] { Util.getStack() });
      paramString = ((j.c)oHy.get(0)).table;
      AppMethodBeat.o(238994);
      return paramString;
    }
    Iterator localIterator = oHy.iterator();
    while (localIterator.hasNext())
    {
      j.c localc = (j.c)localIterator.next();
      if ((!localc.oHu.isEmpty()) && (paramString.toLowerCase().endsWith(localc.oHu)))
      {
        paramString = localc.table;
        AppMethodBeat.o(238994);
        return paramString;
      }
    }
    Log.i("MicroMsg.ImgInfoStorage", "[getTableByTalker] table=%s talker=%s", new Object[] { ((j.c)oHy.get(0)).table, paramString });
    paramString = ((j.c)oHy.get(0)).table;
    AppMethodBeat.o(238994);
    return paramString;
  }
  
  private static void a(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(238989);
    oHy.add(new j.c(paramString1.toLowerCase(), paramString2, paramArrayOfString, paramLong1, paramLong2));
    AppMethodBeat.o(238989);
  }
  
  public static String iR(long paramLong)
  {
    AppMethodBeat.i(238999);
    Object localObject = oHy.iterator();
    while (((Iterator)localObject).hasNext())
    {
      j.c localc = (j.c)((Iterator)localObject).next();
      if ((localc.oHw[0] <= paramLong) && (paramLong <= localc.oHw[1]))
      {
        localObject = localc.table;
        AppMethodBeat.o(238999);
        return localObject;
      }
    }
    Log.i("MicroMsg.ImgInfoStorage", "[getTableById] table=%s id=%s", new Object[] { ((j.c)oHy.get(0)).table, Long.valueOf(paramLong) });
    localObject = ((j.c)oHy.get(0)).table;
    AppMethodBeat.o(238999);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelimage.j.d
 * JD-Core Version:    0.7.0.1
 */
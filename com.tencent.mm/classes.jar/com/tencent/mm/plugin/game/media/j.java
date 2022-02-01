package com.tencent.mm.plugin.game.media;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class j
{
  private static Object lock;
  private static j sZX;
  ContentResolver gne;
  
  static
  {
    AppMethodBeat.i(41033);
    lock = new Object();
    AppMethodBeat.o(41033);
  }
  
  private j()
  {
    AppMethodBeat.i(41030);
    this.gne = ai.getContext().getContentResolver();
    AppMethodBeat.o(41030);
  }
  
  public static String a(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(41031);
    if (bs.gY(paramLinkedList)) {}
    StringBuilder localStringBuilder;
    for (paramLinkedList = "()";; paramLinkedList = localStringBuilder.toString())
    {
      paramLinkedList = String.format("%s in %s and %s<=%d AND %s>=%d", new Object[] { "bucket_display_name", paramLinkedList, "datetaken", Long.valueOf(paramLong1), "datetaken", Long.valueOf(paramLong2) });
      ac.d("MicroMsg.GameLocalVideoQuery", "where %s", new Object[] { paramLinkedList });
      AppMethodBeat.o(41031);
      return paramLinkedList;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      int j = paramLinkedList.size();
      int i = 0;
      while (i < j - 1)
      {
        localStringBuilder.append("\"" + (String)paramLinkedList.get(i) + "\"").append(",");
        i += 1;
      }
      localStringBuilder.append("\"" + (String)paramLinkedList.get(j - 1) + "\"").append(")");
    }
  }
  
  public static j cPs()
  {
    AppMethodBeat.i(41029);
    if (sZX == null) {}
    synchronized (lock)
    {
      if (sZX == null) {
        sZX = new j();
      }
      ??? = sZX;
      AppMethodBeat.o(41029);
      return ???;
    }
  }
  
  public static Uri cPt()
  {
    return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
  }
  
  public static String cPu()
  {
    return "datetaken desc";
  }
  
  public static String[] getProjection()
  {
    return new String[] { "_data", "datetaken", "date_modified", "duration", "description", "mime_type", "title", "_size", "bucket_display_name" };
  }
  
  public final int b(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(41032);
    ContentResolver localContentResolver = this.gne;
    Uri localUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    paramLinkedList = a(paramLinkedList, paramLong1, paramLong2);
    paramLinkedList = localContentResolver.query(localUri, new String[] { "count(*)" }, paramLinkedList, null, null);
    if ((paramLinkedList == null) || (!paramLinkedList.moveToNext()))
    {
      AppMethodBeat.o(41032);
      return 0;
    }
    int i = paramLinkedList.getInt(0);
    paramLinkedList.close();
    AppMethodBeat.o(41032);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.j
 * JD-Core Version:    0.7.0.1
 */
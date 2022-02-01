package com.tencent.mm.plugin.game.media;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class j
{
  private static j Izo;
  private static Object lock;
  ContentResolver mJn;
  
  static
  {
    AppMethodBeat.i(41033);
    lock = new Object();
    AppMethodBeat.o(41033);
  }
  
  private j()
  {
    AppMethodBeat.i(41030);
    this.mJn = MMApplicationContext.getContext().getContentResolver();
    AppMethodBeat.o(41030);
  }
  
  public static String a(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(41031);
    if (Util.isNullOrNil(paramLinkedList)) {}
    StringBuilder localStringBuilder;
    for (paramLinkedList = "()";; paramLinkedList = localStringBuilder.toString())
    {
      paramLinkedList = String.format("%s in %s and %s<=%d AND %s>=%d", new Object[] { "bucket_display_name", paramLinkedList, "datetaken", Long.valueOf(paramLong1), "datetaken", Long.valueOf(paramLong2) });
      Log.d("MicroMsg.GameLocalVideoQuery", "where %s", new Object[] { paramLinkedList });
      AppMethodBeat.o(41031);
      return paramLinkedList;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      int j = paramLinkedList.size();
      int i = 0;
      while (i < j - 1)
      {
        localStringBuilder.append("'" + (String)paramLinkedList.get(i) + "'").append(",");
        i += 1;
      }
      localStringBuilder.append("'" + (String)paramLinkedList.get(j - 1) + "'").append(")");
    }
  }
  
  public static j fFs()
  {
    AppMethodBeat.i(41029);
    if (Izo == null) {}
    synchronized (lock)
    {
      if (Izo == null) {
        Izo = new j();
      }
      ??? = Izo;
      AppMethodBeat.o(41029);
      return ???;
    }
  }
  
  public static Uri fFt()
  {
    return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
  }
  
  public static String fFu()
  {
    return "datetaken desc";
  }
  
  public static String[] fzV()
  {
    return new String[] { "_data", "datetaken", "date_modified", "duration", "description", "mime_type", "title", "_size", "bucket_display_name" };
  }
  
  public final int b(LinkedList<String> paramLinkedList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(41032);
    ContentResolver localContentResolver = this.mJn;
    Uri localUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    paramLinkedList = a(paramLinkedList, paramLong1, paramLong2);
    paramLinkedList = localContentResolver.query(localUri, new String[] { "_id" }, paramLinkedList, null, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.j
 * JD-Core Version:    0.7.0.1
 */
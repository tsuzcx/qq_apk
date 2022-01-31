package com.tencent.mm.plugin.cdndownloader.f;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class c
  extends i<a>
{
  public static final String[] dXp = { i.a(a.buS, "CdnDownloadInfo") };
  
  public c(e parame)
  {
    super(parame, a.buS, "CdnDownloadInfo", null);
  }
  
  public final a zk(String paramString)
  {
    Object localObject = null;
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=%s", new Object[] { "CdnDownloadInfo", "downloadUrlHashCode", Integer.valueOf(paramString.hashCode()) }), new String[0]);
    paramString = localObject;
    if (localCursor == null) {
      return null;
    }
    while (localCursor.moveToNext())
    {
      paramString = new a();
      paramString.d(localCursor);
    }
    localCursor.close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.f.c
 * JD-Core Version:    0.7.0.1
 */
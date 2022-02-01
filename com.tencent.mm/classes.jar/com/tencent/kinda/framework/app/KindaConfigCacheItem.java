package com.tencent.kinda.framework.app;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ee;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class KindaConfigCacheItem
  extends ee
{
  private static final String TAG = "MicroMsg.KindaConfigCacheItem";
  public static final int TYPE_BOOLEAN = 4;
  public static final int TYPE_BYTE = 7;
  public static final int TYPE_DOUBLE = 6;
  public static final int TYPE_FLOAT = 5;
  public static final int TYPE_INT = 1;
  public static final int TYPE_LONG = 2;
  public static final int TYPE_STRING = 3;
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(18392);
    info = ee.initAutoDBInfo(ee.class);
    AppMethodBeat.o(18392);
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(18391);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(18391);
  }
  
  public ContentValues convertTo()
  {
    AppMethodBeat.i(18390);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(18390);
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaConfigCacheItem
 * JD-Core Version:    0.7.0.1
 */
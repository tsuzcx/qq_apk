package com.tencent.kinda.framework.app;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ct;
import com.tencent.mm.sdk.e.c.a;

public class KindaConfigCacheItem
  extends ct
{
  private static final String TAG = "MicroMsg.KindaConfigCacheItem";
  public static final int TYPE_BOOLEAN = 4;
  public static final int TYPE_BYTE = 7;
  public static final int TYPE_DOUBLE = 6;
  public static final int TYPE_FLOAT = 5;
  public static final int TYPE_INT = 1;
  public static final int TYPE_LONG = 2;
  public static final int TYPE_STRING = 3;
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(144320);
    info = ct.initAutoDBInfo(ct.class);
    AppMethodBeat.o(144320);
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(144319);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(144319);
  }
  
  public ContentValues convertTo()
  {
    AppMethodBeat.i(144318);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(144318);
    return localContentValues;
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaConfigCacheItem
 * JD-Core Version:    0.7.0.1
 */
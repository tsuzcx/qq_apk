package com.tencent.kinda.framework.app;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ed;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class KindaCacheItem
  extends ed
{
  private static final String TAG = "MicroMsg.KindaCacheItem";
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(18386);
    info = ed.initAutoDBInfo(ed.class);
    AppMethodBeat.o(18386);
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(18385);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(18385);
  }
  
  public ContentValues convertTo()
  {
    AppMethodBeat.i(18384);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(18384);
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaCacheItem
 * JD-Core Version:    0.7.0.1
 */
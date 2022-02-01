package com.tencent.kinda.framework.app;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dt;
import com.tencent.mm.sdk.e.c.a;

public class KindaCacheItem
  extends dt
{
  private static final String TAG = "MicroMsg.KindaCacheItem";
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(18386);
    info = dt.initAutoDBInfo(dt.class);
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
  
  public c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaCacheItem
 * JD-Core Version:    0.7.0.1
 */
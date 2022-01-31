package com.tencent.kinda.framework.app;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cs;
import com.tencent.mm.sdk.e.c.a;

public class KindaCacheItem
  extends cs
{
  private static final String TAG = "MicroMsg.KindaCacheItem";
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(144314);
    info = cs.initAutoDBInfo(cs.class);
    AppMethodBeat.o(144314);
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(144313);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(144313);
  }
  
  public ContentValues convertTo()
  {
    AppMethodBeat.i(144312);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(144312);
    return localContentValues;
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaCacheItem
 * JD-Core Version:    0.7.0.1
 */
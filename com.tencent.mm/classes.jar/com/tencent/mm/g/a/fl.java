package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fl
  extends b
{
  public a dfe;
  public b dff;
  
  public fl()
  {
    this((byte)0);
  }
  
  private fl(byte paramByte)
  {
    AppMethodBeat.i(19804);
    this.dfe = new a();
    this.dff = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(19804);
  }
  
  public static final class a
  {
    public String[] cYr;
    public Context context;
    public int dfg = 0;
    public String[] selectionArgs;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor dfh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.fl
 * JD-Core Version:    0.7.0.1
 */
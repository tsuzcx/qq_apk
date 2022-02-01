package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fr
  extends b
{
  public a dfL;
  public b dfM;
  
  public fr()
  {
    this((byte)0);
  }
  
  private fr(byte paramByte)
  {
    AppMethodBeat.i(19807);
    this.dfL = new a();
    this.dfM = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(19807);
  }
  
  public static final class a
  {
    public String appId;
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
 * Qualified Name:     com.tencent.mm.g.a.fr
 * JD-Core Version:    0.7.0.1
 */
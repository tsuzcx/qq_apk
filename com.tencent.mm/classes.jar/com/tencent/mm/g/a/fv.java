package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fv
  extends b
{
  public a dsm;
  public b dsn;
  
  public fv()
  {
    this((byte)0);
  }
  
  private fv(byte paramByte)
  {
    AppMethodBeat.i(19807);
    this.dsm = new a();
    this.dsn = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(19807);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public String[] dkL;
    public int drH = 0;
    public String[] selectionArgs;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor drI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.fv
 * JD-Core Version:    0.7.0.1
 */
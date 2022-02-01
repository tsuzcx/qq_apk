package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fq
  extends b
{
  public a diq;
  public b dir;
  
  public fq()
  {
    this((byte)0);
  }
  
  private fq(byte paramByte)
  {
    AppMethodBeat.i(19807);
    this.diq = new a();
    this.dir = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(19807);
  }
  
  public static final class a
  {
    public String appId;
    public Context context;
    public String[] daV;
    public int dhL = 0;
    public String[] selectionArgs;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor dhM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.fq
 * JD-Core Version:    0.7.0.1
 */
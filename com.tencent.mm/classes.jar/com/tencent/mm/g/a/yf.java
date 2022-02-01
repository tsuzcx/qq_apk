package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class yf
  extends b
{
  public a dBI;
  public b dBJ;
  
  public yf()
  {
    this((byte)0);
  }
  
  private yf(byte paramByte)
  {
    AppMethodBeat.i(19848);
    this.dBI = new a();
    this.dBJ = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(19848);
  }
  
  public static final class a
  {
    public String callingPackage;
    public Context context;
    public int dfg = 0;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor dfh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.yf
 * JD-Core Version:    0.7.0.1
 */
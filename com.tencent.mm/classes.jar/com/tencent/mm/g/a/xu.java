package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class xu
  extends b
{
  public a dDW;
  public b dDX;
  
  public xu()
  {
    this((byte)0);
  }
  
  private xu(byte paramByte)
  {
    AppMethodBeat.i(19848);
    this.dDW = new a();
    this.dDX = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(19848);
  }
  
  public static final class a
  {
    public String callingPackage;
    public Context context;
    public int dhL = 0;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor dhM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.xu
 * JD-Core Version:    0.7.0.1
 */
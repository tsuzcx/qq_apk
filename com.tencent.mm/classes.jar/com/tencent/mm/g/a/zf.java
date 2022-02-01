package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class zf
  extends b
{
  public a dPl;
  public b dPm;
  
  public zf()
  {
    this((byte)0);
  }
  
  private zf(byte paramByte)
  {
    AppMethodBeat.i(19848);
    this.dPl = new a();
    this.dPm = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(19848);
  }
  
  public static final class a
  {
    public String callingPackage;
    public Context context;
    public int drH = 0;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor drI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.zf
 * JD-Core Version:    0.7.0.1
 */
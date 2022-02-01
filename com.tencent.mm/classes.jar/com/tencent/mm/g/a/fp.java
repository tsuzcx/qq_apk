package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fp
  extends b
{
  public a drF;
  public b drG;
  
  public fp()
  {
    this((byte)0);
  }
  
  private fp(byte paramByte)
  {
    AppMethodBeat.i(19804);
    this.drF = new a();
    this.drG = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(19804);
  }
  
  public static final class a
  {
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
 * Qualified Name:     com.tencent.mm.g.a.fp
 * JD-Core Version:    0.7.0.1
 */
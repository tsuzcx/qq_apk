package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fk
  extends b
{
  public a dhJ;
  public b dhK;
  
  public fk()
  {
    this((byte)0);
  }
  
  private fk(byte paramByte)
  {
    AppMethodBeat.i(19804);
    this.dhJ = new a();
    this.dhK = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(19804);
  }
  
  public static final class a
  {
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
 * Qualified Name:     com.tencent.mm.g.a.fk
 * JD-Core Version:    0.7.0.1
 */
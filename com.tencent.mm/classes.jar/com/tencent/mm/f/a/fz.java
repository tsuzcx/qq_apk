package com.tencent.mm.f.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fz
  extends IEvent
{
  public a fBI;
  public b fBJ;
  
  public fz()
  {
    this((byte)0);
  }
  
  private fz(byte paramByte)
  {
    AppMethodBeat.i(19804);
    this.fBI = new a();
    this.fBJ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19804);
  }
  
  public static final class a
  {
    public Context context;
    public int fBK = 0;
    public String[] fuA;
    public String[] fuz;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor fBL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.fz
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abr
  extends IEvent
{
  public b gbA;
  public a gbz;
  
  public abr()
  {
    this((byte)0);
  }
  
  private abr(byte paramByte)
  {
    AppMethodBeat.i(19848);
    this.gbz = new a();
    this.gbA = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19848);
  }
  
  public static final class a
  {
    public String callingPackage;
    public Context context;
    public int fBK = 0;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor fBL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.abr
 * JD-Core Version:    0.7.0.1
 */
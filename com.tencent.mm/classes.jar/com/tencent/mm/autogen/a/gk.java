package com.tencent.mm.autogen.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gk
  extends IEvent
{
  public a hGx;
  public b hGy;
  
  public gk()
  {
    this((byte)0);
  }
  
  private gk(byte paramByte)
  {
    AppMethodBeat.i(19804);
    this.hGx = new a();
    this.hGy = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19804);
  }
  
  public static final class a
  {
    public Context context;
    public int hGz = 0;
    public String[] hyR;
    public String[] hyS;
    public Uri uri;
  }
  
  public static final class b
  {
    public Cursor hGA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gk
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gm
  extends IEvent
{
  public a hGF;
  public b hGG;
  
  public gm()
  {
    this((byte)0);
  }
  
  private gm(byte paramByte)
  {
    AppMethodBeat.i(116016);
    this.hGF = new a();
    this.hGG = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116016);
  }
  
  public static final class a
  {
    public String hGH;
  }
  
  public static final class b
  {
    public Cursor hGA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gm
 * JD-Core Version:    0.7.0.1
 */
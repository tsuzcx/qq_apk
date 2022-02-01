package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.sdk.event.IEvent;

public final class gp
  extends IEvent
{
  public a hGY;
  public b hGZ;
  
  public gp()
  {
    this((byte)0);
  }
  
  private gp(byte paramByte)
  {
    AppMethodBeat.i(116018);
    this.hGY = new a();
    this.hGZ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116018);
  }
  
  public static final class a
  {
    public String content;
    public int flags;
    public String hHa;
    public int type;
  }
  
  public static final class b
  {
    public p hHb;
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gp
 * JD-Core Version:    0.7.0.1
 */
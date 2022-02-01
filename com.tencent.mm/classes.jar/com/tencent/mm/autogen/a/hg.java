package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hg
  extends IEvent
{
  public a hIb;
  public b hIc;
  
  public hg()
  {
    this((byte)0);
  }
  
  private hg(byte paramByte)
  {
    AppMethodBeat.i(127288);
    this.hIb = new a();
    this.hIc = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127288);
  }
  
  public static final class a
  {
    public int hId = 0;
    public int state = -1;
    public String talker;
  }
  
  public static final class b
  {
    public int state = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.hg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wp
  extends IEvent
{
  public a iak;
  
  public wp()
  {
    this((byte)0);
  }
  
  private wp(byte paramByte)
  {
    AppMethodBeat.i(116048);
    this.iak = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116048);
  }
  
  public static final class a
  {
    public String content;
    public int flags;
    public String hgl;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.wp
 * JD-Core Version:    0.7.0.1
 */
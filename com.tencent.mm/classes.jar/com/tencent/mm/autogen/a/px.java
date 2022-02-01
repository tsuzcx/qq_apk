package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class px
  extends IEvent
{
  public a hTc;
  
  public px()
  {
    this((byte)0);
  }
  
  private px(byte paramByte)
  {
    AppMethodBeat.i(125622);
    this.hTc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125622);
  }
  
  public static final class a
  {
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.px
 * JD-Core Version:    0.7.0.1
 */
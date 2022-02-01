package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.IEvent;

public final class ap
  extends IEvent
{
  public a hAn;
  
  public ap()
  {
    this((byte)0);
  }
  
  private ap(byte paramByte)
  {
    AppMethodBeat.i(149852);
    this.hAn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149852);
  }
  
  public static final class a
  {
    public b hAo;
    public boolean independent = true;
    public int level = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ap
 * JD-Core Version:    0.7.0.1
 */
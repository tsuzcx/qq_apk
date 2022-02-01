package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.sdk.event.IEvent;

public final class hf
  extends IEvent
{
  public a dLI;
  
  public hf()
  {
    this((byte)0);
  }
  
  private hf(byte paramByte)
  {
    AppMethodBeat.i(168628);
    this.dLI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168628);
  }
  
  public static final class a
  {
    public g contact;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hf
 * JD-Core Version:    0.7.0.1
 */
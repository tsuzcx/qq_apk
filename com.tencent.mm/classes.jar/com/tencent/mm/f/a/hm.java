package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.sdk.event.IEvent;

public final class hm
  extends IEvent
{
  public a fEx;
  
  public hm()
  {
    this((byte)0);
  }
  
  private hm(byte paramByte)
  {
    AppMethodBeat.i(168628);
    this.fEx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168628);
  }
  
  public static final class a
  {
    public i contact;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.hm
 * JD-Core Version:    0.7.0.1
 */
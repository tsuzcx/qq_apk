package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ads
  extends IEvent
{
  public a iic;
  
  public ads()
  {
    this((byte)0);
  }
  
  private ads(byte paramByte)
  {
    AppMethodBeat.i(104423);
    this.iic = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104423);
  }
  
  public static final class a
  {
    public int hAf;
    public String[] iid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ads
 * JD-Core Version:    0.7.0.1
 */
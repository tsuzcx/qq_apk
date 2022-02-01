package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rb
  extends IEvent
{
  public a hUc;
  
  public rb()
  {
    this((byte)0);
  }
  
  private rb(byte paramByte)
  {
    AppMethodBeat.i(116038);
    this.hUc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116038);
  }
  
  public static final class a
  {
    public String hEl;
    public int hFs;
    public String hQA;
    public int op = 0;
    public int reason;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.rb
 * JD-Core Version:    0.7.0.1
 */
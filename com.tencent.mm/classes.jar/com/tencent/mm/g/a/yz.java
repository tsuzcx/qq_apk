package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yz
  extends IEvent
{
  public a efi;
  
  public yz()
  {
    this((byte)0);
  }
  
  private yz(byte paramByte)
  {
    AppMethodBeat.i(19844);
    this.efi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19844);
  }
  
  public static final class a
  {
    public int action;
    public int efj;
    public String result;
    public String userCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.yz
 * JD-Core Version:    0.7.0.1
 */
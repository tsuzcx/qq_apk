package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pk
  extends IEvent
{
  public a hSD;
  
  public pk()
  {
    this((byte)0);
  }
  
  private pk(byte paramByte)
  {
    AppMethodBeat.i(131792);
    this.hSD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131792);
  }
  
  public static final class a
  {
    public int hSE = 0;
    public boolean hSF = false;
    public String hSG;
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pk
 * JD-Core Version:    0.7.0.1
 */
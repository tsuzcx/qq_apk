package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ud
  extends IEvent
{
  public a eax;
  
  public ud()
  {
    this((byte)0);
  }
  
  private ud(byte paramByte)
  {
    AppMethodBeat.i(121035);
    this.eax = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121035);
  }
  
  public static final class a
  {
    public String dNA;
    public Boolean eay;
    public Boolean eaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ud
 * JD-Core Version:    0.7.0.1
 */
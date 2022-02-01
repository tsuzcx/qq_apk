package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class us
  extends IEvent
{
  public a eaU;
  public b eaV;
  
  public us()
  {
    this((byte)0);
  }
  
  private us(byte paramByte)
  {
    AppMethodBeat.i(153185);
    this.eaU = new a();
    this.eaV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153185);
  }
  
  public static final class a
  {
    public boolean eaW;
  }
  
  public static final class b
  {
    public boolean eaX;
    public boolean eaY;
    public boolean eaZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.us
 * JD-Core Version:    0.7.0.1
 */
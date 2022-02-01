package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fc
  extends IEvent
{
  public a dIv;
  public b dIw;
  
  public fc()
  {
    this((byte)0);
  }
  
  private fc(byte paramByte)
  {
    AppMethodBeat.i(19795);
    this.dIv = new a();
    this.dIw = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19795);
  }
  
  public static final class a
  {
    public String dIx;
    public long dIy;
    public String mac;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.fc
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zw
  extends IEvent
{
  public a fZf;
  
  public zw()
  {
    this((byte)0);
  }
  
  private zw(byte paramByte)
  {
    AppMethodBeat.i(153188);
    this.fZf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153188);
  }
  
  public static final class a
  {
    public int fZg;
    public boolean fZh = false;
    public boolean fZi = false;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.zw
 * JD-Core Version:    0.7.0.1
 */
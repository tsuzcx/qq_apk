package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zv
  extends IEvent
{
  public a fZc;
  
  public zv()
  {
    this((byte)0);
  }
  
  private zv(byte paramByte)
  {
    AppMethodBeat.i(155376);
    this.fZc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155376);
  }
  
  public static final class a
  {
    public boolean fZd = false;
    public boolean fZe = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.zv
 * JD-Core Version:    0.7.0.1
 */
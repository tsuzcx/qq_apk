package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kg
  extends IEvent
{
  public a fHH;
  public b fHI;
  
  public kg()
  {
    this((byte)0);
  }
  
  private kg(byte paramByte)
  {
    AppMethodBeat.i(91207);
    this.fHH = new a();
    this.fHI = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91207);
  }
  
  public static final class a
  {
    public int fHJ = 0;
  }
  
  public static final class b
  {
    public boolean fHK = false;
    public String fHL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.kg
 * JD-Core Version:    0.7.0.1
 */
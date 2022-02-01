package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mo
  extends IEvent
{
  public a fKK;
  
  public mo()
  {
    this((byte)0);
  }
  
  private mo(byte paramByte)
  {
    AppMethodBeat.i(149869);
    this.fKK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149869);
  }
  
  public static final class a
  {
    public String filePath;
    public int fxC;
    public boolean fxE = false;
    public int subType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.mo
 * JD-Core Version:    0.7.0.1
 */
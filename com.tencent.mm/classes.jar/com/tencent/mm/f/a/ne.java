package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ne
  extends IEvent
{
  public a fLx;
  public b fLy;
  
  public ne()
  {
    this((byte)0);
  }
  
  private ne(byte paramByte)
  {
    AppMethodBeat.i(149871);
    this.fLx = new a();
    this.fLy = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149871);
  }
  
  public static final class a
  {
    public int action;
    public int fLz;
    public String filePath;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.ne
 * JD-Core Version:    0.7.0.1
 */
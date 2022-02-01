package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class az
  extends IEvent
{
  public a fwJ;
  
  public az()
  {
    this((byte)0);
  }
  
  private az(byte paramByte)
  {
    AppMethodBeat.i(115970);
    this.fwJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115970);
  }
  
  public static final class a
  {
    public String filePath;
    public long fwK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.az
 * JD-Core Version:    0.7.0.1
 */
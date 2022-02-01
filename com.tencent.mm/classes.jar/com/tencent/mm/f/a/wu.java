package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wu
  extends IEvent
{
  public a fVO;
  
  public wu()
  {
    this((byte)0);
  }
  
  private wu(byte paramByte)
  {
    AppMethodBeat.i(125639);
    this.fVO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125639);
  }
  
  public static final class a
  {
    public String fAg;
    public String fLp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.wu
 * JD-Core Version:    0.7.0.1
 */
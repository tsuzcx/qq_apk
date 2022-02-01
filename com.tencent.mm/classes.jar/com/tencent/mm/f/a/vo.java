package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vo
  extends IEvent
{
  public a fUJ;
  public b fUK;
  
  public vo()
  {
    this((byte)0);
  }
  
  private vo(byte paramByte)
  {
    AppMethodBeat.i(93327);
    this.fUJ = new a();
    this.fUK = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93327);
  }
  
  public static final class a
  {
    public String fUL;
    public String fUM;
    public int fUN = 0;
  }
  
  public static final class b
  {
    public String fUL;
    public boolean isSuccess = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.vo
 * JD-Core Version:    0.7.0.1
 */
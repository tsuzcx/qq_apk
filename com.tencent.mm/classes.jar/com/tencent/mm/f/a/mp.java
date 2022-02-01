package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class mp
  extends IEvent
{
  public a fKL;
  public b fKM;
  
  public mp()
  {
    this((byte)0);
  }
  
  private mp(byte paramByte)
  {
    AppMethodBeat.i(55664);
    this.fKL = new a();
    this.fKM = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(55664);
  }
  
  public static final class a
  {
    public int fKG = 0;
    public boolean fKN = false;
    public ca fvt;
    public String language;
  }
  
  public static final class b
  {
    public String fGw;
    public String fKO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.mp
 * JD-Core Version:    0.7.0.1
 */
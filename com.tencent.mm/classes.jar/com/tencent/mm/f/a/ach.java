package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class ach
  extends IEvent
{
  public a gcw;
  
  public ach()
  {
    this((byte)0);
  }
  
  private ach(byte paramByte)
  {
    AppMethodBeat.i(110508);
    this.gcw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(110508);
  }
  
  public static final class a
  {
    public int fvK;
    public int gcA = 0;
    public int gcB = 0;
    public List gcC;
    public String gcx;
    public boolean gcy = false;
    public int gcz = 0;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ach
 * JD-Core Version:    0.7.0.1
 */
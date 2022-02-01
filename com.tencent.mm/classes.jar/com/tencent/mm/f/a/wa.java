package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wa
  extends IEvent
{
  public a fVd;
  public b fVe;
  
  public wa()
  {
    this((byte)0);
  }
  
  private wa(byte paramByte)
  {
    AppMethodBeat.i(125631);
    this.fVd = new a();
    this.fVe = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125631);
  }
  
  public static final class a
  {
    public boolean fVf;
    public String fVg;
    public boolean fVh = false;
    public int type;
    public String videoPath;
  }
  
  public static final class b
  {
    public String fVg;
    public String fVi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wa
 * JD-Core Version:    0.7.0.1
 */
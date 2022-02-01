package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fj
  extends IEvent
{
  public a fBm;
  public b fBn;
  
  public fj()
  {
    this((byte)0);
  }
  
  private fj(byte paramByte)
  {
    AppMethodBeat.i(19795);
    this.fBm = new a();
    this.fBn = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19795);
  }
  
  public static final class a
  {
    public String fBo;
    public long fBp;
    public String mac;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.fj
 * JD-Core Version:    0.7.0.1
 */
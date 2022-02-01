package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fq
  extends IEvent
{
  public b fBA;
  public a fBz;
  
  public fq()
  {
    this((byte)0);
  }
  
  private fq(byte paramByte)
  {
    AppMethodBeat.i(19802);
    this.fBz = new a();
    this.fBA = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19802);
  }
  
  public static final class a
  {
    public byte[] data;
    public String fzM;
    public String mac;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.fq
 * JD-Core Version:    0.7.0.1
 */
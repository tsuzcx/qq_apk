package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fe
  extends IEvent
{
  public a fBa;
  public b fBb;
  
  public fe()
  {
    this((byte)0);
  }
  
  private fe(byte paramByte)
  {
    AppMethodBeat.i(116007);
    this.fBa = new a();
    this.fBb = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116007);
  }
  
  public static final class a
  {
    public String data;
    public String fzB;
    public String fzM;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.fe
 * JD-Core Version:    0.7.0.1
 */
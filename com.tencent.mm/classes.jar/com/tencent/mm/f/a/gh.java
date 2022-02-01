package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gh
  extends IEvent
{
  public a fCu;
  public b fCv;
  
  public gh()
  {
    this((byte)0);
  }
  
  private gh(byte paramByte)
  {
    AppMethodBeat.i(116020);
    this.fCu = new a();
    this.fCv = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116020);
  }
  
  public static final class a
  {
    public int op;
    public String username;
  }
  
  public static final class b
  {
    public String fileName;
    public boolean fyl = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.gh
 * JD-Core Version:    0.7.0.1
 */
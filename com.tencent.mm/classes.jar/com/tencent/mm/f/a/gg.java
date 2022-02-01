package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.k.a;
import com.tencent.mm.an.k.b;
import com.tencent.mm.sdk.event.IEvent;

public final class gg
  extends IEvent
{
  public a fCp;
  public b fCq;
  
  public gg()
  {
    this((byte)0);
  }
  
  private gg(byte paramByte)
  {
    AppMethodBeat.i(116019);
    this.fCp = new a();
    this.fCq = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116019);
  }
  
  public static final class a
  {
    public boolean fCr = false;
    public k.a fCs;
    public k.b fCt;
    public String fileName;
    public boolean fmm;
    public int op;
  }
  
  public static final class b
  {
    public boolean fyl = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.gg
 * JD-Core Version:    0.7.0.1
 */
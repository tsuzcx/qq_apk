package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class el
  extends IEvent
{
  public a fAk;
  public b fAl;
  
  public el()
  {
    this((byte)0);
  }
  
  private el(byte paramByte)
  {
    AppMethodBeat.i(115988);
    this.fAk = new a();
    this.fAl = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115988);
  }
  
  public static final class a
  {
    public String fAm;
    public String fzB;
    public String fzM;
    public int type;
  }
  
  public static final class b
  {
    public boolean fAn;
    public String fAo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.el
 * JD-Core Version:    0.7.0.1
 */
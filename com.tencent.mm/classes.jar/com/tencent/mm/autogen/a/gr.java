package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j.a;
import com.tencent.mm.am.j.b;
import com.tencent.mm.sdk.event.IEvent;

public final class gr
  extends IEvent
{
  public a hHe;
  public b hHf;
  
  public gr()
  {
    this((byte)0);
  }
  
  private gr(byte paramByte)
  {
    AppMethodBeat.i(116019);
    this.hHe = new a();
    this.hHf = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116019);
  }
  
  public static final class a
  {
    public String fileName;
    public boolean hHg = false;
    public j.a hHh;
    public j.b hHi;
    public boolean hqB;
    public int op;
  }
  
  public static final class b
  {
    public boolean hCQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gr
 * JD-Core Version:    0.7.0.1
 */
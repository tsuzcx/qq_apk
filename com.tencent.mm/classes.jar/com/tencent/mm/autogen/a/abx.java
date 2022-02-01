package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class abx
  extends IEvent
{
  public a ifr;
  public b ifs;
  
  public abx()
  {
    this((byte)0);
  }
  
  private abx(byte paramByte)
  {
    AppMethodBeat.i(125651);
    this.ifr = new a();
    this.ifs = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125651);
  }
  
  public static final class a
  {
    public p ift;
  }
  
  public static final class b
  {
    public List ifu;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.abx
 * JD-Core Version:    0.7.0.1
 */
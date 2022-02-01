package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class aaa
  extends IEvent
{
  public a fZm;
  public b fZn;
  
  public aaa()
  {
    this((byte)0);
  }
  
  private aaa(byte paramByte)
  {
    AppMethodBeat.i(125651);
    this.fZm = new a();
    this.fZn = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125651);
  }
  
  public static final class a
  {
    public q fZo;
  }
  
  public static final class b
  {
    public List fZp;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.aaa
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class add
  extends IEvent
{
  public a ihg;
  public b ihh;
  
  public add()
  {
    this((byte)0);
  }
  
  private add(byte paramByte)
  {
    AppMethodBeat.i(91226);
    this.ihg = new a();
    this.ihh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91226);
  }
  
  public static final class a
  {
    public LinkedList<String> ihi;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.add
 * JD-Core Version:    0.7.0.1
 */
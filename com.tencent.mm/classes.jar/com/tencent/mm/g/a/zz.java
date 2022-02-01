package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class zz
  extends IEvent
{
  public a egG;
  public b egH;
  
  public zz()
  {
    this((byte)0);
  }
  
  private zz(byte paramByte)
  {
    AppMethodBeat.i(91226);
    this.egG = new a();
    this.egH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91226);
  }
  
  public static final class a
  {
    public LinkedList<String> egI;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.zz
 * JD-Core Version:    0.7.0.1
 */
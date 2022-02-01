package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class abg
  extends IEvent
{
  public a gaW;
  public b gaX;
  
  public abg()
  {
    this((byte)0);
  }
  
  private abg(byte paramByte)
  {
    AppMethodBeat.i(91226);
    this.gaW = new a();
    this.gaX = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91226);
  }
  
  public static final class a
  {
    public LinkedList<String> gaY;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.abg
 * JD-Core Version:    0.7.0.1
 */
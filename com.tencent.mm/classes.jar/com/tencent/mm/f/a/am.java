package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.IEvent;

public final class am
  extends IEvent
{
  public a fvS;
  
  public am()
  {
    this((byte)0);
  }
  
  private am(byte paramByte)
  {
    AppMethodBeat.i(149852);
    this.fvS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149852);
  }
  
  public static final class a
  {
    public b fvT;
    public boolean independent = true;
    public int level = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.am
 * JD-Core Version:    0.7.0.1
 */
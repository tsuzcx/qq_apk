package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class pr
  extends IEvent
{
  public a dVH;
  
  public pr()
  {
    this((byte)0);
  }
  
  private pr(byte paramByte)
  {
    AppMethodBeat.i(125623);
    this.dVH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125623);
  }
  
  public static final class a
  {
    public int dJY = 0;
    public boolean dLQ = false;
    public long dVI = 0L;
    public List list;
    public int scene = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.pr
 * JD-Core Version:    0.7.0.1
 */
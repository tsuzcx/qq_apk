package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class yt
  extends IEvent
{
  public a eeX;
  public b eeY;
  
  public yt()
  {
    this((byte)0);
  }
  
  private yt(byte paramByte)
  {
    AppMethodBeat.i(125651);
    this.eeX = new a();
    this.eeY = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125651);
  }
  
  public static final class a
  {
    public q eeZ;
  }
  
  public static final class b
  {
    public List efa;
    public int state = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.yt
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class ug
  extends IEvent
{
  public a eaD;
  
  public ug()
  {
    this((byte)0);
  }
  
  private ug(byte paramByte)
  {
    AppMethodBeat.i(121036);
    this.eaD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121036);
  }
  
  public static final class a
  {
    public String dNA;
    public long eaB;
    public List eaE;
    public Boolean eaF;
    public Boolean eaz;
    public int version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ug
 * JD-Core Version:    0.7.0.1
 */
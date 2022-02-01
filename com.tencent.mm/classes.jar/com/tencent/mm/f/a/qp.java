package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class qp
  extends IEvent
{
  public a fPl;
  
  public qp()
  {
    this((byte)0);
  }
  
  private qp(byte paramByte)
  {
    AppMethodBeat.i(125623);
    this.fPl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125623);
  }
  
  public static final class a
  {
    public int fCN = 0;
    public boolean fEF = false;
    public long fPm = 0L;
    public List list;
    public int scene = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.qp
 * JD-Core Version:    0.7.0.1
 */
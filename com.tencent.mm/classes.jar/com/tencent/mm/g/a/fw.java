package com.tencent.mm.g.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fw
  extends IEvent
{
  public a dJq;
  public b dJr;
  
  public fw()
  {
    this((byte)0);
  }
  
  private fw(byte paramByte)
  {
    AppMethodBeat.i(19806);
    this.dJq = new a();
    this.dJr = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19806);
  }
  
  public static final class a
  {
    public String[] dJs;
  }
  
  public static final class b
  {
    public int dIY = 0;
    public MatrixCursor dJt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.fw
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;

public final class lq
  extends IEvent
{
  public a dQX;
  public b dQY;
  
  public lq()
  {
    this((byte)0);
  }
  
  private lq(byte paramByte)
  {
    AppMethodBeat.i(63290);
    this.dQX = new a();
    this.dQY = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63290);
  }
  
  public static final class a
  {
    public Context context;
    public ArrayList dQZ;
    public String dRa;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.lq
 * JD-Core Version:    0.7.0.1
 */
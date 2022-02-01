package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uc
  extends IEvent
{
  public a fTr;
  
  public uc()
  {
    this((byte)0);
  }
  
  private uc(byte paramByte)
  {
    AppMethodBeat.i(19831);
    this.fTr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19831);
  }
  
  public static final class a
  {
    public Context context;
    public String[] fuA;
    public String[] fuz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.uc
 * JD-Core Version:    0.7.0.1
 */
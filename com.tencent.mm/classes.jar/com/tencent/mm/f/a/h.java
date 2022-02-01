package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class h
  extends IEvent
{
  public a fuy;
  
  public h()
  {
    this((byte)0);
  }
  
  private h(byte paramByte)
  {
    AppMethodBeat.i(19786);
    this.fuy = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19786);
  }
  
  public static final class a
  {
    public Context context;
    public String[] fuA;
    public String[] fuz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.h
 * JD-Core Version:    0.7.0.1
 */
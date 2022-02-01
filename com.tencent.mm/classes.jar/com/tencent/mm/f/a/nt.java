package com.tencent.mm.f.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nt
  extends IEvent
{
  public a fMj;
  public b fMk;
  
  public nt()
  {
    this((byte)0);
  }
  
  private nt(byte paramByte)
  {
    AppMethodBeat.i(155373);
    this.fMj = new a();
    this.fMk = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155373);
  }
  
  public static final class a
  {
    public Activity fDf;
    public Runnable fMl;
  }
  
  public static final class b
  {
    public boolean fyl = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.nt
 * JD-Core Version:    0.7.0.1
 */
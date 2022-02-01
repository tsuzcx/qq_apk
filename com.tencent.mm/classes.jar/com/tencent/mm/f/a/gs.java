package com.tencent.mm.f.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gs
  extends IEvent
{
  public a fDc;
  
  public gs()
  {
    this((byte)0);
  }
  
  private gs(byte paramByte)
  {
    AppMethodBeat.i(63288);
    this.fDc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63288);
  }
  
  public static final class a
  {
    public String fDd;
    public int fDe = 0;
    public Activity fDf;
    public int mRequestCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.gs
 * JD-Core Version:    0.7.0.1
 */
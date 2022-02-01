package com.tencent.mm.f.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gt
  extends IEvent
{
  public a fDg;
  
  public gt()
  {
    this((byte)0);
  }
  
  private gt(byte paramByte)
  {
    AppMethodBeat.i(163527);
    this.fDg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(163527);
  }
  
  public static final class a
  {
    public Activity fDf;
    public String fDh;
    public int fDi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.gt
 * JD-Core Version:    0.7.0.1
 */
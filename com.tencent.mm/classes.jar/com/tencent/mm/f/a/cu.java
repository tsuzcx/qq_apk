package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cu
  extends IEvent
{
  public a fyq;
  
  public cu()
  {
    this((byte)0);
  }
  
  private cu(byte paramByte)
  {
    AppMethodBeat.i(19794);
    this.fyq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19794);
  }
  
  public static final class a
  {
    public int action = 0;
    public Context context;
    public String[] fuA;
    public String[] fuz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.cu
 * JD-Core Version:    0.7.0.1
 */
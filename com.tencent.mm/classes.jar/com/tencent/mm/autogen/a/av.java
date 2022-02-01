package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class av
  extends IEvent
{
  public b hAA;
  public a hAz;
  
  public av()
  {
    this((byte)0);
  }
  
  private av(byte paramByte)
  {
    AppMethodBeat.i(131616);
    this.hAz = new a();
    this.hAA = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131616);
  }
  
  public static final class a
  {
    public int action = 0;
    public long beV = 0L;
    public Context context;
    public int fromScene = 0;
    public String hAB;
    public boolean hAC = false;
    public Runnable hAD;
    public int offset = 0;
    public String title;
  }
  
  public static final class b
  {
    public boolean hAE = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.av
 * JD-Core Version:    0.7.0.1
 */
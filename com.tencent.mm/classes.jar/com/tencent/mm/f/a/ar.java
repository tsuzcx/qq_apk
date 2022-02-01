package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ar
  extends IEvent
{
  public a fwc;
  public b fwd;
  
  public ar()
  {
    this((byte)0);
  }
  
  private ar(byte paramByte)
  {
    AppMethodBeat.i(131616);
    this.fwc = new a();
    this.fwd = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131616);
  }
  
  public static final class a
  {
    public int action = 0;
    public Context context;
    public int fromScene = 0;
    public String fwe;
    public long fwf = 0L;
    public boolean fwg = false;
    public Runnable fwh;
    public int offset = 0;
    public String title;
  }
  
  public static final class b
  {
    public boolean fwi = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.ar
 * JD-Core Version:    0.7.0.1
 */
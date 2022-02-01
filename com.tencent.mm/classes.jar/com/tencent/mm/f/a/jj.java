package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jj
  extends IEvent
{
  public a fGE;
  public b fGF;
  
  public jj()
  {
    this((byte)0);
  }
  
  private jj(byte paramByte)
  {
    AppMethodBeat.i(89640);
    this.fGE = new a();
    this.fGF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89640);
  }
  
  public static final class a
  {
    public int Vh = 0;
    public Context context;
    public String param;
  }
  
  public static final class b
  {
    public String result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.jj
 * JD-Core Version:    0.7.0.1
 */
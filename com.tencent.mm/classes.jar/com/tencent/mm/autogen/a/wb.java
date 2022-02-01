package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.lang.ref.WeakReference;

public final class wb
  extends IEvent
{
  public a hZI;
  public b hZJ;
  
  public wb()
  {
    this((byte)0);
  }
  
  private wb(byte paramByte)
  {
    AppMethodBeat.i(91219);
    this.hZI = new a();
    this.hZJ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91219);
  }
  
  public static final class a
  {
    public Runnable callback;
    public WeakReference contextRef;
    public String hZK;
    public int scene;
    public int type;
  }
  
  public static final class b
  {
    public int actionType;
    public String errMsg;
    public String hZL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.wb
 * JD-Core Version:    0.7.0.1
 */
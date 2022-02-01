package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.lang.ref.WeakReference;

public final class ul
  extends IEvent
{
  public a fTK;
  public b fTL;
  
  public ul()
  {
    this((byte)0);
  }
  
  private ul(byte paramByte)
  {
    AppMethodBeat.i(91219);
    this.fTK = new a();
    this.fTL = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91219);
  }
  
  public static final class a
  {
    public WeakReference aFX;
    public Runnable callback;
    public String fTM;
    public int scene;
    public int type;
  }
  
  public static final class b
  {
    public int actionType;
    public String errMsg;
    public String fTN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ul
 * JD-Core Version:    0.7.0.1
 */
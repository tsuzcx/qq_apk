package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.lang.ref.WeakReference;

public final class sa
  extends b
{
  public a duX;
  public b duY;
  
  public sa()
  {
    this((byte)0);
  }
  
  private sa(byte paramByte)
  {
    AppMethodBeat.i(91219);
    this.duX = new a();
    this.duY = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(91219);
  }
  
  public static final class a
  {
    public WeakReference aMw;
    public Runnable callback;
    public String duZ;
    public int scene;
    public int type;
  }
  
  public static final class b
  {
    public int actionType;
    public String dva;
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.sa
 * JD-Core Version:    0.7.0.1
 */
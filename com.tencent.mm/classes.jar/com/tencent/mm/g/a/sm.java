package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.lang.ref.WeakReference;

public final class sm
  extends b
{
  public a dGY;
  public b dGZ;
  
  public sm()
  {
    this((byte)0);
  }
  
  private sm(byte paramByte)
  {
    AppMethodBeat.i(91219);
    this.dGY = new a();
    this.dGZ = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(91219);
  }
  
  public static final class a
  {
    public WeakReference aWN;
    public Runnable callback;
    public String dHa;
    public int scene;
    public int type;
  }
  
  public static final class b
  {
    public int actionType;
    public String dHb;
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.sm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.lang.ref.WeakReference;

public final class sn
  extends b
{
  public a dIe;
  public b dIf;
  
  public sn()
  {
    this((byte)0);
  }
  
  private sn(byte paramByte)
  {
    AppMethodBeat.i(91219);
    this.dIe = new a();
    this.dIf = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(91219);
  }
  
  public static final class a
  {
    public WeakReference aWN;
    public Runnable callback;
    public String dIg;
    public int scene;
    public int type;
  }
  
  public static final class b
  {
    public int actionType;
    public String dIh;
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.sn
 * JD-Core Version:    0.7.0.1
 */
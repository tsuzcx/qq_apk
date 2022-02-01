package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.lang.ref.WeakReference;

public final class rr
  extends b
{
  public a dxk;
  public b dxl;
  
  public rr()
  {
    this((byte)0);
  }
  
  private rr(byte paramByte)
  {
    AppMethodBeat.i(91219);
    this.dxk = new a();
    this.dxl = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(91219);
  }
  
  public static final class a
  {
    public WeakReference aLG;
    public Runnable callback;
    public String dxm;
    public int scene;
    public int type;
  }
  
  public static final class b
  {
    public int actionType;
    public String dxn;
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.rr
 * JD-Core Version:    0.7.0.1
 */
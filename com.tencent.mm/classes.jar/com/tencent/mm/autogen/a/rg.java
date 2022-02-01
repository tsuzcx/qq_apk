package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rg
  extends IEvent
{
  public a hUl;
  public b hUm;
  
  public rg()
  {
    this((byte)0);
  }
  
  private rg(byte paramByte)
  {
    AppMethodBeat.i(140935);
    this.hUl = new a();
    this.hUm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140935);
  }
  
  public static final class a
  {
    public String hMy;
    public int hUn = 0;
    public int hUo = 0;
    public Runnable hUp;
  }
  
  public static final class b
  {
    public int errCode = -1;
    public String errMsg;
    public String hMA;
    public int hMx = 0;
    public String hMz;
    public String hUq;
    public int hUr = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.rg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.d;

public final class v
{
  public Runnable callback;
  public a dky;
  public b dkz;
  
  public v()
  {
    this((byte)0);
  }
  
  private v(byte paramByte)
  {
    AppMethodBeat.i(136972);
    this.callback = null;
    this.dky = new a();
    this.dkz = new b();
    this.callback = null;
    AppMethodBeat.o(136972);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public String dce;
    public int dkA;
    public b dkB;
    public a dkC;
    public String processName;
  }
  
  public static final class b
  {
    public int count;
    public d dkD;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.v
 * JD-Core Version:    0.7.0.1
 */
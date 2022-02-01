package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.d;

public final class y
{
  public Runnable callback;
  public a fvx;
  public b fvy;
  
  public y()
  {
    this((byte)0);
  }
  
  private y(byte paramByte)
  {
    AppMethodBeat.i(136972);
    this.callback = null;
    this.fvx = new a();
    this.fvy = new b();
    this.callback = null;
    AppMethodBeat.o(136972);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public int currentTime;
    public String fmF;
    public a fvA;
    public b fvz;
    public String processName;
  }
  
  public static final class b
  {
    public int count;
    public a fvA;
    public d fvB;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.y
 * JD-Core Version:    0.7.0.1
 */
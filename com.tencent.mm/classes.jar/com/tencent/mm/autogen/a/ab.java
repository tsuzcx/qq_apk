package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.d;

public final class ab
{
  public Runnable callback;
  public a hzS;
  public b hzT;
  
  public ab()
  {
    this((byte)0);
  }
  
  private ab(byte paramByte)
  {
    AppMethodBeat.i(136972);
    this.callback = null;
    this.hzS = new a();
    this.hzT = new b();
    this.callback = null;
    AppMethodBeat.o(136972);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public int currentTime;
    public String hqQ;
    public b hzU;
    public a hzV;
    public String processName;
  }
  
  public static final class b
  {
    public int count;
    public a hzV;
    public d hzW;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ab
 * JD-Core Version:    0.7.0.1
 */
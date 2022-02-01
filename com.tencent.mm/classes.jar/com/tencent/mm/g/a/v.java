package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.d;

public final class v
{
  public Runnable callback;
  public a dlA;
  public b dlB;
  
  public v()
  {
    this((byte)0);
  }
  
  private v(byte paramByte)
  {
    AppMethodBeat.i(136972);
    this.callback = null;
    this.dlA = new a();
    this.dlB = new b();
    this.callback = null;
    AppMethodBeat.o(136972);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public String ddg;
    public int dlC;
    public b dlD;
    public a dlE;
    public String processName;
  }
  
  public static final class b
  {
    public int count;
    public a dlE;
    public d dlF;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.v
 * JD-Core Version:    0.7.0.1
 */
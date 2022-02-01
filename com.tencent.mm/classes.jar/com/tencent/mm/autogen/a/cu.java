package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cu
  extends IEvent
{
  public a hCE;
  public b hCF;
  
  public cu()
  {
    this((byte)0);
  }
  
  private cu(byte paramByte)
  {
    AppMethodBeat.i(43440);
    this.hCE = new a();
    this.hCF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(43440);
  }
  
  public static final class a
  {
    public String username;
  }
  
  public static final class b
  {
    public String appId;
    public String[] eqg;
    public String nickname;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.cu
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sp
  extends IEvent
{
  public a hVM;
  public b hVN;
  
  public sp()
  {
    this((byte)0);
  }
  
  private sp(byte paramByte)
  {
    AppMethodBeat.i(155374);
    this.hVM = new a();
    this.hVN = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155374);
  }
  
  public static final class a
  {
    public String hVO;
    public String hVP;
    public String hVQ;
    public int hVR = 0;
    public int hVS = 0;
    public int opType = 0;
  }
  
  public static final class b
  {
    public boolean hCQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.sp
 * JD-Core Version:    0.7.0.1
 */
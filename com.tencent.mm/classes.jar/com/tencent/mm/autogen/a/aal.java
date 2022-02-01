package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aal
  extends IEvent
{
  public a idS;
  public b idT;
  
  public aal()
  {
    this((byte)0);
  }
  
  private aal(byte paramByte)
  {
    AppMethodBeat.i(19840);
    this.idS = new a();
    this.idT = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19840);
  }
  
  public static final class a
  {
    public String hVQ;
    public int hVR = 0;
    public int hVS = 0;
    public int opType = 0;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aal
 * JD-Core Version:    0.7.0.1
 */
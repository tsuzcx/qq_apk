package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cw
  extends IEvent
{
  public a hCN;
  public b hCO;
  
  public cw()
  {
    this((byte)0);
  }
  
  private cw(byte paramByte)
  {
    AppMethodBeat.i(149859);
    this.hCN = new a();
    this.hCO = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149859);
  }
  
  public static final class a
  {
    public Context context;
    public String hCP;
    public String username;
  }
  
  public static final class b
  {
    public boolean hCQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.cw
 * JD-Core Version:    0.7.0.1
 */
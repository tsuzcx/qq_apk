package com.tencent.mm.autogen.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ni
  extends IEvent
{
  public a hPF;
  public b hPG;
  
  public ni()
  {
    this((byte)0);
  }
  
  private ni(byte paramByte)
  {
    AppMethodBeat.i(369358);
    this.hPF = new a();
    this.hPG = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369358);
  }
  
  public static final class a
  {
    public Bundle hPH;
    public String hPI;
    public Runnable hPJ;
    public int type = 0;
  }
  
  public static final class b
  {
    public Bundle result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ni
 * JD-Core Version:    0.7.0.1
 */
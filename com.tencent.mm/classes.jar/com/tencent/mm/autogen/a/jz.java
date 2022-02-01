package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.event.IEvent;

public final class jz
  extends IEvent
{
  public a hLC;
  
  public jz()
  {
    this((byte)0);
  }
  
  private jz(byte paramByte)
  {
    AppMethodBeat.i(369451);
    this.hLC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369451);
  }
  
  public static final class a
  {
    public Context context;
    public boolean hLD;
    public bi hLE;
    public Runnable hLF;
    public String result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.jz
 * JD-Core Version:    0.7.0.1
 */
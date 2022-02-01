package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lm
  extends IEvent
{
  public a fJm;
  
  public lm()
  {
    this((byte)0);
  }
  
  private lm(byte paramByte)
  {
    AppMethodBeat.i(114792);
    this.fJm = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(114792);
  }
  
  public static final class a
  {
    public Context fJn;
    public long fJo;
    public boolean fJp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.a.lm
 * JD-Core Version:    0.7.0.1
 */
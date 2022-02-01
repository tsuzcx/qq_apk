package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.IEvent;

public final class sr
  extends IEvent
{
  public a fSb;
  
  public sr()
  {
    this((byte)0);
  }
  
  private sr(byte paramByte)
  {
    AppMethodBeat.i(125626);
    this.fSb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125626);
  }
  
  public static final class a
  {
    public SnsAdClick fSc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.sr
 * JD-Core Version:    0.7.0.1
 */
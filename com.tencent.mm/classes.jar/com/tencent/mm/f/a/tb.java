package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.IEvent;

public final class tb
  extends IEvent
{
  public a fSu;
  
  public tb()
  {
    this((byte)0);
  }
  
  private tb(byte paramByte)
  {
    AppMethodBeat.i(125628);
    this.fSu = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125628);
  }
  
  public static final class a
  {
    public SnsAdClick fSc;
    public int fSv;
    public String uxInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.tb
 * JD-Core Version:    0.7.0.1
 */
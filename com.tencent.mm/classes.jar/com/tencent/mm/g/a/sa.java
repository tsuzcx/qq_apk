package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.IEvent;

public final class sa
  extends IEvent
{
  public a dYC;
  
  public sa()
  {
    this((byte)0);
  }
  
  private sa(byte paramByte)
  {
    AppMethodBeat.i(125628);
    this.dYC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125628);
  }
  
  public static final class a
  {
    public int dYD;
    public SnsAdClick dYl;
    public String uxInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.sa
 * JD-Core Version:    0.7.0.1
 */
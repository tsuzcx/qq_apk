package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.IEvent;

public final class ss
  extends IEvent
{
  public a fSd;
  
  public ss()
  {
    this((byte)0);
  }
  
  private ss(byte paramByte)
  {
    AppMethodBeat.i(125627);
    this.fSd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125627);
  }
  
  public static final class a
  {
    public int errorCode;
    public SnsAdClick fSc;
    public int fSe;
    public long timestamp;
    public String url;
    public String uxInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ss
 * JD-Core Version:    0.7.0.1
 */
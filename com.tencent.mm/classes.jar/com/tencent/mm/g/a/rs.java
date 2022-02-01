package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.IEvent;

public final class rs
  extends IEvent
{
  public a dYm;
  
  public rs()
  {
    this((byte)0);
  }
  
  private rs(byte paramByte)
  {
    AppMethodBeat.i(125627);
    this.dYm = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125627);
  }
  
  public static final class a
  {
    public SnsAdClick dYl;
    public int dYn;
    public int errorCode;
    public long timestamp;
    public String url;
    public String uxInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.rs
 * JD-Core Version:    0.7.0.1
 */
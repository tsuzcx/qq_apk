package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class pf
  extends IEvent
{
  public pf()
  {
    this((byte)0);
  }
  
  private pf(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.pf
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class pv
  extends IEvent
{
  public pv()
  {
    this((byte)0);
  }
  
  private pv(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.pv
 * JD-Core Version:    0.7.0.1
 */
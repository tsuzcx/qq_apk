package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class hc
  extends IEvent
{
  public hc()
  {
    this((byte)0);
  }
  
  private hc(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.hc
 * JD-Core Version:    0.7.0.1
 */
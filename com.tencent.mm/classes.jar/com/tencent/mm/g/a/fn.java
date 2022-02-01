package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class fn
  extends IEvent
{
  public fn()
  {
    this((byte)0);
  }
  
  private fn(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.fn
 * JD-Core Version:    0.7.0.1
 */
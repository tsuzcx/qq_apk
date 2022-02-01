package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class oi
  extends IEvent
{
  public oi()
  {
    this((byte)0);
  }
  
  private oi(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.oi
 * JD-Core Version:    0.7.0.1
 */
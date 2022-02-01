package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class oy
  extends IEvent
{
  public oy()
  {
    this((byte)0);
  }
  
  private oy(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.oy
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class mm
  extends IEvent
{
  public mm()
  {
    this((byte)0);
  }
  
  private mm(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.mm
 * JD-Core Version:    0.7.0.1
 */
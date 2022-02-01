package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class rm
  extends IEvent
{
  public rm()
  {
    this((byte)0);
  }
  
  private rm(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.rm
 * JD-Core Version:    0.7.0.1
 */
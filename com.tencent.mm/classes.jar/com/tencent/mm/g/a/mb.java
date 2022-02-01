package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class mb
  extends IEvent
{
  public mb()
  {
    this((byte)0);
  }
  
  private mb(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.mb
 * JD-Core Version:    0.7.0.1
 */
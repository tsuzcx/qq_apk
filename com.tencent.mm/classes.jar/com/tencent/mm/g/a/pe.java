package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class pe
  extends IEvent
{
  public pe()
  {
    this((byte)0);
  }
  
  private pe(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.pe
 * JD-Core Version:    0.7.0.1
 */
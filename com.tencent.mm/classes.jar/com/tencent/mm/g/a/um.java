package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class um
  extends IEvent
{
  public um()
  {
    this((byte)0);
  }
  
  private um(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.um
 * JD-Core Version:    0.7.0.1
 */
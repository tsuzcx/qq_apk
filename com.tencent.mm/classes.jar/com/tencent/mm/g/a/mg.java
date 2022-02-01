package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class mg
  extends IEvent
{
  public mg()
  {
    this((byte)0);
  }
  
  private mg(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.mg
 * JD-Core Version:    0.7.0.1
 */
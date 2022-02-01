package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class hd
  extends IEvent
{
  public hd()
  {
    this((byte)0);
  }
  
  private hd(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.hd
 * JD-Core Version:    0.7.0.1
 */
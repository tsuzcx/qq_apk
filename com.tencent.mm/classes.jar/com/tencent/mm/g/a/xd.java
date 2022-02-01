package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class xd
  extends IEvent
{
  public xd()
  {
    this((byte)0);
  }
  
  private xd(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.xd
 * JD-Core Version:    0.7.0.1
 */
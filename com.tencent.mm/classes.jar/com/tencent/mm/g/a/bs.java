package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class bs
  extends IEvent
{
  public bs()
  {
    this((byte)0);
  }
  
  private bs(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.bs
 * JD-Core Version:    0.7.0.1
 */
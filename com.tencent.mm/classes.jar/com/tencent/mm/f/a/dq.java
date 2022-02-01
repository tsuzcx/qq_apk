package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class dq
  extends IEvent
{
  public dq()
  {
    this((byte)0);
  }
  
  private dq(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.dq
 * JD-Core Version:    0.7.0.1
 */
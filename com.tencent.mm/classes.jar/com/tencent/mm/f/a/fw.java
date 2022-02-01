package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class fw
  extends IEvent
{
  public fw()
  {
    this((byte)0);
  }
  
  private fw(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.fw
 * JD-Core Version:    0.7.0.1
 */
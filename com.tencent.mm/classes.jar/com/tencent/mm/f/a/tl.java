package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class tl
  extends IEvent
{
  public tl()
  {
    this((byte)0);
  }
  
  private tl(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.tl
 * JD-Core Version:    0.7.0.1
 */
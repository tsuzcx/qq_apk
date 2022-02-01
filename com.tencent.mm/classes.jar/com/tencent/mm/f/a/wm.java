package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class wm
  extends IEvent
{
  public wm()
  {
    this((byte)0);
  }
  
  private wm(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wm
 * JD-Core Version:    0.7.0.1
 */
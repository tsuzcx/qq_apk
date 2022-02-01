package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ck
  extends IEvent
{
  public ck()
  {
    this((byte)0);
  }
  
  private ck(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ck
 * JD-Core Version:    0.7.0.1
 */
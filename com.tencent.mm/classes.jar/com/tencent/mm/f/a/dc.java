package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class dc
  extends IEvent
{
  public dc()
  {
    this((byte)0);
  }
  
  private dc(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.dc
 * JD-Core Version:    0.7.0.1
 */
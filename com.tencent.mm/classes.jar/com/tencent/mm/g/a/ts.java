package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ts
  extends IEvent
{
  public ts()
  {
    this((byte)0);
  }
  
  private ts(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.ts
 * JD-Core Version:    0.7.0.1
 */
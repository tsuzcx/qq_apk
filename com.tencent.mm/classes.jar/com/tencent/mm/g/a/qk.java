package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class qk
  extends IEvent
{
  public qk()
  {
    this((byte)0);
  }
  
  private qk(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.qk
 * JD-Core Version:    0.7.0.1
 */
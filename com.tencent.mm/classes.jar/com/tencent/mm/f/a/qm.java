package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class qm
  extends IEvent
{
  public qm()
  {
    this((byte)0);
  }
  
  private qm(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.qm
 * JD-Core Version:    0.7.0.1
 */
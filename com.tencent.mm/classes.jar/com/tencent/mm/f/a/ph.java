package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ph
  extends IEvent
{
  public ph()
  {
    this((byte)0);
  }
  
  private ph(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ph
 * JD-Core Version:    0.7.0.1
 */
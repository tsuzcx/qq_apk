package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ct
  extends IEvent
{
  public ct()
  {
    this((byte)0);
  }
  
  private ct(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ct
 * JD-Core Version:    0.7.0.1
 */
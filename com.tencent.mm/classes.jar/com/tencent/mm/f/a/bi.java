package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class bi
  extends IEvent
{
  public bi()
  {
    this((byte)0);
  }
  
  private bi(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.a.bi
 * JD-Core Version:    0.7.0.1
 */
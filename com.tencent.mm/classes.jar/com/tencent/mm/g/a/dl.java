package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class dl
  extends IEvent
{
  public dl()
  {
    this((byte)0);
  }
  
  private dl(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.dl
 * JD-Core Version:    0.7.0.1
 */
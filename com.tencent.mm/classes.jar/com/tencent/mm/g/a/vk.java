package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class vk
  extends IEvent
{
  public vk()
  {
    this((byte)0);
  }
  
  private vk(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.vk
 * JD-Core Version:    0.7.0.1
 */
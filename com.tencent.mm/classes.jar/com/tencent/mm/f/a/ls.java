package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ls
  extends IEvent
{
  public ls()
  {
    this((byte)0);
  }
  
  private ls(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.ls
 * JD-Core Version:    0.7.0.1
 */
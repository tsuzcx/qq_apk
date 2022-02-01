package com.tencent.mm.f.a;

import com.tencent.mm.sdk.event.IEvent;

public final class tk
  extends IEvent
{
  public tk()
  {
    this((byte)0);
  }
  
  private tk(byte paramByte)
  {
    this.order = false;
    this.callback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.tk
 * JD-Core Version:    0.7.0.1
 */
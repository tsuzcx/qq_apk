package com.tencent.mm.openim.room.a;

import com.tencent.mm.hardcoder.WXHardCoderJNI;

public final class c
{
  private int dmX = 0;
  public int dmY;
  
  public final void jH(int paramInt)
  {
    this.dmX |= paramInt;
  }
  
  final void jI(int paramInt)
  {
    this.dmX &= (paramInt ^ 0xFFFFFFFF);
    if (this.dmX == 0)
    {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcUpdateChatroomEnable, this.dmY);
      this.dmY = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.c
 * JD-Core Version:    0.7.0.1
 */
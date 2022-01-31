package com.tencent.liteav;

import com.tencent.liteav.audio.f;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;

class c$6
  implements f
{
  c$6(c paramc) {}
  
  public void a()
  {
    if (this.a.c != null) {
      this.a.c.onBGMStart();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a.c != null) {
      this.a.c.onBGMComplete(paramInt);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.a.c != null) {
      this.a.c.onBGMProgress(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.c.6
 * JD-Core Version:    0.7.0.1
 */
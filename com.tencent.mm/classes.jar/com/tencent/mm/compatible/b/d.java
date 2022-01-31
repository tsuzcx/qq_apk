package com.tencent.mm.compatible.b;

import android.media.AudioTrack;

public final class d
  extends AudioTrack
{
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, 2, paramInt4, 1);
    f.gs(hashCode());
  }
  
  public final void release()
  {
    super.release();
    f.gt(hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.b.d
 * JD-Core Version:    0.7.0.1
 */
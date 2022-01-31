package com.tencent.mm.compatible.b;

import android.media.AudioRecord;

public final class c
  extends AudioRecord
{
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, 2, paramInt4);
    f.gu(hashCode());
  }
  
  public final void release()
  {
    super.release();
    f.gv(hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.b.c
 * JD-Core Version:    0.7.0.1
 */
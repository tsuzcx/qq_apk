package com.tencent.mm.plugin.mmsight.segment;

import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

final class RecyclerThumbSeekBar$d
{
  ah handler = new ah();
  int mie = 4;
  HandlerThread[] mmr = new HandlerThread[this.mie];
  int mms = 0;
  private BlockingDeque<RecyclerThumbSeekBar.b> mmt = new LinkedBlockingDeque();
  
  public RecyclerThumbSeekBar$d(RecyclerThumbSeekBar paramRecyclerThumbSeekBar)
  {
    int i = 0;
    while (i < this.mmr.length)
    {
      this.mmr[i] = e.ds("RecyclerThumbSeekBar_SimpleImageLoader_" + i, -1);
      this.mmr[i].start();
      i += 1;
    }
    this.mms = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.d
 * JD-Core Version:    0.7.0.1
 */
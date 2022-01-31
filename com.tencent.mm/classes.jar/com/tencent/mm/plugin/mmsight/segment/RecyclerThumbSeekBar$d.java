package com.tencent.mm.plugin.mmsight.segment;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

final class RecyclerThumbSeekBar$d
{
  ak handler;
  int oIl;
  int oLA;
  private BlockingDeque<RecyclerThumbSeekBar.b> oLB;
  HandlerThread[] oLz;
  
  public RecyclerThumbSeekBar$d(RecyclerThumbSeekBar paramRecyclerThumbSeekBar)
  {
    AppMethodBeat.i(54994);
    this.handler = new ak();
    this.oIl = 4;
    this.oLA = 0;
    this.oLB = new LinkedBlockingDeque();
    this.oLz = new HandlerThread[this.oIl];
    int i = 0;
    while (i < this.oLz.length)
    {
      this.oLz[i] = d.ey("RecyclerThumbSeekBar_SimpleImageLoader_".concat(String.valueOf(i)), -1);
      this.oLz[i].start();
      i += 1;
    }
    this.oLA = 0;
    AppMethodBeat.o(54994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.d
 * JD-Core Version:    0.7.0.1
 */
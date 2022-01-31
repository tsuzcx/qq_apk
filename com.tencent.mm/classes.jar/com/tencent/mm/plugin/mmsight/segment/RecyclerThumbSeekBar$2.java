package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.f.e;

final class RecyclerThumbSeekBar$2
  implements Runnable
{
  RecyclerThumbSeekBar$2(RecyclerThumbSeekBar paramRecyclerThumbSeekBar) {}
  
  public final void run()
  {
    if ((this.mmi.getHeight() == 0) || (this.mmi.getWidth() == 0))
    {
      this.mmi.post(RecyclerThumbSeekBar.e(this.mmi));
      return;
    }
    RecyclerThumbSeekBar.a(this.mmi, this.mmi.getHeight());
    RecyclerThumbSeekBar.b(this.mmi, (this.mmi.getWidth() - RecyclerThumbSeekBar.f(this.mmi) * 2) / 12);
    e.post(new RecyclerThumbSeekBar.2.1(this), "check duration of ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.2
 * JD-Core Version:    0.7.0.1
 */
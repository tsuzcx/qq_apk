package com.tencent.mm.plugin.mmsight.segment;

final class RecyclerThumbSeekBar$6
  implements o.a
{
  RecyclerThumbSeekBar$6(RecyclerThumbSeekBar paramRecyclerThumbSeekBar) {}
  
  public final void bjW()
  {
    if ((RecyclerThumbSeekBar.p(this.mmi) != null) && (RecyclerThumbSeekBar.m(this.mmi) != null))
    {
      c.b localb = RecyclerThumbSeekBar.p(this.mmi);
      this.mmi.bjK();
      this.mmi.bjL();
      localb.bjM();
    }
  }
  
  public final void bjX()
  {
    if ((RecyclerThumbSeekBar.p(this.mmi) != null) && (RecyclerThumbSeekBar.m(this.mmi) != null)) {
      RecyclerThumbSeekBar.p(this.mmi).U(this.mmi.bjK(), this.mmi.bjL());
    }
  }
  
  public final void hx(boolean paramBoolean)
  {
    if ((RecyclerThumbSeekBar.p(this.mmi) != null) && (RecyclerThumbSeekBar.m(this.mmi) != null)) {
      RecyclerThumbSeekBar.p(this.mmi).V(this.mmi.bjK(), this.mmi.bjL());
    }
    if (paramBoolean)
    {
      RecyclerThumbSeekBar.m(this.mmi).q(true, RecyclerThumbSeekBar.l(this.mmi).getLeftSliderBound());
      return;
    }
    RecyclerThumbSeekBar.m(this.mmi).q(false, RecyclerThumbSeekBar.l(this.mmi).getWidth() - RecyclerThumbSeekBar.l(this.mmi).getRightSliderBound());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.6
 * JD-Core Version:    0.7.0.1
 */
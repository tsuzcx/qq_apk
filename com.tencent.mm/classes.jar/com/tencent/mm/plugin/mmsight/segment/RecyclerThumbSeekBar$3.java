package com.tencent.mm.plugin.mmsight.segment;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.y;

final class RecyclerThumbSeekBar$3
  implements Runnable
{
  RecyclerThumbSeekBar$3(RecyclerThumbSeekBar paramRecyclerThumbSeekBar) {}
  
  public final void run()
  {
    int i = 1000;
    try
    {
      RecyclerThumbSeekBar.l(this.mmi).setCursorPos(-1.0F);
      RecyclerThumbSeekBar.a(this.mmi, new RecyclerThumbSeekBar.c(this.mmi, (byte)0));
      int j = RecyclerThumbSeekBar.e(this.mmi, RecyclerThumbSeekBar.j(this.mmi).duration * 1000 + 1000);
      Object localObject = this.mmi;
      if (RecyclerThumbSeekBar.b(this.mmi) <= 1000) {}
      for (;;)
      {
        i = RecyclerThumbSeekBar.e((RecyclerThumbSeekBar)localObject, i);
        RecyclerThumbSeekBar.f(this.mmi, (this.mmi.getWidth() - j) / 2);
        localObject = RecyclerThumbSeekBar.l(this.mmi);
        ((o)localObject).post(new o.1((o)localObject, j, RecyclerThumbSeekBar.f(this.mmi), i));
        y.i("RecyclerThumbSeekBar", "RecyclerThumbSeekBar.run(212) width %d", new Object[] { Integer.valueOf(this.mmi.getWidth()) });
        RecyclerThumbSeekBar.m(this.mmi).mmo = (this.mmi.getWidth() - RecyclerThumbSeekBar.f(this.mmi) - j);
        RecyclerThumbSeekBar.m(this.mmi).mmn = RecyclerThumbSeekBar.f(this.mmi);
        RecyclerThumbSeekBar.n(this.mmi).setAdapter(RecyclerThumbSeekBar.m(this.mmi));
        y.d("RecyclerThumbSeekBar", "init segment thumb fetcher end, adapter.getItemCount() %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.m(this.mmi).getItemCount()) });
        if (RecyclerThumbSeekBar.o(this.mmi) == null) {
          break;
        }
        RecyclerThumbSeekBar.o(this.mmi).hw(false);
        return;
        i = RecyclerThumbSeekBar.b(this.mmi);
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("RecyclerThumbSeekBar", localException, "RecyclerThumbSeekBar notifySuccess error : %s", new Object[] { localException.getMessage() });
      if (RecyclerThumbSeekBar.o(this.mmi) != null) {
        RecyclerThumbSeekBar.o(this.mmi).hw(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.3
 * JD-Core Version:    0.7.0.1
 */
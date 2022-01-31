package com.tencent.mm.plugin.mmsight.segment;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ab;

final class RecyclerThumbSeekBar$3
  implements Runnable
{
  RecyclerThumbSeekBar$3(RecyclerThumbSeekBar paramRecyclerThumbSeekBar) {}
  
  public final void run()
  {
    int i = 1000;
    AppMethodBeat.i(54979);
    try
    {
      RecyclerThumbSeekBar.l(this.oLp).setCursorPos(-1.0F);
      RecyclerThumbSeekBar.a(this.oLp, new RecyclerThumbSeekBar.c(this.oLp, (byte)0));
      int j = RecyclerThumbSeekBar.e(this.oLp, RecyclerThumbSeekBar.j(this.oLp).duration * 1000 + 1000);
      Object localObject = this.oLp;
      if (RecyclerThumbSeekBar.b(this.oLp) <= 1000) {}
      for (;;)
      {
        i = RecyclerThumbSeekBar.e((RecyclerThumbSeekBar)localObject, i);
        RecyclerThumbSeekBar.f(this.oLp, (this.oLp.getWidth() - j) / 2);
        localObject = RecyclerThumbSeekBar.l(this.oLp);
        ((n)localObject).post(new n.1((n)localObject, j, RecyclerThumbSeekBar.f(this.oLp), i));
        ab.i("RecyclerThumbSeekBar", "RecyclerThumbSeekBar.run(212) width %d", new Object[] { Integer.valueOf(this.oLp.getWidth()) });
        RecyclerThumbSeekBar.m(this.oLp).oLw = (this.oLp.getWidth() - RecyclerThumbSeekBar.f(this.oLp) - j);
        RecyclerThumbSeekBar.m(this.oLp).oLv = RecyclerThumbSeekBar.f(this.oLp);
        RecyclerThumbSeekBar.n(this.oLp).setAdapter(RecyclerThumbSeekBar.m(this.oLp));
        ab.d("RecyclerThumbSeekBar", "init segment thumb fetcher end, adapter.getItemCount() %d", new Object[] { Integer.valueOf(RecyclerThumbSeekBar.m(this.oLp).getItemCount()) });
        if (RecyclerThumbSeekBar.o(this.oLp) != null) {
          RecyclerThumbSeekBar.o(this.oLp).jp(false);
        }
        AppMethodBeat.o(54979);
        return;
        i = RecyclerThumbSeekBar.b(this.oLp);
      }
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("RecyclerThumbSeekBar", localException, "RecyclerThumbSeekBar notifySuccess error : %s", new Object[] { localException.getMessage() });
      if (RecyclerThumbSeekBar.o(this.oLp) != null) {
        RecyclerThumbSeekBar.o(this.oLp).jp(true);
      }
      AppMethodBeat.o(54979);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;

public final class g
  implements n.a
{
  private n jXj;
  public long jXk = 0L;
  private BaseAdapter jXl;
  
  public g(BaseAdapter paramBaseAdapter)
  {
    this.jXl = paramBaseAdapter;
  }
  
  public final n aWW()
  {
    AppMethodBeat.i(14229);
    if (this.jXj == null) {
      this.jXj = new n();
    }
    n localn = this.jXj;
    AppMethodBeat.o(14229);
    return localn;
  }
  
  public final void bK(String paramString, int paramInt)
  {
    AppMethodBeat.i(14232);
    this.jXl.notifyDataSetChanged();
    AppMethodBeat.o(14232);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(14230);
    if ((this.jXj != null) && (this.jXj.bwz()))
    {
      AppMethodBeat.o(14230);
      return true;
    }
    AppMethodBeat.o(14230);
    return false;
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(14233);
    this.jXk = 0L;
    this.jXl.notifyDataSetChanged();
    AppMethodBeat.o(14233);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(14234);
    this.jXk = 0L;
    this.jXl.notifyDataSetChanged();
    AppMethodBeat.o(14234);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(14231);
    if (isPlaying()) {
      aWW().stopPlay();
    }
    AppMethodBeat.o(14231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g
 * JD-Core Version:    0.7.0.1
 */
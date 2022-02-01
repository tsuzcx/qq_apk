package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;

public final class i
  implements n.a
{
  private n nAU;
  public long nAV = 0L;
  private BaseAdapter nAW;
  
  public i(BaseAdapter paramBaseAdapter)
  {
    this.nAW = paramBaseAdapter;
  }
  
  public final n bKb()
  {
    AppMethodBeat.i(5993);
    if (this.nAU == null) {
      this.nAU = new n();
    }
    n localn = this.nAU;
    AppMethodBeat.o(5993);
    return localn;
  }
  
  public final void cu(String paramString, int paramInt)
  {
    AppMethodBeat.i(5996);
    this.nAW.notifyDataSetChanged();
    AppMethodBeat.o(5996);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(5994);
    if ((this.nAU != null) && (this.nAU.caY()))
    {
      AppMethodBeat.o(5994);
      return true;
    }
    AppMethodBeat.o(5994);
    return false;
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(5997);
    this.nAV = 0L;
    this.nAW.notifyDataSetChanged();
    AppMethodBeat.o(5997);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(5998);
    this.nAV = 0L;
    this.nAW.notifyDataSetChanged();
    AppMethodBeat.o(5998);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(5995);
    if (isPlaying()) {
      bKb().stopPlay();
    }
    AppMethodBeat.o(5995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.i
 * JD-Core Version:    0.7.0.1
 */
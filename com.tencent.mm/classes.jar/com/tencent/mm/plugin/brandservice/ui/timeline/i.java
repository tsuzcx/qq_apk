package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;

public final class i
  implements n.a
{
  private n mYv;
  public long mYw = 0L;
  private BaseAdapter mYx;
  
  public i(BaseAdapter paramBaseAdapter)
  {
    this.mYx = paramBaseAdapter;
  }
  
  public final n bCT()
  {
    AppMethodBeat.i(5993);
    if (this.mYv == null) {
      this.mYv = new n();
    }
    n localn = this.mYv;
    AppMethodBeat.o(5993);
    return localn;
  }
  
  public final void cp(String paramString, int paramInt)
  {
    AppMethodBeat.i(5996);
    this.mYx.notifyDataSetChanged();
    AppMethodBeat.o(5996);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(5994);
    if ((this.mYv != null) && (this.mYv.bTK()))
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
    this.mYw = 0L;
    this.mYx.notifyDataSetChanged();
    AppMethodBeat.o(5997);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(5998);
    this.mYw = 0L;
    this.mYx.notifyDataSetChanged();
    AppMethodBeat.o(5998);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(5995);
    if (isPlaying()) {
      bCT().stopPlay();
    }
    AppMethodBeat.o(5995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.i
 * JD-Core Version:    0.7.0.1
 */
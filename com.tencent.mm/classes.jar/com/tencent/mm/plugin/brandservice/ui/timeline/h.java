package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;

public final class h
  implements n.a
{
  private n ohS;
  public long ohT = 0L;
  private BaseAdapter ohU;
  
  public h(BaseAdapter paramBaseAdapter)
  {
    this.ohU = paramBaseAdapter;
  }
  
  public final n bPs()
  {
    AppMethodBeat.i(5993);
    if (this.ohS == null) {
      this.ohS = new n();
    }
    n localn = this.ohS;
    AppMethodBeat.o(5993);
    return localn;
  }
  
  public final long bPt()
  {
    return this.ohT;
  }
  
  public final void cB(String paramString, int paramInt)
  {
    AppMethodBeat.i(5996);
    this.ohU.notifyDataSetChanged();
    AppMethodBeat.o(5996);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(5994);
    if ((this.ohS != null) && (this.ohS.cgS()))
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
    this.ohT = 0L;
    this.ohU.notifyDataSetChanged();
    AppMethodBeat.o(5997);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(5998);
    this.ohT = 0L;
    this.ohU.notifyDataSetChanged();
    AppMethodBeat.o(5998);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(5995);
    if (isPlaying()) {
      bPs().stopPlay();
    }
    AppMethodBeat.o(5995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;

public final class h
  implements n.a
{
  private n ocd;
  public long oce = 0L;
  private BaseAdapter ocf;
  
  public h(BaseAdapter paramBaseAdapter)
  {
    this.ocf = paramBaseAdapter;
  }
  
  public final n bOv()
  {
    AppMethodBeat.i(5993);
    if (this.ocd == null) {
      this.ocd = new n();
    }
    n localn = this.ocd;
    AppMethodBeat.o(5993);
    return localn;
  }
  
  public final void cx(String paramString, int paramInt)
  {
    AppMethodBeat.i(5996);
    this.ocf.notifyDataSetChanged();
    AppMethodBeat.o(5996);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(5994);
    if ((this.ocd != null) && (this.ocd.cfC()))
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
    this.oce = 0L;
    this.ocf.notifyDataSetChanged();
    AppMethodBeat.o(5997);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(5998);
    this.oce = 0L;
    this.ocf.notifyDataSetChanged();
    AppMethodBeat.o(5998);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(5995);
    if (isPlaying()) {
      bOv().stopPlay();
    }
    AppMethodBeat.o(5995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.h
 * JD-Core Version:    0.7.0.1
 */
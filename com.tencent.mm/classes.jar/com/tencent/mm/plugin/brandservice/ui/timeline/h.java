package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;

public final class h
  implements n.a
{
  private n ihn;
  long iho = 0L;
  private BaseAdapter ihp;
  
  public h(BaseAdapter paramBaseAdapter)
  {
    this.ihp = paramBaseAdapter;
  }
  
  final n ayd()
  {
    if (this.ihn == null) {
      this.ihn = new n();
    }
    return this.ihn;
  }
  
  public final void bj(String paramString, int paramInt)
  {
    this.ihp.notifyDataSetChanged();
  }
  
  public final boolean isPlaying()
  {
    return (this.ihn != null) && (this.ihn.aQk());
  }
  
  public final void onFinish()
  {
    this.iho = 0L;
    this.ihp.notifyDataSetChanged();
  }
  
  public final void onPause()
  {
    this.iho = 0L;
    this.ihp.notifyDataSetChanged();
  }
  
  public final void stopPlay()
  {
    if (isPlaying()) {
      ayd().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.h
 * JD-Core Version:    0.7.0.1
 */
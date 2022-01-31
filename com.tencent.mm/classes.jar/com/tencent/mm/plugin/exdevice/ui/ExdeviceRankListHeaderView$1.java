package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class ExdeviceRankListHeaderView$1
  implements View.OnClickListener
{
  ExdeviceRankListHeaderView$1(ExdeviceRankListHeaderView paramExdeviceRankListHeaderView) {}
  
  public final void onClick(View paramView)
  {
    if (ExdeviceRankListHeaderView.a(this.jGd)) {
      ExdeviceRankListHeaderView.b(this.jGd);
    }
    if (ExdeviceRankListHeaderView.c(this.jGd) != null) {
      ExdeviceRankListHeaderView.c(this.jGd).onClick(this.jGd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView.1
 * JD-Core Version:    0.7.0.1
 */
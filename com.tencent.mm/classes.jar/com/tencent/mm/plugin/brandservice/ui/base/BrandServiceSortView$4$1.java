package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.sortview.c;
import java.util.List;

final class BrandServiceSortView$4$1
  implements Runnable
{
  BrandServiceSortView$4$1(BrandServiceSortView.4 param4) {}
  
  public final void run()
  {
    List localList = this.iey.iex.getDatas();
    if ((this.iey.kX >= 0) && (localList != null) && (this.iey.kX < localList.size()))
    {
      localList.remove(this.iey.kX);
      ai.d(this.iey.iex.getAdapter().vek);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.4.1
 * JD-Core Version:    0.7.0.1
 */
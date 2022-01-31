package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.plugin.appbrand.y.i;
import java.util.List;

public final class BaseAppBrandRecentView$a
  extends RecyclerView.a<BaseAppBrandRecentView.c>
{
  c.a hCS = new c.a();
  
  private BaseAppBrandRecentView$a(BaseAppBrandRecentView paramBaseAppBrandRecentView)
  {
    this.hCS.eru = y.i.default_avatar;
  }
  
  public final int getItemCount()
  {
    int j = BaseAppBrandRecentView.b(this.hCR).size();
    int k = this.hCR.getCompletelyCountPerPage();
    int i = j;
    if (this.hCR.getCustomItemCount() == 1) {
      i = j - 1;
    }
    j = i;
    if (i > this.hCR.getShowCount()) {
      j = this.hCR.getShowCount();
    }
    if (this.hCR.getCustomItemCount() == 1) {
      if (j % k == 0)
      {
        i = j + 1;
        i += this.hCR.getCustomItemCount();
      }
    }
    do
    {
      return i;
      i = j + (k + 1 - j % k);
      break;
      i = j;
    } while (j % k == 0);
    return j + (k - j % k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.a
 * JD-Core Version:    0.7.0.1
 */
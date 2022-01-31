package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import java.util.List;

public final class BaseAppBrandRecentView$a
  extends RecyclerView.a<BaseAppBrandRecentView.c>
{
  c.a jvu;
  
  private BaseAppBrandRecentView$a(BaseAppBrandRecentView paramBaseAppBrandRecentView)
  {
    AppMethodBeat.i(134342);
    this.jvu = new c.a();
    this.jvu.eNY = 2131231207;
    AppMethodBeat.o(134342);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(134343);
    int j = BaseAppBrandRecentView.b(this.jvt).size();
    int k = this.jvt.getCompletelyCountPerPage();
    int i = j;
    if (this.jvt.getCustomItemCount() == 1) {
      i = j - 1;
    }
    j = i;
    if (i > this.jvt.getShowCount()) {
      j = this.jvt.getShowCount();
    }
    if (this.jvt.getCustomItemCount() == 1)
    {
      if (j % k == 0) {}
      for (i = j + 1;; i = j + (k + 1 - j % k))
      {
        j = this.jvt.getCustomItemCount();
        AppMethodBeat.o(134343);
        return i + j;
      }
    }
    i = j;
    if (j % k != 0) {
      i = j + (k - j % k);
    }
    AppMethodBeat.o(134343);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.a
 * JD-Core Version:    0.7.0.1
 */
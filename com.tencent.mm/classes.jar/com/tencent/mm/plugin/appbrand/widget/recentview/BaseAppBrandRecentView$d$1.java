package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.h.c;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class BaseAppBrandRecentView$d$1
  implements Runnable
{
  BaseAppBrandRecentView$d$1(BaseAppBrandRecentView.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(134353);
    c.a(new BaseAppBrandRecentView.b(this.jvz.jvt, this.jvz.iQp, BaseAppBrandRecentView.b(this.jvz.jvt)));
    BaseAppBrandRecentView.b(this.jvz.jvt).clear();
    BaseAppBrandRecentView.i(this.jvz.jvt).clear();
    BaseAppBrandRecentView.b(this.jvz.jvt).addAll(this.jvz.iQp);
    BaseAppBrandRecentView.i(this.jvz.jvt).addAll(this.jvz.jvx);
    this.jvz.iQp.clear();
    this.jvz.jvx.clear();
    if ((this.jvz.jvt.getRefreshListener() != null) && (this.jvz.jvy)) {
      this.jvz.jvt.getRefreshListener().qj(BaseAppBrandRecentView.b(this.jvz.jvt).size());
    }
    if (this.jvz.jvy)
    {
      ab.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh done dispatch diffResult, mType: %s", new Object[] { this.jvz.jvt.jhO });
      ??? = AppBrandRecentView.f.juq;
      this.jvz.jvt.getAdapter().ajb.notifyChanged();
    }
    synchronized (BaseAppBrandRecentView.f(this.jvz.jvt))
    {
      BaseAppBrandRecentView.a(this.jvz.jvt, false);
      BaseAppBrandRecentView.j(this.jvz.jvt);
      AppMethodBeat.o(134353);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.d.1
 * JD-Core Version:    0.7.0.1
 */
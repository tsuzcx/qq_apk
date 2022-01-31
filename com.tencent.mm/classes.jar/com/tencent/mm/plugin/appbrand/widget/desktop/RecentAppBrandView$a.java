package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class RecentAppBrandView$a
  extends RecyclerView.a<e>
{
  RecentAppBrandView$a(RecentAppBrandView paramRecentAppBrandView) {}
  
  public final int getItemCount()
  {
    AppMethodBeat.i(133933);
    int i = RecentAppBrandView.d(this.jgf).size();
    AppMethodBeat.o(133933);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(133932);
    paramInt = RecentAppBrandView.a(this.jgf, paramInt).type;
    AppMethodBeat.o(133932);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView.a
 * JD-Core Version:    0.7.0.1
 */
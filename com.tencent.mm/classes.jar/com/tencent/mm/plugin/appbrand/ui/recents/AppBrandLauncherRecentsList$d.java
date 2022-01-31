package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import java.util.HashMap;
import java.util.Map;

final class AppBrandLauncherRecentsList$d
  extends t<AppBrandRecentTaskInfo, AppBrandLauncherRecentsList.e>
{
  final Map<String, String> iTC;
  
  private AppBrandLauncherRecentsList$d(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList)
  {
    AppMethodBeat.i(133373);
    this.iTC = new HashMap();
    AppMethodBeat.o(133373);
  }
  
  private void a(AppBrandLauncherRecentsList.e parame)
  {
    AppMethodBeat.i(133374);
    AppBrandLauncherRecentsList.d(this.iTl);
    if (LoadMoreRecyclerView.bq(parame.aku) == AppBrandLauncherRecentsList.b(this.iTl).getItemCount() - 1) {
      parame.gqg.setVisibility(8);
    }
    while (AppBrandLauncherRecentsList.C(this.iTl))
    {
      TextView localTextView = parame.iTG;
      AppBrandLauncherRecentsList.d(this.iTl);
      localTextView.setText(String.valueOf(LoadMoreRecyclerView.bq(parame.aku)));
      parame.iTG.setVisibility(0);
      AppMethodBeat.o(133374);
      return;
      parame.gqg.setVisibility(0);
    }
    parame.iTG.setVisibility(8);
    AppMethodBeat.o(133374);
  }
  
  private static void a(AppBrandLauncherRecentsList.e parame, String paramString)
  {
    AppMethodBeat.i(133376);
    parame.iTD.setText(paramString);
    AppMethodBeat.o(133376);
  }
  
  private void a(AppBrandLauncherRecentsList.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(133375);
    parame = parame.iTI;
    if ((AppBrandLauncherRecentsList.n(this.iTl)) && (paramBoolean)) {}
    for (int i = 0;; i = 8)
    {
      parame.setVisibility(i);
      AppMethodBeat.o(133375);
      return;
    }
  }
  
  final void b(AppBrandLauncherRecentsList.e parame, String paramString)
  {
    AppMethodBeat.i(133377);
    AppBrandLauncherRecentsList.D(this.iTl);
    parame = b.acD().a(parame.iTH, paramString, a.acC(), f.fqU);
    this.iTC.put(paramString, parame);
    AppMethodBeat.o(133377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.d
 * JD-Core Version:    0.7.0.1
 */
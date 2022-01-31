package com.tencent.mm.plugin.downloader_app.search;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.q;
import java.util.List;

final class DownloadSearchUI$1
  implements MRecyclerView.a
{
  DownloadSearchUI$1(DownloadSearchUI paramDownloadSearchUI) {}
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(136181);
    paramView = DownloadSearchUI.a(this.lbG).lbx.iVH;
    if ((paramView != null) && (paramInt >= 0) && (paramInt < paramView.size())) {}
    for (paramView = (b)paramView.get(paramInt); paramView == null; paramView = null)
    {
      AppMethodBeat.o(136181);
      return;
    }
    if (paramView.type == 2)
    {
      DownloadSearchUI.a(this.lbG).Kd(paramView.lbI);
      DownloadSearchUI.b(this.lbG).setSearchContent(paramView.lbI);
      com.tencent.mm.plugin.downloader_app.c.a.a(13, 1302, paramView.position, 2, "", "", com.tencent.mm.plugin.downloader_app.c.a.dG("search_key_word", paramView.lbI));
      AppMethodBeat.o(136181);
      return;
    }
    if (paramView.type == 3)
    {
      DownloadSearchUI.a(this.lbG).Kd(DownloadSearchUI.b(this.lbG).getSearchContent());
      if (!bo.isNullOrNil(paramView.jumpUrl))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("rawUrl", paramView.jumpUrl);
        ((d)g.E(d.class)).g(this.lbG.getContext(), localBundle);
      }
      com.tencent.mm.plugin.downloader_app.c.a.a(13, 1303, paramView.position, 40, paramView.appId, "", "");
    }
    AppMethodBeat.o(136181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI.1
 * JD-Core Version:    0.7.0.1
 */
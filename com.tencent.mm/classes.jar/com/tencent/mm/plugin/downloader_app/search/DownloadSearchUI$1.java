package com.tencent.mm.plugin.downloader_app.search;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.n;
import java.util.List;

final class DownloadSearchUI$1
  implements MRecyclerView.a
{
  DownloadSearchUI$1(DownloadSearchUI paramDownloadSearchUI) {}
  
  public final void B(View paramView, int paramInt)
  {
    paramView = DownloadSearchUI.a(this.iSV).iSN.hka;
    if ((paramView != null) && (paramInt >= 0) && (paramInt < paramView.size()))
    {
      paramView = (b)paramView.get(paramInt);
      if (paramView != null) {
        break label53;
      }
    }
    label53:
    do
    {
      do
      {
        return;
        paramView = null;
        break;
        if (paramView.type == 2)
        {
          DownloadSearchUI.a(this.iSV).Ag(paramView.iSX);
          DownloadSearchUI.b(this.iSV).setSearchContent(paramView.iSX);
          return;
        }
      } while (paramView.type != 3);
      DownloadSearchUI.a(this.iSV).Ag(DownloadSearchUI.b(this.iSV).getSearchContent());
    } while (bk.bl(paramView.jumpUrl));
    Bundle localBundle = new Bundle();
    localBundle.putString("rawUrl", paramView.jumpUrl);
    ((com.tencent.mm.plugin.downloader_app.a.a)g.r(com.tencent.mm.plugin.downloader_app.a.a.class)).e(this.iSV.mController.uMN, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI.1
 * JD-Core Version:    0.7.0.1
 */
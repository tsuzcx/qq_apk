package com.tencent.mm.plugin.downloader_app.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class a$a$2
  implements View.OnClickListener
{
  a$a$2(a.a parama, a parama1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136164);
    paramView = (b)paramView.getTag();
    DownloadSearchListView localDownloadSearchListView = this.lbw.lbu.lbi;
    String str = paramView.lbI;
    if (!bo.isNullOrNil(str))
    {
      b.al(localDownloadSearchListView.mContext, str);
      localDownloadSearchListView.lby = b.dI(localDownloadSearchListView.mContext);
      localDownloadSearchListView.setData(localDownloadSearchListView.lby);
    }
    com.tencent.mm.plugin.downloader_app.c.a.a(13, 1302, paramView.position, 81, "", "", "");
    AppMethodBeat.o(136164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a.a.2
 * JD-Core Version:    0.7.0.1
 */
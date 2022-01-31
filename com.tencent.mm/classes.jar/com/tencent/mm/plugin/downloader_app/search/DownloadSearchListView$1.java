package com.tencent.mm.plugin.downloader_app.search;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.mm.plugin.downloader.b.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;

final class DownloadSearchListView$1
  implements a.b
{
  DownloadSearchListView$1(DownloadSearchListView paramDownloadSearchListView) {}
  
  public final void X(int paramInt, String paramString)
  {
    if (paramInt == 9)
    {
      a locala = DownloadSearchListView.a(this.iSR);
      if ((!bk.dk(locala.hka)) && (!bk.bl(paramString)))
      {
        Iterator localIterator = locala.hka.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((localb.appId != null) && (localb.appId.equals(paramString))) {
            localb.state = 2;
          }
        }
        locala.agL.notifyChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchListView.1
 * JD-Core Version:    0.7.0.1
 */
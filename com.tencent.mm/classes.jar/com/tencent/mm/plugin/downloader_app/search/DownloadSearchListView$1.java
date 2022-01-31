package com.tencent.mm.plugin.downloader_app.search;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

final class DownloadSearchListView$1
  implements a.b
{
  DownloadSearchListView$1(DownloadSearchListView paramDownloadSearchListView) {}
  
  public final void H(int paramInt, long paramLong)
  {
    AppMethodBeat.i(136173);
    if (paramInt == 9)
    {
      Object localObject = d.iJ(paramLong);
      if (localObject != null)
      {
        a locala = DownloadSearchListView.a(this.lbB);
        localObject = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
        if ((!bo.es(locala.iVH)) && (!bo.isNullOrNil((String)localObject)))
        {
          Iterator localIterator = locala.iVH.iterator();
          while (localIterator.hasNext())
          {
            b localb = (b)localIterator.next();
            if ((localb.appId != null) && (localb.appId.equals(localObject))) {
              localb.state = 2;
            }
          }
          locala.ajb.notifyChanged();
        }
      }
    }
    AppMethodBeat.o(136173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchListView.1
 * JD-Core Version:    0.7.0.1
 */
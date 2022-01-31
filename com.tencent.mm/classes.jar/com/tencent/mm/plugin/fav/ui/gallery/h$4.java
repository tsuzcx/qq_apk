package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class h$4
  implements Runnable
{
  h$4(h paramh, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    int j = 100;
    if (this.kik)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(Integer.valueOf(21));
      this.kij.idList = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavSearchStorage().a(null, null, (List)localObject1);
      this.kij.kih = this.kij.idList.size();
    }
    int i = j;
    if (this.ejr >= 0)
    {
      i = j;
      if (this.kij.kih - this.ejr > 100) {
        i = this.kij.kih - this.ejr;
      }
    }
    y.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[] { Integer.valueOf(this.ejr), Integer.valueOf(i) });
    Object localObject1 = new LinkedList();
    while ((((LinkedList)localObject1).size() < i) && (this.kij.kii < this.kij.idList.size()))
    {
      int k = this.kij.kii;
      if (k + i > this.kij.idList.size()) {}
      for (j = this.kij.idList.size();; j = k + i)
      {
        Object localObject2 = h.bw(this.kij.idList.subList(k, j));
        this.kij.kii = j;
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((LinkedList)localObject1).addAll(h.F((com.tencent.mm.plugin.fav.a.g)((Iterator)localObject2).next()));
        }
      }
      y.i("MicroMsg.MediaHistoryGalleryPresenter", "traverse until size ok. start:%s, end:%s, idListSize:%s, limit:%s, linklistSize:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(this.kij.idList.size()), Integer.valueOf(i), Integer.valueOf(((LinkedList)localObject1).size()) });
    }
    i = ((LinkedList)localObject1).size();
    Collections.reverse((List)localObject1);
    this.kij.hka.addAll(0, (Collection)localObject1);
    ((LinkedList)localObject1).clear();
    y.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", new Object[] { Integer.valueOf(this.kij.hka.size()) });
    ai.d(new h.4.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
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
    AppMethodBeat.i(74594);
    if (this.kFC)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(Integer.valueOf(21));
      this.mCP.idList = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavSearchStorage().b(null, null, (List)localObject1);
      this.mCP.mCN = this.mCP.idList.size();
    }
    int i = j;
    if (this.fzv >= 0)
    {
      i = j;
      if (this.mCP.mCN - this.fzv > 100) {
        i = this.mCP.mCN - this.fzv;
      }
    }
    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[] { Integer.valueOf(this.fzv), Integer.valueOf(i) });
    Object localObject1 = new LinkedList();
    while ((((LinkedList)localObject1).size() < i) && (this.mCP.mCO < this.mCP.idList.size()))
    {
      int k = this.mCP.mCO;
      if (k + i > this.mCP.idList.size()) {}
      for (j = this.mCP.idList.size();; j = k + i)
      {
        Object localObject2 = h.bQ(this.mCP.idList.subList(k, j));
        this.mCP.mCO = j;
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((LinkedList)localObject1).addAll(h.G((com.tencent.mm.plugin.fav.a.g)((Iterator)localObject2).next()));
        }
      }
      ab.i("MicroMsg.MediaHistoryGalleryPresenter", "traverse until size ok. start:%s, end:%s, idListSize:%s, limit:%s, linklistSize:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(this.mCP.idList.size()), Integer.valueOf(i), Integer.valueOf(((LinkedList)localObject1).size()) });
    }
    i = ((LinkedList)localObject1).size();
    Collections.reverse((List)localObject1);
    this.mCP.iVH.addAll(0, (Collection)localObject1);
    ((LinkedList)localObject1).clear();
    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", new Object[] { Integer.valueOf(this.mCP.iVH.size()) });
    al.d(new h.4.1(this, i));
    AppMethodBeat.o(74594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h.4
 * JD-Core Version:    0.7.0.1
 */
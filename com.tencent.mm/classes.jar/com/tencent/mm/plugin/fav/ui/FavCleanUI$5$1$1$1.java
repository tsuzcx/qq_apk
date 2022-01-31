package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.widget.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class FavCleanUI$5$1$1$1
  implements Runnable
{
  FavCleanUI$5$1$1$1(FavCleanUI.5.1.1 param1) {}
  
  public final void run()
  {
    b localb = FavCleanUI.e(this.kbJ.kbI.kbF.kbE);
    List localList = this.kbJ.kbG;
    ArrayList localArrayList;
    Iterator localIterator1;
    if (localb.keC != null)
    {
      localArrayList = new ArrayList();
      localIterator1 = localb.keC.iterator();
    }
    label323:
    label328:
    for (;;)
    {
      Object localObject;
      Iterator localIterator2;
      g localg;
      if (localIterator1.hasNext())
      {
        localObject = (g)localIterator1.next();
        if (localObject != null)
        {
          localIterator2 = localList.iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
            localg = (g)localIterator2.next();
          } while ((localg == null) || (((g)localObject).field_localId != localg.field_localId));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label328;
          }
          localArrayList.add(localObject);
          break;
          localb.keC = localArrayList;
          localArrayList = new ArrayList();
          localIterator1 = localb.keF.iterator();
          for (;;)
          {
            if (localIterator1.hasNext())
            {
              localObject = (Long)localIterator1.next();
              localIterator2 = localList.iterator();
              do
              {
                if (!localIterator2.hasNext()) {
                  break;
                }
                localg = (g)localIterator2.next();
              } while ((localg == null) || (!((Long)localObject).equals(Long.valueOf(localg.field_localId))));
            }
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label323;
              }
              localArrayList.add(localObject);
              break;
              localb.keF = localArrayList;
              FavCleanUI.e(this.kbJ.kbI.kbF.kbE).notifyDataSetChanged();
              FavCleanUI.f(this.kbJ.kbI.kbF.kbE).aRZ();
              this.kbJ.kbH.dismiss();
              return;
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|batchDelFavItems";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI.5.1.1.1
 * JD-Core Version:    0.7.0.1
 */
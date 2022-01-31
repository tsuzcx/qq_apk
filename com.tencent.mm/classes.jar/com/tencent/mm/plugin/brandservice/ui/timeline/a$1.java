package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.ai.z;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.r.c;
import java.util.Iterator;
import java.util.List;

final class a$1
  implements r.c
{
  a$1(a parama) {}
  
  public final void a(r.a parama)
  {
    if ((parama != null) && (parama.unc)) {}
    StoryListView localStoryListView;
    do
    {
      return;
      localStoryListView = a.a(this.ifl).igM;
    } while (localStoryListView == null);
    int j = localStoryListView.getFirstVisiblePosition();
    Object localObject = a.a(this.ifl);
    int i;
    if ((((BizTimeLineUI)localObject).ieQ.getVisibility() == 0) || (((BizTimeLineUI)localObject).igP.getVisibility() == 0))
    {
      i = 1;
      if (i != 0) {
        break label645;
      }
      i = j;
      if (j == 0) {
        i = 1;
      }
    }
    label384:
    label645:
    for (int k = i;; k = j)
    {
      localObject = localStoryListView.getChildAt(0);
      label102:
      long l;
      if (localObject != null)
      {
        j = ((View)localObject).getTop();
        localStoryListView.setBlockLayoutChildren(true);
        if (parama == null) {
          break label632;
        }
        if ((parama.unb != r.b.und) || (parama.igD == null)) {
          break label416;
        }
        boolean bool = a.b(this.ifl);
        if (a.c(this.ifl).size() <= 0) {
          break label384;
        }
        i = 0;
        label155:
        if (i >= a.c(this.ifl).size()) {
          break label379;
        }
        localObject = (q)a.c(this.ifl).get(i);
        if (parama.igD.field_orderFlag <= ((q)localObject).field_orderFlag) {
          break label372;
        }
        a.c(this.ifl).add(i, parama.igD);
        i = 1;
        label224:
        if ((bool) && (a.axQ() == null))
        {
          l = -1L;
          parama = a.c(this.ifl).iterator();
          label253:
          if (parama.hasNext())
          {
            localObject = (q)parama.next();
            if ((l == -1L) || (l == ((q)localObject).cty())) {
              break label406;
            }
            a.e(Long.valueOf(((q)localObject).field_orderFlag));
          }
        }
        a.d(this.ifl).a("", 0L, 5);
        label319:
        a.a(this.ifl).aya();
        this.ifl.notifyDataSetChanged();
        localStoryListView.setBlockLayoutChildren(false);
        if (i <= 0) {
          break;
        }
        if (k != 0) {
          break label637;
        }
        i = 0;
      }
      for (;;)
      {
        j.a(localStoryListView, i, j, false);
        return;
        i = 0;
        break;
        j = 0;
        break label102;
        label372:
        i += 1;
        break label155;
        label379:
        i = 0;
        break label224;
        a.c(this.ifl).add(parama.igD);
        i = 0;
        break label224;
        label406:
        l = ((q)localObject).cty();
        break label253;
        label416:
        if (parama.unb == r.b.une)
        {
          a.e(this.ifl);
          parama = this.ifl;
          localObject = parama.axL();
          if (localObject != null)
          {
            parama.hfb.clear();
            parama.hfb.addAll(z.ME().hx(((q)localObject).field_orderFlag));
          }
          if ((a.axQ() != null) && (z.ME().D(a.axQ().longValue(), "orderFlag") == null)) {
            i = 0;
          }
          for (;;)
          {
            if (i < a.c(this.ifl).size())
            {
              parama = (q)a.c(this.ifl).get(i);
              if (parama.field_orderFlag < a.axQ().longValue()) {
                a.e(Long.valueOf(parama.field_orderFlag));
              }
            }
            else
            {
              if ((a.axR() == null) || (z.ME().D(a.axR().longValue(), "msgId") != null)) {
                break label632;
              }
              a.axS();
              i = 0;
              break;
            }
            i += 1;
          }
        }
        if ((parama.unb == r.b.unf) && (!bk.dk(parama.list))) {
          a.a(this.ifl, parama.list);
        }
        label632:
        i = 0;
        break label319;
        label637:
        i += k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.1
 * JD-Core Version:    0.7.0.1
 */
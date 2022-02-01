package com.tencent.mm.plugin.finder.feed.jumper;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderTencentVideoHandler;", "Lcom/tencent/mm/plugin/finder/feed/jumper/DefaultJumperViewHandler;", "()V", "onClickDo", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "jumpView", "Landroid/view/View;", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends f
{
  public final void a(j paramj, View paramView, k paramk)
  {
    AppMethodBeat.i(364174);
    s.u(paramj, "holder");
    s.u(paramView, "jumpView");
    s.u(paramk, "infoEx");
    Object localObject1 = paramk.AUZ;
    long l;
    String str1;
    if (localObject1 == null)
    {
      l = 0L;
      str1 = d.hF(l);
      localObject1 = paramk.AUZ;
      if (localObject1 != null) {
        break label181;
      }
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject2 = r.Bej;
      localObject2 = r.a(paramj, edA());
      String str2 = z.bAW();
      paramk.extra = ("shortvideoid=" + str1 + "&cpid=" + (String)localObject1 + "&duration=" + ((Number)((kotlin.r)localObject2).bsC).intValue() + "&playPercent=" + ((Number)((kotlin.r)localObject2).bsD).intValue() + "&visitorUsername=" + str2);
      super.a(paramj, paramView, paramk);
      AppMethodBeat.o(364174);
      return;
      l = ((BaseFinderFeed)localObject1).bZA();
      break;
      label181:
      localObject1 = ((BaseFinderFeed)localObject1).feedObject;
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((FinderItem)localObject1).getUserName();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.o
 * JD-Core Version:    0.7.0.1
 */
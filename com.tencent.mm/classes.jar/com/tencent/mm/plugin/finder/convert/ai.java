package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "type", "isHotPatch", "payloads", "", "", "plugin-finder_release"})
public class ai
  extends u
{
  private ai(i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(165422);
    AppMethodBeat.o(165422);
  }
  
  public void a(h paramh, com.tencent.mm.plugin.finder.model.u paramu, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(165419);
    p.h(paramh, "holder");
    p.h(paramu, "item");
    super.a(paramh, paramu, paramInt1, paramInt2, paramBoolean, paramList);
    paramh.aus.setOnLongClickListener((View.OnLongClickListener)new a(paramu));
    AppMethodBeat.o(165419);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class a
    implements View.OnLongClickListener
  {
    a(com.tencent.mm.plugin.finder.model.u paramu) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(165418);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
      Log.i("Finder.FeedConvert", "text=" + this.tDY.feedObject.getDescription());
      a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(165418);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ai
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "type", "isHotPatch", "payloads", "", "", "plugin-finder_release"})
public class u
  extends k
{
  private u(h paramh, boolean paramBoolean, int paramInt)
  {
    super(paramh, paramBoolean, paramInt);
    AppMethodBeat.i(165422);
    AppMethodBeat.o(165422);
  }
  
  public void a(e parame, o paramo, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(165419);
    p.h(parame, "holder");
    p.h(paramo, "item");
    super.a(parame, (BaseFinderFeed)paramo, paramInt1, paramInt2, paramBoolean, paramList);
    parame.auu.setOnLongClickListener((View.OnLongClickListener)new a(paramo));
    AppMethodBeat.o(165419);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class a
    implements View.OnLongClickListener
  {
    a(o paramo) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(165418);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
      ae.i("Finder.FeedConvert", "text=" + this.rWW.feedObject.getDescription());
      a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(165418);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.u
 * JD-Core Version:    0.7.0.1
 */
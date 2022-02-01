package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "type", "isHotPatch", "payloads", "", "", "plugin-finder_release"})
public class t
  extends j
{
  private t(g paramg, boolean paramBoolean, int paramInt)
  {
    super(paramg, paramBoolean, paramInt);
    AppMethodBeat.i(165422);
    AppMethodBeat.o(165422);
  }
  
  public void a(e parame, m paramm, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(165419);
    k.h(parame, "holder");
    k.h(paramm, "item");
    super.a(parame, (BaseFinderFeed)paramm, paramInt1, paramInt2, paramBoolean, paramList);
    parame.asD.setOnLongClickListener((View.OnLongClickListener)new a(paramm));
    AppMethodBeat.o(165419);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class a
    implements View.OnLongClickListener
  {
    a(m paramm) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(165418);
      ac.i("Finder.FeedConvert", "text=" + this.rbG.feedObject.getDescription());
      AppMethodBeat.o(165418);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.t
 * JD-Core Version:    0.7.0.1
 */
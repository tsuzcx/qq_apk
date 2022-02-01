package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "type", "isHotPatch", "payloads", "", "", "plugin-finder_release"})
public class o
  extends g
{
  private o(c paramc, boolean paramBoolean, int paramInt)
  {
    super(paramc, paramBoolean, paramInt);
    AppMethodBeat.i(165422);
    AppMethodBeat.o(165422);
  }
  
  public void a(e parame, i parami, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(165419);
    k.h(parame, "holder");
    k.h(parami, "item");
    super.a(parame, (BaseFinderFeed)parami, paramInt1, paramInt2, paramBoolean, paramList);
    parame.arI.setOnLongClickListener((View.OnLongClickListener)new a(parami));
    AppMethodBeat.o(165419);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class a
    implements View.OnLongClickListener
  {
    a(i parami) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(165418);
      ad.i("Finder.FeedConvert", "text=" + this.qrw.feedObject.getDescription());
      AppMethodBeat.o(165418);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.o
 * JD-Core Version:    0.7.0.1
 */
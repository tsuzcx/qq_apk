package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileEduUIC;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderDraftInfoConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "()V", "getLayoutId", "", "getStr", "", "context", "Landroid/content/Context;", "resId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setDefaultAvatarImage", "imageView", "Landroid/widget/ImageView;", "setImage", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
public final class e
  extends com.tencent.mm.view.recyclerview.e<q>
{
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(242775);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(242775);
  }
  
  public final int getLayoutId()
  {
    return 2131494589;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(h paramh, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(242774);
      Object localObject = a.PRN;
      localObject = this.qhp.getContext();
      p.g(localObject, "holder.context");
      ((FinderProfileEduUIC)a.ko((Context)localObject).get(FinderProfileEduUIC.class)).gP("draft", this.tzi);
      AppMethodBeat.o(242774);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e
 * JD-Core Version:    0.7.0.1
 */
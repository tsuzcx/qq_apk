package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.profile.uic.f;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderDraftInfoConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "()V", "getLayoutId", "", "getStr", "", "context", "Landroid/content/Context;", "resId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setDefaultAvatarImage", "imageView", "Landroid/widget/ImageView;", "setImage", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Companion", "plugin-finder_release"})
public final class e
  extends com.tencent.mm.view.recyclerview.e<q>
{
  public static final a xgS;
  
  static
  {
    AppMethodBeat.i(292177);
    xgS = new a((byte)0);
    AppMethodBeat.o(292177);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(292175);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(292175);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_profile_music_draft_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderDraftInfoConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(i parami, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(290859);
      Object localObject = g.Xox;
      localObject = this.tDl.getContext();
      p.j(localObject, "holder.context");
      ((f)g.lm((Context)localObject).i(f.class)).M("draft", 0, this.xgT);
      AppMethodBeat.o(290859);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e
 * JD-Core Version:    0.7.0.1
 */
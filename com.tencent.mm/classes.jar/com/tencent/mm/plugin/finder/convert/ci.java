package com.tencent.mm.plugin.finder.convert;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderSearchActivityConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderActivityInfoFeed;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ci
  extends f<m>
{
  public static final a AMl;
  private static final e AMm;
  
  static
  {
    AppMethodBeat.i(349725);
    AMl = new a((byte)0);
    e.a locala = new e.a();
    locala.nqd = true;
    locala.nqc = true;
    locala.nqk = e.g.finder_filled_activity;
    d locald = d.FAy;
    locala.nqh = d.eQo();
    locald = d.FAy;
    locala.nqg = d.eQp();
    AMm = locala.b((Animation)new AlphaAnimation(0.0F, 1.0F)).blI();
    AppMethodBeat.o(349725);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349737);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(349737);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_select_activity_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderSearchActivityConvert$Companion;", "", "()V", "option", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getOption", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ci
 * JD-Core Version:    0.7.0.1
 */
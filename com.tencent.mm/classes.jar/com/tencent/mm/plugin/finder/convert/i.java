package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Paint;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedBulletSubtitleConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorItemPaddingStart", "", "getAuthorItemPaddingStart", "()I", "authorItemPaddingStart$delegate", "Lkotlin/Lazy;", "normalPaddingStart", "getNormalPaddingStart", "normalPaddingStart$delegate", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends f<t>
{
  private final kotlin.j AHG;
  private final kotlin.j AHH;
  final Context context;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(350417);
    this.context = paramContext;
    this.AHG = k.cm((a)new b(this));
    this.AHH = k.cm((a)new a(this));
    AppMethodBeat.o(350417);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(350424);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    aw.a((Paint)((TextView)paramj.UH(e.e.tv_bullet_subtitle)).getPaint(), 0.8F);
    AppMethodBeat.o(350424);
  }
  
  public final int getLayoutId()
  {
    return e.f.feed_bullet_subtitle_item;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Integer>
  {
    a(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Integer>
  {
    b(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.i
 * JD-Core Version:    0.7.0.1
 */
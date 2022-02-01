package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.publish.c;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderDraftInfoConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "()V", "deleteItem", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "posting", "", "getLayoutId", "", "getStr", "", "context", "Landroid/content/Context;", "resId", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setDefaultAvatarImage", "imageView", "Landroid/widget/ImageView;", "setImage", "defaultImageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isMusicTag", "updateProgress", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends f<q>
{
  public static final a AHF;
  
  static
  {
    AppMethodBeat.i(350481);
    AHF = new a((byte)0);
    AppMethodBeat.o(350481);
  }
  
  private static final void a(e parame, com.tencent.mm.view.recyclerview.j paramj, i parami, View paramView)
  {
    AppMethodBeat.i(350474);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramj);
    localb.cH(parami);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderDraftInfoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    s.u(paramj, "$holder");
    s.u(parami, "$it");
    parami.isPostFailed();
    long l = parami.field_localId;
    com.tencent.mm.plugin.finder.storage.j.FKc.pY(l);
    parame = d.hF(l);
    parami = k.aeZF;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    ((com.tencent.mm.plugin.finder.profile.uic.e)k.nq(paramj).q(com.tencent.mm.plugin.finder.profile.uic.e.class)).O("draftdelete", 1, parame);
    a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderDraftInfoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350474);
  }
  
  private static final void a(q paramq, View paramView)
  {
    AppMethodBeat.i(350468);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramq);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderDraftInfoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramq, "$item");
    ((c)h.az(c.class)).finderPostManager().fz(paramq.ABX);
    a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderDraftInfoConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350468);
  }
  
  private static final void a(FinderPostProgressView paramFinderPostProgressView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(350460);
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramFinderPostProgressView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(350460);
      throw paramFinderPostProgressView;
    }
    paramFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
    paramFinderPostProgressView.invalidate();
    AppMethodBeat.o(350460);
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, String paramString)
  {
    AppMethodBeat.i(350453);
    s.u(paramj, "$holder");
    s.u(paramString, "$feedId");
    k localk = k.aeZF;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    ((com.tencent.mm.plugin.finder.profile.uic.e)k.nq(paramj).q(com.tencent.mm.plugin.finder.profile.uic.e.class)).O("draft", 0, paramString);
    AppMethodBeat.o(350453);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(350516);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350516);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_music_draft_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderDraftInfoConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e
 * JD-Core Version:    0.7.0.1
 */
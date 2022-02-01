package com.tencent.mm.plugin.finder.convert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.model.f;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "()V", "feedCommentFailedNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert;", "feedMsgNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "feedMsgNotifyHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "privateMsgNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert;", "privateMsgNotifyHolder", "getLayoutId", "", "handleCommentFailed", "", "parent", "Landroid/view/ViewGroup;", "item", "holder", "position", "type", "isHotPatch", "", "payloads", "", "", "onBindViewHolder", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class t
  extends e<aj>
{
  public static final a xlh;
  private final ad xlc;
  private final ca xld;
  private final j xle;
  private i xlf;
  private i xlg;
  
  static
  {
    AppMethodBeat.i(285300);
    xlh = new a((byte)0);
    AppMethodBeat.o(285300);
  }
  
  public t()
  {
    AppMethodBeat.i(285299);
    this.xlc = new ad();
    this.xld = new ca();
    this.xle = new j();
    AppMethodBeat.o(285299);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(285296);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    Object localObject1 = com.tencent.mm.ui.ad.kS(parami.getContext());
    paramInt = b.g._feed_header_msg_notify_item;
    Object localObject2 = parami.amk;
    if (localObject2 == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(285296);
      throw paramRecyclerView;
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(paramInt, (ViewGroup)localObject2, false);
    localObject2 = com.tencent.mm.ui.ad.kS(parami.getContext());
    paramInt = b.g._feed_header_private_msg_notify_item;
    View localView = parami.amk;
    if (localView == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(285296);
      throw paramRecyclerView;
    }
    localObject2 = ((LayoutInflater)localObject2).inflate(paramInt, (ViewGroup)localView, false);
    paramInt = d.e(paramRecyclerView.getContext(), 6.0F);
    localView = ((View)localObject2).findViewById(b.f.msg_layout);
    Object localObject3;
    if (localView != null)
    {
      localObject3 = localView.getLayoutParams();
      if (localObject3 == null)
      {
        paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(285296);
        throw paramRecyclerView;
      }
      localObject3 = (FrameLayout.LayoutParams)localObject3;
      ((FrameLayout.LayoutParams)localObject3).topMargin = (paramInt * 2);
      ((FrameLayout.LayoutParams)localObject3).bottomMargin = paramInt;
      localView.setBackgroundResource(b.e.feed_full_msg_layout_selector);
    }
    localView = ((View)localObject2).findViewById(b.f.msg_layout);
    if (localView != null)
    {
      localObject3 = localView.getLayoutParams();
      if (localObject3 == null)
      {
        paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(285296);
        throw paramRecyclerView;
      }
      localObject3 = (FrameLayout.LayoutParams)localObject3;
      ((FrameLayout.LayoutParams)localObject3).topMargin = paramInt;
      ((FrameLayout.LayoutParams)localObject3).bottomMargin = paramInt;
      localView.setBackgroundResource(b.e.feed_full_msg_layout_selector);
    }
    localView = parami.amk;
    if (localView == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(285296);
      throw paramRecyclerView;
    }
    ((ViewGroup)localView).addView((View)localObject1);
    parami = parami.amk;
    if (parami == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(285296);
      throw paramRecyclerView;
    }
    ((ViewGroup)parami).addView((View)localObject2);
    parami = new i((View)localObject1);
    parami.setRecyclerView(paramRecyclerView);
    this.xlf = parami;
    parami = new i((View)localObject2);
    parami.setRecyclerView(paramRecyclerView);
    this.xlg = parami;
    parami = this.xlc;
    localObject1 = this.xlf;
    if (localObject1 == null) {
      p.bGy("feedMsgNotifyHolder");
    }
    parami.a(paramRecyclerView, (i)localObject1, -5);
    parami = this.xld;
    localObject1 = this.xlg;
    if (localObject1 == null) {
      p.bGy("privateMsgNotifyHolder");
    }
    parami.a(paramRecyclerView, (i)localObject1, -6);
    AppMethodBeat.o(285296);
  }
  
  public final void a(i parami, aj paramaj, int paramInt)
  {
    AppMethodBeat.i(285297);
    p.k(parami, "holder");
    p.k(paramaj, "item");
    Object localObject1 = this.xlf;
    if (localObject1 == null) {
      p.bGy("feedMsgNotifyHolder");
    }
    ((i)localObject1).ez(paramaj.msgNotifyData);
    localObject1 = this.xlg;
    if (localObject1 == null) {
      p.bGy("privateMsgNotifyHolder");
    }
    ((i)localObject1).ez(paramaj.xCY);
    localObject1 = this.xlf;
    if (localObject1 == null) {
      p.bGy("feedMsgNotifyHolder");
    }
    ad.a((i)localObject1, paramaj.msgNotifyData);
    localObject1 = this.xld;
    Object localObject2 = this.xlg;
    if (localObject2 == null) {
      p.bGy("privateMsgNotifyHolder");
    }
    ((ca)localObject1).a((i)localObject2, paramaj.xCY, paramInt);
    localObject1 = parami.amk;
    if (localObject1 == null)
    {
      parami = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(285297);
      throw parami;
    }
    localObject1 = (ViewGroup)localObject1;
    localObject2 = new HashSet();
    int i = ((ViewGroup)localObject1).getChildCount();
    paramInt = 0;
    Object localObject3;
    while (paramInt < i)
    {
      localObject3 = ((ViewGroup)localObject1).getChildAt(paramInt);
      p.j(localObject3, "child");
      if (((View)localObject3).getId() == b.f.comment_failed_notify_layout) {
        ((HashSet)localObject2).add(localObject3);
      }
      paramInt += 1;
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ViewGroup)localObject1).removeView((View)((Iterator)localObject2).next());
    }
    paramInt = d.e(((ViewGroup)localObject1).getContext(), 6.0F);
    paramaj = ((Iterable)paramaj.xDc).iterator();
    while (paramaj.hasNext())
    {
      localObject2 = (f)paramaj.next();
      if (((f)localObject2).zAc != 1)
      {
        localObject3 = com.tencent.mm.ui.ad.kS(parami.getContext()).inflate(b.g._feed_header_comment_failed_notify_item, (ViewGroup)localObject1, false);
        Object localObject4 = ((View)localObject3).findViewById(b.f.msg_layout);
        if (localObject4 != null)
        {
          localObject5 = ((View)localObject4).getLayoutParams();
          if (localObject5 == null)
          {
            parami = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(285297);
            throw parami;
          }
          localObject5 = (FrameLayout.LayoutParams)localObject5;
          ((FrameLayout.LayoutParams)localObject5).topMargin = paramInt;
          ((FrameLayout.LayoutParams)localObject5).bottomMargin = paramInt;
          ((View)localObject4).setBackgroundResource(b.e.feed_full_msg_layout_selector);
        }
        localObject4 = parami.amk;
        if (localObject4 == null)
        {
          parami = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(285297);
          throw parami;
        }
        ((ViewGroup)localObject4).addView((View)localObject3);
        localObject3 = new i((View)localObject3);
        ((i)localObject3).setRecyclerView(parami.getRecyclerView());
        ((i)localObject3).ez(localObject2);
        localObject4 = this.xle;
        Object localObject5 = ((i)localObject3).getRecyclerView();
        p.j(localObject5, "h.recyclerView");
        ((j)localObject4).a((RecyclerView)localObject5, (i)localObject3, -4);
        localObject4 = this.xle;
        p.j(localObject2, "data");
        ((j)localObject4).a((i)localObject3, (f)localObject2);
      }
    }
    AppMethodBeat.o(285297);
  }
  
  public final int getLayoutId()
  {
    return b.g._feed_full_merged_header_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.t
 * JD-Core Version:    0.7.0.1
 */
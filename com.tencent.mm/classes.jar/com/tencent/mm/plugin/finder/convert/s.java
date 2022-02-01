package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.model.f;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "()V", "feedCommentFailedNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentFailedNotifyConvert;", "feedMsgNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "feedMsgNotifyHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "privateMsgNotifyConvert", "Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert;", "privateMsgNotifyHolder", "getLayoutId", "", "handleCommentFailed", "", "parent", "Landroid/view/ViewGroup;", "item", "holder", "position", "type", "isHotPatch", "", "payloads", "", "", "onBindViewHolder", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class s
  extends e<ah>
{
  public static final a tCO;
  private final ab tCJ;
  private final bx tCK;
  private final i tCL;
  private h tCM;
  private h tCN;
  
  static
  {
    AppMethodBeat.i(242996);
    tCO = new a((byte)0);
    AppMethodBeat.o(242996);
  }
  
  public s()
  {
    AppMethodBeat.i(242995);
    this.tCJ = new ab();
    this.tCK = new bx();
    this.tCL = new i();
    AppMethodBeat.o(242995);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(242992);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    Object localObject1 = aa.jQ(paramh.getContext());
    Object localObject2 = paramh.aus;
    if (localObject2 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(242992);
      throw paramRecyclerView;
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131492872, (ViewGroup)localObject2, false);
    localObject2 = aa.jQ(paramh.getContext());
    View localView = paramh.aus;
    if (localView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(242992);
      throw paramRecyclerView;
    }
    localObject2 = ((LayoutInflater)localObject2).inflate(2131492873, (ViewGroup)localView, false);
    paramInt = d.e(paramRecyclerView.getContext(), 6.0F);
    localView = ((View)localObject2).findViewById(2131304963);
    Object localObject3;
    if (localView != null)
    {
      localObject3 = localView.getLayoutParams();
      if (localObject3 == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(242992);
        throw paramRecyclerView;
      }
      localObject3 = (FrameLayout.LayoutParams)localObject3;
      ((FrameLayout.LayoutParams)localObject3).topMargin = (paramInt * 2);
      ((FrameLayout.LayoutParams)localObject3).bottomMargin = paramInt;
      localView.setBackgroundResource(2131232408);
    }
    localView = ((View)localObject2).findViewById(2131304963);
    if (localView != null)
    {
      localObject3 = localView.getLayoutParams();
      if (localObject3 == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(242992);
        throw paramRecyclerView;
      }
      localObject3 = (FrameLayout.LayoutParams)localObject3;
      ((FrameLayout.LayoutParams)localObject3).topMargin = paramInt;
      ((FrameLayout.LayoutParams)localObject3).bottomMargin = paramInt;
      localView.setBackgroundResource(2131232408);
    }
    localView = paramh.aus;
    if (localView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(242992);
      throw paramRecyclerView;
    }
    ((ViewGroup)localView).addView((View)localObject1);
    paramh = paramh.aus;
    if (paramh == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(242992);
      throw paramRecyclerView;
    }
    ((ViewGroup)paramh).addView((View)localObject2);
    paramh = new h((View)localObject1);
    paramh.setRecyclerView(paramRecyclerView);
    this.tCM = paramh;
    paramh = new h((View)localObject2);
    paramh.setRecyclerView(paramRecyclerView);
    this.tCN = paramh;
    paramh = this.tCJ;
    localObject1 = this.tCM;
    if (localObject1 == null) {
      p.btv("feedMsgNotifyHolder");
    }
    paramh.a(paramRecyclerView, (h)localObject1, -5);
    paramh = this.tCK;
    localObject1 = this.tCN;
    if (localObject1 == null) {
      p.btv("privateMsgNotifyHolder");
    }
    paramh.a(paramRecyclerView, (h)localObject1, -6);
    AppMethodBeat.o(242992);
  }
  
  public final void a(h paramh, ah paramah, int paramInt)
  {
    AppMethodBeat.i(242993);
    p.h(paramh, "holder");
    p.h(paramah, "item");
    Object localObject1 = this.tCM;
    if (localObject1 == null) {
      p.btv("feedMsgNotifyHolder");
    }
    ((h)localObject1).et(paramah.msgNotifyData);
    localObject1 = this.tCN;
    if (localObject1 == null) {
      p.btv("privateMsgNotifyHolder");
    }
    ((h)localObject1).et(paramah.tSf);
    localObject1 = this.tCM;
    if (localObject1 == null) {
      p.btv("feedMsgNotifyHolder");
    }
    ab.a((h)localObject1, paramah.msgNotifyData);
    localObject1 = this.tCK;
    Object localObject2 = this.tCN;
    if (localObject2 == null) {
      p.btv("privateMsgNotifyHolder");
    }
    ((bx)localObject1).a((h)localObject2, paramah.tSf, paramInt);
    localObject1 = paramh.aus;
    if (localObject1 == null)
    {
      paramh = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(242993);
      throw paramh;
    }
    localObject1 = (ViewGroup)localObject1;
    localObject2 = new HashSet();
    int i = ((ViewGroup)localObject1).getChildCount();
    paramInt = 0;
    Object localObject3;
    while (paramInt < i)
    {
      localObject3 = ((ViewGroup)localObject1).getChildAt(paramInt);
      p.g(localObject3, "child");
      if (((View)localObject3).getId() == 2131298944) {
        ((HashSet)localObject2).add(localObject3);
      }
      paramInt += 1;
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ViewGroup)localObject1).removeView((View)((Iterator)localObject2).next());
    }
    paramInt = d.e(((ViewGroup)localObject1).getContext(), 6.0F);
    paramah = ((Iterable)paramah.tSj).iterator();
    while (paramah.hasNext())
    {
      localObject2 = (f)paramah.next();
      if (((f)localObject2).uNO != 1)
      {
        localObject3 = aa.jQ(paramh.getContext()).inflate(2131492869, (ViewGroup)localObject1, false);
        Object localObject4 = ((View)localObject3).findViewById(2131304963);
        if (localObject4 != null)
        {
          localObject5 = ((View)localObject4).getLayoutParams();
          if (localObject5 == null)
          {
            paramh = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(242993);
            throw paramh;
          }
          localObject5 = (FrameLayout.LayoutParams)localObject5;
          ((FrameLayout.LayoutParams)localObject5).topMargin = paramInt;
          ((FrameLayout.LayoutParams)localObject5).bottomMargin = paramInt;
          ((View)localObject4).setBackgroundResource(2131232408);
        }
        localObject4 = paramh.aus;
        if (localObject4 == null)
        {
          paramh = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(242993);
          throw paramh;
        }
        ((ViewGroup)localObject4).addView((View)localObject3);
        localObject3 = new h((View)localObject3);
        ((h)localObject3).setRecyclerView(paramh.getRecyclerView());
        ((h)localObject3).et(localObject2);
        localObject4 = this.tCL;
        Object localObject5 = ((h)localObject3).getRecyclerView();
        p.g(localObject5, "h.recyclerView");
        ((i)localObject4).a((RecyclerView)localObject5, (h)localObject3, -4);
        localObject4 = this.tCL;
        p.g(localObject2, "data");
        ((i)localObject4).a((h)localObject3, (f)localObject2);
      }
    }
    AppMethodBeat.o(242993);
  }
  
  public final int getLayoutId()
  {
    return 2131492868;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullMergedHeaderConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.s
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.view.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFollowConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adjustNickNameTvSize", "", "nicknameTv", "Landroid/widget/TextView;", "authIconIV", "Landroid/view/View;", "userOnLive", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class aq
  extends e<ah>
{
  final String TAG = "FinderFollowConvert";
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(284599);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = parami.RD(b.f.finder_live_onlive_widget);
    paramRecyclerView.post((Runnable)new c(paramRecyclerView));
    AppMethodBeat.o(284599);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_contact_list_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFollowConvert$adjustNickNameTvSize$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-finder_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a(TextView paramTextView, View paramView1, View paramView2) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(283749);
      this.xmP.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = this.xmP.getParent();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(283749);
        throw ((Throwable)localObject);
      }
      int k = ((View)localObject).getWidth();
      int i = 0;
      if (this.xmQ.getVisibility() == 0) {
        i = this.xmQ.getWidth() + (int)this.xmQ.getResources().getDimension(b.d.Edge_2_5_A) + 0;
      }
      int j = i;
      if (this.xmR.getVisibility() == 0) {
        j = i + (this.xmR.getWidth() + (int)this.xmR.getResources().getDimension(b.d.Edge_A));
      }
      if (this.xmP.getWidth() + j > k)
      {
        this.xmP.setMaxWidth(k - j);
        Log.i(this.xmO.TAG, "adjustNickNameTvSize titleW:" + this.xmP.getWidth() + ", containerW:" + k + ",iconW:" + j);
      }
      AppMethodBeat.o(283749);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(com.tencent.mm.view.recyclerview.i parami, com.tencent.mm.plugin.finder.api.i parami1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(271682);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/convert/FinderFollowConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.tDl.getContext();
      p.j(paramView, "holder.context");
      new y(paramView, this.xmS.getUsername(), this.tDl.md(), false).dvx();
      a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFollowConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271682);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(280012);
      Object localObject1 = new Rect();
      this.xmT.getHitRect((Rect)localObject1);
      Object localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      int i = ((Context)localObject2).getResources().getDimensionPixelOffset(b.d.Edge_0_5_A);
      ((Rect)localObject1).inset(-i, -i);
      localObject2 = this.xmT;
      p.j(localObject2, "onliveWidget");
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(280012);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, this.xmT));
      AppMethodBeat.o(280012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aq
 * JD-Core Version:    0.7.0.1
 */
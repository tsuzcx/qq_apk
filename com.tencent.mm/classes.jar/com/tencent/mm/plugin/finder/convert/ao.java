package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.view.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFollowConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adjustNickNameTvSize", "", "nicknameTv", "Landroid/widget/TextView;", "authIconIV", "Landroid/view/View;", "userOnLive", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ao
  extends e<af>
{
  final String TAG = "FinderFollowConvert";
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243135);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = paramh.Mn(2131301215);
    paramRecyclerView.post((Runnable)new c(paramRecyclerView));
    AppMethodBeat.o(243135);
  }
  
  public final int getLayoutId()
  {
    return 2131494221;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFollowConvert$adjustNickNameTvSize$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-finder_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a(TextView paramTextView, View paramView1, View paramView2) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(243132);
      this.tEn.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = this.tEn.getParent();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(243132);
        throw ((Throwable)localObject);
      }
      int k = ((View)localObject).getWidth();
      int i = 0;
      if (this.tEo.getVisibility() == 0) {
        i = this.tEo.getWidth() + (int)this.tEo.getResources().getDimension(2131165297) + 0;
      }
      int j = i;
      if (this.tEp.getVisibility() == 0) {
        j = i + (this.tEp.getWidth() + (int)this.tEp.getResources().getDimension(2131165314));
      }
      if (this.tEn.getWidth() + j > k)
      {
        this.tEn.setMaxWidth(k - j);
        Log.i(this.tEm.TAG, "adjustNickNameTvSize titleW:" + this.tEn.getWidth() + ", containerW:" + k + ",iconW:" + j);
      }
      AppMethodBeat.o(243132);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(View paramView, g paramg, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243133);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFollowConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.tEq.getContext();
      p.g(paramView, "onliveWidget.context");
      new r(paramView, this.tEr.getUsername(), this.qhp.lR(), false).dzC();
      a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFollowConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243133);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(243134);
      Object localObject1 = new Rect();
      this.tEq.getHitRect((Rect)localObject1);
      Object localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      int i = ((Context)localObject2).getResources().getDimensionPixelOffset(2131165277);
      ((Rect)localObject1).inset(-i, -i);
      localObject2 = this.tEq;
      p.g(localObject2, "onliveWidget");
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(243134);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, this.tEq));
      AppMethodBeat.o(243134);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ao
 * JD-Core Version:    0.7.0.1
 */
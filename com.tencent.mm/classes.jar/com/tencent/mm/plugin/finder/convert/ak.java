package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.view.ag;
import com.tencent.mm.plugin.findersdk.a.cg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFollowConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adjustNickNameTvSize", "", "nicknameTv", "Landroid/widget/TextView;", "authIconIV", "Landroid/view/View;", "userOnLive", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  extends f<aj>
{
  final String TAG = "FinderFollowConvert";
  
  private static final void a(j paramj, m paramm, View paramView)
  {
    AppMethodBeat.i(350238);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramm);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderFollowConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramm, "$contact");
    paramView = paramj.context;
    s.s(paramView, "holder.context");
    ((cg)new ag(paramView, paramm.getUsername(), paramj.KJ(), false)).vc(false);
    a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFollowConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350238);
  }
  
  private static final void fv(View paramView)
  {
    AppMethodBeat.i(350228);
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(e.c.Edge_0_5_A);
    localRect.inset(-i, -i);
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(350228);
      throw paramView;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, paramView));
    AppMethodBeat.o(350228);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350253);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = paramj.UH(e.e.finder_live_onlive_widget);
    paramRecyclerView.post(new ak..ExternalSyntheticLambda1(paramRecyclerView));
    AppMethodBeat.o(350253);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_contact_list_item;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFollowConvert$adjustNickNameTvSize$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a(TextView paramTextView, View paramView1, View paramView2, ak paramak) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(350097);
      this.AKX.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = this.AKX.getParent();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(350097);
        throw ((Throwable)localObject);
      }
      int k = ((View)localObject).getWidth();
      int i = 0;
      if (this.AKY.getVisibility() == 0) {
        i = this.AKY.getWidth() + (int)this.AKY.getResources().getDimension(e.c.Edge_2_5_A) + 0;
      }
      int j = i;
      if (this.AKZ.getVisibility() == 0) {
        j = i + (this.AKZ.getWidth() + (int)this.AKZ.getResources().getDimension(e.c.Edge_A));
      }
      if (this.AKX.getWidth() + j > k)
      {
        this.AKX.setMaxWidth(k - j);
        Log.i(this.ALa.TAG, "adjustNickNameTvSize titleW:" + this.AKX.getWidth() + ", containerW:" + k + ",iconW:" + j);
      }
      AppMethodBeat.o(350097);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ak
 * JD-Core Version:    0.7.0.1
 */
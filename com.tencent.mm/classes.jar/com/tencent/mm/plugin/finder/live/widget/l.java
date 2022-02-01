package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.v;
import com.tencent.mm.plugin.finder.live.model.v.b;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.s.au;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.d;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "entranceRoot", "Landroid/view/ViewGroup;", "parent", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "ANCHOR_TAKE_PLACE_HEIGHT", "", "getANCHOR_TAKE_PLACE_HEIGHT", "()I", "TAG", "", "VISITOR_TAKE_PLACE_HEIGHT", "getVISITOR_TAKE_PLACE_HEIGHT", "WIDEGET_HEGIHT", "getWIDEGET_HEGIHT", "WIDEGET_PADDING", "getWIDEGET_PADDING", "arrow", "Landroid/view/View;", "bubbleHideAnim", "Landroid/animation/ObjectAnimator;", "bubbleShowAnim", "close", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "container", "descContainer", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "productDesc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "productImg", "Landroid/widget/ImageView;", "productPrice", "Landroid/widget/TextView;", "promotingContainer", "promotingWidget", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "root", "takePlaceHeight", "getTakePlaceHeight", "setTakePlaceHeight", "(I)V", "addToParent", "", "adjustVisitorBubbleLayout", "hideShoppingBubble", "hideShoppingBubbleAnim", "notifyShoppingBubbleAction", "show", "", "setProductDesc", "productDescTv", "shopName", "goodsDesc", "setVisibility", "visibility", "showShoppingBubble", "data", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "showShoppingBubbleAnim", "updateShoppingBubble", "plugin-finder_release"})
public final class l
  extends FrameLayout
{
  public final String TAG;
  private View gvQ;
  public final com.tencent.mm.live.c.b hOp;
  public g liveData;
  public final ViewGroup parent;
  public ImageView uBJ;
  public TextView uBN;
  private final int uHe;
  private final int uHf;
  private final int uHg;
  private final int uHh;
  public View uHi;
  public View uHj;
  public FinderLiveOnliveWidget uHk;
  public NeatTextView uHl;
  public WeImageView uHm;
  public ObjectAnimator uHn;
  private ObjectAnimator uHo;
  private int uHp;
  public final ViewGroup uHq;
  public View uhh;
  public ViewGroup ulG;
  
  public l(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, com.tencent.mm.live.c.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(248144);
    this.uHq = paramViewGroup1;
    this.parent = paramViewGroup2;
    this.hOp = paramb;
    this.TAG = "Finder.LiveShoppingWidget";
    this.uHe = d.e(MMApplicationContext.getContext(), 74.0F);
    this.uHf = d.e(MMApplicationContext.getContext(), 2.0F);
    this.uHg = (this.uHe + d.e(MMApplicationContext.getContext(), 20.0F));
    this.uHh = d.e(MMApplicationContext.getContext(), 12.0F);
    this.uHp = this.uHg;
    paramViewGroup1 = LayoutInflater.from(paramContext).inflate(2131494459, (ViewGroup)this, true);
    p.g(paramViewGroup1, "LayoutInflater.from(cont…ng_widget_ui, this, true)");
    this.gvQ = paramViewGroup1;
    paramViewGroup1 = this.gvQ.findViewById(2131306169);
    p.g(paramViewGroup1, "root.findViewById(R.id.product_img)");
    this.uBJ = ((ImageView)paramViewGroup1);
    paramViewGroup1 = this.gvQ.findViewById(2131306304);
    p.g(paramViewGroup1, "root.findViewById(R.id.promoting_container)");
    this.uHj = paramViewGroup1;
    paramViewGroup1 = this.gvQ.findViewById(2131306303);
    p.g(paramViewGroup1, "root.findViewById(R.id.promoting)");
    this.uHk = ((FinderLiveOnliveWidget)paramViewGroup1);
    paramViewGroup1 = this.gvQ.findViewById(2131299503);
    p.g(paramViewGroup1, "root.findViewById(R.id.desc_container)");
    this.uhh = paramViewGroup1;
    paramViewGroup1 = this.gvQ.findViewById(2131306155);
    p.g(paramViewGroup1, "root.findViewById(R.id.product_desc)");
    this.uHl = ((NeatTextView)paramViewGroup1);
    paramViewGroup1 = this.gvQ.findViewById(2131306171);
    p.g(paramViewGroup1, "root.findViewById(R.id.product_price)");
    this.uBN = ((TextView)paramViewGroup1);
    paramViewGroup1 = y.vXH;
    y.q(this.uBN);
    paramViewGroup1 = this.gvQ.findViewById(2131298763);
    p.g(paramViewGroup1, "root.findViewById(R.id.close)");
    this.uHm = ((WeImageView)paramViewGroup1);
    paramViewGroup1 = this.uHm;
    if (paramViewGroup1 != null)
    {
      int i = com.tencent.mm.cb.a.aH(paramContext, 2131165296);
      paramContext = new Rect();
      paramViewGroup1.getHitRect(paramContext);
      paramContext.inset(-i, -i / 2);
      paramViewGroup2 = paramViewGroup1.getParent();
      if (paramViewGroup2 == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(248144);
        throw paramContext;
      }
      ((View)paramViewGroup2).setTouchDelegate(new TouchDelegate(paramContext, (View)paramViewGroup1));
    }
    paramContext = this.uHm;
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(248136);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          l.f(this.uHr);
          if (l.g(this.uHr).getLiveRole() == 0)
          {
            paramAnonymousView = com.tencent.mm.plugin.finder.report.live.m.vli;
            localObject = s.au.vrX;
            paramAnonymousView = this.uHr.getLiveData();
            if (paramAnonymousView == null) {
              break label120;
            }
            paramAnonymousView = paramAnonymousView.uEm;
            if (paramAnonymousView == null) {
              break label120;
            }
          }
          label120:
          for (paramAnonymousView = Long.valueOf(paramAnonymousView.uko);; paramAnonymousView = null)
          {
            com.tencent.mm.plugin.finder.report.live.m.a((s.au)localObject, null, String.valueOf(paramAnonymousView));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248136);
            return;
          }
        }
      });
    }
    paramContext = com.tencent.mm.plugin.finder.utils.m.vVH;
    if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
      this.uHp = this.uHh;
    }
    AppMethodBeat.o(248144);
  }
  
  public static void a(NeatTextView paramNeatTextView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(248139);
    paramString2 = new com.tencent.mm.pluginsdk.ui.span.m(paramString1 + paramString2);
    Object localObject = paramNeatTextView.getContext();
    p.g(localObject, "productDescTv.context");
    float f1 = ((Context)localObject).getResources().getDimension(2131165277);
    float f2 = d.e(paramNeatTextView.getContext(), 2.0F);
    localObject = paramNeatTextView.getContext();
    p.g(localObject, "productDescTv.context");
    int i = ((Context)localObject).getResources().getColor(2131099838);
    localObject = paramNeatTextView.getContext();
    p.g(localObject, "productDescTv.context");
    int j = ((Context)localObject).getResources().getColor(2131099835);
    localObject = v.ukj;
    p.h(paramString1, "spanStr");
    localObject = new Paint();
    ((Paint)localObject).setTextSize(d.e(MMApplicationContext.getContext(), 12.0F));
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    float f3 = localContext.getResources().getDimension(2131165277);
    float f4 = ((Paint)localObject).measureText(paramString1, 0, paramString1.length());
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setBounds(0, 0, (int)(f3 + (f4 + 2.0F * f3)), 1);
    paramString2.setSpan(new v((Drawable)localObject, new v.b((CharSequence)paramString1, f1, f1, f1, f1, f1, f2, i, j, d.e(paramNeatTextView.getContext(), 12.0F))), 0, paramString1.length(), 33);
    paramNeatTextView.aw((CharSequence)paramString2);
    AppMethodBeat.o(248139);
  }
  
  private final void djN()
  {
    AppMethodBeat.i(248142);
    Log.i(this.TAG, "hideShoppingBubbleAnim，parent visibility:" + this.parent.getVisibility());
    if (getVisibility() == 0)
    {
      if (this.uHo == null)
      {
        this.uHo = ObjectAnimator.ofFloat(this.parent, "alpha", new float[] { 1.0F, 0.0F });
        localObjectAnimator = this.uHo;
        if (localObjectAnimator != null) {
          localObjectAnimator.addListener((Animator.AnimatorListener)new b(this));
        }
      }
      ObjectAnimator localObjectAnimator = this.uHo;
      if (localObjectAnimator != null) {
        localObjectAnimator.cancel();
      }
      localObjectAnimator = this.uHo;
      if (localObjectAnimator != null)
      {
        localObjectAnimator.start();
        AppMethodBeat.o(248142);
        return;
      }
    }
    AppMethodBeat.o(248142);
  }
  
  public final void djM()
  {
    AppMethodBeat.i(248140);
    g localg = this.liveData;
    if (localg != null) {
      localg.b(null);
    }
    nE(false);
    djN();
    AppMethodBeat.o(248140);
  }
  
  public final int getANCHOR_TAKE_PLACE_HEIGHT()
  {
    return this.uHh;
  }
  
  public final g getLiveData()
  {
    return this.liveData;
  }
  
  public final int getTakePlaceHeight()
  {
    return this.uHp;
  }
  
  public final int getVISITOR_TAKE_PLACE_HEIGHT()
  {
    return this.uHg;
  }
  
  public final int getWIDEGET_HEGIHT()
  {
    return this.uHe;
  }
  
  public final int getWIDEGET_PADDING()
  {
    return this.uHf;
  }
  
  public final void nE(boolean paramBoolean)
  {
    AppMethodBeat.i(248141);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "context.resources");
    int i = ((Resources)localObject).getConfiguration().orientation;
    Log.i(this.TAG, "notifyShoppingBubbleAction show:" + paramBoolean + ", orientation:" + i);
    if (i == 2)
    {
      AppMethodBeat.o(248141);
      return;
    }
    i = this.uHp;
    if (!paramBoolean) {
      i = -this.uHp;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("PARAM_FINDER_LIVE_COMMENT_MOVE_DISTANCE", i);
    this.hOp.statusChange(b.c.hNd, (Bundle)localObject);
    AppMethodBeat.o(248141);
  }
  
  public final void setLiveData(g paramg)
  {
    this.liveData = paramg;
  }
  
  public final void setTakePlaceHeight(int paramInt)
  {
    this.uHp = paramInt;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(248143);
    super.setVisibility(paramInt);
    Object localObject = this.ulG;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(paramInt);
    }
    localObject = this.uHi;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(paramInt);
      AppMethodBeat.o(248143);
      return;
    }
    AppMethodBeat.o(248143);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class a
    implements Runnable
  {
    public a(l paraml) {}
    
    public final void run()
    {
      ViewGroup localViewGroup = null;
      AppMethodBeat.i(248137);
      l.a(this.uHr, (ViewGroup)l.b(this.uHr).findViewById(2131307849));
      Object localObject1 = l.a(this.uHr);
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((ViewGroup)localObject1).indexOfChild((View)this.uHr));
        Log.i(l.c(this.uHr), "addToParent,index:".concat(String.valueOf(localObject1)));
        l.a(this.uHr, l.b(this.uHr).findViewById(2131307848));
        localObject2 = l.b(this.uHr);
        if (localObject2 == null) {
          break label151;
        }
      }
      label151:
      for (Object localObject2 = ((ViewGroup)localObject2).getLayoutParams();; localObject2 = null)
      {
        if (localObject2 != null) {
          break label157;
        }
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(248137);
        throw ((Throwable)localObject1);
        localObject1 = null;
        break;
      }
      label157:
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      int[] arrayOfInt = new int[2];
      l.e(this.uHr).getLocationOnScreen(arrayOfInt);
      Object localObject3 = com.tencent.mm.plugin.finder.utils.m.vVH;
      if (com.tencent.mm.plugin.finder.utils.m.dBP())
      {
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = (au.az(this.uHr.getContext()).y - arrayOfInt[1] - l.e(this.uHr).getHeight() + (l.e(this.uHr).getHeight() - this.uHr.getWIDEGET_HEGIHT() - this.uHr.getWIDEGET_PADDING()) / 2);
        if (localObject1 != null) {
          break label643;
        }
      }
      for (;;)
      {
        localObject1 = l.a(this.uHr);
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setVisibility(0);
        }
        localObject1 = l.d(this.uHr);
        if (localObject1 == null) {
          break label681;
        }
        ((View)localObject1).setVisibility(0);
        AppMethodBeat.o(248137);
        return;
        localObject3 = l.c(this.uHr);
        StringBuilder localStringBuilder = new StringBuilder("[visitor add shopping bubble] arrow:").append(l.d(this.uHr)).append(" container:").append(l.a(this.uHr)).append(" container.right:");
        localObject2 = l.a(this.uHr);
        if (localObject2 != null) {}
        for (localObject2 = Integer.valueOf(((ViewGroup)localObject2).getRight());; localObject2 = null)
        {
          localStringBuilder = localStringBuilder.append(localObject2).append(" loc:").append(arrayOfInt[0]).append(',').append(arrayOfInt[1]).append(" arrow.width:");
          View localView = l.d(this.uHr);
          localObject2 = localViewGroup;
          if (localView != null) {
            localObject2 = Integer.valueOf(localView.getWidth());
          }
          Log.i((String)localObject3, localObject2 + " entranceRoot.width:" + l.e(this.uHr).getWidth());
          if ((l.d(this.uHr) == null) || (l.a(this.uHr) == null)) {
            break;
          }
          localObject2 = new int[2];
          localViewGroup = l.a(this.uHr);
          if (localViewGroup == null) {
            p.hyc();
          }
          localViewGroup.getLocationInWindow((int[])localObject2);
          int i = localObject2[0];
          localObject2 = l.a(this.uHr);
          if (localObject2 == null) {
            p.hyc();
          }
          int j = ((ViewGroup)localObject2).getWidth();
          int k = arrayOfInt[0];
          localObject2 = l.d(this.uHr);
          if (localObject2 == null) {
            p.hyc();
          }
          i = j.mZ(i + j - k - ((View)localObject2).getWidth() / 2 - l.e(this.uHr).getWidth() / 2, 0);
          localObject2 = l.d(this.uHr);
          if (localObject2 == null) {
            p.hyc();
          }
          ((View)localObject2).setTranslationX(-i);
          break;
        }
        label643:
        if (((Integer)localObject1).intValue() == -1)
        {
          localObject1 = l.a(this.uHr);
          if (localObject1 != null) {
            ((ViewGroup)localObject1).addView((View)this.uHr);
          }
        }
      }
      label681:
      AppMethodBeat.o(248137);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget$hideShoppingBubbleAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(248138);
      this.uHr.setVisibility(8);
      AppMethodBeat.o(248138);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.l
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.model.ar;
import com.tencent.mm.plugin.finder.live.model.ar.b;
import com.tencent.mm.plugin.finder.live.report.s.bi;
import com.tencent.mm.plugin.finder.live.view.convert.e;
import com.tencent.mm.plugin.finder.live.view.convert.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.d;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "entranceRoot", "Landroid/view/ViewGroup;", "parent", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "ARROW_SIZE", "", "HORIZONTAL_TAKE_PLACE_HEIGHT", "MIN_ARROW_MARGIN_END", "TAG", "", "VERTICAL_TAKE_PLACE_HEIGHT", "WIDEGET_HEIGHT", "WIDEGET_PADDING", "adButton", "Landroid/widget/TextView;", "adContainer", "Landroid/view/View;", "adDescTv", "arrow", "bubbleHideAnim", "Landroid/animation/ObjectAnimator;", "bubbleRoot", "bubbleShowAnim", "close", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "container", "descContainer", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "productDesc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "productImg", "Landroid/widget/ImageView;", "productPrice", "productSeq", "productSrc", "promotingContainer", "promotingWidget", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "takePlaceHeight", "adjustBubbleLayout", "", "bubbleAttachToParent", "id", "", "hideShoppingBubble", "hideShoppingBubbleAnim", "notifyShoppingBubbleAction", "show", "", "setProductDesc", "productDescTv", "shopName", "goodsDesc", "setVisibility", "visibility", "showShoppingBubble", "data", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "showShoppingBubbleAnim", "updateBubbleLayout", "updateShoppingBubble", "plugin-finder_release"})
public final class ak
  extends FrameLayout
{
  public final String TAG;
  public final com.tencent.mm.live.c.b kCL;
  private final ViewGroup parent;
  public com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private View yXd;
  public TextView yZH;
  public ImageView yZl;
  public TextView yZm;
  public TextView yZo;
  public ViewGroup ybY;
  public View ybl;
  private final int znO;
  private View znQ;
  private ObjectAnimator znT;
  private ObjectAnimator znU;
  private final ViewGroup znV;
  private final int zqU;
  private final int zqV;
  private final int zqW;
  private final int zqX;
  private final int zqY;
  public View zqZ;
  public FinderLiveOnliveWidget zra;
  public NeatTextView zrb;
  public WeImageView zrc;
  public View zrd;
  public TextView zre;
  public TextView zrf;
  private int zrg;
  
  public ak(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, com.tencent.mm.live.c.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(288599);
    this.znV = paramViewGroup1;
    this.parent = paramViewGroup2;
    this.kCL = paramb;
    this.TAG = "Finder.LiveShoppingBubbleWidget";
    this.zqU = paramContext.getResources().getDimensionPixelOffset(b.d.finder_live_shopping_big_bubble_container_height);
    this.znO = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_2A);
    paramViewGroup1 = MMApplicationContext.getContext();
    p.j(paramViewGroup1, "MMApplicationContext.getContext()");
    this.zqV = paramViewGroup1.getResources().getDimensionPixelOffset(b.d.Edge_0_5_A);
    this.zqW = d.e(paramContext, 2.0F);
    this.zqX = (this.zqU + d.e(paramContext, 20.0F));
    this.zqY = d.e(paramContext, 12.0F);
    this.zrg = this.zqX;
    paramContext = LayoutInflater.from(paramContext).inflate(b.g.finder_live_shopping_widget_ui, (ViewGroup)this, true);
    p.j(paramContext, "LayoutInflater.from(cont…ng_widget_ui, this, true)");
    this.znQ = paramContext;
    paramContext = this.znQ.findViewById(b.f.product_img);
    p.j(paramContext, "bubbleRoot.findViewById(R.id.product_img)");
    this.yZl = ((ImageView)paramContext);
    paramContext = this.znQ.findViewById(b.f.promoting_container);
    p.j(paramContext, "bubbleRoot.findViewById(R.id.promoting_container)");
    this.zqZ = paramContext;
    paramContext = this.znQ.findViewById(b.f.promoting);
    p.j(paramContext, "bubbleRoot.findViewById(R.id.promoting)");
    this.zra = ((FinderLiveOnliveWidget)paramContext);
    paramContext = this.znQ.findViewById(b.f.desc_container);
    p.j(paramContext, "bubbleRoot.findViewById(R.id.desc_container)");
    this.ybl = paramContext;
    paramContext = this.znQ.findViewById(b.f.product_desc);
    p.j(paramContext, "bubbleRoot.findViewById(R.id.product_desc)");
    this.zrb = ((NeatTextView)paramContext);
    paramContext = this.znQ.findViewById(b.f.product_source);
    p.j(paramContext, "bubbleRoot.findViewById(R.id.product_source)");
    this.yZH = ((TextView)paramContext);
    paramContext = this.znQ.findViewById(b.f.product_seq);
    p.j(paramContext, "bubbleRoot.findViewById(R.id.product_seq)");
    this.yZm = ((TextView)paramContext);
    paramContext = this.znQ.findViewById(b.f.product_price);
    p.j(paramContext, "bubbleRoot.findViewById(R.id.product_price)");
    this.yZo = ((TextView)paramContext);
    this.zrd = this.znQ.findViewById(b.f.ad_detail_container);
    this.zre = ((TextView)this.znQ.findViewById(b.f.ad_desc));
    this.zrf = ((TextView)this.znQ.findViewById(b.f.ad_button));
    paramContext = aj.AGc;
    aj.u(this.yZo);
    paramContext = this.znQ.findViewById(b.f.close);
    p.j(paramContext, "bubbleRoot.findViewById(R.id.close)");
    this.zrc = ((WeImageView)paramContext);
    paramContext = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.eB((View)this.zrc);
    paramContext = this.zrc;
    if (paramContext != null)
    {
      paramContext.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(271871);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          label119:
          Object localObject2;
          if (ak.e(this.zrh).getLiveRole() == 0)
          {
            paramAnonymousView = this.zrh.getLiveData();
            if (paramAnonymousView == null) {
              break label219;
            }
            paramAnonymousView = (j)paramAnonymousView.business(j.class);
            if (paramAnonymousView == null) {
              break label219;
            }
            paramAnonymousView = paramAnonymousView.ziK;
            if (paramAnonymousView != null)
            {
              paramAnonymousView = this.zrh.getLiveData();
              if (paramAnonymousView == null) {
                break label224;
              }
              paramAnonymousView = (j)paramAnonymousView.business(j.class);
              if (paramAnonymousView == null) {
                break label224;
              }
              localObject1 = paramAnonymousView.ziK;
              if (!(localObject1 instanceof f)) {
                break label235;
              }
              localObject1 = com.tencent.mm.plugin.finder.live.report.m.yCt;
              localObject2 = s.bi.yLV;
              paramAnonymousView = this.zrh.getLiveData();
              if (paramAnonymousView == null) {
                break label230;
              }
              paramAnonymousView = (j)paramAnonymousView.business(j.class);
              if (paramAnonymousView == null) {
                break label230;
              }
              paramAnonymousView = paramAnonymousView.ziK;
              if (paramAnonymousView == null) {
                break label230;
              }
              paramAnonymousView = Long.valueOf(paramAnonymousView.mf());
              label182:
              com.tencent.mm.plugin.finder.live.report.m.a((com.tencent.mm.plugin.finder.live.report.m)localObject1, (s.bi)localObject2, null, String.valueOf(paramAnonymousView));
            }
          }
          for (;;)
          {
            ak.f(this.zrh);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(271871);
            return;
            label219:
            paramAnonymousView = null;
            break;
            label224:
            localObject1 = null;
            break label119;
            label230:
            paramAnonymousView = null;
            break label182;
            label235:
            if ((localObject1 instanceof e))
            {
              com.tencent.mm.plugin.finder.live.report.m localm = com.tencent.mm.plugin.finder.live.report.m.yCt;
              s.bi localbi = s.bi.yLV;
              long l1 = ((e)localObject1).zaI;
              paramAnonymousView = ((e)localObject1).zaJ;
              if (paramAnonymousView != null)
              {
                localObject2 = paramAnonymousView.RHW;
                paramAnonymousView = (View)localObject2;
                if (localObject2 != null) {}
              }
              else
              {
                paramAnonymousView = "";
              }
              long l2 = ((e)localObject1).zaI;
              localObject2 = ((e)localObject1).jDL;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localm.a(localbi, null, String.valueOf(l1), paramAnonymousView, String.valueOf(l2), (String)localObject1);
            }
          }
        }
      });
      AppMethodBeat.o(288599);
      return;
    }
    AppMethodBeat.o(288599);
  }
  
  public static void a(NeatTextView paramNeatTextView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(288594);
    paramString2 = new com.tencent.mm.pluginsdk.ui.span.m(paramString1 + paramString2);
    Object localObject = paramNeatTextView.getContext();
    p.j(localObject, "productDescTv.context");
    float f1 = ((Context)localObject).getResources().getDimension(b.d.Edge_0_5_A);
    float f2 = d.e(paramNeatTextView.getContext(), 2.0F);
    localObject = paramNeatTextView.getContext();
    p.j(localObject, "productDescTv.context");
    int i = ((Context)localObject).getResources().getColor(b.c.UN_BW_97);
    localObject = paramNeatTextView.getContext();
    p.j(localObject, "productDescTv.context");
    int j = ((Context)localObject).getResources().getColor(b.c.UN_BW_0_Alpha_0_5);
    localObject = ar.yis;
    p.k(paramString1, "spanStr");
    localObject = new Paint();
    ((Paint)localObject).setTextSize(d.e(MMApplicationContext.getContext(), 12.0F));
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    float f3 = localContext.getResources().getDimension(b.d.Edge_0_5_A);
    float f4 = ((Paint)localObject).measureText(paramString1, 0, paramString1.length());
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setBounds(0, 0, (int)(f3 + (f4 + 2.0F * f3)), 1);
    paramString2.setSpan(new ar((Drawable)localObject, new ar.b((CharSequence)paramString1, f1, f1, f1, f1, f1, f2, i, j, d.e(paramNeatTextView.getContext(), 12.0F))), 0, paramString1.length(), 33);
    paramNeatTextView.aL((CharSequence)paramString2);
    AppMethodBeat.o(288594);
  }
  
  private final void dIH()
  {
    AppMethodBeat.i(288597);
    Log.i(this.TAG, "hideShoppingBubbleAnim，parent visibility:" + this.parent.getVisibility());
    if (getVisibility() == 0)
    {
      if (this.znU == null)
      {
        this.znU = ObjectAnimator.ofFloat(this.parent, "alpha", new float[] { 1.0F, 0.0F });
        localObjectAnimator = this.znU;
        if (localObjectAnimator != null) {
          localObjectAnimator.addListener((Animator.AnimatorListener)new b(this));
        }
      }
      ObjectAnimator localObjectAnimator = this.znU;
      if (localObjectAnimator != null) {
        localObjectAnimator.cancel();
      }
      localObjectAnimator = this.znU;
      if (localObjectAnimator != null)
      {
        localObjectAnimator.start();
        AppMethodBeat.o(288597);
        return;
      }
    }
    AppMethodBeat.o(288597);
  }
  
  public final void LU(final long paramLong)
  {
    AppMethodBeat.i(288592);
    Object localObject = this.ybY;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getTag();
      if ((localObject instanceof Long)) {
        break label59;
      }
    }
    label59:
    while (paramLong != ((Long)localObject).longValue())
    {
      this.znV.post((Runnable)new a(this, paramLong));
      AppMethodBeat.o(288592);
      return;
      localObject = null;
      break;
    }
    Log.i(this.TAG, "bubbleAttachToParent id:" + paramLong + " view have attach!");
    AppMethodBeat.o(288592);
  }
  
  public final void dCz()
  {
    AppMethodBeat.i(288593);
    Object localObject1 = aj.AGc;
    localObject1 = this.yXd;
    ViewGroup localViewGroup = this.ybY;
    int[] arrayOfInt;
    Object localObject2;
    int j;
    if ((localObject1 != null) && (localViewGroup != null))
    {
      arrayOfInt = new int[2];
      this.znV.getLocationInWindow(arrayOfInt);
      localObject2 = new int[2];
      localViewGroup.getLocationInWindow((int[])localObject2);
      i = localObject2[0];
      j = localViewGroup.getWidth() + i;
      if (localViewGroup.getWidth() <= this.zqV) {
        break label320;
      }
    }
    float f;
    for (int i = localViewGroup.getWidth() - this.zqV;; i = (int)(f - ((Context)localObject2).getResources().getDimensionPixelOffset(b.d.finder_live_last_option_margin) - this.zqV * 2))
    {
      f = i.ow(i.ov(j - arrayOfInt[0] - ((View)localObject1).getWidth() / 2 - this.znV.getWidth() / 2, this.zqV), i);
      if (-f != ((View)localObject1).getTranslationX()) {
        Log.i(this.TAG, "updateBubbleLayout arrow:" + this.yXd + ",container:" + this.ybY + ", containerRight:" + j + ", container.width:" + localViewGroup.getWidth() + ',' + " shoppingEntranceLoc:" + arrayOfInt[0] + ", " + arrayOfInt[1] + ", arrow.width:" + ((View)localObject1).getWidth() + ", entranceRoot.width:" + this.znV.getWidth() + ',' + " MIN_ARROW_MARGIN_END:" + this.zqV + ", maxArrowMarginEnd:" + i + ", arrowMarginEnd:" + f);
      }
      ((View)localObject1).setTranslationX(-f);
      AppMethodBeat.o(288593);
      return;
      label320:
      f = ax.au(MMApplicationContext.getContext()).x;
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
    }
  }
  
  public final void dIF()
  {
    AppMethodBeat.i(288595);
    Object localObject = this.ybY;
    if (localObject != null) {
      ((ViewGroup)localObject).setTag(null);
    }
    localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(j.class);
      if (localObject != null) {
        ((j)localObject).d(null);
      }
    }
    dIH();
    AppMethodBeat.o(288595);
  }
  
  public final void dIG()
  {
    AppMethodBeat.i(288596);
    Log.i(this.TAG, "showShoppingBubbleAnim，parent visibility:" + this.parent.getVisibility());
    if (getVisibility() != 0)
    {
      setVisibility(0);
      if (this.znT == null) {
        this.znT = ObjectAnimator.ofFloat(this.parent, "alpha", new float[] { 0.0F, 1.0F });
      }
      ObjectAnimator localObjectAnimator = this.znT;
      if (localObjectAnimator != null) {
        localObjectAnimator.cancel();
      }
      localObjectAnimator = this.znT;
      if (localObjectAnimator != null)
      {
        localObjectAnimator.start();
        AppMethodBeat.o(288596);
        return;
      }
    }
    AppMethodBeat.o(288596);
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a getLiveData()
  {
    return this.xYp;
  }
  
  public final void setLiveData(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    this.xYp = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(288598);
    super.setVisibility(paramInt);
    Object localObject = this.ybY;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(paramInt);
    }
    localObject = this.yXd;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(paramInt);
      AppMethodBeat.o(288598);
      return;
    }
    AppMethodBeat.o(288598);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ak paramak, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(275150);
      ak.a(this.zrh);
      Object localObject = ak.b(this.zrh);
      if (localObject != null)
      {
        localObject = Integer.valueOf(((ViewGroup)localObject).indexOfChild((View)this.zrh));
        if (localObject != null) {
          break label123;
        }
        label43:
        Log.i(ak.c(this.zrh), "bubbleAttachToParent, have contain child!");
      }
      for (;;)
      {
        localObject = ak.b(this.zrh);
        if (localObject != null) {
          ((ViewGroup)localObject).setVisibility(0);
        }
        localObject = ak.d(this.zrh);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = ak.b(this.zrh);
        if (localObject == null) {
          break label172;
        }
        ((ViewGroup)localObject).setTag(Long.valueOf(paramLong));
        AppMethodBeat.o(275150);
        return;
        localObject = null;
        break;
        label123:
        if (((Integer)localObject).intValue() != -1) {
          break label43;
        }
        localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        com.tencent.mm.plugin.finder.live.utils.a.eC((View)this.zrh);
        localObject = ak.b(this.zrh);
        if (localObject != null) {
          ((ViewGroup)localObject).addView((View)this.zrh);
        }
      }
      label172:
      AppMethodBeat.o(275150);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget$hideShoppingBubbleAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(290577);
      this.zrh.setVisibility(8);
      AppMethodBeat.o(290577);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ak
 * JD-Core Version:    0.7.0.1
 */
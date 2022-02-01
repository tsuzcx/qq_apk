package com.tencent.mm.emoji.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.e;
import com.tencent.mm.emoji.panel.a.ab;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.f.b.a.az;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "dispatchCancel", "", "enableLongPress", "getEnableLongPress", "()Z", "setEnableLongPress", "(Z)V", "longPressDelay", "", "longPressRunnable", "Ljava/lang/Runnable;", "longPressed", "panelLifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getPanelLifeCycle", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "setPanelLifeCycle", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "parentRecycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelGroupView;", "popupHelper", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "scene", "getScene", "()I", "setScene", "(I)V", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "setSizeResolver", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "touchX", "getTouchX", "()F", "setTouchX", "(F)V", "touchY", "getTouchY", "setTouchY", "touched", "bind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "emojiSearchGifPerformanceMode", "gifPerformanceMode", "onAttachedToWindow", "onInterceptTouchEvent", "onLongPress", "onMeasure", "widthSpec", "heightSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEnd", "setEmojiPopupType", "type", "updatePopView", "plugin-emojisdk_release"})
public class EmojiPanelRecyclerView
  extends RecyclerView
{
  private final String TAG;
  private final int bvH;
  private boolean jKU;
  private boolean jKV;
  private boolean jKW;
  private boolean jKX;
  private float jKY;
  private float jKZ;
  private float jLa;
  private float jLb;
  private final long jLc;
  private boolean jLd;
  private final Runnable jLe;
  private EmojiPanelGroupView jLf;
  public com.tencent.mm.view.popview.a jLg;
  private com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> jLh;
  private q jLi;
  private int scene;
  
  public EmojiPanelRecyclerView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(105612);
    AppMethodBeat.o(105612);
  }
  
  public EmojiPanelRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(105611);
    AppMethodBeat.o(105611);
  }
  
  public EmojiPanelRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105610);
    this.TAG = "MicroMsg.EmojiPanelRecyclerView";
    this.jLd = true;
    this.jLe = ((Runnable)new c(this));
    paramContext = ViewConfiguration.get(paramContext);
    this.jLc = ViewConfiguration.getLongPressTimeout();
    p.j(paramContext, "config");
    this.bvH = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(105610);
  }
  
  public final void aCM()
  {
    AppMethodBeat.i(105602);
    a((RecyclerView.l)new b(this));
    AppMethodBeat.o(105602);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105605);
    p.k(paramMotionEvent, "event");
    if (!this.jLd)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(105605);
      return bool;
    }
    Object localObject1;
    Object localObject2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      if ((this.jKW) && (!this.jKX))
      {
        localObject1 = MotionEvent.obtain(paramMotionEvent);
        p.j(localObject1, "cancelEvent");
        ((MotionEvent)localObject1).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject1);
        ((MotionEvent)localObject1).recycle();
        this.jKX = true;
      }
      if ((paramMotionEvent.getActionMasked() == 3) || (paramMotionEvent.getActionMasked() == 1))
      {
        removeCallbacks(this.jLe);
        this.jKW = false;
        localObject1 = this.jLf;
        if (localObject1 != null) {
          ((EmojiPanelGroupView)localObject1).setScrollEnable(true);
        }
        localObject1 = this.jLg;
        if (localObject1 != null) {
          ((com.tencent.mm.view.popview.a)localObject1).fRF();
        }
        localObject2 = this.jLg;
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.vending.e.a)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.vending.e.a)localObject1;
        if (localObject1 != null)
        {
          localObject2 = this.jLh;
          if (localObject2 != null) {
            ((com.tencent.mm.vending.e.b)localObject2).keep((com.tencent.mm.vending.e.a)localObject1);
          }
        }
      }
      if (!this.jKW) {
        break label589;
      }
      Log.i(this.TAG, "updatePopView: " + this.jLa + ", " + this.jLb);
      paramMotionEvent = this.jLf;
      if (paramMotionEvent != null) {
        paramMotionEvent.setScrollEnable(false);
      }
      localObject1 = getAdapter();
      paramMotionEvent = (MotionEvent)localObject1;
      if (!(localObject1 instanceof com.tencent.mm.emoji.panel.a.i)) {
        paramMotionEvent = null;
      }
      localObject1 = (com.tencent.mm.emoji.panel.a.i)paramMotionEvent;
      if (localObject1 != null) {
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(105605);
      return true;
      this.jKU = true;
      this.jKW = false;
      this.jKV = false;
      this.jKX = false;
      this.jKY = paramMotionEvent.getX();
      this.jKZ = paramMotionEvent.getY();
      this.jLa = paramMotionEvent.getX();
      this.jLb = paramMotionEvent.getY();
      if (!this.jLd) {
        break;
      }
      postDelayed(this.jLe, this.jLc);
      break;
      this.jLa = paramMotionEvent.getX();
      this.jLb = paramMotionEvent.getY();
      if ((!this.jKU) || (this.jKV) || ((Math.abs(this.jKY - paramMotionEvent.getX()) <= this.bvH) && (Math.abs(this.jKZ - paramMotionEvent.getY()) <= this.bvH))) {
        break;
      }
      this.jKV = true;
      if (this.jKW) {
        break;
      }
      removeCallbacks(this.jLe);
      break;
      this.jKU = false;
      this.jKV = false;
      break;
      paramMotionEvent = h(this.jLa, this.jLb);
      if (paramMotionEvent != null)
      {
        p.j(paramMotionEvent, "findChildViewUnder(touchX, touchY) ?: return");
        int i = bh(paramMotionEvent);
        localObject2 = e.jNv;
        e.aDd().lp(i);
        localObject1 = ((com.tencent.mm.emoji.panel.a.i)localObject1).rF(i);
        localObject2 = this.jLg;
        if (localObject2 != null) {
          ((com.tencent.mm.view.popview.a)localObject2).d(paramMotionEvent, localObject1);
        }
      }
    }
    label589:
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(105605);
    return bool;
  }
  
  protected final boolean getEnableLongPress()
  {
    return this.jLd;
  }
  
  public final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> getPanelLifeCycle()
  {
    return this.jLh;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final q getSizeResolver()
  {
    return this.jLi;
  }
  
  public final float getTouchX()
  {
    return this.jLa;
  }
  
  public final float getTouchY()
  {
    return this.jLb;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(105607);
    super.onAttachedToWindow();
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof EmojiPanelGroupView))
      {
        this.jLf = ((EmojiPanelGroupView)localViewParent);
        AppMethodBeat.o(105607);
        return;
      }
    }
    AppMethodBeat.o(105607);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105606);
    p.k(paramMotionEvent, "event");
    if (this.jKW)
    {
      AppMethodBeat.o(105606);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(105606);
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105604);
    q localq = this.jLi;
    if (localq != null)
    {
      RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
      Object localObject = localLayoutManager;
      if (!(localLayoutManager instanceof GridLayoutManager)) {
        localObject = null;
      }
      localObject = (GridLayoutManager)localObject;
      if (localObject != null) {
        ((GridLayoutManager)localObject).cw(localq.spanCount);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(105604);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105603);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    q localq = this.jLi;
    if (localq != null)
    {
      localq.rG(paramInt1);
      RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
      Object localObject = localLayoutManager;
      if (!(localLayoutManager instanceof GridLayoutManager)) {
        localObject = null;
      }
      localObject = (GridLayoutManager)localObject;
      if (localObject != null) {
        ((GridLayoutManager)localObject).cw(localq.spanCount);
      }
      setPadding(localq.contentPadding, getPaddingTop(), localq.contentPadding, getPaddingBottom());
      AppMethodBeat.o(105603);
      return;
    }
    AppMethodBeat.o(105603);
  }
  
  public final void setEmojiPopupType(int paramInt)
  {
    AppMethodBeat.i(183958);
    Context localContext = getContext();
    p.j(localContext, "context");
    this.jLg = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.b(localContext, paramInt));
    AppMethodBeat.o(183958);
  }
  
  protected final void setEnableLongPress(boolean paramBoolean)
  {
    this.jLd = paramBoolean;
  }
  
  public final void setPanelLifeCycle(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.jLh = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSizeResolver(q paramq)
  {
    this.jLi = paramq;
  }
  
  public final void setTouchX(float paramFloat)
  {
    this.jLa = paramFloat;
  }
  
  public final void setTouchY(float paramFloat)
  {
    this.jLb = paramFloat;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
  public static final class a
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(223447);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      Util.hideVKB((View)paramRecyclerView);
      switch (paramInt)
      {
      default: 
      case 1: 
      case 2: 
        do
        {
          do
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
            AppMethodBeat.o(223447);
            return;
          } while (!(this.jLj.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a));
          paramRecyclerView = this.jLj.getAdapter();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
            AppMethodBeat.o(223447);
            throw paramRecyclerView;
          }
        } while (!((com.tencent.mm.plugin.emoji.ui.a)paramRecyclerView).jMH);
        paramRecyclerView = this.jLj.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
          AppMethodBeat.o(223447);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.plugin.emoji.ui.a)paramRecyclerView).jMH = false;
        paramRecyclerView = this.jLj.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(223447);
          throw paramRecyclerView;
        }
        paramInt = ((GridLayoutManager)paramRecyclerView).kJ();
        paramRecyclerView = this.jLj.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(223447);
          throw paramRecyclerView;
        }
        i = ((GridLayoutManager)paramRecyclerView).kL();
        while (paramInt <= i)
        {
          if ((this.jLj.cK(paramInt) instanceof ab))
          {
            paramRecyclerView = this.jLj.cK(paramInt);
            if (paramRecyclerView == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
              AppMethodBeat.o(223447);
              throw paramRecyclerView;
            }
            ((ab)paramRecyclerView).jME.pause();
          }
          paramInt += 1;
        }
      }
      if ((this.jLj.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a))
      {
        paramRecyclerView = this.jLj.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
          AppMethodBeat.o(223447);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.plugin.emoji.ui.a)paramRecyclerView).jMH = true;
      }
      paramRecyclerView = this.jLj.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        AppMethodBeat.o(223447);
        throw paramRecyclerView;
      }
      int i = ((GridLayoutManager)paramRecyclerView).kJ();
      paramRecyclerView = this.jLj.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        AppMethodBeat.o(223447);
        throw paramRecyclerView;
      }
      int k = ((GridLayoutManager)paramRecyclerView).kL();
      paramRecyclerView = new ArrayList();
      paramInt = 0;
      int j = i;
      label477:
      if (j <= k)
      {
        if ((j > 0) && ((this.jLj.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a)))
        {
          localObject = this.jLj.getAdapter();
          if (localObject == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
            AppMethodBeat.o(223447);
            throw paramRecyclerView;
          }
          if ((((com.tencent.mm.plugin.emoji.ui.a)localObject).rF(j) instanceof com.tencent.mm.emoji.b.b.h))
          {
            localObject = this.jLj.getAdapter();
            if (localObject == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
              AppMethodBeat.o(223447);
              throw paramRecyclerView;
            }
            localObject = ((com.tencent.mm.plugin.emoji.ui.a)localObject).rF(j);
            if (localObject == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
              AppMethodBeat.o(223447);
              throw paramRecyclerView;
            }
            paramRecyclerView.add(((com.tencent.mm.emoji.b.b.h)localObject).jHh);
          }
        }
        if (!(this.jLj.cK(j) instanceof ab)) {
          break label768;
        }
        paramInt += 1;
        localObject = this.jLj.cK(j);
        if (localObject == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
          AppMethodBeat.o(223447);
          throw paramRecyclerView;
        }
        localObject = (ab)localObject;
        com.tencent.e.h.ZvG.n((Runnable)new a((ab)localObject), paramInt / 2L);
      }
      label768:
      for (;;)
      {
        j += 1;
        break label477;
        if (this.jLj.getScene() != 2) {
          break;
        }
        if (i != 0) {}
        for (paramInt = i - 1;; paramInt = i)
        {
          localObject = com.tencent.mm.emojisearch.d.a.jQm;
          com.tencent.mm.emojisearch.d.a.b(paramRecyclerView, paramRecyclerView.size(), paramInt + paramRecyclerView.size());
          break;
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(223449);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(223449);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ab paramab) {}
      
      public final void run()
      {
        AppMethodBeat.i(227849);
        this.jLk.aCU();
        AppMethodBeat.o(227849);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
  public static final class b
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(225517);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      default: 
      case 1: 
      case 2: 
        do
        {
          do
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
            AppMethodBeat.o(225517);
            return;
          } while (!(this.jLj.getAdapter() instanceof com.tencent.mm.search.d.a));
          paramRecyclerView = this.jLj.getAdapter();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(225517);
            throw paramRecyclerView;
          }
        } while (!((com.tencent.mm.search.d.a)paramRecyclerView).jMH);
        paramRecyclerView = this.jLj.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
          AppMethodBeat.o(225517);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.search.d.a)paramRecyclerView).jMH = false;
        paramRecyclerView = this.jLj.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(225517);
          throw paramRecyclerView;
        }
        paramInt = ((GridLayoutManager)paramRecyclerView).kJ();
        paramRecyclerView = this.jLj.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(225517);
          throw paramRecyclerView;
        }
        i = ((GridLayoutManager)paramRecyclerView).kL();
        while (paramInt <= i)
        {
          if ((this.jLj.cK(paramInt) instanceof ab))
          {
            paramRecyclerView = this.jLj.cK(paramInt);
            if (paramRecyclerView == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
              AppMethodBeat.o(225517);
              throw paramRecyclerView;
            }
            ((ab)paramRecyclerView).jME.pause();
          }
          paramInt += 1;
        }
      }
      if ((this.jLj.getAdapter() instanceof com.tencent.mm.search.d.a))
      {
        paramRecyclerView = this.jLj.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
          AppMethodBeat.o(225517);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.search.d.a)paramRecyclerView).jMH = true;
      }
      paramRecyclerView = this.jLj.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        AppMethodBeat.o(225517);
        throw paramRecyclerView;
      }
      int i = ((GridLayoutManager)paramRecyclerView).kJ();
      paramRecyclerView = this.jLj.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        AppMethodBeat.o(225517);
        throw paramRecyclerView;
      }
      int k = ((GridLayoutManager)paramRecyclerView).kL();
      paramInt = 0;
      paramRecyclerView = new ArrayList();
      int j = i;
      label469:
      if (j <= k)
      {
        if ((j > 0) && ((this.jLj.getAdapter() instanceof com.tencent.mm.search.d.a)))
        {
          localObject = this.jLj.getAdapter();
          if (localObject == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(225517);
            throw paramRecyclerView;
          }
          if ((((com.tencent.mm.search.d.a)localObject).rF(j) instanceof com.tencent.mm.emoji.b.b.h))
          {
            localObject = this.jLj.getAdapter();
            if (localObject == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
              AppMethodBeat.o(225517);
              throw paramRecyclerView;
            }
            localObject = ((com.tencent.mm.search.d.a)localObject).rF(j);
            if (localObject == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
              AppMethodBeat.o(225517);
              throw paramRecyclerView;
            }
            paramRecyclerView.add(((com.tencent.mm.emoji.b.b.h)localObject).jHh);
          }
        }
        if (!(this.jLj.cK(j) instanceof ab)) {
          break label757;
        }
        paramInt += 1;
        localObject = this.jLj.cK(j);
        if (localObject == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
          AppMethodBeat.o(225517);
          throw paramRecyclerView;
        }
        localObject = (ab)localObject;
        com.tencent.e.h.ZvG.n((Runnable)new a((ab)localObject), paramInt / 2L);
      }
      label757:
      for (;;)
      {
        j += 1;
        break label469;
        if (this.jLj.getScene() != 1) {
          break;
        }
        if (i != 0) {}
        for (paramInt = i - 1;; paramInt = i)
        {
          localObject = com.tencent.mm.search.c.b.UWY;
          com.tencent.mm.search.c.b.b(paramRecyclerView, paramInt + paramRecyclerView.size());
          break;
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(225523);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(225523);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ab paramab) {}
      
      public final void run()
      {
        AppMethodBeat.i(105599);
        this.jLk.aCU();
        AppMethodBeat.o(105599);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(EmojiPanelRecyclerView paramEmojiPanelRecyclerView) {}
    
    public final void run()
    {
      AppMethodBeat.i(105601);
      EmojiPanelRecyclerView.a(this.jLj);
      AppMethodBeat.o(105601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.EmojiPanelRecyclerView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.emoji.panel;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.l;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.e;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.emoji.panel.a.z;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "dispatchCancel", "", "enableLongPress", "getEnableLongPress", "()Z", "setEnableLongPress", "(Z)V", "longPressDelay", "", "longPressRunnable", "Ljava/lang/Runnable;", "longPressed", "panelLifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getPanelLifeCycle", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "setPanelLifeCycle", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "parentRecycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelGroupView;", "popupHelper", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "scene", "getScene", "()I", "setScene", "(I)V", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "setSizeResolver", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "touchX", "getTouchX", "()F", "setTouchX", "(F)V", "touchY", "getTouchY", "setTouchY", "touched", "bind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "emojiSearchGifPerformanceMode", "gifPerformanceMode", "onAttachedToWindow", "onInterceptTouchEvent", "onLongPress", "onMeasure", "widthSpec", "heightSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEnd", "setEmojiPopupType", "type", "updatePopView", "plugin-emojisdk_release"})
public class EmojiPanelRecyclerView
  extends RecyclerView
{
  private final String TAG;
  private boolean gZT;
  private boolean gZU;
  private boolean gZV;
  private boolean gZW;
  private float gZX;
  private float gZY;
  private float gZZ;
  private float haa;
  private final long hab;
  private boolean hac;
  private final Runnable had;
  private EmojiPanelGroupView hae;
  public com.tencent.mm.view.popview.a haf;
  private com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> hag;
  private o hah;
  private final int rZ;
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
    this.hac = true;
    this.had = ((Runnable)new c(this));
    paramContext = ViewConfiguration.get(paramContext);
    this.hab = ViewConfiguration.getLongPressTimeout();
    p.g(paramContext, "config");
    this.rZ = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(105610);
  }
  
  public final void avQ()
  {
    AppMethodBeat.i(105602);
    a((RecyclerView.l)new b(this));
    AppMethodBeat.o(105602);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105605);
    p.h(paramMotionEvent, "event");
    if (!this.hac)
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
      if ((this.gZV) && (!this.gZW))
      {
        localObject1 = MotionEvent.obtain(paramMotionEvent);
        p.g(localObject1, "cancelEvent");
        ((MotionEvent)localObject1).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject1);
        ((MotionEvent)localObject1).recycle();
        this.gZW = true;
      }
      if ((paramMotionEvent.getActionMasked() == 3) || (paramMotionEvent.getActionMasked() == 1))
      {
        removeCallbacks(this.had);
        this.gZV = false;
        localObject1 = this.hae;
        if (localObject1 != null) {
          ((EmojiPanelGroupView)localObject1).setScrollEnable(true);
        }
        localObject1 = this.haf;
        if (localObject1 != null) {
          ((com.tencent.mm.view.popview.a)localObject1).fdM();
        }
        localObject2 = this.haf;
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.vending.e.a)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.vending.e.a)localObject1;
        if (localObject1 != null)
        {
          localObject2 = this.hag;
          if (localObject2 != null) {
            ((com.tencent.mm.vending.e.b)localObject2).keep((com.tencent.mm.vending.e.a)localObject1);
          }
        }
      }
      if (!this.gZV) {
        break label589;
      }
      Log.i(this.TAG, "updatePopView: " + this.gZZ + ", " + this.haa);
      paramMotionEvent = this.hae;
      if (paramMotionEvent != null) {
        paramMotionEvent.setScrollEnable(false);
      }
      localObject1 = getAdapter();
      paramMotionEvent = (MotionEvent)localObject1;
      if (!(localObject1 instanceof com.tencent.mm.emoji.panel.a.h)) {
        paramMotionEvent = null;
      }
      localObject1 = (com.tencent.mm.emoji.panel.a.h)paramMotionEvent;
      if (localObject1 != null) {
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(105605);
      return true;
      this.gZT = true;
      this.gZV = false;
      this.gZU = false;
      this.gZW = false;
      this.gZX = paramMotionEvent.getX();
      this.gZY = paramMotionEvent.getY();
      this.gZZ = paramMotionEvent.getX();
      this.haa = paramMotionEvent.getY();
      if (!this.hac) {
        break;
      }
      postDelayed(this.had, this.hab);
      break;
      this.gZZ = paramMotionEvent.getX();
      this.haa = paramMotionEvent.getY();
      if ((!this.gZT) || (this.gZU) || ((Math.abs(this.gZX - paramMotionEvent.getX()) <= this.rZ) && (Math.abs(this.gZY - paramMotionEvent.getY()) <= this.rZ))) {
        break;
      }
      this.gZU = true;
      if (this.gZV) {
        break;
      }
      removeCallbacks(this.had);
      break;
      this.gZT = false;
      this.gZU = false;
      break;
      paramMotionEvent = o(this.gZZ, this.haa);
      if (paramMotionEvent != null)
      {
        p.g(paramMotionEvent, "findChildViewUnder(touchX, touchY) ?: return");
        int i = bw(paramMotionEvent);
        localObject2 = e.hcl;
        e.awe().jV(i);
        localObject1 = ((com.tencent.mm.emoji.panel.a.h)localObject1).pm(i);
        localObject2 = this.haf;
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
    return this.hac;
  }
  
  public final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> getPanelLifeCycle()
  {
    return this.hag;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final o getSizeResolver()
  {
    return this.hah;
  }
  
  public final float getTouchX()
  {
    return this.gZZ;
  }
  
  public final float getTouchY()
  {
    return this.haa;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(105607);
    super.onAttachedToWindow();
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof EmojiPanelGroupView))
      {
        this.hae = ((EmojiPanelGroupView)localViewParent);
        AppMethodBeat.o(105607);
        return;
      }
    }
    AppMethodBeat.o(105607);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105606);
    p.h(paramMotionEvent, "event");
    if (this.gZV)
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
    o localo = this.hah;
    if (localo != null)
    {
      RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
      Object localObject = localLayoutManager;
      if (!(localLayoutManager instanceof GridLayoutManager)) {
        localObject = null;
      }
      localObject = (GridLayoutManager)localObject;
      if (localObject != null) {
        ((GridLayoutManager)localObject).bW(localo.att);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(105604);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105603);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    o localo = this.hah;
    if (localo != null)
    {
      localo.pn(paramInt1);
      RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
      Object localObject = localLayoutManager;
      if (!(localLayoutManager instanceof GridLayoutManager)) {
        localObject = null;
      }
      localObject = (GridLayoutManager)localObject;
      if (localObject != null) {
        ((GridLayoutManager)localObject).bW(localo.att);
      }
      setPadding(localo.hbe, getPaddingTop(), localo.hbe, getPaddingBottom());
      AppMethodBeat.o(105603);
      return;
    }
    AppMethodBeat.o(105603);
  }
  
  public final void setEmojiPopupType(int paramInt)
  {
    AppMethodBeat.i(183958);
    Context localContext = getContext();
    p.g(localContext, "context");
    this.haf = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.b(localContext, paramInt));
    AppMethodBeat.o(183958);
  }
  
  protected final void setEnableLongPress(boolean paramBoolean)
  {
    this.hac = paramBoolean;
  }
  
  public final void setPanelLifeCycle(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.hag = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSizeResolver(o paramo)
  {
    this.hah = paramo;
  }
  
  public final void setTouchX(float paramFloat)
  {
    this.gZZ = paramFloat;
  }
  
  public final void setTouchY(float paramFloat)
  {
    this.haa = paramFloat;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
  public static final class a
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(199962);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
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
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(199962);
            return;
          } while (!(this.hai.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a));
          paramRecyclerView = this.hai.getAdapter();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
            AppMethodBeat.o(199962);
            throw paramRecyclerView;
          }
        } while (!((com.tencent.mm.plugin.emoji.ui.a)paramRecyclerView).hbx);
        paramRecyclerView = this.hai.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
          AppMethodBeat.o(199962);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.plugin.emoji.ui.a)paramRecyclerView).hbx = false;
        paramRecyclerView = this.hai.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(199962);
          throw paramRecyclerView;
        }
        paramInt = ((GridLayoutManager)paramRecyclerView).ks();
        paramRecyclerView = this.hai.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(199962);
          throw paramRecyclerView;
        }
        i = ((GridLayoutManager)paramRecyclerView).ku();
        while (paramInt <= i)
        {
          if ((this.hai.ch(paramInt) instanceof z))
          {
            paramRecyclerView = this.hai.ch(paramInt);
            if (paramRecyclerView == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
              AppMethodBeat.o(199962);
              throw paramRecyclerView;
            }
            ((z)paramRecyclerView).hbu.pause();
          }
          paramInt += 1;
        }
      }
      if ((this.hai.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a))
      {
        paramRecyclerView = this.hai.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
          AppMethodBeat.o(199962);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.plugin.emoji.ui.a)paramRecyclerView).hbx = true;
      }
      paramRecyclerView = this.hai.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(199962);
        throw paramRecyclerView;
      }
      int i = ((GridLayoutManager)paramRecyclerView).ks();
      paramRecyclerView = this.hai.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(199962);
        throw paramRecyclerView;
      }
      int k = ((GridLayoutManager)paramRecyclerView).ku();
      paramRecyclerView = new ArrayList();
      paramInt = 0;
      int j = i;
      label477:
      if (j <= k)
      {
        if ((j > 0) && ((this.hai.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a)))
        {
          localObject = this.hai.getAdapter();
          if (localObject == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
            AppMethodBeat.o(199962);
            throw paramRecyclerView;
          }
          if ((((com.tencent.mm.plugin.emoji.ui.a)localObject).pm(j) instanceof com.tencent.mm.emoji.b.b.h))
          {
            localObject = this.hai.getAdapter();
            if (localObject == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
              AppMethodBeat.o(199962);
              throw paramRecyclerView;
            }
            localObject = ((com.tencent.mm.plugin.emoji.ui.a)localObject).pm(j);
            if (localObject == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
              AppMethodBeat.o(199962);
              throw paramRecyclerView;
            }
            paramRecyclerView.add(((com.tencent.mm.emoji.b.b.h)localObject).gWm);
          }
        }
        if (!(this.hai.ch(j) instanceof z)) {
          break label768;
        }
        paramInt += 1;
        localObject = this.hai.ch(j);
        if (localObject == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
          AppMethodBeat.o(199962);
          throw paramRecyclerView;
        }
        localObject = (z)localObject;
        com.tencent.f.h.RTc.n((Runnable)new a((z)localObject), paramInt / 2L);
      }
      label768:
      for (;;)
      {
        j += 1;
        break label477;
        if (this.hai.getScene() != 2) {
          break;
        }
        if (i != 0) {}
        for (paramInt = i - 1;; paramInt = i)
        {
          localObject = com.tencent.mm.emojisearch.d.a.hew;
          com.tencent.mm.emojisearch.d.a.b(paramRecyclerView, paramRecyclerView.size(), paramInt + paramRecyclerView.size());
          break;
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199963);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(199963);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(z paramz) {}
      
      public final void run()
      {
        AppMethodBeat.i(199961);
        this.haj.avV();
        AppMethodBeat.o(199961);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
  public static final class b
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(105600);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
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
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(105600);
            return;
          } while (!(this.hai.getAdapter() instanceof com.tencent.mm.search.d.a));
          paramRecyclerView = this.hai.getAdapter();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(105600);
            throw paramRecyclerView;
          }
        } while (!((com.tencent.mm.search.d.a)paramRecyclerView).hbx);
        paramRecyclerView = this.hai.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.search.d.a)paramRecyclerView).hbx = false;
        paramRecyclerView = this.hai.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        paramInt = ((GridLayoutManager)paramRecyclerView).ks();
        paramRecyclerView = this.hai.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        i = ((GridLayoutManager)paramRecyclerView).ku();
        while (paramInt <= i)
        {
          if ((this.hai.ch(paramInt) instanceof z))
          {
            paramRecyclerView = this.hai.ch(paramInt);
            if (paramRecyclerView == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            ((z)paramRecyclerView).hbu.pause();
          }
          paramInt += 1;
        }
      }
      if ((this.hai.getAdapter() instanceof com.tencent.mm.search.d.a))
      {
        paramRecyclerView = this.hai.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.search.d.a)paramRecyclerView).hbx = true;
      }
      paramRecyclerView = this.hai.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(105600);
        throw paramRecyclerView;
      }
      int i = ((GridLayoutManager)paramRecyclerView).ks();
      paramRecyclerView = this.hai.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(105600);
        throw paramRecyclerView;
      }
      int k = ((GridLayoutManager)paramRecyclerView).ku();
      paramInt = 0;
      paramRecyclerView = new ArrayList();
      int j = i;
      label469:
      if (j <= k)
      {
        if ((j > 0) && ((this.hai.getAdapter() instanceof com.tencent.mm.search.d.a)))
        {
          localObject = this.hai.getAdapter();
          if (localObject == null)
          {
            paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(105600);
            throw paramRecyclerView;
          }
          if ((((com.tencent.mm.search.d.a)localObject).pm(j) instanceof com.tencent.mm.emoji.b.b.h))
          {
            localObject = this.hai.getAdapter();
            if (localObject == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            localObject = ((com.tencent.mm.search.d.a)localObject).pm(j);
            if (localObject == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            paramRecyclerView.add(((com.tencent.mm.emoji.b.b.h)localObject).gWm);
          }
        }
        if (!(this.hai.ch(j) instanceof z)) {
          break label757;
        }
        paramInt += 1;
        localObject = this.hai.ch(j);
        if (localObject == null)
        {
          paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        localObject = (z)localObject;
        com.tencent.f.h.RTc.n((Runnable)new a((z)localObject), paramInt / 2L);
      }
      label757:
      for (;;)
      {
        j += 1;
        break label469;
        if (this.hai.getScene() != 1) {
          break;
        }
        if (i != 0) {}
        for (paramInt = i - 1;; paramInt = i)
        {
          localObject = com.tencent.mm.search.c.b.NJx;
          com.tencent.mm.search.c.b.b(paramRecyclerView, paramInt + paramRecyclerView.size());
          break;
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199964);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(199964);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(z paramz) {}
      
      public final void run()
      {
        AppMethodBeat.i(105599);
        this.haj.avV();
        AppMethodBeat.o(105599);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(EmojiPanelRecyclerView paramEmojiPanelRecyclerView) {}
    
    public final void run()
    {
      AppMethodBeat.i(105601);
      EmojiPanelRecyclerView.a(this.hai);
      AppMethodBeat.o(105601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.EmojiPanelRecyclerView
 * JD-Core Version:    0.7.0.1
 */
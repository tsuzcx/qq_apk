package com.tencent.mm.emoji.panel;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.d;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.emoji.panel.a.u;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "dispatchCancel", "", "enableLongPress", "getEnableLongPress", "()Z", "setEnableLongPress", "(Z)V", "longPressDelay", "", "longPressRunnable", "Ljava/lang/Runnable;", "longPressed", "panelLifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getPanelLifeCycle", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "setPanelLifeCycle", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "parentRecycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelGroupView;", "popupHelper", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "scene", "getScene", "()I", "setScene", "(I)V", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "setSizeResolver", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "touchX", "getTouchX", "()F", "setTouchX", "(F)V", "touchY", "getTouchY", "setTouchY", "touched", "bind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "gifPerformanceMode", "onAttachedToWindow", "onInterceptTouchEvent", "onLongPress", "onMeasure", "widthSpec", "heightSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEnd", "setEmojiPopupType", "type", "updatePopView", "plugin-emojisdk_release"})
public class EmojiPanelRecyclerView
  extends RecyclerView
{
  private final String TAG;
  private boolean gpa;
  private boolean gpb;
  private boolean gpc;
  private boolean gpd;
  private float gpe;
  private float gpf;
  private float gpg;
  private float gph;
  private final long gpi;
  private boolean gpj;
  private final Runnable gpk;
  private EmojiPanelGroupView gpl;
  public com.tencent.mm.view.popview.a gpm;
  private com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> gpn;
  private o gpo;
  private final int rW;
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
    this.gpj = true;
    this.gpk = ((Runnable)new b(this));
    paramContext = ViewConfiguration.get(paramContext);
    this.gpi = ViewConfiguration.getLongPressTimeout();
    p.g(paramContext, "config");
    this.rW = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(105610);
  }
  
  public final void agc()
  {
    AppMethodBeat.i(105602);
    a((RecyclerView.m)new a(this));
    AppMethodBeat.o(105602);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105605);
    p.h(paramMotionEvent, "event");
    if (!this.gpj)
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
      if ((this.gpc) && (!this.gpd))
      {
        localObject1 = MotionEvent.obtain(paramMotionEvent);
        p.g(localObject1, "cancelEvent");
        ((MotionEvent)localObject1).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject1);
        ((MotionEvent)localObject1).recycle();
        this.gpd = true;
      }
      if ((paramMotionEvent.getActionMasked() == 3) || (paramMotionEvent.getActionMasked() == 1))
      {
        removeCallbacks(this.gpk);
        this.gpc = false;
        localObject1 = this.gpl;
        if (localObject1 != null) {
          ((EmojiPanelGroupView)localObject1).setScrollEnable(true);
        }
        localObject1 = this.gpm;
        if (localObject1 != null) {
          ((com.tencent.mm.view.popview.a)localObject1).eaW();
        }
        localObject2 = this.gpm;
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.vending.e.a)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.vending.e.a)localObject1;
        if (localObject1 != null)
        {
          localObject2 = this.gpn;
          if (localObject2 != null) {
            ((com.tencent.mm.vending.e.b)localObject2).keep((com.tencent.mm.vending.e.a)localObject1);
          }
        }
      }
      if (!this.gpc) {
        break label589;
      }
      ae.i(this.TAG, "updatePopView: " + this.gpg + ", " + this.gph);
      paramMotionEvent = this.gpl;
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
      this.gpa = true;
      this.gpc = false;
      this.gpb = false;
      this.gpd = false;
      this.gpe = paramMotionEvent.getX();
      this.gpf = paramMotionEvent.getY();
      this.gpg = paramMotionEvent.getX();
      this.gph = paramMotionEvent.getY();
      if (!this.gpj) {
        break;
      }
      postDelayed(this.gpk, this.gpi);
      break;
      this.gpg = paramMotionEvent.getX();
      this.gph = paramMotionEvent.getY();
      if ((!this.gpa) || (this.gpb) || ((Math.abs(this.gpe - paramMotionEvent.getX()) <= this.rW) && (Math.abs(this.gpf - paramMotionEvent.getY()) <= this.rW))) {
        break;
      }
      this.gpb = true;
      if (this.gpc) {
        break;
      }
      removeCallbacks(this.gpk);
      break;
      this.gpa = false;
      this.gpb = false;
      break;
      paramMotionEvent = o(this.gpg, this.gph);
      if (paramMotionEvent != null)
      {
        p.g(paramMotionEvent, "findChildViewUnder(touchX, touchY) ?: return");
        int i = bw(paramMotionEvent);
        localObject2 = d.grb;
        d.ago().io(i);
        localObject1 = ((com.tencent.mm.emoji.panel.a.h)localObject1).me(i);
        localObject2 = this.gpm;
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
    return this.gpj;
  }
  
  public final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> getPanelLifeCycle()
  {
    return this.gpn;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final o getSizeResolver()
  {
    return this.gpo;
  }
  
  public final float getTouchX()
  {
    return this.gpg;
  }
  
  public final float getTouchY()
  {
    return this.gph;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(105607);
    super.onAttachedToWindow();
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof EmojiPanelGroupView))
      {
        this.gpl = ((EmojiPanelGroupView)localViewParent);
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
    if (this.gpc)
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
    o localo = this.gpo;
    if (localo != null)
    {
      RecyclerView.i locali = getLayoutManager();
      Object localObject = locali;
      if (!(locali instanceof GridLayoutManager)) {
        localObject = null;
      }
      localObject = (GridLayoutManager)localObject;
      if (localObject != null) {
        ((GridLayoutManager)localObject).bV(localo.atv);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(105604);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105603);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    o localo = this.gpo;
    if (localo != null)
    {
      localo.mf(paramInt1);
      RecyclerView.i locali = getLayoutManager();
      Object localObject = locali;
      if (!(locali instanceof GridLayoutManager)) {
        localObject = null;
      }
      localObject = (GridLayoutManager)localObject;
      if (localObject != null) {
        ((GridLayoutManager)localObject).bV(localo.atv);
      }
      setPadding(localo.gql, getPaddingTop(), localo.gql, getPaddingBottom());
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
    this.gpm = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.b(localContext, paramInt));
    AppMethodBeat.o(183958);
  }
  
  protected final void setEnableLongPress(boolean paramBoolean)
  {
    this.gpj = paramBoolean;
  }
  
  public final void setPanelLifeCycle(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.gpn = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSizeResolver(o paramo)
  {
    this.gpo = paramo;
  }
  
  public final void setTouchX(float paramFloat)
  {
    this.gpg = paramFloat;
  }
  
  public final void setTouchY(float paramFloat)
  {
    this.gph = paramFloat;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
  public static final class a
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(188600);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(188600);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(105600);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
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
          } while (!(this.gpp.getAdapter() instanceof com.tencent.mm.search.d.a));
          paramRecyclerView = this.gpp.getAdapter();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(105600);
            throw paramRecyclerView;
          }
        } while (!((com.tencent.mm.search.d.a)paramRecyclerView).gqx);
        paramRecyclerView = this.gpp.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.search.d.a)paramRecyclerView).gqx = false;
        paramRecyclerView = this.gpp.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        paramInt = ((GridLayoutManager)paramRecyclerView).km();
        paramRecyclerView = this.gpp.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        i = ((GridLayoutManager)paramRecyclerView).ko();
        while (paramInt <= i)
        {
          if ((this.gpp.ci(paramInt) instanceof u))
          {
            paramRecyclerView = this.gpp.ci(paramInt);
            if (paramRecyclerView == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            ((u)paramRecyclerView).gqu.pause();
          }
          paramInt += 1;
        }
      }
      if ((this.gpp.getAdapter() instanceof com.tencent.mm.search.d.a))
      {
        paramRecyclerView = this.gpp.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.search.d.a)paramRecyclerView).gqx = true;
      }
      paramRecyclerView = this.gpp.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(105600);
        throw paramRecyclerView;
      }
      int i = ((GridLayoutManager)paramRecyclerView).km();
      paramRecyclerView = this.gpp.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(105600);
        throw paramRecyclerView;
      }
      int k = ((GridLayoutManager)paramRecyclerView).ko();
      paramInt = 0;
      paramRecyclerView = new ArrayList();
      int j = i;
      label469:
      if (j <= k)
      {
        if ((j > 0) && ((this.gpp.getAdapter() instanceof com.tencent.mm.search.d.a)))
        {
          localObject = this.gpp.getAdapter();
          if (localObject == null)
          {
            paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(105600);
            throw paramRecyclerView;
          }
          if ((((com.tencent.mm.search.d.a)localObject).me(j) instanceof com.tencent.mm.emoji.a.b.h))
          {
            localObject = this.gpp.getAdapter();
            if (localObject == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            localObject = ((com.tencent.mm.search.d.a)localObject).me(j);
            if (localObject == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            paramRecyclerView.add(((com.tencent.mm.emoji.a.b.h)localObject).glt);
          }
        }
        if (!(this.gpp.ci(j) instanceof u)) {
          break label757;
        }
        paramInt += 1;
        localObject = this.gpp.ci(j);
        if (localObject == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        localObject = (u)localObject;
        com.tencent.e.h.MqF.q((Runnable)new a((u)localObject), paramInt / 2L);
      }
      label757:
      for (;;)
      {
        j += 1;
        break label469;
        if (this.gpp.getScene() != 1) {
          break;
        }
        if (i != 0) {}
        for (paramInt = i - 1;; paramInt = i)
        {
          localObject = com.tencent.mm.search.c.b.ICF;
          com.tencent.mm.search.c.b.b(paramRecyclerView, paramInt + paramRecyclerView.size());
          break;
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(u paramu) {}
      
      public final void run()
      {
        AppMethodBeat.i(105599);
        this.gpq.agh();
        AppMethodBeat.o(105599);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(EmojiPanelRecyclerView paramEmojiPanelRecyclerView) {}
    
    public final void run()
    {
      AppMethodBeat.i(105601);
      EmojiPanelRecyclerView.a(this.gpp);
      AppMethodBeat.o(105601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.EmojiPanelRecyclerView
 * JD-Core Version:    0.7.0.1
 */
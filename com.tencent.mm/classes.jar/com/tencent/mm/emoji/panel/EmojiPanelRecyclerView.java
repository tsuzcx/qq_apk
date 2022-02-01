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
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.emoji.panel.a.u;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.g.b.a.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "dispatchCancel", "", "enableLongPress", "getEnableLongPress", "()Z", "setEnableLongPress", "(Z)V", "longPressDelay", "", "longPressRunnable", "Ljava/lang/Runnable;", "longPressed", "panelLifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getPanelLifeCycle", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "setPanelLifeCycle", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "parentRecycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelGroupView;", "popupHelper", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "scene", "getScene", "()I", "setScene", "(I)V", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "setSizeResolver", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "touchX", "getTouchX", "()F", "setTouchX", "(F)V", "touchY", "getTouchY", "setTouchY", "touched", "bind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "gifPerformanceMode", "onAttachedToWindow", "onInterceptTouchEvent", "onLongPress", "onMeasure", "widthSpec", "heightSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEnd", "setEmojiPopupType", "type", "updatePopView", "plugin-emojisdk_release"})
public class EmojiPanelRecyclerView
  extends RecyclerView
{
  private final String TAG;
  private boolean fPf;
  private boolean fPg;
  private boolean fPh;
  private boolean fPi;
  private float fPj;
  private float fPk;
  private float fPl;
  private float fPm;
  private final long fPn;
  private boolean fPo;
  private final Runnable fPp;
  private EmojiPanelGroupView fPq;
  public com.tencent.mm.view.popview.a fPr;
  private com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> fPs;
  private o fPt;
  private final int pd;
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
    this.fPo = true;
    this.fPp = ((Runnable)new b(this));
    paramContext = ViewConfiguration.get(paramContext);
    this.fPn = ViewConfiguration.getLongPressTimeout();
    k.g(paramContext, "config");
    this.pd = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(105610);
  }
  
  public final void acc()
  {
    AppMethodBeat.i(105602);
    a((RecyclerView.m)new a(this));
    AppMethodBeat.o(105602);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105605);
    k.h(paramMotionEvent, "event");
    if (!this.fPo)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(105605);
      return bool;
    }
    Object localObject1;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      if ((this.fPh) && (!this.fPi))
      {
        localObject1 = MotionEvent.obtain(paramMotionEvent);
        k.g(localObject1, "cancelEvent");
        ((MotionEvent)localObject1).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject1);
        ((MotionEvent)localObject1).recycle();
        this.fPi = true;
      }
      if ((paramMotionEvent.getActionMasked() == 3) || (paramMotionEvent.getActionMasked() == 1))
      {
        removeCallbacks(this.fPp);
        this.fPh = false;
        localObject1 = this.fPq;
        if (localObject1 != null) {
          ((EmojiPanelGroupView)localObject1).setScrollEnable(true);
        }
        localObject1 = this.fPr;
        if (localObject1 != null) {
          ((com.tencent.mm.view.popview.a)localObject1).dwD();
        }
      }
      if (!this.fPh) {
        break label536;
      }
      ad.i(this.TAG, "updatePopView: " + this.fPl + ", " + this.fPm);
      paramMotionEvent = this.fPq;
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
      this.fPf = true;
      this.fPh = false;
      this.fPg = false;
      this.fPi = false;
      this.fPj = paramMotionEvent.getX();
      this.fPk = paramMotionEvent.getY();
      this.fPl = paramMotionEvent.getX();
      this.fPm = paramMotionEvent.getY();
      if (!this.fPo) {
        break;
      }
      postDelayed(this.fPp, this.fPn);
      break;
      this.fPl = paramMotionEvent.getX();
      this.fPm = paramMotionEvent.getY();
      if ((!this.fPf) || (this.fPg) || ((Math.abs(this.fPj - paramMotionEvent.getX()) <= this.pd) && (Math.abs(this.fPk - paramMotionEvent.getY()) <= this.pd))) {
        break;
      }
      this.fPg = true;
      if (this.fPh) {
        break;
      }
      removeCallbacks(this.fPp);
      break;
      this.fPf = false;
      this.fPg = false;
      break;
      paramMotionEvent = o(this.fPl, this.fPm);
      if (paramMotionEvent != null)
      {
        k.g(paramMotionEvent, "findChildViewUnder(touchX, touchY) ?: return");
        int i = bw(paramMotionEvent);
        Object localObject2 = d.fRi;
        d.aco().ir(i);
        localObject1 = ((com.tencent.mm.emoji.panel.a.h)localObject1).lE(i);
        localObject2 = this.fPr;
        if (localObject2 != null) {
          ((com.tencent.mm.view.popview.a)localObject2).d(paramMotionEvent, localObject1);
        }
      }
    }
    label536:
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(105605);
    return bool;
  }
  
  protected final boolean getEnableLongPress()
  {
    return this.fPo;
  }
  
  public final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> getPanelLifeCycle()
  {
    return this.fPs;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final o getSizeResolver()
  {
    return this.fPt;
  }
  
  public final float getTouchX()
  {
    return this.fPl;
  }
  
  public final float getTouchY()
  {
    return this.fPm;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(105607);
    super.onAttachedToWindow();
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof EmojiPanelGroupView))
      {
        this.fPq = ((EmojiPanelGroupView)localViewParent);
        AppMethodBeat.o(105607);
        return;
      }
    }
    AppMethodBeat.o(105607);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105606);
    k.h(paramMotionEvent, "event");
    if (this.fPh)
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
    o localo = this.fPt;
    if (localo != null)
    {
      RecyclerView.i locali = getLayoutManager();
      Object localObject = locali;
      if (!(locali instanceof GridLayoutManager)) {
        localObject = null;
      }
      localObject = (GridLayoutManager)localObject;
      if (localObject != null) {
        ((GridLayoutManager)localObject).bV(localo.aqI);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(105604);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105603);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    o localo = this.fPt;
    if (localo != null)
    {
      localo.lF(paramInt1);
      RecyclerView.i locali = getLayoutManager();
      Object localObject = locali;
      if (!(locali instanceof GridLayoutManager)) {
        localObject = null;
      }
      localObject = (GridLayoutManager)localObject;
      if (localObject != null) {
        ((GridLayoutManager)localObject).bV(localo.aqI);
      }
      setPadding(localo.fQs, getPaddingTop(), localo.fQs, getPaddingBottom());
      AppMethodBeat.o(105603);
      return;
    }
    AppMethodBeat.o(105603);
  }
  
  public final void setEmojiPopupType(int paramInt)
  {
    AppMethodBeat.i(183958);
    Object localObject = getContext();
    k.g(localObject, "context");
    localObject = new com.tencent.mm.view.popview.b((Context)localObject, paramInt);
    com.tencent.mm.vending.e.b localb = this.fPs;
    if (localb != null) {
      localb.keep((com.tencent.mm.vending.e.a)localObject);
    }
    this.fPr = ((com.tencent.mm.view.popview.a)localObject);
    AppMethodBeat.o(183958);
  }
  
  protected final void setEnableLongPress(boolean paramBoolean)
  {
    this.fPo = paramBoolean;
  }
  
  public final void setPanelLifeCycle(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.fPs = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSizeResolver(o paramo)
  {
    this.fPt = paramo;
  }
  
  public final void setTouchX(float paramFloat)
  {
    this.fPl = paramFloat;
  }
  
  public final void setTouchY(float paramFloat)
  {
    this.fPm = paramFloat;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
  public static final class a
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202403);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202403);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(105600);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
      k.h(paramRecyclerView, "recyclerView");
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
          } while (!(this.fPu.getAdapter() instanceof com.tencent.mm.search.c.a));
          paramRecyclerView = this.fPu.getAdapter();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(105600);
            throw paramRecyclerView;
          }
        } while (!((com.tencent.mm.search.c.a)paramRecyclerView).fQE);
        paramRecyclerView = this.fPu.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.search.c.a)paramRecyclerView).fQE = false;
        paramRecyclerView = this.fPu.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        paramInt = ((GridLayoutManager)paramRecyclerView).jO();
        paramRecyclerView = this.fPu.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        i = ((GridLayoutManager)paramRecyclerView).jQ();
        while (paramInt <= i)
        {
          if ((this.fPu.cj(paramInt) instanceof u))
          {
            paramRecyclerView = this.fPu.cj(paramInt);
            if (paramRecyclerView == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            ((u)paramRecyclerView).fQB.pause();
          }
          paramInt += 1;
        }
      }
      if ((this.fPu.getAdapter() instanceof com.tencent.mm.search.c.a))
      {
        paramRecyclerView = this.fPu.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.search.c.a)paramRecyclerView).fQE = true;
      }
      paramRecyclerView = this.fPu.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(105600);
        throw paramRecyclerView;
      }
      int i = ((GridLayoutManager)paramRecyclerView).jO();
      paramRecyclerView = this.fPu.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(105600);
        throw paramRecyclerView;
      }
      int k = ((GridLayoutManager)paramRecyclerView).jQ();
      paramInt = 0;
      paramRecyclerView = new ArrayList();
      int j = i;
      label469:
      if (j <= k)
      {
        if ((j > 0) && ((this.fPu.getAdapter() instanceof com.tencent.mm.search.c.a)))
        {
          localObject = this.fPu.getAdapter();
          if (localObject == null)
          {
            paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(105600);
            throw paramRecyclerView;
          }
          if ((((com.tencent.mm.search.c.a)localObject).lE(j) instanceof com.tencent.mm.emoji.a.a.h))
          {
            localObject = this.fPu.getAdapter();
            if (localObject == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            localObject = ((com.tencent.mm.search.c.a)localObject).lE(j);
            if (localObject == null)
            {
              paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            paramRecyclerView.add(((com.tencent.mm.emoji.a.a.h)localObject).fLP);
          }
        }
        if (!(this.fPu.cj(j) instanceof u)) {
          break label757;
        }
        paramInt += 1;
        localObject = this.fPu.cj(j);
        if (localObject == null)
        {
          paramRecyclerView = new v("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        localObject = (u)localObject;
        com.tencent.e.h.Iye.p((Runnable)new a((u)localObject), paramInt / 2L);
      }
      label757:
      for (;;)
      {
        j += 1;
        break label469;
        if (this.fPu.getScene() != 1) {
          break;
        }
        if (i != 0) {}
        for (paramInt = i - 1;; paramInt = i)
        {
          localObject = com.tencent.mm.search.b.b.EZl;
          com.tencent.mm.search.b.b.b(paramRecyclerView, paramInt + paramRecyclerView.size());
          break;
        }
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(u paramu) {}
      
      public final void run()
      {
        AppMethodBeat.i(105599);
        u localu = this.fPv;
        ad.i("MicroMsg.SimilarEmoji", "loadGif");
        com.tencent.mm.emoji.a.a.h localh = (com.tencent.mm.emoji.a.a.h)localu.fQv;
        if (localh != null)
        {
          Object localObject = localu.fQB.getEmojiInfo();
          if (localObject != null)
          {
            localObject = ((EmojiInfo)localObject).JS();
            if ((localObject != null) && (((String)localObject).equals(localh.fLP.JS()) == true))
            {
              if (!localu.fQB.isRunning()) {
                localu.fQB.resume();
              }
              AppMethodBeat.o(105599);
              return;
            }
          }
          localu.fQB.setEmojiInfo(localh.fLP);
          AppMethodBeat.o(105599);
          return;
        }
        AppMethodBeat.o(105599);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(EmojiPanelRecyclerView paramEmojiPanelRecyclerView) {}
    
    public final void run()
    {
      AppMethodBeat.i(105601);
      EmojiPanelRecyclerView.a(this.fPu);
      AppMethodBeat.o(105601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.EmojiPanelRecyclerView
 * JD-Core Version:    0.7.0.1
 */
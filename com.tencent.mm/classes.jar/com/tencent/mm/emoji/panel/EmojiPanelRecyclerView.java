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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "dispatchCancel", "", "enableLongPress", "getEnableLongPress", "()Z", "setEnableLongPress", "(Z)V", "longPressDelay", "", "longPressRunnable", "Ljava/lang/Runnable;", "longPressed", "panelLifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getPanelLifeCycle", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "setPanelLifeCycle", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "parentRecycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelGroupView;", "popupHelper", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "scene", "getScene", "()I", "setScene", "(I)V", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "setSizeResolver", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "touchX", "getTouchX", "()F", "setTouchX", "(F)V", "touchY", "getTouchY", "setTouchY", "touched", "bind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "gifPerformanceMode", "onAttachedToWindow", "onInterceptTouchEvent", "onLongPress", "onMeasure", "widthSpec", "heightSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEnd", "setEmojiPopupType", "type", "updatePopView", "plugin-emojisdk_release"})
public class EmojiPanelRecyclerView
  extends RecyclerView
{
  private final String TAG;
  private boolean fTa;
  private boolean fTb;
  private boolean fTc;
  private boolean fTd;
  private float fTe;
  private float fTf;
  private float fTg;
  private float fTh;
  private final long fTi;
  private boolean fTj;
  private final Runnable fTk;
  private EmojiPanelGroupView fTl;
  public com.tencent.mm.view.popview.a fTm;
  private com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> fTn;
  private o fTo;
  private final int qc;
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
    this.fTj = true;
    this.fTk = ((Runnable)new b(this));
    paramContext = ViewConfiguration.get(paramContext);
    this.fTi = ViewConfiguration.getLongPressTimeout();
    k.g(paramContext, "config");
    this.qc = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(105610);
  }
  
  public final void adi()
  {
    AppMethodBeat.i(105602);
    a((RecyclerView.m)new a(this));
    AppMethodBeat.o(105602);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105605);
    k.h(paramMotionEvent, "event");
    if (!this.fTj)
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
      if ((this.fTc) && (!this.fTd))
      {
        localObject1 = MotionEvent.obtain(paramMotionEvent);
        k.g(localObject1, "cancelEvent");
        ((MotionEvent)localObject1).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject1);
        ((MotionEvent)localObject1).recycle();
        this.fTd = true;
      }
      if ((paramMotionEvent.getActionMasked() == 3) || (paramMotionEvent.getActionMasked() == 1))
      {
        removeCallbacks(this.fTk);
        this.fTc = false;
        localObject1 = this.fTl;
        if (localObject1 != null) {
          ((EmojiPanelGroupView)localObject1).setScrollEnable(true);
        }
        localObject1 = this.fTm;
        if (localObject1 != null) {
          ((com.tencent.mm.view.popview.a)localObject1).dLc();
        }
        localObject2 = this.fTm;
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.vending.e.a)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.vending.e.a)localObject1;
        if (localObject1 != null)
        {
          localObject2 = this.fTn;
          if (localObject2 != null) {
            ((com.tencent.mm.vending.e.b)localObject2).keep((com.tencent.mm.vending.e.a)localObject1);
          }
        }
      }
      if (!this.fTc) {
        break label589;
      }
      ac.i(this.TAG, "updatePopView: " + this.fTg + ", " + this.fTh);
      paramMotionEvent = this.fTl;
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
      this.fTa = true;
      this.fTc = false;
      this.fTb = false;
      this.fTd = false;
      this.fTe = paramMotionEvent.getX();
      this.fTf = paramMotionEvent.getY();
      this.fTg = paramMotionEvent.getX();
      this.fTh = paramMotionEvent.getY();
      if (!this.fTj) {
        break;
      }
      postDelayed(this.fTk, this.fTi);
      break;
      this.fTg = paramMotionEvent.getX();
      this.fTh = paramMotionEvent.getY();
      if ((!this.fTa) || (this.fTb) || ((Math.abs(this.fTe - paramMotionEvent.getX()) <= this.qc) && (Math.abs(this.fTf - paramMotionEvent.getY()) <= this.qc))) {
        break;
      }
      this.fTb = true;
      if (this.fTc) {
        break;
      }
      removeCallbacks(this.fTk);
      break;
      this.fTa = false;
      this.fTb = false;
      break;
      paramMotionEvent = o(this.fTg, this.fTh);
      if (paramMotionEvent != null)
      {
        k.g(paramMotionEvent, "findChildViewUnder(touchX, touchY) ?: return");
        int i = bw(paramMotionEvent);
        localObject2 = d.fVd;
        d.adu().ib(i);
        localObject1 = ((com.tencent.mm.emoji.panel.a.h)localObject1).lB(i);
        localObject2 = this.fTm;
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
    return this.fTj;
  }
  
  public final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> getPanelLifeCycle()
  {
    return this.fTn;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final o getSizeResolver()
  {
    return this.fTo;
  }
  
  public final float getTouchX()
  {
    return this.fTg;
  }
  
  public final float getTouchY()
  {
    return this.fTh;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(105607);
    super.onAttachedToWindow();
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof EmojiPanelGroupView))
      {
        this.fTl = ((EmojiPanelGroupView)localViewParent);
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
    if (this.fTc)
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
    o localo = this.fTo;
    if (localo != null)
    {
      RecyclerView.i locali = getLayoutManager();
      Object localObject = locali;
      if (!(locali instanceof GridLayoutManager)) {
        localObject = null;
      }
      localObject = (GridLayoutManager)localObject;
      if (localObject != null) {
        ((GridLayoutManager)localObject).bV(localo.arE);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(105604);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105603);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    o localo = this.fTo;
    if (localo != null)
    {
      localo.lC(paramInt1);
      RecyclerView.i locali = getLayoutManager();
      Object localObject = locali;
      if (!(locali instanceof GridLayoutManager)) {
        localObject = null;
      }
      localObject = (GridLayoutManager)localObject;
      if (localObject != null) {
        ((GridLayoutManager)localObject).bV(localo.arE);
      }
      setPadding(localo.fUn, getPaddingTop(), localo.fUn, getPaddingBottom());
      AppMethodBeat.o(105603);
      return;
    }
    AppMethodBeat.o(105603);
  }
  
  public final void setEmojiPopupType(int paramInt)
  {
    AppMethodBeat.i(183958);
    Context localContext = getContext();
    k.g(localContext, "context");
    this.fTm = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.b(localContext, paramInt));
    AppMethodBeat.o(183958);
  }
  
  protected final void setEnableLongPress(boolean paramBoolean)
  {
    this.fTj = paramBoolean;
  }
  
  public final void setPanelLifeCycle(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    this.fTn = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSizeResolver(o paramo)
  {
    this.fTo = paramo;
  }
  
  public final void setTouchX(float paramFloat)
  {
    this.fTg = paramFloat;
  }
  
  public final void setTouchY(float paramFloat)
  {
    this.fTh = paramFloat;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
  public static final class a
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209861);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(209861);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(105600);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
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
          } while (!(this.fTp.getAdapter() instanceof com.tencent.mm.search.d.a));
          paramRecyclerView = this.fTp.getAdapter();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new d.v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(105600);
            throw paramRecyclerView;
          }
        } while (!((com.tencent.mm.search.d.a)paramRecyclerView).fUz);
        paramRecyclerView = this.fTp.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new d.v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.search.d.a)paramRecyclerView).fUz = false;
        paramRecyclerView = this.fTp.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new d.v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        paramInt = ((GridLayoutManager)paramRecyclerView).jW();
        paramRecyclerView = this.fTp.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new d.v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        i = ((GridLayoutManager)paramRecyclerView).jY();
        while (paramInt <= i)
        {
          if ((this.fTp.ci(paramInt) instanceof u))
          {
            paramRecyclerView = this.fTp.ci(paramInt);
            if (paramRecyclerView == null)
            {
              paramRecyclerView = new d.v("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            ((u)paramRecyclerView).fUw.pause();
          }
          paramInt += 1;
        }
      }
      if ((this.fTp.getAdapter() instanceof com.tencent.mm.search.d.a))
      {
        paramRecyclerView = this.fTp.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new d.v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.search.d.a)paramRecyclerView).fUz = true;
      }
      paramRecyclerView = this.fTp.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new d.v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(105600);
        throw paramRecyclerView;
      }
      int i = ((GridLayoutManager)paramRecyclerView).jW();
      paramRecyclerView = this.fTp.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new d.v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        AppMethodBeat.o(105600);
        throw paramRecyclerView;
      }
      int k = ((GridLayoutManager)paramRecyclerView).jY();
      paramInt = 0;
      paramRecyclerView = new ArrayList();
      int j = i;
      label469:
      if (j <= k)
      {
        if ((j > 0) && ((this.fTp.getAdapter() instanceof com.tencent.mm.search.d.a)))
        {
          localObject = this.fTp.getAdapter();
          if (localObject == null)
          {
            paramRecyclerView = new d.v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(105600);
            throw paramRecyclerView;
          }
          if ((((com.tencent.mm.search.d.a)localObject).lB(j) instanceof com.tencent.mm.emoji.a.a.h))
          {
            localObject = this.fTp.getAdapter();
            if (localObject == null)
            {
              paramRecyclerView = new d.v("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            localObject = ((com.tencent.mm.search.d.a)localObject).lB(j);
            if (localObject == null)
            {
              paramRecyclerView = new d.v("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
              AppMethodBeat.o(105600);
              throw paramRecyclerView;
            }
            paramRecyclerView.add(((com.tencent.mm.emoji.a.a.h)localObject).fPB);
          }
        }
        if (!(this.fTp.ci(j) instanceof u)) {
          break label757;
        }
        paramInt += 1;
        localObject = this.fTp.ci(j);
        if (localObject == null)
        {
          paramRecyclerView = new d.v("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
          AppMethodBeat.o(105600);
          throw paramRecyclerView;
        }
        localObject = (u)localObject;
        com.tencent.e.h.JZN.p((Runnable)new a((u)localObject), paramInt / 2L);
      }
      label757:
      for (;;)
      {
        j += 1;
        break label469;
        if (this.fTp.getScene() != 1) {
          break;
        }
        if (i != 0) {}
        for (paramInt = i - 1;; paramInt = i)
        {
          localObject = com.tencent.mm.search.c.b.GwA;
          com.tencent.mm.search.c.b.b(paramRecyclerView, paramInt + paramRecyclerView.size());
          break;
        }
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(u paramu) {}
      
      public final void run()
      {
        AppMethodBeat.i(105599);
        u localu = this.fTq;
        ac.i("MicroMsg.SimilarEmoji", "loadGif");
        com.tencent.mm.emoji.a.a.h localh = (com.tencent.mm.emoji.a.a.h)localu.fUq;
        if (localh != null)
        {
          Object localObject = localu.fUw.getEmojiInfo();
          if (localObject != null)
          {
            localObject = ((EmojiInfo)localObject).JC();
            if ((localObject != null) && (((String)localObject).equals(localh.fPB.JC()) == true))
            {
              if (!localu.fUw.isRunning()) {
                localu.fUw.resume();
              }
              AppMethodBeat.o(105599);
              return;
            }
          }
          localu.fUw.setEmojiInfo(localh.fPB);
          AppMethodBeat.o(105599);
          return;
        }
        AppMethodBeat.o(105599);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(EmojiPanelRecyclerView paramEmojiPanelRecyclerView) {}
    
    public final void run()
    {
      AppMethodBeat.i(105601);
      EmojiPanelRecyclerView.a(this.fTp);
      AppMethodBeat.o(105601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.EmojiPanelRecyclerView
 * JD-Core Version:    0.7.0.1
 */
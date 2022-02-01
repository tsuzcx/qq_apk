package com.tencent.mm.plugin.finder.view.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.d.e;
import com.tencent.mm.emoji.panel.a.g;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.view.popview.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/emoji/FinderEmojiPanelRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dispatchCancel", "", "enableLongPress", "getEnableLongPress", "()Z", "setEnableLongPress", "(Z)V", "longPressDelay", "", "longPressRunnable", "Ljava/lang/Runnable;", "longPressed", "panelLifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getPanelLifeCycle", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "setPanelLifeCycle", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "popupHelper", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "scene", "getScene", "()I", "setScene", "(I)V", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "setSizeResolver", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "touchX", "getTouchX", "()F", "setTouchX", "(F)V", "touchY", "getTouchY", "setTouchY", "touched", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onLongPress", "", "onMeasure", "widthSpec", "heightSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEnd", "updatePopView", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderEmojiPanelRecyclerView
  extends RecyclerView
{
  public static final FinderEmojiPanelRecyclerView.a GGZ;
  private final int doK;
  private boolean mkg;
  private boolean mkh;
  private boolean mki;
  private boolean mkj;
  private float mkk;
  private float mkl;
  private float mkm;
  private float mkn;
  private final long mko;
  private boolean mkp;
  private final Runnable mkq;
  private com.tencent.mm.view.popview.a mks;
  private b<com.tencent.mm.vending.e.a> mkt;
  private o mku;
  private int scene;
  
  static
  {
    AppMethodBeat.i(345330);
    GGZ = new FinderEmojiPanelRecyclerView.a((byte)0);
    AppMethodBeat.o(345330);
  }
  
  public FinderEmojiPanelRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(345311);
    AppMethodBeat.o(345311);
  }
  
  public FinderEmojiPanelRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345298);
    this.mkp = true;
    this.mkq = new FinderEmojiPanelRecyclerView..ExternalSyntheticLambda0(this);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    this.mko = ViewConfiguration.getLongPressTimeout();
    this.doK = paramAttributeSet.getScaledTouchSlop();
    this.mks = ((com.tencent.mm.view.popview.a)new d(paramContext));
    AppMethodBeat.o(345298);
  }
  
  private static final void a(FinderEmojiPanelRecyclerView paramFinderEmojiPanelRecyclerView)
  {
    AppMethodBeat.i(345321);
    s.u(paramFinderEmojiPanelRecyclerView, "this$0");
    Object localObject1;
    if (!paramFinderEmojiPanelRecyclerView.mkh)
    {
      localObject1 = paramFinderEmojiPanelRecyclerView.getAdapter();
      if (!(localObject1 instanceof g)) {
        break label135;
      }
      localObject1 = (g)localObject1;
      if (localObject1 != null)
      {
        View localView = paramFinderEmojiPanelRecyclerView.Q(paramFinderEmojiPanelRecyclerView.mkm, paramFinderEmojiPanelRecyclerView.mkn);
        if (localView != null)
        {
          int i = bA(localView);
          Object localObject2 = e.mmt;
          e.aWd().iuy = i;
          localObject1 = ((g)localObject1).rH(i);
          localObject2 = paramFinderEmojiPanelRecyclerView.mks;
          if ((localObject2 == null) || (((com.tencent.mm.view.popview.a)localObject2).b(localView, localObject1) != true)) {
            break label140;
          }
        }
      }
    }
    label135:
    label140:
    for (boolean bool = true;; bool = false)
    {
      paramFinderEmojiPanelRecyclerView.mki = bool;
      Log.i("MicroMsg.FinderEmojiPanelRecyclerView", s.X("long press: ", Boolean.valueOf(paramFinderEmojiPanelRecyclerView.mki)));
      AppMethodBeat.o(345321);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(345441);
    s.u(paramMotionEvent, "event");
    if (!this.mkp)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(345441);
      return bool;
    }
    Object localObject1;
    label174:
    Object localObject2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      if ((this.mki) && (!this.mkj))
      {
        localObject1 = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject1).setAction(3);
        super.dispatchTouchEvent((MotionEvent)localObject1);
        ((MotionEvent)localObject1).recycle();
        this.mkj = true;
      }
      if ((paramMotionEvent.getActionMasked() == 3) || (paramMotionEvent.getActionMasked() == 1))
      {
        removeCallbacks(this.mkq);
        this.mki = false;
        localObject1 = this.mks;
        if (localObject1 != null) {
          ((com.tencent.mm.view.popview.a)localObject1).hjF();
        }
        localObject1 = this.mks;
        if (!(localObject1 instanceof com.tencent.mm.vending.e.a)) {
          break;
        }
        localObject1 = (com.tencent.mm.vending.e.a)localObject1;
        if (localObject1 != null)
        {
          localObject2 = getPanelLifeCycle();
          if (localObject2 != null) {
            ((b)localObject2).keep((com.tencent.mm.vending.e.a)localObject1);
          }
        }
      }
      if (!this.mki) {
        break label529;
      }
      Log.i("MicroMsg.FinderEmojiPanelRecyclerView", "updatePopView: " + this.mkm + ", " + this.mkn);
      paramMotionEvent = getAdapter();
      if (!(paramMotionEvent instanceof g)) {}
      break;
    }
    for (paramMotionEvent = (g)paramMotionEvent;; paramMotionEvent = null)
    {
      if (paramMotionEvent != null)
      {
        localObject1 = Q(this.mkm, this.mkn);
        if (localObject1 != null)
        {
          int i = bA((View)localObject1);
          localObject2 = e.mmt;
          e.aWd().iuy = i;
          paramMotionEvent = paramMotionEvent.rH(i);
          localObject2 = this.mks;
          if (localObject2 != null) {
            ((com.tencent.mm.view.popview.a)localObject2).c((View)localObject1, paramMotionEvent);
          }
        }
      }
      AppMethodBeat.o(345441);
      return true;
      this.mkg = true;
      this.mki = false;
      this.mkh = false;
      this.mkj = false;
      this.mkk = paramMotionEvent.getX();
      this.mkl = paramMotionEvent.getY();
      this.mkm = paramMotionEvent.getX();
      this.mkn = paramMotionEvent.getY();
      if (!this.mkp) {
        break;
      }
      postDelayed(this.mkq, this.mko);
      break;
      this.mkm = paramMotionEvent.getX();
      this.mkn = paramMotionEvent.getY();
      if ((!this.mkg) || (this.mkh) || ((Math.abs(this.mkk - paramMotionEvent.getX()) <= this.doK) && (Math.abs(this.mkl - paramMotionEvent.getY()) <= this.doK))) {
        break;
      }
      this.mkh = true;
      if (this.mki) {
        break;
      }
      removeCallbacks(this.mkq);
      break;
      this.mkg = false;
      this.mkh = false;
      break;
      localObject1 = null;
      break label174;
    }
    label529:
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(345441);
    return bool;
  }
  
  public final boolean getEnableLongPress()
  {
    return this.mkp;
  }
  
  public final b<com.tencent.mm.vending.e.a> getPanelLifeCycle()
  {
    return this.mkt;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final o getSizeResolver()
  {
    return this.mku;
  }
  
  public final float getTouchX()
  {
    return this.mkm;
  }
  
  public final float getTouchY()
  {
    return this.mkn;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(345446);
    s.u(paramMotionEvent, "event");
    if (this.mki)
    {
      AppMethodBeat.o(345446);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(345446);
    return bool;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(345427);
    o localo = this.mku;
    if (localo != null)
    {
      localObject = getLayoutManager();
      if (!(localObject instanceof GridLayoutManager)) {
        break label60;
      }
    }
    label60:
    for (Object localObject = (GridLayoutManager)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((GridLayoutManager)localObject).fI(localo.spanCount);
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(345427);
      return;
    }
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(345418);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    o localo = this.mku;
    if (localo != null)
    {
      localo.rI(paramInt1);
      localObject = getLayoutManager();
      if (!(localObject instanceof GridLayoutManager)) {
        break label97;
      }
    }
    label97:
    for (Object localObject = (GridLayoutManager)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((GridLayoutManager)localObject).fI(localo.spanCount);
      }
      setPadding(localo.contentPadding, getPaddingTop(), localo.contentPadding, getPaddingBottom());
      AppMethodBeat.o(345418);
      return;
    }
  }
  
  public final void setEnableLongPress(boolean paramBoolean)
  {
    this.mkp = paramBoolean;
  }
  
  public final void setPanelLifeCycle(b<com.tencent.mm.vending.e.a> paramb)
  {
    this.mkt = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSizeResolver(o paramo)
  {
    this.mku = paramo;
  }
  
  public final void setTouchX(float paramFloat)
  {
    this.mkm = paramFloat;
  }
  
  public final void setTouchY(float paramFloat)
  {
    this.mkn = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.emoji.FinderEmojiPanelRecyclerView
 * JD-Core Version:    0.7.0.1
 */
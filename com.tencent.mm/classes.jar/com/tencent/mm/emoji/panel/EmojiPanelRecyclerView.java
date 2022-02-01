package com.tencent.mm.emoji.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.d.e;
import com.tencent.mm.emoji.panel.a.g;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.emoji.panel.a.z;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "dispatchCancel", "", "enableLongPress", "getEnableLongPress", "()Z", "setEnableLongPress", "(Z)V", "longPressDelay", "", "longPressRunnable", "Ljava/lang/Runnable;", "longPressed", "panelLifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getPanelLifeCycle", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "setPanelLifeCycle", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "parentRecycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelGroupView;", "popupHelper", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "scene", "getScene", "()I", "setScene", "(I)V", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "setSizeResolver", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "touchX", "getTouchX", "()F", "setTouchX", "(F)V", "touchY", "getTouchY", "setTouchY", "touched", "bind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "emojiSearchGifPerformanceMode", "gifPerformanceMode", "onAttachedToWindow", "onInterceptTouchEvent", "onLongPress", "onMeasure", "widthSpec", "heightSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEnd", "setEmojiPopupType", "type", "updatePopView", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class EmojiPanelRecyclerView
  extends RecyclerView
{
  private final String TAG;
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
  private EmojiPanelGroupView mkr;
  public com.tencent.mm.view.popview.a mks;
  private com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> mkt;
  private o mku;
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
    this.mkp = true;
    this.mkq = new EmojiPanelRecyclerView..ExternalSyntheticLambda0(this);
    paramContext = ViewConfiguration.get(paramContext);
    this.mko = ViewConfiguration.getLongPressTimeout();
    this.doK = paramContext.getScaledTouchSlop();
    AppMethodBeat.o(105610);
  }
  
  private static final void a(EmojiPanelRecyclerView paramEmojiPanelRecyclerView)
  {
    AppMethodBeat.i(242370);
    s.u(paramEmojiPanelRecyclerView, "this$0");
    Object localObject1;
    if (!paramEmojiPanelRecyclerView.mkh)
    {
      localObject1 = paramEmojiPanelRecyclerView.getAdapter();
      if (!(localObject1 instanceof g)) {
        break label158;
      }
      localObject1 = (g)localObject1;
      if (localObject1 != null)
      {
        View localView = paramEmojiPanelRecyclerView.Q(paramEmojiPanelRecyclerView.mkm, paramEmojiPanelRecyclerView.mkn);
        if (localView != null)
        {
          int i = bA(localView);
          Object localObject2 = e.mmt;
          e.aWd().iuy = i;
          localObject1 = ((g)localObject1).rH(i);
          localObject2 = paramEmojiPanelRecyclerView.mks;
          if ((localObject2 == null) || (((com.tencent.mm.view.popview.a)localObject2).b(localView, localObject1) != true)) {
            break label163;
          }
        }
      }
    }
    label158:
    label163:
    for (boolean bool = true;; bool = false)
    {
      paramEmojiPanelRecyclerView.mki = bool;
      if (paramEmojiPanelRecyclerView.mki)
      {
        localObject1 = paramEmojiPanelRecyclerView.mkr;
        if (localObject1 != null) {
          ((EmojiPanelGroupView)localObject1).setScrollEnable(false);
        }
      }
      Log.i(paramEmojiPanelRecyclerView.TAG, s.X("long press: ", Boolean.valueOf(paramEmojiPanelRecyclerView.mki)));
      AppMethodBeat.o(242370);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void aVK()
  {
    AppMethodBeat.i(105602);
    a((RecyclerView.l)new b(this));
    AppMethodBeat.o(105602);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105605);
    s.u(paramMotionEvent, "event");
    if (!this.mkp)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(105605);
      return bool;
    }
    Object localObject1;
    label195:
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
        localObject1 = this.mkr;
        if (localObject1 != null) {
          ((EmojiPanelGroupView)localObject1).setScrollEnable(true);
        }
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
            ((com.tencent.mm.vending.e.b)localObject2).keep((com.tencent.mm.vending.e.a)localObject1);
          }
        }
      }
      if (!this.mki) {
        break label567;
      }
      Log.i(this.TAG, "updatePopView: " + this.mkm + ", " + this.mkn);
      paramMotionEvent = this.mkr;
      if (paramMotionEvent != null) {
        paramMotionEvent.setScrollEnable(false);
      }
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
      AppMethodBeat.o(105605);
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
      break label195;
    }
    label567:
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(105605);
    return bool;
  }
  
  protected final boolean getEnableLongPress()
  {
    return this.mkp;
  }
  
  public final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> getPanelLifeCycle()
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
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(105607);
    super.onAttachedToWindow();
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof EmojiPanelGroupView))
      {
        this.mkr = ((EmojiPanelGroupView)localViewParent);
        AppMethodBeat.o(105607);
        return;
      }
    }
    AppMethodBeat.o(105607);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105606);
    s.u(paramMotionEvent, "event");
    if (this.mki)
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
      AppMethodBeat.o(105604);
      return;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105603);
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
      AppMethodBeat.o(105603);
      return;
    }
  }
  
  public final void setEmojiPopupType(int paramInt)
  {
    AppMethodBeat.i(183958);
    Context localContext = getContext();
    s.s(localContext, "context");
    this.mks = ((com.tencent.mm.view.popview.a)new com.tencent.mm.view.popview.b(localContext, paramInt));
    AppMethodBeat.o(183958);
  }
  
  protected final void setEnableLongPress(boolean paramBoolean)
  {
    this.mkp = paramBoolean;
  }
  
  public final void setPanelLifeCycle(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.l
  {
    public a(EmojiPanelRecyclerView paramEmojiPanelRecyclerView) {}
    
    private static final void a(z paramz)
    {
      AppMethodBeat.i(242361);
      s.u(paramz, "$item");
      paramz.aVU();
      AppMethodBeat.o(242361);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(242389);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      Util.hideVKB((View)paramRecyclerView);
      switch (paramInt)
      {
      }
      int j;
      do
      {
        do
        {
          do
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
            AppMethodBeat.o(242389);
            return;
          } while (!(this.mkv.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a));
          paramRecyclerView = this.mkv.getAdapter();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
            AppMethodBeat.o(242389);
            throw paramRecyclerView;
          }
        } while (!((com.tencent.mm.plugin.emoji.ui.a)paramRecyclerView).mlE);
        paramRecyclerView = this.mkv.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
          AppMethodBeat.o(242389);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.plugin.emoji.ui.a)paramRecyclerView).mlE = false;
        paramRecyclerView = this.mkv.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(242389);
          throw paramRecyclerView;
        }
        paramInt = ((GridLayoutManager)paramRecyclerView).Ju();
        paramRecyclerView = this.mkv.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(242389);
          throw paramRecyclerView;
        }
        int i = ((GridLayoutManager)paramRecyclerView).Jw();
        while (paramInt <= i)
        {
          if ((this.mkv.fU(paramInt) instanceof z))
          {
            paramRecyclerView = this.mkv.fU(paramInt);
            if (paramRecyclerView == null)
            {
              paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
              AppMethodBeat.o(242389);
              throw paramRecyclerView;
            }
            ((z)paramRecyclerView).mlD.pause();
          }
          paramInt += 1;
        }
        if ((this.mkv.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a))
        {
          paramRecyclerView = this.mkv.getAdapter();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
            AppMethodBeat.o(242389);
            throw paramRecyclerView;
          }
          ((com.tencent.mm.plugin.emoji.ui.a)paramRecyclerView).mlE = true;
        }
        paramRecyclerView = this.mkv.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(242389);
          throw paramRecyclerView;
        }
        j = ((GridLayoutManager)paramRecyclerView).Ju();
        paramRecyclerView = this.mkv.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(242389);
          throw paramRecyclerView;
        }
        int m = ((GridLayoutManager)paramRecyclerView).Jw();
        paramRecyclerView = new ArrayList();
        paramInt = 0;
        int k = j;
        while (k <= m)
        {
          if ((k > 0) && ((this.mkv.getAdapter() instanceof com.tencent.mm.plugin.emoji.ui.a)))
          {
            localObject = this.mkv.getAdapter();
            if (localObject == null)
            {
              paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
              AppMethodBeat.o(242389);
              throw paramRecyclerView;
            }
            if ((((com.tencent.mm.plugin.emoji.ui.a)localObject).rH(k) instanceof com.tencent.mm.emoji.c.b.h))
            {
              localObject = this.mkv.getAdapter();
              if (localObject == null)
              {
                paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.emoji.ui.EmojiSearchAdapter");
                AppMethodBeat.o(242389);
                throw paramRecyclerView;
              }
              localObject = ((com.tencent.mm.plugin.emoji.ui.a)localObject).rH(k);
              if (localObject == null)
              {
                paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
                AppMethodBeat.o(242389);
                throw paramRecyclerView;
              }
              paramRecyclerView.add(((com.tencent.mm.emoji.c.b.h)localObject).mgK);
            }
          }
          i = paramInt;
          if ((this.mkv.fU(k) instanceof z))
          {
            i = paramInt + 1;
            localObject = this.mkv.fU(k);
            if (localObject == null)
            {
              paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
              AppMethodBeat.o(242389);
              throw paramRecyclerView;
            }
            localObject = (z)localObject;
            com.tencent.threadpool.h.ahAA.o(new EmojiPanelRecyclerView.a..ExternalSyntheticLambda0((z)localObject), i / 2L);
          }
          k += 1;
          paramInt = i;
        }
      } while (this.mkv.getScene() != 2);
      if (j != 0) {}
      for (paramInt = j - 1;; paramInt = j)
      {
        localObject = com.tencent.mm.emojisearch.c.a.moZ;
        com.tencent.mm.emojisearch.c.a.e(paramRecyclerView, paramRecyclerView.size(), paramInt + paramRecyclerView.size());
        break;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242397);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$emojiSearchGifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(242397);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.l
  {
    b(EmojiPanelRecyclerView paramEmojiPanelRecyclerView) {}
    
    private static final void a(z paramz)
    {
      AppMethodBeat.i(242348);
      s.u(paramz, "$item");
      paramz.aVU();
      AppMethodBeat.o(242348);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(242366);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      int j;
      do
      {
        do
        {
          do
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
            AppMethodBeat.o(242366);
            return;
          } while (!(this.mkv.getAdapter() instanceof com.tencent.mm.search.d.a));
          paramRecyclerView = this.mkv.getAdapter();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(242366);
            throw paramRecyclerView;
          }
        } while (!((com.tencent.mm.search.d.a)paramRecyclerView).mlE);
        paramRecyclerView = this.mkv.getAdapter();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
          AppMethodBeat.o(242366);
          throw paramRecyclerView;
        }
        ((com.tencent.mm.search.d.a)paramRecyclerView).mlE = false;
        paramRecyclerView = this.mkv.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(242366);
          throw paramRecyclerView;
        }
        paramInt = ((GridLayoutManager)paramRecyclerView).Ju();
        paramRecyclerView = this.mkv.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(242366);
          throw paramRecyclerView;
        }
        int i = ((GridLayoutManager)paramRecyclerView).Jw();
        while (paramInt <= i)
        {
          if ((this.mkv.fU(paramInt) instanceof z))
          {
            paramRecyclerView = this.mkv.fU(paramInt);
            if (paramRecyclerView == null)
            {
              paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
              AppMethodBeat.o(242366);
              throw paramRecyclerView;
            }
            ((z)paramRecyclerView).mlD.pause();
          }
          paramInt += 1;
        }
        if ((this.mkv.getAdapter() instanceof com.tencent.mm.search.d.a))
        {
          paramRecyclerView = this.mkv.getAdapter();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
            AppMethodBeat.o(242366);
            throw paramRecyclerView;
          }
          ((com.tencent.mm.search.d.a)paramRecyclerView).mlE = true;
        }
        paramRecyclerView = this.mkv.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(242366);
          throw paramRecyclerView;
        }
        j = ((GridLayoutManager)paramRecyclerView).Ju();
        paramRecyclerView = this.mkv.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
          AppMethodBeat.o(242366);
          throw paramRecyclerView;
        }
        int m = ((GridLayoutManager)paramRecyclerView).Jw();
        paramInt = 0;
        paramRecyclerView = new ArrayList();
        int k = j;
        while (k <= m)
        {
          if ((k > 0) && ((this.mkv.getAdapter() instanceof com.tencent.mm.search.d.a)))
          {
            localObject = this.mkv.getAdapter();
            if (localObject == null)
            {
              paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
              AppMethodBeat.o(242366);
              throw paramRecyclerView;
            }
            if ((((com.tencent.mm.search.d.a)localObject).rH(k) instanceof com.tencent.mm.emoji.c.b.h))
            {
              localObject = this.mkv.getAdapter();
              if (localObject == null)
              {
                paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.search.ui.SimilarEmojiAdapter");
                AppMethodBeat.o(242366);
                throw paramRecyclerView;
              }
              localObject = ((com.tencent.mm.search.d.a)localObject).rH(k);
              if (localObject == null)
              {
                paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
                AppMethodBeat.o(242366);
                throw paramRecyclerView;
              }
              paramRecyclerView.add(((com.tencent.mm.emoji.c.b.h)localObject).mgK);
            }
          }
          i = paramInt;
          if ((this.mkv.fU(k) instanceof z))
          {
            i = paramInt + 1;
            localObject = this.mkv.fU(k);
            if (localObject == null)
            {
              paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.SimilarEmojiNormalViewHolder");
              AppMethodBeat.o(242366);
              throw paramRecyclerView;
            }
            localObject = (z)localObject;
            com.tencent.threadpool.h.ahAA.o(new EmojiPanelRecyclerView.b..ExternalSyntheticLambda0((z)localObject), i / 2L);
          }
          k += 1;
          paramInt = i;
        }
      } while (this.mkv.getScene() != 1);
      if (j != 0) {}
      for (paramInt = j - 1;; paramInt = j)
      {
        localObject = com.tencent.mm.search.c.b.acsj;
        com.tencent.mm.search.c.b.b(paramRecyclerView, paramInt + paramRecyclerView.size());
        break;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242369);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/EmojiPanelRecyclerView$gifPerformanceMode$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(242369);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.EmojiPanelRecyclerView
 * JD-Core Version:    0.7.0.1
 */
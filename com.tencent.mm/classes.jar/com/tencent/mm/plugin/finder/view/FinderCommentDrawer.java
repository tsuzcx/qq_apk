package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.f;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.view.builder.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "banSwitch", "", "getBanSwitch", "()Z", "setBanSwitch", "(Z)V", "blinkRefComment", "getBlinkRefComment", "setBlinkRefComment", "closeComment", "getCloseComment", "setCloseComment", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "interceptClose", "Lkotlin/Function0;", "getInterceptClose", "()Lkotlin/jvm/functions/Function0;", "setInterceptClose", "(Lkotlin/jvm/functions/Function0;)V", "isSelfProfile", "setSelfProfile", "isSingleMode", "setSingleMode", "oldVersion", "getOldVersion", "setOldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "getOnCloseDrawerCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "setOnCloseDrawerCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "reason", "getReason", "()I", "setReason", "(I)V", "rect", "Landroid/graphics/Rect;", "refCommentId", "", "getRefCommentId", "()J", "setRefCommentId", "(J)V", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setReplyCommentObj", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "scene", "getScene", "setScene", "sceneForReply", "getSceneForReply", "setSceneForReply", "showFooter", "getShowFooter", "setShowFooter", "useCache", "getUseCache", "setUseCache", "closeDrawer", "", "closeDrawerWhenError", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onUIPause", "onUIResume", "openDrawer", "fullScreen", "refreshSceneForReply", "switchScene", "Builder", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawer
  extends RecyclerViewDrawer
{
  public static final b wkG;
  private int bDZ;
  private boolean efT;
  private final Rect rect;
  private int scene;
  public FinderItem tMO;
  private CommentDrawerContract.CloseDrawerCallback tMR;
  public boolean tMV;
  private boolean tMW;
  private long tuj;
  private boolean tzn;
  public boolean uLZ;
  private an wkA;
  public int wkB;
  private boolean wkC;
  public FinderCommentFooter wkD;
  private boolean wkE;
  private a<Boolean> wkF;
  private boolean wkz;
  
  static
  {
    AppMethodBeat.i(168255);
    wkG = new b((byte)0);
    AppMethodBeat.o(168255);
  }
  
  public FinderCommentDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168252);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = c.vCb;
    this.wkB = c.drS();
    this.efT = true;
    this.wkz = true;
    this.tzn = true;
    AppMethodBeat.o(168252);
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168253);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = c.vCb;
    this.wkB = c.drS();
    this.efT = true;
    this.wkz = true;
    this.tzn = true;
    AppMethodBeat.o(168253);
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168254);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = c.vCb;
    this.wkB = c.drS();
    this.efT = true;
    this.wkz = true;
    this.tzn = true;
    AppMethodBeat.o(168254);
  }
  
  public final void dGr()
  {
    AppMethodBeat.i(168251);
    if (dGs())
    {
      Object localObject1;
      Object localObject2;
      int i;
      FinderItem localFinderItem;
      if (this.tMV)
      {
        super.DG(false);
        localObject1 = getHeaderLayout().findViewById(2131300794);
        p.g(localObject1, "headerErrTipLayout");
        ((View)localObject1).setVisibility(8);
        localObject1 = FinderReporterUIC.wzC;
        localObject1 = getContext();
        p.g(localObject1, "context");
        localObject2 = FinderReporterUIC.a.fH((Context)localObject1);
        if (localObject2 == null) {
          break label154;
        }
        localObject1 = k.vfA;
        i = ((FinderReporterUIC)localObject2).tCE;
        localObject1 = ((FinderReporterUIC)localObject2).sGQ;
        localObject2 = ((FinderReporterUIC)localObject2).sGE;
        localFinderItem = this.tMO;
        if (localFinderItem == null) {
          break label149;
        }
      }
      label149:
      for (long l = localFinderItem.getId();; l = 0L)
      {
        k.a(i, (String)localObject1, (String)localObject2, l, 3);
        AppMethodBeat.o(168251);
        return;
        super.DG(true);
        break;
      }
    }
    label154:
    AppMethodBeat.o(168251);
  }
  
  final void dGv()
  {
    AppMethodBeat.i(178471);
    if (this.uLZ)
    {
      this.wkB = this.scene;
      Log.i("Finder.CommentDrawer", "refreshSceneForReply isSelfProfile " + this.scene);
    }
    for (;;)
    {
      Object localObject = this.wkD;
      if (localObject != null) {
        ((FinderCommentFooter)localObject).setScene(this.wkB);
      }
      localObject = this.wkD;
      if (localObject == null) {
        break;
      }
      ((FinderCommentFooter)localObject).dGy();
      AppMethodBeat.o(178471);
      return;
      localObject = c.vCb;
      this.wkB = c.drS();
    }
    AppMethodBeat.o(178471);
  }
  
  public final void dGw()
  {
    AppMethodBeat.i(254737);
    Object localObject = this.wkF;
    if (localObject != null)
    {
      localObject = (Boolean)((a)localObject).invoke();
      if (localObject == null) {}
    }
    for (boolean bool = ((Boolean)localObject).booleanValue(); bool; bool = false)
    {
      AppMethodBeat.o(254737);
      return;
    }
    dGr();
    AppMethodBeat.o(254737);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168247);
    p.h(paramMotionEvent, "event");
    View localView;
    if (this.tMV)
    {
      localView = getFooterLayout().findViewById(2131298940);
      this.rect.setEmpty();
      localView.getGlobalVisibleRect(this.rect);
      if (this.rect.top > paramMotionEvent.getY())
      {
        if ((paramMotionEvent.getAction() != 2) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
          break label139;
        }
        dGr();
      }
    }
    boolean bool;
    for (;;)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      if ((!this.Rof) || (paramMotionEvent.getAction() != 0)) {
        break label334;
      }
      paramMotionEvent = getContext();
      if (paramMotionEvent != null) {
        break;
      }
      paramMotionEvent = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(168247);
      throw paramMotionEvent;
      label139:
      if (paramMotionEvent.getAction() == 0)
      {
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(168247);
        return true;
        localView = getHeaderLayout().findViewById(2131300794);
        this.rect.setEmpty();
        localView.getGlobalVisibleRect(this.rect);
        Log.d("Finder.CommentDrawer", "event.action " + paramMotionEvent.getActionMasked() + " event.y " + paramMotionEvent.getY() + ", " + this.rect.top + ", " + this.rect.bottom);
        if ((paramMotionEvent.getY() >= this.rect.top) && (paramMotionEvent.getY() <= this.rect.bottom))
        {
          if (paramMotionEvent.getActionMasked() != 2)
          {
            bool = localView.dispatchTouchEvent(paramMotionEvent);
            AppMethodBeat.o(168247);
            return bool;
          }
        }
        else
        {
          p.g(localView, "headerErrTipLayout");
          localView.setPressed(false);
        }
      }
    }
    ((MMFragmentActivity)paramMotionEvent).hideVKB();
    label334:
    AppMethodBeat.o(168247);
    return bool;
  }
  
  public final boolean getBanSwitch()
  {
    return this.wkE;
  }
  
  public final boolean getBlinkRefComment()
  {
    return this.tMW;
  }
  
  public final boolean getCloseComment()
  {
    return this.wkC;
  }
  
  public final FinderItem getFeedObj()
  {
    return this.tMO;
  }
  
  public final FinderCommentFooter getFooter()
  {
    return this.wkD;
  }
  
  public final a<Boolean> getInterceptClose()
  {
    return this.wkF;
  }
  
  public final boolean getOldVersion()
  {
    return this.tzn;
  }
  
  public final CommentDrawerContract.CloseDrawerCallback getOnCloseDrawerCallback()
  {
    return this.tMR;
  }
  
  public final int getReason()
  {
    return this.bDZ;
  }
  
  public final long getRefCommentId()
  {
    return this.tuj;
  }
  
  public final an getReplyCommentObj()
  {
    return this.wkA;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSceneForReply()
  {
    return this.wkB;
  }
  
  public final boolean getShowFooter()
  {
    return this.wkz;
  }
  
  public final boolean getUseCache()
  {
    return this.efT;
  }
  
  public final void setBanSwitch(boolean paramBoolean)
  {
    this.wkE = paramBoolean;
  }
  
  public final void setBlinkRefComment(boolean paramBoolean)
  {
    this.tMW = paramBoolean;
  }
  
  public final void setCloseComment(boolean paramBoolean)
  {
    this.wkC = paramBoolean;
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.tMO = paramFinderItem;
  }
  
  public final void setFooter(FinderCommentFooter paramFinderCommentFooter)
  {
    this.wkD = paramFinderCommentFooter;
  }
  
  public final void setInterceptClose(a<Boolean> parama)
  {
    this.wkF = parama;
  }
  
  public final void setOldVersion(boolean paramBoolean)
  {
    this.tzn = paramBoolean;
  }
  
  public final void setOnCloseDrawerCallback(CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    this.tMR = paramCloseDrawerCallback;
  }
  
  public final void setReason(int paramInt)
  {
    this.bDZ = paramInt;
  }
  
  public final void setRefCommentId(long paramLong)
  {
    this.tuj = paramLong;
  }
  
  public final void setReplyCommentObj(an paraman)
  {
    this.wkA = paraman;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSceneForReply(int paramInt)
  {
    this.wkB = paramInt;
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.uLZ = paramBoolean;
  }
  
  public final void setShowFooter(boolean paramBoolean)
  {
    this.wkz = paramBoolean;
  }
  
  public final void setSingleMode(boolean paramBoolean)
  {
    this.tMV = paramBoolean;
  }
  
  public final void setUseCache(boolean paramBoolean)
  {
    this.efT = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "", "onBuildDrawerBody", "", "context", "Landroid/content/Context;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onBuildDrawerFooter", "footerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "onBuildDrawerHeader", "headerLayout", "onBuildLoading", "loadingLayout", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "displayScene", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
    
    public abstract void a(Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout);
    
    public abstract void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt);
    
    public abstract void b(Context paramContext, FrameLayout paramFrameLayout);
    
    public abstract void b(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Companion;", "", "()V", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "parent", "Landroid/view/View;", "scene", "", "builder", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "safeMode", "", "fullScreen", "exposeScene", "plugin-finder_release"})
  public static final class b
  {
    private static FinderCommentDrawer a(MMFragmentActivity paramMMFragmentActivity, final View paramView, int paramInt1, final FinderCommentDrawer.a parama, boolean paramBoolean1, final boolean paramBoolean2, int paramInt2)
    {
      AppMethodBeat.i(254733);
      p.h(paramMMFragmentActivity, "context");
      p.h(paramView, "parent");
      p.h(parama, "builder");
      final FinderCommentDrawer localFinderCommentDrawer = new FinderCommentDrawer((Context)paramMMFragmentActivity);
      if (paramBoolean2)
      {
        localFinderCommentDrawer.setTopOffset(ao.jJ((Context)paramMMFragmentActivity));
        localFinderCommentDrawer.setBackgroundColorRes(2131101287);
      }
      Object localObject1 = paramMMFragmentActivity.getResources();
      p.g(localObject1, "context.resources");
      localFinderCommentDrawer.setTopOffset((int)(((Resources)localObject1).getDisplayMetrics().heightPixels * 0.2D));
      parama.a((RecyclerViewDrawer)localFinderCommentDrawer, paramInt1);
      if (!(parama instanceof b)) {}
      for (localObject1 = null;; localObject1 = parama)
      {
        localObject1 = (b)localObject1;
        if (localObject1 != null) {}
        for (localObject1 = ((b)localObject1).tzm;; localObject1 = null)
        {
          Object localObject2 = localObject1;
          if (!(localObject1 instanceof f)) {
            localObject2 = null;
          }
          localObject1 = (f)localObject2;
          if (localObject1 != null) {
            ((f)localObject1).tMM = paramInt2;
          }
          localObject1 = ((b)parama).tzm;
          if (localObject1 != null) {
            break;
          }
          paramMMFragmentActivity = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderCommentDrawerPresenter");
          AppMethodBeat.o(254733);
          throw paramMMFragmentActivity;
        }
        ((f)localObject1).tAj = paramBoolean1;
        paramView.post((Runnable)new a(paramMMFragmentActivity, paramView, localFinderCommentDrawer, new FrameLayout.LayoutParams(-1, -1), parama, paramBoolean2));
        AppMethodBeat.o(254733);
        return localFinderCommentDrawer;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MMFragmentActivity paramMMFragmentActivity, View paramView, FinderCommentDrawer paramFinderCommentDrawer, FrameLayout.LayoutParams paramLayoutParams, FinderCommentDrawer.a parama, boolean paramBoolean) {}
      
      public final void run()
      {
        AppMethodBeat.i(168243);
        Log.i("Finder.CommentDrawer", "[initView] bottomMargin= ".concat(String.valueOf(au.aB((Context)this.vWD))));
        Object localObject = paramView;
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(168243);
          throw ((Throwable)localObject);
        }
        ((FrameLayout)localObject).addView((View)localFinderCommentDrawer, (ViewGroup.LayoutParams)this.wkJ);
        parama.a((Context)this.vWD, localFinderCommentDrawer.getHeaderLayout(), paramBoolean2);
        parama.a((Context)this.vWD, localFinderCommentDrawer.getCenterLayout());
        parama.b((Context)this.vWD, localFinderCommentDrawer.getFooterLayout(), paramBoolean2);
        parama.b((Context)this.vWD, localFinderCommentDrawer.getLoadingLayout());
        AppMethodBeat.o(168243);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentDrawer
 * JD-Core Version:    0.7.0.1
 */
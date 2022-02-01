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
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.f;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.view.builder.b;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "banSwitch", "", "getBanSwitch", "()Z", "setBanSwitch", "(Z)V", "blinkRefComment", "getBlinkRefComment", "setBlinkRefComment", "closeComment", "getCloseComment", "setCloseComment", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "interceptClose", "Lkotlin/Function0;", "getInterceptClose", "()Lkotlin/jvm/functions/Function0;", "setInterceptClose", "(Lkotlin/jvm/functions/Function0;)V", "isSelfProfile", "setSelfProfile", "isSingleMode", "setSingleMode", "oldVersion", "getOldVersion", "setOldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "getOnCloseDrawerCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "setOnCloseDrawerCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "reason", "getReason", "()I", "setReason", "(I)V", "rect", "Landroid/graphics/Rect;", "refCommentId", "", "getRefCommentId", "()J", "setRefCommentId", "(J)V", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setReplyCommentObj", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "scene", "getScene", "setScene", "sceneForReply", "getSceneForReply", "setSceneForReply", "showFooter", "getShowFooter", "setShowFooter", "useCache", "getUseCache", "setUseCache", "closeDrawer", "", "closeDrawerWhenError", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onUIPause", "onUIResume", "openDrawer", "fullScreen", "refreshSceneForReply", "switchScene", "Builder", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawer
  extends RecyclerViewDrawer
{
  public static final b AVC;
  private boolean AVA;
  private a<Boolean> AVB;
  private boolean AVv;
  private am AVw;
  public int AVx;
  private boolean AVy;
  public FinderCommentFooter AVz;
  private int bnA;
  private final Rect byG;
  private boolean gaj;
  public boolean mss;
  private int scene;
  private long xbT;
  private boolean xgY;
  public FinderItem xwF;
  private CommentDrawerContract.CloseDrawerCallback xwI;
  private boolean xwM;
  public boolean zxL;
  
  static
  {
    AppMethodBeat.i(168255);
    AVC = new b((byte)0);
    AppMethodBeat.o(168255);
  }
  
  public FinderCommentDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168252);
    this.byG = new Rect();
    this.scene = 2;
    paramContext = d.AjH;
    this.AVx = d.dTi();
    this.gaj = true;
    this.AVv = true;
    this.xgY = true;
    AppMethodBeat.o(168252);
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168253);
    this.byG = new Rect();
    this.scene = 2;
    paramContext = d.AjH;
    this.AVx = d.dTi();
    this.gaj = true;
    this.AVv = true;
    this.xgY = true;
    AppMethodBeat.o(168253);
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168254);
    this.byG = new Rect();
    this.scene = 2;
    paramContext = d.AjH;
    this.AVx = d.dTi();
    this.gaj = true;
    this.AVv = true;
    this.xgY = true;
    AppMethodBeat.o(168254);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168247);
    p.k(paramMotionEvent, "event");
    View localView;
    if (this.mss)
    {
      localView = getFooterLayout().findViewById(b.f.comment_et_layout);
      this.byG.setEmpty();
      localView.getGlobalVisibleRect(this.byG);
      if (this.byG.top > paramMotionEvent.getY())
      {
        if ((paramMotionEvent.getAction() != 2) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
          break label139;
        }
        eir();
      }
    }
    boolean bool;
    for (;;)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      if ((!ihF()) || (paramMotionEvent.getAction() != 0)) {
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
        localView = getHeaderLayout().findViewById(b.f.finder_comment_error_tip);
        this.byG.setEmpty();
        localView.getGlobalVisibleRect(this.byG);
        Log.d("Finder.CommentDrawer", "event.action " + paramMotionEvent.getActionMasked() + " event.y " + paramMotionEvent.getY() + ", " + this.byG.top + ", " + this.byG.bottom);
        if ((paramMotionEvent.getY() >= this.byG.top) && (paramMotionEvent.getY() <= this.byG.bottom))
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
          p.j(localView, "headerErrTipLayout");
          localView.setPressed(false);
        }
      }
    }
    ((MMFragmentActivity)paramMotionEvent).hideVKB();
    label334:
    AppMethodBeat.o(168247);
    return bool;
  }
  
  public final void eir()
  {
    AppMethodBeat.i(168251);
    if (eis())
    {
      Object localObject1;
      Object localObject2;
      int i;
      FinderItem localFinderItem;
      if (this.mss)
      {
        super.Ig(false);
        localObject1 = getHeaderLayout().findViewById(b.f.finder_comment_error_tip);
        p.j(localObject1, "headerErrTipLayout");
        ((View)localObject1).setVisibility(8);
        localObject1 = aj.Bnu;
        localObject1 = getContext();
        p.j(localObject1, "context");
        localObject2 = aj.a.fZ((Context)localObject1);
        if (localObject2 == null) {
          break label154;
        }
        localObject1 = n.zWF;
        i = ((aj)localObject2).xkX;
        localObject1 = ((aj)localObject2).wmL;
        localObject2 = ((aj)localObject2).wmz;
        localFinderItem = this.xwF;
        if (localFinderItem == null) {
          break label149;
        }
      }
      label149:
      for (long l = localFinderItem.getId();; l = 0L)
      {
        n.a(i, (String)localObject1, (String)localObject2, l, 3);
        AppMethodBeat.o(168251);
        return;
        super.Ig(true);
        break;
      }
    }
    label154:
    AppMethodBeat.o(168251);
  }
  
  final void eiv()
  {
    AppMethodBeat.i(178471);
    if (this.zxL)
    {
      this.AVx = this.scene;
      Log.i("Finder.CommentDrawer", "refreshSceneForReply isSelfProfile " + this.scene);
    }
    for (;;)
    {
      Object localObject = this.AVz;
      if (localObject != null) {
        ((FinderCommentFooter)localObject).setScene(this.AVx);
      }
      localObject = this.AVz;
      if (localObject == null) {
        break;
      }
      ((FinderCommentFooter)localObject).eiy();
      AppMethodBeat.o(178471);
      return;
      localObject = d.AjH;
      this.AVx = d.dTi();
    }
    AppMethodBeat.o(178471);
  }
  
  public final void eiw()
  {
    AppMethodBeat.i(282948);
    Object localObject = this.AVB;
    if (localObject != null)
    {
      localObject = (Boolean)((a)localObject).invoke();
      if (localObject == null) {}
    }
    for (boolean bool = ((Boolean)localObject).booleanValue(); bool; bool = false)
    {
      AppMethodBeat.o(282948);
      return;
    }
    eir();
    AppMethodBeat.o(282948);
  }
  
  public final boolean getBanSwitch()
  {
    return this.AVA;
  }
  
  public final boolean getBlinkRefComment()
  {
    return this.xwM;
  }
  
  public final boolean getCloseComment()
  {
    return this.AVy;
  }
  
  public final FinderItem getFeedObj()
  {
    return this.xwF;
  }
  
  public final FinderCommentFooter getFooter()
  {
    return this.AVz;
  }
  
  public final a<Boolean> getInterceptClose()
  {
    return this.AVB;
  }
  
  public final boolean getOldVersion()
  {
    return this.xgY;
  }
  
  public final CommentDrawerContract.CloseDrawerCallback getOnCloseDrawerCallback()
  {
    return this.xwI;
  }
  
  public final int getReason()
  {
    return this.bnA;
  }
  
  public final long getRefCommentId()
  {
    return this.xbT;
  }
  
  public final am getReplyCommentObj()
  {
    return this.AVw;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSceneForReply()
  {
    return this.AVx;
  }
  
  public final boolean getShowFooter()
  {
    return this.AVv;
  }
  
  public final boolean getUseCache()
  {
    return this.gaj;
  }
  
  public final void setBanSwitch(boolean paramBoolean)
  {
    this.AVA = paramBoolean;
  }
  
  public final void setBlinkRefComment(boolean paramBoolean)
  {
    this.xwM = paramBoolean;
  }
  
  public final void setCloseComment(boolean paramBoolean)
  {
    this.AVy = paramBoolean;
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.xwF = paramFinderItem;
  }
  
  public final void setFooter(FinderCommentFooter paramFinderCommentFooter)
  {
    this.AVz = paramFinderCommentFooter;
  }
  
  public final void setInterceptClose(a<Boolean> parama)
  {
    this.AVB = parama;
  }
  
  public final void setOldVersion(boolean paramBoolean)
  {
    this.xgY = paramBoolean;
  }
  
  public final void setOnCloseDrawerCallback(CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    this.xwI = paramCloseDrawerCallback;
  }
  
  public final void setReason(int paramInt)
  {
    this.bnA = paramInt;
  }
  
  public final void setRefCommentId(long paramLong)
  {
    this.xbT = paramLong;
  }
  
  public final void setReplyCommentObj(am paramam)
  {
    this.AVw = paramam;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSceneForReply(int paramInt)
  {
    this.AVx = paramInt;
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.zxL = paramBoolean;
  }
  
  public final void setShowFooter(boolean paramBoolean)
  {
    this.AVv = paramBoolean;
  }
  
  public final void setSingleMode(boolean paramBoolean)
  {
    this.mss = paramBoolean;
  }
  
  public final void setUseCache(boolean paramBoolean)
  {
    this.gaj = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "", "onBuildDrawerBody", "", "context", "Landroid/content/Context;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onBuildDrawerFooter", "footerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "onBuildDrawerHeader", "headerLayout", "onBuildLoading", "loadingLayout", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "displayScene", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
    
    public abstract void a(Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout);
    
    public abstract void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt);
    
    public abstract void b(Context paramContext, FrameLayout paramFrameLayout);
    
    public abstract void b(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Companion;", "", "()V", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "parent", "Landroid/view/View;", "scene", "", "builder", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "safeMode", "", "fullScreen", "exposeScene", "plugin-finder_release"})
  public static final class b
  {
    private static FinderCommentDrawer a(MMFragmentActivity paramMMFragmentActivity, final View paramView, int paramInt1, final FinderCommentDrawer.a parama, boolean paramBoolean1, final boolean paramBoolean2, int paramInt2)
    {
      AppMethodBeat.i(273110);
      p.k(paramMMFragmentActivity, "context");
      p.k(paramView, "parent");
      p.k(parama, "builder");
      final FinderCommentDrawer localFinderCommentDrawer = new FinderCommentDrawer((Context)paramMMFragmentActivity);
      if (paramBoolean2)
      {
        localFinderCommentDrawer.setTopOffset(ar.kI((Context)paramMMFragmentActivity));
        localFinderCommentDrawer.setBackgroundColorRes(b.c.transparent);
      }
      Object localObject1 = paramMMFragmentActivity.getResources();
      p.j(localObject1, "context.resources");
      localFinderCommentDrawer.setTopOffset((int)(((Resources)localObject1).getDisplayMetrics().heightPixels * 0.2D));
      parama.a((RecyclerViewDrawer)localFinderCommentDrawer, paramInt1);
      if (!(parama instanceof b)) {}
      for (localObject1 = null;; localObject1 = parama)
      {
        localObject1 = (b)localObject1;
        if (localObject1 != null) {}
        for (localObject1 = ((b)localObject1).xgX;; localObject1 = null)
        {
          Object localObject2 = localObject1;
          if (!(localObject1 instanceof f)) {
            localObject2 = null;
          }
          localObject1 = (f)localObject2;
          if (localObject1 != null) {
            ((f)localObject1).xwD = paramInt2;
          }
          localObject1 = ((b)parama).xgX;
          if (localObject1 != null) {
            break;
          }
          paramMMFragmentActivity = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderCommentDrawerPresenter");
          AppMethodBeat.o(273110);
          throw paramMMFragmentActivity;
        }
        ((f)localObject1).safeMode = paramBoolean1;
        paramView.post((Runnable)new a(paramMMFragmentActivity, paramView, localFinderCommentDrawer, new FrameLayout.LayoutParams(-1, -1), parama, paramBoolean2));
        AppMethodBeat.o(273110);
        return localFinderCommentDrawer;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MMFragmentActivity paramMMFragmentActivity, View paramView, FinderCommentDrawer paramFinderCommentDrawer, FrameLayout.LayoutParams paramLayoutParams, FinderCommentDrawer.a parama, boolean paramBoolean) {}
      
      public final void run()
      {
        AppMethodBeat.i(168243);
        Log.i("Finder.CommentDrawer", "[initView] bottomMargin= ".concat(String.valueOf(ax.az((Context)this.AEU))));
        Object localObject = paramView;
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(168243);
          throw ((Throwable)localObject);
        }
        ((FrameLayout)localObject).addView((View)localFinderCommentDrawer, (ViewGroup.LayoutParams)this.AVF);
        parama.a((Context)this.AEU, localFinderCommentDrawer.getHeaderLayout(), paramBoolean2);
        parama.a((Context)this.AEU, localFinderCommentDrawer.getCenterLayout());
        parama.b((Context)this.AEU, localFinderCommentDrawer.getFooterLayout(), paramBoolean2);
        parama.b((Context)this.AEU, localFinderCommentDrawer.getLoadingLayout());
        AppMethodBeat.o(168243);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentDrawer
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "blinkRefComment", "", "getBlinkRefComment", "()Z", "setBlinkRefComment", "(Z)V", "closeComment", "getCloseComment", "setCloseComment", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "interceptClose", "Lkotlin/Function0;", "getInterceptClose", "()Lkotlin/jvm/functions/Function0;", "setInterceptClose", "(Lkotlin/jvm/functions/Function0;)V", "isSelfProfile", "setSelfProfile", "isSingleMode", "setSingleMode", "oldVersion", "getOldVersion", "setOldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "getOnCloseDrawerCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "setOnCloseDrawerCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "rect", "Landroid/graphics/Rect;", "refCommentId", "", "getRefCommentId", "()J", "setRefCommentId", "(J)V", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setReplyCommentObj", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "scene", "getScene", "()I", "setScene", "(I)V", "sceneForReply", "getSceneForReply", "setSceneForReply", "showFooter", "getShowFooter", "setShowFooter", "useCache", "getUseCache", "setUseCache", "closeDrawer", "", "closeDrawerWhenError", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onUIPause", "onUIResume", "openDrawer", "fullScreen", "refreshSceneForReply", "switchScene", "Builder", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawer
  extends RecyclerViewDrawer
{
  public static final b qVJ;
  private d.g.a.a<Boolean> LeF;
  private boolean dCJ;
  public int qVD;
  public boolean qVE;
  private boolean qVF;
  private boolean qVG;
  private com.tencent.mm.plugin.finder.storage.k qVH;
  public FinderCommentFooter qVI;
  private long qoE;
  private boolean qqi;
  public boolean quB;
  private boolean quC;
  public FinderItem quu;
  private CommentDrawerContract.CloseDrawerCallback qux;
  private final Rect rect;
  private int scene;
  
  static
  {
    AppMethodBeat.i(168255);
    qVJ = new b((byte)0);
    AppMethodBeat.o(168255);
  }
  
  public FinderCommentDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168252);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = com.tencent.mm.plugin.finder.storage.b.qJA;
    this.qVD = com.tencent.mm.plugin.finder.storage.b.fUn();
    this.dCJ = true;
    this.qVF = true;
    this.qqi = true;
    AppMethodBeat.o(168252);
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168253);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = com.tencent.mm.plugin.finder.storage.b.qJA;
    this.qVD = com.tencent.mm.plugin.finder.storage.b.fUn();
    this.dCJ = true;
    this.qVF = true;
    this.qqi = true;
    AppMethodBeat.o(168253);
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168254);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = com.tencent.mm.plugin.finder.storage.b.qJA;
    this.qVD = com.tencent.mm.plugin.finder.storage.b.fUn();
    this.dCJ = true;
    this.qVF = true;
    this.qqi = true;
    AppMethodBeat.o(168254);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, com.tencent.mm.plugin.finder.storage.k paramk)
  {
    AppMethodBeat.i(200061);
    d.g.b.k.h(paramFinderItem, "feedObj");
    e.vIY.idkeyStat(1278L, 6L, 1L, false);
    Object localObject = FinderReporterUIC.Ljl;
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    localObject = FinderReporterUIC.a.lB((Context)localObject);
    int i;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.report.b localb = com.tencent.mm.plugin.finder.report.b.qFq;
      int j = ((FinderReporterUIC)localObject).qqE;
      long l = paramFinderItem.getId();
      if (paramLong == 0L)
      {
        i = 1;
        com.tencent.mm.plugin.finder.report.b.d(j, l, i);
      }
    }
    else
    {
      this.qVF = paramBoolean3;
      this.qVG = false;
      this.qqi = paramFinderItem.isOldVersion();
      if (paramFinderItem.isCommentClose())
      {
        localObject = i.qTa;
        if ((!i.ZR(paramFinderItem.field_username)) || (paramBoolean1)) {
          break label212;
        }
        this.qVG = true;
        this.qVF = false;
      }
      csI();
      if (!fiQ())
      {
        this.quu = paramFinderItem;
        this.qoE = paramLong;
        this.quB = paramBoolean1;
        this.qVH = paramk;
        this.quC = paramBoolean2;
        if (!paramBoolean1) {
          break label261;
        }
        paramBoolean2 = false;
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      super.aX(paramBoolean2, paramBoolean1);
      AppMethodBeat.o(200061);
      return;
      i = 2;
      break;
      label212:
      paramFinderItem = new f.a(aj.getContext());
      paramFinderItem.aMo(getContext().getString(2131759215)).wZ(true);
      paramFinderItem.b((f.c)FinderCommentDrawer.c.LeH).show();
      AppMethodBeat.o(200061);
      return;
      label261:
      paramBoolean2 = true;
      if (paramLong == 0L) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
    }
  }
  
  final void csI()
  {
    AppMethodBeat.i(178471);
    if (this.qVE)
    {
      this.qVD = this.scene;
      ad.i("Finder.CommentDrawer", "refreshSceneForReply isSelfProfile " + this.scene);
    }
    for (;;)
    {
      Object localObject = this.qVI;
      if (localObject != null) {
        ((FinderCommentFooter)localObject).setScene(this.qVD);
      }
      localObject = this.qVI;
      if (localObject == null) {
        break;
      }
      ((FinderCommentFooter)localObject).csL();
      AppMethodBeat.o(178471);
      return;
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      this.qVD = com.tencent.mm.plugin.finder.storage.b.fUn();
    }
    AppMethodBeat.o(178471);
  }
  
  public final void csJ()
  {
    AppMethodBeat.i(168251);
    if (fiQ())
    {
      Object localObject;
      int i;
      if (this.quB)
      {
        super.xl(false);
        localObject = getHeaderLayout().findViewById(2131299982);
        d.g.b.k.g(localObject, "headerErrTipLayout");
        ((View)localObject).setVisibility(8);
        localObject = FinderReporterUIC.Ljl;
        localObject = getContext();
        d.g.b.k.g(localObject, "context");
        localObject = FinderReporterUIC.a.lB((Context)localObject);
        if (localObject == null) {
          break label136;
        }
        com.tencent.mm.plugin.finder.report.b localb = com.tencent.mm.plugin.finder.report.b.qFq;
        i = ((FinderReporterUIC)localObject).qqE;
        localObject = this.quu;
        if (localObject == null) {
          break label131;
        }
      }
      label131:
      for (long l = ((FinderItem)localObject).getId();; l = 0L)
      {
        com.tencent.mm.plugin.finder.report.b.d(i, l, 3);
        AppMethodBeat.o(168251);
        return;
        super.xl(true);
        break;
      }
    }
    label136:
    AppMethodBeat.o(168251);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168247);
    d.g.b.k.h(paramMotionEvent, "event");
    View localView;
    if (this.quB)
    {
      localView = getFooterLayout().findViewById(2131298514);
      this.rect.setEmpty();
      localView.getGlobalVisibleRect(this.rect);
      if (this.rect.top > paramMotionEvent.getY())
      {
        if ((paramMotionEvent.getAction() != 2) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
          break label139;
        }
        csJ();
      }
    }
    boolean bool;
    for (;;)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      if ((!this.HYR) || (paramMotionEvent.getAction() != 0)) {
        break label334;
      }
      paramMotionEvent = getContext();
      if (paramMotionEvent != null) {
        break;
      }
      paramMotionEvent = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(168247);
      throw paramMotionEvent;
      label139:
      if (paramMotionEvent.getAction() == 0)
      {
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(168247);
        return true;
        localView = getHeaderLayout().findViewById(2131299982);
        this.rect.setEmpty();
        localView.getGlobalVisibleRect(this.rect);
        ad.d("Finder.CommentDrawer", "event.action " + paramMotionEvent.getActionMasked() + " event.y " + paramMotionEvent.getY() + ", " + this.rect.top + ", " + this.rect.bottom);
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
          d.g.b.k.g(localView, "headerErrTipLayout");
          localView.setPressed(false);
        }
      }
    }
    ((MMActivity)paramMotionEvent).hideVKB();
    label334:
    AppMethodBeat.o(168247);
    return bool;
  }
  
  public final void fWI()
  {
    AppMethodBeat.i(200063);
    Object localObject = this.LeF;
    if (localObject != null)
    {
      localObject = (Boolean)((d.g.a.a)localObject).invoke();
      if (localObject == null) {}
    }
    for (boolean bool = ((Boolean)localObject).booleanValue(); bool; bool = false)
    {
      AppMethodBeat.o(200063);
      return;
    }
    csJ();
    AppMethodBeat.o(200063);
  }
  
  public final boolean getBlinkRefComment()
  {
    return this.quC;
  }
  
  public final boolean getCloseComment()
  {
    return this.qVG;
  }
  
  public final FinderItem getFeedObj()
  {
    return this.quu;
  }
  
  public final FinderCommentFooter getFooter()
  {
    return this.qVI;
  }
  
  public final d.g.a.a<Boolean> getInterceptClose()
  {
    return this.LeF;
  }
  
  public final boolean getOldVersion()
  {
    return this.qqi;
  }
  
  public final CommentDrawerContract.CloseDrawerCallback getOnCloseDrawerCallback()
  {
    return this.qux;
  }
  
  public final long getRefCommentId()
  {
    return this.qoE;
  }
  
  public final com.tencent.mm.plugin.finder.storage.k getReplyCommentObj()
  {
    return this.qVH;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSceneForReply()
  {
    return this.qVD;
  }
  
  public final boolean getShowFooter()
  {
    return this.qVF;
  }
  
  public final boolean getUseCache()
  {
    return this.dCJ;
  }
  
  public final void setBlinkRefComment(boolean paramBoolean)
  {
    this.quC = paramBoolean;
  }
  
  public final void setCloseComment(boolean paramBoolean)
  {
    this.qVG = paramBoolean;
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.quu = paramFinderItem;
  }
  
  public final void setFooter(FinderCommentFooter paramFinderCommentFooter)
  {
    this.qVI = paramFinderCommentFooter;
  }
  
  public final void setInterceptClose(d.g.a.a<Boolean> parama)
  {
    this.LeF = parama;
  }
  
  public final void setOldVersion(boolean paramBoolean)
  {
    this.qqi = paramBoolean;
  }
  
  public final void setOnCloseDrawerCallback(CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    this.qux = paramCloseDrawerCallback;
  }
  
  public final void setRefCommentId(long paramLong)
  {
    this.qoE = paramLong;
  }
  
  public final void setReplyCommentObj(com.tencent.mm.plugin.finder.storage.k paramk)
  {
    this.qVH = paramk;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSceneForReply(int paramInt)
  {
    this.qVD = paramInt;
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.qVE = paramBoolean;
  }
  
  public final void setShowFooter(boolean paramBoolean)
  {
    this.qVF = paramBoolean;
  }
  
  public final void setSingleMode(boolean paramBoolean)
  {
    this.quB = paramBoolean;
  }
  
  public final void setUseCache(boolean paramBoolean)
  {
    this.dCJ = paramBoolean;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "", "onBuildDrawerBody", "", "context", "Landroid/content/Context;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onBuildDrawerFooter", "footerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "onBuildDrawerHeader", "headerLayout", "onBuildLoading", "loadingLayout", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "displayScene", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
    
    public abstract void a(Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout);
    
    public abstract void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt);
    
    public abstract void b(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
    
    public abstract void c(Context paramContext, FrameLayout paramFrameLayout);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Companion;", "", "()V", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "context", "Lcom/tencent/mm/ui/MMActivity;", "parent", "Landroid/view/View;", "scene", "", "builder", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "safeMode", "", "fullScreen", "plugin-finder_release"})
  public static final class b
  {
    public static FinderCommentDrawer a(MMActivity paramMMActivity, final View paramView, int paramInt, final FinderCommentDrawer.a parama, boolean paramBoolean1, final boolean paramBoolean2)
    {
      AppMethodBeat.i(200058);
      d.g.b.k.h(paramMMActivity, "context");
      d.g.b.k.h(paramView, "parent");
      d.g.b.k.h(parama, "builder");
      ad.i("Finder.CommentDrawer", "createDrawerToAttachWindow scene:" + paramInt + ", safeMode:" + paramBoolean1);
      final FinderCommentDrawer localFinderCommentDrawer = new FinderCommentDrawer((Context)paramMMActivity);
      if (paramBoolean2)
      {
        localFinderCommentDrawer.setTopOffset(ai.jl((Context)paramMMActivity));
        localFinderCommentDrawer.setBackgroundColorRes(2131101053);
      }
      parama.a((RecyclerViewDrawer)localFinderCommentDrawer, paramInt);
      CommentDrawerContract.NPresenter localNPresenter = ((com.tencent.mm.plugin.finder.view.builder.a)parama).qqh;
      if (localNPresenter == null)
      {
        paramMMActivity = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderCommentDrawerPresenter");
        AppMethodBeat.o(200058);
        throw paramMMActivity;
      }
      ((com.tencent.mm.plugin.finder.feed.b)localNPresenter).qqF = paramBoolean1;
      paramView.post((Runnable)new a(paramMMActivity, new FrameLayout.LayoutParams(-1, -1), paramView, localFinderCommentDrawer, parama, paramBoolean2));
      AppMethodBeat.o(200058);
      return localFinderCommentDrawer;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MMActivity paramMMActivity, FrameLayout.LayoutParams paramLayoutParams, View paramView, FinderCommentDrawer paramFinderCommentDrawer, FinderCommentDrawer.a parama, boolean paramBoolean) {}
      
      public final void run()
      {
        AppMethodBeat.i(168243);
        int i = ap.jv((Context)this.qSd);
        this.qVK.bottomMargin = i;
        ad.i("Finder.CommentDrawer", "[initView] bottomMargin= ".concat(String.valueOf(i)));
        Object localObject = paramView;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(168243);
          throw ((Throwable)localObject);
        }
        ((FrameLayout)localObject).addView((View)localFinderCommentDrawer, (ViewGroup.LayoutParams)this.qVK);
        parama.a((Context)this.qSd, localFinderCommentDrawer.getHeaderLayout(), paramBoolean2);
        parama.a((Context)this.qSd, localFinderCommentDrawer.getCenterLayout());
        parama.b((Context)this.qSd, localFinderCommentDrawer.getFooterLayout(), paramBoolean2);
        parama.c((Context)this.qSd, localFinderCommentDrawer.getLoadingLayout());
        AppMethodBeat.o(168243);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentDrawer
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "blinkRefComment", "", "getBlinkRefComment", "()Z", "setBlinkRefComment", "(Z)V", "closeComment", "getCloseComment", "setCloseComment", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "interceptClose", "Lkotlin/Function0;", "getInterceptClose", "()Lkotlin/jvm/functions/Function0;", "setInterceptClose", "(Lkotlin/jvm/functions/Function0;)V", "isSelfProfile", "setSelfProfile", "isSingleMode", "setSingleMode", "oldVersion", "getOldVersion", "setOldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "getOnCloseDrawerCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "setOnCloseDrawerCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "rect", "Landroid/graphics/Rect;", "refCommentId", "", "getRefCommentId", "()J", "setRefCommentId", "(J)V", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setReplyCommentObj", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "scene", "getScene", "()I", "setScene", "(I)V", "sceneForReply", "getSceneForReply", "setSceneForReply", "showFooter", "getShowFooter", "setShowFooter", "useCache", "getUseCache", "setUseCache", "closeDrawer", "", "closeDrawerWhenError", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onUIPause", "onUIResume", "openDrawer", "fullScreen", "refreshSceneForReply", "switchScene", "Builder", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawer
  extends RecyclerViewDrawer
{
  public static final b rVZ;
  private boolean dAv;
  private long qXy;
  private boolean qZP;
  private boolean rVS;
  private t rVT;
  public int rVU;
  public boolean rVV;
  private boolean rVW;
  public FinderCommentFooter rVX;
  private a<Boolean> rVY;
  private final Rect rect;
  public boolean rgD;
  private boolean rgE;
  public FinderItem rgw;
  private CommentDrawerContract.CloseDrawerCallback rgz;
  private int scene;
  
  static
  {
    AppMethodBeat.i(168255);
    rVZ = new b((byte)0);
    AppMethodBeat.o(168255);
  }
  
  public FinderCommentDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168252);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = com.tencent.mm.plugin.finder.storage.b.rCU;
    this.rVU = com.tencent.mm.plugin.finder.storage.b.czC();
    this.dAv = true;
    this.rVS = true;
    this.qZP = true;
    AppMethodBeat.o(168252);
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168253);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = com.tencent.mm.plugin.finder.storage.b.rCU;
    this.rVU = com.tencent.mm.plugin.finder.storage.b.czC();
    this.dAv = true;
    this.rVS = true;
    this.qZP = true;
    AppMethodBeat.o(168253);
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168254);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = com.tencent.mm.plugin.finder.storage.b.rCU;
    this.rVU = com.tencent.mm.plugin.finder.storage.b.czC();
    this.dAv = true;
    this.rVS = true;
    this.qZP = true;
    AppMethodBeat.o(168254);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, t paramt)
  {
    AppMethodBeat.i(204132);
    k.h(paramFinderItem, "feedObj");
    e.wTc.idkeyStat(1278L, 6L, 1L, false);
    Object localObject = FinderReporterUIC.seQ;
    localObject = getContext();
    k.g(localObject, "context");
    localObject = FinderReporterUIC.a.eV((Context)localObject);
    int i;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.report.d locald = com.tencent.mm.plugin.finder.report.d.rxr;
      int j = ((FinderReporterUIC)localObject).rfR;
      long l = paramFinderItem.getId();
      if (paramLong == 0L)
      {
        i = 1;
        com.tencent.mm.plugin.finder.report.d.a(j, l, i);
      }
    }
    else
    {
      this.rVS = paramBoolean3;
      this.rVW = false;
      this.qZP = paramFinderItem.isOldVersion();
      if (paramFinderItem.isCommentClose())
      {
        localObject = n.rPN;
        if ((!n.aeD(paramFinderItem.field_username)) || (paramBoolean1)) {
          break label212;
        }
        this.rVW = true;
        this.rVS = false;
      }
      cEJ();
      if (!cEG())
      {
        this.rgw = paramFinderItem;
        this.qXy = paramLong;
        this.rgD = paramBoolean1;
        this.rVT = paramt;
        this.rgE = paramBoolean2;
        if (!paramBoolean1) {
          break label261;
        }
        paramBoolean2 = false;
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      super.aR(paramBoolean2, paramBoolean1);
      AppMethodBeat.o(204132);
      return;
      i = 2;
      break;
      label212:
      paramFinderItem = new f.a(ai.getContext());
      paramFinderItem.aRQ(getContext().getString(2131759215)).yi(true);
      paramFinderItem.b((f.c)FinderCommentDrawer.c.rWg).show();
      AppMethodBeat.o(204132);
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
  
  public final void cEF()
  {
    AppMethodBeat.i(168251);
    if (cEG())
    {
      Object localObject;
      int i;
      if (this.rgD)
      {
        super.yv(false);
        localObject = getHeaderLayout().findViewById(2131299982);
        k.g(localObject, "headerErrTipLayout");
        ((View)localObject).setVisibility(8);
        localObject = FinderReporterUIC.seQ;
        localObject = getContext();
        k.g(localObject, "context");
        localObject = FinderReporterUIC.a.eV((Context)localObject);
        if (localObject == null) {
          break label136;
        }
        com.tencent.mm.plugin.finder.report.d locald = com.tencent.mm.plugin.finder.report.d.rxr;
        i = ((FinderReporterUIC)localObject).rfR;
        localObject = this.rgw;
        if (localObject == null) {
          break label131;
        }
      }
      label131:
      for (long l = ((FinderItem)localObject).getId();; l = 0L)
      {
        com.tencent.mm.plugin.finder.report.d.a(i, l, 3);
        AppMethodBeat.o(168251);
        return;
        super.yv(true);
        break;
      }
    }
    label136:
    AppMethodBeat.o(168251);
  }
  
  final void cEJ()
  {
    AppMethodBeat.i(178471);
    if (this.rVV)
    {
      this.rVU = this.scene;
      ac.i("Finder.CommentDrawer", "refreshSceneForReply isSelfProfile " + this.scene);
    }
    for (;;)
    {
      Object localObject = this.rVX;
      if (localObject != null) {
        ((FinderCommentFooter)localObject).setScene(this.rVU);
      }
      localObject = this.rVX;
      if (localObject == null) {
        break;
      }
      ((FinderCommentFooter)localObject).cEM();
      AppMethodBeat.o(178471);
      return;
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      this.rVU = com.tencent.mm.plugin.finder.storage.b.czC();
    }
    AppMethodBeat.o(178471);
  }
  
  public final void cEK()
  {
    AppMethodBeat.i(204134);
    Object localObject = this.rVY;
    if (localObject != null)
    {
      localObject = (Boolean)((a)localObject).invoke();
      if (localObject == null) {}
    }
    for (boolean bool = ((Boolean)localObject).booleanValue(); bool; bool = false)
    {
      AppMethodBeat.o(204134);
      return;
    }
    cEF();
    AppMethodBeat.o(204134);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168247);
    k.h(paramMotionEvent, "event");
    View localView;
    if (this.rgD)
    {
      localView = getFooterLayout().findViewById(2131298514);
      this.rect.setEmpty();
      localView.getGlobalVisibleRect(this.rect);
      if (this.rect.top > paramMotionEvent.getY())
      {
        if ((paramMotionEvent.getAction() != 2) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
          break label139;
        }
        cEF();
      }
    }
    boolean bool;
    for (;;)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      if ((!this.JzF) || (paramMotionEvent.getAction() != 0)) {
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
        ac.d("Finder.CommentDrawer", "event.action " + paramMotionEvent.getActionMasked() + " event.y " + paramMotionEvent.getY() + ", " + this.rect.top + ", " + this.rect.bottom);
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
          k.g(localView, "headerErrTipLayout");
          localView.setPressed(false);
        }
      }
    }
    ((MMActivity)paramMotionEvent).hideVKB();
    label334:
    AppMethodBeat.o(168247);
    return bool;
  }
  
  public final boolean getBlinkRefComment()
  {
    return this.rgE;
  }
  
  public final boolean getCloseComment()
  {
    return this.rVW;
  }
  
  public final FinderItem getFeedObj()
  {
    return this.rgw;
  }
  
  public final FinderCommentFooter getFooter()
  {
    return this.rVX;
  }
  
  public final a<Boolean> getInterceptClose()
  {
    return this.rVY;
  }
  
  public final boolean getOldVersion()
  {
    return this.qZP;
  }
  
  public final CommentDrawerContract.CloseDrawerCallback getOnCloseDrawerCallback()
  {
    return this.rgz;
  }
  
  public final long getRefCommentId()
  {
    return this.qXy;
  }
  
  public final t getReplyCommentObj()
  {
    return this.rVT;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSceneForReply()
  {
    return this.rVU;
  }
  
  public final boolean getShowFooter()
  {
    return this.rVS;
  }
  
  public final boolean getUseCache()
  {
    return this.dAv;
  }
  
  public final void setBlinkRefComment(boolean paramBoolean)
  {
    this.rgE = paramBoolean;
  }
  
  public final void setCloseComment(boolean paramBoolean)
  {
    this.rVW = paramBoolean;
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.rgw = paramFinderItem;
  }
  
  public final void setFooter(FinderCommentFooter paramFinderCommentFooter)
  {
    this.rVX = paramFinderCommentFooter;
  }
  
  public final void setInterceptClose(a<Boolean> parama)
  {
    this.rVY = parama;
  }
  
  public final void setOldVersion(boolean paramBoolean)
  {
    this.qZP = paramBoolean;
  }
  
  public final void setOnCloseDrawerCallback(CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    this.rgz = paramCloseDrawerCallback;
  }
  
  public final void setRefCommentId(long paramLong)
  {
    this.qXy = paramLong;
  }
  
  public final void setReplyCommentObj(t paramt)
  {
    this.rVT = paramt;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSceneForReply(int paramInt)
  {
    this.rVU = paramInt;
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.rVV = paramBoolean;
  }
  
  public final void setShowFooter(boolean paramBoolean)
  {
    this.rVS = paramBoolean;
  }
  
  public final void setSingleMode(boolean paramBoolean)
  {
    this.rgD = paramBoolean;
  }
  
  public final void setUseCache(boolean paramBoolean)
  {
    this.dAv = paramBoolean;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "", "onBuildDrawerBody", "", "context", "Landroid/content/Context;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onBuildDrawerFooter", "footerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "onBuildDrawerHeader", "headerLayout", "onBuildLoading", "loadingLayout", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "displayScene", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
    
    public abstract void a(Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout);
    
    public abstract void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt);
    
    public abstract void b(Context paramContext, FrameLayout paramFrameLayout);
    
    public abstract void b(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Companion;", "", "()V", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "context", "Lcom/tencent/mm/ui/MMActivity;", "parent", "Landroid/view/View;", "scene", "", "builder", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "safeMode", "", "fullScreen", "plugin-finder_release"})
  public static final class b
  {
    public static FinderCommentDrawer a(MMActivity paramMMActivity, final View paramView, int paramInt, final FinderCommentDrawer.a parama, boolean paramBoolean1, final boolean paramBoolean2)
    {
      AppMethodBeat.i(204129);
      k.h(paramMMActivity, "context");
      k.h(paramView, "parent");
      k.h(parama, "builder");
      ac.i("Finder.CommentDrawer", "createDrawerToAttachWindow scene:" + paramInt + ", safeMode:" + paramBoolean1);
      final FinderCommentDrawer localFinderCommentDrawer = new FinderCommentDrawer((Context)paramMMActivity);
      if (paramBoolean2)
      {
        localFinderCommentDrawer.setTopOffset(aj.jw((Context)paramMMActivity));
        localFinderCommentDrawer.setBackgroundColorRes(2131101053);
      }
      parama.a((RecyclerViewDrawer)localFinderCommentDrawer, paramInt);
      Object localObject = ((com.tencent.mm.plugin.finder.view.builder.b)parama).qZO;
      if (localObject == null)
      {
        paramMMActivity = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderCommentDrawerPresenter");
        AppMethodBeat.o(204129);
        throw paramMMActivity;
      }
      ((com.tencent.mm.plugin.finder.feed.d)localObject).ran = paramBoolean1;
      localObject = new FrameLayout.LayoutParams(-1, -1);
      paramView.addOnLayoutChangeListener((View.OnLayoutChangeListener)FinderCommentDrawer.b.a.rWa);
      paramView.post((Runnable)new b(paramMMActivity, paramView, localFinderCommentDrawer, (FrameLayout.LayoutParams)localObject, parama, paramBoolean2));
      AppMethodBeat.o(204129);
      return localFinderCommentDrawer;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MMActivity paramMMActivity, View paramView, FinderCommentDrawer paramFinderCommentDrawer, FrameLayout.LayoutParams paramLayoutParams, FinderCommentDrawer.a parama, boolean paramBoolean) {}
      
      public final void run()
      {
        AppMethodBeat.i(204128);
        ac.i("Finder.CommentDrawer", "[initView] bottomMargin= ".concat(String.valueOf(ap.jG((Context)this.rOB))));
        Object localObject = paramView;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(204128);
          throw ((Throwable)localObject);
        }
        ((FrameLayout)localObject).addView((View)localFinderCommentDrawer, (ViewGroup.LayoutParams)this.rWd);
        parama.a((Context)this.rOB, localFinderCommentDrawer.getHeaderLayout(), paramBoolean2);
        parama.a((Context)this.rOB, localFinderCommentDrawer.getCenterLayout());
        parama.b((Context)this.rOB, localFinderCommentDrawer.getFooterLayout(), paramBoolean2);
        parama.b((Context)this.rOB, localFinderCommentDrawer.getLoadingLayout());
        AppMethodBeat.o(204128);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentDrawer
 * JD-Core Version:    0.7.0.1
 */
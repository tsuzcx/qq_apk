package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.e;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "banSwitch", "", "getBanSwitch", "()Z", "setBanSwitch", "(Z)V", "blinkRefComment", "getBlinkRefComment", "setBlinkRefComment", "closeComment", "getCloseComment", "setCloseComment", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "interceptClose", "Lkotlin/Function0;", "getInterceptClose", "()Lkotlin/jvm/functions/Function0;", "setInterceptClose", "(Lkotlin/jvm/functions/Function0;)V", "isSelfProfile", "setSelfProfile", "isSingleMode", "setSingleMode", "oldVersion", "getOldVersion", "setOldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "getOnCloseDrawerCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "setOnCloseDrawerCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "reason", "getReason", "()I", "setReason", "(I)V", "rect", "Landroid/graphics/Rect;", "refCommentId", "", "getRefCommentId", "()J", "setRefCommentId", "(J)V", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setReplyCommentObj", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "scene", "getScene", "setScene", "sceneForReply", "getSceneForReply", "setSceneForReply", "showFooter", "getShowFooter", "setShowFooter", "useCache", "getUseCache", "setUseCache", "closeDrawer", "", "closeDrawerWhenError", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onUIPause", "onUIResume", "openDrawer", "fullScreen", "refreshSceneForReply", "switchScene", "Builder", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawer
  extends RecyclerViewDrawer
{
  public static final b sSJ;
  private boolean dMI;
  private long rIH;
  private boolean rMe;
  private CommentDrawerContract.CloseDrawerCallback rUG;
  public boolean rUK;
  private boolean rUL;
  public FinderItem rUg;
  private int reason;
  private final Rect rect;
  private boolean sSB;
  private ab sSC;
  public int sSD;
  public boolean sSE;
  private boolean sSF;
  public FinderCommentFooter sSG;
  private boolean sSH;
  private a<Boolean> sSI;
  private int scene;
  
  static
  {
    AppMethodBeat.i(168255);
    sSJ = new b((byte)0);
    AppMethodBeat.o(168255);
  }
  
  public FinderCommentDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168252);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sSD = com.tencent.mm.plugin.finder.storage.b.cGl();
    this.dMI = true;
    this.sSB = true;
    this.rMe = true;
    AppMethodBeat.o(168252);
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168253);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sSD = com.tencent.mm.plugin.finder.storage.b.cGl();
    this.dMI = true;
    this.sSB = true;
    this.rMe = true;
    AppMethodBeat.o(168253);
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168254);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sSD = com.tencent.mm.plugin.finder.storage.b.cGl();
    this.dMI = true;
    this.sSB = true;
    this.rMe = true;
    AppMethodBeat.o(168254);
  }
  
  public final void cMY()
  {
    AppMethodBeat.i(168251);
    if (cMZ())
    {
      Object localObject;
      int i;
      if (this.rUK)
      {
        super.zi(false);
        localObject = getHeaderLayout().findViewById(2131299982);
        p.g(localObject, "headerErrTipLayout");
        ((View)localObject).setVisibility(8);
        localObject = FinderReporterUIC.tcM;
        localObject = getContext();
        p.g(localObject, "context");
        localObject = FinderReporterUIC.a.eY((Context)localObject);
        if (localObject == null) {
          break label136;
        }
        h localh = h.soM;
        i = ((FinderReporterUIC)localObject).rTD;
        localObject = this.rUg;
        if (localObject == null) {
          break label131;
        }
      }
      label131:
      for (long l = ((FinderItem)localObject).getId();; l = 0L)
      {
        h.a(i, l, 3);
        AppMethodBeat.o(168251);
        return;
        super.zi(true);
        break;
      }
    }
    label136:
    AppMethodBeat.o(168251);
  }
  
  final void cNc()
  {
    AppMethodBeat.i(178471);
    if (this.sSE)
    {
      this.sSD = this.scene;
      ad.i("Finder.CommentDrawer", "refreshSceneForReply isSelfProfile " + this.scene);
    }
    for (;;)
    {
      Object localObject = this.sSG;
      if (localObject != null) {
        ((FinderCommentFooter)localObject).setScene(this.sSD);
      }
      localObject = this.sSG;
      if (localObject == null) {
        break;
      }
      ((FinderCommentFooter)localObject).cNf();
      AppMethodBeat.o(178471);
      return;
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      this.sSD = com.tencent.mm.plugin.finder.storage.b.cGl();
    }
    AppMethodBeat.o(178471);
  }
  
  public final void cNd()
  {
    AppMethodBeat.i(205092);
    Object localObject = this.sSI;
    if (localObject != null)
    {
      localObject = (Boolean)((a)localObject).invoke();
      if (localObject == null) {}
    }
    for (boolean bool = ((Boolean)localObject).booleanValue(); bool; bool = false)
    {
      AppMethodBeat.o(205092);
      return;
    }
    cMY();
    AppMethodBeat.o(205092);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168247);
    p.h(paramMotionEvent, "event");
    View localView;
    if (this.rUK)
    {
      localView = getFooterLayout().findViewById(2131298514);
      this.rect.setEmpty();
      localView.getGlobalVisibleRect(this.rect);
      if (this.rect.top > paramMotionEvent.getY())
      {
        if ((paramMotionEvent.getAction() != 2) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
          break label139;
        }
        cMY();
      }
    }
    boolean bool;
    for (;;)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      if ((!this.LsM) || (paramMotionEvent.getAction() != 0)) {
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
          p.g(localView, "headerErrTipLayout");
          localView.setPressed(false);
        }
      }
    }
    ((MMActivity)paramMotionEvent).hideVKB();
    label334:
    AppMethodBeat.o(168247);
    return bool;
  }
  
  public final boolean getBanSwitch()
  {
    return this.sSH;
  }
  
  public final boolean getBlinkRefComment()
  {
    return this.rUL;
  }
  
  public final boolean getCloseComment()
  {
    return this.sSF;
  }
  
  public final FinderItem getFeedObj()
  {
    return this.rUg;
  }
  
  public final FinderCommentFooter getFooter()
  {
    return this.sSG;
  }
  
  public final a<Boolean> getInterceptClose()
  {
    return this.sSI;
  }
  
  public final boolean getOldVersion()
  {
    return this.rMe;
  }
  
  public final CommentDrawerContract.CloseDrawerCallback getOnCloseDrawerCallback()
  {
    return this.rUG;
  }
  
  public final int getReason()
  {
    return this.reason;
  }
  
  public final long getRefCommentId()
  {
    return this.rIH;
  }
  
  public final ab getReplyCommentObj()
  {
    return this.sSC;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSceneForReply()
  {
    return this.sSD;
  }
  
  public final boolean getShowFooter()
  {
    return this.sSB;
  }
  
  public final boolean getUseCache()
  {
    return this.dMI;
  }
  
  public final void setBanSwitch(boolean paramBoolean)
  {
    this.sSH = paramBoolean;
  }
  
  public final void setBlinkRefComment(boolean paramBoolean)
  {
    this.rUL = paramBoolean;
  }
  
  public final void setCloseComment(boolean paramBoolean)
  {
    this.sSF = paramBoolean;
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.rUg = paramFinderItem;
  }
  
  public final void setFooter(FinderCommentFooter paramFinderCommentFooter)
  {
    this.sSG = paramFinderCommentFooter;
  }
  
  public final void setInterceptClose(a<Boolean> parama)
  {
    this.sSI = parama;
  }
  
  public final void setOldVersion(boolean paramBoolean)
  {
    this.rMe = paramBoolean;
  }
  
  public final void setOnCloseDrawerCallback(CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    this.rUG = paramCloseDrawerCallback;
  }
  
  public final void setReason(int paramInt)
  {
    this.reason = paramInt;
  }
  
  public final void setRefCommentId(long paramLong)
  {
    this.rIH = paramLong;
  }
  
  public final void setReplyCommentObj(ab paramab)
  {
    this.sSC = paramab;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSceneForReply(int paramInt)
  {
    this.sSD = paramInt;
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.sSE = paramBoolean;
  }
  
  public final void setShowFooter(boolean paramBoolean)
  {
    this.sSB = paramBoolean;
  }
  
  public final void setSingleMode(boolean paramBoolean)
  {
    this.rUK = paramBoolean;
  }
  
  public final void setUseCache(boolean paramBoolean)
  {
    this.dMI = paramBoolean;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "", "onBuildDrawerBody", "", "context", "Landroid/content/Context;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onBuildDrawerFooter", "footerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "onBuildDrawerHeader", "headerLayout", "onBuildLoading", "loadingLayout", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "displayScene", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
    
    public abstract void a(Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout);
    
    public abstract void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt);
    
    public abstract void b(Context paramContext, FrameLayout paramFrameLayout);
    
    public abstract void b(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Companion;", "", "()V", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "context", "Lcom/tencent/mm/ui/MMActivity;", "parent", "Landroid/view/View;", "scene", "", "builder", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "safeMode", "", "fullScreen", "plugin-finder_release"})
  public static final class b
  {
    public static FinderCommentDrawer a(MMActivity paramMMActivity, final View paramView, int paramInt, final FinderCommentDrawer.a parama, boolean paramBoolean1, final boolean paramBoolean2)
    {
      AppMethodBeat.i(205088);
      p.h(paramMMActivity, "context");
      p.h(paramView, "parent");
      p.h(parama, "builder");
      ad.i("Finder.CommentDrawer", "createDrawerToAttachWindow scene:" + paramInt + ", safeMode:" + paramBoolean1);
      final FinderCommentDrawer localFinderCommentDrawer = new FinderCommentDrawer((Context)paramMMActivity);
      if (paramBoolean2)
      {
        localFinderCommentDrawer.setTopOffset(al.jH((Context)paramMMActivity));
        localFinderCommentDrawer.setBackgroundColorRes(2131101053);
      }
      Object localObject = paramMMActivity.getResources();
      p.g(localObject, "context.resources");
      localFinderCommentDrawer.setTopOffset((int)(((Resources)localObject).getDisplayMetrics().heightPixels * 0.2D));
      parama.a((RecyclerViewDrawer)localFinderCommentDrawer, paramInt);
      localObject = ((com.tencent.mm.plugin.finder.view.builder.b)parama).rMd;
      if (localObject == null)
      {
        paramMMActivity = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderCommentDrawerPresenter");
        AppMethodBeat.o(205088);
        throw paramMMActivity;
      }
      ((e)localObject).rMJ = paramBoolean1;
      localObject = new FrameLayout.LayoutParams(-1, -1);
      paramView.addOnLayoutChangeListener((View.OnLayoutChangeListener)a.sSK);
      paramView.post((Runnable)new b(paramMMActivity, paramView, localFinderCommentDrawer, (FrameLayout.LayoutParams)localObject, parama, paramBoolean2));
      AppMethodBeat.o(205088);
      return localFinderCommentDrawer;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
    static final class a
      implements View.OnLayoutChangeListener
    {
      public static final a sSK;
      
      static
      {
        AppMethodBeat.i(205086);
        sSK = new a();
        AppMethodBeat.o(205086);
      }
      
      public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
      {
        AppMethodBeat.i(205085);
        ad.i("Finder.CommentDrawer", "[OnLayoutChange] bottom=" + paramInt4 + " oldBottom=" + paramInt8);
        AppMethodBeat.o(205085);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MMActivity paramMMActivity, View paramView, FinderCommentDrawer paramFinderCommentDrawer, FrameLayout.LayoutParams paramLayoutParams, FinderCommentDrawer.a parama, boolean paramBoolean) {}
      
      public final void run()
      {
        AppMethodBeat.i(205087);
        ad.i("Finder.CommentDrawer", "[initView] bottomMargin= ".concat(String.valueOf(ar.jS((Context)this.sav))));
        Object localObject = paramView;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(205087);
          throw ((Throwable)localObject);
        }
        ((FrameLayout)localObject).addView((View)localFinderCommentDrawer, (ViewGroup.LayoutParams)this.sSN);
        parama.a((Context)this.sav, localFinderCommentDrawer.getHeaderLayout(), paramBoolean2);
        parama.a((Context)this.sav, localFinderCommentDrawer.getCenterLayout());
        parama.b((Context)this.sav, localFinderCommentDrawer.getFooterLayout(), paramBoolean2);
        parama.b((Context)this.sav, localFinderCommentDrawer.getLoadingLayout());
        AppMethodBeat.o(205087);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentDrawer
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.f;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.plugin.finder.view.builder.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "banSwitch", "", "getBanSwitch", "()Z", "setBanSwitch", "(Z)V", "blinkDuration", "", "getBlinkDuration", "()J", "setBlinkDuration", "(J)V", "blinkRefComment", "getBlinkRefComment", "setBlinkRefComment", "closeComment", "getCloseComment", "setCloseComment", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "interceptClose", "Lkotlin/Function0;", "getInterceptClose", "()Lkotlin/jvm/functions/Function0;", "setInterceptClose", "(Lkotlin/jvm/functions/Function0;)V", "isOnlyShowDesc", "setOnlyShowDesc", "isSelfProfile", "setSelfProfile", "isSingleMode", "setSingleMode", "oldVersion", "getOldVersion", "setOldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "getOnCloseDrawerCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "setOnCloseDrawerCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "reason", "getReason", "()I", "setReason", "(I)V", "rect", "Landroid/graphics/Rect;", "refCommentId", "getRefCommentId", "setRefCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "setReplyCommentObj", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "scene", "getScene", "setScene", "sceneForReply", "getSceneForReply", "setSceneForReply", "showFooter", "getShowFooter", "setShowFooter", "useCache", "getUseCache", "setUseCache", "closeDrawer", "", "closeDrawerWhenError", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onUIPause", "onUIResume", "openDrawer", "fullScreen", "refreshSceneForReply", "needFocus", "switchScene", "Builder", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderCommentDrawer
  extends RecyclerViewDrawer
{
  public static final b GxJ;
  private long AAW;
  private boolean AHL;
  public boolean AHQ;
  public FinderItem AUj;
  private CommentDrawerContract.CloseDrawerCallback AUm;
  private boolean AUq;
  private long AUr;
  public boolean EAO;
  private boolean FYI;
  public int FYL;
  private boolean FYM;
  private boolean FYO;
  public a<Boolean> FYP;
  private au GxI;
  public FinderCommentFooter GxK;
  private boolean igs;
  public boolean plm;
  private int reason;
  private final Rect rect;
  private int scene;
  
  static
  {
    AppMethodBeat.i(168255);
    GxJ = new b((byte)0);
    AppMethodBeat.o(168255);
  }
  
  public FinderCommentDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168252);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = d.FAy;
    this.FYL = d.eRx();
    if (!((bw)h.ax(bw.class)).aBu()) {}
    for (boolean bool = true;; bool = false)
    {
      this.igs = bool;
      this.FYI = true;
      this.AHL = true;
      this.AUr = 1000L;
      AppMethodBeat.o(168252);
      return;
    }
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168253);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = d.FAy;
    this.FYL = d.eRx();
    if (!((bw)h.ax(bw.class)).aBu()) {}
    for (boolean bool = true;; bool = false)
    {
      this.igs = bool;
      this.FYI = true;
      this.AHL = true;
      this.AUr = 1000L;
      AppMethodBeat.o(168253);
      return;
    }
  }
  
  public FinderCommentDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168254);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = d.FAy;
    this.FYL = d.eRx();
    if (!((bw)h.ax(bw.class)).aBu()) {}
    for (boolean bool = true;; bool = false)
    {
      this.igs = bool;
      this.FYI = true;
      this.AHL = true;
      this.AUr = 1000L;
      AppMethodBeat.o(168254);
      return;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168247);
    s.u(paramMotionEvent, "event");
    View localView;
    if (this.plm)
    {
      localView = getFooterLayout().findViewById(e.e.comment_et_layout);
      this.rect.setEmpty();
      localView.getGlobalVisibleRect(this.rect);
      if (this.rect.top > paramMotionEvent.getY())
      {
        if ((paramMotionEvent.getAction() != 2) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
          break label139;
        }
        fdh();
      }
    }
    boolean bool;
    for (;;)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      if ((!jMS()) || (paramMotionEvent.getAction() != 0)) {
        break label327;
      }
      paramMotionEvent = getContext();
      if (paramMotionEvent != null) {
        break;
      }
      paramMotionEvent = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(168247);
      throw paramMotionEvent;
      label139:
      if (paramMotionEvent.getAction() == 0)
      {
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(168247);
        return true;
        localView = getHeaderLayout().findViewById(e.e.finder_comment_error_tip);
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
        else {
          localView.setPressed(false);
        }
      }
    }
    ((MMFragmentActivity)paramMotionEvent).hideVKB();
    label327:
    AppMethodBeat.o(168247);
    return bool;
  }
  
  public final void fdh()
  {
    AppMethodBeat.i(168251);
    Object localObject1;
    Object localObject2;
    int i;
    FinderItem localFinderItem;
    if (fkp())
    {
      if (!this.plm) {
        break label125;
      }
      super.Ob(false);
      getHeaderLayout().findViewById(e.e.finder_comment_error_tip).setVisibility(8);
      localObject1 = as.GSQ;
      localObject1 = getContext();
      s.s(localObject1, "context");
      localObject2 = as.a.hu((Context)localObject1);
      if (localObject2 != null)
      {
        localObject1 = z.FrZ;
        i = ((as)localObject2).AJo;
        localObject1 = ((as)localObject2).zIO;
        localObject2 = ((as)localObject2).zIB;
        localFinderItem = getFeedObj();
        if (localFinderItem != null) {
          break label133;
        }
      }
    }
    label133:
    for (long l = 0L;; l = localFinderItem.getId())
    {
      z.a(i, (String)localObject1, (String)localObject2, l, 3);
      AppMethodBeat.o(168251);
      return;
      label125:
      super.Ob(true);
      break;
    }
  }
  
  public final boolean getBanSwitch()
  {
    return this.FYO;
  }
  
  public final long getBlinkDuration()
  {
    return this.AUr;
  }
  
  public final boolean getBlinkRefComment()
  {
    return this.AUq;
  }
  
  public final boolean getCloseComment()
  {
    return this.FYM;
  }
  
  public final FinderItem getFeedObj()
  {
    return this.AUj;
  }
  
  public final FinderCommentFooter getFooter()
  {
    return this.GxK;
  }
  
  public final a<Boolean> getInterceptClose()
  {
    return this.FYP;
  }
  
  public final boolean getOldVersion()
  {
    return this.AHL;
  }
  
  public final CommentDrawerContract.CloseDrawerCallback getOnCloseDrawerCallback()
  {
    return this.AUm;
  }
  
  public final int getReason()
  {
    return this.reason;
  }
  
  public final long getRefCommentId()
  {
    return this.AAW;
  }
  
  public final au getReplyCommentObj()
  {
    return this.GxI;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final int getSceneForReply()
  {
    return this.FYL;
  }
  
  public final boolean getShowFooter()
  {
    return this.FYI;
  }
  
  public final boolean getUseCache()
  {
    return this.igs;
  }
  
  public final void setBanSwitch(boolean paramBoolean)
  {
    this.FYO = paramBoolean;
  }
  
  public final void setBlinkDuration(long paramLong)
  {
    this.AUr = paramLong;
  }
  
  public final void setBlinkRefComment(boolean paramBoolean)
  {
    this.AUq = paramBoolean;
  }
  
  public final void setCloseComment(boolean paramBoolean)
  {
    this.FYM = paramBoolean;
  }
  
  public final void setFeedObj(FinderItem paramFinderItem)
  {
    this.AUj = paramFinderItem;
  }
  
  public final void setFooter(FinderCommentFooter paramFinderCommentFooter)
  {
    this.GxK = paramFinderCommentFooter;
  }
  
  public final void setInterceptClose(a<Boolean> parama)
  {
    this.FYP = parama;
  }
  
  public final void setOldVersion(boolean paramBoolean)
  {
    this.AHL = paramBoolean;
  }
  
  public final void setOnCloseDrawerCallback(CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    this.AUm = paramCloseDrawerCallback;
  }
  
  public final void setOnlyShowDesc(boolean paramBoolean)
  {
    this.AHQ = paramBoolean;
  }
  
  public final void setReason(int paramInt)
  {
    this.reason = paramInt;
  }
  
  public final void setRefCommentId(long paramLong)
  {
    this.AAW = paramLong;
  }
  
  public final void setReplyCommentObj(au paramau)
  {
    this.GxI = paramau;
  }
  
  public final void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final void setSceneForReply(int paramInt)
  {
    this.FYL = paramInt;
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.EAO = paramBoolean;
  }
  
  public final void setShowFooter(boolean paramBoolean)
  {
    this.FYI = paramBoolean;
  }
  
  public final void setSingleMode(boolean paramBoolean)
  {
    this.plm = paramBoolean;
  }
  
  public final void setUseCache(boolean paramBoolean)
  {
    this.igs = paramBoolean;
  }
  
  final void uU(boolean paramBoolean)
  {
    AppMethodBeat.i(346125);
    if (this.EAO)
    {
      this.FYL = this.scene;
      Log.i("Finder.CommentDrawer", s.X("refreshSceneForReply isSelfProfile ", Integer.valueOf(this.scene)));
    }
    for (;;)
    {
      Object localObject = this.GxK;
      if (localObject != null) {
        ((FinderCommentFooter)localObject).setScene(this.FYL);
      }
      localObject = this.GxK;
      if (localObject != null) {
        ((FinderCommentFooter)localObject).uq(paramBoolean);
      }
      AppMethodBeat.o(346125);
      return;
      localObject = d.FAy;
      this.FYL = d.eRx();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "", "onBuildDrawerBody", "", "context", "Landroid/content/Context;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onBuildDrawerFooter", "footerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "onBuildDrawerHeader", "headerLayout", "onBuildLoading", "loadingLayout", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "displayScene", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
    
    public abstract void a(Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout);
    
    public abstract void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt);
    
    public abstract void b(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
    
    public abstract void c(Context paramContext, FrameLayout paramFrameLayout);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Companion;", "", "()V", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "parent", "Landroid/view/View;", "scene", "", "builder", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "safeMode", "", "fullScreen", "exposeScene", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private static FinderCommentDrawer a(MMFragmentActivity paramMMFragmentActivity, View paramView, int paramInt1, FinderCommentDrawer.a parama, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
    {
      AppMethodBeat.i(344591);
      s.u(paramMMFragmentActivity, "context");
      s.u(paramView, "parent");
      s.u(parama, "builder");
      FinderCommentDrawer localFinderCommentDrawer = new FinderCommentDrawer((Context)paramMMFragmentActivity);
      if (paramBoolean2)
      {
        localFinderCommentDrawer.setTopOffset(aw.mL((Context)paramMMFragmentActivity));
        localFinderCommentDrawer.setBackgroundColorRes(e.b.transparent);
      }
      Object localObject = at.GiI;
      localFinderCommentDrawer.setTopOffset((int)(at.getScreenHeight() * 0.25D));
      parama.a((RecyclerViewDrawer)localFinderCommentDrawer, paramInt1);
      if ((parama instanceof b))
      {
        localObject = (b)parama;
        if (localObject != null) {
          break label197;
        }
        localObject = null;
        label113:
        if (!(localObject instanceof f)) {
          break label207;
        }
      }
      label197:
      label207:
      for (localObject = (f)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((f)localObject).AUh = paramInt2;
        }
        ((f)((b)parama).AHK).safeMode = paramBoolean1;
        paramView.post(new FinderCommentDrawer.b..ExternalSyntheticLambda0(paramMMFragmentActivity, paramView, localFinderCommentDrawer, new FrameLayout.LayoutParams(-1, -1), parama, paramBoolean2));
        AppMethodBeat.o(344591);
        return localFinderCommentDrawer;
        localObject = null;
        break;
        localObject = ((b)localObject).AHK;
        break label113;
      }
    }
    
    private static final void a(MMFragmentActivity paramMMFragmentActivity, View paramView, FinderCommentDrawer paramFinderCommentDrawer, FrameLayout.LayoutParams paramLayoutParams, FinderCommentDrawer.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(344613);
      s.u(paramMMFragmentActivity, "$context");
      s.u(paramView, "$parent");
      s.u(paramFinderCommentDrawer, "$drawer");
      s.u(paramLayoutParams, "$params");
      s.u(parama, "$builder");
      Log.i("Finder.CommentDrawer", s.X("[initView] bottomMargin= ", Integer.valueOf(bf.bi((Context)paramMMFragmentActivity))));
      ((FrameLayout)paramView).addView((View)paramFinderCommentDrawer, (ViewGroup.LayoutParams)paramLayoutParams);
      parama.a((Context)paramMMFragmentActivity, paramFinderCommentDrawer.getHeaderLayout(), paramBoolean);
      parama.a((Context)paramMMFragmentActivity, paramFinderCommentDrawer.getCenterLayout());
      parama.b((Context)paramMMFragmentActivity, paramFinderCommentDrawer.getFooterLayout(), paramBoolean);
      parama.c((Context)paramMMFragmentActivity, paramFinderCommentDrawer.getLoadingLayout());
      AppMethodBeat.o(344613);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentDrawer
 * JD-Core Version:    0.7.0.1
 */
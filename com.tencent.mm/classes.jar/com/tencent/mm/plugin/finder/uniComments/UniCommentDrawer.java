package com.tencent.mm.plugin.finder.uniComments;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "banSwitch", "", "getBanSwitch", "()Z", "setBanSwitch", "(Z)V", "blinkRefComment", "getBlinkRefComment", "setBlinkRefComment", "closeComment", "getCloseComment", "setCloseComment", "feedObj", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "setFeedObj", "(Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;)V", "footer", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter;)V", "interceptClose", "Lkotlin/Function0;", "getInterceptClose", "()Lkotlin/jvm/functions/Function0;", "setInterceptClose", "(Lkotlin/jvm/functions/Function0;)V", "isOnlyShowDesc", "setOnlyShowDesc", "isSelfProfile", "setSelfProfile", "isSingleMode", "setSingleMode", "oldVersion", "getOldVersion", "setOldVersion", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$CloseDrawerCallback;", "getOnCloseDrawerCallback", "()Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$CloseDrawerCallback;", "setOnCloseDrawerCallback", "(Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$CloseDrawerCallback;)V", "reason", "getReason", "()I", "setReason", "(I)V", "rect", "Landroid/graphics/Rect;", "refCommentId", "", "getRefCommentId", "()J", "setRefCommentId", "(J)V", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "setReplyCommentObj", "(Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;)V", "scene", "getScene", "setScene", "sceneForReply", "getSceneForReply", "setSceneForReply", "showFooter", "getShowFooter", "setShowFooter", "useCache", "getUseCache", "setUseCache", "closeDrawer", "", "closeDrawerWhenError", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onUIPause", "onUIResume", "openDrawer", "fullScreen", "refreshSceneForReply", "needFocus", "switchScene", "Builder", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class UniCommentDrawer
  extends RecyclerViewDrawer
{
  public static final b FYK;
  private long AAW;
  private boolean AHL;
  boolean AHQ;
  private boolean AUq;
  boolean EAO;
  private e.a FYE;
  private com.tencent.mm.plugin.finder.uniComments.model.b FYH;
  private boolean FYI;
  private com.tencent.mm.plugin.finder.uniComments.storge.b FYJ;
  int FYL;
  private boolean FYM;
  UniCommentFooter FYN;
  private boolean FYO;
  private a<Boolean> FYP;
  private boolean igs;
  boolean plm;
  private int reason;
  private final Rect rect;
  private int scene;
  
  static
  {
    AppMethodBeat.i(341528);
    FYK = new b((byte)0);
    AppMethodBeat.o(341528);
  }
  
  public UniCommentDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(341494);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = d.FAy;
    this.FYL = d.eRx();
    this.FYI = true;
    this.AHL = true;
    AppMethodBeat.o(341494);
  }
  
  public UniCommentDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(341503);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = d.FAy;
    this.FYL = d.eRx();
    this.FYI = true;
    this.AHL = true;
    AppMethodBeat.o(341503);
  }
  
  public UniCommentDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(341510);
    this.rect = new Rect();
    this.scene = 2;
    paramContext = d.FAy;
    this.FYL = d.eRx();
    this.FYI = true;
    this.AHL = true;
    AppMethodBeat.o(341510);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(341538);
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
        break label326;
      }
      paramMotionEvent = getContext();
      if (paramMotionEvent != null) {
        break;
      }
      paramMotionEvent = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(341538);
      throw paramMotionEvent;
      label139:
      if (paramMotionEvent.getAction() == 0)
      {
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(341538);
        return true;
        localView = getHeaderLayout().findViewById(e.e.finder_comment_error_tip);
        this.rect.setEmpty();
        localView.getGlobalVisibleRect(this.rect);
        Log.d("MicroMsg.MusicUni.CommentDrawer", "event.action " + paramMotionEvent.getActionMasked() + " event.y " + paramMotionEvent.getY() + ", " + this.rect.top + ", " + this.rect.bottom);
        if ((paramMotionEvent.getY() >= this.rect.top) && (paramMotionEvent.getY() <= this.rect.bottom))
        {
          if (paramMotionEvent.getActionMasked() != 2)
          {
            bool = localView.dispatchTouchEvent(paramMotionEvent);
            AppMethodBeat.o(341538);
            return bool;
          }
        }
        else {
          localView.setPressed(false);
        }
      }
    }
    ((MMFragmentActivity)paramMotionEvent).hideVKB();
    label326:
    AppMethodBeat.o(341538);
    return bool;
  }
  
  public final void fdg()
  {
    AppMethodBeat.i(341672);
    Object localObject = this.FYP;
    boolean bool;
    if (localObject == null) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(341672);
      return;
      localObject = (Boolean)((a)localObject).invoke();
      if (localObject == null) {
        bool = false;
      } else {
        bool = ((Boolean)localObject).booleanValue();
      }
    }
    fdh();
    AppMethodBeat.o(341672);
  }
  
  public final void fdh()
  {
    AppMethodBeat.i(341679);
    if (fkp())
    {
      if (!this.plm) {
        break label47;
      }
      super.Ob(false);
    }
    for (;;)
    {
      getHeaderLayout().findViewById(e.e.finder_comment_error_tip).setVisibility(8);
      AppMethodBeat.o(341679);
      return;
      label47:
      super.Ob(true);
    }
  }
  
  public final boolean getBanSwitch()
  {
    return this.FYO;
  }
  
  public final boolean getBlinkRefComment()
  {
    return this.AUq;
  }
  
  public final boolean getCloseComment()
  {
    return this.FYM;
  }
  
  public final com.tencent.mm.plugin.finder.uniComments.model.b getFeedObj()
  {
    return this.FYH;
  }
  
  public final UniCommentFooter getFooter()
  {
    return this.FYN;
  }
  
  public final a<Boolean> getInterceptClose()
  {
    return this.FYP;
  }
  
  public final boolean getOldVersion()
  {
    return this.AHL;
  }
  
  public final e.a getOnCloseDrawerCallback()
  {
    return this.FYE;
  }
  
  public final int getReason()
  {
    return this.reason;
  }
  
  public final long getRefCommentId()
  {
    return this.AAW;
  }
  
  public final com.tencent.mm.plugin.finder.uniComments.storge.b getReplyCommentObj()
  {
    return this.FYJ;
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
  
  public final void setBlinkRefComment(boolean paramBoolean)
  {
    this.AUq = paramBoolean;
  }
  
  public final void setCloseComment(boolean paramBoolean)
  {
    this.FYM = paramBoolean;
  }
  
  public final void setFeedObj(com.tencent.mm.plugin.finder.uniComments.model.b paramb)
  {
    this.FYH = paramb;
  }
  
  public final void setFooter(UniCommentFooter paramUniCommentFooter)
  {
    this.FYN = paramUniCommentFooter;
  }
  
  public final void setInterceptClose(a<Boolean> parama)
  {
    this.FYP = parama;
  }
  
  public final void setOldVersion(boolean paramBoolean)
  {
    this.AHL = paramBoolean;
  }
  
  public final void setOnCloseDrawerCallback(e.a parama)
  {
    this.FYE = parama;
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
  
  public final void setReplyCommentObj(com.tencent.mm.plugin.finder.uniComments.storge.b paramb)
  {
    this.FYJ = paramb;
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer$Builder;", "", "onBuildDrawerBody", "", "context", "Landroid/content/Context;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onBuildDrawerFooter", "footerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "onBuildDrawerHeader", "headerLayout", "onBuildLoading", "loadingLayout", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "displayScene", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
    
    public abstract void a(Context paramContext, RefreshLoadMoreLayout paramRefreshLoadMoreLayout);
    
    public abstract void a(RecyclerViewDrawer paramRecyclerViewDrawer, int paramInt);
    
    public abstract void b(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean);
    
    public abstract void c(Context paramContext, FrameLayout paramFrameLayout);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer$Companion;", "", "()V", "TAG", "", "createDrawerToAttachWindow", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer;", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "parent", "Landroid/view/View;", "scene", "", "builder", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer$Builder;", "safeMode", "", "fullScreen", "exposeScene", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static UniCommentDrawer a(MMFragmentActivity paramMMFragmentActivity, View paramView, UniCommentDrawer.a parama)
    {
      AppMethodBeat.i(341436);
      s.u(paramMMFragmentActivity, "context");
      s.u(paramView, "parent");
      s.u(parama, "builder");
      UniCommentDrawer localUniCommentDrawer = new UniCommentDrawer((Context)paramMMFragmentActivity);
      Object localObject = at.GiI;
      localUniCommentDrawer.setTopOffset((int)(at.getScreenHeight() * 0.25D));
      parama.a((RecyclerViewDrawer)localUniCommentDrawer, 2);
      localObject = ((i)parama).FZO;
      if ((localObject instanceof f)) {}
      for (localObject = (f)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((f)localObject).AUh = 70;
        }
        ((f)((i)parama).FZO).safeMode = false;
        paramView.post(new UniCommentDrawer.b..ExternalSyntheticLambda0(paramMMFragmentActivity, paramView, localUniCommentDrawer, new FrameLayout.LayoutParams(-1, -1), parama, false));
        AppMethodBeat.o(341436);
        return localUniCommentDrawer;
      }
    }
    
    private static final void a(MMFragmentActivity paramMMFragmentActivity, View paramView, UniCommentDrawer paramUniCommentDrawer, FrameLayout.LayoutParams paramLayoutParams, UniCommentDrawer.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(341453);
      s.u(paramMMFragmentActivity, "$context");
      s.u(paramView, "$parent");
      s.u(paramUniCommentDrawer, "$drawer");
      s.u(paramLayoutParams, "$params");
      s.u(parama, "$builder");
      Log.i("MicroMsg.MusicUni.CommentDrawer", s.X("[initView] bottomMargin= ", Integer.valueOf(bf.bi((Context)paramMMFragmentActivity))));
      ((FrameLayout)paramView).addView((View)paramUniCommentDrawer, (ViewGroup.LayoutParams)paramLayoutParams);
      parama.a((Context)paramMMFragmentActivity, paramUniCommentDrawer.getHeaderLayout(), paramBoolean);
      parama.a((Context)paramMMFragmentActivity, paramUniCommentDrawer.getCenterLayout());
      parama.b((Context)paramMMFragmentActivity, paramUniCommentDrawer.getFooterLayout(), paramBoolean);
      parama.c((Context)paramMMFragmentActivity, paramUniCommentDrawer.getLoadingLayout());
      AppMethodBeat.o(341453);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.UniCommentDrawer
 * JD-Core Version:    0.7.0.1
 */
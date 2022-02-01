package com.tencent.mm.plugin.finder.feed.ui;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.feed.b;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.b;
import com.tencent.mm.plugin.finder.view.FinderTouchLayout;
import com.tencent.mm.plugin.finder.view.FinderTouchLayout.a;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.plugin.finder.view.f.a.a;
import com.tencent.mm.plugin.finder.view.f.a.b;
import com.tencent.mm.plugin.finder.view.f.a.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import d.a.j;
import d.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@com.tencent.mm.ui.base.a(3)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderCommentUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "DRAG_CLOSE_THRESHOLD", "", "DRAG_START_X", "", "DRAG_START_Y", "DURATION", "", "TAG", "", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "containerView", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "getContainerView", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "setContainerView", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "fromMsg", "", "getFromMsg", "()Z", "setFromMsg", "(Z)V", "isFinish", "mentionId", "getMentionId", "()J", "setMentionId", "(J)V", "requestData", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "getRequestData", "()Lkotlin/Pair;", "setRequestData", "(Lkotlin/Pair;)V", "finish", "", "getLayoutId", "initBuilder", "showTopItem", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "plugin-finder_release"})
public final class FinderCommentUI
  extends MMFinderUI
{
  private final int KRe = 50;
  private final int KRf = 300;
  private final float KRg = 0.3F;
  public FinderTouchLayout KRh;
  public FinderCommentDrawer KRi;
  public o<f.a.a, f.a.b> KRj;
  public com.tencent.mm.plugin.finder.view.builder.a KRk;
  private boolean KRl;
  private final String TAG = "Finder.FinderCommentUI";
  private HashMap _$_findViewCache;
  private boolean gPQ;
  private final long jTY = 300L;
  private long qNU;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198393);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(198393);
    return localView1;
  }
  
  public final FinderTouchLayout fTD()
  {
    AppMethodBeat.i(198387);
    FinderTouchLayout localFinderTouchLayout = this.KRh;
    if (localFinderTouchLayout == null) {
      d.g.b.k.aPZ("containerView");
    }
    AppMethodBeat.o(198387);
    return localFinderTouchLayout;
  }
  
  public final FinderCommentDrawer fTE()
  {
    AppMethodBeat.i(198388);
    FinderCommentDrawer localFinderCommentDrawer = this.KRi;
    if (localFinderCommentDrawer == null) {
      d.g.b.k.aPZ("drawer");
    }
    AppMethodBeat.o(198388);
    return localFinderCommentDrawer;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(198390);
    hideVKB();
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(198390);
  }
  
  public final int getLayoutId()
  {
    return 2131496174;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(198389);
    setTheme(2131821145);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null)
    {
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        d.g.b.k.fvU();
      }
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        d.g.b.k.fvU();
      }
      paramBundle.hide();
    }
    paramBundle = com.tencent.mm.plugin.finder.view.f.LeE;
    paramBundle = getIntent();
    d.g.b.k.g(paramBundle, "intent");
    d.g.b.k.h(paramBundle, "intent");
    long l = paramBundle.getLongExtra("COMMENT_REQUEST_KEY", 0L);
    paramBundle = (o)com.tencent.mm.plugin.finder.view.f.fWG().remove(Long.valueOf(l));
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(198389);
      return;
    }
    this.KRj = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.view.f.LeE;
    paramBundle = getIntent();
    d.g.b.k.g(paramBundle, "intent");
    d.g.b.k.h(paramBundle, "intent");
    this.KRl = paramBundle.getBooleanExtra("FROM_MSG", false);
    paramBundle = com.tencent.mm.plugin.finder.view.f.LeE;
    paramBundle = getIntent();
    d.g.b.k.g(paramBundle, "intent");
    d.g.b.k.h(paramBundle, "intent");
    this.qNU = paramBundle.getLongExtra("MENTION_ID", 0L);
    paramBundle = this.KRj;
    if (paramBundle == null) {
      d.g.b.k.aPZ("requestData");
    }
    Object localObject1 = (f.a.a)paramBundle.first;
    paramBundle = this.KRj;
    if (paramBundle == null) {
      d.g.b.k.aPZ("requestData");
    }
    paramBundle = (f.a.b)paramBundle.second;
    Object localObject2 = findViewById(2131307279);
    d.g.b.k.g(localObject2, "findViewById(R.id.comment_ui_container)");
    this.KRh = ((FinderTouchLayout)localObject2);
    this.KRk = ((com.tencent.mm.plugin.finder.view.builder.a)new a(this, this.KRl, paramBundle.quu, this.qNU, ((f.a.a)localObject1).scene, (CommentDrawerContract.NPresenter)new b((Context)this)));
    localObject2 = com.tencent.mm.ui.component.a.LCX;
    localObject2 = (FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class);
    Object localObject3 = com.tencent.mm.ui.component.a.LCX;
    ((FinderReporterUIC)localObject2).qqE = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).LiL;
    localObject2 = FinderCommentDrawer.qVJ;
    localObject2 = (MMActivity)this;
    localObject3 = getWindow();
    d.g.b.k.g(localObject3, "window");
    localObject3 = ((Window)localObject3).getDecorView();
    d.g.b.k.g(localObject3, "window.decorView");
    int i = ((f.a.a)localObject1).scene;
    com.tencent.mm.plugin.finder.view.builder.a locala = this.KRk;
    if (locala == null) {
      d.g.b.k.aPZ("builder");
    }
    this.KRi = FinderCommentDrawer.b.a((MMActivity)localObject2, (View)localObject3, i, (FinderCommentDrawer.a)locala, ((f.a.a)localObject1).qqF, true);
    localObject1 = this.KRi;
    if (localObject1 == null) {
      d.g.b.k.aPZ("drawer");
    }
    ((FinderCommentDrawer)localObject1).setInterceptClose((d.g.a.a)b.KRr);
    localObject1 = this.KRi;
    if (localObject1 == null) {
      d.g.b.k.aPZ("drawer");
    }
    ((FinderCommentDrawer)localObject1).setOnCloseDrawerCallback((CommentDrawerContract.CloseDrawerCallback)new c(this));
    localObject1 = this.KRh;
    if (localObject1 == null) {
      d.g.b.k.aPZ("containerView");
    }
    ((FinderTouchLayout)localObject1).post((Runnable)new d(this, paramBundle));
    paramBundle = this.KRh;
    if (paramBundle == null) {
      d.g.b.k.aPZ("containerView");
    }
    paramBundle.setTouchListener((FinderTouchLayout.a)new e(this));
    AppMethodBeat.o(198389);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(198391);
    super.onResume();
    AppMethodBeat.o(198391);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "onBuildDrawerHeader", "", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.plugin.finder.view.builder.a
  {
    a(boolean paramBoolean, FinderItem paramFinderItem, long paramLong, int paramInt, CommentDrawerContract.NPresenter paramNPresenter)
    {
      super();
    }
    
    public final void a(final Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
    {
      AppMethodBeat.i(198378);
      d.g.b.k.h(paramContext, "context");
      d.g.b.k.h(paramFrameLayout, "headerLayout");
      super.a(paramContext, paramFrameLayout, paramBoolean);
      if (this.KRn)
      {
        View localView = paramFrameLayout.findViewById(2131307393);
        if (localView == null)
        {
          AppMethodBeat.o(198378);
          return;
        }
        localView.setVisibility(0);
        localView.setOnClickListener((View.OnClickListener)new a(this, paramContext));
        Object localObject1 = (ImageView)paramFrameLayout.findViewById(2131307395);
        Object localObject3 = (bmd)j.iz((List)this.KRo.getMediaList());
        Object localObject2;
        com.tencent.mm.plugin.finder.loader.h localh;
        if (localObject3 != null)
        {
          if (((bmd)localObject3).mediaType == 4)
          {
            localObject2 = new com.tencent.mm.plugin.finder.loader.f((bmd)localObject3, com.tencent.mm.plugin.finder.storage.h.qJZ);
            localObject3 = com.tencent.mm.plugin.finder.loader.h.qCF;
            localObject3 = com.tencent.mm.plugin.finder.loader.h.cmU();
            d.g.b.k.g(localObject1, "thumbIv");
            localh = com.tencent.mm.plugin.finder.loader.h.qCF;
            ((d)localObject3).a(localObject2, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
          }
        }
        else
        {
          localObject1 = (TextView)paramFrameLayout.findViewById(2131307396);
          d.g.b.k.g(localObject1, "titleTv");
          ai.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, (CharSequence)paramContext.getString(2131759222, new Object[] { this.KRo.getNickName() })));
          paramFrameLayout = (TextView)paramFrameLayout.findViewById(2131307394);
          if (bt.isNullOrNil(this.KRo.getDescription())) {
            break label383;
          }
          d.g.b.k.g(paramFrameLayout, "descTv");
          paramFrameLayout.setVisibility(0);
          if (!bt.isNullOrNil(this.KRo.getDescription())) {
            break label360;
          }
          paramContext = (CharSequence)"";
          label286:
          paramFrameLayout.setText(paramContext);
        }
        for (;;)
        {
          csX().gV(localView);
          AppMethodBeat.o(198378);
          return;
          localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
          localObject2 = com.tencent.mm.plugin.finder.loader.h.cmU();
          localObject3 = new com.tencent.mm.plugin.finder.loader.f((bmd)localObject3, com.tencent.mm.plugin.finder.storage.h.qJZ);
          d.g.b.k.g(localObject1, "thumbIv");
          localh = com.tencent.mm.plugin.finder.loader.h.qCF;
          ((d)localObject2).a(localObject3, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
          break;
          label360:
          paramContext = (CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)this.KRo.getDescription());
          break label286;
          label383:
          d.g.b.k.g(paramFrameLayout, "descTv");
          paramFrameLayout.setVisibility(8);
        }
      }
      paramContext = paramFrameLayout.findViewById(2131307393);
      if (paramContext != null)
      {
        paramContext.setVisibility(8);
        AppMethodBeat.o(198378);
        return;
      }
      AppMethodBeat.o(198378);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderCommentUI.a parama, Context paramContext) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(198377);
        paramView = new Intent();
        paramView.putExtra("feed_object_id", this.KRq.KRo.getId());
        paramView.putExtra("mention_id", this.KRq.KRp);
        paramView.putExtra("from_scene", this.KRq.gZZ);
        paramView.putExtra("from_comment_ui", true);
        Object localObject = FinderReporterUIC.Ljl;
        FinderReporterUIC.a.a(paramContext, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.B((Context)this.KRq.KRm, paramView);
        AppMethodBeat.o(198377);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    public static final b KRr;
    
    static
    {
      AppMethodBeat.i(198379);
      KRr = new b();
      AppMethodBeat.o(198379);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$2", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class c
    implements CommentDrawerContract.CloseDrawerCallback
  {
    public final void o(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.h> paramList)
    {
      AppMethodBeat.i(198381);
      d.g.b.k.h(paramList, "data");
      if (FinderCommentUI.a(this.KRm))
      {
        AppMethodBeat.o(198381);
        return;
      }
      FinderCommentUI.b(this.KRm);
      Intent localIntent = new Intent();
      f.a locala = com.tencent.mm.plugin.finder.view.f.LeE;
      paramList = new f.a.c(paramInt, paramList);
      d.g.b.k.h(localIntent, "intent");
      d.g.b.k.h(paramList, "resultData");
      long l = System.currentTimeMillis();
      localIntent.putExtra("COMMENT_RESULT_KEY", l);
      ((Map)com.tencent.mm.plugin.finder.view.f.fWH()).put(Long.valueOf(l), paramList);
      this.KRm.setResult(0, localIntent);
      FinderCommentUI.c(this.KRm).postDelayed((Runnable)new a(this), FinderCommentUI.d(this.KRm));
      AppMethodBeat.o(198381);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderCommentUI.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(198380);
        this.KRs.KRm.finish();
        AppMethodBeat.o(198380);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderCommentUI paramFinderCommentUI, f.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(198382);
      this.KRm.fTE().a(paramBundle.quu, paramBundle.quB, paramBundle.qoE, paramBundle.quC, paramBundle.qVF, paramBundle.qVH);
      AppMethodBeat.o(198382);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$4", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "onTouchUp", "plugin-finder_release"})
  public static final class e
    implements FinderTouchLayout.a
  {
    private float rQP;
    
    e()
    {
      AppMethodBeat.i(198386);
      Resources localResources2 = localResources1.getResources();
      d.g.b.k.g(localResources2, "resources");
      float f = localResources2.getDisplayMetrics().heightPixels;
      Resources localResources1 = localResources1.getResources();
      d.g.b.k.g(localResources1, "resources");
      this.rQP = (f / localResources1.getDisplayMetrics().widthPixels);
      AppMethodBeat.o(198386);
    }
    
    public final void bZ(float paramFloat)
    {
      AppMethodBeat.i(198384);
      this.KRm.fTD().setTranslationY(this.rQP * paramFloat);
      ad.i(FinderCommentUI.g(this.KRm), "distanceX " + paramFloat + ", translationY " + this.KRm.fTD().getTranslationY());
      AppMethodBeat.o(198384);
    }
    
    public final boolean i(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(198383);
      d.g.b.k.h(paramMotionEvent, "event");
      if ((paramMotionEvent.getRawX() <= FinderCommentUI.e(this.KRm)) && (paramMotionEvent.getRawY() > FinderCommentUI.f(this.KRm)))
      {
        AppMethodBeat.o(198383);
        return true;
      }
      AppMethodBeat.o(198383);
      return false;
    }
    
    public final void j(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(198385);
      d.g.b.k.h(paramMotionEvent, "event");
      ad.i(FinderCommentUI.g(this.KRm), "translationY " + this.KRm.fTD().getTranslationY() + ", height:" + this.KRm.fTD().getHeight());
      if (this.KRm.fTD().getTranslationY() > FinderCommentUI.h(this.KRm) * this.KRm.fTD().getHeight())
      {
        this.KRm.fTE().csJ();
        AppMethodBeat.o(198385);
        return;
      }
      this.KRm.fTD().clearAnimation();
      this.KRm.fTD().animate().cancel();
      this.KRm.fTD().animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.5F)).translationY(0.0F).setDuration(FinderCommentUI.d(this.KRm)).start();
      AppMethodBeat.o(198385);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI
 * JD-Core Version:    0.7.0.1
 */
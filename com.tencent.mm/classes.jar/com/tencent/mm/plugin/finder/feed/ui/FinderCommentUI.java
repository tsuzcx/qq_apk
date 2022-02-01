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
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.b;
import com.tencent.mm.plugin.finder.view.FinderTouchLayout;
import com.tencent.mm.plugin.finder.view.FinderTouchLayout.a;
import com.tencent.mm.plugin.finder.view.e.a;
import com.tencent.mm.plugin.finder.view.e.a.a;
import com.tencent.mm.plugin.finder.view.e.a.b;
import com.tencent.mm.plugin.finder.view.e.a.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@com.tencent.mm.ui.base.a(3)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderCommentUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "DRAG_CLOSE_THRESHOLD", "", "DRAG_START_X", "", "DRAG_START_Y", "DURATION", "", "TAG", "", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "containerView", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "getContainerView", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "setContainerView", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "fromMsg", "", "getFromMsg", "()Z", "setFromMsg", "(Z)V", "isFinish", "mentionCreateTime", "getMentionCreateTime", "()I", "setMentionCreateTime", "(I)V", "mentionId", "getMentionId", "()J", "setMentionId", "(J)V", "requestData", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "getRequestData", "()Lkotlin/Pair;", "setRequestData", "(Lkotlin/Pair;)V", "finish", "", "getLayoutId", "initBuilder", "showTopItem", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderCommentUI
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderCommentUI";
  private HashMap _$_findViewCache;
  private boolean hII;
  private final long kQm = 300L;
  private boolean sdA;
  private long sdB;
  private int sdC;
  private final int sdt = 50;
  private final int sdu = 300;
  private final float sdv = 0.3F;
  public FinderTouchLayout sdw;
  public FinderCommentDrawer sdx;
  public o<e.a.a, e.a.b> sdy;
  public com.tencent.mm.plugin.finder.view.builder.b sdz;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202631);
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
    AppMethodBeat.o(202631);
    return localView1;
  }
  
  public final FinderTouchLayout cCf()
  {
    AppMethodBeat.i(202624);
    FinderTouchLayout localFinderTouchLayout = this.sdw;
    if (localFinderTouchLayout == null) {
      p.bcb("containerView");
    }
    AppMethodBeat.o(202624);
    return localFinderTouchLayout;
  }
  
  public final FinderCommentDrawer cCg()
  {
    AppMethodBeat.i(202625);
    FinderCommentDrawer localFinderCommentDrawer = this.sdx;
    if (localFinderCommentDrawer == null) {
      p.bcb("drawer");
    }
    AppMethodBeat.o(202625);
    return localFinderCommentDrawer;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(202627);
    hideVKB();
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(202627);
  }
  
  public final int getLayoutId()
  {
    return 2131496175;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(202626);
    setTheme(2131821145);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null)
    {
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        p.gfZ();
      }
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        p.gfZ();
      }
      paramBundle.hide();
    }
    paramBundle = com.tencent.mm.plugin.finder.view.e.sSA;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    long l = paramBundle.getLongExtra("COMMENT_REQUEST_KEY", 0L);
    paramBundle = (o)com.tencent.mm.plugin.finder.view.e.cNa().remove(Long.valueOf(l));
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(202626);
      return;
    }
    this.sdy = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.view.e.sSA;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    this.sdA = paramBundle.getBooleanExtra("FROM_MSG", false);
    paramBundle = com.tencent.mm.plugin.finder.view.e.sSA;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    this.sdB = paramBundle.getLongExtra("MENTION_ID", 0L);
    paramBundle = com.tencent.mm.plugin.finder.view.e.sSA;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    this.sdC = paramBundle.getIntExtra("MENTION_CREATE_TIME", 0);
    paramBundle = this.sdy;
    if (paramBundle == null) {
      p.bcb("requestData");
    }
    Object localObject1 = (e.a.a)paramBundle.first;
    paramBundle = this.sdy;
    if (paramBundle == null) {
      p.bcb("requestData");
    }
    paramBundle = (e.a.b)paramBundle.second;
    Object localObject2 = findViewById(2131307301);
    p.g(localObject2, "findViewById(R.id.comment_ui_container)");
    this.sdw = ((FinderTouchLayout)localObject2);
    this.sdz = ((com.tencent.mm.plugin.finder.view.builder.b)new a(this, this.sdA, paramBundle.rUg, this.sdB, this.sdC, ((e.a.a)localObject1).scene, (CommentDrawerContract.NPresenter)new com.tencent.mm.plugin.finder.feed.e((Context)this)));
    localObject2 = com.tencent.mm.ui.component.a.KiD;
    localObject2 = (FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class);
    Object localObject3 = com.tencent.mm.ui.component.a.KiD;
    ((FinderReporterUIC)localObject2).rTD = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).tcl;
    localObject2 = FinderCommentDrawer.sSJ;
    localObject2 = (MMActivity)this;
    localObject3 = getWindow();
    p.g(localObject3, "window");
    localObject3 = ((Window)localObject3).getDecorView();
    p.g(localObject3, "window.decorView");
    int i = ((e.a.a)localObject1).scene;
    com.tencent.mm.plugin.finder.view.builder.b localb = this.sdz;
    if (localb == null) {
      p.bcb("builder");
    }
    this.sdx = FinderCommentDrawer.b.a((MMActivity)localObject2, (View)localObject3, i, (FinderCommentDrawer.a)localb, ((e.a.a)localObject1).rMJ, true);
    localObject1 = this.sdx;
    if (localObject1 == null) {
      p.bcb("drawer");
    }
    ((FinderCommentDrawer)localObject1).setInterceptClose((d.g.a.a)b.sdJ);
    localObject1 = this.sdx;
    if (localObject1 == null) {
      p.bcb("drawer");
    }
    ((FinderCommentDrawer)localObject1).setOnCloseDrawerCallback((CommentDrawerContract.CloseDrawerCallback)new c(this));
    localObject1 = this.sdw;
    if (localObject1 == null) {
      p.bcb("containerView");
    }
    ((FinderTouchLayout)localObject1).post((Runnable)new d(this, paramBundle));
    paramBundle = this.sdw;
    if (paramBundle == null) {
      p.bcb("containerView");
    }
    paramBundle.setTouchListener((FinderTouchLayout.a)new e(this));
    AppMethodBeat.o(202626);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202629);
    FinderCommentDrawer localFinderCommentDrawer = this.sdx;
    if (localFinderCommentDrawer == null) {
      p.bcb("drawer");
    }
    localFinderCommentDrawer.cNK();
    super.onDestroy();
    AppMethodBeat.o(202629);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(202628);
    super.onResume();
    AppMethodBeat.o(202628);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "onBuildDrawerHeader", "", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.plugin.finder.view.builder.b
  {
    a(boolean paramBoolean, FinderItem paramFinderItem, long paramLong, int paramInt1, int paramInt2, CommentDrawerContract.NPresenter paramNPresenter)
    {
      super();
    }
    
    public final void a(final Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
    {
      AppMethodBeat.i(202615);
      p.h(paramContext, "context");
      p.h(paramFrameLayout, "headerLayout");
      super.a(paramContext, paramFrameLayout, paramBoolean);
      if (this.sdE)
      {
        View localView = paramFrameLayout.findViewById(2131307462);
        if (localView == null)
        {
          AppMethodBeat.o(202615);
          return;
        }
        localView.setVisibility(0);
        localView.setOnClickListener((View.OnClickListener)new a(this, paramContext));
        Object localObject1 = (ImageView)paramFrameLayout.findViewById(2131307464);
        Object localObject3 = (bvf)j.jd((List)this.sdF.getMediaList());
        Object localObject2;
        i locali;
        if (localObject3 != null)
        {
          if (((bvf)localObject3).mediaType == 4)
          {
            localObject2 = new g((bvf)localObject3, r.syE);
            localObject3 = i.sja;
            localObject3 = i.cCB();
            p.g(localObject1, "thumbIv");
            locali = i.sja;
            ((d)localObject3).a(localObject2, (ImageView)localObject1, i.a(i.a.sjb));
          }
        }
        else
        {
          localObject1 = (TextView)paramFrameLayout.findViewById(2131307465);
          p.g(localObject1, "titleTv");
          al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
          ((TextView)localObject1).setText((CharSequence)k.c(paramContext, (CharSequence)paramContext.getString(2131759222, new Object[] { this.sdF.getNickName() })));
          paramFrameLayout = (TextView)paramFrameLayout.findViewById(2131307463);
          if (bt.isNullOrNil(this.sdF.getDescription())) {
            break label383;
          }
          p.g(paramFrameLayout, "descTv");
          paramFrameLayout.setVisibility(0);
          if (!bt.isNullOrNil(this.sdF.getDescription())) {
            break label360;
          }
          paramContext = (CharSequence)"";
          label286:
          paramFrameLayout.setText(paramContext);
        }
        for (;;)
        {
          cNM().hk(localView);
          AppMethodBeat.o(202615);
          return;
          localObject2 = i.sja;
          localObject2 = i.cCB();
          localObject3 = new g((bvf)localObject3, r.syE);
          p.g(localObject1, "thumbIv");
          locali = i.sja;
          ((d)localObject2).a(localObject3, (ImageView)localObject1, i.a(i.a.sjb));
          break;
          label360:
          paramContext = (CharSequence)k.c(aj.getContext(), (CharSequence)this.sdF.getDescription());
          break label286;
          label383:
          p.g(paramFrameLayout, "descTv");
          paramFrameLayout.setVisibility(8);
        }
      }
      paramContext = paramFrameLayout.findViewById(2131307462);
      if (paramContext != null)
      {
        paramContext.setVisibility(8);
        AppMethodBeat.o(202615);
        return;
      }
      AppMethodBeat.o(202615);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderCommentUI.a parama, Context paramContext) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(202614);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramView = new Intent();
        paramView.putExtra("feed_object_id", this.sdI.sdF.getId());
        paramView.putExtra("mention_id", this.sdI.sdG);
        paramView.putExtra("mention_create_time", this.sdI.sdH);
        paramView.putExtra("from_scene", this.sdI.hST);
        paramView.putExtra("from_comment_ui", true);
        localObject = FinderReporterUIC.tcM;
        FinderReporterUIC.a.a(paramContext, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.F((Context)this.sdI.sdD, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202614);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Boolean>
  {
    public static final b sdJ;
    
    static
    {
      AppMethodBeat.i(202616);
      sdJ = new b();
      AppMethodBeat.o(202616);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$2", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class c
    implements CommentDrawerContract.CloseDrawerCallback
  {
    public final void g(int paramInt, List<? extends m> paramList)
    {
      AppMethodBeat.i(202618);
      p.h(paramList, "data");
      if (FinderCommentUI.a(this.sdD))
      {
        AppMethodBeat.o(202618);
        return;
      }
      FinderCommentUI.b(this.sdD);
      Intent localIntent = new Intent();
      e.a locala = com.tencent.mm.plugin.finder.view.e.sSA;
      paramList = new e.a.c(paramInt, paramList);
      p.h(localIntent, "intent");
      p.h(paramList, "resultData");
      long l = System.currentTimeMillis();
      localIntent.putExtra("COMMENT_RESULT_KEY", l);
      ((Map)com.tencent.mm.plugin.finder.view.e.cNb()).put(Long.valueOf(l), paramList);
      this.sdD.setResult(0, localIntent);
      FinderCommentUI.c(this.sdD).postDelayed((Runnable)new a(this), FinderCommentUI.d(this.sdD));
      AppMethodBeat.o(202618);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderCommentUI.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(202617);
        this.sdK.sdD.finish();
        AppMethodBeat.o(202617);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderCommentUI paramFinderCommentUI, e.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(202619);
      FinderCommentDrawer.a(this.sdD.cCg(), paramBundle.rUg, paramBundle.rUK, paramBundle.rIH, paramBundle.rUL, paramBundle.sSB, paramBundle.sSC, false, 0, 384);
      AppMethodBeat.o(202619);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$4", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "onTouchUp", "plugin-finder_release"})
  public static final class e
    implements FinderTouchLayout.a
  {
    private float rOY;
    
    e()
    {
      AppMethodBeat.i(202623);
      Resources localResources2 = localResources1.getResources();
      p.g(localResources2, "resources");
      float f = localResources2.getDisplayMetrics().heightPixels;
      Resources localResources1 = localResources1.getResources();
      p.g(localResources1, "resources");
      this.rOY = (f / localResources1.getDisplayMetrics().widthPixels);
      AppMethodBeat.o(202623);
    }
    
    public final boolean R(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(202620);
      p.h(paramMotionEvent, "event");
      if ((paramMotionEvent.getRawX() <= FinderCommentUI.e(this.sdD)) && (paramMotionEvent.getRawY() > FinderCommentUI.f(this.sdD)))
      {
        AppMethodBeat.o(202620);
        return true;
      }
      AppMethodBeat.o(202620);
      return false;
    }
    
    public final void S(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(202622);
      p.h(paramMotionEvent, "event");
      ad.i(FinderCommentUI.g(this.sdD), "translationY " + this.sdD.cCf().getTranslationY() + ", height:" + this.sdD.cCf().getHeight());
      if (this.sdD.cCf().getTranslationY() > FinderCommentUI.h(this.sdD) * this.sdD.cCf().getHeight())
      {
        this.sdD.cCg().cMY();
        AppMethodBeat.o(202622);
        return;
      }
      this.sdD.cCf().clearAnimation();
      this.sdD.cCf().animate().cancel();
      this.sdD.cCf().animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.5F)).translationY(0.0F).setDuration(FinderCommentUI.d(this.sdD)).start();
      AppMethodBeat.o(202622);
    }
    
    public final void bb(float paramFloat)
    {
      AppMethodBeat.i(202621);
      this.sdD.cCf().setTranslationY(this.rOY * paramFloat);
      ad.i(FinderCommentUI.g(this.sdD), "distanceX " + paramFloat + ", translationY " + this.sdD.cCf().getTranslationY());
      AppMethodBeat.o(202621);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI
 * JD-Core Version:    0.7.0.1
 */
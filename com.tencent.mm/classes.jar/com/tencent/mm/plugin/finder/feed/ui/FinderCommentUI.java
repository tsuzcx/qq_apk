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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.plugin.finder.feed.f;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.b;
import com.tencent.mm.plugin.finder.view.FinderTouchLayout;
import com.tencent.mm.plugin.finder.view.FinderTouchLayout.a;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.e.a;
import com.tencent.mm.plugin.finder.view.e.a.a;
import com.tencent.mm.plugin.finder.view.e.a.b;
import com.tencent.mm.plugin.finder.view.e.a.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderCommentUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "DRAG_CLOSE_THRESHOLD", "", "DRAG_START_X", "", "DRAG_START_Y", "DURATION", "", "TAG", "", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "containerView", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "getContainerView", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "setContainerView", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "fromMsg", "", "getFromMsg", "()Z", "setFromMsg", "(Z)V", "isFinish", "mentionCreateTime", "getMentionCreateTime", "()I", "setMentionCreateTime", "(I)V", "mentionId", "getMentionId", "()J", "setMentionId", "(J)V", "requestData", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "getRequestData", "()Lkotlin/Pair;", "setRequestData", "(Lkotlin/Pair;)V", "finish", "", "getLayoutId", "initBuilder", "showTopItem", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderCommentUI
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderCommentUI";
  private HashMap _$_findViewCache;
  private boolean iGD;
  private final long lZa = 300L;
  public FinderCommentDrawer tNb;
  private boolean tZA;
  private long tZB;
  private int tZC;
  private final int tZu = 50;
  private final int tZv = 300;
  private final float tZw = 0.3F;
  public FinderTouchLayout tZx;
  public o<e.a.a, e.a.b> tZy;
  public com.tencent.mm.plugin.finder.view.builder.b tZz;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245137);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245137);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245136);
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
    AppMethodBeat.o(245136);
    return localView1;
  }
  
  public final FinderTouchLayout ddT()
  {
    AppMethodBeat.i(245129);
    FinderTouchLayout localFinderTouchLayout = this.tZx;
    if (localFinderTouchLayout == null) {
      p.btv("containerView");
    }
    AppMethodBeat.o(245129);
    return localFinderTouchLayout;
  }
  
  public final FinderCommentDrawer ddU()
  {
    AppMethodBeat.i(245130);
    FinderCommentDrawer localFinderCommentDrawer = this.tNb;
    if (localFinderCommentDrawer == null) {
      p.btv("drawer");
    }
    AppMethodBeat.o(245130);
    return localFinderCommentDrawer;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245132);
    hideVKB();
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(245132);
  }
  
  public final int getLayoutId()
  {
    return 2131494220;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(245131);
    setTheme(2131821174);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null)
    {
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        p.hyc();
      }
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        p.hyc();
      }
      paramBundle.hide();
    }
    paramBundle = e.wky;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    long l = paramBundle.getLongExtra("COMMENT_REQUEST_KEY", 0L);
    paramBundle = (o)e.dGt().remove(Long.valueOf(l));
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(245131);
      return;
    }
    this.tZy = paramBundle;
    paramBundle = e.wky;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    this.tZA = paramBundle.getBooleanExtra("FROM_MSG", false);
    paramBundle = e.wky;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    this.tZB = paramBundle.getLongExtra("MENTION_ID", 0L);
    paramBundle = e.wky;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    this.tZC = paramBundle.getIntExtra("MENTION_CREATE_TIME", 0);
    paramBundle = this.tZy;
    if (paramBundle == null) {
      p.btv("requestData");
    }
    Object localObject1 = (e.a.a)paramBundle.first;
    paramBundle = this.tZy;
    if (paramBundle == null) {
      p.btv("requestData");
    }
    paramBundle = (e.a.b)paramBundle.second;
    Object localObject2 = findViewById(2131298971);
    p.g(localObject2, "findViewById(R.id.comment_ui_container)");
    this.tZx = ((FinderTouchLayout)localObject2);
    this.tZz = ((com.tencent.mm.plugin.finder.view.builder.b)new a(this, this.tZA, paramBundle.tMO, this.tZB, this.tZC, ((e.a.a)localObject1).scene, (CommentDrawerContract.NPresenter)new f((Context)this)));
    localObject2 = com.tencent.mm.ui.component.a.PRN;
    localObject2 = (FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class);
    Object localObject3 = com.tencent.mm.ui.component.a.PRN;
    ((FinderReporterUIC)localObject2).tCE = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).tyh;
    localObject2 = FinderCommentDrawer.wkG;
    localObject2 = (MMFragmentActivity)this;
    localObject3 = getWindow();
    p.g(localObject3, "window");
    localObject3 = ((Window)localObject3).getDecorView();
    p.g(localObject3, "window.decorView");
    int i = ((e.a.a)localObject1).scene;
    com.tencent.mm.plugin.finder.view.builder.b localb = this.tZz;
    if (localb == null) {
      p.btv("builder");
    }
    this.tNb = FinderCommentDrawer.b.a((MMFragmentActivity)localObject2, (View)localObject3, i, (FinderCommentDrawer.a)localb, ((e.a.a)localObject1).tAj, true, 0, 64);
    localObject1 = this.tNb;
    if (localObject1 == null) {
      p.btv("drawer");
    }
    ((FinderCommentDrawer)localObject1).setInterceptClose((kotlin.g.a.a)b.tZJ);
    localObject1 = this.tNb;
    if (localObject1 == null) {
      p.btv("drawer");
    }
    ((FinderCommentDrawer)localObject1).setOnCloseDrawerCallback((CommentDrawerContract.CloseDrawerCallback)new c(this));
    localObject1 = this.tZx;
    if (localObject1 == null) {
      p.btv("containerView");
    }
    ((FinderTouchLayout)localObject1).post((Runnable)new d(this, paramBundle));
    paramBundle = this.tZx;
    if (paramBundle == null) {
      p.btv("containerView");
    }
    paramBundle.setTouchListener((FinderTouchLayout.a)new e(this));
    AppMethodBeat.o(245131);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245134);
    FinderCommentDrawer localFinderCommentDrawer = this.tNb;
    if (localFinderCommentDrawer == null) {
      p.btv("drawer");
    }
    localFinderCommentDrawer.dHu();
    super.onDestroy();
    AppMethodBeat.o(245134);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245133);
    super.onResume();
    AppMethodBeat.o(245133);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "onBuildDrawerHeader", "", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.plugin.finder.view.builder.b
  {
    a(boolean paramBoolean, FinderItem paramFinderItem, long paramLong, int paramInt1, int paramInt2, CommentDrawerContract.NPresenter paramNPresenter)
    {
      super();
    }
    
    public final void a(final Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
    {
      AppMethodBeat.i(245120);
      p.h(paramContext, "context");
      p.h(paramFrameLayout, "headerLayout");
      super.a(paramContext, paramFrameLayout, paramBoolean);
      if (this.tZE)
      {
        View localView = paramFrameLayout.findViewById(2131301827);
        if (localView == null)
        {
          AppMethodBeat.o(245120);
          return;
        }
        localView.setVisibility(0);
        localView.setOnClickListener((View.OnClickListener)new a(this, paramContext));
        Object localObject1 = (ImageView)paramFrameLayout.findViewById(2131301829);
        Object localObject3 = (cjl)j.kt((List)this.tZF.getMediaList());
        Object localObject2;
        m localm;
        if (localObject3 != null)
        {
          if (((cjl)localObject3).mediaType == 4)
          {
            localObject2 = new k((cjl)localObject3, x.vEo, null, null, 12);
            localObject3 = m.uJa;
            localObject3 = m.djY();
            p.g(localObject1, "thumbIv");
            localm = m.uJa;
            ((d)localObject3).a(localObject2, (ImageView)localObject1, m.a(m.a.uJb));
          }
        }
        else
        {
          localObject1 = (TextView)paramFrameLayout.findViewById(2131301830);
          p.g(localObject1, "titleTv");
          ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, (CharSequence)paramContext.getString(2131759748, new Object[] { this.tZF.getNickName() })));
          paramFrameLayout = (TextView)paramFrameLayout.findViewById(2131301828);
          if (Util.isNullOrNil(this.tZF.getDescription())) {
            break label391;
          }
          p.g(paramFrameLayout, "descTv");
          paramFrameLayout.setVisibility(0);
          if (!Util.isNullOrNil(this.tZF.getDescription())) {
            break label368;
          }
          paramContext = (CharSequence)"";
          label290:
          paramFrameLayout.setText(paramContext);
        }
        for (;;)
        {
          dHw().hH(localView);
          AppMethodBeat.o(245120);
          return;
          localObject2 = m.uJa;
          localObject2 = m.djY();
          localObject3 = new k((cjl)localObject3, x.vEo, null, null, 12);
          p.g(localObject1, "thumbIv");
          localm = m.uJa;
          ((d)localObject2).a(localObject3, (ImageView)localObject1, m.a(m.a.uJb));
          break;
          label368:
          paramContext = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)this.tZF.getDescription());
          break label290;
          label391:
          p.g(paramFrameLayout, "descTv");
          paramFrameLayout.setVisibility(8);
        }
      }
      paramContext = paramFrameLayout.findViewById(2131301827);
      if (paramContext != null)
      {
        paramContext.setVisibility(8);
        AppMethodBeat.o(245120);
        return;
      }
      AppMethodBeat.o(245120);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderCommentUI.a parama, Context paramContext) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(245119);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = new Intent();
        paramView.putExtra("feed_object_id", this.tZI.tZF.getId());
        paramView.putExtra("mention_id", this.tZI.tZG);
        paramView.putExtra("mention_create_time", this.tZI.tZH);
        paramView.putExtra("from_scene", this.tZI.$scene);
        paramView.putExtra("from_comment_ui", true);
        localObject = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(paramContext, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.I((Context)this.tZI.tZD, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245119);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final b tZJ;
    
    static
    {
      AppMethodBeat.i(245121);
      tZJ = new b();
      AppMethodBeat.o(245121);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$2", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class c
    implements CommentDrawerContract.CloseDrawerCallback
  {
    public final void g(int paramInt, List<? extends s> paramList)
    {
      AppMethodBeat.i(245123);
      p.h(paramList, "data");
      if (FinderCommentUI.a(this.tZD))
      {
        AppMethodBeat.o(245123);
        return;
      }
      FinderCommentUI.b(this.tZD);
      Intent localIntent = new Intent();
      e.a locala = e.wky;
      paramList = new e.a.c(paramInt, paramList);
      p.h(localIntent, "intent");
      p.h(paramList, "resultData");
      long l = System.currentTimeMillis();
      localIntent.putExtra("COMMENT_RESULT_KEY", l);
      ((Map)e.dGu()).put(Long.valueOf(l), paramList);
      this.tZD.setResult(0, localIntent);
      FinderCommentUI.c(this.tZD).postDelayed((Runnable)new a(this), FinderCommentUI.d(this.tZD));
      AppMethodBeat.o(245123);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderCommentUI.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(245122);
        this.tZK.tZD.finish();
        AppMethodBeat.o(245122);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderCommentUI paramFinderCommentUI, e.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(245124);
      FinderCommentDrawer.a(this.tZD.ddU(), paramBundle.tMO, paramBundle.tMV, paramBundle.tuj, paramBundle.tMW, paramBundle.wkz, paramBundle.wkA, false, 0, 384);
      AppMethodBeat.o(245124);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$4", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "onTouchUp", "plugin-finder_release"})
  public static final class e
    implements FinderTouchLayout.a
  {
    private float tEJ;
    
    e()
    {
      AppMethodBeat.i(245128);
      Resources localResources2 = localResources1.getResources();
      p.g(localResources2, "resources");
      float f = localResources2.getDisplayMetrics().heightPixels;
      Resources localResources1 = localResources1.getResources();
      p.g(localResources1, "resources");
      this.tEJ = (f / localResources1.getDisplayMetrics().widthPixels);
      AppMethodBeat.o(245128);
    }
    
    public final boolean T(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(245125);
      p.h(paramMotionEvent, "event");
      if ((paramMotionEvent.getRawX() <= FinderCommentUI.e(this.tZD)) && (paramMotionEvent.getRawY() > FinderCommentUI.f(this.tZD)))
      {
        AppMethodBeat.o(245125);
        return true;
      }
      AppMethodBeat.o(245125);
      return false;
    }
    
    public final void U(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(245127);
      p.h(paramMotionEvent, "event");
      Log.i(FinderCommentUI.g(this.tZD), "translationY " + this.tZD.ddT().getTranslationY() + ", height:" + this.tZD.ddT().getHeight());
      if (this.tZD.ddT().getTranslationY() > FinderCommentUI.h(this.tZD) * this.tZD.ddT().getHeight())
      {
        this.tZD.ddU().dGr();
        AppMethodBeat.o(245127);
        return;
      }
      this.tZD.ddT().clearAnimation();
      this.tZD.ddT().animate().cancel();
      this.tZD.ddT().animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.5F)).translationY(0.0F).setDuration(FinderCommentUI.d(this.tZD)).start();
      AppMethodBeat.o(245127);
    }
    
    public final void bh(float paramFloat)
    {
      AppMethodBeat.i(245126);
      this.tZD.ddT().setTranslationY(this.tEJ * paramFloat);
      Log.i(FinderCommentUI.g(this.tZD), "distanceX " + paramFloat + ", translationY " + this.tZD.ddT().getTranslationY());
      AppMethodBeat.o(245126);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.plugin.finder.model.n;
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
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import d.a.j;
import d.g.b.p;
import d.l;
import d.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@com.tencent.mm.ui.base.a(3)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderCommentUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "DRAG_CLOSE_THRESHOLD", "", "DRAG_START_X", "", "DRAG_START_Y", "DURATION", "", "TAG", "", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "containerView", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "getContainerView", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "setContainerView", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "fromMsg", "", "getFromMsg", "()Z", "setFromMsg", "(Z)V", "isFinish", "mentionCreateTime", "getMentionCreateTime", "()I", "setMentionCreateTime", "(I)V", "mentionId", "getMentionId", "()J", "setMentionId", "(J)V", "requestData", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "getRequestData", "()Lkotlin/Pair;", "setRequestData", "(Lkotlin/Pair;)V", "finish", "", "getLayoutId", "initBuilder", "showTopItem", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderCommentUI
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderCommentUI";
  private HashMap _$_findViewCache;
  private boolean hLB;
  private final long kTU = 300L;
  public FinderCommentDrawer sdu;
  private final int smk = 50;
  private final int sml = 300;
  private final float smm = 0.3F;
  public FinderTouchLayout smn;
  public o<e.a.a, e.a.b> smo;
  public com.tencent.mm.plugin.finder.view.builder.b smp;
  private boolean smq;
  private long smr;
  private int sms;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203107);
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
    AppMethodBeat.o(203107);
    return localView1;
  }
  
  public final FinderTouchLayout cDR()
  {
    AppMethodBeat.i(203100);
    FinderTouchLayout localFinderTouchLayout = this.smn;
    if (localFinderTouchLayout == null) {
      p.bdF("containerView");
    }
    AppMethodBeat.o(203100);
    return localFinderTouchLayout;
  }
  
  public final FinderCommentDrawer cDS()
  {
    AppMethodBeat.i(203101);
    FinderCommentDrawer localFinderCommentDrawer = this.sdu;
    if (localFinderCommentDrawer == null) {
      p.bdF("drawer");
    }
    AppMethodBeat.o(203101);
    return localFinderCommentDrawer;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(203103);
    hideVKB();
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(203103);
  }
  
  public final int getLayoutId()
  {
    return 2131496175;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(203102);
    setTheme(2131821145);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null)
    {
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        p.gkB();
      }
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        p.gkB();
      }
      paramBundle.hide();
    }
    paramBundle = com.tencent.mm.plugin.finder.view.e.tdM;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    long l = paramBundle.getLongExtra("COMMENT_REQUEST_KEY", 0L);
    paramBundle = (o)com.tencent.mm.plugin.finder.view.e.cPJ().remove(Long.valueOf(l));
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(203102);
      return;
    }
    this.smo = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.view.e.tdM;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    this.smq = paramBundle.getBooleanExtra("FROM_MSG", false);
    paramBundle = com.tencent.mm.plugin.finder.view.e.tdM;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    this.smr = paramBundle.getLongExtra("MENTION_ID", 0L);
    paramBundle = com.tencent.mm.plugin.finder.view.e.tdM;
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    p.h(paramBundle, "intent");
    this.sms = paramBundle.getIntExtra("MENTION_CREATE_TIME", 0);
    paramBundle = this.smo;
    if (paramBundle == null) {
      p.bdF("requestData");
    }
    Object localObject1 = (e.a.a)paramBundle.first;
    paramBundle = this.smo;
    if (paramBundle == null) {
      p.bdF("requestData");
    }
    paramBundle = (e.a.b)paramBundle.second;
    Object localObject2 = findViewById(2131307301);
    p.g(localObject2, "findViewById(R.id.comment_ui_container)");
    this.smn = ((FinderTouchLayout)localObject2);
    this.smp = ((com.tencent.mm.plugin.finder.view.builder.b)new a(this, this.smq, paramBundle.scK, this.smr, this.sms, ((e.a.a)localObject1).scene, (CommentDrawerContract.NPresenter)new com.tencent.mm.plugin.finder.feed.e((Context)this)));
    localObject2 = com.tencent.mm.ui.component.a.KEX;
    localObject2 = (FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class);
    Object localObject3 = com.tencent.mm.ui.component.a.KEX;
    ((FinderReporterUIC)localObject2).sch = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).tnf;
    localObject2 = FinderCommentDrawer.tdV;
    localObject2 = (MMActivity)this;
    localObject3 = getWindow();
    p.g(localObject3, "window");
    localObject3 = ((Window)localObject3).getDecorView();
    p.g(localObject3, "window.decorView");
    int i = ((e.a.a)localObject1).scene;
    com.tencent.mm.plugin.finder.view.builder.b localb = this.smp;
    if (localb == null) {
      p.bdF("builder");
    }
    this.sdu = FinderCommentDrawer.b.a((MMActivity)localObject2, (View)localObject3, i, (FinderCommentDrawer.a)localb, ((e.a.a)localObject1).rUX, true);
    localObject1 = this.sdu;
    if (localObject1 == null) {
      p.bdF("drawer");
    }
    ((FinderCommentDrawer)localObject1).setInterceptClose((d.g.a.a)FinderCommentUI.b.smz);
    localObject1 = this.sdu;
    if (localObject1 == null) {
      p.bdF("drawer");
    }
    ((FinderCommentDrawer)localObject1).setOnCloseDrawerCallback((CommentDrawerContract.CloseDrawerCallback)new c(this));
    localObject1 = this.smn;
    if (localObject1 == null) {
      p.bdF("containerView");
    }
    ((FinderTouchLayout)localObject1).post((Runnable)new d(this, paramBundle));
    paramBundle = this.smn;
    if (paramBundle == null) {
      p.bdF("containerView");
    }
    paramBundle.setTouchListener((FinderTouchLayout.a)new e(this));
    AppMethodBeat.o(203102);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203105);
    FinderCommentDrawer localFinderCommentDrawer = this.sdu;
    if (localFinderCommentDrawer == null) {
      p.bdF("drawer");
    }
    localFinderCommentDrawer.cQu();
    super.onDestroy();
    AppMethodBeat.o(203105);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203104);
    super.onResume();
    AppMethodBeat.o(203104);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "onBuildDrawerHeader", "", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.plugin.finder.view.builder.b
  {
    a(boolean paramBoolean, FinderItem paramFinderItem, long paramLong, int paramInt1, int paramInt2, CommentDrawerContract.NPresenter paramNPresenter)
    {
      super();
    }
    
    public final void a(final Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
    {
      AppMethodBeat.i(203091);
      p.h(paramContext, "context");
      p.h(paramFrameLayout, "headerLayout");
      super.a(paramContext, paramFrameLayout, paramBoolean);
      if (this.smu)
      {
        View localView = paramFrameLayout.findViewById(2131307462);
        if (localView == null)
        {
          AppMethodBeat.o(203091);
          return;
        }
        localView.setVisibility(0);
        localView.setOnClickListener((View.OnClickListener)new a(this, paramContext));
        Object localObject1 = (ImageView)paramFrameLayout.findViewById(2131307464);
        Object localObject3 = (bvz)j.jm((List)this.smv.getMediaList());
        Object localObject2;
        i locali;
        if (localObject3 != null)
        {
          if (((bvz)localObject3).mediaType == 4)
          {
            localObject2 = new g((bvz)localObject3, r.sJv);
            localObject3 = i.srW;
            localObject3 = i.cEn();
            p.g(localObject1, "thumbIv");
            locali = i.srW;
            ((d)localObject3).a(localObject2, (ImageView)localObject1, i.a(i.a.srX));
          }
        }
        else
        {
          localObject1 = (TextView)paramFrameLayout.findViewById(2131307465);
          p.g(localObject1, "titleTv");
          al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
          ((TextView)localObject1).setText((CharSequence)k.c(paramContext, (CharSequence)paramContext.getString(2131759222, new Object[] { this.smv.getNickName() })));
          paramFrameLayout = (TextView)paramFrameLayout.findViewById(2131307463);
          if (bu.isNullOrNil(this.smv.getDescription())) {
            break label383;
          }
          p.g(paramFrameLayout, "descTv");
          paramFrameLayout.setVisibility(0);
          if (!bu.isNullOrNil(this.smv.getDescription())) {
            break label360;
          }
          paramContext = (CharSequence)"";
          label286:
          paramFrameLayout.setText(paramContext);
        }
        for (;;)
        {
          cQw().hp(localView);
          AppMethodBeat.o(203091);
          return;
          localObject2 = i.srW;
          localObject2 = i.cEn();
          localObject3 = new g((bvz)localObject3, r.sJv);
          p.g(localObject1, "thumbIv");
          locali = i.srW;
          ((d)localObject2).a(localObject3, (ImageView)localObject1, i.a(i.a.srX));
          break;
          label360:
          paramContext = (CharSequence)k.c(ak.getContext(), (CharSequence)this.smv.getDescription());
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
        AppMethodBeat.o(203091);
        return;
      }
      AppMethodBeat.o(203091);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderCommentUI.a parama, Context paramContext) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(203090);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramView = new Intent();
        paramView.putExtra("feed_object_id", this.smy.smv.getId());
        paramView.putExtra("mention_id", this.smy.smw);
        paramView.putExtra("mention_create_time", this.smy.smx);
        paramView.putExtra("from_scene", this.smy.hVL);
        paramView.putExtra("from_comment_ui", true);
        localObject = FinderReporterUIC.tnG;
        FinderReporterUIC.a.a(paramContext, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.F((Context)this.smy.smt, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203090);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$2", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class c
    implements CommentDrawerContract.CloseDrawerCallback
  {
    public final void g(int paramInt, List<? extends n> paramList)
    {
      AppMethodBeat.i(203094);
      p.h(paramList, "data");
      if (FinderCommentUI.a(this.smt))
      {
        AppMethodBeat.o(203094);
        return;
      }
      FinderCommentUI.b(this.smt);
      Intent localIntent = new Intent();
      e.a locala = com.tencent.mm.plugin.finder.view.e.tdM;
      paramList = new e.a.c(paramInt, paramList);
      p.h(localIntent, "intent");
      p.h(paramList, "resultData");
      long l = System.currentTimeMillis();
      localIntent.putExtra("COMMENT_RESULT_KEY", l);
      ((Map)com.tencent.mm.plugin.finder.view.e.cPK()).put(Long.valueOf(l), paramList);
      this.smt.setResult(0, localIntent);
      FinderCommentUI.c(this.smt).postDelayed((Runnable)new a(this), FinderCommentUI.d(this.smt));
      AppMethodBeat.o(203094);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderCommentUI.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(203093);
        this.smA.smt.finish();
        AppMethodBeat.o(203093);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderCommentUI paramFinderCommentUI, e.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(203095);
      FinderCommentDrawer.a(this.smt.cDS(), paramBundle.scK, paramBundle.sdo, paramBundle.rQR, paramBundle.sdp, paramBundle.tdN, paramBundle.tdO, false, 0, 384);
      AppMethodBeat.o(203095);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$4", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "onTouchUp", "plugin-finder_release"})
  public static final class e
    implements FinderTouchLayout.a
  {
    private float rXz;
    
    e()
    {
      AppMethodBeat.i(203099);
      Resources localResources2 = localResources1.getResources();
      p.g(localResources2, "resources");
      float f = localResources2.getDisplayMetrics().heightPixels;
      Resources localResources1 = localResources1.getResources();
      p.g(localResources1, "resources");
      this.rXz = (f / localResources1.getDisplayMetrics().widthPixels);
      AppMethodBeat.o(203099);
    }
    
    public final boolean P(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(203096);
      p.h(paramMotionEvent, "event");
      if ((paramMotionEvent.getRawX() <= FinderCommentUI.e(this.smt)) && (paramMotionEvent.getRawY() > FinderCommentUI.f(this.smt)))
      {
        AppMethodBeat.o(203096);
        return true;
      }
      AppMethodBeat.o(203096);
      return false;
    }
    
    public final void Q(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(203098);
      p.h(paramMotionEvent, "event");
      ae.i(FinderCommentUI.g(this.smt), "translationY " + this.smt.cDR().getTranslationY() + ", height:" + this.smt.cDR().getHeight());
      if (this.smt.cDR().getTranslationY() > FinderCommentUI.h(this.smt) * this.smt.cDR().getHeight())
      {
        this.smt.cDS().cPH();
        AppMethodBeat.o(203098);
        return;
      }
      this.smt.cDR().clearAnimation();
      this.smt.cDR().animate().cancel();
      this.smt.cDR().animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.5F)).translationY(0.0F).setDuration(FinderCommentUI.d(this.smt)).start();
      AppMethodBeat.o(203098);
    }
    
    public final void bb(float paramFloat)
    {
      AppMethodBeat.i(203097);
      this.smt.cDR().setTranslationY(this.rXz * paramFloat);
      ae.i(FinderCommentUI.g(this.smt), "distanceX " + paramFloat + ", translationY " + this.smt.cDR().getTranslationY());
      AppMethodBeat.o(203097);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI
 * JD-Core Version:    0.7.0.1
 */
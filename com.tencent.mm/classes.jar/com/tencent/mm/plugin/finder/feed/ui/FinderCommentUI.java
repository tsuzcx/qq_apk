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
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer.b;
import com.tencent.mm.plugin.finder.view.FinderTouchLayout;
import com.tencent.mm.plugin.finder.view.FinderTouchLayout.a;
import com.tencent.mm.plugin.finder.view.builder.b;
import com.tencent.mm.plugin.finder.view.d.a;
import com.tencent.mm.plugin.finder.view.d.a.a;
import com.tencent.mm.plugin.finder.view.d.a.b;
import com.tencent.mm.plugin.finder.view.d.a.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import d.a.j;
import d.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@com.tencent.mm.ui.base.a(3)
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderCommentUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "DRAG_CLOSE_THRESHOLD", "", "DRAG_START_X", "", "DRAG_START_Y", "DURATION", "", "TAG", "", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "containerView", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "getContainerView", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "setContainerView", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "fromMsg", "", "getFromMsg", "()Z", "setFromMsg", "(Z)V", "isFinish", "mentionCreateTime", "getMentionCreateTime", "()I", "setMentionCreateTime", "(I)V", "mentionId", "getMentionId", "()J", "setMentionId", "(J)V", "requestData", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "getRequestData", "()Lkotlin/Pair;", "setRequestData", "(Lkotlin/Pair;)V", "finish", "", "getLayoutId", "initBuilder", "showTopItem", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderCommentUI
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderCommentUI";
  private HashMap _$_findViewCache;
  private boolean hqq;
  private final long kuJ = 300L;
  private final int roK = 50;
  private final int roL = 300;
  private final float roM = 0.3F;
  public FinderTouchLayout roN;
  public FinderCommentDrawer roO;
  public o<d.a.a, d.a.b> roP;
  public b roQ;
  private boolean roR;
  private long roS;
  private int roT;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202305);
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
    AppMethodBeat.o(202305);
    return localView1;
  }
  
  public final FinderTouchLayout cvP()
  {
    AppMethodBeat.i(202299);
    FinderTouchLayout localFinderTouchLayout = this.roN;
    if (localFinderTouchLayout == null) {
      d.g.b.k.aVY("containerView");
    }
    AppMethodBeat.o(202299);
    return localFinderTouchLayout;
  }
  
  public final FinderCommentDrawer cvQ()
  {
    AppMethodBeat.i(202300);
    FinderCommentDrawer localFinderCommentDrawer = this.roO;
    if (localFinderCommentDrawer == null) {
      d.g.b.k.aVY("drawer");
    }
    AppMethodBeat.o(202300);
    return localFinderCommentDrawer;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(202302);
    hideVKB();
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(202302);
  }
  
  public final int getLayoutId()
  {
    return 2131496175;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(202301);
    setTheme(2131821145);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null)
    {
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        d.g.b.k.fOy();
      }
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        d.g.b.k.fOy();
      }
      paramBundle.hide();
    }
    paramBundle = com.tencent.mm.plugin.finder.view.d.rVR;
    paramBundle = getIntent();
    d.g.b.k.g(paramBundle, "intent");
    d.g.b.k.h(paramBundle, "intent");
    long l = paramBundle.getLongExtra("COMMENT_REQUEST_KEY", 0L);
    paramBundle = (o)com.tencent.mm.plugin.finder.view.d.cEH().remove(Long.valueOf(l));
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(202301);
      return;
    }
    this.roP = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.view.d.rVR;
    paramBundle = getIntent();
    d.g.b.k.g(paramBundle, "intent");
    d.g.b.k.h(paramBundle, "intent");
    this.roR = paramBundle.getBooleanExtra("FROM_MSG", false);
    paramBundle = com.tencent.mm.plugin.finder.view.d.rVR;
    paramBundle = getIntent();
    d.g.b.k.g(paramBundle, "intent");
    d.g.b.k.h(paramBundle, "intent");
    this.roS = paramBundle.getLongExtra("MENTION_ID", 0L);
    paramBundle = com.tencent.mm.plugin.finder.view.d.rVR;
    paramBundle = getIntent();
    d.g.b.k.g(paramBundle, "intent");
    d.g.b.k.h(paramBundle, "intent");
    this.roT = paramBundle.getIntExtra("MENTION_CREATE_TIME", 0);
    paramBundle = this.roP;
    if (paramBundle == null) {
      d.g.b.k.aVY("requestData");
    }
    Object localObject1 = (d.a.a)paramBundle.first;
    paramBundle = this.roP;
    if (paramBundle == null) {
      d.g.b.k.aVY("requestData");
    }
    paramBundle = (d.a.b)paramBundle.second;
    Object localObject2 = findViewById(2131307301);
    d.g.b.k.g(localObject2, "findViewById(R.id.comment_ui_container)");
    this.roN = ((FinderTouchLayout)localObject2);
    this.roQ = ((b)new a(this, this.roR, paramBundle.rgw, this.roS, this.roT, ((d.a.a)localObject1).scene, (CommentDrawerContract.NPresenter)new com.tencent.mm.plugin.finder.feed.d((Context)this)));
    localObject2 = com.tencent.mm.ui.component.a.IrY;
    localObject2 = (FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class);
    Object localObject3 = com.tencent.mm.ui.component.a.IrY;
    ((FinderReporterUIC)localObject2).rfR = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class)).seo;
    localObject2 = FinderCommentDrawer.rVZ;
    localObject2 = (MMActivity)this;
    localObject3 = getWindow();
    d.g.b.k.g(localObject3, "window");
    localObject3 = ((Window)localObject3).getDecorView();
    d.g.b.k.g(localObject3, "window.decorView");
    int i = ((d.a.a)localObject1).scene;
    b localb = this.roQ;
    if (localb == null) {
      d.g.b.k.aVY("builder");
    }
    this.roO = FinderCommentDrawer.b.a((MMActivity)localObject2, (View)localObject3, i, (FinderCommentDrawer.a)localb, ((d.a.a)localObject1).ran, true);
    localObject1 = this.roO;
    if (localObject1 == null) {
      d.g.b.k.aVY("drawer");
    }
    ((FinderCommentDrawer)localObject1).setInterceptClose((d.g.a.a)FinderCommentUI.b.rpa);
    localObject1 = this.roO;
    if (localObject1 == null) {
      d.g.b.k.aVY("drawer");
    }
    ((FinderCommentDrawer)localObject1).setOnCloseDrawerCallback((CommentDrawerContract.CloseDrawerCallback)new c(this));
    localObject1 = this.roN;
    if (localObject1 == null) {
      d.g.b.k.aVY("containerView");
    }
    ((FinderTouchLayout)localObject1).post((Runnable)new d(this, paramBundle));
    paramBundle = this.roN;
    if (paramBundle == null) {
      d.g.b.k.aVY("containerView");
    }
    paramBundle.setTouchListener((FinderTouchLayout.a)new e(this));
    AppMethodBeat.o(202301);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(210185);
    FinderCommentDrawer localFinderCommentDrawer = this.roO;
    if (localFinderCommentDrawer == null) {
      d.g.b.k.aVY("drawer");
    }
    localFinderCommentDrawer.cMT();
    super.onDestroy();
    AppMethodBeat.o(210185);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(202303);
    super.onResume();
    AppMethodBeat.o(202303);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "onBuildDrawerHeader", "", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "plugin-finder_release"})
  public static final class a
    extends b
  {
    a(boolean paramBoolean, FinderItem paramFinderItem, long paramLong, int paramInt1, int paramInt2, CommentDrawerContract.NPresenter paramNPresenter)
    {
      super();
    }
    
    public final void a(final Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
    {
      AppMethodBeat.i(202290);
      d.g.b.k.h(paramContext, "context");
      d.g.b.k.h(paramFrameLayout, "headerLayout");
      super.a(paramContext, paramFrameLayout, paramBoolean);
      if (this.roV)
      {
        View localView = paramFrameLayout.findViewById(2131307462);
        if (localView == null)
        {
          AppMethodBeat.o(202290);
          return;
        }
        localView.setVisibility(0);
        localView.setOnClickListener((View.OnClickListener)new a(this, paramContext));
        Object localObject1 = (ImageView)paramFrameLayout.findViewById(2131307464);
        Object localObject3 = (bqs)j.iP((List)this.roW.getMediaList());
        Object localObject2;
        h localh;
        if (localObject3 != null)
        {
          if (((bqs)localObject3).mediaType == 4)
          {
            localObject2 = new f((bqs)localObject3, m.rDR);
            localObject3 = h.rtK;
            localObject3 = h.cwn();
            d.g.b.k.g(localObject1, "thumbIv");
            localh = h.rtK;
            ((com.tencent.mm.loader.d)localObject3).a(localObject2, (ImageView)localObject1, h.a(h.a.rtL));
          }
        }
        else
        {
          localObject1 = (TextView)paramFrameLayout.findViewById(2131307465);
          d.g.b.k.g(localObject1, "titleTv");
          aj.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, (CharSequence)paramContext.getString(2131759222, new Object[] { this.roW.getNickName() })));
          paramFrameLayout = (TextView)paramFrameLayout.findViewById(2131307463);
          if (bs.isNullOrNil(this.roW.getDescription())) {
            break label383;
          }
          d.g.b.k.g(paramFrameLayout, "descTv");
          paramFrameLayout.setVisibility(0);
          if (!bs.isNullOrNil(this.roW.getDescription())) {
            break label360;
          }
          paramContext = (CharSequence)"";
          label286:
          paramFrameLayout.setText(paramContext);
        }
        for (;;)
        {
          cFp().gT(localView);
          AppMethodBeat.o(202290);
          return;
          localObject2 = h.rtK;
          localObject2 = h.cwn();
          localObject3 = new f((bqs)localObject3, m.rDR);
          d.g.b.k.g(localObject1, "thumbIv");
          localh = h.rtK;
          ((com.tencent.mm.loader.d)localObject2).a(localObject3, (ImageView)localObject1, h.a(h.a.rtL));
          break;
          label360:
          paramContext = (CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(ai.getContext(), (CharSequence)this.roW.getDescription());
          break label286;
          label383:
          d.g.b.k.g(paramFrameLayout, "descTv");
          paramFrameLayout.setVisibility(8);
        }
      }
      paramContext = paramFrameLayout.findViewById(2131307462);
      if (paramContext != null)
      {
        paramContext.setVisibility(8);
        AppMethodBeat.o(202290);
        return;
      }
      AppMethodBeat.o(202290);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderCommentUI.a parama, Context paramContext) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(202289);
        paramView = new Intent();
        paramView.putExtra("feed_object_id", this.roZ.roW.getId());
        paramView.putExtra("mention_id", this.roZ.roX);
        paramView.putExtra("mention_create_time", this.roZ.roY);
        paramView.putExtra("from_scene", this.roZ.hAy);
        paramView.putExtra("from_comment_ui", true);
        Object localObject = FinderReporterUIC.seQ;
        FinderReporterUIC.a.a(paramContext, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.E((Context)this.roZ.roU, paramView);
        AppMethodBeat.o(202289);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$2", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class c
    implements CommentDrawerContract.CloseDrawerCallback
  {
    public final void g(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.l> paramList)
    {
      AppMethodBeat.i(202293);
      d.g.b.k.h(paramList, "data");
      if (FinderCommentUI.a(this.roU))
      {
        AppMethodBeat.o(202293);
        return;
      }
      FinderCommentUI.b(this.roU);
      Intent localIntent = new Intent();
      d.a locala = com.tencent.mm.plugin.finder.view.d.rVR;
      paramList = new d.a.c(paramInt, paramList);
      d.g.b.k.h(localIntent, "intent");
      d.g.b.k.h(paramList, "resultData");
      long l = System.currentTimeMillis();
      localIntent.putExtra("COMMENT_RESULT_KEY", l);
      ((Map)com.tencent.mm.plugin.finder.view.d.cEI()).put(Long.valueOf(l), paramList);
      this.roU.setResult(0, localIntent);
      FinderCommentUI.c(this.roU).postDelayed((Runnable)new a(this), FinderCommentUI.d(this.roU));
      AppMethodBeat.o(202293);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderCommentUI.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(202292);
        this.rpb.roU.finish();
        AppMethodBeat.o(202292);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderCommentUI paramFinderCommentUI, d.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(202294);
      this.roU.cvQ().a(paramBundle.rgw, paramBundle.rgD, paramBundle.qXy, paramBundle.rgE, paramBundle.rVS, paramBundle.rVT);
      AppMethodBeat.o(202294);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$4", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "onTouchUp", "plugin-finder_release"})
  public static final class e
    implements FinderTouchLayout.a
  {
    private float rcc;
    
    e()
    {
      AppMethodBeat.i(202298);
      Resources localResources2 = localResources1.getResources();
      d.g.b.k.g(localResources2, "resources");
      float f = localResources2.getDisplayMetrics().heightPixels;
      Resources localResources1 = localResources1.getResources();
      d.g.b.k.g(localResources1, "resources");
      this.rcc = (f / localResources1.getDisplayMetrics().widthPixels);
      AppMethodBeat.o(202298);
    }
    
    public final boolean T(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(202295);
      d.g.b.k.h(paramMotionEvent, "event");
      if ((paramMotionEvent.getRawX() <= FinderCommentUI.e(this.roU)) && (paramMotionEvent.getRawY() > FinderCommentUI.f(this.roU)))
      {
        AppMethodBeat.o(202295);
        return true;
      }
      AppMethodBeat.o(202295);
      return false;
    }
    
    public final void U(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(202297);
      d.g.b.k.h(paramMotionEvent, "event");
      ac.i(FinderCommentUI.g(this.roU), "translationY " + this.roU.cvP().getTranslationY() + ", height:" + this.roU.cvP().getHeight());
      if (this.roU.cvP().getTranslationY() > FinderCommentUI.h(this.roU) * this.roU.cvP().getHeight())
      {
        this.roU.cvQ().cEF();
        AppMethodBeat.o(202297);
        return;
      }
      this.roU.cvP().clearAnimation();
      this.roU.cvP().animate().cancel();
      this.roU.cvP().animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.5F)).translationY(0.0F).setDuration(FinderCommentUI.d(this.roU)).start();
      AppMethodBeat.o(202297);
    }
    
    public final void aY(float paramFloat)
    {
      AppMethodBeat.i(202296);
      this.roU.cvP().setTranslationY(this.rcc * paramFloat);
      ac.i(FinderCommentUI.g(this.roU), "distanceX " + paramFloat + ", translationY " + this.roU.cvP().getTranslationY());
      AppMethodBeat.o(202296);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI
 * JD-Core Version:    0.7.0.1
 */
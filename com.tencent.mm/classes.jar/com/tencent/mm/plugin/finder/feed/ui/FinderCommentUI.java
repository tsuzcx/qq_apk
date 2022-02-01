package com.tencent.mm.plugin.finder.feed.ui;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
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
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderCommentUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "DRAG_CLOSE_THRESHOLD", "", "DRAG_START_X", "", "DRAG_START_Y", "DURATION", "", "TAG", "", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "containerView", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "getContainerView", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "setContainerView", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "fromMsg", "", "getFromMsg", "()Z", "setFromMsg", "(Z)V", "isFinish", "mentionCreateTime", "getMentionCreateTime", "()I", "setMentionCreateTime", "(I)V", "mentionId", "getMentionId", "()J", "setMentionId", "(J)V", "requestData", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "getRequestData", "()Lkotlin/Pair;", "setRequestData", "(Lkotlin/Pair;)V", "finish", "", "getLayoutId", "initBuilder", "showTopItem", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderCommentUI
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderCommentUI";
  private HashMap _$_findViewCache;
  private boolean lwF;
  private final long oWT = 300L;
  private final int xLK = 50;
  private final int xLL = 300;
  private final float xLM = 0.3F;
  public FinderTouchLayout xLN;
  public o<f.a.a, f.a.b> xLO;
  public com.tencent.mm.plugin.finder.view.builder.b xLP;
  private boolean xLQ;
  private int xLR;
  private long xcD;
  public FinderCommentDrawer xwQ;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(278260);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(278260);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(278259);
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
    AppMethodBeat.o(278259);
    return localView1;
  }
  
  public final FinderTouchLayout duX()
  {
    AppMethodBeat.i(278250);
    FinderTouchLayout localFinderTouchLayout = this.xLN;
    if (localFinderTouchLayout == null) {
      p.bGy("containerView");
    }
    AppMethodBeat.o(278250);
    return localFinderTouchLayout;
  }
  
  public final FinderCommentDrawer duY()
  {
    AppMethodBeat.i(278251);
    FinderCommentDrawer localFinderCommentDrawer = this.xwQ;
    if (localFinderCommentDrawer == null) {
      p.bGy("drawer");
    }
    AppMethodBeat.o(278251);
    return localFinderCommentDrawer;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(278253);
    hideVKB();
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(278253);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_comment_ui_layout;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(278252);
    setTheme(b.k.MMTheme_Holo_Transparent);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null)
    {
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        p.iCn();
      }
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        p.iCn();
      }
      paramBundle.hide();
    }
    paramBundle = com.tencent.mm.plugin.finder.view.f.AVu;
    paramBundle = getIntent();
    p.j(paramBundle, "intent");
    p.k(paramBundle, "intent");
    long l = paramBundle.getLongExtra("COMMENT_REQUEST_KEY", 0L);
    paramBundle = (o)com.tencent.mm.plugin.finder.view.f.eit().remove(Long.valueOf(l));
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(278252);
      return;
    }
    this.xLO = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.view.f.AVu;
    paramBundle = getIntent();
    p.j(paramBundle, "intent");
    p.k(paramBundle, "intent");
    this.xLQ = paramBundle.getBooleanExtra("FROM_MSG", false);
    paramBundle = com.tencent.mm.plugin.finder.view.f.AVu;
    paramBundle = getIntent();
    p.j(paramBundle, "intent");
    p.k(paramBundle, "intent");
    this.xcD = paramBundle.getLongExtra("MENTION_ID", 0L);
    paramBundle = com.tencent.mm.plugin.finder.view.f.AVu;
    paramBundle = getIntent();
    p.j(paramBundle, "intent");
    p.k(paramBundle, "intent");
    this.xLR = paramBundle.getIntExtra("MENTION_CREATE_TIME", 0);
    paramBundle = this.xLO;
    if (paramBundle == null) {
      p.bGy("requestData");
    }
    Object localObject1 = (f.a.a)paramBundle.Mx;
    paramBundle = this.xLO;
    if (paramBundle == null) {
      p.bGy("requestData");
    }
    paramBundle = (f.a.b)paramBundle.My;
    Object localObject2 = findViewById(b.f.comment_ui_container);
    p.j(localObject2, "findViewById(R.id.comment_ui_container)");
    this.xLN = ((FinderTouchLayout)localObject2);
    this.xLP = ((com.tencent.mm.plugin.finder.view.builder.b)new a(this, this.xLQ, paramBundle.xwF, this.xcD, this.xLR, ((f.a.a)localObject1).scene, (CommentDrawerContract.NPresenter)new com.tencent.mm.plugin.finder.feed.f((Context)this)));
    localObject2 = g.Xox;
    localObject2 = (aj)g.b((AppCompatActivity)this).i(aj.class);
    Object localObject3 = g.Xox;
    ((aj)localObject2).xkX = ((aj)g.b((AppCompatActivity)this).i(aj.class)).fGo;
    localObject2 = FinderCommentDrawer.AVC;
    localObject2 = (MMFragmentActivity)this;
    localObject3 = getWindow();
    p.j(localObject3, "window");
    localObject3 = ((Window)localObject3).getDecorView();
    p.j(localObject3, "window.decorView");
    int i = ((f.a.a)localObject1).scene;
    com.tencent.mm.plugin.finder.view.builder.b localb = this.xLP;
    if (localb == null) {
      p.bGy("builder");
    }
    this.xwQ = FinderCommentDrawer.b.a((MMFragmentActivity)localObject2, (View)localObject3, i, (FinderCommentDrawer.a)localb, ((f.a.a)localObject1).safeMode, true, 0, 64);
    localObject1 = this.xwQ;
    if (localObject1 == null) {
      p.bGy("drawer");
    }
    ((FinderCommentDrawer)localObject1).setInterceptClose((kotlin.g.a.a)b.xLY);
    localObject1 = this.xwQ;
    if (localObject1 == null) {
      p.bGy("drawer");
    }
    ((FinderCommentDrawer)localObject1).setOnCloseDrawerCallback((CommentDrawerContract.CloseDrawerCallback)new c(this));
    localObject1 = this.xLN;
    if (localObject1 == null) {
      p.bGy("containerView");
    }
    ((FinderTouchLayout)localObject1).post((Runnable)new d(this, paramBundle));
    paramBundle = this.xLN;
    if (paramBundle == null) {
      p.bGy("containerView");
    }
    paramBundle.setTouchListener((FinderTouchLayout.a)new e(this));
    AppMethodBeat.o(278252);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(278257);
    FinderCommentDrawer localFinderCommentDrawer = this.xwQ;
    if (localFinderCommentDrawer == null) {
      p.bGy("drawer");
    }
    localFinderCommentDrawer.ejF();
    super.onDestroy();
    AppMethodBeat.o(278257);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(278256);
    super.onResume();
    AppMethodBeat.o(278256);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "onBuildDrawerHeader", "", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.plugin.finder.view.builder.b
  {
    a(boolean paramBoolean, FinderItem paramFinderItem, long paramLong, int paramInt1, int paramInt2, CommentDrawerContract.NPresenter paramNPresenter)
    {
      super();
    }
    
    public final void a(final Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
    {
      AppMethodBeat.i(267110);
      p.k(paramContext, "context");
      p.k(paramFrameLayout, "headerLayout");
      super.a(paramContext, paramFrameLayout, paramBoolean);
      if (this.xLT)
      {
        View localView = paramFrameLayout.findViewById(b.f.full_screen_comment_top_item);
        if (localView == null)
        {
          AppMethodBeat.o(267110);
          return;
        }
        localView.setVisibility(0);
        localView.setOnClickListener((View.OnClickListener)new a(this, paramContext));
        Object localObject1 = (ImageView)paramFrameLayout.findViewById(b.f.full_screen_comment_top_item_thumb);
        Object localObject3 = (csg)j.lp((List)this.xLU.getMediaList());
        Object localObject2;
        t localt;
        if (localObject3 != null)
        {
          if (((csg)localObject3).mediaType == 4)
          {
            localObject2 = new r((csg)localObject3, u.Alz, null, null, 12);
            localObject3 = t.ztT;
            localObject3 = t.dJe();
            p.j(localObject1, "thumbIv");
            localt = t.ztT;
            ((d)localObject3).a(localObject2, (ImageView)localObject1, t.a(t.a.ztU));
          }
        }
        else
        {
          localObject1 = (TextView)paramFrameLayout.findViewById(b.f.full_screen_comment_top_item_title);
          p.j(localObject1, "titleTv");
          ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, (CharSequence)paramContext.getString(b.j.finder_feed_of_user, new Object[] { this.xLU.getNickName() })));
          paramFrameLayout = (TextView)paramFrameLayout.findViewById(b.f.full_screen_comment_top_item_desc);
          if (Util.isNullOrNil(this.xLU.getDescription())) {
            break label396;
          }
          p.j(paramFrameLayout, "descTv");
          paramFrameLayout.setVisibility(0);
          if (!Util.isNullOrNil(this.xLU.getDescription())) {
            break label373;
          }
          paramContext = (CharSequence)"";
          label295:
          paramFrameLayout.setText(paramContext);
        }
        for (;;)
        {
          ejH().jc(localView);
          AppMethodBeat.o(267110);
          return;
          localObject2 = t.ztT;
          localObject2 = t.dJe();
          localObject3 = new r((csg)localObject3, u.Alz, null, null, 12);
          p.j(localObject1, "thumbIv");
          localt = t.ztT;
          ((d)localObject2).a(localObject3, (ImageView)localObject1, t.a(t.a.ztU));
          break;
          label373:
          paramContext = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)this.xLU.getDescription());
          break label295;
          label396:
          p.j(paramFrameLayout, "descTv");
          paramFrameLayout.setVisibility(8);
        }
      }
      paramContext = paramFrameLayout.findViewById(b.f.full_screen_comment_top_item);
      if (paramContext != null)
      {
        paramContext.setVisibility(8);
        AppMethodBeat.o(267110);
        return;
      }
      AppMethodBeat.o(267110);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderCommentUI.a parama, Context paramContext) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(284923);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramView = new Intent();
        paramView.putExtra("feed_object_id", this.xLX.xLU.getId());
        paramView.putExtra("mention_id", this.xLX.xLV);
        paramView.putExtra("mention_create_time", this.xLX.xLW);
        paramView.putExtra("from_scene", this.xLX.$scene);
        paramView.putExtra("from_comment_ui", true);
        localObject = aj.Bnu;
        aj.a.a(paramContext, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.H((Context)this.xLX.xLS, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284923);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final b xLY;
    
    static
    {
      AppMethodBeat.i(291092);
      xLY = new b();
      AppMethodBeat.o(291092);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$2", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class c
    implements CommentDrawerContract.CloseDrawerCallback
  {
    public final void i(int paramInt, List<? extends s> paramList)
    {
      AppMethodBeat.i(285786);
      p.k(paramList, "data");
      if (FinderCommentUI.a(this.xLS))
      {
        AppMethodBeat.o(285786);
        return;
      }
      FinderCommentUI.b(this.xLS);
      Intent localIntent = new Intent();
      f.a locala = com.tencent.mm.plugin.finder.view.f.AVu;
      paramList = new f.a.c(paramInt, paramList);
      p.k(localIntent, "intent");
      p.k(paramList, "resultData");
      long l = System.currentTimeMillis();
      localIntent.putExtra("COMMENT_RESULT_KEY", l);
      ((Map)com.tencent.mm.plugin.finder.view.f.eiu()).put(Long.valueOf(l), paramList);
      this.xLS.setResult(0, localIntent);
      FinderCommentUI.c(this.xLS).postDelayed((Runnable)new a(this), FinderCommentUI.d(this.xLS));
      AppMethodBeat.o(285786);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderCommentUI.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(283005);
        this.xLZ.xLS.finish();
        AppMethodBeat.o(283005);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderCommentUI paramFinderCommentUI, f.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(275085);
      FinderCommentDrawer.a(this.xLS.duY(), paramBundle.xwF, paramBundle.mss, paramBundle.xbT, paramBundle.xwM, paramBundle.AVv, paramBundle.AVw, false, 0, 384);
      AppMethodBeat.o(275085);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$4", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "onTouchUp", "plugin-finder_release"})
  public static final class e
    implements FinderTouchLayout.a
  {
    private float xnl;
    
    e()
    {
      AppMethodBeat.i(287285);
      Resources localResources2 = localResources1.getResources();
      p.j(localResources2, "resources");
      float f = localResources2.getDisplayMetrics().heightPixels;
      Resources localResources1 = localResources1.getResources();
      p.j(localResources1, "resources");
      this.xnl = (f / localResources1.getDisplayMetrics().widthPixels);
      AppMethodBeat.o(287285);
    }
    
    public final boolean Z(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(287282);
      p.k(paramMotionEvent, "event");
      if ((paramMotionEvent.getRawX() <= FinderCommentUI.e(this.xLS)) && (paramMotionEvent.getRawY() > FinderCommentUI.f(this.xLS)))
      {
        AppMethodBeat.o(287282);
        return true;
      }
      AppMethodBeat.o(287282);
      return false;
    }
    
    public final void aa(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(287284);
      p.k(paramMotionEvent, "event");
      Log.i(FinderCommentUI.g(this.xLS), "translationY " + this.xLS.duX().getTranslationY() + ", height:" + this.xLS.duX().getHeight());
      if (this.xLS.duX().getTranslationY() > FinderCommentUI.h(this.xLS) * this.xLS.duX().getHeight())
      {
        this.xLS.duY().eir();
        AppMethodBeat.o(287284);
        return;
      }
      this.xLS.duX().clearAnimation();
      this.xLS.duX().animate().cancel();
      this.xLS.duX().animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.5F)).translationY(0.0F).setDuration(FinderCommentUI.d(this.xLS)).start();
      AppMethodBeat.o(287284);
    }
    
    public final void bg(float paramFloat)
    {
      AppMethodBeat.i(287283);
      this.xLS.duX().setTranslationY(this.xnl * paramFloat);
      Log.i(FinderCommentUI.g(this.xLS), "distanceX " + paramFloat + ", translationY " + this.xLS.duX().getTranslationY());
      AppMethodBeat.o(287283);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.feed.ui;

import android.animation.TimeInterpolator;
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
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.i;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
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
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderCommentUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "DRAG_CLOSE_THRESHOLD", "", "DRAG_START_X", "", "DRAG_START_Y", "DURATION", "", "TAG", "", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "containerView", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "getContainerView", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "setContainerView", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "fromMsg", "", "getFromMsg", "()Z", "setFromMsg", "(Z)V", "isFinish", "mentionCreateTime", "getMentionCreateTime", "()I", "setMentionCreateTime", "(I)V", "mentionId", "getMentionId", "()J", "setMentionId", "(J)V", "requestData", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "getRequestData", "()Lkotlin/Pair;", "setRequestData", "(Lkotlin/Pair;)V", "finish", "", "getLayoutId", "initBuilder", "showTopItem", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderCommentUI
  extends MMFinderUI
{
  private long ABR;
  public FinderCommentDrawer AUv;
  private final int BlS = 50;
  private final int BlT = 300;
  private final float BlU = 0.3F;
  public FinderTouchLayout BlV;
  public r<f.a.a, f.a.b> BlW;
  public com.tencent.mm.plugin.finder.view.builder.b BlX;
  private boolean BlY;
  private int BlZ;
  private final String TAG = "Finder.FinderCommentUI";
  private boolean ooe;
  private final long scq = 300L;
  
  private static final void a(FinderCommentUI paramFinderCommentUI, f.a.b paramb)
  {
    AppMethodBeat.i(365353);
    s.u(paramFinderCommentUI, "this$0");
    s.u(paramb, "$openData");
    FinderCommentDrawer.a(paramFinderCommentUI.eeF(), paramb.AUj, paramb.plm, paramb.AAW, paramb.AUq, paramb.FYI, paramb.GxI, false, 0, false, 0L, 1920);
    AppMethodBeat.o(365353);
  }
  
  private r<f.a.a, f.a.b> eeG()
  {
    AppMethodBeat.i(365343);
    r localr = this.BlW;
    if (localr != null)
    {
      AppMethodBeat.o(365343);
      return localr;
    }
    s.bIx("requestData");
    AppMethodBeat.o(365343);
    return null;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final FinderTouchLayout eeE()
  {
    AppMethodBeat.i(365421);
    FinderTouchLayout localFinderTouchLayout = this.BlV;
    if (localFinderTouchLayout != null)
    {
      AppMethodBeat.o(365421);
      return localFinderTouchLayout;
    }
    s.bIx("containerView");
    AppMethodBeat.o(365421);
    return null;
  }
  
  public final FinderCommentDrawer eeF()
  {
    AppMethodBeat.i(365426);
    FinderCommentDrawer localFinderCommentDrawer = this.AUv;
    if (localFinderCommentDrawer != null)
    {
      AppMethodBeat.o(365426);
      return localFinderCommentDrawer;
    }
    s.bIx("drawer");
    AppMethodBeat.o(365426);
    return null;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(365448);
    hideVKB();
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(365448);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_comment_ui_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365442);
    setTheme(e.i.MMTheme_Holo_Transparent);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null)
    {
      paramBundle = getSupportActionBar();
      s.checkNotNull(paramBundle);
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle = getSupportActionBar();
      s.checkNotNull(paramBundle);
      paramBundle.hide();
    }
    paramBundle = com.tencent.mm.plugin.finder.view.f.GxF;
    paramBundle = getIntent();
    s.s(paramBundle, "intent");
    s.u(paramBundle, "intent");
    long l = paramBundle.getLongExtra("COMMENT_REQUEST_KEY", 0L);
    paramBundle = (r)com.tencent.mm.plugin.finder.view.f.fkq().remove(Long.valueOf(l));
    if (paramBundle == null)
    {
      finish();
      AppMethodBeat.o(365442);
      return;
    }
    s.u(paramBundle, "<set-?>");
    this.BlW = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.view.f.GxF;
    paramBundle = getIntent();
    s.s(paramBundle, "intent");
    s.u(paramBundle, "intent");
    this.BlY = paramBundle.getBooleanExtra("FROM_MSG", false);
    paramBundle = com.tencent.mm.plugin.finder.view.f.GxF;
    paramBundle = getIntent();
    s.s(paramBundle, "intent");
    s.u(paramBundle, "intent");
    this.ABR = paramBundle.getLongExtra("MENTION_ID", 0L);
    paramBundle = com.tencent.mm.plugin.finder.view.f.GxF;
    paramBundle = getIntent();
    s.s(paramBundle, "intent");
    s.u(paramBundle, "intent");
    this.BlZ = paramBundle.getIntExtra("MENTION_CREATE_TIME", 0);
    f.a.a locala = (f.a.a)eeG().bsC;
    f.a.b localb = (f.a.b)eeG().bsD;
    paramBundle = findViewById(e.e.comment_ui_container);
    s.s(paramBundle, "findViewById(R.id.comment_ui_container)");
    paramBundle = (FinderTouchLayout)paramBundle;
    s.u(paramBundle, "<set-?>");
    this.BlV = paramBundle;
    paramBundle = new a(this.BlY, localb.AUj, this.ABR, this.BlZ, locala.scene, this, new com.tencent.mm.plugin.finder.feed.f((Context)this));
    Object localObject = ah.aiuX;
    paramBundle = (com.tencent.mm.plugin.finder.view.builder.b)paramBundle;
    s.u(paramBundle, "<set-?>");
    this.BlX = paramBundle;
    paramBundle = k.aeZF;
    paramBundle = (as)k.d((AppCompatActivity)this).q(as.class);
    localObject = k.aeZF;
    paramBundle.AJo = ((as)k.d((AppCompatActivity)this).q(as.class)).hLK;
    paramBundle = FinderCommentDrawer.GxJ;
    localObject = (MMFragmentActivity)this;
    View localView = getWindow().getDecorView();
    s.s(localView, "window.decorView");
    int i = locala.scene;
    paramBundle = this.BlX;
    if (paramBundle != null) {}
    for (;;)
    {
      paramBundle = FinderCommentDrawer.b.a((MMFragmentActivity)localObject, localView, i, (FinderCommentDrawer.a)paramBundle, locala.safeMode, true, 0, 64);
      s.u(paramBundle, "<set-?>");
      this.AUv = paramBundle;
      eeF().setInterceptClose((kotlin.g.a.a)b.Bmf);
      eeF().setOnCloseDrawerCallback((CommentDrawerContract.CloseDrawerCallback)new c(this));
      eeE().post(new FinderCommentUI..ExternalSyntheticLambda0(this, localb));
      eeE().setTouchListener((FinderTouchLayout.a)new d(this));
      AppMethodBeat.o(365442);
      return;
      s.bIx("builder");
      paramBundle = null;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365459);
    eeF().eIv();
    super.onDestroy();
    AppMethodBeat.o(365459);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(365456);
    super.onResume();
    AppMethodBeat.o(365456);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "onBuildDrawerHeader", "", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends com.tencent.mm.plugin.finder.view.builder.b
  {
    a(boolean paramBoolean, FinderItem paramFinderItem, long paramLong, int paramInt1, int paramInt2, FinderCommentUI paramFinderCommentUI, com.tencent.mm.plugin.finder.feed.f paramf)
    {
      super();
      AppMethodBeat.i(365192);
      AppMethodBeat.o(365192);
    }
    
    private static final void a(FinderItem paramFinderItem, long paramLong, int paramInt1, int paramInt2, Context paramContext, FinderCommentUI paramFinderCommentUI, View paramView)
    {
      AppMethodBeat.i(365202);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderItem);
      localb.hB(paramLong);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      localb.cH(paramContext);
      localb.cH(paramFinderCommentUI);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramFinderItem, "$feed");
      s.u(paramContext, "$context");
      s.u(paramFinderCommentUI, "this$0");
      paramView = new Intent();
      paramView.putExtra("feed_object_id", paramFinderItem.getId());
      paramView.putExtra("mention_id", paramLong);
      paramView.putExtra("mention_create_time", paramInt1);
      paramView.putExtra("from_scene", paramInt2);
      paramView.putExtra("from_comment_ui", true);
      paramFinderItem = as.GSQ;
      as.a.a(paramContext, paramView, 0L, 0, false, 124);
      paramFinderItem = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.ab((Context)paramFinderCommentUI, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(365202);
    }
    
    public final void a(Context paramContext, FrameLayout paramFrameLayout, boolean paramBoolean)
    {
      AppMethodBeat.i(365227);
      s.u(paramContext, "context");
      s.u(paramFrameLayout, "headerLayout");
      super.a(paramContext, paramFrameLayout, paramBoolean);
      if (this.Bma)
      {
        View localView = paramFrameLayout.findViewById(e.e.full_screen_comment_top_item);
        if (localView == null)
        {
          AppMethodBeat.o(365227);
          return;
        }
        localView.setVisibility(0);
        localView.setOnClickListener(new FinderCommentUI.a..ExternalSyntheticLambda0(this.Bmb, this.Bmc, this.Bmd, jdField_this, paramContext, this.Bme));
        Object localObject1 = (ImageView)paramFrameLayout.findViewById(e.e.full_screen_comment_top_item_thumb);
        Object localObject3 = (dji)kotlin.a.p.oL((List)this.Bmb.getMediaList());
        Object localObject2;
        com.tencent.mm.plugin.finder.loader.p localp;
        if (localObject3 != null)
        {
          if (((dji)localObject3).mediaType == 4)
          {
            localObject2 = new n((dji)localObject3, v.FKZ, null, null, 12);
            localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
            localObject3 = com.tencent.mm.plugin.finder.loader.p.eCl();
            s.s(localObject1, "thumbIv");
            localp = com.tencent.mm.plugin.finder.loader.p.ExI;
            ((d)localObject3).a(localObject2, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
          }
        }
        else
        {
          localObject1 = (TextView)paramFrameLayout.findViewById(e.e.full_screen_comment_top_item_title);
          aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)paramContext.getString(e.h.finder_feed_of_user, new Object[] { this.Bmb.getNickName() })));
          paramFrameLayout = (TextView)paramFrameLayout.findViewById(e.e.full_screen_comment_top_item_desc);
          if (Util.isNullOrNil(this.Bmb.getDescription())) {
            break label401;
          }
          paramFrameLayout.setVisibility(0);
          if (!Util.isNullOrNil(this.Bmb.getDescription())) {
            break label378;
          }
          paramContext = (CharSequence)"";
          label300:
          paramFrameLayout.setText(paramContext);
        }
        for (;;)
        {
          flR().mA(localView);
          AppMethodBeat.o(365227);
          return;
          localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
          localObject3 = new n((dji)localObject3, v.FKZ, null, null, 12);
          s.s(localObject1, "thumbIv");
          localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((d)localObject2).a(localObject3, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
          break;
          label378:
          paramContext = (CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)this.Bmb.getDescription());
          break label300;
          label401:
          paramFrameLayout.setVisibility(8);
        }
      }
      paramContext = paramFrameLayout.findViewById(e.e.full_screen_comment_top_item);
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      AppMethodBeat.o(365227);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final b Bmf;
    
    static
    {
      AppMethodBeat.i(365191);
      Bmf = new b();
      AppMethodBeat.o(365191);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$2", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements CommentDrawerContract.CloseDrawerCallback
  {
    c(FinderCommentUI paramFinderCommentUI) {}
    
    private static final void i(FinderCommentUI paramFinderCommentUI)
    {
      AppMethodBeat.i(365237);
      s.u(paramFinderCommentUI, "this$0");
      paramFinderCommentUI.finish();
      AppMethodBeat.o(365237);
    }
    
    public final void z(int paramInt, List<? extends t> paramList)
    {
      AppMethodBeat.i(365249);
      s.u(paramList, "data");
      if (FinderCommentUI.a(this.Bme))
      {
        AppMethodBeat.o(365249);
        return;
      }
      FinderCommentUI.b(this.Bme);
      Intent localIntent = new Intent();
      f.a locala = com.tencent.mm.plugin.finder.view.f.GxF;
      paramList = new f.a.c(paramInt, paramList);
      s.u(localIntent, "intent");
      s.u(paramList, "resultData");
      long l = System.currentTimeMillis();
      localIntent.putExtra("COMMENT_RESULT_KEY", l);
      ((Map)com.tencent.mm.plugin.finder.view.f.fkr()).put(Long.valueOf(l), paramList);
      this.Bme.setResult(0, localIntent);
      FinderCommentUI.c(this.Bme).postDelayed(new FinderCommentUI.c..ExternalSyntheticLambda0(this.Bme), FinderCommentUI.d(this.Bme));
      AppMethodBeat.o(365249);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$4", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "onTouchUp", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements FinderTouchLayout.a
  {
    private float nwN;
    
    d(FinderCommentUI paramFinderCommentUI)
    {
      AppMethodBeat.i(365240);
      this.nwN = (this.Bme.getResources().getDisplayMetrics().heightPixels / this.Bme.getResources().getDisplayMetrics().widthPixels);
      AppMethodBeat.o(365240);
    }
    
    public final boolean aa(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(365246);
      s.u(paramMotionEvent, "event");
      if ((paramMotionEvent.getRawX() <= FinderCommentUI.e(this.Bme)) && (paramMotionEvent.getRawY() > FinderCommentUI.f(this.Bme)))
      {
        AppMethodBeat.o(365246);
        return true;
      }
      AppMethodBeat.o(365246);
      return false;
    }
    
    public final void ab(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(365260);
      s.u(paramMotionEvent, "event");
      Log.i(FinderCommentUI.g(this.Bme), "translationY " + this.Bme.eeE().getTranslationY() + ", height:" + this.Bme.eeE().getHeight());
      if (this.Bme.eeE().getTranslationY() > FinderCommentUI.h(this.Bme) * this.Bme.eeE().getHeight())
      {
        this.Bme.eeF().fdh();
        AppMethodBeat.o(365260);
        return;
      }
      this.Bme.eeE().clearAnimation();
      this.Bme.eeE().animate().cancel();
      this.Bme.eeE().animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.5F)).translationY(0.0F).setDuration(FinderCommentUI.d(this.Bme)).start();
      AppMethodBeat.o(365260);
    }
    
    public final void cj(float paramFloat)
    {
      AppMethodBeat.i(365250);
      this.Bme.eeE().setTranslationY(this.nwN * paramFloat);
      Log.i(FinderCommentUI.g(this.Bme), "distanceX " + paramFloat + ", translationY " + this.Bme.eeE().getTranslationY());
      AppMethodBeat.o(365250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI
 * JD-Core Version:    0.7.0.1
 */
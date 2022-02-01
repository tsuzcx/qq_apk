package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFloatBallDetailLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.p.a;
import com.tencent.mm.plugin.finder.feed.p.b;
import com.tencent.mm.plugin.finder.megavideo.floatball.a.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFloatBallDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFloatBallDetailContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFloatBallDetailContract$Presenter;", "()V", "feedLoader", "isMultiTask", "", "presenter", "viewCallback", "finish", "", "getCommentScene", "", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initMultiTaskData", "initOnCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderFloatBallDetailUI
  extends FinderLoaderFeedUI<FinderFloatBallDetailLoader, p.b, p.a>
{
  private p.a BmE;
  private p.b BmF;
  private FinderFloatBallDetailLoader BmG;
  private boolean BmH;
  
  private static final void a(FinderFloatBallDetailUI paramFinderFloatBallDetailUI, View paramView)
  {
    AppMethodBeat.i(365578);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFloatBallDetailUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFloatBallDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderFloatBallDetailUI, "this$0");
    if (!paramFinderFloatBallDetailUI.BmH)
    {
      paramView = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
      a.a.eCH().ego();
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(false);
      com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    }
    paramFinderFloatBallDetailUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderFloatBallDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365578);
  }
  
  private p.a eeK()
  {
    AppMethodBeat.i(365569);
    p.a locala = this.BmE;
    if (locala == null)
    {
      s.bIx("presenter");
      AppMethodBeat.o(365569);
      return null;
    }
    AppMethodBeat.o(365569);
    return locala;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public void finish()
  {
    AppMethodBeat.i(365651);
    super.finish();
    AppMethodBeat.o(365651);
  }
  
  public final int getCommentScene()
  {
    return 113;
  }
  
  public int getLayoutId()
  {
    return e.f.fidner_float_ball_detail_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(365604);
    if (getIntent().getByteArrayExtra("KEY_FLOAT_BALL_INFO") != null) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      this.BmH = bool;
      localObject1 = (WeImageView)findViewById(e.e.backBtnIv);
      if (localObject1 == null) {
        break label125;
      }
      ((WeImageView)localObject1).setImageResource(e.g.icons_filled_close2);
      ((WeImageView)localObject1).setIconColor(-1);
      i = getResources().getDimensionPixelSize(e.c.Edge_3_5_A);
      localObject2 = ((WeImageView)localObject1).getLayoutParams();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(365604);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = (LinearLayout.LayoutParams)localObject2;
    ((LinearLayout.LayoutParams)localObject2).height = i;
    ((LinearLayout.LayoutParams)localObject2).width = i;
    ((LinearLayout.LayoutParams)localObject2).gravity = 48;
    ((WeImageView)localObject1).requestLayout();
    label125:
    findViewById(e.e.full_actionbar).setPadding(0, getResources().getDimensionPixelSize(e.c.Edge_6_5_A), 0, 0);
    Object localObject1 = findViewById(e.e.back_button);
    ((View)localObject1).setBackground(null);
    ((View)localObject1).setPadding(getResources().getDimensionPixelOffset(e.c.Edge_2A), ((View)localObject1).getPaddingTop(), ((View)localObject1).getPaddingRight(), ((View)localObject1).getPaddingBottom());
    ((View)localObject1).setOnClickListener(new FinderFloatBallDetailUI..ExternalSyntheticLambda0(this));
    this.BmE = new p.a((MMActivity)this);
    Object localObject3 = (MMActivity)this;
    localObject2 = this.BmE;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("presenter");
      localObject1 = null;
    }
    this.BmF = new p.b((MMActivity)localObject3, (p.a)localObject1);
    localObject1 = k.aeZF;
    localObject3 = new FinderFloatBallDetailLoader(((as)k.d((AppCompatActivity)this).q(as.class)).fou());
    ((FinderFloatBallDetailLoader)localObject3).Bgq = getIntent().getLongExtra("KEY_CACHE_OBJECT_ID", 0L);
    localObject2 = getIntent().getStringExtra("KEY_CACHE_OBJECT_NONCE_ID");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((FinderFloatBallDetailLoader)localObject3).avV((String)localObject1);
    localObject1 = getIntent();
    s.s(localObject1, "intent");
    ((FinderFloatBallDetailLoader)localObject3).initFromCache((Intent)localObject1);
    ((FinderFloatBallDetailLoader)localObject3).setInitDone((j)new a(this, (FinderFloatBallDetailLoader)localObject3));
    localObject1 = ah.aiuX;
    this.BmG = ((FinderFloatBallDetailLoader)localObject3);
    localObject1 = k.aeZF;
    ((com.tencent.mm.plugin.finder.viewmodel.component.f)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.f.class)).GMR = this.BmH;
    AppMethodBeat.o(365604);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(365642);
    super.onDestroy();
    AppMethodBeat.o(365642);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(365625);
    super.onPause();
    if ((!this.BmH) && (isFinishing()))
    {
      Object localObject = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
      com.tencent.mm.plugin.finder.megavideo.floatball.a locala1 = a.a.eCH();
      p.a locala = this.BmE;
      localObject = locala;
      if (locala == null)
      {
        s.bIx("presenter");
        localObject = null;
      }
      locala1.Or(((p.a)localObject).ecg());
    }
    AppMethodBeat.o(365625);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(365617);
    super.onResume();
    AppMethodBeat.o(365617);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(365608);
    if (!this.BmH)
    {
      a.a locala = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
      a.a.eCH().egp();
    }
    super.onStart();
    AppMethodBeat.o(365608);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(365636);
    if (!this.BmH)
    {
      a.a locala = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
      a.a.eCH().Or(eeK().ecg());
    }
    super.onStop();
    AppMethodBeat.o(365636);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderFloatBallDetailUI$initOnCreate$3$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements j
  {
    a(FinderFloatBallDetailUI paramFinderFloatBallDetailUI, FinderFloatBallDetailLoader paramFinderFloatBallDetailLoader) {}
    
    private static final void a(FinderLinearLayoutManager paramFinderLinearLayoutManager, FinderFloatBallDetailLoader paramFinderFloatBallDetailLoader, final FinderFloatBallDetailUI paramFinderFloatBallDetailUI, final RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(365400);
      s.u(paramFinderLinearLayoutManager, "$layoutManager");
      s.u(paramFinderFloatBallDetailLoader, "$this_apply");
      s.u(paramFinderFloatBallDetailUI, "this$0");
      s.u(paramRecyclerView, "$it");
      paramFinderLinearLayoutManager.bo(paramFinderFloatBallDetailLoader.getInitPos(), 0);
      final long l = paramFinderFloatBallDetailUI.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
      if (l > 0L) {
        d.a(0L, (kotlin.g.a.a)new a(paramFinderLinearLayoutManager, paramRecyclerView, paramFinderFloatBallDetailUI, l));
      }
      AppMethodBeat.o(365400);
    }
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(365414);
      Object localObject2 = FinderFloatBallDetailUI.a(this.BmI);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView();
      if (localObject1 != null)
      {
        localObject2 = this.BmJ;
        FinderFloatBallDetailUI localFinderFloatBallDetailUI = this.BmI;
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject1).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(365414);
          throw ((Throwable)localObject1);
        }
        ((RecyclerView)localObject1).post(new FinderFloatBallDetailUI.a..ExternalSyntheticLambda0((FinderLinearLayoutManager)localLayoutManager, (FinderFloatBallDetailLoader)localObject2, localFinderFloatBallDetailUI, (RecyclerView)localObject1));
      }
      AppMethodBeat.o(365414);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderLinearLayoutManager paramFinderLinearLayoutManager, RecyclerView paramRecyclerView, FinderFloatBallDetailUI paramFinderFloatBallDetailUI, long paramLong)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFloatBallDetailUI
 * JD-Core Version:    0.7.0.1
 */
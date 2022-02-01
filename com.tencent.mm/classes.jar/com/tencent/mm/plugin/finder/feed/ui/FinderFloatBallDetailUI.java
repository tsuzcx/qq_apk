package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFloatBallDetailLoader;
import com.tencent.mm.plugin.finder.feed.q.a;
import com.tencent.mm.plugin.finder.feed.q.b;
import com.tencent.mm.plugin.finder.megavideo.floatball.a.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFloatBallDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFloatBallDetailContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFloatBallDetailContract$Presenter;", "()V", "feedLoader", "floatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "isMultiTask", "", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "presenter", "viewCallback", "finish", "", "getCommentScene", "", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initMultiTaskData", "initOnCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public class FinderFloatBallDetailUI
  extends FinderLoaderFeedUI<FinderFloatBallDetailLoader, q.b, q.a>
{
  private HashMap _$_findViewCache;
  private q.a xMt;
  private q.b xMu;
  private FinderFloatBallDetailLoader xMv;
  private com.tencent.mm.plugin.finder.megavideo.multitask.a xMw;
  private final cwl xMx;
  private boolean xMy;
  
  public FinderFloatBallDetailUI()
  {
    AppMethodBeat.i(286374);
    this.xMx = new cwl();
    AppMethodBeat.o(286374);
  }
  
  private q.a dvb()
  {
    AppMethodBeat.i(286370);
    q.a locala = this.xMt;
    if (locala == null) {
      p.bGy("presenter");
    }
    AppMethodBeat.o(286370);
    return locala;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(286377);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(286377);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(286376);
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
    AppMethodBeat.o(286376);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public void finish()
  {
    AppMethodBeat.i(286368);
    if (this.xMy)
    {
      com.tencent.mm.plugin.finder.megavideo.multitask.a locala = this.xMw;
      if ((locala != null) && (locala.Q(2, false) == true))
      {
        this.xMy = false;
        AppMethodBeat.o(286368);
        return;
      }
    }
    super.finish();
    AppMethodBeat.o(286368);
  }
  
  public final int getCommentScene()
  {
    return 45;
  }
  
  public int getLayoutId()
  {
    return b.g.fidner_float_ball_detail_ui;
  }
  
  public final void initOnCreate()
  {
    Object localObject3 = null;
    AppMethodBeat.i(286362);
    Object localObject1;
    if (this.xMw == null)
    {
      localObject1 = getIntent().getByteArrayExtra("KEY_FLOAT_BALL_INFO");
      if (localObject1 == null) {}
    }
    for (;;)
    {
      Object localObject4;
      int i;
      try
      {
        this.xMx.parseFrom((byte[])localObject1);
        this.xMy = true;
        localObject1 = this.xMx.key;
        localObject4 = (Context)this;
        Object localObject5 = (Activity)this;
        localObject6 = getWindow();
        p.j(localObject6, "window");
        localObject6 = ((Window)localObject6).getDecorView();
        p.j(localObject6, "window.decorView");
        this.xMw = new com.tencent.mm.plugin.finder.megavideo.multitask.a((Context)localObject4, (com.tencent.mm.plugin.multitask.a.a)new com.tencent.mm.plugin.finder.megavideo.multitask.b((Activity)localObject5, null, (View)localObject6));
        localObject4 = this.xMw;
        if (localObject4 != null)
        {
          if (localObject1 != null) {
            break label883;
          }
          localObject1 = n.zWF;
          localObject1 = n.dPD();
          ((com.tencent.mm.plugin.finder.megavideo.multitask.a)localObject4).I(22, (String)localObject1);
        }
        localObject1 = this.xMw;
        if (localObject1 == null) {
          continue;
        }
        localObject5 = ((com.tencent.mm.plugin.multitask.b.a)localObject1).FHd;
        if (localObject5 == null) {
          continue;
        }
        localObject1 = this.xMx.TFk;
        p.j(localObject1, "floatBallInfo.cacheNewVideoList");
        localObject6 = (FinderObject)kotlin.a.j.lp((List)localObject1);
        if (localObject6 == null) {
          continue;
        }
        localObject1 = ((FinderObject)localObject6).objectDesc;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((FinderObjectDesc)localObject1).description;
        if (!Util.isNullOrNil((String)localObject1)) {
          continue;
        }
        localObject1 = getContext();
        p.j(localObject1, "context");
        localObject4 = ((AppCompatActivity)localObject1).getResources();
        i = b.j.mega_video_post_ui_desc_tv_hint;
        Object localObject7 = (Context)getContext();
        localObject1 = ((FinderObject)localObject6).contact;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((FinderContact)localObject1).nickname;
        localObject1 = ((Resources)localObject4).getString(i, new Object[] { com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject7, (CharSequence)localObject1) });
        ((MultiTaskInfo)localObject5).fbc().title = ((String)localObject1);
        localObject7 = ((MultiTaskInfo)localObject5).fbc();
        localObject1 = ((FinderObject)localObject6).contact;
        if (localObject1 == null) {
          break label886;
        }
        localObject4 = ((FinderContact)localObject1).headUrl;
        localObject1 = localObject4;
        if (localObject4 == null) {
          break label886;
        }
        ((dar)localObject7).TIg = ((String)localObject1);
        localObject7 = ((MultiTaskInfo)localObject5).fbc();
        localObject1 = ((FinderObject)localObject6).contact;
        if (localObject1 == null) {
          break label893;
        }
        localObject4 = ((FinderContact)localObject1).nickname;
        localObject1 = localObject4;
        if (localObject4 == null) {
          break label893;
        }
        ((dar)localObject7).nickname = ((String)localObject1);
        localObject1 = ((FinderObject)localObject6).contact;
        if (localObject1 != null)
        {
          localObject4 = ((FinderContact)localObject1).authInfo;
          if (localObject4 != null)
          {
            if (((FinderAuthInfo)localObject4).authIconType <= 0) {
              continue;
            }
            i = 1;
            break label900;
            if (localObject1 != null)
            {
              ((MultiTaskInfo)localObject5).fbc().TIh = ((FinderAuthInfo)localObject1).authIconType;
              ((MultiTaskInfo)localObject5).fbc().TIf = ((FinderAuthInfo)localObject1).authIconUrl;
            }
          }
        }
        localObject1 = ((MultiTaskInfo)localObject5).fbc();
        localObject3 = ((FinderObject)localObject6).objectDesc;
        if (localObject3 == null) {
          continue;
        }
        localObject3 = ((FinderObjectDesc)localObject3).media;
        if (localObject3 == null) {
          continue;
        }
        localObject3 = (FinderMedia)kotlin.a.j.lp((List)localObject3);
        if (localObject3 == null) {
          continue;
        }
        i = ((FinderMedia)localObject3).videoDuration;
        ((dar)localObject1).KFK = i;
        localObject1 = x.aazN;
      }
      catch (Throwable localThrowable)
      {
        Object localObject6;
        Log.e("BaseMegaVideoUIC", "initFloatBallData", new Object[] { localThrowable });
        localObject2 = x.aazN;
        continue;
        localObject3 = (LinearLayout.LayoutParams)localObject3;
        ((LinearLayout.LayoutParams)localObject3).height = i;
        ((LinearLayout.LayoutParams)localObject3).width = i;
        ((LinearLayout.LayoutParams)localObject3).gravity = 48;
        ((WeImageView)localObject2).requestLayout();
        findViewById(b.f.full_actionbar).setPadding(0, getResources().getDimensionPixelSize(b.d.Edge_6_5_A), 0, 0);
        localObject2 = findViewById(b.f.back_button);
        i = getResources().getDimensionPixelOffset(b.d.Edge_2A);
        p.j(localObject2, "it");
        ((View)localObject2).setPadding(i, ((View)localObject2).getPaddingTop(), ((View)localObject2).getPaddingRight(), ((View)localObject2).getPaddingBottom());
        ((View)localObject2).setOnClickListener((View.OnClickListener)new b(this));
        this.xMt = new q.a((MMActivity)this);
        localObject2 = (MMActivity)this;
        localObject3 = this.xMt;
        if (localObject3 != null) {
          continue;
        }
        p.bGy("presenter");
        this.xMu = new q.b((MMActivity)localObject2, (q.a)localObject3);
        localObject2 = g.Xox;
        localObject2 = new FinderFloatBallDetailLoader(((aj)g.b((AppCompatActivity)this).i(aj.class)).ekY());
        localObject3 = getIntent();
        p.j(localObject3, "intent");
        ((FinderFloatBallDetailLoader)localObject2).initFromCache((Intent)localObject3);
        ((FinderFloatBallDetailLoader)localObject2).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new a((FinderFloatBallDetailLoader)localObject2, this));
        this.xMv = ((FinderFloatBallDetailLoader)localObject2);
        AppMethodBeat.o(286362);
        return;
      }
      if (localObject1 == null)
      {
        ((FinderFloatBallDetailUI)this).xMy = false;
        localObject1 = x.aazN;
      }
      localObject1 = (WeImageView)findViewById(b.f.backBtnIv);
      if (localObject1 != null)
      {
        ((WeImageView)localObject1).setImageResource(b.i.icons_filled_close2);
        ((WeImageView)localObject1).setIconColor(-1);
        i = getResources().getDimensionPixelSize(b.d.Edge_3_5_A);
        localObject3 = ((WeImageView)localObject1).getLayoutParams();
        if (localObject3 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(286362);
          throw ((Throwable)localObject1);
          localObject1 = null;
          continue;
          localObject1 = null;
          continue;
          localObject1 = ((FinderObject)localObject6).objectDesc;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObjectDesc)localObject1).description;
            continue;
          }
          localObject1 = null;
          continue;
          i = 0;
          break label900;
          i = 0;
          continue;
          localObject1 = null;
          continue;
          localObject1 = null;
          continue;
        }
      }
      label883:
      continue;
      label886:
      Object localObject2 = "";
      continue;
      label893:
      localObject2 = "";
      continue;
      label900:
      localObject2 = localObject3;
      if (i != 0) {
        localObject2 = localObject4;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(286367);
    super.onDestroy();
    AppMethodBeat.o(286367);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(286365);
    super.onPause();
    Object localObject = this.xMw;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.megavideo.multitask.a)localObject).aOj();
    }
    if ((!this.xMy) && (isFinishing()))
    {
      localObject = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
      localObject = a.a.dJH();
      q.a locala = this.xMt;
      if (locala == null) {
        p.bGy("presenter");
      }
      ((com.tencent.mm.plugin.finder.megavideo.floatball.a)localObject).Oe(locala.dtf());
    }
    AppMethodBeat.o(286365);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(286364);
    super.onResume();
    com.tencent.mm.plugin.finder.megavideo.multitask.a locala = this.xMw;
    if (locala != null)
    {
      locala.bNV();
      AppMethodBeat.o(286364);
      return;
    }
    AppMethodBeat.o(286364);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(286363);
    if (!this.xMy)
    {
      a.a locala = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
      a.a.dJH().dJF();
    }
    super.onStart();
    AppMethodBeat.o(286363);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(286366);
    if (!this.xMy)
    {
      a.a locala = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
      a.a.dJH().Oe(dvb().dtf());
    }
    super.onStop();
    AppMethodBeat.o(286366);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderFloatBallDetailUI$initOnCreate$3$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    a(FinderFloatBallDetailLoader paramFinderFloatBallDetailLoader, FinderFloatBallDetailUI paramFinderFloatBallDetailUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(285510);
      Object localObject = FinderFloatBallDetailUI.b(jdField_this).xvJ.getRecyclerView();
      if (localObject != null)
      {
        RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject).getLayoutManager();
        if (localLayoutManager == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(285510);
          throw ((Throwable)localObject);
        }
        ((RecyclerView)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(229771);
            this.xMB.au(jdField_this.xMz.getInitPos(), 0);
            final long l = jdField_this.xMA.getIntent().getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", 0L);
            if (l > 0L) {
              d.a(0L, (kotlin.g.a.a)new q(l) {});
            }
            AppMethodBeat.o(229771);
          }
        });
        AppMethodBeat.o(285510);
        return;
      }
      AppMethodBeat.o(285510);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderFloatBallDetailUI$initOnCreate$2$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderFloatBallDetailUI paramFinderFloatBallDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291572);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFloatBallDetailUI$initOnCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!FinderFloatBallDetailUI.a(this.xMA))
      {
        paramView = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
        a.a.dJH().dJE();
        ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).ld(false);
        f.cwA();
      }
      this.xMA.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFloatBallDetailUI$initOnCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291572);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFloatBallDetailUI
 * JD-Core Version:    0.7.0.1
 */
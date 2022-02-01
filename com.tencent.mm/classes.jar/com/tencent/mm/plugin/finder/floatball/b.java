package com.tencent.mm.plugin.finder.floatball;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.megavideo.floatball.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.ab;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.finder.video.v;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.be;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.g;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper;", "Lcom/tencent/mm/plugin/finder/floatball/BaseFinderMiniViewHelper;", "()V", "livingData", "Lcom/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper$SavedData;", "musicPlayer", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "playingView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "savedData", "addMiniView", "", "isPassive", "fromMessage", "addMusicMiniView", "", "mediaType", "", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "avatarUrl", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "targetTimeMs", "", "playSpeedRatio", "", "needPost", "clearAllCache", "enableMessageFloatBall", "gainAudioFocus", "generateCloseClickListener", "Landroid/view/View$OnClickListener;", "generateWindowClickListener", "initVideoView", "thumbPlayerProxy", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "innerAddMiniView", "internalSaveCurrVideo", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "enterFeedId", "isCurrentFloatBallUI", "activity", "Landroid/app/Activity;", "isHomeUIFloatBall", "lossAudioFocus", "onCreate", "floatBallType", "floatBallKey", "onDestroy", "playImageMusic", "playLive", "playVideo", "removeMiniView", "resetPlayers", "reuseVideoView", "saveCurrentVideo", "Landroidx/appcompat/app/AppCompatActivity;", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "bundle", "Landroid/os/Bundle;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "saveMiniViewBitmap", "bitmap", "Landroid/graphics/Bitmap;", "togglePlayer", "forcePause", "Companion", "SavedData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final b.a BtK;
  private static final kotlin.j<b> nqI;
  private static final e roL;
  private d BtL;
  private t BtM;
  private com.tencent.mm.plugin.finder.music.a BtN;
  public d BtO;
  
  static
  {
    AppMethodBeat.i(330444);
    BtK = new b.a((byte)0);
    nqI = kotlin.k.a(o.aiuF, (kotlin.g.a.a)b.c.BtP);
    roL = (e)new b();
    AppMethodBeat.o(330444);
  }
  
  private final void a(int paramInt, FeedData paramFeedData, String paramString, v paramv, bqj parambqj, long paramLong, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(330303);
    egj().a(new b..ExternalSyntheticLambda2(this), egl());
    egj().setPadding(0, 0, 0, 0);
    egj().setOutlineProvider((ViewOutlineProvider)new com.tencent.mm.live.core.mini.d(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 16)));
    egj().ayL(paramString);
    egj().getMusicPlayCtrlLayout().setOnClickListener(new b..ExternalSyntheticLambda1(this));
    switch (paramInt)
    {
    default: 
      egj().setMusicCtrlBtnStatus(false);
    }
    for (;;)
    {
      qg(paramBoolean1);
      AppMethodBeat.o(330303);
      return;
      if ((this.BtM == null) && (paramv != null))
      {
        a(paramv, paramFeedData, paramBoolean2);
        continue;
        if (this.BtM == null)
        {
          a(paramv, paramLong, paramFloat, paramBoolean2);
          continue;
          if (parambqj != null)
          {
            if (this.BtN == null) {
              a(parambqj, paramBoolean2);
            }
          }
          else {
            egj().setMusicCtrlBtnStatus(false);
          }
        }
      }
    }
  }
  
  private static final void a(View.OnClickListener paramOnClickListener, View paramView)
  {
    AppMethodBeat.i(370053);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramOnClickListener);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramOnClickListener, "$superClick");
    paramOnClickListener.onClick(paramView);
    paramOnClickListener = bb.FuK;
    bb.a(null, "button_close_float_frame", 1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(370053);
  }
  
  private final void a(RecyclerView paramRecyclerView, bui parambui, int paramInt, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(330365);
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject5 = new Rect();
    Object localObject1 = paramRecyclerView.getLayoutManager();
    Object localObject3;
    int j;
    int k;
    int i;
    if ((localObject1 instanceof LinearLayoutManager))
    {
      localObject1 = (LinearLayoutManager)localObject1;
      localObject3 = localObject4;
      if (localObject1 != null)
      {
        j = ((LinearLayoutManager)localObject1).Jv();
        k = ((LinearLayoutManager)localObject1).Jx();
        localObject3 = localObject4;
        if (j <= k)
        {
          i = 0;
          localObject1 = localObject2;
        }
      }
    }
    label1158:
    label1427:
    for (;;)
    {
      localObject2 = paramRecyclerView.fT(j);
      if (localObject2 != null)
      {
        localObject3 = ((RecyclerView.v)localObject2).caK;
        s.s(localObject3, "holder.itemView");
        ((View)localObject3).getLocalVisibleRect((Rect)localObject5);
        if (((Rect)localObject5).height() > i)
        {
          i = ((Rect)localObject5).height();
          if ((localObject2 instanceof com.tencent.mm.view.recyclerview.j)) {
            localObject1 = (com.tencent.mm.view.recyclerview.j)localObject2;
          }
        }
      }
      label535:
      label667:
      label691:
      label1203:
      label1462:
      for (;;)
      {
        if (j != k) {
          break label1474;
        }
        localObject3 = localObject1;
        if (localObject3 == null)
        {
          Log.e("FinderVideoPassive", "saveCurrentVideo: focusHolder is null");
          AppMethodBeat.o(330365);
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          continue;
        }
        if ((((RecyclerView.v)localObject3).caO != 9) && (((RecyclerView.v)localObject3).caO != 4) && (((RecyclerView.v)localObject3).caO != 2))
        {
          Log.e("FinderVideoPassive", s.X("saveCurrentVideo: focusHolder is normal view type, viewType = ", Integer.valueOf(((RecyclerView.v)localObject3).caO)));
          AppMethodBeat.o(330365);
          return;
        }
        this.BtL = new d();
        localObject1 = this.BtL;
        if (localObject1 != null) {
          ((d)localObject1).mediaType = ((RecyclerView.v)localObject3).caO;
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject3).CSA;
        if ((localObject1 instanceof BaseFinderFeed))
        {
          localObject1 = (BaseFinderFeed)localObject1;
          if (localObject1 != null) {
            break label583;
          }
          localObject1 = null;
          localObject2 = this.BtL;
          if (localObject2 != null) {
            ((d)localObject2).hJx = paramInt;
          }
          localObject2 = this.BtL;
          if (localObject2 != null)
          {
            localObject4 = new dnq();
            ((dnq)localObject4).aaUN = ((com.tencent.mm.view.recyclerview.j)localObject3).KJ();
            localObject5 = ah.aiuX;
            ((d)localObject2).BtU = ((dnq)localObject4);
          }
          if (paramBoolean) {
            break label691;
          }
          paramInt = 1;
          label379:
          if (paramLong == 0L) {
            break label1468;
          }
          Log.i("FinderVideoPassive", s.X("saveCurrentVideo: need to play enterFeedId=", Long.valueOf(paramLong)));
          paramInt = 1;
        }
        label953:
        label1468:
        for (;;)
        {
          if (paramInt != 0) {
            egr();
          }
          switch (((RecyclerView.v)localObject3).caO)
          {
          default: 
            label452:
            localObject1 = this.BtL;
            if (localObject1 == null)
            {
              localObject1 = null;
              label466:
              if (localObject1 != null)
              {
                localObject2 = this.BtL;
                if (localObject2 != null) {
                  break label1447;
                }
                paramLong = 0L;
                label485:
                ((dnq)localObject1).aaUS = paramLong;
              }
              localObject1 = this.BtL;
              if (localObject1 != null) {
                ((d)localObject1).Auc = parambui;
              }
              parambui = this.BtL;
              if (parambui != null)
              {
                paramRecyclerView = paramRecyclerView.getContext();
                if (!(paramRecyclerView instanceof Activity)) {
                  break label1457;
                }
                paramRecyclerView = (Activity)paramRecyclerView;
                if (paramRecyclerView == null) {
                  break label1462;
                }
                paramRecyclerView = paramRecyclerView.getIntent();
                if ((paramRecyclerView == null) || (paramRecyclerView.getIntExtra("FROM_SCENE_KEY", 2) != 6)) {
                  break label1462;
                }
              }
            }
            break;
          }
          for (paramBoolean = true;; paramBoolean = false)
          {
            parambui.BtT = paramBoolean;
            AppMethodBeat.o(330365);
            return;
            localObject1 = null;
            break;
            label583:
            localObject5 = this.BtL;
            if (localObject5 != null)
            {
              localObject2 = ((BaseFinderFeed)localObject1).contact;
              if (localObject2 != null) {
                break label667;
              }
              localObject2 = "";
            }
            for (;;)
            {
              ((d)localObject5).auZ((String)localObject2);
              localObject2 = this.BtL;
              if (localObject2 != null)
              {
                localObject4 = FeedData.Companion;
                ((d)localObject2).AWA = FeedData.a.l((BaseFinderFeed)localObject1);
              }
              Log.i("FinderVideoPassive", s.X("saveCurrentVideo: feedId = ", com.tencent.mm.ae.d.hF(((BaseFinderFeed)localObject1).bZA())));
              break;
              localObject4 = ((m)localObject2).amx();
              localObject2 = localObject4;
              if (localObject4 == null) {
                localObject2 = "";
              }
            }
            paramInt = 0;
            break label379;
            localObject2 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.j)localObject3).UH(e.e.finder_banner_video_layout);
            if (localObject2 == null) {
              break label452;
            }
            localObject3 = this.BtL;
            if (localObject3 != null)
            {
              localObject1 = ((FinderVideoLayout)localObject2).getVideoView();
              if (localObject1 == null)
              {
                localObject1 = null;
                label740:
                ((d)localObject3).BtQ = ((v)localObject1);
              }
            }
            else
            {
              if (paramInt == 0) {
                break label452;
              }
              localObject1 = this.BtL;
              if (localObject1 != null) {
                break label870;
              }
            }
            label870:
            for (localObject1 = null;; localObject1 = ((d)localObject1).BtQ)
            {
              Log.i("FinderVideoPassive", s.X("saveCurrentVideo: reuse live view, mediaInfo = ", localObject1));
              this.BtM = ((FinderVideoLayout)localObject2).getVideoView();
              localObject1 = ((FinderVideoLayout)localObject2).getVideoView();
              if (localObject1 != null) {
                ((t)localObject1).eLL();
              }
              localObject1 = com.tencent.mm.ui.component.k.aeZF;
              ((be)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(be.class)).av((kotlin.g.a.b)new b.h(this));
              ((FinderVideoLayout)localObject2).setVideoView(null);
              egj().setMusicCtrlBtnStatus(true);
              break;
              localObject1 = ((t)localObject1).getVideoMediaInfo();
              break label740;
            }
            localObject2 = (FinderVideoLayout)((com.tencent.mm.view.recyclerview.j)localObject3).UH(e.e.finder_banner_video_layout);
            if (localObject2 == null) {
              break label452;
            }
            localObject3 = this.BtL;
            if (localObject3 != null)
            {
              localObject1 = ((FinderVideoLayout)localObject2).getVideoView();
              if (localObject1 == null)
              {
                localObject1 = null;
                ((d)localObject3).BtQ = ((v)localObject1);
              }
            }
            else
            {
              localObject1 = ((FinderVideoLayout)localObject2).getVideoView();
              if (!(localObject1 instanceof FinderThumbPlayerProxy)) {
                break label1102;
              }
              localObject1 = (FinderThumbPlayerProxy)localObject1;
              if (localObject1 == null) {
                break label452;
              }
              localObject3 = this.BtL;
              if (localObject3 != null) {
                ((d)localObject3).BtR = ((FinderThumbPlayerProxy)localObject1).getCurrentPlayMs();
              }
              localObject3 = this.BtL;
              if (localObject3 != null) {
                break label1108;
              }
              paramLong = 0L;
              label993:
              if (paramLong >= ((FinderThumbPlayerProxy)localObject1).getVideoDurationMs())
              {
                localObject3 = this.BtL;
                if (localObject3 != null) {
                  ((d)localObject3).BtR = 0L;
                }
              }
              localObject3 = this.BtL;
              if (localObject3 != null) {
                ((d)localObject3).BtS = ((FinderThumbPlayerProxy)localObject1).getPlaySpeedRatio();
              }
              localObject3 = this.BtL;
              if (localObject3 != null) {
                if (((FinderThumbPlayerProxy)localObject1).isPlaying()) {
                  break label1118;
                }
              }
            }
            label1102:
            label1108:
            label1118:
            for (paramBoolean = true;; paramBoolean = false)
            {
              ((d)localObject3).isPaused = paramBoolean;
              if (paramInt == 0) {
                break;
              }
              a((FinderThumbPlayerProxy)localObject1);
              ((FinderVideoLayout)localObject2).setVideoView(null);
              break;
              localObject1 = ((t)localObject1).getVideoMediaInfo();
              break label924;
              localObject1 = null;
              break label953;
              paramLong = ((d)localObject3).BtR;
              break label993;
            }
            localObject4 = this.BtL;
            if (localObject4 != null)
            {
              if (localObject1 == null)
              {
                localObject2 = null;
                label1143:
                ((d)localObject4).musicInfo = ((bqj)localObject2);
              }
            }
            else
            {
              if (localObject1 != null) {
                break label1370;
              }
              localObject1 = null;
              if (localObject1 == null) {
                break label1378;
              }
              localObject2 = (FinderImgFeedMusicTag)((com.tencent.mm.view.recyclerview.j)localObject3).UH(e.e.bgm_iv);
              if (localObject2 == null) {
                break label452;
              }
              localObject1 = this.BtL;
              if (localObject1 != null)
              {
                if (((FinderImgFeedMusicTag)localObject2).isPlaying()) {
                  break label1380;
                }
                paramBoolean = true;
                ((d)localObject1).isPaused = paramBoolean;
              }
              localObject1 = this.BtL;
              if (localObject1 != null)
              {
                localObject4 = ((FinderImgFeedMusicTag)localObject2).getPlayer();
                if (localObject4 != null) {
                  break label1386;
                }
                paramLong = 0L;
                label1236:
                ((d)localObject1).BtR = paramLong;
              }
              if (paramInt == 0) {
                break label452;
              }
              localObject1 = this.BtL;
              if (localObject1 != null) {
                break label1396;
              }
              localObject1 = null;
              label1261:
              Log.i("FinderVideoPassive", s.X("saveCurrentVideo: reuse music player, feedId = ", localObject1));
              localObject1 = com.tencent.mm.ui.component.k.aeZF;
              localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject3).context;
              s.s(localObject1, "focusHolder!!.context");
              ((com.tencent.mm.plugin.finder.music.b)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.finder.music.b.class)).a((FinderImgFeedMusicTag)localObject2);
              this.BtN = ((FinderImgFeedMusicTag)localObject2).getPlayer();
              localObject1 = egj();
              localObject3 = ((FinderImgFeedMusicTag)localObject2).getPlayer();
              if (localObject3 != null) {
                break label1427;
              }
            }
            for (paramBoolean = false;; paramBoolean = ((com.tencent.mm.plugin.finder.music.a)localObject3).isPlaying())
            {
              ((FinderMegaVideoMiniView)localObject1).setMusicCtrlBtnStatus(paramBoolean);
              ((FinderImgFeedMusicTag)localObject2).setPlayer(null);
              break;
              localObject2 = ((BaseFinderFeed)localObject1).musicInfo;
              break label1143;
              label1370:
              localObject1 = ((BaseFinderFeed)localObject1).musicInfo;
              break label1158;
              label1378:
              break;
              label1380:
              paramBoolean = false;
              break label1203;
              label1386:
              paramLong = ((com.tencent.mm.plugin.finder.music.a)localObject4).eDP();
              break label1236;
              label1396:
              localObject1 = ((d)localObject1).AWA;
              if (localObject1 == null)
              {
                localObject1 = null;
                break label1261;
              }
              localObject1 = com.tencent.mm.ae.d.hF(((FeedData)localObject1).getFeedId());
              break label1261;
            }
            localObject1 = ((d)localObject1).BtU;
            break label466;
            paramLong = ((d)localObject2).BtR;
            break label485;
            paramRecyclerView = null;
            break label535;
          }
        }
      }
      label924:
      label1447:
      label1457:
      label1474:
      j += 1;
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(330375);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    boolean bool = paramb.qh(false);
    paramb = bb.FuK;
    if (bool) {}
    for (paramb = "button_pause_play_by_float_frame";; paramb = "button_goon_play_by_float_frame")
    {
      bb.a(null, paramb, 1);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(330375);
      return;
    }
  }
  
  private final void a(FinderThumbPlayerProxy paramFinderThumbPlayerProxy)
  {
    AppMethodBeat.i(330323);
    Log.i("FinderVideoPassive", s.X("reuseVideoView: thumbPlayerProxy = ", paramFinderThumbPlayerProxy));
    this.BtM = ((t)paramFinderThumbPlayerProxy);
    FinderThumbPlayerProxy.b(paramFinderThumbPlayerProxy);
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    ((be)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(be.class)).av((kotlin.g.a.b)new b.k(paramFinderThumbPlayerProxy));
    egj().setMusicCtrlBtnStatus(paramFinderThumbPlayerProxy.isPlaying());
    a(paramFinderThumbPlayerProxy, -1L, 1.0F, false);
    AppMethodBeat.o(330323);
  }
  
  private final void a(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, long paramLong, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(330330);
    paramFinderThumbPlayerProxy.setFullScreenEnjoy(true);
    paramFinderThumbPlayerProxy.setLifecycle((ab)new b.f(this, paramLong, paramFloat));
    paramFinderThumbPlayerProxy.setVideoViewCallback((i.b)new g(paramFinderThumbPlayerProxy, this));
    paramFinderThumbPlayerProxy.setOnlyAudio(true);
    paramFinderThumbPlayerProxy.setLoop(false);
    paramFinderThumbPlayerProxy.setVideoViewFocused(true);
    if (!paramBoolean)
    {
      d locald = this.BtL;
      if ((locald == null) || (locald.isPaused)) {
        break label110;
      }
    }
    label110:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((t)paramFinderThumbPlayerProxy).r(null);
      }
      AppMethodBeat.o(330330);
      return;
    }
  }
  
  private final void a(v paramv, long paramLong, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(330337);
    Log.i("FinderVideoPassive", "playVideo: mediaInfo = " + paramv + ", targetTimeMs = " + paramLong + ", playSpeedRatio = " + paramFloat + ", isPassive = " + paramBoolean);
    egr();
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    ((be)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(be.class)).av((kotlin.g.a.b)new b.l(paramv));
    localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    localObject = new FinderThumbPlayerProxy((Context)localObject);
    this.BtM = ((t)localObject);
    ((FinderThumbPlayerProxy)localObject).a(paramv, true);
    a((FinderThumbPlayerProxy)localObject, paramLong, paramFloat, paramBoolean);
    paramv = egj();
    int i;
    if (!paramBoolean)
    {
      localObject = this.BtO;
      if ((localObject != null) && (((d)localObject).isPaused == true))
      {
        i = 1;
        if (i != 0) {
          break label210;
        }
      }
    }
    label210:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramv.setMusicCtrlBtnStatus(paramBoolean);
      AppMethodBeat.o(330337);
      return;
      i = 0;
      break;
    }
  }
  
  private final void a(v paramv, FeedData paramFeedData, boolean paramBoolean)
  {
    AppMethodBeat.i(330316);
    Log.i("FinderVideoPassive", "playLive: mediaInfo = " + paramv + ", feedData = " + paramFeedData + ", isPassive = " + paramBoolean);
    egr();
    Object localObject = (g)h.ax(g.class);
    Context localContext = MMApplicationContext.getContext();
    s.s(localContext, "getContext()");
    this.BtM = ((g)localObject).eo(localContext);
    localObject = this.BtM;
    if (localObject != null) {
      ((t)localObject).a(paramv.ANK, false, paramFeedData);
    }
    paramv = this.BtM;
    if (paramv != null) {
      paramv.setVideoViewFocused(true);
    }
    paramv = this.BtM;
    if (paramv != null) {
      paramv.r(null);
    }
    paramv = egj();
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramv.setMusicCtrlBtnStatus(bool);
      if (paramBoolean) {
        com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new b.j(this));
      }
      AppMethodBeat.o(330316);
      return;
    }
  }
  
  private final void a(bqj parambqj, final boolean paramBoolean)
  {
    Object localObject1 = null;
    AppMethodBeat.i(330311);
    StringBuilder localStringBuilder = new StringBuilder("playImageMusic: feedId = ");
    Object localObject2 = this.BtO;
    if (localObject2 == null)
    {
      Log.i("FinderVideoPassive", localObject1 + ", isPassive = " + paramBoolean);
      egr();
      localObject1 = MMApplicationContext.getContext();
      s.s(localObject1, "getContext()");
      this.BtN = new com.tencent.mm.plugin.finder.music.a((Context)localObject1, parambqj);
      parambqj = this.BtN;
      if (parambqj != null) {
        parambqj.play();
      }
      parambqj = egj();
      if (paramBoolean) {
        break label166;
      }
    }
    label166:
    for (boolean bool = true;; bool = false)
    {
      parambqj.setMusicCtrlBtnStatus(bool);
      com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new i(this, paramBoolean));
      AppMethodBeat.o(330311);
      return;
      localObject2 = ((d)localObject2).AWA;
      if (localObject2 == null) {
        break;
      }
      localObject1 = com.tencent.mm.ae.d.hF(((FeedData)localObject2).getFeedId());
      break;
    }
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(370054);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramb, "this$0");
    localObject2 = new Intent();
    paramView = paramb.BtO;
    int i;
    boolean bool;
    label138:
    label160:
    label181:
    int j;
    label193:
    label232:
    label241:
    long l;
    label258:
    label321:
    label337:
    label383:
    Object localObject3;
    if (paramView == null)
    {
      i = 0;
      ((Intent)localObject2).putExtra("key_extra_info", "{\"floatWindowType\":1}");
      ((Intent)localObject2).putExtra("key_need_change_reporter", true);
      ((Intent)localObject2).putExtra("FLOAT_BALL_KEY", paramb.vjV.key);
      if (paramb.vjV.type != 20) {
        break label682;
      }
      bool = true;
      ((Intent)localObject2).putExtra("IS_PASSIVE_KEY", bool);
      paramView = paramb.BtO;
      if (paramView != null) {
        break label688;
      }
      paramView = null;
      if (!s.p(paramView, FinderHomeUI.class))
      {
        paramView = paramb.BtO;
        if (paramView != null) {
          break label696;
        }
        paramView = null;
        if (!s.p(paramView, FinderHomeAffinityUI.class)) {
          break label704;
        }
      }
      j = 1;
      if (j == 0)
      {
        paramView = paramb.BtO;
        if (paramView != null)
        {
          paramView = paramView.BtW;
          if (paramView != null) {
            ((Intent)localObject2).putExtras(paramView);
          }
        }
      }
      paramView = AppForegroundDelegate.aCe();
      if (paramView != null) {
        break label709;
      }
      paramView = null;
      if (paramView != null) {
        break label720;
      }
      localObject1 = MMApplicationContext.getContext();
      paramView = paramb.BtM;
      if (!(paramView instanceof FinderThumbPlayerProxy)) {
        break label729;
      }
      paramView = (FinderThumbPlayerProxy)paramView;
      if (paramView != null)
      {
        ((Intent)localObject2).putExtra("KEY_VIDEO_START_PLAY_TIME_MS", paramView.getCurrentPlayMs());
        ((Intent)localObject2).putExtra("KEY_VIDEO_PLAY_SPEED_RATIO", paramView.getPlaySpeedRatio());
      }
      paramView = paramb.BtN;
      if (paramView != null) {
        ((Intent)localObject2).putExtra("KEY_VIDEO_START_PLAY_TIME_MS", paramView.eDP());
      }
      paramView = paramb.BtM;
      if (paramView != null) {
        break label734;
      }
      paramView = null;
      if (paramView != null) {
        break label756;
      }
      paramView = paramb.BtN;
      if (paramView != null) {
        break label747;
      }
      bool = false;
      Log.i("FinderVideoPassive", s.X("generateWindowClickListener: isPlaying = ", Boolean.valueOf(bool)));
      if (!bool) {
        break label765;
      }
      paramView = paramb.BtO;
      if (paramView == null) {
        break label765;
      }
      paramView = paramView.AWA;
      if (paramView == null) {
        break label765;
      }
      l = paramView.getFeedId();
      ((Intent)localObject2).putExtra("KEY_ENTER_PLAYING_FEED_ID", l);
      ((cn)h.az(cn.class)).fillContextIdToIntent(8, 6, i, (Intent)localObject2);
      if (j == 0) {
        break label807;
      }
      paramView = paramb.BtO;
      if (paramView != null)
      {
        paramView = paramView.Auc;
        if (paramView != null) {
          localObject3 = z.FrZ;
        }
      }
      switch (z.SE(paramView.AJo))
      {
      case 2: 
      default: 
        paramView = "";
        label484:
        if (((CharSequence)paramView).length() > 0)
        {
          i = 1;
          label498:
          if (i != 0) {
            ((Intent)localObject2).putExtra(paramView, true);
          }
          ((Intent)localObject2).putExtra("KEY_FORCE_NOT_REFRESH_FIRST_TIME", true);
          paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
          s.s(localObject1, "context");
          paramView = paramb.BtO;
          if ((paramView == null) || (paramView.BtT != true)) {
            break label797;
          }
          i = 1;
          if (i == 0) {
            break label802;
          }
          i = 6;
          com.tencent.mm.plugin.finder.utils.a.a((Context)localObject1, (Intent)localObject2, i, false);
        }
        label551:
        label558:
        break;
      }
    }
    label682:
    label688:
    label696:
    label704:
    label709:
    label720:
    label729:
    label734:
    label747:
    label756:
    label765:
    do
    {
      do
      {
        paramb.vjV.vjI.opType = 1;
        ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).m(paramb.vjV);
        paramView = bb.FuK;
        bb.a(null, "button_goback_finder_from_float_frame", 1);
        Log.i("FinderVideoPassive", "startFinderFeed key: %s", new Object[] { paramb.vjV.key });
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(370054);
        return;
        paramView = paramView.Auc;
        if (paramView == null)
        {
          i = 0;
          break;
        }
        i = paramView.AJo;
        break;
        bool = false;
        break label138;
        paramView = paramView.BtV;
        break label160;
        paramView = paramView.BtV;
        break label181;
        j = 0;
        break label193;
        paramView = (Activity)paramView.get();
        break label232;
        localObject1 = (Context)paramView;
        break label241;
        paramView = null;
        break label258;
        paramView = Boolean.valueOf(paramView.isPlaying());
        break label321;
        bool = paramView.isPlaying();
        break label337;
        bool = paramView.booleanValue();
        break label337;
        l = 0L;
        break label383;
        paramView = "KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB";
        break label484;
        paramView = "KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB";
        break label484;
        paramView = "KEY_FINDER_POST_FINISH_JUMP_HOT_TAB";
        break label484;
        i = 0;
        break label498;
        i = 0;
        break label551;
        i = 2;
        break label558;
        paramView = paramb.BtO;
        if (paramView != null)
        {
          paramView = paramView.BtU;
          if (paramView != null)
          {
            localObject3 = paramView.aaUQ;
            s.s(localObject3, "it.cacheNewVideoList");
            Object localObject4 = (Iterable)localObject3;
            localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
            localObject4 = ((Iterable)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = (FinderObject)((Iterator)localObject4).next();
              Object localObject6 = FinderItem.Companion;
              s.s(localObject5, "feedObject");
              localObject5 = FinderItem.a.e((FinderObject)localObject5, 1);
              localObject6 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
              ((Collection)localObject3).add(d.a.a((FinderItem)localObject5));
            }
            localObject3 = (List)localObject3;
            localObject4 = av.GiL;
            av.a(paramView.aaUN, (List)localObject3, paramView.lastBuffer, (Intent)localObject2);
          }
        }
        paramView = paramb.BtO;
      } while (paramView == null);
      paramView = paramView.BtV;
    } while (paramView == null);
    label797:
    label802:
    label807:
    ((Intent)localObject2).setClass((Context)localObject1, paramView);
    if (!(localObject1 instanceof Activity)) {}
    for (paramView = (View)localObject2;; paramView = null)
    {
      if (paramView != null) {
        paramView.addFlags(268435456);
      }
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramView.aYi(), "com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper", "generateWindowClickListener$lambda-35", "(Lcom/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper", "generateWindowClickListener$lambda-35", "(Lcom/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break;
    }
  }
  
  private final void egr()
  {
    AppMethodBeat.i(330342);
    Log.i("FinderVideoPassive", "resetPlayers: playingView = " + this.BtM + ", musicPlayer = " + this.BtN);
    t localt = this.BtM;
    if (localt != null) {
      if (!(localt instanceof FinderThumbPlayerProxy)) {
        break label126;
      }
    }
    label126:
    for (Object localObject = (FinderThumbPlayerProxy)localt;; localObject = null)
    {
      if (localObject != null)
      {
        ((FinderThumbPlayerProxy)localObject).setVideoViewCallback(null);
        ((FinderThumbPlayerProxy)localObject).setLifecycle(null);
      }
      localt.onUIDestroy();
      localt.onRelease();
      this.BtM = null;
      localObject = this.BtN;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.music.a)localObject).stop();
        ((com.tencent.mm.plugin.finder.music.a)localObject).release();
      }
      this.BtN = null;
      AppMethodBeat.o(330342);
      return;
    }
  }
  
  private final void i(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(330295);
    Log.i("FinderVideoPassive", "innerAddMiniView: isPassive = " + paramBoolean1 + ", fromMessage = " + paramBoolean3 + ", needPost = " + paramBoolean2);
    this.vjV.type = 32;
    this.vjV.cIh = 32;
    this.BtO = this.BtL;
    Object localObject1 = this.BtO;
    Object localObject2;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        Log.e("FinderVideoPassive", "innerAddMiniView: feedData is null");
      }
      localObject1 = this.BtO;
      if (localObject1 != null)
      {
        localObject1 = ((d)localObject1).Auc;
        if (localObject1 != null)
        {
          if (paramBoolean3)
          {
            localObject2 = bb.FuK;
            bb.a((bui)localObject1, "wechat_push_card", 1);
          }
          localObject2 = this.vjV.vjI;
          switch (((bui)localObject1).AJo)
          {
          case 19: 
          default: 
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      ((BallReportInfo)localObject2).vjN = i;
      this.vjV.vjI.opType = 16;
      AppMethodBeat.o(330295);
      return;
      FeedData localFeedData = ((d)localObject1).AWA;
      if (localFeedData == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = this.BtO;
      label249:
      Object localObject3;
      label265:
      label279:
      label293:
      d locald;
      long l;
      if (localObject1 == null)
      {
        i = 0;
        localObject1 = this.BtO;
        if (localObject1 != null) {
          break label359;
        }
        localObject1 = "";
        localObject2 = this.BtO;
        if (localObject2 != null) {
          break label369;
        }
        localObject2 = null;
        localObject3 = this.BtO;
        if (localObject3 != null) {
          break label379;
        }
        localObject3 = null;
        locald = this.BtO;
        if (locald != null) {
          break label389;
        }
        l = 0L;
        label307:
        locald = this.BtO;
        if (locald != null) {
          break label399;
        }
      }
      label389:
      label399:
      for (float f = 1.0F;; f = locald.BtS)
      {
        a(i, localFeedData, (String)localObject1, (v)localObject2, (bqj)localObject3, l, f, paramBoolean2, paramBoolean1);
        localObject1 = ah.aiuX;
        break;
        i = ((d)localObject1).mediaType;
        break label249;
        label359:
        localObject1 = ((d)localObject1).nVM;
        break label265;
        label369:
        localObject2 = ((d)localObject2).BtQ;
        break label279;
        label379:
        localObject3 = ((d)localObject3).musicInfo;
        break label293;
        l = locald.BtR;
        break label307;
      }
      i = 15;
      continue;
      i = 16;
      continue;
      i = 17;
    }
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(330462);
    super.J(paramInt, paramString);
    paramInt = e.g.float_ball_state_finder;
    if ((this.vjV != null) && (this.vjV.tus != paramInt))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateIconResId, iconResId:%s", new Object[] { Integer.valueOf(paramInt) });
      this.vjV.tus = paramInt;
      cYr();
    }
    cYv().mUU = 19;
    AppMethodBeat.o(330462);
  }
  
  public final boolean W(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(330478);
    Object localObject1 = MMApplicationContext.getContext();
    int i;
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      bool = true;
      if (!com.tencent.mm.n.a.p((Context)localObject1, bool))
      {
        localObject1 = MMApplicationContext.getContext();
        if ((paramBoolean1) || (paramBoolean2)) {
          break label179;
        }
        i = 1;
        label47:
        if (!com.tencent.mm.n.a.aTe()) {
          break label184;
        }
        if (i != 0) {
          aa.makeText((Context)localObject1, ((Context)localObject1).getString(c.h.multitalk_in_toast), 0).show();
        }
        i = 1;
        label76:
        if (i == 0)
        {
          localObject1 = MMApplicationContext.getContext();
          if ((paramBoolean1) || (paramBoolean2)) {
            break label189;
          }
          bool = true;
          label96:
          if ((!com.tencent.mm.n.a.s((Context)localObject1, bool)) && (!com.tencent.mm.n.a.aTh()) && (!com.tencent.mm.n.a.aTi()))
          {
            localObject1 = MMApplicationContext.getContext();
            if ((paramBoolean1) || (paramBoolean2)) {
              break label195;
            }
          }
        }
      }
    }
    label179:
    label184:
    label189:
    label195:
    for (boolean bool = true;; bool = false)
    {
      if ((!com.tencent.mm.n.a.r((Context)localObject1, bool)) && ((!paramBoolean1) || (!com.tencent.mm.n.a.q(null, false)))) {
        break label201;
      }
      Log.w("FinderVideoPassive", "addVideoFloatBall: failed to add video float ball");
      AppMethodBeat.o(330478);
      return false;
      bool = false;
      break;
      i = 0;
      break label47;
      i = 0;
      break label76;
      bool = false;
      break label96;
    }
    label201:
    final ah.a locala = new ah.a();
    if (!paramBoolean1)
    {
      localObject1 = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
      locala.aiwY = a.a.eCH().ego();
      if (com.tencent.mm.n.a.q(null, false))
      {
        localObject1 = h.ax(g.class);
        s.s(localObject1, "service(IFinderCommonLiveService::class.java)");
        ((g)localObject1).bUr();
        locala.aiwY = true;
      }
    }
    Object localObject2;
    if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
    {
      Log.w("FinderVideoPassive", "addVideoFloatBall: showVideoTalking, permission denied");
      localObject1 = AppForegroundDelegate.aCe();
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = AppForegroundDelegate.heY.aCb();
          if (localObject1 != null) {
            break label369;
          }
          localObject2 = null;
        }
        label326:
        if (localObject2 != null) {
          break label382;
        }
        localObject1 = null;
        label334:
        if (localObject1 == null) {
          Log.e("FinderVideoPassive", "addVideoFloatBall: showVideoTalking, request permission dialog show failed, top activity is null");
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(330478);
      return true;
      localObject1 = (Activity)((WeakReference)localObject1).get();
      break;
      label369:
      localObject2 = (Activity)((WeakReference)localObject1).get();
      break label326;
      label382:
      RequestFloatWindowPermissionDialog.a((Context)localObject2, ((Activity)localObject2).getString(e.h.mega_video_float_permission_alert_content), (RequestFloatWindowPermissionDialog.a)new e(this, paramBoolean1, locala, paramBoolean2), false, com.tencent.mm.bq.a.aQB());
      localObject1 = ah.aiuX;
      break label334;
      i(paramBoolean1, locala.aiwY, paramBoolean2);
    }
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, List<? extends cc> paramList, com.tencent.mm.bx.b paramb, Bundle paramBundle, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(330511);
    s.u(paramAppCompatActivity, "activity");
    this.BtL = null;
    Object localObject1 = (RefreshLoadMoreLayout)paramAppCompatActivity.findViewById(e.e.rl_layout);
    if (localObject1 != null)
    {
      RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
      if (localRecyclerView != null)
      {
        label75:
        label81:
        int i;
        if (paramList == null)
        {
          paramList = localRecyclerView.getAdapter();
          if ((paramList instanceof WxRecyclerAdapter))
          {
            paramList = (WxRecyclerAdapter)paramList;
            if (paramList != null) {
              break label141;
            }
            paramList = null;
            if (paramList != null) {
              break label155;
            }
            paramList = null;
            localObject1 = (Collection)paramList;
            if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
              break label228;
            }
            i = 1;
            label105:
            if (i == 0) {
              break label247;
            }
            if (paramList != null) {
              break label234;
            }
          }
        }
        label141:
        label155:
        label228:
        label234:
        for (paramAppCompatActivity = null;; paramAppCompatActivity = Integer.valueOf(paramList.size()))
        {
          Log.e("FinderVideoPassive", s.X("saveNormalUICurrVideo: data.size = ", paramAppCompatActivity));
          AppMethodBeat.o(330511);
          return;
          paramList = null;
          break;
          paramList = (List)paramList.data;
          break label75;
          break label75;
          localObject1 = (Iterable)paramList;
          paramList = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            if ((localObject2 instanceof BaseFinderFeed)) {
              paramList.add(localObject2);
            }
          }
          paramList = (List)paramList;
          break label81;
          i = 0;
          break label105;
        }
        label247:
        localObject1 = as.GSQ;
        localObject1 = as.a.hu((Context)paramAppCompatActivity);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
        {
          a(localRecyclerView, (bui)localObject1, 0, paramBoolean, paramLong);
          localObject1 = this.BtL;
          if (localObject1 == null) {
            break label408;
          }
          localObject1 = ((d)localObject1).BtU;
          if (localObject1 == null) {
            break label408;
          }
          ((dnq)localObject1).lastBuffer = paramb;
          paramb = ((dnq)localObject1).aaUQ;
          localObject1 = (Iterable)paramList;
          paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramList.add(((BaseFinderFeed)((Iterator)localObject1).next()).feedObject.getFeedObject());
          }
        }
        paramb.addAll((Collection)paramList);
        label408:
        paramList = this.BtL;
        if (paramList != null) {
          paramList.BtV = paramAppCompatActivity.getClass();
        }
        paramAppCompatActivity = this.BtL;
        if (paramAppCompatActivity != null) {
          paramAppCompatActivity.BtW = paramBundle;
        }
      }
    }
    AppMethodBeat.o(330511);
  }
  
  public final void a(FinderHomeTabFragment paramFinderHomeTabFragment, bui parambui, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(330520);
    s.u(paramFinderHomeTabFragment, "fragment");
    this.BtL = null;
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXG().bmg()).intValue() != 1)
    {
      Log.i("FinderVideoPassive", "saveCurrentVideo: FINDER_PASSIVE_VIDEO_SWITCH is close");
      AppMethodBeat.o(330520);
      return;
    }
    if (!paramFinderHomeTabFragment.isVisible())
    {
      AppMethodBeat.o(330520);
      return;
    }
    localObject = paramFinderHomeTabFragment.rootView;
    if (localObject != null)
    {
      localObject = (RefreshLoadMoreLayout)((View)localObject).findViewById(e.e.rl_layout);
      if (localObject != null)
      {
        localObject = ((RefreshLoadMoreLayout)localObject).getRecyclerView();
        if (localObject != null)
        {
          a((RecyclerView)localObject, parambui, paramFinderHomeTabFragment.hJx, paramBoolean, paramLong);
          localObject = this.BtL;
          if (localObject != null)
          {
            paramFinderHomeTabFragment = paramFinderHomeTabFragment.getActivity();
            if (paramFinderHomeTabFragment != null) {
              break label169;
            }
          }
        }
      }
    }
    label169:
    for (paramFinderHomeTabFragment = null;; paramFinderHomeTabFragment = paramFinderHomeTabFragment.getClass())
    {
      parambui = paramFinderHomeTabFragment;
      if (paramFinderHomeTabFragment == null) {
        parambui = FinderHomeAffinityUI.class;
      }
      ((d)localObject).BtV = parambui;
      AppMethodBeat.o(330520);
      return;
    }
  }
  
  public final boolean ax(Activity paramActivity)
  {
    AppMethodBeat.i(330500);
    s.u(paramActivity, "activity");
    Class localClass = paramActivity.getClass();
    paramActivity = this.BtO;
    if (paramActivity == null) {}
    for (paramActivity = null;; paramActivity = paramActivity.BtV)
    {
      boolean bool = s.p(localClass, paramActivity);
      AppMethodBeat.o(330500);
      return bool;
    }
  }
  
  public final boolean cop()
  {
    return true;
  }
  
  public final View.OnClickListener egk()
  {
    AppMethodBeat.i(370072);
    b..ExternalSyntheticLambda2 localExternalSyntheticLambda2 = new b..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(370072);
    return localExternalSyntheticLambda2;
  }
  
  public final View.OnClickListener egl()
  {
    AppMethodBeat.i(370071);
    b..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = new b..ExternalSyntheticLambda0(super.egl());
    AppMethodBeat.o(370071);
    return localExternalSyntheticLambda0;
  }
  
  public final void egm()
  {
    AppMethodBeat.i(330534);
    Object localObject = this.BtM;
    if (localObject != null) {
      ((t)localObject).setMute(false);
    }
    localObject = this.BtN;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.music.a)localObject).setMute(false);
    }
    AppMethodBeat.o(330534);
  }
  
  public final void egn()
  {
    AppMethodBeat.i(330544);
    Object localObject = this.BtM;
    if (localObject != null) {
      ((t)localObject).setMute(true);
    }
    localObject = this.BtN;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.music.a)localObject).setMute(true);
    }
    AppMethodBeat.o(330544);
  }
  
  public final boolean ego()
  {
    AppMethodBeat.i(330496);
    egr();
    this.BtL = null;
    this.BtO = null;
    boolean bool = super.ego();
    AppMethodBeat.o(330496);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(330526);
    Object localObject1 = this.BtM;
    if ((localObject1 instanceof View))
    {
      localObject1 = (View)localObject1;
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).getParent();
        if (!(localObject2 instanceof ViewGroup)) {
          break label69;
        }
      }
    }
    label69:
    for (Object localObject2 = (ViewGroup)localObject2;; localObject2 = null)
    {
      if (localObject2 != null) {
        ((ViewGroup)localObject2).removeView((View)localObject1);
      }
      super.onDestroy();
      AppMethodBeat.o(330526);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final boolean qh(boolean paramBoolean)
  {
    AppMethodBeat.i(370061);
    Object localObject = this.BtM;
    boolean bool1;
    if (localObject == null)
    {
      bool1 = false;
      localObject = this.BtN;
      if (localObject != null) {
        break label139;
      }
    }
    label139:
    for (boolean bool2 = false;; bool2 = ((com.tencent.mm.plugin.finder.music.a)localObject).isPlaying())
    {
      bool1 |= bool2;
      Log.i("FinderVideoPassive", "togglePlayer: isPlaying = " + bool1 + ", forcePause = " + paramBoolean);
      if ((!bool1) && (!paramBoolean)) {
        break label148;
      }
      localObject = this.BtM;
      if (localObject != null) {
        ((t)localObject).pause();
      }
      localObject = this.BtN;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.music.a)localObject).pause();
      }
      egj().setMusicCtrlBtnStatus(false);
      AppMethodBeat.o(370061);
      return bool1;
      bool1 = ((t)localObject).isPlaying();
      break;
    }
    label148:
    if ((this.BtM != null) || (this.BtN != null))
    {
      localObject = this.BtM;
      if (localObject != null) {
        ((t)localObject).r(null);
      }
      localObject = this.BtN;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.music.a)localObject).play();
      }
      egm();
    }
    for (;;)
    {
      egj().setMusicCtrlBtnStatus(true);
      break;
      aa.makeText(MMApplicationContext.getContext(), e.h.mini_view_no_music_hint, 0).show();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper$Companion$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onAddMessageFloatBall", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoClicked", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends f
  {
    public final void b(BallInfo paramBallInfo) {}
    
    public final boolean coy()
    {
      AppMethodBeat.i(330243);
      Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXG().bmg()).intValue() != 1)
      {
        Log.i("FinderVideoPassive", "addMiniView: FINDER_PASSIVE_VIDEO_SWITCH is close");
        AppMethodBeat.o(330243);
        return true;
      }
      localObject = b.BtK;
      b.d(b.a.egt());
      localObject = b.BtK;
      b.a.egt().W(true, true);
      AppMethodBeat.o(330243);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper$SavedData;", "", "(Lcom/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper;)V", "avatarUrl", "", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "currPlayTimeMs", "", "getCurrPlayTimeMs", "()J", "setCurrPlayTimeMs", "(J)V", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getFeedData", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeedData", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "floatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "getFloatBallInfo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "setFloatBallInfo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;)V", "isFromShare", "", "()Z", "setFromShare", "(Z)V", "isPaused", "setPaused", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "mediaType", "", "getMediaType", "()I", "setMediaType", "(I)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "playRatio", "", "getPlayRatio", "()F", "setPlayRatio", "(F)V", "saveBitmap", "Landroid/graphics/Bitmap;", "getSaveBitmap", "()Landroid/graphics/Bitmap;", "setSaveBitmap", "(Landroid/graphics/Bitmap;)V", "savedBundle", "Landroid/os/Bundle;", "getSavedBundle", "()Landroid/os/Bundle;", "setSavedBundle", "(Landroid/os/Bundle;)V", "tabType", "getTabType", "setTabType", "targetUI", "Ljava/lang/Class;", "getTargetUI", "()Ljava/lang/Class;", "setTargetUI", "(Ljava/lang/Class;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
  {
    FeedData AWA;
    bui Auc;
    v BtQ;
    long BtR;
    float BtS;
    boolean BtT;
    dnq BtU;
    public Class<?> BtV;
    Bundle BtW;
    int hJx;
    boolean isPaused;
    int mediaType;
    bqj musicInfo;
    String nVM;
    
    public d()
    {
      AppMethodBeat.i(330239);
      this.BtS = 1.0F;
      this.nVM = "";
      AppMethodBeat.o(330239);
    }
    
    public final void auZ(String paramString)
    {
      AppMethodBeat.i(330250);
      s.u(paramString, "<set-?>");
      this.nVM = paramString;
      AppMethodBeat.o(330250);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper$addMiniView$1$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements RequestFloatWindowPermissionDialog.a
  {
    e(b paramb, boolean paramBoolean1, ah.a parama, boolean paramBoolean2) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(330227);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      b.a(this.BtX, paramBoolean1, locala.aiwY, paramBoolean2);
      AppMethodBeat.o(330227);
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(330236);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      AppMethodBeat.o(330236);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(330245);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      AppMethodBeat.o(330245);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper$initVideoView$2", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onSeekComplete", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements i.b
  {
    g(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, b paramb) {}
    
    public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
    
    public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
    
    public final void el(String paramString1, String paramString2) {}
    
    public final void em(String paramString1, String paramString2)
    {
      AppMethodBeat.i(330288);
      this.Bue.stop();
      jdField_this.egj().setMusicCtrlBtnStatus(false);
      AppMethodBeat.o(330288);
    }
    
    public final void en(String paramString1, String paramString2) {}
    
    public final void eo(String paramString1, String paramString2) {}
    
    public final void ep(String paramString1, String paramString2) {}
    
    public final void eq(String paramString1, String paramString2) {}
    
    public final void gE(String paramString1, String paramString2) {}
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.floatball.b
 * JD-Core Version:    0.7.0.1
 */
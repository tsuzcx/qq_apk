package com.tencent.mm.plugin.finder.music;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.post.g;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.c;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.h;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.finder.video.FinderVideoViewForTopic;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.k;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/music/IFinderFollowTopicHeaderView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioPath", "", "getAudioPath", "()Ljava/lang/String;", "setAudioPath", "(Ljava/lang/String;)V", "bgmPlayBtn", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "getBgmPlayBtn", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "setBgmPlayBtn", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;)V", "copyrightRestrictionListener", "Landroid/view/View$OnClickListener;", "currentListener", "getCurrentListener", "()Landroid/view/View$OnClickListener;", "setCurrentListener", "(Landroid/view/View$OnClickListener;)V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "downloadFinish", "", "getDownloadFinish", "()Z", "setDownloadFinish", "(Z)V", "filePath", "getFilePath", "setFilePath", "finderBgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getFinderBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "setFinderBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;)V", "isFirstClickPlay", "setFirstClickPlay", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "setMedia", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "originFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getOriginFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setOriginFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "pauseMusicListener", "pauseVideoListener", "playMusicListener", "playVideoListener", "preCheckHelper", "Lcom/tencent/mm/plugin/finder/post/PostPreCheckUIC;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "tabType", "getTabType", "()I", "setTabType", "(I)V", "type", "getType", "setType", "videoView", "Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "getVideoView", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "setVideoView", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;)V", "bindOriginFeed", "", "feed", "bgmInfo", "flag", "checkVideoDataAvailable", "mediaId", "offset", "length", "extractAudioTrack", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "initView", "isCopyrightRestriction", "isFileLegal", "path", "onDetachedFromWindow", "onDettach", "onFinishDownload", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onFollowBtnClick", "onMoovReadyDownload", "total", "moovFirstDownloaded", "onProgressDownload", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStartDownload", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "result", "onWindowFocusChanged", "hasWindowFocus", "showBottomSheet", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFollowTopicHeaderView
  extends ConstraintLayout
  implements com.tencent.mm.am.h, d, com.tencent.mm.plugin.finder.video.aa
{
  public static final FinderFollowTopicHeaderView.a EEr;
  private bys AwM;
  private g AwN;
  private View.OnClickListener EEA;
  private View.OnClickListener EEB;
  private View.OnClickListener EEC;
  private View.OnClickListener EED;
  private View.OnClickListener EEE;
  private View.OnClickListener EEF;
  private FinderVideoViewForTopic EEs;
  private FinderItem EEt;
  private bxt EEu;
  private com.tencent.mm.plugin.finder.loader.v EEv;
  private boolean EEw;
  private AudioCacheInfo EEx;
  private FinderImgFeedMusicTag EEy;
  private String EEz;
  private String filePath;
  private int hJx;
  private volatile boolean hsO;
  private w rYw;
  private int type;
  
  static
  {
    AppMethodBeat.i(331200);
    EEr = new FinderFollowTopicHeaderView.a((byte)0);
    AppMethodBeat.o(331200);
  }
  
  public FinderFollowTopicHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(330938);
    this.EEw = true;
    this.filePath = "";
    this.EEz = "";
    this.EEB = new FinderFollowTopicHeaderView..ExternalSyntheticLambda5(this);
    this.EEC = new FinderFollowTopicHeaderView..ExternalSyntheticLambda3(this);
    this.EED = new FinderFollowTopicHeaderView..ExternalSyntheticLambda4(this);
    this.EEE = new FinderFollowTopicHeaderView..ExternalSyntheticLambda2(this);
    this.EEF = new FinderFollowTopicHeaderView..ExternalSyntheticLambda0(this);
    ci(paramContext);
    AppMethodBeat.o(330938);
  }
  
  public FinderFollowTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(330948);
    this.EEw = true;
    this.filePath = "";
    this.EEz = "";
    this.EEB = new FinderFollowTopicHeaderView..ExternalSyntheticLambda5(this);
    this.EEC = new FinderFollowTopicHeaderView..ExternalSyntheticLambda3(this);
    this.EED = new FinderFollowTopicHeaderView..ExternalSyntheticLambda4(this);
    this.EEE = new FinderFollowTopicHeaderView..ExternalSyntheticLambda2(this);
    this.EEF = new FinderFollowTopicHeaderView..ExternalSyntheticLambda0(this);
    ci(paramContext);
    AppMethodBeat.o(330948);
  }
  
  public FinderFollowTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(330962);
    this.EEw = true;
    this.filePath = "";
    this.EEz = "";
    this.EEB = new FinderFollowTopicHeaderView..ExternalSyntheticLambda5(this);
    this.EEC = new FinderFollowTopicHeaderView..ExternalSyntheticLambda3(this);
    this.EED = new FinderFollowTopicHeaderView..ExternalSyntheticLambda4(this);
    this.EEE = new FinderFollowTopicHeaderView..ExternalSyntheticLambda2(this);
    this.EEF = new FinderFollowTopicHeaderView..ExternalSyntheticLambda0(this);
    ci(paramContext);
    AppMethodBeat.o(330962);
  }
  
  private static boolean Qv(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  private final void a(x paramx)
  {
    AppMethodBeat.i(331014);
    Object localObject1 = this.EEu;
    if (localObject1 != null)
    {
      Object localObject2 = (CharSequence)((bxt)localObject1).audioTrackUrl;
      int i;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
        i = 1;
      }
      while (i != 0)
      {
        localObject2 = bm.GlZ;
        localObject2 = ((bxt)localObject1).groupId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = kotlin.g.b.s.X("emptyid_", Long.valueOf(System.currentTimeMillis()));
        }
        kotlin.g.b.s.s(localObject1, "it.groupId?:\"emptyid_${S…tem.currentTimeMillis()}\"");
        localObject1 = bm.aCg((String)localObject1);
        if (ayT((String)localObject1))
        {
          Log.i("FinderFollowTopicHeaderView", "audio length = " + (float)com.tencent.mm.pluginsdk.res.downloader.b.a.jK((String)localObject1) / 1024.0F / 1024.0F + 'M');
          setAudioPath((String)localObject1);
          AppMethodBeat.o(331014);
          return;
          i = 0;
        }
        else
        {
          Log.i("FinderFollowTopicHeaderView", "audio:" + (String)localObject1 + " track no exist");
          localObject2 = com.tencent.mm.plugin.vlog.remux.a.UdR;
          if (com.tencent.mm.plugin.vlog.remux.a.nr(paramx.getPath(), (String)localObject1))
          {
            Log.i("FinderFollowTopicHeaderView", "[SimpleAudioExtractor] true");
            Log.i("FinderFollowTopicHeaderView", "audio length = " + (float)com.tencent.mm.pluginsdk.res.downloader.b.a.jK((String)localObject1) / 1024.0F / 1024.0F + 'M');
            paramx = MultiMediaVideoChecker.ObB;
            if (localObject1 == null) {}
            for (paramx = "";; paramx = (x)localObject1)
            {
              paramx = MultiMediaVideoChecker.aTH(paramx);
              if ((paramx != null) && (paramx.duration != 0L)) {
                break;
              }
              Log.i("FinderFollowTopicHeaderView", "no audio track");
              setDownloadFinish(false);
              paramx = findViewById(l.e.follow_btn);
              if (paramx == null) {
                break label396;
              }
              paramx.setOnClickListener(this.EEF);
              AppMethodBeat.o(331014);
              return;
            }
            setAudioPath((String)localObject1);
            AppMethodBeat.o(331014);
            return;
          }
          Log.i("FinderFollowTopicHeaderView", "[SimpleAudioExtractor] false");
          Toast.makeText(getContext(), l.i.finder_follow_header_music_err, 0).show();
          setDownloadFinish(false);
          paramx = findViewById(l.e.follow_btn);
          if (paramx != null) {
            paramx.setOnClickListener(this.EEF);
          }
          com.tencent.mm.plugin.report.service.h.OAn.p(1530L, 0L, 1L);
        }
      }
    }
    label396:
    AppMethodBeat.o(331014);
  }
  
  private static final void a(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, int paramInt, View paramView)
  {
    AppMethodBeat.i(331094);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFollowTopicHeaderView);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFollowTopicHeaderView, "this$0");
    if (Qv(paramInt)) {
      paramFinderFollowTopicHeaderView.EEF.onClick(paramView);
    }
    for (;;)
    {
      paramFinderFollowTopicHeaderView = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.T(false, 6);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(331094);
      return;
      paramFinderFollowTopicHeaderView.eDL();
    }
  }
  
  private static final void a(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, View paramView)
  {
    AppMethodBeat.i(331023);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFollowTopicHeaderView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFollowTopicHeaderView, "this$0");
    paramView = paramFinderFollowTopicHeaderView.getVideoView();
    if (paramView != null)
    {
      if (!paramFinderFollowTopicHeaderView.EEw) {
        break label225;
      }
      paramFinderFollowTopicHeaderView.setFirstClickPlay(false);
      paramView.setMute(false);
      paramView.b(0.0D, true);
      paramView = (WeImageView)paramFinderFollowTopicHeaderView.findViewById(l.e.finder_music_play_btn_ui);
      if (paramView != null) {
        paramView.setImageDrawable(bb.m(paramFinderFollowTopicHeaderView.getContext(), l.h.finder_music_follow_topic_pause_icon, com.tencent.mm.cd.a.w(paramFinderFollowTopicHeaderView.getContext(), l.b.FG_0)));
      }
      paramView = (WeImageView)paramFinderFollowTopicHeaderView.findViewById(l.e.finder_music_play_btn_ui);
      if (paramView != null) {
        paramView.setOnClickListener(paramFinderFollowTopicHeaderView.EEC);
      }
      paramFinderFollowTopicHeaderView.setCurrentListener(paramFinderFollowTopicHeaderView.EEC);
      paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramView = paramFinderFollowTopicHeaderView.getContext();
      kotlin.g.b.s.s(paramView, "context");
      paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getOriginFeed();
      if (paramFinderFollowTopicHeaderView != null) {
        break label233;
      }
      paramFinderFollowTopicHeaderView = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.z.a(paramView, 2, 2, paramFinderFollowTopicHeaderView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(331023);
      return;
      label225:
      paramView.bNU();
      break;
      label233:
      paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getFeedObject();
      if (paramFinderFollowTopicHeaderView == null) {
        paramFinderFollowTopicHeaderView = null;
      } else {
        paramFinderFollowTopicHeaderView = Integer.valueOf(paramFinderFollowTopicHeaderView.follow_feed_count);
      }
    }
  }
  
  private static final void a(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(331115);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFollowTopicHeaderView);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFollowTopicHeaderView, "this$0");
    kotlin.g.b.s.u(paramd, "$bottomSheet");
    if (AndroidContextUtil.castActivityOrNull(paramFinderFollowTopicHeaderView.getContext()) != null)
    {
      paramView = new Intent();
      paramView.putExtra("key_create_scene", 12);
      localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getContext();
      kotlin.g.b.s.s(paramFinderFollowTopicHeaderView, "context");
      ((com.tencent.mm.plugin.finder.utils.a)localObject).x(paramFinderFollowTopicHeaderView, paramView);
    }
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(331115);
  }
  
  private static final void a(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, String paramString, MenuItem paramMenuItem, int paramInt)
  {
    Object localObject7 = null;
    Object localObject6 = null;
    AppMethodBeat.i(331153);
    kotlin.g.b.s.u(paramFinderFollowTopicHeaderView, "this$0");
    kotlin.g.b.s.u(paramString, "$postId");
    Intent localIntent = new Intent();
    Object localObject2;
    Object localObject3;
    Object localObject5;
    label99:
    Object localObject1;
    label115:
    Object localObject4;
    if (paramMenuItem.getItemId() == 1001)
    {
      localIntent.putExtra("key_finder_post_router", 2);
      localObject2 = "";
      localObject3 = "";
      localObject5 = "";
      if (paramFinderFollowTopicHeaderView.getType() != 1) {
        break label437;
      }
      localObject3 = paramFinderFollowTopicHeaderView.getAudioPath();
      paramMenuItem = paramFinderFollowTopicHeaderView.getFinderBgmInfo();
      if (paramMenuItem != null) {
        break label392;
      }
      paramMenuItem = "-1";
      localObject1 = paramFinderFollowTopicHeaderView.getFinderBgmInfo();
      if (localObject1 != null) {
        break label413;
      }
      localObject1 = "";
      localObject5 = null;
      localObject4 = localObject1;
      localObject2 = paramMenuItem;
      localObject1 = localObject5;
      paramMenuItem = (MenuItem)localObject4;
    }
    for (;;)
    {
      localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", (String)localObject2);
      localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", (String)localObject3);
      if (localObject1 == null)
      {
        localObject1 = null;
        label162:
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", (byte[])localObject1);
        localObject1 = paramFinderFollowTopicHeaderView.getFinderBgmInfo();
        if (localObject1 != null) {
          break label720;
        }
        localObject1 = null;
        label187:
        localIntent.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", kotlin.g.b.s.p(localObject1, com.tencent.mm.model.z.bAW()));
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", paramMenuItem);
        paramMenuItem = paramFinderFollowTopicHeaderView.getFinderBgmInfo();
        if (paramMenuItem != null) {
          break label748;
        }
        paramMenuItem = null;
        label225:
        if (paramMenuItem == null) {
          break label779;
        }
        paramMenuItem = paramFinderFollowTopicHeaderView.getFinderBgmInfo();
        if (paramMenuItem != null) {
          break label756;
        }
        paramMenuItem = localObject6;
        label241:
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", String.valueOf(paramMenuItem));
        Log.i("FinderFollowTopicHeaderView", kotlin.g.b.s.X("tabType ", Integer.valueOf(paramFinderFollowTopicHeaderView.getTabType())));
        switch (paramFinderFollowTopicHeaderView.getTabType())
        {
        case 2: 
        default: 
          paramInt = 5;
        }
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", paramInt);
        localIntent.putExtra("key_finder_post_id", paramString);
        paramString = com.tencent.mm.plugin.finder.utils.a.GfO;
        paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getContext();
        kotlin.g.b.s.s(paramFinderFollowTopicHeaderView, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(paramFinderFollowTopicHeaderView, localIntent);
        AppMethodBeat.o(331153);
        return;
        if (paramMenuItem.getItemId() != 1002) {
          break;
        }
        localIntent.putExtra("key_finder_post_router", 3);
        break;
        label392:
        localObject1 = paramMenuItem.groupId;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 != null) {
          break label99;
        }
        paramMenuItem = "-1";
        break label99;
        label413:
        localObject2 = ((bxt)localObject1).audioTrackUrl;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label115;
        }
        localObject1 = "";
        break label115;
        label437:
        if (paramFinderFollowTopicHeaderView.getType() != 2) {
          break label844;
        }
        paramMenuItem = paramFinderFollowTopicHeaderView.getAudioInfo();
        label458:
        label474:
        bqj localbqj;
        if (paramMenuItem == null)
        {
          paramMenuItem = "";
          localObject1 = paramFinderFollowTopicHeaderView.getFinderBgmInfo();
          if (localObject1 != null) {
            break label662;
          }
          localObject1 = "-1";
          localObject4 = paramFinderFollowTopicHeaderView.getFinderBgmInfo();
          localObject2 = paramMenuItem;
          localObject3 = localObject1;
          if (localObject4 == null) {
            break label844;
          }
          localbqj = ((bxt)localObject4).musicInfo;
          localObject2 = paramMenuItem;
          localObject3 = localObject1;
          if (localbqj == null) {
            break label844;
          }
          localObject3 = localbqj.ZYp;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject4 = new bqj();
          localObject3 = paramFinderFollowTopicHeaderView.getFinderBgmInfo();
          if (localObject3 != null) {
            break label686;
          }
          localObject3 = "";
        }
        for (;;)
        {
          ((bqj)localObject4).HsD = ((String)localObject3);
          localObject5 = localbqj.ZYp;
          localObject3 = localObject5;
          if (localObject5 == null) {
            localObject3 = "";
          }
          ((bqj)localObject4).ZYp = ((String)localObject3);
          ((bqj)localObject4).artist = localbqj.artist;
          ((bqj)localObject4).name = localbqj.name;
          localObject3 = localObject4;
          localObject4 = localObject1;
          localObject5 = paramMenuItem;
          paramMenuItem = (MenuItem)localObject2;
          localObject1 = localObject3;
          localObject2 = localObject4;
          localObject3 = localObject5;
          break;
          localObject1 = paramMenuItem.cachePath;
          paramMenuItem = (MenuItem)localObject1;
          if (localObject1 != null) {
            break label458;
          }
          paramMenuItem = "";
          break label458;
          label662:
          localObject2 = ((bxt)localObject1).groupId;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label474;
          }
          localObject1 = "-1";
          break label474;
          label686:
          localObject5 = ((bxt)localObject3).groupId;
          localObject3 = localObject5;
          if (localObject5 == null) {
            localObject3 = "";
          }
        }
        localObject1 = ((bqj)localObject1).toByteArray();
        break label162;
        label720:
        localObject1 = ((bxt)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label187;
        }
        localObject1 = ((FinderContact)localObject1).username;
        break label187;
        label748:
        paramMenuItem = paramMenuItem.musicInfo;
        break label225;
        label756:
        localObject1 = paramMenuItem.musicInfo;
        paramMenuItem = localObject6;
        if (localObject1 == null) {
          break label241;
        }
        paramMenuItem = ((bqj)localObject1).name;
        break label241;
        label779:
        paramMenuItem = paramFinderFollowTopicHeaderView.getFinderBgmInfo();
        if (paramMenuItem == null) {
          paramMenuItem = localObject7;
        }
        for (;;)
        {
          localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", kotlin.g.b.s.X(paramMenuItem, "的动态原声"));
          break;
          localObject1 = paramMenuItem.contact;
          paramMenuItem = localObject7;
          if (localObject1 != null) {
            paramMenuItem = ((FinderContact)localObject1).nickname;
          }
        }
        paramInt = 5;
        continue;
        paramInt = 7;
      }
      label844:
      localObject1 = null;
      localObject4 = localObject2;
      paramMenuItem = (MenuItem)localObject5;
      localObject2 = localObject3;
      localObject3 = localObject4;
    }
  }
  
  private static final void a(bxt parambxt, FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, View paramView)
  {
    AppMethodBeat.i(331073);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambxt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderFollowTopicHeaderView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramFinderFollowTopicHeaderView, "this$0");
    localObject1 = parambxt.contact;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        localObject1 = new Intent();
        parambxt = parambxt.contact;
        if (parambxt != null) {
          break label331;
        }
      }
    }
    label331:
    for (parambxt = null;; parambxt = parambxt.username)
    {
      ((Intent)localObject1).putExtra("finder_username", parambxt);
      parambxt = as.GSQ;
      parambxt = paramFinderFollowTopicHeaderView.getContext();
      kotlin.g.b.s.s(parambxt, "context");
      as.a.a(parambxt, (Intent)localObject1, 0L, 6, false, 64);
      parambxt = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderFollowTopicHeaderView = paramView.getContext();
      kotlin.g.b.s.s(paramFinderFollowTopicHeaderView, "it.context");
      parambxt.enterFinderProfileUI(paramFinderFollowTopicHeaderView, (Intent)localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(331073);
      return;
      localObject1 = com.tencent.mm.plugin.finder.api.c.b((FinderContact)localObject1);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject2 = new Intent();
      Object localObject3 = as.GSQ;
      localObject3 = paramFinderFollowTopicHeaderView.getContext();
      kotlin.g.b.s.s(localObject3, "context");
      as.a.a((Context)localObject3, (Intent)localObject2, 0L, 0, false, 124);
      ((Intent)localObject2).putExtra("Contact_User", ((pu)localObject1).ADE);
      ((Intent)localObject2).putExtra("Contact_Scene", 213);
      ((Intent)localObject2).putExtra("biz_profile_enter_from_finder", true);
      ((Intent)localObject2).putExtra("force_get_contact", true);
      ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
      ((Intent)localObject2).putExtra("biz_profile_tab_type", 1);
      com.tencent.mm.br.c.b(paramFinderFollowTopicHeaderView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      localObject1 = ah.aiuX;
      break;
    }
  }
  
  private static boolean ayT(String paramString)
  {
    AppMethodBeat.i(330997);
    if ((com.tencent.mm.pluginsdk.res.downloader.b.a.ZC(paramString)) && (com.tencent.mm.pluginsdk.res.downloader.b.a.jK(paramString) > 0L))
    {
      AppMethodBeat.o(330997);
      return true;
    }
    AppMethodBeat.o(330997);
    return false;
  }
  
  private static final void b(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, View paramView)
  {
    AppMethodBeat.i(331031);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFollowTopicHeaderView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFollowTopicHeaderView, "this$0");
    paramView = paramFinderFollowTopicHeaderView.getVideoView();
    if (paramView != null)
    {
      localObject = (WeImageView)paramFinderFollowTopicHeaderView.findViewById(l.e.finder_music_play_btn_ui);
      if (localObject != null) {
        ((WeImageView)localObject).setImageDrawable(bb.m(paramFinderFollowTopicHeaderView.getContext(), l.h.finder_music_follow_topic_play_icon, com.tencent.mm.cd.a.w(paramFinderFollowTopicHeaderView.getContext(), l.b.FG_0)));
      }
      paramView.pause();
      paramView = (WeImageView)paramFinderFollowTopicHeaderView.findViewById(l.e.finder_music_play_btn_ui);
      if (paramView != null) {
        paramView.setOnClickListener(paramFinderFollowTopicHeaderView.EEB);
      }
      paramFinderFollowTopicHeaderView.setCurrentListener(paramFinderFollowTopicHeaderView.EEB);
      paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramView = paramFinderFollowTopicHeaderView.getContext();
      kotlin.g.b.s.s(paramView, "context");
      paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getOriginFeed();
      if (paramFinderFollowTopicHeaderView != null) {
        break label206;
      }
      paramFinderFollowTopicHeaderView = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.z.a(paramView, 2, 3, paramFinderFollowTopicHeaderView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(331031);
      return;
      label206:
      paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getFeedObject();
      if (paramFinderFollowTopicHeaderView == null) {
        paramFinderFollowTopicHeaderView = null;
      } else {
        paramFinderFollowTopicHeaderView = Integer.valueOf(paramFinderFollowTopicHeaderView.follow_feed_count);
      }
    }
  }
  
  private static final void c(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, View paramView)
  {
    AppMethodBeat.i(331040);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFollowTopicHeaderView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFollowTopicHeaderView, "this$0");
    paramView = paramFinderFollowTopicHeaderView.getBgmPlayBtn();
    if (paramView != null) {
      paramView.eDU();
    }
    paramView = (WeImageView)paramFinderFollowTopicHeaderView.findViewById(l.e.finder_music_play_btn_ui);
    if (paramView != null) {
      paramView.setImageDrawable(bb.m(paramFinderFollowTopicHeaderView.getContext(), l.h.finder_music_follow_topic_pause_icon, com.tencent.mm.cd.a.w(paramFinderFollowTopicHeaderView.getContext(), l.b.FG_0)));
    }
    paramView = (WeImageView)paramFinderFollowTopicHeaderView.findViewById(l.e.finder_music_play_btn_ui);
    if (paramView != null) {
      paramView.setOnClickListener(paramFinderFollowTopicHeaderView.EEE);
    }
    paramFinderFollowTopicHeaderView.setCurrentListener(paramFinderFollowTopicHeaderView.EEE);
    paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
    paramView = paramFinderFollowTopicHeaderView.getContext();
    kotlin.g.b.s.s(paramView, "context");
    paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getOriginFeed();
    if (paramFinderFollowTopicHeaderView == null) {
      paramFinderFollowTopicHeaderView = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.z.a(paramView, 2, 2, paramFinderFollowTopicHeaderView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(331040);
      return;
      paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getFeedObject();
      if (paramFinderFollowTopicHeaderView == null) {
        paramFinderFollowTopicHeaderView = null;
      } else {
        paramFinderFollowTopicHeaderView = Integer.valueOf(paramFinderFollowTopicHeaderView.follow_feed_count);
      }
    }
  }
  
  private final void ci(Context paramContext)
  {
    AppMethodBeat.i(330980);
    af.mU(paramContext).inflate(l.f.finder_follow_topic_feed_header, (ViewGroup)this, true);
    int i = paramContext.getResources().getDimensionPixelOffset(l.c.Edge_1_5_A);
    int j = paramContext.getResources().getDimensionPixelOffset(l.c.Edge_2A);
    setPadding(j, i, j, i);
    this.EEs = ((FinderVideoViewForTopic)findViewById(l.e.video_view));
    aw.a((Paint)((TextView)findViewById(l.e.follow_btn_tv)).getPaint(), 0.8F);
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    this.AwN = new g((AppCompatActivity)paramContext);
    AppMethodBeat.o(330980);
  }
  
  private static final void d(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, View paramView)
  {
    AppMethodBeat.i(331049);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFollowTopicHeaderView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFollowTopicHeaderView, "this$0");
    paramView = paramFinderFollowTopicHeaderView.getBgmPlayBtn();
    if (paramView != null) {
      paramView.bLg();
    }
    paramView = (WeImageView)paramFinderFollowTopicHeaderView.findViewById(l.e.finder_music_play_btn_ui);
    if (paramView != null) {
      paramView.setImageDrawable(bb.m(paramFinderFollowTopicHeaderView.getContext(), l.h.finder_music_follow_topic_play_icon, com.tencent.mm.cd.a.w(paramFinderFollowTopicHeaderView.getContext(), l.b.FG_0)));
    }
    paramView = (WeImageView)paramFinderFollowTopicHeaderView.findViewById(l.e.finder_music_play_btn_ui);
    if (paramView != null) {
      paramView.setOnClickListener(paramFinderFollowTopicHeaderView.EED);
    }
    paramFinderFollowTopicHeaderView.setCurrentListener(paramFinderFollowTopicHeaderView.EED);
    paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
    paramView = paramFinderFollowTopicHeaderView.getContext();
    kotlin.g.b.s.s(paramView, "context");
    paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getOriginFeed();
    if (paramFinderFollowTopicHeaderView == null) {
      paramFinderFollowTopicHeaderView = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.z.a(paramView, 2, 3, paramFinderFollowTopicHeaderView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(331049);
      return;
      paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getFeedObject();
      if (paramFinderFollowTopicHeaderView == null) {
        paramFinderFollowTopicHeaderView = null;
      } else {
        paramFinderFollowTopicHeaderView = Integer.valueOf(paramFinderFollowTopicHeaderView.follow_feed_count);
      }
    }
  }
  
  private static final void e(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, View paramView)
  {
    AppMethodBeat.i(331061);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFollowTopicHeaderView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFollowTopicHeaderView, "this$0");
    paramView = paramFinderFollowTopicHeaderView.getFinderBgmInfo();
    if (paramView == null)
    {
      paramView = null;
      if (paramView == null) {
        break label159;
      }
      com.tencent.mm.ui.base.aa.makeText(paramFinderFollowTopicHeaderView.getContext(), l.i.finder_can_not_follow_music, 0).show();
      label88:
      paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramView = paramFinderFollowTopicHeaderView.getContext();
      kotlin.g.b.s.s(paramView, "context");
      paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getOriginFeed();
      if (paramFinderFollowTopicHeaderView != null) {
        break label176;
      }
      paramFinderFollowTopicHeaderView = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.z.a(paramView, 2, 4, paramFinderFollowTopicHeaderView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(331061);
      return;
      paramView = paramView.musicInfo;
      break;
      label159:
      com.tencent.mm.ui.base.aa.makeText(paramFinderFollowTopicHeaderView.getContext(), l.i.finder_can_not_follow_feed_bgm, 0).show();
      break label88;
      label176:
      paramFinderFollowTopicHeaderView = paramFinderFollowTopicHeaderView.getFeedObject();
      if (paramFinderFollowTopicHeaderView == null) {
        paramFinderFollowTopicHeaderView = null;
      } else {
        paramFinderFollowTopicHeaderView = Integer.valueOf(paramFinderFollowTopicHeaderView.follow_feed_count);
      }
    }
  }
  
  private static final void eDN()
  {
    AppMethodBeat.i(331163);
    com.tencent.mm.plugin.finder.report.v localv = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.SA(6);
    AppMethodBeat.o(331163);
  }
  
  private static final void f(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, View paramView)
  {
    AppMethodBeat.i(331083);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFollowTopicHeaderView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFollowTopicHeaderView, "this$0");
    com.tencent.mm.ui.base.aa.makeText(paramFinderFollowTopicHeaderView.getContext(), l.i.finder_follow_header_music_invaild_toast, 0).show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(331083);
  }
  
  private static final void f(com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(331104);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "$bottomSheet");
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(331104);
  }
  
  private static final void i(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(331126);
    if (params.jmw())
    {
      params.oh(1001, l.i.app_field_mmsight);
      params.oh(1002, l.i.app_field_select_new_pic);
    }
    AppMethodBeat.o(331126);
  }
  
  public final void a(int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(331764);
    kotlin.g.b.s.u(paramx, "video");
    Log.i("FinderFollowTopicHeaderView", "[onProgressDownload] offset:" + paramInt1 + ',' + paramInt2);
    AppMethodBeat.o(331764);
  }
  
  public final void a(int paramInt1, int paramInt2, x paramx, boolean paramBoolean)
  {
    AppMethodBeat.i(331757);
    kotlin.g.b.s.u(paramx, "video");
    Log.i("FinderFollowTopicHeaderView", "[onMoovReadyDownload]");
    AppMethodBeat.o(331757);
  }
  
  public final void a(int paramInt, x paramx, com.tencent.mm.g.d paramd)
  {
    int i = 1;
    AppMethodBeat.i(331743);
    kotlin.g.b.s.u(paramx, "video");
    Log.i("FinderFollowTopicHeaderView", kotlin.g.b.s.X("[onFinishDownload] videoPath = ", paramx.getPath()));
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      this.hsO = bool;
      if (!this.hsO) {
        break label193;
      }
      if (this.EEu == null) {
        break label218;
      }
      a(paramx);
      paramd = getDialog();
      if ((paramd == null) || (paramd.isShowing() != true)) {
        break label187;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramd = getDialog();
        if (paramd != null) {
          paramd.dismiss();
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
      }
      Log.i("FinderFollowTopicHeaderView", "[onFinishDownload] ret = " + paramInt + ",fileExist = " + com.tencent.mm.pluginsdk.res.downloader.b.a.ZC(paramx.getPath()) + ",fileSize = " + com.tencent.mm.pluginsdk.res.downloader.b.a.jK(paramx.getPath()));
      AppMethodBeat.o(331743);
      return;
      bool = false;
      break;
      label187:
      i = 0;
    }
    label193:
    Toast.makeText(getContext(), l.i.finder_follow_header_music_err, 0).show();
    com.tencent.mm.plugin.report.service.h.OAn.p(1530L, 1L, 1L);
    label218:
    AppMethodBeat.o(331743);
  }
  
  public final void a(x paramx, com.tencent.mm.g.h paramh, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(331732);
    kotlin.g.b.s.u(paramx, "video");
    Log.i("FinderFollowTopicHeaderView", "[onStopDownload]");
    AppMethodBeat.o(331732);
  }
  
  public final void a(FinderItem paramFinderItem, bxt parambxt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331661);
    this.EEt = paramFinderItem;
    this.EEu = parambxt;
    this.hJx = paramInt1;
    if (parambxt == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label685;
      }
      this.type = 2;
      paramFinderItem = parambxt.musicInfo;
      if (paramFinderItem == null) {
        break label235;
      }
      paramFinderItem = paramFinderItem.artist;
      if ((paramFinderItem == null) || (n.a((CharSequence)paramFinderItem, (CharSequence)" · ", false) != true)) {
        break label235;
      }
      paramInt1 = 1;
      label76:
      if (paramInt1 == 0) {
        break label295;
      }
      paramFinderItem = parambxt.musicInfo;
      if (paramFinderItem != null) {
        break label240;
      }
      paramFinderItem = null;
      label91:
      localObject1 = (TextView)findViewById(l.e.finder_artist_name);
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)String.valueOf(paramFinderItem));
      }
      localObject1 = (TextView)findViewById(l.e.finder_music_name);
      if (localObject1 != null)
      {
        paramFinderItem = parambxt.musicInfo;
        if (paramFinderItem != null) {
          break label317;
        }
      }
    }
    label295:
    label317:
    for (paramFinderItem = null;; paramFinderItem = paramFinderItem.name)
    {
      ((TextView)localObject1).setText((CharSequence)String.valueOf(paramFinderItem));
      if (!Qv(paramInt2)) {
        break label325;
      }
      paramFinderItem = (WeImageView)findViewById(l.e.finder_music_play_btn_ui);
      if (paramFinderItem != null)
      {
        paramFinderItem.setOnClickListener(this.EEF);
        paramFinderItem = ah.aiuX;
      }
      paramFinderItem = findViewById(l.e.follow_btn);
      if (paramFinderItem != null)
      {
        paramFinderItem.setOnClickListener(this.EEF);
        paramFinderItem = ah.aiuX;
      }
      AppMethodBeat.o(331661);
      return;
      localObject1 = parambxt.musicInfo;
      break;
      label235:
      paramInt1 = 0;
      break label76;
      label240:
      paramFinderItem = paramFinderItem.artist;
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        break label91;
      }
      paramFinderItem = n.a((CharSequence)paramFinderItem, new String[] { " · " });
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        break label91;
      }
      paramFinderItem = (String)paramFinderItem.get(0);
      break label91;
      paramFinderItem = parambxt.musicInfo;
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        break label91;
      }
      paramFinderItem = paramFinderItem.artist;
      break label91;
    }
    label325:
    this.EEy = ((FinderImgFeedMusicTag)findViewById(l.e.finder_music_play_btn));
    Object localObject1 = this.EEy;
    if (localObject1 != null)
    {
      if (parambxt == null)
      {
        paramFinderItem = null;
        ((FinderImgFeedMusicTag)localObject1).a(paramFinderItem);
        paramFinderItem = ah.aiuX;
      }
    }
    else
    {
      paramFinderItem = (WeImageView)findViewById(l.e.finder_music_play_btn_ui);
      if (paramFinderItem != null)
      {
        paramFinderItem.setOnClickListener(this.EED);
        paramFinderItem = ah.aiuX;
      }
      localObject1 = new AudioCacheInfo();
      ((AudioCacheInfo)localObject1).NID = ((int)System.currentTimeMillis());
      if (parambxt != null) {
        break label655;
      }
      paramFinderItem = null;
      label417:
      ((AudioCacheInfo)localObject1).musicUrl = paramFinderItem;
      paramFinderItem = bm.GlZ;
      if (parambxt != null) {
        break label677;
      }
      paramFinderItem = null;
      label433:
      kotlin.g.b.s.checkNotNull(paramFinderItem);
      kotlin.g.b.s.s(paramFinderItem, "bgmInfo?.musicInfo!!");
      ((AudioCacheInfo)localObject1).cachePath = bm.b(paramFinderItem);
      parambxt = ((AudioCacheInfo)localObject1).cachePath;
      paramFinderItem = parambxt;
      if (parambxt == null) {
        paramFinderItem = "";
      }
      setFilePath(paramFinderItem);
      paramFinderItem = ah.aiuX;
      this.EEx = ((AudioCacheInfo)localObject1);
      paramFinderItem = k.NJr;
      paramFinderItem = k.gIk();
      parambxt = getContext();
      kotlin.g.b.s.s(parambxt, "context");
      localObject1 = this.EEx;
      kotlin.g.b.s.checkNotNull(localObject1);
      paramFinderItem.a(parambxt, (AudioCacheInfo)localObject1, (kotlin.g.a.m)new b(this));
      label533:
      parambxt = findViewById(l.e.finder_music_play_btn);
      paramFinderItem = (FinderImgFeedMusicTag)parambxt;
      if (paramFinderItem != null) {
        break label1574;
      }
      paramFinderItem = null;
      label552:
      if (!(paramFinderItem instanceof ViewGroup)) {
        break label1582;
      }
    }
    label655:
    label677:
    label685:
    label1582:
    for (paramFinderItem = (ViewGroup)paramFinderItem;; paramFinderItem = null)
    {
      if (paramFinderItem != null)
      {
        paramFinderItem.removeView(parambxt);
        paramFinderItem = ah.aiuX;
      }
      paramFinderItem = AndroidContextUtil.castActivityOrNull(getContext());
      if (paramFinderItem != null)
      {
        ((FrameLayout)paramFinderItem.getWindow().getDecorView()).addView(parambxt);
        paramFinderItem = ah.aiuX;
        paramFinderItem = ah.aiuX;
      }
      paramFinderItem = av.GiL;
      if (av.fgg() != 1) {
        break label1587;
      }
      paramFinderItem = findViewById(l.e.follow_btn);
      if (paramFinderItem == null) {
        break label1644;
      }
      paramFinderItem.setVisibility(8);
      AppMethodBeat.o(331661);
      return;
      paramFinderItem = parambxt.musicInfo;
      break;
      paramFinderItem = parambxt.musicInfo;
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        break label417;
      }
      paramFinderItem = paramFinderItem.ZYp;
      break label417;
      paramFinderItem = parambxt.musicInfo;
      break label433;
      this.type = 1;
      Object localObject2;
      Context localContext;
      if ((parambxt != null) && (parambxt.contact != null))
      {
        localObject2 = (TextView)findViewById(l.e.finder_artist_name);
        if (localObject2 != null)
        {
          localObject1 = parambxt.contact;
          if (localObject1 != null) {
            break label900;
          }
          localObject1 = null;
          ((TextView)localObject2).setText((CharSequence)String.valueOf(localObject1));
        }
        localObject2 = (TextView)findViewById(l.e.finder_music_name);
        if (localObject2 != null)
        {
          localContext = getContext();
          paramInt1 = l.i.finder_follow_header_title;
          localObject1 = parambxt.contact;
          if (localObject1 != null) {
            break label910;
          }
        }
      }
      for (localObject1 = null;; localObject1 = ((FinderContact)localObject1).nickname)
      {
        ((TextView)localObject2).setText((CharSequence)localContext.getString(paramInt1, new Object[] { localObject1 }));
        findViewById(l.e.finder_artist_name).setOnClickListener(new FinderFollowTopicHeaderView..ExternalSyntheticLambda9(parambxt, this));
        localObject1 = findViewById(l.e.finder_follow_arrow);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
        if (!Qv(paramInt2)) {
          break label920;
        }
        paramFinderItem = (WeImageView)findViewById(l.e.finder_music_play_btn_ui);
        if (paramFinderItem != null)
        {
          paramFinderItem.setOnClickListener(this.EEF);
          paramFinderItem = ah.aiuX;
        }
        AppMethodBeat.o(331661);
        return;
        localObject1 = ((FinderContact)localObject1).nickname;
        break;
      }
      if (parambxt == null)
      {
        localObject1 = null;
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label1091;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0)
        {
          this.EEy = ((FinderImgFeedMusicTag)findViewById(l.e.finder_music_play_btn));
          parambxt = (WeImageView)findViewById(l.e.finder_music_play_btn_ui);
          if (parambxt != null)
          {
            parambxt.setOnClickListener(this.EEB);
            parambxt = ah.aiuX;
          }
          this.EEB = this.EEB;
          if (paramFinderItem == null)
          {
            paramFinderItem = findViewById(l.e.follow_btn);
            if (paramFinderItem != null) {
              paramFinderItem.setVisibility(8);
            }
            paramFinderItem = (WeImageView)findViewById(l.e.finder_music_play_btn_ui);
            if (paramFinderItem != null) {
              paramFinderItem.setAlpha(0.5F);
            }
            paramFinderItem = (WeImageView)findViewById(l.e.finder_music_play_btn_ui);
            if (paramFinderItem == null) {
              break;
            }
            paramFinderItem.setOnClickListener(new FinderFollowTopicHeaderView..ExternalSyntheticLambda1(this));
            paramFinderItem = ah.aiuX;
            break;
            localObject1 = parambxt.audioTrackUrl;
            break label927;
            label1091:
            paramInt1 = 0;
            continue;
          }
          localObject2 = this.EEs;
          if (localObject2 == null) {
            break;
          }
          parambxt = paramFinderItem.getMediaList().get(0);
          kotlin.g.b.s.s(parambxt, "feed.mediaList[0]");
          setMedia(new com.tencent.mm.plugin.finder.loader.v((dji)parambxt, com.tencent.mm.plugin.finder.storage.v.FLk, 0, null, 12));
          parambxt = getMedia();
          kotlin.g.b.s.checkNotNull(parambxt);
          setFilePath(parambxt.getPath());
          parambxt = getMedia();
          if (parambxt == null) {
            parambxt = "";
          }
          for (;;)
          {
            setDownloadFinish(ayT(parambxt));
            if (getDownloadFinish())
            {
              parambxt = getMedia();
              kotlin.g.b.s.checkNotNull(parambxt);
              a((x)parambxt);
            }
            Log.i("FinderFollowTopicHeaderView", kotlin.g.b.s.X("file downloadFinish = ", Boolean.valueOf(getDownloadFinish())));
            parambxt = getMedia();
            kotlin.g.b.s.checkNotNull(parambxt);
            parambxt = (x)parambxt;
            localObject1 = FeedData.Companion;
            ((FinderVideoViewForTopic)localObject2).b(parambxt, false, FeedData.a.n(paramFinderItem));
            ((FinderVideoViewForTopic)localObject2).setScaleType(i.e.XYN);
            paramFinderItem = new com.tencent.mm.plugin.finder.loader.u();
            parambxt = getMedia();
            kotlin.g.b.s.checkNotNull(parambxt);
            ((FinderVideoViewForTopic)localObject2).setIOnlineVideoProxy(paramFinderItem.a(parambxt, (com.tencent.mm.plugin.finder.video.aa)this));
            ((FinderVideoViewForTopic)localObject2).setIsShowBasicControls(false);
            ((FinderVideoViewForTopic)localObject2).setLoop(true);
            ((FinderVideoViewForTopic)localObject2).setMute(true);
            ((FinderVideoViewForTopic)localObject2).fjG();
            break;
            localObject1 = parambxt.getPath();
            parambxt = (bxt)localObject1;
            if (localObject1 == null) {
              parambxt = "";
            }
          }
        }
      }
      if (parambxt == null) {
        break label533;
      }
      setBgmPlayBtn((FinderImgFeedMusicTag)findViewById(l.e.finder_music_play_btn));
      paramFinderItem = new bqj();
      paramFinderItem.ZYp = parambxt.audioTrackUrl;
      paramFinderItem.name = "fake music info";
      paramFinderItem.HsD = String.valueOf(System.currentTimeMillis());
      parambxt = ah.aiuX;
      parambxt = getBgmPlayBtn();
      if (parambxt != null)
      {
        parambxt.a(paramFinderItem);
        parambxt = ah.aiuX;
      }
      parambxt = (WeImageView)findViewById(l.e.finder_music_play_btn_ui);
      if (parambxt != null)
      {
        parambxt.setOnClickListener(this.EED);
        parambxt = ah.aiuX;
      }
      localObject1 = new AudioCacheInfo();
      ((AudioCacheInfo)localObject1).NID = ((int)System.currentTimeMillis());
      ((AudioCacheInfo)localObject1).musicUrl = paramFinderItem.ZYp;
      parambxt = bm.GlZ;
      ((AudioCacheInfo)localObject1).cachePath = bm.b(paramFinderItem);
      parambxt = ((AudioCacheInfo)localObject1).cachePath;
      paramFinderItem = parambxt;
      if (parambxt == null) {
        paramFinderItem = "";
      }
      setFilePath(paramFinderItem);
      paramFinderItem = ah.aiuX;
      setAudioInfo((AudioCacheInfo)localObject1);
      paramFinderItem = k.NJr;
      paramFinderItem = k.gIk();
      parambxt = getContext();
      kotlin.g.b.s.s(parambxt, "context");
      localObject1 = getAudioInfo();
      kotlin.g.b.s.checkNotNull(localObject1);
      paramFinderItem.a(parambxt, (AudioCacheInfo)localObject1, (kotlin.g.a.m)new c(this));
      paramFinderItem = ah.aiuX;
      paramFinderItem = ah.aiuX;
      break label533;
      paramFinderItem = paramFinderItem.getParent();
      break label552;
    }
    label900:
    label910:
    label920:
    label927:
    label1574:
    label1587:
    paramFinderItem = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.T(true, 6);
    paramFinderItem = findViewById(l.e.follow_btn);
    if (paramFinderItem != null) {
      paramFinderItem.setVisibility(0);
    }
    paramFinderItem = findViewById(l.e.follow_btn);
    if (paramFinderItem != null)
    {
      paramFinderItem.setOnClickListener(new FinderFollowTopicHeaderView..ExternalSyntheticLambda6(this, paramInt2));
      paramFinderItem = ah.aiuX;
    }
    label1644:
    AppMethodBeat.o(331661);
  }
  
  public final void aj(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331750);
    kotlin.g.b.s.u(paramString, "mediaId");
    Log.i("FinderFollowTopicHeaderView", "[checkVideoDataAvailable]");
    AppMethodBeat.o(331750);
  }
  
  public final void b(x paramx)
  {
    AppMethodBeat.i(331722);
    kotlin.g.b.s.u(paramx, "video");
    Log.i("FinderFollowTopicHeaderView", "[onStartDownload]");
    AppMethodBeat.o(331722);
  }
  
  public final void eDL()
  {
    int i = 1;
    AppMethodBeat.i(331688);
    Object localObject1 = av.GiL;
    switch (av.fgg())
    {
    default: 
      Log.d("FinderFollowTopicHeaderView", "not one of six state");
    case 3: 
    case 6: 
      if (this.hsO) {
        break label291;
      }
      if (this.rYw == null)
      {
        this.rYw = w.a(getContext(), (CharSequence)getContext().getString(l.i.finder_follow_header_downloading_wait), true, 2, null);
        AppMethodBeat.o(331688);
        return;
      }
      break;
    case 1: 
      com.tencent.mm.ui.base.aa.makeText(getContext(), l.i.finder_no_post_quality_tips, 0).show();
      AppMethodBeat.o(331688);
      return;
    case 2: 
      localObject1 = new com.tencent.mm.plugin.finder.view.d(getContext());
      ((com.tencent.mm.plugin.finder.view.d)localObject1).UD(l.f.finder_follow_topic_header_create_accoutn_bottom_sheet_layout);
      ((com.tencent.mm.plugin.finder.view.d)localObject1).rootView.findViewById(l.e.cancel).setOnClickListener(new FinderFollowTopicHeaderView..ExternalSyntheticLambda8((com.tencent.mm.plugin.finder.view.d)localObject1));
      ((com.tencent.mm.plugin.finder.view.d)localObject1).rootView.findViewById(l.e.create_account).setOnClickListener(new FinderFollowTopicHeaderView..ExternalSyntheticLambda7(this, (com.tencent.mm.plugin.finder.view.d)localObject1));
      ((com.tencent.mm.plugin.finder.view.d)localObject1).dDn();
      AppMethodBeat.o(331688);
      return;
    case 4: 
      com.tencent.mm.ui.base.aa.makeText(getContext(), l.i.finder_account_forbid, 0).show();
      AppMethodBeat.o(331688);
      return;
    case 5: 
      com.tencent.mm.ui.base.aa.makeText(getContext(), l.i.finder_self_contact_reviewing, 0).show();
      AppMethodBeat.o(331688);
      return;
    }
    localObject1 = this.rYw;
    if ((localObject1 != null) && (!((w)localObject1).isShowing())) {}
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = this.rYw;
        if (localObject1 != null) {
          ((w)localObject1).show();
        }
      }
      AppMethodBeat.o(331688);
      return;
      i = 0;
    }
    label291:
    localObject1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("post"))
    {
      AppMethodBeat.o(331688);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
    localObject1 = getContext();
    kotlin.g.b.s.s(localObject1, "context");
    if (com.tencent.mm.plugin.finder.utils.a.gW((Context)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.aP(6, true);
      AppMethodBeat.o(331688);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.aP(6, false);
    localObject1 = this.AwN;
    if ((localObject1 != null) && (!((g)localObject1).a((kotlin.g.a.a)new e(this), (kotlin.g.a.a)new f(this)))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(331688);
      return;
    }
    localObject1 = new f(getContext(), 1, true);
    View localView = af.mU(getContext()).inflate(l.f.finder_sheet_header, null);
    Object localObject4 = (TextView)localView.findViewById(l.e.nickname);
    Object localObject2 = (ImageView)localView.findViewById(l.e.avatar);
    Object localObject3 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject3 = d.a.auT(com.tencent.mm.model.z.bAW());
    if (localObject3 != null)
    {
      ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.m)localObject3).getNickname()));
      localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject4 = com.tencent.mm.plugin.finder.loader.p.eCp();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((com.tencent.mm.plugin.finder.api.m)localObject3).field_avatarUrl);
      kotlin.g.b.s.s(localObject2, "avatarIv");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject4).a(localb, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject2 = av.GiL;
      kotlin.g.b.s.s(localView, "headerView");
      av.a((com.tencent.mm.plugin.finder.api.m)localObject3, localView);
    }
    localObject2 = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localObject2 = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
    localObject3 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.azP((String)localObject2);
    ((f)localObject1).af(localView, true);
    ((f)localObject1).Vtg = FinderFollowTopicHeaderView..ExternalSyntheticLambda10.INSTANCE;
    ((f)localObject1).GAC = new FinderFollowTopicHeaderView..ExternalSyntheticLambda11(this, (String)localObject2);
    ((f)localObject1).aeLi = FinderFollowTopicHeaderView..ExternalSyntheticLambda12.INSTANCE;
    ((f)localObject1).dDn();
    AppMethodBeat.o(331688);
  }
  
  public final void eDM()
  {
    AppMethodBeat.i(331715);
    Object localObject = this.EEy;
    if (localObject != null) {
      ((FinderImgFeedMusicTag)localObject).eDT();
    }
    localObject = this.EEs;
    if (localObject != null) {
      ((FinderVideoViewForTopic)localObject).stop();
    }
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(331715);
  }
  
  public final AudioCacheInfo getAudioInfo()
  {
    return this.EEx;
  }
  
  public final String getAudioPath()
  {
    return this.EEz;
  }
  
  public final FinderImgFeedMusicTag getBgmPlayBtn()
  {
    return this.EEy;
  }
  
  public final View.OnClickListener getCurrentListener()
  {
    return this.EEA;
  }
  
  public final w getDialog()
  {
    return this.rYw;
  }
  
  public final boolean getDownloadFinish()
  {
    return this.hsO;
  }
  
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  public final bxt getFinderBgmInfo()
  {
    return this.EEu;
  }
  
  public final com.tencent.mm.plugin.finder.loader.v getMedia()
  {
    return this.EEv;
  }
  
  public final FinderItem getOriginFeed()
  {
    return this.EEt;
  }
  
  public final int getTabType()
  {
    return this.hJx;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final FinderVideoViewForTopic getVideoView()
  {
    return this.EEs;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(331710);
    super.onDetachedFromWindow();
    Log.d("FinderFollowTopicHeaderView", "[onDetachedFromWindow] onViewRecycled");
    AppMethodBeat.o(331710);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(331589);
    if (this.AwM == null)
    {
      localObject = new di(11);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
    }
    Object localObject = this.AwN;
    if (localObject != null) {
      ((g)localObject).onResume();
    }
    AppMethodBeat.o(331589);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(331605);
    g localg = this.AwN;
    if (localg != null) {
      localg.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof di))) {
      this.AwM = ((di)paramp).dVy();
    }
    AppMethodBeat.o(331605);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(331703);
    super.onWindowFocusChanged(paramBoolean);
    if ((!paramBoolean) && ((kotlin.g.b.s.p(this.EEA, this.EEC)) || (kotlin.g.b.s.p(this.EEA, this.EEE))))
    {
      WeImageView localWeImageView = (WeImageView)findViewById(l.e.finder_music_play_btn_ui);
      if (localWeImageView != null) {
        localWeImageView.performClick();
      }
    }
    AppMethodBeat.o(331703);
  }
  
  public final void setAudioInfo(AudioCacheInfo paramAudioCacheInfo)
  {
    this.EEx = paramAudioCacheInfo;
  }
  
  public final void setAudioPath(String paramString)
  {
    AppMethodBeat.i(331530);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.EEz = paramString;
    AppMethodBeat.o(331530);
  }
  
  public final void setBgmPlayBtn(FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
  {
    this.EEy = paramFinderImgFeedMusicTag;
  }
  
  public final void setCurrentListener(View.OnClickListener paramOnClickListener)
  {
    this.EEA = paramOnClickListener;
  }
  
  public final void setDialog(w paramw)
  {
    this.rYw = paramw;
  }
  
  public final void setDownloadFinish(boolean paramBoolean)
  {
    this.hsO = paramBoolean;
  }
  
  public final void setFilePath(String paramString)
  {
    AppMethodBeat.i(331491);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.filePath = paramString;
    AppMethodBeat.o(331491);
  }
  
  public final void setFinderBgmInfo(bxt parambxt)
  {
    this.EEu = parambxt;
  }
  
  public final void setFirstClickPlay(boolean paramBoolean)
  {
    this.EEw = paramBoolean;
  }
  
  public final void setMedia(com.tencent.mm.plugin.finder.loader.v paramv)
  {
    this.EEv = paramv;
  }
  
  public final void setOriginFeed(FinderItem paramFinderItem)
  {
    this.EEt = paramFinderItem;
  }
  
  public final void setTabType(int paramInt)
  {
    this.hJx = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final void setVideoView(FinderVideoViewForTopic paramFinderVideoViewForTopic)
  {
    this.EEs = paramFinderVideoViewForTopic;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "filepath", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<Boolean, String, ah>
  {
    b(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "filepath", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.m<Boolean, String, ah>
  {
    c(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    e(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView
 * JD-Core Version:    0.7.0.1
 */
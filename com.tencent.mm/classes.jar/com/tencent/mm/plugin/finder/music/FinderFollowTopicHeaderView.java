package com.tencent.mm.plugin.finder.music;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.FinderVideoViewForTopic;
import com.tencent.mm.plugin.finder.video.y;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioPath", "", "getAudioPath", "()Ljava/lang/String;", "setAudioPath", "(Ljava/lang/String;)V", "bgmPlayBtn", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "getBgmPlayBtn", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "setBgmPlayBtn", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;)V", "copyrightRestrictionListener", "Landroid/view/View$OnClickListener;", "currentListener", "getCurrentListener", "()Landroid/view/View$OnClickListener;", "setCurrentListener", "(Landroid/view/View$OnClickListener;)V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "downloadFinish", "", "getDownloadFinish", "()Z", "setDownloadFinish", "(Z)V", "filePath", "getFilePath", "setFilePath", "finderBgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getFinderBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "setFinderBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;)V", "isFirstClickPlay", "setFirstClickPlay", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "setMedia", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "originFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getOriginFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setOriginFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "pauseMusicListener", "pauseVideoListener", "playMusicListener", "playVideoListener", "preCheckHelper", "Lcom/tencent/mm/plugin/finder/live/ui/post/PostPreCheckUIC;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "tabType", "getTabType", "()I", "setTabType", "(I)V", "type", "getType", "setType", "videoView", "Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "getVideoView", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "setVideoView", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;)V", "bindOriginFeed", "", "feed", "bgmInfo", "flag", "checkVideoDataAvailable", "mediaId", "offset", "length", "extractAudioTrack", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "initView", "isCopyrightRestriction", "isFileLegal", "path", "onDetachedFromWindow", "onDettach", "onFinishDownload", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onFollowBtnClick", "onMoovReadyDownload", "total", "moovFirstDownloaded", "onProgressDownload", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStartDownload", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "result", "onWindowFocusChanged", "hasWindowFocus", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderFollowTopicHeaderView
  extends ConstraintLayout
  implements com.tencent.mm.an.i, y
{
  public static final a zBM;
  private HashMap _$_findViewCache;
  public int fEH;
  public String filePath;
  public volatile boolean foE;
  private s oTk;
  public int type;
  public com.tencent.mm.plugin.finder.live.ui.post.d wZA;
  public ble wZz;
  public bkq zBA;
  public aa zBB;
  boolean zBC;
  public AudioCacheInfo zBD;
  public FinderImgFeedMusicTag zBE;
  private String zBF;
  private View.OnClickListener zBG;
  public View.OnClickListener zBH;
  private View.OnClickListener zBI;
  public View.OnClickListener zBJ;
  private View.OnClickListener zBK;
  public View.OnClickListener zBL;
  public FinderVideoViewForTopic zBy;
  public FinderItem zBz;
  
  static
  {
    AppMethodBeat.i(278832);
    zBM = new a((byte)0);
    AppMethodBeat.o(278832);
  }
  
  public FinderFollowTopicHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(278828);
    this.zBC = true;
    this.filePath = "";
    this.zBF = "";
    this.zBH = ((View.OnClickListener)new q(this));
    this.zBI = ((View.OnClickListener)new o(this));
    this.zBJ = ((View.OnClickListener)new p(this));
    this.zBK = ((View.OnClickListener)new n(this));
    this.zBL = ((View.OnClickListener)new g(this));
    bv(paramContext);
    AppMethodBeat.o(278828);
  }
  
  public FinderFollowTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(278829);
    this.zBC = true;
    this.filePath = "";
    this.zBF = "";
    this.zBH = ((View.OnClickListener)new q(this));
    this.zBI = ((View.OnClickListener)new o(this));
    this.zBJ = ((View.OnClickListener)new p(this));
    this.zBK = ((View.OnClickListener)new n(this));
    this.zBL = ((View.OnClickListener)new g(this));
    bv(paramContext);
    AppMethodBeat.o(278829);
  }
  
  public FinderFollowTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(278831);
    this.zBC = true;
    this.filePath = "";
    this.zBF = "";
    this.zBH = ((View.OnClickListener)new q(this));
    this.zBI = ((View.OnClickListener)new o(this));
    this.zBJ = ((View.OnClickListener)new p(this));
    this.zBK = ((View.OnClickListener)new n(this));
    this.zBL = ((View.OnClickListener)new g(this));
    bv(paramContext);
    AppMethodBeat.o(278831);
  }
  
  public static boolean Oi(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean aDw(String paramString)
  {
    AppMethodBeat.i(278810);
    if ((com.tencent.mm.pluginsdk.k.a.d.a.agG(paramString)) && (com.tencent.mm.pluginsdk.k.a.d.a.ij(paramString) > 0L))
    {
      AppMethodBeat.o(278810);
      return true;
    }
    AppMethodBeat.o(278810);
    return false;
  }
  
  private final void bPQ()
  {
    AppMethodBeat.i(278812);
    final com.tencent.mm.plugin.finder.view.e locale = new com.tencent.mm.plugin.finder.view.e(getContext());
    locale.RB(b.g.finder_follow_topic_header_create_accoutn_bottom_sheet_layout);
    locale.oFW.findViewById(b.f.cancel).setOnClickListener((View.OnClickListener)new r(this, locale));
    locale.oFW.findViewById(b.f.create_account).setOnClickListener((View.OnClickListener)new s(this, locale));
    locale.eik();
    AppMethodBeat.o(278812);
  }
  
  private final void bv(Context paramContext)
  {
    AppMethodBeat.i(278807);
    ad.kS(paramContext).inflate(b.g.finder_follow_topic_feed_header, (ViewGroup)this, true);
    int i = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_1_5_A);
    int j = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_2A);
    setPadding(j, i, j, i);
    this.zBy = ((FinderVideoViewForTopic)findViewById(b.f.video_view));
    View localView = findViewById(b.f.follow_btn_tv);
    p.j(localView, "this.findViewById<TextView>(R.id.follow_btn_tv)");
    ar.a((Paint)((TextView)localView).getPaint(), 0.8F);
    com.tencent.mm.kernel.h.aGY().a(3761, (com.tencent.mm.an.i)this);
    if (paramContext == null)
    {
      paramContext = new kotlin.t("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
      AppMethodBeat.o(278807);
      throw paramContext;
    }
    this.wZA = new com.tencent.mm.plugin.finder.live.ui.post.d((AppCompatActivity)paramContext);
    AppMethodBeat.o(278807);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(278839);
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
    AppMethodBeat.o(278839);
    return localView1;
  }
  
  public final void a(int paramInt1, int paramInt2, ac paramac)
  {
    AppMethodBeat.i(278826);
    p.k(paramac, "video");
    Log.i("FinderFollowTopicHeaderView", "[onProgressDownload] offset:" + paramInt1 + ',' + paramInt2);
    AppMethodBeat.o(278826);
  }
  
  public final void a(int paramInt1, int paramInt2, ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(278825);
    p.k(paramac, "video");
    Log.i("FinderFollowTopicHeaderView", "[onMoovReadyDownload]");
    AppMethodBeat.o(278825);
  }
  
  public final void a(final int paramInt, final ac paramac, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(278823);
    p.k(paramac, "video");
    Log.i("FinderFollowTopicHeaderView", "[onFinishDownload] videoPath = " + paramac.getPath());
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.foE = bool;
      if (!this.foE) {
        break label198;
      }
      if (this.zBA == null) {
        break;
      }
      a(paramac);
      paramd = this.oTk;
      if ((paramd != null) && (paramd.isShowing() == true))
      {
        paramd = this.oTk;
        if (paramd != null) {
          paramd.dismiss();
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, paramac, paramInt));
      }
      Log.i("FinderFollowTopicHeaderView", "[onFinishDownload] ret = " + paramInt + ",fileExist = " + com.tencent.mm.pluginsdk.k.a.d.a.agG(paramac.getPath()) + ",fileSize = " + com.tencent.mm.pluginsdk.k.a.d.a.ij(paramac.getPath()));
      AppMethodBeat.o(278823);
      return;
    }
    AppMethodBeat.o(278823);
    return;
    label198:
    Toast.makeText(getContext(), b.j.finder_follow_header_music_err, 0).show();
    com.tencent.mm.plugin.report.service.h.IzE.p(1530L, 1L, 1L);
    AppMethodBeat.o(278823);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(278820);
    Object localObject1 = this.zBA;
    if (localObject1 != null)
    {
      Object localObject2 = (CharSequence)((bkq)localObject1).audioTrackUrl;
      int i;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject2 = av.AJz;
          localObject2 = ((bkq)localObject1).groupId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "emptyid_" + System.currentTimeMillis();
          }
          localObject1 = av.aGd((String)localObject1);
          if (aDw((String)localObject1))
          {
            Log.i("FinderFollowTopicHeaderView", "audio length = " + (float)com.tencent.mm.pluginsdk.k.a.d.a.ij((String)localObject1) / 1024.0F / 1024.0F + 'M');
            this.zBF = ((String)localObject1);
            AppMethodBeat.o(278820);
            return;
            i = 0;
          }
          else
          {
            Log.i("FinderFollowTopicHeaderView", "audio:" + (String)localObject1 + " track no exist");
            localObject2 = com.tencent.mm.plugin.vlog.remux.a.Nqc;
            if (com.tencent.mm.plugin.vlog.remux.a.lH(paramac.getPath(), (String)localObject1))
            {
              Log.i("FinderFollowTopicHeaderView", "[SimpleAudioExtractor] true");
              Log.i("FinderFollowTopicHeaderView", "audio length = " + (float)com.tencent.mm.pluginsdk.k.a.d.a.ij((String)localObject1) / 1024.0F / 1024.0F + 'M');
              paramac = MultiMediaVideoChecker.NmA;
              if (localObject1 != null) {
                break label399;
              }
            }
          }
        }
      }
    }
    label399:
    for (paramac = "";; paramac = (ac)localObject1)
    {
      paramac = MultiMediaVideoChecker.bft(paramac);
      if ((paramac == null) || (paramac.duration == 0L))
      {
        Log.i("FinderFollowTopicHeaderView", "no audio track");
        this.foE = false;
        ((LinearLayout)_$_findCachedViewById(b.f.follow_btn)).setOnClickListener(this.zBL);
        AppMethodBeat.o(278820);
        return;
      }
      this.zBF = ((String)localObject1);
      AppMethodBeat.o(278820);
      return;
      Log.i("FinderFollowTopicHeaderView", "[SimpleAudioExtractor] false");
      Toast.makeText(getContext(), b.j.finder_follow_header_music_err, 0).show();
      this.foE = false;
      ((LinearLayout)_$_findCachedViewById(b.f.follow_btn)).setOnClickListener(this.zBL);
      com.tencent.mm.plugin.report.service.h.IzE.p(1530L, 0L, 1L);
      AppMethodBeat.o(278820);
      return;
      AppMethodBeat.o(278820);
      return;
    }
  }
  
  public final void a(ac paramac, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(278822);
    p.k(paramac, "video");
    Log.i("FinderFollowTopicHeaderView", "[onStopDownload]");
    AppMethodBeat.o(278822);
  }
  
  public final void ae(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(278824);
    p.k(paramString, "mediaId");
    Log.i("FinderFollowTopicHeaderView", "[checkVideoDataAvailable]");
    AppMethodBeat.o(278824);
  }
  
  public final void b(ac paramac)
  {
    AppMethodBeat.i(278821);
    p.k(paramac, "video");
    Log.i("FinderFollowTopicHeaderView", "[onStartDownload]");
    AppMethodBeat.o(278821);
  }
  
  public final void dLa()
  {
    AppMethodBeat.i(278815);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    switch (com.tencent.mm.plugin.finder.utils.aj.eei())
    {
    default: 
      Log.d("FinderFollowTopicHeaderView", "not one of six state");
    case 3: 
    case 6: 
      if (this.foE) {
        break label233;
      }
      if (this.oTk == null)
      {
        this.oTk = s.a(getContext(), (CharSequence)getContext().getString(b.j.finder_follow_header_downloading_wait), true, 2, null);
        AppMethodBeat.o(278815);
        return;
      }
      break;
    case 1: 
      w.makeText(getContext(), b.j.finder_no_post_quality_tips, 0).show();
      AppMethodBeat.o(278815);
      return;
    case 2: 
      bPQ();
      AppMethodBeat.o(278815);
      return;
    case 4: 
      w.makeText(getContext(), b.j.finder_account_forbid, 0).show();
      AppMethodBeat.o(278815);
      return;
    case 5: 
      w.makeText(getContext(), b.j.finder_self_contact_reviewing, 0).show();
      AppMethodBeat.o(278815);
      return;
    }
    localObject1 = this.oTk;
    if (localObject1 != null)
    {
      if (!((s)localObject1).isShowing())
      {
        localObject1 = this.oTk;
        if (localObject1 != null)
        {
          ((s)localObject1).show();
          AppMethodBeat.o(278815);
        }
      }
    }
    else
    {
      AppMethodBeat.o(278815);
      return;
    }
    AppMethodBeat.o(278815);
    return;
    label233:
    localObject1 = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGS("post"))
    {
      AppMethodBeat.o(278815);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
    localObject1 = getContext();
    p.j(localObject1, "context");
    com.tencent.mm.plugin.finder.utils.a.fE((Context)localObject1);
    localObject1 = k.zWs;
    k.av(6, false);
    localObject1 = this.wZA;
    if ((localObject1 != null) && (!((com.tencent.mm.plugin.finder.live.ui.post.d)localObject1).a((kotlin.g.a.a)new i(this), (kotlin.g.a.a)new j(this))))
    {
      AppMethodBeat.o(278815);
      return;
    }
    localObject1 = new com.tencent.mm.ui.widget.a.e(getContext(), 1, true);
    View localView = ad.kS(getContext()).inflate(b.g.finder_sheet_header, null);
    Object localObject4 = (TextView)localView.findViewById(b.f.nickname);
    Object localObject2 = (ImageView)localView.findViewById(b.f.avatar);
    Object localObject3 = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject3 = d.a.aAK(z.bdh());
    if (localObject3 != null)
    {
      p.j(localObject4, "nicknameTv");
      ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.i)localObject3).getNickname()));
      localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject4 = com.tencent.mm.plugin.finder.loader.t.dJh();
      localObject3 = new com.tencent.mm.plugin.finder.loader.e(((com.tencent.mm.plugin.finder.api.i)localObject3).field_avatarUrl);
      p.j(localObject2, "avatarIv");
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject4).a(localObject3, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
    }
    localObject2 = new StringBuilder();
    p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
    localObject2 = com.tencent.mm.kernel.b.aGq() + '_' + Util.nowMilliSecond();
    localObject3 = k.zWs;
    k.aEa((String)localObject2);
    ((com.tencent.mm.ui.widget.a.e)localObject1).Z(localView, true);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((q.f)k.zBU);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((q.g)new l(this, (String)localObject2));
    ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)m.zBV);
    ((com.tencent.mm.ui.widget.a.e)localObject1).eik();
    AppMethodBeat.o(278815);
  }
  
  public final AudioCacheInfo getAudioInfo()
  {
    return this.zBD;
  }
  
  public final String getAudioPath()
  {
    return this.zBF;
  }
  
  public final FinderImgFeedMusicTag getBgmPlayBtn()
  {
    return this.zBE;
  }
  
  public final View.OnClickListener getCurrentListener()
  {
    return this.zBG;
  }
  
  public final s getDialog()
  {
    return this.oTk;
  }
  
  public final boolean getDownloadFinish()
  {
    return this.foE;
  }
  
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  public final bkq getFinderBgmInfo()
  {
    return this.zBA;
  }
  
  public final aa getMedia()
  {
    return this.zBB;
  }
  
  public final FinderItem getOriginFeed()
  {
    return this.zBz;
  }
  
  public final int getTabType()
  {
    return this.fEH;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final FinderVideoViewForTopic getVideoView()
  {
    return this.zBy;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(278818);
    super.onDetachedFromWindow();
    Log.d("FinderFollowTopicHeaderView", "[onDetachedFromWindow] onViewRecycled");
    AppMethodBeat.o(278818);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(278808);
    com.tencent.mm.plugin.finder.live.ui.post.d locald = this.wZA;
    if (locald != null) {
      locald.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof ch))) {
      this.wZz = ((ch)paramq).dnR();
    }
    AppMethodBeat.o(278808);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(278817);
    super.onWindowFocusChanged(paramBoolean);
    if ((!paramBoolean) && ((p.h(this.zBG, this.zBI)) || (p.h(this.zBG, this.zBK))))
    {
      WeImageView localWeImageView = (WeImageView)_$_findCachedViewById(b.f.finder_music_play_btn_ui);
      if (localWeImageView != null)
      {
        localWeImageView.performClick();
        AppMethodBeat.o(278817);
        return;
      }
    }
    AppMethodBeat.o(278817);
  }
  
  public final void setAudioInfo(AudioCacheInfo paramAudioCacheInfo)
  {
    this.zBD = paramAudioCacheInfo;
  }
  
  public final void setAudioPath(String paramString)
  {
    AppMethodBeat.i(278805);
    p.k(paramString, "<set-?>");
    this.zBF = paramString;
    AppMethodBeat.o(278805);
  }
  
  public final void setBgmPlayBtn(FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
  {
    this.zBE = paramFinderImgFeedMusicTag;
  }
  
  public final void setCurrentListener(View.OnClickListener paramOnClickListener)
  {
    this.zBG = paramOnClickListener;
  }
  
  public final void setDialog(s params)
  {
    this.oTk = params;
  }
  
  public final void setDownloadFinish(boolean paramBoolean)
  {
    this.foE = paramBoolean;
  }
  
  public final void setFilePath(String paramString)
  {
    AppMethodBeat.i(278804);
    p.k(paramString, "<set-?>");
    this.filePath = paramString;
    AppMethodBeat.o(278804);
  }
  
  public final void setFinderBgmInfo(bkq parambkq)
  {
    this.zBA = parambkq;
  }
  
  public final void setFirstClickPlay(boolean paramBoolean)
  {
    this.zBC = paramBoolean;
  }
  
  public final void setMedia(aa paramaa)
  {
    this.zBB = paramaa;
  }
  
  public final void setOriginFeed(FinderItem paramFinderItem)
  {
    this.zBz = paramFinderItem;
  }
  
  public final void setTabType(int paramInt)
  {
    this.fEH = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final void setVideoView(FinderVideoViewForTopic paramFinderVideoViewForTopic)
  {
    this.zBy = paramFinderVideoViewForTopic;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$Companion;", "", "()V", "TAG", "", "TYPE_FEED_VIDEO", "", "TYPE_PURE_MUSIC", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$3$1"})
  public static final class b
    implements View.OnClickListener
  {
    public b(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, bkq parambkq) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(284566);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      Intent localIntent = new Intent();
      localObject = this.zBO.contact;
      if (localObject != null) {}
      for (localObject = ((FinderContact)localObject).username;; localObject = null)
      {
        localIntent.putExtra("finder_username", (String)localObject);
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject = this.zBN.getContext();
        p.j(localObject, "context");
        aj.a.a((Context)localObject, localIntent, 0L, 6, false, 64);
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        p.j(paramView, "it");
        paramView = paramView.getContext();
        p.j(paramView, "it.context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284566);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "filepath", "", "invoke", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$6$2"})
  public static final class c
    extends kotlin.g.b.q
    implements m<Boolean, String, x>
  {
    public c(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "filepath", "", "invoke"})
  public static final class d
    extends kotlin.g.b.q
    implements m<Boolean, String, x>
  {
    public d(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class e
    implements View.OnClickListener
  {
    public e(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279057);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      w.makeText(this.zBN.getContext(), b.j.finder_follow_header_music_invaild_toast, 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279057);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class f
    implements View.OnClickListener
  {
    public f(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269777);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (FinderFollowTopicHeaderView.Oj(this.zBS)) {
        FinderFollowTopicHeaderView.a(this.zBN).onClick(paramView);
      }
      for (;;)
      {
        paramView = k.zWs;
        k.R(false, 6);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(269777);
        return;
        this.zBN.dLa();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(276947);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$copyrightRestrictionListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.zBN.getFinderBgmInfo();
      if (paramView != null)
      {
        paramView = paramView.musicInfo;
        if (paramView == null) {
          break label149;
        }
        w.makeText(this.zBN.getContext(), b.j.finder_can_not_follow_music, 0).show();
        label72:
        paramView = n.zWF;
        localObject = this.zBN.getContext();
        p.j(localObject, "context");
        paramView = this.zBN.getOriginFeed();
        if (paramView == null) {
          break label169;
        }
        paramView = paramView.getFeedObject();
        if (paramView == null) {
          break label169;
        }
      }
      label149:
      label169:
      for (paramView = Integer.valueOf(paramView.follow_feed_count);; paramView = null)
      {
        n.a((Context)localObject, 2, 4, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$copyrightRestrictionListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276947);
        return;
        paramView = null;
        break;
        w.makeText(this.zBN.getContext(), b.j.finder_can_not_follow_feed_bgm, 0).show();
        break label72;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$onFinishDownload$1$1"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, ac paramac, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class k
    implements q.f
  {
    public static final k zBU;
    
    static
    {
      AppMethodBeat.i(279597);
      zBU = new k();
      AppMethodBeat.o(279597);
    }
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(279596);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.mn(1001, b.j.app_field_mmsight);
        paramo.mn(1002, b.j.app_field_select_new_pic);
      }
      AppMethodBeat.o(279596);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements q.g
  {
    l(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      Object localObject6 = null;
      Object localObject7 = null;
      AppMethodBeat.i(274771);
      Intent localIntent = new Intent();
      p.j(paramMenuItem, "menuItem");
      Object localObject2;
      Object localObject3;
      Object localObject5;
      Object localObject1;
      Object localObject4;
      if (paramMenuItem.getItemId() == 1001)
      {
        localIntent.putExtra("key_finder_post_router", 2);
        localObject2 = "";
        localObject3 = "";
        localObject5 = "";
        if (this.zBN.getType() != 1) {
          break label453;
        }
        localObject3 = this.zBN.getAudioPath();
        paramMenuItem = this.zBN.getFinderBgmInfo();
        if (paramMenuItem != null)
        {
          localObject1 = paramMenuItem.groupId;
          paramMenuItem = (MenuItem)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramMenuItem = "-1";
        }
        localObject1 = this.zBN.getFinderBgmInfo();
        if (localObject1 != null)
        {
          localObject2 = ((bkq)localObject1).audioTrackUrl;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localObject5 = null;
        localObject4 = localObject1;
        localObject2 = paramMenuItem;
        localObject1 = localObject5;
        paramMenuItem = (MenuItem)localObject4;
        label149:
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", (String)localObject2);
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", (String)localObject3);
        if (localObject1 == null) {
          break label721;
        }
        localObject1 = ((bfg)localObject1).toByteArray();
        label178:
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", (byte[])localObject1);
        localObject1 = this.zBN.getFinderBgmInfo();
        if (localObject1 == null) {
          break label726;
        }
        localObject1 = ((bkq)localObject1).contact;
        if (localObject1 == null) {
          break label726;
        }
        localObject1 = ((FinderContact)localObject1).username;
        label213:
        localIntent.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", p.h(localObject1, z.bdh()));
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", paramMenuItem);
        paramMenuItem = this.zBN.getFinderBgmInfo();
        if (paramMenuItem == null) {
          break label731;
        }
        paramMenuItem = paramMenuItem.musicInfo;
        label254:
        if (paramMenuItem == null) {
          break label736;
        }
        localObject1 = this.zBN.getFinderBgmInfo();
        paramMenuItem = localObject7;
        if (localObject1 != null)
        {
          localObject1 = ((bkq)localObject1).musicInfo;
          paramMenuItem = localObject7;
          if (localObject1 != null) {
            paramMenuItem = ((bfg)localObject1).name;
          }
        }
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", String.valueOf(paramMenuItem));
        label302:
        Log.i("FinderFollowTopicHeaderView", "tabType " + this.zBN.getTabType());
        switch (this.zBN.getTabType())
        {
        case 2: 
        default: 
          paramInt = 5;
        }
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", paramInt);
        localIntent.putExtra("key_finder_post_id", this.xNP);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramMenuItem = this.zBN.getContext();
        p.j(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(paramMenuItem, localIntent);
        AppMethodBeat.o(274771);
        return;
        if (paramMenuItem.getItemId() != 1002) {
          break;
        }
        localIntent.putExtra("key_finder_post_router", 3);
        break;
        label453:
        if (this.zBN.getType() == 2)
        {
          paramMenuItem = this.zBN.getAudioInfo();
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.cachePath;
            paramMenuItem = (MenuItem)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramMenuItem = "";
          }
          localObject1 = this.zBN.getFinderBgmInfo();
          if (localObject1 != null)
          {
            localObject2 = ((bkq)localObject1).groupId;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "-1";
          }
          localObject4 = this.zBN.getFinderBgmInfo();
          localObject2 = paramMenuItem;
          localObject3 = localObject1;
          if (localObject4 != null)
          {
            bfg localbfg = ((bkq)localObject4).musicInfo;
            localObject2 = paramMenuItem;
            localObject3 = localObject1;
            if (localbfg != null)
            {
              localObject3 = localbfg.SPV;
              localObject2 = localObject3;
              if (localObject3 == null) {
                localObject2 = "";
              }
              localObject4 = new bfg();
              localObject3 = this.zBN.getFinderBgmInfo();
              if (localObject3 != null)
              {
                localObject5 = ((bkq)localObject3).groupId;
                localObject3 = localObject5;
                if (localObject5 != null) {}
              }
              else
              {
                localObject3 = "";
              }
              ((bfg)localObject4).BHW = ((String)localObject3);
              localObject5 = localbfg.SPV;
              localObject3 = localObject5;
              if (localObject5 == null) {
                localObject3 = "";
              }
              ((bfg)localObject4).SPV = ((String)localObject3);
              ((bfg)localObject4).artist = localbfg.artist;
              ((bfg)localObject4).name = localbfg.name;
              localObject3 = localObject4;
              localObject4 = localObject1;
              localObject5 = paramMenuItem;
              paramMenuItem = (MenuItem)localObject2;
              localObject1 = localObject3;
              localObject2 = localObject4;
              localObject3 = localObject5;
              break label149;
            }
          }
        }
        localObject1 = null;
        localObject4 = localObject2;
        paramMenuItem = (MenuItem)localObject5;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break label149;
        label721:
        localObject1 = null;
        break label178;
        label726:
        localObject1 = null;
        break label213;
        label731:
        paramMenuItem = null;
        break label254;
        label736:
        localObject1 = new StringBuilder();
        localObject2 = this.zBN.getFinderBgmInfo();
        paramMenuItem = localObject6;
        if (localObject2 != null)
        {
          localObject2 = ((bkq)localObject2).contact;
          paramMenuItem = localObject6;
          if (localObject2 != null) {
            paramMenuItem = ((FinderContact)localObject2).nickname;
          }
        }
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", paramMenuItem + "的动态原声");
        break label302;
        paramInt = 5;
        continue;
        paramInt = 7;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class m
    implements e.b
  {
    public static final m zBV;
    
    static
    {
      AppMethodBeat.i(273351);
      zBV = new m();
      AppMethodBeat.o(273351);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(273350);
      k localk = k.zWs;
      k.Pw(6);
      AppMethodBeat.o(273350);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282118);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.zBN.getBgmPlayBtn();
      if (paramView != null) {
        paramView.bnt();
      }
      ((WeImageView)this.zBN._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setImageDrawable(au.o(this.zBN.getContext(), b.i.finder_music_follow_topic_play_icon, com.tencent.mm.ci.a.w(this.zBN.getContext(), b.c.FG_0)));
      ((WeImageView)this.zBN._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setOnClickListener(FinderFollowTopicHeaderView.f(this.zBN));
      this.zBN.setCurrentListener(FinderFollowTopicHeaderView.f(this.zBN));
      paramView = n.zWF;
      localObject = this.zBN.getContext();
      p.j(localObject, "context");
      paramView = this.zBN.getOriginFeed();
      if (paramView != null)
      {
        paramView = paramView.getFeedObject();
        if (paramView == null) {}
      }
      for (paramView = Integer.valueOf(paramView.follow_feed_count);; paramView = null)
      {
        n.a((Context)localObject, 2, 3, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(282118);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279501);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.zBN.getVideoView();
      if (paramView != null)
      {
        ((WeImageView)this.zBN._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setImageDrawable(au.o(this.zBN.getContext(), b.i.finder_music_follow_topic_play_icon, com.tencent.mm.ci.a.w(this.zBN.getContext(), b.c.FG_0)));
        paramView.pause();
        ((WeImageView)this.zBN._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setOnClickListener(FinderFollowTopicHeaderView.d(this.zBN));
        this.zBN.setCurrentListener(FinderFollowTopicHeaderView.d(this.zBN));
        paramView = n.zWF;
        localObject = this.zBN.getContext();
        p.j(localObject, "context");
        paramView = this.zBN.getOriginFeed();
        if (paramView == null) {
          break label202;
        }
        paramView = paramView.getFeedObject();
        if (paramView == null) {
          break label202;
        }
      }
      label202:
      for (paramView = Integer.valueOf(paramView.follow_feed_count);; paramView = null)
      {
        n.a((Context)localObject, 2, 3, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279501);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(284930);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.zBN.getBgmPlayBtn();
      if (paramView != null) {
        paramView.dLf();
      }
      ((WeImageView)this.zBN._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setImageDrawable(au.o(this.zBN.getContext(), b.i.finder_music_follow_topic_pause_icon, com.tencent.mm.ci.a.w(this.zBN.getContext(), b.c.FG_0)));
      ((WeImageView)this.zBN._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setOnClickListener(FinderFollowTopicHeaderView.e(this.zBN));
      this.zBN.setCurrentListener(FinderFollowTopicHeaderView.e(this.zBN));
      paramView = n.zWF;
      localObject = this.zBN.getContext();
      p.j(localObject, "context");
      paramView = this.zBN.getOriginFeed();
      if (paramView != null)
      {
        paramView = paramView.getFeedObject();
        if (paramView == null) {}
      }
      for (paramView = Integer.valueOf(paramView.follow_feed_count);; paramView = null)
      {
        n.a((Context)localObject, 2, 2, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284930);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285750);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.zBN.getVideoView();
      if (paramView != null)
      {
        if (!this.zBN.zBC) {
          break label227;
        }
        this.zBN.setFirstClickPlay(false);
        paramView.setMute(false);
        paramView.a(0.0D, true);
        ((WeImageView)this.zBN._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setImageDrawable(au.o(this.zBN.getContext(), b.i.finder_music_follow_topic_pause_icon, com.tencent.mm.ci.a.w(this.zBN.getContext(), b.c.FG_0)));
        ((WeImageView)this.zBN._$_findCachedViewById(b.f.finder_music_play_btn_ui)).setOnClickListener(FinderFollowTopicHeaderView.c(this.zBN));
        this.zBN.setCurrentListener(FinderFollowTopicHeaderView.c(this.zBN));
        paramView = n.zWF;
        localObject = this.zBN.getContext();
        p.j(localObject, "context");
        paramView = this.zBN.getOriginFeed();
        if (paramView == null) {
          break label235;
        }
        paramView = paramView.getFeedObject();
        if (paramView == null) {
          break label235;
        }
      }
      label227:
      label235:
      for (paramView = Integer.valueOf(paramView.follow_feed_count);; paramView = null)
      {
        n.a((Context)localObject, 2, 2, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285750);
        return;
        paramView.bqo();
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$1$1"})
  static final class r
    implements View.OnClickListener
  {
    r(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, com.tencent.mm.plugin.finder.view.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(272502);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      locale.bYF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(272502);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$1$2"})
  static final class s
    implements View.OnClickListener
  {
    s(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, com.tencent.mm.plugin.finder.view.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(264423);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (AndroidContextUtil.castActivityOrNull(this.zBN.getContext()) != null)
      {
        paramView = new Intent();
        paramView.putExtra("key_create_scene", 12);
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject = this.zBN.getContext();
        p.j(localObject, "context");
        com.tencent.mm.plugin.finder.utils.a.w((Context)localObject, paramView);
      }
      locale.bYF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264423);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView
 * JD-Core Version:    0.7.0.1
 */
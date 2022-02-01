package com.tencent.mm.plugin.finder.music;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.constraint.ConstraintLayout;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoViewForTopic;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView;", "Landroid/support/constraint/ConstraintLayout;", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioPath", "", "getAudioPath", "()Ljava/lang/String;", "setAudioPath", "(Ljava/lang/String;)V", "bgmPlayBtn", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "getBgmPlayBtn", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "setBgmPlayBtn", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;)V", "copyrightRestrictionListener", "Landroid/view/View$OnClickListener;", "currentListener", "getCurrentListener", "()Landroid/view/View$OnClickListener;", "setCurrentListener", "(Landroid/view/View$OnClickListener;)V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "downloadFinish", "", "getDownloadFinish", "()Z", "setDownloadFinish", "(Z)V", "filePath", "getFilePath", "setFilePath", "finderBgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getFinderBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "setFinderBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;)V", "isFirstClickPlay", "setFirstClickPlay", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "setMedia", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "originFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getOriginFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setOriginFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "pauseMusicListener", "pauseVideoListener", "playMusicListener", "playVideoListener", "tabType", "getTabType", "()I", "setTabType", "(I)V", "type", "getType", "setType", "videoView", "Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "getVideoView", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;", "setVideoView", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoViewForTopic;)V", "bindOriginFeed", "", "feed", "bgmInfo", "flag", "checkVideoDataAvailable", "mediaId", "offset", "length", "extractAudioTrack", "video", "initView", "isCopyrightRestriction", "isFileLegal", "path", "onDetachedFromWindow", "onDettach", "onFinishDownload", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onFollowBtnClick", "onMoovReadyDownload", "total", "moovFirstDownloaded", "onProgressDownload", "onStartDownload", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "result", "onWindowFocusChanged", "hasWindowFocus", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderFollowTopicHeaderView
  extends ConstraintLayout
  implements com.tencent.mm.plugin.finder.video.x
{
  public static final a uPq;
  private HashMap _$_findViewCache;
  public int dLS;
  public volatile boolean dvV;
  public String filePath;
  private com.tencent.mm.ui.base.q nUq;
  public int type;
  public FinderVideoViewForTopic uPc;
  public FinderItem uPd;
  public bdr uPe;
  public s uPf;
  boolean uPg;
  public AudioCacheInfo uPh;
  public FinderImgFeedMusicTag uPi;
  private String uPj;
  private View.OnClickListener uPk;
  public View.OnClickListener uPl;
  private View.OnClickListener uPm;
  public View.OnClickListener uPn;
  private View.OnClickListener uPo;
  public View.OnClickListener uPp;
  
  static
  {
    AppMethodBeat.i(248914);
    uPq = new a((byte)0);
    AppMethodBeat.o(248914);
  }
  
  public FinderFollowTopicHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(248911);
    this.uPg = true;
    this.filePath = "";
    this.uPj = "";
    this.uPl = ((View.OnClickListener)new o(this));
    this.uPm = ((View.OnClickListener)new m(this));
    this.uPn = ((View.OnClickListener)new n(this));
    this.uPo = ((View.OnClickListener)new l(this));
    this.uPp = ((View.OnClickListener)new g(this));
    bh(paramContext);
    AppMethodBeat.o(248911);
  }
  
  public FinderFollowTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(248912);
    this.uPg = true;
    this.filePath = "";
    this.uPj = "";
    this.uPl = ((View.OnClickListener)new o(this));
    this.uPm = ((View.OnClickListener)new m(this));
    this.uPn = ((View.OnClickListener)new n(this));
    this.uPo = ((View.OnClickListener)new l(this));
    this.uPp = ((View.OnClickListener)new g(this));
    bh(paramContext);
    AppMethodBeat.o(248912);
  }
  
  public FinderFollowTopicHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248913);
    this.uPg = true;
    this.filePath = "";
    this.uPj = "";
    this.uPl = ((View.OnClickListener)new o(this));
    this.uPm = ((View.OnClickListener)new m(this));
    this.uPn = ((View.OnClickListener)new n(this));
    this.uPo = ((View.OnClickListener)new l(this));
    this.uPp = ((View.OnClickListener)new g(this));
    bh(paramContext);
    AppMethodBeat.o(248913);
  }
  
  public static boolean Jv(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean auj(String paramString)
  {
    AppMethodBeat.i(248899);
    if ((com.tencent.mm.pluginsdk.j.a.d.a.YS(paramString)) && (com.tencent.mm.pluginsdk.j.a.d.a.hv(paramString) > 0L))
    {
      AppMethodBeat.o(248899);
      return true;
    }
    AppMethodBeat.o(248899);
    return false;
  }
  
  private final void bEq()
  {
    AppMethodBeat.i(248900);
    final com.tencent.mm.plugin.finder.view.d locald = new com.tencent.mm.plugin.finder.view.d(getContext());
    locald.Ml(2131494322);
    locald.lJI.findViewById(2131297959).setOnClickListener((View.OnClickListener)new p(this, locald));
    locald.lJI.findViewById(2131299317).setOnClickListener((View.OnClickListener)new q(this, locald));
    locald.dGm();
    AppMethodBeat.o(248900);
  }
  
  private final void bh(Context paramContext)
  {
    AppMethodBeat.i(248898);
    aa.jQ(paramContext).inflate(2131494321, (ViewGroup)this, true);
    int i = paramContext.getResources().getDimensionPixelOffset(2131165289);
    int j = paramContext.getResources().getDimensionPixelOffset(2131165296);
    setPadding(j, i, j, i);
    this.uPc = ((FinderVideoViewForTopic)findViewById(2131309841));
    paramContext = findViewById(2131301649);
    p.g(paramContext, "this.findViewById<TextView>(R.id.follow_btn_tv)");
    ao.a((Paint)((TextView)paramContext).getPaint(), 0.8F);
    paramContext = new cd(11);
    com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramContext);
    AppMethodBeat.o(248898);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(248917);
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
    AppMethodBeat.o(248917);
    return localView1;
  }
  
  public final void a(int paramInt1, int paramInt2, s params)
  {
    AppMethodBeat.i(248910);
    p.h(params, "video");
    Log.i("FinderFollowTopicHeaderView", "[onProgressDownload] offset:" + paramInt1 + ',' + paramInt2);
    AppMethodBeat.o(248910);
  }
  
  public final void a(int paramInt1, int paramInt2, s params, boolean paramBoolean)
  {
    AppMethodBeat.i(248909);
    p.h(params, "video");
    Log.i("FinderFollowTopicHeaderView", "[onMoovReadyDownload]");
    AppMethodBeat.o(248909);
  }
  
  public final void a(final int paramInt, final s params, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(248907);
    p.h(params, "video");
    Log.i("FinderFollowTopicHeaderView", "[onFinishDownload] videoPath = " + params.getPath());
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.dvV = bool;
      if (!this.dvV) {
        break label192;
      }
      if (this.uPe == null) {
        break;
      }
      a(params);
      paramd = this.nUq;
      if ((paramd != null) && (paramd.isShowing() == true))
      {
        paramd = this.nUq;
        if (paramd != null) {
          paramd.dismiss();
        }
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new h(this, params, paramInt));
      }
      Log.i("FinderFollowTopicHeaderView", "[onFinishDownload] ret = " + paramInt + ",fileExist = " + com.tencent.mm.pluginsdk.j.a.d.a.YS(params.getPath()) + ",fileSize = " + com.tencent.mm.pluginsdk.j.a.d.a.hv(params.getPath()));
      AppMethodBeat.o(248907);
      return;
    }
    AppMethodBeat.o(248907);
    return;
    label192:
    Toast.makeText(getContext(), 2131759786, 0).show();
    com.tencent.mm.plugin.report.service.h.CyF.n(1530L, 1L, 1L);
    AppMethodBeat.o(248907);
  }
  
  public final void a(s params)
  {
    AppMethodBeat.i(248904);
    Object localObject1 = this.uPe;
    if (localObject1 != null)
    {
      Object localObject2 = (CharSequence)((bdr)localObject1).audioTrackUrl;
      int i;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject2 = al.waC;
          localObject2 = ((bdr)localObject1).groupId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "emptyid_" + System.currentTimeMillis();
          }
          localObject1 = al.awB((String)localObject1);
          if (auj((String)localObject1))
          {
            Log.i("FinderFollowTopicHeaderView", "audio length = " + (float)com.tencent.mm.pluginsdk.j.a.d.a.hv((String)localObject1) / 1024.0F / 1024.0F + 'M');
            this.uPj = ((String)localObject1);
            AppMethodBeat.o(248904);
            return;
            i = 0;
          }
          else
          {
            Log.i("FinderFollowTopicHeaderView", "audio:" + (String)localObject1 + " track no exist");
            localObject2 = am.waD;
            if (am.hi(params.getPath(), (String)localObject1))
            {
              Log.i("FinderFollowTopicHeaderView", "[SimpleAudioExtractor] true");
              Log.i("FinderFollowTopicHeaderView", "audio length = " + (float)com.tencent.mm.pluginsdk.j.a.d.a.hv((String)localObject1) / 1024.0F / 1024.0F + 'M');
              params = MultiMediaVideoChecker.GyY;
              if (localObject1 != null) {
                break label396;
              }
            }
          }
        }
      }
    }
    label396:
    for (params = "";; params = (s)localObject1)
    {
      params = MultiMediaVideoChecker.aTW(params);
      if ((params == null) || (params.duration == 0L))
      {
        Log.i("FinderFollowTopicHeaderView", "no audio track");
        this.dvV = false;
        ((LinearLayout)_$_findCachedViewById(2131301647)).setOnClickListener(this.uPp);
        AppMethodBeat.o(248904);
        return;
      }
      this.uPj = ((String)localObject1);
      AppMethodBeat.o(248904);
      return;
      Log.i("FinderFollowTopicHeaderView", "[SimpleAudioExtractor] false");
      Toast.makeText(getContext(), 2131759786, 0).show();
      this.dvV = false;
      ((LinearLayout)_$_findCachedViewById(2131301647)).setOnClickListener(this.uPp);
      com.tencent.mm.plugin.report.service.h.CyF.n(1530L, 0L, 1L);
      AppMethodBeat.o(248904);
      return;
      AppMethodBeat.o(248904);
      return;
    }
  }
  
  public final void a(s params, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(248906);
    p.h(params, "video");
    Log.i("FinderFollowTopicHeaderView", "[onStopDownload]");
    AppMethodBeat.o(248906);
  }
  
  public final void ac(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248908);
    p.h(paramString, "mediaId");
    Log.i("FinderFollowTopicHeaderView", "[checkVideoDataAvailable]");
    AppMethodBeat.o(248908);
  }
  
  public final void b(s params)
  {
    AppMethodBeat.i(248905);
    p.h(params, "video");
    Log.i("FinderFollowTopicHeaderView", "[onStartDownload]");
    AppMethodBeat.o(248905);
  }
  
  public final void dla()
  {
    AppMethodBeat.i(248901);
    Object localObject1 = y.vXH;
    switch (y.dCL())
    {
    default: 
      Log.d("FinderFollowTopicHeaderView", "not one of six state");
    case 3: 
    case 6: 
      if (this.dvV) {
        break label233;
      }
      if (this.nUq == null)
      {
        this.nUq = com.tencent.mm.ui.base.q.a(getContext(), (CharSequence)getContext().getString(2131759784), true, 2, null);
        AppMethodBeat.o(248901);
        return;
      }
      break;
    case 1: 
      u.makeText(getContext(), 2131760346, 0).show();
      AppMethodBeat.o(248901);
      return;
    case 2: 
      bEq();
      AppMethodBeat.o(248901);
      return;
    case 4: 
      u.makeText(getContext(), 2131759483, 0).show();
      AppMethodBeat.o(248901);
      return;
    case 5: 
      u.makeText(getContext(), 2131760533, 0).show();
      AppMethodBeat.o(248901);
      return;
    }
    localObject1 = this.nUq;
    if (localObject1 != null)
    {
      if (!((com.tencent.mm.ui.base.q)localObject1).isShowing())
      {
        localObject1 = this.nUq;
        if (localObject1 != null)
        {
          ((com.tencent.mm.ui.base.q)localObject1).show();
          AppMethodBeat.o(248901);
        }
      }
    }
    else
    {
      AppMethodBeat.o(248901);
      return;
    }
    AppMethodBeat.o(248901);
    return;
    label233:
    localObject1 = com.tencent.mm.plugin.finder.spam.a.vwk;
    if (com.tencent.mm.plugin.finder.spam.a.avp("post"))
    {
      AppMethodBeat.o(248901);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
    localObject1 = getContext();
    p.g(localObject1, "context");
    com.tencent.mm.plugin.finder.utils.a.fr((Context)localObject1);
    localObject1 = i.vfo;
    i.as(6, false);
    localObject1 = new e(getContext(), 1, true);
    View localView = aa.jQ(getContext()).inflate(2131494632, null);
    Object localObject4 = (TextView)localView.findViewById(2131305436);
    Object localObject2 = (ImageView)localView.findViewById(2131297119);
    Object localObject3 = c.tsp;
    localObject3 = c.a.asG(z.aUg());
    if (localObject3 != null)
    {
      p.g(localObject4, "nicknameTv");
      ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject3).getNickname()));
      localObject4 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject4 = com.tencent.mm.plugin.finder.loader.m.dka();
      localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject3).field_avatarUrl);
      p.g(localObject2, "avatarIv");
      com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject4).a(localObject3, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
    }
    localObject2 = new StringBuilder();
    p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
    localObject2 = com.tencent.mm.kernel.a.ayV() + '_' + Util.nowMilliSecond();
    localObject3 = i.vfo;
    i.auH((String)localObject2);
    ((e)localObject1).V(localView, true);
    ((e)localObject1).a((o.f)i.uPy);
    ((e)localObject1).a((o.g)new j(this, (String)localObject2));
    ((e)localObject1).b((e.b)k.uPA);
    ((e)localObject1).dGm();
    AppMethodBeat.o(248901);
  }
  
  public final AudioCacheInfo getAudioInfo()
  {
    return this.uPh;
  }
  
  public final String getAudioPath()
  {
    return this.uPj;
  }
  
  public final FinderImgFeedMusicTag getBgmPlayBtn()
  {
    return this.uPi;
  }
  
  public final View.OnClickListener getCurrentListener()
  {
    return this.uPk;
  }
  
  public final com.tencent.mm.ui.base.q getDialog()
  {
    return this.nUq;
  }
  
  public final boolean getDownloadFinish()
  {
    return this.dvV;
  }
  
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  public final bdr getFinderBgmInfo()
  {
    return this.uPe;
  }
  
  public final s getMedia()
  {
    return this.uPf;
  }
  
  public final FinderItem getOriginFeed()
  {
    return this.uPd;
  }
  
  public final int getTabType()
  {
    return this.dLS;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final FinderVideoViewForTopic getVideoView()
  {
    return this.uPc;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(248903);
    super.onDetachedFromWindow();
    Log.d("FinderFollowTopicHeaderView", "[onDetachedFromWindow] onViewRecycled");
    AppMethodBeat.o(248903);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(248902);
    super.onWindowFocusChanged(paramBoolean);
    if ((!paramBoolean) && ((p.j(this.uPk, this.uPm)) || (p.j(this.uPk, this.uPo))))
    {
      WeImageView localWeImageView = (WeImageView)_$_findCachedViewById(2131301373);
      if (localWeImageView != null)
      {
        localWeImageView.performClick();
        AppMethodBeat.o(248902);
        return;
      }
    }
    AppMethodBeat.o(248902);
  }
  
  public final void setAudioInfo(AudioCacheInfo paramAudioCacheInfo)
  {
    this.uPh = paramAudioCacheInfo;
  }
  
  public final void setAudioPath(String paramString)
  {
    AppMethodBeat.i(248897);
    p.h(paramString, "<set-?>");
    this.uPj = paramString;
    AppMethodBeat.o(248897);
  }
  
  public final void setBgmPlayBtn(FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
  {
    this.uPi = paramFinderImgFeedMusicTag;
  }
  
  public final void setCurrentListener(View.OnClickListener paramOnClickListener)
  {
    this.uPk = paramOnClickListener;
  }
  
  public final void setDialog(com.tencent.mm.ui.base.q paramq)
  {
    this.nUq = paramq;
  }
  
  public final void setDownloadFinish(boolean paramBoolean)
  {
    this.dvV = paramBoolean;
  }
  
  public final void setFilePath(String paramString)
  {
    AppMethodBeat.i(248896);
    p.h(paramString, "<set-?>");
    this.filePath = paramString;
    AppMethodBeat.o(248896);
  }
  
  public final void setFinderBgmInfo(bdr parambdr)
  {
    this.uPe = parambdr;
  }
  
  public final void setFirstClickPlay(boolean paramBoolean)
  {
    this.uPg = paramBoolean;
  }
  
  public final void setMedia(s params)
  {
    this.uPf = params;
  }
  
  public final void setOriginFeed(FinderItem paramFinderItem)
  {
    this.uPd = paramFinderItem;
  }
  
  public final void setTabType(int paramInt)
  {
    this.dLS = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final void setVideoView(FinderVideoViewForTopic paramFinderVideoViewForTopic)
  {
    this.uPc = paramFinderVideoViewForTopic;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$Companion;", "", "()V", "TAG", "", "TYPE_FEED_VIDEO", "", "TYPE_PURE_MUSIC", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$3$1"})
  public static final class b
    implements View.OnClickListener
  {
    public b(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, bdr parambdr) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248876);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      Intent localIntent = new Intent();
      localObject = this.uPs.contact;
      if (localObject != null) {}
      for (localObject = ((FinderContact)localObject).username;; localObject = null)
      {
        localIntent.putExtra("finder_username", (String)localObject);
        localObject = FinderReporterUIC.wzC;
        localObject = this.uPr.getContext();
        p.g(localObject, "context");
        FinderReporterUIC.a.a((Context)localObject, localIntent, 0L, 6, false, 64);
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        p.g(paramView, "it");
        paramView = paramView.getContext();
        p.g(paramView, "it.context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248876);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "filepath", "", "invoke", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$6$2"})
  public static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, String, kotlin.x>
  {
    public c(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "filepath", "", "invoke"})
  public static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, String, kotlin.x>
  {
    public d(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class e
    implements View.OnClickListener
  {
    public e(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248881);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      u.makeText(this.uPr.getContext(), 2131759787, 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248881);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class f
    implements View.OnClickListener
  {
    public f(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248882);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (FinderFollowTopicHeaderView.Jw(this.uPw)) {
        FinderFollowTopicHeaderView.a(this.uPr).onClick(paramView);
      }
      for (;;)
      {
        paramView = i.vfo;
        i.H(false, 6);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$bindOriginFeed$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248882);
        return;
        this.uPr.dla();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248883);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$copyrightRestrictionListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.uPr.getFinderBgmInfo();
      if (paramView != null)
      {
        paramView = paramView.musicInfo;
        if (paramView == null) {
          break label148;
        }
        u.makeText(this.uPr.getContext(), 2131759569, 0).show();
        label71:
        paramView = k.vfA;
        localObject = this.uPr.getContext();
        p.g(localObject, "context");
        paramView = this.uPr.getOriginFeed();
        if (paramView == null) {
          break label167;
        }
        paramView = paramView.getFeedObject();
        if (paramView == null) {
          break label167;
        }
      }
      label148:
      label167:
      for (paramView = Integer.valueOf(paramView.follow_feed_count);; paramView = null)
      {
        k.a((Context)localObject, 2, 4, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$copyrightRestrictionListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248883);
        return;
        paramView = null;
        break;
        u.makeText(this.uPr.getContext(), 2131759568, 0).show();
        break label71;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$onFinishDownload$1$1"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    h(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, s params, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class i
    implements o.f
  {
    public static final i uPy;
    
    static
    {
      AppMethodBeat.i(248886);
      uPy = new i();
      AppMethodBeat.o(248886);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(248885);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(1001, 2131755822);
        paramm.kV(1002, 2131755831);
      }
      AppMethodBeat.o(248885);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements o.g
  {
    j(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      Object localObject6 = null;
      Object localObject7 = null;
      AppMethodBeat.i(248887);
      Intent localIntent = new Intent();
      p.g(paramMenuItem, "menuItem");
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
        if (this.uPr.getType() != 1) {
          break label453;
        }
        localObject3 = this.uPr.getAudioPath();
        paramMenuItem = this.uPr.getFinderBgmInfo();
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
        localObject1 = this.uPr.getFinderBgmInfo();
        if (localObject1 != null)
        {
          localObject2 = ((bdr)localObject1).audioTrackUrl;
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
        localObject1 = ((azk)localObject1).toByteArray();
        label178:
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", (byte[])localObject1);
        localObject1 = this.uPr.getFinderBgmInfo();
        if (localObject1 == null) {
          break label726;
        }
        localObject1 = ((bdr)localObject1).contact;
        if (localObject1 == null) {
          break label726;
        }
        localObject1 = ((FinderContact)localObject1).username;
        label213:
        localIntent.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", p.j(localObject1, z.aUg()));
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", paramMenuItem);
        paramMenuItem = this.uPr.getFinderBgmInfo();
        if (paramMenuItem == null) {
          break label731;
        }
        paramMenuItem = paramMenuItem.musicInfo;
        label254:
        if (paramMenuItem == null) {
          break label736;
        }
        localObject1 = this.uPr.getFinderBgmInfo();
        paramMenuItem = localObject7;
        if (localObject1 != null)
        {
          localObject1 = ((bdr)localObject1).musicInfo;
          paramMenuItem = localObject7;
          if (localObject1 != null) {
            paramMenuItem = ((azk)localObject1).name;
          }
        }
        localIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", String.valueOf(paramMenuItem));
        label302:
        Log.i("FinderFollowTopicHeaderView", "tabType " + this.uPr.getTabType());
        switch (this.uPr.getTabType())
        {
        case 2: 
        default: 
          paramInt = 5;
        }
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", paramInt);
        localIntent.putExtra("key_finder_post_id", this.uPz);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramMenuItem = this.uPr.getContext();
        p.g(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(paramMenuItem, localIntent);
        AppMethodBeat.o(248887);
        return;
        if (paramMenuItem.getItemId() != 1002) {
          break;
        }
        localIntent.putExtra("key_finder_post_router", 3);
        break;
        label453:
        if (this.uPr.getType() == 2)
        {
          paramMenuItem = this.uPr.getAudioInfo();
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
          localObject1 = this.uPr.getFinderBgmInfo();
          if (localObject1 != null)
          {
            localObject2 = ((bdr)localObject1).groupId;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "-1";
          }
          localObject4 = this.uPr.getFinderBgmInfo();
          localObject2 = paramMenuItem;
          localObject3 = localObject1;
          if (localObject4 != null)
          {
            azk localazk = ((bdr)localObject4).musicInfo;
            localObject2 = paramMenuItem;
            localObject3 = localObject1;
            if (localazk != null)
            {
              localObject3 = localazk.LJi;
              localObject2 = localObject3;
              if (localObject3 == null) {
                localObject2 = "";
              }
              localObject4 = new azk();
              localObject3 = this.uPr.getFinderBgmInfo();
              if (localObject3 != null)
              {
                localObject5 = ((bdr)localObject3).groupId;
                localObject3 = localObject5;
                if (localObject5 != null) {}
              }
              else
              {
                localObject3 = "";
              }
              ((azk)localObject4).wWb = ((String)localObject3);
              localObject5 = localazk.LJi;
              localObject3 = localObject5;
              if (localObject5 == null) {
                localObject3 = "";
              }
              ((azk)localObject4).LJi = ((String)localObject3);
              ((azk)localObject4).artist = localazk.artist;
              ((azk)localObject4).name = localazk.name;
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
        localObject2 = this.uPr.getFinderBgmInfo();
        paramMenuItem = localObject6;
        if (localObject2 != null)
        {
          localObject2 = ((bdr)localObject2).contact;
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class k
    implements e.b
  {
    public static final k uPA;
    
    static
    {
      AppMethodBeat.i(248889);
      uPA = new k();
      AppMethodBeat.o(248889);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(248888);
      i locali = i.vfo;
      i.Ks(6);
      AppMethodBeat.o(248888);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248890);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.uPr.getBgmPlayBtn();
      if (paramView != null) {
        paramView.bdY();
      }
      ((WeImageView)this.uPr._$_findCachedViewById(2131301373)).setImageDrawable(ar.m(this.uPr.getContext(), 2131690277, com.tencent.mm.cb.a.n(this.uPr.getContext(), 2131099746)));
      ((WeImageView)this.uPr._$_findCachedViewById(2131301373)).setOnClickListener(FinderFollowTopicHeaderView.e(this.uPr));
      this.uPr.setCurrentListener(FinderFollowTopicHeaderView.e(this.uPr));
      paramView = k.vfA;
      localObject = this.uPr.getContext();
      p.g(localObject, "context");
      paramView = this.uPr.getOriginFeed();
      if (paramView != null)
      {
        paramView = paramView.getFeedObject();
        if (paramView == null) {}
      }
      for (paramView = Integer.valueOf(paramView.follow_feed_count);; paramView = null)
      {
        k.a((Context)localObject, 2, 3, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248890);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248891);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.uPr.getVideoView();
      if (paramView != null)
      {
        ((WeImageView)this.uPr._$_findCachedViewById(2131301373)).setImageDrawable(ar.m(this.uPr.getContext(), 2131690277, com.tencent.mm.cb.a.n(this.uPr.getContext(), 2131099746)));
        paramView.pause();
        ((WeImageView)this.uPr._$_findCachedViewById(2131301373)).setOnClickListener(FinderFollowTopicHeaderView.c(this.uPr));
        this.uPr.setCurrentListener(FinderFollowTopicHeaderView.c(this.uPr));
        paramView = k.vfA;
        localObject = this.uPr.getContext();
        p.g(localObject, "context");
        paramView = this.uPr.getOriginFeed();
        if (paramView == null) {
          break label198;
        }
        paramView = paramView.getFeedObject();
        if (paramView == null) {
          break label198;
        }
      }
      label198:
      for (paramView = Integer.valueOf(paramView.follow_feed_count);; paramView = null)
      {
        k.a((Context)localObject, 2, 3, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$pauseVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248891);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248892);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.uPr.getBgmPlayBtn();
      if (paramView != null) {
        paramView.dlf();
      }
      ((WeImageView)this.uPr._$_findCachedViewById(2131301373)).setImageDrawable(ar.m(this.uPr.getContext(), 2131690276, com.tencent.mm.cb.a.n(this.uPr.getContext(), 2131099746)));
      ((WeImageView)this.uPr._$_findCachedViewById(2131301373)).setOnClickListener(FinderFollowTopicHeaderView.d(this.uPr));
      this.uPr.setCurrentListener(FinderFollowTopicHeaderView.d(this.uPr));
      paramView = k.vfA;
      localObject = this.uPr.getContext();
      p.g(localObject, "context");
      paramView = this.uPr.getOriginFeed();
      if (paramView != null)
      {
        paramView = paramView.getFeedObject();
        if (paramView == null) {}
      }
      for (paramView = Integer.valueOf(paramView.follow_feed_count);; paramView = null)
      {
        k.a((Context)localObject, 2, 2, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playMusicListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248892);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248893);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.uPr.getVideoView();
      if (paramView != null)
      {
        if (!this.uPr.uPg) {
          break label223;
        }
        this.uPr.setFirstClickPlay(false);
        paramView.setMute(false);
        paramView.c(0.0D, true);
        ((WeImageView)this.uPr._$_findCachedViewById(2131301373)).setImageDrawable(ar.m(this.uPr.getContext(), 2131690276, com.tencent.mm.cb.a.n(this.uPr.getContext(), 2131099746)));
        ((WeImageView)this.uPr._$_findCachedViewById(2131301373)).setOnClickListener(FinderFollowTopicHeaderView.b(this.uPr));
        this.uPr.setCurrentListener(FinderFollowTopicHeaderView.b(this.uPr));
        paramView = k.vfA;
        localObject = this.uPr.getContext();
        p.g(localObject, "context");
        paramView = this.uPr.getOriginFeed();
        if (paramView == null) {
          break label231;
        }
        paramView = paramView.getFeedObject();
        if (paramView == null) {
          break label231;
        }
      }
      label223:
      label231:
      for (paramView = Integer.valueOf(paramView.follow_feed_count);; paramView = null)
      {
        k.a((Context)localObject, 2, 2, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$playVideoListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248893);
        return;
        paramView.play();
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$1$1"})
  static final class p
    implements View.OnClickListener
  {
    p(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, com.tencent.mm.plugin.finder.view.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248894);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      locald.bMo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248894);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$1$2"})
  static final class q
    implements View.OnClickListener
  {
    q(FinderFollowTopicHeaderView paramFinderFollowTopicHeaderView, com.tencent.mm.plugin.finder.view.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248895);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = AndroidContextUtil.castActivityOrNull(this.uPr.getContext());
      if (paramView != null)
      {
        localObject = y.vXH;
        if (y.an(paramView))
        {
          paramView = new Intent();
          paramView.putExtra("key_create_scene", 3);
          paramView.putExtra("scene", 2);
          localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
          localObject = this.uPr.getContext();
          p.g(localObject, "context");
          com.tencent.mm.plugin.finder.utils.a.w((Context)localObject, paramView);
        }
      }
      locald.bMo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderFollowTopicHeaderView$showBottomSheet$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248895);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.FinderFollowTopicHeaderView
 * JD-Core Version:    0.7.0.1
 */
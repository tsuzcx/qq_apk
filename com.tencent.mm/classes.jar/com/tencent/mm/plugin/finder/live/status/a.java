package com.tencent.mm.plugin.finder.live.status;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.c.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.core.e.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.model.cgi.w;
import com.tencent.mm.plugin.finder.live.model.cgi.w.a;
import com.tencent.mm.plugin.findersdk.a.k;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.xlabeffect.g;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.videocomposition.effect.b.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/status/LivePullDownView;", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "liveInfoCache", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "(Ljava/lang/String;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;Ljava/util/Map;)V", "finderLiveShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "isMute", "", "()Z", "setMute", "(Z)V", "getJumpInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "listener", "com/tencent/mm/plugin/finder/live/status/LivePullDownView$listener$1", "Lcom/tencent/mm/plugin/finder/live/status/LivePullDownView$listener$1;", "liveEffectView", "Lcom/tencent/mm/videocomposition/effect/EffectRenderView;", "livePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "liveSurface", "Landroid/graphics/SurfaceTexture;", "mode", "", "getPullDownParam", "()Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "getSourceId", "()Ljava/lang/String;", "getTag", "initData", "", "initEffectRender", "initPlayer", "isPauseMusic", "onDestroy", "onPause", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onResume", "onTransAnim", "percent", "", "switchToImage", "switchToVideo", "tryGetLiveInfo", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.ui.widget.b
{
  public static final b yNT;
  private boolean iYs;
  private int mode;
  private final String sourceId;
  private bcp yNL;
  private TXLivePlayer yNM;
  private SurfaceTexture yNN;
  private d yNO;
  private final EffectRenderView yNP;
  private final TextStatusJumpInfo yNQ;
  private final com.tencent.mm.plugin.textstatus.proto.d yNR;
  private final Map<String, bac> yNS;
  
  static
  {
    AppMethodBeat.i(287630);
    yNT = new b((byte)0);
    g.hfh();
    AppMethodBeat.o(287630);
  }
  
  public a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, com.tencent.mm.plugin.textstatus.proto.d paramd, Map<String, bac> paramMap)
  {
    AppMethodBeat.i(287629);
    this.sourceId = paramString;
    this.yNQ = paramTextStatusJumpInfo;
    this.yNR = paramd;
    this.yNS = paramMap;
    this.yNO = new d(this);
    paramTextStatusJumpInfo = View.inflate(MMApplicationContext.getContext(), b.g.finder_live_pull_down_view, null);
    paramString = paramTextStatusJumpInfo.findViewById(b.f.finder_live_pull_down_view_player_effect_view);
    p.j(paramString, "livePullDownView.findVie…_view_player_effect_view)");
    this.yNP = ((EffectRenderView)paramString);
    if (paramFrameLayout != null) {
      paramFrameLayout.addView(paramTextStatusJumpInfo);
    }
    dDA();
    paramString = this.yNQ;
    if (paramString != null)
    {
      paramString = XmlParser.parseXml(paramString.busiBuf, "finderLive", null);
      if (paramString != null) {
        this.yNL = k.u("", paramString);
      }
    }
    paramFrameLayout = new StringBuilder("tryGetLiveInfo anchorUsername:");
    paramString = this.yNL;
    if (paramString != null)
    {
      paramString = paramString.username;
      paramFrameLayout = paramFrameLayout.append(paramString).append(" liveId:");
      paramString = this.yNL;
      if (paramString == null) {
        break label599;
      }
      paramString = paramString.kwM;
      label182:
      Log.i("LivePullDownView", paramString);
      paramFrameLayout = this.yNL;
      if (paramFrameLayout != null)
      {
        paramString = (bac)this.yNS.get(paramFrameLayout.kwM);
        if ((paramString == null) || (paramString.liveStatus != 2))
        {
          paramString = paramFrameLayout.username;
          if (paramString != null) {
            break label642;
          }
          paramString = "";
        }
      }
    }
    label642:
    for (;;)
    {
      new w(paramString, (w.a)new e(this)).bhW();
      paramd = new StringBuilder("tryGetLiveInfo cacheLiveStatus:");
      paramString = (bac)this.yNS.get(paramFrameLayout.kwM);
      label309:
      label484:
      label488:
      boolean bool;
      if (paramString != null)
      {
        paramString = Integer.valueOf(paramString.liveStatus);
        Log.i("LivePullDownView", paramString);
        this.yNM = new TXLivePlayer(MMApplicationContext.getContext());
        paramString = new TXLivePlayConfig();
        paramString.setAutoAdjustCacheTime(false);
        paramFrameLayout = e.c.kjA;
        paramString.setMaxAutoAdjustCacheTime(e.c.aJM());
        paramFrameLayout = e.c.kjA;
        paramString.setMinAutoAdjustCacheTime(e.c.aJM());
        paramFrameLayout = e.c.kjA;
        paramString.setCacheTime(e.c.aJM());
        paramFrameLayout = this.yNM;
        if (paramFrameLayout != null) {
          paramFrameLayout.setPlayerView(null);
        }
        paramFrameLayout = this.yNM;
        if (paramFrameLayout != null) {
          paramFrameLayout.setPlayListener((ITXLivePlayListener)this.yNO);
        }
        paramFrameLayout = this.yNM;
        if (paramFrameLayout != null) {
          paramFrameLayout.enableHardwareDecode(true);
        }
        paramFrameLayout = this.yNM;
        if (paramFrameLayout != null) {
          paramFrameLayout.setConfig(paramString);
        }
        paramString = this.yNM;
        if (paramString != null) {
          paramString.setRenderMode(0);
        }
        paramFrameLayout = this.yNR;
        paramString = localObject;
        if (paramFrameLayout != null) {
          paramString = Integer.valueOf(paramFrameLayout.MEO);
        }
        if (paramString != null) {
          break label609;
        }
        if (paramString != null) {
          break label622;
        }
        bool = false;
      }
      for (;;)
      {
        this.iYs = bool;
        paramString = this.yNM;
        if (paramString != null) {
          paramString.setMute(bool);
        }
        this.yNP.getEffectManager().ikd();
        this.yNP.setSurfaceCallback((b.b)new c(this));
        paramString = this.yNL;
        if (paramString == null) {
          break label636;
        }
        paramString = paramString.kwM;
        if (paramString == null) {
          break label636;
        }
        ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getLiveInfo(Util.safeParseLong(paramString), (b.d)new a(paramTextStatusJumpInfo));
        AppMethodBeat.o(287629);
        return;
        paramString = null;
        break;
        label599:
        paramString = null;
        break label182;
        paramString = null;
        break label309;
        label609:
        if (paramString.intValue() != 0) {
          break label484;
        }
        bool = true;
        continue;
        label622:
        if (paramString.intValue() != 2) {
          break label488;
        }
        bool = true;
      }
      label636:
      AppMethodBeat.o(287629);
      return;
    }
  }
  
  private final void dDA()
  {
    AppMethodBeat.i(287626);
    StringBuilder localStringBuilder = new StringBuilder("switchToImage liveId:");
    Object localObject = this.yNL;
    if (localObject != null) {}
    for (localObject = ((bcp)localObject).kwM;; localObject = null)
    {
      Log.i("LivePullDownView", (String)localObject);
      this.mode = 0;
      localObject = this.yNM;
      if (localObject == null) {
        break;
      }
      ((TXLivePlayer)localObject).stopPlay(true);
      AppMethodBeat.o(287626);
      return;
    }
    AppMethodBeat.o(287626);
  }
  
  private final void dDz()
  {
    Object localObject2 = null;
    AppMethodBeat.i(287625);
    Object localObject3 = new StringBuilder("switchToVideo liveId:");
    Object localObject1 = this.yNL;
    if (localObject1 != null) {}
    for (localObject1 = ((bcp)localObject1).kwM;; localObject1 = null)
    {
      Log.i("LivePullDownView", (String)localObject1);
      localObject1 = this.yNL;
      if (localObject1 == null) {
        break;
      }
      this.mode = 1;
      localObject3 = (bac)this.yNS.get(((bcp)localObject1).kwM);
      if ((localObject3 != null) && (((bac)localObject3).liveStatus != 2))
      {
        localObject1 = this.yNM;
        if (localObject1 != null) {
          ((TXLivePlayer)localObject1).startPlay(((bac)localObject3).kih, 1);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder("switchToVideo streamUrl:");
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((bac)localObject3).kih;
      }
      Log.i("LivePullDownView", (String)localObject1);
      AppMethodBeat.o(287625);
      return;
    }
    AppMethodBeat.o(287625);
  }
  
  public final void dDB() {}
  
  public final void dDC() {}
  
  public final boolean dDD()
  {
    com.tencent.mm.plugin.textstatus.proto.d locald = this.yNR;
    return (locald == null) || (locald.MEO != 2);
  }
  
  public final void dDE()
  {
    boolean bool = false;
    AppMethodBeat.i(287627);
    super.dDE();
    TXLivePlayer localTXLivePlayer = this.yNM;
    if (localTXLivePlayer != null)
    {
      if ((this.iYs) || (com.tencent.mm.q.a.aAo()) || (com.tencent.mm.q.a.r(MMApplicationContext.getContext(), false))) {
        bool = true;
      }
      localTXLivePlayer.setMute(bool);
    }
    dDz();
    AppMethodBeat.o(287627);
  }
  
  public final String getTag()
  {
    return "LivePullDownView";
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287622);
    super.onDestroy();
    AppMethodBeat.o(287622);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(287623);
    super.onPause();
    AppMethodBeat.o(287623);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(287628);
    super.onPostClose();
    dDA();
    AppMethodBeat.o(287628);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(287624);
    super.onResume();
    AppMethodBeat.o(287624);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/status/LivePullDownView$1$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "liveId", "", "status", "", "liveInfoResp", "", "plugin-finder_release"})
  public static final class a
    implements b.d
  {
    a(View paramView) {}
    
    public final void a(long paramLong, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(272211);
      if (paramInt == 2)
      {
        paramObject = this.yNU;
        p.j(paramObject, "livePullDownView");
        paramObject.setVisibility(8);
      }
      AppMethodBeat.o(272211);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/status/LivePullDownView$Companion;", "", "()V", "PULL_DOWN_MODE_CLOSE", "", "PULL_DOWN_MODE_OPEN", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/status/LivePullDownView$initEffectRender$1", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "onSurfaceAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceDestroy", "onSurfaceSizeChanged", "onSurfaceUpdate", "plugin-finder_release"})
  public static final class c
    implements b.b
  {
    public final void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(284263);
      Log.i("LivePullDownView", "liveEffectView onSurfaceAvailable width:" + paramInt1 + " height:" + paramInt2);
      a.a(this.yNV, paramSurfaceTexture);
      paramSurfaceTexture = a.b(this.yNV);
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.setSurface(new Surface(a.a(this.yNV)));
        AppMethodBeat.o(284263);
        return;
      }
      AppMethodBeat.o(284263);
    }
    
    public final void l(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(284265);
      Log.i("LivePullDownView", "liveEffectView onSurfaceDestroy");
      a.a(this.yNV, null);
      paramSurfaceTexture = a.b(this.yNV);
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.setSurface(null);
        AppMethodBeat.o(284265);
        return;
      }
      AppMethodBeat.o(284265);
    }
    
    public final void m(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(284267);
      Log.i("LivePullDownView", "liveEffectView onSurfaceUpdate");
      AppMethodBeat.o(284267);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/status/LivePullDownView$listener$1", "Lcom/tencent/rtmp/ITXLivePlayListener;", "onNetStatus", "", "param", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "plugin-finder_release"})
  public static final class d
    implements ITXLivePlayListener
  {
    public final void onNetStatus(Bundle paramBundle) {}
    
    public final void onPlayEvent(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(287797);
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(287797);
        return;
      }
      if (paramBundle != null)
      {
        paramInt = paramBundle.getInt("EVT_PARAM1");
        label41:
        if (paramBundle == null) {
          break label139;
        }
      }
      label139:
      for (int i = paramBundle.getInt("EVT_PARAM2");; i = 0)
      {
        paramBundle = a.b(this.yNV);
        if (paramBundle != null) {
          paramBundle.setSurfaceSize(paramInt, i);
        }
        paramBundle = a.a(this.yNV);
        if (paramBundle != null) {
          paramBundle.setDefaultBufferSize(paramInt, i);
        }
        a.f(this.yNV).bg(paramInt, i, 0);
        Log.i("LivePullDownView", "PLAY_EVT_CHANGE_RESOLUTION width:" + paramInt + " height:" + i);
        break;
        paramInt = 0;
        break label41;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/status/LivePullDownView$tryGetLiveInfo$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder_release"})
  public static final class e
    implements w.a
  {
    e(a parama) {}
    
    public final void a(int paramInt1, int paramInt2, aun paramaun)
    {
      AppMethodBeat.i(286399);
      p.k(paramaun, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramaun = paramaun.SFP;
        if (paramaun != null)
        {
          paramaun = paramaun.liveInfo;
          if (paramaun != null)
          {
            Map localMap = a.c(this.yNV);
            String str = com.tencent.mm.ae.d.Fw(paramaun.liveId);
            p.j(paramaun, "respInfo");
            localMap.put(str, paramaun);
            if (a.d(this.yNV) == 1) {
              a.e(this.yNV);
            }
            AppMethodBeat.o(286399);
            return;
          }
        }
      }
      AppMethodBeat.o(286399);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.status.a
 * JD-Core Version:    0.7.0.1
 */
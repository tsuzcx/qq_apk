package com.tencent.mm.plugin.finder.live.status;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.d.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.core.e.c;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.plugin.finder.live.model.cgi.ac;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.plugin.findersdk.a.t;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.plugin.xlabeffect.m;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/status/LivePullDownView;", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "liveInfoCache", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "(Ljava/lang/String;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;Ljava/util/Map;)V", "finderLiveShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "isMute", "", "()Z", "setMute", "(Z)V", "getJumpInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "listener", "com/tencent/mm/plugin/finder/live/status/LivePullDownView$listener$1", "Lcom/tencent/mm/plugin/finder/live/status/LivePullDownView$listener$1;", "liveEffectView", "Lcom/tencent/mm/videocomposition/effect/EffectRenderView;", "livePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "liveSurface", "Landroid/graphics/SurfaceTexture;", "mode", "", "getPullDownParam", "()Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "getSourceId", "()Ljava/lang/String;", "getTag", "initData", "", "initEffectRender", "initPlayer", "isPauseMusic", "onDestroy", "onPause", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onResume", "onTransAnim", "percent", "", "switchToImage", "switchToVideo", "tryGetLiveInfo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.ui.widget.b
{
  public static final b DGW;
  private final TextStatusJumpInfo DGX;
  private final l DGY;
  private final Map<String, bip> DGZ;
  private bmr DHa;
  private TXLivePlayer DHb;
  private SurfaceTexture DHc;
  private d DHd;
  private final EffectRenderView DHe;
  private boolean lAj;
  private int mode;
  private final String sourceId;
  
  static
  {
    AppMethodBeat.i(351571);
    DGW = new b((byte)0);
    m.iGg();
    AppMethodBeat.o(351571);
  }
  
  public a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, l paraml, Map<String, bip> paramMap)
  {
    AppMethodBeat.i(351501);
    this.sourceId = paramString;
    this.DGX = paramTextStatusJumpInfo;
    this.DGY = paraml;
    this.DGZ = paramMap;
    this.DHd = new d(this);
    paramTextStatusJumpInfo = View.inflate(MMApplicationContext.getContext(), p.f.Cfp, null);
    paramString = paramTextStatusJumpInfo.findViewById(p.e.BRM);
    s.s(paramString, "livePullDownView.findVie…_view_player_effect_view)");
    this.DHe = ((EffectRenderView)paramString);
    if (paramFrameLayout != null) {
      paramFrameLayout.addView(paramTextStatusJumpInfo);
    }
    etK();
    paramString = this.DGX;
    if (paramString != null)
    {
      paramString = XmlParser.parseXml(paramString.busiBuf, "finderLive", null);
      if (paramString != null) {
        this.DHa = q.z("", paramString);
      }
    }
    paramFrameLayout = new StringBuilder("tryGetLiveInfo anchorUsername:");
    paramString = this.DHa;
    if (paramString == null)
    {
      paramString = null;
      paramFrameLayout = paramFrameLayout.append(paramString).append(" liveId:");
      paramString = this.DHa;
      if (paramString != null) {
        break label574;
      }
      paramString = null;
      label176:
      Log.i("LivePullDownView", paramString);
      paramFrameLayout = this.DHa;
      if (paramFrameLayout != null)
      {
        paramString = (bip)this.DGZ.get(paramFrameLayout.liveId);
        if ((paramString == null) || (paramString.liveStatus != 2))
        {
          paramString = paramFrameLayout.username;
          if (paramString != null) {
            break label582;
          }
          paramString = "";
          label239:
          new ac(paramString, (t)new e(this)).bFJ();
        }
        paramString = (bip)this.DGZ.get(paramFrameLayout.liveId);
        if (paramString != null) {
          break label585;
        }
        paramString = null;
        label285:
        Log.i("LivePullDownView", s.X("tryGetLiveInfo cacheLiveStatus:", paramString));
      }
      this.DHb = new TXLivePlayer(MMApplicationContext.getContext());
      paramString = new TXLivePlayConfig();
      paramString.setAutoAdjustCacheTime(false);
      paramFrameLayout = e.c.mKi;
      paramString.setMaxAutoAdjustCacheTime(e.c.bcw());
      paramFrameLayout = e.c.mKi;
      paramString.setMinAutoAdjustCacheTime(e.c.bcw());
      paramFrameLayout = e.c.mKi;
      paramString.setCacheTime(e.c.bcw());
      paramFrameLayout = this.DHb;
      if (paramFrameLayout != null) {
        paramFrameLayout.setPlayerView(null);
      }
      paramFrameLayout = this.DHb;
      if (paramFrameLayout != null) {
        paramFrameLayout.setPlayListener((ITXLivePlayListener)this.DHd);
      }
      paramFrameLayout = this.DHb;
      if (paramFrameLayout != null) {
        paramFrameLayout.enableHardwareDecode(true);
      }
      paramFrameLayout = this.DHb;
      if (paramFrameLayout != null) {
        paramFrameLayout.setConfig(paramString);
      }
      paramString = this.DHb;
      if (paramString != null) {
        paramString.setRenderMode(0);
      }
      paramString = this.DGY;
      if (paramString != null) {
        break label596;
      }
      paramString = localObject;
      label446:
      if (paramString != null) {
        break label607;
      }
    }
    label450:
    for (boolean bool = false;; bool = true)
    {
      this.lAj = bool;
      paramString = this.DHb;
      if (paramString != null) {
        paramString.setMute(bool);
      }
      this.DHe.getEffectManager().jQk();
      this.DHe.setSurfaceCallback((com.tencent.mm.videocomposition.effect.b.b)new c(this));
      paramString = this.DHa;
      if (paramString != null)
      {
        paramString = paramString.liveId;
        if (paramString != null)
        {
          paramFrameLayout = h.az(com.tencent.d.a.a.a.b.class);
          s.s(paramFrameLayout, "plugin(IPluginFinderLive::class.java)");
          com.tencent.d.a.a.a.b.b.a((com.tencent.d.a.a.a.b)paramFrameLayout, Util.safeParseLong(paramString), false, (b.d)new a(paramTextStatusJumpInfo), 6);
        }
      }
      AppMethodBeat.o(351501);
      return;
      paramString = paramString.username;
      break;
      paramString = paramString.liveId;
      break label176;
      label582:
      break label239;
      label585:
      paramString = Integer.valueOf(paramString.liveStatus);
      break label285;
      label596:
      paramString = Integer.valueOf(paramString.ToO);
      break label446;
      label607:
      if (paramString.intValue() != 0) {
        break label450;
      }
    }
  }
  
  private final void etJ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(351512);
    Object localObject1 = this.DHa;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("LivePullDownView", s.X("switchToVideo liveId:", localObject1));
      localObject1 = this.DHa;
      if (localObject1 != null)
      {
        this.mode = 1;
        localObject1 = (bip)this.DGZ.get(((bmr)localObject1).liveId);
        if ((localObject1 != null) && (((bip)localObject1).liveStatus != 2))
        {
          if (!e.isInstalled()) {
            break label132;
          }
          TXLivePlayer localTXLivePlayer = this.DHb;
          if (localTXLivePlayer != null) {
            localTXLivePlayer.startPlay(((bip)localObject1).mIE, 1);
          }
        }
        label99:
        if (localObject1 != null) {
          break label143;
        }
      }
    }
    label132:
    label143:
    for (localObject1 = localObject2;; localObject1 = ((bip)localObject1).mIE)
    {
      Log.i("LivePullDownView", s.X("switchToVideo streamUrl:", localObject1));
      AppMethodBeat.o(351512);
      return;
      localObject1 = ((bmr)localObject1).liveId;
      break;
      Log.i("LivePullDownView", "switchToVideo fail, expansions not installed");
      break label99;
    }
  }
  
  private final void etK()
  {
    AppMethodBeat.i(351520);
    Object localObject = this.DHa;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((bmr)localObject).liveId)
    {
      Log.i("LivePullDownView", s.X("switchToImage liveId:", localObject));
      this.mode = 0;
      localObject = this.DHb;
      if (localObject != null) {
        ((TXLivePlayer)localObject).stopPlay(true);
      }
      AppMethodBeat.o(351520);
      return;
    }
  }
  
  public final void etL() {}
  
  public final void etM() {}
  
  public final boolean etN()
  {
    return true;
  }
  
  public final void etO()
  {
    boolean bool = false;
    AppMethodBeat.i(351633);
    super.etO();
    TXLivePlayer localTXLivePlayer = this.DHb;
    if (localTXLivePlayer != null)
    {
      if ((this.lAj) || (com.tencent.mm.n.a.aTj()) || (com.tencent.mm.n.a.s(MMApplicationContext.getContext(), false))) {
        bool = true;
      }
      localTXLivePlayer.setMute(bool);
    }
    etJ();
    AppMethodBeat.o(351633);
  }
  
  public final String getTag()
  {
    return "LivePullDownView";
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(351581);
    super.onDestroy();
    AppMethodBeat.o(351581);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(351590);
    super.onPause();
    AppMethodBeat.o(351590);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(351641);
    super.onPostClose();
    etK();
    AppMethodBeat.o(351641);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(351597);
    super.onResume();
    AppMethodBeat.o(351597);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/status/LivePullDownView$1$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "liveId", "", "status", "", "liveInfoResp", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b.d
  {
    a(View paramView) {}
    
    public final void onLiveStatusCallback(long paramLong, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(351480);
      if (paramInt == 2) {
        this.DHf.setVisibility(8);
      }
      AppMethodBeat.o(351480);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/status/LivePullDownView$Companion;", "", "()V", "PULL_DOWN_MODE_CLOSE", "", "PULL_DOWN_MODE_OPEN", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/status/LivePullDownView$initEffectRender$1", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "onSurfaceAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceDestroy", "onSurfaceSizeChanged", "onSurfaceUpdate", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.videocomposition.effect.b.b
  {
    c(a parama) {}
    
    public final void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(351478);
      Log.i("LivePullDownView", "liveEffectView onSurfaceAvailable width:" + paramInt1 + " height:" + paramInt2);
      a.a(this.DHg, paramSurfaceTexture);
      paramSurfaceTexture = a.a(this.DHg);
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.setSurface(new Surface(a.b(this.DHg)));
      }
      AppMethodBeat.o(351478);
    }
    
    public final void k(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(351487);
      Log.i("LivePullDownView", "liveEffectView onSurfaceDestroy");
      a.a(this.DHg, null);
      paramSurfaceTexture = a.a(this.DHg);
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.setSurface(null);
      }
      AppMethodBeat.o(351487);
    }
    
    public final void l(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(351494);
      Log.i("LivePullDownView", "liveEffectView onSurfaceUpdate");
      AppMethodBeat.o(351494);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/status/LivePullDownView$listener$1", "Lcom/tencent/rtmp/ITXLivePlayListener;", "onNetStatus", "", "param", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ITXLivePlayListener
  {
    d(a parama) {}
    
    public final void onNetStatus(Bundle paramBundle) {}
    
    public final void onPlayEvent(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(351473);
      if (paramInt == 2009)
      {
        if (paramBundle != null) {
          break label109;
        }
        paramInt = 0;
        if (paramBundle != null) {
          break label119;
        }
      }
      label109:
      label119:
      for (int i = 0;; i = paramBundle.getInt("EVT_PARAM2"))
      {
        paramBundle = a.a(this.DHg);
        if (paramBundle != null) {
          paramBundle.setSurfaceSize(paramInt, i);
        }
        paramBundle = a.b(this.DHg);
        if (paramBundle != null) {
          paramBundle.setDefaultBufferSize(paramInt, i);
        }
        a.f(this.DHg).bH(paramInt, i, 0);
        Log.i("LivePullDownView", "PLAY_EVT_CHANGE_RESOLUTION width:" + paramInt + " height:" + i);
        AppMethodBeat.o(351473);
        return;
        paramInt = paramBundle.getInt("EVT_PARAM1");
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/status/LivePullDownView$tryGetLiveInfo$1$1", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveGetLastObjectCallback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements t
  {
    e(a parama) {}
    
    public final void a(int paramInt1, int paramInt2, azf paramazf)
    {
      AppMethodBeat.i(351468);
      s.u(paramazf, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramazf = paramazf.ZIo;
        if (paramazf != null)
        {
          paramazf = paramazf.liveInfo;
          if (paramazf != null)
          {
            a locala = this.DHg;
            a.c(locala).put(d.hF(paramazf.liveId), paramazf);
            if (a.d(locala) == 1) {
              a.e(locala);
            }
          }
        }
      }
      AppMethodBeat.o(351468);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.status.a
 * JD-Core Version:    0.7.0.1
 */
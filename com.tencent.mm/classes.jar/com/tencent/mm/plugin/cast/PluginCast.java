package com.tencent.mm.plugin.cast;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.wf;
import com.tencent.mm.autogen.a.wj;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.cast.a.b;
import com.tencent.mm.plugin.cast.service.ScreenCastForegroundService;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.threadpool.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/PluginCast;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/cast/IPluginScreenCast;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "appForegroundListener", "com/tencent/mm/plugin/cast/PluginCast$appForegroundListener$1", "Lcom/tencent/mm/plugin/cast/PluginCast$appForegroundListener$1;", "bannerOnInitListener", "com/tencent/mm/plugin/cast/PluginCast$bannerOnInitListener$1", "Lcom/tencent/mm/plugin/cast/PluginCast$bannerOnInitListener$1;", "scanQrcodeLiveAuthorizationEventListner", "com/tencent/mm/plugin/cast/PluginCast$scanQrcodeLiveAuthorizationEventListner$1", "Lcom/tencent/mm/plugin/cast/PluginCast$scanQrcodeLiveAuthorizationEventListner$1;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "forceStopCurCast", "getCurrentConnectStatus", "", "getRemoteConfig", "Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "intent", "Landroid/content/Intent;", "installed", "isRecordAudio", "", "isScreenRecording", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "refreshRecordStatus", "remoteAddress", "", "status", "callback", "Lcom/tencent/mm/plugin/cast/IPluginScreenCast$ScreenCastStatusCallback;", "Companion", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginCast
  extends com.tencent.mm.kernel.b.f
  implements c, a
{
  public static final a wLM;
  private static com.tencent.mm.plugin.cast.c.a wLQ;
  private scanQrcodeLiveAuthorizationEventListner.1 wLN;
  private final b wLO;
  private PluginCast.bannerOnInitListener.1 wLP;
  
  static
  {
    AppMethodBeat.i(274093);
    wLM = new a((byte)0);
    AppMethodBeat.o(274093);
  }
  
  public PluginCast()
  {
    AppMethodBeat.i(274051);
    this.wLN = new IListener(com.tencent.mm.app.f.hfK)
    {
      private static final void a(PluginCast paramAnonymousPluginCast, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
      {
        AppMethodBeat.i(274170);
        s.u(paramAnonymousPluginCast, "this$0");
        if (paramAnonymousp == null)
        {
          paramAnonymousPluginCast = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.cast.netscene.NetSceneGetScreenCastAuthorization");
          AppMethodBeat.o(274170);
          throw paramAnonymousPluginCast;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.cast.d.a)paramAnonymousp).wNh;
        if (paramAnonymousString != null)
        {
          paramAnonymousp = paramAnonymousString.ZQT;
          if (paramAnonymousp != null)
          {
            paramAnonymousString = new Intent();
            paramAnonymousString.putExtra("remoteConfig", paramAnonymousp.ZUY);
            paramAnonymousString.putExtra("pc_ip", paramAnonymousp.ZUZ);
            paramAnonymousString.putExtra("phone_ip", paramAnonymousp.ZVa);
            paramAnonymousp = PluginCast.wLM;
            paramAnonymousp = PluginCast.a.dpb();
            if (paramAnonymousp != null) {
              paramAnonymousp.wMM = PluginCast.access$getRemoteConfig(paramAnonymousPluginCast, paramAnonymousString);
            }
          }
        }
        AppMethodBeat.o(274170);
      }
    };
    this.wLO = new b(this);
    this.wLP = new PluginCast.bannerOnInitListener.1(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(274051);
  }
  
  private final b getRemoteConfig(Intent paramIntent)
  {
    AppMethodBeat.i(274068);
    localb = new b();
    Object localObject1 = paramIntent.getStringExtra("remoteConfig");
    if (localObject1 != null) {}
    try
    {
      localObject1 = new com.tencent.mm.ad.i((String)localObject1);
      localb.bitrate = (((com.tencent.mm.ad.i)localObject1).optInt("VideoBitRate") * 1000);
      localb.wMv = ((com.tencent.mm.ad.i)localObject1).optString("ip");
      localb.wMw = Integer.valueOf(((com.tencent.mm.ad.i)localObject1).optInt("port"));
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("CanvasDirection");
      s.s(localObject2, "json.optString(REMOTE_CONDIF_PC_CANVAS_DIRECTION)");
      localObject2 = n.bJF((String)localObject2);
      if (localObject2 != null) {
        localb.wMA = ((Number)localObject2).intValue();
      }
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("VideoSolution");
      s.s(localObject2, "it");
      localObject2 = n.a((CharSequence)localObject2, new String[] { "*" });
      localInteger = n.bJF((String)kotlin.a.p.oK((List)localObject2));
      if (localInteger != null) {
        break label587;
      }
      i = 0;
      localObject2 = n.bJF((String)kotlin.a.p.oM((List)localObject2));
      if (localObject2 != null) {
        break label597;
      }
      j = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Integer localInteger;
        int i;
        int j;
        boolean bool;
        Log.printErrStackTrace("MicroMsg.PluginCast", (Throwable)localException, "isScreenCastCode error", new Object[0]);
        ah localah = ah.aiuX;
        continue;
        do
        {
          localObject2 = aw.bf(MMApplicationContext.getContext());
          int k;
          float f1;
          float f2;
          if (i > j)
          {
            k = ((Point)localObject2).x;
            ((Point)localObject2).x = ((Point)localObject2).y;
            ((Point)localObject2).y = k;
            if (((Point)localObject2).x > ((Point)localObject2).y)
            {
              f1 = ((Point)localObject2).x / i;
              f2 = i;
              f1 = ((Point)localObject2).y / f1;
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.PluginCast", "width is " + i + " and height is " + j + " and screen size is" + ((Point)localObject2).x + " amd " + ((Point)localObject2).y + " and resule is " + f2 + " * " + f1);
            localb.setVideoSize((int)f2, (int)f1);
            break;
            f2 = ((Point)localObject2).y / i;
            f1 = i;
            f2 *= ((Point)localObject2).x;
            continue;
            if (((Point)localObject2).x > ((Point)localObject2).y)
            {
              f2 = ((Point)localObject2).y / i;
              f1 = i;
              f2 *= ((Point)localObject2).x;
            }
            else
            {
              f1 = ((Point)localObject2).x / j;
              f2 = j;
              k = ((Point)localObject2).y;
              f1 *= k;
            }
          }
          bool = false;
          break label425;
          if (i == 0) {
            break;
          }
        } while (j != 0);
      }
    }
    localObject2 = aw.bf(MMApplicationContext.getContext());
    if (localb.wMA == 0)
    {
      localb.setVideoSize(((Point)localObject2).y, ((Point)localObject2).x);
      Log.i("MicroMsg.PluginCast", "width is " + i + " and height is " + j + " and screen size is" + ((Point)localObject2).x + " amd " + ((Point)localObject2).y);
    }
    for (;;)
    {
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("VideoFrameRate");
      s.s(localObject2, "json.optString(REMOTE_CONFIG_VIDEO_FRAME)");
      localObject2 = n.bJF((String)localObject2);
      if (localObject2 != null) {
        localb.frameRate = ((Number)localObject2).intValue();
      }
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("VideoIFrameInterval");
      s.s(localObject2, "json.optString(REMOTE_CO…G_VIDEO_I_FRAME_INTERVAL)");
      localObject2 = n.bJF((String)localObject2);
      if (localObject2 != null) {
        localb.nxQ = ((Number)localObject2).intValue();
      }
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("AudioRecordUseAndroidMic");
      s.s(localObject2, "json.optString(REMOTE_CO…AUDIO_USE_ANDROID_RECORD)");
      localObject2 = n.bJF((String)localObject2);
      if (localObject2 != null)
      {
        if (((Number)localObject2).intValue() != 1) {
          break label919;
        }
        bool = true;
        label425:
        localb.wMx.wMt = bool;
      }
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("AudioSampleRate");
      s.s(localObject2, "json.optString(REMOTE_CONFIG_AUDIO_SAMPLERATE)");
      localObject2 = n.bJF((String)localObject2);
      if (localObject2 != null)
      {
        i = ((Number)localObject2).intValue();
        localb.wMx.audioSampleRate = i;
      }
      localObject1 = ((com.tencent.mm.ad.i)localObject1).optString("AudioChannelCnt");
      s.s(localObject1, "json.optString(REMOTE_CONFIG_AUDIO_CHANNEL_CNT)");
      localObject1 = n.bJF((String)localObject1);
      if (localObject1 != null)
      {
        i = ((Number)localObject1).intValue();
        localb.wMx.wMu = i;
        localObject1 = ah.aiuX;
      }
      localObject1 = paramIntent.getStringExtra("pc_ip");
      if (localObject1 != null) {
        localb.wMy = ((String)localObject1);
      }
      paramIntent = paramIntent.getStringExtra("phone_ip");
      if (paramIntent != null) {
        localb.wMz = paramIntent;
      }
      AppMethodBeat.o(274068);
      return localb;
      label587:
      i = localInteger.intValue();
      break;
      label597:
      j = ((Integer)localObject2).intValue();
      break label925;
      localb.setVideoSize(((Point)localObject2).x, ((Point)localObject2).y);
    }
  }
  
  public final void execute(g paramg) {}
  
  public final void forceStopCurCast()
  {
    AppMethodBeat.i(274107);
    Object localObject = new Intent(MMApplicationContext.getContext(), ScreenCastForegroundService.class);
    MMApplicationContext.getContext().stopService((Intent)localObject);
    localObject = a.dpb();
    if (localObject != null) {
      ((com.tencent.mm.plugin.cast.c.a)localObject).stopRecord();
    }
    AppMethodBeat.o(274107);
  }
  
  public final int getCurrentConnectStatus()
  {
    return 0;
  }
  
  public final void installed()
  {
    AppMethodBeat.i(274116);
    super.installed();
    alias(a.class);
    AppMethodBeat.o(274116);
  }
  
  public final boolean isRecordAudio()
  {
    return true;
  }
  
  public final boolean isScreenRecording()
  {
    AppMethodBeat.i(274110);
    com.tencent.mm.plugin.cast.c.a locala = a.dpb();
    if (locala == null)
    {
      AppMethodBeat.o(274110);
      return false;
    }
    boolean bool = locala.wMU;
    AppMethodBeat.o(274110);
    return bool;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(274141);
    Log.i("MicroMsg.PluginCast", "happened account release");
    this.wLN.alive();
    this.wLP.alive();
    AppForegroundDelegate.heY.a((com.tencent.mm.app.q)this.wLO);
    AppMethodBeat.o(274141);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(274132);
    Log.i("MicroMsg.PluginCast", "happened account release");
    forceStopCurCast();
    this.wLN.dead();
    this.wLP.dead();
    AppForegroundDelegate.heY.b((com.tencent.mm.app.q)this.wLO);
    AppMethodBeat.o(274132);
  }
  
  public final void refreshRecordStatus(long paramLong, int paramInt, a.a parama) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/PluginCast$Companion;", "", "()V", "CAST_TO_PC", "", "CAST_TO_PC_CONNECTED_FAILED_DIFF_NETWORK", "CAST_TO_PC_CONNECTED_FAILED_FORBIDDEN", "CAST_TO_PC_CONNECTED_FAILED_TIMEOUT", "CAST_TO_PC_CONNECTING", "CAST_TO_PC_MEDIACODEC_INIT_FAILED", "CAST_TO_PC_READY", "CAST_TO_PC_SERVICE_REMOVED", "REMOTE_CONDIF_PC_CANVAS_DIRECTION", "", "REMOTE_CONFIG_AUDIO_CHANNEL_CNT", "REMOTE_CONFIG_AUDIO_SAMPLERATE", "REMOTE_CONFIG_AUDIO_USE_ANDROID_RECORD", "REMOTE_CONFIG_BITRATE", "REMOTE_CONFIG_DATA", "REMOTE_CONFIG_IP", "REMOTE_CONFIG_PORT", "REMOTE_CONFIG_RESOLUTION", "REMOTE_CONFIG_VIDEO_FRAME", "REMOTE_CONFIG_VIDEO_I_FRAME_INTERVAL", "REMOTE_PC_IP", "REMOTE_PHONE_IP", "TAG", "screenCastManager", "Lcom/tencent/mm/plugin/cast/manager/ScreenCastManager;", "getScreenCastManager", "()Lcom/tencent/mm/plugin/cast/manager/ScreenCastManager;", "setScreenCastManager", "(Lcom/tencent/mm/plugin/cast/manager/ScreenCastManager;)V", "startScreenCast", "", "stopScreenCast", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static com.tencent.mm.plugin.cast.c.a dpb()
    {
      AppMethodBeat.i(274215);
      if (PluginCast.access$getScreenCastManager$cp() == null) {
        PluginCast.access$setScreenCastManager$cp(new com.tencent.mm.plugin.cast.c.a());
      }
      com.tencent.mm.plugin.cast.c.a locala = PluginCast.access$getScreenCastManager$cp();
      AppMethodBeat.o(274215);
      return locala;
    }
    
    public static void dpc()
    {
      AppMethodBeat.i(274224);
      wj localwj = new wj();
      localwj.hZX.hzt = true;
      localwj.publish();
      AppMethodBeat.o(274224);
    }
    
    public static void dpd()
    {
      AppMethodBeat.i(274231);
      wj localwj = new wj();
      localwj.hZX.hzt = false;
      localwj.publish();
      AppMethodBeat.o(274231);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/cast/PluginCast$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.app.q
  {
    b(PluginCast paramPluginCast) {}
    
    private static final void a(PluginCast paramPluginCast)
    {
      AppMethodBeat.i(274212);
      s.u(paramPluginCast, "this$0");
      if (paramPluginCast.isScreenRecording())
      {
        paramPluginCast = PluginCast.wLM;
        PluginCast.a.dpc();
        AppMethodBeat.o(274212);
        return;
      }
      PluginCast.a locala = PluginCast.wLM;
      PluginCast.a.dpd();
      paramPluginCast.forceStopCurCast();
      AppMethodBeat.o(274212);
    }
    
    private static final void b(PluginCast paramPluginCast)
    {
      AppMethodBeat.i(274219);
      s.u(paramPluginCast, "this$0");
      if (paramPluginCast.isScreenRecording())
      {
        paramPluginCast = PluginCast.wLM;
        PluginCast.a.dpc();
        AppMethodBeat.o(274219);
        return;
      }
      PluginCast.a locala = PluginCast.wLM;
      PluginCast.a.dpd();
      paramPluginCast.forceStopCurCast();
      AppMethodBeat.o(274219);
    }
    
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(274242);
      Log.i("MicroMsg.PluginCast", s.X("onAppBackground ", Boolean.valueOf(this.wLR.isScreenRecording())));
      h.ahAA.o(new PluginCast.b..ExternalSyntheticLambda1(this.wLR), 2000L);
      AppMethodBeat.o(274242);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(274249);
      Log.i("MicroMsg.PluginCast", s.X("onAppForeground ", Boolean.valueOf(this.wLR.isScreenRecording())));
      h.ahAA.o(new PluginCast.b..ExternalSyntheticLambda0(this.wLR), 2000L);
      AppMethodBeat.o(274249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.PluginCast
 * JD-Core Version:    0.7.0.1
 */
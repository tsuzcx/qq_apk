package com.tencent.mm.plugin.cast;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.f.a.up;
import com.tencent.mm.f.a.ut;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.cast.b.b;
import com.tencent.mm.plugin.cast.service.ScreenCastForegroundService;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/PluginCast;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/cast/IPluginScreenCast;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "appForegroundListener", "com/tencent/mm/plugin/cast/PluginCast$appForegroundListener$1", "Lcom/tencent/mm/plugin/cast/PluginCast$appForegroundListener$1;", "bannerOnInitListener", "com/tencent/mm/plugin/cast/PluginCast$bannerOnInitListener$1", "Lcom/tencent/mm/plugin/cast/PluginCast$bannerOnInitListener$1;", "scanQrcodeLiveAuthorizationEventListner", "com/tencent/mm/plugin/cast/PluginCast$scanQrcodeLiveAuthorizationEventListner$1", "Lcom/tencent/mm/plugin/cast/PluginCast$scanQrcodeLiveAuthorizationEventListner$1;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "forceStopCurCast", "getCurrentConnectStatus", "", "getRemoteConfig", "Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "intent", "Landroid/content/Intent;", "installed", "isRecordAudio", "", "isScreenRecording", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "refreshRecordStatus", "remoteAddress", "", "status", "callback", "Lcom/tencent/mm/plugin/cast/IPluginScreenCast$ScreenCastStatusCallback;", "Companion", "plugin-cast_release"})
public final class PluginCast
  extends f
  implements c, a
{
  private static com.tencent.mm.plugin.cast.d.a tIf;
  public static final a tIg;
  private d tIc;
  private final b tId;
  private PluginCast.c tIe;
  
  static
  {
    AppMethodBeat.i(190222);
    tIg = new a((byte)0);
    AppMethodBeat.o(190222);
  }
  
  public PluginCast()
  {
    AppMethodBeat.i(190220);
    this.tIc = new d(this);
    this.tId = new b(this);
    this.tIe = new PluginCast.c();
    AppMethodBeat.o(190220);
  }
  
  private final b getRemoteConfig(Intent paramIntent)
  {
    AppMethodBeat.i(190196);
    localb = new b();
    Object localObject1 = paramIntent.getStringExtra("remoteConfig");
    if (localObject1 != null) {}
    try
    {
      localObject1 = new com.tencent.mm.ad.i((String)localObject1);
      localb.bitrate = (((com.tencent.mm.ad.i)localObject1).optInt("VideoBitRate") * 1000);
      localb.tIO = ((com.tencent.mm.ad.i)localObject1).optString("ip");
      localb.tIP = Integer.valueOf(((com.tencent.mm.ad.i)localObject1).optInt("port"));
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("CanvasDirection");
      p.j(localObject2, "json.optString(REMOTE_CONDIF_PC_CANVAS_DIRECTION)");
      localObject2 = n.bHC((String)localObject2);
      if (localObject2 != null) {
        localb.tIT = ((Number)localObject2).intValue();
      }
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("VideoSolution");
      p.j(localObject2, "it");
      localObject2 = n.a((CharSequence)localObject2, new String[] { "*" });
      Integer localInteger = n.bHC((String)j.lo((List)localObject2));
      if (localInteger == null) {
        break label595;
      }
      i = localInteger.intValue();
      localObject2 = n.bHC((String)j.lq((List)localObject2));
      if (localObject2 == null) {
        break label601;
      }
      j = ((Integer)localObject2).intValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        int i;
        int j;
        boolean bool;
        Log.printErrStackTrace("MicroMsg.PluginCast", (Throwable)localException, "isScreenCastCode error", new Object[0]);
        x localx = x.aazN;
        continue;
        do
        {
          localObject2 = ar.au(MMApplicationContext.getContext());
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
          break label433;
          if (i == 0) {
            break;
          }
        } while (j != 0);
      }
    }
    localObject2 = ar.au(MMApplicationContext.getContext());
    if (localb.tIT == 0)
    {
      localb.setVideoSize(((Point)localObject2).y, ((Point)localObject2).x);
      Log.i("MicroMsg.PluginCast", "width is " + i + " and height is " + j + " and screen size is" + ((Point)localObject2).x + " amd " + ((Point)localObject2).y);
    }
    for (;;)
    {
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("VideoFrameRate");
      p.j(localObject2, "json.optString(REMOTE_CONFIG_VIDEO_FRAME)");
      localObject2 = n.bHC((String)localObject2);
      if (localObject2 != null) {
        localb.frameRate = ((Number)localObject2).intValue();
      }
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("VideoIFrameInterval");
      p.j(localObject2, "json.optString(REMOTE_CO…G_VIDEO_I_FRAME_INTERVAL)");
      localObject2 = n.bHC((String)localObject2);
      if (localObject2 != null) {
        localb.kSh = ((Number)localObject2).intValue();
      }
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("AudioRecordUseAndroidMic");
      p.j(localObject2, "json.optString(REMOTE_CO…AUDIO_USE_ANDROID_RECORD)");
      localObject2 = n.bHC((String)localObject2);
      if (localObject2 != null)
      {
        if (((Number)localObject2).intValue() != 1) {
          break label919;
        }
        bool = true;
        label433:
        localb.tIQ.tIM = bool;
      }
      localObject2 = ((com.tencent.mm.ad.i)localObject1).optString("AudioSampleRate");
      p.j(localObject2, "json.optString(REMOTE_CONFIG_AUDIO_SAMPLERATE)");
      localObject2 = n.bHC((String)localObject2);
      if (localObject2 != null)
      {
        i = ((Number)localObject2).intValue();
        localb.tIQ.audioSampleRate = i;
      }
      localObject1 = ((com.tencent.mm.ad.i)localObject1).optString("AudioChannelCnt");
      p.j(localObject1, "json.optString(REMOTE_CONFIG_AUDIO_CHANNEL_CNT)");
      localObject1 = n.bHC((String)localObject1);
      if (localObject1 != null)
      {
        i = ((Number)localObject1).intValue();
        localb.tIQ.tIN = i;
        localObject1 = x.aazN;
      }
      localObject1 = paramIntent.getStringExtra("pc_ip");
      if (localObject1 != null) {
        localb.tIR = ((String)localObject1);
      }
      paramIntent = paramIntent.getStringExtra("phone_ip");
      if (paramIntent != null) {
        localb.tIS = paramIntent;
      }
      AppMethodBeat.o(190196);
      return localb;
      label595:
      i = 0;
      break;
      label601:
      j = 0;
      break label925;
      localb.setVideoSize(((Point)localObject2).x, ((Point)localObject2).y);
    }
  }
  
  public final void execute(g paramg) {}
  
  public final void forceStopCurCast()
  {
    AppMethodBeat.i(190200);
    Object localObject = new Intent(MMApplicationContext.getContext(), ScreenCastForegroundService.class);
    MMApplicationContext.getContext().stopService((Intent)localObject);
    localObject = a.cLu();
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.cast.d.a)localObject).stopRecord();
      AppMethodBeat.o(190200);
      return;
    }
    AppMethodBeat.o(190200);
  }
  
  public final int getCurrentConnectStatus()
  {
    return 0;
  }
  
  public final void installed()
  {
    AppMethodBeat.i(190205);
    super.installed();
    alias(a.class);
    AppMethodBeat.o(190205);
  }
  
  public final boolean isRecordAudio()
  {
    return true;
  }
  
  public final boolean isScreenRecording()
  {
    AppMethodBeat.i(190202);
    com.tencent.mm.plugin.cast.d.a locala = a.cLu();
    if (locala != null)
    {
      boolean bool = locala.tJr;
      AppMethodBeat.o(190202);
      return bool;
    }
    AppMethodBeat.o(190202);
    return false;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(190214);
    Log.i("MicroMsg.PluginCast", "happened account release");
    EventCenter.instance.add((IListener)this.tIc);
    EventCenter.instance.add((IListener)this.tIe);
    AppForegroundDelegate.fby.a((o)this.tId);
    AppMethodBeat.o(190214);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(190211);
    Log.i("MicroMsg.PluginCast", "happened account release");
    forceStopCurCast();
    EventCenter.instance.removeListener((IListener)this.tIc);
    EventCenter.instance.removeListener((IListener)this.tIe);
    AppForegroundDelegate.fby.b((o)this.tId);
    AppMethodBeat.o(190211);
  }
  
  public final void refreshRecordStatus(long paramLong, int paramInt, a.a parama) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/PluginCast$Companion;", "", "()V", "CAST_TO_PC", "", "CAST_TO_PC_CONNECTED_FAILED_DIFF_NETWORK", "CAST_TO_PC_CONNECTED_FAILED_FORBIDDEN", "CAST_TO_PC_CONNECTED_FAILED_TIMEOUT", "CAST_TO_PC_CONNECTING", "CAST_TO_PC_MEDIACODEC_INIT_FAILED", "CAST_TO_PC_READY", "CAST_TO_PC_SERVICE_REMOVED", "REMOTE_CONDIF_PC_CANVAS_DIRECTION", "", "REMOTE_CONFIG_AUDIO_CHANNEL_CNT", "REMOTE_CONFIG_AUDIO_SAMPLERATE", "REMOTE_CONFIG_AUDIO_USE_ANDROID_RECORD", "REMOTE_CONFIG_BITRATE", "REMOTE_CONFIG_DATA", "REMOTE_CONFIG_IP", "REMOTE_CONFIG_PORT", "REMOTE_CONFIG_RESOLUTION", "REMOTE_CONFIG_VIDEO_FRAME", "REMOTE_CONFIG_VIDEO_I_FRAME_INTERVAL", "REMOTE_PC_IP", "REMOTE_PHONE_IP", "TAG", "screenCastManager", "Lcom/tencent/mm/plugin/cast/manager/ScreenCastManager;", "getScreenCastManager", "()Lcom/tencent/mm/plugin/cast/manager/ScreenCastManager;", "setScreenCastManager", "(Lcom/tencent/mm/plugin/cast/manager/ScreenCastManager;)V", "startScreenCast", "", "stopScreenCast", "plugin-cast_release"})
  public static final class a
  {
    public static com.tencent.mm.plugin.cast.d.a cLu()
    {
      AppMethodBeat.i(189459);
      if (PluginCast.access$getScreenCastManager$cp() == null) {
        PluginCast.access$setScreenCastManager$cp(new com.tencent.mm.plugin.cast.d.a());
      }
      com.tencent.mm.plugin.cast.d.a locala = PluginCast.access$getScreenCastManager$cp();
      AppMethodBeat.o(189459);
      return locala;
    }
    
    public static void cLv()
    {
      AppMethodBeat.i(189461);
      ut localut = new ut();
      localut.fUa.fuZ = true;
      EventCenter.instance.publish((IEvent)localut);
      AppMethodBeat.o(189461);
    }
    
    public static void cLw()
    {
      AppMethodBeat.i(189462);
      ut localut = new ut();
      localut.fUa.fuZ = false;
      EventCenter.instance.publish((IEvent)localut);
      AppMethodBeat.o(189462);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/cast/PluginCast$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-cast_release"})
  public static final class b
    implements o
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(190383);
      Log.i("MicroMsg.PluginCast", "onAppBackground " + this.tIh.isScreenRecording());
      h.ZvG.n((Runnable)new a(this), 2000L);
      AppMethodBeat.o(190383);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(190387);
      Log.i("MicroMsg.PluginCast", "onAppForeground " + this.tIh.isScreenRecording());
      h.ZvG.n((Runnable)new b(this), 2000L);
      AppMethodBeat.o(190387);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(PluginCast.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(189662);
        if (this.tIi.tIh.isScreenRecording())
        {
          locala = PluginCast.tIg;
          PluginCast.a.cLv();
          AppMethodBeat.o(189662);
          return;
        }
        PluginCast.a locala = PluginCast.tIg;
        PluginCast.a.cLw();
        this.tIi.tIh.forceStopCurCast();
        AppMethodBeat.o(189662);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(PluginCast.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(189667);
        if (this.tIi.tIh.isScreenRecording())
        {
          locala = PluginCast.tIg;
          PluginCast.a.cLv();
          AppMethodBeat.o(189667);
          return;
        }
        PluginCast.a locala = PluginCast.tIg;
        PluginCast.a.cLw();
        this.tIi.tIh.forceStopCurCast();
        AppMethodBeat.o(189667);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/cast/PluginCast$scanQrcodeLiveAuthorizationEventListner$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ScanQrcodeLiveScreenCastAuthorizationEvent;", "callback", "", "event", "plugin-cast_release"})
  public static final class d
    extends IListener<up>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/plugin/cast/PluginCast$scanQrcodeLiveAuthorizationEventListner$1$callback$1$1"})
    static final class a
      implements com.tencent.mm.an.i
    {
      a(PluginCast.d paramd) {}
      
      public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
      {
        AppMethodBeat.i(190507);
        if (paramq == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.cast.netscene.NetSceneGetScreenCastAuthorization");
          AppMethodBeat.o(190507);
          throw paramString;
        }
        paramString = ((com.tencent.mm.plugin.cast.e.a)paramq).tJK;
        if (paramString != null)
        {
          paramq = paramString.SLm;
          if (paramq != null)
          {
            paramString = new Intent();
            paramString.putExtra("remoteConfig", paramq.SNI);
            paramString.putExtra("pc_ip", paramq.SNJ);
            paramString.putExtra("phone_ip", paramq.SNK);
            paramq = PluginCast.tIg;
            paramq = PluginCast.a.cLu();
            if (paramq != null)
            {
              paramq.tJj = PluginCast.access$getRemoteConfig(this.tIj.tIh, paramString);
              AppMethodBeat.o(190507);
              return;
            }
            AppMethodBeat.o(190507);
            return;
          }
        }
        AppMethodBeat.o(190507);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.PluginCast
 * JD-Core Version:    0.7.0.1
 */
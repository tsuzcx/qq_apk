package com.tencent.mm.plugin.cast.d;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.cast.PluginCast;
import com.tencent.mm.plugin.cast.PluginCast.a;
import com.tencent.mm.plugin.cast.f.b.b;
import com.tencent.mm.plugin.cast.i.d.a;
import com.tencent.mm.plugin.cast.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/manager/ScreenCastManager;", "", "()V", "avgFrameRenderCost", "", "getAvgFrameRenderCost", "()J", "setAvgFrameRenderCost", "(J)V", "batteryHelper", "Lcom/tencent/mm/plugin/cast/utils/BatteryUtils;", "getBatteryHelper", "()Lcom/tencent/mm/plugin/cast/utils/BatteryUtils;", "setBatteryHelper", "(Lcom/tencent/mm/plugin/cast/utils/BatteryUtils;)V", "eventCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "", "getEventCallback", "()Lkotlin/jvm/functions/Function1;", "setEventCallback", "(Lkotlin/jvm/functions/Function1;)V", "intentData", "Landroid/content/Intent;", "getIntentData", "()Landroid/content/Intent;", "setIntentData", "(Landroid/content/Intent;)V", "isScreenCasting", "", "()Z", "setScreenCasting", "(Z)V", "mConfig", "Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "getMConfig", "()Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "setMConfig", "(Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;)V", "mCurrentStatus", "getMCurrentStatus", "()Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "setMCurrentStatus", "(Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;)V", "mDataSenderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMDataSenderHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setMDataSenderHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "mDataSenderHandlerThread", "Landroid/os/HandlerThread;", "getMDataSenderHandlerThread", "()Landroid/os/HandlerThread;", "setMDataSenderHandlerThread", "(Landroid/os/HandlerThread;)V", "mFirstCostEncoder", "getMFirstCostEncoder", "setMFirstCostEncoder", "mFirstCostRender", "getMFirstCostRender", "setMFirstCostRender", "mMediaProjection", "Landroid/media/projection/MediaProjection;", "getMMediaProjection", "()Landroid/media/projection/MediaProjection;", "setMMediaProjection", "(Landroid/media/projection/MediaProjection;)V", "mScreenCastAudioEncoder", "Lcom/tencent/mm/plugin/cast/encoder/ScreenCastAudioEncoder;", "getMScreenCastAudioEncoder", "()Lcom/tencent/mm/plugin/cast/encoder/ScreenCastAudioEncoder;", "setMScreenCastAudioEncoder", "(Lcom/tencent/mm/plugin/cast/encoder/ScreenCastAudioEncoder;)V", "mScreenCastRenderer", "Lcom/tencent/mm/plugin/cast/render/ScreenCastRenderer;", "getMScreenCastRenderer", "()Lcom/tencent/mm/plugin/cast/render/ScreenCastRenderer;", "setMScreenCastRenderer", "(Lcom/tencent/mm/plugin/cast/render/ScreenCastRenderer;)V", "mScreenCastVideoEncoder", "Lcom/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder;", "getMScreenCastVideoEncoder", "()Lcom/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder;", "setMScreenCastVideoEncoder", "(Lcom/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder;)V", "mStartRecordingTimes", "getMStartRecordingTimes", "setMStartRecordingTimes", "mVirtualDisplay", "Landroid/hardware/display/VirtualDisplay;", "getMVirtualDisplay", "()Landroid/hardware/display/VirtualDisplay;", "setMVirtualDisplay", "(Landroid/hardware/display/VirtualDisplay;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "transportClient", "Lcom/tencent/mm/plugin/cast/transportclient/TransportClient;", "getTransportClient", "()Lcom/tencent/mm/plugin/cast/transportclient/TransportClient;", "setTransportClient", "(Lcom/tencent/mm/plugin/cast/transportclient/TransportClient;)V", "createMediaCodec", "config", "callback", "Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;", "createMediaProjection", "context", "Landroid/content/Context;", "intent", "createScreenRecorderUseMediaCodec", "createVirtualDisplay", "mediaProject", "surface", "Landroid/view/Surface;", "getEncoderStrategy", "getRendererStrategy", "initScreenCastMgr", "initTcpTransport", "retryConnect", "startRecord", "startScreenCast", "stopRecord", "translateStatus", "Companion", "plugin-cast_release"})
public final class a
{
  public static final a.a tJA;
  public VirtualDisplay mVirtualDisplay;
  public int resultCode;
  public com.tencent.mm.plugin.cast.b.b tJj;
  public MediaProjection tJk;
  public Intent tJl;
  com.tencent.mm.plugin.cast.c.c tJm;
  com.tencent.mm.plugin.cast.c.a tJn;
  public com.tencent.mm.plugin.cast.f.b tJo;
  private HandlerThread tJp;
  MMHandler tJq;
  public boolean tJr;
  public long tJs = -1L;
  public long tJt = -1L;
  public long tJu = -1L;
  long tJv = -1L;
  com.tencent.mm.plugin.cast.i.a tJw;
  public com.tencent.mm.plugin.cast.h.b tJx;
  public com.tencent.mm.plugin.cast.h.a.b tJy;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.cast.h.a.b, x> tJz;
  
  static
  {
    AppMethodBeat.i(189451);
    tJA = new a.a((byte)0);
    AppMethodBeat.o(189451);
  }
  
  private static int cLx()
  {
    AppMethodBeat.i(189438);
    e locale = e.tKY;
    if (e.cMf())
    {
      AppMethodBeat.o(189438);
      return 1;
    }
    AppMethodBeat.o(189438);
    return 2;
  }
  
  private static int cLy()
  {
    AppMethodBeat.i(189440);
    e locale = e.tKY;
    if (e.cMe())
    {
      AppMethodBeat.o(189440);
      return 1;
    }
    AppMethodBeat.o(189440);
    return 2;
  }
  
  private final int cLz()
  {
    AppMethodBeat.i(189442);
    com.tencent.mm.plugin.cast.h.a.b localb = this.tJy;
    if (localb == null) {}
    for (;;)
    {
      AppMethodBeat.o(189442);
      return 0;
      switch (b.$EnumSwitchMapping$0[localb.ordinal()])
      {
      }
    }
    AppMethodBeat.o(189442);
    return 1;
    AppMethodBeat.o(189442);
    return 2;
    AppMethodBeat.o(189442);
    return 3;
    AppMethodBeat.o(189442);
    return 4;
    AppMethodBeat.o(189442);
    return 5;
  }
  
  public final void C(kotlin.g.a.b<? super com.tencent.mm.plugin.cast.h.a.b, x> paramb)
  {
    AppMethodBeat.i(189435);
    p.k(paramb, "callback");
    Log.i("MicroMsg.ScreenCastManager", "initScreenCastMgr");
    paramb.invoke(com.tencent.mm.plugin.cast.h.a.b.tKr);
    this.tJz = paramb;
    this.tJp = new HandlerThread("MicroMsg.ScreenCastManager_DataSender", 5);
    paramb = this.tJp;
    if (paramb != null) {
      paramb.start();
    }
    paramb = this.tJp;
    if (paramb != null) {
      this.tJq = new MMHandler(paramb.getLooper(), (MMHandler.Callback)new a.c(this));
    }
    this.tJx = new com.tencent.mm.plugin.cast.h.b();
    paramb = this.tJj;
    if (paramb != null)
    {
      String str = paramb.tIO;
      if (str != null)
      {
        Object localObject = new StringBuilder("remote pc addr: ").append(str).append(":");
        paramb = this.tJj;
        if (paramb != null)
        {
          paramb = paramb.tIP;
          Log.i("MicroMsg.ScreenCastManager", paramb + "local phone is " + com.tencent.mm.plugin.cast.i.b.cMc());
          paramb = this.tJx;
          if (paramb == null) {
            break label264;
          }
          localObject = this.tJj;
          if (localObject == null) {
            break label259;
          }
          localObject = ((com.tencent.mm.plugin.cast.b.b)localObject).tIP;
          if (localObject == null) {
            break label259;
          }
        }
        label259:
        for (int i = ((Integer)localObject).intValue();; i = 0)
        {
          paramb.a(str, i, (com.tencent.mm.plugin.cast.h.a)new a.d(this));
          AppMethodBeat.o(189435);
          return;
          paramb = null;
          break;
        }
        label264:
        AppMethodBeat.o(189435);
        return;
      }
    }
    AppMethodBeat.o(189435);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(189446);
    h.ZvG.bc((Runnable)g.tJI);
    Object localObject = Long.valueOf(this.tJs);
    int i;
    label51:
    label101:
    label105:
    int j;
    if (((Number)localObject).longValue() != -1L)
    {
      i = 1;
      if (i == 0) {
        break label446;
      }
      if (localObject != null)
      {
        long l = ((Number)localObject).longValue();
        localObject = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.Io((int)l);
      }
      localObject = Long.valueOf(this.tJt);
      if (((Number)localObject).longValue() == -1L) {
        break label452;
      }
      i = 1;
      if (i == 0) {
        break label457;
      }
      if (localObject != null)
      {
        ((Number)localObject).longValue();
        localObject = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.In((int)this.tJt);
      }
      localObject = this.tJw;
      if (localObject == null) {
        break label463;
      }
      i = ((com.tencent.mm.plugin.cast.i.a)localObject).cMb();
      label149:
      localObject = Long.valueOf(this.tJv);
      if (((Number)localObject).longValue() == -1L) {
        break label468;
      }
      j = 1;
      label175:
      if (j == 0) {
        break label473;
      }
      label179:
      if (localObject == null) {
        break label479;
      }
      j = (int)Util.ticksToNow(((Number)localObject).longValue());
      localObject = com.tencent.mm.plugin.cast.g.a.tKa;
      com.tencent.mm.plugin.cast.g.a.Iq(j);
    }
    for (;;)
    {
      localObject = this.tJj;
      if (localObject != null)
      {
        com.tencent.mm.plugin.cast.g.a locala = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.a(((com.tencent.mm.media.b.d)localObject).bitrate, ((com.tencent.mm.media.b.d)localObject).targetHeight, ((com.tencent.mm.media.b.d)localObject).targetWidth, ((com.tencent.mm.media.b.d)localObject).frameRate, j, i, cLx(), cLy(), (int)this.tJs, (int)this.tJt, (int)this.tJu, cLz());
      }
      localObject = this.tJx;
      if (localObject != null) {
        ((com.tencent.mm.plugin.cast.h.b)localObject).disconnect();
      }
      localObject = this.tJq;
      if (localObject != null) {
        ((MMHandler)localObject).removeCallbacksAndMessages(null);
      }
      localObject = this.tJq;
      if (localObject != null) {
        ((MMHandler)localObject).quitSafely();
      }
      this.tJq = null;
      localObject = this.tJp;
      if (localObject != null) {
        ((HandlerThread)localObject).quitSafely();
      }
      localObject = this.tJn;
      if (localObject != null) {
        ((com.tencent.mm.plugin.cast.c.a)localObject).stopRecord();
      }
      localObject = this.tJm;
      if (localObject != null) {
        ((com.tencent.mm.plugin.cast.c.c)localObject).stopRecord();
      }
      localObject = this.tJo;
      if (localObject != null) {
        ((com.tencent.mm.plugin.cast.f.b)localObject).release();
      }
      localObject = this.tJk;
      if (localObject != null) {
        ((MediaProjection)localObject).stop();
      }
      localObject = this.mVirtualDisplay;
      if (localObject != null) {
        ((VirtualDisplay)localObject).release();
      }
      this.tJr = false;
      this.tJy = null;
      AppMethodBeat.o(189446);
      return;
      i = 0;
      break;
      label446:
      localObject = null;
      break label51;
      label452:
      i = 0;
      break label101;
      label457:
      localObject = null;
      break label105;
      label463:
      i = 0;
      break label149;
      label468:
      j = 0;
      break label175;
      label473:
      localObject = null;
      break label179;
      label479:
      j = 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public b(a parama, com.tencent.mm.plugin.cast.b.b paramb, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public static final f tJH;
    
    static
    {
      AppMethodBeat.i(189889);
      tJH = new f();
      AppMethodBeat.o(189889);
    }
    
    public final void run()
    {
      AppMethodBeat.i(189887);
      PluginCast.a locala = PluginCast.tIg;
      PluginCast.a.cLv();
      AppMethodBeat.o(189887);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    public static final g tJI;
    
    static
    {
      AppMethodBeat.i(190514);
      tJI = new g();
      AppMethodBeat.o(190514);
    }
    
    public final void run()
    {
      AppMethodBeat.i(190511);
      PluginCast.a locala = PluginCast.tIg;
      PluginCast.a.cLw();
      AppMethodBeat.o(190511);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.d.a
 * JD-Core Version:    0.7.0.1
 */
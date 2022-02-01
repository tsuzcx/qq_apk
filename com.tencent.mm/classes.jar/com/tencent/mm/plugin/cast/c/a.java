package com.tencent.mm.plugin.cast.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.hardware.display.VirtualDisplay;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.cast.PluginCast;
import com.tencent.mm.plugin.cast.PluginCast.a;
import com.tencent.mm.plugin.cast.e.b.b;
import com.tencent.mm.plugin.cast.h.d.a;
import com.tencent.mm.plugin.cast.h.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.net.Socket;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/manager/ScreenCastManager;", "", "()V", "avgFrameRenderCost", "", "getAvgFrameRenderCost", "()J", "setAvgFrameRenderCost", "(J)V", "batteryHelper", "Lcom/tencent/mm/plugin/cast/utils/BatteryUtils;", "getBatteryHelper", "()Lcom/tencent/mm/plugin/cast/utils/BatteryUtils;", "setBatteryHelper", "(Lcom/tencent/mm/plugin/cast/utils/BatteryUtils;)V", "eventCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "", "getEventCallback", "()Lkotlin/jvm/functions/Function1;", "setEventCallback", "(Lkotlin/jvm/functions/Function1;)V", "intentData", "Landroid/content/Intent;", "getIntentData", "()Landroid/content/Intent;", "setIntentData", "(Landroid/content/Intent;)V", "isScreenCasting", "", "()Z", "setScreenCasting", "(Z)V", "mConfig", "Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "getMConfig", "()Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;", "setMConfig", "(Lcom/tencent/mm/plugin/cast/config/ScreenRecordConfig;)V", "mCurrentStatus", "getMCurrentStatus", "()Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "setMCurrentStatus", "(Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;)V", "mDataSenderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMDataSenderHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setMDataSenderHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "mDataSenderHandlerThread", "Landroid/os/HandlerThread;", "getMDataSenderHandlerThread", "()Landroid/os/HandlerThread;", "setMDataSenderHandlerThread", "(Landroid/os/HandlerThread;)V", "mFirstCostEncoder", "getMFirstCostEncoder", "setMFirstCostEncoder", "mFirstCostRender", "getMFirstCostRender", "setMFirstCostRender", "mMediaProjection", "Landroid/media/projection/MediaProjection;", "getMMediaProjection", "()Landroid/media/projection/MediaProjection;", "setMMediaProjection", "(Landroid/media/projection/MediaProjection;)V", "mScreenCastAudioEncoder", "Lcom/tencent/mm/plugin/cast/encoder/ScreenCastAudioEncoder;", "getMScreenCastAudioEncoder", "()Lcom/tencent/mm/plugin/cast/encoder/ScreenCastAudioEncoder;", "setMScreenCastAudioEncoder", "(Lcom/tencent/mm/plugin/cast/encoder/ScreenCastAudioEncoder;)V", "mScreenCastRenderer", "Lcom/tencent/mm/plugin/cast/render/ScreenCastRenderer;", "getMScreenCastRenderer", "()Lcom/tencent/mm/plugin/cast/render/ScreenCastRenderer;", "setMScreenCastRenderer", "(Lcom/tencent/mm/plugin/cast/render/ScreenCastRenderer;)V", "mScreenCastVideoEncoder", "Lcom/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder;", "getMScreenCastVideoEncoder", "()Lcom/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder;", "setMScreenCastVideoEncoder", "(Lcom/tencent/mm/plugin/cast/encoder/ScreenCastVideoEncoder;)V", "mStartRecordingTimes", "getMStartRecordingTimes", "setMStartRecordingTimes", "mVirtualDisplay", "Landroid/hardware/display/VirtualDisplay;", "getMVirtualDisplay", "()Landroid/hardware/display/VirtualDisplay;", "setMVirtualDisplay", "(Landroid/hardware/display/VirtualDisplay;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "transportClient", "Lcom/tencent/mm/plugin/cast/transportclient/TransportClient;", "getTransportClient", "()Lcom/tencent/mm/plugin/cast/transportclient/TransportClient;", "setTransportClient", "(Lcom/tencent/mm/plugin/cast/transportclient/TransportClient;)V", "createMediaCodec", "config", "callback", "Lcom/tencent/mm/plugin/cast/utils/RecordHelper$IMediaCodecCallback;", "createMediaProjection", "context", "Landroid/content/Context;", "intent", "createScreenRecorderUseMediaCodec", "createVirtualDisplay", "mediaProject", "surface", "Landroid/view/Surface;", "getEncoderStrategy", "getRendererStrategy", "initScreenCastMgr", "initTcpTransport", "retryConnect", "startRecord", "startScreenCast", "stopRecord", "translateStatus", "Companion", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a wML;
  VirtualDisplay mVirtualDisplay;
  public int resultCode;
  public com.tencent.mm.plugin.cast.a.b wMM;
  private MediaProjection wMN;
  public Intent wMO;
  com.tencent.mm.plugin.cast.b.b wMP;
  com.tencent.mm.plugin.cast.b.a wMQ;
  com.tencent.mm.plugin.cast.e.b wMR;
  private HandlerThread wMS;
  MMHandler wMT;
  public boolean wMU;
  public long wMV = -1L;
  public long wMW = -1L;
  public long wMX = -1L;
  long wMY = -1L;
  com.tencent.mm.plugin.cast.h.a wMZ;
  public com.tencent.mm.plugin.cast.g.b wNa;
  public com.tencent.mm.plugin.cast.g.a.b wNb;
  kotlin.g.a.b<? super com.tencent.mm.plugin.cast.g.a.b, ah> wNc;
  
  static
  {
    AppMethodBeat.i(274214);
    wML = new a.a((byte)0);
    AppMethodBeat.o(274214);
  }
  
  private static final boolean a(a parama, Message paramMessage)
  {
    int j = 0;
    AppMethodBeat.i(274179);
    s.u(parama, "this$0");
    s.u(paramMessage, "it");
    paramMessage = paramMessage.getData();
    byte b;
    int i;
    label58:
    com.tencent.mm.plugin.cast.g.b localb;
    if (paramMessage != null)
    {
      b = paramMessage.getByte("data_type");
      paramMessage = paramMessage.getByteArray("data_data");
      if (paramMessage == null) {
        break label163;
      }
      i = 1;
      if (i == 0) {
        break label168;
      }
      if (paramMessage != null)
      {
        if (b != 1) {
          break label178;
        }
        Log.i("MicroMsg.ScreenCastManager", "onVideoFrame Ready");
        localb = parama.wNa;
        if (localb != null)
        {
          paramMessage = Integer.valueOf(localb.a(b, paramMessage));
          i = j;
          if (((Number)paramMessage).intValue() != 0) {
            i = 1;
          }
          if (i == 0) {
            break label173;
          }
          label117:
          if (paramMessage != null)
          {
            ((Number)paramMessage).intValue();
            parama.wNb = com.tencent.mm.plugin.cast.g.a.b.wNP;
            parama = parama.wNc;
            if (parama != null) {
              parama.invoke(com.tencent.mm.plugin.cast.g.a.b.wNP);
            }
          }
        }
      }
    }
    label276:
    label279:
    for (;;)
    {
      AppMethodBeat.o(274179);
      return true;
      label163:
      i = 0;
      break;
      label168:
      paramMessage = null;
      break label58;
      label173:
      paramMessage = null;
      break label117;
      label178:
      if (b == 2)
      {
        Log.i("MicroMsg.ScreenCastManager", "onAudioFrame Ready");
        localb = parama.wNa;
        if (localb != null)
        {
          paramMessage = Integer.valueOf(localb.a(b, paramMessage));
          if (((Number)paramMessage).intValue() != 0)
          {
            i = 1;
            label226:
            if (i == 0) {
              break label276;
            }
          }
          for (;;)
          {
            if (paramMessage == null) {
              break label279;
            }
            ((Number)paramMessage).intValue();
            parama.wNb = com.tencent.mm.plugin.cast.g.a.b.wNP;
            parama = parama.wNc;
            if (parama == null) {
              break;
            }
            parama.invoke(com.tencent.mm.plugin.cast.g.a.b.wNP);
            break;
            i = 0;
            break label226;
            paramMessage = null;
          }
        }
      }
    }
  }
  
  private static final void dpf()
  {
    AppMethodBeat.i(274184);
    PluginCast.a locala = PluginCast.wLM;
    PluginCast.a.dpc();
    AppMethodBeat.o(274184);
  }
  
  private static final void dpg()
  {
    AppMethodBeat.i(274190);
    PluginCast.a locala = PluginCast.wLM;
    PluginCast.a.dpd();
    AppMethodBeat.o(274190);
  }
  
  public final void ae(kotlin.g.a.b<? super com.tencent.mm.plugin.cast.g.a.b, ah> paramb)
  {
    int i = 0;
    AppMethodBeat.i(274244);
    s.u(paramb, "callback");
    Log.i("MicroMsg.ScreenCastManager", "initScreenCastMgr");
    paramb.invoke(com.tencent.mm.plugin.cast.g.a.b.wNK);
    Object localObject1 = ah.aiuX;
    this.wNc = paramb;
    this.wMS = new HandlerThread("MicroMsg.ScreenCastManager_DataSender", 5);
    paramb = this.wMS;
    if (paramb != null) {
      paramb.start();
    }
    paramb = this.wMS;
    if (paramb != null) {
      this.wMT = new MMHandler(paramb.getLooper(), new a..ExternalSyntheticLambda0(this));
    }
    this.wNa = new com.tencent.mm.plugin.cast.g.b();
    paramb = this.wMM;
    Object localObject2;
    if (paramb != null)
    {
      localObject1 = paramb.wMv;
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder("remote pc addr: ").append((String)localObject1).append(':');
        paramb = this.wMM;
        if (paramb != null) {
          break label235;
        }
        paramb = null;
        Log.i("MicroMsg.ScreenCastManager", paramb + "local phone is " + com.tencent.mm.plugin.cast.h.b.dpG());
        paramb = this.wNa;
        if (paramb != null)
        {
          localObject2 = this.wMM;
          if (localObject2 != null) {
            break label243;
          }
        }
      }
    }
    for (;;)
    {
      paramb.a((String)localObject1, i, (com.tencent.mm.plugin.cast.g.a)new d(this));
      AppMethodBeat.o(274244);
      return;
      label235:
      paramb = paramb.wMw;
      break;
      label243:
      localObject2 = ((com.tencent.mm.plugin.cast.a.b)localObject2).wMw;
      if (localObject2 != null) {
        i = ((Integer)localObject2).intValue();
      }
    }
  }
  
  public final void fS(final Context paramContext)
  {
    AppMethodBeat.i(274261);
    s.u(paramContext, "context");
    final com.tencent.mm.plugin.cast.a.b localb;
    try
    {
      localb = this.wMM;
      if (localb == null) {
        break label321;
      }
      this.wMR = new com.tencent.mm.plugin.cast.e.b(localb.nxO, localb.nxP, localb.frameRate);
      localObject1 = this.wMO;
      s.checkNotNull(localObject1);
      i = this.resultCode;
      s.u(paramContext, "context");
      s.u(localObject1, "intent");
      Log.i("MicroMsg.ScreenCastManager", "createMediaProjection");
      localObject2 = paramContext.getSystemService("media_projection");
      if (localObject2 == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
        AppMethodBeat.o(274261);
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      Log.printInfoStack("MicroMsg.ScreenCastManager", "start foregound service failed cause " + paramContext + " and stack is %s", new Object[] { paramContext.getStackTrace() });
      paramContext = this.wNc;
      if (paramContext != null) {
        paramContext.invoke(com.tencent.mm.plugin.cast.g.a.b.wNO);
      }
      AppMethodBeat.o(274261);
      return;
    }
    Object localObject1 = ((MediaProjectionManager)localObject2).getMediaProjection(i, (Intent)localObject1);
    s.s(localObject1, "context.getSystemService…ction(resultCode, intent)");
    s.u(paramContext, "context");
    s.u(localObject1, "mediaProject");
    s.u(localb, "config");
    Log.i("MicroMsg.ScreenCastManager", "createVirtualDisplay");
    int i = (int)com.tencent.mm.cd.a.getDensity(paramContext);
    Object localObject2 = ((MediaProjection)localObject1).createVirtualDisplay("MicroMsg.ScreenCastManager", localb.nxO, localb.nxP, i, 16, null, null, null);
    s.s(localObject2, "mediaProject.createVirtu…MIRROR, null, null, null)");
    this.mVirtualDisplay = ((VirtualDisplay)localObject2);
    localObject2 = ah.aiuX;
    this.wMN = ((MediaProjection)localObject1);
    localObject1 = this.wMR;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.cast.e.b)localObject1).K((kotlin.g.a.a)new c(this, localb, paramContext));
    }
    label321:
    paramContext = com.tencent.mm.plugin.cast.f.a.wNt;
    com.tencent.mm.plugin.cast.f.a.dpq();
    h.ahAA.bk(a..ExternalSyntheticLambda1.INSTANCE);
    this.wMU = true;
    AppMethodBeat.o(274261);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(274276);
    h.ahAA.bk(a..ExternalSyntheticLambda2.INSTANCE);
    Object localObject1 = Long.valueOf(this.wMV);
    int i;
    label48:
    label100:
    label104:
    int j;
    label144:
    int k;
    label172:
    label176:
    Object localObject2;
    int i1;
    int i2;
    int i3;
    int i4;
    int m;
    label261:
    int n;
    label275:
    int i5;
    int i6;
    int i7;
    if (((Number)localObject1).longValue() != -1L)
    {
      i = 1;
      if (i == 0) {
        break label859;
      }
      if (localObject1 != null)
      {
        long l = ((Number)localObject1).longValue();
        localObject1 = com.tencent.mm.plugin.cast.f.a.wNt;
        com.tencent.mm.plugin.cast.f.a.IR((int)l);
      }
      localObject1 = Long.valueOf(this.wMW);
      if (((Number)localObject1).longValue() == -1L) {
        break label865;
      }
      i = 1;
      if (i == 0) {
        break label870;
      }
      if (localObject1 != null)
      {
        ((Number)localObject1).longValue();
        localObject1 = com.tencent.mm.plugin.cast.f.a.wNt;
        com.tencent.mm.plugin.cast.f.a.IQ((int)this.wMW);
      }
      localObject1 = this.wMZ;
      if (localObject1 != null) {
        break label876;
      }
      j = 0;
      k = 0;
      localObject1 = Long.valueOf(this.wMY);
      if (((Number)localObject1).longValue() == -1L) {
        break label988;
      }
      i = 1;
      if (i == 0) {
        break label993;
      }
      if (localObject1 != null)
      {
        k = (int)Util.ticksToNow(((Number)localObject1).longValue());
        localObject1 = com.tencent.mm.plugin.cast.f.a.wNt;
        com.tencent.mm.plugin.cast.f.a.IT(k);
      }
      localObject1 = this.wMM;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.cast.f.a.wNt;
        i1 = ((com.tencent.mm.media.b.d)localObject1).bitrate;
        i2 = ((com.tencent.mm.media.b.d)localObject1).nxP;
        i3 = ((com.tencent.mm.media.b.d)localObject1).nxO;
        i4 = ((com.tencent.mm.media.b.d)localObject1).frameRate;
        localObject1 = e.wOn;
        if (!e.dpJ()) {
          break label999;
        }
        m = 1;
        localObject1 = e.wOn;
        if (!e.dpI()) {
          break label1005;
        }
        n = 1;
        i5 = (int)this.wMV;
        i6 = (int)this.wMW;
        i7 = (int)this.wMX;
        localObject1 = this.wNb;
        if (localObject1 != null) {
          break label1011;
        }
        i = -1;
        switch (i)
        {
        default: 
          label309:
          i = 0;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.cast.f.a.a(i1, i2, i3, i4, k, j, m, n, i5, i6, i7, i);
      localObject1 = this.wNa;
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.cast.g.b)localObject1).wNx.dpA();
        ((com.tencent.mm.plugin.cast.g.b)localObject1).wNy.alI("EXIT");
        Thread.sleep(50L);
        localObject1 = ((com.tencent.mm.plugin.cast.g.b)localObject1).wNw;
        if (((com.tencent.mm.plugin.cast.g.a.a)localObject1).wNC == com.tencent.mm.plugin.cast.g.a.b.wNL)
        {
          localObject2 = ((com.tencent.mm.plugin.cast.g.a.a)localObject1).wNH;
          s.checkNotNull(localObject2);
          ((Socket)localObject2).close();
          ((com.tencent.mm.plugin.cast.g.a.a)localObject1).wNC = com.tencent.mm.plugin.cast.g.a.b.wNJ;
          ((com.tencent.mm.plugin.cast.g.a.a)localObject1).wNH = new Socket();
        }
      }
      localObject1 = this.wMT;
      if (localObject1 != null) {
        ((MMHandler)localObject1).removeCallbacksAndMessages(null);
      }
      localObject1 = this.wMT;
      if (localObject1 != null) {
        ((MMHandler)localObject1).quitSafely();
      }
      this.wMT = null;
      localObject1 = this.wMS;
      if (localObject1 != null) {
        ((HandlerThread)localObject1).quitSafely();
      }
      localObject1 = this.wMQ;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.cast.b.a)localObject1).stopRecord();
      }
      localObject1 = this.wMP;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.cast.b.b)localObject1).stopRecord();
      }
      localObject1 = this.wMR;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.cast.f.a.wNt;
        com.tencent.mm.plugin.cast.f.a.IP((int)((com.tencent.mm.plugin.cast.e.b)localObject1).wNq);
        ((com.tencent.mm.plugin.cast.e.b)localObject1).nBk.removeCallbacksAndMessages(null);
        ((com.tencent.mm.plugin.cast.e.b)localObject1).nBk.quitSafely();
        localObject2 = ((com.tencent.mm.plugin.cast.e.b)localObject1).mVE;
        if (localObject2 != null) {
          ((HandlerThread)localObject2).quitSafely();
        }
        localObject2 = ((com.tencent.mm.plugin.cast.e.b)localObject1).wNo;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.c)localObject2).release();
        }
        localObject2 = ((com.tencent.mm.plugin.cast.e.b)localObject1).wNn;
        Object localObject3;
        if (localObject2 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.cast.e.a)localObject2).wNj;
          if (localObject3 != null) {
            ((Surface)localObject3).release();
          }
          localObject3 = ((com.tencent.mm.plugin.cast.e.a)localObject2).inputSurface;
          if (localObject3 != null) {
            ((Surface)localObject3).release();
          }
          ((com.tencent.mm.plugin.cast.e.a)localObject2).inputSurface = null;
          localObject3 = ((com.tencent.mm.plugin.cast.e.a)localObject2).imageReader;
          if (localObject3 != null) {
            ((ImageReader)localObject3).close();
          }
          ((com.tencent.mm.plugin.cast.e.a)localObject2).imageReader = null;
        }
        localObject2 = ((com.tencent.mm.plugin.cast.e.b)localObject1).mVJ;
        if (localObject2 != null)
        {
          localObject3 = com.tencent.mm.media.util.c.nFs;
          c.a.a((c.b)localObject2);
        }
        localObject2 = ((com.tencent.mm.plugin.cast.e.b)localObject1).mVI;
        if (localObject2 != null) {
          ((Surface)localObject2).release();
        }
        localObject2 = ((com.tencent.mm.plugin.cast.e.b)localObject1).mSurfaceTexture;
        if (localObject2 != null) {
          ((SurfaceTexture)localObject2).release();
        }
        ((com.tencent.mm.plugin.cast.e.b)localObject1).eln.removeCallbacksAndMessages(null);
        ((com.tencent.mm.plugin.cast.e.b)localObject1).eln.stopTimer();
        ((com.tencent.mm.plugin.cast.e.b)localObject1).eln.quitSafely();
        localObject1 = ((com.tencent.mm.plugin.cast.e.b)localObject1).surface;
        if (localObject1 != null) {
          ((Surface)localObject1).release();
        }
      }
      localObject1 = this.wMN;
      if (localObject1 != null) {
        ((MediaProjection)localObject1).stop();
      }
      localObject1 = this.mVirtualDisplay;
      if (localObject1 != null) {
        ((VirtualDisplay)localObject1).release();
      }
      this.wMU = false;
      this.wNb = null;
      AppMethodBeat.o(274276);
      return;
      i = 0;
      break;
      label859:
      localObject1 = null;
      break label48;
      label865:
      i = 0;
      break label100;
      label870:
      localObject1 = null;
      break label104;
      label876:
      ((com.tencent.mm.plugin.cast.h.a)localObject1).wOi = false;
      if (((com.tencent.mm.plugin.cast.h.a)localObject1).wOh > 0L)
      {
        Log.i("MicroMsg.BatteryUtils", "sum avgBattery=￥avgAverageBattery} microAmpere and avg avgBattery= " + ((com.tencent.mm.plugin.cast.h.a)localObject1).wOh + ' ');
        localObject2 = com.tencent.mm.plugin.cast.f.a.wNt;
        com.tencent.mm.plugin.cast.f.a.IS((int)((com.tencent.mm.plugin.cast.h.a)localObject1).wOh);
      }
      i = (int)((com.tencent.mm.plugin.cast.h.a)localObject1).wOh;
      localObject2 = ((com.tencent.mm.plugin.cast.h.a)localObject1).handler;
      if (localObject2 != null) {
        ((MMHandler)localObject2).removeCallbacksAndMessages(null);
      }
      localObject1 = ((com.tencent.mm.plugin.cast.h.a)localObject1).handler;
      j = i;
      if (localObject1 == null) {
        break label144;
      }
      ((MMHandler)localObject1).quitSafely();
      j = i;
      break label144;
      label988:
      i = 0;
      break label172;
      label993:
      localObject1 = null;
      break label176;
      label999:
      m = 2;
      break label261;
      label1005:
      n = 2;
      break label275;
      label1011:
      i = b.$EnumSwitchMapping$0[localObject1.ordinal()];
      break label309;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama, com.tencent.mm.plugin.cast.a.b paramb, Context paramContext)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "pcmData", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<byte[], ah>
    {
      a(Context paramContext, a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/cast/manager/ScreenCastManager$initTcpTransport$2$1", "Lcom/tencent/mm/plugin/cast/transportclient/ConnectListener;", "onConnected", "", "errCode", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.cast.g.a
  {
    d(a parama) {}
    
    private static final void a(a parama, com.tencent.mm.plugin.cast.g.a.b paramb)
    {
      AppMethodBeat.i(274162);
      s.u(parama, "this$0");
      s.u(paramb, "$errCode");
      parama = parama.wNc;
      if (parama != null) {
        parama.invoke(paramb);
      }
      AppMethodBeat.o(274162);
    }
    
    public final void a(com.tencent.mm.plugin.cast.g.a.b paramb)
    {
      AppMethodBeat.i(274175);
      s.u(paramb, "errCode");
      Log.d("MicroMsg.ScreenCastManager", s.X("onConnected errCode:", paramb));
      this.wNd.wNb = paramb;
      h.ahAA.bk(new a.d..ExternalSyntheticLambda0(this.wNd, paramb));
      AppMethodBeat.o(274175);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/cast/manager/ScreenCastManager$retryConnect$2$1", "Lcom/tencent/mm/plugin/cast/transportclient/ConnectListener;", "onConnected", "", "errCode", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.cast.g.a
  {
    public e(a parama) {}
    
    private static final void a(a parama, com.tencent.mm.plugin.cast.g.a.b paramb)
    {
      AppMethodBeat.i(274156);
      s.u(parama, "this$0");
      s.u(paramb, "$errCode");
      parama = parama.wNc;
      if (parama != null) {
        parama.invoke(paramb);
      }
      AppMethodBeat.o(274156);
    }
    
    public final void a(com.tencent.mm.plugin.cast.g.a.b paramb)
    {
      AppMethodBeat.i(274168);
      s.u(paramb, "errCode");
      Log.d("MicroMsg.ScreenCastManager", s.X("onConnected errCode:", paramb));
      this.wNd.wNb = paramb;
      h.ahAA.bk(new a.e..ExternalSyntheticLambda0(this.wNd, paramb));
      AppMethodBeat.o(274168);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.c.a
 * JD-Core Version:    0.7.0.1
 */
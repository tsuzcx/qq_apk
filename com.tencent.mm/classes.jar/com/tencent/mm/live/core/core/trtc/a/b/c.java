package com.tencent.mm.live.core.core.trtc.a.b;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.h;
import com.tencent.mm.live.core.core.trtc.a.a.a;
import com.tencent.mm.live.core.core.trtc.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;
import com.tencent.trtc.TRTCCloudDef.TRTCMixUser;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private TRTCCloud hAY;
  private final a hBL;
  private boolean hBM;
  private ArrayList<b> hBN;
  private String hBO;
  private HashMap<String, h> hBP;
  private HashMap<Long, TXLivePlayer> hBQ;
  private int hBR;
  private int hBS;
  
  public c(TRTCCloud paramTRTCCloud, a parama)
  {
    AppMethodBeat.i(196287);
    this.hBR = 1258344707;
    this.hBS = 58415;
    this.hAY = paramTRTCCloud;
    this.hBL = parama;
    this.hBM = true;
    this.hBN = new ArrayList();
    this.hBP = new HashMap();
    this.hBQ = new HashMap();
    AppMethodBeat.o(196287);
  }
  
  private boolean Gt(String paramString)
  {
    AppMethodBeat.i(196290);
    Iterator localIterator = this.hBN.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb != null) && (localb.userId != null) && (localb.userId.equals(paramString)) && (localb.streamType == 0))
      {
        AppMethodBeat.o(196290);
        return true;
      }
    }
    AppMethodBeat.o(196290);
    return false;
  }
  
  private b Gu(String paramString)
  {
    AppMethodBeat.i(196291);
    Iterator localIterator = this.hBN.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb != null) && (localb.userId != null) && (localb.userId.equals(paramString)) && (localb.streamType == 0))
      {
        AppMethodBeat.o(196291);
        return localb;
      }
    }
    AppMethodBeat.o(196291);
    return null;
  }
  
  public static void Gw(String paramString)
  {
    AppMethodBeat.i(196294);
    b localb = new b((byte)0);
    localb.userId = paramString;
    localb.streamType = 0;
    if (b.a.aDT().Gr(paramString) == null)
    {
      paramString = new a(paramString);
      b.a.aDT().a(paramString);
    }
    AppMethodBeat.o(196294);
  }
  
  private void Gz(String paramString)
  {
    AppMethodBeat.i(196299);
    h localh = (h)this.hBP.remove(paramString);
    if (localh != null) {
      localh.release();
    }
    this.hAY.stopRemoteSubStreamView(paramString);
    AppMethodBeat.o(196299);
  }
  
  public final void B(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(196301);
    int i = 720;
    int j = 1280;
    if (!a.a.aDH().aDD().hBw)
    {
      i = 1280;
      j = 720;
    }
    int k = 180;
    int m = 320;
    if (!a.a.aDH().aDD().hBG)
    {
      k = 320;
      m = 180;
    }
    int i3 = 50;
    int i2 = 200;
    int i1;
    int n;
    float f1;
    float f2;
    TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig;
    label524:
    Object localObject2;
    TRTCCloudDef.TRTCMixUser localTRTCMixUser;
    switch (a.a.aDH().aDD().hBu)
    {
    default: 
      i1 = m;
      n = i;
      m = j;
      j = i1;
      i1 = i3;
      i = i2;
      i2 = a.a.aDH().aDD().mVideoBitrate;
      if (i2 > 0) {
        i = i2;
      }
      f1 = paramFloat1 / au.az(MMApplicationContext.getContext()).x * n;
      f2 = paramFloat2 / au.az(MMApplicationContext.getContext()).y * m;
      Log.i("MicroMsg.LiveCoreVisitor", "xOffset:%s, realXOffset:%s, yOffset:%s, realYOffset:%s, videoWidth:%s, videoHeight:%s, bitrate:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(f1), Float.valueOf(paramFloat2), Float.valueOf(f2), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i) });
      localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
      localTRTCTranscodingConfig.appId = this.hBR;
      localTRTCTranscodingConfig.bizId = this.hBS;
      localTRTCTranscodingConfig.videoWidth = n;
      localTRTCTranscodingConfig.videoHeight = m;
      localTRTCTranscodingConfig.videoGOP = 1;
      localTRTCTranscodingConfig.videoFramerate = 15;
      localTRTCTranscodingConfig.videoBitrate = i;
      localTRTCTranscodingConfig.audioSampleRate = 48000;
      localTRTCTranscodingConfig.audioBitrate = 64;
      localTRTCTranscodingConfig.audioChannels = 2;
      Object localObject1 = new TRTCCloudDef.TRTCMixUser();
      ((TRTCCloudDef.TRTCMixUser)localObject1).userId = this.hBO;
      ((TRTCCloudDef.TRTCMixUser)localObject1).zOrder = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).x = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).y = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).width = n;
      ((TRTCCloudDef.TRTCMixUser)localObject1).height = m;
      localTRTCTranscodingConfig.mixUsers = new ArrayList();
      localTRTCTranscodingConfig.mixUsers.add(localObject1);
      if (!a.a.aDH().aDD().hBE) {
        break label1640;
      }
      TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.hBN.size());
      localObject1 = b.a.aDT().hBJ;
      if (localObject1 == null) {
        break label1640;
      }
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label1640;
      }
      localObject2 = (a)((Iterator)localObject1).next();
      localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
      com.tencent.mm.live.core.core.trtc.a.a.c localc = a.a.aDH().aDF();
      if ((localc.hBs) && (((a)localObject2).goe.equalsIgnoreCase(localc.hBr))) {
        localTRTCMixUser.roomId = localc.hBq;
      }
      localTRTCMixUser.userId = ((a)localObject2).goe;
      localTRTCMixUser.streamType = ((a)localObject2).mStreamType;
      localTRTCMixUser.zOrder = (i + 1);
      localTRTCMixUser.pureAudio = true;
      localObject2 = Gu(localTRTCMixUser.userId);
      if (localObject2 != null)
      {
        localTRTCMixUser.pureAudio = ((b)localObject2).hBV;
        if (i >= 3) {
          break label1589;
        }
        if (((b)localObject2).x != 0) {
          break label1556;
        }
        localTRTCMixUser.x = (n - 5 - k + (int)f1);
        label687:
        localTRTCMixUser.x = Math.max(Math.min(n - k, localTRTCMixUser.x), 0);
        ((b)localObject2).x = localTRTCMixUser.x;
        if (((b)localObject2).y != 0) {
          break label1572;
        }
        localTRTCMixUser.y = (i * j + i1 + (int)f2);
        label744:
        localTRTCMixUser.y = Math.max(Math.min(m - j, localTRTCMixUser.y), 0);
        ((b)localObject2).y = localTRTCMixUser.y;
        localTRTCMixUser.width = k;
        localTRTCMixUser.height = j;
      }
      break;
    }
    for (;;)
    {
      TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + localTRTCMixUser.userId + ", pureAudioMode: " + localTRTCMixUser.pureAudio);
      localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser);
      i += 1;
      break label524;
      n = 160;
      m = 160;
      i = 27;
      j = 48;
      if (!a.a.aDH().aDD().hBG)
      {
        i = 48;
        j = 27;
      }
      i2 = 200;
      i1 = 20;
      k = i;
      i = i2;
      break;
      i = 192;
      j = 336;
      if (!a.a.aDH().aDD().hBw)
      {
        i = 336;
        j = 192;
      }
      k = 54;
      m = 96;
      if (!a.a.aDH().aDD().hBG)
      {
        k = 96;
        m = 54;
      }
      i1 = 30;
      i3 = 400;
      n = j;
      i2 = i;
      i = i3;
      j = m;
      m = n;
      n = i2;
      break;
      i = 240;
      j = 320;
      if (!a.a.aDH().aDD().hBw)
      {
        i = 320;
        j = 240;
      }
      k = 54;
      m = 96;
      if (!a.a.aDH().aDD().hBG)
      {
        k = 96;
        m = 54;
      }
      i1 = 400;
      n = j;
      i2 = i;
      i = i1;
      i1 = i3;
      j = m;
      m = n;
      n = i2;
      break;
      n = 480;
      i = 72;
      j = 128;
      if (!a.a.aDH().aDD().hBG)
      {
        i = 128;
        j = 72;
      }
      i1 = 600;
      k = i;
      m = 480;
      i = i1;
      i1 = i3;
      break;
      i = 368;
      j = 640;
      if (!a.a.aDH().aDD().hBw)
      {
        i = 640;
        j = 368;
      }
      k = 90;
      m = 160;
      if (!a.a.aDH().aDD().hBG)
      {
        k = 160;
        m = 90;
      }
      i1 = 800;
      n = j;
      i2 = i;
      i = i1;
      i1 = i3;
      j = m;
      m = n;
      n = i2;
      break;
      i = 480;
      j = 640;
      if (!a.a.aDH().aDD().hBw)
      {
        i = 640;
        j = 480;
      }
      k = 90;
      m = 160;
      if (!a.a.aDH().aDD().hBG)
      {
        k = 160;
        m = 90;
      }
      i1 = 800;
      n = j;
      i2 = i;
      i = i1;
      i1 = i3;
      j = m;
      m = n;
      n = i2;
      break;
      i = 544;
      j = 960;
      if (!a.a.aDH().aDD().hBw)
      {
        i = 960;
        j = 544;
      }
      k = 171;
      m = 304;
      if (!a.a.aDH().aDD().hBG)
      {
        k = 304;
        m = 171;
      }
      i1 = 1000;
      n = j;
      i2 = i;
      i = i1;
      i1 = i3;
      j = m;
      m = n;
      n = i2;
      break;
      i = 720;
      j = 1280;
      if (!a.a.aDH().aDD().hBw)
      {
        i = 1280;
        j = 720;
      }
      k = 180;
      m = 320;
      if (!a.a.aDH().aDD().hBG)
      {
        k = 320;
        m = 180;
      }
      i1 = 1500;
      n = j;
      i2 = i;
      i = i1;
      i1 = i3;
      j = m;
      m = n;
      n = i2;
      break;
      label1556:
      localTRTCMixUser.x = (((b)localObject2).x + (int)f1);
      break label687;
      label1572:
      localTRTCMixUser.y = (((b)localObject2).y + (int)f2);
      break label744;
      label1589:
      if (i < 6)
      {
        localTRTCMixUser.x = 5;
        localTRTCMixUser.y = (m - i1 - (i - 3) * j - j);
        localTRTCMixUser.width = k;
        localTRTCMixUser.height = j;
      }
    }
    label1640:
    this.hAY.setMixTranscodingConfig(localTRTCTranscodingConfig);
    AppMethodBeat.o(196301);
  }
  
  public final void Gs(String paramString)
  {
    this.hBO = paramString;
  }
  
  public final void Gv(String paramString)
  {
    AppMethodBeat.i(196292);
    if (!this.hBM) {
      this.hAY.stopRemoteView(paramString);
    }
    for (;;)
    {
      Iterator localIterator = this.hBN.iterator();
      b localb;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localb = (b)localIterator.next();
      } while ((localb.userId == null) || (!localb.userId.equals(paramString)) || (localb.streamType != 0));
      localIterator.remove();
      TXLog.i("MicroMsg.LiveCoreVisitor", "removeVideoStream " + paramString + ", stream 0, size " + this.hBN.size());
      AppMethodBeat.o(196292);
      return;
      Gz(paramString);
    }
    AppMethodBeat.o(196292);
  }
  
  public final void Gx(String paramString)
  {
    AppMethodBeat.i(196295);
    Object localObject = b.a.aDT().hBJ.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((a)((Iterator)localObject).next()).goe)) {
        ((Iterator)localObject).remove();
      }
    }
    Gz(paramString);
    this.hAY.stopRemoteView(paramString);
    this.hAY.stopRemoteSubStreamView(paramString);
    localObject = a.a.aDH().aDF();
    if (paramString.equals(((com.tencent.mm.live.core.core.trtc.a.a.c)localObject).hBr))
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.c)localObject).hBq = "";
      ((com.tencent.mm.live.core.core.trtc.a.a.c)localObject).hBr = "";
      ((com.tencent.mm.live.core.core.trtc.a.a.c)localObject).hBs = false;
      ((com.tencent.mm.live.core.core.trtc.a.a.c)localObject).hBt = "";
    }
    AppMethodBeat.o(196295);
  }
  
  public final h Gy(String paramString)
  {
    AppMethodBeat.i(196296);
    if ((this.hBP != null) && (!Util.isNullOrNil(paramString)) && (this.hBP.containsKey(paramString)))
    {
      paramString = (h)this.hBP.get(paramString);
      AppMethodBeat.o(196296);
      return paramString;
    }
    AppMethodBeat.o(196296);
    return null;
  }
  
  public final void a(long paramLong, TXLivePlayer paramTXLivePlayer)
  {
    AppMethodBeat.i(196298);
    this.hBQ.put(Long.valueOf(paramLong), paramTXLivePlayer);
    AppMethodBeat.o(196298);
  }
  
  public final void a(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(196293);
    b localb = new b((byte)0);
    localb.userId = paramString;
    localb.streamType = 0;
    localb.hBV = false;
    Object localObject1;
    if (b.a.aDT().Gr(paramString) == null)
    {
      localObject1 = new a(paramString);
      b.a.aDT().a((a)localObject1);
    }
    if (!this.hBM) {
      if (paramTXCloudVideoView != null)
      {
        this.hAY.setDebugViewMargin(paramString, new TRTCCloud.TRTCViewMargin(0.0F, 0.0F, 0.1F, 0.0F));
        this.hAY.setRemoteViewFillMode(paramString, 1);
        this.hAY.startRemoteView(paramString, paramTXCloudVideoView);
      }
    }
    for (;;)
    {
      if (!Gt(paramString))
      {
        this.hBN.add(localb);
        TXLog.i("MicroMsg.LiveCoreVisitor", "remoteUserVideoAvailable " + localb.userId + ", stream 0, size " + this.hBN.size());
      }
      AppMethodBeat.o(196293);
      return;
      Object localObject2 = Gy(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new h(paramString);
      }
      localObject2 = new TextureView(paramTXCloudVideoView.getContext());
      ((TextureView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      paramTXCloudVideoView.addVideoView((TextureView)localObject2);
      ((TextureView)localObject2).setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
      {
        public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(196284);
          Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          this.hBT.bO(new Surface(paramAnonymousSurfaceTexture));
          this.hBT.cX(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(196284);
        }
        
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(196286);
          Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
          this.hBT.aEG();
          AppMethodBeat.o(196286);
          return false;
        }
        
        public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(196285);
          Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          this.hBT.cX(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(196285);
        }
        
        public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
      });
      this.hAY.setRemoteVideoRenderListener(paramString, 1, 2, (TRTCCloudListener.TRTCVideoRenderListener)localObject1);
      this.hBP.put(paramString, localObject1);
      this.hAY.startRemoteView(paramString, null);
      ((TextureView)localObject2).invalidate();
    }
  }
  
  public final void aDU()
  {
    AppMethodBeat.i(196300);
    int i = 720;
    int j = 1280;
    if (!a.a.aDH().aDD().hBw)
    {
      i = 1280;
      j = 720;
    }
    int k = 180;
    int m;
    if (!a.a.aDH().aDD().hBG)
    {
      m = 180;
      k = 320;
    }
    for (;;)
    {
      int i3;
      int i4;
      int i2;
      int i1;
      int n;
      TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig;
      TRTCCloudDef.TRTCMixUser localTRTCMixUser;
      switch (a.a.aDH().aDD().hBu)
      {
      default: 
        i3 = 200;
        i4 = 50;
        i2 = m;
        i1 = i;
        n = j;
        m = k;
        k = i2;
        j = i4;
        i = i3;
      case 3: 
        for (;;)
        {
          i2 = a.a.aDH().aDD().mVideoBitrate;
          if (i2 > 0) {
            i = i2;
          }
          Log.i("MicroMsg.LiveCoreVisitor", "videoWidth:%s, videoHeight:%s, bitrate:%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(i) });
          localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
          localTRTCTranscodingConfig.appId = this.hBR;
          localTRTCTranscodingConfig.bizId = this.hBS;
          localTRTCTranscodingConfig.videoWidth = i1;
          localTRTCTranscodingConfig.videoHeight = n;
          localTRTCTranscodingConfig.videoGOP = 1;
          localTRTCTranscodingConfig.videoFramerate = 15;
          localTRTCTranscodingConfig.videoBitrate = i;
          localTRTCTranscodingConfig.audioSampleRate = 48000;
          localTRTCTranscodingConfig.audioBitrate = 64;
          localTRTCTranscodingConfig.audioChannels = 2;
          Object localObject1 = new TRTCCloudDef.TRTCMixUser();
          ((TRTCCloudDef.TRTCMixUser)localObject1).userId = this.hBO;
          ((TRTCCloudDef.TRTCMixUser)localObject1).zOrder = 0;
          ((TRTCCloudDef.TRTCMixUser)localObject1).x = 0;
          ((TRTCCloudDef.TRTCMixUser)localObject1).y = 0;
          ((TRTCCloudDef.TRTCMixUser)localObject1).width = i1;
          ((TRTCCloudDef.TRTCMixUser)localObject1).height = n;
          localTRTCTranscodingConfig.mixUsers = new ArrayList();
          localTRTCTranscodingConfig.mixUsers.add(localObject1);
          if (!a.a.aDH().aDD().hBE) {
            break label1395;
          }
          TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.hBN.size());
          localObject1 = b.a.aDT().hBJ;
          if (localObject1 == null) {
            break label1395;
          }
          localObject1 = ((List)localObject1).iterator();
          i = 0;
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label1395;
            }
            Object localObject2 = (a)((Iterator)localObject1).next();
            localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
            com.tencent.mm.live.core.core.trtc.a.a.c localc = a.a.aDH().aDF();
            if ((localc.hBs) && (((a)localObject2).goe.equalsIgnoreCase(localc.hBr))) {
              localTRTCMixUser.roomId = localc.hBq;
            }
            localTRTCMixUser.userId = ((a)localObject2).goe;
            localTRTCMixUser.streamType = ((a)localObject2).mStreamType;
            localTRTCMixUser.zOrder = (i + 1);
            localTRTCMixUser.pureAudio = true;
            localObject2 = Gu(localTRTCMixUser.userId);
            if (localObject2 != null)
            {
              localTRTCMixUser.pureAudio = ((b)localObject2).hBV;
              if (i >= 3) {
                break;
              }
              localTRTCMixUser.x = (i1 - 5 - m);
              localTRTCMixUser.y = (i * k + j);
              localTRTCMixUser.width = m;
              localTRTCMixUser.height = k;
            }
            TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + localTRTCMixUser.userId + ", pureAudioMode: " + localTRTCMixUser.pureAudio);
            localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser);
            i += 1;
          }
          i = 27;
          j = 48;
          if (!a.a.aDH().aDD().hBG)
          {
            i = 48;
            j = 27;
          }
          i3 = 200;
          i2 = 20;
          k = j;
          m = i;
          n = 160;
          i1 = 160;
          i = i3;
          j = i2;
        }
      case 104: 
        label619:
        i = 192;
        j = 336;
        if (!a.a.aDH().aDD().hBw)
        {
          i = 336;
          j = 192;
        }
        m = 96;
        if (!a.a.aDH().aDD().hBG)
        {
          k = 96;
          m = 54;
        }
        break;
      }
      for (;;)
      {
        i3 = 30;
        i4 = 400;
        n = k;
        i1 = j;
        i2 = i;
        i = i4;
        j = i3;
        k = m;
        m = n;
        n = i1;
        i1 = i2;
        break;
        i = 240;
        if (!a.a.aDH().aDD().hBw)
        {
          j = 240;
          i = 320;
        }
        for (;;)
        {
          m = 96;
          if (!a.a.aDH().aDD().hBG)
          {
            k = 96;
            m = 54;
          }
          for (;;)
          {
            i4 = 400;
            i3 = 50;
            n = k;
            i1 = j;
            i2 = i;
            i = i4;
            j = i3;
            k = m;
            m = n;
            n = i1;
            i1 = i2;
            break;
            i = 72;
            j = 128;
            if (!a.a.aDH().aDD().hBG)
            {
              i = 128;
              j = 72;
            }
            i3 = 600;
            i2 = 50;
            k = j;
            m = i;
            n = 480;
            i1 = 480;
            i = i3;
            j = i2;
            break;
            i = 368;
            j = 640;
            if (!a.a.aDH().aDD().hBw)
            {
              i = 640;
              j = 368;
            }
            if (!a.a.aDH().aDD().hBG) {
              m = 90;
            }
            for (k = 160;; k = 90)
            {
              i4 = 800;
              i3 = 50;
              n = k;
              i1 = j;
              i2 = i;
              i = i4;
              j = i3;
              k = m;
              m = n;
              n = i1;
              i1 = i2;
              break;
              i = 480;
              j = 640;
              if (!a.a.aDH().aDD().hBw)
              {
                i = 640;
                j = 480;
              }
              if (!a.a.aDH().aDD().hBG) {
                m = 90;
              }
              for (k = 160;; k = 90)
              {
                i4 = 800;
                i3 = 50;
                n = k;
                i1 = j;
                i2 = i;
                i = i4;
                j = i3;
                k = m;
                m = n;
                n = i1;
                i1 = i2;
                break;
                i = 544;
                j = 960;
                if (!a.a.aDH().aDD().hBw)
                {
                  i = 960;
                  j = 544;
                }
                k = 171;
                m = 304;
                if (!a.a.aDH().aDD().hBG)
                {
                  k = 304;
                  m = 171;
                }
                i4 = 1000;
                i3 = 50;
                n = k;
                i1 = j;
                i2 = i;
                i = i4;
                j = i3;
                k = m;
                m = n;
                n = i1;
                i1 = i2;
                break;
                i = 720;
                j = 1280;
                if (!a.a.aDH().aDD().hBw)
                {
                  i = 1280;
                  j = 720;
                }
                k = 180;
                if (!a.a.aDH().aDD().hBG)
                {
                  m = 180;
                  k = 320;
                }
                for (;;)
                {
                  i4 = 1500;
                  i3 = 50;
                  n = k;
                  i1 = j;
                  i2 = i;
                  i = i4;
                  j = i3;
                  k = m;
                  m = n;
                  n = i1;
                  i1 = i2;
                  break;
                  if (i >= 6) {
                    break label619;
                  }
                  localTRTCMixUser.x = 5;
                  localTRTCMixUser.y = (n - j - (i - 3) * k - k);
                  localTRTCMixUser.width = m;
                  localTRTCMixUser.height = k;
                  break label619;
                  label1395:
                  this.hAY.setMixTranscodingConfig(localTRTCTranscodingConfig);
                  AppMethodBeat.o(196300);
                  return;
                  m = 320;
                }
                m = 160;
              }
              m = 160;
            }
            k = 54;
          }
          j = 320;
        }
        k = 54;
      }
      m = 320;
    }
  }
  
  public final void aDV()
  {
    AppMethodBeat.i(196302);
    int j = 1280;
    int i;
    if (!a.a.aDH().aDD().hBw)
    {
      i = 1280;
      j = 720;
    }
    for (;;)
    {
      a.a.aDH().aDD();
      int m;
      int k;
      switch (a.a.aDH().aDD().hBu)
      {
      default: 
        m = 200;
        k = i;
        i = m;
      case 3: 
      case 104: 
      case 56: 
      case 7: 
        for (;;)
        {
          m = a.a.aDH().aDD().mVideoBitrate;
          if (m > 0) {
            i = m;
          }
          Log.i("MicroMsg.LiveCoreVisitor", "videoWidth:%s, videoHeight:%s, bitrate:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
          TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
          localTRTCTranscodingConfig.appId = this.hBR;
          localTRTCTranscodingConfig.bizId = this.hBS;
          localTRTCTranscodingConfig.videoWidth = k;
          localTRTCTranscodingConfig.videoHeight = j;
          localTRTCTranscodingConfig.videoGOP = 1;
          localTRTCTranscodingConfig.videoFramerate = 15;
          localTRTCTranscodingConfig.videoBitrate = i;
          localTRTCTranscodingConfig.audioSampleRate = 48000;
          localTRTCTranscodingConfig.audioBitrate = 64;
          localTRTCTranscodingConfig.audioChannels = 2;
          TRTCCloudDef.TRTCMixUser localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
          localTRTCMixUser.userId = this.hBO;
          localTRTCMixUser.zOrder = 0;
          localTRTCMixUser.x = 0;
          localTRTCMixUser.y = 0;
          localTRTCMixUser.width = k;
          localTRTCMixUser.height = j;
          localTRTCTranscodingConfig.mixUsers = new ArrayList();
          localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser);
          if (a.a.aDH().aDD().hBE)
          {
            TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.hBN.size());
            Object localObject1 = b.a.aDT().hBJ;
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              Object localObject2 = (a)((List)localObject1).get(0);
              localObject1 = new TRTCCloudDef.TRTCMixUser();
              com.tencent.mm.live.core.core.trtc.a.a.c localc = a.a.aDH().aDF();
              if ((localc.hBs) && (((a)localObject2).goe.equalsIgnoreCase(localc.hBr))) {
                ((TRTCCloudDef.TRTCMixUser)localObject1).roomId = localc.hBq;
              }
              ((TRTCCloudDef.TRTCMixUser)localObject1).userId = ((a)localObject2).goe;
              ((TRTCCloudDef.TRTCMixUser)localObject1).streamType = ((a)localObject2).mStreamType;
              ((TRTCCloudDef.TRTCMixUser)localObject1).zOrder = 1;
              ((TRTCCloudDef.TRTCMixUser)localObject1).pureAudio = true;
              localObject2 = Gu(((TRTCCloudDef.TRTCMixUser)localObject1).userId);
              if (localObject2 != null)
              {
                ((TRTCCloudDef.TRTCMixUser)localObject1).pureAudio = ((b)localObject2).hBV;
                ((TRTCCloudDef.TRTCMixUser)localObject1).x = (k / 2);
                ((TRTCCloudDef.TRTCMixUser)localObject1).y = 0;
                ((TRTCCloudDef.TRTCMixUser)localObject1).width = (k / 2);
                ((TRTCCloudDef.TRTCMixUser)localObject1).height = (j / 2);
                localTRTCMixUser.x = 0;
                localTRTCMixUser.y = 0;
                localTRTCMixUser.width = (k / 2);
                localTRTCMixUser.height = (j / 2);
                localTRTCTranscodingConfig.videoWidth = k;
                localTRTCTranscodingConfig.videoHeight = (j / 2);
              }
              TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + ((TRTCCloudDef.TRTCMixUser)localObject1).userId + ", pureAudioMode: " + ((TRTCCloudDef.TRTCMixUser)localObject1).pureAudio + ", userStream: " + localObject2);
              localTRTCTranscodingConfig.mixUsers.add(localObject1);
            }
          }
          this.hAY.setMixTranscodingConfig(localTRTCTranscodingConfig);
          AppMethodBeat.o(196302);
          return;
          a.a.aDH().aDD();
          i = 200;
          j = 160;
          k = 160;
          continue;
          i = 192;
          j = 336;
          if (!a.a.aDH().aDD().hBw)
          {
            i = 336;
            j = 192;
          }
          a.a.aDH().aDD();
          m = 400;
          k = i;
          i = m;
          continue;
          i = 240;
          j = 320;
          if (!a.a.aDH().aDD().hBw)
          {
            i = 320;
            j = 240;
          }
          a.a.aDH().aDD();
          m = 400;
          k = i;
          i = m;
          continue;
          a.a.aDH().aDD();
          i = 600;
          j = 480;
          k = 480;
        }
      case 108: 
        i = 368;
        if (!a.a.aDH().aDD().hBw)
        {
          j = 368;
          i = 640;
        }
        break;
      }
      for (;;)
      {
        a.a.aDH().aDD();
        m = 800;
        k = i;
        i = m;
        break;
        if (!a.a.aDH().aDD().hBw) {
          j = 480;
        }
        for (i = 640;; i = 480)
        {
          a.a.aDH().aDD();
          m = 800;
          k = i;
          i = m;
          break;
          i = 544;
          j = 960;
          if (!a.a.aDH().aDD().hBw)
          {
            i = 960;
            j = 544;
          }
          a.a.aDH().aDD();
          m = 1000;
          k = i;
          i = m;
          break;
          j = 1280;
          if (!a.a.aDH().aDD().hBw)
          {
            i = 1280;
            j = 720;
          }
          for (;;)
          {
            a.a.aDH().aDD();
            m = 1500;
            k = i;
            i = m;
            break;
            i = 720;
          }
          j = 640;
        }
        j = 640;
      }
      i = 720;
    }
  }
  
  public final void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(196289);
    this.hAY.muteRemoteAudio(paramString, paramBoolean);
    AppMethodBeat.o(196289);
  }
  
  public final void y(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(196288);
    if (paramLong1 > 0L) {
      this.hBR = ((int)paramLong1);
    }
    if (paramLong2 > 0L) {
      this.hBS = ((int)paramLong2);
    }
    TXLog.i("MicroMsg.LiveCoreVisitor", "setQCloudAccount:appid: " + paramLong1 + ", bizid: " + paramLong2 + ", mCloudAppid: " + this.hBR + ", mCloudBizid: " + this.hBS);
    AppMethodBeat.o(196288);
  }
  
  public final TXLivePlayer zv(long paramLong)
  {
    AppMethodBeat.i(196297);
    if ((this.hBQ != null) && (this.hBQ.containsKey(Long.valueOf(paramLong))))
    {
      TXLivePlayer localTXLivePlayer = (TXLivePlayer)this.hBQ.get(Long.valueOf(paramLong));
      AppMethodBeat.o(196297);
      return localTXLivePlayer;
    }
    AppMethodBeat.o(196297);
    return null;
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public boolean hBV = true;
    public int streamType;
    public String userId;
    public int x = 0;
    public int y = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b.c
 * JD-Core Version:    0.7.0.1
 */
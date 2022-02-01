package com.tencent.mm.live.core.core.trtc.a.b;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.f;
import com.tencent.mm.live.core.core.trtc.a.a.a;
import com.tencent.mm.live.core.core.trtc.a.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ar;
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
  private TRTCCloud gLA;
  private final a gMl;
  private boolean gMm;
  private ArrayList<b> gMn;
  private String gMo;
  private HashMap<String, f> gMp;
  private HashMap<Long, TXLivePlayer> gMq;
  private int gMr;
  private int gMs;
  
  public c(TRTCCloud paramTRTCCloud, a parama)
  {
    AppMethodBeat.i(197098);
    this.gMr = 1258344707;
    this.gMs = 58415;
    this.gLA = paramTRTCCloud;
    this.gMl = parama;
    this.gMm = true;
    this.gMn = new ArrayList();
    this.gMp = new HashMap();
    this.gMq = new HashMap();
    AppMethodBeat.o(197098);
  }
  
  private boolean xZ(String paramString)
  {
    AppMethodBeat.i(197101);
    Iterator localIterator = this.gMn.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb != null) && (localb.userId != null) && (localb.userId.equals(paramString)) && (localb.streamType == 0))
      {
        AppMethodBeat.o(197101);
        return true;
      }
    }
    AppMethodBeat.o(197101);
    return false;
  }
  
  private b ya(String paramString)
  {
    AppMethodBeat.i(197102);
    Iterator localIterator = this.gMn.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb != null) && (localb.userId != null) && (localb.userId.equals(paramString)) && (localb.streamType == 0))
      {
        AppMethodBeat.o(197102);
        return localb;
      }
    }
    AppMethodBeat.o(197102);
    return null;
  }
  
  public static void yc(String paramString)
  {
    AppMethodBeat.i(197105);
    b localb = new b((byte)0);
    localb.userId = paramString;
    localb.streamType = 0;
    if (b.a.amo().xX(paramString) == null)
    {
      paramString = new a(paramString);
      b.a.amo().a(paramString);
    }
    AppMethodBeat.o(197105);
  }
  
  private void yf(String paramString)
  {
    AppMethodBeat.i(197110);
    f localf = (f)this.gMp.remove(paramString);
    if (localf != null) {
      localf.release();
    }
    this.gLA.stopRemoteSubStreamView(paramString);
    AppMethodBeat.o(197110);
  }
  
  public final void a(long paramLong, TXLivePlayer paramTXLivePlayer)
  {
    AppMethodBeat.i(197109);
    this.gMq.put(Long.valueOf(paramLong), paramTXLivePlayer);
    AppMethodBeat.o(197109);
  }
  
  public final void a(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(197104);
    b localb = new b((byte)0);
    localb.userId = paramString;
    localb.streamType = 0;
    localb.gMv = false;
    Object localObject;
    if (b.a.amo().xX(paramString) == null)
    {
      localObject = new a(paramString);
      b.a.amo().a((a)localObject);
    }
    if (!this.gMm) {
      if (paramTXCloudVideoView != null)
      {
        this.gLA.setDebugViewMargin(paramString, new TRTCCloud.TRTCViewMargin(0.0F, 0.0F, 0.1F, 0.0F));
        this.gLA.setRemoteViewFillMode(paramString, 1);
        this.gLA.startRemoteView(paramString, paramTXCloudVideoView);
      }
    }
    for (;;)
    {
      if (!xZ(paramString))
      {
        this.gMn.add(localb);
        TXLog.i("MicroMsg.LiveCoreVisitor", "remoteUserVideoAvailable " + localb.userId + ", stream 0, size " + this.gMn.size());
      }
      AppMethodBeat.o(197104);
      return;
      localObject = new f(paramString);
      TextureView localTextureView = new TextureView(paramTXCloudVideoView.getContext());
      paramTXCloudVideoView.addVideoView(localTextureView);
      localTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
      {
        public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(197095);
          ae.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          this.gMt.bG(new Surface(paramAnonymousSurfaceTexture));
          this.gMt.cS(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(197095);
        }
        
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(197097);
          ae.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
          this.gMt.amK();
          AppMethodBeat.o(197097);
          return false;
        }
        
        public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(197096);
          ae.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          this.gMt.cS(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(197096);
        }
        
        public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
      });
      this.gLA.setRemoteVideoRenderListener(paramString, 1, 2, (TRTCCloudListener.TRTCVideoRenderListener)localObject);
      this.gMp.put(paramString, localObject);
      this.gLA.startRemoteView(paramString, null);
      localTextureView.invalidate();
    }
  }
  
  public final void amp()
  {
    AppMethodBeat.i(197111);
    int i = 720;
    int j = 1280;
    if (!a.a.amd().alZ().gLW)
    {
      i = 1280;
      j = 720;
    }
    int k = 180;
    int m;
    if (!a.a.amd().alZ().gMg)
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
      switch (a.a.amd().alZ().gLU)
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
          i2 = a.a.amd().alZ().mVideoBitrate;
          if (i2 > 0) {
            i = i2;
          }
          ae.i("MicroMsg.LiveCoreVisitor", "videoWidth:%s, videoHeight:%s, bitrate:%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(i) });
          localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
          localTRTCTranscodingConfig.appId = this.gMr;
          localTRTCTranscodingConfig.bizId = this.gMs;
          localTRTCTranscodingConfig.videoWidth = i1;
          localTRTCTranscodingConfig.videoHeight = n;
          localTRTCTranscodingConfig.videoGOP = 1;
          localTRTCTranscodingConfig.videoFramerate = 15;
          localTRTCTranscodingConfig.videoBitrate = i;
          localTRTCTranscodingConfig.audioSampleRate = 48000;
          localTRTCTranscodingConfig.audioBitrate = 64;
          localTRTCTranscodingConfig.audioChannels = 2;
          Object localObject1 = new TRTCCloudDef.TRTCMixUser();
          ((TRTCCloudDef.TRTCMixUser)localObject1).userId = this.gMo;
          ((TRTCCloudDef.TRTCMixUser)localObject1).zOrder = 0;
          ((TRTCCloudDef.TRTCMixUser)localObject1).x = 0;
          ((TRTCCloudDef.TRTCMixUser)localObject1).y = 0;
          ((TRTCCloudDef.TRTCMixUser)localObject1).width = i1;
          ((TRTCCloudDef.TRTCMixUser)localObject1).height = n;
          localTRTCTranscodingConfig.mixUsers = new ArrayList();
          localTRTCTranscodingConfig.mixUsers.add(localObject1);
          if (!a.a.amd().alZ().gMe) {
            break label1392;
          }
          TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.gMn.size());
          localObject1 = b.a.amo().gMj;
          if (localObject1 == null) {
            break label1392;
          }
          localObject1 = ((List)localObject1).iterator();
          i = 0;
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label1392;
            }
            Object localObject2 = (a)((Iterator)localObject1).next();
            localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
            com.tencent.mm.live.core.core.trtc.a.a.c localc = a.a.amd().amb();
            if ((localc.gLT) && (((a)localObject2).fIQ.equalsIgnoreCase(localc.gLS))) {
              localTRTCMixUser.roomId = localc.gLR;
            }
            localTRTCMixUser.userId = ((a)localObject2).fIQ;
            localTRTCMixUser.streamType = ((a)localObject2).mStreamType;
            localTRTCMixUser.zOrder = (i + 1);
            localTRTCMixUser.pureAudio = true;
            localObject2 = ya(localTRTCMixUser.userId);
            if (localObject2 != null)
            {
              localTRTCMixUser.pureAudio = ((b)localObject2).gMv;
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
          if (!a.a.amd().alZ().gMg)
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
        label616:
        i = 192;
        j = 336;
        if (!a.a.amd().alZ().gLW)
        {
          i = 336;
          j = 192;
        }
        m = 96;
        if (!a.a.amd().alZ().gMg)
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
        if (!a.a.amd().alZ().gLW)
        {
          j = 240;
          i = 320;
        }
        for (;;)
        {
          m = 96;
          if (!a.a.amd().alZ().gMg)
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
            if (!a.a.amd().alZ().gMg)
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
            if (!a.a.amd().alZ().gLW)
            {
              i = 640;
              j = 368;
            }
            if (!a.a.amd().alZ().gMg) {
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
              if (!a.a.amd().alZ().gLW)
              {
                i = 640;
                j = 480;
              }
              if (!a.a.amd().alZ().gMg) {
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
                if (!a.a.amd().alZ().gLW)
                {
                  i = 960;
                  j = 544;
                }
                k = 171;
                m = 304;
                if (!a.a.amd().alZ().gMg)
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
                if (!a.a.amd().alZ().gLW)
                {
                  i = 1280;
                  j = 720;
                }
                k = 180;
                if (!a.a.amd().alZ().gMg)
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
                    break label616;
                  }
                  localTRTCMixUser.x = 5;
                  localTRTCMixUser.y = (n - j - (i - 3) * k - k);
                  localTRTCMixUser.width = m;
                  localTRTCMixUser.height = k;
                  break label616;
                  label1392:
                  this.gLA.setMixTranscodingConfig(localTRTCTranscodingConfig);
                  AppMethodBeat.o(197111);
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
  
  public final void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197100);
    this.gLA.muteRemoteAudio(paramString, paramBoolean);
    AppMethodBeat.o(197100);
  }
  
  public final TXLivePlayer rr(long paramLong)
  {
    AppMethodBeat.i(197108);
    if ((this.gMq != null) && (this.gMq.containsKey(Long.valueOf(paramLong))))
    {
      TXLivePlayer localTXLivePlayer = (TXLivePlayer)this.gMq.get(Long.valueOf(paramLong));
      AppMethodBeat.o(197108);
      return localTXLivePlayer;
    }
    AppMethodBeat.o(197108);
    return null;
  }
  
  public final void v(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(197099);
    if (paramLong1 > 0L) {
      this.gMr = ((int)paramLong1);
    }
    if (paramLong2 > 0L) {
      this.gMs = ((int)paramLong2);
    }
    TXLog.i("MicroMsg.LiveCoreVisitor", "setQCloudAccount:appid: " + paramLong1 + ", bizid: " + paramLong2 + ", mCloudAppid: " + this.gMr + ", mCloudBizid: " + this.gMs);
    AppMethodBeat.o(197099);
  }
  
  public final void xY(String paramString)
  {
    this.gMo = paramString;
  }
  
  public final void yb(String paramString)
  {
    AppMethodBeat.i(197103);
    if (!this.gMm) {
      this.gLA.stopRemoteView(paramString);
    }
    for (;;)
    {
      Iterator localIterator = this.gMn.iterator();
      b localb;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localb = (b)localIterator.next();
      } while ((localb.userId == null) || (!localb.userId.equals(paramString)) || (localb.streamType != 0));
      localIterator.remove();
      TXLog.i("MicroMsg.LiveCoreVisitor", "removeVideoStream " + paramString + ", stream 0, size " + this.gMn.size());
      AppMethodBeat.o(197103);
      return;
      yf(paramString);
    }
    AppMethodBeat.o(197103);
  }
  
  public final void yd(String paramString)
  {
    AppMethodBeat.i(197106);
    Object localObject = b.a.amo().gMj.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((a)((Iterator)localObject).next()).fIQ)) {
        ((Iterator)localObject).remove();
      }
    }
    yf(paramString);
    this.gLA.stopRemoteView(paramString);
    this.gLA.stopRemoteSubStreamView(paramString);
    localObject = a.a.amd().amb();
    if (paramString.equals(((com.tencent.mm.live.core.core.trtc.a.a.c)localObject).gLS))
    {
      ((com.tencent.mm.live.core.core.trtc.a.a.c)localObject).gLR = "";
      ((com.tencent.mm.live.core.core.trtc.a.a.c)localObject).gLS = "";
      ((com.tencent.mm.live.core.core.trtc.a.a.c)localObject).gLT = false;
    }
    AppMethodBeat.o(197106);
  }
  
  public final f ye(String paramString)
  {
    AppMethodBeat.i(197107);
    if ((this.gMp != null) && (!bu.isNullOrNil(paramString)) && (this.gMp.containsKey(paramString)))
    {
      paramString = (f)this.gMp.get(paramString);
      AppMethodBeat.o(197107);
      return paramString;
    }
    AppMethodBeat.o(197107);
    return null;
  }
  
  public final void z(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(197112);
    int i = 720;
    int j = 1280;
    if (!a.a.amd().alZ().gLW)
    {
      i = 1280;
      j = 720;
    }
    int k = 180;
    int m = 320;
    if (!a.a.amd().alZ().gMg)
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
    label530:
    Object localObject2;
    TRTCCloudDef.TRTCMixUser localTRTCMixUser;
    switch (a.a.amd().alZ().gLU)
    {
    default: 
      i1 = m;
      n = i;
      m = j;
      j = i1;
      i1 = i3;
      i = i2;
      i2 = a.a.amd().alZ().mVideoBitrate;
      if (i2 > 0) {
        i = i2;
      }
      f1 = paramFloat1 / ar.ck(ak.getContext()).x * n;
      f2 = paramFloat2 / ar.ck(ak.getContext()).y * m;
      ae.i("MicroMsg.LiveCoreVisitor", "xOffset:%s, realXOffset:%s, yOffset:%s, realYOffset:%s, videoWidth:%s, videoHeight:%s, bitrate:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(f1), Float.valueOf(paramFloat2), Float.valueOf(f2), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i) });
      localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
      localTRTCTranscodingConfig.appId = this.gMr;
      localTRTCTranscodingConfig.bizId = this.gMs;
      localTRTCTranscodingConfig.videoWidth = n;
      localTRTCTranscodingConfig.videoHeight = m;
      localTRTCTranscodingConfig.videoGOP = 1;
      localTRTCTranscodingConfig.videoFramerate = 15;
      localTRTCTranscodingConfig.videoBitrate = i;
      localTRTCTranscodingConfig.audioSampleRate = 48000;
      localTRTCTranscodingConfig.audioBitrate = 64;
      localTRTCTranscodingConfig.audioChannels = 2;
      Object localObject1 = new TRTCCloudDef.TRTCMixUser();
      ((TRTCCloudDef.TRTCMixUser)localObject1).userId = this.gMo;
      ((TRTCCloudDef.TRTCMixUser)localObject1).zOrder = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).x = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).y = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject1).width = n;
      ((TRTCCloudDef.TRTCMixUser)localObject1).height = m;
      localTRTCTranscodingConfig.mixUsers = new ArrayList();
      localTRTCTranscodingConfig.mixUsers.add(localObject1);
      if (!a.a.amd().alZ().gMe) {
        break label1646;
      }
      TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.gMn.size());
      localObject1 = b.a.amo().gMj;
      if (localObject1 == null) {
        break label1646;
      }
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label1646;
      }
      localObject2 = (a)((Iterator)localObject1).next();
      localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
      com.tencent.mm.live.core.core.trtc.a.a.c localc = a.a.amd().amb();
      if ((localc.gLT) && (((a)localObject2).fIQ.equalsIgnoreCase(localc.gLS))) {
        localTRTCMixUser.roomId = localc.gLR;
      }
      localTRTCMixUser.userId = ((a)localObject2).fIQ;
      localTRTCMixUser.streamType = ((a)localObject2).mStreamType;
      localTRTCMixUser.zOrder = (i + 1);
      localTRTCMixUser.pureAudio = true;
      localObject2 = ya(localTRTCMixUser.userId);
      if (localObject2 != null)
      {
        localTRTCMixUser.pureAudio = ((b)localObject2).gMv;
        if (i >= 3) {
          break label1595;
        }
        if (((b)localObject2).x != 0) {
          break label1562;
        }
        localTRTCMixUser.x = (n - 5 - k + (int)f1);
        label693:
        localTRTCMixUser.x = Math.max(Math.min(n - k, localTRTCMixUser.x), 0);
        ((b)localObject2).x = localTRTCMixUser.x;
        if (((b)localObject2).y != 0) {
          break label1578;
        }
        localTRTCMixUser.y = (i * j + i1 + (int)f2);
        label750:
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
      break label530;
      n = 160;
      m = 160;
      i = 27;
      j = 48;
      if (!a.a.amd().alZ().gMg)
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
      if (!a.a.amd().alZ().gLW)
      {
        i = 336;
        j = 192;
      }
      k = 54;
      m = 96;
      if (!a.a.amd().alZ().gMg)
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
      if (!a.a.amd().alZ().gLW)
      {
        i = 320;
        j = 240;
      }
      k = 54;
      m = 96;
      if (!a.a.amd().alZ().gMg)
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
      if (!a.a.amd().alZ().gMg)
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
      if (!a.a.amd().alZ().gLW)
      {
        i = 640;
        j = 368;
      }
      k = 90;
      m = 160;
      if (!a.a.amd().alZ().gMg)
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
      if (!a.a.amd().alZ().gLW)
      {
        i = 640;
        j = 480;
      }
      k = 90;
      m = 160;
      if (!a.a.amd().alZ().gMg)
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
      if (!a.a.amd().alZ().gLW)
      {
        i = 960;
        j = 544;
      }
      k = 171;
      m = 304;
      if (!a.a.amd().alZ().gMg)
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
      if (!a.a.amd().alZ().gLW)
      {
        i = 1280;
        j = 720;
      }
      k = 180;
      m = 320;
      if (!a.a.amd().alZ().gMg)
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
      label1562:
      localTRTCMixUser.x = (((b)localObject2).x + (int)f1);
      break label693;
      label1578:
      localTRTCMixUser.y = (((b)localObject2).y + (int)f2);
      break label750;
      label1595:
      if (i < 6)
      {
        localTRTCMixUser.x = 5;
        localTRTCMixUser.y = (m - i1 - (i - 3) * j - j);
        localTRTCMixUser.width = k;
        localTRTCMixUser.height = j;
      }
    }
    label1646:
    this.gLA.setMixTranscodingConfig(localTRTCTranscodingConfig);
    AppMethodBeat.o(197112);
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public boolean gMv = true;
    public int streamType;
    public String userId;
    public int x = 0;
    public int y = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.live.core.core.trtc.a.b;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.f;
import com.tencent.mm.live.core.b.f.d;
import com.tencent.mm.live.core.core.trtc.a.a.a;
import com.tencent.mm.live.core.core.trtc.a.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ap;
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

public final class c
{
  private TRTCCloud qEF;
  private HashMap<String, f> qKI;
  private HashMap<Long, TXLivePlayer> qKJ;
  private final a qKa;
  private boolean qKc;
  private ArrayList<b> qKu;
  private String qKw;
  private int qLj;
  private int qLk;
  
  public c(TRTCCloud paramTRTCCloud, a parama)
  {
    AppMethodBeat.i(205515);
    this.qLj = 1258344707;
    this.qLk = 58415;
    this.qEF = paramTRTCCloud;
    this.qKa = parama;
    this.qKc = true;
    this.qKu = new ArrayList();
    this.qKI = new HashMap();
    this.qKJ = new HashMap();
    AppMethodBeat.o(205515);
  }
  
  private boolean aTY(String paramString)
  {
    AppMethodBeat.i(205518);
    Iterator localIterator = this.qKu.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb != null) && (localb.userId != null) && (localb.userId.equals(paramString)) && (localb.streamType == 0))
      {
        AppMethodBeat.o(205518);
        return true;
      }
    }
    AppMethodBeat.o(205518);
    return false;
  }
  
  public static void aUa(String paramString)
  {
    AppMethodBeat.i(205521);
    b localb = new b((byte)0);
    localb.userId = paramString;
    localb.streamType = 0;
    if (b.a.crs().aTW(paramString) == null)
    {
      paramString = new a(paramString);
      b.a.crs().a(paramString);
    }
    AppMethodBeat.o(205521);
  }
  
  public final TXLivePlayer Bb(long paramLong)
  {
    AppMethodBeat.i(205523);
    if ((this.qKJ != null) && (this.qKJ.containsKey(Long.valueOf(paramLong))))
    {
      TXLivePlayer localTXLivePlayer = (TXLivePlayer)this.qKJ.get(Long.valueOf(paramLong));
      AppMethodBeat.o(205523);
      return localTXLivePlayer;
    }
    AppMethodBeat.o(205523);
    return null;
  }
  
  public final void E(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205516);
    if (paramLong1 > 0L) {
      this.qLj = ((int)paramLong1);
    }
    if (paramLong2 > 0L) {
      this.qLk = ((int)paramLong2);
    }
    TXLog.i("MicroMsg.LiveCoreVisitor", "setQCloudAccount:appid: " + paramLong1 + ", bizid: " + paramLong2 + ", mCloudAppid: " + this.qLj + ", mCloudBizid: " + this.qLk);
    AppMethodBeat.o(205516);
  }
  
  public final void a(long paramLong, TXLivePlayer paramTXLivePlayer)
  {
    AppMethodBeat.i(205524);
    this.qKJ.put(Long.valueOf(paramLong), paramTXLivePlayer);
    AppMethodBeat.o(205524);
  }
  
  public final void a(String paramString, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(205520);
    b localb = new b((byte)0);
    localb.userId = paramString;
    localb.streamType = 0;
    localb.qLy = false;
    Object localObject;
    if (b.a.crs().aTW(paramString) == null)
    {
      localObject = new a(paramString);
      b.a.crs().a((a)localObject);
    }
    if (!this.qKc) {
      if (paramTXCloudVideoView != null)
      {
        this.qEF.setDebugViewMargin(paramString, new TRTCCloud.TRTCViewMargin(0.0F, 0.0F, 0.1F, 0.0F));
        this.qEF.setRemoteViewFillMode(paramString, 1);
        this.qEF.startRemoteView(paramString, paramTXCloudVideoView);
      }
    }
    for (;;)
    {
      if (!aTY(paramString))
      {
        this.qKu.add(localb);
        TXLog.i("MicroMsg.LiveCoreVisitor", "remoteUserVideoAvailable " + localb.userId + ", stream 0, size " + this.qKu.size());
      }
      AppMethodBeat.o(205520);
      return;
      localObject = new f(paramString);
      TextureView localTextureView = new TextureView(paramTXCloudVideoView.getContext());
      paramTXCloudVideoView.addVideoView(localTextureView);
      localTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
      {
        public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(205512);
          ad.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          this.qLw.gc(new Surface(paramAnonymousSurfaceTexture));
          this.qLw.cR(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(205512);
        }
        
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(205514);
          ad.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
          this.qLw.cAi();
          AppMethodBeat.o(205514);
          return false;
        }
        
        public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(205513);
          ad.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          this.qLw.cR(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(205513);
        }
        
        public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
      });
      this.qEF.setRemoteVideoRenderListener(paramString, 1, 2, (TRTCCloudListener.TRTCVideoRenderListener)localObject);
      this.qKI.put(paramString, localObject);
      this.qEF.startRemoteView(paramString, null);
      localTextureView.invalidate();
    }
  }
  
  public final void aTX(String paramString)
  {
    this.qKw = paramString;
  }
  
  public final void aTZ(String paramString)
  {
    AppMethodBeat.i(205519);
    if (!this.qKc) {
      this.qEF.stopRemoteView(paramString);
    }
    for (;;)
    {
      Object localObject = this.qKu.iterator();
      b localb;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localb = (b)((Iterator)localObject).next();
      } while ((localb.userId == null) || (!localb.userId.equals(paramString)) || (localb.streamType != 0));
      ((Iterator)localObject).remove();
      TXLog.i("MicroMsg.LiveCoreVisitor", "removeVideoStream " + paramString + ", stream 0, size " + this.qKu.size());
      AppMethodBeat.o(205519);
      return;
      localObject = (f)this.qKI.remove(paramString);
      if (localObject != null) {
        ((f)localObject).i((d.g.a.a)new f.d((f)localObject));
      }
      this.qEF.stopRemoteSubStreamView(paramString);
    }
    AppMethodBeat.o(205519);
  }
  
  public final f aUb(String paramString)
  {
    AppMethodBeat.i(205522);
    if ((this.qKI != null) && (!bt.isNullOrNil(paramString)) && (this.qKI.containsKey(paramString)))
    {
      paramString = (f)this.qKI.get(paramString);
      AppMethodBeat.o(205522);
      return paramString;
    }
    AppMethodBeat.o(205522);
    return null;
  }
  
  public final void ao(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205526);
    int n = 720;
    int m = 1280;
    int i = 180;
    int j = 320;
    if (!a.a.cpW().cpF().qJb)
    {
      i = 320;
      j = 180;
    }
    int i1 = 50;
    int i2 = 200;
    int k;
    float f1;
    float f2;
    TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig;
    label437:
    b localb;
    TRTCCloudDef.TRTCMixUser localTRTCMixUser;
    switch (a.a.cpW().cpF().mVideoResolution)
    {
    default: 
      k = j;
      j = i2;
      f1 = paramFloat1 / ap.cf(aj.getContext()).x;
      f1 = n * f1;
      f2 = paramFloat2 / ap.cf(aj.getContext()).y;
      f2 = m * f2;
      ad.i("MicroMsg.LiveCoreVisitor", "xOffset:%s, realXOffset:%s, yOffset:%s, realYOffset:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(f1), Float.valueOf(paramFloat2), Float.valueOf(f2) });
      localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
      localTRTCTranscodingConfig.appId = this.qLj;
      localTRTCTranscodingConfig.bizId = this.qLk;
      localTRTCTranscodingConfig.videoWidth = n;
      localTRTCTranscodingConfig.videoHeight = m;
      localTRTCTranscodingConfig.videoGOP = 1;
      localTRTCTranscodingConfig.videoFramerate = 15;
      localTRTCTranscodingConfig.videoBitrate = j;
      localTRTCTranscodingConfig.audioSampleRate = 48000;
      localTRTCTranscodingConfig.audioBitrate = 64;
      localTRTCTranscodingConfig.audioChannels = 2;
      Object localObject = new TRTCCloudDef.TRTCMixUser();
      ((TRTCCloudDef.TRTCMixUser)localObject).userId = this.qKw;
      ((TRTCCloudDef.TRTCMixUser)localObject).zOrder = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject).x = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject).y = 0;
      ((TRTCCloudDef.TRTCMixUser)localObject).width = n;
      ((TRTCCloudDef.TRTCMixUser)localObject).height = m;
      localTRTCTranscodingConfig.mixUsers = new ArrayList();
      localTRTCTranscodingConfig.mixUsers.add(localObject);
      if (!a.a.cpW().cpF().qHL) {
        break label1235;
      }
      TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.qKu.size());
      localObject = this.qKu.iterator();
      j = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label1235;
      }
      localb = (b)((Iterator)localObject).next();
      localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
      com.tencent.mm.live.core.core.trtc.a.a.c localc = a.a.cpW().cpS();
      if ((localc.ugS) && (localb.userId.equalsIgnoreCase(localc.qGo))) {
        localTRTCMixUser.roomId = localc.qGn;
      }
      localTRTCMixUser.userId = localb.userId;
      localTRTCMixUser.streamType = localb.streamType;
      localTRTCMixUser.zOrder = (j + 1);
      localTRTCMixUser.pureAudio = localb.qLy;
      if (j < 3) {
        if (localb.x == 0)
        {
          localTRTCMixUser.x = (n - 5 - i + (int)f1);
          label578:
          localb.x = localTRTCMixUser.x;
          if (localb.y != 0) {
            break label1167;
          }
          localTRTCMixUser.y = (j * k + i1 + (int)f2);
          label613:
          localb.y = localTRTCMixUser.y;
          localTRTCMixUser.width = i;
          localTRTCMixUser.height = k;
        }
      }
      break;
    }
    for (;;)
    {
      TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + localTRTCMixUser.userId + ", pureAudioMode: " + localTRTCMixUser.pureAudio);
      localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser);
      j += 1;
      break label437;
      n = 160;
      m = 160;
      i = 27;
      j = 48;
      if (!a.a.cpW().cpF().qJb)
      {
        i = 48;
        j = 27;
      }
      i1 = 20;
      i2 = 200;
      k = j;
      j = i2;
      break;
      n = 192;
      m = 336;
      i = 54;
      j = 96;
      if (!a.a.cpW().cpF().qJb)
      {
        i = 96;
        j = 54;
      }
      i1 = 30;
      i2 = 400;
      k = j;
      j = i2;
      break;
      n = 240;
      m = 320;
      i = 54;
      j = 96;
      if (!a.a.cpW().cpF().qJb)
      {
        i = 96;
        j = 54;
      }
      i2 = 400;
      k = j;
      j = i2;
      break;
      n = 480;
      m = 480;
      i = 72;
      j = 128;
      if (!a.a.cpW().cpF().qJb)
      {
        i = 128;
        j = 72;
      }
      i2 = 600;
      k = j;
      j = i2;
      break;
      n = 368;
      m = 640;
      i = 90;
      j = 160;
      if (!a.a.cpW().cpF().qJb)
      {
        i = 160;
        j = 90;
      }
      i2 = 800;
      k = j;
      j = i2;
      break;
      n = 480;
      m = 640;
      i = 90;
      j = 160;
      if (!a.a.cpW().cpF().qJb)
      {
        i = 160;
        j = 90;
      }
      i2 = 800;
      k = j;
      j = i2;
      break;
      n = 544;
      m = 960;
      i = 171;
      j = 304;
      if (!a.a.cpW().cpF().qJb)
      {
        i = 304;
        j = 171;
      }
      i2 = 1000;
      k = j;
      j = i2;
      break;
      n = 720;
      m = 1280;
      i = 180;
      j = 320;
      if (!a.a.cpW().cpF().qJb)
      {
        i = 320;
        j = 180;
      }
      i2 = 1500;
      k = j;
      j = i2;
      break;
      localTRTCMixUser.x = (localb.x + (int)f1);
      break label578;
      label1167:
      localTRTCMixUser.y = (localb.y + (int)f2);
      break label613;
      if (j < 6)
      {
        localTRTCMixUser.x = 5;
        localTRTCMixUser.y = (m - i1 - (j - 3) * k - k);
        localTRTCMixUser.width = i;
        localTRTCMixUser.height = k;
      }
    }
    label1235:
    this.qEF.setMixTranscodingConfig(localTRTCTranscodingConfig);
    AppMethodBeat.o(205526);
  }
  
  public final void crD()
  {
    AppMethodBeat.i(205525);
    int i1 = 720;
    int n = 1280;
    int i = 180;
    int j;
    if (!a.a.cpW().cpF().qJb)
    {
      j = 180;
      i = 320;
    }
    for (;;)
    {
      int i2;
      int i3;
      int m;
      int k;
      TRTCCloudDef.TRTCTranscodingConfig localTRTCTranscodingConfig;
      TRTCCloudDef.TRTCMixUser localTRTCMixUser;
      switch (a.a.cpW().cpF().mVideoResolution)
      {
      default: 
        i2 = 200;
        i3 = 50;
        m = i;
        k = j;
        j = i3;
        i = i2;
      case 3: 
        for (;;)
        {
          localTRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
          localTRTCTranscodingConfig.appId = this.qLj;
          localTRTCTranscodingConfig.bizId = this.qLk;
          localTRTCTranscodingConfig.videoWidth = i1;
          localTRTCTranscodingConfig.videoHeight = n;
          localTRTCTranscodingConfig.videoGOP = 1;
          localTRTCTranscodingConfig.videoFramerate = 15;
          localTRTCTranscodingConfig.videoBitrate = i;
          localTRTCTranscodingConfig.audioSampleRate = 48000;
          localTRTCTranscodingConfig.audioBitrate = 64;
          localTRTCTranscodingConfig.audioChannels = 2;
          Object localObject = new TRTCCloudDef.TRTCMixUser();
          ((TRTCCloudDef.TRTCMixUser)localObject).userId = this.qKw;
          ((TRTCCloudDef.TRTCMixUser)localObject).zOrder = 0;
          ((TRTCCloudDef.TRTCMixUser)localObject).x = 0;
          ((TRTCCloudDef.TRTCMixUser)localObject).y = 0;
          ((TRTCCloudDef.TRTCMixUser)localObject).width = i1;
          ((TRTCCloudDef.TRTCMixUser)localObject).height = n;
          localTRTCTranscodingConfig.mixUsers = new ArrayList();
          localTRTCTranscodingConfig.mixUsers.add(localObject);
          if (!a.a.cpW().cpF().qHL) {
            break label1049;
          }
          TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams videostreams: " + this.qKu.size());
          localObject = this.qKu.iterator();
          i = 0;
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label1049;
            }
            b localb = (b)((Iterator)localObject).next();
            localTRTCMixUser = new TRTCCloudDef.TRTCMixUser();
            com.tencent.mm.live.core.core.trtc.a.a.c localc = a.a.cpW().cpS();
            if ((localc.ugS) && (localb.userId.equalsIgnoreCase(localc.qGo))) {
              localTRTCMixUser.roomId = localc.qGn;
            }
            localTRTCMixUser.userId = localb.userId;
            localTRTCMixUser.streamType = localb.streamType;
            localTRTCMixUser.zOrder = (i + 1);
            localTRTCMixUser.pureAudio = localb.qLy;
            if (i >= 3) {
              break;
            }
            localTRTCMixUser.x = (i1 - 5 - m);
            localTRTCMixUser.y = (i * k + j);
            localTRTCMixUser.width = m;
            localTRTCMixUser.height = k;
            TXLog.i("MicroMsg.LiveCoreVisitor", "updateCloudMixtureParams userId " + localTRTCMixUser.userId + ", pureAudioMode: " + localTRTCMixUser.pureAudio);
            localTRTCTranscodingConfig.mixUsers.add(localTRTCMixUser);
            i += 1;
          }
          i = 27;
          j = 48;
          if (!a.a.cpW().cpF().qJb)
          {
            i = 48;
            j = 27;
          }
          i2 = 20;
          i3 = 200;
          k = j;
          m = i;
          n = 160;
          i1 = 160;
          i = i3;
          j = i2;
        }
      case 104: 
        label500:
        j = 96;
        if (!a.a.cpW().cpF().qJb)
        {
          i = 96;
          j = 54;
        }
        break;
      }
      for (;;)
      {
        i2 = 30;
        i3 = 400;
        k = j;
        m = i;
        n = 336;
        i1 = 192;
        i = i3;
        j = i2;
        break;
        j = 96;
        if (!a.a.cpW().cpF().qJb)
        {
          i = 96;
          j = 54;
        }
        for (;;)
        {
          i3 = 400;
          i2 = 50;
          k = j;
          m = i;
          n = 320;
          i1 = 240;
          i = i3;
          j = i2;
          break;
          i = 72;
          j = 128;
          if (!a.a.cpW().cpF().qJb)
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
          i1 = 368;
          if (!a.a.cpW().cpF().qJb) {
            j = 90;
          }
          for (i = 160;; i = 90)
          {
            i3 = 800;
            i2 = 50;
            k = j;
            m = i;
            n = 640;
            i = i3;
            j = i2;
            break;
            i1 = 480;
            if (!a.a.cpW().cpF().qJb) {
              j = 90;
            }
            for (i = 160;; i = 90)
            {
              i3 = 800;
              i2 = 50;
              k = j;
              m = i;
              n = 640;
              i = i3;
              j = i2;
              break;
              i = 171;
              j = 304;
              if (!a.a.cpW().cpF().qJb)
              {
                i = 304;
                j = 171;
              }
              i3 = 1000;
              i2 = 50;
              k = j;
              m = i;
              n = 960;
              i1 = 544;
              i = i3;
              j = i2;
              break;
              i = 180;
              if (!a.a.cpW().cpF().qJb)
              {
                j = 180;
                i = 320;
              }
              for (;;)
              {
                i3 = 1500;
                i2 = 50;
                k = j;
                m = i;
                n = 1280;
                i1 = 720;
                i = i3;
                j = i2;
                break;
                if (i >= 6) {
                  break label500;
                }
                localTRTCMixUser.x = 5;
                localTRTCMixUser.y = (n - j - (i - 3) * k - k);
                localTRTCMixUser.width = m;
                localTRTCMixUser.height = k;
                break label500;
                label1049:
                this.qEF.setMixTranscodingConfig(localTRTCTranscodingConfig);
                AppMethodBeat.o(205525);
                return;
                j = 320;
              }
              j = 160;
            }
            j = 160;
          }
          i = 54;
        }
        i = 54;
      }
      j = 320;
    }
  }
  
  public final void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205517);
    this.qEF.muteRemoteAudio(paramString, paramBoolean);
    AppMethodBeat.o(205517);
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public boolean qLy = true;
    public int streamType;
    public String userId;
    public int x = 0;
    public int y = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b.c
 * JD-Core Version:    0.7.0.1
 */
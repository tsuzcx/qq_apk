package com.tencent.mm.plugin.flutter.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Surface;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.m.c;
import io.flutter.plugin.a.m.f;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.c.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class f
  implements k.c
{
  private final m.c aRg;
  a smJ;
  final Map<Long, b> smK;
  b smL;
  private HashMap<String, Integer> smM;
  int smN;
  
  public f(m.c paramc)
  {
    AppMethodBeat.i(148925);
    this.smM = new HashMap();
    this.aRg = paramc;
    this.smK = new HashMap();
    this.smN = NetUtil.getNetType(ai.getContext());
    this.smJ = new a();
    ai.getContext().registerReceiver(this.smJ, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(148925);
  }
  
  private static boolean a(b paramb)
  {
    AppMethodBeat.i(209700);
    e.smI.cIf();
    if (!e.cId())
    {
      b.a(paramb, 1, 2, "视频加载失败，请检查网络连接后重试", "重试");
      AppMethodBeat.o(209700);
      return false;
    }
    if (!e.smI.cIf().smE)
    {
      e.smI.cIf();
      if (!e.ccN())
      {
        b.a(paramb, 2, 1, "当前为非Wi-Fi环境，是否使用流量观看视频？", "仍然播放");
        AppMethodBeat.o(209700);
        return false;
      }
    }
    AppMethodBeat.o(209700);
    return true;
  }
  
  public final void a(j paramj, k.d paramd)
  {
    int j = -1;
    AppMethodBeat.i(148926);
    Object localObject1 = this.aRg.It();
    if (localObject1 == null)
    {
      ac.e("MicroMsg.FlutterVideoPlayerPlugin", "texture null");
      paramd.e("no_activity", "video_player plugin requires a foreground activity", null);
      AppMethodBeat.o(148926);
      return;
    }
    if (paramj.tn("force") != null) {}
    for (boolean bool = ((Boolean)paramj.tn("force")).booleanValue();; bool = false)
    {
      Object localObject2 = paramj.method;
      switch (((String)localObject2).hashCode())
      {
      default: 
        label116:
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          l = ((Number)paramj.tn("textureId")).longValue();
          localObject1 = (b)this.smK.get(Long.valueOf(l));
          if (localObject1 != null) {
            break label684;
          }
          paramd.e("Unknown textureId", "No video player associated with texture id ".concat(String.valueOf(l)), null);
          AppMethodBeat.o(148926);
          return;
          if (!((String)localObject2).equals("init")) {
            break label116;
          }
          i = 0;
          continue;
          if (!((String)localObject2).equals("create")) {
            break label116;
          }
          i = 1;
          continue;
          if (!((String)localObject2).equals("preload")) {
            break label116;
          }
          i = 2;
        }
      }
      paramj = this.smK.values().iterator();
      while (paramj.hasNext()) {
        ((b)paramj.next()).dispose();
      }
      this.smK.clear();
      e.smI.cIf().smE = false;
      e.smI.cIf().smG.clearAll();
      AppMethodBeat.o(148926);
      return;
      localObject1 = ((io.flutter.view.c)localObject1).fNv();
      localObject2 = new io.flutter.plugin.a.d(this.aRg.Is(), "com.tencent.mm.flutter/videoPlayer/videoEvents" + ((c.a)localObject1).fNy());
      if (paramj.tn("asset") != null) {
        if (paramj.tn("package") != null)
        {
          paramj = this.aRg.K((String)paramj.tn("asset"), (String)paramj.tn("package"));
          paramj = new b(this.aRg.Ir(), (io.flutter.plugin.a.d)localObject2, (c.a)localObject1, "asset:///".concat(String.valueOf(paramj)), paramd);
          this.smK.put(Long.valueOf(((c.a)localObject1).fNy()), paramj);
        }
      }
      for (;;)
      {
        if ((bool) || (a(paramj)))
        {
          paramj.prepare();
          paramd = com.tencent.mm.b.g.getMessageDigest(paramj.getVideoPath().getBytes());
          paramj = paramj.getVideoPath();
          e.smI.cIf().smF.gt(paramj, paramd);
        }
        ac.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.smK.size()) });
        AppMethodBeat.o(148926);
        return;
        paramj = this.aRg.dr((String)paramj.tn("asset"));
        break;
        paramj = new b(this.aRg.Ir(), (io.flutter.plugin.a.d)localObject2, (c.a)localObject1, (String)paramj.tn("uri"), paramd);
        this.smK.put(Long.valueOf(((c.a)localObject1).fNy()), paramj);
      }
      paramj = (String)paramj.tn("url");
      if (!bs.isNullOrNil(paramj))
      {
        e.smI.cIf().smF.a(paramj, null);
        AppMethodBeat.o(148926);
        return;
        label684:
        localObject2 = paramj.method;
        switch (((String)localObject2).hashCode())
        {
        default: 
          i = j;
        }
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramd.daE();
          AppMethodBeat.o(148926);
          return;
          i = j;
          if (((String)localObject2).equals("setLooping"))
          {
            i = 0;
            continue;
            i = j;
            if (((String)localObject2).equals("setVolume"))
            {
              i = 1;
              continue;
              i = j;
              if (((String)localObject2).equals("play"))
              {
                i = 2;
                continue;
                i = j;
                if (((String)localObject2).equals("pause"))
                {
                  i = 3;
                  continue;
                  i = j;
                  if (((String)localObject2).equals("seekTo"))
                  {
                    i = 4;
                    continue;
                    i = j;
                    if (((String)localObject2).equals("position"))
                    {
                      i = 5;
                      continue;
                      i = j;
                      if (((String)localObject2).equals("resetPosition"))
                      {
                        i = 6;
                        continue;
                        i = j;
                        if (((String)localObject2).equals("dispose")) {
                          i = 7;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      bool = ((Boolean)paramj.tn("looping")).booleanValue();
      ((b)localObject1).smQ.setLooping(bool);
      paramd.db(null);
      AppMethodBeat.o(148926);
      return;
      float f = (float)Math.max(0.0D, Math.min(1.0D, ((Double)paramj.tn("volume")).doubleValue()));
      ((b)localObject1).smQ.u(f);
      paramd.db(null);
      AppMethodBeat.o(148926);
      return;
      ac.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.smL != localObject1)
      {
        if (this.smL != null)
        {
          this.smL.pause();
          paramj = com.tencent.mm.b.g.getMessageDigest(this.smL.getVideoPath().getBytes());
          e.smI.cIf().smF.aeW(paramj);
        }
        this.smL = ((b)localObject1);
      }
      if (bool) {
        e.smI.cIf().smE = true;
      }
      if (a(this.smL))
      {
        if (!this.smL.Xy) {
          this.smL.prepare();
        }
        if (this.smM.containsKey(this.smL.getVideoPath())) {
          this.smL.seekTo(((Integer)this.smM.get(this.smL.getVideoPath())).intValue());
        }
        paramj = this.smL;
        ac.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer play %s", new Object[] { Integer.valueOf(paramj.hashCode()) });
        paramj.smQ.start();
        paramj = com.tencent.mm.b.g.getMessageDigest(this.smL.getVideoPath().getBytes());
        localObject1 = this.smL.getVideoPath();
        e.smI.cIf().smF.gt((String)localObject1, paramj);
      }
      paramd.db(null);
      AppMethodBeat.o(148926);
      return;
      ac.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.smL == localObject1) {
        ((b)localObject1).pause();
      }
      for (;;)
      {
        paramd.db(null);
        AppMethodBeat.o(148926);
        return;
        ac.d("MicroMsg.FlutterVideoPlayerPlugin", "pause ignore %s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
      }
      if (this.smL != localObject1)
      {
        if (this.smL != null)
        {
          this.smL.pause();
          localObject2 = com.tencent.mm.b.g.getMessageDigest(this.smL.getVideoPath().getBytes());
          e.smI.cIf().smF.aeW((String)localObject2);
        }
        this.smL = ((b)localObject1);
      }
      int i = ((Number)paramj.tn("location")).intValue();
      this.smM.put(this.smL.getVideoPath(), Integer.valueOf(i));
      this.smL.seekTo(i);
      paramj = com.tencent.mm.b.g.getMessageDigest(this.smL.getVideoPath().getBytes());
      localObject1 = this.smL.getVideoPath();
      e.smI.cIf().smF.gt((String)localObject1, paramj);
      paramd.db(null);
      AppMethodBeat.o(148926);
      return;
      long l = ((b)localObject1).smQ.getCurrentPosition();
      this.smM.put(((b)localObject1).getVideoPath(), Integer.valueOf((int)l));
      paramd.db(Long.valueOf(l));
      AppMethodBeat.o(148926);
      return;
      ((b)localObject1).seekTo(0);
      ((b)localObject1).pause();
      this.smM.put(((b)localObject1).getVideoPath(), Integer.valueOf(0));
      paramd.db(null);
      AppMethodBeat.o(148926);
      return;
      if ((this.smL != null) && (localObject1 != null) && (this.smL.getVideoPath().equalsIgnoreCase(((b)localObject1).getVideoPath()))) {
        this.smM.remove(((b)localObject1).getVideoPath());
      }
      ac.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.smL == localObject1) {
        this.smL = null;
      }
      ((b)localObject1).dispose();
      this.smK.remove(Long.valueOf(l));
      ac.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.smK.size()) });
      paramd.db(null);
      AppMethodBeat.o(148926);
      return;
    }
  }
  
  final class a
    extends BroadcastReceiver
  {
    a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(209688);
      int i = f.this.smN;
      f.this.smN = NetUtil.getNetType(ai.getContext());
      if ((i != f.this.smN) && (f.this.smN != 5) && (NetUtil.isNetAvailable(ai.getContext())))
      {
        ac.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net. reset enable play in mobile net false.");
        e.smI.cIf().smE = false;
        if (f.this.smL != null)
        {
          ac.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net.");
          f.this.smL.pause();
        }
      }
      AppMethodBeat.o(209688);
    }
  }
  
  static final class b
  {
    boolean Xy;
    private Context context;
    ao handler;
    boolean isInitialized;
    g smQ;
    private final c.a smR;
    i smS;
    private final io.flutter.plugin.a.d smT;
    private Surface surface;
    
    b(Context paramContext, io.flutter.plugin.a.d paramd, c.a parama, String paramString, k.d paramd1)
    {
      AppMethodBeat.i(148923);
      this.smS = new i();
      this.isInitialized = false;
      this.Xy = false;
      this.handler = new f.b.1(this);
      ac.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer create %s", new Object[] { Integer.valueOf(hashCode()) });
      this.context = paramContext;
      this.smT = paramd;
      this.smR = parama;
      this.smQ = new d(paramContext, q.B(new com.tencent.mm.vfs.e(paramContext.getCacheDir() + "/flutter/MMVideo-" + paramString.hashCode() + ".mp4").fxV()));
      this.smQ.setPath(paramString);
      paramd.a(new f.b.2(this));
      this.surface = new Surface(parama.surfaceTexture());
      this.smQ.setSurface(this.surface);
      this.smQ.a(new a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(209693);
          super.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString1, paramAnonymousString2);
          if (f.b.this.smS != null)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("errorCode", Integer.valueOf(paramAnonymousInt1));
            localHashMap.put("errorType", Integer.valueOf(paramAnonymousInt2));
            localHashMap.put("errorMsg", paramAnonymousString1);
            localHashMap.put("errorActionDesc", paramAnonymousString2);
            f.b.this.smS.e(String.valueOf(paramAnonymousInt1), paramAnonymousString1, localHashMap);
          }
          AppMethodBeat.o(209693);
        }
        
        public final void e(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          AppMethodBeat.i(209692);
          super.e(paramAnonymousBoolean, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(209692);
            return;
            f.b.this.handler.sendEmptyMessageDelayed(1001, 500L);
            AppMethodBeat.o(209692);
            return;
            f.b.this.handler.removeMessages(1001);
            if (!f.b.this.isInitialized)
            {
              f.b.this.isInitialized = true;
              f.b localb = f.b.this;
              HashMap localHashMap;
              if (localb.isInitialized)
              {
                localHashMap = new HashMap();
                localHashMap.put("event", "initialized");
                localHashMap.put("duration", Long.valueOf(localb.smQ.getDurationMs()));
                localHashMap.put("width", Integer.valueOf(localb.smQ.getWidth()));
                localHashMap.put("height", Integer.valueOf(localb.smQ.getHeight()));
                localb.smS.db(localHashMap);
              }
              if (paramAnonymousBoolean)
              {
                f.b.this.smQ.start();
                AppMethodBeat.o(209692);
                return;
                localb = f.b.this;
                if (localb.smS != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingUpdate");
                  localHashMap.put("values", Collections.singletonList(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(localb.smQ.getBufferedPercentage()) })));
                  localb.smS.db(localHashMap);
                }
                AppMethodBeat.o(209692);
                return;
                localb = f.b.this;
                ac.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering start]");
                if (localb.smS != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingStart");
                  localb.smS.db(localHashMap);
                }
                AppMethodBeat.o(209692);
                return;
                localb = f.b.this;
                ac.i("FlutterThumb", "[buffering end]");
                if (localb.smS != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingEnd");
                  localb.smS.db(localHashMap);
                }
                AppMethodBeat.o(209692);
                return;
                localb = f.b.this;
                if (localb.isInitialized)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "completed");
                  localb.smS.db(localHashMap);
                }
              }
            }
          }
        }
      });
      paramContext = new HashMap();
      paramContext.put("textureId", Long.valueOf(parama.fNy()));
      paramd1.db(paramContext);
      AppMethodBeat.o(148923);
    }
    
    private void e(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(209697);
      if (this.smS != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("errorCode", Integer.valueOf(paramInt1));
        localHashMap.put("errorType", Integer.valueOf(paramInt2));
        localHashMap.put("errorMsg", paramString1);
        localHashMap.put("errorActionDesc", paramString2);
        this.smS.e(String.valueOf(paramInt1), paramString1, localHashMap);
      }
      AppMethodBeat.o(209697);
    }
    
    final void dispose()
    {
      AppMethodBeat.i(148924);
      ac.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer createOfDispose %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.isInitialized) {
        this.smQ.stop();
      }
      this.smR.release();
      this.smT.a(null);
      if ((this.surface != null) && (this.surface.isValid())) {
        this.surface.release();
      }
      if (this.smQ != null) {
        this.smQ.release();
      }
      AppMethodBeat.o(148924);
    }
    
    final String getVideoPath()
    {
      AppMethodBeat.i(209698);
      String str = this.smQ.getVideoPath();
      AppMethodBeat.o(209698);
      return str;
    }
    
    final void pause()
    {
      AppMethodBeat.i(209695);
      ac.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer pause %s", new Object[] { Integer.valueOf(hashCode()) });
      this.smQ.pause();
      AppMethodBeat.o(209695);
    }
    
    final void prepare()
    {
      AppMethodBeat.i(209694);
      this.smQ.cIc();
      this.Xy = true;
      AppMethodBeat.o(209694);
    }
    
    final void seekTo(int paramInt)
    {
      AppMethodBeat.i(209696);
      ac.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer seekTo %s", new Object[] { Integer.valueOf(hashCode()) });
      this.smQ.seek(paramInt);
      AppMethodBeat.o(209696);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.flutter.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.view.Surface;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import io.flutter.plugin.a.d.a;
import io.flutter.plugin.a.d.c;
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
  private final m.c bbB;
  a tuf;
  final Map<Long, b> tug;
  b tuh;
  private HashMap<String, Integer> tui;
  int tuj;
  
  public f(m.c paramc)
  {
    AppMethodBeat.i(148925);
    this.tui = new HashMap();
    this.bbB = paramc;
    this.tug = new HashMap();
    this.tuj = NetUtil.getNetType(ak.getContext());
    this.tuf = new a();
    ak.getContext().registerReceiver(this.tuf, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(148925);
  }
  
  private static boolean a(b paramb)
  {
    AppMethodBeat.i(213534);
    e.tue.cSZ();
    if (!e.cSX())
    {
      b.a(paramb, 1, 2, "视频加载失败，请检查网络连接后重试", "重试");
      AppMethodBeat.o(213534);
      return false;
    }
    if (!e.tue.cSZ().tua)
    {
      e.tue.cSZ();
      if (!e.ciH())
      {
        b.a(paramb, 2, 1, "当前为非Wi-Fi环境，是否使用流量观看视频？", "仍然播放");
        AppMethodBeat.o(213534);
        return false;
      }
    }
    AppMethodBeat.o(213534);
    return true;
  }
  
  public final void a(j paramj, k.d paramd)
  {
    int j = -1;
    AppMethodBeat.i(148926);
    Object localObject1 = this.bbB.Kb();
    if (localObject1 == null)
    {
      ae.e("MicroMsg.FlutterVideoPlayerPlugin", "texture null");
      paramd.f("no_activity", "video_player plugin requires a foreground activity", null);
      AppMethodBeat.o(148926);
      return;
    }
    if (paramj.wM("force") != null) {}
    for (boolean bool = ((Boolean)paramj.wM("force")).booleanValue();; bool = false)
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
          l = ((Number)paramj.wM("textureId")).longValue();
          localObject1 = (b)this.tug.get(Long.valueOf(l));
          if (localObject1 != null) {
            break label684;
          }
          paramd.f("Unknown textureId", "No video player associated with texture id ".concat(String.valueOf(l)), null);
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
      paramj = this.tug.values().iterator();
      while (paramj.hasNext()) {
        ((b)paramj.next()).dispose();
      }
      this.tug.clear();
      e.tue.cSZ().tua = false;
      e.tue.cSZ().tuc.clearAll();
      AppMethodBeat.o(148926);
      return;
      localObject1 = ((io.flutter.view.c)localObject1).gjw();
      localObject2 = new io.flutter.plugin.a.d(this.bbB.Ka(), "com.tencent.mm.flutter/videoPlayer/videoEvents" + ((c.a)localObject1).gjz());
      if (paramj.wM("asset") != null) {
        if (paramj.wM("package") != null)
        {
          paramj = this.bbB.L((String)paramj.wM("asset"), (String)paramj.wM("package"));
          paramj = new b(this.bbB.JZ(), (io.flutter.plugin.a.d)localObject2, (c.a)localObject1, "asset:///".concat(String.valueOf(paramj)), paramd);
          this.tug.put(Long.valueOf(((c.a)localObject1).gjz()), paramj);
        }
      }
      for (;;)
      {
        if ((bool) || (a(paramj)))
        {
          paramj.prepare();
          paramd = com.tencent.mm.b.g.getMessageDigest(paramj.getVideoPath().getBytes());
          paramj = paramj.getVideoPath();
          e.tue.cSZ().tub.gJ(paramj, paramd);
        }
        ae.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.tug.size()) });
        AppMethodBeat.o(148926);
        return;
        paramj = this.bbB.es((String)paramj.wM("asset"));
        break;
        paramj = new b(this.bbB.JZ(), (io.flutter.plugin.a.d)localObject2, (c.a)localObject1, (String)paramj.wM("uri"), paramd);
        this.tug.put(Long.valueOf(((c.a)localObject1).gjz()), paramj);
      }
      paramj = (String)paramj.wM("url");
      if (!bu.isNullOrNil(paramj))
      {
        e.tue.cSZ().tub.a(paramj, null);
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
          paramd.dmQ();
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
      bool = ((Boolean)paramj.wM("looping")).booleanValue();
      ((b)localObject1).tum.setLooping(bool);
      paramd.df(null);
      AppMethodBeat.o(148926);
      return;
      float f = (float)Math.max(0.0D, Math.min(1.0D, ((Double)paramj.wM("volume")).doubleValue()));
      ((b)localObject1).tum.u(f);
      paramd.df(null);
      AppMethodBeat.o(148926);
      return;
      ae.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.tuh != localObject1)
      {
        if (this.tuh != null)
        {
          this.tuh.pause();
          paramj = com.tencent.mm.b.g.getMessageDigest(this.tuh.getVideoPath().getBytes());
          e.tue.cSZ().tub.aks(paramj);
        }
        this.tuh = ((b)localObject1);
      }
      if (bool) {
        e.tue.cSZ().tua = true;
      }
      if (a(this.tuh))
      {
        if (!this.tuh.Zn) {
          this.tuh.prepare();
        }
        if (this.tui.containsKey(this.tuh.getVideoPath())) {
          this.tuh.seekTo(((Integer)this.tui.get(this.tuh.getVideoPath())).intValue());
        }
        paramj = this.tuh;
        ae.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer play %s", new Object[] { Integer.valueOf(paramj.hashCode()) });
        paramj.tum.start();
        paramj = com.tencent.mm.b.g.getMessageDigest(this.tuh.getVideoPath().getBytes());
        localObject1 = this.tuh.getVideoPath();
        e.tue.cSZ().tub.gJ((String)localObject1, paramj);
      }
      paramd.df(null);
      AppMethodBeat.o(148926);
      return;
      ae.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.tuh == localObject1) {
        ((b)localObject1).pause();
      }
      for (;;)
      {
        paramd.df(null);
        AppMethodBeat.o(148926);
        return;
        ae.d("MicroMsg.FlutterVideoPlayerPlugin", "pause ignore %s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
      }
      if (this.tuh != localObject1)
      {
        if (this.tuh != null)
        {
          this.tuh.pause();
          localObject2 = com.tencent.mm.b.g.getMessageDigest(this.tuh.getVideoPath().getBytes());
          e.tue.cSZ().tub.aks((String)localObject2);
        }
        this.tuh = ((b)localObject1);
      }
      int i = ((Number)paramj.wM("location")).intValue();
      this.tui.put(this.tuh.getVideoPath(), Integer.valueOf(i));
      this.tuh.seekTo(i);
      paramj = com.tencent.mm.b.g.getMessageDigest(this.tuh.getVideoPath().getBytes());
      localObject1 = this.tuh.getVideoPath();
      e.tue.cSZ().tub.gJ((String)localObject1, paramj);
      paramd.df(null);
      AppMethodBeat.o(148926);
      return;
      long l = ((b)localObject1).tum.getCurrentPosition();
      this.tui.put(((b)localObject1).getVideoPath(), Integer.valueOf((int)l));
      paramd.df(Long.valueOf(l));
      AppMethodBeat.o(148926);
      return;
      ((b)localObject1).seekTo(0);
      ((b)localObject1).pause();
      this.tui.put(((b)localObject1).getVideoPath(), Integer.valueOf(0));
      paramd.df(null);
      AppMethodBeat.o(148926);
      return;
      if ((this.tuh != null) && (localObject1 != null) && (this.tuh.getVideoPath().equalsIgnoreCase(((b)localObject1).getVideoPath()))) {
        this.tui.remove(((b)localObject1).getVideoPath());
      }
      ae.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.tuh == localObject1) {
        this.tuh = null;
      }
      ((b)localObject1).dispose();
      this.tug.remove(Long.valueOf(l));
      ae.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.tug.size()) });
      paramd.df(null);
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
      AppMethodBeat.i(213522);
      int i = f.this.tuj;
      f.this.tuj = NetUtil.getNetType(ak.getContext());
      if ((i != f.this.tuj) && (f.this.tuj != 5) && (NetUtil.isNetAvailable(ak.getContext())))
      {
        ae.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net. reset enable play in mobile net false.");
        e.tue.cSZ().tua = false;
        if (f.this.tuh != null)
        {
          ae.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net.");
          f.this.tuh.pause();
        }
      }
      AppMethodBeat.o(213522);
    }
  }
  
  static final class b
  {
    boolean Zn;
    private Context context;
    aq handler;
    boolean isInitialized;
    private Surface surface;
    g tum;
    private final c.a tun;
    i tuo;
    private final io.flutter.plugin.a.d tup;
    
    b(Context paramContext, io.flutter.plugin.a.d paramd, c.a parama, String paramString, k.d paramd1)
    {
      AppMethodBeat.i(148923);
      this.tuo = new i();
      this.isInitialized = false;
      this.Zn = false;
      this.handler = new aq()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(213523);
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(213523);
            return;
            paramAnonymousMessage = f.b.this;
            ae.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering prepare]");
            if (paramAnonymousMessage.tuo != null)
            {
              HashMap localHashMap = new HashMap();
              localHashMap.put("event", "preparing");
              paramAnonymousMessage.tuo.df(localHashMap);
            }
          }
        }
      };
      ae.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer create %s", new Object[] { Integer.valueOf(hashCode()) });
      this.context = paramContext;
      this.tup = paramd;
      this.tun = parama;
      this.tum = new d(paramContext, w.B(new k(paramContext.getCacheDir() + "/flutter/MMVideo-" + paramString.hashCode() + ".mp4").fTh()));
      this.tum.setPath(paramString);
      paramd.a(new d.c()
      {
        public final void a(d.a paramAnonymousa)
        {
          AppMethodBeat.i(213524);
          f.b.this.tuo.b(paramAnonymousa);
          AppMethodBeat.o(213524);
        }
        
        public final void sQ()
        {
          AppMethodBeat.i(213525);
          f.b.this.tuo.b(null);
          AppMethodBeat.o(213525);
        }
      });
      this.surface = new Surface(parama.surfaceTexture());
      this.tum.setSurface(this.surface);
      this.tum.a(new a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(213527);
          super.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString1, paramAnonymousString2);
          if (f.b.this.tuo != null)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("errorCode", Integer.valueOf(paramAnonymousInt1));
            localHashMap.put("errorType", Integer.valueOf(paramAnonymousInt2));
            localHashMap.put("errorMsg", paramAnonymousString1);
            localHashMap.put("errorActionDesc", paramAnonymousString2);
            f.b.this.tuo.f(String.valueOf(paramAnonymousInt1), paramAnonymousString1, localHashMap);
          }
          AppMethodBeat.o(213527);
        }
        
        public final void e(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          AppMethodBeat.i(213526);
          super.e(paramAnonymousBoolean, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(213526);
            return;
            f.b.this.handler.sendEmptyMessageDelayed(1001, 500L);
            AppMethodBeat.o(213526);
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
                localHashMap.put("duration", Long.valueOf(localb.tum.getDurationMs()));
                localHashMap.put("width", Integer.valueOf(localb.tum.getWidth()));
                localHashMap.put("height", Integer.valueOf(localb.tum.getHeight()));
                localb.tuo.df(localHashMap);
              }
              if (paramAnonymousBoolean)
              {
                f.b.this.tum.start();
                AppMethodBeat.o(213526);
                return;
                localb = f.b.this;
                if (localb.tuo != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingUpdate");
                  localHashMap.put("values", Collections.singletonList(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(localb.tum.getBufferedPercentage()) })));
                  localb.tuo.df(localHashMap);
                }
                AppMethodBeat.o(213526);
                return;
                localb = f.b.this;
                ae.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering start]");
                if (localb.tuo != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingStart");
                  localb.tuo.df(localHashMap);
                }
                AppMethodBeat.o(213526);
                return;
                localb = f.b.this;
                ae.i("FlutterThumb", "[buffering end]");
                if (localb.tuo != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingEnd");
                  localb.tuo.df(localHashMap);
                }
                AppMethodBeat.o(213526);
                return;
                localb = f.b.this;
                if (localb.isInitialized)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "completed");
                  localb.tuo.df(localHashMap);
                }
              }
            }
          }
        }
      });
      paramContext = new HashMap();
      paramContext.put("textureId", Long.valueOf(parama.gjz()));
      paramd1.df(paramContext);
      AppMethodBeat.o(148923);
    }
    
    private void e(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(213531);
      if (this.tuo != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("errorCode", Integer.valueOf(paramInt1));
        localHashMap.put("errorType", Integer.valueOf(paramInt2));
        localHashMap.put("errorMsg", paramString1);
        localHashMap.put("errorActionDesc", paramString2);
        this.tuo.f(String.valueOf(paramInt1), paramString1, localHashMap);
      }
      AppMethodBeat.o(213531);
    }
    
    final void dispose()
    {
      AppMethodBeat.i(148924);
      ae.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer createOfDispose %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.isInitialized) {
        this.tum.stop();
      }
      this.tun.release();
      this.tup.a(null);
      if ((this.surface != null) && (this.surface.isValid())) {
        this.surface.release();
      }
      if (this.tum != null) {
        this.tum.release();
      }
      AppMethodBeat.o(148924);
    }
    
    final String getVideoPath()
    {
      AppMethodBeat.i(213532);
      String str = this.tum.getVideoPath();
      AppMethodBeat.o(213532);
      return str;
    }
    
    final void pause()
    {
      AppMethodBeat.i(213529);
      ae.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer pause %s", new Object[] { Integer.valueOf(hashCode()) });
      this.tum.pause();
      AppMethodBeat.o(213529);
    }
    
    final void prepare()
    {
      AppMethodBeat.i(213528);
      this.tum.cSW();
      this.Zn = true;
      AppMethodBeat.o(213528);
    }
    
    final void seekTo(int paramInt)
    {
      AppMethodBeat.i(213530);
      ae.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer seekTo %s", new Object[] { Integer.valueOf(hashCode()) });
      this.tum.seek(paramInt);
      AppMethodBeat.o(213530);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.flutter.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.view.Surface;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
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
  a tjn;
  final Map<Long, b> tjo;
  b tjp;
  private HashMap<String, Integer> tjq;
  int tjr;
  
  public f(m.c paramc)
  {
    AppMethodBeat.i(148925);
    this.tjq = new HashMap();
    this.bbB = paramc;
    this.tjo = new HashMap();
    this.tjr = NetUtil.getNetType(aj.getContext());
    this.tjn = new a();
    aj.getContext().registerReceiver(this.tjn, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(148925);
  }
  
  private static boolean a(b paramb)
  {
    AppMethodBeat.i(219128);
    e.tjm.cQu();
    if (!e.cQs())
    {
      b.a(paramb, 1, 2, "视频加载失败，请检查网络连接后重试", "重试");
      AppMethodBeat.o(219128);
      return false;
    }
    if (!e.tjm.cQu().tji)
    {
      e.tjm.cQu();
      if (!e.chr())
      {
        b.a(paramb, 2, 1, "当前为非Wi-Fi环境，是否使用流量观看视频？", "仍然播放");
        AppMethodBeat.o(219128);
        return false;
      }
    }
    AppMethodBeat.o(219128);
    return true;
  }
  
  public final void a(j paramj, k.d paramd)
  {
    int j = -1;
    AppMethodBeat.i(148926);
    Object localObject1 = this.bbB.JT();
    if (localObject1 == null)
    {
      ad.e("MicroMsg.FlutterVideoPlayerPlugin", "texture null");
      paramd.f("no_activity", "video_player plugin requires a foreground activity", null);
      AppMethodBeat.o(148926);
      return;
    }
    if (paramj.wd("force") != null) {}
    for (boolean bool = ((Boolean)paramj.wd("force")).booleanValue();; bool = false)
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
          l = ((Number)paramj.wd("textureId")).longValue();
          localObject1 = (b)this.tjo.get(Long.valueOf(l));
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
      paramj = this.tjo.values().iterator();
      while (paramj.hasNext()) {
        ((b)paramj.next()).dispose();
      }
      this.tjo.clear();
      e.tjm.cQu().tji = false;
      e.tjm.cQu().tjk.clearAll();
      AppMethodBeat.o(148926);
      return;
      localObject1 = ((io.flutter.view.c)localObject1).geU();
      localObject2 = new io.flutter.plugin.a.d(this.bbB.JS(), "com.tencent.mm.flutter/videoPlayer/videoEvents" + ((c.a)localObject1).geX());
      if (paramj.wd("asset") != null) {
        if (paramj.wd("package") != null)
        {
          paramj = this.bbB.L((String)paramj.wd("asset"), (String)paramj.wd("package"));
          paramj = new b(this.bbB.JR(), (io.flutter.plugin.a.d)localObject2, (c.a)localObject1, "asset:///".concat(String.valueOf(paramj)), paramd);
          this.tjo.put(Long.valueOf(((c.a)localObject1).geX()), paramj);
        }
      }
      for (;;)
      {
        if ((bool) || (a(paramj)))
        {
          paramj.prepare();
          paramd = com.tencent.mm.b.g.getMessageDigest(paramj.getVideoPath().getBytes());
          paramj = paramj.getVideoPath();
          e.tjm.cQu().tjj.gE(paramj, paramd);
        }
        ad.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.tjo.size()) });
        AppMethodBeat.o(148926);
        return;
        paramj = this.bbB.en((String)paramj.wd("asset"));
        break;
        paramj = new b(this.bbB.JR(), (io.flutter.plugin.a.d)localObject2, (c.a)localObject1, (String)paramj.wd("uri"), paramd);
        this.tjo.put(Long.valueOf(((c.a)localObject1).geX()), paramj);
      }
      paramj = (String)paramj.wd("url");
      if (!bt.isNullOrNil(paramj))
      {
        e.tjm.cQu().tjj.a(paramj, null);
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
          paramd.djR();
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
      bool = ((Boolean)paramj.wd("looping")).booleanValue();
      ((b)localObject1).tju.setLooping(bool);
      paramd.de(null);
      AppMethodBeat.o(148926);
      return;
      float f = (float)Math.max(0.0D, Math.min(1.0D, ((Double)paramj.wd("volume")).doubleValue()));
      ((b)localObject1).tju.u(f);
      paramd.de(null);
      AppMethodBeat.o(148926);
      return;
      ad.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.tjp != localObject1)
      {
        if (this.tjp != null)
        {
          this.tjp.pause();
          paramj = com.tencent.mm.b.g.getMessageDigest(this.tjp.getVideoPath().getBytes());
          e.tjm.cQu().tjj.aju(paramj);
        }
        this.tjp = ((b)localObject1);
      }
      if (bool) {
        e.tjm.cQu().tji = true;
      }
      if (a(this.tjp))
      {
        if (!this.tjp.Zn) {
          this.tjp.prepare();
        }
        if (this.tjq.containsKey(this.tjp.getVideoPath())) {
          this.tjp.seekTo(((Integer)this.tjq.get(this.tjp.getVideoPath())).intValue());
        }
        paramj = this.tjp;
        ad.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer play %s", new Object[] { Integer.valueOf(paramj.hashCode()) });
        paramj.tju.start();
        paramj = com.tencent.mm.b.g.getMessageDigest(this.tjp.getVideoPath().getBytes());
        localObject1 = this.tjp.getVideoPath();
        e.tjm.cQu().tjj.gE((String)localObject1, paramj);
      }
      paramd.de(null);
      AppMethodBeat.o(148926);
      return;
      ad.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.tjp == localObject1) {
        ((b)localObject1).pause();
      }
      for (;;)
      {
        paramd.de(null);
        AppMethodBeat.o(148926);
        return;
        ad.d("MicroMsg.FlutterVideoPlayerPlugin", "pause ignore %s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
      }
      if (this.tjp != localObject1)
      {
        if (this.tjp != null)
        {
          this.tjp.pause();
          localObject2 = com.tencent.mm.b.g.getMessageDigest(this.tjp.getVideoPath().getBytes());
          e.tjm.cQu().tjj.aju((String)localObject2);
        }
        this.tjp = ((b)localObject1);
      }
      int i = ((Number)paramj.wd("location")).intValue();
      this.tjq.put(this.tjp.getVideoPath(), Integer.valueOf(i));
      this.tjp.seekTo(i);
      paramj = com.tencent.mm.b.g.getMessageDigest(this.tjp.getVideoPath().getBytes());
      localObject1 = this.tjp.getVideoPath();
      e.tjm.cQu().tjj.gE((String)localObject1, paramj);
      paramd.de(null);
      AppMethodBeat.o(148926);
      return;
      long l = ((b)localObject1).tju.getCurrentPosition();
      this.tjq.put(((b)localObject1).getVideoPath(), Integer.valueOf((int)l));
      paramd.de(Long.valueOf(l));
      AppMethodBeat.o(148926);
      return;
      ((b)localObject1).seekTo(0);
      ((b)localObject1).pause();
      this.tjq.put(((b)localObject1).getVideoPath(), Integer.valueOf(0));
      paramd.de(null);
      AppMethodBeat.o(148926);
      return;
      if ((this.tjp != null) && (localObject1 != null) && (this.tjp.getVideoPath().equalsIgnoreCase(((b)localObject1).getVideoPath()))) {
        this.tjq.remove(((b)localObject1).getVideoPath());
      }
      ad.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.tjp == localObject1) {
        this.tjp = null;
      }
      ((b)localObject1).dispose();
      this.tjo.remove(Long.valueOf(l));
      ad.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.tjo.size()) });
      paramd.de(null);
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
      AppMethodBeat.i(219116);
      int i = f.this.tjr;
      f.this.tjr = NetUtil.getNetType(aj.getContext());
      if ((i != f.this.tjr) && (f.this.tjr != 5) && (NetUtil.isNetAvailable(aj.getContext())))
      {
        ad.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net. reset enable play in mobile net false.");
        e.tjm.cQu().tji = false;
        if (f.this.tjp != null)
        {
          ad.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net.");
          f.this.tjp.pause();
        }
      }
      AppMethodBeat.o(219116);
    }
  }
  
  static final class b
  {
    boolean Zn;
    private Context context;
    ap handler;
    boolean isInitialized;
    private Surface surface;
    g tju;
    private final c.a tjv;
    i tjw;
    private final io.flutter.plugin.a.d tjx;
    
    b(Context paramContext, io.flutter.plugin.a.d paramd, c.a parama, String paramString, k.d paramd1)
    {
      AppMethodBeat.i(148923);
      this.tjw = new i();
      this.isInitialized = false;
      this.Zn = false;
      this.handler = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(219117);
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(219117);
            return;
            paramAnonymousMessage = f.b.this;
            ad.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering prepare]");
            if (paramAnonymousMessage.tjw != null)
            {
              HashMap localHashMap = new HashMap();
              localHashMap.put("event", "preparing");
              paramAnonymousMessage.tjw.de(localHashMap);
            }
          }
        }
      };
      ad.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer create %s", new Object[] { Integer.valueOf(hashCode()) });
      this.context = paramContext;
      this.tjx = paramd;
      this.tjv = parama;
      this.tju = new d(paramContext, q.B(new com.tencent.mm.vfs.e(paramContext.getCacheDir() + "/flutter/MMVideo-" + paramString.hashCode() + ".mp4").fOK()));
      this.tju.setPath(paramString);
      paramd.a(new d.c()
      {
        public final void a(d.a paramAnonymousa)
        {
          AppMethodBeat.i(219118);
          f.b.this.tjw.b(paramAnonymousa);
          AppMethodBeat.o(219118);
        }
        
        public final void sQ()
        {
          AppMethodBeat.i(219119);
          f.b.this.tjw.b(null);
          AppMethodBeat.o(219119);
        }
      });
      this.surface = new Surface(parama.surfaceTexture());
      this.tju.setSurface(this.surface);
      this.tju.a(new a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(219121);
          super.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString1, paramAnonymousString2);
          if (f.b.this.tjw != null)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("errorCode", Integer.valueOf(paramAnonymousInt1));
            localHashMap.put("errorType", Integer.valueOf(paramAnonymousInt2));
            localHashMap.put("errorMsg", paramAnonymousString1);
            localHashMap.put("errorActionDesc", paramAnonymousString2);
            f.b.this.tjw.f(String.valueOf(paramAnonymousInt1), paramAnonymousString1, localHashMap);
          }
          AppMethodBeat.o(219121);
        }
        
        public final void e(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          AppMethodBeat.i(219120);
          super.e(paramAnonymousBoolean, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(219120);
            return;
            f.b.this.handler.sendEmptyMessageDelayed(1001, 500L);
            AppMethodBeat.o(219120);
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
                localHashMap.put("duration", Long.valueOf(localb.tju.getDurationMs()));
                localHashMap.put("width", Integer.valueOf(localb.tju.getWidth()));
                localHashMap.put("height", Integer.valueOf(localb.tju.getHeight()));
                localb.tjw.de(localHashMap);
              }
              if (paramAnonymousBoolean)
              {
                f.b.this.tju.start();
                AppMethodBeat.o(219120);
                return;
                localb = f.b.this;
                if (localb.tjw != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingUpdate");
                  localHashMap.put("values", Collections.singletonList(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(localb.tju.getBufferedPercentage()) })));
                  localb.tjw.de(localHashMap);
                }
                AppMethodBeat.o(219120);
                return;
                localb = f.b.this;
                ad.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering start]");
                if (localb.tjw != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingStart");
                  localb.tjw.de(localHashMap);
                }
                AppMethodBeat.o(219120);
                return;
                localb = f.b.this;
                ad.i("FlutterThumb", "[buffering end]");
                if (localb.tjw != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingEnd");
                  localb.tjw.de(localHashMap);
                }
                AppMethodBeat.o(219120);
                return;
                localb = f.b.this;
                if (localb.isInitialized)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "completed");
                  localb.tjw.de(localHashMap);
                }
              }
            }
          }
        }
      });
      paramContext = new HashMap();
      paramContext.put("textureId", Long.valueOf(parama.geX()));
      paramd1.de(paramContext);
      AppMethodBeat.o(148923);
    }
    
    private void e(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(219125);
      if (this.tjw != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("errorCode", Integer.valueOf(paramInt1));
        localHashMap.put("errorType", Integer.valueOf(paramInt2));
        localHashMap.put("errorMsg", paramString1);
        localHashMap.put("errorActionDesc", paramString2);
        this.tjw.f(String.valueOf(paramInt1), paramString1, localHashMap);
      }
      AppMethodBeat.o(219125);
    }
    
    final void dispose()
    {
      AppMethodBeat.i(148924);
      ad.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer createOfDispose %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.isInitialized) {
        this.tju.stop();
      }
      this.tjv.release();
      this.tjx.a(null);
      if ((this.surface != null) && (this.surface.isValid())) {
        this.surface.release();
      }
      if (this.tju != null) {
        this.tju.release();
      }
      AppMethodBeat.o(148924);
    }
    
    final String getVideoPath()
    {
      AppMethodBeat.i(219126);
      String str = this.tju.getVideoPath();
      AppMethodBeat.o(219126);
      return str;
    }
    
    final void pause()
    {
      AppMethodBeat.i(219123);
      ad.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer pause %s", new Object[] { Integer.valueOf(hashCode()) });
      this.tju.pause();
      AppMethodBeat.o(219123);
    }
    
    final void prepare()
    {
      AppMethodBeat.i(219122);
      this.tju.cQr();
      this.Zn = true;
      AppMethodBeat.o(219122);
    }
    
    final void seekTo(int paramInt)
    {
      AppMethodBeat.i(219124);
      ad.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer seekTo %s", new Object[] { Integer.valueOf(hashCode()) });
      this.tju.seek(paramInt);
      AppMethodBeat.o(219124);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.f
 * JD-Core Version:    0.7.0.1
 */
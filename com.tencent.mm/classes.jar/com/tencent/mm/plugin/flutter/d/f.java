package com.tencent.mm.plugin.flutter.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.view.Surface;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import io.flutter.embedding.engine.plugins.a.a;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.d.a;
import io.flutter.plugin.a.d.c;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.view.c.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class f
  implements io.flutter.embedding.engine.plugins.a, k.c
{
  private a BDp;
  b BDq;
  private HashMap<String, Integer> BDr;
  int BDs;
  private k aKT;
  private a.b jSe;
  private final Map<Long, b> jSg;
  
  public f()
  {
    AppMethodBeat.i(220558);
    this.BDr = new HashMap();
    this.jSg = new HashMap();
    this.BDs = NetUtil.getNetType(MMApplicationContext.getContext());
    this.BDp = new a();
    MMApplicationContext.getContext().registerReceiver(this.BDp, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(220558);
  }
  
  private static boolean a(b paramb)
  {
    AppMethodBeat.i(220577);
    e.BDo.eqd();
    if (!e.eqa())
    {
      b.a(paramb, 1, 2, "视频加载失败，请检查网络连接后重试", "重试");
      AppMethodBeat.o(220577);
      return false;
    }
    if (!e.BDo.eqd().BDk)
    {
      e.BDo.eqd();
      if (!e.eqb())
      {
        b.a(paramb, 2, 1, "当前为非Wi-Fi环境，是否使用流量观看视频？", "仍然播放");
        AppMethodBeat.o(220577);
        return false;
      }
    }
    AppMethodBeat.o(220577);
    return true;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(220553);
    this.jSe = paramb;
    this.aKT = new k(paramb.aaqF, "com.tencent.mm.flutter/videoPlayer");
    this.aKT.a(this);
    AppMethodBeat.o(220553);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    int j = -1;
    AppMethodBeat.i(148926);
    Object localObject1 = this.jSe.aarP;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.FlutterVideoPlayerPlugin", "texture null");
      paramd.b("no_activity", "video_player plugin requires a foreground activity", null);
      AppMethodBeat.o(148926);
      return;
    }
    if (paramj.bGt("force") != null) {}
    for (boolean bool = ((Boolean)paramj.bGt("force")).booleanValue();; bool = false)
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
          l = ((Number)paramj.bGt("textureId")).longValue();
          localObject1 = (b)this.jSg.get(Long.valueOf(l));
          if (localObject1 != null) {
            break label699;
          }
          paramd.b("Unknown textureId", "No video player associated with texture id ".concat(String.valueOf(l)), null);
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
      paramj = this.jSg.values().iterator();
      while (paramj.hasNext()) {
        ((b)paramj.next()).dispose();
      }
      this.jSg.clear();
      e.BDo.eqd().BDk = false;
      paramj = e.BDo.eqd().BDm.BCY;
      if (paramj != null)
      {
        paramj.clear();
        AppMethodBeat.o(148926);
        return;
      }
      AppMethodBeat.o(148926);
      return;
      localObject1 = ((io.flutter.view.c)localObject1).iBa();
      localObject2 = new io.flutter.plugin.a.d(this.jSe.aaqF, "com.tencent.mm.flutter/videoPlayer/videoEvents" + ((c.a)localObject1).dux());
      if (paramj.bGt("asset") != null) {
        if (paramj.bGt("package") != null)
        {
          paramj = this.jSe.aarR.pl((String)paramj.bGt("asset"), (String)paramj.bGt("package"));
          paramj = new b(this.jSe.applicationContext, (io.flutter.plugin.a.d)localObject2, (c.a)localObject1, "asset:///".concat(String.valueOf(paramj)), paramd);
          this.jSg.put(Long.valueOf(((c.a)localObject1).dux()), paramj);
        }
      }
      for (;;)
      {
        if ((bool) || (a(paramj)))
        {
          paramj.prepare();
          paramd = com.tencent.mm.b.g.getMessageDigest(paramj.getVideoPath().getBytes());
          paramj = paramj.getVideoPath();
          e.BDo.eqd().BDl.hC(paramj, paramd);
        }
        Log.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.jSg.size()) });
        AppMethodBeat.o(148926);
        return;
        paramj = this.jSe.aarR.bGe((String)paramj.bGt("asset"));
        break;
        paramj = new b(this.jSe.applicationContext, (io.flutter.plugin.a.d)localObject2, (c.a)localObject1, (String)paramj.bGt("uri"), paramd);
        this.jSg.put(Long.valueOf(((c.a)localObject1).dux()), paramj);
      }
      paramj = (String)paramj.bGt("url");
      if (!Util.isNullOrNil(paramj))
      {
        e.BDo.eqd().BDl.b(paramj, null);
        AppMethodBeat.o(148926);
        return;
        label699:
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
          paramd.epZ();
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
      bool = ((Boolean)paramj.bGt("looping")).booleanValue();
      ((b)localObject1).BDu.setLooping(bool);
      paramd.bb(null);
      AppMethodBeat.o(148926);
      return;
      float f = (float)Math.max(0.0D, Math.min(1.0D, ((Double)paramj.bGt("volume")).doubleValue()));
      ((b)localObject1).BDu.u(f);
      paramd.bb(null);
      AppMethodBeat.o(148926);
      return;
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.BDq != localObject1)
      {
        if (this.BDq != null)
        {
          this.BDq.pause();
          paramj = com.tencent.mm.b.g.getMessageDigest(this.BDq.getVideoPath().getBytes());
          e.BDo.eqd().BDl.aHk(paramj);
        }
        this.BDq = ((b)localObject1);
      }
      if (bool) {
        e.BDo.eqd().BDk = true;
      }
      if (a(this.BDq))
      {
        if (!this.BDq.gX) {
          this.BDq.prepare();
        }
        if (this.BDr.containsKey(this.BDq.getVideoPath())) {
          this.BDq.seekTo(((Integer)this.BDr.get(this.BDq.getVideoPath())).intValue());
        }
        paramj = this.BDq;
        Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer play %s", new Object[] { Integer.valueOf(paramj.hashCode()) });
        paramj.BDu.start();
        paramj = com.tencent.mm.b.g.getMessageDigest(this.BDq.getVideoPath().getBytes());
        localObject1 = this.BDq.getVideoPath();
        e.BDo.eqd().BDl.hC((String)localObject1, paramj);
      }
      paramd.bb(null);
      AppMethodBeat.o(148926);
      return;
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.BDq == localObject1) {
        ((b)localObject1).pause();
      }
      for (;;)
      {
        paramd.bb(null);
        AppMethodBeat.o(148926);
        return;
        Log.d("MicroMsg.FlutterVideoPlayerPlugin", "pause ignore %s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
      }
      if (this.BDq != localObject1)
      {
        if (this.BDq != null)
        {
          this.BDq.pause();
          localObject2 = com.tencent.mm.b.g.getMessageDigest(this.BDq.getVideoPath().getBytes());
          e.BDo.eqd().BDl.aHk((String)localObject2);
        }
        this.BDq = ((b)localObject1);
      }
      int i = ((Number)paramj.bGt("location")).intValue();
      this.BDr.put(this.BDq.getVideoPath(), Integer.valueOf(i));
      this.BDq.seekTo(i);
      paramj = com.tencent.mm.b.g.getMessageDigest(this.BDq.getVideoPath().getBytes());
      localObject1 = this.BDq.getVideoPath();
      e.BDo.eqd().BDl.hC((String)localObject1, paramj);
      paramd.bb(null);
      AppMethodBeat.o(148926);
      return;
      long l = ((b)localObject1).BDu.getCurrentPosition();
      this.BDr.put(((b)localObject1).getVideoPath(), Integer.valueOf((int)l));
      paramd.bb(Long.valueOf(l));
      AppMethodBeat.o(148926);
      return;
      ((b)localObject1).seekTo(0);
      ((b)localObject1).pause();
      this.BDr.put(((b)localObject1).getVideoPath(), Integer.valueOf(0));
      paramd.bb(null);
      AppMethodBeat.o(148926);
      return;
      if ((this.BDq != null) && (localObject1 != null) && (this.BDq.getVideoPath().equalsIgnoreCase(((b)localObject1).getVideoPath()))) {
        this.BDr.remove(((b)localObject1).getVideoPath());
      }
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.BDq == localObject1) {
        this.BDq = null;
      }
      ((b)localObject1).dispose();
      this.jSg.remove(Long.valueOf(l));
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.jSg.size()) });
      paramd.bb(null);
      AppMethodBeat.o(148926);
      return;
    }
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(220555);
    this.aKT.a(null);
    AppMethodBeat.o(220555);
  }
  
  final class a
    extends BroadcastReceiver
  {
    a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(221095);
      int i = f.this.BDs;
      f.this.BDs = NetUtil.getNetType(MMApplicationContext.getContext());
      if ((i != f.this.BDs) && (f.this.BDs != 5) && (NetUtil.isNetAvailable(MMApplicationContext.getContext())))
      {
        Log.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net. reset enable play in mobile net false.");
        e.BDo.eqd().BDk = false;
        if (f.this.BDq != null)
        {
          Log.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net.");
          f.this.BDq.pause();
        }
      }
      AppMethodBeat.o(221095);
    }
  }
  
  static final class b
  {
    g BDu;
    i BDv;
    private final io.flutter.plugin.a.d aKU;
    private Context context;
    boolean gX;
    MMHandler handler;
    boolean isInitialized;
    private final c.a jSi;
    private Surface surface;
    
    b(Context paramContext, io.flutter.plugin.a.d paramd, c.a parama, String paramString, k.d paramd1)
    {
      AppMethodBeat.i(148923);
      this.BDv = new i();
      this.isInitialized = false;
      this.gX = false;
      this.handler = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(220813);
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(220813);
            return;
            paramAnonymousMessage = f.b.this;
            Log.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering prepare]");
            if (paramAnonymousMessage.BDv != null)
            {
              HashMap localHashMap = new HashMap();
              localHashMap.put("event", "preparing");
              paramAnonymousMessage.BDv.bb(localHashMap);
            }
          }
        }
      };
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer create %s", new Object[] { Integer.valueOf(hashCode()) });
      this.context = paramContext;
      this.aKU = paramd;
      this.jSi = parama;
      this.BDu = new d(paramContext, new q(paramContext.getCacheDir() + "/flutter/MMVideo-" + paramString.hashCode() + ".mp4").bOF());
      this.BDu.setPath(paramString);
      paramd.a(new d.c()
      {
        public final void a(d.a paramAnonymousa)
        {
          AppMethodBeat.i(221133);
          f.b.this.BDv.b(paramAnonymousa);
          AppMethodBeat.o(221133);
        }
        
        public final void qH()
        {
          AppMethodBeat.i(221135);
          f.b.this.BDv.b(null);
          AppMethodBeat.o(221135);
        }
      });
      this.surface = new Surface(parama.surfaceTexture());
      this.BDu.setSurface(this.surface);
      this.BDu.a(new a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(220938);
          super.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString1, paramAnonymousString2);
          if (f.b.this.BDv != null)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("errorCode", Integer.valueOf(paramAnonymousInt1));
            localHashMap.put("errorType", Integer.valueOf(paramAnonymousInt2));
            localHashMap.put("errorMsg", paramAnonymousString1);
            localHashMap.put("errorActionDesc", paramAnonymousString2);
            f.b.this.BDv.b(String.valueOf(paramAnonymousInt1), paramAnonymousString1, localHashMap);
          }
          AppMethodBeat.o(220938);
        }
        
        public final void e(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          AppMethodBeat.i(220935);
          super.e(paramAnonymousBoolean, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(220935);
            return;
            f.b.this.handler.sendEmptyMessageDelayed(1001, 500L);
            AppMethodBeat.o(220935);
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
                localHashMap.put("duration", Long.valueOf(localb.BDu.getDurationMs()));
                localHashMap.put("width", Integer.valueOf(localb.BDu.getWidth()));
                localHashMap.put("height", Integer.valueOf(localb.BDu.getHeight()));
                localb.BDv.bb(localHashMap);
              }
              if (paramAnonymousBoolean)
              {
                f.b.this.BDu.start();
                AppMethodBeat.o(220935);
                return;
                localb = f.b.this;
                if (localb.BDv != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingUpdate");
                  localHashMap.put("values", Collections.singletonList(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(localb.BDu.getBufferedPercentage()) })));
                  localb.BDv.bb(localHashMap);
                }
                AppMethodBeat.o(220935);
                return;
                localb = f.b.this;
                Log.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering start]");
                if (localb.BDv != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingStart");
                  localb.BDv.bb(localHashMap);
                }
                AppMethodBeat.o(220935);
                return;
                localb = f.b.this;
                Log.i("FlutterThumb", "[buffering end]");
                if (localb.BDv != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingEnd");
                  localb.BDv.bb(localHashMap);
                }
                AppMethodBeat.o(220935);
                return;
                localb = f.b.this;
                if (localb.isInitialized)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "completed");
                  localb.BDv.bb(localHashMap);
                }
              }
            }
          }
        }
      });
      paramContext = new HashMap();
      paramContext.put("textureId", Long.valueOf(parama.dux()));
      paramd1.bb(paramContext);
      AppMethodBeat.o(148923);
    }
    
    private void e(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(220523);
      if (this.BDv != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("errorCode", Integer.valueOf(paramInt1));
        localHashMap.put("errorType", Integer.valueOf(paramInt2));
        localHashMap.put("errorMsg", paramString1);
        localHashMap.put("errorActionDesc", paramString2);
        this.BDv.b(String.valueOf(paramInt1), paramString1, localHashMap);
      }
      AppMethodBeat.o(220523);
    }
    
    final void dispose()
    {
      AppMethodBeat.i(148924);
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer createOfDispose %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.isInitialized) {
        this.BDu.stop();
      }
      this.jSi.release();
      this.aKU.a(null);
      if ((this.surface != null) && (this.surface.isValid())) {
        this.surface.release();
      }
      if (this.BDu != null) {
        this.BDu.release();
      }
      AppMethodBeat.o(148924);
    }
    
    final String getVideoPath()
    {
      AppMethodBeat.i(220525);
      String str = this.BDu.getVideoPath();
      AppMethodBeat.o(220525);
      return str;
    }
    
    final void pause()
    {
      AppMethodBeat.i(220516);
      Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer pause %s", new Object[] { Integer.valueOf(hashCode()) });
      this.BDu.pause();
      AppMethodBeat.o(220516);
    }
    
    final void prepare()
    {
      AppMethodBeat.i(220514);
      this.BDu.prepare();
      this.gX = true;
      AppMethodBeat.o(220514);
    }
    
    final void seekTo(int paramInt)
    {
      AppMethodBeat.i(220519);
      Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer seekTo %s", new Object[] { Integer.valueOf(hashCode()) });
      this.BDu.seek(paramInt);
      AppMethodBeat.o(220519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.f
 * JD-Core Version:    0.7.0.1
 */
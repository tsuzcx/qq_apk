package com.tencent.mm.plugin.flutter.f;

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
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
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
  private k bbv;
  private a.b hgm;
  private final Map<Long, b> hgn;
  private a wLt;
  b wLu;
  private HashMap<String, Integer> wLv;
  int wLw;
  
  public f()
  {
    AppMethodBeat.i(240990);
    this.wLv = new HashMap();
    this.hgn = new HashMap();
    this.wLw = NetUtil.getNetType(MMApplicationContext.getContext());
    this.wLt = new a();
    MMApplicationContext.getContext().registerReceiver(this.wLt, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(240990);
  }
  
  private static boolean a(b paramb)
  {
    AppMethodBeat.i(240991);
    e.wLs.dMk();
    if (!e.dMi())
    {
      b.a(paramb, 1, 2, "视频加载失败，请检查网络连接后重试", "重试");
      AppMethodBeat.o(240991);
      return false;
    }
    if (!e.wLs.dMk().wLo)
    {
      e.wLs.dMk();
      if (!e.cGF())
      {
        b.a(paramb, 2, 1, "当前为非Wi-Fi环境，是否使用流量观看视频？", "仍然播放");
        AppMethodBeat.o(240991);
        return false;
      }
    }
    AppMethodBeat.o(240991);
    return true;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(240988);
    this.hgm = paramb;
    this.bbv = new k(paramb.SOH, "com.tencent.mm.flutter/videoPlayer");
    this.bbv.a(this);
    AppMethodBeat.o(240988);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    int j = -1;
    AppMethodBeat.i(148926);
    Object localObject1 = this.hgm.StA;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.FlutterVideoPlayerPlugin", "texture null");
      paramd.b("no_activity", "video_player plugin requires a foreground activity", null);
      AppMethodBeat.o(148926);
      return;
    }
    if (paramj.btq("force") != null) {}
    for (boolean bool = ((Boolean)paramj.btq("force")).booleanValue();; bool = false)
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
          l = ((Number)paramj.btq("textureId")).longValue();
          localObject1 = (b)this.hgn.get(Long.valueOf(l));
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
      paramj = this.hgn.values().iterator();
      while (paramj.hasNext()) {
        ((b)paramj.next()).dispose();
      }
      this.hgn.clear();
      e.wLs.dMk().wLo = false;
      paramj = e.wLs.dMk().wLq.wLb;
      if (paramj != null)
      {
        paramj.clear();
        AppMethodBeat.o(148926);
        return;
      }
      AppMethodBeat.o(148926);
      return;
      localObject1 = ((io.flutter.view.c)localObject1).hwY();
      localObject2 = new io.flutter.plugin.a.d(this.hgm.SOH, "com.tencent.mm.flutter/videoPlayer/videoEvents" + ((c.a)localObject1).hxb());
      if (paramj.btq("asset") != null) {
        if (paramj.btq("package") != null)
        {
          paramj = this.hgm.SPB.op((String)paramj.btq("asset"), (String)paramj.btq("package"));
          paramj = new b(this.hgm.applicationContext, (io.flutter.plugin.a.d)localObject2, (c.a)localObject1, "asset:///".concat(String.valueOf(paramj)), paramd);
          this.hgn.put(Long.valueOf(((c.a)localObject1).hxb()), paramj);
        }
      }
      for (;;)
      {
        if ((bool) || (a(paramj)))
        {
          paramj.prepare();
          paramd = com.tencent.mm.b.g.getMessageDigest(paramj.getVideoPath().getBytes());
          paramj = paramj.getVideoPath();
          e.wLs.dMk().wLp.hp(paramj, paramd);
        }
        Log.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.hgn.size()) });
        AppMethodBeat.o(148926);
        return;
        paramj = this.hgm.SPB.btc((String)paramj.btq("asset"));
        break;
        paramj = new b(this.hgm.applicationContext, (io.flutter.plugin.a.d)localObject2, (c.a)localObject1, (String)paramj.btq("uri"), paramd);
        this.hgn.put(Long.valueOf(((c.a)localObject1).hxb()), paramj);
      }
      paramj = (String)paramj.btq("url");
      if (!Util.isNullOrNil(paramj))
      {
        e.wLs.dMk().wLp.a(paramj, null);
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
          paramd.dLv();
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
      bool = ((Boolean)paramj.btq("looping")).booleanValue();
      ((b)localObject1).wLy.setLooping(bool);
      paramd.ba(null);
      AppMethodBeat.o(148926);
      return;
      float f = (float)Math.max(0.0D, Math.min(1.0D, ((Double)paramj.btq("volume")).doubleValue()));
      ((b)localObject1).wLy.u(f);
      paramd.ba(null);
      AppMethodBeat.o(148926);
      return;
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.wLu != localObject1)
      {
        if (this.wLu != null)
        {
          this.wLu.pause();
          paramj = com.tencent.mm.b.g.getMessageDigest(this.wLu.getVideoPath().getBytes());
          e.wLs.dMk().wLp.axx(paramj);
        }
        this.wLu = ((b)localObject1);
      }
      if (bool) {
        e.wLs.dMk().wLo = true;
      }
      if (a(this.wLu))
      {
        if (!this.wLu.ZA) {
          this.wLu.prepare();
        }
        if (this.wLv.containsKey(this.wLu.getVideoPath())) {
          this.wLu.seekTo(((Integer)this.wLv.get(this.wLu.getVideoPath())).intValue());
        }
        paramj = this.wLu;
        Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer play %s", new Object[] { Integer.valueOf(paramj.hashCode()) });
        paramj.wLy.start();
        paramj = com.tencent.mm.b.g.getMessageDigest(this.wLu.getVideoPath().getBytes());
        localObject1 = this.wLu.getVideoPath();
        e.wLs.dMk().wLp.hp((String)localObject1, paramj);
      }
      paramd.ba(null);
      AppMethodBeat.o(148926);
      return;
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.wLu == localObject1) {
        ((b)localObject1).pause();
      }
      for (;;)
      {
        paramd.ba(null);
        AppMethodBeat.o(148926);
        return;
        Log.d("MicroMsg.FlutterVideoPlayerPlugin", "pause ignore %s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
      }
      if (this.wLu != localObject1)
      {
        if (this.wLu != null)
        {
          this.wLu.pause();
          localObject2 = com.tencent.mm.b.g.getMessageDigest(this.wLu.getVideoPath().getBytes());
          e.wLs.dMk().wLp.axx((String)localObject2);
        }
        this.wLu = ((b)localObject1);
      }
      int i = ((Number)paramj.btq("location")).intValue();
      this.wLv.put(this.wLu.getVideoPath(), Integer.valueOf(i));
      this.wLu.seekTo(i);
      paramj = com.tencent.mm.b.g.getMessageDigest(this.wLu.getVideoPath().getBytes());
      localObject1 = this.wLu.getVideoPath();
      e.wLs.dMk().wLp.hp((String)localObject1, paramj);
      paramd.ba(null);
      AppMethodBeat.o(148926);
      return;
      long l = ((b)localObject1).wLy.getCurrentPosition();
      this.wLv.put(((b)localObject1).getVideoPath(), Integer.valueOf((int)l));
      paramd.ba(Long.valueOf(l));
      AppMethodBeat.o(148926);
      return;
      ((b)localObject1).seekTo(0);
      ((b)localObject1).pause();
      this.wLv.put(((b)localObject1).getVideoPath(), Integer.valueOf(0));
      paramd.ba(null);
      AppMethodBeat.o(148926);
      return;
      if ((this.wLu != null) && (localObject1 != null) && (this.wLu.getVideoPath().equalsIgnoreCase(((b)localObject1).getVideoPath()))) {
        this.wLv.remove(((b)localObject1).getVideoPath());
      }
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramj.method);
      if (this.wLu == localObject1) {
        this.wLu = null;
      }
      ((b)localObject1).dispose();
      this.hgn.remove(Long.valueOf(l));
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.hgn.size()) });
      paramd.ba(null);
      AppMethodBeat.o(148926);
      return;
    }
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(240989);
    this.bbv.a(null);
    AppMethodBeat.o(240989);
  }
  
  final class a
    extends BroadcastReceiver
  {
    a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(240976);
      int i = f.this.wLw;
      f.this.wLw = NetUtil.getNetType(MMApplicationContext.getContext());
      if ((i != f.this.wLw) && (f.this.wLw != 5) && (NetUtil.isNetAvailable(MMApplicationContext.getContext())))
      {
        Log.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net. reset enable play in mobile net false.");
        e.wLs.dMk().wLo = false;
        if (f.this.wLu != null)
        {
          Log.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net.");
          f.this.wLu.pause();
        }
      }
      AppMethodBeat.o(240976);
    }
  }
  
  static final class b
  {
    boolean ZA;
    private final io.flutter.plugin.a.d bbw;
    private Context context;
    MMHandler handler;
    private final c.a hgp;
    boolean isInitialized;
    private Surface surface;
    g wLy;
    i wLz;
    
    b(Context paramContext, io.flutter.plugin.a.d paramd, c.a parama, String paramString, k.d paramd1)
    {
      AppMethodBeat.i(148923);
      this.wLz = new i();
      this.isInitialized = false;
      this.ZA = false;
      this.handler = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(240977);
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(240977);
            return;
            paramAnonymousMessage = f.b.this;
            Log.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering prepare]");
            if (paramAnonymousMessage.wLz != null)
            {
              HashMap localHashMap = new HashMap();
              localHashMap.put("event", "preparing");
              paramAnonymousMessage.wLz.ba(localHashMap);
            }
          }
        }
      };
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer create %s", new Object[] { Integer.valueOf(hashCode()) });
      this.context = paramContext;
      this.bbw = paramd;
      this.hgp = parama;
      this.wLy = new d(paramContext, aa.z(new o(paramContext.getCacheDir() + "/flutter/MMVideo-" + paramString.hashCode() + ".mp4").her()));
      this.wLy.setPath(paramString);
      paramd.a(new d.c()
      {
        public final void a(Object paramAnonymousObject, d.a paramAnonymousa)
        {
          AppMethodBeat.i(240978);
          f.b.this.wLz.a(paramAnonymousa);
          AppMethodBeat.o(240978);
        }
        
        public final void sT()
        {
          AppMethodBeat.i(240979);
          f.b.this.wLz.a(null);
          AppMethodBeat.o(240979);
        }
      });
      this.surface = new Surface(parama.surfaceTexture());
      this.wLy.setSurface(this.surface);
      this.wLy.a(new a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(240981);
          super.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString1, paramAnonymousString2);
          if (f.b.this.wLz != null)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("errorCode", Integer.valueOf(paramAnonymousInt1));
            localHashMap.put("errorType", Integer.valueOf(paramAnonymousInt2));
            localHashMap.put("errorMsg", paramAnonymousString1);
            localHashMap.put("errorActionDesc", paramAnonymousString2);
            f.b.this.wLz.b(String.valueOf(paramAnonymousInt1), paramAnonymousString1, localHashMap);
          }
          AppMethodBeat.o(240981);
        }
        
        public final void c(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          AppMethodBeat.i(240980);
          super.c(paramAnonymousBoolean, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(240980);
            return;
            f.b.this.handler.sendEmptyMessageDelayed(1001, 500L);
            AppMethodBeat.o(240980);
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
                localHashMap.put("duration", Long.valueOf(localb.wLy.getDurationMs()));
                localHashMap.put("width", Integer.valueOf(localb.wLy.getWidth()));
                localHashMap.put("height", Integer.valueOf(localb.wLy.getHeight()));
                localb.wLz.ba(localHashMap);
              }
              if (paramAnonymousBoolean)
              {
                f.b.this.wLy.start();
                AppMethodBeat.o(240980);
                return;
                localb = f.b.this;
                if (localb.wLz != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingUpdate");
                  localHashMap.put("values", Collections.singletonList(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(localb.wLy.getBufferedPercentage()) })));
                  localb.wLz.ba(localHashMap);
                }
                AppMethodBeat.o(240980);
                return;
                localb = f.b.this;
                Log.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering start]");
                if (localb.wLz != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingStart");
                  localb.wLz.ba(localHashMap);
                }
                AppMethodBeat.o(240980);
                return;
                localb = f.b.this;
                Log.i("FlutterThumb", "[buffering end]");
                if (localb.wLz != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingEnd");
                  localb.wLz.ba(localHashMap);
                }
                AppMethodBeat.o(240980);
                return;
                localb = f.b.this;
                if (localb.isInitialized)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "completed");
                  localb.wLz.ba(localHashMap);
                }
              }
            }
          }
        }
      });
      paramContext = new HashMap();
      paramContext.put("textureId", Long.valueOf(parama.hxb()));
      paramd1.ba(paramContext);
      AppMethodBeat.o(148923);
    }
    
    private void d(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(240985);
      if (this.wLz != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("errorCode", Integer.valueOf(paramInt1));
        localHashMap.put("errorType", Integer.valueOf(paramInt2));
        localHashMap.put("errorMsg", paramString1);
        localHashMap.put("errorActionDesc", paramString2);
        this.wLz.b(String.valueOf(paramInt1), paramString1, localHashMap);
      }
      AppMethodBeat.o(240985);
    }
    
    final void dispose()
    {
      AppMethodBeat.i(148924);
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer createOfDispose %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.isInitialized) {
        this.wLy.stop();
      }
      this.hgp.release();
      this.bbw.a(null);
      if ((this.surface != null) && (this.surface.isValid())) {
        this.surface.release();
      }
      if (this.wLy != null) {
        this.wLy.release();
      }
      AppMethodBeat.o(148924);
    }
    
    final String getVideoPath()
    {
      AppMethodBeat.i(240986);
      String str = this.wLy.getVideoPath();
      AppMethodBeat.o(240986);
      return str;
    }
    
    final void pause()
    {
      AppMethodBeat.i(240983);
      Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer pause %s", new Object[] { Integer.valueOf(hashCode()) });
      this.wLy.pause();
      AppMethodBeat.o(240983);
    }
    
    final void prepare()
    {
      AppMethodBeat.i(240982);
      this.wLy.prepare();
      this.ZA = true;
      AppMethodBeat.o(240982);
    }
    
    final void seekTo(int paramInt)
    {
      AppMethodBeat.i(240984);
      Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer seekTo %s", new Object[] { Integer.valueOf(hashCode()) });
      this.wLy.seek(paramInt);
      AppMethodBeat.o(240984);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.f.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.flutter.e;

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
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class f
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private final a HlW;
  private b HlX;
  private HashMap<String, Integer> HlY;
  private int HlZ;
  private MethodChannel channel;
  private FlutterPlugin.FlutterPluginBinding msv;
  private final Map<Long, b> msy;
  
  public f()
  {
    AppMethodBeat.i(263074);
    this.HlY = new HashMap();
    this.msy = new HashMap();
    this.HlZ = NetUtil.getNetType(MMApplicationContext.getContext());
    this.HlW = new a();
    AppMethodBeat.o(263074);
  }
  
  private static boolean a(b paramb)
  {
    AppMethodBeat.i(263080);
    e.HlR.fvk();
    if (!e.fvh())
    {
      b.a(paramb, 1, 2, "视频加载失败，请检查网络连接后重试", "重试");
      AppMethodBeat.o(263080);
      return false;
    }
    if (!e.HlR.fvk().HlS)
    {
      e.HlR.fvk();
      if (!e.fvi())
      {
        b.a(paramb, 2, 1, "当前为非Wi-Fi环境，是否使用流量观看视频？", "仍然播放");
        AppMethodBeat.o(263080);
        return false;
      }
    }
    AppMethodBeat.o(263080);
    return true;
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263109);
    this.msv = paramFlutterPluginBinding;
    this.channel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "com.tencent.mm.flutter/videoPlayer");
    this.channel.setMethodCallHandler(this);
    MMApplicationContext.getContext().registerReceiver(this.HlW, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(263109);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263118);
    this.channel.setMethodCallHandler(null);
    MMApplicationContext.getContext().unregisterReceiver(this.HlW);
    AppMethodBeat.o(263118);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    int j = -1;
    AppMethodBeat.i(148926);
    Object localObject1 = this.msv.getTextureRegistry();
    if (localObject1 == null)
    {
      Log.e("MicroMsg.FlutterVideoPlayerPlugin", "texture null");
      paramResult.error("no_activity", "video_player plugin requires a foreground activity", null);
      AppMethodBeat.o(148926);
      return;
    }
    if (paramMethodCall.argument("force") != null) {}
    for (boolean bool = ((Boolean)paramMethodCall.argument("force")).booleanValue();; bool = false)
    {
      Object localObject2 = paramMethodCall.method;
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
          l = ((Number)paramMethodCall.argument("textureId")).longValue();
          localObject1 = (b)this.msy.get(Long.valueOf(l));
          if (localObject1 != null) {
            break label626;
          }
          paramResult.error("Unknown textureId", "No video player associated with texture id ".concat(String.valueOf(l)), null);
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
      paramMethodCall = this.msy.values().iterator();
      while (paramMethodCall.hasNext()) {
        ((b)paramMethodCall.next()).dispose();
      }
      this.msy.clear();
      e.HlR.fvk().HlS = false;
      paramMethodCall = e.HlR.fvk().HlU.HlG;
      if (paramMethodCall != null) {
        paramMethodCall.clear();
      }
      AppMethodBeat.o(148926);
      return;
      localObject1 = ((TextureRegistry)localObject1).createSurfaceTexture();
      localObject2 = new EventChannel(this.msv.getBinaryMessenger(), "com.tencent.mm.flutter/videoPlayer/videoEvents" + ((TextureRegistry.SurfaceTextureEntry)localObject1).id());
      if (paramMethodCall.argument("asset") != null)
      {
        paramMethodCall = (String)paramMethodCall.argument("asset");
        paramMethodCall = new b(this.msv.getApplicationContext(), (EventChannel)localObject2, (TextureRegistry.SurfaceTextureEntry)localObject1, paramMethodCall, paramResult);
        this.msy.put(Long.valueOf(((TextureRegistry.SurfaceTextureEntry)localObject1).id()), paramMethodCall);
      }
      for (;;)
      {
        if ((bool) || (a(paramMethodCall)))
        {
          paramMethodCall.prepare();
          paramResult = com.tencent.mm.b.g.getMessageDigest(paramMethodCall.getVideoPath().getBytes());
          paramMethodCall = paramMethodCall.getVideoPath();
          e.HlR.fvk().HlT.iB(paramMethodCall, paramResult);
        }
        Log.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.msy.size()) });
        AppMethodBeat.o(148926);
        return;
        paramMethodCall = new b(this.msv.getApplicationContext(), (EventChannel)localObject2, (TextureRegistry.SurfaceTextureEntry)localObject1, (String)paramMethodCall.argument("uri"), paramResult);
        this.msy.put(Long.valueOf(((TextureRegistry.SurfaceTextureEntry)localObject1).id()), paramMethodCall);
      }
      paramMethodCall = (String)paramMethodCall.argument("url");
      if (!Util.isNullOrNil(paramMethodCall))
      {
        e.HlR.fvk().HlT.b(paramMethodCall, null);
        AppMethodBeat.o(148926);
        return;
        label626:
        localObject2 = paramMethodCall.method;
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
          paramResult.notImplemented();
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
              if (((String)localObject2).equals("setOutputMute"))
              {
                i = 2;
                continue;
                i = j;
                if (((String)localObject2).equals("play"))
                {
                  i = 3;
                  continue;
                  i = j;
                  if (((String)localObject2).equals("pause"))
                  {
                    i = 4;
                    continue;
                    i = j;
                    if (((String)localObject2).equals("seekTo"))
                    {
                      i = 5;
                      continue;
                      i = j;
                      if (((String)localObject2).equals("position"))
                      {
                        i = 6;
                        continue;
                        i = j;
                        if (((String)localObject2).equals("resetPosition"))
                        {
                          i = 7;
                          continue;
                          i = j;
                          if (((String)localObject2).equals("dispose")) {
                            i = 8;
                          }
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
      bool = ((Boolean)paramMethodCall.argument("looping")).booleanValue();
      ((b)localObject1).Hmb.setLooping(bool);
      paramResult.success(null);
      AppMethodBeat.o(148926);
      return;
      float f = (float)Math.max(0.0D, Math.min(1.0D, ((Double)paramMethodCall.argument("volume")).doubleValue()));
      ((b)localObject1).Hmb.M(f);
      paramResult.success(null);
      AppMethodBeat.o(148926);
      return;
      bool = ((Boolean)paramMethodCall.argument("outputMute")).booleanValue();
      ((b)localObject1).Hmb.setMute(bool);
      paramResult.success(null);
      AppMethodBeat.o(148926);
      return;
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramMethodCall.method);
      if (this.HlX != localObject1)
      {
        if (this.HlX != null)
        {
          this.HlX.pause();
          paramMethodCall = com.tencent.mm.b.g.getMessageDigest(this.HlX.getVideoPath().getBytes());
          e.HlR.fvk().HlT.aDC(paramMethodCall);
        }
        this.HlX = ((b)localObject1);
      }
      if (bool) {
        e.HlR.fvk().HlS = true;
      }
      if (a(this.HlX))
      {
        if (!this.HlX.hS) {
          this.HlX.prepare();
        }
        if (this.HlY.containsKey(this.HlX.getVideoPath())) {
          this.HlX.seekTo(((Integer)this.HlY.get(this.HlX.getVideoPath())).intValue());
        }
        paramMethodCall = this.HlX;
        Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer play %s", new Object[] { Integer.valueOf(paramMethodCall.hashCode()) });
        paramMethodCall.Hmb.start();
        paramMethodCall = com.tencent.mm.b.g.getMessageDigest(this.HlX.getVideoPath().getBytes());
        localObject1 = this.HlX.getVideoPath();
        e.HlR.fvk().HlT.iB((String)localObject1, paramMethodCall);
      }
      paramResult.success(null);
      AppMethodBeat.o(148926);
      return;
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramMethodCall.method);
      if (this.HlX == localObject1) {
        ((b)localObject1).pause();
      }
      for (;;)
      {
        paramResult.success(null);
        AppMethodBeat.o(148926);
        return;
        Log.d("MicroMsg.FlutterVideoPlayerPlugin", "pause ignore %s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
      }
      if (this.HlX != localObject1)
      {
        if (this.HlX != null)
        {
          this.HlX.pause();
          localObject2 = com.tencent.mm.b.g.getMessageDigest(this.HlX.getVideoPath().getBytes());
          e.HlR.fvk().HlT.aDC((String)localObject2);
        }
        this.HlX = ((b)localObject1);
      }
      int i = ((Number)paramMethodCall.argument("location")).intValue();
      this.HlY.put(this.HlX.getVideoPath(), Integer.valueOf(i));
      this.HlX.seekTo(i);
      paramMethodCall = com.tencent.mm.b.g.getMessageDigest(this.HlX.getVideoPath().getBytes());
      localObject1 = this.HlX.getVideoPath();
      e.HlR.fvk().HlT.iB((String)localObject1, paramMethodCall);
      paramResult.success(null);
      AppMethodBeat.o(148926);
      return;
      long l = ((b)localObject1).Hmb.getCurrentPosition();
      this.HlY.put(((b)localObject1).getVideoPath(), Integer.valueOf((int)l));
      paramResult.success(Long.valueOf(l));
      AppMethodBeat.o(148926);
      return;
      ((b)localObject1).seekTo(0);
      ((b)localObject1).pause();
      this.HlY.put(((b)localObject1).getVideoPath(), Integer.valueOf(0));
      paramResult.success(null);
      AppMethodBeat.o(148926);
      return;
      if ((this.HlX != null) && (localObject1 != null) && (this.HlX.getVideoPath().equalsIgnoreCase(((b)localObject1).getVideoPath()))) {
        this.HlY.remove(((b)localObject1).getVideoPath());
      }
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "video_status method call: " + paramMethodCall.method);
      if (this.HlX == localObject1) {
        this.HlX = null;
      }
      ((b)localObject1).dispose();
      this.msy.remove(Long.valueOf(l));
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "player createOrDispose size:%d ", new Object[] { Integer.valueOf(this.msy.size()) });
      paramResult.success(null);
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
      AppMethodBeat.i(263075);
      int i = f.a(f.this);
      f.a(f.this, NetUtil.getNetType(MMApplicationContext.getContext()));
      if ((i != f.a(f.this)) && (f.a(f.this) != 5) && (NetUtil.isNetAvailable(MMApplicationContext.getContext())))
      {
        Log.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net. reset enable play in mobile net false.");
        e.HlR.fvk().HlS = false;
        if (f.b(f.this) != null)
        {
          Log.i("MicroMsg.FlutterVideoPlayerPlugin", "network change to mobile net.");
          f.b(f.this).pause();
        }
      }
      AppMethodBeat.o(263075);
    }
  }
  
  static final class b
  {
    g Hmb;
    i Hmc;
    boolean baY;
    private Context context;
    private final EventChannel eventChannel;
    boolean hS;
    MMHandler handler;
    private Surface surface;
    private final TextureRegistry.SurfaceTextureEntry textureEntry;
    
    b(Context paramContext, EventChannel paramEventChannel, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, String paramString, MethodChannel.Result paramResult)
    {
      AppMethodBeat.i(148923);
      this.Hmc = new i();
      this.baY = false;
      this.hS = false;
      this.handler = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(263037);
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(263037);
            return;
            paramAnonymousMessage = f.b.this;
            Log.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering prepare]");
            if (paramAnonymousMessage.Hmc != null)
            {
              HashMap localHashMap = new HashMap();
              localHashMap.put("event", "preparing");
              paramAnonymousMessage.Hmc.success(localHashMap);
            }
          }
        }
      };
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer create %s", new Object[] { Integer.valueOf(hashCode()) });
      this.context = paramContext;
      this.eventChannel = paramEventChannel;
      this.textureEntry = paramSurfaceTextureEntry;
      this.Hmb = new d(paramContext, ah.v(new u(paramContext.getCacheDir() + "/flutter/MMVideo-" + paramString.hashCode() + ".mp4").jKT()));
      this.Hmb.setPath(paramString);
      paramEventChannel.setStreamHandler(new EventChannel.StreamHandler()
      {
        public final void onCancel(Object paramAnonymousObject)
        {
          AppMethodBeat.i(263035);
          f.b.this.Hmc.a(null);
          AppMethodBeat.o(263035);
        }
        
        public final void onListen(Object paramAnonymousObject, EventChannel.EventSink paramAnonymousEventSink)
        {
          AppMethodBeat.i(263028);
          f.b.this.Hmc.a(paramAnonymousEventSink);
          AppMethodBeat.o(263028);
        }
      });
      this.surface = new Surface(paramSurfaceTextureEntry.surfaceTexture());
      this.Hmb.setSurface(this.surface);
      this.Hmb.a(new a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(263050);
          super.e(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString1, paramAnonymousString2);
          if (f.b.this.Hmc != null)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("errorCode", Integer.valueOf(paramAnonymousInt1));
            localHashMap.put("errorType", Integer.valueOf(paramAnonymousInt2));
            localHashMap.put("errorMsg", paramAnonymousString1);
            localHashMap.put("errorActionDesc", paramAnonymousString2);
            f.b.this.Hmc.error(String.valueOf(paramAnonymousInt1), paramAnonymousString1, localHashMap);
          }
          AppMethodBeat.o(263050);
        }
        
        public final void onPlayerStateChanged(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          AppMethodBeat.i(263043);
          super.onPlayerStateChanged(paramAnonymousBoolean, paramAnonymousInt);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(263043);
            return;
            f.b.this.handler.sendEmptyMessageDelayed(1001, 500L);
            AppMethodBeat.o(263043);
            return;
            f.b.this.handler.removeMessages(1001);
            if (!f.b.this.baY)
            {
              f.b.this.baY = true;
              f.b localb = f.b.this;
              HashMap localHashMap;
              if (localb.baY)
              {
                localHashMap = new HashMap();
                localHashMap.put("event", "initialized");
                localHashMap.put("duration", Long.valueOf(localb.Hmb.getDurationMs()));
                localHashMap.put("width", Integer.valueOf(localb.Hmb.getWidth()));
                localHashMap.put("height", Integer.valueOf(localb.Hmb.getHeight()));
                localb.Hmc.success(localHashMap);
              }
              if (paramAnonymousBoolean)
              {
                f.b.this.Hmb.start();
                AppMethodBeat.o(263043);
                return;
                localb = f.b.this;
                if (localb.Hmc != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingUpdate");
                  localHashMap.put("values", Collections.singletonList(Arrays.asList(new Double[] { Double.valueOf(0.0D), Double.valueOf(localb.Hmb.getBufferedPercentage()) })));
                  localb.Hmc.success(localHashMap);
                }
                AppMethodBeat.o(263043);
                return;
                localb = f.b.this;
                Log.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering start]");
                if (localb.Hmc != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingStart");
                  localb.Hmc.success(localHashMap);
                }
                AppMethodBeat.o(263043);
                return;
                localb = f.b.this;
                Log.i("FlutterThumb", "[buffering end]");
                if (localb.Hmc != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "bufferingEnd");
                  localb.Hmc.success(localHashMap);
                }
                AppMethodBeat.o(263043);
                return;
                localb = f.b.this;
                Log.i("FlutterThumb", "[seek complete]");
                if (localb.Hmc != null)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "onSeekComplete");
                  localHashMap.put("position", Long.valueOf(localb.Hmb.getCurrentPosition()));
                  localb.Hmc.success(localHashMap);
                }
                AppMethodBeat.o(263043);
                return;
                localb = f.b.this;
                if (localb.baY)
                {
                  localHashMap = new HashMap();
                  localHashMap.put("event", "completed");
                  localb.Hmc.success(localHashMap);
                }
              }
            }
          }
        }
      });
      paramContext = new HashMap();
      paramContext.put("textureId", Long.valueOf(paramSurfaceTextureEntry.id()));
      paramResult.success(paramContext);
      AppMethodBeat.o(148923);
    }
    
    private void f(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(263085);
      if (this.Hmc != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("errorCode", Integer.valueOf(paramInt1));
        localHashMap.put("errorType", Integer.valueOf(paramInt2));
        localHashMap.put("errorMsg", paramString1);
        localHashMap.put("errorActionDesc", paramString2);
        this.Hmc.error(String.valueOf(paramInt1), paramString1, localHashMap);
      }
      AppMethodBeat.o(263085);
    }
    
    final void dispose()
    {
      AppMethodBeat.i(148924);
      Log.d("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer createOfDispose %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.baY) {
        this.Hmb.stop();
      }
      this.textureEntry.release();
      this.eventChannel.setStreamHandler(null);
      if ((this.surface != null) && (this.surface.isValid())) {
        this.surface.release();
      }
      if (this.Hmb != null) {
        this.Hmb.release();
      }
      AppMethodBeat.o(148924);
    }
    
    final String getVideoPath()
    {
      AppMethodBeat.i(263129);
      String str = this.Hmb.getVideoPath();
      AppMethodBeat.o(263129);
      return str;
    }
    
    final void pause()
    {
      AppMethodBeat.i(263108);
      Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer pause %s", new Object[] { Integer.valueOf(hashCode()) });
      this.Hmb.pause();
      AppMethodBeat.o(263108);
    }
    
    final void prepare()
    {
      AppMethodBeat.i(263100);
      this.Hmb.prepare();
      this.hS = true;
      AppMethodBeat.o(263100);
    }
    
    final void seekTo(int paramInt)
    {
      AppMethodBeat.i(263117);
      Log.i("MicroMsg.FlutterVideoPlayerPlugin", "VideoPlayer seekTo %s", new Object[] { Integer.valueOf(hashCode()) });
      this.Hmb.seek(paramInt);
      AppMethodBeat.o(263117);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.f
 * JD-Core Version:    0.7.0.1
 */
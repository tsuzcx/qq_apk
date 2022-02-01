package com.tencent.mm.flutter.b.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private MethodChannel channel;
  private FlutterPlugin.FlutterPluginBinding msv;
  private Class<? extends b> msw;
  private boolean msx;
  private final Map<Long, a> msy;
  
  public d()
  {
    AppMethodBeat.i(233266);
    this.msx = false;
    this.msy = new HashMap();
    AppMethodBeat.o(233266);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(233272);
    this.channel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "com.tencent.mm.flutter/videoPlayer");
    this.channel.setMethodCallHandler(this);
    this.msv = paramFlutterPluginBinding;
    AppMethodBeat.o(233272);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(233276);
    if (this.channel == null)
    {
      AppMethodBeat.o(233276);
      return;
    }
    this.channel.setMethodCallHandler(null);
    this.channel = null;
    paramFlutterPluginBinding = this.msy.values().iterator();
    while (paramFlutterPluginBinding.hasNext()) {
      ((a)paramFlutterPluginBinding.next()).dispose();
    }
    this.msy.clear();
    AppMethodBeat.o(233276);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    int j = 0;
    AppMethodBeat.i(233294);
    Object localObject1 = this.msv.getTextureRegistry();
    if (localObject1 == null)
    {
      paramResult.error("no_activity", "video_player plugin requires a foreground activity", null);
      AppMethodBeat.o(233294);
      return;
    }
    new StringBuilder("onMethodCall:").append(paramMethodCall.method);
    Object localObject2 = paramMethodCall.method;
    label92:
    int i;
    switch (((String)localObject2).hashCode())
    {
    default: 
      i = -1;
    }
    long l;
    for (;;)
    {
      switch (i)
      {
      default: 
        l = ((Number)paramMethodCall.argument("textureId")).longValue();
        localObject1 = (a)this.msy.get(Long.valueOf(l));
        if (localObject1 != null) {
          break label439;
        }
        paramResult.error("Unknown textureId", "No video player associated with texture id ".concat(String.valueOf(l)), null);
        AppMethodBeat.o(233294);
        return;
        if (!((String)localObject2).equals("init")) {
          break label92;
        }
        i = 0;
        continue;
        if (!((String)localObject2).equals("create")) {
          break label92;
        }
        i = 1;
      }
    }
    paramMethodCall = this.msy.values().iterator();
    while (paramMethodCall.hasNext()) {
      ((a)paramMethodCall.next()).dispose();
    }
    this.msy.clear();
    AppMethodBeat.o(233294);
    return;
    localObject1 = ((TextureRegistry)localObject1).createSurfaceTexture();
    localObject2 = new EventChannel(this.msv.getBinaryMessenger(), "com.tencent.mm.flutter/videoPlayer/videoEvents" + ((TextureRegistry.SurfaceTextureEntry)localObject1).id());
    if (paramMethodCall.argument("asset") != null)
    {
      paramMethodCall.argument("asset");
      this.msv.getApplicationContext();
      paramMethodCall = new a((EventChannel)localObject2, (TextureRegistry.SurfaceTextureEntry)localObject1, paramResult, this.msw);
      this.msy.put(Long.valueOf(((TextureRegistry.SurfaceTextureEntry)localObject1).id()), paramMethodCall);
      AppMethodBeat.o(233294);
      return;
    }
    this.msv.getApplicationContext();
    paramMethodCall.argument("uri");
    paramMethodCall = new a((EventChannel)localObject2, (TextureRegistry.SurfaceTextureEntry)localObject1, paramResult, this.msw);
    this.msy.put(Long.valueOf(((TextureRegistry.SurfaceTextureEntry)localObject1).id()), paramMethodCall);
    AppMethodBeat.o(233294);
    return;
    label439:
    localObject2 = paramMethodCall.method;
    switch (((String)localObject2).hashCode())
    {
    default: 
      label524:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramResult.notImplemented();
        AppMethodBeat.o(233294);
        return;
        if (!((String)localObject2).equals("setLooping")) {
          break label524;
        }
        i = j;
        continue;
        if (!((String)localObject2).equals("setVolume")) {
          break label524;
        }
        i = 1;
        continue;
        if (!((String)localObject2).equals("setOutputMute")) {
          break label524;
        }
        i = 2;
        continue;
        if (!((String)localObject2).equals("play")) {
          break label524;
        }
        i = 3;
        continue;
        if (!((String)localObject2).equals("pause")) {
          break label524;
        }
        i = 4;
        continue;
        if (!((String)localObject2).equals("seekTo")) {
          break label524;
        }
        i = 5;
        continue;
        if (!((String)localObject2).equals("position")) {
          break label524;
        }
        i = 6;
        continue;
        if (!((String)localObject2).equals("dispose")) {
          break label524;
        }
        i = 7;
      }
    }
    ((Boolean)paramMethodCall.argument("looping")).booleanValue();
    paramResult.success(null);
    AppMethodBeat.o(233294);
    return;
    Math.max(0.0D, Math.min(1.0D, ((Double)paramMethodCall.argument("volume")).doubleValue()));
    paramResult.success(null);
    AppMethodBeat.o(233294);
    return;
    ((Boolean)paramMethodCall.argument("outputMute")).booleanValue();
    paramResult.success(null);
    AppMethodBeat.o(233294);
    return;
    paramResult.success(null);
    AppMethodBeat.o(233294);
    return;
    paramResult.success(null);
    AppMethodBeat.o(233294);
    return;
    ((Number)paramMethodCall.argument("location")).intValue();
    this.msx = true;
    paramResult.success(null);
    AppMethodBeat.o(233294);
    return;
    paramResult.success(Long.valueOf(((a)localObject1).msz.getCurrentPosition()));
    AppMethodBeat.o(233294);
    return;
    ((a)localObject1).dispose();
    this.msy.remove(Long.valueOf(l));
    paramResult.success(null);
    AppMethodBeat.o(233294);
  }
  
  final class a
  {
    private boolean baY;
    private final EventChannel eventChannel;
    c msA;
    b msz;
    private Surface surface;
    private final TextureRegistry.SurfaceTextureEntry textureEntry;
    
    a(TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, MethodChannel.Result paramResult, Class<? extends b> paramClass)
    {
      AppMethodBeat.i(233264);
      this.msA = new c();
      this.baY = false;
      this.eventChannel = paramSurfaceTextureEntry;
      this.textureEntry = paramResult;
      try
      {
        Object localObject;
        this.msz = ((b)localObject.newInstance());
        paramSurfaceTextureEntry.setStreamHandler(new EventChannel.StreamHandler()
        {
          public final void onCancel(Object paramAnonymousObject)
          {
            AppMethodBeat.i(233262);
            d.a.this.msA.a(null);
            AppMethodBeat.o(233262);
          }
          
          public final void onListen(Object paramAnonymousObject, EventChannel.EventSink paramAnonymousEventSink)
          {
            AppMethodBeat.i(233259);
            d.a.this.msA.a(paramAnonymousEventSink);
            AppMethodBeat.o(233259);
          }
        });
        this.surface = new Surface(paramResult.surfaceTexture());
        new a() {};
        this$1 = new HashMap();
        d.this.put("textureId", Long.valueOf(paramResult.id()));
        paramClass.success(d.this);
        AppMethodBeat.o(233264);
        return;
      }
      catch (IllegalAccessException this$1)
      {
        new StringBuilder("clazz init fail:").append(d.this.toString());
        this$1 = new RuntimeException("video class is empty.");
        AppMethodBeat.o(233264);
        throw d.this;
      }
      catch (InstantiationException this$1)
      {
        new StringBuilder("clazz init fail:").append(d.this.toString());
        this$1 = new RuntimeException("video class is empty.");
        AppMethodBeat.o(233264);
        throw d.this;
      }
    }
    
    final void dispose()
    {
      AppMethodBeat.i(233268);
      this.textureEntry.release();
      this.eventChannel.setStreamHandler(null);
      if (this.surface != null) {
        this.surface.release();
      }
      AppMethodBeat.o(233268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.flutter.b.a.d
 * JD-Core Version:    0.7.0.1
 */
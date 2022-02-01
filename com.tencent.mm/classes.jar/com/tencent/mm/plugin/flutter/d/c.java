package com.tencent.mm.plugin.flutter.d;

import android.content.Context;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import io.flutter.a.a.d.a;
import io.flutter.a.a.d.c;
import io.flutter.a.a.j;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;
import io.flutter.a.a.m.c;
import io.flutter.a.a.m.f;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.f.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c
  implements k.c
{
  private final m.c rdH;
  final Map<Long, a> rdT;
  
  public c(m.c paramc)
  {
    AppMethodBeat.i(148925);
    this.rdH = paramc;
    this.rdT = new HashMap();
    AppMethodBeat.o(148925);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    int j = 0;
    AppMethodBeat.i(148926);
    Object localObject1 = this.rdH.IK();
    if (localObject1 == null)
    {
      paramd.a("no_activity", "video_player plugin requires a foreground activity", null);
      AppMethodBeat.o(148926);
      return;
    }
    Object localObject2 = paramj.method;
    switch (((String)localObject2).hashCode())
    {
    default: 
      label80:
      i = -1;
    }
    long l;
    for (;;)
    {
      switch (i)
      {
      default: 
        l = ((Number)paramj.qa("textureId")).longValue();
        localObject1 = (a)this.rdT.get(Long.valueOf(l));
        if (localObject1 != null) {
          break label490;
        }
        paramd.a("Unknown textureId", "No video player associated with texture id ".concat(String.valueOf(l)), null);
        AppMethodBeat.o(148926);
        return;
        if (!((String)localObject2).equals("init")) {
          break label80;
        }
        i = 0;
        continue;
        if (!((String)localObject2).equals("create")) {
          break label80;
        }
        i = 1;
      }
    }
    paramj = this.rdT.values().iterator();
    while (paramj.hasNext()) {
      ((a)paramj.next()).dispose();
    }
    this.rdT.clear();
    AppMethodBeat.o(148926);
    return;
    localObject1 = ((io.flutter.view.f)localObject1).fuS();
    localObject2 = new io.flutter.a.a.d(this.rdH.IJ(), "com.tencent.mm.flutter/videoPlayer/videoEvents" + ((f.a)localObject1).fuU());
    if (paramj.qa("asset") != null)
    {
      if (paramj.qa("package") != null) {}
      for (paramj = this.rdH.J((String)paramj.qa("asset"), (String)paramj.qa("package"));; paramj = this.rdH.dC((String)paramj.qa("asset")))
      {
        paramj = new a(this.rdH.II(), (io.flutter.a.a.d)localObject2, (f.a)localObject1, "asset:///".concat(String.valueOf(paramj)), paramd);
        this.rdT.put(Long.valueOf(((f.a)localObject1).fuU()), paramj);
        AppMethodBeat.o(148926);
        return;
      }
    }
    paramj = new a(this.rdH.II(), (io.flutter.a.a.d)localObject2, (f.a)localObject1, (String)paramj.qa("uri"), paramd);
    this.rdT.put(Long.valueOf(((f.a)localObject1).fuU()), paramj);
    AppMethodBeat.o(148926);
    return;
    label490:
    localObject2 = paramj.method;
    switch (((String)localObject2).hashCode())
    {
    default: 
      label568:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramd.Av();
        AppMethodBeat.o(148926);
        return;
        if (!((String)localObject2).equals("setLooping")) {
          break label568;
        }
        i = j;
        continue;
        if (!((String)localObject2).equals("setVolume")) {
          break label568;
        }
        i = 1;
        continue;
        if (!((String)localObject2).equals("play")) {
          break label568;
        }
        i = 2;
        continue;
        if (!((String)localObject2).equals("pause")) {
          break label568;
        }
        i = 3;
        continue;
        if (!((String)localObject2).equals("seekTo")) {
          break label568;
        }
        i = 4;
        continue;
        if (!((String)localObject2).equals("position")) {
          break label568;
        }
        i = 5;
        continue;
        if (!((String)localObject2).equals("dispose")) {
          break label568;
        }
        i = 6;
      }
    }
    boolean bool = ((Boolean)paramj.qa("looping")).booleanValue();
    ((a)localObject1).rdV.setLooping(bool);
    paramd.ay(null);
    AppMethodBeat.o(148926);
    return;
    float f = (float)Math.max(0.0D, Math.min(1.0D, ((Double)paramj.qa("volume")).doubleValue()));
    ((a)localObject1).rdV.v(f);
    paramd.ay(null);
    AppMethodBeat.o(148926);
    return;
    ((a)localObject1).rdV.start();
    paramd.ay(null);
    AppMethodBeat.o(148926);
    return;
    ((a)localObject1).rdV.pause();
    paramd.ay(null);
    AppMethodBeat.o(148926);
    return;
    int i = ((Number)paramj.qa("location")).intValue();
    ((a)localObject1).rdV.seek(i);
    paramd.ay(null);
    AppMethodBeat.o(148926);
    return;
    paramd.ay(Long.valueOf(((a)localObject1).rdV.getCurrentPosition()));
    AppMethodBeat.o(148926);
    return;
    ((a)localObject1).dispose();
    this.rdT.remove(Long.valueOf(l));
    paramd.ay(null);
    AppMethodBeat.o(148926);
  }
  
  static final class a
  {
    boolean isInitialized;
    d rdV;
    private final f.a rdW;
    f rdX;
    private final io.flutter.a.a.d rdY;
    private Surface surface;
    
    a(Context paramContext, io.flutter.a.a.d paramd, f.a parama, String paramString, k.d paramd1)
    {
      AppMethodBeat.i(148923);
      this.rdX = new f();
      this.isInitialized = false;
      ad.i("FlutterVideoPlayerPlugin", "VideoPlayer create %s", new Object[] { Integer.valueOf(hashCode()) });
      this.rdY = paramd;
      this.rdW = parama;
      this.rdV = new b(paramContext);
      this.rdV.setPath(paramString);
      paramd.a(new d.c()
      {
        public final void a(d.a paramAnonymousa)
        {
          AppMethodBeat.i(148920);
          c.a.this.rdX.b(paramAnonymousa);
          AppMethodBeat.o(148920);
        }
        
        public final void cuT()
        {
          AppMethodBeat.i(148921);
          c.a.this.rdX.b(null);
          AppMethodBeat.o(148921);
        }
      });
      this.surface = new Surface(parama.surfaceTexture());
      this.rdV.setSurface(this.surface);
      this.rdV.cuS();
      this.rdV.a(new a()
      {
        public final void e(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          AppMethodBeat.i(148922);
          super.e(paramAnonymousBoolean, paramAnonymousInt);
          Object localObject;
          if (paramAnonymousInt == 2)
          {
            localObject = new HashMap();
            ((Map)localObject).put("event", "bufferingUpdate");
            ((Map)localObject).put("values", Collections.singletonList(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(c.a.this.rdV.getBufferedPercentage()) })));
            c.a.this.rdX.ay(localObject);
            AppMethodBeat.o(148922);
            return;
          }
          if ((paramAnonymousInt == 3) && (!c.a.this.isInitialized))
          {
            c.a.this.isInitialized = true;
            localObject = c.a.this;
            if (((c.a)localObject).isInitialized)
            {
              HashMap localHashMap = new HashMap();
              localHashMap.put("event", "initialized");
              localHashMap.put("duration", Long.valueOf(((c.a)localObject).rdV.cuR()));
              localHashMap.put("width", Integer.valueOf(((c.a)localObject).rdV.getWidth()));
              localHashMap.put("height", Integer.valueOf(((c.a)localObject).rdV.getHeight()));
              ((c.a)localObject).rdX.ay(localHashMap);
            }
            if (paramAnonymousBoolean) {
              c.a.this.rdV.start();
            }
          }
          AppMethodBeat.o(148922);
        }
      });
      this.rdV.cuQ();
      paramContext = new HashMap();
      paramContext.put("textureId", Long.valueOf(parama.fuU()));
      paramd1.ay(paramContext);
      AppMethodBeat.o(148923);
    }
    
    final void dispose()
    {
      AppMethodBeat.i(148924);
      ad.i("FlutterVideoPlayerPlugin", "VideoPlayer dispose %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.isInitialized) {
        this.rdV.stop();
      }
      this.rdW.release();
      this.rdY.a(null);
      if (this.surface != null) {
        this.surface.release();
      }
      if (this.rdV != null) {
        this.rdV.release();
      }
      AppMethodBeat.o(148924);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.c
 * JD-Core Version:    0.7.0.1
 */
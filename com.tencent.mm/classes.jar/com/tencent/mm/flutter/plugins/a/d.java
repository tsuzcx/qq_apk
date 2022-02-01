package com.tencent.mm.flutter.plugins.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.embedding.engine.plugins.a.a;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.d.c;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.view.c.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d
  implements a, k.c
{
  private k aKT;
  private a.b jSe;
  private Class<? extends b> jSf;
  private final Map<Long, a> jSg;
  
  public d()
  {
    AppMethodBeat.i(207356);
    this.jSg = new HashMap();
    AppMethodBeat.o(207356);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(207353);
    this.aKT = new k(paramb.aaqF, "com.tencent.mm.flutter/videoPlayer");
    this.aKT.a(this);
    this.jSe = paramb;
    AppMethodBeat.o(207353);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    int j = 0;
    AppMethodBeat.i(207363);
    Object localObject1 = this.jSe.aarP;
    if (localObject1 == null)
    {
      paramd.b("no_activity", "video_player plugin requires a foreground activity", null);
      AppMethodBeat.o(207363);
      return;
    }
    new StringBuilder("onMethodCall:").append(paramj.method);
    Object localObject2 = paramj.method;
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
        l = ((Number)paramj.bGt("textureId")).longValue();
        localObject1 = (a)this.jSg.get(Long.valueOf(l));
        if (localObject1 != null) {
          break label491;
        }
        paramd.b("Unknown textureId", "No video player associated with texture id ".concat(String.valueOf(l)), null);
        AppMethodBeat.o(207363);
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
    paramj = this.jSg.values().iterator();
    while (paramj.hasNext()) {
      ((a)paramj.next()).dispose();
    }
    this.jSg.clear();
    AppMethodBeat.o(207363);
    return;
    localObject1 = ((io.flutter.view.c)localObject1).iBa();
    localObject2 = new io.flutter.plugin.a.d(this.jSe.aaqF, "com.tencent.mm.flutter/videoPlayer/videoEvents" + ((c.a)localObject1).dux());
    if (paramj.bGt("asset") != null)
    {
      if (paramj.bGt("package") != null) {}
      for (paramj = this.jSe.aarR.pl((String)paramj.bGt("asset"), (String)paramj.bGt("package"));; paramj = this.jSe.aarR.bGe((String)paramj.bGt("asset")))
      {
        "asset:///".concat(String.valueOf(paramj));
        paramj = new a((io.flutter.plugin.a.d)localObject2, (c.a)localObject1, paramd, this.jSf);
        this.jSg.put(Long.valueOf(((c.a)localObject1).dux()), paramj);
        AppMethodBeat.o(207363);
        return;
      }
    }
    paramj.bGt("uri");
    paramj = new a((io.flutter.plugin.a.d)localObject2, (c.a)localObject1, paramd, this.jSf);
    this.jSg.put(Long.valueOf(((c.a)localObject1).dux()), paramj);
    AppMethodBeat.o(207363);
    return;
    label491:
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
        paramd.epZ();
        AppMethodBeat.o(207363);
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
    ((Boolean)paramj.bGt("looping")).booleanValue();
    paramd.bb(null);
    AppMethodBeat.o(207363);
    return;
    Math.max(0.0D, Math.min(1.0D, ((Double)paramj.bGt("volume")).doubleValue()));
    paramd.bb(null);
    AppMethodBeat.o(207363);
    return;
    paramd.bb(null);
    AppMethodBeat.o(207363);
    return;
    paramd.bb(null);
    AppMethodBeat.o(207363);
    return;
    ((Number)paramj.bGt("location")).intValue();
    paramd.bb(null);
    AppMethodBeat.o(207363);
    return;
    paramd.bb(Long.valueOf(((a)localObject1).jSh.getCurrentPosition()));
    AppMethodBeat.o(207363);
    return;
    ((a)localObject1).dispose();
    this.jSg.remove(Long.valueOf(l));
    paramd.bb(null);
    AppMethodBeat.o(207363);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(207354);
    if (this.aKT == null)
    {
      AppMethodBeat.o(207354);
      return;
    }
    this.aKT.a(null);
    this.aKT = null;
    paramb = this.jSg.values().iterator();
    while (paramb.hasNext()) {
      ((a)paramb.next()).dispose();
    }
    this.jSg.clear();
    AppMethodBeat.o(207354);
  }
  
  final class a
  {
    private final io.flutter.plugin.a.d aKU;
    private boolean isInitialized;
    b jSh;
    private final c.a jSi;
    c jSj;
    private Surface surface;
    
    a(c.a parama, k.d paramd, Class<? extends b> paramClass)
    {
      AppMethodBeat.i(207334);
      this.jSj = new c();
      this.isInitialized = false;
      this.aKU = parama;
      this.jSi = paramd;
      try
      {
        Object localObject;
        this.jSh = ((b)localObject.newInstance());
        parama.a(new d.c()
        {
          public final void a(io.flutter.plugin.a.d.a paramAnonymousa)
          {
            AppMethodBeat.i(207309);
            d.a.this.jSj.b(paramAnonymousa);
            AppMethodBeat.o(207309);
          }
          
          public final void qH()
          {
            AppMethodBeat.i(207312);
            d.a.this.jSj.b(null);
            AppMethodBeat.o(207312);
          }
        });
        this.surface = new Surface(paramd.surfaceTexture());
        new d.a.2(this);
        this$1 = new HashMap();
        d.this.put("textureId", Long.valueOf(paramd.dux()));
        paramClass.bb(d.this);
        AppMethodBeat.o(207334);
        return;
      }
      catch (IllegalAccessException this$1)
      {
        new StringBuilder("clazz init fail:").append(d.this.toString());
        this$1 = new RuntimeException("video class is empty. please add VideoPlayerPlugin with clazz in WxaLiteApp.Config.");
        AppMethodBeat.o(207334);
        throw d.this;
      }
      catch (InstantiationException this$1)
      {
        new StringBuilder("clazz init fail:").append(d.this.toString());
        this$1 = new RuntimeException("video class is empty. please add VideoPlayerPlugin with clazz in WxaLiteApp.Config.");
        AppMethodBeat.o(207334);
        throw d.this;
      }
    }
    
    final void dispose()
    {
      AppMethodBeat.i(207335);
      this.jSi.release();
      this.aKU.a(null);
      if (this.surface != null) {
        this.surface.release();
      }
      AppMethodBeat.o(207335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.flutter.plugins.a.d
 * JD-Core Version:    0.7.0.1
 */
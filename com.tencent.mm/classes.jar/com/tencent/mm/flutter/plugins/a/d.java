package com.tencent.mm.flutter.plugins.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  implements io.flutter.embedding.engine.plugins.a, k.c
{
  private k bbv;
  private a.b hgm;
  private final Map<Long, a> hgn;
  
  public d()
  {
    AppMethodBeat.i(199143);
    this.hgn = new HashMap();
    AppMethodBeat.o(199143);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(199141);
    this.bbv = new k(paramb.SOH, "com.tencent.mm.flutter/videoPlayer");
    this.bbv.a(this);
    AppMethodBeat.o(199141);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    int j = 0;
    AppMethodBeat.i(199144);
    Object localObject1 = this.hgm.StA;
    if (localObject1 == null)
    {
      paramd.b("no_activity", "video_player plugin requires a foreground activity", null);
      AppMethodBeat.o(199144);
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
        l = ((Number)paramj.btq("textureId")).longValue();
        localObject1 = (a)this.hgn.get(Long.valueOf(l));
        if (localObject1 != null) {
          break label496;
        }
        paramd.b("Unknown textureId", "No video player associated with texture id ".concat(String.valueOf(l)), null);
        AppMethodBeat.o(199144);
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
    paramj = this.hgn.values().iterator();
    while (paramj.hasNext()) {
      ((a)paramj.next()).dispose();
    }
    this.hgn.clear();
    AppMethodBeat.o(199144);
    return;
    localObject1 = ((io.flutter.view.c)localObject1).hwY();
    localObject2 = new io.flutter.plugin.a.d(this.hgm.SOH, "com.tencent.mm.flutter/videoPlayer/videoEvents" + ((c.a)localObject1).hxb());
    String str = (String)paramj.btq("clazz");
    if (paramj.btq("asset") != null)
    {
      if (paramj.btq("package") != null) {}
      for (paramj = this.hgm.SPB.op((String)paramj.btq("asset"), (String)paramj.btq("package"));; paramj = this.hgm.SPB.btc((String)paramj.btq("asset")))
      {
        "asset:///".concat(String.valueOf(paramj));
        paramj = new a((io.flutter.plugin.a.d)localObject2, (c.a)localObject1, paramd, str);
        this.hgn.put(Long.valueOf(((c.a)localObject1).hxb()), paramj);
        AppMethodBeat.o(199144);
        return;
      }
    }
    paramj.btq("uri");
    paramj = new a((io.flutter.plugin.a.d)localObject2, (c.a)localObject1, paramd, str);
    this.hgn.put(Long.valueOf(((c.a)localObject1).hxb()), paramj);
    AppMethodBeat.o(199144);
    return;
    label496:
    localObject2 = paramj.method;
    switch (((String)localObject2).hashCode())
    {
    default: 
      label572:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramd.dLv();
        AppMethodBeat.o(199144);
        return;
        if (!((String)localObject2).equals("setLooping")) {
          break label572;
        }
        i = j;
        continue;
        if (!((String)localObject2).equals("setVolume")) {
          break label572;
        }
        i = 1;
        continue;
        if (!((String)localObject2).equals("play")) {
          break label572;
        }
        i = 2;
        continue;
        if (!((String)localObject2).equals("pause")) {
          break label572;
        }
        i = 3;
        continue;
        if (!((String)localObject2).equals("seekTo")) {
          break label572;
        }
        i = 4;
        continue;
        if (!((String)localObject2).equals("position")) {
          break label572;
        }
        i = 5;
        continue;
        if (!((String)localObject2).equals("dispose")) {
          break label572;
        }
        i = 6;
      }
    }
    ((Boolean)paramj.btq("looping")).booleanValue();
    paramd.ba(null);
    AppMethodBeat.o(199144);
    return;
    Math.max(0.0D, Math.min(1.0D, ((Double)paramj.btq("volume")).doubleValue()));
    paramd.ba(null);
    AppMethodBeat.o(199144);
    return;
    paramd.ba(null);
    AppMethodBeat.o(199144);
    return;
    paramd.ba(null);
    AppMethodBeat.o(199144);
    return;
    ((Number)paramj.btq("location")).intValue();
    paramd.ba(null);
    AppMethodBeat.o(199144);
    return;
    paramd.ba(Long.valueOf(((a)localObject1).hgo.getCurrentPosition()));
    AppMethodBeat.o(199144);
    return;
    ((a)localObject1).dispose();
    this.hgn.remove(Long.valueOf(l));
    paramd.ba(null);
    AppMethodBeat.o(199144);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(199142);
    this.bbv.a(null);
    this.bbv = null;
    paramb = this.hgn.values().iterator();
    while (paramb.hasNext()) {
      ((a)paramb.next()).dispose();
    }
    this.hgn.clear();
    AppMethodBeat.o(199142);
  }
  
  static final class a
  {
    private final io.flutter.plugin.a.d bbw;
    b hgo;
    private final c.a hgp;
    c hgq;
    private boolean isInitialized;
    private Surface surface;
    
    a(io.flutter.plugin.a.d paramd, c.a parama, k.d paramd1, String paramString)
    {
      AppMethodBeat.i(199139);
      this.hgq = new c();
      this.isInitialized = false;
      this.bbw = paramd;
      this.hgp = parama;
      try
      {
        this.hgo = ((b)Class.forName(paramString).newInstance());
        label50:
        paramd.a(new d.c()
        {
          public final void a(Object paramAnonymousObject, io.flutter.plugin.a.d.a paramAnonymousa)
          {
            AppMethodBeat.i(199137);
            d.a.this.hgq.a(paramAnonymousa);
            AppMethodBeat.o(199137);
          }
          
          public final void sT()
          {
            AppMethodBeat.i(199138);
            d.a.this.hgq.a(null);
            AppMethodBeat.o(199138);
          }
        });
        this.surface = new Surface(parama.surfaceTexture());
        new a() {};
        paramd = new HashMap();
        paramd.put("textureId", Long.valueOf(parama.hxb()));
        paramd1.ba(paramd);
        AppMethodBeat.o(199139);
        return;
      }
      catch (Exception paramString)
      {
        break label50;
      }
      catch (ClassNotFoundException paramString)
      {
        break label50;
      }
    }
    
    final void dispose()
    {
      AppMethodBeat.i(199140);
      this.hgp.release();
      this.bbw.a(null);
      if (this.surface != null) {
        this.surface.release();
      }
      AppMethodBeat.o(199140);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.flutter.plugins.a.d
 * JD-Core Version:    0.7.0.1
 */
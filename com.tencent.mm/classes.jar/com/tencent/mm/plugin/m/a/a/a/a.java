package com.tencent.mm.plugin.m.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.b.p;
import d.l;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService;", "", "()V", "channels", "", "", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder;", "channelsHandlerWrappers", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodCallHandlerDelegate;", "value", "Lio/flutter/plugin/common/BinaryMessenger;", "messenger", "getMessenger", "()Lio/flutter/plugin/common/BinaryMessenger;", "setMessenger", "(Lio/flutter/plugin/common/BinaryMessenger;)V", "pendingChannels", "", "pendingChannelsHandler", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "innerSetChannelHandler", "", "name", "handler", "invokeMethod", "method", "arguments", "callback", "Lio/flutter/plugin/common/MethodChannel$Result;", "newMethodChannel", "registerChannel", "setChannelHandler", "ChannelCallback", "Companion", "MethodCallHandlerDelegate", "MethodChannelHolder", "luggage-native-view_release"})
public final class a
{
  private static final a vOm;
  public static final a.b vOn;
  public final Map<String, d> vOh;
  public final List<String> vOi;
  public final Map<String, k.c> vOj;
  private final Map<String, c> vOk;
  public c vOl;
  
  static
  {
    AppMethodBeat.i(123825);
    vOn = new a.b((byte)0);
    vOm = new a();
    AppMethodBeat.o(123825);
  }
  
  public a()
  {
    AppMethodBeat.i(123824);
    this.vOh = ((Map)new LinkedHashMap());
    this.vOi = ((List)new ArrayList());
    this.vOj = ((Map)new LinkedHashMap());
    this.vOk = ((Map)new LinkedHashMap());
    AppMethodBeat.o(123824);
  }
  
  private void h(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(123823);
    p.h(paramString1, "name");
    p.h(paramString2, "method");
    d locald = (d)this.vOh.get(paramString1);
    if (locald != null)
    {
      locald.a(paramString2, paramObject, (k.d)new a.a(paramString1 + '$' + paramString2));
      AppMethodBeat.o(123823);
      return;
    }
    AppMethodBeat.o(123823);
  }
  
  public final void a(String paramString, k.c paramc)
  {
    AppMethodBeat.i(123821);
    d locald = (d)this.vOh.get(paramString);
    if (locald != null)
    {
      paramString = (c)this.vOk.get(paramString);
      if (paramString != null)
      {
        paramString.vOo = paramc;
        locald.a((k.c)paramString);
        AppMethodBeat.o(123821);
        return;
      }
      AppMethodBeat.o(123821);
      return;
    }
    AppMethodBeat.o(123821);
  }
  
  public final void aqm(String paramString)
  {
    AppMethodBeat.i(123820);
    d locald = new d(new k(this.vOl, paramString));
    this.vOh.put(paramString, locald);
    this.vOk.put(paramString, new c(locald));
    locald = (d)this.vOh.get(paramString);
    if (locald != null)
    {
      locald.a((k.c)this.vOk.get(paramString));
      AppMethodBeat.o(123820);
      return;
    }
    AppMethodBeat.o(123820);
  }
  
  public final void g(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(123822);
    p.h(paramString1, "name");
    p.h(paramString2, "method");
    h(paramString1, paramString2, paramObject);
    AppMethodBeat.o(123822);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodCallHandlerDelegate;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "channel", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder;", "(Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder;)V", "handler", "getHandler", "()Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "setHandler", "(Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;)V", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "luggage-native-view_release"})
  static final class c
    implements k.c
  {
    k.c vOo;
    private final a.d vOp;
    
    public c(a.d paramd)
    {
      AppMethodBeat.i(123814);
      this.vOp = paramd;
      AppMethodBeat.o(123814);
    }
    
    public final void a(j paramj, k.d paramd)
    {
      AppMethodBeat.i(123813);
      p.h(paramj, "call");
      p.h(paramd, "result");
      Object localObject = paramj.method;
      if (localObject == null) {}
      do
      {
        for (;;)
        {
          localObject = this.vOo;
          if (localObject == null) {
            break;
          }
          ((k.c)localObject).a(paramj, paramd);
          AppMethodBeat.o(123813);
          return;
          switch (((String)localObject).hashCode())
          {
          }
        }
      } while (!((String)localObject).equals("onDartChannelReady"));
      paramj = this.vOp;
      paramj.bWM = true;
      paramd = paramj.vOq.iterator();
      while (paramd.hasNext())
      {
        localObject = (a.d.a)paramd.next();
        paramj.vOr.a(((a.d.a)localObject).method, ((a.d.a)localObject).gtF, ((a.d.a)localObject).vOs);
      }
      paramj.vOq.clear();
      AppMethodBeat.o(123813);
      return;
      AppMethodBeat.o(123813);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder;", "", "channel", "Lio/flutter/plugin/common/MethodChannel;", "(Lio/flutter/plugin/common/MethodChannel;)V", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "isReady", "", "pendingInvokeRequests", "", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder$InvokeRequest;", "kotlin.jvm.PlatformType", "", "invokeMethod", "", "method", "", "arguments", "callback", "Lio/flutter/plugin/common/MethodChannel$Result;", "notifyChannelReady", "setMethodCallHandler", "handler", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "InvokeRequest", "luggage-native-view_release"})
  public static final class d
  {
    boolean bWM;
    final List<a> vOq;
    final k vOr;
    
    public d(k paramk)
    {
      AppMethodBeat.i(123819);
      this.vOr = paramk;
      this.vOq = Collections.synchronizedList((List)new ArrayList());
      AppMethodBeat.o(123819);
    }
    
    public final void a(k.c paramc)
    {
      AppMethodBeat.i(123818);
      this.vOr.a(paramc);
      AppMethodBeat.o(123818);
    }
    
    public final void a(final String paramString, final Object paramObject, final k.d paramd)
    {
      AppMethodBeat.i(123817);
      p.h(paramString, "method");
      if (!ar.isMainThread())
      {
        ar.f((Runnable)new b(this, paramString, paramObject, paramd));
        AppMethodBeat.o(123817);
        return;
      }
      if (this.bWM)
      {
        this.vOr.a(paramString, paramObject, paramd);
        AppMethodBeat.o(123817);
        return;
      }
      this.vOq.add(new a(paramString, paramObject, paramd));
      AppMethodBeat.o(123817);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder$InvokeRequest;", "", "method", "", "arguments", "callback", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Ljava/lang/String;Ljava/lang/Object;Lio/flutter/plugin/common/MethodChannel$Result;)V", "getArguments", "()Ljava/lang/Object;", "getCallback", "()Lio/flutter/plugin/common/MethodChannel$Result;", "getMethod", "()Ljava/lang/String;", "luggage-native-view_release"})
    public static final class a
    {
      final Object gtF;
      final String method;
      final k.d vOs;
      
      public a(String paramString, Object paramObject, k.d paramd)
      {
        AppMethodBeat.i(123815);
        this.method = paramString;
        this.gtF = paramObject;
        this.vOs = paramd;
        AppMethodBeat.o(123815);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.d paramd, String paramString, Object paramObject, k.d paramd1) {}
      
      public final void run()
      {
        AppMethodBeat.i(123816);
        this.vOt.a(paramString, paramObject, paramd);
        AppMethodBeat.o(123816);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */
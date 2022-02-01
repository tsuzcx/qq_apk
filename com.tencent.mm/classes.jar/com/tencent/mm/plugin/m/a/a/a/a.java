package com.tencent.mm.plugin.m.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import d.l;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService;", "", "()V", "channels", "", "", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder;", "channelsHandlerWrappers", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodCallHandlerDelegate;", "value", "Lio/flutter/plugin/common/BinaryMessenger;", "messenger", "getMessenger", "()Lio/flutter/plugin/common/BinaryMessenger;", "setMessenger", "(Lio/flutter/plugin/common/BinaryMessenger;)V", "pendingChannels", "", "pendingChannelsHandler", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "innerSetChannelHandler", "", "name", "handler", "invokeMethod", "method", "arguments", "callback", "Lio/flutter/plugin/common/MethodChannel$Result;", "newMethodChannel", "registerChannel", "setChannelHandler", "ChannelCallback", "Companion", "MethodCallHandlerDelegate", "MethodChannelHolder", "luggage-native-view_release"})
public final class a
{
  private static final a uzF;
  public static final b uzG;
  public final Map<String, d> uzA;
  public final List<String> uzB;
  public final Map<String, k.c> uzC;
  private final Map<String, c> uzD;
  public c uzE;
  
  static
  {
    AppMethodBeat.i(123825);
    uzG = new b((byte)0);
    uzF = new a();
    AppMethodBeat.o(123825);
  }
  
  public a()
  {
    AppMethodBeat.i(123824);
    this.uzA = ((Map)new LinkedHashMap());
    this.uzB = ((List)new ArrayList());
    this.uzC = ((Map)new LinkedHashMap());
    this.uzD = ((Map)new LinkedHashMap());
    AppMethodBeat.o(123824);
  }
  
  private void g(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(123823);
    d.g.b.k.h(paramString1, "name");
    d.g.b.k.h(paramString2, "method");
    d locald = (d)this.uzA.get(paramString1);
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
    d locald = (d)this.uzA.get(paramString);
    if (locald != null)
    {
      paramString = (c)this.uzD.get(paramString);
      if (paramString != null)
      {
        paramString.uzH = paramc;
        locald.a((k.c)paramString);
        AppMethodBeat.o(123821);
        return;
      }
      AppMethodBeat.o(123821);
      return;
    }
    AppMethodBeat.o(123821);
  }
  
  public final void aku(String paramString)
  {
    AppMethodBeat.i(123820);
    d locald = new d(new io.flutter.plugin.a.k(this.uzE, paramString));
    this.uzA.put(paramString, locald);
    this.uzD.put(paramString, new c(locald));
    locald = (d)this.uzA.get(paramString);
    if (locald != null)
    {
      locald.a((k.c)this.uzD.get(paramString));
      AppMethodBeat.o(123820);
      return;
    }
    AppMethodBeat.o(123820);
  }
  
  public final void f(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(123822);
    d.g.b.k.h(paramString1, "name");
    d.g.b.k.h(paramString2, "method");
    g(paramString1, paramString2, paramObject);
    AppMethodBeat.o(123822);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService;", "getInstance", "()Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService;", "luggage-native-view_release"})
  public static final class b {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodCallHandlerDelegate;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "channel", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder;", "(Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder;)V", "handler", "getHandler", "()Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "setHandler", "(Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;)V", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "luggage-native-view_release"})
  static final class c
    implements k.c
  {
    k.c uzH;
    private final a.d uzI;
    
    public c(a.d paramd)
    {
      AppMethodBeat.i(123814);
      this.uzI = paramd;
      AppMethodBeat.o(123814);
    }
    
    public final void a(j paramj, k.d paramd)
    {
      AppMethodBeat.i(123813);
      d.g.b.k.h(paramj, "call");
      d.g.b.k.h(paramd, "result");
      Object localObject = paramj.method;
      if (localObject == null) {}
      do
      {
        for (;;)
        {
          localObject = this.uzH;
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
      paramj = this.uzI;
      paramj.bMz = true;
      paramd = paramj.uzJ.iterator();
      while (paramd.hasNext())
      {
        localObject = (a.d.a)paramd.next();
        paramj.uzK.a(((a.d.a)localObject).method, ((a.d.a)localObject).fXJ, ((a.d.a)localObject).uzL);
      }
      paramj.uzJ.clear();
      AppMethodBeat.o(123813);
      return;
      AppMethodBeat.o(123813);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder;", "", "channel", "Lio/flutter/plugin/common/MethodChannel;", "(Lio/flutter/plugin/common/MethodChannel;)V", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "isReady", "", "pendingInvokeRequests", "", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder$InvokeRequest;", "kotlin.jvm.PlatformType", "", "invokeMethod", "", "method", "", "arguments", "callback", "Lio/flutter/plugin/common/MethodChannel$Result;", "notifyChannelReady", "setMethodCallHandler", "handler", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "InvokeRequest", "luggage-native-view_release"})
  public static final class d
  {
    boolean bMz;
    final List<a> uzJ;
    final io.flutter.plugin.a.k uzK;
    
    public d(io.flutter.plugin.a.k paramk)
    {
      AppMethodBeat.i(123819);
      this.uzK = paramk;
      this.uzJ = Collections.synchronizedList((List)new ArrayList());
      AppMethodBeat.o(123819);
    }
    
    public final void a(k.c paramc)
    {
      AppMethodBeat.i(123818);
      this.uzK.a(paramc);
      AppMethodBeat.o(123818);
    }
    
    public final void a(final String paramString, final Object paramObject, final k.d paramd)
    {
      AppMethodBeat.i(123817);
      d.g.b.k.h(paramString, "method");
      if (!ap.isMainThread())
      {
        ap.f((Runnable)new b(this, paramString, paramObject, paramd));
        AppMethodBeat.o(123817);
        return;
      }
      if (this.bMz)
      {
        this.uzK.a(paramString, paramObject, paramd);
        AppMethodBeat.o(123817);
        return;
      }
      this.uzJ.add(new a(paramString, paramObject, paramd));
      AppMethodBeat.o(123817);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$MethodChannelHolder$InvokeRequest;", "", "method", "", "arguments", "callback", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Ljava/lang/String;Ljava/lang/Object;Lio/flutter/plugin/common/MethodChannel$Result;)V", "getArguments", "()Ljava/lang/Object;", "getCallback", "()Lio/flutter/plugin/common/MethodChannel$Result;", "getMethod", "()Ljava/lang/String;", "luggage-native-view_release"})
    public static final class a
    {
      final Object fXJ;
      final String method;
      final k.d uzL;
      
      public a(String paramString, Object paramObject, k.d paramd)
      {
        AppMethodBeat.i(123815);
        this.method = paramString;
        this.fXJ = paramObject;
        this.uzL = paramd;
        AppMethodBeat.o(123815);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.d paramd, String paramString, Object paramObject, k.d paramd1) {}
      
      public final void run()
      {
        AppMethodBeat.i(123816);
        this.uzM.a(paramString, paramObject, paramd);
        AppMethodBeat.o(123816);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */
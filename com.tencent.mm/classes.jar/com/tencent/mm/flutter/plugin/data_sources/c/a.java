package com.tencent.mm.flutter.plugin.data_sources.c;

import com.tencent.c.c.a;
import com.tencent.c.c.c;
import com.tencent.c.c.d;
import com.tencent.c.c.e;
import com.tencent.c.c.l;
import com.tencent.c.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/plugins/FlutterPluginFinderDataSource;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$FinderDataSource;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getImageFile", "", "request", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$GetFinderImageFileRequest;", "result", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$Result;", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$GetFinderImageFileResponse;", "getLatestFinders", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$GetFindersRequest;", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$ProtoBuffer;", "onAttachedToEngine", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "Companion", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c.a
  implements FlutterPlugin
{
  public static final a.a mrw;
  private final aq coroutineScope;
  
  static
  {
    AppMethodBeat.i(233357);
    mrw = new a.a((byte)0);
    AppMethodBeat.o(233357);
  }
  
  public a()
  {
    AppMethodBeat.i(233350);
    this.coroutineScope = ar.kBZ();
    AppMethodBeat.o(233350);
  }
  
  public final void a(c.c paramc, final c.m<c.d> paramm)
  {
    AppMethodBeat.i(233385);
    s.u(paramc, "request");
    s.u(paramm, "result");
    j.a(this.coroutineScope, null, null, (m)new b(paramc, paramm, null), 3);
    AppMethodBeat.o(233385);
  }
  
  public final void a(final c.e parame, final c.m<c.l> paramm)
  {
    AppMethodBeat.i(233377);
    s.u(parame, "request");
    s.u(paramm, "result");
    String str = parame.username;
    parame = parame.ahhz;
    Log.i("MicroMsg.FlutterPluginFinderDataSource", "getLatestFinders(" + str + ", " + parame + ')');
    j.a(this.coroutineScope, null, null, (m)new c(str, parame, paramm, null), 3);
    AppMethodBeat.o(233377);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(233362);
    s.u(paramFlutterPluginBinding, "binding");
    Log.i("MicroMsg.FlutterPluginFinderDataSource", "onAttachedToEngine");
    c.a.a(paramFlutterPluginBinding.getBinaryMessenger(), (c.a)this);
    AppMethodBeat.o(233362);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(233369);
    s.u(paramFlutterPluginBinding, "binding");
    Log.i("MicroMsg.FlutterPluginFinderDataSource", "onDetachedFromEngine");
    ar.a(this.coroutineScope, null);
    AppMethodBeat.o(233369);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(c.c paramc, c.m<c.d> paramm, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(233388);
      paramObject = (kotlin.d.d)new b(this.mrx, paramm, paramd);
      AppMethodBeat.o(233388);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(233374);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(233374);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        new com.tencent.mm.flutter.plugin.data_sources.b.a();
        paramObject = this.mrx.username;
        s.s(paramObject, "request.username");
        Object localObject1 = this.mrx.url;
        s.s(localObject1, "request.url");
        String str1 = this.mrx.msf;
        s.s(str1, "request.urlToken");
        String str2 = this.mrx.decodeKey;
        s.s(str2, "request.decodeKey");
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        paramObject = com.tencent.mm.flutter.plugin.data_sources.b.a.a(paramObject, (String)localObject1, str1, str2, locald);
        localObject1 = paramObject;
        if (paramObject == localObject2)
        {
          AppMethodBeat.o(233374);
          return localObject2;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        localObject2 = (String)localObject1;
        paramObject = paramm;
        localObject1 = new c.d();
        ((c.d)localObject1).path = ((String)localObject2);
        localObject2 = ah.aiuX;
        paramObject.success(localObject1);
        paramObject = ah.aiuX;
        AppMethodBeat.o(233374);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        paramm.D((Throwable)paramObject);
        paramObject = ah.aiuX;
        AppMethodBeat.o(233374);
      }
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(String paramString, Long paramLong, c.m<c.l> paramm, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(233373);
      paramObject = (kotlin.d.d)new c(this.mrr, parame, paramm, paramd);
      AppMethodBeat.o(233373);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(233366);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(233366);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = new com.tencent.mm.flutter.plugin.data_sources.b.a();
        Object localObject1 = this.mrr;
        s.s(localObject1, "username");
        Object localObject2 = parame;
        s.s(localObject2, "timeLimit");
        long l = ((Number)localObject2).longValue();
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        paramObject = paramObject.a((String)localObject1, l, (kotlin.d.d)localObject2);
        localObject1 = paramObject;
        if (paramObject == locala)
        {
          AppMethodBeat.o(233366);
          return locala;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        paramObject = (com.tencent.mm.flutter.plugin.a.d)localObject1;
        localObject1 = new c.l();
        ((c.l)localObject1).buffer = paramObject.toByteArray();
        paramm.success(localObject1);
        paramObject = ah.aiuX;
        AppMethodBeat.o(233366);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        paramm.D((Throwable)paramObject);
        paramObject = ah.aiuX;
        AppMethodBeat.o(233366);
      }
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.c.a
 * JD-Core Version:    0.7.0.1
 */
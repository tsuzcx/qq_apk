package com.tencent.mm.flutter.plugin.data_sources.c;

import com.tencent.c.c.i;
import com.tencent.c.c.j;
import com.tencent.c.c.k;
import com.tencent.c.c.l;
import com.tencent.c.c.m;
import com.tencent.c.c.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.flutter.plugin.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/plugins/FlutterPluginTextStatusDataSource;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$TextStatusDataSource;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getImageFile", "", "request", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$GetTextStatusImageFileRequest;", "result", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$Result;", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$GetTextStatusImageFileResponse;", "getTextStatus", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$GetTextStatusRequest;", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$ProtoBuffer;", "onAttachedToEngine", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "Companion", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends c.p
  implements FlutterPlugin
{
  public static final c.a mrC;
  private final aq coroutineScope;
  
  static
  {
    AppMethodBeat.i(233358);
    mrC = new c.a((byte)0);
    AppMethodBeat.o(233358);
  }
  
  public c()
  {
    AppMethodBeat.i(233353);
    this.coroutineScope = ar.kBZ();
    AppMethodBeat.o(233353);
  }
  
  public final void a(c.i parami, final c.m<c.j> paramm)
  {
    AppMethodBeat.i(233386);
    s.u(parami, "request");
    s.u(paramm, "result");
    j.a(this.coroutineScope, null, null, (m)new b(parami, paramm, null), 3);
    AppMethodBeat.o(233386);
  }
  
  public final void a(c.k paramk, final c.m<c.l> paramm)
  {
    AppMethodBeat.i(233376);
    s.u(paramk, "request");
    s.u(paramm, "result");
    paramk = paramk.username;
    Log.i("MicroMsg.FlutterPluginTextStatusDataSource", "getTextStatus(" + paramk + ')');
    j.a(this.coroutineScope, null, null, (m)new c(paramk, paramm, null), 3);
    AppMethodBeat.o(233376);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(233363);
    s.u(paramFlutterPluginBinding, "binding");
    c.p.a(paramFlutterPluginBinding.getBinaryMessenger(), (c.p)this);
    AppMethodBeat.o(233363);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(233370);
    s.u(paramFlutterPluginBinding, "binding");
    ar.a(this.coroutineScope, null);
    AppMethodBeat.o(233370);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(c.i parami, c.m<c.j> paramm, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(233355);
      paramObject = (d)new b(this.mrD, paramm, paramd);
      AppMethodBeat.o(233355);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(233345);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(233345);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        new com.tencent.mm.flutter.plugin.data_sources.e.a();
        paramObject = this.mrD.username;
        s.s(paramObject, "request.username");
        Object localObject1 = this.mrD.url;
        s.s(localObject1, "request.url");
        String str = this.mrD.Tly;
        s.s(str, "request.statusId");
        d locald = (d)this;
        this.label = 1;
        paramObject = com.tencent.mm.flutter.plugin.data_sources.e.a.a(paramObject, (String)localObject1, str, locald);
        localObject1 = paramObject;
        if (paramObject == localObject2)
        {
          AppMethodBeat.o(233345);
          return localObject2;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        localObject2 = (String)localObject1;
        paramObject = paramm;
        localObject1 = new c.j();
        ((c.j)localObject1).path = ((String)localObject2);
        localObject2 = ah.aiuX;
        paramObject.success(localObject1);
        paramObject = ah.aiuX;
        AppMethodBeat.o(233345);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        Log.w("MicroMsg.FlutterPluginTextStatusDataSource", s.X("Failed to get image file: ", paramObject));
        paramm.D((Throwable)paramObject);
        paramObject = ah.aiuX;
        AppMethodBeat.o(233345);
      }
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    c(String paramString, c.m<c.l> paramm, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(233347);
      paramObject = (d)new c(this.mrr, paramm, paramd);
      AppMethodBeat.o(233347);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(233342);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(233342);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        new com.tencent.mm.flutter.plugin.data_sources.e.a();
        paramObject = this.mrr;
        s.s(paramObject, "username");
        Object localObject1 = (d)this;
        this.label = 1;
        paramObject = com.tencent.mm.flutter.plugin.data_sources.e.a.a(paramObject, (d)localObject1);
        localObject1 = paramObject;
        if (paramObject == localObject2)
        {
          AppMethodBeat.o(233342);
          return localObject2;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        localObject2 = (f)localObject1;
        paramObject = paramm;
        localObject1 = new c.l();
        ((c.l)localObject1).buffer = ((f)localObject2).toByteArray();
        localObject2 = ah.aiuX;
        paramObject.success(localObject1);
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          Log.w("MicroMsg.FlutterPluginTextStatusDataSource", s.X("Failed to get status: ", paramObject));
          paramm.D((Throwable)paramObject);
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(233342);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.c.c
 * JD-Core Version:    0.7.0.1
 */
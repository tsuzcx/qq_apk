package com.tencent.mm.plugin;

import com.tencent.c.b.a;
import com.tencent.c.b.c;
import com.tencent.c.b.d;
import com.tencent.c.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/FlutterCgiPlugin;", "Lcom/tencent/pigeon/FlutterCgiPigeon$FlutterCgiHost;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "send", "flutterRequest", "Lcom/tencent/pigeon/FlutterCgiPigeon$FlutterCgiRequest;", "result", "Lcom/tencent/pigeon/FlutterCgiPigeon$Result;", "Lcom/tencent/pigeon/FlutterCgiPigeon$FlutterCgiResponse;", "CgiDelegate", "Companion", "RequestProtoBufDelegate", "ResponseProtoBufDelegate", "plugin-flutter-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b.a
  implements FlutterPlugin
{
  public static final c.b pFf;
  private aq coroutineScope;
  
  static
  {
    AppMethodBeat.i(260290);
    pFf = new c.b((byte)0);
    AppMethodBeat.o(260290);
  }
  
  public c()
  {
    AppMethodBeat.i(260285);
    aq localaq = ar.kBZ();
    ar.a(localaq, null);
    ah localah = ah.aiuX;
    this.coroutineScope = localaq;
    AppMethodBeat.o(260285);
  }
  
  public final void a(b.c paramc, final b.e<b.d> parame)
  {
    AppMethodBeat.i(260302);
    s.u(paramc, "flutterRequest");
    s.u(parame, "result");
    j.a(this.coroutineScope, (kotlin.d.f)bg.kCi(), null, (m)new e(paramc, parame, null), 2);
    AppMethodBeat.o(260302);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(260294);
    s.u(paramFlutterPluginBinding, "binding");
    this.coroutineScope = ar.kBZ();
    b.a.a(paramFlutterPluginBinding.getBinaryMessenger(), (b.a)this);
    AppMethodBeat.o(260294);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(260299);
    s.u(paramFlutterPluginBinding, "binding");
    ar.a(this.coroutineScope, null);
    AppMethodBeat.o(260299);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a$b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a
  {
    a$b(p<? super b.d> paramp) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    e(b.c paramc, b.e<b.d> parame, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(260427);
      paramObject = (d)new e(this.pFg, parame, paramd);
      AppMethodBeat.o(260427);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(260423);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(260423);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      case 1: 
      case 2: 
        try
        {
          paramObject = new c.a(this.pFg);
          localObject1 = (d)this;
          this.label = 1;
          localObject2 = new q(kotlin.d.a.b.au((d)localObject1), 1);
          ((q)localObject2).kBA();
          p localp = (p)localObject2;
          localp.bg((kotlin.g.a.b)new c.a.a(paramObject.bFJ().g((com.tencent.mm.vending.c.a)new c.a.b(localp))));
          paramObject = ((q)localObject2).getResult();
          if (paramObject == kotlin.d.a.a.aiwj) {
            s.u(localObject1, "frame");
          }
          if (paramObject != locala) {
            break label326;
          }
          AppMethodBeat.o(260423);
          return locala;
        }
        catch (Exception localException)
        {
          Object localObject1;
          paramObject = (kotlin.d.f)bg.kCh();
          localm = (m)new a(parame, localException, null);
          Object localObject2 = (d)this;
          this.label = 2;
          if (l.a(paramObject, localm, (d)localObject2) != locala) {
            break;
          }
          AppMethodBeat.o(260423);
          return locala;
          ResultKt.throwOnFailure(paramObject);
          paramObject = ah.aiuX;
          AppMethodBeat.o(260423);
          return paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
      }
      label326:
      for (;;)
      {
        localObject1 = (b.d)paramObject;
        paramObject = (kotlin.d.f)bg.kCh();
        localObject1 = (m)new k(parame, (b.d)localObject1)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(260380);
            paramAnonymousObject = (d)new 1(this.pFh, this.pFi, paramAnonymousd);
            AppMethodBeat.o(260380);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(260376);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(260376);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            this.pFh.success(this.pFi);
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(260376);
            return paramAnonymousObject;
          }
        };
        localObject2 = (d)this;
        this.label = 3;
        if (l.a(paramObject, (m)localObject1, (d)localObject2) == locala)
        {
          AppMethodBeat.o(260423);
          return locala;
          m localm;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(260423);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, d<? super ah>, Object>
    {
      int label;
      
      a(b.e<b.d> parame, Exception paramException, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(260277);
        paramObject = (d)new a(this.pFh, localException, paramd);
        AppMethodBeat.o(260277);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(260275);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(260275);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        this.pFh.D((Throwable)localException);
        paramObject = ah.aiuX;
        AppMethodBeat.o(260275);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.c
 * JD-Core Version:    0.7.0.1
 */
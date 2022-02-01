package com.tencent.mm.flutter.plugin.data_sources.c;

import com.tencent.c.c.f;
import com.tencent.c.c.g;
import com.tencent.c.c.h;
import com.tencent.c.c.l;
import com.tencent.c.c.m;
import com.tencent.c.c.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.flutter.plugin.a.e;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.sns.model.ab;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/plugins/FlutterPluginSnsDataSource;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$SnsDataSource;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getImageFile", "", "request", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$GetSnsImageFileRequest;", "result", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$Result;", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$GetSnsImageFileResponse;", "getLatestSns", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$GetSnsRequest;", "Lcom/tencent/pigeon/FlutterDataSourcesPlugin$ProtoBuffer;", "onAttachedToEngine", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "Companion", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c.n
  implements FlutterPlugin
{
  public static final b.a mrA;
  private final aq coroutineScope;
  
  static
  {
    AppMethodBeat.i(233352);
    mrA = new b.a((byte)0);
    AppMethodBeat.o(233352);
  }
  
  public b()
  {
    AppMethodBeat.i(233343);
    this.coroutineScope = ar.kBZ();
    AppMethodBeat.o(233343);
  }
  
  public final void a(c.f paramf, final c.m<c.g> paramm)
  {
    AppMethodBeat.i(233384);
    kotlin.g.b.s.u(paramf, "request");
    kotlin.g.b.s.u(paramm, "result");
    j.a(this.coroutineScope, null, null, (m)new b(paramf, paramm, null), 3);
    AppMethodBeat.o(233384);
  }
  
  public final void a(c.h paramh, c.m<c.l> paramm)
  {
    AppMethodBeat.i(233375);
    long l;
    if (paramh == null)
    {
      str = "";
      if (paramh != null) {
        break label188;
      }
      l = 259200000L;
    }
    for (;;)
    {
      Log.i("MicroMsg.FlutterPluginSnsDataSource", "getLatestSns(" + str + "), timeLimit:" + l);
      paramh = new com.tencent.mm.flutter.plugin.data_sources.d.a(str);
      paramm = (kotlin.g.a.b)new c(paramm);
      paramh.ibE = l;
      paramh.mrF = paramm;
      Log.i("MicroMsg.SnsDataSource", "getLatestSnsInfo username:" + paramh.username + ", timeLimit:" + l);
      if (!com.tencent.mm.flutter.plugin.data_sources.a.a.ED(paramh.username)) {
        break label214;
      }
      paramh = paramh.mrF;
      if (paramh != null) {
        paramh.invoke(new e());
      }
      Log.i("MicroMsg.SnsDataSource", "do not show sns cause in black list!");
      AppMethodBeat.o(233375);
      return;
      str = paramh.username;
      if (str == null)
      {
        str = "";
        break;
      }
      break;
      label188:
      paramh = paramh.ahhz;
      if (paramh == null) {
        l = 259200000L;
      } else {
        l = paramh.longValue();
      }
    }
    label214:
    com.tencent.mm.kernel.h.baD().mCm.a(212, (com.tencent.mm.am.h)paramh);
    paramm = com.tencent.mm.kernel.h.baD().mCm;
    String str = paramh.username;
    boolean bool = paramh.hHq;
    int j = ay.Qyy;
    if (paramh.hHq) {}
    for (int i = 4;; i = 8)
    {
      paramm.a((p)new ab(str, 0L, bool, 0, j, 0, i, 2), 0);
      AppMethodBeat.o(233375);
      return;
    }
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(233359);
    kotlin.g.b.s.u(paramFlutterPluginBinding, "binding");
    c.n.a(paramFlutterPluginBinding.getBinaryMessenger(), (c.n)this);
    AppMethodBeat.o(233359);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(233364);
    kotlin.g.b.s.u(paramFlutterPluginBinding, "binding");
    ar.a(this.coroutineScope, null);
    AppMethodBeat.o(233364);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(c.f paramf, c.m<c.g> paramm, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(233344);
      paramObject = (d)new b(this.mrB, paramm, paramd);
      AppMethodBeat.o(233344);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(233339);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(233339);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        new com.tencent.mm.flutter.plugin.data_sources.d.a("");
        paramObject = this.mrB.hHB;
        kotlin.g.b.s.s(paramObject, "request.localId");
        Object localObject1 = this.mrB.hQX;
        kotlin.g.b.s.s(localObject1, "request.snsId");
        String str = this.mrB.mediaId;
        kotlin.g.b.s.s(str, "request.mediaId");
        Object localObject2 = this.mrB;
        boolean bool;
        if (localObject2 == null) {
          bool = false;
        }
        for (;;)
        {
          localObject2 = (d)this;
          this.label = 1;
          paramObject = com.tencent.mm.flutter.plugin.data_sources.d.a.a(paramObject, (String)localObject1, str, bool, (d)localObject2);
          localObject1 = paramObject;
          if (paramObject != locala) {
            break;
          }
          AppMethodBeat.o(233339);
          return locala;
          localObject2 = ((c.f)localObject2).ahhA;
          if (localObject2 == null) {
            bool = false;
          } else {
            bool = ((Boolean)localObject2).booleanValue();
          }
        }
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = (String)localObject1;
        localObject1 = new c.g();
        ((c.g)localObject1).path = paramObject;
        paramm.success(localObject1);
        paramObject = ah.aiuX;
        AppMethodBeat.o(233339);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        paramm.D((Throwable)paramObject);
        paramObject = ah.aiuX;
        AppMethodBeat.o(233339);
      }
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/flutter/plugin/proto/GetSnsResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<e, ah>
  {
    c(c.m<c.l> paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.c.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.au.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.a.ag;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vibrate/util/VibrateFileHelper;", "", "()V", "TAG", "", "processVibrateFile", "", "simpleRingBack", "Lcom/tencent/mm/protocal/protobuf/ringtone/SimpleRingBack;", "plugin-vibrate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a TWU;
  
  static
  {
    AppMethodBeat.i(260687);
    TWU = new a();
    AppMethodBeat.o(260687);
  }
  
  public static void a(ag paramag)
  {
    AppMethodBeat.i(260680);
    s.u(paramag, "simpleRingBack");
    j.a(ar.d((f)bg.kCi()), null, null, (m)new a(paramag, null), 3);
    AppMethodBeat.o(260680);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(ag paramag, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(260689);
      paramObject = (d)new a(this.TWV, paramd);
      AppMethodBeat.o(260689);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(260681);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(260681);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = (com.tencent.mm.am.b)new com.tencent.mm.plugin.au.c.a(this.TWV);
        d locald = (d)this;
        this.label = 1;
        paramObject = com.tencent.mm.af.b.a(paramObject, locald);
        if (paramObject != locala) {
          break label104;
        }
        AppMethodBeat.o(260681);
        return locala;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          label104:
          Log.e("MicroMsg.VibrateFileHelper", "error in get cgi process ringback");
        }
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = ah.aiuX;
      AppMethodBeat.o(260681);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.au.d.a
 * JD-Core Version:    0.7.0.1
 */
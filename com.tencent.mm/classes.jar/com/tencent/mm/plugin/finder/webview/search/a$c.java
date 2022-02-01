package com.tencent.mm.plugin.finder.webview.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.a.h;
import kotlinx.coroutines.aq;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class a$c
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  a$c(JSONObject paramJSONObject, h<String> paramh, d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(334680);
    paramObject = (d)new c(this.GZo, this.aaM, paramd);
    AppMethodBeat.o(334680);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(334668);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(334668);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      Log.i("Finder.WebSearchService", s.X("result=", this.GZo.toString(4)));
      paramObject = this.aaM;
      String str = this.GZo.toString();
      s.s(str, "result.toString()");
      d locald = (d)this;
      this.label = 1;
      if (paramObject.b(str, locald) == locala)
      {
        AppMethodBeat.o(334668);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(334668);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.search.a.c
 * JD-Core Version:    0.7.0.1
 */
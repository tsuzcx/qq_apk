package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class a$a$a
  extends k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  a$a$a(WeakReference<a> paramWeakReference, kotlin.d.d<? super a> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(302391);
    paramObject = (kotlin.d.d)new a(this.vGu, paramd);
    AppMethodBeat.o(302391);
    return paramObject;
  }
  
  public final Object invokeSuspend(final Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(302386);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    Object localObject2;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(302386);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      if (a.deq())
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(302386);
        return paramObject;
      }
      paramObject = a.vOf;
      a.mX(true);
      paramObject = c.XPt;
      c.xZ(System.currentTimeMillis());
      paramObject = c.XPt;
      paramObject = a.vOf;
      int i = a.dep();
      paramObject = (kotlin.d.d)this;
      this.label = 1;
      localObject2 = c.a(i, null, paramObject);
      paramObject = localObject2;
      if (localObject2 == locala)
      {
        AppMethodBeat.o(302386);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = (pn)paramObject;
    if (paramObject == null)
    {
      paramObject = null;
      Log.d("MicroMsg.BizFinderLiveBar", "doGetBizFinderLives");
      localObject2 = a.vOf;
      a.mX(false);
      if (paramObject != null) {
        break label248;
      }
    }
    label248:
    for (paramObject = localObject1;; paramObject = paramObject.YSX)
    {
      if (paramObject != null) {
        break label256;
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(302386);
      return paramObject;
      localObject2 = c.XPt;
      localObject2 = a.vOf;
      c.nE(a.dep(), paramObject.YSY);
      localObject2 = c.XPt;
      localObject2 = a.vOf;
      c.nF(a.dep(), paramObject.YSZ);
      localObject2 = c.XPt;
      c.a(paramObject);
      break;
    }
    label256:
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(this.vGu) {});
    paramObject = ah.aiuX;
    AppMethodBeat.o(302386);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a.a.a
 * JD-Core Version:    0.7.0.1
 */
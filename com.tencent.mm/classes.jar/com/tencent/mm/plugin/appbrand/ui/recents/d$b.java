package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.protocal.protobuf.cxe;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;
import org.xwalk.core.Log;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class d$b
  extends k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  d$b(d paramd, kotlin.d.d<? super b> paramd1)
  {
    super(2, paramd1);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(323105);
    paramObject = (kotlin.d.d)new b(this.ulk, paramd);
    AppMethodBeat.o(323105);
    return paramObject;
  }
  
  public final Object invokeSuspend(final Object paramObject)
  {
    AppMethodBeat.i(323104);
    a locala = a.aiwj;
    Object localObject1;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(323104);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = new c();
      localObject1 = (kotlin.d.d)this;
      this.label = 1;
      localObject1 = paramObject.U((kotlin.d.d)localObject1);
      paramObject = localObject1;
      if (localObject1 == locala)
      {
        AppMethodBeat.o(323104);
        return locala;
      }
    case 1: 
      ResultKt.throwOnFailure(paramObject);
      localObject1 = this.ulk;
      Object localObject2 = (b.a)paramObject;
      int i = ((b.a)localObject2).errType;
      int j = ((b.a)localObject2).errCode;
      String str = ((b.a)localObject2).errMsg;
      paramObject = (cxe)((b.a)localObject2).ott;
      if (((b.a)localObject2).hEi == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.netscene.NetSceneGetWxaOrderInfo");
        AppMethodBeat.o(323104);
        throw paramObject;
      }
      if ((i != 0) || (j != 0))
      {
        new StringBuilder("NetSceneGetWxaOrderInfo error errType=").append(i).append(", errCode=").append(j).append(", errMsg=").append(str);
        h.jXD();
        paramObject = ah.aiuX;
        AppMethodBeat.o(323104);
        return paramObject;
      }
      localObject2 = (f)bg.kCh();
      paramObject = (m)new a((d)localObject1, paramObject, null);
      this.label = 2;
      if (l.a((f)localObject2, paramObject, this) != locala) {
        break label282;
      }
      AppMethodBeat.o(323104);
      return locala;
    }
    ResultKt.throwOnFailure(paramObject);
    label282:
    paramObject = ah.aiuX;
    AppMethodBeat.o(323104);
    return paramObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(d paramd, cxe paramcxe, kotlin.d.d<? super a> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(323129);
      paramObject = (kotlin.d.d)new a(this.ulk, paramObject, paramd);
      AppMethodBeat.o(323129);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(323120);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(323120);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.ulk;
      boolean bool = paramObject.aaCJ;
      Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showRedDot] showRedDot == ".concat(String.valueOf(bool)));
      paramObject = paramObject.ult;
      if (bool) {}
      for (int i = 0;; i = 8)
      {
        paramObject.setVisibility(i);
        paramObject = ah.aiuX;
        AppMethodBeat.o(323120);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d.b
 * JD-Core Version:    0.7.0.1
 */
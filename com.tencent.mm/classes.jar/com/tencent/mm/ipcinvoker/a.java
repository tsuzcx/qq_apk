package com.tencent.mm.ipcinvoker;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"ipcInvoke", "", "InputType", "Landroid/os/Parcelable;", "ResultType", "targetProcessName", "", "request", "process", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "callback", "Lkotlin/Function1;", "(Ljava/lang/String;Landroid/os/Parcelable;Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;Lkotlin/jvm/functions/Function1;)V", "ipcinvoker_release"})
public final class a
{
  public static final <InputType extends Parcelable, ResultType extends Parcelable> void a(String paramString, InputType paramInputType, d<InputType, ResultType> paramd, b<? super ResultType, x> paramb)
  {
    AppMethodBeat.i(214375);
    p.k(paramString, "targetProcessName");
    p.k(paramd, "process");
    Class localClass = paramd.getClass();
    if (paramb == null) {}
    for (paramd = null;; paramd = (f)new a(paramb))
    {
      j.a(paramString, paramInputType, localClass, paramd);
      AppMethodBeat.o(214375);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "InputType", "Landroid/os/Parcelable;", "ResultType", "data", "kotlin.jvm.PlatformType", "onCallback", "(Landroid/os/Parcelable;)V"})
  static final class a<T>
    implements f<ResultType>
  {
    a(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.a
 * JD-Core Version:    0.7.0.1
 */
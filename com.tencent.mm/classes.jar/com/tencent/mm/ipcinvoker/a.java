package com.tencent.mm.ipcinvoker;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"ipcInvoke", "", "InputType", "Landroid/os/Parcelable;", "ResultType", "targetProcessName", "", "request", "process", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "callback", "Lkotlin/Function1;", "(Ljava/lang/String;Landroid/os/Parcelable;Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;Lkotlin/jvm/functions/Function1;)V", "ipcinvoker_release"})
public final class a
{
  public static final <InputType extends Parcelable, ResultType extends Parcelable> void a(String paramString, InputType paramInputType, b<InputType, ResultType> paramb, d.g.a.b<? super ResultType, y> paramb1)
  {
    AppMethodBeat.i(199245);
    k.h(paramString, "targetProcessName");
    k.h(paramb, "process");
    Class localClass = paramb.getClass();
    if (paramb1 == null) {}
    for (paramb = null;; paramb = (d)new a(paramb1))
    {
      h.a(paramString, paramInputType, localClass, paramb);
      AppMethodBeat.o(199245);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "InputType", "Landroid/os/Parcelable;", "ResultType", "data", "kotlin.jvm.PlatformType", "onCallback", "(Landroid/os/Parcelable;)V"})
  static final class a<T>
    implements d<ResultType>
  {
    a(d.g.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.a
 * JD-Core Version:    0.7.0.1
 */
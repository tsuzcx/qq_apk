package com.tencent.mm.ipcinvoker;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"ipcInvoke", "", "InputType", "Landroid/os/Parcelable;", "ResultType", "targetProcessName", "", "request", "process", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "callback", "Lkotlin/Function1;", "(Ljava/lang/String;Landroid/os/Parcelable;Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;Lkotlin/jvm/functions/Function1;)V", "ipcInvokeSync", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "(Ljava/lang/String;Landroid/os/Parcelable;Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;)Landroid/os/Parcelable;", "ipcinvoker_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final <InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String paramString, InputType paramInputType, m<InputType, ResultType> paramm)
  {
    AppMethodBeat.i(235675);
    s.u(paramString, "targetProcessName");
    s.u(paramm, "process");
    paramString = j.a(paramString, paramInputType, paramm.getClass());
    AppMethodBeat.o(235675);
    return paramString;
  }
  
  public static final <InputType extends Parcelable, ResultType extends Parcelable> void a(String paramString, InputType paramInputType, d<InputType, ResultType> paramd, b<? super ResultType, ah> paramb)
  {
    AppMethodBeat.i(235670);
    s.u(paramString, "targetProcessName");
    s.u(paramd, "process");
    Class localClass = paramd.getClass();
    if (paramb == null) {}
    for (paramd = null;; paramd = new a..ExternalSyntheticLambda0(paramb))
    {
      j.a(paramString, paramInputType, localClass, paramd);
      AppMethodBeat.o(235670);
      return;
    }
  }
  
  private static final void a(b paramb, Parcelable paramParcelable)
  {
    AppMethodBeat.i(235678);
    s.s(paramParcelable, "data");
    paramb.invoke(paramParcelable);
    AppMethodBeat.o(235678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.a
 * JD-Core Version:    0.7.0.1
 */
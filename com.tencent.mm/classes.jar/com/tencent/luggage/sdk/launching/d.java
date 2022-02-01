package com.tencent.luggage.sdk.launching;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/launching/OnWXAppResultXPCLeakFreeWrapper;", "", "()V", "readFromParcel", "Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;", "R", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "releaseSenderReference", "", "resultListener", "writeToParcel", "listener", "flags", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d etB;
  
  static
  {
    AppMethodBeat.i(220554);
    etB = new d();
    AppMethodBeat.o(220554);
  }
  
  public static final void a(b<?> paramb)
  {
    AppMethodBeat.i(220546);
    if ((paramb instanceof a)) {}
    for (paramb = (a)paramb;; paramb = null)
    {
      if (paramb != null) {
        paramb.release();
      }
      AppMethodBeat.o(220546);
      return;
    }
  }
  
  public static final <R extends Parcelable> void b(b<R> paramb, Parcel paramParcel)
  {
    AppMethodBeat.i(220552);
    s.u(paramParcel, "parcel");
    a(paramb, paramParcel);
    AppMethodBeat.o(220552);
  }
  
  public static final <R extends Parcelable> b<R> c(Parcel paramParcel)
  {
    AppMethodBeat.i(220539);
    s.u(paramParcel, "parcel");
    paramParcel = (OnWXAppResultEventBinder)paramParcel.readParcelable(OnWXAppResultEventBinder.class.getClassLoader());
    if (paramParcel == null)
    {
      AppMethodBeat.o(220539);
      return null;
    }
    paramParcel = (b)new a(paramParcel.etw, paramParcel.processName);
    AppMethodBeat.o(220539);
    return paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.d
 * JD-Core Version:    0.7.0.1
 */
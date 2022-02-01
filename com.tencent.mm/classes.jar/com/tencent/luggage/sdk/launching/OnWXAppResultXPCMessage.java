package com.tencent.luggage.sdk.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/launching/OnWXAppResultXPCMessage;", "Landroid/os/Parcelable;", "instance", "", "action", "data", "(IILandroid/os/Parcelable;)V", "getAction", "()I", "getData", "()Landroid/os/Parcelable;", "getInstance", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OnWXAppResultXPCMessage
  implements Parcelable
{
  public static final Parcelable.Creator<OnWXAppResultXPCMessage> CREATOR;
  final int action;
  final Parcelable etA;
  final int etw;
  
  static
  {
    AppMethodBeat.i(220537);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220537);
  }
  
  public OnWXAppResultXPCMessage(int paramInt1, int paramInt2, Parcelable paramParcelable)
  {
    this.etw = paramInt1;
    this.action = paramInt2;
    this.etA = paramParcelable;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220553);
    if (this == paramObject)
    {
      AppMethodBeat.o(220553);
      return true;
    }
    if (!(paramObject instanceof OnWXAppResultXPCMessage))
    {
      AppMethodBeat.o(220553);
      return false;
    }
    paramObject = (OnWXAppResultXPCMessage)paramObject;
    if (this.etw != paramObject.etw)
    {
      AppMethodBeat.o(220553);
      return false;
    }
    if (this.action != paramObject.action)
    {
      AppMethodBeat.o(220553);
      return false;
    }
    if (!s.p(this.etA, paramObject.etA))
    {
      AppMethodBeat.o(220553);
      return false;
    }
    AppMethodBeat.o(220553);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(220549);
    int j = this.etw;
    int k = this.action;
    if (this.etA == null) {}
    for (int i = 0;; i = this.etA.hashCode())
    {
      AppMethodBeat.o(220549);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220545);
    String str = "OnWXAppResultXPCMessage(instance=" + this.etw + ", action=" + this.action + ", data=" + this.etA + ')';
    AppMethodBeat.o(220545);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220561);
    s.u(paramParcel, "out");
    paramParcel.writeInt(this.etw);
    paramParcel.writeInt(this.action);
    paramParcel.writeParcelable(this.etA, paramInt);
    AppMethodBeat.o(220561);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<OnWXAppResultXPCMessage>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.OnWXAppResultXPCMessage
 * JD-Core Version:    0.7.0.1
 */
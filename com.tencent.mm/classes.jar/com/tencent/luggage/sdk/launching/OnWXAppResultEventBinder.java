package com.tencent.luggage.sdk.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/launching/OnWXAppResultEventBinder;", "Landroid/os/Parcelable;", "instance", "", "processName", "", "(ILjava/lang/String;)V", "getInstance", "()I", "getProcessName", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OnWXAppResultEventBinder
  implements Parcelable
{
  public static final Parcelable.Creator<OnWXAppResultEventBinder> CREATOR;
  final int etw;
  final String processName;
  
  static
  {
    AppMethodBeat.i(220536);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220536);
  }
  
  public OnWXAppResultEventBinder(int paramInt, String paramString)
  {
    this.etw = paramInt;
    this.processName = paramString;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220555);
    if (this == paramObject)
    {
      AppMethodBeat.o(220555);
      return true;
    }
    if (!(paramObject instanceof OnWXAppResultEventBinder))
    {
      AppMethodBeat.o(220555);
      return false;
    }
    paramObject = (OnWXAppResultEventBinder)paramObject;
    if (this.etw != paramObject.etw)
    {
      AppMethodBeat.o(220555);
      return false;
    }
    if (!s.p(this.processName, paramObject.processName))
    {
      AppMethodBeat.o(220555);
      return false;
    }
    AppMethodBeat.o(220555);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(220551);
    int j = this.etw;
    if (this.processName == null) {}
    for (int i = 0;; i = this.processName.hashCode())
    {
      AppMethodBeat.o(220551);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220544);
    String str = "OnWXAppResultEventBinder(instance=" + this.etw + ", processName=" + this.processName + ')';
    AppMethodBeat.o(220544);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220562);
    s.u(paramParcel, "out");
    paramParcel.writeInt(this.etw);
    paramParcel.writeString(this.processName);
    AppMethodBeat.o(220562);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<OnWXAppResultEventBinder>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.OnWXAppResultEventBinder
 * JD-Core Version:    0.7.0.1
 */
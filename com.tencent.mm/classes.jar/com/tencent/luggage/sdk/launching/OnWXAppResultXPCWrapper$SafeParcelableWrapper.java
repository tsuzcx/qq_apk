package com.tencent.luggage.sdk.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class OnWXAppResultXPCWrapper$SafeParcelableWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<SafeParcelableWrapper> CREATOR;
  private Parcelable bEY;
  
  static
  {
    AppMethodBeat.i(101675);
    CREATOR = new OnWXAppResultXPCWrapper.SafeParcelableWrapper.1();
    AppMethodBeat.o(101675);
  }
  
  OnWXAppResultXPCWrapper$SafeParcelableWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(101674);
    String str = paramParcel.readString();
    if (TextUtils.isEmpty(str))
    {
      this.bEY = null;
      AppMethodBeat.o(101674);
      return;
    }
    try
    {
      this.bEY = paramParcel.readParcelable(Class.forName(str).getClassLoader());
      AppMethodBeat.o(101674);
      return;
    }
    catch (ClassNotFoundException paramParcel)
    {
      d.e("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "ClassNotFoundException with %s", new Object[] { str });
      AppMethodBeat.o(101674);
    }
  }
  
  OnWXAppResultXPCWrapper$SafeParcelableWrapper(Parcelable paramParcelable)
  {
    this.bEY = paramParcelable;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101673);
    if (this.bEY == null)
    {
      paramParcel.writeString(null);
      AppMethodBeat.o(101673);
      return;
    }
    paramParcel.writeString(this.bEY.getClass().getName());
    paramParcel.writeParcelable(this.bEY, paramInt);
    AppMethodBeat.o(101673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper.SafeParcelableWrapper
 * JD-Core Version:    0.7.0.1
 */
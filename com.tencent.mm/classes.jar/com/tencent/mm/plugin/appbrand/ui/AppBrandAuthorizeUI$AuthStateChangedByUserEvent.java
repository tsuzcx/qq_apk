package com.tencent.mm.plugin.appbrand.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandAuthorizeUI$AuthStateChangedByUserEvent
  implements Parcelable
{
  public static final Parcelable.Creator<AuthStateChangedByUserEvent> CREATOR;
  public boolean maE;
  public boolean maF;
  
  static
  {
    AppMethodBeat.i(48550);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48550);
  }
  
  public AppBrandAuthorizeUI$AuthStateChangedByUserEvent()
  {
    this.maE = false;
    this.maF = false;
  }
  
  protected AppBrandAuthorizeUI$AuthStateChangedByUserEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(48548);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.maE = bool1;
      if (paramParcel.readByte() == 0) {
        break label50;
      }
    }
    label50:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.maF = bool1;
      AppMethodBeat.o(48548);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(48549);
    if (this.maE)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.maF) {
        break label48;
      }
    }
    label48:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(48549);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent
 * JD-Core Version:    0.7.0.1
 */
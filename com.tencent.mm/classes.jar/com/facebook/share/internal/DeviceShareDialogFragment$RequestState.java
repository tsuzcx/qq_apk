package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class DeviceShareDialogFragment$RequestState
  implements Parcelable
{
  public static final Parcelable.Creator<RequestState> CREATOR;
  private long expiresIn;
  private String userCode;
  
  static
  {
    AppMethodBeat.i(7985);
    CREATOR = new Parcelable.Creator()
    {
      public final DeviceShareDialogFragment.RequestState createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(7980);
        paramAnonymousParcel = new DeviceShareDialogFragment.RequestState(paramAnonymousParcel);
        AppMethodBeat.o(7980);
        return paramAnonymousParcel;
      }
      
      public final DeviceShareDialogFragment.RequestState[] newArray(int paramAnonymousInt)
      {
        return new DeviceShareDialogFragment.RequestState[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(7985);
  }
  
  DeviceShareDialogFragment$RequestState() {}
  
  protected DeviceShareDialogFragment$RequestState(Parcel paramParcel)
  {
    AppMethodBeat.i(7983);
    this.userCode = paramParcel.readString();
    this.expiresIn = paramParcel.readLong();
    AppMethodBeat.o(7983);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getExpiresIn()
  {
    return this.expiresIn;
  }
  
  public String getUserCode()
  {
    return this.userCode;
  }
  
  public void setExpiresIn(long paramLong)
  {
    this.expiresIn = paramLong;
  }
  
  public void setUserCode(String paramString)
  {
    this.userCode = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(7984);
    paramParcel.writeString(this.userCode);
    paramParcel.writeLong(this.expiresIn);
    AppMethodBeat.o(7984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.internal.DeviceShareDialogFragment.RequestState
 * JD-Core Version:    0.7.0.1
 */
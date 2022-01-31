package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Date;
import java.util.Locale;

class DeviceAuthDialog$RequestState
  implements Parcelable
{
  public static final Parcelable.Creator<RequestState> CREATOR;
  private String authorizationUri;
  private long interval;
  private long lastPoll;
  private String requestCode;
  private String userCode;
  
  static
  {
    AppMethodBeat.i(96725);
    CREATOR = new DeviceAuthDialog.RequestState.1();
    AppMethodBeat.o(96725);
  }
  
  DeviceAuthDialog$RequestState() {}
  
  protected DeviceAuthDialog$RequestState(Parcel paramParcel)
  {
    AppMethodBeat.i(96722);
    this.authorizationUri = paramParcel.readString();
    this.userCode = paramParcel.readString();
    this.requestCode = paramParcel.readString();
    this.interval = paramParcel.readLong();
    this.lastPoll = paramParcel.readLong();
    AppMethodBeat.o(96722);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAuthorizationUri()
  {
    return this.authorizationUri;
  }
  
  public long getInterval()
  {
    return this.interval;
  }
  
  public String getRequestCode()
  {
    return this.requestCode;
  }
  
  public String getUserCode()
  {
    return this.userCode;
  }
  
  public void setInterval(long paramLong)
  {
    this.interval = paramLong;
  }
  
  public void setLastPoll(long paramLong)
  {
    this.lastPoll = paramLong;
  }
  
  public void setRequestCode(String paramString)
  {
    this.requestCode = paramString;
  }
  
  public void setUserCode(String paramString)
  {
    AppMethodBeat.i(96721);
    this.userCode = paramString;
    this.authorizationUri = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", new Object[] { paramString });
    AppMethodBeat.o(96721);
  }
  
  public boolean withinLastRefreshWindow()
  {
    AppMethodBeat.i(96723);
    if (this.lastPoll == 0L)
    {
      AppMethodBeat.o(96723);
      return false;
    }
    if (new Date().getTime() - this.lastPoll - this.interval * 1000L < 0L)
    {
      AppMethodBeat.o(96723);
      return true;
    }
    AppMethodBeat.o(96723);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96724);
    paramParcel.writeString(this.authorizationUri);
    paramParcel.writeString(this.userCode);
    paramParcel.writeString(this.requestCode);
    paramParcel.writeLong(this.interval);
    paramParcel.writeLong(this.lastPoll);
    AppMethodBeat.o(96724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.login.DeviceAuthDialog.RequestState
 * JD-Core Version:    0.7.0.1
 */
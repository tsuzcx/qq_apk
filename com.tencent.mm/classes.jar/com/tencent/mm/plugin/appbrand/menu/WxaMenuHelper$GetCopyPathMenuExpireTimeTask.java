package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.message.h;

public class WxaMenuHelper$GetCopyPathMenuExpireTimeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetCopyPathMenuExpireTimeTask> CREATOR;
  private String mAppId;
  private long tkZ;
  
  static
  {
    AppMethodBeat.i(47670);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47670);
  }
  
  public WxaMenuHelper$GetCopyPathMenuExpireTimeTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47666);
    this.tkZ = 0L;
    h(paramParcel);
    AppMethodBeat.o(47666);
  }
  
  public WxaMenuHelper$GetCopyPathMenuExpireTimeTask(String paramString)
  {
    this.tkZ = 0L;
    this.mAppId = paramString;
  }
  
  public final void asn()
  {
    AppMethodBeat.i(47667);
    Object localObject = h.tlY;
    localObject = h.fa(this.mAppId, "copypath");
    if (localObject == null)
    {
      this.tkZ = 0L;
      AppMethodBeat.o(47667);
      return;
    }
    this.tkZ = ((Long)localObject).longValue();
    AppMethodBeat.o(47667);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(47668);
    this.tkZ = paramParcel.readLong();
    this.mAppId = paramParcel.readString();
    AppMethodBeat.o(47668);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47669);
    paramParcel.writeLong(this.tkZ);
    paramParcel.writeString(this.mAppId);
    AppMethodBeat.o(47669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask
 * JD-Core Version:    0.7.0.1
 */
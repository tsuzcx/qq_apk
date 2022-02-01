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
  private long lum;
  private String mAppId;
  
  static
  {
    AppMethodBeat.i(47670);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47670);
  }
  
  public WxaMenuHelper$GetCopyPathMenuExpireTimeTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47666);
    this.lum = 0L;
    e(paramParcel);
    AppMethodBeat.o(47666);
  }
  
  public WxaMenuHelper$GetCopyPathMenuExpireTimeTask(String paramString)
  {
    this.lum = 0L;
    this.mAppId = paramString;
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(47667);
    Object localObject = h.lvl;
    localObject = h.dT(this.mAppId, "copypath");
    if (localObject == null)
    {
      this.lum = 0L;
      AppMethodBeat.o(47667);
      return;
    }
    this.lum = ((Long)localObject).longValue();
    AppMethodBeat.o(47667);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(47668);
    this.lum = paramParcel.readLong();
    this.mAppId = paramParcel.readString();
    AppMethodBeat.o(47668);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47669);
    paramParcel.writeLong(this.lum);
    paramParcel.writeString(this.mAppId);
    AppMethodBeat.o(47669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask
 * JD-Core Version:    0.7.0.1
 */
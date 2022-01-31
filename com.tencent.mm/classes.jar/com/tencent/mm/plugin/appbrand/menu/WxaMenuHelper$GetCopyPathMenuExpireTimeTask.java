package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j.f;

public class WxaMenuHelper$GetCopyPathMenuExpireTimeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetCopyPathMenuExpireTimeTask> CREATOR;
  private long irn;
  private String mAppId;
  
  static
  {
    AppMethodBeat.i(132259);
    CREATOR = new WxaMenuHelper.GetCopyPathMenuExpireTimeTask.1();
    AppMethodBeat.o(132259);
  }
  
  public WxaMenuHelper$GetCopyPathMenuExpireTimeTask(Parcel paramParcel)
  {
    AppMethodBeat.i(132255);
    this.irn = 0L;
    f(paramParcel);
    AppMethodBeat.o(132255);
  }
  
  public WxaMenuHelper$GetCopyPathMenuExpireTimeTask(String paramString)
  {
    this.irn = 0L;
    this.mAppId = paramString;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(132256);
    Object localObject = f.irL;
    localObject = f.cK(this.mAppId, "copypath");
    if (localObject == null)
    {
      this.irn = 0L;
      AppMethodBeat.o(132256);
      return;
    }
    this.irn = ((Long)localObject).longValue();
    AppMethodBeat.o(132256);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(132257);
    this.irn = paramParcel.readLong();
    this.mAppId = paramParcel.readString();
    AppMethodBeat.o(132257);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(132258);
    paramParcel.writeLong(this.irn);
    paramParcel.writeString(this.mAppId);
    AppMethodBeat.o(132258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask
 * JD-Core Version:    0.7.0.1
 */
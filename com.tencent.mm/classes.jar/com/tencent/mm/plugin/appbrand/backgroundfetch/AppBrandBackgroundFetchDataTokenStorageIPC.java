package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class AppBrandBackgroundFetchDataTokenStorageIPC
  implements l
{
  public final AppBrandBackgroundFetchDataTokenParcel WN(String paramString)
  {
    AppMethodBeat.i(44752);
    paramString = (AppBrandBackgroundFetchDataTokenParcel)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramString), a.class);
    AppMethodBeat.o(44752);
    return paramString;
  }
  
  public final boolean dn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44753);
    paramString1 = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new WxappParams(paramString1, paramString2), b.class);
    if ((paramString1 != null) && (paramString1.value))
    {
      AppMethodBeat.o(44753);
      return true;
    }
    AppMethodBeat.o(44753);
    return false;
  }
  
  static class WxappParams
    implements Parcelable
  {
    public static final Parcelable.Creator<WxappParams> CREATOR;
    public String token;
    public String username;
    
    static
    {
      AppMethodBeat.i(44751);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44751);
    }
    
    public WxappParams() {}
    
    protected WxappParams(Parcel paramParcel)
    {
      AppMethodBeat.i(44750);
      this.username = paramParcel.readString();
      this.token = paramParcel.readString();
      AppMethodBeat.o(44750);
    }
    
    public WxappParams(String paramString1, String paramString2)
    {
      this.username = paramString1;
      this.token = paramString2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44749);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.token);
      AppMethodBeat.o(44749);
    }
  }
  
  static class a
    implements m<IPCString, AppBrandBackgroundFetchDataTokenParcel>
  {
    private static AppBrandBackgroundFetchDataTokenParcel a(IPCString paramIPCString)
    {
      AppMethodBeat.i(44744);
      if ((paramIPCString == null) || (Util.isNullOrNil(paramIPCString.value)))
      {
        Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "GetCall:data or username is null");
        AppMethodBeat.o(44744);
        return null;
      }
      try
      {
        paramIPCString = ((l)h.ax(l.class)).WN(paramIPCString.value);
        AppMethodBeat.o(44744);
        return paramIPCString;
      }
      catch (Exception paramIPCString)
      {
        Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "GetCall fail", new Object[] { paramIPCString });
        AppMethodBeat.o(44744);
      }
      return null;
    }
  }
  
  static class b
    implements m<AppBrandBackgroundFetchDataTokenStorageIPC.WxappParams, IPCBoolean>
  {
    private static IPCBoolean a(AppBrandBackgroundFetchDataTokenStorageIPC.WxappParams paramWxappParams)
    {
      AppMethodBeat.i(44746);
      if ((paramWxappParams == null) || (Util.isNullOrNil(paramWxappParams.username)))
      {
        Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "SetCall:data or username is null");
        paramWxappParams = new IPCBoolean(false);
        AppMethodBeat.o(44746);
        return paramWxappParams;
      }
      try
      {
        paramWxappParams = new IPCBoolean(((l)h.ax(l.class)).dn(paramWxappParams.username, paramWxappParams.token));
        AppMethodBeat.o(44746);
        return paramWxappParams;
      }
      catch (Exception paramWxappParams)
      {
        Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "SetCall fail", new Object[] { paramWxappParams });
        paramWxappParams = new IPCBoolean(false);
        AppMethodBeat.o(44746);
      }
      return paramWxappParams;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC
 * JD-Core Version:    0.7.0.1
 */
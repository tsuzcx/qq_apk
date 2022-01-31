package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class AppBrandBackgroundFetchDataStorageIPC
  implements k
{
  public final boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(129797);
    ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "AppBrandBackgroundFetchDataStorageIPC set");
    paramString1 = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new AppBrandBackgroundFetchDataStorageIPC.WxappParams(paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramLong), c.class);
    if ((paramString1 != null) && (paramString1.value))
    {
      AppMethodBeat.o(129797);
      return true;
    }
    AppMethodBeat.o(129797);
    return false;
  }
  
  public final long aQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(129799);
    ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "AppBrandBackgroundFetchDataStorageIPC getUpdateTime");
    paramString = (IPCLong)XIPCInvoker.a("com.tencent.mm", new AppBrandBackgroundFetchDataStorageIPC.WxappIdentity(paramString, paramInt), AppBrandBackgroundFetchDataStorageIPC.b.class);
    if (paramString != null)
    {
      long l = paramString.value;
      AppMethodBeat.o(129799);
      return l;
    }
    AppMethodBeat.o(129799);
    return 0L;
  }
  
  public final AppBrandBackgroundFetchDataParcel aR(String paramString, int paramInt)
  {
    AppMethodBeat.i(129800);
    ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "AppBrandBackgroundFetchDataStorageIPC getByAppId");
    paramString = (AppBrandBackgroundFetchDataParcel)XIPCInvoker.a("com.tencent.mm", new WxappIdentityWithAppId(paramString, paramInt), AppBrandBackgroundFetchDataStorageIPC.a.class);
    AppMethodBeat.o(129800);
    return paramString;
  }
  
  static class WxappIdentityWithAppId
    implements Parcelable
  {
    public static final Parcelable.Creator<WxappIdentityWithAppId> CREATOR;
    public String cwc;
    public int hdX;
    
    static
    {
      AppMethodBeat.i(129792);
      CREATOR = new AppBrandBackgroundFetchDataStorageIPC.WxappIdentityWithAppId.1();
      AppMethodBeat.o(129792);
    }
    
    public WxappIdentityWithAppId() {}
    
    protected WxappIdentityWithAppId(Parcel paramParcel)
    {
      AppMethodBeat.i(129791);
      this.cwc = paramParcel.readString();
      this.hdX = paramParcel.readInt();
      AppMethodBeat.o(129791);
    }
    
    public WxappIdentityWithAppId(String paramString, int paramInt)
    {
      this.cwc = paramString;
      this.hdX = paramInt;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(129790);
      paramParcel.writeString(this.cwc);
      paramParcel.writeInt(this.hdX);
      AppMethodBeat.o(129790);
    }
  }
  
  static class c
    implements i<AppBrandBackgroundFetchDataStorageIPC.WxappParams, IPCBoolean>
  {
    private static IPCBoolean a(AppBrandBackgroundFetchDataStorageIPC.WxappParams paramWxappParams)
    {
      AppMethodBeat.i(129783);
      if ((paramWxappParams == null) || (bo.isNullOrNil(paramWxappParams.username)))
      {
        ab.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "SetCall:data or username is null");
        paramWxappParams = new IPCBoolean(false);
        AppMethodBeat.o(129783);
        return paramWxappParams;
      }
      try
      {
        paramWxappParams = new IPCBoolean(((k)g.E(k.class)).a(paramWxappParams.username, paramWxappParams.hdX, paramWxappParams.data, paramWxappParams.path, paramWxappParams.query, paramWxappParams.scene, paramWxappParams.time));
        AppMethodBeat.o(129783);
        return paramWxappParams;
      }
      catch (Exception paramWxappParams)
      {
        ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "SetCall fail", new Object[] { paramWxappParams });
        paramWxappParams = new IPCBoolean(false);
        AppMethodBeat.o(129783);
      }
      return paramWxappParams;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC
 * JD-Core Version:    0.7.0.1
 */
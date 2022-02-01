package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class AppBrandBackgroundFetchDataStorageIPC
  implements k
{
  public final boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(44728);
    Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "AppBrandBackgroundFetchDataStorageIPC set");
    paramString1 = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.dkO, new WxappParams(paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramLong), c.class);
    if ((paramString1 != null) && (paramString1.value))
    {
      AppMethodBeat.o(44728);
      return true;
    }
    AppMethodBeat.o(44728);
    return false;
  }
  
  public final long bu(String paramString, int paramInt)
  {
    AppMethodBeat.i(44729);
    Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "AppBrandBackgroundFetchDataStorageIPC getUpdateTime");
    paramString = (IPCLong)XIPCInvoker.a(MainProcessIPCService.dkO, new WxappIdentity(paramString, paramInt), b.class);
    if (paramString != null)
    {
      long l = paramString.value;
      AppMethodBeat.o(44729);
      return l;
    }
    AppMethodBeat.o(44729);
    return 0L;
  }
  
  public final AppBrandBackgroundFetchDataParcel bv(String paramString, int paramInt)
  {
    AppMethodBeat.i(44730);
    Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "AppBrandBackgroundFetchDataStorageIPC getByAppId");
    paramString = (AppBrandBackgroundFetchDataParcel)XIPCInvoker.a(MainProcessIPCService.dkO, new WxappIdentityWithAppId(paramString, paramInt), a.class);
    AppMethodBeat.o(44730);
    return paramString;
  }
  
  static class WxappIdentity
    implements Parcelable
  {
    public static final Parcelable.Creator<WxappIdentity> CREATOR;
    public int kXP;
    public String username;
    
    static
    {
      AppMethodBeat.i(44719);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44719);
    }
    
    public WxappIdentity() {}
    
    protected WxappIdentity(Parcel paramParcel)
    {
      AppMethodBeat.i(44718);
      this.username = paramParcel.readString();
      this.kXP = paramParcel.readInt();
      AppMethodBeat.o(44718);
    }
    
    public WxappIdentity(String paramString, int paramInt)
    {
      this.username = paramString;
      this.kXP = paramInt;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44717);
      paramParcel.writeString(this.username);
      paramParcel.writeInt(this.kXP);
      AppMethodBeat.o(44717);
    }
  }
  
  static class WxappIdentityWithAppId
    implements Parcelable
  {
    public static final Parcelable.Creator<WxappIdentityWithAppId> CREATOR;
    public String dNI;
    public int kXP;
    
    static
    {
      AppMethodBeat.i(44723);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44723);
    }
    
    public WxappIdentityWithAppId() {}
    
    protected WxappIdentityWithAppId(Parcel paramParcel)
    {
      AppMethodBeat.i(44722);
      this.dNI = paramParcel.readString();
      this.kXP = paramParcel.readInt();
      AppMethodBeat.o(44722);
    }
    
    public WxappIdentityWithAppId(String paramString, int paramInt)
    {
      this.dNI = paramString;
      this.kXP = paramInt;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44721);
      paramParcel.writeString(this.dNI);
      paramParcel.writeInt(this.kXP);
      AppMethodBeat.o(44721);
    }
  }
  
  static class WxappParams
    implements Parcelable
  {
    public static final Parcelable.Creator<WxappParams> CREATOR;
    public String data;
    public int kXP;
    public String path;
    public String query;
    public int scene;
    public long time;
    public String username;
    
    static
    {
      AppMethodBeat.i(44727);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44727);
    }
    
    public WxappParams() {}
    
    protected WxappParams(Parcel paramParcel)
    {
      AppMethodBeat.i(44726);
      this.username = paramParcel.readString();
      this.kXP = paramParcel.readInt();
      this.data = paramParcel.readString();
      this.path = paramParcel.readString();
      this.query = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.time = paramParcel.readLong();
      AppMethodBeat.o(44726);
    }
    
    public WxappParams(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
    {
      this.username = paramString1;
      this.kXP = paramInt1;
      this.data = paramString2;
      this.path = paramString3;
      this.query = paramString4;
      this.scene = paramInt2;
      this.time = paramLong;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44725);
      paramParcel.writeString(this.username);
      paramParcel.writeInt(this.kXP);
      paramParcel.writeString(this.data);
      paramParcel.writeString(this.path);
      paramParcel.writeString(this.query);
      paramParcel.writeInt(this.scene);
      paramParcel.writeLong(this.time);
      AppMethodBeat.o(44725);
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.k<AppBrandBackgroundFetchDataStorageIPC.WxappIdentityWithAppId, AppBrandBackgroundFetchDataParcel>
  {
    private static AppBrandBackgroundFetchDataParcel a(AppBrandBackgroundFetchDataStorageIPC.WxappIdentityWithAppId paramWxappIdentityWithAppId)
    {
      AppMethodBeat.i(44710);
      if ((paramWxappIdentityWithAppId == null) || (Util.isNullOrNil(paramWxappIdentityWithAppId.dNI)))
      {
        Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetByAppIdCall:data or appid is null");
        AppMethodBeat.o(44710);
        return null;
      }
      try
      {
        paramWxappIdentityWithAppId = ((k)g.af(k.class)).bv(paramWxappIdentityWithAppId.dNI, paramWxappIdentityWithAppId.kXP);
        AppMethodBeat.o(44710);
        return paramWxappIdentityWithAppId;
      }
      catch (Exception paramWxappIdentityWithAppId)
      {
        Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetByAppIdCall fail", new Object[] { paramWxappIdentityWithAppId });
        AppMethodBeat.o(44710);
      }
      return null;
    }
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.k<AppBrandBackgroundFetchDataStorageIPC.WxappIdentity, IPCLong>
  {
    private static IPCLong a(AppBrandBackgroundFetchDataStorageIPC.WxappIdentity paramWxappIdentity)
    {
      AppMethodBeat.i(44712);
      if ((paramWxappIdentity == null) || (Util.isNullOrNil(paramWxappIdentity.username)))
      {
        Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetUpdateTimeCall:data or username is null");
        paramWxappIdentity = new IPCLong(0L);
        AppMethodBeat.o(44712);
        return paramWxappIdentity;
      }
      try
      {
        paramWxappIdentity = new IPCLong(((k)g.af(k.class)).bu(paramWxappIdentity.username, paramWxappIdentity.kXP));
        AppMethodBeat.o(44712);
        return paramWxappIdentity;
      }
      catch (Exception paramWxappIdentity)
      {
        Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetUpdateTimeCall fail", new Object[] { paramWxappIdentity });
        paramWxappIdentity = new IPCLong(0L);
        AppMethodBeat.o(44712);
      }
      return paramWxappIdentity;
    }
  }
  
  static class c
    implements com.tencent.mm.ipcinvoker.k<AppBrandBackgroundFetchDataStorageIPC.WxappParams, IPCBoolean>
  {
    private static IPCBoolean a(AppBrandBackgroundFetchDataStorageIPC.WxappParams paramWxappParams)
    {
      AppMethodBeat.i(44714);
      if ((paramWxappParams == null) || (Util.isNullOrNil(paramWxappParams.username)))
      {
        Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "SetCall:data or username is null");
        paramWxappParams = new IPCBoolean(false);
        AppMethodBeat.o(44714);
        return paramWxappParams;
      }
      try
      {
        paramWxappParams = new IPCBoolean(((k)g.af(k.class)).a(paramWxappParams.username, paramWxappParams.kXP, paramWxappParams.data, paramWxappParams.path, paramWxappParams.query, paramWxappParams.scene, paramWxappParams.time));
        AppMethodBeat.o(44714);
        return paramWxappParams;
      }
      catch (Exception paramWxappParams)
      {
        Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "SetCall fail", new Object[] { paramWxappParams });
        paramWxappParams = new IPCBoolean(false);
        AppMethodBeat.o(44714);
      }
      return paramWxappParams;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC
 * JD-Core Version:    0.7.0.1
 */
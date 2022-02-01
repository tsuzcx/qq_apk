package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Locale;

public abstract interface ILaunchWxaAppInfoNotify
{
  public static final ILaunchWxaAppInfoNotify kJK = new ILaunchWxaAppInfoNotify()
  {
    private final String TAG = "MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]";
    
    private static String a(au paramAnonymousau)
    {
      AppMethodBeat.i(47171);
      if (paramAnonymousau == null)
      {
        AppMethodBeat.o(47171);
        return "NULL";
      }
      try
      {
        paramAnonymousau = String.format(Locale.US, "bytes[%d]", new Object[] { Integer.valueOf(paramAnonymousau.field_jsapiInfo.CWN.wA.length) });
        AppMethodBeat.o(47171);
        return paramAnonymousau;
      }
      catch (Exception paramAnonymousau)
      {
        paramAnonymousau = String.format(Locale.US, "Exception[%s]", new Object[] { paramAnonymousau });
        AppMethodBeat.o(47171);
      }
      return paramAnonymousau;
    }
    
    public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, au paramAnonymousau)
    {
      AppMethodBeat.i(47170);
      Object localObject = k.Ke(paramAnonymousString2);
      if (localObject != null)
      {
        ad.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousau) });
        ((k)localObject).a(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousau);
      }
      try
      {
        ad.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousau) });
        localObject = new ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper();
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).appId = paramAnonymousString1;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).gXn = paramAnonymousInt;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).cfu = new AppRuntimeApiPermissionBundle(paramAnonymousau.field_jsapiInfo);
        AppBrandLaunchErrorAction.a locala = AppBrandLaunchErrorAction.CREATOR;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).kJL = AppBrandLaunchErrorAction.a.a(paramAnonymousString1, paramAnonymousInt, paramAnonymousau);
        com.tencent.mm.plugin.appbrand.ipc.e.b(paramAnonymousString1, (Parcelable)localObject);
        AppMethodBeat.o(47170);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousau) });
        AppMethodBeat.o(47170);
      }
    }
    
    public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, HashMap<String, AppRuntimeApiPermissionBundle> paramAnonymousHashMap)
    {
      int j = 0;
      AppMethodBeat.i(196008);
      Object localObject = k.Ke(paramAnonymousString2);
      if (localObject != null)
      {
        if (paramAnonymousHashMap == null)
        {
          i = 0;
          ad.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyPluginPermissionInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
          ((k)localObject).a(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousHashMap);
        }
      }
      else {
        if (paramAnonymousHashMap != null) {
          break label163;
        }
      }
      for (int i = 0;; i = paramAnonymousHashMap.size())
      {
        try
        {
          ad.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyPluginPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
          localObject = new ILaunchWxaAppInfoNotify.PluginIpcWrapper();
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).appId = paramAnonymousString1;
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).gXn = paramAnonymousInt;
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).kJM = paramAnonymousHashMap;
          com.tencent.mm.plugin.appbrand.ipc.e.b(paramAnonymousString1, (Parcelable)localObject);
          AppMethodBeat.o(196008);
          return;
        }
        catch (Throwable localThrowable)
        {
          label163:
          if (paramAnonymousHashMap != null) {
            break label226;
          }
        }
        i = paramAnonymousHashMap.size();
        break;
      }
      label226:
      for (i = j;; i = paramAnonymousHashMap.size())
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyPluginPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
        AppMethodBeat.o(196008);
        return;
      }
    }
  };
  
  public abstract void a(String paramString1, int paramInt, String paramString2, au paramau);
  
  public abstract void a(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap);
  
  public static class LaunchInfoIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<LaunchInfoIpcWrapper> CREATOR;
    public String appId;
    public AppRuntimeApiPermissionBundle cfu;
    public int gXn;
    public AppBrandLaunchErrorAction kJL;
    
    static
    {
      AppMethodBeat.i(47175);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47175);
    }
    
    LaunchInfoIpcWrapper() {}
    
    LaunchInfoIpcWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(47174);
      this.appId = paramParcel.readString();
      this.gXn = paramParcel.readInt();
      this.cfu = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.kJL = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
      AppMethodBeat.o(47174);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47173);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.gXn);
      paramParcel.writeParcelable(this.cfu, paramInt);
      paramParcel.writeParcelable(this.kJL, paramInt);
      AppMethodBeat.o(47173);
    }
  }
  
  public static class PluginIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<PluginIpcWrapper> CREATOR;
    public String appId;
    public int gXn;
    public HashMap<String, AppRuntimeApiPermissionBundle> kJM;
    
    static
    {
      AppMethodBeat.i(196012);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(196012);
    }
    
    PluginIpcWrapper() {}
    
    PluginIpcWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(196011);
      this.appId = paramParcel.readString();
      this.gXn = paramParcel.readInt();
      this.kJM = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
      AppMethodBeat.o(196011);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(196010);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.gXn);
      paramParcel.writeMap(this.kJM);
      AppMethodBeat.o(196010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
 * JD-Core Version:    0.7.0.1
 */
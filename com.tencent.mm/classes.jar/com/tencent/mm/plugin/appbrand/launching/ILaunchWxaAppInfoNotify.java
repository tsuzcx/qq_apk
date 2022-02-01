package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Locale;

public abstract interface ILaunchWxaAppInfoNotify
{
  public static final ILaunchWxaAppInfoNotify lIo = new ILaunchWxaAppInfoNotify()
  {
    private final String TAG = "MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]";
    
    private static String a(ax paramAnonymousax)
    {
      AppMethodBeat.i(47171);
      if (paramAnonymousax == null)
      {
        AppMethodBeat.o(47171);
        return "NULL";
      }
      try
      {
        paramAnonymousax = String.format(Locale.US, "bytes[%d]", new Object[] { Integer.valueOf(paramAnonymousax.field_jsapiInfo.FWI.zr.length) });
        AppMethodBeat.o(47171);
        return paramAnonymousax;
      }
      catch (Exception paramAnonymousax)
      {
        paramAnonymousax = String.format(Locale.US, "Exception[%s]", new Object[] { paramAnonymousax });
        AppMethodBeat.o(47171);
      }
      return paramAnonymousax;
    }
    
    public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, ax paramAnonymousax)
    {
      AppMethodBeat.i(47170);
      Object localObject = k.RJ(paramAnonymousString2);
      if (localObject != null)
      {
        ad.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousax) });
        ((k)localObject).a(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousax);
      }
      try
      {
        ad.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousax) });
        localObject = new ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper();
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).appId = paramAnonymousString1;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).hQh = paramAnonymousInt;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).cmI = new AppRuntimeApiPermissionBundle(paramAnonymousax.field_jsapiInfo);
        AppBrandLaunchErrorAction.a locala = AppBrandLaunchErrorAction.CREATOR;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).lIp = AppBrandLaunchErrorAction.a.a(paramAnonymousString1, paramAnonymousInt, paramAnonymousax);
        e.b(paramAnonymousString1, (Parcelable)localObject);
        AppMethodBeat.o(47170);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousax) });
        AppMethodBeat.o(47170);
      }
    }
    
    public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, HashMap<String, AppRuntimeApiPermissionBundle> paramAnonymousHashMap)
    {
      int j = 0;
      AppMethodBeat.i(188610);
      Object localObject = k.RJ(paramAnonymousString2);
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
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).hQh = paramAnonymousInt;
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).lIq = paramAnonymousHashMap;
          e.b(paramAnonymousString1, (Parcelable)localObject);
          AppMethodBeat.o(188610);
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
        AppMethodBeat.o(188610);
        return;
      }
    }
  };
  
  public abstract void a(String paramString1, int paramInt, String paramString2, ax paramax);
  
  public abstract void a(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap);
  
  public static class LaunchInfoIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<LaunchInfoIpcWrapper> CREATOR;
    public String appId;
    public AppRuntimeApiPermissionBundle cmI;
    public int hQh;
    public AppBrandLaunchErrorAction lIp;
    
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
      this.hQh = paramParcel.readInt();
      this.cmI = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.lIp = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
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
      paramParcel.writeInt(this.hQh);
      paramParcel.writeParcelable(this.cmI, paramInt);
      paramParcel.writeParcelable(this.lIp, paramInt);
      AppMethodBeat.o(47173);
    }
  }
  
  public static class PluginIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<PluginIpcWrapper> CREATOR;
    public String appId;
    public int hQh;
    public HashMap<String, AppRuntimeApiPermissionBundle> lIq;
    
    static
    {
      AppMethodBeat.i(188614);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(188614);
    }
    
    PluginIpcWrapper() {}
    
    PluginIpcWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(188613);
      this.appId = paramParcel.readString();
      this.hQh = paramParcel.readInt();
      this.lIq = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
      AppMethodBeat.o(188613);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(188612);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.hQh);
      paramParcel.writeMap(this.lIq);
      AppMethodBeat.o(188612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
 * JD-Core Version:    0.7.0.1
 */
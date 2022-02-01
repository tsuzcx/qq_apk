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
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Locale;

public abstract interface ILaunchWxaAppInfoNotify
{
  public static final ILaunchWxaAppInfoNotify llg = new ILaunchWxaAppInfoNotify()
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
        paramAnonymousau = String.format(Locale.US, "bytes[%d]", new Object[] { Integer.valueOf(paramAnonymousau.field_jsapiInfo.Epw.xy.length) });
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
      Object localObject = k.Ol(paramAnonymousString2);
      if (localObject != null)
      {
        ac.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousau) });
        ((k)localObject).a(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousau);
      }
      try
      {
        ac.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousau) });
        localObject = new ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper();
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).appId = paramAnonymousString1;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).hxM = paramAnonymousInt;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).ccr = new AppRuntimeApiPermissionBundle(paramAnonymousau.field_jsapiInfo);
        AppBrandLaunchErrorAction.a locala = AppBrandLaunchErrorAction.CREATOR;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).llh = AppBrandLaunchErrorAction.a.a(paramAnonymousString1, paramAnonymousInt, paramAnonymousau);
        com.tencent.mm.plugin.appbrand.ipc.e.b(paramAnonymousString1, (Parcelable)localObject);
        AppMethodBeat.o(47170);
        return;
      }
      catch (Throwable localThrowable)
      {
        ac.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousau) });
        AppMethodBeat.o(47170);
      }
    }
    
    public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, HashMap<String, AppRuntimeApiPermissionBundle> paramAnonymousHashMap)
    {
      int j = 0;
      AppMethodBeat.i(186832);
      Object localObject = k.Ol(paramAnonymousString2);
      if (localObject != null)
      {
        if (paramAnonymousHashMap == null)
        {
          i = 0;
          ac.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyPluginPermissionInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
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
          ac.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyPluginPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
          localObject = new ILaunchWxaAppInfoNotify.PluginIpcWrapper();
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).appId = paramAnonymousString1;
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).hxM = paramAnonymousInt;
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).lli = paramAnonymousHashMap;
          com.tencent.mm.plugin.appbrand.ipc.e.b(paramAnonymousString1, (Parcelable)localObject);
          AppMethodBeat.o(186832);
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
        ac.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyPluginPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
        AppMethodBeat.o(186832);
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
    public AppRuntimeApiPermissionBundle ccr;
    public int hxM;
    public AppBrandLaunchErrorAction llh;
    
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
      this.hxM = paramParcel.readInt();
      this.ccr = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.llh = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
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
      paramParcel.writeInt(this.hxM);
      paramParcel.writeParcelable(this.ccr, paramInt);
      paramParcel.writeParcelable(this.llh, paramInt);
      AppMethodBeat.o(47173);
    }
  }
  
  public static class PluginIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<PluginIpcWrapper> CREATOR;
    public String appId;
    public int hxM;
    public HashMap<String, AppRuntimeApiPermissionBundle> lli;
    
    static
    {
      AppMethodBeat.i(186836);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(186836);
    }
    
    PluginIpcWrapper() {}
    
    PluginIpcWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(186835);
      this.appId = paramParcel.readString();
      this.hxM = paramParcel.readInt();
      this.lli = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
      AppMethodBeat.o(186835);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(186834);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.hxM);
      paramParcel.writeMap(this.lli);
      AppMethodBeat.o(186834);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
 * JD-Core Version:    0.7.0.1
 */
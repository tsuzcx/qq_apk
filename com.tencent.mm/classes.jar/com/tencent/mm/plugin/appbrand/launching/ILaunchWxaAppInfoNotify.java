package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC.26;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract interface ILaunchWxaAppInfoNotify
{
  public static final ILaunchWxaAppInfoNotify tal = new ILaunchWxaAppInfoNotify()
  {
    private final String TAG = "MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]";
    
    private static String a(ak paramAnonymousak)
    {
      AppMethodBeat.i(47171);
      if (paramAnonymousak == null)
      {
        AppMethodBeat.o(47171);
        return "NULL";
      }
      try
      {
        paramAnonymousak = String.format(Locale.US, "bytes[%d]", new Object[] { Integer.valueOf(paramAnonymousak.field_jsapiInfo.Zjj.Op.length) });
        AppMethodBeat.o(47171);
        return paramAnonymousak;
      }
      catch (Exception paramAnonymousak)
      {
        paramAnonymousak = String.format(Locale.US, "Exception[%s]", new Object[] { paramAnonymousak });
        AppMethodBeat.o(47171);
      }
      return paramAnonymousak;
    }
    
    public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, ak paramAnonymousak, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      AppMethodBeat.i(320668);
      Object localObject = k.acV(paramAnonymousString2);
      if (localObject != null)
      {
        Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousak) });
        ((k)localObject).a(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousak, paramAnonymousBoolean1, paramAnonymousBoolean2);
      }
      try
      {
        Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousak) });
        localObject = new ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper();
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).appId = paramAnonymousString1;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).euz = paramAnonymousInt;
        AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = new AppRuntimeApiPermissionBundle(paramAnonymousak.field_jsapiInfo);
        AppBrandLaunchErrorAction.a locala = AppBrandLaunchErrorAction.CREATOR;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).epC = new LaunchWxaAppInfoParcelized(localAppRuntimeApiPermissionBundle, AppBrandLaunchErrorAction.a.a(paramAnonymousString1, paramAnonymousInt, paramAnonymousak), paramAnonymousak.field_opConfig, paramAnonymousBoolean1, paramAnonymousBoolean2);
        com.tencent.mm.plugin.appbrand.ipc.f.b(paramAnonymousString1, (Parcelable)localObject);
        AppMethodBeat.o(320668);
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousak) });
        AppMethodBeat.o(320668);
      }
    }
    
    public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, HashMap<String, AppRuntimeApiPermissionBundle> paramAnonymousHashMap)
    {
      int j = 0;
      AppMethodBeat.i(320673);
      Object localObject = k.acV(paramAnonymousString2);
      if (localObject != null)
      {
        if (paramAnonymousHashMap == null)
        {
          i = 0;
          Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyPluginPermissionInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
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
          Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyPluginPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
          localObject = new ILaunchWxaAppInfoNotify.PluginIpcWrapper();
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).appId = paramAnonymousString1;
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).euz = paramAnonymousInt;
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).tan = paramAnonymousHashMap;
          com.tencent.mm.plugin.appbrand.ipc.f.b(paramAnonymousString1, (Parcelable)localObject);
          AppMethodBeat.o(320673);
          return;
        }
        finally
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
        Log.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyPluginPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
        AppMethodBeat.o(320673);
        return;
      }
    }
    
    public final void b(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, HashMap<String, AppRuntimeAppidABTestPermissionBundle> paramAnonymousHashMap)
    {
      int j = 0;
      AppMethodBeat.i(320679);
      Object localObject = k.acV(paramAnonymousString2);
      if (localObject != null)
      {
        if (paramAnonymousHashMap == null)
        {
          i = 0;
          Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyAppidABTestPermissionInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], appidABTestMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
          ((k)localObject).b(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousHashMap);
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
          Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyAppidABTestPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], appidABTestMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
          localObject = new ILaunchWxaAppInfoNotify.AppidABTestIpcWrapper();
          ((ILaunchWxaAppInfoNotify.AppidABTestIpcWrapper)localObject).appId = paramAnonymousString1;
          ((ILaunchWxaAppInfoNotify.AppidABTestIpcWrapper)localObject).euz = paramAnonymousInt;
          ((ILaunchWxaAppInfoNotify.AppidABTestIpcWrapper)localObject).tam = paramAnonymousHashMap;
          com.tencent.mm.plugin.appbrand.ipc.f.b(paramAnonymousString1, (Parcelable)localObject);
          AppMethodBeat.o(320679);
          return;
        }
        finally
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
        Log.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyAppidABTestPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], appidABTestMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
        AppMethodBeat.o(320679);
        return;
      }
    }
  };
  
  public abstract void a(String paramString1, int paramInt, String paramString2, ak paramak, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap);
  
  public abstract void b(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeAppidABTestPermissionBundle> paramHashMap);
  
  public static class AppidABTestIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<AppidABTestIpcWrapper> CREATOR;
    public String appId;
    public int euz;
    public HashMap<String, AppRuntimeAppidABTestPermissionBundle> tam;
    
    static
    {
      AppMethodBeat.i(320885);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(320885);
    }
    
    AppidABTestIpcWrapper() {}
    
    AppidABTestIpcWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(320882);
      this.appId = paramParcel.readString();
      this.euz = paramParcel.readInt();
      this.tam = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
      AppMethodBeat.o(320882);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(320897);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.euz);
      paramParcel.writeMap(this.tam);
      AppMethodBeat.o(320897);
    }
  }
  
  public static class LaunchInfoIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<LaunchInfoIpcWrapper> CREATOR;
    public String appId;
    public LaunchWxaAppInfoParcelized epC;
    public int euz;
    
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
      this.euz = paramParcel.readInt();
      this.epC = ((LaunchWxaAppInfoParcelized)paramParcel.readParcelable(LaunchWxaAppInfoParcelized.class.getClassLoader()));
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
      paramParcel.writeInt(this.euz);
      paramParcel.writeParcelable(this.epC, paramInt);
      AppMethodBeat.o(47173);
    }
  }
  
  public static class PluginIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<PluginIpcWrapper> CREATOR;
    public String appId;
    public int euz;
    public HashMap<String, AppRuntimeApiPermissionBundle> tan;
    
    static
    {
      AppMethodBeat.i(320792);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(320792);
    }
    
    PluginIpcWrapper() {}
    
    PluginIpcWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(320788);
      this.appId = paramParcel.readString();
      this.euz = paramParcel.readInt();
      this.tan = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
      AppMethodBeat.o(320788);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(320798);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.euz);
      paramParcel.writeMap(this.tan);
      AppMethodBeat.o(320798);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
 * JD-Core Version:    0.7.0.1
 */
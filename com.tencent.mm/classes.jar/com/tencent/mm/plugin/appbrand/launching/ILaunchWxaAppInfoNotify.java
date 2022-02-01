package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import java.util.Locale;

public abstract interface ILaunchWxaAppInfoNotify
{
  public static final ILaunchWxaAppInfoNotify mUz = new ILaunchWxaAppInfoNotify()
  {
    private final String TAG = "MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]";
    
    private static String a(ap paramAnonymousap)
    {
      AppMethodBeat.i(47171);
      if (paramAnonymousap == null)
      {
        AppMethodBeat.o(47171);
        return "NULL";
      }
      try
      {
        paramAnonymousap = String.format(Locale.US, "bytes[%d]", new Object[] { Integer.valueOf(paramAnonymousap.field_jsapiInfo.LjS.zy.length) });
        AppMethodBeat.o(47171);
        return paramAnonymousap;
      }
      catch (Exception paramAnonymousap)
      {
        paramAnonymousap = String.format(Locale.US, "Exception[%s]", new Object[] { paramAnonymousap });
        AppMethodBeat.o(47171);
      }
      return paramAnonymousap;
    }
    
    public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, ap paramAnonymousap)
    {
      AppMethodBeat.i(47170);
      Object localObject = k.abY(paramAnonymousString2);
      if (localObject != null)
      {
        Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update deferred process] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousap) });
        ((k)localObject).a(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousap);
      }
      try
      {
        Log.i("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousap) });
        localObject = new ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper();
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).appId = paramAnonymousString1;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).iOo = paramAnonymousInt;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).cyG = new AppRuntimeApiPermissionBundle(paramAnonymousap.field_jsapiInfo);
        AppBrandLaunchErrorAction.a locala = AppBrandLaunchErrorAction.CREATOR;
        ((ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)localObject).mUB = AppBrandLaunchErrorAction.a.a(paramAnonymousString1, paramAnonymousInt, paramAnonymousap);
        e.b(paramAnonymousString1, (Parcelable)localObject);
        AppMethodBeat.o(47170);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyLaunchInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, a(paramAnonymousap) });
        AppMethodBeat.o(47170);
      }
    }
    
    public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, HashMap<String, AppRuntimeApiPermissionBundle> paramAnonymousHashMap)
    {
      int j = 0;
      AppMethodBeat.i(227082);
      Object localObject = k.abY(paramAnonymousString2);
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
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).iOo = paramAnonymousInt;
          ((ILaunchWxaAppInfoNotify.PluginIpcWrapper)localObject).mUC = paramAnonymousHashMap;
          e.b(paramAnonymousString1, (Parcelable)localObject);
          AppMethodBeat.o(227082);
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
        Log.printErrStackTrace("MicroMsg.AppBrand.ILaunchWxaAppInfoNotify.INSTANCE[permission]", localThrowable, "notifyPluginPermissionInfoUpdate [update remote] appId[%s], type[%d], sessionId[%s], pluginMapSize:[%d]", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, Integer.valueOf(i) });
        AppMethodBeat.o(227082);
        return;
      }
    }
  };
  
  public abstract void a(String paramString1, int paramInt, String paramString2, ap paramap);
  
  public abstract void a(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap);
  
  public static class LaunchInfoIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<LaunchInfoIpcWrapper> CREATOR;
    public String appId;
    public AppRuntimeApiPermissionBundle cyG;
    public int iOo;
    public AppBrandLaunchErrorAction mUB;
    
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
      this.iOo = paramParcel.readInt();
      this.cyG = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.mUB = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
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
      paramParcel.writeInt(this.iOo);
      paramParcel.writeParcelable(this.cyG, paramInt);
      paramParcel.writeParcelable(this.mUB, paramInt);
      AppMethodBeat.o(47173);
    }
  }
  
  public static class PluginIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<PluginIpcWrapper> CREATOR;
    public String appId;
    public int iOo;
    public HashMap<String, AppRuntimeApiPermissionBundle> mUC;
    
    static
    {
      AppMethodBeat.i(227086);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(227086);
    }
    
    PluginIpcWrapper() {}
    
    PluginIpcWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(227085);
      this.appId = paramParcel.readString();
      this.iOo = paramParcel.readInt();
      this.mUC = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
      AppMethodBeat.o(227085);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(227084);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.iOo);
      paramParcel.writeMap(this.mUC);
      AppMethodBeat.o(227084);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
 * JD-Core Version:    0.7.0.1
 */
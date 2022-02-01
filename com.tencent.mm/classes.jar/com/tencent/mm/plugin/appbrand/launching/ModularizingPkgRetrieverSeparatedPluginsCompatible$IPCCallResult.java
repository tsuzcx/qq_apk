package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "callbackType", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "result", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "succeed", "", "errCode", "errMsg", "", "(ILcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;Ljava/util/List;ZILjava/lang/String;)V", "getCallbackType", "()I", "setCallbackType", "(I)V", "getErrCode", "setErrCode", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getProgress", "()Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "setProgress", "(Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;)V", "getResult", "()Ljava/util/List;", "setResult", "(Ljava/util/List;)V", "getSucceed", "()Z", "setSucceed", "(Z)V", "describeContents", "readFromParcel", "", "writeToParcel", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
final class ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult
  implements Parcelable
{
  public static final Parcelable.Creator<IPCCallResult> CREATOR;
  public static final a pWS;
  private int errCode;
  private String errMsg;
  boolean fPd;
  int pWP;
  WxaPkgLoadProgress pWQ;
  List<? extends IPkgInfo> pWR;
  
  static
  {
    AppMethodBeat.i(180629);
    pWS = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(180629);
  }
  
  private ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult(int paramInt1, WxaPkgLoadProgress paramWxaPkgLoadProgress, List<? extends IPkgInfo> paramList, boolean paramBoolean, int paramInt2, String paramString)
  {
    this.pWP = paramInt1;
    this.pWQ = paramWxaPkgLoadProgress;
    this.pWR = paramList;
    this.fPd = paramBoolean;
    this.errCode = paramInt2;
    this.errMsg = paramString;
  }
  
  public ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult(Parcel paramParcel)
  {
    this(0, null, null, false, 0, null, 62);
    AppMethodBeat.i(180628);
    p.k(paramParcel, "source");
    this.pWP = paramParcel.readInt();
    switch (this.pWP)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(180628);
      return;
      this.pWQ = ((WxaPkgLoadProgress)paramParcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader()));
      AppMethodBeat.o(180628);
      return;
      Object localObject = ModularizingPkgRetrieverSeparatedPluginsCompatible.pWK;
      int j = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localObject = paramParcel.readString();
        if (p.h(localObject, ModulePkgInfo.class.getName())) {
          localObject = ModulePkgInfo.class.getClassLoader();
        }
        for (;;)
        {
          if (localObject == null) {
            p.iCn();
          }
          localObject = paramParcel.readParcelable((ClassLoader)localObject);
          if (localObject != null) {
            break;
          }
          paramParcel = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.IPkgInfo");
          AppMethodBeat.o(180628);
          throw paramParcel;
          if (p.h(localObject, WxaPluginPkgInfo.class.getName())) {
            localObject = WxaPluginPkgInfo.class.getClassLoader();
          } else {
            localObject = null;
          }
        }
        localArrayList.add((IPkgInfo)localObject);
        i += 1;
      }
      this.pWR = ((List)localArrayList);
      if (paramParcel.readByte() > 0) {
        bool = true;
      }
      this.fPd = bool;
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(180626);
    p.k(paramParcel, "dest");
    paramParcel.writeInt(this.pWP);
    switch (this.pWP)
    {
    default: 
      AppMethodBeat.o(180626);
      return;
    case 1: 
      paramParcel.writeParcelable((Parcelable)this.pWQ, 0);
      AppMethodBeat.o(180626);
      return;
    }
    Object localObject1 = ModularizingPkgRetrieverSeparatedPluginsCompatible.pWK;
    Object localObject2 = this.pWR;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.aaAd;
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label188:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      Parcelable localParcelable = (Parcelable)localObject3;
      if (((localParcelable instanceof ModulePkgInfo)) || ((localParcelable instanceof WxaPluginPkgInfo))) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label188;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = (List)localObject1;
    paramParcel.writeInt(((List)localObject1).size());
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Parcelable)((Iterator)localObject1).next();
      paramParcel.writeString(localObject2.getClass().getName());
      paramParcel.writeParcelable((Parcelable)localObject2, 0);
    }
    if (this.fPd) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "plugin-appbrand-integration_release"})
  public static final class b
    implements Parcelable.Creator<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult
 * JD-Core Version:    0.7.0.1
 */
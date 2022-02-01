package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandStorageQuotaManager$CleanupTempFilesOnExitParams;", "Landroid/os/Parcelable;", "appId", "", "minTempSize", "", "maxTempSize", "maxTotalTempSize", "storageKey2Path", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "report", "", "appVersion", "appState", "", "appType", "storageSpaceStatisticsEnable", "supportRuntimeSpaceStaticsMap", "", "", "(Ljava/lang/String;JJJLjava/util/HashMap;ZJIJZLjava/util/Map;)V", "getAppId", "()Ljava/lang/String;", "getAppState", "()I", "getAppType", "()J", "getAppVersion", "getMaxTempSize", "getMaxTotalTempSize", "getMinTempSize", "getReport", "()Z", "getStorageKey2Path", "()Ljava/util/HashMap;", "getStorageSpaceStatisticsEnable", "getSupportRuntimeSpaceStaticsMap", "()Ljava/util/Map;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandStorageQuotaManager$CleanupTempFilesOnExitParams
  implements Parcelable
{
  public static final Parcelable.Creator<CleanupTempFilesOnExitParams> CREATOR;
  final String appId;
  final int hzw;
  final long qMA;
  final long qMB;
  final boolean qMC;
  final HashMap<String, String> qMu;
  final Map<String, List<String>> qMv;
  final long qMw;
  final long qMx;
  final long qMy;
  final boolean qMz;
  
  static
  {
    AppMethodBeat.i(323163);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(323163);
  }
  
  public AppBrandStorageQuotaManager$CleanupTempFilesOnExitParams(String paramString, long paramLong1, long paramLong2, long paramLong3, HashMap<String, String> paramHashMap, boolean paramBoolean1, long paramLong4, int paramInt, long paramLong5, boolean paramBoolean2, Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(323155);
    this.appId = paramString;
    this.qMw = paramLong1;
    this.qMx = paramLong2;
    this.qMy = paramLong3;
    this.qMu = paramHashMap;
    this.qMz = paramBoolean1;
    this.qMA = paramLong4;
    this.hzw = paramInt;
    this.qMB = paramLong5;
    this.qMC = paramBoolean2;
    this.qMv = paramMap;
    AppMethodBeat.o(323155);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(323179);
    if (this == paramObject)
    {
      AppMethodBeat.o(323179);
      return true;
    }
    if (!(paramObject instanceof CleanupTempFilesOnExitParams))
    {
      AppMethodBeat.o(323179);
      return false;
    }
    paramObject = (CleanupTempFilesOnExitParams)paramObject;
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(323179);
      return false;
    }
    if (this.qMw != paramObject.qMw)
    {
      AppMethodBeat.o(323179);
      return false;
    }
    if (this.qMx != paramObject.qMx)
    {
      AppMethodBeat.o(323179);
      return false;
    }
    if (this.qMy != paramObject.qMy)
    {
      AppMethodBeat.o(323179);
      return false;
    }
    if (!s.p(this.qMu, paramObject.qMu))
    {
      AppMethodBeat.o(323179);
      return false;
    }
    if (this.qMz != paramObject.qMz)
    {
      AppMethodBeat.o(323179);
      return false;
    }
    if (this.qMA != paramObject.qMA)
    {
      AppMethodBeat.o(323179);
      return false;
    }
    if (this.hzw != paramObject.hzw)
    {
      AppMethodBeat.o(323179);
      return false;
    }
    if (this.qMB != paramObject.qMB)
    {
      AppMethodBeat.o(323179);
      return false;
    }
    if (this.qMC != paramObject.qMC)
    {
      AppMethodBeat.o(323179);
      return false;
    }
    if (!s.p(this.qMv, paramObject.qMv))
    {
      AppMethodBeat.o(323179);
      return false;
    }
    AppMethodBeat.o(323179);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(323170);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CleanupTempFilesOnExitParams(appId=").append(this.appId).append(", minTempSize=").append(this.qMw).append(", maxTempSize=").append(this.qMx).append(", maxTotalTempSize=").append(this.qMy).append(", storageKey2Path=").append(this.qMu).append(", report=").append(this.qMz).append(", appVersion=").append(this.qMA).append(", appState=").append(this.hzw).append(", appType=").append(this.qMB).append(", storageSpaceStatisticsEnable=").append(this.qMC).append(", supportRuntimeSpaceStaticsMap=").append(this.qMv).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(323170);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(323187);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.appId);
    paramParcel.writeLong(this.qMw);
    paramParcel.writeLong(this.qMx);
    paramParcel.writeLong(this.qMy);
    Object localObject1 = this.qMu;
    paramParcel.writeInt(((HashMap)localObject1).size());
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      paramParcel.writeString((String)((Map.Entry)localObject2).getKey());
      paramParcel.writeString((String)((Map.Entry)localObject2).getValue());
    }
    if (this.qMz)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.qMA);
      paramParcel.writeInt(this.hzw);
      paramParcel.writeLong(this.qMB);
      if (!this.qMC) {
        break label272;
      }
    }
    label272:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      localObject1 = this.qMv;
      paramParcel.writeInt(((Map)localObject1).size());
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        paramParcel.writeString((String)((Map.Entry)localObject2).getKey());
        paramParcel.writeStringList((List)((Map.Entry)localObject2).getValue());
      }
      paramInt = 0;
      break;
    }
    AppMethodBeat.o(323187);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams
 * JD-Core Version:    0.7.0.1
 */
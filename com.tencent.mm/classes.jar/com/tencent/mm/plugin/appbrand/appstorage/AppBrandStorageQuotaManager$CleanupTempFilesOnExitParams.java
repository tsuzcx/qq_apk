package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandStorageQuotaManager$CleanupTempFilesOnExitParams;", "Landroid/os/Parcelable;", "appId", "", "minTempSize", "", "maxTempSize", "maxTotalTempSize", "storageKey2Path", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "report", "", "appVersion", "appState", "", "appType", "storageSpaceStatisticsEnable", "supportRuntimeSpaceStaticsMap", "", "", "(Ljava/lang/String;JJJLjava/util/HashMap;ZJIJZLjava/util/Map;)V", "getAppId", "()Ljava/lang/String;", "getAppState", "()I", "getAppType", "()J", "getAppVersion", "getMaxTempSize", "getMaxTotalTempSize", "getMinTempSize", "getReport", "()Z", "getStorageKey2Path", "()Ljava/util/HashMap;", "getStorageSpaceStatisticsEnable", "getSupportRuntimeSpaceStaticsMap", "()Ljava/util/Map;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class AppBrandStorageQuotaManager$CleanupTempFilesOnExitParams
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  final String appId;
  final int fvc;
  final long nMA;
  final long nMB;
  final boolean nMC;
  final HashMap<String, String> nMt;
  final Map<String, List<String>> nMu;
  final long nMw;
  final long nMx;
  final long nMy;
  final boolean nMz;
  
  static
  {
    AppMethodBeat.i(276657);
    CREATOR = new a();
    AppMethodBeat.o(276657);
  }
  
  public AppBrandStorageQuotaManager$CleanupTempFilesOnExitParams(String paramString, long paramLong1, long paramLong2, long paramLong3, HashMap<String, String> paramHashMap, boolean paramBoolean1, long paramLong4, int paramInt, long paramLong5, boolean paramBoolean2, Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(276643);
    this.appId = paramString;
    this.nMw = paramLong1;
    this.nMx = paramLong2;
    this.nMy = paramLong3;
    this.nMt = paramHashMap;
    this.nMz = paramBoolean1;
    this.nMA = paramLong4;
    this.fvc = paramInt;
    this.nMB = paramLong5;
    this.nMC = paramBoolean2;
    this.nMu = paramMap;
    AppMethodBeat.o(276643);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(276651);
    if (this != paramObject)
    {
      if ((paramObject instanceof CleanupTempFilesOnExitParams))
      {
        paramObject = (CleanupTempFilesOnExitParams)paramObject;
        if ((!p.h(this.appId, paramObject.appId)) || (this.nMw != paramObject.nMw) || (this.nMx != paramObject.nMx) || (this.nMy != paramObject.nMy) || (!p.h(this.nMt, paramObject.nMt)) || (this.nMz != paramObject.nMz) || (this.nMA != paramObject.nMA) || (this.fvc != paramObject.fvc) || (this.nMB != paramObject.nMB) || (this.nMC != paramObject.nMC) || (!p.h(this.nMu, paramObject.nMu))) {}
      }
    }
    else
    {
      AppMethodBeat.o(276651);
      return true;
    }
    AppMethodBeat.o(276651);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(276646);
    String str = "CleanupTempFilesOnExitParams(appId=" + this.appId + ", minTempSize=" + this.nMw + ", maxTempSize=" + this.nMx + ", maxTotalTempSize=" + this.nMy + ", storageKey2Path=" + this.nMt + ", report=" + this.nMz + ", appVersion=" + this.nMA + ", appState=" + this.fvc + ", appType=" + this.nMB + ", storageSpaceStatisticsEnable=" + this.nMC + ", supportRuntimeSpaceStaticsMap=" + this.nMu + ")";
    AppMethodBeat.o(276646);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(268328);
      p.k(paramParcel, "in");
      String str = paramParcel.readString();
      long l1 = paramParcel.readLong();
      long l2 = paramParcel.readLong();
      long l3 = paramParcel.readLong();
      int i = paramParcel.readInt();
      HashMap localHashMap = new HashMap(i);
      while (i != 0)
      {
        localHashMap.put(paramParcel.readString(), paramParcel.readString());
        i -= 1;
      }
      boolean bool1;
      long l4;
      int j;
      long l5;
      if (paramParcel.readInt() != 0)
      {
        bool1 = true;
        l4 = paramParcel.readLong();
        j = paramParcel.readInt();
        l5 = paramParcel.readLong();
        if (paramParcel.readInt() == 0) {
          break label165;
        }
      }
      LinkedHashMap localLinkedHashMap;
      label165:
      for (boolean bool2 = true;; bool2 = false)
      {
        i = paramParcel.readInt();
        localLinkedHashMap = new LinkedHashMap(i);
        while (i != 0)
        {
          localLinkedHashMap.put(paramParcel.readString(), (List)paramParcel.createStringArrayList());
          i -= 1;
        }
        bool1 = false;
        break;
      }
      paramParcel = new AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams(str, l1, l2, l3, localHashMap, bool1, l4, j, l5, bool2, localLinkedHashMap);
      AppMethodBeat.o(268328);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandStorageQuotaManager.CleanupTempFilesOnExitParams
 * JD-Core Version:    0.7.0.1
 */
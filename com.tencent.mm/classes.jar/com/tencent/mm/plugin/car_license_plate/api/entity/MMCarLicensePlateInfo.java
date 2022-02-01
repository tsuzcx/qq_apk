package com.tencent.mm.plugin.car_license_plate.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "Landroid/os/Parcelable;", "plateNoList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "defaultPlateNo", "isModifyBanned", "", "maxCount", "", "(Ljava/util/ArrayList;Ljava/lang/String;ZI)V", "getDefaultPlateNo", "()Ljava/lang/String;", "setDefaultPlateNo", "(Ljava/lang/String;)V", "()Z", "setModifyBanned", "(Z)V", "getMaxCount", "()I", "setMaxCount", "(I)V", "getPlateNoList", "()Ljava/util/ArrayList;", "setPlateNoList", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMCarLicensePlateInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MMCarLicensePlateInfo> CREATOR;
  public static final MMCarLicensePlateInfo.a wbJ;
  private int lyL;
  public ArrayList<String> wbK;
  public String wbL;
  private boolean wbM;
  
  static
  {
    AppMethodBeat.i(277597);
    wbJ = new MMCarLicensePlateInfo.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(277597);
  }
  
  private MMCarLicensePlateInfo(byte paramByte)
  {
    this();
  }
  
  public MMCarLicensePlateInfo(ArrayList<String> paramArrayList, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(277582);
    this.wbK = paramArrayList;
    this.wbL = paramString;
    this.wbM = paramBoolean;
    this.lyL = paramInt;
    AppMethodBeat.o(277582);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277612);
    if (this == paramObject)
    {
      AppMethodBeat.o(277612);
      return true;
    }
    if (!(paramObject instanceof MMCarLicensePlateInfo))
    {
      AppMethodBeat.o(277612);
      return false;
    }
    paramObject = (MMCarLicensePlateInfo)paramObject;
    if (!s.p(this.wbK, paramObject.wbK))
    {
      AppMethodBeat.o(277612);
      return false;
    }
    if (!s.p(this.wbL, paramObject.wbL))
    {
      AppMethodBeat.o(277612);
      return false;
    }
    if (this.wbM != paramObject.wbM)
    {
      AppMethodBeat.o(277612);
      return false;
    }
    if (this.lyL != paramObject.lyL)
    {
      AppMethodBeat.o(277612);
      return false;
    }
    AppMethodBeat.o(277612);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277602);
    String str = "MMCarLicensePlateInfo(plateNoList=" + this.wbK + ", defaultPlateNo=" + this.wbL + ", isModifyBanned=" + this.wbM + ", maxCount=" + this.lyL + ')';
    AppMethodBeat.o(277602);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277623);
    s.u(paramParcel, "out");
    paramParcel.writeStringList((List)this.wbK);
    paramParcel.writeString(this.wbL);
    if (this.wbM) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.lyL);
      AppMethodBeat.o(277623);
      return;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<MMCarLicensePlateInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.api.entity.MMCarLicensePlateInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.car_license_plate.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "Landroid/os/Parcelable;", "plateNoList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "defaultPlateNo", "isModifyBanned", "", "maxCount", "", "(Ljava/util/ArrayList;Ljava/lang/String;ZI)V", "getDefaultPlateNo", "()Ljava/lang/String;", "setDefaultPlateNo", "(Ljava/lang/String;)V", "()Z", "setModifyBanned", "(Z)V", "getMaxCount", "()I", "setMaxCount", "(I)V", "getPlateNoList", "()Ljava/util/ArrayList;", "setPlateNoList", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-car-license-plate_release"})
public final class MMCarLicensePlateInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public static final a sXu;
  private int iWH;
  public ArrayList<String> sXr;
  public String sXs;
  private boolean sXt;
  
  static
  {
    AppMethodBeat.i(187196);
    sXu = new a((byte)0);
    CREATOR = new b();
    AppMethodBeat.o(187196);
  }
  
  private MMCarLicensePlateInfo(byte paramByte)
  {
    this();
  }
  
  public MMCarLicensePlateInfo(ArrayList<String> paramArrayList, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(187177);
    this.sXr = paramArrayList;
    this.sXs = paramString;
    this.sXt = paramBoolean;
    this.iWH = paramInt;
    AppMethodBeat.o(187177);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187213);
    if (this != paramObject)
    {
      if ((paramObject instanceof MMCarLicensePlateInfo))
      {
        paramObject = (MMCarLicensePlateInfo)paramObject;
        if ((!p.h(this.sXr, paramObject.sXr)) || (!p.h(this.sXs, paramObject.sXs)) || (this.sXt != paramObject.sXt) || (this.iWH != paramObject.iWH)) {}
      }
    }
    else
    {
      AppMethodBeat.o(187213);
      return true;
    }
    AppMethodBeat.o(187213);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187204);
    String str = "MMCarLicensePlateInfo(plateNoList=" + this.sXr + ", defaultPlateNo=" + this.sXs + ", isModifyBanned=" + this.sXt + ", maxCount=" + this.iWH + ")";
    AppMethodBeat.o(187204);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo$Companion;", "", "()V", "fromPBObj", "Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "pb", "Lcom/tencent/mm/protocal/protobuf/UserPlateInfo;", "plugin-car-license-plate_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16})
  public static final class b
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(186987);
      p.k(paramParcel, "in");
      int i = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(i);
      while (i != 0)
      {
        localArrayList.add(paramParcel.readString());
        i -= 1;
      }
      String str = paramParcel.readString();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramParcel = new MMCarLicensePlateInfo(localArrayList, str, bool, paramParcel.readInt());
        AppMethodBeat.o(186987);
        return paramParcel;
      }
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new MMCarLicensePlateInfo[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.api.entity.MMCarLicensePlateInfo
 * JD-Core Version:    0.7.0.1
 */
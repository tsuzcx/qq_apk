package com.tencent.mm.plugin.car_license_plate.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.car_license_plate.api.entity.MMCarLicensePlateInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract;", "", "Presenter", "ViewCallback", "ViewModel", "plugin-car-license-plate_release"})
public abstract interface CarLicensePlateListViewContract
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewModel;", "Landroid/os/Parcelable;", "cachedData", "Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "callbackAfterCreated", "", "hostWxaAppId", "", "(Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;ZLjava/lang/String;)V", "getCachedData", "()Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "setCachedData", "(Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;)V", "getCallbackAfterCreated", "()Z", "setCallbackAfterCreated", "(Z)V", "getHostWxaAppId", "()Ljava/lang/String;", "setHostWxaAppId", "(Ljava/lang/String;)V", "append", "", "plate", "describeContents", "", "replace", "oldPlate", "newPlate", "replaceList", "newPlateNoList", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-car-license-plate_release"})
  public static final class ViewModel
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    static final MMCarLicensePlateInfo sYZ;
    public static final a sZa;
    public String nIo;
    public MMCarLicensePlateInfo sYX;
    public boolean sYY;
    
    static
    {
      AppMethodBeat.i(186240);
      sZa = new a((byte)0);
      CREATOR = new b();
      AppMethodBeat.o(186240);
    }
    
    private ViewModel(byte paramByte)
    {
      this();
    }
    
    public ViewModel(MMCarLicensePlateInfo paramMMCarLicensePlateInfo, boolean paramBoolean, String paramString)
    {
      this.sYX = paramMMCarLicensePlateInfo;
      this.sYY = paramBoolean;
      this.nIo = paramString;
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(186235);
      p.k(paramString, "plate");
      if (p.h(sYZ, this.sYX))
      {
        localMMCarLicensePlateInfo = new MMCarLicensePlateInfo();
        localMMCarLicensePlateInfo.sXr.add(paramString);
        this.sYX = localMMCarLicensePlateInfo;
        AppMethodBeat.o(186235);
        return;
      }
      MMCarLicensePlateInfo localMMCarLicensePlateInfo = this.sYX;
      if (localMMCarLicensePlateInfo == null) {
        p.iCn();
      }
      localMMCarLicensePlateInfo.sXr.add(paramString);
      AppMethodBeat.o(186235);
    }
    
    public final void bR(List<String> paramList)
    {
      AppMethodBeat.i(186238);
      if (p.h(sYZ, this.sYX)) {
        this.sYX = new MMCarLicensePlateInfo();
      }
      Object localObject = this.sYX;
      if (localObject == null) {
        p.iCn();
      }
      ((MMCarLicensePlateInfo)localObject).sXr.clear();
      localObject = ((MMCarLicensePlateInfo)localObject).sXr;
      if (paramList == null) {
        paramList = (List)v.aaAd;
      }
      for (;;)
      {
        ((ArrayList)localObject).addAll((Collection)paramList);
        AppMethodBeat.o(186238);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewModel$Companion;", "", "()V", "NO_CACHE", "Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "getNO_CACHE", "()Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "plugin-car-license-plate_release"})
    public static final class a {}
    
    @l(iBK={1, 1, 16})
    public static final class b
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(187526);
        p.k(paramParcel, "in");
        MMCarLicensePlateInfo localMMCarLicensePlateInfo;
        if (paramParcel.readInt() != 0)
        {
          localMMCarLicensePlateInfo = (MMCarLicensePlateInfo)MMCarLicensePlateInfo.CREATOR.createFromParcel(paramParcel);
          if (paramParcel.readInt() == 0) {
            break label66;
          }
        }
        label66:
        for (boolean bool = true;; bool = false)
        {
          paramParcel = new CarLicensePlateListViewContract.ViewModel(localMMCarLicensePlateInfo, bool, paramParcel.readString());
          AppMethodBeat.o(187526);
          return paramParcel;
          localMMCarLicensePlateInfo = null;
          break;
        }
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new CarLicensePlateListViewContract.ViewModel[paramInt];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.car_license_plate.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.car_license_plate.api.entity.MMCarLicensePlateInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewModel;", "Landroid/os/Parcelable;", "cachedData", "Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "callbackAfterCreated", "", "hostWxaAppId", "", "(Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;ZLjava/lang/String;)V", "getCachedData", "()Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "setCachedData", "(Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;)V", "getCallbackAfterCreated", "()Z", "setCallbackAfterCreated", "(Z)V", "getHostWxaAppId", "()Ljava/lang/String;", "setHostWxaAppId", "(Ljava/lang/String;)V", "append", "", "plate", "describeContents", "", "replace", "oldPlate", "newPlate", "replaceList", "newPlateNoList", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CarLicensePlateListViewContract$ViewModel
  implements Parcelable
{
  public static final Parcelable.Creator<ViewModel> CREATOR;
  public static final CarLicensePlateListViewContract.ViewModel.a wdl;
  static final MMCarLicensePlateInfo wdo;
  public String qIf;
  public MMCarLicensePlateInfo wdm;
  public boolean wdn;
  
  static
  {
    AppMethodBeat.i(277785);
    wdl = new CarLicensePlateListViewContract.ViewModel.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(277785);
  }
  
  private CarLicensePlateListViewContract$ViewModel(byte paramByte)
  {
    this();
  }
  
  public CarLicensePlateListViewContract$ViewModel(MMCarLicensePlateInfo paramMMCarLicensePlateInfo, boolean paramBoolean, String paramString)
  {
    this.wdm = paramMMCarLicensePlateInfo;
    this.wdn = paramBoolean;
    this.qIf = paramString;
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(277788);
    s.u(paramString, "plate");
    if (s.p(wdo, this.wdm))
    {
      localMMCarLicensePlateInfo = new MMCarLicensePlateInfo();
      localMMCarLicensePlateInfo.wbK.add(paramString);
      paramString = ah.aiuX;
      this.wdm = localMMCarLicensePlateInfo;
      AppMethodBeat.o(277788);
      return;
    }
    MMCarLicensePlateInfo localMMCarLicensePlateInfo = this.wdm;
    s.checkNotNull(localMMCarLicensePlateInfo);
    localMMCarLicensePlateInfo.wbK.add(paramString);
    AppMethodBeat.o(277788);
  }
  
  public final void dG(List<String> paramList)
  {
    AppMethodBeat.i(277789);
    if (s.p(wdo, this.wdm)) {
      this.wdm = new MMCarLicensePlateInfo();
    }
    Object localObject = this.wdm;
    s.checkNotNull(localObject);
    ((MMCarLicensePlateInfo)localObject).wbK.clear();
    localObject = ((MMCarLicensePlateInfo)localObject).wbK;
    if (paramList == null) {
      paramList = (List)ab.aivy;
    }
    for (;;)
    {
      ((ArrayList)localObject).addAll((Collection)paramList);
      AppMethodBeat.o(277789);
      return;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(277793);
    s.u(paramParcel, "out");
    MMCarLicensePlateInfo localMMCarLicensePlateInfo = this.wdm;
    if (localMMCarLicensePlateInfo == null)
    {
      paramParcel.writeInt(0);
      if (!this.wdn) {
        break label72;
      }
    }
    label72:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.qIf);
      AppMethodBeat.o(277793);
      return;
      paramParcel.writeInt(1);
      localMMCarLicensePlateInfo.writeToParcel(paramParcel, paramInt);
      break;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<CarLicensePlateListViewContract.ViewModel>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.ViewModel
 * JD-Core Version:    0.7.0.1
 */
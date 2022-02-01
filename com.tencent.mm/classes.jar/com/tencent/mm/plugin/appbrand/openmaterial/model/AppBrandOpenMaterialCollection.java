package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppBrandOpenMaterialCollection
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandOpenMaterialCollection> CREATOR;
  public final MaterialModel trN;
  public final List<AppBrandOpenMaterialModel> trO;
  public final List<AppBrandOpenMaterialDetailModel> trP;
  
  static
  {
    AppMethodBeat.i(323604);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(323604);
  }
  
  protected AppBrandOpenMaterialCollection(Parcel paramParcel)
  {
    AppMethodBeat.i(323595);
    Object localObject2 = (MaterialModel)paramParcel.readParcelable(MaterialModel.class.getClassLoader());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = MaterialModel.cDu();
    }
    this.trN = ((MaterialModel)localObject1);
    localObject2 = paramParcel.createTypedArrayList(AppBrandOpenMaterialModel.CREATOR);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Collections.emptyList();
    }
    this.trO = ((List)localObject1);
    localObject1 = paramParcel.createTypedArrayList(AppBrandOpenMaterialDetailModel.CREATOR);
    paramParcel = (Parcel)localObject1;
    if (localObject1 == null) {
      paramParcel = Collections.emptyList();
    }
    this.trP = paramParcel;
    AppMethodBeat.o(323595);
  }
  
  public AppBrandOpenMaterialCollection(MaterialModel paramMaterialModel, List<AppBrandOpenMaterialModel> paramList, List<AppBrandOpenMaterialDetailModel> paramList1)
  {
    AppMethodBeat.i(323586);
    this.trN = paramMaterialModel;
    this.trO = new ArrayList(paramList);
    this.trP = new ArrayList(paramList1);
    AppMethodBeat.o(323586);
  }
  
  public static AppBrandOpenMaterialCollection h(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(323576);
    paramMaterialModel = new AppBrandOpenMaterialCollection(paramMaterialModel, Collections.emptyList(), Collections.emptyList());
    AppMethodBeat.o(323576);
    return paramMaterialModel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(323614);
    String str = "AppBrandOpenMaterialCollection{materialModel=" + this.trN + ", appBrandOpenMaterialModels=" + Arrays.toString(this.trO.toArray()) + ", appBrandOpenMaterialDetailModels=" + Arrays.toString(this.trP.toArray()) + '}';
    AppMethodBeat.o(323614);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(323628);
    paramParcel.writeParcelable(this.trN, paramInt);
    paramParcel.writeTypedList(this.trO);
    paramParcel.writeTypedList(this.trP);
    AppMethodBeat.o(323628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection
 * JD-Core Version:    0.7.0.1
 */
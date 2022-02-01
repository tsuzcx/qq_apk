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
  public final MaterialModel qng;
  public final List<AppBrandOpenMaterialModel> qnh;
  public final List<AppBrandOpenMaterialDetailModel> qni;
  
  static
  {
    AppMethodBeat.i(190889);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(190889);
  }
  
  protected AppBrandOpenMaterialCollection(Parcel paramParcel)
  {
    AppMethodBeat.i(190885);
    Object localObject2 = (MaterialModel)paramParcel.readParcelable(MaterialModel.class.getClassLoader());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = MaterialModel.ccW();
    }
    this.qng = ((MaterialModel)localObject1);
    localObject2 = paramParcel.createTypedArrayList(AppBrandOpenMaterialModel.CREATOR);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Collections.emptyList();
    }
    this.qnh = ((List)localObject1);
    localObject1 = paramParcel.createTypedArrayList(AppBrandOpenMaterialDetailModel.CREATOR);
    paramParcel = (Parcel)localObject1;
    if (localObject1 == null) {
      paramParcel = Collections.emptyList();
    }
    this.qni = paramParcel;
    AppMethodBeat.o(190885);
  }
  
  public AppBrandOpenMaterialCollection(MaterialModel paramMaterialModel, List<AppBrandOpenMaterialModel> paramList, List<AppBrandOpenMaterialDetailModel> paramList1)
  {
    AppMethodBeat.i(190876);
    this.qng = paramMaterialModel;
    this.qnh = new ArrayList(paramList);
    this.qni = new ArrayList(paramList1);
    AppMethodBeat.o(190876);
  }
  
  public static AppBrandOpenMaterialCollection j(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(190873);
    paramMaterialModel = new AppBrandOpenMaterialCollection(paramMaterialModel, Collections.emptyList(), Collections.emptyList());
    AppMethodBeat.o(190873);
    return paramMaterialModel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(190881);
    String str = "AppBrandOpenMaterialCollection{materialModel=" + this.qng + ", appBrandOpenMaterialModels=" + Arrays.toString(this.qnh.toArray()) + ", appBrandOpenMaterialDetailModels=" + Arrays.toString(this.qni.toArray()) + '}';
    AppMethodBeat.o(190881);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(190887);
    paramParcel.writeParcelable(this.qng, paramInt);
    paramParcel.writeTypedList(this.qnh);
    paramParcel.writeTypedList(this.qni);
    AppMethodBeat.o(190887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection
 * JD-Core Version:    0.7.0.1
 */
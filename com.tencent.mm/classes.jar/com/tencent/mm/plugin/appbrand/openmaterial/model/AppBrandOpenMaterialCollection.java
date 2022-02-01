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
  public final MaterialModel nlD;
  public final List<AppBrandOpenMaterialModel> nlE;
  public final List<AppBrandOpenMaterialDetailModel> nlF;
  
  static
  {
    AppMethodBeat.i(194348);
    CREATOR = new AppBrandOpenMaterialCollection.1();
    AppMethodBeat.o(194348);
  }
  
  protected AppBrandOpenMaterialCollection(Parcel paramParcel)
  {
    AppMethodBeat.i(194346);
    Object localObject2 = (MaterialModel)paramParcel.readParcelable(MaterialModel.class.getClassLoader());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = MaterialModel.bQg();
    }
    this.nlD = ((MaterialModel)localObject1);
    localObject2 = paramParcel.createTypedArrayList(AppBrandOpenMaterialModel.CREATOR);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Collections.emptyList();
    }
    this.nlE = ((List)localObject1);
    localObject1 = paramParcel.createTypedArrayList(AppBrandOpenMaterialDetailModel.CREATOR);
    paramParcel = (Parcel)localObject1;
    if (localObject1 == null) {
      paramParcel = Collections.emptyList();
    }
    this.nlF = paramParcel;
    AppMethodBeat.o(194346);
  }
  
  public AppBrandOpenMaterialCollection(MaterialModel paramMaterialModel, List<AppBrandOpenMaterialModel> paramList, List<AppBrandOpenMaterialDetailModel> paramList1)
  {
    AppMethodBeat.i(194344);
    this.nlD = paramMaterialModel;
    this.nlE = new ArrayList(paramList);
    this.nlF = new ArrayList(paramList1);
    AppMethodBeat.o(194344);
  }
  
  public static AppBrandOpenMaterialCollection j(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(194343);
    paramMaterialModel = new AppBrandOpenMaterialCollection(paramMaterialModel, Collections.emptyList(), Collections.emptyList());
    AppMethodBeat.o(194343);
    return paramMaterialModel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(194345);
    String str = "AppBrandOpenMaterialCollection{materialModel=" + this.nlD + ", appBrandOpenMaterialModels=" + Arrays.toString(this.nlE.toArray()) + ", appBrandOpenMaterialDetailModels=" + Arrays.toString(this.nlF.toArray()) + '}';
    AppMethodBeat.o(194345);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(194347);
    paramParcel.writeParcelable(this.nlD, paramInt);
    paramParcel.writeTypedList(this.nlE);
    paramParcel.writeTypedList(this.nlF);
    AppMethodBeat.o(194347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AppBrandOpenMaterialDetailModel
  extends AppBrandOpenMaterialModel
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandOpenMaterialDetailModel> CREATOR;
  public final List<String> obg;
  public final String qnj;
  public final float score;
  
  static
  {
    AppMethodBeat.i(191616);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(191616);
  }
  
  protected AppBrandOpenMaterialDetailModel(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(191610);
    ArrayList localArrayList = new ArrayList();
    this.obg = localArrayList;
    paramParcel.readStringList(localArrayList);
    this.score = paramParcel.readFloat();
    this.qnj = Util.nullAs(paramParcel.readString(), "");
    AppMethodBeat.o(191610);
  }
  
  public AppBrandOpenMaterialDetailModel(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, List<String> paramList, float paramFloat, String paramString5)
  {
    super(paramString1, paramInt, paramString2, paramString3, paramString4);
    this.obg = paramList;
    this.score = paramFloat;
    this.qnj = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191604);
    if (this == paramObject)
    {
      AppMethodBeat.o(191604);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(191604);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(191604);
      return false;
    }
    paramObject = (AppBrandOpenMaterialDetailModel)paramObject;
    if ((Float.compare(paramObject.score, this.score) == 0) && (this.obg.equals(paramObject.obg)) && (this.qnj.equals(paramObject.qnj)))
    {
      AppMethodBeat.o(191604);
      return true;
    }
    AppMethodBeat.o(191604);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(191608);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.obg, Float.valueOf(this.score), this.qnj });
    AppMethodBeat.o(191608);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(191598);
    String str = "AppBrandOpenMaterialDetailModel{categories='" + Arrays.toString(this.obg.toArray()) + '\'' + ", score=" + this.score + ", functionDesc='" + this.qnj + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", functionName='" + this.qnk + '\'' + ", appName='" + this.appName + '\'' + ", appId='" + this.appId + '\'' + ", versionType=" + this.cBU + ", enterPath='" + this.nBq + '\'' + '}';
    AppMethodBeat.o(191598);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(191614);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeStringList(this.obg);
    paramParcel.writeFloat(this.score);
    paramParcel.writeString(this.qnj);
    AppMethodBeat.o(191614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel
 * JD-Core Version:    0.7.0.1
 */
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
  public final List<String> lgE;
  public final String nlG;
  public final float score;
  
  static
  {
    AppMethodBeat.i(194355);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(194355);
  }
  
  protected AppBrandOpenMaterialDetailModel(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(194353);
    ArrayList localArrayList = new ArrayList();
    this.lgE = localArrayList;
    paramParcel.readStringList(localArrayList);
    this.score = paramParcel.readFloat();
    this.nlG = Util.nullAs(paramParcel.readString(), "");
    AppMethodBeat.o(194353);
  }
  
  public AppBrandOpenMaterialDetailModel(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, List<String> paramList, float paramFloat, String paramString5)
  {
    super(paramString1, paramInt, paramString2, paramString3, paramString4);
    this.lgE = paramList;
    this.score = paramFloat;
    this.nlG = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(194351);
    if (this == paramObject)
    {
      AppMethodBeat.o(194351);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(194351);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(194351);
      return false;
    }
    paramObject = (AppBrandOpenMaterialDetailModel)paramObject;
    if ((Float.compare(paramObject.score, this.score) == 0) && (this.lgE.equals(paramObject.lgE)) && (this.nlG.equals(paramObject.nlG)))
    {
      AppMethodBeat.o(194351);
      return true;
    }
    AppMethodBeat.o(194351);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(194352);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.lgE, Float.valueOf(this.score), this.nlG });
    AppMethodBeat.o(194352);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(194350);
    String str = "AppBrandOpenMaterialDetailModel{categories='" + Arrays.toString(this.lgE.toArray()) + '\'' + ", score=" + this.score + ", functionDesc='" + this.nlG + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", functionName='" + this.nlH + '\'' + ", appName='" + this.appName + '\'' + ", appId='" + this.appId + '\'' + ", versionType=" + this.iOo + ", enterPath='" + this.kHw + '\'' + '}';
    AppMethodBeat.o(194350);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(194354);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeStringList(this.lgE);
    paramParcel.writeFloat(this.score);
    paramParcel.writeString(this.nlG);
    AppMethodBeat.o(194354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel
 * JD-Core Version:    0.7.0.1
 */
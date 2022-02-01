package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public class AppBrandOpenMaterialModel
  extends BaseAppBrandOpenMaterialModel
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandOpenMaterialModel> CREATOR;
  public String appName;
  public final String iconUrl;
  public final String qnk;
  
  static
  {
    AppMethodBeat.i(192387);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(192387);
  }
  
  protected AppBrandOpenMaterialModel(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(192375);
    this.iconUrl = paramParcel.readString();
    this.qnk = Util.nullAs(paramParcel.readString(), "");
    this.appName = paramParcel.readString();
    AppMethodBeat.o(192375);
  }
  
  public AppBrandOpenMaterialModel(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramInt, paramString2);
    this.iconUrl = paramString3;
    this.qnk = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(192368);
    if (this == paramObject)
    {
      AppMethodBeat.o(192368);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(192368);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(192368);
      return false;
    }
    paramObject = (AppBrandOpenMaterialModel)paramObject;
    if ((Objects.equals(this.iconUrl, paramObject.iconUrl)) && (this.qnk.equals(paramObject.qnk)) && (Objects.equals(this.appName, paramObject.appName)))
    {
      AppMethodBeat.o(192368);
      return true;
    }
    AppMethodBeat.o(192368);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(192373);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.iconUrl, this.qnk, this.appName });
    AppMethodBeat.o(192373);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(192361);
    String str = "AppBrandOpenMaterialModel{iconUrl='" + this.iconUrl + '\'' + ", functionName='" + this.qnk + '\'' + ", appName='" + this.appName + '\'' + ", appId='" + this.appId + '\'' + ", versionType=" + this.cBU + ", enterPath='" + this.nBq + '\'' + '}';
    AppMethodBeat.o(192361);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(192384);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.qnk);
    paramParcel.writeString(this.appName);
    AppMethodBeat.o(192384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel
 * JD-Core Version:    0.7.0.1
 */
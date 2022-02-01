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
  public final String nlH;
  
  static
  {
    AppMethodBeat.i(194362);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(194362);
  }
  
  protected AppBrandOpenMaterialModel(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(194360);
    this.iconUrl = paramParcel.readString();
    this.nlH = Util.nullAs(paramParcel.readString(), "");
    this.appName = paramParcel.readString();
    AppMethodBeat.o(194360);
  }
  
  public AppBrandOpenMaterialModel(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramInt, paramString2);
    this.iconUrl = paramString3;
    this.nlH = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(194358);
    if (this == paramObject)
    {
      AppMethodBeat.o(194358);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(194358);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(194358);
      return false;
    }
    paramObject = (AppBrandOpenMaterialModel)paramObject;
    if ((Objects.equals(this.iconUrl, paramObject.iconUrl)) && (this.nlH.equals(paramObject.nlH)) && (Objects.equals(this.appName, paramObject.appName)))
    {
      AppMethodBeat.o(194358);
      return true;
    }
    AppMethodBeat.o(194358);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(194359);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.iconUrl, this.nlH, this.appName });
    AppMethodBeat.o(194359);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(194357);
    String str = "AppBrandOpenMaterialModel{iconUrl='" + this.iconUrl + '\'' + ", functionName='" + this.nlH + '\'' + ", appName='" + this.appName + '\'' + ", appId='" + this.appId + '\'' + ", versionType=" + this.iOo + ", enterPath='" + this.kHw + '\'' + '}';
    AppMethodBeat.o(194357);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(194361);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.nlH);
    paramParcel.writeString(this.appName);
    AppMethodBeat.o(194361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel
 * JD-Core Version:    0.7.0.1
 */
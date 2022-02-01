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
  public final String trR;
  
  static
  {
    AppMethodBeat.i(323607);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(323607);
  }
  
  protected AppBrandOpenMaterialModel(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(323594);
    this.iconUrl = paramParcel.readString();
    this.trR = Util.nullAs(paramParcel.readString(), "");
    this.appName = paramParcel.readString();
    AppMethodBeat.o(323594);
  }
  
  public AppBrandOpenMaterialModel(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramInt, paramString2);
    this.iconUrl = paramString3;
    this.trR = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(323622);
    if (this == paramObject)
    {
      AppMethodBeat.o(323622);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(323622);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(323622);
      return false;
    }
    paramObject = (AppBrandOpenMaterialModel)paramObject;
    if ((Objects.equals(this.iconUrl, paramObject.iconUrl)) && (this.trR.equals(paramObject.trR)) && (Objects.equals(this.appName, paramObject.appName)))
    {
      AppMethodBeat.o(323622);
      return true;
    }
    AppMethodBeat.o(323622);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(323633);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.iconUrl, this.trR, this.appName });
    AppMethodBeat.o(323633);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(323615);
    String str = "AppBrandOpenMaterialModel{iconUrl='" + this.iconUrl + '\'' + ", functionName='" + this.trR + '\'' + ", appName='" + this.appName + '\'' + ", appId='" + this.appId + '\'' + ", versionType=" + this.euz + ", enterPath='" + this.qAF + '\'' + '}';
    AppMethodBeat.o(323615);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(323645);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.trR);
    paramParcel.writeString(this.appName);
    AppMethodBeat.o(323645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel
 * JD-Core Version:    0.7.0.1
 */
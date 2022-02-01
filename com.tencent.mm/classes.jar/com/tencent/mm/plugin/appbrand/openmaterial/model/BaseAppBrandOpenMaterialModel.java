package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.k.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public class BaseAppBrandOpenMaterialModel
  implements Parcelable
{
  public static final Parcelable.Creator<BaseAppBrandOpenMaterialModel> CREATOR;
  public final String appId;
  public final int cBU;
  public final String nBq;
  
  static
  {
    AppMethodBeat.i(192179);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(192179);
  }
  
  protected BaseAppBrandOpenMaterialModel(Parcel paramParcel)
  {
    AppMethodBeat.i(192172);
    this.appId = Util.nullAs(paramParcel.readString(), "");
    this.cBU = paramParcel.readInt();
    this.nBq = Util.nullAs(paramParcel.readString(), "");
    AppMethodBeat.o(192172);
  }
  
  public BaseAppBrandOpenMaterialModel(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(192152);
    this.appId = paramString1;
    this.cBU = paramInt;
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = l.eo(paramString2);
      if (paramString1.endsWith(".html")) {}
    }
    for (paramString1 = paramString2.replace(paramString1, paramString1 + ".html");; paramString1 = paramString2)
    {
      Log.i("MicroMsg.AppBrand.BaseAppBrandOpenMaterialModel", "fixPath, path: %s, fixedPath: %s", new Object[] { paramString2, paramString1 });
      this.nBq = paramString1;
      AppMethodBeat.o(192152);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(192163);
    if (this == paramObject)
    {
      AppMethodBeat.o(192163);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(192163);
      return false;
    }
    paramObject = (BaseAppBrandOpenMaterialModel)paramObject;
    if ((this.cBU == paramObject.cBU) && (this.appId.equals(paramObject.appId)) && (this.nBq.equals(paramObject.nBq)))
    {
      AppMethodBeat.o(192163);
      return true;
    }
    AppMethodBeat.o(192163);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(192171);
    int i = Objects.hash(new Object[] { this.appId, Integer.valueOf(this.cBU), this.nBq });
    AppMethodBeat.o(192171);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(192156);
    String str = "BaseAppBrandOpenMaterialModel{appId='" + this.appId + '\'' + ", versionType=" + this.cBU + ", enterPath='" + this.nBq + '\'' + '}';
    AppMethodBeat.o(192156);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(192175);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeString(this.nBq);
    AppMethodBeat.o(192175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
 * JD-Core Version:    0.7.0.1
 */
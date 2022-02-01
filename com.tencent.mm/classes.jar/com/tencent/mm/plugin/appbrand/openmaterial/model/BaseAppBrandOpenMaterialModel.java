package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public class BaseAppBrandOpenMaterialModel
  implements Parcelable
{
  public static final Parcelable.Creator<BaseAppBrandOpenMaterialModel> CREATOR;
  public final String appId;
  public final int iOo;
  public final String kHw;
  
  static
  {
    AppMethodBeat.i(194373);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(194373);
  }
  
  protected BaseAppBrandOpenMaterialModel(Parcel paramParcel)
  {
    AppMethodBeat.i(194371);
    this.appId = Util.nullAs(paramParcel.readString(), "");
    this.iOo = paramParcel.readInt();
    this.kHw = Util.nullAs(paramParcel.readString(), "");
    AppMethodBeat.o(194371);
  }
  
  public BaseAppBrandOpenMaterialModel(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(194367);
    this.appId = paramString1;
    this.iOo = paramInt;
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = l.dM(paramString2);
      if (paramString1.endsWith(".html")) {}
    }
    for (paramString1 = paramString2.replace(paramString1, paramString1 + ".html");; paramString1 = paramString2)
    {
      Log.i("MicroMsg.AppBrand.BaseAppBrandOpenMaterialModel", "fixPath, path: %s, fixedPath: %s", new Object[] { paramString2, paramString1 });
      this.kHw = paramString1;
      AppMethodBeat.o(194367);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(194369);
    if (this == paramObject)
    {
      AppMethodBeat.o(194369);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(194369);
      return false;
    }
    paramObject = (BaseAppBrandOpenMaterialModel)paramObject;
    if ((this.iOo == paramObject.iOo) && (this.appId.equals(paramObject.appId)) && (this.kHw.equals(paramObject.kHw)))
    {
      AppMethodBeat.o(194369);
      return true;
    }
    AppMethodBeat.o(194369);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(194370);
    int i = Objects.hash(new Object[] { this.appId, Integer.valueOf(this.iOo), this.kHw });
    AppMethodBeat.o(194370);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(194368);
    String str = "BaseAppBrandOpenMaterialModel{appId='" + this.appId + '\'' + ", versionType=" + this.iOo + ", enterPath='" + this.kHw + '\'' + '}';
    AppMethodBeat.o(194368);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(194372);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.iOo);
    paramParcel.writeString(this.kHw);
    AppMethodBeat.o(194372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
 * JD-Core Version:    0.7.0.1
 */
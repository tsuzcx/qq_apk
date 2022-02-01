package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public class BaseAppBrandOpenMaterialModel
  implements Parcelable
{
  public static final Parcelable.Creator<BaseAppBrandOpenMaterialModel> CREATOR;
  public final String appId;
  public final int euz;
  public final String qAF;
  
  static
  {
    AppMethodBeat.i(323618);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(323618);
  }
  
  protected BaseAppBrandOpenMaterialModel(Parcel paramParcel)
  {
    AppMethodBeat.i(323601);
    this.appId = Util.nullAs(paramParcel.readString(), "");
    this.euz = paramParcel.readInt();
    this.qAF = Util.nullAs(paramParcel.readString(), "");
    AppMethodBeat.o(323601);
  }
  
  public BaseAppBrandOpenMaterialModel(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(323587);
    this.appId = paramString1;
    this.euz = paramInt;
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = m.fL(paramString2);
      if (paramString1.endsWith(".html")) {}
    }
    for (paramString1 = paramString2.replace(paramString1, paramString1 + ".html");; paramString1 = paramString2)
    {
      Log.i("MicroMsg.AppBrand.BaseAppBrandOpenMaterialModel", "fixPath, path: %s, fixedPath: %s", new Object[] { paramString2, paramString1 });
      this.qAF = paramString1;
      AppMethodBeat.o(323587);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(323644);
    if (this == paramObject)
    {
      AppMethodBeat.o(323644);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(323644);
      return false;
    }
    paramObject = (BaseAppBrandOpenMaterialModel)paramObject;
    if ((this.euz == paramObject.euz) && (this.appId.equals(paramObject.appId)) && (this.qAF.equals(paramObject.qAF)))
    {
      AppMethodBeat.o(323644);
      return true;
    }
    AppMethodBeat.o(323644);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(323654);
    int i = Objects.hash(new Object[] { this.appId, Integer.valueOf(this.euz), this.qAF });
    AppMethodBeat.o(323654);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(323632);
    String str = "BaseAppBrandOpenMaterialModel{appId='" + this.appId + '\'' + ", versionType=" + this.euz + ", enterPath='" + this.qAF + '\'' + '}';
    AppMethodBeat.o(323632);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(323672);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.euz);
    paramParcel.writeString(this.qAF);
    AppMethodBeat.o(323672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel
 * JD-Core Version:    0.7.0.1
 */
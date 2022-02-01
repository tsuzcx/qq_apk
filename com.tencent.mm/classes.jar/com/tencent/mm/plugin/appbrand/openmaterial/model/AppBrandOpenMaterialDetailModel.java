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
  public final List<String> rbS;
  public final float score;
  public final String trQ;
  
  static
  {
    AppMethodBeat.i(323579);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(323579);
  }
  
  protected AppBrandOpenMaterialDetailModel(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(323572);
    ArrayList localArrayList = new ArrayList();
    this.rbS = localArrayList;
    paramParcel.readStringList(localArrayList);
    this.score = paramParcel.readFloat();
    this.trQ = Util.nullAs(paramParcel.readString(), "");
    AppMethodBeat.o(323572);
  }
  
  public AppBrandOpenMaterialDetailModel(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, List<String> paramList, float paramFloat, String paramString5)
  {
    super(paramString1, paramInt, paramString2, paramString3, paramString4);
    this.rbS = paramList;
    this.score = paramFloat;
    this.trQ = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(323602);
    if (this == paramObject)
    {
      AppMethodBeat.o(323602);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(323602);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(323602);
      return false;
    }
    paramObject = (AppBrandOpenMaterialDetailModel)paramObject;
    if ((Float.compare(paramObject.score, this.score) == 0) && (this.rbS.equals(paramObject.rbS)) && (this.trQ.equals(paramObject.trQ)))
    {
      AppMethodBeat.o(323602);
      return true;
    }
    AppMethodBeat.o(323602);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(323613);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.rbS, Float.valueOf(this.score), this.trQ });
    AppMethodBeat.o(323613);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(323590);
    String str = "AppBrandOpenMaterialDetailModel{categories='" + Arrays.toString(this.rbS.toArray()) + '\'' + ", score=" + this.score + ", functionDesc='" + this.trQ + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", functionName='" + this.trR + '\'' + ", appName='" + this.appName + '\'' + ", appId='" + this.appId + '\'' + ", versionType=" + this.euz + ", enterPath='" + this.qAF + '\'' + '}';
    AppMethodBeat.o(323590);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(323626);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeStringList(this.rbS);
    paramParcel.writeFloat(this.score);
    paramParcel.writeString(this.trQ);
    AppMethodBeat.o(323626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel
 * JD-Core Version:    0.7.0.1
 */
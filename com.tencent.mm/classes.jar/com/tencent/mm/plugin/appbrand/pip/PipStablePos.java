package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "Landroid/os/Parcelable;", "appId", "", "point", "Landroid/graphics/Point;", "(Ljava/lang/String;Landroid/graphics/Point;)V", "getAppId", "()Ljava/lang/String;", "getPoint", "()Landroid/graphics/Point;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class PipStablePos
  implements Parcelable
{
  public static final a CREATOR;
  final String appId;
  final Point nDV;
  
  static
  {
    AppMethodBeat.i(229274);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(229274);
  }
  
  public PipStablePos(String paramString, Point paramPoint)
  {
    AppMethodBeat.i(229273);
    this.appId = paramString;
    this.nDV = paramPoint;
    AppMethodBeat.o(229273);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(229277);
    if (this != paramObject)
    {
      if ((paramObject instanceof PipStablePos))
      {
        paramObject = (PipStablePos)paramObject;
        if ((!p.j(this.appId, paramObject.appId)) || (!p.j(this.nDV, paramObject.nDV))) {}
      }
    }
    else
    {
      AppMethodBeat.o(229277);
      return true;
    }
    AppMethodBeat.o(229277);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(229276);
    Object localObject = this.appId;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.nDV;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(229276);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229275);
    String str = "PipStablePos(appId=" + this.appId + ", point=" + this.nDV + ")";
    AppMethodBeat.o(229275);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(229272);
    p.h(paramParcel, "parcel");
    try
    {
      paramParcel.writeString(this.appId);
      paramParcel.writeParcelable((Parcelable)this.nDV, paramInt);
      AppMethodBeat.o(229272);
      return;
    }
    catch (Exception paramParcel)
    {
      Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "writeToParcel fail since ".concat(String.valueOf(paramParcel)));
      AppMethodBeat.o(229272);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<PipStablePos>
  {
    private static PipStablePos m(Parcel paramParcel)
    {
      AppMethodBeat.i(229270);
      p.h(paramParcel, "parcel");
      for (;;)
      {
        try
        {
          str = paramParcel.readString();
          paramParcel = (Point)paramParcel.readParcelable(Point.class.getClassLoader());
          if ((str != null) && (paramParcel != null)) {
            continue;
          }
          Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "createFromParcel fail, appId: " + str + ", point: " + paramParcel);
          paramParcel = m.bTI();
        }
        catch (Exception paramParcel)
        {
          String str;
          Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "createFromParcel fail since ".concat(String.valueOf(paramParcel)));
          paramParcel = m.bTI();
          continue;
        }
        AppMethodBeat.o(229270);
        return paramParcel;
        paramParcel = new PipStablePos(str, paramParcel);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.PipStablePos
 * JD-Core Version:    0.7.0.1
 */
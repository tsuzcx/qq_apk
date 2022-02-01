package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "Landroid/os/Parcelable;", "appId", "", "point", "Landroid/graphics/Point;", "(Ljava/lang/String;Landroid/graphics/Point;)V", "getAppId", "()Ljava/lang/String;", "getPoint", "()Landroid/graphics/Point;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class PipStablePos
  implements Parcelable
{
  public static final a CREATOR;
  final String appId;
  final Point lOz;
  
  static
  {
    AppMethodBeat.i(187364);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(187364);
  }
  
  public PipStablePos(String paramString, Point paramPoint)
  {
    AppMethodBeat.i(187363);
    this.appId = paramString;
    this.lOz = paramPoint;
    AppMethodBeat.o(187363);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187367);
    if (this != paramObject)
    {
      if ((paramObject instanceof PipStablePos))
      {
        paramObject = (PipStablePos)paramObject;
        if ((!k.g(this.appId, paramObject.appId)) || (!k.g(this.lOz, paramObject.lOz))) {}
      }
    }
    else
    {
      AppMethodBeat.o(187367);
      return true;
    }
    AppMethodBeat.o(187367);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(187366);
    Object localObject = this.appId;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.lOz;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(187366);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187365);
    String str = "PipStablePos(appId=" + this.appId + ", point=" + this.lOz + ")";
    AppMethodBeat.o(187365);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(187362);
    k.h(paramParcel, "parcel");
    try
    {
      paramParcel.writeString(this.appId);
      paramParcel.writeParcelable((Parcelable)this.lOz, paramInt);
      AppMethodBeat.o(187362);
      return;
    }
    catch (Exception paramParcel)
    {
      ac.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "writeToParcel fail since ".concat(String.valueOf(paramParcel)));
      AppMethodBeat.o(187362);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<PipStablePos>
  {
    private static PipStablePos l(Parcel paramParcel)
    {
      AppMethodBeat.i(187360);
      k.h(paramParcel, "parcel");
      for (;;)
      {
        try
        {
          str = paramParcel.readString();
          paramParcel = (Point)paramParcel.readParcelable(Point.class.getClassLoader());
          if ((str != null) && (paramParcel != null)) {
            continue;
          }
          ac.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "createFromParcel fail, appId: " + str + ", point: " + paramParcel);
          paramParcel = m.bsC();
        }
        catch (Exception paramParcel)
        {
          String str;
          ac.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "createFromParcel fail since ".concat(String.valueOf(paramParcel)));
          paramParcel = m.bsC();
          continue;
        }
        AppMethodBeat.o(187360);
        return paramParcel;
        paramParcel = new PipStablePos(str, paramParcel);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.PipStablePos
 * JD-Core Version:    0.7.0.1
 */
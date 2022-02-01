package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "Landroid/os/Parcelable;", "appId", "", "point", "Landroid/graphics/Point;", "(Ljava/lang/String;Landroid/graphics/Point;)V", "getAppId", "()Ljava/lang/String;", "getPoint", "()Landroid/graphics/Point;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class PipStablePos
  implements Parcelable
{
  public static final a CREATOR;
  final String appId;
  final Point mtn;
  
  static
  {
    AppMethodBeat.i(223842);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(223842);
  }
  
  public PipStablePos(String paramString, Point paramPoint)
  {
    AppMethodBeat.i(223841);
    this.appId = paramString;
    this.mtn = paramPoint;
    AppMethodBeat.o(223841);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(223845);
    if (this != paramObject)
    {
      if ((paramObject instanceof PipStablePos))
      {
        paramObject = (PipStablePos)paramObject;
        if ((!p.i(this.appId, paramObject.appId)) || (!p.i(this.mtn, paramObject.mtn))) {}
      }
    }
    else
    {
      AppMethodBeat.o(223845);
      return true;
    }
    AppMethodBeat.o(223845);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(223844);
    Object localObject = this.appId;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.mtn;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(223844);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(223843);
    String str = "PipStablePos(appId=" + this.appId + ", point=" + this.mtn + ")";
    AppMethodBeat.o(223843);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(223840);
    p.h(paramParcel, "parcel");
    try
    {
      paramParcel.writeString(this.appId);
      paramParcel.writeParcelable((Parcelable)this.mtn, paramInt);
      AppMethodBeat.o(223840);
      return;
    }
    catch (Exception paramParcel)
    {
      ae.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "writeToParcel fail since ".concat(String.valueOf(paramParcel)));
      AppMethodBeat.o(223840);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<PipStablePos>
  {
    private static PipStablePos l(Parcel paramParcel)
    {
      AppMethodBeat.i(223838);
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
          ae.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "createFromParcel fail, appId: " + str + ", point: " + paramParcel);
          paramParcel = m.bxx();
        }
        catch (Exception paramParcel)
        {
          String str;
          ae.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "createFromParcel fail since ".concat(String.valueOf(paramParcel)));
          paramParcel = m.bxx();
          continue;
        }
        AppMethodBeat.o(223838);
        return paramParcel;
        paramParcel = new PipStablePos(str, paramParcel);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.PipStablePos
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "Landroid/os/Parcelable;", "appId", "", "point", "Landroid/graphics/Point;", "(Ljava/lang/String;Landroid/graphics/Point;)V", "getAppId", "()Ljava/lang/String;", "getPoint", "()Landroid/graphics/Point;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class PipStablePos
  implements Parcelable
{
  public static final a CREATOR;
  final String appId;
  final Point qGg;
  
  static
  {
    AppMethodBeat.i(269163);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(269163);
  }
  
  public PipStablePos(String paramString, Point paramPoint)
  {
    AppMethodBeat.i(269162);
    this.appId = paramString;
    this.qGg = paramPoint;
    AppMethodBeat.o(269162);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(269166);
    if (this != paramObject)
    {
      if ((paramObject instanceof PipStablePos))
      {
        paramObject = (PipStablePos)paramObject;
        if ((!p.h(this.appId, paramObject.appId)) || (!p.h(this.qGg, paramObject.qGg))) {}
      }
    }
    else
    {
      AppMethodBeat.o(269166);
      return true;
    }
    AppMethodBeat.o(269166);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(269165);
    Object localObject = this.appId;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.qGg;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(269165);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269164);
    String str = "PipStablePos(appId=" + this.appId + ", point=" + this.qGg + ")";
    AppMethodBeat.o(269164);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(269161);
    p.k(paramParcel, "parcel");
    try
    {
      paramParcel.writeString(this.appId);
      paramParcel.writeParcelable((Parcelable)this.qGg, paramInt);
      AppMethodBeat.o(269161);
      return;
    }
    catch (Exception paramParcel)
    {
      Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "writeToParcel fail since ".concat(String.valueOf(paramParcel)));
      AppMethodBeat.o(269161);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<PipStablePos>
  {
    private static PipStablePos m(Parcel paramParcel)
    {
      AppMethodBeat.i(271558);
      p.k(paramParcel, "parcel");
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
          paramParcel = m.cgN();
        }
        catch (Exception paramParcel)
        {
          String str;
          Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "createFromParcel fail since ".concat(String.valueOf(paramParcel)));
          paramParcel = m.cgN();
          continue;
        }
        AppMethodBeat.o(271558);
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
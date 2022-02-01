package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "Landroid/os/Parcelable;", "appId", "", "point", "Landroid/graphics/Point;", "(Ljava/lang/String;Landroid/graphics/Point;)V", "getAppId", "()Ljava/lang/String;", "getPoint", "()Landroid/graphics/Point;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class PipStablePos
  implements Parcelable
{
  public static final a CREATOR;
  final String appId;
  final Point tKS;
  
  static
  {
    AppMethodBeat.i(319585);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(319585);
  }
  
  public PipStablePos(String paramString, Point paramPoint)
  {
    AppMethodBeat.i(319580);
    this.appId = paramString;
    this.tKS = paramPoint;
    AppMethodBeat.o(319580);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(319614);
    if (this == paramObject)
    {
      AppMethodBeat.o(319614);
      return true;
    }
    if (!(paramObject instanceof PipStablePos))
    {
      AppMethodBeat.o(319614);
      return false;
    }
    paramObject = (PipStablePos)paramObject;
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(319614);
      return false;
    }
    if (!s.p(this.tKS, paramObject.tKS))
    {
      AppMethodBeat.o(319614);
      return false;
    }
    AppMethodBeat.o(319614);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(319606);
    int i = this.appId.hashCode();
    int j = this.tKS.hashCode();
    AppMethodBeat.o(319606);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(319600);
    String str = "PipStablePos(appId=" + this.appId + ", point=" + this.tKS + ')';
    AppMethodBeat.o(319600);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(319590);
    s.u(paramParcel, "parcel");
    try
    {
      paramParcel.writeString(this.appId);
      paramParcel.writeParcelable((Parcelable)this.tKS, paramInt);
      AppMethodBeat.o(319590);
      return;
    }
    catch (Exception paramParcel)
    {
      Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", s.X("writeToParcel fail since ", paramParcel));
      AppMethodBeat.o(319590);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<PipStablePos>
  {
    private static PipStablePos q(Parcel paramParcel)
    {
      AppMethodBeat.i(319556);
      s.u(paramParcel, "parcel");
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
          paramParcel = n.cHL();
        }
        catch (Exception paramParcel)
        {
          String str;
          Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", s.X("createFromParcel fail since ", paramParcel));
          paramParcel = n.cHL();
          continue;
        }
        AppMethodBeat.o(319556);
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
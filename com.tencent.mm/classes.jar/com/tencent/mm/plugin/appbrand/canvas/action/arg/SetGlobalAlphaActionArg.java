package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetGlobalAlphaActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetGlobalAlphaActionArg> CREATOR;
  public int alpha;
  
  static
  {
    AppMethodBeat.i(103498);
    CREATOR = new SetGlobalAlphaActionArg.1();
    AppMethodBeat.o(103498);
  }
  
  public SetGlobalAlphaActionArg() {}
  
  public SetGlobalAlphaActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103496);
    if (this == paramObject)
    {
      AppMethodBeat.o(103496);
      return true;
    }
    if (!(paramObject instanceof SetGlobalAlphaActionArg))
    {
      AppMethodBeat.o(103496);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103496);
      return false;
    }
    paramObject = (SetGlobalAlphaActionArg)paramObject;
    if (this.alpha == paramObject.alpha)
    {
      AppMethodBeat.o(103496);
      return true;
    }
    AppMethodBeat.o(103496);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103493);
    super.h(paramParcel);
    this.alpha = paramParcel.readInt();
    AppMethodBeat.o(103493);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103497);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.alpha) });
    AppMethodBeat.o(103497);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103494);
    super.p(paramJSONObject);
    this.alpha = g.a(paramJSONObject.optJSONArray("data"), 0);
    AppMethodBeat.o(103494);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103495);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.alpha);
    AppMethodBeat.o(103495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalAlphaActionArg
 * JD-Core Version:    0.7.0.1
 */
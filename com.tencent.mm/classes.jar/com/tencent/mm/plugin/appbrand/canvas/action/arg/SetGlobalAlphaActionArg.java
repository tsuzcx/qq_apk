package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetGlobalAlphaActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetGlobalAlphaActionArg> CREATOR;
  public int alpha;
  
  static
  {
    AppMethodBeat.i(145181);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145181);
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
    AppMethodBeat.i(145179);
    if (this == paramObject)
    {
      AppMethodBeat.o(145179);
      return true;
    }
    if (!(paramObject instanceof SetGlobalAlphaActionArg))
    {
      AppMethodBeat.o(145179);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145179);
      return false;
    }
    paramObject = (SetGlobalAlphaActionArg)paramObject;
    if (this.alpha == paramObject.alpha)
    {
      AppMethodBeat.o(145179);
      return true;
    }
    AppMethodBeat.o(145179);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145176);
    super.h(paramParcel);
    this.alpha = paramParcel.readInt();
    AppMethodBeat.o(145176);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145180);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.alpha) });
    AppMethodBeat.o(145180);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145177);
    super.parse(paramJSONObject);
    this.alpha = g.c(paramJSONObject.optJSONArray("data"), 0);
    AppMethodBeat.o(145177);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145178);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.alpha);
    AppMethodBeat.o(145178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalAlphaActionArg
 * JD-Core Version:    0.7.0.1
 */
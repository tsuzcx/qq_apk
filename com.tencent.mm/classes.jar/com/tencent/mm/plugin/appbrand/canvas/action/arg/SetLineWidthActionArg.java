package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetLineWidthActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetLineWidthActionArg> CREATOR;
  public float jTB;
  
  static
  {
    AppMethodBeat.i(145216);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145216);
  }
  
  public SetLineWidthActionArg() {}
  
  public SetLineWidthActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145214);
    if (this == paramObject)
    {
      AppMethodBeat.o(145214);
      return true;
    }
    if (!(paramObject instanceof SetLineWidthActionArg))
    {
      AppMethodBeat.o(145214);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145214);
      return false;
    }
    if (Float.compare(((SetLineWidthActionArg)paramObject).jTB, this.jTB) == 0)
    {
      AppMethodBeat.o(145214);
      return true;
    }
    AppMethodBeat.o(145214);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145211);
    super.h(paramParcel);
    this.jTB = paramParcel.readFloat();
    AppMethodBeat.o(145211);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145215);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.jTB) });
    AppMethodBeat.o(145215);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145212);
    super.parse(paramJSONObject);
    this.jTB = g.f(paramJSONObject.optJSONArray("data"), 0);
    AppMethodBeat.o(145212);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145213);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.jTB);
    AppMethodBeat.o(145213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineWidthActionArg
 * JD-Core Version:    0.7.0.1
 */
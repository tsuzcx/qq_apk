package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RotateActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<RotateActionArg> CREATOR;
  public float heZ;
  
  static
  {
    AppMethodBeat.i(103433);
    CREATOR = new RotateActionArg.1();
    AppMethodBeat.o(103433);
  }
  
  public RotateActionArg() {}
  
  public RotateActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103431);
    if (this == paramObject)
    {
      AppMethodBeat.o(103431);
      return true;
    }
    if (!(paramObject instanceof RotateActionArg))
    {
      AppMethodBeat.o(103431);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103431);
      return false;
    }
    if (Float.compare(((RotateActionArg)paramObject).heZ, this.heZ) == 0)
    {
      AppMethodBeat.o(103431);
      return true;
    }
    AppMethodBeat.o(103431);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103428);
    super.h(paramParcel);
    this.heZ = paramParcel.readFloat();
    AppMethodBeat.o(103428);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103432);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.heZ) });
    AppMethodBeat.o(103432);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103429);
    super.p(paramJSONObject);
    this.heZ = ((float)paramJSONObject.optJSONArray("data").optDouble(0));
    AppMethodBeat.o(103429);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103430);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.heZ);
    AppMethodBeat.o(103430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RotateActionArg
 * JD-Core Version:    0.7.0.1
 */
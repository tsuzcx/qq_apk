package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SeMiterLimitActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SeMiterLimitActionArg> CREATOR;
  public float nTT;
  
  static
  {
    AppMethodBeat.i(145130);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145130);
  }
  
  public SeMiterLimitActionArg() {}
  
  public SeMiterLimitActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145128);
    if (this == paramObject)
    {
      AppMethodBeat.o(145128);
      return true;
    }
    if (!(paramObject instanceof SeMiterLimitActionArg))
    {
      AppMethodBeat.o(145128);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145128);
      return false;
    }
    if (Float.compare(((SeMiterLimitActionArg)paramObject).nTT, this.nTT) == 0)
    {
      AppMethodBeat.o(145128);
      return true;
    }
    AppMethodBeat.o(145128);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145129);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.nTT) });
    AppMethodBeat.o(145129);
    return i;
  }
  
  public final void i(Parcel paramParcel)
  {
    AppMethodBeat.i(145125);
    super.i(paramParcel);
    this.nTT = paramParcel.readFloat();
    AppMethodBeat.o(145125);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145126);
    super.parse(paramJSONObject);
    this.nTT = ((float)paramJSONObject.optJSONArray("data").optDouble(0));
    AppMethodBeat.o(145126);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145127);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.nTT);
    AppMethodBeat.o(145127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SeMiterLimitActionArg
 * JD-Core Version:    0.7.0.1
 */
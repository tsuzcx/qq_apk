package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetTextBaseLineActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetTextBaseLineActionArg> CREATOR;
  public String nUc;
  
  static
  {
    AppMethodBeat.i(145253);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145253);
  }
  
  public SetTextBaseLineActionArg() {}
  
  public SetTextBaseLineActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145251);
    if (this == paramObject)
    {
      AppMethodBeat.o(145251);
      return true;
    }
    if (!(paramObject instanceof SetTextBaseLineActionArg))
    {
      AppMethodBeat.o(145251);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145251);
      return false;
    }
    paramObject = (SetTextBaseLineActionArg)paramObject;
    boolean bool = Objects.equals(this.nUc, paramObject.nUc);
    AppMethodBeat.o(145251);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145252);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.nUc });
    AppMethodBeat.o(145252);
    return i;
  }
  
  public final void i(Parcel paramParcel)
  {
    AppMethodBeat.i(145248);
    super.i(paramParcel);
    this.nUc = paramParcel.readString();
    AppMethodBeat.o(145248);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145249);
    super.parse(paramJSONObject);
    this.nUc = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(145249);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145250);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.nUc);
    AppMethodBeat.o(145250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg
 * JD-Core Version:    0.7.0.1
 */
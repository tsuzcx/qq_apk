package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontWeightArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontWeightArg> CREATOR;
  public String jzB;
  
  static
  {
    AppMethodBeat.i(145174);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145174);
  }
  
  public SetFontWeightArg() {}
  
  public SetFontWeightArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145172);
    if (this == paramObject)
    {
      AppMethodBeat.o(145172);
      return true;
    }
    if (!(paramObject instanceof SetFontWeightArg))
    {
      AppMethodBeat.o(145172);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145172);
      return false;
    }
    paramObject = (SetFontWeightArg)paramObject;
    boolean bool = Objects.equals(this.jzB, paramObject.jzB);
    AppMethodBeat.o(145172);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145169);
    super.h(paramParcel);
    this.jzB = paramParcel.readString();
    AppMethodBeat.o(145169);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145173);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.jzB });
    AppMethodBeat.o(145173);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145170);
    super.parse(paramJSONObject);
    this.jzB = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(145170);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145171);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jzB);
    AppMethodBeat.o(145171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontWeightArg
 * JD-Core Version:    0.7.0.1
 */
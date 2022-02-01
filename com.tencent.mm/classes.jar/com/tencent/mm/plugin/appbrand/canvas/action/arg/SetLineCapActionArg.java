package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetLineCapActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetLineCapActionArg> CREATOR;
  public String jWO;
  
  static
  {
    AppMethodBeat.i(145195);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145195);
  }
  
  public SetLineCapActionArg() {}
  
  public SetLineCapActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145193);
    if (this == paramObject)
    {
      AppMethodBeat.o(145193);
      return true;
    }
    if (!(paramObject instanceof SetLineCapActionArg))
    {
      AppMethodBeat.o(145193);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145193);
      return false;
    }
    paramObject = (SetLineCapActionArg)paramObject;
    boolean bool = Objects.equals(this.jWO, paramObject.jWO);
    AppMethodBeat.o(145193);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145190);
    super.h(paramParcel);
    this.jWO = paramParcel.readString();
    AppMethodBeat.o(145190);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145194);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.jWO });
    AppMethodBeat.o(145194);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145191);
    super.parse(paramJSONObject);
    this.jWO = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(145191);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145192);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jWO);
    AppMethodBeat.o(145192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineCapActionArg
 * JD-Core Version:    0.7.0.1
 */
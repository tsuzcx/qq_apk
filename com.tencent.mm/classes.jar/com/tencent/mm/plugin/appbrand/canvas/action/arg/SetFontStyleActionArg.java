package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontStyleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontStyleActionArg> CREATOR;
  public String fontStyle;
  
  static
  {
    AppMethodBeat.i(145167);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145167);
  }
  
  public SetFontStyleActionArg() {}
  
  public SetFontStyleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145165);
    if (this == paramObject)
    {
      AppMethodBeat.o(145165);
      return true;
    }
    if (!(paramObject instanceof SetFontStyleActionArg))
    {
      AppMethodBeat.o(145165);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145165);
      return false;
    }
    paramObject = (SetFontStyleActionArg)paramObject;
    boolean bool = Objects.equals(this.fontStyle, paramObject.fontStyle);
    AppMethodBeat.o(145165);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145166);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.fontStyle });
    AppMethodBeat.o(145166);
    return i;
  }
  
  public final void i(Parcel paramParcel)
  {
    AppMethodBeat.i(145162);
    super.i(paramParcel);
    this.fontStyle = paramParcel.readString();
    AppMethodBeat.o(145162);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145163);
    super.parse(paramJSONObject);
    this.fontStyle = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(145163);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145164);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.fontStyle);
    AppMethodBeat.o(145164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg
 * JD-Core Version:    0.7.0.1
 */
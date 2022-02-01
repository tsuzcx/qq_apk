package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontFamilyActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontFamilyActionArg> CREATOR;
  public String fontFamily;
  
  static
  {
    AppMethodBeat.i(145153);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145153);
  }
  
  public SetFontFamilyActionArg() {}
  
  public SetFontFamilyActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145151);
    if (this == paramObject)
    {
      AppMethodBeat.o(145151);
      return true;
    }
    if (!(paramObject instanceof SetFontFamilyActionArg))
    {
      AppMethodBeat.o(145151);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145151);
      return false;
    }
    paramObject = (SetFontFamilyActionArg)paramObject;
    boolean bool = Objects.equals(this.fontFamily, paramObject.fontFamily);
    AppMethodBeat.o(145151);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145152);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.fontFamily });
    AppMethodBeat.o(145152);
    return i;
  }
  
  public final void i(Parcel paramParcel)
  {
    AppMethodBeat.i(145148);
    super.i(paramParcel);
    this.fontFamily = paramParcel.readString();
    AppMethodBeat.o(145148);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145149);
    super.parse(paramJSONObject);
    this.fontFamily = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(145149);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145150);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.fontFamily);
    AppMethodBeat.o(145150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg
 * JD-Core Version:    0.7.0.1
 */
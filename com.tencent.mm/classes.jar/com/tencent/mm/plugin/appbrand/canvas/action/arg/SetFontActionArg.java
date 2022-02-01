package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontActionArg> CREATOR;
  public String name;
  public float size;
  
  static
  {
    AppMethodBeat.i(145146);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145146);
  }
  
  public SetFontActionArg() {}
  
  public SetFontActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145144);
    if (this == paramObject)
    {
      AppMethodBeat.o(145144);
      return true;
    }
    if (!(paramObject instanceof SetFontActionArg))
    {
      AppMethodBeat.o(145144);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145144);
      return false;
    }
    paramObject = (SetFontActionArg)paramObject;
    if ((Float.compare(paramObject.size, this.size) == 0) && (Objects.equals(this.name, paramObject.name)))
    {
      AppMethodBeat.o(145144);
      return true;
    }
    AppMethodBeat.o(145144);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145145);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.name, Float.valueOf(this.size) });
    AppMethodBeat.o(145145);
    return i;
  }
  
  public final void i(Parcel paramParcel)
  {
    AppMethodBeat.i(145141);
    super.i(paramParcel);
    this.name = paramParcel.readString();
    this.size = paramParcel.readFloat();
    AppMethodBeat.o(145141);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145142);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2)
    {
      AppMethodBeat.o(145142);
      return;
    }
    this.name = paramJSONObject.optString(0);
    this.size = g.f(paramJSONObject, 1);
    AppMethodBeat.o(145142);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145143);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.name);
    paramParcel.writeFloat(this.size);
    AppMethodBeat.o(145143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontActionArg
 * JD-Core Version:    0.7.0.1
 */
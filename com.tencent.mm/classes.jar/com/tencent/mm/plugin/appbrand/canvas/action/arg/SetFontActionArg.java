package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
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
    AppMethodBeat.i(103463);
    CREATOR = new SetFontActionArg.1();
    AppMethodBeat.o(103463);
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
    AppMethodBeat.i(103461);
    if (this == paramObject)
    {
      AppMethodBeat.o(103461);
      return true;
    }
    if (!(paramObject instanceof SetFontActionArg))
    {
      AppMethodBeat.o(103461);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103461);
      return false;
    }
    paramObject = (SetFontActionArg)paramObject;
    if ((Float.compare(paramObject.size, this.size) == 0) && (Objects.equals(this.name, paramObject.name)))
    {
      AppMethodBeat.o(103461);
      return true;
    }
    AppMethodBeat.o(103461);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103458);
    super.h(paramParcel);
    this.name = paramParcel.readString();
    this.size = paramParcel.readFloat();
    AppMethodBeat.o(103458);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103462);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.name, Float.valueOf(this.size) });
    AppMethodBeat.o(103462);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103459);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2)
    {
      AppMethodBeat.o(103459);
      return;
    }
    this.name = paramJSONObject.optString(0);
    this.size = g.d(paramJSONObject, 1);
    AppMethodBeat.o(103459);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103460);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.name);
    paramParcel.writeFloat(this.size);
    AppMethodBeat.o(103460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontActionArg
 * JD-Core Version:    0.7.0.1
 */
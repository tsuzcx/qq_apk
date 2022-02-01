package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetShadowActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetShadowActionArg> CREATOR;
  public int color;
  public float qTL;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(145230);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145230);
  }
  
  public SetShadowActionArg() {}
  
  public SetShadowActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145228);
    if (this == paramObject)
    {
      AppMethodBeat.o(145228);
      return true;
    }
    if (!(paramObject instanceof SetShadowActionArg))
    {
      AppMethodBeat.o(145228);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145228);
      return false;
    }
    paramObject = (SetShadowActionArg)paramObject;
    if ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.qTL, this.qTL) == 0) && (this.color == paramObject.color))
    {
      AppMethodBeat.o(145228);
      return true;
    }
    AppMethodBeat.o(145228);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145229);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.qTL), Integer.valueOf(this.color) });
    AppMethodBeat.o(145229);
    return i;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145225);
    super.k(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.qTL = paramParcel.readFloat();
    this.color = paramParcel.readInt();
    AppMethodBeat.o(145225);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145227);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    paramJSONObject.length();
    this.x = i.f(paramJSONObject, 0);
    this.y = i.f(paramJSONObject, 1);
    this.qTL = i.f(paramJSONObject, 2);
    paramJSONObject = paramJSONObject.optJSONArray(3);
    if ((paramJSONObject == null) || (paramJSONObject.length() < 4))
    {
      AppMethodBeat.o(145227);
      return;
    }
    this.color = i.u(paramJSONObject);
    AppMethodBeat.o(145227);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145226);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.qTL);
    paramParcel.writeInt(this.color);
    AppMethodBeat.o(145226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetShadowActionArg
 * JD-Core Version:    0.7.0.1
 */
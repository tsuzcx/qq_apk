package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import java.util.Objects;
import org.json.JSONObject;

public class TranslateActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<TranslateActionArg> CREATOR;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(145267);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145267);
  }
  
  public TranslateActionArg() {}
  
  public TranslateActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public final boolean cjZ()
  {
    return (this.x == 0.0F) && (this.y == 0.0F);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145265);
    if (this == paramObject)
    {
      AppMethodBeat.o(145265);
      return true;
    }
    if (!(paramObject instanceof TranslateActionArg))
    {
      AppMethodBeat.o(145265);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145265);
      return false;
    }
    paramObject = (TranslateActionArg)paramObject;
    if ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0))
    {
      AppMethodBeat.o(145265);
      return true;
    }
    AppMethodBeat.o(145265);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145266);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y) });
    AppMethodBeat.o(145266);
    return i;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145262);
    super.k(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    AppMethodBeat.o(145262);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145264);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = i.f(paramJSONObject, 0);
    this.y = i.f(paramJSONObject, 1);
    AppMethodBeat.o(145264);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145263);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    AppMethodBeat.o(145263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.TranslateActionArg
 * JD-Core Version:    0.7.0.1
 */
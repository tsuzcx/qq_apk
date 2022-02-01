package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawTextActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawTextActionArg> CREATOR;
  public float maxWidth;
  public String text;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(145035);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145035);
  }
  
  public DrawTextActionArg() {}
  
  public DrawTextActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145033);
    if (this == paramObject)
    {
      AppMethodBeat.o(145033);
      return true;
    }
    if (!(paramObject instanceof DrawTextActionArg))
    {
      AppMethodBeat.o(145033);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145033);
      return false;
    }
    paramObject = (DrawTextActionArg)paramObject;
    if ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.maxWidth, this.maxWidth) == 0) && (Objects.equals(this.text, paramObject.text)))
    {
      AppMethodBeat.o(145033);
      return true;
    }
    AppMethodBeat.o(145033);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145034);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.text, Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.maxWidth) });
    AppMethodBeat.o(145034);
    return i;
  }
  
  public final void i(Parcel paramParcel)
  {
    AppMethodBeat.i(145030);
    super.i(paramParcel);
    this.text = paramParcel.readString();
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.maxWidth = paramParcel.readFloat();
    AppMethodBeat.o(145030);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145031);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.text = paramJSONObject.optString(0);
    this.x = g.f(paramJSONObject, 1);
    this.y = g.f(paramJSONObject, 2);
    this.maxWidth = g.f(paramJSONObject, 3);
    AppMethodBeat.o(145031);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145032);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.text);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.maxWidth);
    AppMethodBeat.o(145032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawTextActionArg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetPixelsActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetPixelsActionArg> CREATOR;
  public Bitmap bitmap = null;
  public int height;
  public int width;
  public int x;
  public int y;
  
  static
  {
    AppMethodBeat.i(103540);
    CREATOR = new SetPixelsActionArg.1();
    AppMethodBeat.o(103540);
  }
  
  public SetPixelsActionArg() {}
  
  public SetPixelsActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103535);
    if (this == paramObject)
    {
      AppMethodBeat.o(103535);
      return true;
    }
    if (!(paramObject instanceof SetPixelsActionArg))
    {
      AppMethodBeat.o(103535);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103535);
      return false;
    }
    paramObject = (SetPixelsActionArg)paramObject;
    if ((this.x == paramObject.x) && (this.y == paramObject.y) && (this.width == paramObject.width) && (this.height == paramObject.height) && (Objects.equals(this.bitmap, paramObject.bitmap)))
    {
      AppMethodBeat.o(103535);
      return true;
    }
    AppMethodBeat.o(103535);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103537);
    super.h(paramParcel);
    this.x = paramParcel.readInt();
    this.y = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.bitmap = ((Bitmap)paramParcel.readParcelable(SetPixelsActionArg.class.getClassLoader()));
    AppMethodBeat.o(103537);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103536);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.width), Integer.valueOf(this.height), this.bitmap });
    AppMethodBeat.o(103536);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103539);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.a(paramJSONObject, 0);
    this.y = g.a(paramJSONObject, 1);
    this.width = g.a(paramJSONObject, 2);
    this.height = g.a(paramJSONObject, 3);
    try
    {
      this.bitmap = ((Bitmap)paramJSONObject.get(4));
      AppMethodBeat.o(103539);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      d.printErrStackTrace("SetPixelsActionArg", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(103539);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103538);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeParcelable(this.bitmap, paramInt);
    AppMethodBeat.o(103538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetPixelsActionArg
 * JD-Core Version:    0.7.0.1
 */
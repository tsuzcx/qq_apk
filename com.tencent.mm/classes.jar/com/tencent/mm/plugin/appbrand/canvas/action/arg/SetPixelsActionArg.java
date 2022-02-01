package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.sdk.platformtools.ad;
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
    AppMethodBeat.i(145223);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145223);
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
    AppMethodBeat.i(145218);
    if (this == paramObject)
    {
      AppMethodBeat.o(145218);
      return true;
    }
    if (!(paramObject instanceof SetPixelsActionArg))
    {
      AppMethodBeat.o(145218);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145218);
      return false;
    }
    paramObject = (SetPixelsActionArg)paramObject;
    if ((this.x == paramObject.x) && (this.y == paramObject.y) && (this.width == paramObject.width) && (this.height == paramObject.height) && (Objects.equals(this.bitmap, paramObject.bitmap)))
    {
      AppMethodBeat.o(145218);
      return true;
    }
    AppMethodBeat.o(145218);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145220);
    super.h(paramParcel);
    this.x = paramParcel.readInt();
    this.y = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.bitmap = ((Bitmap)paramParcel.readParcelable(SetPixelsActionArg.class.getClassLoader()));
    AppMethodBeat.o(145220);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145219);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.width), Integer.valueOf(this.height), this.bitmap });
    AppMethodBeat.o(145219);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145222);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.c(paramJSONObject, 0);
    this.y = g.c(paramJSONObject, 1);
    this.width = g.c(paramJSONObject, 2);
    this.height = g.c(paramJSONObject, 3);
    try
    {
      this.bitmap = ((Bitmap)paramJSONObject.get(4));
      AppMethodBeat.o(145222);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ad.printErrStackTrace("SetPixelsActionArg", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(145222);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145221);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeParcelable(this.bitmap, paramInt);
    AppMethodBeat.o(145221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetPixelsActionArg
 * JD-Core Version:    0.7.0.1
 */
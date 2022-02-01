package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawImageActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawImageActionArg> CREATOR;
  public int aXg;
  public int aXh;
  public float height;
  public int jTk;
  public int jTl;
  public int jTm;
  public String url;
  public float width;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(145021);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145021);
  }
  
  public DrawImageActionArg() {}
  
  public DrawImageActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145019);
    if (this == paramObject)
    {
      AppMethodBeat.o(145019);
      return true;
    }
    if (!(paramObject instanceof DrawImageActionArg))
    {
      AppMethodBeat.o(145019);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145019);
      return false;
    }
    paramObject = (DrawImageActionArg)paramObject;
    if ((this.jTk == paramObject.jTk) && (Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.width, this.width) == 0) && (Float.compare(paramObject.height, this.height) == 0) && (this.jTl == paramObject.jTl) && (this.jTm == paramObject.jTm) && (this.aXg == paramObject.aXg) && (this.aXh == paramObject.aXh) && (Objects.equals(this.url, paramObject.url)))
    {
      AppMethodBeat.o(145019);
      return true;
    }
    AppMethodBeat.o(145019);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145016);
    super.h(paramParcel);
    this.jTk = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
    this.jTl = paramParcel.readInt();
    this.jTm = paramParcel.readInt();
    this.aXg = paramParcel.readInt();
    this.aXh = paramParcel.readInt();
    AppMethodBeat.o(145016);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145020);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.jTk), this.url, Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.jTl), Integer.valueOf(this.jTm), Integer.valueOf(this.aXg), Integer.valueOf(this.aXh) });
    AppMethodBeat.o(145020);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145017);
    super.parse(paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.optJSONArray("data");
      this.jTk = paramJSONObject.length();
      this.url = paramJSONObject.optString(0);
      this.x = g.f(paramJSONObject, 1);
      this.y = g.f(paramJSONObject, 2);
      this.width = g.f(paramJSONObject, 3);
      this.height = g.f(paramJSONObject, 4);
      this.jTl = paramJSONObject.optInt(5);
      this.jTm = paramJSONObject.optInt(6);
      this.aXg = paramJSONObject.optInt(7);
      this.aXh = paramJSONObject.optInt(8);
      AppMethodBeat.o(145017);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ad.printErrStackTrace("DrawImageActionArg", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(145017);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145018);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.jTk);
    paramParcel.writeString(this.url);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    paramParcel.writeInt(this.jTl);
    paramParcel.writeInt(this.jTm);
    paramParcel.writeInt(this.aXg);
    paramParcel.writeInt(this.aXh);
    AppMethodBeat.o(145018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg
 * JD-Core Version:    0.7.0.1
 */
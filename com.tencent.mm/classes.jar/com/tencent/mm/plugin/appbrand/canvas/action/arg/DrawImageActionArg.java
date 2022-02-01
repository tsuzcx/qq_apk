package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawImageActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawImageActionArg> CREATOR;
  public float height;
  public int qTu;
  public int qTv;
  public int qTw;
  public int sHeight;
  public int sWidth;
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
    if ((this.qTu == paramObject.qTu) && (Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.width, this.width) == 0) && (Float.compare(paramObject.height, this.height) == 0) && (this.qTv == paramObject.qTv) && (this.qTw == paramObject.qTw) && (this.sWidth == paramObject.sWidth) && (this.sHeight == paramObject.sHeight) && (Objects.equals(this.url, paramObject.url)))
    {
      AppMethodBeat.o(145019);
      return true;
    }
    AppMethodBeat.o(145019);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145020);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.qTu), this.url, Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.qTv), Integer.valueOf(this.qTw), Integer.valueOf(this.sWidth), Integer.valueOf(this.sHeight) });
    AppMethodBeat.o(145020);
    return i;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145016);
    super.k(paramParcel);
    this.qTu = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
    this.qTv = paramParcel.readInt();
    this.qTw = paramParcel.readInt();
    this.sWidth = paramParcel.readInt();
    this.sHeight = paramParcel.readInt();
    AppMethodBeat.o(145016);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145017);
    super.parse(paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.optJSONArray("data");
      this.qTu = paramJSONObject.length();
      this.url = paramJSONObject.optString(0);
      this.x = i.f(paramJSONObject, 1);
      this.y = i.f(paramJSONObject, 2);
      this.width = i.f(paramJSONObject, 3);
      this.height = i.f(paramJSONObject, 4);
      this.qTv = paramJSONObject.optInt(5);
      this.qTw = paramJSONObject.optInt(6);
      this.sWidth = paramJSONObject.optInt(7);
      this.sHeight = paramJSONObject.optInt(8);
      AppMethodBeat.o(145017);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace("DrawImageActionArg", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(145017);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145018);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.qTu);
    paramParcel.writeString(this.url);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    paramParcel.writeInt(this.qTv);
    paramParcel.writeInt(this.qTw);
    paramParcel.writeInt(this.sWidth);
    paramParcel.writeInt(this.sHeight);
    AppMethodBeat.o(145018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg
 * JD-Core Version:    0.7.0.1
 */
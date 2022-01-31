package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetPixelsActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetPixelsActionArg> CREATOR = new SetPixelsActionArg.1();
  public Bitmap bitmap = null;
  public int height;
  public int width;
  public int x;
  public int y;
  
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
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof SetPixelsActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (SetPixelsActionArg)paramObject;
    } while ((this.x == paramObject.x) && (this.y == paramObject.y) && (this.width == paramObject.width) && (this.height == paramObject.height) && (Objects.equals(this.bitmap, paramObject.bitmap)));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.x = paramParcel.readInt();
    this.y = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.bitmap = ((Bitmap)paramParcel.readParcelable(SetPixelsActionArg.class.getClassLoader()));
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.width), Integer.valueOf(this.height), this.bitmap });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = h.a(paramJSONObject, 0);
    this.y = h.a(paramJSONObject, 1);
    this.width = h.a(paramJSONObject, 2);
    this.height = h.a(paramJSONObject, 3);
    try
    {
      this.bitmap = ((Bitmap)paramJSONObject.get(4));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      c.printErrStackTrace("SetPixelsActionArg", paramJSONObject, "", new Object[0]);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeParcelable(this.bitmap, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetPixelsActionArg
 * JD-Core Version:    0.7.0.1
 */
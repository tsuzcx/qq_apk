package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONObject;

public abstract class BaseDrawActionArg
  implements DrawActionArg
{
  public String method;
  
  public BaseDrawActionArg() {}
  
  public BaseDrawActionArg(Parcel paramParcel)
  {
    this.method = paramParcel.readString();
  }
  
  @Deprecated
  public BaseDrawActionArg(Parcel paramParcel, byte paramByte)
  {
    k(paramParcel);
  }
  
  public boolean a(d paramd, Canvas paramCanvas)
  {
    return false;
  }
  
  public boolean cjZ()
  {
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof BaseDrawActionArg)) {
        break;
      }
      paramObject = (BaseDrawActionArg)paramObject;
    } while ((this.method == paramObject.method) || ((this.method != null) && (this.method.equals(paramObject.method))));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  @Deprecated
  public void k(Parcel paramParcel)
  {
    this.method = paramParcel.readString();
  }
  
  public void parse(JSONObject paramJSONObject)
  {
    this.method = paramJSONObject.optString("method");
  }
  
  public void reset() {}
  
  public String toString()
  {
    return String.format("method %s", new Object[] { this.method });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.method);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg
 * JD-Core Version:    0.7.0.1
 */
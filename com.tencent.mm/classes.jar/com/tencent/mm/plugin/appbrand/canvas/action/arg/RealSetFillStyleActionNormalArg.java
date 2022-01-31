package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionNormalArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionNormalArg> CREATOR = new Parcelable.Creator() {};
  public int color;
  
  public RealSetFillStyleActionNormalArg() {}
  
  public RealSetFillStyleActionNormalArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    paramd = paramd.fLq;
    paramd.setShader(null);
    paramd.setColor(this.color);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(JSONArray paramJSONArray)
  {
    super.e(paramJSONArray);
    paramJSONArray = paramJSONArray.optJSONArray(1);
    if ((paramJSONArray == null) || (paramJSONArray.length() < 4)) {
      return;
    }
    this.color = h.l(paramJSONArray);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof RealSetFillStyleActionNormalArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (RealSetFillStyleActionNormalArg)paramObject;
    } while (this.color == paramObject.color);
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.color = paramParcel.readInt();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.color) });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.color);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionNormalArg
 * JD-Core Version:    0.7.0.1
 */
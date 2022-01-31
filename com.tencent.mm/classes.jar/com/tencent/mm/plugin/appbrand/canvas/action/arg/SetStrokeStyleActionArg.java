package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.h;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetStrokeStyleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetStrokeStyleActionArg> CREATOR = new SetStrokeStyleActionArg.1();
  public RealSetStrokeStyleActionArg fMa;
  
  public SetStrokeStyleActionArg() {}
  
  public SetStrokeStyleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    if (this.fMa == null) {
      return false;
    }
    return this.fMa.a(paramd, paramCanvas);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof SetStrokeStyleActionArg));
      bool1 = bool2;
    } while (!super.equals(paramObject));
    paramObject = (SetStrokeStyleActionArg)paramObject;
    return Objects.equals(this.fMa, paramObject.fMa);
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fMa = ((RealSetStrokeStyleActionArg)paramParcel.readParcelable(SetStrokeStyleActionArg.class.getClassLoader()));
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.fMa });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2) {
      return;
    }
    String str = paramJSONObject.optString(0);
    this.fMa = ((RealSetStrokeStyleActionArg)h.adN().rK(str));
    this.fMa.e(paramJSONObject);
  }
  
  public final void reset()
  {
    super.reset();
    h.adN().a(this.fMa);
    this.fMa = null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.fMa, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetStrokeStyleActionArg
 * JD-Core Version:    0.7.0.1
 */
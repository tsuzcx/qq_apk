package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.g;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFillStyleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFillStyleActionArg> CREATOR = new SetFillStyleActionArg.1();
  public RealSetFillStyleActionArg fLR;
  
  public SetFillStyleActionArg() {}
  
  public SetFillStyleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    if (this.fLR == null) {
      return false;
    }
    return this.fLR.a(paramd, paramCanvas);
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
      } while (!(paramObject instanceof SetFillStyleActionArg));
      bool1 = bool2;
    } while (!super.equals(paramObject));
    paramObject = (SetFillStyleActionArg)paramObject;
    return Objects.equals(this.fLR, paramObject.fLR);
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fLR = ((RealSetFillStyleActionArg)paramParcel.readParcelable(SetFillStyleActionArg.class.getClassLoader()));
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.fLR });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2) {
      return;
    }
    String str = paramJSONObject.optString(0);
    this.fLR = ((RealSetFillStyleActionArg)g.adM().rK(str));
    this.fLR.e(paramJSONObject);
  }
  
  public final void reset()
  {
    super.reset();
    g.adM().a(this.fLR);
    this.fLR = null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.fLR, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFillStyleActionArg
 * JD-Core Version:    0.7.0.1
 */
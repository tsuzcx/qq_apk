package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetStrokeStyleActionNormalArg
  extends RealSetStrokeStyleActionArg
{
  public static final Parcelable.Creator<RealSetStrokeStyleActionNormalArg> CREATOR;
  public int color;
  
  static
  {
    AppMethodBeat.i(145100);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145100);
  }
  
  public RealSetStrokeStyleActionNormalArg() {}
  
  public RealSetStrokeStyleActionNormalArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(145093);
    paramd.qTi.setColor(this.color);
    AppMethodBeat.o(145093);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145095);
    if (this == paramObject)
    {
      AppMethodBeat.o(145095);
      return true;
    }
    if (!(paramObject instanceof RealSetStrokeStyleActionNormalArg))
    {
      AppMethodBeat.o(145095);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145095);
      return false;
    }
    paramObject = (RealSetStrokeStyleActionNormalArg)paramObject;
    if (this.color == paramObject.color)
    {
      AppMethodBeat.o(145095);
      return true;
    }
    AppMethodBeat.o(145095);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145096);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.color) });
    AppMethodBeat.o(145096);
    return i;
  }
  
  public final void i(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145098);
    super.i(paramJSONArray);
    paramJSONArray = paramJSONArray.optJSONArray(1);
    if ((paramJSONArray == null) || (paramJSONArray.length() < 4))
    {
      AppMethodBeat.o(145098);
      return;
    }
    this.color = i.u(paramJSONArray);
    AppMethodBeat.o(145098);
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145094);
    super.k(paramParcel);
    this.color = paramParcel.readInt();
    AppMethodBeat.o(145094);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145099);
    super.parse(paramJSONObject);
    AppMethodBeat.o(145099);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145097);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.color);
    AppMethodBeat.o(145097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionNormalArg
 * JD-Core Version:    0.7.0.1
 */
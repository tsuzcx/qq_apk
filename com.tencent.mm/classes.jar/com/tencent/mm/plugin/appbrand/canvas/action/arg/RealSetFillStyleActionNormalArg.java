package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.z.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionNormalArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionNormalArg> CREATOR;
  public int color;
  
  static
  {
    AppMethodBeat.i(145062);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145062);
  }
  
  public RealSetFillStyleActionNormalArg() {}
  
  public RealSetFillStyleActionNormalArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(145055);
    paramd = paramd.jzc;
    paramd.setShader(null);
    paramd.setColor(this.color);
    AppMethodBeat.o(145055);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145059);
    if (this == paramObject)
    {
      AppMethodBeat.o(145059);
      return true;
    }
    if (!(paramObject instanceof RealSetFillStyleActionNormalArg))
    {
      AppMethodBeat.o(145059);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145059);
      return false;
    }
    paramObject = (RealSetFillStyleActionNormalArg)paramObject;
    if (this.color == paramObject.color)
    {
      AppMethodBeat.o(145059);
      return true;
    }
    AppMethodBeat.o(145059);
    return false;
  }
  
  public final void f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145058);
    super.f(paramJSONArray);
    paramJSONArray = paramJSONArray.optJSONArray(1);
    if ((paramJSONArray == null) || (paramJSONArray.length() < 4))
    {
      AppMethodBeat.o(145058);
      return;
    }
    this.color = g.p(paramJSONArray);
    AppMethodBeat.o(145058);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145056);
    super.h(paramParcel);
    this.color = paramParcel.readInt();
    AppMethodBeat.o(145056);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145060);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.color) });
    AppMethodBeat.o(145060);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145061);
    super.parse(paramJSONObject);
    AppMethodBeat.o(145061);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145057);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.color);
    AppMethodBeat.o(145057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionNormalArg
 * JD-Core Version:    0.7.0.1
 */
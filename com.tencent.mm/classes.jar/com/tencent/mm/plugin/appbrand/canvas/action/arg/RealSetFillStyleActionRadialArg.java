package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.z.g;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionRadialArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionRadialArg> CREATOR;
  public float jzq;
  public float jzr;
  public int[] jzu;
  public float[] jzv;
  public float jzx;
  
  static
  {
    AppMethodBeat.i(145080);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145080);
  }
  
  public RealSetFillStyleActionRadialArg() {}
  
  public RealSetFillStyleActionRadialArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(145073);
    if ((this.jzu == null) || (this.jzv == null))
    {
      AppMethodBeat.o(145073);
      return false;
    }
    paramd.jzc.setShader(new RadialGradient(this.jzq, this.jzr, this.jzx, this.jzu, this.jzv, Shader.TileMode.CLAMP));
    AppMethodBeat.o(145073);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145074);
    if (this == paramObject)
    {
      AppMethodBeat.o(145074);
      return true;
    }
    if (!(paramObject instanceof RealSetFillStyleActionRadialArg))
    {
      AppMethodBeat.o(145074);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145074);
      return false;
    }
    paramObject = (RealSetFillStyleActionRadialArg)paramObject;
    if ((Float.compare(paramObject.jzq, this.jzq) == 0) && (Float.compare(paramObject.jzr, this.jzr) == 0) && (Float.compare(paramObject.jzx, this.jzx) == 0) && (Arrays.equals(this.jzu, paramObject.jzu)) && (Arrays.equals(this.jzv, paramObject.jzv)))
    {
      AppMethodBeat.o(145074);
      return true;
    }
    AppMethodBeat.o(145074);
    return false;
  }
  
  public final void f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145078);
    super.f(paramJSONArray);
    if (paramJSONArray.length() < 3)
    {
      AppMethodBeat.o(145078);
      return;
    }
    JSONArray localJSONArray = paramJSONArray.optJSONArray(1);
    if ((localJSONArray == null) || (localJSONArray.length() < 3))
    {
      AppMethodBeat.o(145078);
      return;
    }
    this.jzq = g.f(localJSONArray, 1);
    this.jzr = g.f(localJSONArray, 2);
    this.jzx = g.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    this.jzu = new int[paramJSONArray.length()];
    this.jzv = new float[paramJSONArray.length()];
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localJSONArray = paramJSONArray.optJSONArray(i);
      if (localJSONArray.length() >= 2)
      {
        this.jzv[i] = ((float)localJSONArray.optDouble(0));
        this.jzu[i] = g.p(localJSONArray.optJSONArray(1));
      }
      i += 1;
    }
    AppMethodBeat.o(145078);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145076);
    super.h(paramParcel);
    this.jzq = paramParcel.readFloat();
    this.jzr = paramParcel.readFloat();
    this.jzx = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.jzu = new int[i];
      paramParcel.readIntArray(this.jzu);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.jzv = new float[i];
      paramParcel.readFloatArray(this.jzv);
    }
    AppMethodBeat.o(145076);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145075);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.jzq), Float.valueOf(this.jzr), Float.valueOf(this.jzx) });
    int j = Arrays.hashCode(this.jzu);
    int k = Arrays.hashCode(this.jzv);
    AppMethodBeat.o(145075);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145079);
    super.parse(paramJSONObject);
    AppMethodBeat.o(145079);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145077);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.jzq);
    paramParcel.writeFloat(this.jzr);
    paramParcel.writeFloat(this.jzx);
    if (this.jzu != null)
    {
      paramParcel.writeInt(this.jzu.length);
      paramParcel.writeIntArray(this.jzu);
    }
    while (this.jzv != null)
    {
      paramParcel.writeInt(this.jzv.length);
      paramParcel.writeFloatArray(this.jzv);
      AppMethodBeat.o(145077);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(145077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionRadialArg
 * JD-Core Version:    0.7.0.1
 */
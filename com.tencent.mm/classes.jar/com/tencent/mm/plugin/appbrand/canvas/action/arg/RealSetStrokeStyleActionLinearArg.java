package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
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

public class RealSetStrokeStyleActionLinearArg
  extends RealSetStrokeStyleActionArg
{
  public static final Parcelable.Creator<RealSetStrokeStyleActionLinearArg> CREATOR;
  public float jzq;
  public float jzr;
  public float jzs;
  public float jzt;
  public int[] jzu;
  public float[] jzv;
  
  static
  {
    AppMethodBeat.i(145091);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145091);
  }
  
  public RealSetStrokeStyleActionLinearArg() {}
  
  public RealSetStrokeStyleActionLinearArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(145084);
    if ((this.jzu == null) || (this.jzv == null))
    {
      AppMethodBeat.o(145084);
      return false;
    }
    paramCanvas = new LinearGradient(this.jzq, this.jzr, this.jzs, this.jzt, this.jzu, this.jzv, Shader.TileMode.CLAMP);
    paramd.jzb.setShader(paramCanvas);
    AppMethodBeat.o(145084);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145085);
    if (this == paramObject)
    {
      AppMethodBeat.o(145085);
      return true;
    }
    if (!(paramObject instanceof RealSetStrokeStyleActionLinearArg))
    {
      AppMethodBeat.o(145085);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145085);
      return false;
    }
    paramObject = (RealSetStrokeStyleActionLinearArg)paramObject;
    if ((Float.compare(paramObject.jzq, this.jzq) == 0) && (Float.compare(paramObject.jzr, this.jzr) == 0) && (Float.compare(paramObject.jzs, this.jzs) == 0) && (Float.compare(paramObject.jzt, this.jzt) == 0) && (Arrays.equals(this.jzu, paramObject.jzu)) && (Arrays.equals(this.jzv, paramObject.jzv)))
    {
      AppMethodBeat.o(145085);
      return true;
    }
    AppMethodBeat.o(145085);
    return false;
  }
  
  public final void f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145089);
    super.f(paramJSONArray);
    if (paramJSONArray.length() < 3)
    {
      AppMethodBeat.o(145089);
      return;
    }
    JSONArray localJSONArray = paramJSONArray.optJSONArray(1);
    if ((localJSONArray == null) || (localJSONArray.length() < 4))
    {
      AppMethodBeat.o(145089);
      return;
    }
    this.jzq = g.f(localJSONArray, 0);
    this.jzr = g.f(localJSONArray, 1);
    this.jzs = g.f(localJSONArray, 2);
    this.jzt = g.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(145089);
      return;
    }
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
    AppMethodBeat.o(145089);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145087);
    super.h(paramParcel);
    this.jzq = paramParcel.readFloat();
    this.jzr = paramParcel.readFloat();
    this.jzs = paramParcel.readFloat();
    this.jzt = paramParcel.readFloat();
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
    AppMethodBeat.o(145087);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145086);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.jzq), Float.valueOf(this.jzr), Float.valueOf(this.jzs), Float.valueOf(this.jzt) });
    int j = Arrays.hashCode(this.jzu);
    int k = Arrays.hashCode(this.jzv);
    AppMethodBeat.o(145086);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145090);
    super.parse(paramJSONObject);
    AppMethodBeat.o(145090);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145088);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.jzq);
    paramParcel.writeFloat(this.jzr);
    paramParcel.writeFloat(this.jzs);
    paramParcel.writeFloat(this.jzt);
    if (this.jzu != null)
    {
      paramParcel.writeInt(this.jzu.length);
      paramParcel.writeIntArray(this.jzu);
    }
    while (this.jzv != null)
    {
      paramParcel.writeInt(this.jzv.length);
      paramParcel.writeFloatArray(this.jzv);
      AppMethodBeat.o(145088);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(145088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionLinearArg
 * JD-Core Version:    0.7.0.1
 */
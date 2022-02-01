package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetStrokeStyleActionRadialArg
  extends RealSetStrokeStyleActionArg
{
  public static final Parcelable.Creator<RealSetStrokeStyleActionRadialArg> CREATOR;
  public float iZa;
  public float iZb;
  public int[] iZe;
  public float[] iZf;
  public float iZh;
  
  static
  {
    AppMethodBeat.i(145109);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145109);
  }
  
  public RealSetStrokeStyleActionRadialArg() {}
  
  public RealSetStrokeStyleActionRadialArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(145102);
    if ((this.iZe == null) || (this.iZf == null))
    {
      AppMethodBeat.o(145102);
      return false;
    }
    paramCanvas = new RadialGradient(this.iZa, this.iZb, this.iZh, this.iZe, this.iZf, Shader.TileMode.CLAMP);
    paramd.iYL.setShader(paramCanvas);
    AppMethodBeat.o(145102);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145103);
    if (this == paramObject)
    {
      AppMethodBeat.o(145103);
      return true;
    }
    if (!(paramObject instanceof RealSetStrokeStyleActionRadialArg))
    {
      AppMethodBeat.o(145103);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145103);
      return false;
    }
    paramObject = (RealSetStrokeStyleActionRadialArg)paramObject;
    if ((Float.compare(paramObject.iZa, this.iZa) == 0) && (Float.compare(paramObject.iZb, this.iZb) == 0) && (Float.compare(paramObject.iZh, this.iZh) == 0) && (Arrays.equals(this.iZe, paramObject.iZe)) && (Arrays.equals(this.iZf, paramObject.iZf)))
    {
      AppMethodBeat.o(145103);
      return true;
    }
    AppMethodBeat.o(145103);
    return false;
  }
  
  public final void f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145107);
    super.f(paramJSONArray);
    if (paramJSONArray.length() < 3)
    {
      AppMethodBeat.o(145107);
      return;
    }
    JSONArray localJSONArray = paramJSONArray.optJSONArray(1);
    if ((localJSONArray == null) || (localJSONArray.length() < 3))
    {
      AppMethodBeat.o(145107);
      return;
    }
    this.iZa = g.f(localJSONArray, 1);
    this.iZb = g.f(localJSONArray, 2);
    this.iZh = g.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    this.iZe = new int[paramJSONArray.length()];
    this.iZf = new float[paramJSONArray.length()];
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localJSONArray = paramJSONArray.optJSONArray(i);
      if (localJSONArray.length() >= 2)
      {
        this.iZf[i] = ((float)localJSONArray.optDouble(0));
        this.iZe[i] = g.p(localJSONArray.optJSONArray(1));
      }
      i += 1;
    }
    AppMethodBeat.o(145107);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145105);
    super.h(paramParcel);
    this.iZa = paramParcel.readFloat();
    this.iZb = paramParcel.readFloat();
    this.iZh = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.iZe = new int[i];
      paramParcel.readIntArray(this.iZe);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.iZf = new float[i];
      paramParcel.readFloatArray(this.iZf);
    }
    AppMethodBeat.o(145105);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145104);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.iZa), Float.valueOf(this.iZb), Float.valueOf(this.iZh) });
    int j = Arrays.hashCode(this.iZe);
    int k = Arrays.hashCode(this.iZf);
    AppMethodBeat.o(145104);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145108);
    super.parse(paramJSONObject);
    AppMethodBeat.o(145108);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145106);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.iZa);
    paramParcel.writeFloat(this.iZb);
    paramParcel.writeFloat(this.iZh);
    if (this.iZe != null)
    {
      paramParcel.writeInt(this.iZe.length);
      paramParcel.writeIntArray(this.iZe);
    }
    while (this.iZf != null)
    {
      paramParcel.writeInt(this.iZf.length);
      paramParcel.writeFloatArray(this.iZf);
      AppMethodBeat.o(145106);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(145106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg
 * JD-Core Version:    0.7.0.1
 */
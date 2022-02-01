package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
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
  public float kZA;
  public float kZB;
  public int[] kZE;
  public float[] kZF;
  public float kZH;
  
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
    if ((this.kZE == null) || (this.kZF == null))
    {
      AppMethodBeat.o(145102);
      return false;
    }
    paramCanvas = new RadialGradient(this.kZA, this.kZB, this.kZH, this.kZE, this.kZF, Shader.TileMode.CLAMP);
    paramd.kZl.setShader(paramCanvas);
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
    if ((Float.compare(paramObject.kZA, this.kZA) == 0) && (Float.compare(paramObject.kZB, this.kZB) == 0) && (Float.compare(paramObject.kZH, this.kZH) == 0) && (Arrays.equals(this.kZE, paramObject.kZE)) && (Arrays.equals(this.kZF, paramObject.kZF)))
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
    this.kZA = g.f(localJSONArray, 1);
    this.kZB = g.f(localJSONArray, 2);
    this.kZH = g.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    this.kZE = new int[paramJSONArray.length()];
    this.kZF = new float[paramJSONArray.length()];
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localJSONArray = paramJSONArray.optJSONArray(i);
      if (localJSONArray.length() >= 2)
      {
        this.kZF[i] = ((float)localJSONArray.optDouble(0));
        this.kZE[i] = g.r(localJSONArray.optJSONArray(1));
      }
      i += 1;
    }
    AppMethodBeat.o(145107);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145104);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.kZA), Float.valueOf(this.kZB), Float.valueOf(this.kZH) });
    int j = Arrays.hashCode(this.kZE);
    int k = Arrays.hashCode(this.kZF);
    AppMethodBeat.o(145104);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void i(Parcel paramParcel)
  {
    AppMethodBeat.i(145105);
    super.i(paramParcel);
    this.kZA = paramParcel.readFloat();
    this.kZB = paramParcel.readFloat();
    this.kZH = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.kZE = new int[i];
      paramParcel.readIntArray(this.kZE);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.kZF = new float[i];
      paramParcel.readFloatArray(this.kZF);
    }
    AppMethodBeat.o(145105);
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
    paramParcel.writeFloat(this.kZA);
    paramParcel.writeFloat(this.kZB);
    paramParcel.writeFloat(this.kZH);
    if (this.kZE != null)
    {
      paramParcel.writeInt(this.kZE.length);
      paramParcel.writeIntArray(this.kZE);
    }
    while (this.kZF != null)
    {
      paramParcel.writeInt(this.kZF.length);
      paramParcel.writeFloatArray(this.kZF);
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
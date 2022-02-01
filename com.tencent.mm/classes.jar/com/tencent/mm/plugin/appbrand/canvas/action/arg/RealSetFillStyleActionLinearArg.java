package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
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

public class RealSetFillStyleActionLinearArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionLinearArg> CREATOR;
  public float kZA;
  public float kZB;
  public float kZC;
  public float kZD;
  public int[] kZE;
  public float[] kZF;
  
  static
  {
    AppMethodBeat.i(145053);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145053);
  }
  
  public RealSetFillStyleActionLinearArg() {}
  
  public RealSetFillStyleActionLinearArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(145046);
    if ((this.kZE == null) || (this.kZF == null))
    {
      AppMethodBeat.o(145046);
      return false;
    }
    paramd.kZm.setShader(new LinearGradient(this.kZA, this.kZB, this.kZC, this.kZD, this.kZE, this.kZF, Shader.TileMode.CLAMP));
    AppMethodBeat.o(145046);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145049);
    if (this == paramObject)
    {
      AppMethodBeat.o(145049);
      return true;
    }
    if (!(paramObject instanceof RealSetFillStyleActionLinearArg))
    {
      AppMethodBeat.o(145049);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145049);
      return false;
    }
    paramObject = (RealSetFillStyleActionLinearArg)paramObject;
    if ((Float.compare(paramObject.kZA, this.kZA) == 0) && (Float.compare(paramObject.kZB, this.kZB) == 0) && (Float.compare(paramObject.kZC, this.kZC) == 0) && (Float.compare(paramObject.kZD, this.kZD) == 0) && (Arrays.equals(this.kZE, paramObject.kZE)) && (Arrays.equals(this.kZF, paramObject.kZF)))
    {
      AppMethodBeat.o(145049);
      return true;
    }
    AppMethodBeat.o(145049);
    return false;
  }
  
  public final void f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145051);
    super.f(paramJSONArray);
    if (paramJSONArray.length() < 3)
    {
      AppMethodBeat.o(145051);
      return;
    }
    JSONArray localJSONArray = paramJSONArray.optJSONArray(1);
    if ((localJSONArray == null) || (localJSONArray.length() < 4))
    {
      AppMethodBeat.o(145051);
      return;
    }
    this.kZA = g.f(localJSONArray, 0);
    this.kZB = g.f(localJSONArray, 1);
    this.kZC = g.f(localJSONArray, 2);
    this.kZD = g.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(145051);
      return;
    }
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
    AppMethodBeat.o(145051);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145050);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.kZA), Float.valueOf(this.kZB), Float.valueOf(this.kZC), Float.valueOf(this.kZD) });
    int j = Arrays.hashCode(this.kZE);
    int k = Arrays.hashCode(this.kZF);
    AppMethodBeat.o(145050);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void i(Parcel paramParcel)
  {
    AppMethodBeat.i(145047);
    super.i(paramParcel);
    this.kZA = paramParcel.readFloat();
    this.kZB = paramParcel.readFloat();
    this.kZC = paramParcel.readFloat();
    this.kZD = paramParcel.readFloat();
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
    AppMethodBeat.o(145047);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145052);
    super.parse(paramJSONObject);
    AppMethodBeat.o(145052);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145048);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.kZA);
    paramParcel.writeFloat(this.kZB);
    paramParcel.writeFloat(this.kZC);
    paramParcel.writeFloat(this.kZD);
    if (this.kZE != null)
    {
      paramParcel.writeInt(this.kZE.length);
      paramParcel.writeIntArray(this.kZE);
    }
    while (this.kZF != null)
    {
      paramParcel.writeInt(this.kZF.length);
      paramParcel.writeFloatArray(this.kZF);
      AppMethodBeat.o(145048);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(145048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg
 * JD-Core Version:    0.7.0.1
 */
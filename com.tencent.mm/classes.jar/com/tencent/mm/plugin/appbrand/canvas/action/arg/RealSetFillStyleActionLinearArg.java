package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.y.g;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionLinearArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionLinearArg> CREATOR;
  public float jWE;
  public float jWF;
  public float jWG;
  public float jWH;
  public int[] jWI;
  public float[] jWJ;
  
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
    if ((this.jWI == null) || (this.jWJ == null))
    {
      AppMethodBeat.o(145046);
      return false;
    }
    paramd.jWq.setShader(new LinearGradient(this.jWE, this.jWF, this.jWG, this.jWH, this.jWI, this.jWJ, Shader.TileMode.CLAMP));
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
    if ((Float.compare(paramObject.jWE, this.jWE) == 0) && (Float.compare(paramObject.jWF, this.jWF) == 0) && (Float.compare(paramObject.jWG, this.jWG) == 0) && (Float.compare(paramObject.jWH, this.jWH) == 0) && (Arrays.equals(this.jWI, paramObject.jWI)) && (Arrays.equals(this.jWJ, paramObject.jWJ)))
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
    this.jWE = g.f(localJSONArray, 0);
    this.jWF = g.f(localJSONArray, 1);
    this.jWG = g.f(localJSONArray, 2);
    this.jWH = g.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(145051);
      return;
    }
    this.jWI = new int[paramJSONArray.length()];
    this.jWJ = new float[paramJSONArray.length()];
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localJSONArray = paramJSONArray.optJSONArray(i);
      if (localJSONArray.length() >= 2)
      {
        this.jWJ[i] = ((float)localJSONArray.optDouble(0));
        this.jWI[i] = g.r(localJSONArray.optJSONArray(1));
      }
      i += 1;
    }
    AppMethodBeat.o(145051);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145047);
    super.h(paramParcel);
    this.jWE = paramParcel.readFloat();
    this.jWF = paramParcel.readFloat();
    this.jWG = paramParcel.readFloat();
    this.jWH = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.jWI = new int[i];
      paramParcel.readIntArray(this.jWI);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.jWJ = new float[i];
      paramParcel.readFloatArray(this.jWJ);
    }
    AppMethodBeat.o(145047);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145050);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.jWE), Float.valueOf(this.jWF), Float.valueOf(this.jWG), Float.valueOf(this.jWH) });
    int j = Arrays.hashCode(this.jWI);
    int k = Arrays.hashCode(this.jWJ);
    AppMethodBeat.o(145050);
    return (i * 31 + j) * 31 + k;
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
    paramParcel.writeFloat(this.jWE);
    paramParcel.writeFloat(this.jWF);
    paramParcel.writeFloat(this.jWG);
    paramParcel.writeFloat(this.jWH);
    if (this.jWI != null)
    {
      paramParcel.writeInt(this.jWI.length);
      paramParcel.writeIntArray(this.jWI);
    }
    while (this.jWJ != null)
    {
      paramParcel.writeInt(this.jWJ.length);
      paramParcel.writeFloatArray(this.jWJ);
      AppMethodBeat.o(145048);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(145048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg
 * JD-Core Version:    0.7.0.1
 */
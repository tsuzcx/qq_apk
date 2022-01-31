package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.s.g;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetFillStyleActionRadialArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionRadialArg> CREATOR;
  public float heS;
  public float heT;
  public int[] heW;
  public float heY;
  public float[] positions;
  
  static
  {
    AppMethodBeat.i(103397);
    CREATOR = new RealSetFillStyleActionRadialArg.1();
    AppMethodBeat.o(103397);
  }
  
  public RealSetFillStyleActionRadialArg() {}
  
  public RealSetFillStyleActionRadialArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(103390);
    if ((this.heW == null) || (this.positions == null))
    {
      AppMethodBeat.o(103390);
      return false;
    }
    paramd.heC.setShader(new RadialGradient(this.heS, this.heT, this.heY, this.heW, this.positions, Shader.TileMode.CLAMP));
    AppMethodBeat.o(103390);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103391);
    if (this == paramObject)
    {
      AppMethodBeat.o(103391);
      return true;
    }
    if (!(paramObject instanceof RealSetFillStyleActionRadialArg))
    {
      AppMethodBeat.o(103391);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103391);
      return false;
    }
    paramObject = (RealSetFillStyleActionRadialArg)paramObject;
    if ((Float.compare(paramObject.heS, this.heS) == 0) && (Float.compare(paramObject.heT, this.heT) == 0) && (Float.compare(paramObject.heY, this.heY) == 0) && (Arrays.equals(this.heW, paramObject.heW)) && (Arrays.equals(this.positions, paramObject.positions)))
    {
      AppMethodBeat.o(103391);
      return true;
    }
    AppMethodBeat.o(103391);
    return false;
  }
  
  public final void f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103395);
    super.f(paramJSONArray);
    if (paramJSONArray.length() < 3)
    {
      AppMethodBeat.o(103395);
      return;
    }
    JSONArray localJSONArray = paramJSONArray.optJSONArray(1);
    if ((localJSONArray == null) || (localJSONArray.length() < 3))
    {
      AppMethodBeat.o(103395);
      return;
    }
    this.heS = g.d(localJSONArray, 1);
    this.heT = g.d(localJSONArray, 2);
    this.heY = g.d(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    this.heW = new int[paramJSONArray.length()];
    this.positions = new float[paramJSONArray.length()];
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localJSONArray = paramJSONArray.optJSONArray(i);
      if (localJSONArray.length() >= 2)
      {
        this.positions[i] = ((float)localJSONArray.optDouble(0));
        this.heW[i] = g.o(localJSONArray.optJSONArray(1));
      }
      i += 1;
    }
    AppMethodBeat.o(103395);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103393);
    super.h(paramParcel);
    this.heS = paramParcel.readFloat();
    this.heT = paramParcel.readFloat();
    this.heY = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.heW = new int[i];
      paramParcel.readIntArray(this.heW);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.positions = new float[i];
      paramParcel.readFloatArray(this.positions);
    }
    AppMethodBeat.o(103393);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103392);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.heS), Float.valueOf(this.heT), Float.valueOf(this.heY) });
    int j = Arrays.hashCode(this.heW);
    int k = Arrays.hashCode(this.positions);
    AppMethodBeat.o(103392);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103396);
    super.p(paramJSONObject);
    AppMethodBeat.o(103396);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103394);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.heS);
    paramParcel.writeFloat(this.heT);
    paramParcel.writeFloat(this.heY);
    if (this.heW != null)
    {
      paramParcel.writeInt(this.heW.length);
      paramParcel.writeIntArray(this.heW);
    }
    while (this.positions != null)
    {
      paramParcel.writeInt(this.positions.length);
      paramParcel.writeFloatArray(this.positions);
      AppMethodBeat.o(103394);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(103394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionRadialArg
 * JD-Core Version:    0.7.0.1
 */
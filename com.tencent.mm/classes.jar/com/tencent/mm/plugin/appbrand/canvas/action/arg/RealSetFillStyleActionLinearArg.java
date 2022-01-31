package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
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

public class RealSetFillStyleActionLinearArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionLinearArg> CREATOR;
  public float heS;
  public float heT;
  public float heU;
  public float heV;
  public int[] heW;
  public float[] positions;
  
  static
  {
    AppMethodBeat.i(103370);
    CREATOR = new RealSetFillStyleActionLinearArg.1();
    AppMethodBeat.o(103370);
  }
  
  public RealSetFillStyleActionLinearArg() {}
  
  public RealSetFillStyleActionLinearArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(103363);
    if ((this.heW == null) || (this.positions == null))
    {
      AppMethodBeat.o(103363);
      return false;
    }
    paramd.heC.setShader(new LinearGradient(this.heS, this.heT, this.heU, this.heV, this.heW, this.positions, Shader.TileMode.CLAMP));
    AppMethodBeat.o(103363);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103366);
    if (this == paramObject)
    {
      AppMethodBeat.o(103366);
      return true;
    }
    if (!(paramObject instanceof RealSetFillStyleActionLinearArg))
    {
      AppMethodBeat.o(103366);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103366);
      return false;
    }
    paramObject = (RealSetFillStyleActionLinearArg)paramObject;
    if ((Float.compare(paramObject.heS, this.heS) == 0) && (Float.compare(paramObject.heT, this.heT) == 0) && (Float.compare(paramObject.heU, this.heU) == 0) && (Float.compare(paramObject.heV, this.heV) == 0) && (Arrays.equals(this.heW, paramObject.heW)) && (Arrays.equals(this.positions, paramObject.positions)))
    {
      AppMethodBeat.o(103366);
      return true;
    }
    AppMethodBeat.o(103366);
    return false;
  }
  
  public final void f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103368);
    super.f(paramJSONArray);
    if (paramJSONArray.length() < 3)
    {
      AppMethodBeat.o(103368);
      return;
    }
    JSONArray localJSONArray = paramJSONArray.optJSONArray(1);
    if ((localJSONArray == null) || (localJSONArray.length() < 4))
    {
      AppMethodBeat.o(103368);
      return;
    }
    this.heS = g.d(localJSONArray, 0);
    this.heT = g.d(localJSONArray, 1);
    this.heU = g.d(localJSONArray, 2);
    this.heV = g.d(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(103368);
      return;
    }
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
    AppMethodBeat.o(103368);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103364);
    super.h(paramParcel);
    this.heS = paramParcel.readFloat();
    this.heT = paramParcel.readFloat();
    this.heU = paramParcel.readFloat();
    this.heV = paramParcel.readFloat();
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
    AppMethodBeat.o(103364);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103367);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.heS), Float.valueOf(this.heT), Float.valueOf(this.heU), Float.valueOf(this.heV) });
    int j = Arrays.hashCode(this.heW);
    int k = Arrays.hashCode(this.positions);
    AppMethodBeat.o(103367);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103369);
    super.p(paramJSONObject);
    AppMethodBeat.o(103369);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103365);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.heS);
    paramParcel.writeFloat(this.heT);
    paramParcel.writeFloat(this.heU);
    paramParcel.writeFloat(this.heV);
    if (this.heW != null)
    {
      paramParcel.writeInt(this.heW.length);
      paramParcel.writeIntArray(this.heW);
    }
    while (this.positions != null)
    {
      paramParcel.writeInt(this.positions.length);
      paramParcel.writeFloatArray(this.positions);
      AppMethodBeat.o(103365);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(103365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg
 * JD-Core Version:    0.7.0.1
 */
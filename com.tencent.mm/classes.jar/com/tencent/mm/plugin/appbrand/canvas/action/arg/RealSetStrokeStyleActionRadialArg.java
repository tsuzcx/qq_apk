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

public class RealSetStrokeStyleActionRadialArg
  extends RealSetStrokeStyleActionArg
{
  public static final Parcelable.Creator<RealSetStrokeStyleActionRadialArg> CREATOR;
  public float heS;
  public float heT;
  public int[] heW;
  public float heY;
  public float[] positions;
  
  static
  {
    AppMethodBeat.i(103426);
    CREATOR = new RealSetStrokeStyleActionRadialArg.1();
    AppMethodBeat.o(103426);
  }
  
  public RealSetStrokeStyleActionRadialArg() {}
  
  public RealSetStrokeStyleActionRadialArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(103419);
    if ((this.heW == null) || (this.positions == null))
    {
      AppMethodBeat.o(103419);
      return false;
    }
    paramCanvas = new RadialGradient(this.heS, this.heT, this.heY, this.heW, this.positions, Shader.TileMode.CLAMP);
    paramd.heB.setShader(paramCanvas);
    AppMethodBeat.o(103419);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103420);
    if (this == paramObject)
    {
      AppMethodBeat.o(103420);
      return true;
    }
    if (!(paramObject instanceof RealSetStrokeStyleActionRadialArg))
    {
      AppMethodBeat.o(103420);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103420);
      return false;
    }
    paramObject = (RealSetStrokeStyleActionRadialArg)paramObject;
    if ((Float.compare(paramObject.heS, this.heS) == 0) && (Float.compare(paramObject.heT, this.heT) == 0) && (Float.compare(paramObject.heY, this.heY) == 0) && (Arrays.equals(this.heW, paramObject.heW)) && (Arrays.equals(this.positions, paramObject.positions)))
    {
      AppMethodBeat.o(103420);
      return true;
    }
    AppMethodBeat.o(103420);
    return false;
  }
  
  public final void f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103424);
    super.f(paramJSONArray);
    if (paramJSONArray.length() < 3)
    {
      AppMethodBeat.o(103424);
      return;
    }
    JSONArray localJSONArray = paramJSONArray.optJSONArray(1);
    if ((localJSONArray == null) || (localJSONArray.length() < 3))
    {
      AppMethodBeat.o(103424);
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
    AppMethodBeat.o(103424);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103422);
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
    AppMethodBeat.o(103422);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103421);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.heS), Float.valueOf(this.heT), Float.valueOf(this.heY) });
    int j = Arrays.hashCode(this.heW);
    int k = Arrays.hashCode(this.positions);
    AppMethodBeat.o(103421);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103425);
    super.p(paramJSONObject);
    AppMethodBeat.o(103425);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103423);
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
      AppMethodBeat.o(103423);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(103423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg
 * JD-Core Version:    0.7.0.1
 */
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

public class RealSetStrokeStyleActionRadialArg
  extends RealSetStrokeStyleActionArg
{
  public static final Parcelable.Creator<RealSetStrokeStyleActionRadialArg> CREATOR;
  public float jTn;
  public float jTo;
  public int[] jTr;
  public float[] jTs;
  public float jTu;
  
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
    if ((this.jTr == null) || (this.jTs == null))
    {
      AppMethodBeat.o(145102);
      return false;
    }
    paramCanvas = new RadialGradient(this.jTn, this.jTo, this.jTu, this.jTr, this.jTs, Shader.TileMode.CLAMP);
    paramd.jSY.setShader(paramCanvas);
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
    if ((Float.compare(paramObject.jTn, this.jTn) == 0) && (Float.compare(paramObject.jTo, this.jTo) == 0) && (Float.compare(paramObject.jTu, this.jTu) == 0) && (Arrays.equals(this.jTr, paramObject.jTr)) && (Arrays.equals(this.jTs, paramObject.jTs)))
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
    this.jTn = g.f(localJSONArray, 1);
    this.jTo = g.f(localJSONArray, 2);
    this.jTu = g.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    this.jTr = new int[paramJSONArray.length()];
    this.jTs = new float[paramJSONArray.length()];
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localJSONArray = paramJSONArray.optJSONArray(i);
      if (localJSONArray.length() >= 2)
      {
        this.jTs[i] = ((float)localJSONArray.optDouble(0));
        this.jTr[i] = g.q(localJSONArray.optJSONArray(1));
      }
      i += 1;
    }
    AppMethodBeat.o(145107);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145105);
    super.h(paramParcel);
    this.jTn = paramParcel.readFloat();
    this.jTo = paramParcel.readFloat();
    this.jTu = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.jTr = new int[i];
      paramParcel.readIntArray(this.jTr);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.jTs = new float[i];
      paramParcel.readFloatArray(this.jTs);
    }
    AppMethodBeat.o(145105);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145104);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.jTn), Float.valueOf(this.jTo), Float.valueOf(this.jTu) });
    int j = Arrays.hashCode(this.jTr);
    int k = Arrays.hashCode(this.jTs);
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
    paramParcel.writeFloat(this.jTn);
    paramParcel.writeFloat(this.jTo);
    paramParcel.writeFloat(this.jTu);
    if (this.jTr != null)
    {
      paramParcel.writeInt(this.jTr.length);
      paramParcel.writeIntArray(this.jTr);
    }
    while (this.jTs != null)
    {
      paramParcel.writeInt(this.jTs.length);
      paramParcel.writeFloatArray(this.jTs);
      AppMethodBeat.o(145106);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(145106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
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
  public int[] colors;
  public float[] qTB;
  public float qTD;
  public float qTx;
  public float qTy;
  
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
    if ((this.colors == null) || (this.qTB == null))
    {
      AppMethodBeat.o(145102);
      return false;
    }
    paramCanvas = new RadialGradient(this.qTx, this.qTy, this.qTD, this.colors, this.qTB, Shader.TileMode.CLAMP);
    paramd.qTi.setShader(paramCanvas);
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
    if ((Float.compare(paramObject.qTx, this.qTx) == 0) && (Float.compare(paramObject.qTy, this.qTy) == 0) && (Float.compare(paramObject.qTD, this.qTD) == 0) && (Arrays.equals(this.colors, paramObject.colors)) && (Arrays.equals(this.qTB, paramObject.qTB)))
    {
      AppMethodBeat.o(145103);
      return true;
    }
    AppMethodBeat.o(145103);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145104);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.qTx), Float.valueOf(this.qTy), Float.valueOf(this.qTD) });
    int j = Arrays.hashCode(this.colors);
    int k = Arrays.hashCode(this.qTB);
    AppMethodBeat.o(145104);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void i(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145107);
    super.i(paramJSONArray);
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
    this.qTx = i.f(localJSONArray, 1);
    this.qTy = i.f(localJSONArray, 2);
    this.qTD = i.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    this.colors = new int[paramJSONArray.length()];
    this.qTB = new float[paramJSONArray.length()];
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localJSONArray = paramJSONArray.optJSONArray(i);
      if (localJSONArray.length() >= 2)
      {
        this.qTB[i] = ((float)localJSONArray.optDouble(0));
        this.colors[i] = i.u(localJSONArray.optJSONArray(1));
      }
      i += 1;
    }
    AppMethodBeat.o(145107);
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145105);
    super.k(paramParcel);
    this.qTx = paramParcel.readFloat();
    this.qTy = paramParcel.readFloat();
    this.qTD = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.colors = new int[i];
      paramParcel.readIntArray(this.colors);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.qTB = new float[i];
      paramParcel.readFloatArray(this.qTB);
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
    paramParcel.writeFloat(this.qTx);
    paramParcel.writeFloat(this.qTy);
    paramParcel.writeFloat(this.qTD);
    if (this.colors != null)
    {
      paramParcel.writeInt(this.colors.length);
      paramParcel.writeIntArray(this.colors);
    }
    while (this.qTB != null)
    {
      paramParcel.writeInt(this.qTB.length);
      paramParcel.writeFloatArray(this.qTB);
      AppMethodBeat.o(145106);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(145106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg
 * JD-Core Version:    0.7.0.1
 */
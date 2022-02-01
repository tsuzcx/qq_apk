package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
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

public class RealSetStrokeStyleActionLinearArg
  extends RealSetStrokeStyleActionArg
{
  public static final Parcelable.Creator<RealSetStrokeStyleActionLinearArg> CREATOR;
  public int[] colors;
  public float qTA;
  public float[] qTB;
  public float qTx;
  public float qTy;
  public float qTz;
  
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
    if ((this.colors == null) || (this.qTB == null))
    {
      AppMethodBeat.o(145084);
      return false;
    }
    paramCanvas = new LinearGradient(this.qTx, this.qTy, this.qTz, this.qTA, this.colors, this.qTB, Shader.TileMode.CLAMP);
    paramd.qTi.setShader(paramCanvas);
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
    if ((Float.compare(paramObject.qTx, this.qTx) == 0) && (Float.compare(paramObject.qTy, this.qTy) == 0) && (Float.compare(paramObject.qTz, this.qTz) == 0) && (Float.compare(paramObject.qTA, this.qTA) == 0) && (Arrays.equals(this.colors, paramObject.colors)) && (Arrays.equals(this.qTB, paramObject.qTB)))
    {
      AppMethodBeat.o(145085);
      return true;
    }
    AppMethodBeat.o(145085);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145086);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.qTx), Float.valueOf(this.qTy), Float.valueOf(this.qTz), Float.valueOf(this.qTA) });
    int j = Arrays.hashCode(this.colors);
    int k = Arrays.hashCode(this.qTB);
    AppMethodBeat.o(145086);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void i(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145089);
    super.i(paramJSONArray);
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
    this.qTx = i.f(localJSONArray, 0);
    this.qTy = i.f(localJSONArray, 1);
    this.qTz = i.f(localJSONArray, 2);
    this.qTA = i.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(145089);
      return;
    }
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
    AppMethodBeat.o(145089);
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145087);
    super.k(paramParcel);
    this.qTx = paramParcel.readFloat();
    this.qTy = paramParcel.readFloat();
    this.qTz = paramParcel.readFloat();
    this.qTA = paramParcel.readFloat();
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
    AppMethodBeat.o(145087);
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
    paramParcel.writeFloat(this.qTx);
    paramParcel.writeFloat(this.qTy);
    paramParcel.writeFloat(this.qTz);
    paramParcel.writeFloat(this.qTA);
    if (this.colors != null)
    {
      paramParcel.writeInt(this.colors.length);
      paramParcel.writeIntArray(this.colors);
    }
    while (this.qTB != null)
    {
      paramParcel.writeInt(this.qTB.length);
      paramParcel.writeFloatArray(this.qTB);
      AppMethodBeat.o(145088);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(145088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionLinearArg
 * JD-Core Version:    0.7.0.1
 */
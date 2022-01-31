package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealSetStrokeStyleActionRadialArg
  extends RealSetStrokeStyleActionArg
{
  public static final Parcelable.Creator<RealSetStrokeStyleActionRadialArg> CREATOR = new RealSetStrokeStyleActionRadialArg.1();
  public float fLI;
  public float fLJ;
  public int[] fLM;
  public float fLO;
  public float[] positions;
  
  public RealSetStrokeStyleActionRadialArg() {}
  
  public RealSetStrokeStyleActionRadialArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    if ((this.fLM == null) || (this.positions == null)) {
      return false;
    }
    paramCanvas = new RadialGradient(this.fLI, this.fLJ, this.fLO, this.fLM, this.positions, Shader.TileMode.CLAMP);
    paramd.fLp.setShader(paramCanvas);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(JSONArray paramJSONArray)
  {
    super.e(paramJSONArray);
    if (paramJSONArray.length() < 3) {}
    for (;;)
    {
      return;
      JSONArray localJSONArray = paramJSONArray.optJSONArray(1);
      if ((localJSONArray != null) && (localJSONArray.length() >= 3))
      {
        this.fLI = h.d(localJSONArray, 1);
        this.fLJ = h.d(localJSONArray, 2);
        this.fLO = h.d(localJSONArray, 3);
        paramJSONArray = paramJSONArray.optJSONArray(2);
        this.fLM = new int[paramJSONArray.length()];
        this.positions = new float[paramJSONArray.length()];
        int i = 0;
        while (i < paramJSONArray.length())
        {
          localJSONArray = paramJSONArray.optJSONArray(i);
          if (localJSONArray.length() >= 2)
          {
            this.positions[i] = ((float)localJSONArray.optDouble(0));
            this.fLM[i] = h.l(localJSONArray.optJSONArray(1));
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof RealSetStrokeStyleActionRadialArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (RealSetStrokeStyleActionRadialArg)paramObject;
    } while ((Float.compare(paramObject.fLI, this.fLI) == 0) && (Float.compare(paramObject.fLJ, this.fLJ) == 0) && (Float.compare(paramObject.fLO, this.fLO) == 0) && (Arrays.equals(this.fLM, paramObject.fLM)) && (Arrays.equals(this.positions, paramObject.positions)));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fLI = paramParcel.readFloat();
    this.fLJ = paramParcel.readFloat();
    this.fLO = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.fLM = new int[i];
      paramParcel.readIntArray(this.fLM);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.positions = new float[i];
      paramParcel.readFloatArray(this.positions);
    }
  }
  
  public int hashCode()
  {
    return (Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.fLI), Float.valueOf(this.fLJ), Float.valueOf(this.fLO) }) * 31 + Arrays.hashCode(this.fLM)) * 31 + Arrays.hashCode(this.positions);
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.fLI);
    paramParcel.writeFloat(this.fLJ);
    paramParcel.writeFloat(this.fLO);
    if (this.fLM != null)
    {
      paramParcel.writeInt(this.fLM.length);
      paramParcel.writeIntArray(this.fLM);
    }
    while (this.positions != null)
    {
      paramParcel.writeInt(this.positions.length);
      paramParcel.writeFloatArray(this.positions);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
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

public class RealSetFillStyleActionLinearArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionLinearArg> CREATOR = new RealSetFillStyleActionLinearArg.1();
  public float fLI;
  public float fLJ;
  public float fLK;
  public float fLL;
  public int[] fLM;
  public float[] positions;
  
  public RealSetFillStyleActionLinearArg() {}
  
  public RealSetFillStyleActionLinearArg(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    if ((this.fLM == null) || (this.positions == null)) {
      return false;
    }
    paramd.fLq.setShader(new LinearGradient(this.fLI, this.fLJ, this.fLK, this.fLL, this.fLM, this.positions, Shader.TileMode.CLAMP));
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
      if ((localJSONArray != null) && (localJSONArray.length() >= 4))
      {
        this.fLI = h.d(localJSONArray, 0);
        this.fLJ = h.d(localJSONArray, 1);
        this.fLK = h.d(localJSONArray, 2);
        this.fLL = h.d(localJSONArray, 3);
        paramJSONArray = paramJSONArray.optJSONArray(2);
        if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
        {
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
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof RealSetFillStyleActionLinearArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (RealSetFillStyleActionLinearArg)paramObject;
    } while ((Float.compare(paramObject.fLI, this.fLI) == 0) && (Float.compare(paramObject.fLJ, this.fLJ) == 0) && (Float.compare(paramObject.fLK, this.fLK) == 0) && (Float.compare(paramObject.fLL, this.fLL) == 0) && (Arrays.equals(this.fLM, paramObject.fLM)) && (Arrays.equals(this.positions, paramObject.positions)));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fLI = paramParcel.readFloat();
    this.fLJ = paramParcel.readFloat();
    this.fLK = paramParcel.readFloat();
    this.fLL = paramParcel.readFloat();
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
    return (Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.fLI), Float.valueOf(this.fLJ), Float.valueOf(this.fLK), Float.valueOf(this.fLL) }) * 31 + Arrays.hashCode(this.fLM)) * 31 + Arrays.hashCode(this.positions);
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
    paramParcel.writeFloat(this.fLK);
    paramParcel.writeFloat(this.fLL);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg
 * JD-Core Version:    0.7.0.1
 */
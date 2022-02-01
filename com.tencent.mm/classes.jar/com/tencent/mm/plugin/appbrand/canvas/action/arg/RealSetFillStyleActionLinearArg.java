package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
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
  public float iZa;
  public float iZb;
  public float iZc;
  public float iZd;
  public int[] iZe;
  public float[] iZf;
  
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
    if ((this.iZe == null) || (this.iZf == null))
    {
      AppMethodBeat.o(145046);
      return false;
    }
    paramd.iYM.setShader(new LinearGradient(this.iZa, this.iZb, this.iZc, this.iZd, this.iZe, this.iZf, Shader.TileMode.CLAMP));
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
    if ((Float.compare(paramObject.iZa, this.iZa) == 0) && (Float.compare(paramObject.iZb, this.iZb) == 0) && (Float.compare(paramObject.iZc, this.iZc) == 0) && (Float.compare(paramObject.iZd, this.iZd) == 0) && (Arrays.equals(this.iZe, paramObject.iZe)) && (Arrays.equals(this.iZf, paramObject.iZf)))
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
    this.iZa = g.f(localJSONArray, 0);
    this.iZb = g.f(localJSONArray, 1);
    this.iZc = g.f(localJSONArray, 2);
    this.iZd = g.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(145051);
      return;
    }
    this.iZe = new int[paramJSONArray.length()];
    this.iZf = new float[paramJSONArray.length()];
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localJSONArray = paramJSONArray.optJSONArray(i);
      if (localJSONArray.length() >= 2)
      {
        this.iZf[i] = ((float)localJSONArray.optDouble(0));
        this.iZe[i] = g.p(localJSONArray.optJSONArray(1));
      }
      i += 1;
    }
    AppMethodBeat.o(145051);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145047);
    super.h(paramParcel);
    this.iZa = paramParcel.readFloat();
    this.iZb = paramParcel.readFloat();
    this.iZc = paramParcel.readFloat();
    this.iZd = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.iZe = new int[i];
      paramParcel.readIntArray(this.iZe);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.iZf = new float[i];
      paramParcel.readFloatArray(this.iZf);
    }
    AppMethodBeat.o(145047);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145050);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.iZa), Float.valueOf(this.iZb), Float.valueOf(this.iZc), Float.valueOf(this.iZd) });
    int j = Arrays.hashCode(this.iZe);
    int k = Arrays.hashCode(this.iZf);
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
    paramParcel.writeFloat(this.iZa);
    paramParcel.writeFloat(this.iZb);
    paramParcel.writeFloat(this.iZc);
    paramParcel.writeFloat(this.iZd);
    if (this.iZe != null)
    {
      paramParcel.writeInt(this.iZe.length);
      paramParcel.writeIntArray(this.iZe);
    }
    while (this.iZf != null)
    {
      paramParcel.writeInt(this.iZf.length);
      paramParcel.writeFloatArray(this.iZf);
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
package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
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

public class RealSetFillStyleActionLinearArg
  extends RealSetFillStyleActionArg
{
  public static final Parcelable.Creator<RealSetFillStyleActionLinearArg> CREATOR;
  public float jTn;
  public float jTo;
  public float jTp;
  public float jTq;
  public int[] jTr;
  public float[] jTs;
  
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
    if ((this.jTr == null) || (this.jTs == null))
    {
      AppMethodBeat.o(145046);
      return false;
    }
    paramd.jSZ.setShader(new LinearGradient(this.jTn, this.jTo, this.jTp, this.jTq, this.jTr, this.jTs, Shader.TileMode.CLAMP));
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
    if ((Float.compare(paramObject.jTn, this.jTn) == 0) && (Float.compare(paramObject.jTo, this.jTo) == 0) && (Float.compare(paramObject.jTp, this.jTp) == 0) && (Float.compare(paramObject.jTq, this.jTq) == 0) && (Arrays.equals(this.jTr, paramObject.jTr)) && (Arrays.equals(this.jTs, paramObject.jTs)))
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
    this.jTn = g.f(localJSONArray, 0);
    this.jTo = g.f(localJSONArray, 1);
    this.jTp = g.f(localJSONArray, 2);
    this.jTq = g.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(145051);
      return;
    }
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
    AppMethodBeat.o(145051);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145047);
    super.h(paramParcel);
    this.jTn = paramParcel.readFloat();
    this.jTo = paramParcel.readFloat();
    this.jTp = paramParcel.readFloat();
    this.jTq = paramParcel.readFloat();
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
    AppMethodBeat.o(145047);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145050);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.jTn), Float.valueOf(this.jTo), Float.valueOf(this.jTp), Float.valueOf(this.jTq) });
    int j = Arrays.hashCode(this.jTr);
    int k = Arrays.hashCode(this.jTs);
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
    paramParcel.writeFloat(this.jTn);
    paramParcel.writeFloat(this.jTo);
    paramParcel.writeFloat(this.jTp);
    paramParcel.writeFloat(this.jTq);
    if (this.jTr != null)
    {
      paramParcel.writeInt(this.jTr.length);
      paramParcel.writeIntArray(this.jTr);
    }
    while (this.jTs != null)
    {
      paramParcel.writeInt(this.jTs.length);
      paramParcel.writeFloatArray(this.jTs);
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
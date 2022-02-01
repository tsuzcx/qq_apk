package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
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
  public float nTL;
  public float nTM;
  public float nTN;
  public float nTO;
  public int[] nTP;
  public float[] nTQ;
  
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
    if ((this.nTP == null) || (this.nTQ == null))
    {
      AppMethodBeat.o(145084);
      return false;
    }
    paramCanvas = new LinearGradient(this.nTL, this.nTM, this.nTN, this.nTO, this.nTP, this.nTQ, Shader.TileMode.CLAMP);
    paramd.nTw.setShader(paramCanvas);
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
    if ((Float.compare(paramObject.nTL, this.nTL) == 0) && (Float.compare(paramObject.nTM, this.nTM) == 0) && (Float.compare(paramObject.nTN, this.nTN) == 0) && (Float.compare(paramObject.nTO, this.nTO) == 0) && (Arrays.equals(this.nTP, paramObject.nTP)) && (Arrays.equals(this.nTQ, paramObject.nTQ)))
    {
      AppMethodBeat.o(145085);
      return true;
    }
    AppMethodBeat.o(145085);
    return false;
  }
  
  public final void f(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145089);
    super.f(paramJSONArray);
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
    this.nTL = g.f(localJSONArray, 0);
    this.nTM = g.f(localJSONArray, 1);
    this.nTN = g.f(localJSONArray, 2);
    this.nTO = g.f(localJSONArray, 3);
    paramJSONArray = paramJSONArray.optJSONArray(2);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(145089);
      return;
    }
    this.nTP = new int[paramJSONArray.length()];
    this.nTQ = new float[paramJSONArray.length()];
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localJSONArray = paramJSONArray.optJSONArray(i);
      if (localJSONArray.length() >= 2)
      {
        this.nTQ[i] = ((float)localJSONArray.optDouble(0));
        this.nTP[i] = g.r(localJSONArray.optJSONArray(1));
      }
      i += 1;
    }
    AppMethodBeat.o(145089);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145086);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.nTL), Float.valueOf(this.nTM), Float.valueOf(this.nTN), Float.valueOf(this.nTO) });
    int j = Arrays.hashCode(this.nTP);
    int k = Arrays.hashCode(this.nTQ);
    AppMethodBeat.o(145086);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void i(Parcel paramParcel)
  {
    AppMethodBeat.i(145087);
    super.i(paramParcel);
    this.nTL = paramParcel.readFloat();
    this.nTM = paramParcel.readFloat();
    this.nTN = paramParcel.readFloat();
    this.nTO = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.nTP = new int[i];
      paramParcel.readIntArray(this.nTP);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.nTQ = new float[i];
      paramParcel.readFloatArray(this.nTQ);
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
    paramParcel.writeFloat(this.nTL);
    paramParcel.writeFloat(this.nTM);
    paramParcel.writeFloat(this.nTN);
    paramParcel.writeFloat(this.nTO);
    if (this.nTP != null)
    {
      paramParcel.writeInt(this.nTP.length);
      paramParcel.writeIntArray(this.nTP);
    }
    while (this.nTQ != null)
    {
      paramParcel.writeInt(this.nTQ.length);
      paramParcel.writeFloatArray(this.nTQ);
      AppMethodBeat.o(145088);
      return;
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(145088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionLinearArg
 * JD-Core Version:    0.7.0.1
 */
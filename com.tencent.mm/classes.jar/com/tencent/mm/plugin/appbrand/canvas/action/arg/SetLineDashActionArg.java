package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetLineDashActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetLineDashActionArg> CREATOR;
  public float[] qTH = null;
  public float qTI = 1.4E-45F;
  
  static
  {
    AppMethodBeat.i(145202);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145202);
  }
  
  public SetLineDashActionArg() {}
  
  public SetLineDashActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145200);
    if (this == paramObject)
    {
      AppMethodBeat.o(145200);
      return true;
    }
    if (!(paramObject instanceof SetLineDashActionArg))
    {
      AppMethodBeat.o(145200);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145200);
      return false;
    }
    paramObject = (SetLineDashActionArg)paramObject;
    if ((Float.compare(paramObject.qTI, this.qTI) == 0) && (Arrays.equals(this.qTH, paramObject.qTH)))
    {
      AppMethodBeat.o(145200);
      return true;
    }
    AppMethodBeat.o(145200);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145201);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.qTI) });
    int j = Arrays.hashCode(this.qTH);
    AppMethodBeat.o(145201);
    return i * 31 + j;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145197);
    super.k(paramParcel);
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.qTH = new float[i];
      paramParcel.readFloatArray(this.qTH);
    }
    this.qTI = paramParcel.readFloat();
    AppMethodBeat.o(145197);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(145198);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2)
    {
      AppMethodBeat.o(145198);
      return;
    }
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray(0);
      if (localJSONArray == null)
      {
        AppMethodBeat.o(145198);
        return;
      }
      this.qTH = new float[localJSONArray.length()];
      while (i < this.qTH.length)
      {
        this.qTH[i] = i.f(localJSONArray, i);
        i += 1;
      }
      this.qTI = i.f(paramJSONObject, 1);
      AppMethodBeat.o(145198);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      AppMethodBeat.o(145198);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145199);
    super.writeToParcel(paramParcel, paramInt);
    if (this.qTH != null)
    {
      paramParcel.writeInt(this.qTH.length);
      paramParcel.writeFloatArray(this.qTH);
    }
    paramParcel.writeFloat(this.qTI);
    AppMethodBeat.o(145199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg
 * JD-Core Version:    0.7.0.1
 */
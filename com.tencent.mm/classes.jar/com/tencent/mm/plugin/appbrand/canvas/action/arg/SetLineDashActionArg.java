package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetLineDashActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetLineDashActionArg> CREATOR;
  public float[] hff = null;
  public float hfg = 1.4E-45F;
  
  static
  {
    AppMethodBeat.i(103519);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103519);
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
    AppMethodBeat.i(103517);
    if (this == paramObject)
    {
      AppMethodBeat.o(103517);
      return true;
    }
    if (!(paramObject instanceof SetLineDashActionArg))
    {
      AppMethodBeat.o(103517);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103517);
      return false;
    }
    paramObject = (SetLineDashActionArg)paramObject;
    if ((Float.compare(paramObject.hfg, this.hfg) == 0) && (Arrays.equals(this.hff, paramObject.hff)))
    {
      AppMethodBeat.o(103517);
      return true;
    }
    AppMethodBeat.o(103517);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103514);
    super.h(paramParcel);
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.hff = new float[i];
      paramParcel.readFloatArray(this.hff);
    }
    this.hfg = paramParcel.readFloat();
    AppMethodBeat.o(103514);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103518);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.hfg) });
    int j = Arrays.hashCode(this.hff);
    AppMethodBeat.o(103518);
    return i * 31 + j;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(103515);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2)
    {
      AppMethodBeat.o(103515);
      return;
    }
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray(0);
      if (localJSONArray == null)
      {
        AppMethodBeat.o(103515);
        return;
      }
      this.hff = new float[localJSONArray.length()];
      while (i < this.hff.length)
      {
        this.hff[i] = g.d(localJSONArray, i);
        i += 1;
      }
      this.hfg = g.d(paramJSONObject, 1);
      AppMethodBeat.o(103515);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      AppMethodBeat.o(103515);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103516);
    super.writeToParcel(paramParcel, paramInt);
    if (this.hff != null)
    {
      paramParcel.writeInt(this.hff.length);
      paramParcel.writeFloatArray(this.hff);
    }
    paramParcel.writeFloat(this.hfg);
    AppMethodBeat.o(103516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg
 * JD-Core Version:    0.7.0.1
 */
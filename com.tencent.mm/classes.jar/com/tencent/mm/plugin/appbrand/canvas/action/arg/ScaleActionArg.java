package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class ScaleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<ScaleActionArg> CREATOR;
  public float heS;
  public float heT;
  
  static
  {
    AppMethodBeat.i(103440);
    CREATOR = new ScaleActionArg.1();
    AppMethodBeat.o(103440);
  }
  
  public ScaleActionArg() {}
  
  public ScaleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103437);
    if (this == paramObject)
    {
      AppMethodBeat.o(103437);
      return true;
    }
    if (!(paramObject instanceof ScaleActionArg))
    {
      AppMethodBeat.o(103437);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103437);
      return false;
    }
    paramObject = (ScaleActionArg)paramObject;
    if ((Float.compare(paramObject.heS, this.heS) == 0) && (Float.compare(paramObject.heT, this.heT) == 0))
    {
      AppMethodBeat.o(103437);
      return true;
    }
    AppMethodBeat.o(103437);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103435);
    super.h(paramParcel);
    this.heS = paramParcel.readFloat();
    this.heT = paramParcel.readFloat();
    AppMethodBeat.o(103435);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103438);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.heS), Float.valueOf(this.heT) });
    AppMethodBeat.o(103438);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103436);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.heS = ((float)paramJSONObject.optDouble(0));
    this.heT = ((float)paramJSONObject.optDouble(1));
    AppMethodBeat.o(103436);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103439);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.heS);
    paramParcel.writeFloat(this.heT);
    AppMethodBeat.o(103439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.ScaleActionArg
 * JD-Core Version:    0.7.0.1
 */
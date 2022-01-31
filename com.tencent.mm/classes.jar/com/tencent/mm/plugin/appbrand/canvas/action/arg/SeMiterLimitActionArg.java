package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SeMiterLimitActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SeMiterLimitActionArg> CREATOR;
  public float hfa;
  
  static
  {
    AppMethodBeat.i(103447);
    CREATOR = new SeMiterLimitActionArg.1();
    AppMethodBeat.o(103447);
  }
  
  public SeMiterLimitActionArg() {}
  
  public SeMiterLimitActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103445);
    if (this == paramObject)
    {
      AppMethodBeat.o(103445);
      return true;
    }
    if (!(paramObject instanceof SeMiterLimitActionArg))
    {
      AppMethodBeat.o(103445);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103445);
      return false;
    }
    if (Float.compare(((SeMiterLimitActionArg)paramObject).hfa, this.hfa) == 0)
    {
      AppMethodBeat.o(103445);
      return true;
    }
    AppMethodBeat.o(103445);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103442);
    super.h(paramParcel);
    this.hfa = paramParcel.readFloat();
    AppMethodBeat.o(103442);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103446);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.hfa) });
    AppMethodBeat.o(103446);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103443);
    super.p(paramJSONObject);
    this.hfa = ((float)paramJSONObject.optJSONArray("data").optDouble(0));
    AppMethodBeat.o(103443);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103444);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.hfa);
    AppMethodBeat.o(103444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SeMiterLimitActionArg
 * JD-Core Version:    0.7.0.1
 */
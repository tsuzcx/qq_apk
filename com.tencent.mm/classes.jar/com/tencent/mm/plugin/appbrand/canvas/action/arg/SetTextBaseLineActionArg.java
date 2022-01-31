package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetTextBaseLineActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetTextBaseLineActionArg> CREATOR;
  public String hfl;
  
  static
  {
    AppMethodBeat.i(103570);
    CREATOR = new SetTextBaseLineActionArg.1();
    AppMethodBeat.o(103570);
  }
  
  public SetTextBaseLineActionArg() {}
  
  public SetTextBaseLineActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103568);
    if (this == paramObject)
    {
      AppMethodBeat.o(103568);
      return true;
    }
    if (!(paramObject instanceof SetTextBaseLineActionArg))
    {
      AppMethodBeat.o(103568);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103568);
      return false;
    }
    paramObject = (SetTextBaseLineActionArg)paramObject;
    boolean bool = Objects.equals(this.hfl, paramObject.hfl);
    AppMethodBeat.o(103568);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103565);
    super.h(paramParcel);
    this.hfl = paramParcel.readString();
    AppMethodBeat.o(103565);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103569);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.hfl });
    AppMethodBeat.o(103569);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103566);
    super.p(paramJSONObject);
    this.hfl = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(103566);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103567);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.hfl);
    AppMethodBeat.o(103567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg
 * JD-Core Version:    0.7.0.1
 */
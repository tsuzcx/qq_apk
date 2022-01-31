package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontFamilyActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontFamilyActionArg> CREATOR;
  public String aWz;
  
  static
  {
    AppMethodBeat.i(103470);
    CREATOR = new SetFontFamilyActionArg.1();
    AppMethodBeat.o(103470);
  }
  
  public SetFontFamilyActionArg() {}
  
  public SetFontFamilyActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103468);
    if (this == paramObject)
    {
      AppMethodBeat.o(103468);
      return true;
    }
    if (!(paramObject instanceof SetFontFamilyActionArg))
    {
      AppMethodBeat.o(103468);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103468);
      return false;
    }
    paramObject = (SetFontFamilyActionArg)paramObject;
    boolean bool = Objects.equals(this.aWz, paramObject.aWz);
    AppMethodBeat.o(103468);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103465);
    super.h(paramParcel);
    this.aWz = paramParcel.readString();
    AppMethodBeat.o(103465);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103469);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.aWz });
    AppMethodBeat.o(103469);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103466);
    super.p(paramJSONObject);
    this.aWz = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(103466);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103467);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.aWz);
    AppMethodBeat.o(103467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg
 * JD-Core Version:    0.7.0.1
 */
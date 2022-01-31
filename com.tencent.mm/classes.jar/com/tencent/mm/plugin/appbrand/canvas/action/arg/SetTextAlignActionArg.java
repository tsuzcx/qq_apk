package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetTextAlignActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetTextAlignActionArg> CREATOR;
  public String hfl;
  
  static
  {
    AppMethodBeat.i(103563);
    CREATOR = new SetTextAlignActionArg.1();
    AppMethodBeat.o(103563);
  }
  
  public SetTextAlignActionArg() {}
  
  public SetTextAlignActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103561);
    if (this == paramObject)
    {
      AppMethodBeat.o(103561);
      return true;
    }
    if (!(paramObject instanceof SetTextAlignActionArg))
    {
      AppMethodBeat.o(103561);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103561);
      return false;
    }
    paramObject = (SetTextAlignActionArg)paramObject;
    boolean bool = Objects.equals(this.hfl, paramObject.hfl);
    AppMethodBeat.o(103561);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103558);
    super.h(paramParcel);
    this.hfl = paramParcel.readString();
    AppMethodBeat.o(103558);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103562);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.hfl });
    AppMethodBeat.o(103562);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103559);
    super.p(paramJSONObject);
    this.hfl = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(103559);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103560);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.hfl);
    AppMethodBeat.o(103560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextAlignActionArg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetLineCapActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetLineCapActionArg> CREATOR;
  public String hfe;
  
  static
  {
    AppMethodBeat.i(103512);
    CREATOR = new SetLineCapActionArg.1();
    AppMethodBeat.o(103512);
  }
  
  public SetLineCapActionArg() {}
  
  public SetLineCapActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103510);
    if (this == paramObject)
    {
      AppMethodBeat.o(103510);
      return true;
    }
    if (!(paramObject instanceof SetLineCapActionArg))
    {
      AppMethodBeat.o(103510);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103510);
      return false;
    }
    paramObject = (SetLineCapActionArg)paramObject;
    boolean bool = Objects.equals(this.hfe, paramObject.hfe);
    AppMethodBeat.o(103510);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103507);
    super.h(paramParcel);
    this.hfe = paramParcel.readString();
    AppMethodBeat.o(103507);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103511);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.hfe });
    AppMethodBeat.o(103511);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103508);
    super.p(paramJSONObject);
    this.hfe = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(103508);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103509);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.hfe);
    AppMethodBeat.o(103509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineCapActionArg
 * JD-Core Version:    0.7.0.1
 */
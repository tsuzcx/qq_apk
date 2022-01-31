package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetLineJoinActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetLineJoinActionArg> CREATOR;
  public String hfh;
  
  static
  {
    AppMethodBeat.i(103526);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103526);
  }
  
  public SetLineJoinActionArg() {}
  
  public SetLineJoinActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103524);
    if (this == paramObject)
    {
      AppMethodBeat.o(103524);
      return true;
    }
    if (!(paramObject instanceof SetLineJoinActionArg))
    {
      AppMethodBeat.o(103524);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103524);
      return false;
    }
    paramObject = (SetLineJoinActionArg)paramObject;
    boolean bool = Objects.equals(this.hfh, paramObject.hfh);
    AppMethodBeat.o(103524);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103521);
    super.h(paramParcel);
    this.hfh = paramParcel.readString();
    AppMethodBeat.o(103521);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103525);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.hfh });
    AppMethodBeat.o(103525);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103522);
    super.p(paramJSONObject);
    this.hfh = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(103522);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103523);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.hfh);
    AppMethodBeat.o(103523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineJoinActionArg
 * JD-Core Version:    0.7.0.1
 */
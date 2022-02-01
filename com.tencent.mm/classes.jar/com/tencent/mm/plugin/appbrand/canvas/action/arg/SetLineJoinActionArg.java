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
  public String qTJ;
  
  static
  {
    AppMethodBeat.i(145209);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145209);
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
    AppMethodBeat.i(145207);
    if (this == paramObject)
    {
      AppMethodBeat.o(145207);
      return true;
    }
    if (!(paramObject instanceof SetLineJoinActionArg))
    {
      AppMethodBeat.o(145207);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145207);
      return false;
    }
    paramObject = (SetLineJoinActionArg)paramObject;
    boolean bool = Objects.equals(this.qTJ, paramObject.qTJ);
    AppMethodBeat.o(145207);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145208);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.qTJ });
    AppMethodBeat.o(145208);
    return i;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145204);
    super.k(paramParcel);
    this.qTJ = paramParcel.readString();
    AppMethodBeat.o(145204);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145205);
    super.parse(paramJSONObject);
    this.qTJ = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(145205);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145206);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.qTJ);
    AppMethodBeat.o(145206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineJoinActionArg
 * JD-Core Version:    0.7.0.1
 */
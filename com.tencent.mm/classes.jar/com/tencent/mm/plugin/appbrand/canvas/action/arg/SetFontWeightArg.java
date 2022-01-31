package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontWeightArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontWeightArg> CREATOR;
  public String hfd;
  
  static
  {
    AppMethodBeat.i(103491);
    CREATOR = new SetFontWeightArg.1();
    AppMethodBeat.o(103491);
  }
  
  public SetFontWeightArg() {}
  
  public SetFontWeightArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103489);
    if (this == paramObject)
    {
      AppMethodBeat.o(103489);
      return true;
    }
    if (!(paramObject instanceof SetFontWeightArg))
    {
      AppMethodBeat.o(103489);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103489);
      return false;
    }
    paramObject = (SetFontWeightArg)paramObject;
    boolean bool = Objects.equals(this.hfd, paramObject.hfd);
    AppMethodBeat.o(103489);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103486);
    super.h(paramParcel);
    this.hfd = paramParcel.readString();
    AppMethodBeat.o(103486);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103490);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.hfd });
    AppMethodBeat.o(103490);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103487);
    super.p(paramJSONObject);
    this.hfd = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(103487);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103488);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.hfd);
    AppMethodBeat.o(103488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontWeightArg
 * JD-Core Version:    0.7.0.1
 */
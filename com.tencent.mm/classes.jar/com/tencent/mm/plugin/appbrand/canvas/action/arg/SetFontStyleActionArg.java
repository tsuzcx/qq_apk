package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFontStyleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontStyleActionArg> CREATOR;
  public String hfc;
  
  static
  {
    AppMethodBeat.i(103484);
    CREATOR = new SetFontStyleActionArg.1();
    AppMethodBeat.o(103484);
  }
  
  public SetFontStyleActionArg() {}
  
  public SetFontStyleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103482);
    if (this == paramObject)
    {
      AppMethodBeat.o(103482);
      return true;
    }
    if (!(paramObject instanceof SetFontStyleActionArg))
    {
      AppMethodBeat.o(103482);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103482);
      return false;
    }
    paramObject = (SetFontStyleActionArg)paramObject;
    boolean bool = Objects.equals(this.hfc, paramObject.hfc);
    AppMethodBeat.o(103482);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103479);
    super.h(paramParcel);
    this.hfc = paramParcel.readString();
    AppMethodBeat.o(103479);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103483);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.hfc });
    AppMethodBeat.o(103483);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103480);
    super.p(paramJSONObject);
    this.hfc = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(103480);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103481);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.hfc);
    AppMethodBeat.o(103481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg
 * JD-Core Version:    0.7.0.1
 */
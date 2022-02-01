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
  public String jWV;
  
  static
  {
    AppMethodBeat.i(145246);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145246);
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
    AppMethodBeat.i(145244);
    if (this == paramObject)
    {
      AppMethodBeat.o(145244);
      return true;
    }
    if (!(paramObject instanceof SetTextAlignActionArg))
    {
      AppMethodBeat.o(145244);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145244);
      return false;
    }
    paramObject = (SetTextAlignActionArg)paramObject;
    boolean bool = Objects.equals(this.jWV, paramObject.jWV);
    AppMethodBeat.o(145244);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145241);
    super.h(paramParcel);
    this.jWV = paramParcel.readString();
    AppMethodBeat.o(145241);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145245);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.jWV });
    AppMethodBeat.o(145245);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145242);
    super.parse(paramJSONObject);
    this.jWV = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(145242);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145243);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jWV);
    AppMethodBeat.o(145243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextAlignActionArg
 * JD-Core Version:    0.7.0.1
 */
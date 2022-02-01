package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetGlobalCompositeOperationActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetGlobalCompositeOperationActionArg> CREATOR;
  public String type;
  
  static
  {
    AppMethodBeat.i(145188);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145188);
  }
  
  public SetGlobalCompositeOperationActionArg() {}
  
  public SetGlobalCompositeOperationActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145186);
    if (this == paramObject)
    {
      AppMethodBeat.o(145186);
      return true;
    }
    if (!(paramObject instanceof SetGlobalCompositeOperationActionArg))
    {
      AppMethodBeat.o(145186);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145186);
      return false;
    }
    paramObject = (SetGlobalCompositeOperationActionArg)paramObject;
    boolean bool = Objects.equals(this.type, paramObject.type);
    AppMethodBeat.o(145186);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145187);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.type });
    AppMethodBeat.o(145187);
    return i;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145183);
    super.k(paramParcel);
    this.type = paramParcel.readString();
    AppMethodBeat.o(145183);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145184);
    super.parse(paramJSONObject);
    this.type = paramJSONObject.optJSONArray("data").optString(0);
    AppMethodBeat.o(145184);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145185);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.type);
    AppMethodBeat.o(145185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalCompositeOperationActionArg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetLineWidthActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetLineWidthActionArg> CREATOR;
  public float hfi;
  
  static
  {
    AppMethodBeat.i(103533);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103533);
  }
  
  public SetLineWidthActionArg() {}
  
  public SetLineWidthActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103531);
    if (this == paramObject)
    {
      AppMethodBeat.o(103531);
      return true;
    }
    if (!(paramObject instanceof SetLineWidthActionArg))
    {
      AppMethodBeat.o(103531);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103531);
      return false;
    }
    if (Float.compare(((SetLineWidthActionArg)paramObject).hfi, this.hfi) == 0)
    {
      AppMethodBeat.o(103531);
      return true;
    }
    AppMethodBeat.o(103531);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103528);
    super.h(paramParcel);
    this.hfi = paramParcel.readFloat();
    AppMethodBeat.o(103528);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103532);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.hfi) });
    AppMethodBeat.o(103532);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103529);
    super.p(paramJSONObject);
    this.hfi = g.d(paramJSONObject.optJSONArray("data"), 0);
    AppMethodBeat.o(103529);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103530);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.hfi);
    AppMethodBeat.o(103530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineWidthActionArg
 * JD-Core Version:    0.7.0.1
 */
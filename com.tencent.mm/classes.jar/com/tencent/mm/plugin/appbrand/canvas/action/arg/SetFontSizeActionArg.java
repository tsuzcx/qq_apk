package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetFontSizeActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontSizeActionArg> CREATOR;
  public int size;
  
  static
  {
    AppMethodBeat.i(145160);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145160);
  }
  
  public SetFontSizeActionArg() {}
  
  public SetFontSizeActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145158);
    if (this == paramObject)
    {
      AppMethodBeat.o(145158);
      return true;
    }
    if (!(paramObject instanceof SetFontSizeActionArg))
    {
      AppMethodBeat.o(145158);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145158);
      return false;
    }
    paramObject = (SetFontSizeActionArg)paramObject;
    if (this.size == paramObject.size)
    {
      AppMethodBeat.o(145158);
      return true;
    }
    AppMethodBeat.o(145158);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145155);
    super.h(paramParcel);
    this.size = paramParcel.readInt();
    AppMethodBeat.o(145155);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145159);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.size) });
    AppMethodBeat.o(145159);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145156);
    super.parse(paramJSONObject);
    this.size = g.c(paramJSONObject.optJSONArray("data"), 0);
    AppMethodBeat.o(145156);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145157);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.size);
    AppMethodBeat.o(145157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontSizeActionArg
 * JD-Core Version:    0.7.0.1
 */
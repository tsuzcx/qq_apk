package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import java.util.Objects;
import org.json.JSONObject;

public class SetFontSizeActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFontSizeActionArg> CREATOR;
  public int size;
  
  static
  {
    AppMethodBeat.i(103477);
    CREATOR = new SetFontSizeActionArg.1();
    AppMethodBeat.o(103477);
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
    AppMethodBeat.i(103475);
    if (this == paramObject)
    {
      AppMethodBeat.o(103475);
      return true;
    }
    if (!(paramObject instanceof SetFontSizeActionArg))
    {
      AppMethodBeat.o(103475);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103475);
      return false;
    }
    paramObject = (SetFontSizeActionArg)paramObject;
    if (this.size == paramObject.size)
    {
      AppMethodBeat.o(103475);
      return true;
    }
    AppMethodBeat.o(103475);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103472);
    super.h(paramParcel);
    this.size = paramParcel.readInt();
    AppMethodBeat.o(103472);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103476);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.size) });
    AppMethodBeat.o(103476);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103473);
    super.p(paramJSONObject);
    this.size = g.a(paramJSONObject.optJSONArray("data"), 0);
    AppMethodBeat.o(103473);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103474);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.size);
    AppMethodBeat.o(103474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontSizeActionArg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import java.util.Objects;
import org.json.JSONObject;

public class TranslateActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<TranslateActionArg> CREATOR;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(103584);
    CREATOR = new TranslateActionArg.1();
    AppMethodBeat.o(103584);
  }
  
  public TranslateActionArg() {}
  
  public TranslateActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public final boolean axX()
  {
    return (this.x == 0.0F) && (this.y == 0.0F);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103582);
    if (this == paramObject)
    {
      AppMethodBeat.o(103582);
      return true;
    }
    if (!(paramObject instanceof TranslateActionArg))
    {
      AppMethodBeat.o(103582);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103582);
      return false;
    }
    paramObject = (TranslateActionArg)paramObject;
    if ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0))
    {
      AppMethodBeat.o(103582);
      return true;
    }
    AppMethodBeat.o(103582);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103579);
    super.h(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    AppMethodBeat.o(103579);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103583);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y) });
    AppMethodBeat.o(103583);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103581);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.d(paramJSONObject, 0);
    this.y = g.d(paramJSONObject, 1);
    AppMethodBeat.o(103581);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103580);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    AppMethodBeat.o(103580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.TranslateActionArg
 * JD-Core Version:    0.7.0.1
 */
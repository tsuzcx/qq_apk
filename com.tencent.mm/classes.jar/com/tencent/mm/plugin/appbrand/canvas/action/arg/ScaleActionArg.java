package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class ScaleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<ScaleActionArg> CREATOR;
  public float jWE;
  public float jWF;
  
  static
  {
    AppMethodBeat.i(145123);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145123);
  }
  
  public ScaleActionArg() {}
  
  public ScaleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145120);
    if (this == paramObject)
    {
      AppMethodBeat.o(145120);
      return true;
    }
    if (!(paramObject instanceof ScaleActionArg))
    {
      AppMethodBeat.o(145120);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145120);
      return false;
    }
    paramObject = (ScaleActionArg)paramObject;
    if ((Float.compare(paramObject.jWE, this.jWE) == 0) && (Float.compare(paramObject.jWF, this.jWF) == 0))
    {
      AppMethodBeat.o(145120);
      return true;
    }
    AppMethodBeat.o(145120);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145118);
    super.h(paramParcel);
    this.jWE = paramParcel.readFloat();
    this.jWF = paramParcel.readFloat();
    AppMethodBeat.o(145118);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145121);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.jWE), Float.valueOf(this.jWF) });
    AppMethodBeat.o(145121);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145119);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.jWE = ((float)paramJSONObject.optDouble(0));
    this.jWF = ((float)paramJSONObject.optDouble(1));
    AppMethodBeat.o(145119);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145122);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.jWE);
    paramParcel.writeFloat(this.jWF);
    AppMethodBeat.o(145122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.ScaleActionArg
 * JD-Core Version:    0.7.0.1
 */
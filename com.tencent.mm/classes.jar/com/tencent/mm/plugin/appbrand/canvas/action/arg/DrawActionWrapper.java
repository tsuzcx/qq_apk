package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c;
import org.json.JSONException;
import org.json.JSONObject;

public class DrawActionWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<DrawActionWrapper> CREATOR;
  public BaseDrawActionArg heL;
  public JSONObject heM;
  public int type;
  
  static
  {
    AppMethodBeat.i(103324);
    CREATOR = new DrawActionWrapper.1();
    AppMethodBeat.o(103324);
  }
  
  public DrawActionWrapper() {}
  
  public DrawActionWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(103319);
    this.type = paramParcel.readInt();
    switch (this.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103319);
      return;
      paramParcel = paramParcel.readString();
      try
      {
        this.heM = new JSONObject(paramParcel);
        AppMethodBeat.o(103319);
        return;
      }
      catch (JSONException paramParcel)
      {
        com.tencent.luggage.g.d.printErrStackTrace("DrawActionWrapper", paramParcel, "", new Object[0]);
        AppMethodBeat.o(103319);
        return;
      }
      this.heL = ((BaseDrawActionArg)paramParcel.readParcelable(DrawActionWrapper.class.getClassLoader()));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getMethod()
  {
    AppMethodBeat.i(103321);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(103321);
      return "";
    case 1: 
      str = this.heM.optString("method");
      AppMethodBeat.o(103321);
      return str;
    }
    String str = this.heL.method;
    AppMethodBeat.o(103321);
    return str;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103320);
    if (this.heL != null)
    {
      this.heL.reset();
      c.aya().a(this.heL);
    }
    com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d.ayb().hfv.release(this);
    AppMethodBeat.o(103320);
  }
  
  public String toString()
  {
    AppMethodBeat.i(103322);
    String str = String.format("type %d ,method %s", new Object[] { Integer.valueOf(this.type), getMethod() });
    AppMethodBeat.o(103322);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103323);
    paramParcel.writeInt(this.type);
    switch (this.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103323);
      return;
      paramParcel.writeString(this.heM.toString());
      AppMethodBeat.o(103323);
      return;
      paramParcel.writeParcelable(this.heL, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper
 * JD-Core Version:    0.7.0.1
 */
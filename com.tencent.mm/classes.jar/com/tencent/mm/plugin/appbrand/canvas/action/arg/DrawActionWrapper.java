package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public class DrawActionWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<DrawActionWrapper> CREATOR;
  public JSONObject jWA;
  public BaseDrawActionArg jWz;
  public int type;
  
  static
  {
    AppMethodBeat.i(145007);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145007);
  }
  
  public DrawActionWrapper() {}
  
  public DrawActionWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(145002);
    this.type = paramParcel.readInt();
    switch (this.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(145002);
      return;
      paramParcel = paramParcel.readString();
      try
      {
        this.jWA = new JSONObject(paramParcel);
        AppMethodBeat.o(145002);
        return;
      }
      catch (JSONException paramParcel)
      {
        ae.printErrStackTrace("DrawActionWrapper", paramParcel, "", new Object[0]);
        AppMethodBeat.o(145002);
        return;
      }
      this.jWz = ((BaseDrawActionArg)paramParcel.readParcelable(DrawActionWrapper.class.getClassLoader()));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getMethod()
  {
    AppMethodBeat.i(145004);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(145004);
      return "";
    case 1: 
      str = this.jWA.optString("method");
      AppMethodBeat.o(145004);
      return str;
    }
    String str = this.jWz.method;
    AppMethodBeat.o(145004);
    return str;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(145003);
    if (this.jWz != null)
    {
      this.jWz.reset();
      com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c.bdW().a(this.jWz);
    }
    d.bdX().jXf.release(this);
    AppMethodBeat.o(145003);
  }
  
  public String toString()
  {
    AppMethodBeat.i(145005);
    String str = String.format("type %d ,method %s", new Object[] { Integer.valueOf(this.type), getMethod() });
    AppMethodBeat.o(145005);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145006);
    paramParcel.writeInt(this.type);
    switch (this.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(145006);
      return;
      paramParcel.writeString(this.jWA.toString());
      AppMethodBeat.o(145006);
      return;
      paramParcel.writeParcelable(this.jWz, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper
 * JD-Core Version:    0.7.0.1
 */
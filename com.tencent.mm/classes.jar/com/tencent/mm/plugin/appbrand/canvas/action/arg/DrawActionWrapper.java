package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.sdk.SynchronizedPool;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class DrawActionWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<DrawActionWrapper> CREATOR;
  public BaseDrawActionArg kZv;
  public JSONObject kZw;
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
        this.kZw = new JSONObject(paramParcel);
        AppMethodBeat.o(145002);
        return;
      }
      catch (JSONException paramParcel)
      {
        Log.printErrStackTrace("DrawActionWrapper", paramParcel, "", new Object[0]);
        AppMethodBeat.o(145002);
        return;
      }
      this.kZv = ((BaseDrawActionArg)paramParcel.readParcelable(DrawActionWrapper.class.getClassLoader()));
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
      str = this.kZw.optString("method");
      AppMethodBeat.o(145004);
      return str;
    }
    String str = this.kZv.method;
    AppMethodBeat.o(145004);
    return str;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(145003);
    if (this.kZv != null)
    {
      this.kZv.reset();
      c.bzn().a(this.kZv);
    }
    d.bzo().lab.release(this);
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
      paramParcel.writeString(this.kZw.toString());
      AppMethodBeat.o(145006);
      return;
      paramParcel.writeParcelable(this.kZv, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper
 * JD-Core Version:    0.7.0.1
 */
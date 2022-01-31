package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.g;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetFillStyleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetFillStyleActionArg> CREATOR;
  public RealSetFillStyleActionArg hfb;
  
  static
  {
    AppMethodBeat.i(103456);
    CREATOR = new SetFillStyleActionArg.1();
    AppMethodBeat.o(103456);
  }
  
  public SetFillStyleActionArg() {}
  
  public SetFillStyleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(103450);
    if (this.hfb == null)
    {
      AppMethodBeat.o(103450);
      return false;
    }
    boolean bool = this.hfb.a(paramd, paramCanvas);
    AppMethodBeat.o(103450);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103454);
    if (this == paramObject)
    {
      AppMethodBeat.o(103454);
      return true;
    }
    if (!(paramObject instanceof SetFillStyleActionArg))
    {
      AppMethodBeat.o(103454);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103454);
      return false;
    }
    paramObject = (SetFillStyleActionArg)paramObject;
    boolean bool = Objects.equals(this.hfb, paramObject.hfb);
    AppMethodBeat.o(103454);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103451);
    super.h(paramParcel);
    this.hfb = ((RealSetFillStyleActionArg)paramParcel.readParcelable(SetFillStyleActionArg.class.getClassLoader()));
    AppMethodBeat.o(103451);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103455);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.hfb });
    AppMethodBeat.o(103455);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103453);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2)
    {
      AppMethodBeat.o(103453);
      return;
    }
    String str = paramJSONObject.optString(0);
    this.hfb = ((RealSetFillStyleActionArg)g.aye().zA(str));
    this.hfb.f(paramJSONObject);
    AppMethodBeat.o(103453);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103449);
    super.reset();
    g.aye().a(this.hfb);
    this.hfb = null;
    AppMethodBeat.o(103449);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103452);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.hfb, paramInt);
    AppMethodBeat.o(103452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFillStyleActionArg
 * JD-Core Version:    0.7.0.1
 */
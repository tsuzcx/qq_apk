package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.h;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class SetStrokeStyleActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetStrokeStyleActionArg> CREATOR;
  public RealSetStrokeStyleActionArg hfk;
  
  static
  {
    AppMethodBeat.i(103556);
    CREATOR = new SetStrokeStyleActionArg.1();
    AppMethodBeat.o(103556);
  }
  
  public SetStrokeStyleActionArg() {}
  
  public SetStrokeStyleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(103550);
    if (this.hfk == null)
    {
      AppMethodBeat.o(103550);
      return false;
    }
    boolean bool = this.hfk.a(paramd, paramCanvas);
    AppMethodBeat.o(103550);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103554);
    if (this == paramObject)
    {
      AppMethodBeat.o(103554);
      return true;
    }
    if (!(paramObject instanceof SetStrokeStyleActionArg))
    {
      AppMethodBeat.o(103554);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103554);
      return false;
    }
    paramObject = (SetStrokeStyleActionArg)paramObject;
    boolean bool = Objects.equals(this.hfk, paramObject.hfk);
    AppMethodBeat.o(103554);
    return bool;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103551);
    super.h(paramParcel);
    this.hfk = ((RealSetStrokeStyleActionArg)paramParcel.readParcelable(SetStrokeStyleActionArg.class.getClassLoader()));
    AppMethodBeat.o(103551);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103555);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.hfk });
    AppMethodBeat.o(103555);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103553);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2)
    {
      AppMethodBeat.o(103553);
      return;
    }
    String str = paramJSONObject.optString(0);
    this.hfk = ((RealSetStrokeStyleActionArg)h.ayf().zA(str));
    this.hfk.f(paramJSONObject);
    AppMethodBeat.o(103553);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103549);
    super.reset();
    h.ayf().a(this.hfk);
    this.hfk = null;
    AppMethodBeat.o(103549);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103552);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.hfk, paramInt);
    AppMethodBeat.o(103552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetStrokeStyleActionArg
 * JD-Core Version:    0.7.0.1
 */
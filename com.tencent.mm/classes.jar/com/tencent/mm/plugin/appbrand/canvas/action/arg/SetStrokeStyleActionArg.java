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
  public RealSetStrokeStyleActionArg qTM;
  
  static
  {
    AppMethodBeat.i(145239);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145239);
  }
  
  public SetStrokeStyleActionArg() {}
  
  public SetStrokeStyleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(145233);
    if (this.qTM == null)
    {
      AppMethodBeat.o(145233);
      return false;
    }
    boolean bool = this.qTM.a(paramd, paramCanvas);
    AppMethodBeat.o(145233);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145237);
    if (this == paramObject)
    {
      AppMethodBeat.o(145237);
      return true;
    }
    if (!(paramObject instanceof SetStrokeStyleActionArg))
    {
      AppMethodBeat.o(145237);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145237);
      return false;
    }
    paramObject = (SetStrokeStyleActionArg)paramObject;
    boolean bool = Objects.equals(this.qTM, paramObject.qTM);
    AppMethodBeat.o(145237);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145238);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.qTM });
    AppMethodBeat.o(145238);
    return i;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145234);
    super.k(paramParcel);
    this.qTM = ((RealSetStrokeStyleActionArg)paramParcel.readParcelable(SetStrokeStyleActionArg.class.getClassLoader()));
    AppMethodBeat.o(145234);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145236);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2)
    {
      AppMethodBeat.o(145236);
      return;
    }
    String str = paramJSONObject.optString(0);
    this.qTM = ((RealSetStrokeStyleActionArg)h.ckh().WQ(str));
    this.qTM.i(paramJSONObject);
    AppMethodBeat.o(145236);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(145232);
    super.reset();
    h.ckh().a(this.qTM);
    this.qTM = null;
    AppMethodBeat.o(145232);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145235);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.qTM, paramInt);
    AppMethodBeat.o(145235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetStrokeStyleActionArg
 * JD-Core Version:    0.7.0.1
 */
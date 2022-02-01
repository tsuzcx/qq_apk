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
  public RealSetFillStyleActionArg qTF;
  
  static
  {
    AppMethodBeat.i(145139);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145139);
  }
  
  public SetFillStyleActionArg() {}
  
  public SetFillStyleActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public final boolean a(d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(145133);
    if (this.qTF == null)
    {
      AppMethodBeat.o(145133);
      return false;
    }
    boolean bool = this.qTF.a(paramd, paramCanvas);
    AppMethodBeat.o(145133);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145137);
    if (this == paramObject)
    {
      AppMethodBeat.o(145137);
      return true;
    }
    if (!(paramObject instanceof SetFillStyleActionArg))
    {
      AppMethodBeat.o(145137);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145137);
      return false;
    }
    paramObject = (SetFillStyleActionArg)paramObject;
    boolean bool = Objects.equals(this.qTF, paramObject.qTF);
    AppMethodBeat.o(145137);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145138);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.qTF });
    AppMethodBeat.o(145138);
    return i;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145134);
    super.k(paramParcel);
    this.qTF = ((RealSetFillStyleActionArg)paramParcel.readParcelable(SetFillStyleActionArg.class.getClassLoader()));
    AppMethodBeat.o(145134);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145136);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    if (paramJSONObject.length() < 2)
    {
      AppMethodBeat.o(145136);
      return;
    }
    String str = paramJSONObject.optString(0);
    this.qTF = ((RealSetFillStyleActionArg)g.ckg().WQ(str));
    this.qTF.i(paramJSONObject);
    AppMethodBeat.o(145136);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(145132);
    super.reset();
    g.ckg().a(this.qTF);
    this.qTF = null;
    AppMethodBeat.o(145132);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145135);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.qTF, paramInt);
    AppMethodBeat.o(145135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFillStyleActionArg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetTransformActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<SetTransformActionArg> CREATOR;
  public float bbL;
  public float qTO;
  public float scaleX;
  public float scaleY;
  public float translateX;
  public float translateY;
  
  static
  {
    AppMethodBeat.i(145260);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145260);
  }
  
  public SetTransformActionArg() {}
  
  public SetTransformActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145258);
    if (this == paramObject)
    {
      AppMethodBeat.o(145258);
      return true;
    }
    if (!(paramObject instanceof SetTransformActionArg))
    {
      AppMethodBeat.o(145258);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145258);
      return false;
    }
    paramObject = (SetTransformActionArg)paramObject;
    if ((Float.compare(paramObject.scaleX, this.scaleX) == 0) && (Float.compare(paramObject.bbL, this.bbL) == 0) && (Float.compare(paramObject.qTO, this.qTO) == 0) && (Float.compare(paramObject.scaleY, this.scaleY) == 0) && (Float.compare(paramObject.translateX, this.translateX) == 0) && (Float.compare(paramObject.translateY, this.translateY) == 0))
    {
      AppMethodBeat.o(145258);
      return true;
    }
    AppMethodBeat.o(145258);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145259);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.scaleX), Float.valueOf(this.bbL), Float.valueOf(this.qTO), Float.valueOf(this.scaleY), Float.valueOf(this.translateX), Float.valueOf(this.translateY) });
    AppMethodBeat.o(145259);
    return i;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145255);
    super.k(paramParcel);
    this.scaleX = paramParcel.readFloat();
    this.bbL = paramParcel.readFloat();
    this.qTO = paramParcel.readFloat();
    this.scaleY = paramParcel.readFloat();
    this.translateX = paramParcel.readFloat();
    this.translateY = paramParcel.readFloat();
    AppMethodBeat.o(145255);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145256);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    try
    {
      this.scaleX = ((float)paramJSONObject.getDouble(0));
      this.bbL = ((float)paramJSONObject.getDouble(1));
      this.qTO = ((float)paramJSONObject.getDouble(2));
      this.scaleY = ((float)paramJSONObject.getDouble(3));
      this.translateX = i.e(paramJSONObject, 4);
      this.translateY = i.e(paramJSONObject, 5);
      AppMethodBeat.o(145256);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("SetTransformActionArg", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(145256);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145257);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.scaleY);
    paramParcel.writeFloat(this.bbL);
    paramParcel.writeFloat(this.qTO);
    paramParcel.writeFloat(this.scaleY);
    paramParcel.writeFloat(this.translateX);
    paramParcel.writeFloat(this.translateY);
    AppMethodBeat.o(145257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTransformActionArg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramNavigationBackResult
  implements Parcelable
{
  public static final Parcelable.Creator<MiniProgramNavigationBackResult> CREATOR;
  public JSONObject qxT;
  public JSONObject qxU;
  
  static
  {
    AppMethodBeat.i(134629);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134629);
  }
  
  public MiniProgramNavigationBackResult() {}
  
  private MiniProgramNavigationBackResult(Parcel paramParcel)
  {
    AppMethodBeat.i(134628);
    try
    {
      this.qxT = new JSONObject(Util.nullAs(paramParcel.readString(), "{}"));
      this.qxU = new JSONObject(Util.nullAs(paramParcel.readString(), "{}"));
      AppMethodBeat.o(134628);
      return;
    }
    catch (JSONException paramParcel)
    {
      Log.e("MicroMsg.AppBrand.MiniProgramNavigationBackResult", "readFromParcel, ex = %s", new Object[] { paramParcel });
      AppMethodBeat.o(134628);
    }
  }
  
  public static MiniProgramNavigationBackResult a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    AppMethodBeat.i(134626);
    if ((paramJSONObject1 == null) && (paramJSONObject2 == null))
    {
      AppMethodBeat.o(134626);
      return null;
    }
    MiniProgramNavigationBackResult localMiniProgramNavigationBackResult = new MiniProgramNavigationBackResult();
    JSONObject localJSONObject = new JSONObject();
    if (paramJSONObject1 == null)
    {
      paramJSONObject1 = localJSONObject;
      localMiniProgramNavigationBackResult.qxT = ((JSONObject)paramJSONObject1);
      paramJSONObject1 = new JSONObject();
      if (paramJSONObject2 != null) {
        break label80;
      }
    }
    for (;;)
    {
      localMiniProgramNavigationBackResult.qxU = ((JSONObject)paramJSONObject1);
      AppMethodBeat.o(134626);
      return localMiniProgramNavigationBackResult;
      break;
      label80:
      paramJSONObject1 = paramJSONObject2;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(316874);
    String str = "MiniProgramNavigationBackResult{extraData=" + this.qxT + ", privateData=" + this.qxU + '}';
    AppMethodBeat.o(316874);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(134627);
    if (this.qxT == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.qxU != null) {
        break label54;
      }
    }
    label54:
    for (Object localObject1 = localObject2;; localObject1 = this.qxU.toString())
    {
      paramParcel.writeString((String)localObject1);
      AppMethodBeat.o(134627);
      return;
      localObject1 = this.qxT.toString();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramNavigationBackResult
  implements Parcelable
{
  public static final Parcelable.Creator<MiniProgramNavigationBackResult> CREATOR;
  public JSONObject iHT;
  public JSONObject iHU;
  
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
      this.iHT = new JSONObject(bt.by(paramParcel.readString(), "{}"));
      this.iHU = new JSONObject(bt.by(paramParcel.readString(), "{}"));
      AppMethodBeat.o(134628);
      return;
    }
    catch (JSONException paramParcel)
    {
      ad.e("MicroMsg.AppBrand.MiniProgramNavigationBackResult", "readFromParcel, ex = %s", new Object[] { paramParcel });
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
      localMiniProgramNavigationBackResult.iHT = ((JSONObject)paramJSONObject1);
      paramJSONObject1 = new JSONObject();
      if (paramJSONObject2 != null) {
        break label80;
      }
    }
    for (;;)
    {
      localMiniProgramNavigationBackResult.iHU = ((JSONObject)paramJSONObject1);
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(134627);
    if (this.iHT == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.iHU != null) {
        break label54;
      }
    }
    label54:
    for (Object localObject1 = localObject2;; localObject1 = this.iHU.toString())
    {
      paramParcel.writeString((String)localObject1);
      AppMethodBeat.o(134627);
      return;
      localObject1 = this.iHT.toString();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult
 * JD-Core Version:    0.7.0.1
 */
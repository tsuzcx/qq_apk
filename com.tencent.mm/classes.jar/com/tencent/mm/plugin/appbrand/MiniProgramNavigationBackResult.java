package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramNavigationBackResult
  implements Parcelable
{
  public static final Parcelable.Creator<MiniProgramNavigationBackResult> CREATOR = new MiniProgramNavigationBackResult.1();
  public JSONObject fAv;
  public JSONObject fAw;
  
  public MiniProgramNavigationBackResult() {}
  
  private MiniProgramNavigationBackResult(Parcel paramParcel)
  {
    try
    {
      this.fAv = new JSONObject(bk.aM(paramParcel.readString(), "{}"));
      this.fAw = new JSONObject(bk.aM(paramParcel.readString(), "{}"));
      return;
    }
    catch (JSONException paramParcel)
    {
      y.e("MicroMsg.AppBrand.MiniProgramNavigationBackResult", "readFromParcel, ex = %s", new Object[] { paramParcel });
    }
  }
  
  public static MiniProgramNavigationBackResult a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) && (paramJSONObject2 == null)) {
      return null;
    }
    MiniProgramNavigationBackResult localMiniProgramNavigationBackResult = new MiniProgramNavigationBackResult();
    JSONObject localJSONObject = new JSONObject();
    if (paramJSONObject1 == null)
    {
      paramJSONObject1 = localJSONObject;
      localMiniProgramNavigationBackResult.fAv = ((JSONObject)paramJSONObject1);
      paramJSONObject1 = new JSONObject();
      if (paramJSONObject2 != null) {
        break label65;
      }
    }
    for (;;)
    {
      localMiniProgramNavigationBackResult.fAw = ((JSONObject)paramJSONObject1);
      return localMiniProgramNavigationBackResult;
      break;
      label65:
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
    if (this.fAv == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.fAw != null) {
        break label44;
      }
    }
    label44:
    for (Object localObject1 = localObject2;; localObject1 = this.fAw.toString())
    {
      paramParcel.writeString((String)localObject1);
      return;
      localObject1 = this.fAv.toString();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult
 * JD-Core Version:    0.7.0.1
 */
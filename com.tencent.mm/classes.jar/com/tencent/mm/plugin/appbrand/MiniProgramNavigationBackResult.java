package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniProgramNavigationBackResult
  implements Parcelable
{
  public static final Parcelable.Creator<MiniProgramNavigationBackResult> CREATOR;
  public JSONObject gSe;
  public JSONObject gSf;
  
  static
  {
    AppMethodBeat.i(86795);
    CREATOR = new MiniProgramNavigationBackResult.1();
    AppMethodBeat.o(86795);
  }
  
  public MiniProgramNavigationBackResult() {}
  
  private MiniProgramNavigationBackResult(Parcel paramParcel)
  {
    AppMethodBeat.i(86794);
    try
    {
      this.gSe = new JSONObject(bo.bf(paramParcel.readString(), "{}"));
      this.gSf = new JSONObject(bo.bf(paramParcel.readString(), "{}"));
      AppMethodBeat.o(86794);
      return;
    }
    catch (JSONException paramParcel)
    {
      ab.e("MicroMsg.AppBrand.MiniProgramNavigationBackResult", "readFromParcel, ex = %s", new Object[] { paramParcel });
      AppMethodBeat.o(86794);
    }
  }
  
  public static MiniProgramNavigationBackResult a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    AppMethodBeat.i(86792);
    if ((paramJSONObject1 == null) && (paramJSONObject2 == null))
    {
      AppMethodBeat.o(86792);
      return null;
    }
    MiniProgramNavigationBackResult localMiniProgramNavigationBackResult = new MiniProgramNavigationBackResult();
    JSONObject localJSONObject = new JSONObject();
    if (paramJSONObject1 == null)
    {
      paramJSONObject1 = localJSONObject;
      localMiniProgramNavigationBackResult.gSe = ((JSONObject)paramJSONObject1);
      paramJSONObject1 = new JSONObject();
      if (paramJSONObject2 != null) {
        break label80;
      }
    }
    for (;;)
    {
      localMiniProgramNavigationBackResult.gSf = ((JSONObject)paramJSONObject1);
      AppMethodBeat.o(86792);
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
    AppMethodBeat.i(86793);
    if (this.gSe == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.gSf != null) {
        break label54;
      }
    }
    label54:
    for (Object localObject1 = localObject2;; localObject1 = this.gSf.toString())
    {
      paramParcel.writeString((String)localObject1);
      AppMethodBeat.o(86793);
      return;
      localObject1 = this.gSe.toString();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult
 * JD-Core Version:    0.7.0.1
 */
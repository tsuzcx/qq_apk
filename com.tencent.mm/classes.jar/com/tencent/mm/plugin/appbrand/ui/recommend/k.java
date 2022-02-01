package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/WeAppNativeExtraDataWeUse;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "showOrderEntrance", "", "redDotTypeList", "", "(I[I)V", "TAG", "", "getRedDotTypeList", "()[I", "getShowOrderEntrance", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toJsonString", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements d
{
  private final String TAG = "MicroMsg.AppBrand.WeAppNativeExtraDataWeUse";
  private final int upD = 1;
  private final int[] upE = null;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(180717);
    if (this == paramObject)
    {
      AppMethodBeat.o(180717);
      return true;
    }
    if (!(paramObject instanceof k))
    {
      AppMethodBeat.o(180717);
      return false;
    }
    paramObject = (k)paramObject;
    if (this.upD != paramObject.upD)
    {
      AppMethodBeat.o(180717);
      return false;
    }
    if (!s.p(this.upE, paramObject.upE))
    {
      AppMethodBeat.o(180717);
      return false;
    }
    AppMethodBeat.o(180717);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(180716);
    int j = this.upD;
    if (this.upE == null) {}
    for (int i = 0;; i = Arrays.hashCode(this.upE))
    {
      AppMethodBeat.o(180716);
      return i + j * 31;
    }
  }
  
  public final String toJsonString()
  {
    AppMethodBeat.i(180714);
    JSONArray localJSONArray;
    Object localObject;
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("showOrderEntrance", this.upD);
      if (this.upE != null)
      {
        localJSONArray = new JSONArray();
        localObject = this.upE;
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          int k = localObject[i];
          i += 1;
          localJSONArray.put(k);
          continue;
          AppMethodBeat.o(180714);
        }
      }
    }
    finally
    {
      Log.printErrStackTrace(this.TAG, localThrowable, "toJsonString", new Object[0]);
      str = "{}";
    }
    for (;;)
    {
      return str;
      localObject = ah.aiuX;
      str.put("redDotTypeList", localJSONArray);
      str = str.toString();
      s.s(str, "{\n            val obj = … obj.toString()\n        }");
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(180715);
    String str = toJsonString();
    AppMethodBeat.o(180715);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.k
 * JD-Core Version:    0.7.0.1
 */
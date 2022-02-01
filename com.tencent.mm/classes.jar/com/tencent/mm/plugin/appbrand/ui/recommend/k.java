package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/WeAppNativeExtraDataWeUse;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "showOrderEntrance", "", "redDotTypeList", "", "(I[I)V", "TAG", "", "getRedDotTypeList", "()[I", "getShowOrderEntrance", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toJsonString", "toString", "plugin-appbrand-integration_release"})
public final class k
  implements d
{
  private final String TAG = "MicroMsg.AppBrand.WeAppNativeExtraDataWeUse";
  private final int ofY = 1;
  private final int[] ofZ = null;
  
  public final String bua()
  {
    AppMethodBeat.i(180714);
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("showOrderEntrance", this.ofY);
      if (this.ofZ != null)
      {
        JSONArray localJSONArray = new JSONArray();
        int[] arrayOfInt = this.ofZ;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          localJSONArray.put(arrayOfInt[i]);
          i += 1;
        }
        ((JSONObject)localObject).put("redDotTypeList", localJSONArray);
      }
      localObject = ((JSONObject)localObject).toString();
      p.g(localObject, "obj.toString()");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        Log.printErrStackTrace(this.TAG, localThrowable, "toJsonString", new Object[0]);
        String str = "{}";
      }
    }
    AppMethodBeat.o(180714);
    return localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(180717);
    if (this != paramObject)
    {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if ((this.ofY != paramObject.ofY) || (!p.j(this.ofZ, paramObject.ofZ))) {}
      }
    }
    else
    {
      AppMethodBeat.o(180717);
      return true;
    }
    AppMethodBeat.o(180717);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(180716);
    int j = this.ofY;
    int[] arrayOfInt = this.ofZ;
    if (arrayOfInt != null) {}
    for (int i = Arrays.hashCode(arrayOfInt);; i = 0)
    {
      AppMethodBeat.o(180716);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(180715);
    String str = bua();
    AppMethodBeat.o(180715);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.k
 * JD-Core Version:    0.7.0.1
 */
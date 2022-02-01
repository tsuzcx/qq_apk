package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/WeAppNativeExtraDataWeUse;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "showOrderEntrance", "", "redDotTypeList", "", "(I[I)V", "TAG", "", "getRedDotTypeList", "()[I", "getShowOrderEntrance", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toJsonString", "toString", "plugin-appbrand-integration_release"})
public final class k
  implements d
{
  private final String TAG = "MicroMsg.AppBrand.WeAppNativeExtraDataWeUse";
  private final int lLs = 1;
  private final int[] lLt = null;
  
  public final String aOj()
  {
    AppMethodBeat.i(180714);
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("showOrderEntrance", this.lLs);
      if (this.lLt != null)
      {
        JSONArray localJSONArray = new JSONArray();
        int[] arrayOfInt = this.lLt;
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
      d.g.b.k.g(localObject, "obj.toString()");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        ad.printErrStackTrace(this.TAG, localThrowable, "toJsonString", new Object[0]);
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
        if ((this.lLs != paramObject.lLs) || (!d.g.b.k.g(this.lLt, paramObject.lLt))) {}
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
    int j = this.lLs;
    int[] arrayOfInt = this.lLt;
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
    String str = aOj();
    AppMethodBeat.o(180715);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.k
 * JD-Core Version:    0.7.0.1
 */
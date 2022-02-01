package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/WxLiveShoppingExtranData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "clickScene", "", "getClickScene", "()I", "setClickScene", "(I)V", "clickid", "", "getClickid", "()[B", "setClickid", "([B)V", "extraData", "getExtraData", "setExtraData", "(Ljava/lang/String;)V", "isPreRender", "setPreRender", "openMode", "getOpenMode", "setOpenMode", "productId", "", "getProductId", "()J", "setProductId", "(J)V", "shopExtraData", "getShopExtraData", "setShopExtraData", "toJsonString", "toString", "plugin-finder_release"})
public final class x
  implements d
{
  private final String TAG = "WxLiveShoppingExtranData";
  private String dSJ = "";
  public long uko;
  public int ukp;
  private String ukq = "";
  public String ukr = "";
  public int uks;
  public byte[] ukt;
  
  public final void atG(String paramString)
  {
    AppMethodBeat.i(246290);
    p.h(paramString, "<set-?>");
    this.dSJ = paramString;
    AppMethodBeat.o(246290);
  }
  
  public final void atH(String paramString)
  {
    AppMethodBeat.i(246291);
    p.h(paramString, "<set-?>");
    this.ukq = paramString;
    AppMethodBeat.o(246291);
  }
  
  public final String bua()
  {
    AppMethodBeat.i(246292);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("extraData", this.dSJ);
      localJSONObject.put("productId", this.uko);
      localJSONObject.put("isPreRender", this.ukp);
      localJSONObject.put("openMode", this.ukq);
      String str3 = this.ukr;
      str1 = str3;
      if (str3 == null) {
        str1 = "";
      }
      localJSONObject.put("shopExtraData", str1);
      str1 = localJSONObject.toString();
      p.g(str1, "obj.toString()");
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str1;
        Log.printErrStackTrace(this.TAG, (Throwable)localJSONException, "", new Object[0]);
        String str2 = "{}";
      }
    }
    AppMethodBeat.o(246292);
    return str1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246293);
    String str = bua();
    AppMethodBeat.o(246293);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.x
 * JD-Core Version:    0.7.0.1
 */
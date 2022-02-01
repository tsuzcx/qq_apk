package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/WxLiveShoppingExtranData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "()V", "clickScene", "", "getClickScene", "()I", "setClickScene", "(I)V", "clickid", "", "getClickid", "()[B", "setClickid", "([B)V", "enableGesture", "", "getEnableGesture", "()Z", "setEnableGesture", "(Z)V", "extraData", "", "getExtraData", "()Ljava/lang/String;", "setExtraData", "(Ljava/lang/String;)V", "isPreRender", "setPreRender", "openMode", "getOpenMode", "setOpenMode", "platform_id", "getPlatform_id", "setPlatform_id", "preloadType", "getPreloadType", "setPreloadType", "productId", "", "getProductId", "()J", "setProductId", "(J)V", "shopExtraData", "getShopExtraData", "setShopExtraData", "toJsonString", "toString", "Companion", "plugin-finder_release"})
public final class at
  implements d
{
  public static final a yiI;
  private String fMh = "";
  public int yiA;
  private String yiB = "";
  public String yiC = "";
  public int yiD;
  public byte[] yiE;
  public int yiF;
  public boolean yiG = true;
  public int yiH;
  public long yiz;
  
  static
  {
    AppMethodBeat.i(287638);
    yiI = new a((byte)0);
    AppMethodBeat.o(287638);
  }
  
  public final void aCh(String paramString)
  {
    AppMethodBeat.i(287634);
    p.k(paramString, "<set-?>");
    this.fMh = paramString;
    AppMethodBeat.o(287634);
  }
  
  public final void aCi(String paramString)
  {
    AppMethodBeat.i(287635);
    p.k(paramString, "<set-?>");
    this.yiB = paramString;
    AppMethodBeat.o(287635);
  }
  
  public final String bFa()
  {
    AppMethodBeat.i(287636);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("extraData", this.fMh);
      localJSONObject.put("productId", this.yiz);
      localJSONObject.put("isPreRender", this.yiA);
      localJSONObject.put("openMode", this.yiB);
      String str3 = this.yiC;
      str1 = str3;
      if (str3 == null) {
        str1 = "";
      }
      localJSONObject.put("shopExtraData", str1);
      str1 = localJSONObject.toString();
      p.j(str1, "obj.toString()");
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str1;
        Log.printErrStackTrace("WxLiveShoppingExtranData", (Throwable)localJSONException, "", new Object[0]);
        String str2 = "{}";
      }
    }
    AppMethodBeat.o(287636);
    return str1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(287637);
    String str = bFa();
    AppMethodBeat.o(287637);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/WxLiveShoppingExtranData$Companion;", "", "()V", "PRE_DOWNLOAD", "", "PRE_HOT", "PRE_LOAD", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.at
 * JD-Core Version:    0.7.0.1
 */
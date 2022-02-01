package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/WxLiveShoppingExtranData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "()V", "clickScene", "", "getClickScene", "()I", "setClickScene", "(I)V", "clickid", "", "getClickid", "()[B", "setClickid", "([B)V", "enableGesture", "", "getEnableGesture", "()Z", "setEnableGesture", "(Z)V", "extraData", "", "getExtraData", "()Ljava/lang/String;", "setExtraData", "(Ljava/lang/String;)V", "forbidSlidingUpGesture", "getForbidSlidingUpGesture", "setForbidSlidingUpGesture", "isPreRender", "setPreRender", "openMode", "getOpenMode", "setOpenMode", "preloadType", "getPreloadType", "setPreloadType", "productId", "", "getProductId", "()J", "setProductId", "(J)V", "shopExtraData", "getShopExtraData", "setShopExtraData", "toJsonString", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
  implements d
{
  public static final ay.a CID;
  public long Azu;
  public int CIE;
  private String CIF = "";
  public String CIG = "";
  public int CIH;
  public byte[] CII;
  public int CIJ;
  public boolean CIK = true;
  private String hRR = "";
  public boolean qZT;
  
  static
  {
    AppMethodBeat.i(360051);
    CID = new ay.a((byte)0);
    AppMethodBeat.o(360051);
  }
  
  public final void awD(String paramString)
  {
    AppMethodBeat.i(360059);
    s.u(paramString, "<set-?>");
    this.hRR = paramString;
    AppMethodBeat.o(360059);
  }
  
  public final void awE(String paramString)
  {
    AppMethodBeat.i(360065);
    s.u(paramString, "<set-?>");
    this.CIF = paramString;
    AppMethodBeat.o(360065);
  }
  
  public final String toJsonString()
  {
    AppMethodBeat.i(360078);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("extraData", this.hRR);
      localJSONObject.put("productId", this.Azu);
      localJSONObject.put("isPreRender", this.CIE);
      localJSONObject.put("openMode", this.CIF);
      String str3 = this.CIG;
      str1 = str3;
      if (str3 == null) {
        str1 = "";
      }
      localJSONObject.put("shopExtraData", str1);
      str1 = localJSONObject.toString();
      s.s(str1, "{\n            val obj = … obj.toString()\n        }");
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
    AppMethodBeat.o(360078);
    return str1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(360085);
    String str = toJsonString();
    AppMethodBeat.o(360085);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ay
 * JD-Core Version:    0.7.0.1
 */
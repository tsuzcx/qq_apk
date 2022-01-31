package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public static f yP(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardMallItemParser", "parseCardMallItem jsonContent is null");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      f localf = new f();
      localf.imD = paramString.optString("empty_tips");
      localf.imE = paramString.optString("shoppingmall_title");
      localf.imF = paramString.optString("shoppingmall_url");
      if (paramString.optInt("is_show") == 0) {}
      for (boolean bool = false;; bool = true)
      {
        localf.imG = bool;
        return localf;
      }
      return null;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.CardMallItemParser", paramString, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.i
 * JD-Core Version:    0.7.0.1
 */
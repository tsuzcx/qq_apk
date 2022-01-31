package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public static f Iz(String paramString)
  {
    AppMethodBeat.i(88876);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.CardMallItemParser", "parseCardMallItem jsonContent is null");
      AppMethodBeat.o(88876);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      f localf = new f();
      localf.knz = paramString.optString("empty_tips");
      localf.knA = paramString.optString("shoppingmall_title");
      localf.knB = paramString.optString("shoppingmall_url");
      if (paramString.optInt("is_show") == 0) {}
      for (boolean bool = false;; bool = true)
      {
        localf.knC = bool;
        AppMethodBeat.o(88876);
        return localf;
      }
      return null;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.CardMallItemParser", paramString, "", new Object[0]);
      AppMethodBeat.o(88876);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.i
 * JD-Core Version:    0.7.0.1
 */
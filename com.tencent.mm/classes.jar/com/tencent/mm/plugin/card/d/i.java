package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public static f arP(String paramString)
  {
    AppMethodBeat.i(113804);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardMallItemParser", "parseCardMallItem jsonContent is null");
      AppMethodBeat.o(113804);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      f localf = new f();
      localf.tpr = paramString.optString("empty_tips");
      localf.tps = paramString.optString("shoppingmall_title");
      localf.tpt = paramString.optString("shoppingmall_url");
      if (paramString.optInt("is_show") == 0) {}
      for (boolean bool = false;; bool = true)
      {
        localf.tpu = bool;
        AppMethodBeat.o(113804);
        return localf;
      }
      return null;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.CardMallItemParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113804);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.i
 * JD-Core Version:    0.7.0.1
 */
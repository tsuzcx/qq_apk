package com.tencent.mm.plugin.lite.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.bj;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class e
  extends com.tencent.mm.plugin.lite.api.e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271517);
    Log.d("LiteAppJsApiOpenFinderPostView", "Invoke openFinderPostView");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271517);
      return;
    }
    try
    {
      paramString = paramJSONObject.optJSONObject("jumpInfo");
      ((cn)h.az(cn.class)).enterFinderPostUI(MMApplicationContext.getContext(), paramString.toString(), 3, new bj()
      {
        public final void callback(int paramAnonymousInt, String paramAnonymousString) {}
      });
      this.JZj.fTW();
      AppMethodBeat.o(271517);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("LiteAppJsApiOpenFinderPostView", paramString, "openFinderPostView fail", new Object[0]);
      this.JZj.aJV("fail");
      AppMethodBeat.o(271517);
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.d.e
 * JD-Core Version:    0.7.0.1
 */
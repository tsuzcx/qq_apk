package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class a$8
  implements a.a
{
  a$8(a parama) {}
  
  public final void z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154400);
    if (!bo.isNullOrNil(paramString2))
    {
      ab.i(this.bGK.xo(), "operatePlayBgm, local file path:%s", new Object[] { paramString2 });
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("BGMFilePath", paramString2);
        if ((this.bGK.bGz != null) && (this.bGK.bGz.b("playBGM", localJSONObject).errorCode != 0))
        {
          ab.e("MicroMsg.SameLayer.LivePusherPluginHandler", "operatePlayBgm, play bgm fail, url:%s", new Object[] { paramString1 });
          if (this.bGK.bGB != null)
          {
            paramString2 = new HashMap();
            paramString2.put("url", paramString1);
            this.bGK.bGB.a(this.bGK.getId(), 10003, "play bgm fail", paramString2);
          }
        }
        AppMethodBeat.o(154400);
        return;
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          ab.e("MicroMsg.SameLayer.LivePusherPluginHandler", "operatePlayBgm, set param fail", new Object[] { paramString2 });
        }
      }
    }
    ab.e("MicroMsg.SameLayer.LivePusherPluginHandler", "operatePlayBgm, download file fail, url:%s", new Object[] { paramString1 });
    if (this.bGK.bGB != null)
    {
      paramString2 = new HashMap();
      paramString2.put("url", paramString1);
      this.bGK.bGB.a(this.bGK.getId(), 10003, "download file fail", paramString2);
    }
    AppMethodBeat.o(154400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.8
 * JD-Core Version:    0.7.0.1
 */
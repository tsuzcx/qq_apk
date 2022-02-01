package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import org.json.JSONException;
import org.json.JSONObject;

final class CleanNewUI$9
  extends b.c
{
  CleanNewUI$9(CleanNewUI paramCleanNewUI, String paramString)
  {
    super(paramString);
  }
  
  public final void onComplete()
  {
    AppMethodBeat.i(193187);
    ad.d("MicroMsg.CleanNewUI", "request onComplete:%s", new Object[] { this.content });
    try
    {
      new JSONObject(this.content);
      ba.aBQ();
      c.ajl().set(al.a.ItZ, this.content);
      AppMethodBeat.o(193187);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      g.yhR.idkeyStat(714L, 6L, 1L, false);
      AppMethodBeat.o(193187);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.9
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
    AppMethodBeat.i(195975);
    ac.d("MicroMsg.CleanNewUI", "request onComplete:%s", new Object[] { this.content });
    try
    {
      new JSONObject(this.content);
      az.ayM();
      c.agA().set(ah.a.GHH, this.content);
      AppMethodBeat.o(195975);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      h.wUl.idkeyStat(714L, 6L, 1L, false);
      AppMethodBeat.o(195975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.9
 * JD-Core Version:    0.7.0.1
 */
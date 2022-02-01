package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
    AppMethodBeat.i(186447);
    ae.d("MicroMsg.CleanNewUI", "request onComplete:%s", new Object[] { this.content });
    try
    {
      new JSONObject(this.content);
      bc.aCg();
      c.ajA().set(am.a.IOw, this.content);
      AppMethodBeat.o(186447);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      g.yxI.idkeyStat(714L, 6L, 1L, false);
      AppMethodBeat.o(186447);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.9
 * JD-Core Version:    0.7.0.1
 */
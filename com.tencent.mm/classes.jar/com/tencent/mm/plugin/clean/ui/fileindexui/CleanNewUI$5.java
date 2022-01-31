package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import org.json.JSONException;
import org.json.JSONObject;

final class CleanNewUI$5
  extends b.c
{
  CleanNewUI$5(CleanNewUI paramCleanNewUI, String paramString)
  {
    super(paramString);
  }
  
  public final void onComplete()
  {
    AppMethodBeat.i(18816);
    ab.d("MicroMsg.CleanNewUI", "request onComplete:%s", new Object[] { this.content });
    try
    {
      new JSONObject(this.content);
      aw.aaz();
      c.Ru().set(ac.a.yBw, this.content);
      AppMethodBeat.o(18816);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      h.qsU.idkeyStat(714L, 6L, 1L, false);
      AppMethodBeat.o(18816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.5
 * JD-Core Version:    0.7.0.1
 */
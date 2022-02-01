package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.http.HttpWrapperBase.Response;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import org.json.JSONException;
import org.json.JSONObject;

final class CleanNewUI$9
  extends HttpWrapperBase.Response
{
  CleanNewUI$9(CleanNewUI paramCleanNewUI, String paramString)
  {
    super(0, null, paramString);
  }
  
  public final void onComplete()
  {
    AppMethodBeat.i(245430);
    Log.d("MicroMsg.CleanNewUI", "request onComplete:%s", new Object[] { this.content });
    try
    {
      new JSONObject(this.content);
      bh.beI();
      c.aHp().set(ar.a.Vky, this.content);
      AppMethodBeat.o(245430);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      h.IzE.idkeyStat(714L, 6L, 1L, false);
      AppMethodBeat.o(245430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.9
 * JD-Core Version:    0.7.0.1
 */
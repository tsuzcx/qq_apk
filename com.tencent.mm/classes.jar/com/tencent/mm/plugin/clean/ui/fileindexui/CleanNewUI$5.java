package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.y;
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
    y.d("MicroMsg.CleanNewUI", "request onComplete:%s", new Object[] { this.content });
    try
    {
      new JSONObject(this.content);
      au.Hx();
      c.Dz().c(ac.a.urx, this.content);
      return;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.CleanNewUI", localJSONException, "", new Object[0]);
      h.nFQ.a(714L, 6L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.5
 * JD-Core Version:    0.7.0.1
 */
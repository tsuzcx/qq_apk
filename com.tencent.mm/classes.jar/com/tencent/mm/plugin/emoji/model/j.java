package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import org.json.JSONObject;

public final class j
{
  private static j xME;
  public String xMF;
  public String xMG;
  public boolean xMH;
  public boolean xMI;
  public String xMJ;
  public String xMK;
  
  public j()
  {
    AppMethodBeat.i(179054);
    this.xMH = false;
    this.xMI = false;
    this.xMG = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXe, ""));
    this.xMF = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXf, ""));
    dzO();
    AppMethodBeat.o(179054);
  }
  
  public static j dzN()
  {
    try
    {
      AppMethodBeat.i(179053);
      if (xME == null) {
        xME = new j();
      }
      j localj = xME;
      AppMethodBeat.o(179053);
      return localj;
    }
    finally {}
  }
  
  public final void dzO()
  {
    AppMethodBeat.i(179055);
    Log.i("MicroMsg.EmojiStoreExpt", "updateExpt: %s %s", new Object[] { this.xMG, this.xMF });
    try
    {
      if (!Util.isNullOrNil(this.xMG)) {
        this.xMH = Util.isEqual(com.tencent.mm.ad.h.Fn(this.xMG).optString("second_strategy", "None"), "Paid");
      }
      if (!Util.isNullOrNil(this.xMF))
      {
        JSONObject localJSONObject = com.tencent.mm.ad.h.Fn(this.xMF);
        this.xMI = Util.isEqual(localJSONObject.optString("strategy", "Recommend"), "FriendDownloads");
        this.xMJ = localJSONObject.optString("tab_wording");
        this.xMK = localJSONObject.optString("list_wording");
      }
      AppMethodBeat.o(179055);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.EmojiStoreExpt", localException, "", new Object[0]);
      this.xMH = false;
      this.xMI = false;
      AppMethodBeat.o(179055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.j
 * JD-Core Version:    0.7.0.1
 */
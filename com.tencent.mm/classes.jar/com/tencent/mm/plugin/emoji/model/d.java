package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import org.json.JSONObject;

public final class d
{
  private static d pKD;
  public String pKE;
  public String pKF;
  public boolean pKG;
  public boolean pKH;
  public String pKI;
  public String pKJ;
  
  public d()
  {
    AppMethodBeat.i(179054);
    this.pKG = false;
    this.pKH = false;
    this.pKF = ((String)g.ajR().ajA().get(am.a.IYI, ""));
    this.pKE = ((String)g.ajR().ajA().get(am.a.IYJ, ""));
    chZ();
    AppMethodBeat.o(179054);
  }
  
  public static d chY()
  {
    try
    {
      AppMethodBeat.i(179053);
      if (pKD == null) {
        pKD = new d();
      }
      d locald = pKD;
      AppMethodBeat.o(179053);
      return locald;
    }
    finally {}
  }
  
  public final void chZ()
  {
    AppMethodBeat.i(179055);
    ae.i("MicroMsg.EmojiStoreExpt", "updateExpt: %s %s", new Object[] { this.pKF, this.pKE });
    try
    {
      if (!bu.isNullOrNil(this.pKF)) {
        this.pKG = bu.lX(h.xs(this.pKF).optString("second_strategy", "None"), "Paid");
      }
      if (!bu.isNullOrNil(this.pKE))
      {
        JSONObject localJSONObject = h.xs(this.pKE);
        this.pKH = bu.lX(localJSONObject.optString("strategy", "Recommend"), "FriendDownloads");
        this.pKI = localJSONObject.optString("tab_wording");
        this.pKJ = localJSONObject.optString("list_wording");
      }
      AppMethodBeat.o(179055);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.EmojiStoreExpt", localException, "", new Object[0]);
      this.pKG = false;
      this.pKH = false;
      AppMethodBeat.o(179055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d
 * JD-Core Version:    0.7.0.1
 */
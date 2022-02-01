package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import org.json.JSONObject;

public final class d
{
  private static d pDZ;
  public String pEa;
  public String pEb;
  public boolean pEc;
  public boolean pEd;
  public String pEe;
  public String pEf;
  
  public d()
  {
    AppMethodBeat.i(179054);
    this.pEc = false;
    this.pEd = false;
    this.pEb = ((String)g.ajC().ajl().get(al.a.IEi, ""));
    this.pEa = ((String)g.ajC().ajl().get(al.a.IEj, ""));
    cgJ();
    AppMethodBeat.o(179054);
  }
  
  public static d cgI()
  {
    try
    {
      AppMethodBeat.i(179053);
      if (pDZ == null) {
        pDZ = new d();
      }
      d locald = pDZ;
      AppMethodBeat.o(179053);
      return locald;
    }
    finally {}
  }
  
  public final void cgJ()
  {
    AppMethodBeat.i(179055);
    ad.i("MicroMsg.EmojiStoreExpt", "updateExpt: %s %s", new Object[] { this.pEb, this.pEa });
    try
    {
      if (!bt.isNullOrNil(this.pEb)) {
        this.pEc = bt.lQ(h.wJ(this.pEb).optString("second_strategy", "None"), "Paid");
      }
      if (!bt.isNullOrNil(this.pEa))
      {
        JSONObject localJSONObject = h.wJ(this.pEa);
        this.pEd = bt.lQ(localJSONObject.optString("strategy", "Recommend"), "FriendDownloads");
        this.pEe = localJSONObject.optString("tab_wording");
        this.pEf = localJSONObject.optString("list_wording");
      }
      AppMethodBeat.o(179055);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.EmojiStoreExpt", localException, "", new Object[0]);
      this.pEc = false;
      this.pEd = false;
      AppMethodBeat.o(179055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d
 * JD-Core Version:    0.7.0.1
 */
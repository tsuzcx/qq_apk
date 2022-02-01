package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import org.json.JSONObject;

public final class d
{
  private static d owP;
  public String owQ;
  public String owR;
  public boolean owS;
  public boolean owT;
  public String owU;
  public String owV;
  
  public d()
  {
    AppMethodBeat.i(179054);
    this.owS = false;
    this.owT = false;
    this.owR = ((String)g.afB().afk().get(ae.a.FtK, ""));
    this.owQ = ((String)g.afB().afk().get(ae.a.FtL, ""));
    bUS();
    AppMethodBeat.o(179054);
  }
  
  public static d bUR()
  {
    try
    {
      AppMethodBeat.i(179053);
      if (owP == null) {
        owP = new d();
      }
      d locald = owP;
      AppMethodBeat.o(179053);
      return locald;
    }
    finally {}
  }
  
  public final void bUS()
  {
    AppMethodBeat.i(179055);
    ad.i("MicroMsg.EmojiStoreExpt", "updateExpt: %s %s", new Object[] { this.owR, this.owQ });
    try
    {
      if (!bt.isNullOrNil(this.owR)) {
        this.owS = bt.kU(h.qE(this.owR).optString("second_strategy", "None"), "Paid");
      }
      if (!bt.isNullOrNil(this.owQ))
      {
        JSONObject localJSONObject = h.qE(this.owQ);
        this.owT = bt.kU(localJSONObject.optString("strategy", "Recommend"), "FriendDownloads");
        this.owU = localJSONObject.optString("tab_wording");
        this.owV = localJSONObject.optString("list_wording");
      }
      AppMethodBeat.o(179055);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.EmojiStoreExpt", localException, "", new Object[0]);
      this.owS = false;
      this.owT = false;
      AppMethodBeat.o(179055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d
 * JD-Core Version:    0.7.0.1
 */
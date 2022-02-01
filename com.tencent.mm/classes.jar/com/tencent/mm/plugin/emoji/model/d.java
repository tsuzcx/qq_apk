package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import org.json.JSONObject;

public final class d
{
  private static d pap;
  public String paq;
  public String par;
  public boolean pas;
  public boolean pat;
  public String pau;
  public String pav;
  
  public d()
  {
    AppMethodBeat.i(179054);
    this.pas = false;
    this.pat = false;
    this.par = ((String)g.agR().agA().get(ah.a.GRE, ""));
    this.paq = ((String)g.agR().agA().get(ah.a.GRF, ""));
    ccf();
    AppMethodBeat.o(179054);
  }
  
  public static d cce()
  {
    try
    {
      AppMethodBeat.i(179053);
      if (pap == null) {
        pap = new d();
      }
      d locald = pap;
      AppMethodBeat.o(179053);
      return locald;
    }
    finally {}
  }
  
  public final void ccf()
  {
    AppMethodBeat.i(179055);
    ac.i("MicroMsg.EmojiStoreExpt", "updateExpt: %s %s", new Object[] { this.par, this.paq });
    try
    {
      if (!bs.isNullOrNil(this.par)) {
        this.pas = bs.lr(h.tT(this.par).optString("second_strategy", "None"), "Paid");
      }
      if (!bs.isNullOrNil(this.paq))
      {
        JSONObject localJSONObject = h.tT(this.paq);
        this.pat = bs.lr(localJSONObject.optString("strategy", "Recommend"), "FriendDownloads");
        this.pau = localJSONObject.optString("tab_wording");
        this.pav = localJSONObject.optString("list_wording");
      }
      AppMethodBeat.o(179055);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.EmojiStoreExpt", localException, "", new Object[0]);
      this.pas = false;
      this.pat = false;
      AppMethodBeat.o(179055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import org.json.JSONObject;

public final class e
{
  private static e rbj;
  public String rbk;
  public String rbl;
  public boolean rbm;
  public boolean rbn;
  public String rbo;
  public String rbp;
  
  public e()
  {
    AppMethodBeat.i(179054);
    this.rbm = false;
    this.rbn = false;
    this.rbl = ((String)g.aAh().azQ().get(ar.a.Ohf, ""));
    this.rbk = ((String)g.aAh().azQ().get(ar.a.Ohg, ""));
    cFY();
    AppMethodBeat.o(179054);
  }
  
  public static e cFX()
  {
    try
    {
      AppMethodBeat.i(179053);
      if (rbj == null) {
        rbj = new e();
      }
      e locale = rbj;
      AppMethodBeat.o(179053);
      return locale;
    }
    finally {}
  }
  
  public final void cFY()
  {
    AppMethodBeat.i(179055);
    Log.i("MicroMsg.EmojiStoreExpt", "updateExpt: %s %s", new Object[] { this.rbl, this.rbk });
    try
    {
      if (!Util.isNullOrNil(this.rbl)) {
        this.rbm = Util.isEqual(h.FE(this.rbl).optString("second_strategy", "None"), "Paid");
      }
      if (!Util.isNullOrNil(this.rbk))
      {
        JSONObject localJSONObject = h.FE(this.rbk);
        this.rbn = Util.isEqual(localJSONObject.optString("strategy", "Recommend"), "FriendDownloads");
        this.rbo = localJSONObject.optString("tab_wording");
        this.rbp = localJSONObject.optString("list_wording");
      }
      AppMethodBeat.o(179055);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.EmojiStoreExpt", localException, "", new Object[0]);
      this.rbm = false;
      this.rbn = false;
      AppMethodBeat.o(179055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.e
 * JD-Core Version:    0.7.0.1
 */
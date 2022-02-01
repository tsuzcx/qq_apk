package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import org.json.JSONObject;

public final class j
{
  private static j uEn;
  public String uEo;
  public String uEp;
  public boolean uEq;
  public boolean uEr;
  public String uEs;
  public String uEt;
  
  public j()
  {
    AppMethodBeat.i(179054);
    this.uEq = false;
    this.uEr = false;
    this.uEp = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vvv, ""));
    this.uEo = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vvw, ""));
    cUH();
    AppMethodBeat.o(179054);
  }
  
  public static j cUG()
  {
    try
    {
      AppMethodBeat.i(179053);
      if (uEn == null) {
        uEn = new j();
      }
      j localj = uEn;
      AppMethodBeat.o(179053);
      return localj;
    }
    finally {}
  }
  
  public final void cUH()
  {
    AppMethodBeat.i(179055);
    Log.i("MicroMsg.EmojiStoreExpt", "updateExpt: %s %s", new Object[] { this.uEp, this.uEo });
    try
    {
      if (!Util.isNullOrNil(this.uEp)) {
        this.uEq = Util.isEqual(com.tencent.mm.ad.h.ME(this.uEp).optString("second_strategy", "None"), "Paid");
      }
      if (!Util.isNullOrNil(this.uEo))
      {
        JSONObject localJSONObject = com.tencent.mm.ad.h.ME(this.uEo);
        this.uEr = Util.isEqual(localJSONObject.optString("strategy", "Recommend"), "FriendDownloads");
        this.uEs = localJSONObject.optString("tab_wording");
        this.uEt = localJSONObject.optString("list_wording");
      }
      AppMethodBeat.o(179055);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.EmojiStoreExpt", localException, "", new Object[0]);
      this.uEq = false;
      this.uEr = false;
      AppMethodBeat.o(179055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.j
 * JD-Core Version:    0.7.0.1
 */
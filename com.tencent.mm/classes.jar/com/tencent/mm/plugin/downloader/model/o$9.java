package com.tencent.mm.plugin.downloader.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.pointers.PBool;
import org.json.JSONException;
import org.json.JSONObject;

final class o$9
  implements DialogInterface.OnClickListener
{
  o$9(PBool paramPBool, JSONObject paramJSONObject, a parama, o.a parama1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(141074);
    this.kZk.value = true;
    try
    {
      this.kZl.put("reserve_for_wifi", 0);
      label24:
      paramDialogInterface = this.kYh;
      this.kYh.field_downloadInWifi = false;
      paramDialogInterface.field_reserveInWifi = false;
      d.e(this.kYh);
      if (this.kYh.field_status == 0) {
        ((com.tencent.mm.plugin.downloader_app.a.d)g.E(com.tencent.mm.plugin.downloader_app.a.d.class)).lI(this.kYh.field_appId);
      }
      this.kZi.c(null, this.kZl);
      AppMethodBeat.o(141074);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      break label24;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.9
 * JD-Core Version:    0.7.0.1
 */
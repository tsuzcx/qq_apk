package com.tencent.mm.plugin.masssend.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.p;

final class a$3
  extends ak
{
  a$3(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(22756);
    int i = r.Zy();
    if (this.ldm) {
      i &= 0xFFFEFFFF;
    }
    for (;;)
    {
      aw.aaz();
      c.Ru().set(34, Integer.valueOf(i));
      aw.aaz();
      c.Yz().c(new k("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.ldm) {
        a.clearData();
      }
      if (this.oBt != null) {
        this.oBt.a(null, null);
      }
      AppMethodBeat.o(22756);
      return;
      i |= 0x10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.a.3
 * JD-Core Version:    0.7.0.1
 */
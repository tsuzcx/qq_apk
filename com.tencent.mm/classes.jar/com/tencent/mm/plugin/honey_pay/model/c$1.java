package com.tencent.mm.plugin.honey_pay.model;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.e.a;

final class c$1
  implements e.a
{
  c$1(boolean paramBoolean) {}
  
  public final Intent v(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(64647);
    if (this.JAK) {
      h.OAn.b(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    }
    for (;;)
    {
      paramBundle = new Intent();
      AppMethodBeat.o(64647);
      return paramBundle;
      h.OAn.b(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c.1
 * JD-Core Version:    0.7.0.1
 */
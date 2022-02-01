package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class au
  extends aw
{
  protected final void a(Context paramContext, Intent paramIntent, boolean paramBoolean) {}
  
  protected final boolean b(Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(44002);
    paramBoolean = super.b(paramIntent, paramBoolean);
    if (z(paramIntent) == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ad.i("MiroMsg.WxaManufacturerShortcutEntry", "invalid scene ");
      }
      if ((i != 0) || (!paramBoolean)) {
        break;
      }
      AppMethodBeat.o(44002);
      return true;
    }
    AppMethodBeat.o(44002);
    return false;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  protected final int z(Intent paramIntent)
  {
    AppMethodBeat.i(44001);
    int i = paramIntent.getIntExtra("SCENE", -1);
    if (i == 2)
    {
      AppMethodBeat.o(44001);
      return 1114;
    }
    if (i == 1)
    {
      AppMethodBeat.o(44001);
      return 1113;
    }
    AppMethodBeat.o(44001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.au
 * JD-Core Version:    0.7.0.1
 */
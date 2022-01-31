package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class aj
  extends al
{
  protected final int A(Intent paramIntent)
  {
    AppMethodBeat.i(129170);
    int i = paramIntent.getIntExtra("SCENE", -1);
    if (i == 2)
    {
      AppMethodBeat.o(129170);
      return 1114;
    }
    if (i == 1)
    {
      AppMethodBeat.o(129170);
      return 1113;
    }
    AppMethodBeat.o(129170);
    return -1;
  }
  
  protected final void a(Context paramContext, Intent paramIntent, boolean paramBoolean) {}
  
  protected final boolean b(Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(143052);
    paramBoolean = super.b(paramIntent, paramBoolean);
    if (A(paramIntent) == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ab.i("MiroMsg.WxaManufacturerShortcutEntry", "invalid scene ");
      }
      if ((i != 0) || (!paramBoolean)) {
        break;
      }
      AppMethodBeat.o(143052);
      return true;
    }
    AppMethodBeat.o(143052);
    return false;
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aj
 * JD-Core Version:    0.7.0.1
 */
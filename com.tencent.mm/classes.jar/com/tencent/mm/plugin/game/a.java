package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.e.c;
import com.tencent.mm.plugin.game.commlib.e.c.a;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;

public final class a
{
  public static final String HRS;
  public static final String HRT;
  
  static
  {
    AppMethodBeat.i(40810);
    HRS = WeChatPermissions.PERMISSION_MM_MESSAGE();
    HRT = c.c(c.a.Itm) + "message/";
    AppMethodBeat.o(40810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.a
 * JD-Core Version:    0.7.0.1
 */
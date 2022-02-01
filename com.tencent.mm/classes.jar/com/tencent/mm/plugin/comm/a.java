package com.tencent.mm.plugin.comm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.c;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/comm/MusicExptFlagLogic;", "", "()V", "QQ_MUSIC_APP_ID", "", "isFromQQMusicApp", "", "appId", "isOpenDowngradeH5Flag", "isOpenMvChatting", "newContextId", "plugin-comm_release"})
public final class a
{
  public static final a qCo;
  
  static
  {
    AppMethodBeat.i(223466);
    qCo = new a();
    AppMethodBeat.o(223466);
  }
  
  public static boolean akQ(String paramString)
  {
    AppMethodBeat.i(223463);
    boolean bool = p.j("wx5aa333606550dfd5", paramString);
    AppMethodBeat.o(223463);
    return bool;
  }
  
  public static boolean cAI()
  {
    AppMethodBeat.i(223462);
    b localb = (b)g.af(b.class);
    b.a locala = b.a.sfF;
    c localc = c.QYz;
    if (localb.a(locala, Util.getInt(c.axY(c.np("musicplayer", "openMvType")), 0)) == 1)
    {
      AppMethodBeat.o(223462);
      return true;
    }
    AppMethodBeat.o(223462);
    return false;
  }
  
  public static boolean cAJ()
  {
    AppMethodBeat.i(223464);
    b localb = (b)g.af(b.class);
    b.a locala = b.a.sfH;
    c localc = c.QYz;
    if (localb.a(locala, Util.getInt(c.axY(c.np("musicplayer", "openMvChatting")), 0)) == 1)
    {
      AppMethodBeat.o(223464);
      return true;
    }
    AppMethodBeat.o(223464);
    return false;
  }
  
  public static String cAK()
  {
    AppMethodBeat.i(223465);
    String str = UUID.randomUUID().toString();
    p.g(str, "UUID.randomUUID().toString()");
    AppMethodBeat.o(223465);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.a
 * JD-Core Version:    0.7.0.1
 */
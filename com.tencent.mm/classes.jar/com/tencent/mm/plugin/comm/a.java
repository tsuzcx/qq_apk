package com.tencent.mm.plugin.comm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/comm/MusicExptFlagLogic;", "", "()V", "KU_GOU_APP_ID", "", "KU_WO_APP_ID", "NetEase_Cloud_APP_ID", "QQ_MUSIC_APP_ID", "isEnableFlexMode", "", "isFromKuGouApp", "appId", "isFromKuWoApp", "isFromNetEaseCloud", "isFromQQMusicApp", "isMusicDowngradeH5", "isOpenDowngradeH5Flag", "isOpenMvChatting", "isUseNetworkDataPlay", "newContextId", "plugin-comm_release"})
public final class a
{
  public static final a ubo;
  
  static
  {
    AppMethodBeat.i(220979);
    ubo = new a();
    AppMethodBeat.o(220979);
  }
  
  public static boolean asG(String paramString)
  {
    AppMethodBeat.i(220958);
    boolean bool = p.h("wx5aa333606550dfd5", paramString);
    AppMethodBeat.o(220958);
    return bool;
  }
  
  public static boolean asH(String paramString)
  {
    AppMethodBeat.i(220961);
    boolean bool = p.h("wx8dd6ecd81906fd84", paramString);
    AppMethodBeat.o(220961);
    return bool;
  }
  
  public static boolean asI(String paramString)
  {
    AppMethodBeat.i(220963);
    boolean bool = p.h("wxc305711a2a7ad71c", paramString);
    AppMethodBeat.o(220963);
    return bool;
  }
  
  public static boolean asJ(String paramString)
  {
    AppMethodBeat.i(220968);
    boolean bool = p.h("wx79f2c4418704b4f8", paramString);
    AppMethodBeat.o(220968);
    return bool;
  }
  
  public static boolean cPi()
  {
    AppMethodBeat.i(220949);
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPt, com.tencent.mm.util.b.a.YxT, 0) == 1)
    {
      AppMethodBeat.o(220949);
      return true;
    }
    AppMethodBeat.o(220949);
    return false;
  }
  
  public static boolean cPj()
  {
    AppMethodBeat.i(220955);
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vNE, 0) == 1)
    {
      AppMethodBeat.o(220955);
      return true;
    }
    AppMethodBeat.o(220955);
    return false;
  }
  
  public static boolean cPk()
  {
    AppMethodBeat.i(220972);
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPu, com.tencent.mm.util.b.a.YxS, 0) == 1)
    {
      AppMethodBeat.o(220972);
      return true;
    }
    AppMethodBeat.o(220972);
    return false;
  }
  
  public static boolean cPl()
  {
    AppMethodBeat.i(220973);
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPw, com.tencent.mm.util.b.a.YxV, 0) == 1)
    {
      AppMethodBeat.o(220973);
      return true;
    }
    AppMethodBeat.o(220973);
    return false;
  }
  
  public static boolean cPm()
  {
    AppMethodBeat.i(220975);
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPx, com.tencent.mm.util.b.a.YxW, 0) == 1)
    {
      AppMethodBeat.o(220975);
      return true;
    }
    AppMethodBeat.o(220975);
    return false;
  }
  
  public static String cPn()
  {
    AppMethodBeat.i(220977);
    String str = UUID.randomUUID().toString();
    p.j(str, "UUID.randomUUID().toString()");
    AppMethodBeat.o(220977);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.a
 * JD-Core Version:    0.7.0.1
 */
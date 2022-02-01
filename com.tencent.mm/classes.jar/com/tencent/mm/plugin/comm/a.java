package com.tencent.mm.plugin.comm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.util.b.a;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/comm/MusicExptFlagLogic;", "", "()V", "KU_GOU_APP_ID", "", "KU_WO_APP_ID", "NetEase_Cloud_APP_ID", "QQ_MUSIC_APP_ID", "isEnableFlexMode", "", "isFromKuGouApp", "appId", "isFromKuWoApp", "isFromNetEaseCloud", "isFromQQMusicApp", "isInShieldAppIdList", "shieldAppIdStr", "isMusicDowngradeH5", "isOpenDowngradeH5Flag", "isOpenMvChatting", "isShieldAppId", "isUseNetworkDataPlay", "newContextId", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a xeG;
  
  static
  {
    AppMethodBeat.i(260542);
    xeG = new a();
    AppMethodBeat.o(260542);
  }
  
  public static boolean aml(String paramString)
  {
    AppMethodBeat.i(260512);
    boolean bool = s.p("wx5aa333606550dfd5", paramString);
    AppMethodBeat.o(260512);
    return bool;
  }
  
  public static boolean amm(String paramString)
  {
    AppMethodBeat.i(260515);
    boolean bool = s.p("wx8dd6ecd81906fd84", paramString);
    AppMethodBeat.o(260515);
    return bool;
  }
  
  public static boolean amn(String paramString)
  {
    AppMethodBeat.i(260518);
    boolean bool = s.p("wxc305711a2a7ad71c", paramString);
    AppMethodBeat.o(260518);
    return bool;
  }
  
  public static boolean amo(String paramString)
  {
    AppMethodBeat.i(260522);
    boolean bool = s.p("wx79f2c4418704b4f8", paramString);
    AppMethodBeat.o(260522);
    return bool;
  }
  
  public static boolean dsO()
  {
    AppMethodBeat.i(260507);
    if (((c)h.ax(c.class)).a(c.a.zhV, b.a.agqS, 0) == 1)
    {
      AppMethodBeat.o(260507);
      return true;
    }
    AppMethodBeat.o(260507);
    return false;
  }
  
  public static boolean dsP()
  {
    return true;
  }
  
  public static boolean dsQ()
  {
    AppMethodBeat.i(260527);
    if (((c)h.ax(c.class)).a(c.a.zhW, b.a.agqR, 0) == 1)
    {
      AppMethodBeat.o(260527);
      return true;
    }
    AppMethodBeat.o(260527);
    return false;
  }
  
  public static boolean dsR()
  {
    AppMethodBeat.i(260531);
    if (((c)h.ax(c.class)).a(c.a.zhY, b.a.agqU, 0) == 1)
    {
      AppMethodBeat.o(260531);
      return true;
    }
    AppMethodBeat.o(260531);
    return false;
  }
  
  public static boolean dsS()
  {
    AppMethodBeat.i(260535);
    if (((c)h.ax(c.class)).a(c.a.zhZ, b.a.agqV, 0) == 1)
    {
      AppMethodBeat.o(260535);
      return true;
    }
    AppMethodBeat.o(260535);
    return false;
  }
  
  public static String dsT()
  {
    AppMethodBeat.i(260539);
    String str = UUID.randomUUID().toString();
    s.s(str, "randomUUID().toString()");
    AppMethodBeat.o(260539);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.a
 * JD-Core Version:    0.7.0.1
 */
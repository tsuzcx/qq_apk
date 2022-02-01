package com.tencent.mm.plugin.game.luggage;

import android.os.Parcelable;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.xweb.ao;

public final class b
{
  public static <T extends d<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean b(InputType paramInputType, Class<T> paramClass, f<ResultType> paramf)
  {
    AppMethodBeat.i(82981);
    int i;
    if ((ao.bHC(WeChatHosts.domainString(j.f.host_game_weixin_qq_com))) && (!ToolsProcessIPCService.aYM()))
    {
      i = 1;
      if (i == 0) {
        break label70;
      }
    }
    label70:
    for (String str = ToolsMpProcessIPCService.PROCESS_NAME;; str = ToolsProcessIPCService.PROCESS_NAME)
    {
      boolean bool = j.a(str, paramInputType, paramClass, paramf);
      AppMethodBeat.o(82981);
      return bool;
      i = 0;
      break;
    }
  }
  
  public static boolean fEl()
  {
    AppMethodBeat.i(276945);
    if ((com.tencent.mm.plugin.game.commlib.e.b.aFM("com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI")) || (com.tencent.mm.plugin.game.commlib.e.b.aFM("com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI")) || (com.tencent.mm.plugin.game.commlib.e.b.aFM("com.tencent.mm.plugin.game.ui.chat_tab.ChatRoomTabUI")))
    {
      AppMethodBeat.o(276945);
      return true;
    }
    AppMethodBeat.o(276945);
    return false;
  }
  
  public static boolean fEm()
  {
    AppMethodBeat.i(276947);
    boolean bool = ((c)h.ax(c.class)).dbD();
    AppMethodBeat.o(276947);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b
 * JD-Core Version:    0.7.0.1
 */
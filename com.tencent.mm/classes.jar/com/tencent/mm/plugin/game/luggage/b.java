package com.tencent.mm.plugin.game.luggage;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.xweb.t;

public final class b
{
  public static <T extends com.tencent.mm.ipcinvoker.b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean b(InputType paramInputType, Class<T> paramClass, d<ResultType> paramd)
  {
    AppMethodBeat.i(82981);
    int i;
    if ((t.bsh(WeChatHosts.domainString(2131761707))) && (!ToolsProcessIPCService.ayt()))
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
    }
    label69:
    for (String str = ToolsMpProcessIPCService.dkO;; str = ToolsProcessIPCService.dkO)
    {
      boolean bool = h.a(str, paramInputType, paramClass, paramd);
      AppMethodBeat.o(82981);
      return bool;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b
 * JD-Core Version:    0.7.0.1
 */
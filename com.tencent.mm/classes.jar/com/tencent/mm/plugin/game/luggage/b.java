package com.tencent.mm.plugin.game.luggage;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.xweb.t;

public final class b
{
  public static <T extends com.tencent.mm.ipcinvoker.b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean b(InputType paramInputType, Class<T> paramClass, d<ResultType> paramd)
  {
    AppMethodBeat.i(82981);
    if (cXa()) {}
    for (String str = "com.tencent.mm:toolsmp";; str = "com.tencent.mm:tools")
    {
      boolean bool = h.a(str, paramInputType, paramClass, paramd);
      AppMethodBeat.o(82981);
      return bool;
    }
  }
  
  private static boolean cXa()
  {
    AppMethodBeat.i(82980);
    if ((t.baV("game.weixin.qq.com")) && (!ToolsProcessIPCService.ahO()))
    {
      AppMethodBeat.o(82980);
      return true;
    }
    AppMethodBeat.o(82980);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b
 * JD-Core Version:    0.7.0.1
 */
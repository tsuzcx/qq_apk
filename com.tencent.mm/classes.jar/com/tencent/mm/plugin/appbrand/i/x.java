package com.tencent.mm.plugin.appbrand.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class x
{
  private static int aGF()
  {
    AppMethodBeat.i(154700);
    Object localObject = a.b.eEW;
    localObject = a.me("100377");
    if (localObject == null)
    {
      ab.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item is null");
      AppMethodBeat.o(154700);
      return 0;
    }
    if (!((c)localObject).isValid())
    {
      ab.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item not valid");
      AppMethodBeat.o(154700);
      return 0;
    }
    int i = bo.getInt((String)((c)localObject).dvN().get("JsRuntime"), 0);
    ab.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(154700);
    return i;
  }
  
  private static int aGG()
  {
    AppMethodBeat.i(154701);
    Object localObject = a.b.eEW;
    localObject = a.me("100377");
    if ((localObject != null) && (((c)localObject).isValid())) {}
    for (int i = bo.getInt((String)((c)localObject).dvN().get("isolateContextLibVersion"), 2147483647);; i = 2147483647)
    {
      AppMethodBeat.o(154701);
      return i;
    }
  }
  
  public static boolean oC(int paramInt)
  {
    AppMethodBeat.i(154699);
    int i = aGG();
    if ((aGF() == 2) && ((paramInt >= i) || (paramInt == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.AppBrand.JsRuntimeABTests", "supportLibVer:%d currentLibVer:%d userNodeJS:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      AppMethodBeat.o(154699);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.x
 * JD-Core Version:    0.7.0.1
 */
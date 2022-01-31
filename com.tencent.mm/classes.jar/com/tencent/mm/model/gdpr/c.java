package com.tencent.mm.model.gdpr;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
{
  public static void a(Context paramContext, a parama, String paramString, b paramb)
  {
    AppMethodBeat.i(1494);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    if (abL())
    {
      if (bo.isNullOrNil(paramString))
      {
        paramb.kK(1);
        AppMethodBeat.o(1494);
        return;
      }
      g.dTg().h(new c.2(parama, paramString, paramb)).g(new c.1(paramb, localContext, parama, paramString));
      AppMethodBeat.o(1494);
      return;
    }
    paramb.kK(0);
    AppMethodBeat.o(1494);
  }
  
  public static boolean abL()
  {
    AppMethodBeat.i(1493);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.eER, a.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(1493);
      return true;
    }
    AppMethodBeat.o(1493);
    return false;
  }
  
  static final class a
    implements i<IPCVoid, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.c
 * JD-Core Version:    0.7.0.1
 */
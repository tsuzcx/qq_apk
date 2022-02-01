package com.tencent.mm.model.gdpr;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
{
  public static void a(Context paramContext, final a parama, final String paramString, b paramb)
  {
    AppMethodBeat.i(40088);
    final Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ak.getContext();
    }
    if (aDx())
    {
      if (bu.isNullOrNil(paramString))
      {
        paramb.oJ(1);
        AppMethodBeat.o(40088);
        return;
      }
      g.fWL().h(new c.2(parama, paramString, paramb)).g(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(40088);
      return;
    }
    paramb.oJ(0);
    AppMethodBeat.o(40088);
  }
  
  public static boolean aDx()
  {
    AppMethodBeat.i(40087);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, a.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(40087);
      return true;
    }
    AppMethodBeat.o(40087);
    return false;
  }
  
  static final class a
    implements k<IPCVoid, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.c
 * JD-Core Version:    0.7.0.1
 */
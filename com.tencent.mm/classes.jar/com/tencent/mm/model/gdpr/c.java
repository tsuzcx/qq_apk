package com.tencent.mm.model.gdpr;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  public static void a(Context paramContext, final a parama, final String paramString, final b paramb)
  {
    AppMethodBeat.i(40088);
    final Context localContext = paramContext;
    if (paramContext == null) {
      localContext = aj.getContext();
    }
    if (atn())
    {
      if (bt.isNullOrNil(paramString))
      {
        paramb.ns(1);
        AppMethodBeat.o(40088);
        return;
      }
      g.fkM().h(new com.tencent.mm.vending.c.a() {}).g(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(40088);
      return;
    }
    paramb.ns(0);
    AppMethodBeat.o(40088);
  }
  
  public static boolean atn()
  {
    AppMethodBeat.i(40087);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.fZS, a.class);
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
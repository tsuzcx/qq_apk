package com.tencent.mm.model.gdpr;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.fob;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static void a(Context paramContext, final a parama, final String paramString, final b paramb)
  {
    AppMethodBeat.i(40088);
    final Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    if (bgq())
    {
      if (Util.isNullOrNil(paramString))
      {
        paramb.vu(1);
        AppMethodBeat.o(40088);
        return;
      }
      g.ijP().h(new com.tencent.mm.vending.c.a() {}).g(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(40088);
      return;
    }
    paramb.vu(0);
    AppMethodBeat.o(40088);
  }
  
  public static boolean bgq()
  {
    AppMethodBeat.i(40087);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, a.class);
    if ((localIPCBoolean != null) && (localIPCBoolean.value))
    {
      AppMethodBeat.o(40087);
      return true;
    }
    AppMethodBeat.o(40087);
    return false;
  }
  
  static final class a
    implements m<IPCVoid, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.c
 * JD-Core Version:    0.7.0.1
 */
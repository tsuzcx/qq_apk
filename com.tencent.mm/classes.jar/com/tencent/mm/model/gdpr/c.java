package com.tencent.mm.model.gdpr;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.cp.g;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.ckl;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.gla;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class c
{
  public static void a(Context paramContext, final a parama, final String paramString, final b paramb)
  {
    AppMethodBeat.i(40088);
    final Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    if (bEh())
    {
      if (Util.isNullOrNil(paramString))
      {
        paramb.onPermissionReturn(1);
        AppMethodBeat.o(40088);
        return;
      }
      g.jPX().h(new com.tencent.mm.vending.c.a() {}).g(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(40088);
      return;
    }
    paramb.onPermissionReturn(0);
    AppMethodBeat.o(40088);
  }
  
  public static boolean bEh()
  {
    AppMethodBeat.i(40087);
    if (MMApplicationContext.isMainProcess())
    {
      new a((byte)0);
      localObject = IPCVoid.mzv;
      boolean bool = a.bEi().value;
      AppMethodBeat.o(40087);
      return bool;
    }
    Object localObject = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, a.class);
    if ((localObject != null) && (((IPCBoolean)localObject).value))
    {
      AppMethodBeat.o(40087);
      return true;
    }
    AppMethodBeat.o(40087);
    return false;
  }
  
  static final class a
    implements m<IPCVoid, IPCBoolean>
  {
    public static IPCBoolean bEi()
    {
      AppMethodBeat.i(242097);
      if ((h.baz()) && (com.tencent.mm.au.b.OE((String)h.baE().ban().d(274436, null)))) {}
      for (boolean bool = true;; bool = false)
      {
        IPCBoolean localIPCBoolean = new IPCBoolean(bool);
        AppMethodBeat.o(242097);
        return localIPCBoolean;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.c
 * JD-Core Version:    0.7.0.1
 */
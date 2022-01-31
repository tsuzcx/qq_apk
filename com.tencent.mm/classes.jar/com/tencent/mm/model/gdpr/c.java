package com.tencent.mm.model.gdpr;

import android.content.Context;
import com.tencent.mm.ck.f;
import com.tencent.mm.ck.g;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

public final class c
{
  public static boolean IO()
  {
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", IPCVoid.dHo, a.class);
    return (localIPCBoolean != null) && (localIPCBoolean.value);
  }
  
  public static void a(Context paramContext, a parama, String paramString, b paramb)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    if (IO())
    {
      if (bk.bl(paramString))
      {
        paramb.hX(1);
        return;
      }
      g.cNB().h(new c.2(parama, paramString, paramb)).g(new c.1(paramb, localContext, parama, paramString));
      return;
    }
    paramb.hX(0);
  }
  
  private static final class a
    implements i<IPCVoid, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.c
 * JD-Core Version:    0.7.0.1
 */
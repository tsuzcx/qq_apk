package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.k.b;
import com.tencent.mm.plugin.appbrand.u.d.d;
import com.tencent.mm.plugin.appbrand.u.d.d.a;
import com.tencent.mm.plugin.appbrand.u.e.h;
import com.tencent.mm.plugin.appbrand.u.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

final class s$1
  extends com.tencent.mm.plugin.appbrand.u.a.a
{
  private d hmq = null;
  
  s$1(s params, URI paramURI, com.tencent.mm.plugin.appbrand.u.b.a parama, Map paramMap, k.b paramb)
  {
    super(paramURI, parama, paramMap, 60000);
  }
  
  public final void AR(String paramString)
  {
    AppMethodBeat.i(101897);
    this.hms.hmo.CZ(paramString);
    ab.d("MicroMsg.RemoteDebugSocket", "onSocketMessage, message: %s", new Object[] { paramString });
    this.hmr.aze();
    AppMethodBeat.o(101897);
  }
  
  public final void P(int paramInt, String paramString)
  {
    AppMethodBeat.i(101898);
    ab.i("MicroMsg.RemoteDebugSocket", "onClose,reason: %s, errCode = %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if ((paramInt == -1) || (paramInt == -2) || (paramInt == -3))
    {
      if (!at.isConnected(ah.getContext()))
      {
        this.hmr.AM("network is down");
        paramInt = 1006;
      }
      for (;;)
      {
        this.hmr.N(paramInt, paramString);
        AppMethodBeat.o(101898);
        return;
        this.hmr.AM(paramString);
      }
    }
    this.hmr.N(paramInt, paramString);
    AppMethodBeat.o(101898);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(101901);
    if ((paramd.aOo() != d.a.iZF) && (!paramd.aOm()))
    {
      this.hmq = paramd;
      AppMethodBeat.o(101901);
      return;
    }
    if (paramd.aOo() == d.a.iZF)
    {
      if (this.hmq == null)
      {
        AppMethodBeat.o(101901);
        return;
      }
      if (this.hmq.aOl().position() > 10485760)
      {
        ab.e("MicroMsg.RemoteDebugSocket", "Pending Frame exploded");
        this.hmq = null;
        AppMethodBeat.o(101901);
        return;
      }
      try
      {
        this.hmq.e(paramd);
        if (!paramd.aOm())
        {
          AppMethodBeat.o(101901);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.RemoteDebugSocket", localException.getMessage());
        }
      }
      if (this.hmq.aOo() != d.a.iZH) {
        break label174;
      }
      i(this.hmq.aOl());
    }
    for (;;)
    {
      this.hmq = null;
      AppMethodBeat.o(101901);
      return;
      label174:
      if (this.hmq.aOo() == d.a.iZG) {
        try
        {
          AR(bo.nullAsNil(b.x(this.hmq.aOl())));
        }
        catch (Exception paramd)
        {
          ab.e("MicroMsg.RemoteDebugSocket", paramd.getMessage());
        }
      }
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(101896);
    ab.d("MicroMsg.RemoteDebugSocket", "onSocketOpen");
    this.hmr.azd();
    AppMethodBeat.o(101896);
  }
  
  public final void i(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(101900);
    this.hmr.h(paramByteBuffer);
    AppMethodBeat.o(101900);
  }
  
  public final void onError(Exception paramException)
  {
    AppMethodBeat.i(101899);
    ab.e("MicroMsg.RemoteDebugSocket", "onSocketError, ex: " + paramException.toString());
    AppMethodBeat.o(101899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s.1
 * JD-Core Version:    0.7.0.1
 */
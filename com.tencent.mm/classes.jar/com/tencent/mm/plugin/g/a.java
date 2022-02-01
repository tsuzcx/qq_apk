package com.tencent.mm.plugin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.an.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public final class a
  extends u
  implements com.tencent.mm.plugin.auth.a.a
{
  private static a oXn;
  
  private a()
  {
    super(f.class);
  }
  
  public static a cad()
  {
    try
    {
      AppMethodBeat.i(151474);
      if (oXn == null) {
        oXn = new a();
      }
      a locala = oXn;
      AppMethodBeat.o(151474);
      return locala;
    }
    finally {}
  }
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean) {}
  
  public final void a(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(151475);
    if (paramb.FGY.qkC != 0) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151473);
          f.a locala = new f.a();
          long l2 = -1L;
          f.aGW();
          long l1 = l2;
          if (f.aGY() != null)
          {
            l1 = l2;
            if (this.oXo != null)
            {
              f.aGW();
              f.aGY().a(this.oXo, this.oXp, this.oXq);
              l1 = locala.abs();
            }
          }
          ae.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", new Object[] { Long.valueOf(locala.abs()), Long.valueOf(l1) });
          AppMethodBeat.o(151473);
        }
      });
    }
    AppMethodBeat.o(151475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a
 * JD-Core Version:    0.7.0.1
 */
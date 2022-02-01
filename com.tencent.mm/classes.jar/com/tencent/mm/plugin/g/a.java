package com.tencent.mm.plugin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.d;
import com.tencent.mm.ao.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class a
  extends t
  implements com.tencent.mm.plugin.auth.a.a
{
  private static a nKq;
  
  private a()
  {
    super(f.class);
  }
  
  public static a bMY()
  {
    try
    {
      AppMethodBeat.i(151474);
      if (nKq == null) {
        nKq = new a();
      }
      a locala = nKq;
      AppMethodBeat.o(151474);
      return locala;
    }
    finally {}
  }
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean) {}
  
  public final void a(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(151475);
    if (paramb.Crb.oXh != 0) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151473);
          f.a locala = new f.a();
          long l2 = -1L;
          f.awI();
          long l1 = l2;
          if (f.awK() != null)
          {
            l1 = l2;
            if (this.nKr != null)
            {
              f.awI();
              f.awK().a(this.nKr, this.nKs, this.nKt);
              l1 = locala.XK();
            }
          }
          ad.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", new Object[] { Long.valueOf(locala.XK()), Long.valueOf(l1) });
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
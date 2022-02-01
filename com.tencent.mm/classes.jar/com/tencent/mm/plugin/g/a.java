package com.tencent.mm.plugin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.ao.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class a
  extends t
  implements com.tencent.mm.plugin.auth.a.a
{
  private static a oQL;
  
  private a()
  {
    super(f.class);
  }
  
  public static a bYO()
  {
    try
    {
      AppMethodBeat.i(151474);
      if (oQL == null) {
        oQL = new a();
      }
      a locala = oQL;
      AppMethodBeat.o(151474);
      return locala;
    }
    finally {}
  }
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean) {}
  
  public final void a(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(151475);
    if (paramb.FoA.qdX != 0) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151473);
          f.a locala = new f.a();
          long l2 = -1L;
          f.aGF();
          long l1 = l2;
          if (f.aGH() != null)
          {
            l1 = l2;
            if (this.oQM != null)
            {
              f.aGF();
              f.aGH().a(this.oQM, this.oQN, this.oQO);
              l1 = locala.abj();
            }
          }
          ad.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", new Object[] { Long.valueOf(locala.abj()), Long.valueOf(l1) });
          AppMethodBeat.o(151473);
        }
      });
    }
    AppMethodBeat.o(151475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a
 * JD-Core Version:    0.7.0.1
 */
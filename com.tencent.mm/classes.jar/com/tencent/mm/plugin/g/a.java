package com.tencent.mm.plugin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.an.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.protocal.protobuf.qg;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

public final class a
  extends t
  implements com.tencent.mm.plugin.auth.a.a
{
  private static a onq;
  
  private a()
  {
    super(f.class);
  }
  
  public static a bUj()
  {
    try
    {
      AppMethodBeat.i(151474);
      if (onq == null) {
        onq = new a();
      }
      a locala = onq;
      AppMethodBeat.o(151474);
      return locala;
    }
    finally {}
  }
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean) {}
  
  public final void a(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(151475);
    if (paramb.DJt.pAs != 0) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151473);
          f.a locala = new f.a();
          long l2 = -1L;
          f.aDA();
          long l1 = l2;
          if (f.aDC() != null)
          {
            l1 = l2;
            if (this.onr != null)
            {
              f.aDA();
              f.aDC().a(this.onr, this.ons, this.ont);
              l1 = locala.YH();
            }
          }
          ac.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", new Object[] { Long.valueOf(locala.YH()), Long.valueOf(l1) });
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
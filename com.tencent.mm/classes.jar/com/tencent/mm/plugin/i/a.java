package com.tencent.mm.plugin.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a
  extends y
  implements b
{
  private static a tKZ;
  
  private a()
  {
    super(com.tencent.mm.aq.f.class);
  }
  
  public static a cMn()
  {
    try
    {
      AppMethodBeat.i(151474);
      if (tKZ == null) {
        tKZ = new a();
      }
      a locala = tKZ;
      AppMethodBeat.o(151474);
      return locala;
    }
    finally {}
  }
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean) {}
  
  public final void a(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(151475);
    if (paramb.RBZ.vhf != 0) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151473);
          f.a locala = new f.a();
          long l2 = -1L;
          com.tencent.mm.aq.f.bkd();
          long l1 = l2;
          if (com.tencent.mm.aq.f.bkf() != null)
          {
            l1 = l2;
            if (this.tLa != null)
            {
              com.tencent.mm.aq.f.bkd();
              com.tencent.mm.aq.f.bkf().a(this.tLa, this.tLb, this.tLc);
              l1 = locala.avE();
            }
          }
          Log.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", new Object[] { Long.valueOf(locala.avE()), Long.valueOf(l1) });
          AppMethodBeat.o(151473);
        }
      });
    }
    AppMethodBeat.o(151475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a
 * JD-Core Version:    0.7.0.1
 */
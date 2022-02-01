package com.tencent.mm.plugin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a
  extends y
  implements b
{
  private static a qmi;
  
  private a()
  {
    super(com.tencent.mm.an.f.class);
  }
  
  public static a cxS()
  {
    try
    {
      AppMethodBeat.i(151474);
      if (qmi == null) {
        qmi = new a();
      }
      a locala = qmi;
      AppMethodBeat.o(151474);
      return locala;
    }
    finally {}
  }
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean) {}
  
  public final void a(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(151475);
    if (paramb.KAj.rBx != 0) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151473);
          f.a locala = new f.a();
          long l2 = -1L;
          com.tencent.mm.an.f.baN();
          long l1 = l2;
          if (com.tencent.mm.an.f.baP() != null)
          {
            l1 = l2;
            if (this.qmj != null)
            {
              com.tencent.mm.an.f.baN();
              com.tencent.mm.an.f.baP().a(this.qmj, this.qmk, this.qml);
              l1 = locala.apr();
            }
          }
          Log.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", new Object[] { Long.valueOf(locala.apr()), Long.valueOf(l1) });
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
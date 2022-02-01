package com.tencent.mm.plugin.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.e;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.y;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a
  extends y
  implements b
{
  private static a wOo;
  
  private a()
  {
    super(k.class);
  }
  
  public static a dpR()
  {
    try
    {
      AppMethodBeat.i(151474);
      if (wOo == null) {
        wOo = new a();
      }
      a locala = wOo;
      AppMethodBeat.o(151474);
      return locala;
    }
    finally {}
  }
  
  public final void onAuthResponse(j.h paramh, j.i parami, boolean paramBoolean) {}
  
  public final void onRegResponse(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(151475);
    if (paramb.YyC.yth != 0) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151473);
          f.a locala = new f.a();
          long l2 = -1L;
          k.bHT();
          long l1 = l2;
          if (k.bHV() != null)
          {
            l1 = l2;
            if (a.this != null)
            {
              k.bHT();
              k.bHV().a(a.this, this.wOq, this.wOr);
              l1 = locala.aPY();
            }
          }
          Log.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", new Object[] { Long.valueOf(locala.aPY()), Long.valueOf(l1) });
          AppMethodBeat.o(151473);
        }
      });
    }
    AppMethodBeat.o(151475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a
 * JD-Core Version:    0.7.0.1
 */
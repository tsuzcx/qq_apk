package com.tencent.mm.plugin.ext.d;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bn;

public class e
{
  public static e quE = null;
  public Context mContext = null;
  
  public static void W(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24502);
    h.wUl.f(14869, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24502);
  }
  
  public static void X(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24503);
    h.wUl.f(14868, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24503);
  }
  
  public static d.b aW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(24505);
    paramString = d.cmO().aV(paramString, paramBoolean);
    AppMethodBeat.o(24505);
    return paramString;
  }
  
  public static e cmP()
  {
    AppMethodBeat.i(24501);
    if (quE == null) {
      try
      {
        if (quE == null) {
          quE = new e();
        }
        e locale1 = quE;
        return locale1;
      }
      finally
      {
        AppMethodBeat.o(24501);
      }
    }
    e locale2 = quE;
    AppMethodBeat.o(24501);
    return locale2;
  }
  
  public static Cursor cmQ()
  {
    AppMethodBeat.i(24504);
    ac.i("MicroMsg.ExtQrCodeHandler", "hy: release temp mapping");
    c.clearCache();
    MatrixCursor localMatrixCursor = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
    AppMethodBeat.o(24504);
    return localMatrixCursor;
  }
  
  public static ao cmR()
  {
    AppMethodBeat.i(24507);
    ao localao = new ao(Looper.getMainLooper());
    AppMethodBeat.o(24507);
    return localao;
  }
  
  public final a a(final d.b paramb)
  {
    AppMethodBeat.i(24506);
    long l = System.currentTimeMillis();
    a locala = (a)new bn(new a(), paramb)
    {
      private e.a cmS()
      {
        AppMethodBeat.i(24495);
        try
        {
          ac.d("MicroMsg.ExtQrCodeHandler", "hy: start scan qrcode");
          if (paramb != null)
          {
            qy localqy = new qy();
            localqy.dtZ.width = paramb.aNa;
            localqy.dtZ.height = paramb.aNb;
            localqy.dtZ.dub = paramb.quD;
            localqy.dtZ.duc = paramb.duc;
            localqy.dtZ.dua = paramb.dua;
            localqy.dtZ.dud = new r() {};
            com.tencent.mm.sdk.b.a.GpY.l(localqy);
          }
          for (;;)
          {
            AppMethodBeat.o(24495);
            return null;
            ac.w("MicroMsg.ExtQrCodeHandler", "hy: qrcode data not retrieved");
            aE(null);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.ExtQrCodeHandler", localException, "hy: error when syncTaskScanQrCode", new Object[0]);
            aE(null);
          }
        }
      }
    }.b(cmR());
    if (locala != null) {}
    for (paramb = locala.toString();; paramb = "null")
    {
      ac.i("MicroMsg.ExtQrCodeHandler", "hy: resolved qrcode: %s, using: %d ms", new Object[] { paramb, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(24506);
      return locala;
    }
  }
  
  public static final class a
  {
    public int quJ;
    private boolean quK = false;
    public int type;
    public String url;
    
    public final String toString()
    {
      AppMethodBeat.i(24500);
      String str = "QrCodeModel{type=" + this.type + ", url='" + this.url + '\'' + ", flagTimeout=" + this.quK + '}';
      AppMethodBeat.o(24500);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.ext.d;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public class e
{
  public static e pLW = null;
  public Context mContext = null;
  
  public static void X(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24502);
    h.vKh.f(14869, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24502);
  }
  
  public static void Y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24503);
    h.vKh.f(14868, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24503);
  }
  
  public static d.b aV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(24505);
    paramString = d.cfh().aU(paramString, paramBoolean);
    AppMethodBeat.o(24505);
    return paramString;
  }
  
  public static e cfi()
  {
    AppMethodBeat.i(24501);
    if (pLW == null) {
      try
      {
        if (pLW == null) {
          pLW = new e();
        }
        e locale1 = pLW;
        return locale1;
      }
      finally
      {
        AppMethodBeat.o(24501);
      }
    }
    e locale2 = pLW;
    AppMethodBeat.o(24501);
    return locale2;
  }
  
  public static Cursor cfj()
  {
    AppMethodBeat.i(24504);
    ad.i("MicroMsg.ExtQrCodeHandler", "hy: release temp mapping");
    c.clearCache();
    MatrixCursor localMatrixCursor = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
    AppMethodBeat.o(24504);
    return localMatrixCursor;
  }
  
  public static ap cfk()
  {
    AppMethodBeat.i(24507);
    ap localap = new ap(Looper.getMainLooper());
    AppMethodBeat.o(24507);
    return localap;
  }
  
  public final a a(final d.b paramb)
  {
    AppMethodBeat.i(24506);
    long l = System.currentTimeMillis();
    a locala = (a)new bo(new a(), paramb)
    {
      private e.a cfl()
      {
        AppMethodBeat.i(24495);
        try
        {
          ad.d("MicroMsg.ExtQrCodeHandler", "hy: start scan qrcode");
          if (paramb != null)
          {
            qp localqp = new qp();
            localqp.dwm.width = paramb.aMk;
            localqp.dwm.height = paramb.aMl;
            localqp.dwm.dwo = paramb.pLV;
            localqp.dwm.dwp = paramb.dwp;
            localqp.dwm.dwn = paramb.dwn;
            localqp.dwm.dwq = new r() {};
            com.tencent.mm.sdk.b.a.ESL.l(localqp);
          }
          for (;;)
          {
            AppMethodBeat.o(24495);
            return null;
            ad.w("MicroMsg.ExtQrCodeHandler", "hy: qrcode data not retrieved");
            aH(null);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.ExtQrCodeHandler", localException, "hy: error when syncTaskScanQrCode", new Object[0]);
            aH(null);
          }
        }
      }
    }.b(cfk());
    if (locala != null) {}
    for (paramb = locala.toString();; paramb = "null")
    {
      ad.i("MicroMsg.ExtQrCodeHandler", "hy: resolved qrcode: %s, using: %d ms", new Object[] { paramb, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(24506);
      return locala;
    }
  }
  
  public static final class a
  {
    public int pMb;
    private boolean pMc = false;
    public int type;
    public String url;
    
    public final String toString()
    {
      AppMethodBeat.i(24500);
      String str = "QrCodeModel{type=" + this.type + ", url='" + this.url + '\'' + ", flagTimeout=" + this.pMc + '}';
      AppMethodBeat.o(24500);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.e
 * JD-Core Version:    0.7.0.1
 */
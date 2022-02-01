package com.tencent.mm.plugin.ext.d;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public class e
{
  public static e reu = null;
  public Context mContext = null;
  
  public static void Y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24502);
    com.tencent.mm.plugin.report.service.g.yhR.f(14869, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24502);
  }
  
  public static void Z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24503);
    com.tencent.mm.plugin.report.service.g.yhR.f(14868, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24503);
  }
  
  public static d.b aY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(24505);
    paramString = d.cst().aX(paramString, paramBoolean);
    AppMethodBeat.o(24505);
    return paramString;
  }
  
  public static e csu()
  {
    AppMethodBeat.i(24501);
    if (reu == null) {
      try
      {
        if (reu == null) {
          reu = new e();
        }
        e locale1 = reu;
        return locale1;
      }
      finally
      {
        AppMethodBeat.o(24501);
      }
    }
    e locale2 = reu;
    AppMethodBeat.o(24501);
    return locale2;
  }
  
  public static Cursor csv()
  {
    AppMethodBeat.i(24504);
    ad.i("MicroMsg.ExtQrCodeHandler", "hy: release temp mapping");
    c.clearCache();
    MatrixCursor localMatrixCursor = com.tencent.mm.pluginsdk.d.a.a.Yf(1);
    AppMethodBeat.o(24504);
    return localMatrixCursor;
  }
  
  public static ap csw()
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
      private e.a csx()
      {
        AppMethodBeat.i(24495);
        try
        {
          ad.d("MicroMsg.ExtQrCodeHandler", "hy: start scan qrcode");
          if (paramb != null)
          {
            rj localrj = new rj();
            localrj.dFZ.width = paramb.aXs;
            localrj.dFZ.height = paramb.aXt;
            localrj.dFZ.dGb = paramb.res;
            localrj.dFZ.dGc = paramb.dGc;
            localrj.dFZ.dGa = paramb.dGa;
            localrj.dFZ.dGd = new r() {};
            com.tencent.mm.sdk.b.a.IbL.l(localrj);
          }
          for (;;)
          {
            AppMethodBeat.o(24495);
            return null;
            ad.w("MicroMsg.ExtQrCodeHandler", "hy: qrcode data not retrieved");
            aG(null);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.ExtQrCodeHandler", localException, "hy: error when syncTaskScanQrCode", new Object[0]);
            aG(null);
          }
        }
      }
    }.b(csw());
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
    private boolean reA = false;
    public int rez;
    public int type;
    public String url;
    
    public final String toString()
    {
      AppMethodBeat.i(24500);
      String str = "QrCodeModel{type=" + this.type + ", url='" + this.url + '\'' + ", flagTimeout=" + this.reA + '}';
      AppMethodBeat.o(24500);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.e
 * JD-Core Version:    0.7.0.1
 */
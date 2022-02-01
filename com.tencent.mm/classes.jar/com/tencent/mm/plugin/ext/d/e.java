package com.tencent.mm.plugin.ext.d;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bp;

public class e
{
  public static e rmx = null;
  public Context mContext = null;
  
  public static void Y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24502);
    g.yxI.f(14869, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24502);
  }
  
  public static void Z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24503);
    g.yxI.f(14868, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24503);
  }
  
  public static d.b ba(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(24505);
    paramString = d.ctV().aZ(paramString, paramBoolean);
    AppMethodBeat.o(24505);
    return paramString;
  }
  
  public static e ctW()
  {
    AppMethodBeat.i(24501);
    if (rmx == null) {
      try
      {
        if (rmx == null) {
          rmx = new e();
        }
        e locale1 = rmx;
        return locale1;
      }
      finally
      {
        AppMethodBeat.o(24501);
      }
    }
    e locale2 = rmx;
    AppMethodBeat.o(24501);
    return locale2;
  }
  
  public static Cursor ctX()
  {
    AppMethodBeat.i(24504);
    ae.i("MicroMsg.ExtQrCodeHandler", "hy: release temp mapping");
    c.clearCache();
    MatrixCursor localMatrixCursor = com.tencent.mm.pluginsdk.d.a.a.YL(1);
    AppMethodBeat.o(24504);
    return localMatrixCursor;
  }
  
  public static aq ctY()
  {
    AppMethodBeat.i(24507);
    aq localaq = new aq(Looper.getMainLooper());
    AppMethodBeat.o(24507);
    return localaq;
  }
  
  public final e.a a(final d.b paramb)
  {
    AppMethodBeat.i(24506);
    long l = System.currentTimeMillis();
    e.a locala = (e.a)new bp(new e.a(), paramb)
    {
      private e.a ctZ()
      {
        AppMethodBeat.i(24495);
        try
        {
          ae.d("MicroMsg.ExtQrCodeHandler", "hy: start scan qrcode");
          if (paramb != null)
          {
            rk localrk = new rk();
            localrk.dHf.width = paramb.aXs;
            localrk.dHf.height = paramb.aXt;
            localrk.dHf.dHh = paramb.rmw;
            localrk.dHf.dHi = paramb.dHi;
            localrk.dHf.dHg = paramb.dHg;
            localrk.dHf.dHj = new r() {};
            com.tencent.mm.sdk.b.a.IvT.l(localrk);
          }
          for (;;)
          {
            AppMethodBeat.o(24495);
            return null;
            ae.w("MicroMsg.ExtQrCodeHandler", "hy: qrcode data not retrieved");
            aG(null);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.ExtQrCodeHandler", localException, "hy: error when syncTaskScanQrCode", new Object[0]);
            aG(null);
          }
        }
      }
    }.b(ctY());
    if (locala != null) {}
    for (paramb = locala.toString();; paramb = "null")
    {
      ae.i("MicroMsg.ExtQrCodeHandler", "hy: resolved qrcode: %s, using: %d ms", new Object[] { paramb, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(24506);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.e
 * JD-Core Version:    0.7.0.1
 */
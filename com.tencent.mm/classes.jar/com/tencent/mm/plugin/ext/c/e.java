package com.tencent.mm.plugin.ext.c;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class e
{
  public static e mfk = null;
  public Context mContext = null;
  
  public static d.b aN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20428);
    paramString = d.btN().aM(paramString, paramBoolean);
    AppMethodBeat.o(20428);
    return paramString;
  }
  
  public static void aa(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20425);
    h.qsU.e(14869, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(20425);
  }
  
  public static void ab(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20426);
    h.qsU.e(14868, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(20426);
  }
  
  public static e btO()
  {
    AppMethodBeat.i(20424);
    if (mfk == null) {
      try
      {
        if (mfk == null) {
          mfk = new e();
        }
        e locale1 = mfk;
        return locale1;
      }
      finally
      {
        AppMethodBeat.o(20424);
      }
    }
    e locale2 = mfk;
    AppMethodBeat.o(20424);
    return locale2;
  }
  
  public static Cursor btP()
  {
    AppMethodBeat.i(20427);
    ab.i("MicroMsg.ExtQrCodeHandler", "hy: release temp mapping");
    c.clearCache();
    MatrixCursor localMatrixCursor = a.Ls(1);
    AppMethodBeat.o(20427);
    return localMatrixCursor;
  }
  
  public static ak btQ()
  {
    AppMethodBeat.i(20430);
    ak localak = new ak(Looper.getMainLooper());
    AppMethodBeat.o(20430);
    return localak;
  }
  
  public final e.a a(d.b paramb)
  {
    AppMethodBeat.i(20429);
    long l = System.currentTimeMillis();
    e.a locala = (e.a)new e.1(this, new e.a(), paramb).b(btQ());
    if (locala != null) {}
    for (paramb = locala.toString();; paramb = "null")
    {
      ab.i("MicroMsg.ExtQrCodeHandler", "hy: resolved qrcode: %s, using: %d ms", new Object[] { paramb, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(20429);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.e
 * JD-Core Version:    0.7.0.1
 */
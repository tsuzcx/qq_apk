package com.tencent.mm.plugin.appbrand.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MagicARJNIHelper
{
  public static final String TAG = "MagicARJNIHelper";
  
  public static int getARImplType()
  {
    AppMethodBeat.i(321211);
    int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zkR, 0);
    AppMethodBeat.o(321211);
    return i;
  }
  
  public static boolean hasCameraPermission()
  {
    AppMethodBeat.i(321206);
    boolean bool = b.g(MMApplicationContext.getContext(), new String[] { "android.permission.CAMERA" });
    AppMethodBeat.o(321206);
    return bool;
  }
  
  public static void reportIDKey(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(321213);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(paramInt1, paramInt2, paramInt3, paramBoolean);
    AppMethodBeat.o(321213);
  }
  
  public static void reportKV(int paramInt, String paramString)
  {
    AppMethodBeat.i(321217);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(paramInt, paramString);
    AppMethodBeat.o(321217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ar.MagicARJNIHelper
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expansions;

import android.text.TextUtils;
import com.google.android.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.Log;

final class f$1
  implements b
{
  final String yFM;
  final String yFN;
  
  f$1()
  {
    AppMethodBeat.i(273676);
    this.yFM = a.class.getName().replaceAll("\\.", "/");
    this.yFN = Delivery.class.getName().replaceAll("\\.", "/");
    AppMethodBeat.o(273676);
  }
  
  private boolean hc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(273681);
    if ((this.yFM.equals(paramString2)) || ("com/google/android/play/core/splitinstall/SplitInstallHelper".equals(paramString2)))
    {
      AppMethodBeat.o(273681);
      return true;
    }
    if ((this.yFN.equals(paramString2)) || ("com/tencent/mm/plugin/expansions/Delivery".equals(paramString2)))
    {
      AppMethodBeat.o(273681);
      return true;
    }
    boolean bool = "loadLibraryFlattWithinDelivery".equals(paramString1);
    AppMethodBeat.o(273681);
    return bool;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(273689);
    if (hc(paramString2, paramString1))
    {
      AppMethodBeat.o(273689);
      return;
    }
    Log.i("MicroMsg.exp.asm", "on System.loadLibrary invoke done, caller method = " + paramString2 + ", caller class = " + paramString1 + ", caller obj = " + paramObject1);
    AppMethodBeat.o(273689);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(273686);
    if (hc(paramString2, paramString1))
    {
      AppMethodBeat.o(273686);
      return;
    }
    paramString4 = null;
    paramString3 = paramString4;
    if (paramArrayOfObject != null)
    {
      paramString3 = paramString4;
      if (paramArrayOfObject.length > 0)
      {
        paramString3 = paramString4;
        if ((paramArrayOfObject[0] instanceof String)) {
          paramString3 = (String)paramArrayOfObject[0];
        }
      }
    }
    Log.i("MicroMsg.exp.asm", "on System.loadLibrary invoke, caller method = " + paramString2 + ", caller class = " + paramString1 + ", caller obj = " + paramObject + ", libName = " + paramString3);
    boolean bool;
    if (TextUtils.isEmpty(paramString3)) {
      bool = false;
    }
    for (;;)
    {
      if (bool)
      {
        Log.i("MicroMsg.exp.asm", "try loadLibrary with Delivery");
        Delivery.tryLoadLibrary(paramString3, false);
      }
      AppMethodBeat.o(273686);
      return;
      if (!Delivery.isInstalled()) {
        bool = false;
      } else {
        bool = h.aQg();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.f.1
 * JD-Core Version:    0.7.0.1
 */
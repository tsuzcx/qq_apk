package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.BitSet;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualityFlagsReport;", "", "()V", "reportFlags", "", "instanceId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  private static final BitSet nKm;
  public static final a nKn;
  
  static
  {
    AppMethodBeat.i(229312);
    nKn = new a((byte)0);
    BitSet localBitSet = new BitSet();
    nKm = localBitSet;
    localBitSet.set(0, com.tencent.mm.plugin.appbrand.ui.p.bXv());
    nKm.set(1, com.tencent.mm.plugin.appbrand.ui.p.bXu());
    AppMethodBeat.o(229312);
  }
  
  public static void aeT(String paramString)
  {
    AppMethodBeat.i(229311);
    kotlin.g.b.p.h(paramString, "instanceId");
    mf localmf = new mf();
    localmf.zu(a.getFlags());
    localmf.zt(paramString);
    Log.d("MicroMsg.AppBrandQualityFlagsReport", "reportFlags: instanceId=" + paramString + ",flags=" + localmf.getFlags());
    localmf.bfK();
    AppMethodBeat.o(229311);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualityFlagsReport$Companion;", "", "()V", "TAG", "", "flags", "Ljava/util/BitSet;", "getFlags", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static String getFlags()
    {
      AppMethodBeat.i(229310);
      org.apache.commons.b.c.a locala = new org.apache.commons.b.c.a();
      byte[] arrayOfByte = a.bUY().toByteArray();
      kotlin.g.b.p.g(arrayOfByte, "flags.toByteArray()");
      int k = arrayOfByte.length;
      int i = 0;
      if (i < k)
      {
        str = String.valueOf(arrayOfByte[i]);
        if (((CharSequence)str).length() == 0) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            str = "0";
          }
          locala.bvo(str);
          i += 1;
          break;
        }
      }
      if (locala.isEmpty())
      {
        AppMethodBeat.o(229310);
        return "0";
      }
      String str = locala.toString();
      kotlin.g.b.p.g(str, "sb.toString()");
      AppMethodBeat.o(229310);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a
 * JD-Core Version:    0.7.0.1
 */
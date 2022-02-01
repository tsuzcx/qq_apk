package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.sw;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.BitSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualityFlagsReport;", "", "()V", "reportFlags", "", "instanceId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a tRi;
  private static final BitSet tRj;
  
  static
  {
    AppMethodBeat.i(321453);
    tRi = new a((byte)0);
    BitSet localBitSet = new BitSet();
    tRj = localBitSet;
    localBitSet.set(0, r.cLs());
    tRj.set(1, r.cLr());
    AppMethodBeat.o(321453);
  }
  
  public static void afY(String paramString)
  {
    AppMethodBeat.i(321440);
    s.u(paramString, "instanceId");
    sw localsw = new sw();
    localsw.ilJ = localsw.F("flags", a.getFlags(), true);
    localsw.jzx = localsw.F("instanceId", paramString, true);
    Log.d("MicroMsg.AppBrandQualityFlagsReport", "reportFlags: instanceId=" + paramString + ",flags=" + localsw.ilJ);
    localsw.bMH();
    AppMethodBeat.o(321440);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualityFlagsReport$Companion;", "", "()V", "TAG", "", "flags", "Ljava/util/BitSet;", "getFlags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String getFlags()
    {
      AppMethodBeat.i(321462);
      org.apache.commons.c.c.a locala = new org.apache.commons.c.c.a();
      byte[] arrayOfByte = a.cJa().toByteArray();
      s.s(arrayOfByte, "flags.toByteArray()");
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
          locala.bLo(str);
          i += 1;
          break;
        }
      }
      if (locala.isEmpty())
      {
        AppMethodBeat.o(321462);
        return "0";
      }
      String str = locala.toString();
      s.s(str, "sb.toString()");
      AppMethodBeat.o(321462);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a
 * JD-Core Version:    0.7.0.1
 */
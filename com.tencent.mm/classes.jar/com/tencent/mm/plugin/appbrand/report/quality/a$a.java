package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.BitSet;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualityFlagsReport$Companion;", "", "()V", "TAG", "", "flags", "Ljava/util/BitSet;", "getFlags", "plugin-appbrand-integration_release"})
public final class a$a
{
  public static String getFlags()
  {
    AppMethodBeat.i(249897);
    org.apache.commons.b.c.a locala = new org.apache.commons.b.c.a();
    byte[] arrayOfByte = a.cij().toByteArray();
    p.j(arrayOfByte, "flags.toByteArray()");
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
        locala.bIt(str);
        i += 1;
        break;
      }
    }
    if (locala.isEmpty())
    {
      AppMethodBeat.o(249897);
      return "0";
    }
    String str = locala.toString();
    p.j(str, "sb.toString()");
    AppMethodBeat.o(249897);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a.a
 * JD-Core Version:    0.7.0.1
 */
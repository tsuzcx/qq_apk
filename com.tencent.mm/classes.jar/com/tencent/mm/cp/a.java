package com.tencent.mm.cp;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  private static String[] LBc = { "BND-AL00", "BND-AL10", "BND-TL10", "NOVA 2S", "HWI-AL00", "HWI-TL00", "LLD-AL00", "LLD-AL10", "LLD-TL10", "MATE 9", "MHA-AL00", "MHA-TL00", "MATE 9 PRO", "LON-AL00", "PRA-AL00", "PRA-AL00X", "PRA-TL10", "STF-AL00", "STF-AL10", "STF-TL10", "P10", "VTR-AL00", "VTR-TL00", "P10 PLUS", "VKY-AL00", "VKY-TL00", "MATE10", "ALP-AL00", "ALP-TL00", "MATE10PRO", "BLA-AL00", "BLA-TL00", "P20", "EML-AL00", "EML-TL00", "P20PRO", "CLT-AL00", "CLT-AL01", "CLT-TL00", "MATE RS", "NEO-AL00", "COR-AL00", "COR-AL10", "COR-TL10", "NOVA3", "PAR-AL00", "PAR-TL00", "NOVA3I", "INE-AL00", "INE-TL00", "NOVA 3E", "ANE-AL00", "ANE-TL00", "COL-AL10", "COL-TL10" };
  
  public static boolean kG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152884);
    int i = ((b)g.ab(b.class)).a(b.a.qqF, 0);
    if (i == 1)
    {
      ad.i("MicroMsg.BigImageFilter", "alvinluo BigImageFilter clicfg notFilter: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(152884);
      return false;
    }
    if (((paramInt1 >= 5700) && (paramInt2 >= 8000)) || ((paramInt1 >= 8000) && (paramInt2 >= 5700))) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(152884);
      return false;
    }
    String str = Build.MODEL;
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(152884);
      return false;
    }
    String[] arrayOfString = LBc;
    int j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      if (str.equalsIgnoreCase(arrayOfString[i]))
      {
        ad.i("MicroMsg.BigImageFilter", "alvinluo BigImageFilter filter model: %s, width: %d, height: %d", new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(152884);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(152884);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cp.a
 * JD-Core Version:    0.7.0.1
 */
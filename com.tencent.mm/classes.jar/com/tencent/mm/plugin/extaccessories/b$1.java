package com.tencent.mm.plugin.extaccessories;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(20463);
    if (!aw.RG())
    {
      AppMethodBeat.o(20463);
      return;
    }
    if (bo.isNullOrNil(this.mfR.eHR))
    {
      AppMethodBeat.o(20463);
      return;
    }
    long l = System.currentTimeMillis();
    bo.q(this.mfR.eHR + "image/spen/", "spen_", 259200000L);
    ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(20463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.b.1
 * JD-Core Version:    0.7.0.1
 */
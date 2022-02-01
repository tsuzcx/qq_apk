package com.tencent.mm.plugin.appbrand.ui.collection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"TAG", "", "OPEN_TEST_ENTRY", "", "plugin-appbrand-integration_release"})
public final class a
{
  static final boolean bpj()
  {
    AppMethodBeat.i(175226);
    if ((h.DEBUG) || (h.IS_FLAVOR_RED) || (bu.eGT()))
    {
      AppMethodBeat.o(175226);
      return true;
    }
    AppMethodBeat.o(175226);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.a
 * JD-Core Version:    0.7.0.1
 */
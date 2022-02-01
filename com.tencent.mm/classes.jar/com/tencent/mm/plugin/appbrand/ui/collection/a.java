package com.tencent.mm.plugin.appbrand.ui.collection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"TAG", "", "OPEN_TEST_ENTRY", "", "plugin-appbrand-integration_release"})
public final class a
{
  static final boolean bBf()
  {
    AppMethodBeat.i(175226);
    if ((j.DEBUG) || (j.IS_FLAVOR_RED) || (bv.fpT()))
    {
      AppMethodBeat.o(175226);
      return true;
    }
    AppMethodBeat.o(175226);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.a
 * JD-Core Version:    0.7.0.1
 */
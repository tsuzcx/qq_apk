package com.tencent.mm.plugin.appbrand.ui.collection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"TAG", "", "OPEN_TEST_ENTRY", "", "plugin-appbrand-integration_release"})
public final class a
{
  static final boolean bAk()
  {
    AppMethodBeat.i(175226);
    if ((i.DEBUG) || (i.IS_FLAVOR_RED) || (bu.flY()))
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
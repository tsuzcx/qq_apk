package com.tencent.mm.plugin.appbrand.appstorage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"notExists", "", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-appbrand-integration_release"})
public final class c
{
  public static final boolean x(e parame)
  {
    AppMethodBeat.i(175123);
    k.h(parame, "$this$notExists");
    if (!parame.exists())
    {
      AppMethodBeat.o(175123);
      return true;
    }
    AppMethodBeat.o(175123);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;

final class PluginFTS$8$1
  extends a
{
  String mQn = "";
  
  PluginFTS$8$1(PluginFTS.8 param8) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(136589);
    this.mQn = aa.gP(ah.getContext());
    PluginFTS.access$100(this.mQo.mQm).M(-3L, this.mQn.hashCode());
    AppMethodBeat.o(136589);
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(136590);
    String str = "LanguageUpdate(\"" + this.mQn + "\")";
    AppMethodBeat.o(136590);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.8.1
 * JD-Core Version:    0.7.0.1
 */
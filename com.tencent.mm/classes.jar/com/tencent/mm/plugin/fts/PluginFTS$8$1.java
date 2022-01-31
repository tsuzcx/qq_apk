package com.tencent.mm.plugin.fts;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;

final class PluginFTS$8$1
  extends a
{
  String kuz = "";
  
  PluginFTS$8$1(PluginFTS.8 param8) {}
  
  public final boolean execute()
  {
    this.kuz = x.fB(ae.getContext());
    PluginFTS.access$200(this.kuA.kuy).A(-3L, this.kuz.hashCode());
    return true;
  }
  
  public final String toString()
  {
    return "LanguageUpdate(\"" + this.kuz + "\")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.8.1
 * JD-Core Version:    0.7.0.1
 */
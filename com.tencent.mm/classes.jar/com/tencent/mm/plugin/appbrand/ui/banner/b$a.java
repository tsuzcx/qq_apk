package com.tencent.mm.plugin.appbrand.ui.banner;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum b$a
{
  static final int iQN;
  
  static
  {
    AppMethodBeat.i(133268);
    iQI = new a("appId", 0);
    iQJ = new a("versionType", 1);
    iQK = new a("appName", 2);
    iQL = new a("iconURL", 3);
    iQM = new a("customText", 4);
    iQO = new a[] { iQI, iQJ, iQK, iQL, iQM };
    iQN = values().length;
    AppMethodBeat.o(133268);
  }
  
  private b$a() {}
  
  public final String tX()
  {
    AppMethodBeat.i(133267);
    String str = "appbrand_top_banner_in_chatting_extra_key_" + name();
    AppMethodBeat.o(133267);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.b.a
 * JD-Core Version:    0.7.0.1
 */
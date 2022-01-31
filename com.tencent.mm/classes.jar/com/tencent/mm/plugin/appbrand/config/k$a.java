package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$a
{
  final int intValue;
  
  static
  {
    AppMethodBeat.i(129849);
    hjf = new a("DEFAULT", 0, 100);
    hjg = new a("RECENTS_LIST", 1, 101);
    hjh = new a("TASK_BAR", 2, 102);
    hji = new a("STAR_LIST", 3, 103);
    hjj = new a("MP_PRELOAD", 4, 104);
    hjk = new a("BIZ_BIND_WXA", 5, 105);
    hjl = new a("WXA_CUSTOMER_SERVICE", 6, 106);
    hjm = new a("WXA_PLUGIN_JSAPI", 7, 107);
    hjn = new a("WXA_RECOMMEND_LIST", 8, 108);
    hjo = new a("WXA_RECOMMEND_CARD_LIST", 9, 109);
    hjp = new a[] { hjf, hjg, hjh, hji, hjj, hjk, hjl, hjm, hjn, hjo };
    AppMethodBeat.o(129849);
  }
  
  private k$a(int paramInt)
  {
    this.intValue = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.k.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.plugin.appbrand.i.o;
import com.tencent.mm.plugin.appbrand.i.p;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.xweb.g;

public enum a
{
  private a() {}
  
  public static a a(com.tencent.mm.plugin.appbrand.i.f paramf)
  {
    if ((paramf instanceof com.tencent.mm.plugin.appbrand.game.f)) {
      return gXw;
    }
    if ((paramf instanceof com.tencent.mm.plugin.appbrand.i.a)) {
      return gXw;
    }
    if ((paramf instanceof p)) {
      return gXx;
    }
    if ((paramf instanceof o)) {
      paramf = g.cSh();
    }
    switch (a.1.gXB[paramf.ordinal()])
    {
    default: 
      if (d.DEBUG) {
        throw new IllegalStateException();
      }
      break;
    case 1: 
      return gXv;
    case 2: 
      return gXx;
    case 3: 
      return gXw;
    case 4: 
      return gXw;
    case 5: 
      return gXw;
    case 6: 
      return gXv;
    case 7: 
      return gXy;
    }
    return gXz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a
 * JD-Core Version:    0.7.0.1
 */
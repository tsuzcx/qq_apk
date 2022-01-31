package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mm.ah.h.a;
import com.tencent.mm.ah.h.b;
import com.tencent.mm.h.a.fi;
import com.tencent.mm.sdk.b.a;

final class b
  implements com.tencent.mm.plugin.appbrand.compat.a.b
{
  public final void a(String paramString, h.a parama, h.b paramb)
  {
    fi localfi = new fi();
    localfi.bMc.op = 1;
    localfi.bMc.fileName = paramString;
    localfi.bMc.bMe = true;
    localfi.bMc.bBp = true;
    localfi.bMc.bMf = parama;
    localfi.bMc.bMg = paramb;
    a.udP.m(localfi);
  }
  
  public final void pause()
  {
    fi localfi = new fi();
    localfi.bMc.op = 4;
    a.udP.m(localfi);
  }
  
  public final void stop()
  {
    fi localfi = new fi();
    localfi.bMc.op = 2;
    a.udP.m(localfi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.compat.b
 * JD-Core Version:    0.7.0.1
 */
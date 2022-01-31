package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;

public final class a
  extends com.tencent.mm.plugin.appbrand.c
{
  private final com.tencent.mm.plugin.appbrand.o iBh;
  private final h iBi;
  private final com.tencent.mm.plugin.appbrand.jsapi.p.a iBj;
  
  public a(com.tencent.mm.plugin.appbrand.o paramo, h paramh)
  {
    super(paramo, paramh, paramo.wO());
    AppMethodBeat.i(132501);
    this.iBj = new com.tencent.mm.plugin.appbrand.jsapi.p.a();
    this.iBh = paramo;
    this.iBi = paramh;
    AppMethodBeat.o(132501);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(132503);
    super.G(paramInt, paramString);
    this.iBj.X(paramInt, paramString);
    AppMethodBeat.o(132503);
  }
  
  public final void a(m paramm, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(132504);
    super.a(paramm, paramString1, paramInt, paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      if (((f.IS_FLAVOR_RED) || (d.whL) || (d.whK)) && ("fail:internal error invalid js component".equals(paramString2)))
      {
        paramm = new ClassCastException(String.format("Mismatch api(%s) component", new Object[] { paramm.getName() }));
        AppMethodBeat.o(132504);
        throw paramm;
      }
      this.iBj.X(paramInt, paramString2);
    }
    AppMethodBeat.o(132504);
  }
  
  public final boolean a(m paramm, String paramString, int paramInt, c.a parama)
  {
    AppMethodBeat.i(132502);
    com.tencent.mm.plugin.appbrand.jsapi.p.a locala = this.iBj;
    Object localObject2 = this.iBi;
    ??? = this.iBh.atT();
    if ((??? == null) || (((r)???).getCurrentPage() == null)) {
      ??? = "";
    }
    for (;;)
    {
      if (!i.EI(paramm.getName())) {
        localObject2 = new com.tencent.mm.plugin.appbrand.jsapi.p.c((h)localObject2, paramm, paramString, bo.yB(), (String)???);
      }
      synchronized (locala.hXR)
      {
        locala.hXR.put(paramInt, localObject2);
        boolean bool = super.a(paramm, paramString, paramInt, parama);
        AppMethodBeat.o(132502);
        return bool;
        ??? = ((r)???).getCurrentPage().getCurrentUrl();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a
 * JD-Core Version:    0.7.0.1
 */
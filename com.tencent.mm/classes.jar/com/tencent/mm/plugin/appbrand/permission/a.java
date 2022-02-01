package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.s.a.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.y;

public final class a
  extends com.tencent.mm.plugin.appbrand.c
{
  private final o lid;
  private final com.tencent.mm.plugin.appbrand.jsapi.h lie;
  private final com.tencent.mm.plugin.appbrand.jsapi.s.a lif;
  
  public a(o paramo, com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    super(paramo, paramh, paramo.cif);
    this.lid = paramo;
    this.lie = paramh;
    this.lif = paramo.iGb;
  }
  
  private String blc()
  {
    AppMethodBeat.i(47987);
    if (this.lid.CZ()) {
      try
      {
        String str = bt.nullAsNil(this.lid.aNc().iJb);
        AppMethodBeat.o(47987);
        return str;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(47987);
        return "";
      }
    }
    Object localObject = this.lid.aNd();
    if (localObject == null)
    {
      AppMethodBeat.o(47987);
      return null;
    }
    localObject = ((t)localObject).getCurrentUrl();
    AppMethodBeat.o(47987);
    return localObject;
  }
  
  public final void P(int paramInt, String paramString)
  {
    AppMethodBeat.i(47989);
    super.P(paramInt, paramString);
    this.lif.ai(paramInt, paramString);
    AppMethodBeat.o(47989);
  }
  
  public final void a(m paramm, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(47990);
    super.a(paramm, paramString1, paramInt, paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      if (((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (d.CpO) || (d.CpN)) && ("fail:internal error invalid js component".equals(paramString2)))
      {
        paramm = new ClassCastException(String.format("Mismatch api(%s) component", new Object[] { paramm.getName() }));
        AppMethodBeat.o(47990);
        throw paramm;
      }
      this.lif.ai(paramInt, paramString2);
    }
    AppMethodBeat.o(47990);
  }
  
  public final boolean a(m paramm, String paramString, int paramInt, c.a parama)
  {
    AppMethodBeat.i(47988);
    ??? = this.lif;
    com.tencent.mm.plugin.appbrand.jsapi.h localh = this.lie;
    String str = blc();
    k.h(localh, "component");
    k.h(paramm, "api");
    Object localObject1;
    if (!i.Mz(paramm.getName()))
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)???).khX.bbK();
      long l = bt.GC();
      ((com.tencent.mm.plugin.appbrand.jsapi.s.b)localObject1).khZ = localh;
      ((com.tencent.mm.plugin.appbrand.jsapi.s.b)localObject1).kia = paramm;
      ((com.tencent.mm.plugin.appbrand.jsapi.s.b)localObject1).data = paramString;
      ((com.tencent.mm.plugin.appbrand.jsapi.s.b)localObject1).startTime = l;
      ((com.tencent.mm.plugin.appbrand.jsapi.s.b)localObject1).path = str;
    }
    synchronized (((com.tencent.mm.plugin.appbrand.jsapi.s.a)???).khW)
    {
      ((SparseArray)???).put(paramInt, localObject1);
      localObject1 = y.JfV;
      boolean bool = super.a(paramm, paramString, paramInt, parama);
      AppMethodBeat.o(47988);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a
 * JD-Core Version:    0.7.0.1
 */
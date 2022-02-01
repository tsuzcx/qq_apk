package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u.a.a;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import d.z;

public final class a
  extends c
{
  private final h lnB;
  private final com.tencent.mm.plugin.appbrand.p mmF;
  private final com.tencent.mm.plugin.appbrand.jsapi.u.a mmG;
  
  public a(com.tencent.mm.plugin.appbrand.p paramp, h paramh)
  {
    super(paramp, paramh, paramp.cpU);
    this.mmF = paramp;
    this.lnB = paramh;
    this.mmG = paramp.jCk;
  }
  
  private String bwM()
  {
    AppMethodBeat.i(47987);
    if (this.mmF.Ee()) {
      try
      {
        String str = bu.nullAsNil(this.mmF.aXx().jFL);
        AppMethodBeat.o(47987);
        return str;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(47987);
        return "";
      }
    }
    Object localObject = this.mmF.aXy();
    if (localObject == null)
    {
      AppMethodBeat.o(47987);
      return null;
    }
    localObject = ((t)localObject).getCurrentUrl();
    AppMethodBeat.o(47987);
    return localObject;
  }
  
  public final void S(int paramInt, String paramString)
  {
    AppMethodBeat.i(47989);
    super.S(paramInt, paramString);
    this.mmG.al(paramInt, paramString);
    AppMethodBeat.o(47989);
  }
  
  public final void a(m paramm, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(47990);
    super.a(paramm, paramString1, paramInt, paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      if (((j.IS_FLAVOR_RED) || (com.tencent.mm.protocal.d.FFL) || (com.tencent.mm.protocal.d.FFK)) && ("fail:internal error invalid js component".equals(paramString2)))
      {
        paramm = new ClassCastException(String.format("Mismatch api(%s) component", new Object[] { paramm.getName() }));
        AppMethodBeat.o(47990);
        throw paramm;
      }
      this.mmG.al(paramInt, paramString2);
    }
    AppMethodBeat.o(47990);
  }
  
  public final boolean a(m paramm, String paramString, int paramInt, c.a parama)
  {
    AppMethodBeat.i(47988);
    ??? = this.mmG;
    h localh = this.lnB;
    String str = bwM();
    d.g.b.p.h(localh, "component");
    d.g.b.p.h(paramm, "api");
    Object localObject1;
    if (!i.UZ(paramm.getName()))
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)???).lju.bna();
      long l = bu.HQ();
      ((com.tencent.mm.plugin.appbrand.jsapi.u.b)localObject1).ljw = localh;
      ((com.tencent.mm.plugin.appbrand.jsapi.u.b)localObject1).ljx = paramm;
      ((com.tencent.mm.plugin.appbrand.jsapi.u.b)localObject1).data = paramString;
      ((com.tencent.mm.plugin.appbrand.jsapi.u.b)localObject1).startTime = l;
      ((com.tencent.mm.plugin.appbrand.jsapi.u.b)localObject1).path = str;
    }
    synchronized (((com.tencent.mm.plugin.appbrand.jsapi.u.a)???).ljt)
    {
      ((SparseArray)???).put(paramInt, localObject1);
      localObject1 = z.Nhr;
      boolean bool = super.a(paramm, paramString, paramInt, parama);
      AppMethodBeat.o(47988);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u.a.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.z;

public final class a
  extends com.tencent.mm.plugin.appbrand.c
{
  private final o mhG;
  private final h mhH;
  private final com.tencent.mm.plugin.appbrand.jsapi.u.a mhI;
  
  public a(o paramo, h paramh)
  {
    super(paramo, paramh, paramo.cpr);
    this.mhG = paramo;
    this.mhH = paramh;
    this.mhI = paramo.jzj;
  }
  
  private String bvV()
  {
    AppMethodBeat.i(47987);
    if (this.mhG.Eb()) {
      try
      {
        String str = bt.nullAsNil(this.mhG.aXc().jCN);
        AppMethodBeat.o(47987);
        return str;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(47987);
        return "";
      }
    }
    Object localObject = this.mhG.aXd();
    if (localObject == null)
    {
      AppMethodBeat.o(47987);
      return null;
    }
    localObject = ((u)localObject).getCurrentUrl();
    AppMethodBeat.o(47987);
    return localObject;
  }
  
  public final void S(int paramInt, String paramString)
  {
    AppMethodBeat.i(47989);
    super.S(paramInt, paramString);
    this.mhI.al(paramInt, paramString);
    AppMethodBeat.o(47989);
  }
  
  public final void a(m paramm, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(47990);
    super.a(paramm, paramString1, paramInt, paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      if (((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (d.Fnn) || (d.Fnm)) && ("fail:internal error invalid js component".equals(paramString2)))
      {
        paramm = new ClassCastException(String.format("Mismatch api(%s) component", new Object[] { paramm.getName() }));
        AppMethodBeat.o(47990);
        throw paramm;
      }
      this.mhI.al(paramInt, paramString2);
    }
    AppMethodBeat.o(47990);
  }
  
  public final boolean a(m paramm, String paramString, int paramInt, c.a parama)
  {
    AppMethodBeat.i(47988);
    ??? = this.mhI;
    h localh = this.mhH;
    String str = bvV();
    p.h(localh, "component");
    p.h(paramm, "api");
    Object localObject1;
    if (!com.tencent.mm.plugin.appbrand.report.model.i.Uo(paramm.getName()))
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)???).lfI.bmr();
      long l = bt.HI();
      ((com.tencent.mm.plugin.appbrand.jsapi.u.b)localObject1).lfK = localh;
      ((com.tencent.mm.plugin.appbrand.jsapi.u.b)localObject1).lfL = paramm;
      ((com.tencent.mm.plugin.appbrand.jsapi.u.b)localObject1).data = paramString;
      ((com.tencent.mm.plugin.appbrand.jsapi.u.b)localObject1).startTime = l;
      ((com.tencent.mm.plugin.appbrand.jsapi.u.b)localObject1).path = str;
    }
    synchronized (((com.tencent.mm.plugin.appbrand.jsapi.u.a)???).lfH)
    {
      ((SparseArray)???).put(paramInt, localObject1);
      localObject1 = z.MKo;
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
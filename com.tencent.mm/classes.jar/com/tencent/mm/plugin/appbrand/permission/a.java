package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.w.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.b;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.x;

public final class a
  extends c
{
  private final k mui;
  private final q nxf;
  private final com.tencent.mm.plugin.appbrand.jsapi.w.a nxg;
  
  public a(q paramq, k paramk)
  {
    super(paramq, paramk, paramq.cCn);
    this.nxf = paramq;
    this.mui = paramk;
    this.nxg = paramq.kDh;
  }
  
  private String bSV()
  {
    AppMethodBeat.i(47987);
    if (this.nxf.NA()) {
      try
      {
        String str = Util.nullAsNil(this.nxf.bsC().kHw);
        AppMethodBeat.o(47987);
        return str;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(47987);
        return "";
      }
    }
    Object localObject = this.nxf.bsD();
    if (localObject == null)
    {
      AppMethodBeat.o(47987);
      return null;
    }
    localObject = ((w)localObject).getCurrentUrl();
    AppMethodBeat.o(47987);
    return localObject;
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(47989);
    super.V(paramInt, paramString);
    this.nxg.ao(paramInt, paramString);
    AppMethodBeat.o(47989);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.p paramp, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(47990);
    super.a(paramp, paramString1, paramInt, paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      if (((BuildInfo.IS_FLAVOR_RED) || (com.tencent.mm.protocal.d.KyS) || (com.tencent.mm.protocal.d.KyR)) && ("fail:internal error invalid js component".equals(paramString2)))
      {
        paramp = new ClassCastException(String.format("Mismatch api(%s) component", new Object[] { paramp.getName() }));
        AppMethodBeat.o(47990);
        throw paramp;
      }
      this.nxg.ao(paramInt, paramString2);
    }
    AppMethodBeat.o(47990);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.p paramp, String paramString, int paramInt, f.a parama)
  {
    AppMethodBeat.i(47988);
    ??? = this.nxg;
    k localk = this.mui;
    String str = bSV();
    kotlin.g.b.p.h(localk, "component");
    kotlin.g.b.p.h(paramp, "api");
    Object localObject1;
    if (!i.aeO(paramp.getName()))
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.w.a)???).moZ.bIz();
      long l = Util.currentTicks();
      ((b)localObject1).mpb = localk;
      ((b)localObject1).mpc = paramp;
      ((b)localObject1).data = paramString;
      ((b)localObject1).startTime = l;
      ((b)localObject1).path = str;
    }
    synchronized (((com.tencent.mm.plugin.appbrand.jsapi.w.a)???).moY)
    {
      ((SparseArray)???).put(paramInt, localObject1);
      localObject1 = x.SXb;
      if (s.a(this.mui, paramp, parama))
      {
        AppMethodBeat.o(47988);
        return true;
      }
    }
    boolean bool = super.a(paramp, paramString, paramInt, parama);
    AppMethodBeat.o(47988);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a
 * JD-Core Version:    0.7.0.1
 */
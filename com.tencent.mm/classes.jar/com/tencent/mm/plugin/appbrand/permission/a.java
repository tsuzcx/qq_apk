package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.x.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.x.b;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;

public final class a
  extends f
{
  private final j psu;
  private final t qzh;
  private final com.tencent.mm.plugin.appbrand.jsapi.x.a qzi;
  
  public a(t paramt, j paramj)
  {
    super(paramt, paramj, paramt.cCQ);
    this.qzh = paramt;
    this.psu = paramj;
    this.qzi = paramt.nws;
  }
  
  private String cfY()
  {
    AppMethodBeat.i(47987);
    if (this.qzh.Qv()) {
      try
      {
        String str = Util.nullAsNil(this.qzh.bDy().nBq);
        AppMethodBeat.o(47987);
        return str;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(47987);
        return "";
      }
    }
    Object localObject = this.qzh.bDz();
    if (localObject == null)
    {
      AppMethodBeat.o(47987);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.page.x)localObject).getCurrentUrl();
    AppMethodBeat.o(47987);
    return localObject;
  }
  
  public final void X(int paramInt, String paramString)
  {
    AppMethodBeat.i(47989);
    super.X(paramInt, paramString);
    this.qzi.aq(paramInt, paramString);
    AppMethodBeat.o(47989);
  }
  
  public final void a(o paramo, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(47990);
    super.a(paramo, paramString1, paramInt, paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      if (((BuildInfo.IS_FLAVOR_RED) || (com.tencent.mm.protocal.d.RAH) || (com.tencent.mm.protocal.d.RAG)) && ("fail:internal error invalid js component".equals(paramString2)))
      {
        paramo = new ClassCastException(String.format("Mismatch api(%s) component", new Object[] { paramo.getName() }));
        AppMethodBeat.o(47990);
        throw paramo;
      }
      this.qzi.aq(paramInt, paramString2);
    }
    AppMethodBeat.o(47990);
  }
  
  public final boolean a(o paramo, String paramString, int paramInt, e.b paramb)
  {
    AppMethodBeat.i(47988);
    ??? = this.qzi;
    j localj = this.psu;
    String str = cfY();
    p.k(localj, "component");
    p.k(paramo, "api");
    Object localObject1;
    if (!i.amJ(paramo.getName()))
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.x.a)???).pne.bUg();
      long l = Util.currentTicks();
      ((b)localObject1).png = localj;
      ((b)localObject1).pnh = paramo;
      ((b)localObject1).data = paramString;
      ((b)localObject1).startTime = l;
      ((b)localObject1).path = str;
    }
    synchronized (((com.tencent.mm.plugin.appbrand.jsapi.x.a)???).pnd)
    {
      ((SparseArray)???).put(paramInt, localObject1);
      localObject1 = kotlin.x.aazN;
      if (s.a(this.psu, paramo, paramb))
      {
        AppMethodBeat.o(47988);
        return true;
      }
    }
    boolean bool = super.a(paramo, paramString, paramInt, paramb);
    AppMethodBeat.o(47988);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a
 * JD-Core Version:    0.7.0.1
 */
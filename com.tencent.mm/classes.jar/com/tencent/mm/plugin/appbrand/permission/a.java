package com.tencent.mm.plugin.appbrand.permission;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.jsapi.aa.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.aa.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.ah;
import kotlin.g.b.s;

public final class a
  extends f
{
  private final com.tencent.mm.plugin.appbrand.jsapi.k sxG;
  private final w tEc;
  private final com.tencent.mm.plugin.appbrand.jsapi.aa.a tEd;
  private final SparseIntArray tEe;
  
  public a(w paramw, com.tencent.mm.plugin.appbrand.jsapi.k paramk)
  {
    super(paramw, paramk, paramw.evw);
    AppMethodBeat.i(318744);
    this.tEe = new SparseIntArray();
    this.tEc = paramw;
    this.sxG = paramk;
    this.tEd = paramw.qvx;
    AppMethodBeat.o(318744);
  }
  
  private String cGK()
  {
    AppMethodBeat.i(47987);
    if (this.tEc.aqJ()) {
      try
      {
        String str = Util.nullAsNil(this.tEc.getInitConfig().qAF);
        AppMethodBeat.o(47987);
        return str;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(47987);
        return "";
      }
    }
    Object localObject = this.tEc.ccN();
    if (localObject == null)
    {
      AppMethodBeat.o(47987);
      return null;
    }
    localObject = ((x)localObject).getCurrentUrl();
    AppMethodBeat.o(47987);
    return localObject;
  }
  
  public final void a(p arg1, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(318768);
    Object localObject1 = (b)com.tencent.mm.plugin.appbrand.jsapi.aa.a.b(this.tEd.srT, paramInt1);
    if (localObject1 != null) {
      ((b)localObject1).srY = paramInt2;
    }
    if (4 == paramInt2)
    {
      localObject1 = com.tencent.mm.plugin.wxpayreport.e.XIO;
      if (com.tencent.mm.plugin.wxpayreport.e.boG(???.getName())) {
        synchronized (this.tEe)
        {
          this.tEe.delete(paramInt1);
          AppMethodBeat.o(318768);
          return;
        }
      }
    }
    AppMethodBeat.o(318768);
  }
  
  public final void a(p paramp, String arg2, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(318774);
    super.a(paramp, ???, paramString2, paramInt, paramString3);
    synchronized (this.tEe)
    {
      this.tEe.delete(paramInt);
      if (TextUtils.isEmpty(paramString3)) {
        break label128;
      }
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (com.tencent.mm.protocal.d.Yxl) || (com.tencent.mm.protocal.d.Yxk)) && ("fail:internal error invalid js component".equals(paramString3)))
      {
        paramp = new ClassCastException(String.format("Mismatch api(%s) component", new Object[] { paramp.getName() }));
        AppMethodBeat.o(318774);
        throw paramp;
      }
    }
    this.tEd.aA(paramInt, paramString3);
    label128:
    AppMethodBeat.o(318774);
  }
  
  public final boolean a(p paramp, String paramString1, String paramString2, int paramInt, f.b paramb)
  {
    AppMethodBeat.i(318764);
    ??? = this.tEd;
    com.tencent.mm.plugin.appbrand.jsapi.k localk = this.sxG;
    String str = cGK();
    s.u(localk, "component");
    s.u(paramp, "api");
    Object localObject1;
    if (!com.tencent.mm.plugin.appbrand.report.model.k.afU(paramp.getName()))
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.aa.a)???).srU.cut();
      long l = Util.currentTicks();
      ((b)localObject1).srW = localk;
      ((b)localObject1).srX = paramp;
      ((b)localObject1).data = paramString1;
      ((b)localObject1).startTime = l;
      ((b)localObject1).path = str;
      ((b)localObject1).srY = 0;
    }
    synchronized (((com.tencent.mm.plugin.appbrand.jsapi.aa.a)???).srT)
    {
      ((SparseArray)???).put(paramInt, localObject1);
      localObject1 = ah.aiuX;
      if (v.a(this.sxG, paramp, paramb))
      {
        AppMethodBeat.o(318764);
        return true;
      }
    }
    boolean bool = super.a(paramp, paramString1, paramString2, paramInt, paramb);
    AppMethodBeat.o(318764);
    return bool;
  }
  
  public final void af(int paramInt, String paramString)
  {
    AppMethodBeat.i(47989);
    super.af(paramInt, paramString);
    this.tEd.aA(paramInt, paramString);
    AppMethodBeat.o(47989);
  }
  
  public final boolean da(String arg1, int paramInt)
  {
    AppMethodBeat.i(318779);
    com.tencent.mm.plugin.wxpayreport.e locale = com.tencent.mm.plugin.wxpayreport.e.XIO;
    if (com.tencent.mm.plugin.wxpayreport.e.boF(???)) {
      synchronized (this.tEe)
      {
        this.tEe.put(paramInt, 1);
        AppMethodBeat.o(318779);
        return true;
      }
    }
    AppMethodBeat.o(318779);
    return false;
  }
  
  public final void db(String paramString, int paramInt)
  {
    AppMethodBeat.i(318785);
    this.sxG.getAsyncHandler().post(new a..ExternalSyntheticLambda0(this, paramInt, paramString));
    AppMethodBeat.o(318785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a
 * JD-Core Version:    0.7.0.1
 */
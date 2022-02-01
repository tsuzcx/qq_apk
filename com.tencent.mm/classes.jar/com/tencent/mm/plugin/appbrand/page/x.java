package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.o.b;
import com.tencent.mm.plugin.appbrand.jsapi.o.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.d;
import com.tencent.mm.plugin.appbrand.jsapi.o.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.j;
import com.tencent.mm.plugin.appbrand.jsapi.o.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class x
{
  final aa cdz;
  public final String cjP;
  public j.a kzM;
  boolean lax;
  public final LinkedList<String> lay;
  public final Map<String, a> laz;
  
  public x(aa paramaa)
  {
    AppMethodBeat.i(176621);
    this.cjP = ("MicroMsg.AppBrand.AppBrandPageScopedPipInfo#" + hashCode());
    this.kzM = null;
    this.lay = new LinkedList();
    this.laz = new ConcurrentHashMap();
    this.cdz = paramaa;
    this.lax = this.cdz.cdK;
    ad.i(this.cjP, "mIsCurPageForeground: " + this.lax);
    paramaa.a(new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(176617);
        x localx = x.this;
        ad.i(localx.cjP, "markCurPageForeground");
        localx.lax = true;
        AppMethodBeat.o(176617);
      }
    });
    paramaa.a(new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(176618);
        x localx = x.this;
        ad.i(localx.cjP, "markCurPageBackground");
        localx.lax = false;
        AppMethodBeat.o(176618);
      }
    });
    AppMethodBeat.o(176621);
  }
  
  final void LC(String paramString)
  {
    AppMethodBeat.i(176622);
    ad.i(this.cjP, "removePipRelatedKey, key: ".concat(String.valueOf(paramString)));
    synchronized (this.lay)
    {
      this.lay.remove(paramString);
      AppMethodBeat.o(176622);
      return;
    }
  }
  
  final String bjx()
  {
    AppMethodBeat.i(176623);
    synchronized (this.lay)
    {
      if (this.lay.isEmpty())
      {
        AppMethodBeat.o(176623);
        return null;
      }
      String str = (String)this.lay.getFirst();
      AppMethodBeat.o(176623);
      return str;
    }
  }
  
  final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(176624);
    synchronized (this.lay)
    {
      boolean bool = this.lay.contains(paramString);
      AppMethodBeat.o(176624);
      return bool;
    }
  }
  
  public static final class a
  {
    public final int id;
    public b.a laB;
    public boolean laC;
    public final i.a laD;
    public final d laE;
    public final h laF;
    public final j laG;
    public ag laH;
    
    public a(int paramInt, b paramb, h paramh, i.a parama, d paramd, ag paramag, j.a parama1)
    {
      AppMethodBeat.i(176619);
      this.laB = b.a.kgX;
      this.laC = false;
      this.id = paramInt;
      this.laF = paramh;
      this.laD = parama;
      this.laE = paramd;
      this.laH = paramag;
      a(paramb);
      this.laG = paramh.bbF();
      this.laG.a(parama1);
      AppMethodBeat.o(176619);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(176620);
      b.a locala = paramb.EG();
      if (locala != null) {
        this.laB = locala;
      }
      paramb = paramb.EH();
      if (paramb != null) {
        this.laC = paramb.booleanValue();
      }
      AppMethodBeat.o(176620);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.x
 * JD-Core Version:    0.7.0.1
 */
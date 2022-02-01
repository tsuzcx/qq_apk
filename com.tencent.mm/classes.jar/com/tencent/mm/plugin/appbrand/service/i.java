package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.h.a;
import com.tencent.mm.plugin.appbrand.openmaterial.j;
import com.tencent.mm.plugin.appbrand.openmaterial.k;
import com.tencent.mm.plugin.appbrand.openmaterial.l;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.ui.widget.a.e;

public abstract interface i
  extends a
{
  public abstract com.tencent.mm.plugin.appbrand.openmaterial.i a(b paramb, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection);
  
  public abstract com.tencent.mm.plugin.appbrand.openmaterial.i a(b paramb, MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection);
  
  public abstract j a(b paramb, Context paramContext, e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, h paramh, l paraml);
  
  public abstract AppBrandOpenMaterialCollection a(MaterialModel paramMaterialModel);
  
  public abstract void a(MaterialModel paramMaterialModel, k paramk);
  
  public abstract boolean a(MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection);
  
  public abstract boolean a(b paramb, MaterialModel paramMaterialModel, com.tencent.mm.plugin.appbrand.openmaterial.i parami);
  
  public abstract boolean a(e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection);
  
  public abstract boolean alg(String paramString);
  
  public abstract AppBrandOpenMaterialCollection b(MaterialModel paramMaterialModel);
  
  public abstract boolean c(b paramb);
  
  public abstract h.a ccL();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.i
 * JD-Core Version:    0.7.0.1
 */
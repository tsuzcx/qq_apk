package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.openmaterial.g;
import com.tencent.mm.plugin.appbrand.openmaterial.g.a;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.i;
import com.tencent.mm.plugin.appbrand.openmaterial.k;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.ui.widget.a.f;

public abstract interface j
  extends a
{
  public abstract h a(b paramb, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection);
  
  public abstract h a(b paramb, MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, boolean paramBoolean);
  
  public abstract i a(b paramb, Context paramContext, f paramf, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, g paramg, k paramk);
  
  public abstract AppBrandOpenMaterialCollection a(MaterialModel paramMaterialModel);
  
  public abstract void a(MaterialModel paramMaterialModel, com.tencent.mm.plugin.appbrand.openmaterial.j paramj);
  
  public abstract boolean a(MaterialModel paramMaterialModel, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection);
  
  public abstract boolean a(b paramb, MaterialModel paramMaterialModel, h paramh);
  
  public abstract boolean a(f paramf, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection);
  
  public abstract boolean aen(String paramString);
  
  public abstract AppBrandOpenMaterialCollection b(MaterialModel paramMaterialModel);
  
  public abstract boolean c(b paramb);
  
  public abstract g.a cDh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.j
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzrq
  extends zzf<zzrq>
{
  private ProductAction zzabO;
  private final Map<String, List<Product>> zzabP = new HashMap();
  private final List<Promotion> zzabQ = new ArrayList();
  private final List<Product> zzabR = new ArrayList();
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    if (!this.zzabR.isEmpty()) {
      localHashMap.put("products", this.zzabR);
    }
    if (!this.zzabQ.isEmpty()) {
      localHashMap.put("promotions", this.zzabQ);
    }
    if (!this.zzabP.isEmpty()) {
      localHashMap.put("impressions", this.zzabP);
    }
    localHashMap.put("productAction", this.zzabO);
    return zzj(localHashMap);
  }
  
  public final void zza(Product paramProduct, String paramString)
  {
    if (paramProduct == null) {
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (!this.zzabP.containsKey(str)) {
      this.zzabP.put(str, new ArrayList());
    }
    ((List)this.zzabP.get(str)).add(paramProduct);
  }
  
  public final void zza(zzrq paramzzrq)
  {
    paramzzrq.zzabR.addAll(this.zzabR);
    paramzzrq.zzabQ.addAll(this.zzabQ);
    Iterator localIterator = this.zzabP.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramzzrq.zza((Product)((Iterator)localObject).next(), str);
      }
    }
    if (this.zzabO != null) {
      paramzzrq.zzabO = this.zzabO;
    }
  }
  
  public final ProductAction zznp()
  {
    return this.zzabO;
  }
  
  public final List<Product> zznq()
  {
    return Collections.unmodifiableList(this.zzabR);
  }
  
  public final Map<String, List<Product>> zznr()
  {
    return this.zzabP;
  }
  
  public final List<Promotion> zzns()
  {
    return Collections.unmodifiableList(this.zzabQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzrq
 * JD-Core Version:    0.7.0.1
 */
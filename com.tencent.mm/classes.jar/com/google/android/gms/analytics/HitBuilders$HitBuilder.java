package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HitBuilders$HitBuilder<T extends HitBuilder>
{
  private Map<String, String> zzabN = new HashMap();
  ProductAction zzabO;
  Map<String, List<Product>> zzabP = new HashMap();
  List<Promotion> zzabQ = new ArrayList();
  List<Product> zzabR = new ArrayList();
  
  private T zzo(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null) {
        this.zzabN.put(paramString1, paramString2);
      }
      return this;
    }
    zztc.zzbh("HitBuilder.setIfNonNull() called with a null paramName.");
    return this;
  }
  
  public T addImpression(Product paramProduct, String paramString)
  {
    if (paramProduct == null)
    {
      zztc.zzbh("product should be non-null");
      return this;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (!this.zzabP.containsKey(str)) {
      this.zzabP.put(str, new ArrayList());
    }
    ((List)this.zzabP.get(str)).add(paramProduct);
    return this;
  }
  
  public T addProduct(Product paramProduct)
  {
    if (paramProduct == null)
    {
      zztc.zzbh("product should be non-null");
      return this;
    }
    this.zzabR.add(paramProduct);
    return this;
  }
  
  public T addPromotion(Promotion paramPromotion)
  {
    if (paramPromotion == null)
    {
      zztc.zzbh("promotion should be non-null");
      return this;
    }
    this.zzabQ.add(paramPromotion);
    return this;
  }
  
  public Map<String, String> build()
  {
    HashMap localHashMap = new HashMap(this.zzabN);
    if (this.zzabO != null) {
      localHashMap.putAll(this.zzabO.build());
    }
    Object localObject = this.zzabQ.iterator();
    int i = 1;
    while (((Iterator)localObject).hasNext())
    {
      localHashMap.putAll(((Promotion)((Iterator)localObject).next()).zzbM(zzc.zzat(i)));
      i += 1;
    }
    localObject = this.zzabR.iterator();
    i = 1;
    while (((Iterator)localObject).hasNext())
    {
      localHashMap.putAll(((Product)((Iterator)localObject).next()).zzbM(zzc.zzar(i)));
      i += 1;
    }
    Iterator localIterator1 = this.zzabP.entrySet().iterator();
    i = 1;
    if (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      localObject = (List)localEntry.getValue();
      String str1 = zzc.zzaw(i);
      Iterator localIterator2 = ((List)localObject).iterator();
      int j = 1;
      if (localIterator2.hasNext())
      {
        Product localProduct = (Product)localIterator2.next();
        localObject = String.valueOf(str1);
        String str2 = String.valueOf(zzc.zzav(j));
        if (str2.length() != 0) {}
        for (localObject = ((String)localObject).concat(str2);; localObject = new String((String)localObject))
        {
          localHashMap.putAll(localProduct.zzbM((String)localObject));
          j += 1;
          break;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localEntry.getKey()))
      {
        localObject = String.valueOf(str1);
        str1 = String.valueOf("nm");
        if (str1.length() == 0) {
          break label357;
        }
      }
      label357:
      for (localObject = ((String)localObject).concat(str1);; localObject = new String((String)localObject))
      {
        localHashMap.put(localObject, (String)localEntry.getKey());
        i += 1;
        break;
      }
    }
    return localHashMap;
  }
  
  protected String get(String paramString)
  {
    return (String)this.zzabN.get(paramString);
  }
  
  public final T set(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      this.zzabN.put(paramString1, paramString2);
      return this;
    }
    zztc.zzbh("HitBuilder.set() called with a null paramName.");
    return this;
  }
  
  public final T setAll(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return this;
    }
    this.zzabN.putAll(new HashMap(paramMap));
    return this;
  }
  
  public T setCampaignParamsFromUrl(String paramString)
  {
    paramString = zztm.zzcg(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return this;
    }
    paramString = zztm.zzce(paramString);
    zzo("&cc", (String)paramString.get("utm_content"));
    zzo("&cm", (String)paramString.get("utm_medium"));
    zzo("&cn", (String)paramString.get("utm_campaign"));
    zzo("&cs", (String)paramString.get("utm_source"));
    zzo("&ck", (String)paramString.get("utm_term"));
    zzo("&ci", (String)paramString.get("utm_id"));
    zzo("&anid", (String)paramString.get("anid"));
    zzo("&gclid", (String)paramString.get("gclid"));
    zzo("&dclid", (String)paramString.get("dclid"));
    zzo("&aclid", (String)paramString.get("aclid"));
    zzo("&gmob_t", (String)paramString.get("gmob_t"));
    return this;
  }
  
  public T setCustomDimension(int paramInt, String paramString)
  {
    set(zzc.zzan(paramInt), paramString);
    return this;
  }
  
  public T setCustomMetric(int paramInt, float paramFloat)
  {
    set(zzc.zzap(paramInt), Float.toString(paramFloat));
    return this;
  }
  
  protected T setHitType(String paramString)
  {
    set("&t", paramString);
    return this;
  }
  
  public T setNewSession()
  {
    set("&sc", "start");
    return this;
  }
  
  public T setNonInteraction(boolean paramBoolean)
  {
    set("&ni", zztm.zzX(paramBoolean));
    return this;
  }
  
  public T setProductAction(ProductAction paramProductAction)
  {
    this.zzabO = paramProductAction;
    return this;
  }
  
  public T setPromotionAction(String paramString)
  {
    this.zzabN.put("&promoa", paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.analytics.HitBuilders.HitBuilder
 * JD-Core Version:    0.7.0.1
 */
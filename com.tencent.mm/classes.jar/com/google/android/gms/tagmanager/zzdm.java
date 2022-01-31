package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzdm
  extends zzdj
{
  private static final String ID = zzah.zzeM.toString();
  private static final String zzbIP = zzai.zzfs.toString();
  private static final String zzbIQ = zzai.zzfD.toString();
  private static final String zzbIR = zzai.zzhc.toString();
  private static final String zzbIS = zzai.zzgV.toString();
  private static final String zzbIT = zzai.zzgU.toString();
  private static final String zzbIU = zzai.zzfC.toString();
  private static final String zzbIV = zzai.zzjK.toString();
  private static final String zzbIW = zzai.zzjN.toString();
  private static final String zzbIX = zzai.zzjP.toString();
  private static final List<String> zzbIY = Arrays.asList(new String[] { "detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund" });
  private static final Pattern zzbIZ = Pattern.compile("dimension(\\d+)");
  private static final Pattern zzbJa = Pattern.compile("metric(\\d+)");
  private static Map<String, String> zzbJb;
  private static Map<String, String> zzbJc;
  private final DataLayer zzbEZ;
  private final Set<String> zzbJd;
  private final zzdi zzbJe;
  
  public zzdm(Context paramContext, DataLayer paramDataLayer)
  {
    this(paramContext, paramDataLayer, new zzdi(paramContext));
  }
  
  zzdm(Context paramContext, DataLayer paramDataLayer, zzdi paramzzdi)
  {
    super(ID, new String[0]);
    this.zzbEZ = paramDataLayer;
    this.zzbJe = paramzzdi;
    this.zzbJd = new HashSet();
    this.zzbJd.add("");
    this.zzbJd.add("0");
    this.zzbJd.add("false");
  }
  
  private Double zzV(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      try
      {
        paramObject = Double.valueOf((String)paramObject);
        return paramObject;
      }
      catch (NumberFormatException paramObject)
      {
        paramObject = String.valueOf(paramObject.getMessage());
        if (paramObject.length() == 0) {}
      }
      for (paramObject = "Cannot convert the object to Double: ".concat(paramObject);; paramObject = new String("Cannot convert the object to Double: ")) {
        throw new RuntimeException(paramObject);
      }
    }
    if ((paramObject instanceof Integer)) {
      return Double.valueOf(((Integer)paramObject).doubleValue());
    }
    if ((paramObject instanceof Double)) {
      return (Double)paramObject;
    }
    paramObject = String.valueOf(paramObject.toString());
    if (paramObject.length() != 0) {}
    for (paramObject = "Cannot convert the object to Double: ".concat(paramObject);; paramObject = new String("Cannot convert the object to Double: ")) {
      throw new RuntimeException(paramObject);
    }
  }
  
  private Integer zzW(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      try
      {
        paramObject = Integer.valueOf((String)paramObject);
        return paramObject;
      }
      catch (NumberFormatException paramObject)
      {
        paramObject = String.valueOf(paramObject.getMessage());
        if (paramObject.length() == 0) {}
      }
      for (paramObject = "Cannot convert the object to Integer: ".concat(paramObject);; paramObject = new String("Cannot convert the object to Integer: ")) {
        throw new RuntimeException(paramObject);
      }
    }
    if ((paramObject instanceof Double)) {
      return Integer.valueOf(((Double)paramObject).intValue());
    }
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    paramObject = String.valueOf(paramObject.toString());
    if (paramObject.length() != 0) {}
    for (paramObject = "Cannot convert the object to Integer: ".concat(paramObject);; paramObject = new String("Cannot convert the object to Integer: ")) {
      throw new RuntimeException(paramObject);
    }
  }
  
  private void zza(Tracker paramTracker, Map<String, zzak.zza> paramMap)
  {
    String str = zzhB("transactionId");
    if (str == null) {
      zzbo.e("Cannot find transactionId in data layer.");
    }
    for (;;)
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = zzk((zzak.zza)paramMap.get(zzbIU));
        ((Map)localObject1).put("&t", "transaction");
        localObject2 = zzal(paramMap).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          zze((Map)localObject1, (String)((Map.Entry)localObject3).getValue(), zzhB((String)((Map.Entry)localObject3).getKey()));
        }
        localLinkedList.add(localObject1);
      }
      catch (IllegalArgumentException paramTracker)
      {
        zzbo.zzb("Unable to send transaction", paramTracker);
        return;
      }
      Object localObject1 = zzhC("transactionProducts");
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map)((Iterator)localObject1).next();
          if (((Map)localObject2).get("name") == null)
          {
            zzbo.e("Unable to send transaction item hit due to missing 'name' field.");
            return;
          }
          localObject3 = zzk((zzak.zza)paramMap.get(zzbIU));
          ((Map)localObject3).put("&t", "item");
          ((Map)localObject3).put("&ti", str);
          Iterator localIterator = zzam(paramMap).entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            zze((Map)localObject3, (String)localEntry.getValue(), (String)((Map)localObject2).get(localEntry.getKey()));
          }
          localLinkedList.add(localObject3);
        }
      }
      paramMap = localLinkedList.iterator();
      while (paramMap.hasNext()) {
        paramTracker.send((Map)paramMap.next());
      }
    }
  }
  
  private Promotion zzaj(Map<String, String> paramMap)
  {
    Promotion localPromotion = new Promotion();
    String str = (String)paramMap.get("id");
    if (str != null) {
      localPromotion.setId(String.valueOf(str));
    }
    str = (String)paramMap.get("name");
    if (str != null) {
      localPromotion.setName(String.valueOf(str));
    }
    str = (String)paramMap.get("creative");
    if (str != null) {
      localPromotion.setCreative(String.valueOf(str));
    }
    paramMap = (String)paramMap.get("position");
    if (paramMap != null) {
      localPromotion.setPosition(String.valueOf(paramMap));
    }
    return localPromotion;
  }
  
  private Product zzak(Map<String, Object> paramMap)
  {
    Product localProduct = new Product();
    Object localObject = paramMap.get("id");
    if (localObject != null) {
      localProduct.setId(String.valueOf(localObject));
    }
    localObject = paramMap.get("name");
    if (localObject != null) {
      localProduct.setName(String.valueOf(localObject));
    }
    localObject = paramMap.get("brand");
    if (localObject != null) {
      localProduct.setBrand(String.valueOf(localObject));
    }
    localObject = paramMap.get("category");
    if (localObject != null) {
      localProduct.setCategory(String.valueOf(localObject));
    }
    localObject = paramMap.get("variant");
    if (localObject != null) {
      localProduct.setVariant(String.valueOf(localObject));
    }
    localObject = paramMap.get("coupon");
    if (localObject != null) {
      localProduct.setCouponCode(String.valueOf(localObject));
    }
    localObject = paramMap.get("position");
    if (localObject != null) {
      localProduct.setPosition(zzW(localObject).intValue());
    }
    localObject = paramMap.get("price");
    if (localObject != null) {
      localProduct.setPrice(zzV(localObject).doubleValue());
    }
    localObject = paramMap.get("quantity");
    if (localObject != null) {
      localProduct.setQuantity(zzW(localObject).intValue());
    }
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label455;
      }
      localObject = (String)localIterator.next();
      Matcher localMatcher1 = zzbIZ.matcher((CharSequence)localObject);
      int i;
      if (localMatcher1.matches())
      {
        try
        {
          i = Integer.parseInt(localMatcher1.group(1));
          localProduct.setCustomDimension(i, String.valueOf(paramMap.get(localObject)));
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localObject = String.valueOf(localObject);
          if (((String)localObject).length() == 0) {}
        }
        for (localObject = "illegal number in custom dimension value: ".concat((String)localObject);; localObject = new String("illegal number in custom dimension value: "))
        {
          zzbo.zzbh((String)localObject);
          break;
        }
      }
      else
      {
        Matcher localMatcher2 = zzbJa.matcher((CharSequence)localObject);
        if (localMatcher2.matches()) {
          try
          {
            i = Integer.parseInt(localMatcher2.group(1));
            localProduct.setCustomMetric(i, zzW(paramMap.get(localObject)).intValue());
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            localObject = String.valueOf(localObject);
            if (((String)localObject).length() == 0) {}
          }
        }
      }
    }
    for (localObject = "illegal number in custom metric value: ".concat((String)localObject);; localObject = new String("illegal number in custom metric value: "))
    {
      zzbo.zzbh((String)localObject);
      break;
    }
    label455:
    return localProduct;
  }
  
  private Map<String, String> zzal(Map<String, zzak.zza> paramMap)
  {
    paramMap = (zzak.zza)paramMap.get(zzbIW);
    if (paramMap != null) {
      return zzc(paramMap);
    }
    if (zzbJb == null)
    {
      paramMap = new HashMap();
      paramMap.put("transactionId", "&ti");
      paramMap.put("transactionAffiliation", "&ta");
      paramMap.put("transactionTax", "&tt");
      paramMap.put("transactionShipping", "&ts");
      paramMap.put("transactionTotal", "&tr");
      paramMap.put("transactionCurrency", "&cu");
      zzbJb = paramMap;
    }
    return zzbJb;
  }
  
  private Map<String, String> zzam(Map<String, zzak.zza> paramMap)
  {
    paramMap = (zzak.zza)paramMap.get(zzbIX);
    if (paramMap != null) {
      return zzc(paramMap);
    }
    if (zzbJc == null)
    {
      paramMap = new HashMap();
      paramMap.put("name", "&in");
      paramMap.put("sku", "&ic");
      paramMap.put("category", "&iv");
      paramMap.put("price", "&ip");
      paramMap.put("quantity", "&iq");
      paramMap.put("currency", "&cu");
      zzbJc = paramMap;
    }
    return zzbJc;
  }
  
  private void zzb(Tracker paramTracker, Map<String, zzak.zza> paramMap)
  {
    HitBuilders.ScreenViewBuilder localScreenViewBuilder = new HitBuilders.ScreenViewBuilder();
    Object localObject1 = zzk((zzak.zza)paramMap.get(zzbIU));
    localScreenViewBuilder.setAll((Map)localObject1);
    if (zzi(paramMap, zzbIS))
    {
      paramMap = this.zzbEZ.get("ecommerce");
      if (!(paramMap instanceof Map)) {
        break label800;
      }
      paramMap = (Map)paramMap;
    }
    for (;;)
    {
      Object localObject4;
      label158:
      Object localObject2;
      if (paramMap != null)
      {
        localObject4 = (String)((Map)localObject1).get("&cu");
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = (String)paramMap.get("currencyCode");
        }
        if (localObject1 != null) {
          localScreenViewBuilder.set("&cu", (String)localObject1);
        }
        localObject1 = paramMap.get("impressions");
        if ((localObject1 instanceof List))
        {
          localObject4 = ((List)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject4).hasNext()) {
              break label292;
            }
            localObject1 = (Map)((Iterator)localObject4).next();
            try
            {
              localScreenViewBuilder.addImpression(zzak((Map)localObject1), (String)((Map)localObject1).get("list"));
            }
            catch (RuntimeException localRuntimeException1)
            {
              localObject2 = String.valueOf(localRuntimeException1.getMessage());
              if (((String)localObject2).length() == 0) {}
            }
          }
          for (localObject2 = "Failed to extract a product from DataLayer. ".concat((String)localObject2);; localObject2 = new String("Failed to extract a product from DataLayer. "))
          {
            zzbo.e((String)localObject2);
            break label158;
            paramMap = zzdl.zzj((zzak.zza)paramMap.get(zzbIT));
            if (!(paramMap instanceof Map)) {
              break label795;
            }
            paramMap = (Map)paramMap;
            break;
          }
        }
        label292:
        if (paramMap.containsKey("promoClick")) {
          localObject2 = (List)((Map)paramMap.get("promoClick")).get("promotions");
        }
      }
      for (;;)
      {
        label343:
        label473:
        int i;
        if (localObject2 != null)
        {
          localObject4 = ((List)localObject2).iterator();
          for (;;)
          {
            if (!((Iterator)localObject4).hasNext()) {
              break label473;
            }
            localObject2 = (Map)((Iterator)localObject4).next();
            try
            {
              localScreenViewBuilder.addPromotion(zzaj((Map)localObject2));
            }
            catch (RuntimeException localRuntimeException2)
            {
              localObject3 = String.valueOf(localRuntimeException2.getMessage());
              if (((String)localObject3).length() == 0) {}
            }
          }
          for (localObject3 = "Failed to extract a promotion from DataLayer. ".concat((String)localObject3);; localObject3 = new String("Failed to extract a promotion from DataLayer. "))
          {
            zzbo.e((String)localObject3);
            break label343;
            if (!paramMap.containsKey("promoView")) {
              break label789;
            }
            localObject3 = (List)((Map)paramMap.get("promoView")).get("promotions");
            break;
          }
          if (paramMap.containsKey("promoClick"))
          {
            localScreenViewBuilder.set("&promoa", "click");
            i = 0;
            if (i == 0) {
              break label721;
            }
            localObject4 = zzbIY.iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject3 = (String)((Iterator)localObject4).next();
            } while (!paramMap.containsKey(localObject3));
            localObject4 = (Map)paramMap.get(localObject3);
            paramMap = (List)((Map)localObject4).get("products");
            if (paramMap == null) {
              break label681;
            }
            Iterator localIterator = paramMap.iterator();
            for (;;)
            {
              label584:
              if (!localIterator.hasNext()) {
                break label681;
              }
              paramMap = (Map)localIterator.next();
              try
              {
                localScreenViewBuilder.addProduct(zzak(paramMap));
              }
              catch (RuntimeException paramMap)
              {
                paramMap = String.valueOf(paramMap.getMessage());
                if (paramMap.length() == 0) {}
              }
            }
          }
        }
        for (paramMap = "Failed to extract a product from DataLayer. ".concat(paramMap);; paramMap = new String("Failed to extract a product from DataLayer. "))
        {
          zzbo.e(paramMap);
          break label584;
          localScreenViewBuilder.set("&promoa", "view");
          i = 1;
          break;
        }
        try
        {
          label681:
          if (((Map)localObject4).containsKey("actionField")) {}
          for (paramMap = zzh((String)localObject3, (Map)((Map)localObject4).get("actionField"));; paramMap = new ProductAction((String)localObject3))
          {
            localScreenViewBuilder.setProductAction(paramMap);
            label721:
            paramTracker.send(localScreenViewBuilder.build());
            return;
          }
          paramMap = "Failed to extract a product action from DataLayer. ".concat(paramMap);
        }
        catch (RuntimeException paramMap)
        {
          paramMap = String.valueOf(paramMap.getMessage());
          if (paramMap.length() == 0) {}
        }
        for (;;)
        {
          zzbo.e(paramMap);
          break;
          paramMap = new String("Failed to extract a product action from DataLayer. ");
        }
        label789:
        Object localObject3 = null;
      }
      label795:
      paramMap = null;
      continue;
      label800:
      paramMap = null;
    }
  }
  
  private Map<String, String> zzc(zzak.zza paramzza)
  {
    paramzza = zzdl.zzj(paramzza);
    if (!(paramzza instanceof Map)) {
      return null;
    }
    Object localObject = (Map)paramzza;
    paramzza = new LinkedHashMap();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramzza.put(localEntry.getKey().toString(), localEntry.getValue().toString());
    }
    return paramzza;
  }
  
  private void zze(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private ProductAction zzh(String paramString, Map<String, Object> paramMap)
  {
    paramString = new ProductAction(paramString);
    Object localObject = paramMap.get("id");
    if (localObject != null) {
      paramString.setTransactionId(String.valueOf(localObject));
    }
    localObject = paramMap.get("affiliation");
    if (localObject != null) {
      paramString.setTransactionAffiliation(String.valueOf(localObject));
    }
    localObject = paramMap.get("coupon");
    if (localObject != null) {
      paramString.setTransactionCouponCode(String.valueOf(localObject));
    }
    localObject = paramMap.get("list");
    if (localObject != null) {
      paramString.setProductActionList(String.valueOf(localObject));
    }
    localObject = paramMap.get("option");
    if (localObject != null) {
      paramString.setCheckoutOptions(String.valueOf(localObject));
    }
    localObject = paramMap.get("revenue");
    if (localObject != null) {
      paramString.setTransactionRevenue(zzV(localObject).doubleValue());
    }
    localObject = paramMap.get("tax");
    if (localObject != null) {
      paramString.setTransactionTax(zzV(localObject).doubleValue());
    }
    localObject = paramMap.get("shipping");
    if (localObject != null) {
      paramString.setTransactionShipping(zzV(localObject).doubleValue());
    }
    paramMap = paramMap.get("step");
    if (paramMap != null) {
      paramString.setCheckoutStep(zzW(paramMap).intValue());
    }
    return paramString;
  }
  
  private String zzhB(String paramString)
  {
    paramString = this.zzbEZ.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.toString();
  }
  
  private List<Map<String, String>> zzhC(String paramString)
  {
    paramString = this.zzbEZ.get(paramString);
    if (paramString == null) {
      return null;
    }
    if (!(paramString instanceof List)) {
      throw new IllegalArgumentException("transactionProducts should be of type List.");
    }
    Iterator localIterator = ((List)paramString).iterator();
    while (localIterator.hasNext()) {
      if (!(localIterator.next() instanceof Map)) {
        throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
      }
    }
    return (List)paramString;
  }
  
  private boolean zzi(Map<String, zzak.zza> paramMap, String paramString)
  {
    paramMap = (zzak.zza)paramMap.get(paramString);
    if (paramMap == null) {
      return false;
    }
    return zzdl.zzi(paramMap).booleanValue();
  }
  
  private Map<String, String> zzk(zzak.zza paramzza)
  {
    if (paramzza == null) {
      return new HashMap();
    }
    paramzza = zzc(paramzza);
    if (paramzza == null) {
      return new HashMap();
    }
    String str = (String)paramzza.get("&aip");
    if ((str != null) && (this.zzbJd.contains(str.toLowerCase()))) {
      paramzza.remove("&aip");
    }
    return paramzza;
  }
  
  public void zzab(Map<String, zzak.zza> paramMap)
  {
    Tracker localTracker = this.zzbJe.zzht("_GTM_DEFAULT_TRACKER_");
    localTracker.enableAdvertisingIdCollection(zzi(paramMap, "collect_adid"));
    if (zzi(paramMap, zzbIR))
    {
      zzb(localTracker, paramMap);
      return;
    }
    if (zzi(paramMap, zzbIQ))
    {
      localTracker.send(zzk((zzak.zza)paramMap.get(zzbIU)));
      return;
    }
    if (zzi(paramMap, zzbIV))
    {
      zza(localTracker, paramMap);
      return;
    }
    zzbo.zzbh("Ignoring unknown tag.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzdm
 * JD-Core Version:    0.7.0.1
 */
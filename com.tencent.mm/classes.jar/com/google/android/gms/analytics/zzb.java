package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.internal.zzrt;
import com.google.android.gms.internal.zzru;
import com.google.android.gms.internal.zzrv;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzrz;
import com.google.android.gms.internal.zzsb;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zztm;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzb
  extends zzrz
  implements zzi
{
  private static DecimalFormat zzabr;
  private final zzsc zzabn;
  private final String zzabs;
  private final Uri zzabt;
  private final boolean zzabu;
  private final boolean zzabv;
  
  public zzb(zzsc paramzzsc, String paramString)
  {
    this(paramzzsc, paramString, true, false);
  }
  
  public zzb(zzsc paramzzsc, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramzzsc);
    zzac.zzdr(paramString);
    this.zzabn = paramzzsc;
    this.zzabs = paramString;
    this.zzabu = paramBoolean1;
    this.zzabv = paramBoolean2;
    this.zzabt = zzbq(this.zzabs);
  }
  
  private static String zzR(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, double paramDouble)
  {
    if (paramDouble != 0.0D) {
      paramMap.put(paramString, zzb(paramDouble));
    }
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      paramMap.put(paramString, 23 + paramInt1 + "x" + paramInt2);
    }
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramMap.put(paramString, "1");
    }
  }
  
  static String zzb(double paramDouble)
  {
    if (zzabr == null) {
      zzabr = new DecimalFormat("0.######");
    }
    return zzabr.format(paramDouble);
  }
  
  private static void zzb(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  static Uri zzbq(String paramString)
  {
    zzac.zzdr(paramString);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("uri");
    localBuilder.authority("google-analytics.com");
    localBuilder.path(paramString);
    return localBuilder.build();
  }
  
  public static Map<String, String> zzc(zze paramzze)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = (zzro)paramzze.zza(zzro.class);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((zzro)localObject1).zznj().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzi(((Map.Entry)localObject2).getValue());
        if (localObject3 != null) {
          localHashMap.put((String)((Map.Entry)localObject2).getKey(), localObject3);
        }
      }
    }
    localObject1 = (zzrt)paramzze.zza(zzrt.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "t", ((zzrt)localObject1).zznu());
      zzb(localHashMap, "cid", ((zzrt)localObject1).zzmy());
      zzb(localHashMap, "uid", ((zzrt)localObject1).getUserId());
      zzb(localHashMap, "sc", ((zzrt)localObject1).zznx());
      zza(localHashMap, "sf", ((zzrt)localObject1).zznz());
      zza(localHashMap, "ni", ((zzrt)localObject1).zzny());
      zzb(localHashMap, "adid", ((zzrt)localObject1).zznv());
      zza(localHashMap, "ate", ((zzrt)localObject1).zznw());
    }
    localObject1 = (zzru)paramzze.zza(zzru.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "cd", ((zzru)localObject1).zznB());
      zza(localHashMap, "a", ((zzru)localObject1).zznC());
      zzb(localHashMap, "dr", ((zzru)localObject1).zznD());
    }
    localObject1 = (zzrr)paramzze.zza(zzrr.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "ec", ((zzrr)localObject1).getCategory());
      zzb(localHashMap, "ea", ((zzrr)localObject1).getAction());
      zzb(localHashMap, "el", ((zzrr)localObject1).getLabel());
      zza(localHashMap, "ev", ((zzrr)localObject1).getValue());
    }
    localObject1 = (zzrl)paramzze.zza(zzrl.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "cn", ((zzrl)localObject1).getName());
      zzb(localHashMap, "cs", ((zzrl)localObject1).getSource());
      zzb(localHashMap, "cm", ((zzrl)localObject1).zznb());
      zzb(localHashMap, "ck", ((zzrl)localObject1).zznc());
      zzb(localHashMap, "cc", ((zzrl)localObject1).getContent());
      zzb(localHashMap, "ci", ((zzrl)localObject1).getId());
      zzb(localHashMap, "anid", ((zzrl)localObject1).zznd());
      zzb(localHashMap, "gclid", ((zzrl)localObject1).zzne());
      zzb(localHashMap, "dclid", ((zzrl)localObject1).zznf());
      zzb(localHashMap, "aclid", ((zzrl)localObject1).zzng());
    }
    localObject1 = (zzrs)paramzze.zza(zzrs.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "exd", ((zzrs)localObject1).getDescription());
      zza(localHashMap, "exf", ((zzrs)localObject1).zznt());
    }
    localObject1 = (zzrv)paramzze.zza(zzrv.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "sn", ((zzrv)localObject1).zznE());
      zzb(localHashMap, "sa", ((zzrv)localObject1).getAction());
      zzb(localHashMap, "st", ((zzrv)localObject1).getTarget());
    }
    localObject1 = (zzrw)paramzze.zza(zzrw.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "utv", ((zzrw)localObject1).zznF());
      zza(localHashMap, "utt", ((zzrw)localObject1).getTimeInMillis());
      zzb(localHashMap, "utc", ((zzrw)localObject1).getCategory());
      zzb(localHashMap, "utl", ((zzrw)localObject1).getLabel());
    }
    localObject1 = (zzrm)paramzze.zza(zzrm.class);
    if (localObject1 != null)
    {
      localObject1 = ((zzrm)localObject1).zznh().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzc.zzao(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localHashMap.put(localObject3, (String)((Map.Entry)localObject2).getValue());
        }
      }
    }
    localObject1 = (zzrn)paramzze.zza(zzrn.class);
    if (localObject1 != null)
    {
      localObject1 = ((zzrn)localObject1).zzni().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzc.zzaq(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localHashMap.put(localObject3, zzb(((Double)((Map.Entry)localObject2).getValue()).doubleValue()));
        }
      }
    }
    localObject1 = (zzrq)paramzze.zza(zzrq.class);
    if (localObject1 != null)
    {
      localObject2 = ((zzrq)localObject1).zznp();
      if (localObject2 != null)
      {
        localObject2 = ((ProductAction)localObject2).build().entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (((String)((Map.Entry)localObject3).getKey()).startsWith("&")) {
            localHashMap.put(((String)((Map.Entry)localObject3).getKey()).substring(1), (String)((Map.Entry)localObject3).getValue());
          } else {
            localHashMap.put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
          }
        }
      }
      localObject2 = ((zzrq)localObject1).zzns().iterator();
      int i = 1;
      while (((Iterator)localObject2).hasNext())
      {
        localHashMap.putAll(((Promotion)((Iterator)localObject2).next()).zzbM(zzc.zzau(i)));
        i += 1;
      }
      localObject2 = ((zzrq)localObject1).zznq().iterator();
      i = 1;
      while (((Iterator)localObject2).hasNext())
      {
        localHashMap.putAll(((Product)((Iterator)localObject2).next()).zzbM(zzc.zzas(i)));
        i += 1;
      }
      localObject2 = ((zzrq)localObject1).zznr().entrySet().iterator();
      i = 1;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        localObject1 = (List)((Map.Entry)localObject3).getValue();
        String str1 = zzc.zzax(i);
        Iterator localIterator = ((List)localObject1).iterator();
        int j = 1;
        if (localIterator.hasNext())
        {
          Product localProduct = (Product)localIterator.next();
          localObject1 = String.valueOf(str1);
          String str2 = String.valueOf(zzc.zzav(j));
          if (str2.length() != 0) {}
          for (localObject1 = ((String)localObject1).concat(str2);; localObject1 = new String((String)localObject1))
          {
            localHashMap.putAll(localProduct.zzbM((String)localObject1));
            j += 1;
            break;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)((Map.Entry)localObject3).getKey()))
        {
          localObject1 = String.valueOf(str1);
          str1 = String.valueOf("nm");
          if (str1.length() == 0) {
            break label1285;
          }
        }
        label1285:
        for (localObject1 = ((String)localObject1).concat(str1);; localObject1 = new String((String)localObject1))
        {
          localHashMap.put(localObject1, (String)((Map.Entry)localObject3).getKey());
          i += 1;
          break;
        }
      }
    }
    localObject1 = (zzrp)paramzze.zza(zzrp.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "ul", ((zzrp)localObject1).getLanguage());
      zza(localHashMap, "sd", ((zzrp)localObject1).zznk());
      zza(localHashMap, "sr", ((zzrp)localObject1).zznl(), ((zzrp)localObject1).zznm());
      zza(localHashMap, "vp", ((zzrp)localObject1).zznn(), ((zzrp)localObject1).zzno());
    }
    paramzze = (zzrk)paramzze.zza(zzrk.class);
    if (paramzze != null)
    {
      zzb(localHashMap, "an", paramzze.zzmY());
      zzb(localHashMap, "aid", paramzze.zzke());
      zzb(localHashMap, "aiid", paramzze.zzna());
      zzb(localHashMap, "av", paramzze.zzmZ());
    }
    return localHashMap;
  }
  
  private static String zzi(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return paramObject;
      if (!(paramObject instanceof String)) {
        break;
      }
      str = (String)paramObject;
      paramObject = str;
    } while (!TextUtils.isEmpty(str));
    return null;
    if ((paramObject instanceof Double))
    {
      paramObject = (Double)paramObject;
      if (paramObject.doubleValue() != 0.0D) {
        return zzb(paramObject.doubleValue());
      }
      return null;
    }
    if ((paramObject instanceof Boolean))
    {
      if (paramObject != Boolean.FALSE) {
        return "1";
      }
      return null;
    }
    return String.valueOf(paramObject);
  }
  
  public void zzb(zze paramzze)
  {
    zzac.zzw(paramzze);
    zzac.zzb(paramzze.zzmH(), "Can't deliver not submitted measurement");
    zzac.zzdk("deliver should be called on worker thread");
    Object localObject2 = paramzze.zzmC();
    Object localObject1 = (zzrt)((zze)localObject2).zzb(zzrt.class);
    if (TextUtils.isEmpty(((zzrt)localObject1).zznu())) {
      zznS().zzg(zzc((zze)localObject2), "Ignoring measurement without type");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(((zzrt)localObject1).zzmy()))
      {
        zznS().zzg(zzc((zze)localObject2), "Ignoring measurement without client id");
        return;
      }
    } while (this.zzabn.zzof().getAppOptOut());
    double d = ((zzrt)localObject1).zznz();
    if (zztm.zza(d, ((zzrt)localObject1).zzmy()))
    {
      zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
      return;
    }
    localObject2 = zzc((zze)localObject2);
    ((Map)localObject2).put("v", "1");
    ((Map)localObject2).put("_v", zzsb.zzadQ);
    ((Map)localObject2).put("tid", this.zzabs);
    if (this.zzabn.zzof().isDryRunEnabled())
    {
      zzc("Dry run is enabled. GoogleAnalytics would have sent", zzR((Map)localObject2));
      return;
    }
    HashMap localHashMap = new HashMap();
    zztm.zzc(localHashMap, "uid", ((zzrt)localObject1).getUserId());
    Object localObject3 = (zzrk)paramzze.zza(zzrk.class);
    if (localObject3 != null)
    {
      zztm.zzc(localHashMap, "an", ((zzrk)localObject3).zzmY());
      zztm.zzc(localHashMap, "aid", ((zzrk)localObject3).zzke());
      zztm.zzc(localHashMap, "av", ((zzrk)localObject3).zzmZ());
      zztm.zzc(localHashMap, "aiid", ((zzrk)localObject3).zzna());
    }
    localObject3 = ((zzrt)localObject1).zzmy();
    String str = this.zzabs;
    if (!TextUtils.isEmpty(((zzrt)localObject1).zznv())) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new zzse(0L, (String)localObject3, str, bool, 0L, localHashMap);
      ((Map)localObject2).put("_s", String.valueOf(zzmA().zza((zzse)localObject1)));
      paramzze = new zzsz(zznS(), (Map)localObject2, paramzze.zzmF(), true);
      zzmA().zza(paramzze);
      return;
    }
  }
  
  public Uri zzmr()
  {
    return this.zzabt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.analytics.zzb
 * JD-Core Version:    0.7.0.1
 */
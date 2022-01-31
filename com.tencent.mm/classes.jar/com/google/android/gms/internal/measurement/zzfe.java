package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfe
  extends zzhh
{
  private static final AtomicReference<String[]> zzaij;
  private static final AtomicReference<String[]> zzaik;
  private static final AtomicReference<String[]> zzail;
  
  static
  {
    AppMethodBeat.i(68868);
    zzaij = new AtomicReference();
    zzaik = new AtomicReference();
    zzail = new AtomicReference();
    AppMethodBeat.o(68868);
  }
  
  zzfe(zzgl paramzzgl)
  {
    super(paramzzgl);
  }
  
  private static String zza(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, AtomicReference<String[]> paramAtomicReference)
  {
    int i = 0;
    AppMethodBeat.i(68836);
    Preconditions.checkNotNull(paramArrayOfString1);
    Preconditions.checkNotNull(paramArrayOfString2);
    Preconditions.checkNotNull(paramAtomicReference);
    boolean bool;
    if (paramArrayOfString1.length == paramArrayOfString2.length)
    {
      bool = true;
      Preconditions.checkArgument(bool);
    }
    for (;;)
    {
      if (i >= paramArrayOfString1.length) {
        break label186;
      }
      if (zzka.zzs(paramString, paramArrayOfString1[i]))
      {
        try
        {
          Object localObject = (String[])paramAtomicReference.get();
          paramString = (String)localObject;
          if (localObject == null)
          {
            paramString = new String[paramArrayOfString2.length];
            paramAtomicReference.set(paramString);
          }
          if (paramString[i] == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramArrayOfString2[i]);
            ((StringBuilder)localObject).append("(");
            ((StringBuilder)localObject).append(paramArrayOfString1[i]);
            ((StringBuilder)localObject).append(")");
            paramString[i] = ((StringBuilder)localObject).toString();
          }
          paramString = paramString[i];
          return paramString;
        }
        finally
        {
          AppMethodBeat.o(68836);
        }
        bool = false;
        break;
      }
      i += 1;
    }
    label186:
    AppMethodBeat.o(68836);
    return paramString;
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(68844);
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append("  ");
      i += 1;
    }
    AppMethodBeat.o(68844);
  }
  
  private final void zza(StringBuilder paramStringBuilder, int paramInt, zzkf paramzzkf)
  {
    AppMethodBeat.i(68848);
    if (paramzzkf == null)
    {
      AppMethodBeat.o(68848);
      return;
    }
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("filter {\n");
    zza(paramStringBuilder, paramInt, "complement", paramzzkf.zzarx);
    zza(paramStringBuilder, paramInt, "param_name", zzbk(paramzzkf.zzary));
    int j = paramInt + 1;
    zzki localzzki = paramzzkf.zzarv;
    if (localzzki != null)
    {
      zza(paramStringBuilder, j);
      paramStringBuilder.append("string_filter");
      paramStringBuilder.append(" {\n");
      Object localObject;
      if (localzzki.zzash != null)
      {
        localObject = "UNKNOWN_MATCH_TYPE";
        switch (localzzki.zzash.intValue())
        {
        }
      }
      for (;;)
      {
        zza(paramStringBuilder, j, "match_type", localObject);
        zza(paramStringBuilder, j, "expression", localzzki.zzasi);
        zza(paramStringBuilder, j, "case_sensitive", localzzki.zzasj);
        if (localzzki.zzask.length <= 0) {
          break label317;
        }
        zza(paramStringBuilder, j + 1);
        paramStringBuilder.append("expression_list {\n");
        localObject = localzzki.zzask;
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          localzzki = localObject[i];
          zza(paramStringBuilder, j + 2);
          paramStringBuilder.append(localzzki);
          paramStringBuilder.append("\n");
          i += 1;
        }
        localObject = "REGEXP";
        continue;
        localObject = "BEGINS_WITH";
        continue;
        localObject = "ENDS_WITH";
        continue;
        localObject = "PARTIAL";
        continue;
        localObject = "EXACT";
        continue;
        localObject = "IN_LIST";
      }
      paramStringBuilder.append("}\n");
      label317:
      zza(paramStringBuilder, j);
      paramStringBuilder.append("}\n");
    }
    zza(paramStringBuilder, j, "number_filter", paramzzkf.zzarw);
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
    AppMethodBeat.o(68848);
  }
  
  private final void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, zzkg paramzzkg)
  {
    AppMethodBeat.i(68847);
    if (paramzzkg == null)
    {
      AppMethodBeat.o(68847);
      return;
    }
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    if (paramzzkg.zzarz != null)
    {
      paramString = "UNKNOWN_COMPARISON_TYPE";
      switch (paramzzkg.zzarz.intValue())
      {
      }
    }
    for (;;)
    {
      zza(paramStringBuilder, paramInt, "comparison_type", paramString);
      zza(paramStringBuilder, paramInt, "match_as_float", paramzzkg.zzasa);
      zza(paramStringBuilder, paramInt, "comparison_value", paramzzkg.zzasb);
      zza(paramStringBuilder, paramInt, "min_comparison_value", paramzzkg.zzasc);
      zza(paramStringBuilder, paramInt, "max_comparison_value", paramzzkg.zzasd);
      zza(paramStringBuilder, paramInt);
      paramStringBuilder.append("}\n");
      AppMethodBeat.o(68847);
      return;
      paramString = "LESS_THAN";
      continue;
      paramString = "GREATER_THAN";
      continue;
      paramString = "EQUAL";
      continue;
      paramString = "BETWEEN";
    }
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, zzkr paramzzkr)
  {
    AppMethodBeat.i(68846);
    if (paramzzkr == null)
    {
      AppMethodBeat.o(68846);
      return;
    }
    zza(paramStringBuilder, 3);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    int j;
    int i;
    long l;
    if (paramzzkr.zzaul != null)
    {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("results: ");
      paramString = paramzzkr.zzaul;
      j = paramString.length;
      i = 0;
      paramInt = 0;
      while (i < j)
      {
        l = paramString[i];
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(Long.valueOf(l));
        i += 1;
        paramInt += 1;
      }
      paramStringBuilder.append('\n');
    }
    if (paramzzkr.zzauk != null)
    {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("status: ");
      paramString = paramzzkr.zzauk;
      j = paramString.length;
      i = 0;
      paramInt = 0;
      while (i < j)
      {
        l = paramString[i];
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(Long.valueOf(l));
        i += 1;
        paramInt += 1;
      }
      paramStringBuilder.append('\n');
    }
    zza(paramStringBuilder, 3);
    paramStringBuilder.append("}\n");
    AppMethodBeat.o(68846);
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    AppMethodBeat.i(68845);
    if (paramObject == null)
    {
      AppMethodBeat.o(68845);
      return;
    }
    zza(paramStringBuilder, paramInt + 1);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append('\n');
    AppMethodBeat.o(68845);
  }
  
  private final String zzb(zzer paramzzer)
  {
    AppMethodBeat.i(68839);
    if (paramzzer == null)
    {
      AppMethodBeat.o(68839);
      return null;
    }
    if (!zzil())
    {
      paramzzer = paramzzer.toString();
      AppMethodBeat.o(68839);
      return paramzzer;
    }
    paramzzer = zzb(paramzzer.zzif());
    AppMethodBeat.o(68839);
    return paramzzer;
  }
  
  private final boolean zzil()
  {
    AppMethodBeat.i(68832);
    boolean bool = this.zzacw.zzge().isLoggable(3);
    AppMethodBeat.o(68832);
    return bool;
  }
  
  protected final String zza(zzep paramzzep)
  {
    AppMethodBeat.i(68838);
    if (paramzzep == null)
    {
      AppMethodBeat.o(68838);
      return null;
    }
    if (!zzil())
    {
      paramzzep = paramzzep.toString();
      AppMethodBeat.o(68838);
      return paramzzep;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Event{appId='");
    localStringBuilder.append(paramzzep.zzti);
    localStringBuilder.append("', name='");
    localStringBuilder.append(zzbj(paramzzep.name));
    localStringBuilder.append("', params=");
    localStringBuilder.append(zzb(paramzzep.zzafq));
    localStringBuilder.append("}");
    paramzzep = localStringBuilder.toString();
    AppMethodBeat.o(68838);
    return paramzzep;
  }
  
  protected final String zza(zzke paramzzke)
  {
    int i = 0;
    AppMethodBeat.i(68842);
    if (paramzzke == null)
    {
      AppMethodBeat.o(68842);
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nevent_filter {\n");
    zza(localStringBuilder, 0, "filter_id", paramzzke.zzarp);
    zza(localStringBuilder, 0, "event_name", zzbj(paramzzke.zzarq));
    zza(localStringBuilder, 1, "event_count_filter", paramzzke.zzart);
    localStringBuilder.append("  filters {\n");
    paramzzke = paramzzke.zzarr;
    int j = paramzzke.length;
    while (i < j)
    {
      zza(localStringBuilder, 2, paramzzke[i]);
      i += 1;
    }
    zza(localStringBuilder, 1);
    localStringBuilder.append("}\n}\n");
    paramzzke = localStringBuilder.toString();
    AppMethodBeat.o(68842);
    return paramzzke;
  }
  
  protected final String zza(zzkh paramzzkh)
  {
    AppMethodBeat.i(68843);
    if (paramzzkh == null)
    {
      AppMethodBeat.o(68843);
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nproperty_filter {\n");
    zza(localStringBuilder, 0, "filter_id", paramzzkh.zzarp);
    zza(localStringBuilder, 0, "property_name", zzbl(paramzzkh.zzasf));
    zza(localStringBuilder, 1, paramzzkh.zzasg);
    localStringBuilder.append("}\n");
    paramzzkh = localStringBuilder.toString();
    AppMethodBeat.o(68843);
    return paramzzkh;
  }
  
  protected final String zza(zzkp paramzzkp)
  {
    AppMethodBeat.i(68841);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nbatch {\n");
    if (paramzzkp.zzatf != null)
    {
      paramzzkp = paramzzkp.zzatf;
      int m = paramzzkp.length;
      int i = 0;
      while (i < m)
      {
        zzkn[] arrayOfzzkn = paramzzkp[i];
        if ((arrayOfzzkn != null) && (arrayOfzzkn != null))
        {
          zza(localStringBuilder, 1);
          localStringBuilder.append("bundle {\n");
          zza(localStringBuilder, 1, "protocol_version", arrayOfzzkn.zzath);
          zza(localStringBuilder, 1, "platform", arrayOfzzkn.zzatp);
          zza(localStringBuilder, 1, "gmp_version", arrayOfzzkn.zzatt);
          zza(localStringBuilder, 1, "uploading_gmp_version", arrayOfzzkn.zzatu);
          zza(localStringBuilder, 1, "config_version", arrayOfzzkn.zzauf);
          zza(localStringBuilder, 1, "gmp_app_id", arrayOfzzkn.zzadm);
          zza(localStringBuilder, 1, "app_id", arrayOfzzkn.zzti);
          zza(localStringBuilder, 1, "app_version", arrayOfzzkn.zzth);
          zza(localStringBuilder, 1, "app_version_major", arrayOfzzkn.zzaub);
          zza(localStringBuilder, 1, "firebase_instance_id", arrayOfzzkn.zzado);
          zza(localStringBuilder, 1, "dev_cert_hash", arrayOfzzkn.zzatx);
          zza(localStringBuilder, 1, "app_store", arrayOfzzkn.zzadt);
          zza(localStringBuilder, 1, "upload_timestamp_millis", arrayOfzzkn.zzatk);
          zza(localStringBuilder, 1, "start_timestamp_millis", arrayOfzzkn.zzatl);
          zza(localStringBuilder, 1, "end_timestamp_millis", arrayOfzzkn.zzatm);
          zza(localStringBuilder, 1, "previous_bundle_start_timestamp_millis", arrayOfzzkn.zzatn);
          zza(localStringBuilder, 1, "previous_bundle_end_timestamp_millis", arrayOfzzkn.zzato);
          zza(localStringBuilder, 1, "app_instance_id", arrayOfzzkn.zzadl);
          zza(localStringBuilder, 1, "resettable_device_id", arrayOfzzkn.zzatv);
          zza(localStringBuilder, 1, "device_id", arrayOfzzkn.zzaue);
          zza(localStringBuilder, 1, "limited_ad_tracking", arrayOfzzkn.zzatw);
          zza(localStringBuilder, 1, "os_version", arrayOfzzkn.zzatq);
          zza(localStringBuilder, 1, "device_model", arrayOfzzkn.zzatr);
          zza(localStringBuilder, 1, "user_default_language", arrayOfzzkn.zzafn);
          zza(localStringBuilder, 1, "time_zone_offset_minutes", arrayOfzzkn.zzats);
          zza(localStringBuilder, 1, "bundle_sequential_index", arrayOfzzkn.zzaty);
          zza(localStringBuilder, 1, "service_upload", arrayOfzzkn.zzatz);
          zza(localStringBuilder, 1, "health_monitor", arrayOfzzkn.zzaek);
          if ((arrayOfzzkn.zzaug != null) && (arrayOfzzkn.zzaug.longValue() != 0L)) {
            zza(localStringBuilder, 1, "android_id", arrayOfzzkn.zzaug);
          }
          if (arrayOfzzkn.zzauj != null) {
            zza(localStringBuilder, 1, "retry_counter", arrayOfzzkn.zzauj);
          }
          Object localObject1 = arrayOfzzkn.zzatj;
          int k;
          int j;
          Object localObject2;
          if (localObject1 != null)
          {
            k = localObject1.length;
            j = 0;
            while (j < k)
            {
              localObject2 = localObject1[j];
              if (localObject2 != null)
              {
                zza(localStringBuilder, 2);
                localStringBuilder.append("user_property {\n");
                zza(localStringBuilder, 2, "set_timestamp_millis", localObject2.zzaun);
                zza(localStringBuilder, 2, "name", zzbl(localObject2.name));
                zza(localStringBuilder, 2, "string_value", localObject2.zzajf);
                zza(localStringBuilder, 2, "int_value", localObject2.zzate);
                zza(localStringBuilder, 2, "double_value", localObject2.zzarc);
                zza(localStringBuilder, 2);
                localStringBuilder.append("}\n");
              }
              j += 1;
            }
          }
          localObject1 = arrayOfzzkn.zzaua;
          if (localObject1 != null)
          {
            k = localObject1.length;
            j = 0;
            while (j < k)
            {
              localObject2 = localObject1[j];
              if (localObject2 != null)
              {
                zza(localStringBuilder, 2);
                localStringBuilder.append("audience_membership {\n");
                zza(localStringBuilder, 2, "audience_id", localObject2.zzarl);
                zza(localStringBuilder, 2, "new_audience", localObject2.zzasy);
                zza(localStringBuilder, 2, "current_data", localObject2.zzasw);
                zza(localStringBuilder, 2, "previous_data", localObject2.zzasx);
                zza(localStringBuilder, 2);
                localStringBuilder.append("}\n");
              }
              j += 1;
            }
          }
          arrayOfzzkn = arrayOfzzkn.zzati;
          if (arrayOfzzkn != null)
          {
            int n = arrayOfzzkn.length;
            j = 0;
            while (j < n)
            {
              localObject1 = arrayOfzzkn[j];
              if (localObject1 != null)
              {
                zza(localStringBuilder, 2);
                localStringBuilder.append("event {\n");
                zza(localStringBuilder, 2, "name", zzbj(((zzkn)localObject1).name));
                zza(localStringBuilder, 2, "timestamp_millis", ((zzkn)localObject1).zzatb);
                zza(localStringBuilder, 2, "previous_timestamp_millis", ((zzkn)localObject1).zzatc);
                zza(localStringBuilder, 2, "count", ((zzkn)localObject1).count);
                localObject1 = ((zzkn)localObject1).zzata;
                if (localObject1 != null)
                {
                  int i1 = localObject1.length;
                  k = 0;
                  while (k < i1)
                  {
                    localObject2 = localObject1[k];
                    if (localObject2 != null)
                    {
                      zza(localStringBuilder, 3);
                      localStringBuilder.append("param {\n");
                      zza(localStringBuilder, 3, "name", zzbk(localObject2.name));
                      zza(localStringBuilder, 3, "string_value", localObject2.zzajf);
                      zza(localStringBuilder, 3, "int_value", localObject2.zzate);
                      zza(localStringBuilder, 3, "double_value", localObject2.zzarc);
                      zza(localStringBuilder, 3);
                      localStringBuilder.append("}\n");
                    }
                    k += 1;
                  }
                }
                zza(localStringBuilder, 2);
                localStringBuilder.append("}\n");
              }
              j += 1;
            }
          }
          zza(localStringBuilder, 1);
          localStringBuilder.append("}\n");
        }
        i += 1;
      }
    }
    localStringBuilder.append("}\n");
    paramzzkp = localStringBuilder.toString();
    AppMethodBeat.o(68841);
    return paramzzkp;
  }
  
  protected final String zzb(Bundle paramBundle)
  {
    AppMethodBeat.i(68840);
    if (paramBundle == null)
    {
      AppMethodBeat.o(68840);
      return null;
    }
    if (!zzil())
    {
      paramBundle = paramBundle.toString();
      AppMethodBeat.o(68840);
      return paramBundle;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(", ");
      }
      for (;;)
      {
        localStringBuilder.append(zzbk(str));
        localStringBuilder.append("=");
        localStringBuilder.append(paramBundle.get(str));
        break;
        localStringBuilder.append("Bundle[{");
      }
    }
    localStringBuilder.append("}]");
    paramBundle = localStringBuilder.toString();
    AppMethodBeat.o(68840);
    return paramBundle;
  }
  
  protected final String zzb(zzeu paramzzeu)
  {
    AppMethodBeat.i(68837);
    if (paramzzeu == null)
    {
      AppMethodBeat.o(68837);
      return null;
    }
    if (!zzil())
    {
      paramzzeu = paramzzeu.toString();
      AppMethodBeat.o(68837);
      return paramzzeu;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("origin=");
    localStringBuilder.append(paramzzeu.origin);
    localStringBuilder.append(",name=");
    localStringBuilder.append(zzbj(paramzzeu.name));
    localStringBuilder.append(",params=");
    localStringBuilder.append(zzb(paramzzeu.zzafq));
    paramzzeu = localStringBuilder.toString();
    AppMethodBeat.o(68837);
    return paramzzeu;
  }
  
  protected final String zzbj(String paramString)
  {
    AppMethodBeat.i(68833);
    if (paramString == null)
    {
      AppMethodBeat.o(68833);
      return null;
    }
    if (!zzil())
    {
      AppMethodBeat.o(68833);
      return paramString;
    }
    paramString = zza(paramString, AppMeasurement.Event.zzacy, AppMeasurement.Event.zzacx, zzaij);
    AppMethodBeat.o(68833);
    return paramString;
  }
  
  protected final String zzbk(String paramString)
  {
    AppMethodBeat.i(68834);
    if (paramString == null)
    {
      AppMethodBeat.o(68834);
      return null;
    }
    if (!zzil())
    {
      AppMethodBeat.o(68834);
      return paramString;
    }
    paramString = zza(paramString, AppMeasurement.Param.zzada, AppMeasurement.Param.zzacz, zzaik);
    AppMethodBeat.o(68834);
    return paramString;
  }
  
  protected final String zzbl(String paramString)
  {
    AppMethodBeat.i(68835);
    if (paramString == null)
    {
      AppMethodBeat.o(68835);
      return null;
    }
    if (!zzil())
    {
      AppMethodBeat.o(68835);
      return paramString;
    }
    if (paramString.startsWith("_exp_"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("experiment_id");
      localStringBuilder.append("(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(68835);
      return paramString;
    }
    paramString = zza(paramString, AppMeasurement.UserProperty.zzadc, AppMeasurement.UserProperty.zzadb, zzail);
    AppMethodBeat.o(68835);
    return paramString;
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfe
 * JD-Core Version:    0.7.0.1
 */
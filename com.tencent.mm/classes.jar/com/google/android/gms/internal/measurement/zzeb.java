package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.e.a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzeb
  extends zzjq
{
  zzeb(zzjr paramzzjr)
  {
    super(paramzzjr);
  }
  
  private final Boolean zza(double paramDouble, zzkg paramzzkg)
  {
    AppMethodBeat.i(68589);
    try
    {
      paramzzkg = zza(new BigDecimal(paramDouble), paramzzkg, Math.ulp(paramDouble));
      AppMethodBeat.o(68589);
      return paramzzkg;
    }
    catch (NumberFormatException paramzzkg)
    {
      AppMethodBeat.o(68589);
    }
    return null;
  }
  
  private final Boolean zza(long paramLong, zzkg paramzzkg)
  {
    AppMethodBeat.i(68588);
    try
    {
      paramzzkg = zza(new BigDecimal(paramLong), paramzzkg, 0.0D);
      AppMethodBeat.o(68588);
      return paramzzkg;
    }
    catch (NumberFormatException paramzzkg)
    {
      AppMethodBeat.o(68588);
    }
    return null;
  }
  
  @VisibleForTesting
  private static Boolean zza(Boolean paramBoolean, boolean paramBoolean1)
  {
    AppMethodBeat.i(68585);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(68585);
      return null;
    }
    boolean bool = paramBoolean.booleanValue();
    AppMethodBeat.o(68585);
    return Boolean.valueOf(bool ^ paramBoolean1);
  }
  
  private final Boolean zza(String paramString1, int paramInt, boolean paramBoolean, String paramString2, List<String> paramList, String paramString3)
  {
    AppMethodBeat.i(68587);
    if (paramString1 == null)
    {
      AppMethodBeat.o(68587);
      return null;
    }
    if (paramInt == 6)
    {
      if ((paramList == null) || (paramList.size() == 0))
      {
        AppMethodBeat.o(68587);
        return null;
      }
    }
    else if (paramString2 == null)
    {
      AppMethodBeat.o(68587);
      return null;
    }
    String str = paramString1;
    if (!paramBoolean) {
      if (paramInt != 1) {
        break label119;
      }
    }
    label119:
    for (str = paramString1;; str = paramString1.toUpperCase(Locale.ENGLISH)) {
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(68587);
        return null;
      }
    }
    if (paramBoolean) {}
    for (paramInt = 0;; paramInt = 66) {
      try
      {
        paramBoolean = Pattern.compile(paramString3, paramInt).matcher(str).matches();
        AppMethodBeat.o(68587);
        return Boolean.valueOf(paramBoolean);
      }
      catch (PatternSyntaxException paramString1)
      {
        zzge().zzip().zzg("Invalid regular expression in REGEXP audience filter. expression", paramString3);
        AppMethodBeat.o(68587);
        return null;
      }
    }
    paramBoolean = str.startsWith(paramString2);
    AppMethodBeat.o(68587);
    return Boolean.valueOf(paramBoolean);
    paramBoolean = str.endsWith(paramString2);
    AppMethodBeat.o(68587);
    return Boolean.valueOf(paramBoolean);
    paramBoolean = str.contains(paramString2);
    AppMethodBeat.o(68587);
    return Boolean.valueOf(paramBoolean);
    paramBoolean = str.equals(paramString2);
    AppMethodBeat.o(68587);
    return Boolean.valueOf(paramBoolean);
    paramBoolean = paramList.contains(str);
    AppMethodBeat.o(68587);
    return Boolean.valueOf(paramBoolean);
  }
  
  private final Boolean zza(String paramString, zzkg paramzzkg)
  {
    AppMethodBeat.i(68590);
    if (!zzka.zzck(paramString))
    {
      AppMethodBeat.o(68590);
      return null;
    }
    try
    {
      paramString = zza(new BigDecimal(paramString), paramzzkg, 0.0D);
      AppMethodBeat.o(68590);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(68590);
    }
    return null;
  }
  
  @VisibleForTesting
  private final Boolean zza(String paramString, zzki paramzzki)
  {
    int i = 0;
    Object localObject = null;
    AppMethodBeat.i(68586);
    Preconditions.checkNotNull(paramzzki);
    if (paramString == null)
    {
      AppMethodBeat.o(68586);
      return null;
    }
    if ((paramzzki.zzash == null) || (paramzzki.zzash.intValue() == 0))
    {
      AppMethodBeat.o(68586);
      return null;
    }
    if (paramzzki.zzash.intValue() == 6)
    {
      if ((paramzzki.zzask == null) || (paramzzki.zzask.length == 0))
      {
        AppMethodBeat.o(68586);
        return null;
      }
    }
    else if (paramzzki.zzasi == null)
    {
      AppMethodBeat.o(68586);
      return null;
    }
    int j = paramzzki.zzash.intValue();
    boolean bool;
    String str;
    if ((paramzzki.zzasj != null) && (paramzzki.zzasj.booleanValue()))
    {
      bool = true;
      if ((!bool) && (j != 1) && (j != 6)) {
        break label198;
      }
      str = paramzzki.zzasi;
      label151:
      if (paramzzki.zzask != null) {
        break label213;
      }
    }
    label198:
    label213:
    String[] arrayOfString;
    for (paramzzki = null;; paramzzki = Arrays.asList(arrayOfString))
    {
      if (j == 1) {
        localObject = str;
      }
      paramString = zza(paramString, j, bool, str, paramzzki, localObject);
      AppMethodBeat.o(68586);
      return paramString;
      bool = false;
      break;
      str = paramzzki.zzasi.toUpperCase(Locale.ENGLISH);
      break label151;
      arrayOfString = paramzzki.zzask;
      if (!bool) {
        break label233;
      }
    }
    label233:
    ArrayList localArrayList = new ArrayList();
    int k = arrayOfString.length;
    for (;;)
    {
      paramzzki = localArrayList;
      if (i >= k) {
        break;
      }
      localArrayList.add(arrayOfString[i].toUpperCase(Locale.ENGLISH));
      i += 1;
    }
  }
  
  @VisibleForTesting
  private static Boolean zza(BigDecimal paramBigDecimal, zzkg paramzzkg, double paramDouble)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    AppMethodBeat.i(68591);
    Preconditions.checkNotNull(paramzzkg);
    if ((paramzzkg.zzarz == null) || (paramzzkg.zzarz.intValue() == 0))
    {
      AppMethodBeat.o(68591);
      return null;
    }
    if (paramzzkg.zzarz.intValue() == 4)
    {
      if ((paramzzkg.zzasc == null) || (paramzzkg.zzasd == null))
      {
        AppMethodBeat.o(68591);
        return null;
      }
    }
    else if (paramzzkg.zzasb == null)
    {
      AppMethodBeat.o(68591);
      return null;
    }
    int i = paramzzkg.zzarz.intValue();
    if (paramzzkg.zzarz.intValue() == 4) {
      if ((!zzka.zzck(paramzzkg.zzasc)) || (!zzka.zzck(paramzzkg.zzasd)))
      {
        AppMethodBeat.o(68591);
        return null;
      }
    }
    BigDecimal localBigDecimal1;
    BigDecimal localBigDecimal2;
    for (;;)
    {
      try
      {
        localBigDecimal1 = new BigDecimal(paramzzkg.zzasc);
        paramzzkg = new BigDecimal(paramzzkg.zzasd);
        localBigDecimal2 = null;
        if (i != 4) {
          break;
        }
        if (localBigDecimal1 != null) {
          break label247;
        }
        AppMethodBeat.o(68591);
        return null;
      }
      catch (NumberFormatException paramBigDecimal)
      {
        AppMethodBeat.o(68591);
        return null;
      }
      if (!zzka.zzck(paramzzkg.zzasb))
      {
        AppMethodBeat.o(68591);
        return null;
      }
      try
      {
        localBigDecimal2 = new BigDecimal(paramzzkg.zzasb);
        paramzzkg = null;
        localBigDecimal1 = null;
      }
      catch (NumberFormatException paramBigDecimal)
      {
        AppMethodBeat.o(68591);
        return null;
      }
    }
    if (localBigDecimal2 != null) {}
    switch (i)
    {
    default: 
      AppMethodBeat.o(68591);
      return null;
    case 1: 
      if (paramBigDecimal.compareTo(localBigDecimal2) == -1) {}
      for (;;)
      {
        AppMethodBeat.o(68591);
        return Boolean.valueOf(bool1);
        bool1 = false;
      }
    case 2: 
      if (paramBigDecimal.compareTo(localBigDecimal2) == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        AppMethodBeat.o(68591);
        return Boolean.valueOf(bool1);
      }
    case 3: 
      label247:
      if (paramDouble != 0.0D)
      {
        if ((paramBigDecimal.compareTo(localBigDecimal2.subtract(new BigDecimal(paramDouble).multiply(new BigDecimal(2)))) == 1) && (paramBigDecimal.compareTo(localBigDecimal2.add(new BigDecimal(paramDouble).multiply(new BigDecimal(2)))) == -1)) {}
        for (bool1 = bool3;; bool1 = false)
        {
          AppMethodBeat.o(68591);
          return Boolean.valueOf(bool1);
        }
      }
      if (paramBigDecimal.compareTo(localBigDecimal2) == 0) {}
      for (bool1 = bool4;; bool1 = false)
      {
        AppMethodBeat.o(68591);
        return Boolean.valueOf(bool1);
      }
    }
    if ((paramBigDecimal.compareTo(localBigDecimal1) != -1) && (paramBigDecimal.compareTo(paramzzkg) != 1)) {}
    for (bool1 = bool5;; bool1 = false)
    {
      AppMethodBeat.o(68591);
      return Boolean.valueOf(bool1);
    }
  }
  
  final zzkm[] zza(String paramString, zzkn[] paramArrayOfzzkn, zzks[] paramArrayOfzzks)
  {
    AppMethodBeat.i(68584);
    Preconditions.checkNotEmpty(paramString);
    HashSet localHashSet = new HashSet();
    a locala1 = new a();
    a locala2 = new a();
    a locala3 = new a();
    Object localObject4 = zzix().zzbf(paramString);
    Object localObject5;
    int j;
    Object localObject6;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    int i;
    if (localObject4 != null)
    {
      localObject5 = ((Map)localObject4).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        j = ((Integer)((Iterator)localObject5).next()).intValue();
        localObject6 = (zzkr)((Map)localObject4).get(Integer.valueOf(j));
        localObject3 = (BitSet)locala2.get(Integer.valueOf(j));
        localObject2 = (BitSet)locala3.get(Integer.valueOf(j));
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = new BitSet();
          locala2.put(Integer.valueOf(j), localObject1);
          localObject2 = new BitSet();
          locala3.put(Integer.valueOf(j), localObject2);
        }
        i = 0;
        while (i < ((zzkr)localObject6).zzauk.length << 6)
        {
          if (zzka.zza(((zzkr)localObject6).zzauk, i))
          {
            zzge().zzit().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(j), Integer.valueOf(i));
            ((BitSet)localObject2).set(i);
            if (zzka.zza(((zzkr)localObject6).zzaul, i)) {
              ((BitSet)localObject1).set(i);
            }
          }
          i += 1;
        }
        localObject3 = new zzkm();
        locala1.put(Integer.valueOf(j), localObject3);
        ((zzkm)localObject3).zzasy = Boolean.FALSE;
        ((zzkm)localObject3).zzasx = ((zzkr)localObject6);
        ((zzkm)localObject3).zzasw = new zzkr();
        ((zzkm)localObject3).zzasw.zzaul = zzka.zza((BitSet)localObject1);
        ((zzkm)localObject3).zzasw.zzauk = zzka.zza((BitSet)localObject2);
      }
    }
    long l1;
    Object localObject11;
    label473:
    int k;
    label492:
    Object localObject7;
    if (paramArrayOfzzkn != null)
    {
      localObject2 = null;
      l1 = 0L;
      localObject3 = null;
      localObject11 = new a();
      int n = paramArrayOfzzkn.length;
      j = 0;
      if (j < n)
      {
        localObject6 = paramArrayOfzzkn[j];
        localObject4 = ((zzkn)localObject6).name;
        localObject1 = ((zzkn)localObject6).zzata;
        if (!zzgg().zzd(paramString, zzew.zzahv)) {
          break label4125;
        }
        zzgb();
        localObject5 = (Long)zzka.zzb((zzkn)localObject6, "_eid");
        if (localObject5 != null)
        {
          i = 1;
          if ((i == 0) || (!((String)localObject4).equals("_ep"))) {
            break label553;
          }
          k = 1;
          if (k == 0) {
            break label1218;
          }
          zzgb();
          localObject4 = (String)zzka.zzb((zzkn)localObject6, "_en");
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            break label559;
          }
          zzge().zzim().zzg("Extra parameter without an event name. eventId", localObject5);
        }
        for (;;)
        {
          j += 1;
          break;
          i = 0;
          break label473;
          label553:
          k = 0;
          break label492;
          label559:
          if ((localObject2 != null) && (localObject3 != null) && (((Long)localObject5).longValue() == ((Long)localObject3).longValue())) {
            break label4148;
          }
          localObject7 = zzix().zza(paramString, (Long)localObject5);
          if ((localObject7 != null) && (((Pair)localObject7).first != null)) {
            break label628;
          }
          zzge().zzim().zze("Extra parameter without existing main event. eventName, eventId", localObject4, localObject5);
        }
        label628:
        localObject2 = (zzkn)((Pair)localObject7).first;
        l1 = ((Long)((Pair)localObject7).second).longValue();
        zzgb();
        localObject3 = (Long)zzka.zzb((zzkn)localObject2, "_eid");
        l1 -= 1L;
        if (l1 <= 0L)
        {
          localObject5 = zzix();
          ((zzhg)localObject5).zzab();
          ((zzhg)localObject5).zzge().zzit().zzg("Clearing complex main event info. appId", paramString);
        }
      }
    }
    label934:
    label1218:
    label1736:
    label4169:
    label4172:
    for (;;)
    {
      int i1;
      Object localObject9;
      int m;
      try
      {
        ((zzei)localObject5).getWritableDatabase().execSQL("delete from main_event_params where app_id=?", new String[] { paramString });
        localObject5 = new zzko[((zzkn)localObject2).zzata.length + localObject1.length];
        i = 0;
        localObject7 = ((zzkn)localObject2).zzata;
        i1 = localObject7.length;
        k = 0;
        if (k >= i1) {
          break label857;
        }
        localObject9 = localObject7[k];
        zzgb();
        if (zzka.zza((zzkn)localObject6, ((zzko)localObject9).name) != null) {
          break label4172;
        }
        m = i + 1;
        localObject5[i] = localObject9;
        i = m;
        k += 1;
        continue;
      }
      catch (SQLiteException localSQLiteException)
      {
        ((zzhg)localObject5).zzge().zzim().zzg("Error clearing complex main event", localSQLiteException);
        continue;
      }
      zzix().zza(paramString, (Long)localObject5, l1, (zzkn)localObject2);
      continue;
      label857:
      label1009:
      long l2;
      if (i > 0)
      {
        m = localObject1.length;
        k = 0;
        while (k < m)
        {
          localObject5[i] = localObject1[k];
          k += 1;
          i += 1;
        }
        if (i == localObject5.length)
        {
          localObject1 = localObject5;
          localObject5 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject5;
          localObject5 = localObject4;
          localObject4 = localObject1;
          localObject1 = zzix().zzf(paramString, ((zzkn)localObject6).name);
          if (localObject1 != null) {
            break label1357;
          }
          zzge().zzip().zze("Event aggregate wasn't created during raw event logging. appId, event", zzfg.zzbm(paramString), zzga().zzbj((String)localObject5));
          localObject1 = new zzeq(paramString, ((zzkn)localObject6).name, 1L, 1L, ((zzkn)localObject6).zzatb.longValue(), 0L, null, null, null);
          zzix().zza((zzeq)localObject1);
          l2 = ((zzeq)localObject1).zzafr;
          localObject6 = (Map)((Map)localObject11).get(localObject5);
          if (localObject6 != null) {
            break label4169;
          }
          localObject6 = zzix().zzk(paramString, (String)localObject5);
          localObject1 = localObject6;
          if (localObject6 == null) {
            localObject1 = new a();
          }
          ((Map)localObject11).put(localObject5, localObject1);
          localObject6 = localObject1;
        }
      }
      for (;;)
      {
        Iterator localIterator1 = ((Map)localObject6).keySet().iterator();
        label1357:
        for (;;)
        {
          label1104:
          if (localIterator1.hasNext())
          {
            m = ((Integer)localIterator1.next()).intValue();
            if (localHashSet.contains(Integer.valueOf(m)))
            {
              zzge().zzit().zzg("Skipping failed audience ID", Integer.valueOf(m));
              continue;
              localObject1 = (zzko[])Arrays.copyOf((Object[])localObject5, i);
              break;
              zzge().zzip().zzg("No unique parameters in main event. eventName", localObject4);
              localObject5 = localObject4;
              localObject8 = localObject2;
              localObject4 = localObject1;
              localObject2 = localObject3;
              localObject3 = localObject8;
              break label934;
              if (i == 0) {
                break label4125;
              }
              zzgb();
              localObject2 = Long.valueOf(0L);
              localObject3 = zzka.zzb((zzkn)localObject6, "_epc");
              if (localObject3 == null) {}
              for (;;)
              {
                l1 = ((Long)localObject2).longValue();
                if (l1 > 0L) {
                  break label1315;
                }
                zzge().zzip().zzg("Complex event with zero extra param count. eventName", localObject4);
                localObject2 = localObject4;
                localObject8 = localObject5;
                localObject3 = localObject6;
                localObject4 = localObject1;
                localObject5 = localObject2;
                localObject2 = localObject8;
                break;
                localObject2 = localObject3;
              }
              zzix().zza(paramString, (Long)localObject5, l1, (zzkn)localObject6);
              localObject2 = localObject4;
              localObject8 = localObject5;
              localObject3 = localObject6;
              localObject4 = localObject1;
              localObject5 = localObject2;
              localObject2 = localObject8;
              break label934;
              localObject1 = ((zzeq)localObject1).zzie();
              break label1009;
            }
            localObject1 = (zzkm)locala1.get(Integer.valueOf(m));
            localObject9 = (BitSet)locala2.get(Integer.valueOf(m));
            Object localObject8 = (BitSet)locala3.get(Integer.valueOf(m));
            if (localObject1 == null)
            {
              localObject1 = new zzkm();
              locala1.put(Integer.valueOf(m), localObject1);
              ((zzkm)localObject1).zzasy = Boolean.TRUE;
              localObject9 = new BitSet();
              locala2.put(Integer.valueOf(m), localObject9);
              localObject8 = new BitSet();
              locala3.put(Integer.valueOf(m), localObject8);
            }
            for (;;)
            {
              Iterator localIterator2 = ((List)((Map)localObject6).get(Integer.valueOf(m))).iterator();
              Object localObject10;
              while (localIterator2.hasNext())
              {
                zzke localzzke = (zzke)localIterator2.next();
                if (zzge().isLoggable(2))
                {
                  zzge().zzit().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(m), localzzke.zzarp, zzga().zzbj(localzzke.zzarq));
                  zzge().zzit().zzg("Filter definition", zzga().zza(localzzke));
                }
                if ((localzzke.zzarp == null) || (localzzke.zzarp.intValue() > 256))
                {
                  zzge().zzip().zze("Invalid event filter ID. appId, id", zzfg.zzbm(paramString), String.valueOf(localzzke.zzarp));
                }
                else if (((BitSet)localObject9).get(localzzke.zzarp.intValue()))
                {
                  zzge().zzit().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(m), localzzke.zzarp);
                }
                else
                {
                  Object localObject12;
                  if (localzzke.zzart != null)
                  {
                    localObject1 = zza(l2, localzzke.zzart);
                    if (localObject1 == null)
                    {
                      localObject1 = null;
                      localObject12 = zzge().zzit();
                      if (localObject1 != null) {
                        break label2694;
                      }
                    }
                  }
                  for (localObject10 = "null";; localObject10 = localObject1)
                  {
                    ((zzfi)localObject12).zzg("Event filter result", localObject10);
                    if (localObject1 != null) {
                      break label2701;
                    }
                    localHashSet.add(Integer.valueOf(m));
                    break;
                    if (!((Boolean)localObject1).booleanValue())
                    {
                      localObject1 = Boolean.FALSE;
                      break label1736;
                    }
                    localObject1 = new HashSet();
                    localObject10 = localzzke.zzarr;
                    k = localObject10.length;
                    i = 0;
                    for (;;)
                    {
                      if (i >= k) {
                        break label1901;
                      }
                      localObject12 = localObject10[i];
                      if (TextUtils.isEmpty(((zzkf)localObject12).zzary))
                      {
                        zzge().zzip().zzg("null or empty param name in filter. event", zzga().zzbj((String)localObject5));
                        localObject1 = null;
                        break;
                      }
                      ((Set)localObject1).add(((zzkf)localObject12).zzary);
                      i += 1;
                    }
                    label1901:
                    localObject10 = new a();
                    k = localObject4.length;
                    i = 0;
                    if (i < k)
                    {
                      localObject12 = localObject4[i];
                      if (((Set)localObject1).contains(((zzko)localObject12).name))
                      {
                        if (((zzko)localObject12).zzate == null) {
                          break label1982;
                        }
                        ((Map)localObject10).put(((zzko)localObject12).name, ((zzko)localObject12).zzate);
                      }
                      for (;;)
                      {
                        i += 1;
                        break;
                        if (((zzko)localObject12).zzarc != null)
                        {
                          ((Map)localObject10).put(((zzko)localObject12).name, ((zzko)localObject12).zzarc);
                        }
                        else
                        {
                          if (((zzko)localObject12).zzajf == null) {
                            break label2040;
                          }
                          ((Map)localObject10).put(((zzko)localObject12).name, ((zzko)localObject12).zzajf);
                        }
                      }
                      label2040:
                      zzge().zzip().zze("Unknown value for param. event, param", zzga().zzbj((String)localObject5), zzga().zzbk(((zzko)localObject12).name));
                      localObject1 = null;
                      break label1736;
                    }
                    localObject12 = localzzke.zzarr;
                    i1 = localObject12.length;
                    i = 0;
                    for (;;)
                    {
                      if (i >= i1) {
                        break label2686;
                      }
                      localObject1 = localObject12[i];
                      int i2 = Boolean.TRUE.equals(((zzkf)localObject1).zzarx);
                      String str = ((zzkf)localObject1).zzary;
                      if (TextUtils.isEmpty(str))
                      {
                        zzge().zzip().zzg("Event has empty param name. event", zzga().zzbj((String)localObject5));
                        localObject1 = null;
                        break;
                      }
                      Object localObject13 = ((Map)localObject10).get(str);
                      if ((localObject13 instanceof Long))
                      {
                        if (((zzkf)localObject1).zzarw == null)
                        {
                          zzge().zzip().zze("No number filter for long param. event, param", zzga().zzbj((String)localObject5), zzga().zzbk(str));
                          localObject1 = null;
                          break;
                        }
                        localObject1 = zza(((Long)localObject13).longValue(), ((zzkf)localObject1).zzarw);
                        if (localObject1 == null)
                        {
                          localObject1 = null;
                          break;
                        }
                        if (!((Boolean)localObject1).booleanValue()) {}
                        for (k = 1;; k = 0)
                        {
                          if ((k ^ i2) == 0) {
                            break label2677;
                          }
                          localObject1 = Boolean.FALSE;
                          break;
                        }
                      }
                      if ((localObject13 instanceof Double))
                      {
                        if (((zzkf)localObject1).zzarw == null)
                        {
                          zzge().zzip().zze("No number filter for double param. event, param", zzga().zzbj((String)localObject5), zzga().zzbk(str));
                          localObject1 = null;
                          break;
                        }
                        localObject1 = zza(((Double)localObject13).doubleValue(), ((zzkf)localObject1).zzarw);
                        if (localObject1 == null)
                        {
                          localObject1 = null;
                          break;
                        }
                        if (!((Boolean)localObject1).booleanValue()) {}
                        for (k = 1;; k = 0)
                        {
                          if ((k ^ i2) == 0) {
                            break label2677;
                          }
                          localObject1 = Boolean.FALSE;
                          break;
                        }
                      }
                      if ((localObject13 instanceof String))
                      {
                        if (((zzkf)localObject1).zzarv != null) {
                          localObject1 = zza((String)localObject13, ((zzkf)localObject1).zzarv);
                        }
                        for (;;)
                        {
                          if (localObject1 == null)
                          {
                            localObject1 = null;
                            break;
                            if (((zzkf)localObject1).zzarw != null)
                            {
                              if (zzka.zzck((String)localObject13))
                              {
                                localObject1 = zza((String)localObject13, ((zzkf)localObject1).zzarw);
                                continue;
                              }
                              zzge().zzip().zze("Invalid param value for number filter. event, param", zzga().zzbj((String)localObject5), zzga().zzbk(str));
                              localObject1 = null;
                              break;
                            }
                            zzge().zzip().zze("No filter for String param. event, param", zzga().zzbj((String)localObject5), zzga().zzbk(str));
                            localObject1 = null;
                            break;
                          }
                        }
                        if (!((Boolean)localObject1).booleanValue()) {}
                        for (k = 1;; k = 0)
                        {
                          if ((k ^ i2) == 0) {
                            break label2677;
                          }
                          localObject1 = Boolean.FALSE;
                          break;
                        }
                      }
                      if (localObject13 == null)
                      {
                        zzge().zzit().zze("Missing param for filter. event, param", zzga().zzbj((String)localObject5), zzga().zzbk(str));
                        localObject1 = Boolean.FALSE;
                        break;
                      }
                      zzge().zzip().zze("Unknown param type. event, param", zzga().zzbj((String)localObject5), zzga().zzbk(str));
                      localObject1 = null;
                      break;
                      label2677:
                      i += 1;
                    }
                    label2686:
                    localObject1 = Boolean.TRUE;
                    break label1736;
                  }
                  ((BitSet)localObject8).set(localzzke.zzarp.intValue());
                  if (((Boolean)localObject1).booleanValue()) {
                    ((BitSet)localObject9).set(localzzke.zzarp.intValue());
                  }
                }
              }
              break label1104;
              if (paramArrayOfzzks != null)
              {
                localObject5 = new a();
                j = paramArrayOfzzks.length;
                i = 0;
                if (i < j)
                {
                  localObject6 = paramArrayOfzzks[i];
                  localObject1 = (Map)((Map)localObject5).get(((zzks)localObject6).name);
                  if (localObject1 != null) {
                    break label4122;
                  }
                  localObject1 = zzix().zzl(paramString, ((zzks)localObject6).name);
                  paramArrayOfzzkn = (zzkn[])localObject1;
                  if (localObject1 == null) {
                    paramArrayOfzzkn = new a();
                  }
                  ((Map)localObject5).put(((zzks)localObject6).name, paramArrayOfzzkn);
                  localObject1 = paramArrayOfzzkn;
                }
              }
              for (;;)
              {
                localObject8 = ((Map)localObject1).keySet().iterator();
                label3301:
                label3711:
                while (((Iterator)localObject8).hasNext())
                {
                  k = ((Integer)((Iterator)localObject8).next()).intValue();
                  if (localHashSet.contains(Integer.valueOf(k)))
                  {
                    zzge().zzit().zzg("Skipping failed audience ID", Integer.valueOf(k));
                  }
                  else
                  {
                    paramArrayOfzzkn = (zzkm)locala1.get(Integer.valueOf(k));
                    localObject2 = (BitSet)locala2.get(Integer.valueOf(k));
                    localObject3 = (BitSet)locala3.get(Integer.valueOf(k));
                    if (paramArrayOfzzkn == null)
                    {
                      paramArrayOfzzkn = new zzkm();
                      locala1.put(Integer.valueOf(k), paramArrayOfzzkn);
                      paramArrayOfzzkn.zzasy = Boolean.TRUE;
                      localObject2 = new BitSet();
                      locala2.put(Integer.valueOf(k), localObject2);
                      localObject3 = new BitSet();
                      locala3.put(Integer.valueOf(k), localObject3);
                    }
                    localObject9 = ((List)((Map)localObject1).get(Integer.valueOf(k))).iterator();
                    for (;;)
                    {
                      if (!((Iterator)localObject9).hasNext()) {
                        break label3711;
                      }
                      localObject10 = (zzkh)((Iterator)localObject9).next();
                      if (zzge().isLoggable(2))
                      {
                        zzge().zzit().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(k), ((zzkh)localObject10).zzarp, zzga().zzbl(((zzkh)localObject10).zzasf));
                        zzge().zzit().zzg("Filter definition", zzga().zza((zzkh)localObject10));
                      }
                      if ((((zzkh)localObject10).zzarp == null) || (((zzkh)localObject10).zzarp.intValue() > 256))
                      {
                        zzge().zzip().zze("Invalid property filter ID. appId, id", zzfg.zzbm(paramString), String.valueOf(((zzkh)localObject10).zzarp));
                        localHashSet.add(Integer.valueOf(k));
                        break;
                      }
                      if (((BitSet)localObject2).get(((zzkh)localObject10).zzarp.intValue()))
                      {
                        zzge().zzit().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(k), ((zzkh)localObject10).zzarp);
                      }
                      else
                      {
                        paramArrayOfzzkn = ((zzkh)localObject10).zzasg;
                        if (paramArrayOfzzkn == null)
                        {
                          zzge().zzip().zzg("Missing property filter. property", zzga().zzbl(((zzks)localObject6).name));
                          paramArrayOfzzkn = null;
                          localObject11 = zzge().zzit();
                          if (paramArrayOfzzkn != null) {
                            break label3671;
                          }
                        }
                        for (localObject4 = "null";; localObject4 = paramArrayOfzzkn)
                        {
                          ((zzfi)localObject11).zzg("Property filter result", localObject4);
                          if (paramArrayOfzzkn != null) {
                            break label3677;
                          }
                          localHashSet.add(Integer.valueOf(k));
                          break;
                          boolean bool = Boolean.TRUE.equals(paramArrayOfzzkn.zzarx);
                          if (((zzks)localObject6).zzate != null)
                          {
                            if (paramArrayOfzzkn.zzarw == null)
                            {
                              zzge().zzip().zzg("No number filter for long property. property", zzga().zzbl(((zzks)localObject6).name));
                              paramArrayOfzzkn = null;
                              break label3301;
                            }
                            paramArrayOfzzkn = zza(zza(((zzks)localObject6).zzate.longValue(), paramArrayOfzzkn.zzarw), bool);
                            break label3301;
                          }
                          if (((zzks)localObject6).zzarc != null)
                          {
                            if (paramArrayOfzzkn.zzarw == null)
                            {
                              zzge().zzip().zzg("No number filter for double property. property", zzga().zzbl(((zzks)localObject6).name));
                              paramArrayOfzzkn = null;
                              break label3301;
                            }
                            paramArrayOfzzkn = zza(zza(((zzks)localObject6).zzarc.doubleValue(), paramArrayOfzzkn.zzarw), bool);
                            break label3301;
                          }
                          if (((zzks)localObject6).zzajf != null)
                          {
                            if (paramArrayOfzzkn.zzarv == null)
                            {
                              if (paramArrayOfzzkn.zzarw == null) {
                                zzge().zzip().zzg("No string or number filter defined. property", zzga().zzbl(((zzks)localObject6).name));
                              }
                              for (;;)
                              {
                                paramArrayOfzzkn = null;
                                break;
                                if (zzka.zzck(((zzks)localObject6).zzajf))
                                {
                                  paramArrayOfzzkn = zza(zza(((zzks)localObject6).zzajf, paramArrayOfzzkn.zzarw), bool);
                                  break;
                                }
                                zzge().zzip().zze("Invalid user property value for Numeric number filter. property, value", zzga().zzbl(((zzks)localObject6).name), ((zzks)localObject6).zzajf);
                              }
                            }
                            paramArrayOfzzkn = zza(zza(((zzks)localObject6).zzajf, paramArrayOfzzkn.zzarv), bool);
                            break label3301;
                          }
                          zzge().zzip().zzg("User property has no value, property", zzga().zzbl(((zzks)localObject6).name));
                          paramArrayOfzzkn = null;
                          break label3301;
                        }
                        ((BitSet)localObject3).set(((zzkh)localObject10).zzarp.intValue());
                        if (paramArrayOfzzkn.booleanValue()) {
                          ((BitSet)localObject2).set(((zzkh)localObject10).zzarp.intValue());
                        }
                      }
                    }
                  }
                }
                label3671:
                label3677:
                i += 1;
                break;
                paramArrayOfzzks = new zzkm[locala2.size()];
                localObject1 = locala2.keySet().iterator();
                i = 0;
                while (((Iterator)localObject1).hasNext())
                {
                  k = ((Integer)((Iterator)localObject1).next()).intValue();
                  if (!localHashSet.contains(Integer.valueOf(k)))
                  {
                    paramArrayOfzzkn = (zzkm)locala1.get(Integer.valueOf(k));
                    if (paramArrayOfzzkn != null) {
                      break label4119;
                    }
                    paramArrayOfzzkn = new zzkm();
                  }
                }
                for (;;)
                {
                  for (;;)
                  {
                    j = i + 1;
                    paramArrayOfzzks[i] = paramArrayOfzzkn;
                    paramArrayOfzzkn.zzarl = Integer.valueOf(k);
                    paramArrayOfzzkn.zzasw = new zzkr();
                    paramArrayOfzzkn.zzasw.zzaul = zzka.zza((BitSet)locala2.get(Integer.valueOf(k)));
                    paramArrayOfzzkn.zzasw.zzauk = zzka.zza((BitSet)locala3.get(Integer.valueOf(k)));
                    localObject2 = zzix();
                    localObject3 = paramArrayOfzzkn.zzasw;
                    ((zzjq)localObject2).zzch();
                    ((zzhg)localObject2).zzab();
                    Preconditions.checkNotEmpty(paramString);
                    Preconditions.checkNotNull(localObject3);
                    try
                    {
                      paramArrayOfzzkn = new byte[((zzace)localObject3).zzvm()];
                      localObject4 = zzabw.zzb(paramArrayOfzzkn, 0, paramArrayOfzzkn.length);
                      ((zzace)localObject3).zza((zzabw)localObject4);
                      ((zzabw)localObject4).zzve();
                      localObject3 = new ContentValues();
                      ((ContentValues)localObject3).put("app_id", paramString);
                      ((ContentValues)localObject3).put("audience_id", Integer.valueOf(k));
                      ((ContentValues)localObject3).put("current_results", paramArrayOfzzkn);
                    }
                    catch (IOException paramArrayOfzzkn)
                    {
                      try
                      {
                        if (((zzei)localObject2).getWritableDatabase().insertWithOnConflict("audience_filter_values", null, (ContentValues)localObject3, 5) == -1L) {
                          ((zzhg)localObject2).zzge().zzim().zzg("Failed to insert filter results (got -1). appId", zzfg.zzbm(paramString));
                        }
                        i = j;
                      }
                      catch (SQLiteException paramArrayOfzzkn)
                      {
                        ((zzhg)localObject2).zzge().zzim().zze("Error storing filter results. appId", zzfg.zzbm(paramString), paramArrayOfzzkn);
                        i = j;
                      }
                      paramArrayOfzzkn = paramArrayOfzzkn;
                      ((zzhg)localObject2).zzge().zzim().zze("Configuration loss. Failed to serialize filter results. appId", zzfg.zzbm(paramString), paramArrayOfzzkn);
                      i = j;
                    }
                  }
                  break;
                  break;
                  paramString = (zzkm[])Arrays.copyOf(paramArrayOfzzks, i);
                  AppMethodBeat.o(68584);
                  return paramString;
                }
              }
              localObject5 = localObject4;
              localObject8 = localObject2;
              localObject4 = localObject1;
              localObject2 = localObject3;
              localObject3 = localObject8;
              break label934;
              break;
            }
          }
        }
        localObject1 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject1;
        break;
      }
    }
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzeb
 * JD-Core Version:    0.7.0.1
 */
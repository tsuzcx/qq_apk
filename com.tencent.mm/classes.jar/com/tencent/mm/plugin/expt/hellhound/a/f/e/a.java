package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static WeakReference<Object> qQG;
  private static final Map<Integer, WeakReference<Activity>> qZl;
  
  static
  {
    AppMethodBeat.i(122193);
    qZl = new HashMap();
    qQG = null;
    AppMethodBeat.o(122193);
  }
  
  @SuppressLint({"NewApi"})
  public static void Dn(int paramInt)
  {
    AppMethodBeat.i(122183);
    Object localObject = (WeakReference)qZl.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = (Activity)((WeakReference)localObject).get();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(122183);
      return;
    }
    if (((Activity)localObject).isDestroyed())
    {
      AppMethodBeat.o(122183);
      return;
    }
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk != null) {
      a(localObject, localchk, true);
    }
    AppMethodBeat.o(122183);
  }
  
  @SuppressLint({"NewApi"})
  public static void Do(int paramInt)
  {
    AppMethodBeat.i(122184);
    Object localObject = (WeakReference)qZl.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = (Activity)((WeakReference)localObject).get();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(122184);
      return;
    }
    if (((Activity)localObject).isDestroyed())
    {
      AppMethodBeat.o(122184);
      return;
    }
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk != null)
    {
      ad.i("HABBYGE-MALI.HellPageParamsCatcher", "catchOnActivityFinishAsync: %s", new Object[] { localchk.sessionId });
      a(localObject, localchk, false);
    }
    AppMethodBeat.o(122184);
  }
  
  private static void a(Object paramObject, chk paramchk, boolean paramBoolean)
  {
    AppMethodBeat.i(122189);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.d.cpU();
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.cpV();
    if (localObject == null)
    {
      ad.e("HABBYGE-MALI.HellPageParamsCatcher", "HellPageParamsCatcher, _doCatchOnActivity, config is NULL !!");
      AppMethodBeat.o(122189);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramchk.sessionId);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeN(paramchk.sessionId)) {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.g(paramchk);
    }
    for (;;)
    {
      localObject = ((dbj)localObject).Hrc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dbm localdbm = (dbm)((Iterator)localObject).next();
        if ((localdbm != null) && ((localdbm.qXk.equals(str)) || ("-1".equals(localdbm.qXk)))) {
          a(paramObject, localdbm, paramchk, paramBoolean);
        }
      }
      AppMethodBeat.o(122189);
      return;
    }
  }
  
  private static void a(Object paramObject, dbi paramdbi1, dbi paramdbi2, String paramString, chk paramchk, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169354);
    if (paramBoolean)
    {
      if (paramdbi2.dtL.equals(paramString))
      {
        a(paramObject, paramdbi2, paramchk.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramdbi1.dtL.equals(paramString))
      {
        a(paramObject, paramdbi1, paramchk.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
      }
    }
    else
    {
      if (paramdbi2.dtL.equals(paramString))
      {
        a(paramObject, paramdbi2, paramchk.sessionId, paramLong, false);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramdbi1.dtL.equals(paramString)) {
        a(paramObject, paramdbi1, paramchk.sessionId, paramLong, false);
      }
    }
    AppMethodBeat.o(169354);
  }
  
  private static void a(Object paramObject, dbi paramdbi, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169355);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.d.ai(paramString, paramLong);
    if (localObject == null)
    {
      ad.e("HABBYGE-MALI.HellPageParamsCatcher", "HABBYGE0-MALI, _setBizParams4FuzzyPath, FuzzyMatchDao.getPaths NULL");
      AppMethodBeat.o(169355);
      return;
    }
    auc localauc = (auc)((Pair)localObject).first;
    int i = ((Integer)((Pair)localObject).second).intValue();
    paramdbi = paramdbi.Hra.iterator();
    while (paramdbi.hasNext())
    {
      localObject = (chj)paramdbi.next();
      if (localObject != null) {
        b.a(paramObject, (chj)localObject, localauc, paramBoolean);
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.d.d.a(paramString, localauc, i);
    AppMethodBeat.o(169355);
  }
  
  private static void a(Object paramObject, dbi paramdbi, String paramString, chk paramchk, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169353);
    if (paramBoolean)
    {
      if (paramdbi.dtL.equals(paramString))
      {
        a(paramObject, paramdbi, paramchk.sessionId, paramLong, true);
        AppMethodBeat.o(169353);
      }
    }
    else if (paramdbi.dtL.equals(paramString)) {
      a(paramObject, paramdbi, paramchk.sessionId, paramLong, false);
    }
    AppMethodBeat.o(169353);
  }
  
  private static void a(Object paramObject, dbm paramdbm, chk paramchk, boolean paramBoolean)
  {
    AppMethodBeat.i(169351);
    String str = paramObject.getClass().getCanonicalName();
    int j = paramdbm.Hrg.size();
    if (j == 1)
    {
      b(paramObject, paramdbm, paramchk, paramBoolean);
      AppMethodBeat.o(169351);
      return;
    }
    int i = 1;
    while (i < j)
    {
      dbi localdbi1 = (dbi)paramdbm.Hrg.get(i - 1);
      dbi localdbi2 = (dbi)paramdbm.Hrg.get(i);
      if ((localdbi1 != null) && (localdbi2 != null))
      {
        if (paramdbm.type != 0)
        {
          if (paramdbm.type != 1) {
            break label148;
          }
          if (j == 2)
          {
            a(paramObject, localdbi1, localdbi2, str, paramchk, paramdbm.Gsl, paramBoolean);
            AppMethodBeat.o(169351);
            return;
          }
        }
        a(paramObject, str, localdbi1, localdbi2, paramchk, paramBoolean, paramdbm);
      }
      label148:
      i += 1;
    }
    AppMethodBeat.o(169351);
  }
  
  private static void a(Object paramObject, String paramString, dbi paramdbi1, dbi paramdbi2, chk paramchk, boolean paramBoolean, dbm paramdbm)
  {
    AppMethodBeat.i(177398);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.cnD();
    if ((paramdbi2.dtL.equals(paramString)) && (paramdbi1.dtL.equals(str)))
    {
      if (paramdbm.type == 0)
      {
        a(paramObject, paramString, paramdbi2, paramchk.sessionId, paramBoolean);
        AppMethodBeat.o(177398);
        return;
      }
      if (paramdbm.type == 1) {
        a(paramObject, paramdbi2, paramString, paramchk, paramdbm.Gsl, paramBoolean);
      }
    }
    AppMethodBeat.o(177398);
  }
  
  private static void a(Object paramObject, String paramString1, dbi paramdbi, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(169356);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.fX(paramString2, paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(169356);
      return;
    }
    paramString2 = (boc)paramString1.get(0);
    paramdbi = paramdbi.Hra.iterator();
    while (paramdbi.hasNext())
    {
      chj localchj = (chj)paramdbi.next();
      if (localchj != null) {
        b.a(paramObject, localchj, paramString2, false, paramBoolean);
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramString2, ((Integer)paramString1.get(1)).intValue());
    AppMethodBeat.o(169356);
  }
  
  public static void b(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(122185);
    if (paramFragment == null)
    {
      AppMethodBeat.o(122185);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122185);
      return;
      chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
      if (localchk != null) {
        a(paramFragment, localchk, true);
      }
      AppMethodBeat.o(122185);
      return;
      localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
      if (localchk != null) {
        a(paramFragment, localchk, false);
      }
    }
  }
  
  private static void b(Object paramObject, dbm paramdbm, chk paramchk, boolean paramBoolean)
  {
    AppMethodBeat.i(169352);
    dbi localdbi = (dbi)paramdbm.Hrg.get(0);
    if (localdbi == null)
    {
      AppMethodBeat.o(169352);
      return;
    }
    String str = paramObject.getClass().getCanonicalName();
    if (paramdbm.type == 0)
    {
      if (localdbi.dtL.equals(str))
      {
        a(paramObject, str, localdbi, paramchk.sessionId, paramBoolean);
        AppMethodBeat.o(169352);
      }
    }
    else if (paramdbm.type == 1) {
      a(paramObject, localdbi, str, paramchk, paramdbm.Gsl, paramBoolean);
    }
    AppMethodBeat.o(169352);
  }
  
  public static void cX(Object paramObject)
  {
    AppMethodBeat.i(210475);
    if (paramObject != null) {
      qQG = new WeakReference(paramObject);
    }
    AppMethodBeat.o(210475);
  }
  
  public static Object cnA()
  {
    AppMethodBeat.i(210474);
    if (qQG == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.cnB().cnA();
      AppMethodBeat.o(210474);
      return localObject;
    }
    Object localObject = qQG.get();
    AppMethodBeat.o(210474);
    return localObject;
  }
  
  public static void df(String paramString, int paramInt)
  {
    AppMethodBeat.i(210476);
    if (qZl.isEmpty())
    {
      AppMethodBeat.o(210476);
      return;
    }
    if (paramInt > 0) {
      try
      {
        qZl.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(210476);
        return;
      }
      catch (NumberFormatException paramString)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellPageParamsCatcher", paramString, "HellPageParamsCatcher, onDestroy: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(210476);
        return;
      }
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = qZl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        Object localObject = (Activity)((WeakReference)localEntry.getValue()).get();
        if (localObject == null)
        {
          localArrayList.add(localEntry.getKey());
        }
        else
        {
          localObject = localObject.getClass().getCanonicalName();
          if ((localObject != null) && (((String)localObject).equals(paramString))) {
            localArrayList.add(localEntry.getKey());
          }
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        paramInt = ((Integer)paramString.next()).intValue();
        qZl.remove(Integer.valueOf(paramInt));
      }
    }
    AppMethodBeat.o(210476);
  }
  
  public static void f(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(122182);
    if (paramActivity == null)
    {
      AppMethodBeat.o(122182);
      return;
    }
    WeakReference localWeakReference;
    switch (paramInt)
    {
    case 1: 
    default: 
      AppMethodBeat.o(122182);
      return;
    case 0: 
      paramInt = paramActivity.hashCode();
      if (!qZl.containsKey(Integer.valueOf(paramInt)))
      {
        paramActivity = new WeakReference(paramActivity);
        qZl.put(Integer.valueOf(paramInt), paramActivity);
      }
      for (;;)
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(400, Integer.valueOf(paramInt));
        AppMethodBeat.o(122182);
        return;
        localWeakReference = (WeakReference)qZl.get(Integer.valueOf(paramInt));
        if ((localWeakReference == null) || (localWeakReference.get() == null))
        {
          qZl.remove(Integer.valueOf(paramInt));
          paramActivity = new WeakReference(paramActivity);
          qZl.put(Integer.valueOf(paramInt), paramActivity);
        }
      }
    }
    paramInt = paramActivity.hashCode();
    if (!qZl.containsKey(Integer.valueOf(paramInt)))
    {
      paramActivity = new WeakReference(paramActivity);
      qZl.put(Integer.valueOf(paramInt), paramActivity);
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(401, Integer.valueOf(paramInt));
      break;
      localWeakReference = (WeakReference)qZl.get(Integer.valueOf(paramInt));
      if ((localWeakReference == null) || (localWeakReference.get() == null))
      {
        qZl.remove(Integer.valueOf(paramInt));
        paramActivity = new WeakReference(paramActivity);
        qZl.put(Integer.valueOf(paramInt), paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.a
 * JD-Core Version:    0.7.0.1
 */
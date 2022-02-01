package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.protocal.protobuf.dcd;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.sdk.platformtools.ae;
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
  private static WeakReference<Object> qYE;
  private static final Map<Integer, WeakReference<Activity>> rhr;
  
  static
  {
    AppMethodBeat.i(122193);
    rhr = new HashMap();
    qYE = null;
    AppMethodBeat.o(122193);
  }
  
  @SuppressLint({"NewApi"})
  public static void DA(int paramInt)
  {
    AppMethodBeat.i(122183);
    Object localObject = (WeakReference)rhr.get(Integer.valueOf(paramInt));
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
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie != null) {
      a(localObject, localcie, true);
    }
    AppMethodBeat.o(122183);
  }
  
  @SuppressLint({"NewApi"})
  public static void DB(int paramInt)
  {
    AppMethodBeat.i(122184);
    Object localObject = (WeakReference)rhr.get(Integer.valueOf(paramInt));
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
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie != null)
    {
      ae.i("HABBYGE-MALI.HellPageParamsCatcher", "catchOnActivityFinishAsync: %s", new Object[] { localcie.sessionId });
      a(localObject, localcie, false);
    }
    AppMethodBeat.o(122184);
  }
  
  private static void a(Object paramObject, cie paramcie, boolean paramBoolean)
  {
    AppMethodBeat.i(122189);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.d.crw();
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.crx();
    if (localObject == null)
    {
      ae.e("HABBYGE-MALI.HellPageParamsCatcher", "HellPageParamsCatcher, _doCatchOnActivity, config is NULL !!");
      AppMethodBeat.o(122189);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramcie.sessionId);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afJ(paramcie.sessionId)) {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.k(paramcie);
    }
    for (;;)
    {
      localObject = ((dcd)localObject).HKE.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dcg localdcg = (dcg)((Iterator)localObject).next();
        if ((localdcg != null) && ((localdcg.rfp.equals(str)) || ("-1".equals(localdcg.rfp)))) {
          a(paramObject, localdcg, paramcie, paramBoolean);
        }
      }
      AppMethodBeat.o(122189);
      return;
    }
  }
  
  private static void a(Object paramObject, dcc paramdcc1, dcc paramdcc2, String paramString, cie paramcie, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169354);
    if (paramBoolean)
    {
      if (paramdcc2.duQ.equals(paramString))
      {
        a(paramObject, paramdcc2, paramcie.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramdcc1.duQ.equals(paramString))
      {
        a(paramObject, paramdcc1, paramcie.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
      }
    }
    else
    {
      if (paramdcc2.duQ.equals(paramString))
      {
        a(paramObject, paramdcc2, paramcie.sessionId, paramLong, false);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramdcc1.duQ.equals(paramString)) {
        a(paramObject, paramdcc1, paramcie.sessionId, paramLong, false);
      }
    }
    AppMethodBeat.o(169354);
  }
  
  private static void a(Object paramObject, dcc paramdcc, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169355);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.d.ai(paramString, paramLong);
    if (localObject == null)
    {
      ae.e("HABBYGE-MALI.HellPageParamsCatcher", "HABBYGE0-MALI, _setBizParams4FuzzyPath, FuzzyMatchDao.getPaths NULL");
      AppMethodBeat.o(169355);
      return;
    }
    aus localaus = (aus)((Pair)localObject).first;
    int i = ((Integer)((Pair)localObject).second).intValue();
    paramdcc = paramdcc.HKC.iterator();
    while (paramdcc.hasNext())
    {
      localObject = (cid)paramdcc.next();
      if (localObject != null) {
        b.a(paramObject, (cid)localObject, localaus, paramBoolean);
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.d.d.a(paramString, localaus, i);
    AppMethodBeat.o(169355);
  }
  
  private static void a(Object paramObject, dcc paramdcc, String paramString, cie paramcie, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169353);
    if (paramBoolean)
    {
      if (paramdcc.duQ.equals(paramString))
      {
        a(paramObject, paramdcc, paramcie.sessionId, paramLong, true);
        AppMethodBeat.o(169353);
      }
    }
    else if (paramdcc.duQ.equals(paramString)) {
      a(paramObject, paramdcc, paramcie.sessionId, paramLong, false);
    }
    AppMethodBeat.o(169353);
  }
  
  private static void a(Object paramObject, dcg paramdcg, cie paramcie, boolean paramBoolean)
  {
    AppMethodBeat.i(169351);
    String str = paramObject.getClass().getCanonicalName();
    int j = paramdcg.HKI.size();
    if (j == 1)
    {
      b(paramObject, paramdcg, paramcie, paramBoolean);
      AppMethodBeat.o(169351);
      return;
    }
    int i = 1;
    while (i < j)
    {
      dcc localdcc1 = (dcc)paramdcg.HKI.get(i - 1);
      dcc localdcc2 = (dcc)paramdcg.HKI.get(i);
      if ((localdcc1 != null) && (localdcc2 != null))
      {
        if (paramdcg.type != 0)
        {
          if (paramdcg.type != 1) {
            break label148;
          }
          if (j == 2)
          {
            a(paramObject, localdcc1, localdcc2, str, paramcie, paramdcg.GLJ, paramBoolean);
            AppMethodBeat.o(169351);
            return;
          }
        }
        a(paramObject, str, localdcc1, localdcc2, paramcie, paramBoolean, paramdcg);
      }
      label148:
      i += 1;
    }
    AppMethodBeat.o(169351);
  }
  
  private static void a(Object paramObject, String paramString, dcc paramdcc1, dcc paramdcc2, cie paramcie, boolean paramBoolean, dcg paramdcg)
  {
    AppMethodBeat.i(177398);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.cpf();
    if ((paramdcc2.duQ.equals(paramString)) && (paramdcc1.duQ.equals(str)))
    {
      if (paramdcg.type == 0)
      {
        a(paramObject, paramString, paramdcc2, paramcie.sessionId, paramBoolean);
        AppMethodBeat.o(177398);
        return;
      }
      if (paramdcg.type == 1) {
        a(paramObject, paramdcc2, paramString, paramcie, paramdcg.GLJ, paramBoolean);
      }
    }
    AppMethodBeat.o(177398);
  }
  
  private static void a(Object paramObject, String paramString1, dcc paramdcc, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(169356);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.gc(paramString2, paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(169356);
      return;
    }
    paramString2 = (bou)paramString1.get(0);
    paramdcc = paramdcc.HKC.iterator();
    while (paramdcc.hasNext())
    {
      cid localcid = (cid)paramdcc.next();
      if (localcid != null) {
        b.a(paramObject, localcid, paramString2, false, paramBoolean);
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
      cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
      if (localcie != null) {
        a(paramFragment, localcie, true);
      }
      AppMethodBeat.o(122185);
      return;
      localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
      if (localcie != null) {
        a(paramFragment, localcie, false);
      }
    }
  }
  
  private static void b(Object paramObject, dcg paramdcg, cie paramcie, boolean paramBoolean)
  {
    AppMethodBeat.i(169352);
    dcc localdcc = (dcc)paramdcg.HKI.get(0);
    if (localdcc == null)
    {
      AppMethodBeat.o(169352);
      return;
    }
    String str = paramObject.getClass().getCanonicalName();
    if (paramdcg.type == 0)
    {
      if (localdcc.duQ.equals(str))
      {
        a(paramObject, str, localdcc, paramcie.sessionId, paramBoolean);
        AppMethodBeat.o(169352);
      }
    }
    else if (paramdcg.type == 1) {
      a(paramObject, localdcc, str, paramcie, paramdcg.GLJ, paramBoolean);
    }
    AppMethodBeat.o(169352);
  }
  
  public static void cY(Object paramObject)
  {
    AppMethodBeat.i(196142);
    if (paramObject != null) {
      qYE = new WeakReference(paramObject);
    }
    AppMethodBeat.o(196142);
  }
  
  public static Object cpc()
  {
    AppMethodBeat.i(196141);
    if (qYE == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.cpd().cpc();
      AppMethodBeat.o(196141);
      return localObject;
    }
    Object localObject = qYE.get();
    AppMethodBeat.o(196141);
    return localObject;
  }
  
  public static void dj(String paramString, int paramInt)
  {
    AppMethodBeat.i(196143);
    if (rhr.isEmpty())
    {
      AppMethodBeat.o(196143);
      return;
    }
    if (paramInt > 0) {
      try
      {
        rhr.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(196143);
        return;
      }
      catch (NumberFormatException paramString)
      {
        ae.printErrStackTrace("HABBYGE-MALI.HellPageParamsCatcher", paramString, "HellPageParamsCatcher, onDestroy: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(196143);
        return;
      }
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = rhr.entrySet().iterator();
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
        rhr.remove(Integer.valueOf(paramInt));
      }
    }
    AppMethodBeat.o(196143);
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
      if (!rhr.containsKey(Integer.valueOf(paramInt)))
      {
        paramActivity = new WeakReference(paramActivity);
        rhr.put(Integer.valueOf(paramInt), paramActivity);
      }
      for (;;)
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(400, Integer.valueOf(paramInt));
        AppMethodBeat.o(122182);
        return;
        localWeakReference = (WeakReference)rhr.get(Integer.valueOf(paramInt));
        if ((localWeakReference == null) || (localWeakReference.get() == null))
        {
          rhr.remove(Integer.valueOf(paramInt));
          paramActivity = new WeakReference(paramActivity);
          rhr.put(Integer.valueOf(paramInt), paramActivity);
        }
      }
    }
    paramInt = paramActivity.hashCode();
    if (!rhr.containsKey(Integer.valueOf(paramInt)))
    {
      paramActivity = new WeakReference(paramActivity);
      rhr.put(Integer.valueOf(paramInt), paramActivity);
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(401, Integer.valueOf(paramInt));
      break;
      localWeakReference = (WeakReference)rhr.get(Integer.valueOf(paramInt));
      if ((localWeakReference == null) || (localWeakReference.get() == null))
      {
        rhr.remove(Integer.valueOf(paramInt));
        paramActivity = new WeakReference(paramActivity);
        rhr.put(Integer.valueOf(paramInt), paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.platformtools.ac;
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
  private static final Map<Integer, WeakReference<Activity>> qql;
  
  static
  {
    AppMethodBeat.i(122193);
    qql = new HashMap();
    AppMethodBeat.o(122193);
  }
  
  @SuppressLint({"NewApi"})
  public static void CA(int paramInt)
  {
    AppMethodBeat.i(122183);
    Object localObject = (WeakReference)qql.get(Integer.valueOf(paramInt));
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
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs != null) {
      a(localObject, localccs, true);
    }
    AppMethodBeat.o(122183);
  }
  
  @SuppressLint({"NewApi"})
  public static void CB(int paramInt)
  {
    AppMethodBeat.i(122184);
    Object localObject = (WeakReference)qql.get(Integer.valueOf(paramInt));
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
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs != null) {
      a(localObject, localccs, false);
    }
    AppMethodBeat.o(122184);
  }
  
  private static void a(Object paramObject, ccs paramccs, boolean paramBoolean)
  {
    AppMethodBeat.i(122189);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.d.ckF();
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.ckG();
    if (localObject == null)
    {
      ac.e("HABBYGE-MALI.HellPageParamsCatcher", "HellPageParamsCatcher, _doCatchOnActivity, config is NULL !!");
      AppMethodBeat.o(122189);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(paramccs.sessionId);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aba(paramccs.sessionId)) {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.h(paramccs);
    }
    for (;;)
    {
      paramObject.getClass().getCanonicalName();
      localObject = ((cvx)localObject).FGz.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cwa localcwa = (cwa)((Iterator)localObject).next();
        if ((localcwa != null) && ((localcwa.qon.equals(str)) || ("-1".equals(localcwa.qon)))) {
          a(paramObject, localcwa, paramccs, paramBoolean);
        }
      }
      AppMethodBeat.o(122189);
      return;
    }
  }
  
  private static void a(Object paramObject, cvw paramcvw1, cvw paramcvw2, String paramString, ccs paramccs, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169354);
    if (paramBoolean)
    {
      if (paramcvw2.qoi.equals(paramString))
      {
        a(paramObject, paramcvw2, paramccs.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramcvw1.qoi.equals(paramString))
      {
        a(paramObject, paramcvw1, paramccs.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
      }
    }
    else
    {
      if (paramcvw2.qoi.equals(paramString))
      {
        a(paramObject, paramcvw2, paramccs.sessionId, paramLong, false);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramcvw1.qoi.equals(paramString)) {
        a(paramObject, paramcvw1, paramccs.sessionId, paramLong, false);
      }
    }
    AppMethodBeat.o(169354);
  }
  
  private static void a(Object paramObject, cvw paramcvw, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169355);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.d.ad(paramString, paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(169355);
      return;
    }
    aqg localaqg = (aqg)((Pair)localObject).first;
    int i = ((Integer)((Pair)localObject).second).intValue();
    paramcvw = paramcvw.FGy.iterator();
    while (paramcvw.hasNext())
    {
      localObject = (ccr)paramcvw.next();
      if (localObject != null) {
        b.a(paramObject, (ccr)localObject, localaqg, paramBoolean);
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.d.d.a(paramString, localaqg, i);
    AppMethodBeat.o(169355);
  }
  
  private static void a(Object paramObject, cvw paramcvw, String paramString, ccs paramccs, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169353);
    if (paramBoolean)
    {
      if (paramcvw.qoi.equals(paramString))
      {
        a(paramObject, paramcvw, paramccs.sessionId, paramLong, true);
        AppMethodBeat.o(169353);
      }
    }
    else if (paramcvw.qoi.equals(paramString)) {
      a(paramObject, paramcvw, paramccs.sessionId, paramLong, false);
    }
    AppMethodBeat.o(169353);
  }
  
  private static void a(Object paramObject, cwa paramcwa, ccs paramccs, boolean paramBoolean)
  {
    AppMethodBeat.i(169351);
    String str = paramObject.getClass().getCanonicalName();
    int j = paramcwa.FGD.size();
    if (j == 1)
    {
      b(paramObject, paramcwa, paramccs, paramBoolean);
      AppMethodBeat.o(169351);
      return;
    }
    int i = 1;
    while (i < j)
    {
      cvw localcvw1 = (cvw)paramcwa.FGD.get(i - 1);
      cvw localcvw2 = (cvw)paramcwa.FGD.get(i);
      if ((localcvw1 != null) && (localcvw2 != null))
      {
        if (paramcwa.type != 0)
        {
          if (paramcwa.type != 1) {
            break label148;
          }
          if (j == 2)
          {
            a(paramObject, localcvw1, localcvw2, str, paramccs, paramcwa.EJj, paramBoolean);
            AppMethodBeat.o(169351);
            return;
          }
        }
        a(paramObject, str, localcvw1, localcvw2, paramccs, paramBoolean, paramcwa);
      }
      label148:
      i += 1;
    }
    AppMethodBeat.o(169351);
  }
  
  private static void a(Object paramObject, String paramString, cvw paramcvw1, cvw paramcvw2, ccs paramccs, boolean paramBoolean, cwa paramcwa)
  {
    AppMethodBeat.i(177398);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.ciF();
    if ((paramcvw2.qoi.equals(paramString)) && (paramcvw1.qoi.equals(str))) {
      if (paramcwa.type == 0)
      {
        if (paramcvw2.qoi.equals(paramString))
        {
          a(paramObject, paramString, paramcvw2, paramccs.sessionId, paramBoolean);
          AppMethodBeat.o(177398);
        }
      }
      else if (paramcwa.type == 1) {
        a(paramObject, paramcvw2, paramString, paramccs, paramcwa.EJj, paramBoolean);
      }
    }
    AppMethodBeat.o(177398);
  }
  
  private static void a(Object paramObject, String paramString1, cvw paramcvw, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(169356);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.fO(paramString2, paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(169356);
      return;
    }
    paramString2 = (bju)paramString1.get(0);
    paramcvw = paramcvw.FGy.iterator();
    while (paramcvw.hasNext())
    {
      ccr localccr = (ccr)paramcvw.next();
      if (localccr != null) {
        b.a(paramObject, localccr, paramString2, false, paramBoolean);
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
      ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
      if (localccs != null) {
        a(paramFragment, localccs, true);
      }
      AppMethodBeat.o(122185);
      return;
      localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
      if (localccs != null) {
        a(paramFragment, localccs, false);
      }
    }
  }
  
  private static void b(Object paramObject, cwa paramcwa, ccs paramccs, boolean paramBoolean)
  {
    AppMethodBeat.i(169352);
    cvw localcvw = (cvw)paramcwa.FGD.get(0);
    if (localcvw == null)
    {
      AppMethodBeat.o(169352);
      return;
    }
    String str = paramObject.getClass().getCanonicalName();
    if (paramcwa.type == 0)
    {
      if (localcvw.qoi.equals(str))
      {
        a(paramObject, str, localcvw, paramccs.sessionId, paramBoolean);
        AppMethodBeat.o(169352);
      }
    }
    else if (paramcwa.type == 1) {
      a(paramObject, localcvw, str, paramccs, paramcwa.EJj, paramBoolean);
    }
    AppMethodBeat.o(169352);
  }
  
  public static void f(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(122182);
    if (paramActivity == null)
    {
      AppMethodBeat.o(122182);
      return;
    }
    paramActivity.getClass().getCanonicalName();
    WeakReference localWeakReference;
    switch (paramInt)
    {
    case 1: 
    default: 
      AppMethodBeat.o(122182);
      return;
    case 0: 
      paramInt = paramActivity.hashCode();
      if (!qql.containsKey(Integer.valueOf(paramInt)))
      {
        paramActivity = new WeakReference(paramActivity);
        qql.put(Integer.valueOf(paramInt), paramActivity);
      }
      for (;;)
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(400, Integer.valueOf(paramInt));
        AppMethodBeat.o(122182);
        return;
        localWeakReference = (WeakReference)qql.get(Integer.valueOf(paramInt));
        if ((localWeakReference == null) || (localWeakReference.get() == null))
        {
          qql.remove(Integer.valueOf(paramInt));
          paramActivity = new WeakReference(paramActivity);
          qql.put(Integer.valueOf(paramInt), paramActivity);
        }
      }
    }
    paramInt = paramActivity.hashCode();
    if (!qql.containsKey(Integer.valueOf(paramInt)))
    {
      paramActivity = new WeakReference(paramActivity);
      qql.put(Integer.valueOf(paramInt), paramActivity);
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(401, Integer.valueOf(paramInt));
      break;
      localWeakReference = (WeakReference)qql.get(Integer.valueOf(paramInt));
      if ((localWeakReference == null) || (localWeakReference.get() == null))
      {
        qql.remove(Integer.valueOf(paramInt));
        paramActivity = new WeakReference(paramActivity);
        qql.put(Integer.valueOf(paramInt), paramActivity);
      }
    }
  }
  
  public static void fP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122181);
    if (qql.isEmpty())
    {
      AppMethodBeat.o(122181);
      return;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      try
      {
        qql.remove(Integer.valueOf(paramString2));
        AppMethodBeat.o(122181);
        return;
      }
      catch (NumberFormatException paramString1)
      {
        ac.printErrStackTrace("HABBYGE-MALI.HellPageParamsCatcher", paramString1, "HellPageParamsCatcher, onDestroy: %s", new Object[] { paramString1.getMessage() });
        AppMethodBeat.o(122181);
        return;
      }
    }
    paramString2 = new ArrayList();
    Iterator localIterator = qql.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        Object localObject = (Activity)((WeakReference)localEntry.getValue()).get();
        if (localObject == null)
        {
          paramString2.add(localEntry.getKey());
        }
        else
        {
          localObject = localObject.getClass().getCanonicalName();
          if ((localObject != null) && (((String)localObject).equals(paramString1))) {
            paramString2.add(localEntry.getKey());
          }
        }
      }
    }
    if (!paramString2.isEmpty())
    {
      paramString1 = paramString2.iterator();
      while (paramString1.hasNext())
      {
        int i = ((Integer)paramString1.next()).intValue();
        qql.remove(Integer.valueOf(i));
      }
    }
    AppMethodBeat.o(122181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.a
 * JD-Core Version:    0.7.0.1
 */
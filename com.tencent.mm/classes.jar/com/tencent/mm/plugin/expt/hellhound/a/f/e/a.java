package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.cqp;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.protocal.protobuf.cqt;
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
  private static final Map<Integer, WeakReference<Activity>> pHE;
  
  static
  {
    AppMethodBeat.i(122193);
    pHE = new HashMap();
    AppMethodBeat.o(122193);
  }
  
  @SuppressLint({"NewApi"})
  public static void BH(int paramInt)
  {
    AppMethodBeat.i(122183);
    Object localObject = (WeakReference)pHE.get(Integer.valueOf(paramInt));
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
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx != null) {
      a(localObject, localbxx, true);
    }
    AppMethodBeat.o(122183);
  }
  
  @SuppressLint({"NewApi"})
  public static void BI(int paramInt)
  {
    AppMethodBeat.i(122184);
    Object localObject = (WeakReference)pHE.get(Integer.valueOf(paramInt));
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
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx != null) {
      a(localObject, localbxx, false);
    }
    AppMethodBeat.o(122184);
  }
  
  private static void a(Object paramObject, bxx parambxx, boolean paramBoolean)
  {
    AppMethodBeat.i(122189);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.d.ccX();
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.ccY();
    if (localObject == null)
    {
      ad.e("HABBYGE-MALI.HellPageParamsCatcher", "HellPageParamsCatcher, _doCatchOnActivity, config is NULL !!");
      AppMethodBeat.o(122189);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(parambxx.sessionId);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WD(parambxx.sessionId)) {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.g(parambxx);
    }
    for (;;)
    {
      paramObject.getClass().getCanonicalName();
      localObject = ((cqq)localObject).EjB.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cqt localcqt = (cqt)((Iterator)localObject).next();
        if ((localcqt != null) && ((localcqt.pZX.equals(str)) || ("-1".equals(localcqt.pZX)))) {
          a(paramObject, localcqt, parambxx, paramBoolean);
        }
      }
      AppMethodBeat.o(122189);
      return;
    }
  }
  
  private static void a(Object paramObject, cqp paramcqp1, cqp paramcqp2, String paramString, bxx parambxx, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169354);
    if (paramBoolean)
    {
      if (paramcqp2.DDP.equals(paramString))
      {
        a(paramObject, paramcqp2, parambxx.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramcqp1.DDP.equals(paramString))
      {
        a(paramObject, paramcqp1, parambxx.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
      }
    }
    else
    {
      if (paramcqp2.DDP.equals(paramString))
      {
        a(paramObject, paramcqp2, parambxx.sessionId, paramLong, false);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramcqp1.DDP.equals(paramString)) {
        a(paramObject, paramcqp1, parambxx.sessionId, paramLong, false);
      }
    }
    AppMethodBeat.o(169354);
  }
  
  private static void a(Object paramObject, cqp paramcqp, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169355);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.d.ab(paramString, paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(169355);
      return;
    }
    anc localanc = (anc)((Pair)localObject).first;
    int i = ((Integer)((Pair)localObject).second).intValue();
    paramcqp = paramcqp.EjA.iterator();
    while (paramcqp.hasNext())
    {
      localObject = (bxw)paramcqp.next();
      if (localObject != null) {
        b.a(paramObject, (bxw)localObject, localanc, paramBoolean);
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.d.d.a(paramString, localanc, i);
    AppMethodBeat.o(169355);
  }
  
  private static void a(Object paramObject, cqp paramcqp, String paramString, bxx parambxx, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169353);
    if (paramBoolean)
    {
      if (paramcqp.DDP.equals(paramString))
      {
        a(paramObject, paramcqp, parambxx.sessionId, paramLong, true);
        AppMethodBeat.o(169353);
      }
    }
    else if (paramcqp.DDP.equals(paramString)) {
      a(paramObject, paramcqp, parambxx.sessionId, paramLong, false);
    }
    AppMethodBeat.o(169353);
  }
  
  private static void a(Object paramObject, cqt paramcqt, bxx parambxx, boolean paramBoolean)
  {
    AppMethodBeat.i(169351);
    String str = paramObject.getClass().getCanonicalName();
    int j = paramcqt.EjF.size();
    if (j == 1)
    {
      b(paramObject, paramcqt, parambxx, paramBoolean);
      AppMethodBeat.o(169351);
      return;
    }
    int i = 1;
    while (i < j)
    {
      cqp localcqp1 = (cqp)paramcqt.EjF.get(i - 1);
      cqp localcqp2 = (cqp)paramcqt.EjF.get(i);
      if ((localcqp1 != null) && (localcqp2 != null))
      {
        if (paramcqt.type != 0)
        {
          if (paramcqt.type != 1) {
            break label148;
          }
          if (j == 2)
          {
            a(paramObject, localcqp1, localcqp2, str, parambxx, paramcqt.Doj, paramBoolean);
            AppMethodBeat.o(169351);
            return;
          }
        }
        a(paramObject, str, localcqp1, localcqp2, parambxx, paramBoolean, paramcqt);
      }
      label148:
      i += 1;
    }
    AppMethodBeat.o(169351);
  }
  
  private static void a(Object paramObject, String paramString, cqp paramcqp1, cqp paramcqp2, bxx parambxx, boolean paramBoolean, cqt paramcqt)
  {
    AppMethodBeat.i(177398);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.cbw();
    if ((paramcqp2.DDP.equals(paramString)) && (paramcqp1.DDP.equals(str))) {
      if (paramcqt.type == 0)
      {
        if (paramcqp2.DDP.equals(paramString))
        {
          a(paramObject, paramString, paramcqp2, parambxx.sessionId, paramBoolean);
          AppMethodBeat.o(177398);
        }
      }
      else if (paramcqt.type == 1) {
        a(paramObject, paramcqp2, paramString, parambxx, paramcqt.Doj, paramBoolean);
      }
    }
    AppMethodBeat.o(177398);
  }
  
  private static void a(Object paramObject, String paramString1, cqp paramcqp, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(169356);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.fB(paramString2, paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(169356);
      return;
    }
    paramString2 = (bgc)paramString1.get(0);
    paramcqp = paramcqp.EjA.iterator();
    while (paramcqp.hasNext())
    {
      bxw localbxw = (bxw)paramcqp.next();
      if (localbxw != null) {
        b.a(paramObject, localbxw, paramString2, false, paramBoolean);
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
      bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
      if (localbxx != null) {
        a(paramFragment, localbxx, true);
      }
      AppMethodBeat.o(122185);
      return;
      localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
      if (localbxx != null) {
        a(paramFragment, localbxx, false);
      }
    }
  }
  
  private static void b(Object paramObject, cqt paramcqt, bxx parambxx, boolean paramBoolean)
  {
    AppMethodBeat.i(169352);
    cqp localcqp = (cqp)paramcqt.EjF.get(0);
    if (localcqp == null)
    {
      AppMethodBeat.o(169352);
      return;
    }
    String str = paramObject.getClass().getCanonicalName();
    if (paramcqt.type == 0)
    {
      if (localcqp.DDP.equals(str))
      {
        a(paramObject, str, localcqp, parambxx.sessionId, paramBoolean);
        AppMethodBeat.o(169352);
      }
    }
    else if (paramcqt.type == 1) {
      a(paramObject, localcqp, str, parambxx, paramcqt.Doj, paramBoolean);
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
      if (!pHE.containsKey(Integer.valueOf(paramInt)))
      {
        paramActivity = new WeakReference(paramActivity);
        pHE.put(Integer.valueOf(paramInt), paramActivity);
      }
      for (;;)
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(400, Integer.valueOf(paramInt));
        AppMethodBeat.o(122182);
        return;
        localWeakReference = (WeakReference)pHE.get(Integer.valueOf(paramInt));
        if ((localWeakReference == null) || (localWeakReference.get() == null))
        {
          pHE.remove(Integer.valueOf(paramInt));
          paramActivity = new WeakReference(paramActivity);
          pHE.put(Integer.valueOf(paramInt), paramActivity);
        }
      }
    }
    paramInt = paramActivity.hashCode();
    if (!pHE.containsKey(Integer.valueOf(paramInt)))
    {
      paramActivity = new WeakReference(paramActivity);
      pHE.put(Integer.valueOf(paramInt), paramActivity);
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(401, Integer.valueOf(paramInt));
      break;
      localWeakReference = (WeakReference)pHE.get(Integer.valueOf(paramInt));
      if ((localWeakReference == null) || (localWeakReference.get() == null))
      {
        pHE.remove(Integer.valueOf(paramInt));
        paramActivity = new WeakReference(paramActivity);
        pHE.put(Integer.valueOf(paramInt), paramActivity);
      }
    }
  }
  
  public static void fC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122181);
    if (pHE.isEmpty())
    {
      AppMethodBeat.o(122181);
      return;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      try
      {
        pHE.remove(Integer.valueOf(paramString2));
        AppMethodBeat.o(122181);
        return;
      }
      catch (NumberFormatException paramString1)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellPageParamsCatcher", paramString1, "HellPageParamsCatcher, onDestroy: %s", new Object[] { paramString1.getMessage() });
        AppMethodBeat.o(122181);
        return;
      }
    }
    paramString2 = new ArrayList();
    Iterator localIterator = pHE.entrySet().iterator();
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
        pHE.remove(Integer.valueOf(i));
      }
    }
    AppMethodBeat.o(122181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.sdk.platformtools.Log;
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
  private static final Map<Integer, WeakReference<Activity>> sIN;
  private static WeakReference<Object> syV;
  
  static
  {
    AppMethodBeat.i(122193);
    sIN = new HashMap();
    syV = null;
    AppMethodBeat.o(122193);
  }
  
  @SuppressLint({"NewApi"})
  public static void Hn(int paramInt)
  {
    AppMethodBeat.i(122183);
    Object localObject = (WeakReference)sIN.get(Integer.valueOf(paramInt));
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
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl != null) {
      a(localObject, localcyl, true);
    }
    AppMethodBeat.o(122183);
  }
  
  @SuppressLint({"NewApi"})
  public static void Ho(int paramInt)
  {
    AppMethodBeat.i(122184);
    Object localObject = (WeakReference)sIN.get(Integer.valueOf(paramInt));
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
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl != null)
    {
      Log.i("HABBYGE-MALI.HellPageParamsCatcher", "catchOnActivityFinishAsync: %s", new Object[] { localcyl.sessionId });
      a(localObject, localcyl, false);
    }
    AppMethodBeat.o(122184);
  }
  
  private static void a(Object paramObject, cyl paramcyl, boolean paramBoolean)
  {
    AppMethodBeat.i(122189);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.d.cQe();
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.cQf();
    if (localObject == null)
    {
      Log.e("HABBYGE-MALI.HellPageParamsCatcher", "HellPageParamsCatcher, _doCatchOnActivity, config is NULL !!");
      AppMethodBeat.o(122189);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramcyl.sessionId);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqu(paramcyl.sessionId)) {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.k(paramcyl);
    }
    for (;;)
    {
      localObject = ((dvh)localObject).MWn.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dvk localdvk = (dvk)((Iterator)localObject).next();
        if ((localdvk != null) && ((localdvk.sGF.equals(str)) || ("-1".equals(localdvk.sGF)))) {
          a(paramObject, localdvk, paramcyl, paramBoolean);
        }
      }
      AppMethodBeat.o(122189);
      return;
    }
  }
  
  private static void a(Object paramObject, dvg paramdvg1, dvg paramdvg2, String paramString, cyl paramcyl, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169354);
    if (paramBoolean)
    {
      if (paramdvg2.dMl.equals(paramString))
      {
        a(paramObject, paramdvg2, paramcyl.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramdvg1.dMl.equals(paramString))
      {
        a(paramObject, paramdvg1, paramcyl.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
      }
    }
    else
    {
      if (paramdvg2.dMl.equals(paramString))
      {
        a(paramObject, paramdvg2, paramcyl.sessionId, paramLong, false);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramdvg1.dMl.equals(paramString)) {
        a(paramObject, paramdvg1, paramcyl.sessionId, paramLong, false);
      }
    }
    AppMethodBeat.o(169354);
  }
  
  private static void a(Object paramObject, dvg paramdvg, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169355);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.d.ah(paramString, paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(169355);
      return;
    }
    bgb localbgb = (bgb)((Pair)localObject).first;
    int i = ((Integer)((Pair)localObject).second).intValue();
    paramdvg = paramdvg.MWl.iterator();
    while (paramdvg.hasNext())
    {
      localObject = (cyk)paramdvg.next();
      if (localObject != null) {
        b.a(paramObject, (cyk)localObject, localbgb, paramBoolean);
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.d.d.a(paramString, localbgb, i);
    AppMethodBeat.o(169355);
  }
  
  private static void a(Object paramObject, dvg paramdvg, String paramString, cyl paramcyl, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169353);
    if (paramBoolean)
    {
      if (paramdvg.dMl.equals(paramString))
      {
        a(paramObject, paramdvg, paramcyl.sessionId, paramLong, true);
        AppMethodBeat.o(169353);
      }
    }
    else if (paramdvg.dMl.equals(paramString)) {
      a(paramObject, paramdvg, paramcyl.sessionId, paramLong, false);
    }
    AppMethodBeat.o(169353);
  }
  
  private static void a(Object paramObject, dvk paramdvk, cyl paramcyl, boolean paramBoolean)
  {
    AppMethodBeat.i(169351);
    String str = paramObject.getClass().getCanonicalName();
    int j = paramdvk.MWr.size();
    if (j == 1)
    {
      b(paramObject, paramdvk, paramcyl, paramBoolean);
      AppMethodBeat.o(169351);
      return;
    }
    int i = 1;
    while (i < j)
    {
      dvg localdvg1 = (dvg)paramdvk.MWr.get(i - 1);
      dvg localdvg2 = (dvg)paramdvk.MWr.get(i);
      if ((localdvg1 != null) && (localdvg2 != null))
      {
        if (paramdvk.type != 0)
        {
          if (paramdvk.type != 1) {
            break label148;
          }
          if (j == 2)
          {
            a(paramObject, localdvg1, localdvg2, str, paramcyl, paramdvk.LPN, paramBoolean);
            AppMethodBeat.o(169351);
            return;
          }
        }
        a(paramObject, str, localdvg1, localdvg2, paramcyl, paramBoolean, paramdvk);
      }
      label148:
      i += 1;
    }
    AppMethodBeat.o(169351);
  }
  
  private static void a(Object paramObject, String paramString, dvg paramdvg1, dvg paramdvg2, cyl paramcyl, boolean paramBoolean, dvk paramdvk)
  {
    AppMethodBeat.i(177398);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.cNy();
    if ((paramdvg2.dMl.equals(paramString)) && (paramdvg1.dMl.equals(str)))
    {
      if (paramdvk.type == 0)
      {
        a(paramObject, paramString, paramdvg2, paramcyl.sessionId, paramBoolean);
        AppMethodBeat.o(177398);
        return;
      }
      if (paramdvk.type == 1) {
        a(paramObject, paramdvg2, paramString, paramcyl, paramdvk.LPN, paramBoolean);
      }
    }
    AppMethodBeat.o(177398);
  }
  
  private static void a(Object paramObject, String paramString1, dvg paramdvg, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(169356);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.gw(paramString2, paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(169356);
      return;
    }
    paramString2 = (cbm)paramString1.get(0);
    paramdvg = paramdvg.MWl.iterator();
    while (paramdvg.hasNext())
    {
      cyk localcyk = (cyk)paramdvg.next();
      if (localcyk != null) {
        b.a(paramObject, localcyk, paramString2, false, paramBoolean);
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
      cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
      if (localcyl != null) {
        a(paramFragment, localcyl, true);
      }
      AppMethodBeat.o(122185);
      return;
      localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
      if (localcyl != null) {
        a(paramFragment, localcyl, false);
      }
    }
  }
  
  private static void b(Object paramObject, dvk paramdvk, cyl paramcyl, boolean paramBoolean)
  {
    AppMethodBeat.i(169352);
    dvg localdvg = (dvg)paramdvk.MWr.get(0);
    if (localdvg == null)
    {
      AppMethodBeat.o(169352);
      return;
    }
    String str = paramObject.getClass().getCanonicalName();
    if (paramdvk.type == 0)
    {
      if (localdvg.dMl.equals(str))
      {
        a(paramObject, str, localdvg, paramcyl.sessionId, paramBoolean);
        AppMethodBeat.o(169352);
      }
    }
    else if (paramdvk.type == 1) {
      a(paramObject, localdvg, str, paramcyl, paramdvk.LPN, paramBoolean);
    }
    AppMethodBeat.o(169352);
  }
  
  public static Object cNw()
  {
    AppMethodBeat.i(220572);
    if (syV == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.cNx().cNw();
      AppMethodBeat.o(220572);
      return localObject;
    }
    Object localObject = syV.get();
    AppMethodBeat.o(220572);
    return localObject;
  }
  
  public static void df(Object paramObject)
  {
    AppMethodBeat.i(220573);
    if (paramObject != null) {
      syV = new WeakReference(paramObject);
    }
    AppMethodBeat.o(220573);
  }
  
  public static void dp(String paramString, int paramInt)
  {
    AppMethodBeat.i(220574);
    if (sIN.isEmpty())
    {
      AppMethodBeat.o(220574);
      return;
    }
    if (paramInt > 0) {
      try
      {
        sIN.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(220574);
        return;
      }
      catch (NumberFormatException paramString)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellPageParamsCatcher", paramString, "HellPageParamsCatcher, onDestroy: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(220574);
        return;
      }
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = sIN.entrySet().iterator();
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
        sIN.remove(Integer.valueOf(paramInt));
      }
    }
    AppMethodBeat.o(220574);
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
      if (!sIN.containsKey(Integer.valueOf(paramInt)))
      {
        paramActivity = new WeakReference(paramActivity);
        sIN.put(Integer.valueOf(paramInt), paramActivity);
      }
      for (;;)
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(400, Integer.valueOf(paramInt));
        AppMethodBeat.o(122182);
        return;
        localWeakReference = (WeakReference)sIN.get(Integer.valueOf(paramInt));
        if ((localWeakReference == null) || (localWeakReference.get() == null))
        {
          sIN.remove(Integer.valueOf(paramInt));
          paramActivity = new WeakReference(paramActivity);
          sIN.put(Integer.valueOf(paramInt), paramActivity);
        }
      }
    }
    paramInt = paramActivity.hashCode();
    if (!sIN.containsKey(Integer.valueOf(paramInt)))
    {
      paramActivity = new WeakReference(paramActivity);
      sIN.put(Integer.valueOf(paramInt), paramActivity);
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(401, Integer.valueOf(paramInt));
      break;
      localWeakReference = (WeakReference)sIN.get(Integer.valueOf(paramInt));
      if ((localWeakReference == null) || (localWeakReference.get() == null))
      {
        sIN.remove(Integer.valueOf(paramInt));
        paramActivity = new WeakReference(paramActivity);
        sIN.put(Integer.valueOf(paramInt), paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.a
 * JD-Core Version:    0.7.0.1
 */
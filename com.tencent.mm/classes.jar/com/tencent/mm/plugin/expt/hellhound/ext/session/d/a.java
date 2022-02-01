package com.tencent.mm.plugin.expt.hellhound.ext.session.d;

import android.app.Activity;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.d;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.protocal.protobuf.ezf;
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
  private static WeakReference<Object> zAP;
  private static final Map<Integer, WeakReference<Activity>> zKP;
  
  static
  {
    AppMethodBeat.i(122193);
    zKP = new HashMap();
    zAP = null;
    AppMethodBeat.o(122193);
  }
  
  public static void LW(int paramInt)
  {
    AppMethodBeat.i(122183);
    Object localObject = (WeakReference)zKP.get(Integer.valueOf(paramInt));
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
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah != null) {
      a(localObject, localeah, true);
    }
    AppMethodBeat.o(122183);
  }
  
  public static void LX(int paramInt)
  {
    AppMethodBeat.i(122184);
    Object localObject = (WeakReference)zKP.get(Integer.valueOf(paramInt));
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
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah != null)
    {
      Log.i("HABBYGE-MALI.HellPageParamsCatcher", "catchOnActivityFinishAsync: %s", new Object[] { localeah.sessionId });
      a(localObject, localeah, false);
    }
    AppMethodBeat.o(122184);
  }
  
  private static void a(Object paramObject, eah parameah, boolean paramBoolean)
  {
    AppMethodBeat.i(122189);
    d.dLN();
    Object localObject = d.dLO();
    if (localObject == null)
    {
      Log.e("HABBYGE-MALI.HellPageParamsCatcher", "HellPageParamsCatcher, _doCatchOnActivity, config is NULL !!");
      AppMethodBeat.o(122189);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(parameah.sessionId);
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asz(parameah.sessionId)) {
      str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.i(parameah);
    }
    for (;;)
    {
      localObject = ((ezc)localObject).abAh.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ezf localezf = (ezf)((Iterator)localObject).next();
        if ((localezf != null) && ((localezf.zIC.equals(str)) || ("-1".equals(localezf.zIC)))) {
          a(paramObject, localezf, parameah, paramBoolean);
        }
      }
      AppMethodBeat.o(122189);
      return;
    }
  }
  
  private static void a(Object paramObject, ezb paramezb1, ezb paramezb2, String paramString, eah parameah, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169354);
    if (paramBoolean)
    {
      if (paramezb2.hJW.equals(paramString))
      {
        a(paramObject, paramezb2, parameah.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramezb1.hJW.equals(paramString))
      {
        a(paramObject, paramezb1, parameah.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
      }
    }
    else
    {
      if (paramezb2.hJW.equals(paramString))
      {
        a(paramObject, paramezb2, parameah.sessionId, paramLong, false);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramezb1.hJW.equals(paramString)) {
        a(paramObject, paramezb1, parameah.sessionId, paramLong, false);
      }
    }
    AppMethodBeat.o(169354);
  }
  
  private static void a(Object paramObject, ezb paramezb, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169355);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.d.c.aq(paramString, paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(169355);
      return;
    }
    caw localcaw = (caw)((Pair)localObject).first;
    int i = ((Integer)((Pair)localObject).second).intValue();
    paramezb = paramezb.abAf.iterator();
    while (paramezb.hasNext())
    {
      localObject = (eag)paramezb.next();
      if (localObject != null) {
        b.a(paramObject, (eag)localObject, localcaw, paramBoolean);
      }
    }
    com.tencent.mm.plugin.expt.hellhound.ext.d.c.a(paramString, localcaw, i);
    AppMethodBeat.o(169355);
  }
  
  private static void a(Object paramObject, ezb paramezb, String paramString, eah parameah, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169353);
    if (paramBoolean)
    {
      if (paramezb.hJW.equals(paramString))
      {
        a(paramObject, paramezb, parameah.sessionId, paramLong, true);
        AppMethodBeat.o(169353);
      }
    }
    else if (paramezb.hJW.equals(paramString)) {
      a(paramObject, paramezb, parameah.sessionId, paramLong, false);
    }
    AppMethodBeat.o(169353);
  }
  
  private static void a(Object paramObject, ezf paramezf, eah parameah, boolean paramBoolean)
  {
    AppMethodBeat.i(169351);
    String str = paramObject.getClass().getCanonicalName();
    int j = paramezf.abAl.size();
    if (j == 1)
    {
      b(paramObject, paramezf, parameah, paramBoolean);
      AppMethodBeat.o(169351);
      return;
    }
    int i = 1;
    while (i < j)
    {
      ezb localezb1 = (ezb)paramezf.abAl.get(i - 1);
      ezb localezb2 = (ezb)paramezf.abAl.get(i);
      if ((localezb1 != null) && (localezb2 != null))
      {
        if (paramezf.type != 0)
        {
          if (paramezf.type != 1) {
            break label148;
          }
          if (j == 2)
          {
            a(paramObject, localezb1, localezb2, str, parameah, paramezf.aajX, paramBoolean);
            AppMethodBeat.o(169351);
            return;
          }
        }
        a(paramObject, str, localezb1, localezb2, parameah, paramBoolean, paramezf);
      }
      label148:
      i += 1;
    }
    AppMethodBeat.o(169351);
  }
  
  private static void a(Object paramObject, String paramString, ezb paramezb1, ezb paramezb2, eah parameah, boolean paramBoolean, ezf paramezf)
  {
    AppMethodBeat.i(177398);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.dIU();
    if ((paramezb2.hJW.equals(paramString)) && (paramezb1.hJW.equals(str)))
    {
      if (paramezf.type == 0)
      {
        a(paramObject, paramString, paramezb2, parameah.sessionId, paramBoolean);
        AppMethodBeat.o(177398);
        return;
      }
      if (paramezf.type == 1) {
        a(paramObject, paramezb2, paramString, parameah, paramezf.aajX, paramBoolean);
      }
    }
    AppMethodBeat.o(177398);
  }
  
  private static void a(Object paramObject, String paramString1, ezb paramezb, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(169356);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.hs(paramString2, paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(169356);
      return;
    }
    paramString2 = (czu)paramString1.get(0);
    paramezb = paramezb.abAf.iterator();
    while (paramezb.hasNext())
    {
      eag localeag = (eag)paramezb.next();
      if (localeag != null) {
        b.a(paramObject, localeag, paramString2, false, paramBoolean);
      }
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(paramString2, ((Integer)paramString1.get(1)).intValue());
    AppMethodBeat.o(169356);
  }
  
  public static void b(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(300209);
    if (paramFragment == null)
    {
      AppMethodBeat.o(300209);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300209);
      return;
      eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
      if (localeah != null) {
        a(paramFragment, localeah, true);
      }
      AppMethodBeat.o(300209);
      return;
      localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
      if (localeah != null) {
        a(paramFragment, localeah, false);
      }
    }
  }
  
  private static void b(Object paramObject, ezf paramezf, eah parameah, boolean paramBoolean)
  {
    AppMethodBeat.i(169352);
    ezb localezb = (ezb)paramezf.abAl.get(0);
    if (localezb == null)
    {
      AppMethodBeat.o(169352);
      return;
    }
    String str = paramObject.getClass().getCanonicalName();
    if (paramezf.type == 0)
    {
      if (localezb.hJW.equals(str))
      {
        a(paramObject, str, localezb, parameah.sessionId, paramBoolean);
        AppMethodBeat.o(169352);
      }
    }
    else if (paramezf.type == 1) {
      a(paramObject, localezb, str, parameah, paramezf.aajX, paramBoolean);
    }
    AppMethodBeat.o(169352);
  }
  
  public static Object dIS()
  {
    AppMethodBeat.i(300191);
    if (zAP == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.dIT().dIS();
      AppMethodBeat.o(300191);
      return localObject;
    }
    Object localObject = zAP.get();
    AppMethodBeat.o(300191);
    return localObject;
  }
  
  public static void en(String paramString, int paramInt)
  {
    AppMethodBeat.i(300200);
    if (zKP.isEmpty())
    {
      AppMethodBeat.o(300200);
      return;
    }
    if (paramInt > 0) {
      try
      {
        zKP.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(300200);
        return;
      }
      catch (NumberFormatException paramString)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellPageParamsCatcher", paramString, "HellPageParamsCatcher, onDestroy: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(300200);
        return;
      }
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zKP.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        Object localObject = (Activity)((WeakReference)localEntry.getValue()).get();
        if (localObject == null)
        {
          localArrayList.add((Integer)localEntry.getKey());
        }
        else
        {
          localObject = localObject.getClass().getCanonicalName();
          if ((localObject != null) && (((String)localObject).equals(paramString))) {
            localArrayList.add((Integer)localEntry.getKey());
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
        zKP.remove(Integer.valueOf(paramInt));
      }
    }
    AppMethodBeat.o(300200);
  }
  
  public static void fa(Object paramObject)
  {
    AppMethodBeat.i(300196);
    if (paramObject != null) {
      zAP = new WeakReference(paramObject);
    }
    AppMethodBeat.o(300196);
  }
  
  public static void g(Activity paramActivity, int paramInt)
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
      if (!zKP.containsKey(Integer.valueOf(paramInt)))
      {
        paramActivity = new WeakReference(paramActivity);
        zKP.put(Integer.valueOf(paramInt), paramActivity);
      }
      for (;;)
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(400, Integer.valueOf(paramInt));
        AppMethodBeat.o(122182);
        return;
        localWeakReference = (WeakReference)zKP.get(Integer.valueOf(paramInt));
        if ((localWeakReference == null) || (localWeakReference.get() == null))
        {
          zKP.remove(Integer.valueOf(paramInt));
          paramActivity = new WeakReference(paramActivity);
          zKP.put(Integer.valueOf(paramInt), paramActivity);
        }
      }
    }
    paramInt = paramActivity.hashCode();
    if (!zKP.containsKey(Integer.valueOf(paramInt)))
    {
      paramActivity = new WeakReference(paramActivity);
      zKP.put(Integer.valueOf(paramInt), paramActivity);
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(401, Integer.valueOf(paramInt));
      break;
      localWeakReference = (WeakReference)zKP.get(Integer.valueOf(paramInt));
      if ((localWeakReference == null) || (localWeakReference.get() == null))
      {
        zKP.remove(Integer.valueOf(paramInt));
        paramActivity = new WeakReference(paramActivity);
        zKP.put(Integer.valueOf(paramInt), paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.d.a
 * JD-Core Version:    0.7.0.1
 */
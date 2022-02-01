package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.protocal.protobuf.efm;
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
  private static WeakReference<Object> weR;
  private static final Map<Integer, WeakReference<Activity>> woK;
  
  static
  {
    AppMethodBeat.i(122193);
    woK = new HashMap();
    weR = null;
    AppMethodBeat.o(122193);
  }
  
  @SuppressLint({"NewApi"})
  public static void KX(int paramInt)
  {
    AppMethodBeat.i(122183);
    Object localObject = (WeakReference)woK.get(Integer.valueOf(paramInt));
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
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx != null) {
      a(localObject, localdhx, true);
    }
    AppMethodBeat.o(122183);
  }
  
  @SuppressLint({"NewApi"})
  public static void KY(int paramInt)
  {
    AppMethodBeat.i(122184);
    Object localObject = (WeakReference)woK.get(Integer.valueOf(paramInt));
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
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx != null)
    {
      Log.i("HABBYGE-MALI.HellPageParamsCatcher", "catchOnActivityFinishAsync: %s", new Object[] { localdhx.sessionId });
      a(localObject, localdhx, false);
    }
    AppMethodBeat.o(122184);
  }
  
  private static void a(Object paramObject, dhx paramdhx, boolean paramBoolean)
  {
    AppMethodBeat.i(122189);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.d.deY();
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.deZ();
    if (localObject == null)
    {
      Log.e("HABBYGE-MALI.HellPageParamsCatcher", "HellPageParamsCatcher, _doCatchOnActivity, config is NULL !!");
      AppMethodBeat.o(122189);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramdhx.sessionId);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayu(paramdhx.sessionId)) {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.k(paramdhx);
    }
    for (;;)
    {
      localObject = ((efj)localObject).UiI.iterator();
      while (((Iterator)localObject).hasNext())
      {
        efm localefm = (efm)((Iterator)localObject).next();
        if ((localefm != null) && ((localefm.wmA.equals(str)) || ("-1".equals(localefm.wmA)))) {
          a(paramObject, localefm, paramdhx, paramBoolean);
        }
      }
      AppMethodBeat.o(122189);
      return;
    }
  }
  
  private static void a(Object paramObject, efi paramefi1, efi paramefi2, String paramString, dhx paramdhx, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169354);
    if (paramBoolean)
    {
      if (paramefi2.fFe.equals(paramString))
      {
        a(paramObject, paramefi2, paramdhx.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramefi1.fFe.equals(paramString))
      {
        a(paramObject, paramefi1, paramdhx.sessionId, paramLong, true);
        AppMethodBeat.o(169354);
      }
    }
    else
    {
      if (paramefi2.fFe.equals(paramString))
      {
        a(paramObject, paramefi2, paramdhx.sessionId, paramLong, false);
        AppMethodBeat.o(169354);
        return;
      }
      if (paramefi1.fFe.equals(paramString)) {
        a(paramObject, paramefi1, paramdhx.sessionId, paramLong, false);
      }
    }
    AppMethodBeat.o(169354);
  }
  
  private static void a(Object paramObject, efi paramefi, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169355);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.d.ai(paramString, paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(169355);
      return;
    }
    bnc localbnc = (bnc)((Pair)localObject).first;
    int i = ((Integer)((Pair)localObject).second).intValue();
    paramefi = paramefi.UiG.iterator();
    while (paramefi.hasNext())
    {
      localObject = (dhw)paramefi.next();
      if (localObject != null) {
        b.a(paramObject, (dhw)localObject, localbnc, paramBoolean);
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.d.d.a(paramString, localbnc, i);
    AppMethodBeat.o(169355);
  }
  
  private static void a(Object paramObject, efi paramefi, String paramString, dhx paramdhx, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(169353);
    if (paramBoolean)
    {
      if (paramefi.fFe.equals(paramString))
      {
        a(paramObject, paramefi, paramdhx.sessionId, paramLong, true);
        AppMethodBeat.o(169353);
      }
    }
    else if (paramefi.fFe.equals(paramString)) {
      a(paramObject, paramefi, paramdhx.sessionId, paramLong, false);
    }
    AppMethodBeat.o(169353);
  }
  
  private static void a(Object paramObject, efm paramefm, dhx paramdhx, boolean paramBoolean)
  {
    AppMethodBeat.i(169351);
    String str = paramObject.getClass().getCanonicalName();
    int j = paramefm.UiM.size();
    if (j == 1)
    {
      b(paramObject, paramefm, paramdhx, paramBoolean);
      AppMethodBeat.o(169351);
      return;
    }
    int i = 1;
    while (i < j)
    {
      efi localefi1 = (efi)paramefm.UiM.get(i - 1);
      efi localefi2 = (efi)paramefm.UiM.get(i);
      if ((localefi1 != null) && (localefi2 != null))
      {
        if (paramefm.type != 0)
        {
          if (paramefm.type != 1) {
            break label148;
          }
          if (j == 2)
          {
            a(paramObject, localefi1, localefi2, str, paramdhx, paramefm.SYb, paramBoolean);
            AppMethodBeat.o(169351);
            return;
          }
        }
        a(paramObject, str, localefi1, localefi2, paramdhx, paramBoolean, paramefm);
      }
      label148:
      i += 1;
    }
    AppMethodBeat.o(169351);
  }
  
  private static void a(Object paramObject, String paramString, efi paramefi1, efi paramefi2, dhx paramdhx, boolean paramBoolean, efm paramefm)
  {
    AppMethodBeat.i(177398);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.dcq();
    if ((paramefi2.fFe.equals(paramString)) && (paramefi1.fFe.equals(str)))
    {
      if (paramefm.type == 0)
      {
        a(paramObject, paramString, paramefi2, paramdhx.sessionId, paramBoolean);
        AppMethodBeat.o(177398);
        return;
      }
      if (paramefm.type == 1) {
        a(paramObject, paramefi2, paramString, paramdhx, paramefm.SYb, paramBoolean);
      }
    }
    AppMethodBeat.o(177398);
  }
  
  private static void a(Object paramObject, String paramString1, efi paramefi, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(169356);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.gK(paramString2, paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(169356);
      return;
    }
    paramString2 = (cjp)paramString1.get(0);
    paramefi = paramefi.UiG.iterator();
    while (paramefi.hasNext())
    {
      dhw localdhw = (dhw)paramefi.next();
      if (localdhw != null) {
        b.a(paramObject, localdhw, paramString2, false, paramBoolean);
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramString2, ((Integer)paramString1.get(1)).intValue());
    AppMethodBeat.o(169356);
  }
  
  public static void b(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(252439);
    if (paramFragment == null)
    {
      AppMethodBeat.o(252439);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(252439);
      return;
      dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
      if (localdhx != null) {
        a(paramFragment, localdhx, true);
      }
      AppMethodBeat.o(252439);
      return;
      localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
      if (localdhx != null) {
        a(paramFragment, localdhx, false);
      }
    }
  }
  
  private static void b(Object paramObject, efm paramefm, dhx paramdhx, boolean paramBoolean)
  {
    AppMethodBeat.i(169352);
    efi localefi = (efi)paramefm.UiM.get(0);
    if (localefi == null)
    {
      AppMethodBeat.o(169352);
      return;
    }
    String str = paramObject.getClass().getCanonicalName();
    if (paramefm.type == 0)
    {
      if (localefi.fFe.equals(str))
      {
        a(paramObject, str, localefi, paramdhx.sessionId, paramBoolean);
        AppMethodBeat.o(169352);
      }
    }
    else if (paramefm.type == 1) {
      a(paramObject, localefi, str, paramdhx, paramefm.SYb, paramBoolean);
    }
    AppMethodBeat.o(169352);
  }
  
  public static void dK(String paramString, int paramInt)
  {
    AppMethodBeat.i(252438);
    if (woK.isEmpty())
    {
      AppMethodBeat.o(252438);
      return;
    }
    if (paramInt > 0) {
      try
      {
        woK.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(252438);
        return;
      }
      catch (NumberFormatException paramString)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellPageParamsCatcher", paramString, "HellPageParamsCatcher, onDestroy: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(252438);
        return;
      }
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = woK.entrySet().iterator();
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
        woK.remove(Integer.valueOf(paramInt));
      }
    }
    AppMethodBeat.o(252438);
  }
  
  public static void dc(Object paramObject)
  {
    AppMethodBeat.i(252437);
    if (paramObject != null) {
      weR = new WeakReference(paramObject);
    }
    AppMethodBeat.o(252437);
  }
  
  public static Object dco()
  {
    AppMethodBeat.i(252436);
    if (weR == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.dcp().dco();
      AppMethodBeat.o(252436);
      return localObject;
    }
    Object localObject = weR.get();
    AppMethodBeat.o(252436);
    return localObject;
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
      if (!woK.containsKey(Integer.valueOf(paramInt)))
      {
        paramActivity = new WeakReference(paramActivity);
        woK.put(Integer.valueOf(paramInt), paramActivity);
      }
      for (;;)
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(400, Integer.valueOf(paramInt));
        AppMethodBeat.o(122182);
        return;
        localWeakReference = (WeakReference)woK.get(Integer.valueOf(paramInt));
        if ((localWeakReference == null) || (localWeakReference.get() == null))
        {
          woK.remove(Integer.valueOf(paramInt));
          paramActivity = new WeakReference(paramActivity);
          woK.put(Integer.valueOf(paramInt), paramActivity);
        }
      }
    }
    paramInt = paramActivity.hashCode();
    if (!woK.containsKey(Integer.valueOf(paramInt)))
    {
      paramActivity = new WeakReference(paramActivity);
      woK.put(Integer.valueOf(paramInt), paramActivity);
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(401, Integer.valueOf(paramInt));
      break;
      localWeakReference = (WeakReference)woK.get(Integer.valueOf(paramInt));
      if ((localWeakReference == null) || (localWeakReference.get() == null))
      {
        woK.remove(Integer.valueOf(paramInt));
        paramActivity = new WeakReference(paramActivity);
        woK.put(Integer.valueOf(paramInt), paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.a
 * JD-Core Version:    0.7.0.1
 */
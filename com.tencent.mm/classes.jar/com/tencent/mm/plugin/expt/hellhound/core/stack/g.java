package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  public f lZU;
  
  public static be Mh(String paramString)
  {
    AppMethodBeat.i(152271);
    bf localbf = c.brA();
    paramString = b(localbf, paramString, null);
    int i = ((Integer)paramString.get(0)).intValue();
    int j = ((Integer)paramString.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(152271);
      return null;
    }
    paramString = (be)((cjr)localbf.wnv.get(i)).xTI.get(j);
    AppMethodBeat.o(152271);
    return paramString;
  }
  
  public static be a(bf parambf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(73375);
    if (parambf == null)
    {
      AppMethodBeat.o(73375);
      return null;
    }
    ab.d("TaskRecordWrapper", "habbyge-mali, doPopRealActivity: " + paramString1 + "=" + paramString2);
    int i = parambf.wnv.size() - 1;
    while (i >= 0)
    {
      cjr localcjr = (cjr)parambf.wnv.get(i);
      int j = localcjr.xTI.size() - 1;
      while (j >= 0)
      {
        be localbe = (be)localcjr.xTI.get(j);
        if (h.l(localbe.wnr.activityName, localbe.wnr.wXg, paramString1, paramString2))
        {
          ab.d("TaskRecordWrapper", "habbyge-mali, doPopRealActivity.pop YES: " + paramString1 + "=" + paramString2);
          localcjr.xTI.remove(j);
          if (localcjr.xTI.isEmpty()) {
            parambf.wnv.remove(i);
          }
          AppMethodBeat.o(73375);
          return localbe;
        }
        ab.e("TaskRecordWrapper", "habbyge-mali, doPopRealActivity.pop NOT: " + paramString1 + "/" + localbe.wnr.activityName);
        j -= 1;
      }
      i -= 1;
    }
    AppMethodBeat.o(73375);
    return null;
  }
  
  public static com.tencent.mm.vending.j.c<cjr, Integer> a(bf parambf, be parambe)
  {
    AppMethodBeat.i(73376);
    if ((parambf == null) || (parambf.wnv.isEmpty()) || (parambe == null))
    {
      AppMethodBeat.o(73376);
      return null;
    }
    int i = parambf.wnv.size() - 1;
    while (i >= 0)
    {
      cjr localcjr = (cjr)parambf.wnv.get(i);
      if ((localcjr != null) && (!localcjr.xTI.isEmpty()))
      {
        int j = localcjr.xTI.size() - 1;
        while (j >= 0)
        {
          be localbe = (be)localcjr.xTI.get(j);
          if ((localbe != null) && (h.a(parambe.wnr, localbe.wnr)))
          {
            ab.d("TaskRecordWrapper", "habbyge-mali, getTaskOfActivity 2: " + localbe.wnr.activityName + "/" + localbe.wnr.wXg);
            parambf = a.C(localcjr, Integer.valueOf(i));
            AppMethodBeat.o(73376);
            return parambf;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(73376);
    return null;
  }
  
  static void a(bf parambf, be parambe, boolean paramBoolean)
  {
    AppMethodBeat.i(73378);
    if (parambe == null)
    {
      AppMethodBeat.o(73378);
      return;
    }
    cjr localcjr = new cjr();
    localcjr.xTH = paramBoolean;
    localcjr.xTI.addLast(parambe);
    parambe = parambf;
    if (parambf == null) {
      parambe = new bf();
    }
    parambe.wnv.addLast(localcjr);
    AppMethodBeat.o(73378);
  }
  
  public static com.tencent.mm.vending.j.c<Integer, Integer> b(bf parambf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(73383);
    if (TextUtils.isEmpty(paramString1))
    {
      parambf = a.C(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(73383);
      return parambf;
    }
    ab.d("TaskRecordWrapper", "habbyge-mali, search: " + paramString1 + "/" + paramString2);
    if (parambf == null)
    {
      parambf = com.tencent.mm.vending.j.c.C(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(73383);
      return parambf;
    }
    int i = parambf.wnv.size();
    if (i <= 0)
    {
      parambf = com.tencent.mm.vending.j.c.C(Integer.valueOf(-1), Integer.valueOf(-1));
      AppMethodBeat.o(73383);
      return parambf;
    }
    i -= 1;
    int k = -1;
    int j = -1;
    int m;
    if (i >= 0)
    {
      cjr localcjr = (cjr)parambf.wnv.get(i);
      m = localcjr.xTI.size() - 1;
      label154:
      if (m < 0) {
        break label267;
      }
      be localbe = (be)localcjr.xTI.get(m);
      if (h.l(paramString1, paramString2, localbe.wnr.activityName, localbe.wnr.wXg))
      {
        k = m;
        j = i;
      }
    }
    label267:
    for (;;)
    {
      i -= 1;
      break;
      m -= 1;
      break label154;
      if (j == -1)
      {
        parambf = com.tencent.mm.vending.j.c.C(Integer.valueOf(-1), Integer.valueOf(-1));
        AppMethodBeat.o(73383);
        return parambf;
      }
      parambf = a.C(Integer.valueOf(j), Integer.valueOf(k));
      AppMethodBeat.o(73383);
      return parambf;
    }
  }
  
  static void b(bf parambf, be parambe)
  {
    AppMethodBeat.i(73377);
    ab.d("TaskRecordWrapper", "habbyge-mali, push: " + parambe.wnr.activityName);
    cjr localcjr1 = null;
    if (!parambf.wnv.isEmpty())
    {
      ab.d("TaskRecordWrapper", "habbyge-mali, push: stack.taskRecords NOT NULL");
      localcjr1 = (cjr)parambf.wnv.getLast();
    }
    cjr localcjr2 = localcjr1;
    if (localcjr1 == null)
    {
      localcjr2 = new cjr();
      parambf.wnv.addLast(localcjr2);
    }
    localcjr2.xTI.addLast(parambe);
    AppMethodBeat.o(73377);
  }
  
  static boolean b(bf parambf)
  {
    AppMethodBeat.i(73379);
    if (parambf == null)
    {
      AppMethodBeat.o(73379);
      return false;
    }
    cjr localcjr = null;
    if (!parambf.wnv.isEmpty()) {
      localcjr = (cjr)parambf.wnv.getLast();
    }
    if ((localcjr != null) && (localcjr.xTH))
    {
      AppMethodBeat.o(73379);
      return true;
    }
    AppMethodBeat.o(73379);
    return false;
  }
  
  public static com.tencent.mm.vending.j.c<bf, be> brI()
  {
    AppMethodBeat.i(73384);
    Object localObject = c.brA();
    localObject = a.C(localObject, c((bf)localObject));
    AppMethodBeat.o(73384);
    return localObject;
  }
  
  public static be c(bf parambf)
  {
    AppMethodBeat.i(73385);
    if (parambf == null)
    {
      AppMethodBeat.o(73385);
      return null;
    }
    if (!parambf.wnv.isEmpty()) {}
    for (parambf = (cjr)parambf.wnv.getLast();; parambf = null)
    {
      if (parambf == null)
      {
        AppMethodBeat.o(73385);
        return null;
      }
      if (parambf.xTI.isEmpty())
      {
        AppMethodBeat.o(73385);
        return null;
      }
      parambf = (be)parambf.xTI.getLast();
      AppMethodBeat.o(73385);
      return parambf;
    }
  }
  
  static com.tencent.mm.vending.j.c<Integer, Integer> c(bf parambf, be parambe)
  {
    AppMethodBeat.i(73382);
    parambf = b(parambf, parambe.wnr.activityName, parambe.wnr.wXg);
    AppMethodBeat.o(73382);
    return parambf;
  }
  
  final void a(Activity paramActivity, be parambe)
  {
    AppMethodBeat.i(152268);
    ab.d("TaskRecordWrapper", "habbyge-mali, singleInstanceMode: " + parambe.wnr.activityName);
    bf localbf = c.brA();
    be localbe1 = c(localbf);
    if (localbf == null) {}
    for (LinkedList localLinkedList = null; localLinkedList == null; localLinkedList = localbf.wnv)
    {
      ab.d("TaskRecordWrapper", "habbyge-mali, singleInstanceMode: allTaskRecords == null");
      a(localbf, parambe, true);
      c.a(localbf);
      if (this.lZU != null) {
        this.lZU.a(paramActivity, parambe, localbe1);
      }
      AppMethodBeat.o(152268);
      return;
    }
    int i = 0;
    int j = localLinkedList.size() - 1;
    label123:
    int k;
    if (j >= 0)
    {
      cjr localcjr = (cjr)localLinkedList.get(j);
      if ((localcjr == null) || (!localcjr.xTH)) {
        break label281;
      }
      k = localcjr.xTI.size() - 1;
      label165:
      if (k < 0) {
        break label281;
      }
      be localbe2 = (be)localcjr.xTI.get(k);
      if ((localbe2 != null) && (h.a(parambe.wnr, localbe2.wnr)))
      {
        localLinkedList.addLast((cjr)localLinkedList.remove(j));
        i = 1;
      }
    }
    label281:
    for (;;)
    {
      j -= 1;
      break label123;
      k -= 1;
      break label165;
      if (i != 0) {
        break;
      }
      ab.d("TaskRecordWrapper", "habbyge-mali, singleInstanceMode: findThisTask NOT: " + parambe.wnr.activityName);
      a(localbf, parambe, true);
      break;
    }
  }
  
  final void a(bf parambf, int paramInt, be parambe)
  {
    AppMethodBeat.i(152270);
    ab.d("TaskRecordWrapper", "habbyge-mali, pop_int: ".concat(String.valueOf(paramInt)));
    if (parambf == null)
    {
      AppMethodBeat.o(152270);
      return;
    }
    cjr localcjr = (cjr)parambf.wnv.getLast();
    int i = localcjr.xTI.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(152270);
      return;
    }
    ab.d("TaskRecordWrapper", "habbyge-mali, pop_int activityCount = ".concat(String.valueOf(i)));
    i -= 1;
    while (i >= paramInt)
    {
      be localbe = (be)localcjr.xTI.remove(i);
      ab.d("TaskRecordWrapper", "habbyge-mali, pop_int_activity: " + localbe.wnr.activityName);
      if (this.lZU != null) {
        this.lZU.b(localbe, parambe);
      }
      i -= 1;
    }
    if ((localcjr.xTI.isEmpty()) && (!parambf.wnv.isEmpty())) {
      parambf.wnv.removeLast();
    }
    AppMethodBeat.o(152270);
  }
  
  final void b(bf parambf, int paramInt, be parambe)
  {
    AppMethodBeat.i(73381);
    ab.d("TaskRecordWrapper", "habbyge-mali, popTask: " + paramInt + "/" + parambe.wnr.activityName);
    if (parambf == null)
    {
      AppMethodBeat.o(73381);
      return;
    }
    int i = parambf.wnv.size();
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(73381);
      return;
    }
    ab.d("TaskRecordWrapper", "habbyge-mali, popTask taskCount = ".concat(String.valueOf(i)));
    i -= 1;
    while (i >= paramInt)
    {
      Iterator localIterator = ((cjr)parambf.wnv.remove(i)).xTI.iterator();
      while (localIterator.hasNext())
      {
        be localbe = (be)localIterator.next();
        if (this.lZU != null) {
          this.lZU.b(localbe, parambe);
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(73381);
  }
  
  final boolean b(Activity paramActivity, be parambe)
  {
    AppMethodBeat.i(152269);
    if (TextUtils.isEmpty(parambe.wnr.activityName))
    {
      AppMethodBeat.o(152269);
      return false;
    }
    ab.d("TaskRecordWrapper", "habbyge-mali, flagNewTask: " + parambe.wnr.activityName);
    bf localbf = c.brA();
    be localbe = c(localbf);
    Object localObject = a(localbf, parambe);
    if (localObject == null)
    {
      AppMethodBeat.o(152269);
      return false;
    }
    cjr localcjr = (cjr)((b)localObject).get(0);
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    localbf.wnv.remove(i);
    localbf.wnv.addLast(localcjr);
    localObject = (be)localcjr.xTI.getLast();
    if ((localObject != null) && (!h.a(((be)localObject).wnr, parambe.wnr)))
    {
      ab.e("TaskRecordWrapper", "habbyge-mali, flagNewTask: " + parambe.wnr.activityName + "/" + ((be)localObject).wnr.activityName);
      i = localcjr.xTI.size() - 1;
      while ((i >= 0) && (!h.a(((be)localcjr.xTI.get(i)).wnr, parambe.wnr)))
      {
        localcjr.xTI.remove(i);
        i -= 1;
      }
    }
    c.a(localbf);
    if (this.lZU != null)
    {
      ab.d("TaskRecordWrapper", "habbyge-mali, activityRecord: " + parambe.wnr.activityName);
      this.lZU.a(paramActivity, parambe, localbe);
    }
    AppMethodBeat.o(152269);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.g
 * JD-Core Version:    0.7.0.1
 */
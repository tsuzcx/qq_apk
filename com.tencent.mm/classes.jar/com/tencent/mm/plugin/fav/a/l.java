package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class l
{
  public HashMap<String, WeakReference<a>> bwc;
  private boolean dirty;
  public ahz qIN;
  private HashSet<Integer> qIO;
  private List<ahx> qIP;
  
  public l()
  {
    AppMethodBeat.i(103413);
    this.qIN = new ahz();
    this.bwc = new HashMap();
    this.qIO = new HashSet();
    this.dirty = true;
    this.qIP = new LinkedList();
    byte[] arrayOfByte = bs.aLu((String)com.tencent.mm.kernel.g.agR().agA().get(225283, ""));
    try
    {
      this.qIN.parseFrom(arrayOfByte);
      ac.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[] { this.qIN.sVE });
      AppMethodBeat.o(103413);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        ac.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[] { localException.getMessage() });
        this.qIN = new ahz();
      }
    }
  }
  
  private void lb(boolean paramBoolean)
  {
    AppMethodBeat.i(103415);
    Iterator localIterator = this.bwc.values().iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        if (paramBoolean) {
          ((a)localWeakReference.get()).cpw();
        } else {
          ((a)localWeakReference.get()).cpx();
        }
      }
    }
    AppMethodBeat.o(103415);
  }
  
  private void removeTag(final String paramString)
  {
    AppMethodBeat.i(103423);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103423);
      return;
    }
    this.qIO.remove(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ac.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[] { paramString });
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103412);
          l.this.acD(paramString);
          AppMethodBeat.o(103412);
        }
      });
      AppMethodBeat.o(103423);
      return;
    }
    ac.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[] { paramString });
    acD(paramString);
    AppMethodBeat.o(103423);
  }
  
  private void save()
  {
    AppMethodBeat.i(103416);
    try
    {
      byte[] arrayOfByte = this.qIN.toByteArray();
      com.tencent.mm.kernel.g.agU().az(new l.1(this, arrayOfByte));
      this.dirty = true;
      AppMethodBeat.o(103416);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        ac.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", new Object[] { localException.getMessage() });
        Object localObject = null;
      }
    }
  }
  
  public final List<ahx> Dg(int paramInt)
  {
    AppMethodBeat.i(103417);
    if ((paramInt < 0) || (paramInt > 1))
    {
      AppMethodBeat.o(103417);
      return null;
    }
    if (this.dirty)
    {
      ac.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
      this.qIP.clear();
      localObject = this.qIN.sVE.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ahy localahy = (ahy)((Iterator)localObject).next();
        this.qIP.addAll(localahy.EBV);
      }
      this.dirty = false;
    }
    ac.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[] { Integer.valueOf(this.qIP.size()) });
    Object localObject = this.qIP;
    AppMethodBeat.o(103417);
    return localObject;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103414);
    if (parama == null)
    {
      AppMethodBeat.o(103414);
      return;
    }
    this.bwc.put(parama.toString(), new WeakReference(parama));
    AppMethodBeat.o(103414);
  }
  
  public final void acB(final String paramString)
  {
    AppMethodBeat.i(103419);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103419);
      return;
    }
    if (this.qIO.contains(Integer.valueOf(paramString.hashCode())))
    {
      ac.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[] { paramString });
      AppMethodBeat.o(103419);
      return;
    }
    this.qIO.add(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ac.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[] { paramString });
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103411);
          l.this.acC(paramString);
          AppMethodBeat.o(103411);
        }
      });
      AppMethodBeat.o(103419);
      return;
    }
    ac.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[] { paramString });
    acC(paramString);
    AppMethodBeat.o(103419);
  }
  
  final void acC(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(103420);
    String str = f.Fv(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int i = str.charAt(0);; i = 35)
    {
      Object localObject = this.qIN.sVE.iterator();
      int j = 0;
      ahy localahy;
      if (((Iterator)localObject).hasNext())
      {
        localahy = (ahy)((Iterator)localObject).next();
        if (localahy.EBU != i) {}
      }
      for (;;)
      {
        label83:
        if (localahy == null)
        {
          localahy = new ahy();
          localahy.EBU = i;
          this.qIN.sVE.add(localahy);
        }
        for (;;)
        {
          localObject = localahy.EBV.iterator();
          i = k;
          label129:
          if (((Iterator)localObject).hasNext())
          {
            ahx localahx = (ahx)((Iterator)localObject).next();
            j = localahx.EBT.compareTo(str);
            if (j != 0) {
              break label343;
            }
            j = localahx.zkN.compareTo(paramString);
          }
          label343:
          for (;;)
          {
            if (j == 0)
            {
              AppMethodBeat.o(103420);
              return;
              if (localahy.EBU > i)
              {
                localahy = new ahy();
                localahy.EBU = i;
                this.qIN.sVE.add(j, localahy);
                break label83;
              }
              j += 1;
              break;
            }
            if (j > 0)
            {
              localObject = new ahx();
              ((ahx)localObject).zkN = paramString;
              ((ahx)localObject).EBT = str;
              localahy.EBV.add(i, localObject);
              save();
              lb(true);
              AppMethodBeat.o(103420);
              return;
            }
            i += 1;
            break label129;
            localObject = new ahx();
            ((ahx)localObject).zkN = paramString;
            ((ahx)localObject).EBT = str;
            localahy.EBV.add(localObject);
            lb(true);
            save();
            AppMethodBeat.o(103420);
            return;
          }
        }
        localahy = null;
      }
    }
  }
  
  final void acD(String paramString)
  {
    AppMethodBeat.i(103424);
    String str = f.Fv(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int j = str.charAt(0);; j = 35)
    {
      Iterator localIterator = this.qIN.sVE.iterator();
      int i = 0;
      ahy localahy;
      if (localIterator.hasNext())
      {
        localahy = (ahy)localIterator.next();
        if (localahy.EBU != j) {}
      }
      for (;;)
      {
        if (localahy == null)
        {
          AppMethodBeat.o(103424);
          return;
          if (localahy.EBU > j)
          {
            AppMethodBeat.o(103424);
            return;
          }
          i += 1;
          break;
        }
        localIterator = localahy.EBV.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          ahx localahx = (ahx)localIterator.next();
          int m = localahx.EBT.compareTo(str);
          int k = m;
          if (m == 0) {
            k = localahx.zkN.compareTo(paramString);
          }
          if (k == 0)
          {
            if (!((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().acI(localahx.zkN))
            {
              localahy.EBV.remove(j);
              if (localahy.EBV.isEmpty()) {
                this.qIN.sVE.remove(i);
              }
              lb(false);
              save();
            }
            AppMethodBeat.o(103424);
            return;
          }
          if (k > 0)
          {
            AppMethodBeat.o(103424);
            return;
          }
          j += 1;
        }
        AppMethodBeat.o(103424);
        return;
        localahy = null;
      }
    }
  }
  
  public final int cpv()
  {
    AppMethodBeat.i(103418);
    Iterator localIterator = this.qIN.sVE.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((ahy)localIterator.next()).EBV.size() + i) {}
    AppMethodBeat.o(103418);
    return i;
  }
  
  public final void f(Set<String> paramSet)
  {
    AppMethodBeat.i(103422);
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      AppMethodBeat.o(103422);
      return;
    }
    ac.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", new Object[] { paramSet });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      removeTag((String)paramSet.next());
    }
    AppMethodBeat.o(103422);
  }
  
  public final void w(g paramg)
  {
    AppMethodBeat.i(103421);
    if (paramg == null)
    {
      AppMethodBeat.o(103421);
      return;
    }
    paramg = paramg.field_tagProto.EBX.iterator();
    while (paramg.hasNext()) {
      removeTag((String)paramg.next());
    }
    AppMethodBeat.o(103421);
  }
  
  public static abstract interface a
  {
    public abstract void cpw();
    
    public abstract void cpx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.l
 * JD-Core Version:    0.7.0.1
 */
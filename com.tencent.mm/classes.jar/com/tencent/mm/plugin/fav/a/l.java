package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.akx;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
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
  public HashMap<String, WeakReference<a>> bGq;
  private boolean dirty;
  public akz rBb;
  private HashSet<Integer> rBc;
  private List<akx> rBd;
  
  public l()
  {
    AppMethodBeat.i(103413);
    this.rBb = new akz();
    this.bGq = new HashMap();
    this.rBc = new HashSet();
    this.dirty = true;
    this.rBd = new LinkedList();
    byte[] arrayOfByte = bu.aSx((String)com.tencent.mm.kernel.g.ajR().ajA().get(225283, ""));
    try
    {
      this.rBb.parseFrom(arrayOfByte);
      ae.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[] { this.rBb.uda });
      AppMethodBeat.o(103413);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        ae.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[] { localException.getMessage() });
        this.rBb = new akz();
      }
    }
  }
  
  private void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(103415);
    Iterator localIterator = this.bGq.values().iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        if (paramBoolean) {
          ((a)localWeakReference.get()).cwC();
        } else {
          ((a)localWeakReference.get()).cwD();
        }
      }
    }
    AppMethodBeat.o(103415);
  }
  
  private void removeTag(final String paramString)
  {
    AppMethodBeat.i(103423);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103423);
      return;
    }
    this.rBc.remove(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ae.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[] { paramString });
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103412);
          l.this.ahp(paramString);
          AppMethodBeat.o(103412);
        }
      });
      AppMethodBeat.o(103423);
      return;
    }
    ae.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[] { paramString });
    ahp(paramString);
    AppMethodBeat.o(103423);
  }
  
  private void save()
  {
    AppMethodBeat.i(103416);
    try
    {
      byte[] arrayOfByte = this.rBb.toByteArray();
      com.tencent.mm.kernel.g.ajU().aw(new l.1(this, arrayOfByte));
      this.dirty = true;
      AppMethodBeat.o(103416);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.FavTagSetMgr", localException, "", new Object[0]);
        ae.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", new Object[] { localException.getMessage() });
        Object localObject = null;
      }
    }
  }
  
  public final List<akx> El(int paramInt)
  {
    AppMethodBeat.i(103417);
    if ((paramInt < 0) || (paramInt > 1))
    {
      AppMethodBeat.o(103417);
      return null;
    }
    if (this.dirty)
    {
      ae.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
      this.rBd.clear();
      localObject = this.rBb.uda.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aky localaky = (aky)((Iterator)localObject).next();
        this.rBd.addAll(localaky.GCq);
      }
      this.dirty = false;
    }
    ae.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[] { Integer.valueOf(this.rBd.size()) });
    Object localObject = this.rBd;
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
    this.bGq.put(parama.toString(), new WeakReference(parama));
    AppMethodBeat.o(103414);
  }
  
  public final void ahn(final String paramString)
  {
    AppMethodBeat.i(103419);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(103419);
      return;
    }
    if (this.rBc.contains(Integer.valueOf(paramString.hashCode())))
    {
      ae.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[] { paramString });
      AppMethodBeat.o(103419);
      return;
    }
    this.rBc.add(Integer.valueOf(paramString.hashCode()));
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ae.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[] { paramString });
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103411);
          l.this.aho(paramString);
          AppMethodBeat.o(103411);
        }
      });
      AppMethodBeat.o(103419);
      return;
    }
    ae.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[] { paramString });
    aho(paramString);
    AppMethodBeat.o(103419);
  }
  
  final void aho(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(103420);
    String str = f.Jk(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int i = str.charAt(0);; i = 35)
    {
      Object localObject = this.rBb.uda.iterator();
      int j = 0;
      aky localaky;
      if (((Iterator)localObject).hasNext())
      {
        localaky = (aky)((Iterator)localObject).next();
        if (localaky.GCp != i) {}
      }
      for (;;)
      {
        label83:
        if (localaky == null)
        {
          localaky = new aky();
          localaky.GCp = i;
          this.rBb.uda.add(localaky);
        }
        for (;;)
        {
          localObject = localaky.GCq.iterator();
          i = k;
          label129:
          if (((Iterator)localObject).hasNext())
          {
            akx localakx = (akx)((Iterator)localObject).next();
            j = localakx.GCo.compareTo(str);
            if (j != 0) {
              break label343;
            }
            j = localakx.AUt.compareTo(paramString);
          }
          label343:
          for (;;)
          {
            if (j == 0)
            {
              AppMethodBeat.o(103420);
              return;
              if (localaky.GCp > i)
              {
                localaky = new aky();
                localaky.GCp = i;
                this.rBb.uda.add(j, localaky);
                break label83;
              }
              j += 1;
              break;
            }
            if (j > 0)
            {
              localObject = new akx();
              ((akx)localObject).AUt = paramString;
              ((akx)localObject).GCo = str;
              localaky.GCq.add(i, localObject);
              save();
              lu(true);
              AppMethodBeat.o(103420);
              return;
            }
            i += 1;
            break label129;
            localObject = new akx();
            ((akx)localObject).AUt = paramString;
            ((akx)localObject).GCo = str;
            localaky.GCq.add(localObject);
            lu(true);
            save();
            AppMethodBeat.o(103420);
            return;
          }
        }
        localaky = null;
      }
    }
  }
  
  final void ahp(String paramString)
  {
    AppMethodBeat.i(103424);
    String str = f.Jk(paramString.toLowerCase());
    if ((str != null) && (str.length() > 0)) {}
    for (int j = str.charAt(0);; j = 35)
    {
      Iterator localIterator = this.rBb.uda.iterator();
      int i = 0;
      aky localaky;
      if (localIterator.hasNext())
      {
        localaky = (aky)localIterator.next();
        if (localaky.GCp != j) {}
      }
      for (;;)
      {
        if (localaky == null)
        {
          AppMethodBeat.o(103424);
          return;
          if (localaky.GCp > j)
          {
            AppMethodBeat.o(103424);
            return;
          }
          i += 1;
          break;
        }
        localIterator = localaky.GCq.iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          akx localakx = (akx)localIterator.next();
          int m = localakx.GCo.compareTo(str);
          int k = m;
          if (m == 0) {
            k = localakx.AUt.compareTo(paramString);
          }
          if (k == 0)
          {
            if (!((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().ahu(localakx.AUt))
            {
              localaky.GCq.remove(j);
              if (localaky.GCq.isEmpty()) {
                this.rBb.uda.remove(i);
              }
              lu(false);
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
        localaky = null;
      }
    }
  }
  
  public final int cwB()
  {
    AppMethodBeat.i(103418);
    Iterator localIterator = this.rBb.uda.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((aky)localIterator.next()).GCq.size() + i) {}
    AppMethodBeat.o(103418);
    return i;
  }
  
  public final void j(Set<String> paramSet)
  {
    AppMethodBeat.i(103422);
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      AppMethodBeat.o(103422);
      return;
    }
    ae.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", new Object[] { paramSet });
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
    paramg = paramg.field_tagProto.GCs.iterator();
    while (paramg.hasNext()) {
      removeTag((String)paramg.next());
    }
    AppMethodBeat.o(103421);
  }
  
  public static abstract interface a
  {
    public abstract void cwC();
    
    public abstract void cwD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.l
 * JD-Core Version:    0.7.0.1
 */